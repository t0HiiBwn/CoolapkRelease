package net.lingala.zip4j.headers;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.DataDescriptor;
import net.lingala.zip4j.model.DigitalSignature;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.Zip64ExtendedInfo;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;

public class HeaderReader {
    private byte[] intBuff = new byte[4];
    private RawIO rawIO = new RawIO();
    private ZipModel zipModel;

    public ZipModel readAllHeaders(RandomAccessFile randomAccessFile, Charset charset) throws IOException {
        if (randomAccessFile.length() >= 22) {
            ZipModel zipModel2 = new ZipModel();
            this.zipModel = zipModel2;
            try {
                zipModel2.setEndOfCentralDirectoryRecord(readEndOfCentralDirectoryRecord(randomAccessFile, this.rawIO, charset));
                if (this.zipModel.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory() == 0) {
                    return this.zipModel;
                }
                ZipModel zipModel3 = this.zipModel;
                zipModel3.setZip64EndOfCentralDirectoryLocator(readZip64EndOfCentralDirectoryLocator(randomAccessFile, this.rawIO, zipModel3.getEndOfCentralDirectoryRecord().getOffsetOfEndOfCentralDirectory()));
                if (this.zipModel.isZip64Format()) {
                    this.zipModel.setZip64EndOfCentralDirectoryRecord(readZip64EndCentralDirRec(randomAccessFile, this.rawIO));
                    if (this.zipModel.getZip64EndOfCentralDirectoryRecord() == null || this.zipModel.getZip64EndOfCentralDirectoryRecord().getNumberOfThisDisk() <= 0) {
                        this.zipModel.setSplitArchive(false);
                    } else {
                        this.zipModel.setSplitArchive(true);
                    }
                }
                this.zipModel.setCentralDirectory(readCentralDirectory(randomAccessFile, this.rawIO, charset));
                return this.zipModel;
            } catch (ZipException e) {
                throw e;
            } catch (IOException e2) {
                throw new ZipException("Zip headers not found. Probably not a zip file or a corrupted zip file", e2);
            }
        } else {
            throw new ZipException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        }
    }

