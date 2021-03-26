package net.lingala.zip4j.model;

public class Zip64EndOfCentralDirectoryRecord extends ZipHeader {
    private byte[] extensibleDataSector;
    private int numberOfThisDisk;
    private int numberOfThisDiskStartOfCentralDirectory;
    private long offsetStartCentralDirectoryWRTStartDiskNumber = -1;
    private long sizeOfCentralDirectory;
    private long sizeOfZip64EndCentralDirectoryRecord;
    private long totalNumberOfEntriesInCentralDirectory;
    private long totalNumberOfEntriesInCentralDirectoryOnThisDisk;
    private int versionMadeBy;
    private int versionNeededToExtract;

    public long getSizeOfZip64EndCentralDirectoryRecord() {
        return this.sizeOfZip64EndCentralDirectoryRecord;
    }

    public void setSizeOfZip64EndCentralDirectoryRecord(long j) {
        this.sizeOfZip64EndCentralDirectoryRecord = j;
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public void setVersionMadeBy(int i) {
        this.versionMadeBy = i;
    }

    public int getVersionNeededToExtract() {
        return this.versionNeededToExtract;
    }

    public void setVersionNeededToExtract(int i) {
        this.versionNeededToExtract = i;
    }

    public int getNumberOfThisDisk() {
        return this.numberOfThisDisk;
    }

    public void setNumberOfThisDisk(int i) {
        this.numberOfThisDisk = i;
    }

    public int getNumberOfThisDiskStartOfCentralDirectory() {
        return this.numberOfThisDiskStartOfCentralDirectory;
    }

    public void setNumberOfThisDiskStartOfCentralDirectory(int i) {
        this.numberOfThisDiskStartOfCentralDirectory = i;
    }

    public long getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() {
        return this.totalNumberOfEntriesInCentralDirectoryOnThisDisk;
    }

    public void setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(long j) {
        this.totalNumberOfEntriesInCentralDirectoryOnThisDisk = j;
    }

    public long getTotalNumberOfEntriesInCentralDirectory() {
        return this.totalNumberOfEntriesInCentralDirectory;
    }

    public void setTotalNumberOfEntriesInCentralDirectory(long j) {
        this.totalNumberOfEntriesInCentralDirectory = j;
    }

    public long getSizeOfCentralDirectory() {
        return this.sizeOfCentralDirectory;
    }

    public void setSizeOfCentralDirectory(long j) {
        this.sizeOfCentralDirectory = j;
    }

    public long getOffsetStartCentralDirectoryWRTStartDiskNumber() {
        return this.offsetStartCentralDirectoryWRTStartDiskNumber;
    }

    public void setOffsetStartCentralDirectoryWRTStartDiskNumber(long j) {
        this.offsetStartCentralDirectoryWRTStartDiskNumber = j;
    }

    public byte[] getExtensibleDataSector() {
        return this.extensibleDataSector;
    }

    public void setExtensibleDataSector(byte[] bArr) {
        this.extensibleDataSector = bArr;
    }
}
