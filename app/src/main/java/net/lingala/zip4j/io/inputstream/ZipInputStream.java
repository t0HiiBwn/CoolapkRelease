package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderReader;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.DataDescriptor;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

public class ZipInputStream extends InputStream {
    private boolean canSkipExtendedLocalFileHeader;
    private Charset charset;
    private CRC32 crc32;
    private DecompressedInputStream decompressedInputStream;
    private byte[] endOfEntryBuffer;
    private HeaderReader headerReader;
    private PushbackInputStream inputStream;
    private LocalFileHeader localFileHeader;
    private char[] password;

    public ZipInputStream(InputStream inputStream2) {
        this(inputStream2, null, InternalZipConstants.CHARSET_UTF_8);
    }

    public ZipInputStream(InputStream inputStream2, Charset charset2) {
        this(inputStream2, null, charset2);
    }

    public ZipInputStream(InputStream inputStream2, char[] cArr) {
        this(inputStream2, cArr, InternalZipConstants.CHARSET_UTF_8);
    }

    public ZipInputStream(InputStream inputStream2, char[] cArr, Charset charset2) {
        this.headerReader = new HeaderReader();
        this.crc32 = new CRC32();
        this.canSkipExtendedLocalFileHeader = false;
        charset2 = charset2 == null ? InternalZipConstants.CHARSET_UTF_8 : charset2;
        this.inputStream = new PushbackInputStream(inputStream2, 4096);
        this.password = cArr;
        this.charset = charset2;
    }

    public LocalFileHeader getNextEntry() throws IOException {
        return getNextEntry(null);
    }

    public LocalFileHeader getNextEntry(FileHeader fileHeader) throws IOException {
        if (this.localFileHeader != null) {
            readUntilEndOfEntry();
        }
        LocalFileHeader readLocalFileHeader = this.headerReader.readLocalFileHeader(this.inputStream, this.charset);
        this.localFileHeader = readLocalFileHeader;
        if (readLocalFileHeader == null) {
            return null;
        }
        verifyLocalFileHeader(readLocalFileHeader);
        this.crc32.reset();
        if (fileHeader != null) {
            this.localFileHeader.setCrc(fileHeader.getCrc());
            this.localFileHeader.setCompressedSize(fileHeader.getCompressedSize());
            this.localFileHeader.setUncompressedSize(fileHeader.getUncompressedSize());
            this.canSkipExtendedLocalFileHeader = true;
        } else {
            this.canSkipExtendedLocalFileHeader = false;
        }
        this.decompressedInputStream = initializeEntryInputStream(this.localFileHeader);
        return this.localFileHeader;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative read length");
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.localFileHeader == null) {
                return -1;
            }
            try {
                int read = this.decompressedInputStream.read(bArr, i, i2);
                if (read == -1) {
                    endOfCompressedDataReached();
                } else {
                    this.crc32.update(bArr, i, read);
                }
                return read;
            } catch (IOException e) {
                if (e.getCause() == null || !(e.getCause() instanceof DataFormatException) || !isEncryptionMethodZipStandard(this.localFileHeader)) {
                    throw e;
                }
                throw new ZipException(e.getMessage(), e.getCause(), ZipException.Type.WRONG_PASSWORD);
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        DecompressedInputStream decompressedInputStream2 = this.decompressedInputStream;
        if (decompressedInputStream2 != null) {
            decompressedInputStream2.close();
        }
    }

    public int getAvailableBytesInPushBackInputStream() throws IOException {
        return this.inputStream.available();
    }

    private void endOfCompressedDataReached() throws IOException {
        this.decompressedInputStream.pushBackInputStreamIfNecessary(this.inputStream);
        this.decompressedInputStream.endOfEntryReached(this.inputStream);
        readExtendedLocalFileHeaderIfPresent();
        verifyCrc();
        resetFields();
    }

    private DecompressedInputStream initializeEntryInputStream(LocalFileHeader localFileHeader2) throws IOException {
        return initializeDecompressorForThisEntry(initializeCipherInputStream(new ZipEntryInputStream(this.inputStream, getCompressedSize(localFileHeader2)), localFileHeader2), localFileHeader2);
    }

