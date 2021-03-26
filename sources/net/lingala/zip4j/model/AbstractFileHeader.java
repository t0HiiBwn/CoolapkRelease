package net.lingala.zip4j.model;

import java.util.List;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractFileHeader extends ZipHeader {
    private AESExtraDataRecord aesExtraDataRecord;
    private long compressedSize = 0;
    private CompressionMethod compressionMethod;
    private long crc = 0;
    private byte[] crcRawData;
    private boolean dataDescriptorExists;
    private EncryptionMethod encryptionMethod = EncryptionMethod.NONE;
    private List<ExtraDataRecord> extraDataRecords;
    private int extraFieldLength;
    private String fileName;
    private int fileNameLength;
    private boolean fileNameUTF8Encoded;
    private byte[] generalPurposeFlag;
    private boolean isDirectory;
    private boolean isEncrypted;
    private long lastModifiedTime;
    private long uncompressedSize = 0;
    private int versionNeededToExtract;
    private Zip64ExtendedInfo zip64ExtendedInfo;

    public int getVersionNeededToExtract() {
        return this.versionNeededToExtract;
    }

    public void setVersionNeededToExtract(int i) {
        this.versionNeededToExtract = i;
    }

    public byte[] getGeneralPurposeFlag() {
        return this.generalPurposeFlag;
    }

    public void setGeneralPurposeFlag(byte[] bArr) {
        this.generalPurposeFlag = bArr;
    }

    public CompressionMethod getCompressionMethod() {
        return this.compressionMethod;
    }

    public void setCompressionMethod(CompressionMethod compressionMethod2) {
        this.compressionMethod = compressionMethod2;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public void setLastModifiedTime(long j) {
        this.lastModifiedTime = j;
    }

    public long getLastModifiedTimeEpoch() {
        return Zip4jUtil.dosToExtendedEpochTme(this.lastModifiedTime);
    }

    public long getCrc() {
        return this.crc;
    }

    public void setCrc(long j) {
        this.crc = j;
    }

    public byte[] getCrcRawData() {
        return this.crcRawData;
    }

    public void setCrcRawData(byte[] bArr) {
        this.crcRawData = bArr;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public void setCompressedSize(long j) {
        this.compressedSize = j;
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public void setUncompressedSize(long j) {
        this.uncompressedSize = j;
    }

    public int getFileNameLength() {
        return this.fileNameLength;
    }

    public void setFileNameLength(int i) {
        this.fileNameLength = i;
    }

    public int getExtraFieldLength() {
        return this.extraFieldLength;
    }

    public void setExtraFieldLength(int i) {
        this.extraFieldLength = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public void setEncrypted(boolean z) {
        this.isEncrypted = z;
    }

    public EncryptionMethod getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public void setEncryptionMethod(EncryptionMethod encryptionMethod2) {
        this.encryptionMethod = encryptionMethod2;
    }

    public boolean isDataDescriptorExists() {
        return this.dataDescriptorExists;
    }

    public void setDataDescriptorExists(boolean z) {
        this.dataDescriptorExists = z;
    }

    public Zip64ExtendedInfo getZip64ExtendedInfo() {
        return this.zip64ExtendedInfo;
    }

    public void setZip64ExtendedInfo(Zip64ExtendedInfo zip64ExtendedInfo2) {
        this.zip64ExtendedInfo = zip64ExtendedInfo2;
    }

    public AESExtraDataRecord getAesExtraDataRecord() {
        return this.aesExtraDataRecord;
    }

    public void setAesExtraDataRecord(AESExtraDataRecord aESExtraDataRecord) {
        this.aesExtraDataRecord = aESExtraDataRecord;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.fileNameUTF8Encoded;
    }

    public void setFileNameUTF8Encoded(boolean z) {
        this.fileNameUTF8Encoded = z;
    }

    public List<ExtraDataRecord> getExtraDataRecords() {
        return this.extraDataRecords;
    }

    public void setExtraDataRecords(List<ExtraDataRecord> list) {
        this.extraDataRecords = list;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AbstractFileHeader)) {
            return getFileName().equals(((AbstractFileHeader) obj).getFileName());
        }
        return false;
    }
}
