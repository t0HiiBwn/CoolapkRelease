package net.lingala.zip4j.headers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.outputstream.CountingOutputStream;
import net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;

public class HeaderWriter {
    private static final short AES_EXTRA_DATA_RECORD_SIZE = 11;
    private static final short ZIP64_EXTRA_DATA_RECORD_SIZE_FH = 28;
    private static final short ZIP64_EXTRA_DATA_RECORD_SIZE_LFH = 16;
    private byte[] intBuff = new byte[4];
    private byte[] longBuff = new byte[8];
    private RawIO rawIO = new RawIO();

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0166, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x016b, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x016c, code lost:
        r10.addSuppressed(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x016f, code lost:
        throw r11;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x006e A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0086 A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00b5 A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c5 A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c8 A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cf A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d9 A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00de A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0109 A[Catch:{ all -> 0x0166 }] */
    public void writeLocalFileHeader(ZipModel zipModel, LocalFileHeader localFileHeader, OutputStream outputStream, Charset charset) throws IOException {
        boolean z;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.rawIO.writeIntLittleEndian(byteArrayOutputStream, (int) localFileHeader.getSignature().getValue());
        this.rawIO.writeShortLittleEndian(byteArrayOutputStream, localFileHeader.getVersionNeededToExtract());
        byteArrayOutputStream.write(localFileHeader.getGeneralPurposeFlag());
        this.rawIO.writeShortLittleEndian(byteArrayOutputStream, localFileHeader.getCompressionMethod().getCode());
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getLastModifiedTime());
        byteArrayOutputStream.write(this.longBuff, 0, 4);
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCrc());
        byteArrayOutputStream.write(this.longBuff, 0, 4);
        if (localFileHeader.getCompressedSize() < 4294967295L) {
            if (localFileHeader.getUncompressedSize() < 4294967295L) {
                z = false;
                if (!z) {
                    this.rawIO.writeLongLittleEndian(this.longBuff, 0, 4294967295L);
                    byteArrayOutputStream.write(this.longBuff, 0, 4);
                    byteArrayOutputStream.write(this.longBuff, 0, 4);
                    zipModel.setZip64Format(true);
                    localFileHeader.setWriteCompressedSizeInZip64ExtraRecord(true);
                } else {
                    this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCompressedSize());
                    byteArrayOutputStream.write(this.longBuff, 0, 4);
                    this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getUncompressedSize());
                    byteArrayOutputStream.write(this.longBuff, 0, 4);
                    localFileHeader.setWriteCompressedSizeInZip64ExtraRecord(false);
                }
                bArr = new byte[0];
                if (Zip4jUtil.isStringNotNullAndNotEmpty(localFileHeader.getFileName())) {
                    bArr = localFileHeader.getFileName().getBytes(charset);
                }
                this.rawIO.writeShortLittleEndian(byteArrayOutputStream, bArr.length);
                int i = !z ? 20 : 0;
                if (localFileHeader.getAesExtraDataRecord() != null) {
                    i += 11;
                }
                this.rawIO.writeShortLittleEndian(byteArrayOutputStream, i);
                if (bArr.length > 0) {
                    byteArrayOutputStream.write(bArr);
                }
                if (z) {
                    this.rawIO.writeShortLittleEndian(byteArrayOutputStream, (int) HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue());
                    this.rawIO.writeShortLittleEndian(byteArrayOutputStream, 16);
                    this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getUncompressedSize());
                    this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getCompressedSize());
                }
                if (localFileHeader.getAesExtraDataRecord() != null) {
                    AESExtraDataRecord aesExtraDataRecord = localFileHeader.getAesExtraDataRecord();
                    this.rawIO.writeShortLittleEndian(byteArrayOutputStream, (int) aesExtraDataRecord.getSignature().getValue());
                    this.rawIO.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getDataSize());
                    this.rawIO.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getAesVersion().getVersionNumber());
                    byteArrayOutputStream.write(aesExtraDataRecord.getVendorID().getBytes());
                    byteArrayOutputStream.write(new byte[]{(byte) aesExtraDataRecord.getAesKeyStrength().getRawCode()});
                    this.rawIO.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getCompressionMethod().getCode());
                }
                outputStream.write(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
            }
        }
        z = true;
        if (!z) {
        }
        bArr = new byte[0];
        if (Zip4jUtil.isStringNotNullAndNotEmpty(localFileHeader.getFileName())) {
        }
        this.rawIO.writeShortLittleEndian(byteArrayOutputStream, bArr.length);
        if (!z) {
        }
        if (localFileHeader.getAesExtraDataRecord() != null) {
        }
        this.rawIO.writeShortLittleEndian(byteArrayOutputStream, i);
        if (bArr.length > 0) {
        }
        if (z) {
        }
        if (localFileHeader.getAesExtraDataRecord() != null) {
        }
        outputStream.write(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0072, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        r9.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        throw r10;
     */
    public void writeExtendedLocalHeader(LocalFileHeader localFileHeader, OutputStream outputStream) throws IOException {
        if (localFileHeader == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot write extended local header");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.rawIO.writeIntLittleEndian(byteArrayOutputStream, (int) HeaderSignature.EXTRA_DATA_RECORD.getValue());
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCrc());
        byteArrayOutputStream.write(this.longBuff, 0, 4);
        if (localFileHeader.isWriteCompressedSizeInZip64ExtraRecord()) {
            this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getCompressedSize());
            this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getUncompressedSize());
        } else {
            this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCompressedSize());
            byteArrayOutputStream.write(this.longBuff, 0, 4);
            this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getUncompressedSize());
            byteArrayOutputStream.write(this.longBuff, 0, 4);
        }
        outputStream.write(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00af, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b4, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b5, code lost:
        r12.addSuppressed(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b8, code lost:
        throw r13;
     */
    public void finalizeZipFile(ZipModel zipModel, OutputStream outputStream, Charset charset) throws IOException {
        if (zipModel == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        processHeaderData(zipModel, outputStream);
        long offsetOfCentralDirectory = getOffsetOfCentralDirectory(zipModel);
        writeCentralDirectory(zipModel, byteArrayOutputStream, this.rawIO, charset);
        int size = byteArrayOutputStream.size();
        if (zipModel.isZip64Format() || offsetOfCentralDirectory >= 4294967295L || zipModel.getCentralDirectory().getFileHeaders().size() >= 65535) {
            if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                zipModel.setZip64EndOfCentralDirectoryRecord(new Zip64EndOfCentralDirectoryRecord());
            }
            if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                zipModel.setZip64EndOfCentralDirectoryLocator(new Zip64EndOfCentralDirectoryLocator());
            }
            zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(((long) size) + offsetOfCentralDirectory);
            if (isSplitZipFile(outputStream)) {
                int currentSplitFileCounter = getCurrentSplitFileCounter(outputStream);
                zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(currentSplitFileCounter);
                zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(currentSplitFileCounter + 1);
            } else {
                zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(0);
                zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(1);
            }
            writeZip64EndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory, byteArrayOutputStream, this.rawIO);
            writeZip64EndOfCentralDirectoryLocator(zipModel, byteArrayOutputStream, this.rawIO);
        }
        writeEndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory, byteArrayOutputStream, this.rawIO, charset);
        writeZipHeaderBytes(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
        byteArrayOutputStream.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        r12.addSuppressed(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008f, code lost:
        throw r13;
     */
    public void finalizeZipFileWithoutValidations(ZipModel zipModel, OutputStream outputStream, Charset charset) throws IOException {
        if (zipModel == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot finalize zip file without validations");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long offsetOfStartOfCentralDirectory = zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory();
        writeCentralDirectory(zipModel, byteArrayOutputStream, this.rawIO, charset);
        int size = byteArrayOutputStream.size();
        if (zipModel.isZip64Format() || offsetOfStartOfCentralDirectory >= 4294967295L || zipModel.getCentralDirectory().getFileHeaders().size() >= 65535) {
            if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                zipModel.setZip64EndOfCentralDirectoryRecord(new Zip64EndOfCentralDirectoryRecord());
            }
            if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                zipModel.setZip64EndOfCentralDirectoryLocator(new Zip64EndOfCentralDirectoryLocator());
            }
            zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(((long) size) + offsetOfStartOfCentralDirectory);
            writeZip64EndOfCentralDirectoryRecord(zipModel, size, offsetOfStartOfCentralDirectory, byteArrayOutputStream, this.rawIO);
            writeZip64EndOfCentralDirectoryLocator(zipModel, byteArrayOutputStream, this.rawIO);
        }
        writeEndOfCentralDirectoryRecord(zipModel, size, offsetOfStartOfCentralDirectory, byteArrayOutputStream, this.rawIO, charset);
        writeZipHeaderBytes(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
        byteArrayOutputStream.close();
    }

    public void updateLocalFileHeader(FileHeader fileHeader, ZipModel zipModel, SplitOutputStream splitOutputStream) throws IOException {
        SplitOutputStream splitOutputStream2;
        String str;
        if (fileHeader == null || zipModel == null) {
            throw new ZipException("invalid input parameters, cannot update local file header");
        }
        boolean z = true;
        if (fileHeader.getDiskNumberStart() != splitOutputStream.getCurrentSplitFileCounter()) {
            String parent = zipModel.getZipFile().getParent();
            String zipFileNameWithoutExtension = FileUtils.getZipFileNameWithoutExtension(zipModel.getZipFile().getName());
            String str2 = parent + System.getProperty("file.separator");
            if (fileHeader.getDiskNumberStart() < 9) {
                str = str2 + zipFileNameWithoutExtension + ".z0" + (fileHeader.getDiskNumberStart() + 1);
            } else {
                str = str2 + zipFileNameWithoutExtension + ".z" + (fileHeader.getDiskNumberStart() + 1);
            }
            splitOutputStream2 = new SplitOutputStream(new File(str));
        } else {
            splitOutputStream2 = splitOutputStream;
            z = false;
        }
        long filePointer = splitOutputStream2.getFilePointer();
        splitOutputStream2.seek(fileHeader.getOffsetLocalHeader() + 14);
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCrc());
        splitOutputStream2.write(this.longBuff, 0, 4);
        updateFileSizesInLocalFileHeader(splitOutputStream2, fileHeader);
        if (z) {
            splitOutputStream2.close();
        } else {
            splitOutputStream.seek(filePointer);
        }
    }

    private void updateFileSizesInLocalFileHeader(SplitOutputStream splitOutputStream, FileHeader fileHeader) throws IOException {
        if (fileHeader.getUncompressedSize() >= 4294967295L) {
            this.rawIO.writeLongLittleEndian(this.longBuff, 0, 4294967295L);
            splitOutputStream.write(this.longBuff, 0, 4);
            splitOutputStream.write(this.longBuff, 0, 4);
            int fileNameLength = fileHeader.getFileNameLength() + 4 + 2 + 2;
            if (splitOutputStream.skipBytes(fileNameLength) == fileNameLength) {
                this.rawIO.writeLongLittleEndian(splitOutputStream, fileHeader.getUncompressedSize());
                this.rawIO.writeLongLittleEndian(splitOutputStream, fileHeader.getCompressedSize());
                return;
            }
            throw new ZipException("Unable to skip " + fileNameLength + " bytes to update LFH");
        }
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCompressedSize());
        splitOutputStream.write(this.longBuff, 0, 4);
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getUncompressedSize());
        splitOutputStream.write(this.longBuff, 0, 4);
    }

    private boolean isSplitZipFile(OutputStream outputStream) {
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).isSplitZipFile();
        }
        if (outputStream instanceof CountingOutputStream) {
            return ((CountingOutputStream) outputStream).isSplitZipFile();
        }
        return false;
    }

    private int getCurrentSplitFileCounter(OutputStream outputStream) {
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).getCurrentSplitFileCounter();
        }
        return ((CountingOutputStream) outputStream).getCurrentSplitFileCounter();
    }

    private void writeZipHeaderBytes(ZipModel zipModel, OutputStream outputStream, byte[] bArr, Charset charset) throws IOException {
        if (bArr == null) {
            throw new ZipException("invalid buff to write as zip headers");
        } else if (!(outputStream instanceof CountingOutputStream) || !((CountingOutputStream) outputStream).checkBuffSizeAndStartNextSplitFile(bArr.length)) {
            outputStream.write(bArr);
        } else {
            finalizeZipFile(zipModel, outputStream, charset);
        }
    }

    private void processHeaderData(ZipModel zipModel, OutputStream outputStream) throws IOException {
        int i;
        if (outputStream instanceof OutputStreamWithSplitZipSupport) {
            OutputStreamWithSplitZipSupport outputStreamWithSplitZipSupport = (OutputStreamWithSplitZipSupport) outputStream;
            zipModel.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(outputStreamWithSplitZipSupport.getFilePointer());
            i = outputStreamWithSplitZipSupport.getCurrentSplitFileCounter();
        } else {
            i = 0;
        }
        if (zipModel.isZip64Format()) {
            if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                zipModel.setZip64EndOfCentralDirectoryRecord(new Zip64EndOfCentralDirectoryRecord());
            }
            if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                zipModel.setZip64EndOfCentralDirectoryLocator(new Zip64EndOfCentralDirectoryLocator());
            }
            zipModel.getZip64EndOfCentralDirectoryRecord().setOffsetStartCentralDirectoryWRTStartDiskNumber(zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory());
            zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(i);
            zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(i + 1);
        }
        zipModel.getEndOfCentralDirectoryRecord().setNumberOfThisDisk(i);
        zipModel.getEndOfCentralDirectoryRecord().setNumberOfThisDiskStartOfCentralDir(i);
    }

    private void writeCentralDirectory(ZipModel zipModel, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2, Charset charset) throws ZipException {
        if (!(zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() <= 0)) {
            for (FileHeader fileHeader : zipModel.getCentralDirectory().getFileHeaders()) {
                writeFileHeader(zipModel, fileHeader, byteArrayOutputStream, rawIO2, charset);
            }
        }
    }

    private void writeFileHeader(ZipModel zipModel, FileHeader fileHeader, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2, Charset charset) throws ZipException {
        byte[] bArr;
        if (fileHeader != null) {
            try {
                byte[] bArr2 = {0, 0};
                boolean isZip64Entry = isZip64Entry(fileHeader);
                rawIO2.writeIntLittleEndian(byteArrayOutputStream, (int) fileHeader.getSignature().getValue());
                rawIO2.writeShortLittleEndian(byteArrayOutputStream, fileHeader.getVersionMadeBy());
                rawIO2.writeShortLittleEndian(byteArrayOutputStream, fileHeader.getVersionNeededToExtract());
                byteArrayOutputStream.write(fileHeader.getGeneralPurposeFlag());
                rawIO2.writeShortLittleEndian(byteArrayOutputStream, fileHeader.getCompressionMethod().getCode());
                rawIO2.writeLongLittleEndian(this.longBuff, 0, fileHeader.getLastModifiedTime());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                rawIO2.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCrc());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                if (isZip64Entry) {
                    rawIO2.writeLongLittleEndian(this.longBuff, 0, 4294967295L);
                    byteArrayOutputStream.write(this.longBuff, 0, 4);
                    byteArrayOutputStream.write(this.longBuff, 0, 4);
                    zipModel.setZip64Format(true);
                    bArr = bArr2;
                } else {
                    bArr = bArr2;
                    rawIO2.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCompressedSize());
                    byteArrayOutputStream.write(this.longBuff, 0, 4);
                    rawIO2.writeLongLittleEndian(this.longBuff, 0, fileHeader.getUncompressedSize());
                    byteArrayOutputStream.write(this.longBuff, 0, 4);
                }
                byte[] bArr3 = new byte[0];
                if (Zip4jUtil.isStringNotNullAndNotEmpty(fileHeader.getFileName())) {
                    bArr3 = fileHeader.getFileName().getBytes(charset);
                }
                rawIO2.writeShortLittleEndian(byteArrayOutputStream, bArr3.length);
                byte[] bArr4 = new byte[4];
                if (isZip64Entry) {
                    rawIO2.writeLongLittleEndian(this.longBuff, 0, 4294967295L);
                    System.arraycopy(this.longBuff, 0, bArr4, 0, 4);
                } else {
                    rawIO2.writeLongLittleEndian(this.longBuff, 0, fileHeader.getOffsetLocalHeader());
                    System.arraycopy(this.longBuff, 0, bArr4, 0, 4);
                }
                rawIO2.writeShortLittleEndian(byteArrayOutputStream, calculateExtraDataRecordsSize(fileHeader, isZip64Entry));
                String fileComment = fileHeader.getFileComment();
                byte[] bArr5 = new byte[0];
                if (Zip4jUtil.isStringNotNullAndNotEmpty(fileComment)) {
                    bArr5 = fileComment.getBytes(charset);
                }
                rawIO2.writeShortLittleEndian(byteArrayOutputStream, bArr5.length);
                if (isZip64Entry) {
                    rawIO2.writeIntLittleEndian(this.intBuff, 0, 65535);
                    byteArrayOutputStream.write(this.intBuff, 0, 2);
                } else {
                    rawIO2.writeShortLittleEndian(byteArrayOutputStream, fileHeader.getDiskNumberStart());
                }
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(fileHeader.getExternalFileAttributes());
                byteArrayOutputStream.write(bArr4);
                if (bArr3.length > 0) {
                    byteArrayOutputStream.write(bArr3);
                }
                if (isZip64Entry) {
                    zipModel.setZip64Format(true);
                    rawIO2.writeShortLittleEndian(byteArrayOutputStream, (int) HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue());
                    rawIO2.writeShortLittleEndian(byteArrayOutputStream, 28);
                    rawIO2.writeLongLittleEndian(byteArrayOutputStream, fileHeader.getUncompressedSize());
                    rawIO2.writeLongLittleEndian(byteArrayOutputStream, fileHeader.getCompressedSize());
                    rawIO2.writeLongLittleEndian(byteArrayOutputStream, fileHeader.getOffsetLocalHeader());
                    rawIO2.writeIntLittleEndian(byteArrayOutputStream, fileHeader.getDiskNumberStart());
                }
                if (fileHeader.getAesExtraDataRecord() != null) {
                    AESExtraDataRecord aesExtraDataRecord = fileHeader.getAesExtraDataRecord();
                    rawIO2.writeShortLittleEndian(byteArrayOutputStream, (int) aesExtraDataRecord.getSignature().getValue());
                    rawIO2.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getDataSize());
                    rawIO2.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getAesVersion().getVersionNumber());
                    byteArrayOutputStream.write(aesExtraDataRecord.getVendorID().getBytes());
                    byteArrayOutputStream.write(new byte[]{(byte) aesExtraDataRecord.getAesKeyStrength().getRawCode()});
                    rawIO2.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getCompressionMethod().getCode());
                }
                writeRemainingExtraDataRecordsIfPresent(fileHeader, byteArrayOutputStream);
                if (bArr5.length > 0) {
                    byteArrayOutputStream.write(bArr5);
                }
            } catch (Exception e) {
                throw new ZipException(e);
            }
        } else {
            throw new ZipException("input parameters is null, cannot write local file header");
        }
    }

    private int calculateExtraDataRecordsSize(FileHeader fileHeader, boolean z) throws IOException {
        int i = z ? 32 : 0;
        if (fileHeader.getAesExtraDataRecord() != null) {
            i += 11;
        }
        if (fileHeader.getExtraDataRecords() != null) {
            for (ExtraDataRecord extraDataRecord : fileHeader.getExtraDataRecords()) {
                if (!(extraDataRecord.getHeader() == HeaderSignature.AES_EXTRA_DATA_RECORD.getValue() || extraDataRecord.getHeader() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue())) {
                    i += extraDataRecord.getSizeOfData() + 4;
                }
            }
        }
        return i;
    }

    private void writeRemainingExtraDataRecordsIfPresent(FileHeader fileHeader, OutputStream outputStream) throws IOException {
        if (!(fileHeader.getExtraDataRecords() == null || fileHeader.getExtraDataRecords().size() == 0)) {
            for (ExtraDataRecord extraDataRecord : fileHeader.getExtraDataRecords()) {
                if (!(extraDataRecord.getHeader() == HeaderSignature.AES_EXTRA_DATA_RECORD.getValue() || extraDataRecord.getHeader() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue())) {
                    this.rawIO.writeShortLittleEndian(outputStream, (int) extraDataRecord.getHeader());
                    this.rawIO.writeShortLittleEndian(outputStream, extraDataRecord.getSizeOfData());
                    if (extraDataRecord.getSizeOfData() > 0 && extraDataRecord.getData() != null) {
                        outputStream.write(extraDataRecord.getData());
                    }
                }
            }
        }
    }

    private void writeZip64EndOfCentralDirectoryRecord(ZipModel zipModel, int i, long j, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2) throws IOException {
        byte[] bArr = {0, 0};
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, (int) HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD.getValue());
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, 44);
        if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
        } else {
            rawIO2.writeShortLittleEndian(byteArrayOutputStream, zipModel.getCentralDirectory().getFileHeaders().get(0).getVersionMadeBy());
            rawIO2.writeShortLittleEndian(byteArrayOutputStream, zipModel.getCentralDirectory().getFileHeaders().get(0).getVersionNeededToExtract());
        }
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk());
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDiskStartOfCentralDir());
        long size = (long) zipModel.getCentralDirectory().getFileHeaders().size();
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, zipModel.isSplitArchive() ? countNumberOfFileHeaderEntriesOnDisk(zipModel.getCentralDirectory().getFileHeaders(), zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) : size);
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, size);
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, (long) i);
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, j);
    }

    private void writeZip64EndOfCentralDirectoryLocator(ZipModel zipModel, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2) throws IOException {
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, (int) HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.getValue());
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, zipModel.getZip64EndOfCentralDirectoryLocator().getNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord());
        rawIO2.writeLongLittleEndian(byteArrayOutputStream, zipModel.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord());
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, zipModel.getZip64EndOfCentralDirectoryLocator().getTotalNumberOfDiscs());
    }

    private void writeEndOfCentralDirectoryRecord(ZipModel zipModel, int i, long j, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO2, Charset charset) throws IOException {
        byte[] bArr = new byte[8];
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, (int) HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue());
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk());
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDiskStartOfCentralDir());
        long size = (long) zipModel.getCentralDirectory().getFileHeaders().size();
        long countNumberOfFileHeaderEntriesOnDisk = zipModel.isSplitArchive() ? countNumberOfFileHeaderEntriesOnDisk(zipModel.getCentralDirectory().getFileHeaders(), zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) : size;
        if (countNumberOfFileHeaderEntriesOnDisk > 65535) {
            countNumberOfFileHeaderEntriesOnDisk = 65535;
        }
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, (int) countNumberOfFileHeaderEntriesOnDisk);
        if (size > 65535) {
            size = 65535;
        }
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, (int) size);
        rawIO2.writeIntLittleEndian(byteArrayOutputStream, i);
        if (j > 4294967295L) {
            rawIO2.writeLongLittleEndian(bArr, 0, 4294967295L);
            byteArrayOutputStream.write(bArr, 0, 4);
        } else {
            rawIO2.writeLongLittleEndian(bArr, 0, j);
            byteArrayOutputStream.write(bArr, 0, 4);
        }
        String comment = zipModel.getEndOfCentralDirectoryRecord().getComment();
        if (Zip4jUtil.isStringNotNullAndNotEmpty(comment)) {
            byte[] bytes = comment.getBytes(charset);
            rawIO2.writeShortLittleEndian(byteArrayOutputStream, bytes.length);
            byteArrayOutputStream.write(bytes);
            return;
        }
        rawIO2.writeShortLittleEndian(byteArrayOutputStream, 0);
    }

    private long countNumberOfFileHeaderEntriesOnDisk(List<FileHeader> list, int i) throws ZipException {
        if (list != null) {
            int i2 = 0;
            for (FileHeader fileHeader : list) {
                if (fileHeader.getDiskNumberStart() == i) {
                    i2++;
                }
            }
            return (long) i2;
        }
        throw new ZipException("file headers are null, cannot calculate number of entries on this disk");
    }

    private boolean isZip64Entry(FileHeader fileHeader) {
        return fileHeader.getCompressedSize() >= 4294967295L || fileHeader.getUncompressedSize() >= 4294967295L || fileHeader.getOffsetLocalHeader() >= 4294967295L || fileHeader.getDiskNumberStart() >= 65535;
    }

    private long getOffsetOfCentralDirectory(ZipModel zipModel) {
        if (!zipModel.isZip64Format() || zipModel.getZip64EndOfCentralDirectoryRecord() == null || zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() == -1) {
            return zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory();
        }
        return zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber();
    }
}