    private CipherInputStream initializeCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader2) throws IOException {
        if (!localFileHeader2.isEncrypted()) {
            return new NoCipherInputStream(zipEntryInputStream, localFileHeader2, this.password);
        }
        if (localFileHeader2.getEncryptionMethod() == EncryptionMethod.AES) {
            return new AesCipherInputStream(zipEntryInputStream, localFileHeader2, this.password);
        }
        return new ZipStandardCipherInputStream(zipEntryInputStream, localFileHeader2, this.password);
    }

    private DecompressedInputStream initializeDecompressorForThisEntry(CipherInputStream cipherInputStream, LocalFileHeader localFileHeader2) {
        if (Zip4jUtil.getCompressionMethod(localFileHeader2) == CompressionMethod.DEFLATE) {
            return new InflaterInputStream(cipherInputStream);
        }
        return new StoreInputStream(cipherInputStream);
    }

    private void readExtendedLocalFileHeaderIfPresent() throws IOException {
        if (this.localFileHeader.isDataDescriptorExists() && !this.canSkipExtendedLocalFileHeader) {
            DataDescriptor readDataDescriptor = this.headerReader.readDataDescriptor(this.inputStream, checkIfZip64ExtraDataRecordPresentInLFH(this.localFileHeader.getExtraDataRecords()));
            this.localFileHeader.setCompressedSize(readDataDescriptor.getCompressedSize());
            this.localFileHeader.setUncompressedSize(readDataDescriptor.getUncompressedSize());
            this.localFileHeader.setCrc(readDataDescriptor.getCrc());
        }
    }

    private void verifyLocalFileHeader(LocalFileHeader localFileHeader2) throws IOException {
        if (!isEntryDirectory(localFileHeader2.getFileName()) && localFileHeader2.getCompressionMethod() == CompressionMethod.STORE && localFileHeader2.getUncompressedSize() < 0) {
            throw new IOException("Invalid local file header for: " + localFileHeader2.getFileName() + ". Uncompressed size has to be set for entry of compression type store which is not a directory");
        }
    }

    private boolean checkIfZip64ExtraDataRecordPresentInLFH(List<ExtraDataRecord> list) {
        if (list == null) {
            return false;
        }
        for (ExtraDataRecord extraDataRecord : list) {
            if (extraDataRecord.getHeader() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                return true;
            }
        }
        return false;
    }

    private void verifyCrc() throws IOException {
        if ((this.localFileHeader.getEncryptionMethod() != EncryptionMethod.AES || !this.localFileHeader.getAesExtraDataRecord().getAesVersion().equals(AesVersion.TWO)) && this.localFileHeader.getCrc() != this.crc32.getValue()) {
            ZipException.Type type = ZipException.Type.CHECKSUM_MISMATCH;
            if (isEncryptionMethodZipStandard(this.localFileHeader)) {
                type = ZipException.Type.WRONG_PASSWORD;
            }
            throw new ZipException("Reached end of entry, but crc verification failed for " + this.localFileHeader.getFileName(), type);
        }
    }

    private void resetFields() {
        this.localFileHeader = null;
        this.crc32.reset();
    }

    private boolean isEntryDirectory(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    private long getCompressedSize(LocalFileHeader localFileHeader2) {
        if (Zip4jUtil.getCompressionMethod(localFileHeader2).equals(CompressionMethod.STORE)) {
            return localFileHeader2.getUncompressedSize();
        }
        if (!localFileHeader2.isDataDescriptorExists() || this.canSkipExtendedLocalFileHeader) {
            return localFileHeader2.getCompressedSize() - ((long) getEncryptionHeaderSize(localFileHeader2));
        }
        return -1;
    }

    private int getEncryptionHeaderSize(LocalFileHeader localFileHeader2) {
        if (!localFileHeader2.isEncrypted()) {
            return 0;
        }
        if (localFileHeader2.getEncryptionMethod().equals(EncryptionMethod.AES)) {
            return localFileHeader2.getAesExtraDataRecord().getAesKeyStrength().getSaltLength() + 12;
        }
        if (localFileHeader2.getEncryptionMethod().equals(EncryptionMethod.ZIP_STANDARD)) {
            return 12;
        }
        return 0;
    }

    private void readUntilEndOfEntry() throws IOException {
        if (!this.localFileHeader.isDirectory() && this.localFileHeader.getCompressedSize() != 0) {
            if (this.endOfEntryBuffer == null) {
                this.endOfEntryBuffer = new byte[512];
            }
            do {
            } while (read(this.endOfEntryBuffer) != -1);
        }
    }

    private boolean isEncryptionMethodZipStandard(LocalFileHeader localFileHeader2) {
        return localFileHeader2.isEncrypted() && EncryptionMethod.ZIP_STANDARD.equals(localFileHeader2.getEncryptionMethod());
    }
}