    private EndOfCentralDirectoryRecord readEndOfCentralDirectoryRecord(RandomAccessFile randomAccessFile, RawIO rawIO2, Charset charset) throws IOException {
        long length = randomAccessFile.length() - 22;
        seekInCurrentPart(randomAccessFile, length);
        if (((long) rawIO2.readIntLittleEndian(randomAccessFile)) != HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue()) {
            length = determineOffsetOfEndOfCentralDirectory(randomAccessFile);
            randomAccessFile.seek(4 + length);
        }
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = new EndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setSignature(HeaderSignature.END_OF_CENTRAL_DIRECTORY);
        endOfCentralDirectoryRecord.setNumberOfThisDisk(rawIO2.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDir(rawIO2.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(rawIO2.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(rawIO2.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setSizeOfCentralDirectory(rawIO2.readIntLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setOffsetOfEndOfCentralDirectory(length);
        randomAccessFile.readFully(this.intBuff);
        boolean z = false;
        endOfCentralDirectoryRecord.setOffsetOfStartOfCentralDirectory(rawIO2.readLongLittleEndian(this.intBuff, 0));
        endOfCentralDirectoryRecord.setComment(readZipComment(randomAccessFile, rawIO2.readShortLittleEndian(randomAccessFile), charset));
        ZipModel zipModel2 = this.zipModel;
        if (endOfCentralDirectoryRecord.getNumberOfThisDisk() > 0) {
            z = true;
        }
        zipModel2.setSplitArchive(z);
        return endOfCentralDirectoryRecord;
    }

    private CentralDirectory readCentralDirectory(RandomAccessFile randomAccessFile, RawIO rawIO2, Charset charset) throws IOException {
        CentralDirectory centralDirectory = new CentralDirectory();
        ArrayList arrayList = new ArrayList();
        long offsetStartOfCentralDirectory = HeaderUtil.getOffsetStartOfCentralDirectory(this.zipModel);
        long numberOfEntriesInCentralDirectory = getNumberOfEntriesInCentralDirectory(this.zipModel);
        randomAccessFile.seek(offsetStartOfCentralDirectory);
        int i = 2;
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int i2 = 0;
        int i3 = 0;
        while (((long) i3) < numberOfEntriesInCentralDirectory) {
            FileHeader fileHeader = new FileHeader();
            boolean z = true;
            if (((long) rawIO2.readIntLittleEndian(randomAccessFile)) == HeaderSignature.CENTRAL_DIRECTORY.getValue()) {
                fileHeader.setSignature(HeaderSignature.CENTRAL_DIRECTORY);
                fileHeader.setVersionMadeBy(rawIO2.readShortLittleEndian(randomAccessFile));
                fileHeader.setVersionNeededToExtract(rawIO2.readShortLittleEndian(randomAccessFile));
                byte[] bArr3 = new byte[i];
                randomAccessFile.readFully(bArr3);
                fileHeader.setEncrypted(BitUtils.isBitSet(bArr3[i2], i2));
                fileHeader.setDataDescriptorExists(BitUtils.isBitSet(bArr3[i2], 3));
                fileHeader.setFileNameUTF8Encoded(BitUtils.isBitSet(bArr3[1], 3));
                fileHeader.setGeneralPurposeFlag((byte[]) bArr3.clone());
                fileHeader.setCompressionMethod(CompressionMethod.getCompressionMethodFromCode(rawIO2.readShortLittleEndian(randomAccessFile)));
                fileHeader.setLastModifiedTime((long) rawIO2.readIntLittleEndian(randomAccessFile));
                randomAccessFile.readFully(bArr2);
                fileHeader.setCrc(rawIO2.readLongLittleEndian(bArr2, i2));
                fileHeader.setCrcRawData(bArr2);
                fileHeader.setCompressedSize(rawIO2.readLongLittleEndian(randomAccessFile, 4));
                fileHeader.setUncompressedSize(rawIO2.readLongLittleEndian(randomAccessFile, 4));
                int readShortLittleEndian = rawIO2.readShortLittleEndian(randomAccessFile);
                fileHeader.setFileNameLength(readShortLittleEndian);
                fileHeader.setExtraFieldLength(rawIO2.readShortLittleEndian(randomAccessFile));
                int readShortLittleEndian2 = rawIO2.readShortLittleEndian(randomAccessFile);
                fileHeader.setFileCommentLength(readShortLittleEndian2);
                fileHeader.setDiskNumberStart(rawIO2.readShortLittleEndian(randomAccessFile));
                randomAccessFile.readFully(bArr);
                fileHeader.setInternalFileAttributes((byte[]) bArr.clone());
                randomAccessFile.readFully(bArr2);
                fileHeader.setExternalFileAttributes((byte[]) bArr2.clone());
                randomAccessFile.readFully(bArr2);
                fileHeader.setOffsetLocalHeader(rawIO2.readLongLittleEndian(bArr2, 0));
                if (readShortLittleEndian > 0) {
                    byte[] bArr4 = new byte[readShortLittleEndian];
                    randomAccessFile.readFully(bArr4);
                    String decodeStringWithCharset = HeaderUtil.decodeStringWithCharset(bArr4, fileHeader.isFileNameUTF8Encoded(), charset);
                    if (decodeStringWithCharset.contains(":\\")) {
                        decodeStringWithCharset = decodeStringWithCharset.substring(decodeStringWithCharset.indexOf(":\\") + 2);
                    }
                    fileHeader.setFileName(decodeStringWithCharset);
                    if (!decodeStringWithCharset.endsWith("/") && !decodeStringWithCharset.endsWith("\\")) {
                        z = false;
                    }
                    fileHeader.setDirectory(z);
                } else {
                    fileHeader.setFileName(null);
                }
                readExtraDataRecords(randomAccessFile, fileHeader);
                readZip64ExtendedInfo(fileHeader, rawIO2);
                readAesExtraDataRecord(fileHeader, rawIO2);
                if (readShortLittleEndian2 > 0) {
                    byte[] bArr5 = new byte[readShortLittleEndian2];
                    randomAccessFile.readFully(bArr5);
                    fileHeader.setFileComment(HeaderUtil.decodeStringWithCharset(bArr5, fileHeader.isFileNameUTF8Encoded(), charset));
                }
                if (fileHeader.isEncrypted()) {
                    if (fileHeader.getAesExtraDataRecord() != null) {
                        fileHeader.setEncryptionMethod(EncryptionMethod.AES);
                    } else {
                        fileHeader.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
                    }
                }
                arrayList.add(fileHeader);
                i3++;
                bArr2 = bArr2;
                bArr = bArr;
                numberOfEntriesInCentralDirectory = numberOfEntriesInCentralDirectory;
                i = 2;
                i2 = 0;
            } else {
                throw new ZipException("Expected central directory entry not found (#" + (i3 + 1) + ")");
            }
        }
        centralDirectory.setFileHeaders(arrayList);
        DigitalSignature digitalSignature = new DigitalSignature();
        if (((long) rawIO2.readIntLittleEndian(randomAccessFile)) == HeaderSignature.DIGITAL_SIGNATURE.getValue()) {
            digitalSignature.setSignature(HeaderSignature.DIGITAL_SIGNATURE);
            digitalSignature.setSizeOfData(rawIO2.readShortLittleEndian(randomAccessFile));
            if (digitalSignature.getSizeOfData() > 0) {
                byte[] bArr6 = new byte[digitalSignature.getSizeOfData()];
                randomAccessFile.readFully(bArr6);
                digitalSignature.setSignatureData(new String(bArr6));
            }
        }
        return centralDirectory;
    }

    private void readExtraDataRecords(RandomAccessFile randomAccessFile, FileHeader fileHeader) throws IOException {
        int extraFieldLength = fileHeader.getExtraFieldLength();
        if (extraFieldLength > 0) {
            fileHeader.setExtraDataRecords(readExtraDataRecords(randomAccessFile, extraFieldLength));
        }
    }

    private void readExtraDataRecords(InputStream inputStream, LocalFileHeader localFileHeader) throws IOException {
        int extraFieldLength = localFileHeader.getExtraFieldLength();
        if (extraFieldLength > 0) {
            localFileHeader.setExtraDataRecords(readExtraDataRecords(inputStream, extraFieldLength));
        }
    }

    private List<ExtraDataRecord> readExtraDataRecords(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i >= 4) {
            byte[] bArr = new byte[i];
            randomAccessFile.read(bArr);
            try {
                return parseExtraDataRecords(bArr, i);
            } catch (Exception unused) {
                return Collections.emptyList();
            }
        } else if (i <= 0) {
            return null;
        } else {
            randomAccessFile.skipBytes(i);
            return null;
        }
    }

    private List<ExtraDataRecord> readExtraDataRecords(InputStream inputStream, int i) throws IOException {
        if (i >= 4) {
            byte[] bArr = new byte[i];
            Zip4jUtil.readFully(inputStream, bArr);
            try {
                return parseExtraDataRecords(bArr, i);
            } catch (Exception unused) {
                return Collections.emptyList();
            }
        } else if (i <= 0) {
            return null;
        } else {
            inputStream.skip((long) i);
            return null;
        }
    }

    private List<ExtraDataRecord> parseExtraDataRecords(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            ExtraDataRecord extraDataRecord = new ExtraDataRecord();
            extraDataRecord.setHeader((long) this.rawIO.readShortLittleEndian(bArr, i2));
            int i3 = i2 + 2;
            int readShortLittleEndian = this.rawIO.readShortLittleEndian(bArr, i3);
            extraDataRecord.setSizeOfData(readShortLittleEndian);
            int i4 = i3 + 2;
            if (readShortLittleEndian > 0) {
                byte[] bArr2 = new byte[readShortLittleEndian];
                System.arraycopy(bArr, i4, bArr2, 0, readShortLittleEndian);
                extraDataRecord.setData(bArr2);
            }
            i2 = i4 + readShortLittleEndian;
            arrayList.add(extraDataRecord);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private Zip64EndOfCentralDirectoryLocator readZip64EndOfCentralDirectoryLocator(RandomAccessFile randomAccessFile, RawIO rawIO2, long j) throws IOException {
        Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = new Zip64EndOfCentralDirectoryLocator();
        setFilePointerToReadZip64EndCentralDirLoc(randomAccessFile, j);
        if (((long) rawIO2.readIntLittleEndian(randomAccessFile)) == HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.getValue()) {
            this.zipModel.setZip64Format(true);
            zip64EndOfCentralDirectoryLocator.setSignature(HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR);
            zip64EndOfCentralDirectoryLocator.setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(rawIO2.readIntLittleEndian(randomAccessFile));
            zip64EndOfCentralDirectoryLocator.setOffsetZip64EndOfCentralDirectoryRecord(rawIO2.readLongLittleEndian(randomAccessFile));
            zip64EndOfCentralDirectoryLocator.setTotalNumberOfDiscs(rawIO2.readIntLittleEndian(randomAccessFile));
            return zip64EndOfCentralDirectoryLocator;
        }
        this.zipModel.setZip64Format(false);
        return null;
    }

    private Zip64EndOfCentralDirectoryRecord readZip64EndCentralDirRec(RandomAccessFile randomAccessFile, RawIO rawIO2) throws IOException {
        if (this.zipModel.getZip64EndOfCentralDirectoryLocator() != null) {
            long offsetZip64EndOfCentralDirectoryRecord = this.zipModel.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord();
            if (offsetZip64EndOfCentralDirectoryRecord >= 0) {
                randomAccessFile.seek(offsetZip64EndOfCentralDirectoryRecord);
                Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = new Zip64EndOfCentralDirectoryRecord();
                if (((long) rawIO2.readIntLittleEndian(randomAccessFile)) == HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD.getValue()) {
                    zip64EndOfCentralDirectoryRecord.setSignature(HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD);
                    zip64EndOfCentralDirectoryRecord.setSizeOfZip64EndCentralDirectoryRecord(rawIO2.readLongLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setVersionMadeBy(rawIO2.readShortLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setVersionNeededToExtract(rawIO2.readShortLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(rawIO2.readIntLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(rawIO2.readIntLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(rawIO2.readLongLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(rawIO2.readLongLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setSizeOfCentralDirectory(rawIO2.readLongLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(rawIO2.readLongLittleEndian(randomAccessFile));
                    long sizeOfZip64EndCentralDirectoryRecord = zip64EndOfCentralDirectoryRecord.getSizeOfZip64EndCentralDirectoryRecord() - 44;
                    if (sizeOfZip64EndCentralDirectoryRecord > 0) {
                        byte[] bArr = new byte[((int) sizeOfZip64EndCentralDirectoryRecord)];
                        randomAccessFile.readFully(bArr);
                        zip64EndOfCentralDirectoryRecord.setExtensibleDataSector(bArr);
                    }
                    return zip64EndOfCentralDirectoryRecord;
                }
                throw new ZipException("invalid signature for zip64 end of central directory record");
            }
            throw new ZipException("invalid offset for start of end of central directory record");
        }
        throw new ZipException("invalid zip64 end of central directory locator");
    }

    private void readZip64ExtendedInfo(FileHeader fileHeader, RawIO rawIO2) throws ZipException {
        Zip64ExtendedInfo readZip64ExtendedInfo;
        if (fileHeader.getExtraDataRecords() != null && fileHeader.getExtraDataRecords().size() > 0 && (readZip64ExtendedInfo = readZip64ExtendedInfo(fileHeader.getExtraDataRecords(), rawIO2, fileHeader.getUncompressedSize(), fileHeader.getCompressedSize(), fileHeader.getOffsetLocalHeader(), fileHeader.getDiskNumberStart())) != null) {
            fileHeader.setZip64ExtendedInfo(readZip64ExtendedInfo);
            if (readZip64ExtendedInfo.getUncompressedSize() != -1) {
                fileHeader.setUncompressedSize(readZip64ExtendedInfo.getUncompressedSize());
            }
            if (readZip64ExtendedInfo.getCompressedSize() != -1) {
                fileHeader.setCompressedSize(readZip64ExtendedInfo.getCompressedSize());
            }
            if (readZip64ExtendedInfo.getOffsetLocalHeader() != -1) {
                fileHeader.setOffsetLocalHeader(readZip64ExtendedInfo.getOffsetLocalHeader());
            }
            if (readZip64ExtendedInfo.getDiskNumberStart() != -1) {
                fileHeader.setDiskNumberStart(readZip64ExtendedInfo.getDiskNumberStart());
            }
        }
    }

    private void readZip64ExtendedInfo(LocalFileHeader localFileHeader, RawIO rawIO2) throws ZipException {
        Zip64ExtendedInfo readZip64ExtendedInfo;
        if (localFileHeader == null) {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        } else if (localFileHeader.getExtraDataRecords() != null && localFileHeader.getExtraDataRecords().size() > 0 && (readZip64ExtendedInfo = readZip64ExtendedInfo(localFileHeader.getExtraDataRecords(), rawIO2, localFileHeader.getUncompressedSize(), localFileHeader.getCompressedSize(), 0, 0)) != null) {
            localFileHeader.setZip64ExtendedInfo(readZip64ExtendedInfo);
            if (readZip64ExtendedInfo.getUncompressedSize() != -1) {
                localFileHeader.setUncompressedSize(readZip64ExtendedInfo.getUncompressedSize());
            }
            if (readZip64ExtendedInfo.getCompressedSize() != -1) {
                localFileHeader.setCompressedSize(readZip64ExtendedInfo.getCompressedSize());
            }
        }
    }

    private Zip64ExtendedInfo readZip64ExtendedInfo(List<ExtraDataRecord> list, RawIO rawIO2, long j, long j2, long j3, int i) {
        for (ExtraDataRecord extraDataRecord : list) {
            if (extraDataRecord != null) {
                if (HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue() == extraDataRecord.getHeader()) {
                    Zip64ExtendedInfo zip64ExtendedInfo = new Zip64ExtendedInfo();
                    byte[] data = extraDataRecord.getData();
                    if (extraDataRecord.getSizeOfData() <= 0) {
                        return null;
                    }
                    int i2 = 0;
                    if (extraDataRecord.getSizeOfData() > 0 && j == 4294967295L) {
                        zip64ExtendedInfo.setUncompressedSize(rawIO2.readLongLittleEndian(data, 0));
                        i2 = 8;
                    }
                    if (i2 < extraDataRecord.getSizeOfData() && j2 == 4294967295L) {
                        zip64ExtendedInfo.setCompressedSize(rawIO2.readLongLittleEndian(data, i2));
                        i2 += 8;
                    }
                    if (i2 < extraDataRecord.getSizeOfData() && j3 == 4294967295L) {
                        zip64ExtendedInfo.setOffsetLocalHeader(rawIO2.readLongLittleEndian(data, i2));
                        i2 += 8;
                    }
                    if (i2 < extraDataRecord.getSizeOfData() && i == 65535) {
                        zip64ExtendedInfo.setDiskNumberStart(rawIO2.readIntLittleEndian(data, i2));
                    }
                    return zip64ExtendedInfo;
                }
            }
        }
        return null;
    }

    private void setFilePointerToReadZip64EndCentralDirLoc(RandomAccessFile randomAccessFile, long j) throws IOException {
        seekInCurrentPart(randomAccessFile, (((j - 4) - 8) - 4) - 4);
    }

    public LocalFileHeader readLocalFileHeader(InputStream inputStream, Charset charset) throws IOException {
        LocalFileHeader localFileHeader = new LocalFileHeader();
        byte[] bArr = new byte[4];
        if (((long) this.rawIO.readIntLittleEndian(inputStream)) != HeaderSignature.LOCAL_FILE_HEADER.getValue()) {
            return null;
        }
        localFileHeader.setSignature(HeaderSignature.LOCAL_FILE_HEADER);
        localFileHeader.setVersionNeededToExtract(this.rawIO.readShortLittleEndian(inputStream));
        byte[] bArr2 = new byte[2];
        if (Zip4jUtil.readFully(inputStream, bArr2) == 2) {
            localFileHeader.setEncrypted(BitUtils.isBitSet(bArr2[0], 0));
            localFileHeader.setDataDescriptorExists(BitUtils.isBitSet(bArr2[0], 3));
            boolean z = true;
            localFileHeader.setFileNameUTF8Encoded(BitUtils.isBitSet(bArr2[1], 3));
            localFileHeader.setGeneralPurposeFlag((byte[]) bArr2.clone());
            localFileHeader.setCompressionMethod(CompressionMethod.getCompressionMethodFromCode(this.rawIO.readShortLittleEndian(inputStream)));
            localFileHeader.setLastModifiedTime((long) this.rawIO.readIntLittleEndian(inputStream));
            Zip4jUtil.readFully(inputStream, bArr);
            localFileHeader.setCrc(this.rawIO.readLongLittleEndian(bArr, 0));
            localFileHeader.setCrcRawData((byte[]) bArr.clone());
            localFileHeader.setCompressedSize(this.rawIO.readLongLittleEndian(inputStream, 4));
            localFileHeader.setUncompressedSize(this.rawIO.readLongLittleEndian(inputStream, 4));
            int readShortLittleEndian = this.rawIO.readShortLittleEndian(inputStream);
            localFileHeader.setFileNameLength(readShortLittleEndian);
            localFileHeader.setExtraFieldLength(this.rawIO.readShortLittleEndian(inputStream));
            if (readShortLittleEndian > 0) {
                byte[] bArr3 = new byte[readShortLittleEndian];
                Zip4jUtil.readFully(inputStream, bArr3);
                String decodeStringWithCharset = HeaderUtil.decodeStringWithCharset(bArr3, localFileHeader.isFileNameUTF8Encoded(), charset);
                if (decodeStringWithCharset != null) {
                    if (decodeStringWithCharset.contains(":" + System.getProperty("file.separator"))) {
                        decodeStringWithCharset = decodeStringWithCharset.substring(decodeStringWithCharset.indexOf(":" + System.getProperty("file.separator")) + 2);
                    }
                    localFileHeader.setFileName(decodeStringWithCharset);
                    if (!decodeStringWithCharset.endsWith("/") && !decodeStringWithCharset.endsWith("\\")) {
                        z = false;
                    }
                    localFileHeader.setDirectory(z);
                } else {
                    throw new ZipException("file name is null, cannot assign file name to local file header");
                }
            } else {
                localFileHeader.setFileName(null);
            }
            readExtraDataRecords(inputStream, localFileHeader);
            readZip64ExtendedInfo(localFileHeader, this.rawIO);
            readAesExtraDataRecord(localFileHeader, this.rawIO);
            if (localFileHeader.isEncrypted() && localFileHeader.getEncryptionMethod() != EncryptionMethod.AES) {
                if (BigInteger.valueOf((long) localFileHeader.getGeneralPurposeFlag()[0]).testBit(6)) {
                    localFileHeader.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG);
                } else {
                    localFileHeader.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
                }
            }
            return localFileHeader;
        }
        throw new ZipException("Could not read enough bytes for generalPurposeFlags");
    }

    public DataDescriptor readDataDescriptor(InputStream inputStream, boolean z) throws IOException {
        DataDescriptor dataDescriptor = new DataDescriptor();
        byte[] bArr = new byte[4];
        Zip4jUtil.readFully(inputStream, bArr);
        long readLongLittleEndian = this.rawIO.readLongLittleEndian(bArr, 0);
        if (readLongLittleEndian == HeaderSignature.EXTRA_DATA_RECORD.getValue()) {
            dataDescriptor.setSignature(HeaderSignature.EXTRA_DATA_RECORD);
            Zip4jUtil.readFully(inputStream, bArr);
            dataDescriptor.setCrc(this.rawIO.readLongLittleEndian(bArr, 0));
        } else {
            dataDescriptor.setCrc(readLongLittleEndian);
        }
        if (z) {
            dataDescriptor.setCompressedSize(this.rawIO.readLongLittleEndian(inputStream));
            dataDescriptor.setUncompressedSize(this.rawIO.readLongLittleEndian(inputStream));
        } else {
            dataDescriptor.setCompressedSize((long) this.rawIO.readIntLittleEndian(inputStream));
            dataDescriptor.setUncompressedSize((long) this.rawIO.readIntLittleEndian(inputStream));
        }
        return dataDescriptor;
    }

    private void readAesExtraDataRecord(FileHeader fileHeader, RawIO rawIO2) throws ZipException {
        AESExtraDataRecord readAesExtraDataRecord;
        if (fileHeader.getExtraDataRecords() != null && fileHeader.getExtraDataRecords().size() > 0 && (readAesExtraDataRecord = readAesExtraDataRecord(fileHeader.getExtraDataRecords(), rawIO2)) != null) {
            fileHeader.setAesExtraDataRecord(readAesExtraDataRecord);
            fileHeader.setEncryptionMethod(EncryptionMethod.AES);
        }
    }

    private void readAesExtraDataRecord(LocalFileHeader localFileHeader, RawIO rawIO2) throws ZipException {
        AESExtraDataRecord readAesExtraDataRecord;
        if (localFileHeader.getExtraDataRecords() != null && localFileHeader.getExtraDataRecords().size() > 0 && (readAesExtraDataRecord = readAesExtraDataRecord(localFileHeader.getExtraDataRecords(), rawIO2)) != null) {
            localFileHeader.setAesExtraDataRecord(readAesExtraDataRecord);
            localFileHeader.setEncryptionMethod(EncryptionMethod.AES);
        }
    }

    private AESExtraDataRecord readAesExtraDataRecord(List<ExtraDataRecord> list, RawIO rawIO2) throws ZipException {
        if (list == null) {
            return null;
        }
        for (ExtraDataRecord extraDataRecord : list) {
            if (extraDataRecord != null && extraDataRecord.getHeader() == HeaderSignature.AES_EXTRA_DATA_RECORD.getValue()) {
                if (extraDataRecord.getData() != null) {
                    AESExtraDataRecord aESExtraDataRecord = new AESExtraDataRecord();
                    aESExtraDataRecord.setSignature(HeaderSignature.AES_EXTRA_DATA_RECORD);
                    aESExtraDataRecord.setDataSize(extraDataRecord.getSizeOfData());
                    byte[] data = extraDataRecord.getData();
                    aESExtraDataRecord.setAesVersion(AesVersion.getFromVersionNumber(rawIO2.readShortLittleEndian(data, 0)));
                    byte[] bArr = new byte[2];
                    System.arraycopy(data, 2, bArr, 0, 2);
                    aESExtraDataRecord.setVendorID(new String(bArr));
                    aESExtraDataRecord.setAesKeyStrength(AesKeyStrength.getAesKeyStrengthFromRawCode(data[4] & 255));
                    aESExtraDataRecord.setCompressionMethod(CompressionMethod.getCompressionMethodFromCode(rawIO2.readShortLittleEndian(data, 5)));
                    return aESExtraDataRecord;
                }
                throw new ZipException("corrupt AES extra data records");
            }
        }
        return null;
    }

    private long getNumberOfEntriesInCentralDirectory(ZipModel zipModel2) {
        if (zipModel2.isZip64Format()) {
            return zipModel2.getZip64EndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory();
        }
        return (long) zipModel2.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory();
    }

    private long determineOffsetOfEndOfCentralDirectory(RandomAccessFile randomAccessFile) throws IOException {
        byte[] bArr = new byte[4096];
        long filePointer = randomAccessFile.getFilePointer();
        do {
            int i = filePointer > 4096 ? 4096 : (int) filePointer;
            filePointer = (filePointer - ((long) i)) + 4;
            if (filePointer == 4) {
                filePointer = 0;
            }
            seekInCurrentPart(randomAccessFile, filePointer);
            randomAccessFile.read(bArr, 0, i);
            for (int i2 = 0; i2 < i - 3; i2++) {
                if (((long) this.rawIO.readIntLittleEndian(bArr, i2)) == HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue()) {
                    return filePointer + ((long) i2);
                }
            }
        } while (filePointer > 0);
        throw new ZipException("Zip headers not found. Probably not a zip file");
    }

    private void seekInCurrentPart(RandomAccessFile randomAccessFile, long j) throws IOException {
        if (randomAccessFile instanceof NumberedSplitRandomAccessFile) {
            ((NumberedSplitRandomAccessFile) randomAccessFile).seekInCurrentPart(j);
        } else {
            randomAccessFile.seek(j);
        }
    }

    private String readZipComment(RandomAccessFile randomAccessFile, int i, Charset charset) {
        if (i <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i];
            randomAccessFile.readFully(bArr);
            return new String(bArr, charset);
        } catch (IOException unused) {
            return null;
        }
    }
}
