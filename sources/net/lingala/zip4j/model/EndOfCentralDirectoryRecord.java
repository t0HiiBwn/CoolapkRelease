package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class EndOfCentralDirectoryRecord extends ZipHeader {
    private String comment = "";
    private int numberOfThisDisk;
    private int numberOfThisDiskStartOfCentralDir;
    private long offsetOfEndOfCentralDirectory;
    private long offsetOfStartOfCentralDirectory;
    private int sizeOfCentralDirectory;
    private int totalNumberOfEntriesInCentralDirectory;
    private int totalNumberOfEntriesInCentralDirectoryOnThisDisk;

    public EndOfCentralDirectoryRecord() {
        setSignature(HeaderSignature.END_OF_CENTRAL_DIRECTORY);
    }

    public int getNumberOfThisDisk() {
        return this.numberOfThisDisk;
    }

    public void setNumberOfThisDisk(int i) {
        this.numberOfThisDisk = i;
    }

    public int getNumberOfThisDiskStartOfCentralDir() {
        return this.numberOfThisDiskStartOfCentralDir;
    }

    public void setNumberOfThisDiskStartOfCentralDir(int i) {
        this.numberOfThisDiskStartOfCentralDir = i;
    }

    public int getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() {
        return this.totalNumberOfEntriesInCentralDirectoryOnThisDisk;
    }

    public void setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(int i) {
        this.totalNumberOfEntriesInCentralDirectoryOnThisDisk = i;
    }

    public int getTotalNumberOfEntriesInCentralDirectory() {
        return this.totalNumberOfEntriesInCentralDirectory;
    }

    public void setTotalNumberOfEntriesInCentralDirectory(int i) {
        this.totalNumberOfEntriesInCentralDirectory = i;
    }

    public int getSizeOfCentralDirectory() {
        return this.sizeOfCentralDirectory;
    }

    public void setSizeOfCentralDirectory(int i) {
        this.sizeOfCentralDirectory = i;
    }

    public long getOffsetOfStartOfCentralDirectory() {
        return this.offsetOfStartOfCentralDirectory;
    }

    public void setOffsetOfStartOfCentralDirectory(long j) {
        this.offsetOfStartOfCentralDirectory = j;
    }

    public long getOffsetOfEndOfCentralDirectory() {
        return this.offsetOfEndOfCentralDirectory;
    }

    public void setOffsetOfEndOfCentralDirectory(long j) {
        this.offsetOfEndOfCentralDirectory = j;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        if (str != null) {
            this.comment = str;
        }
    }
}
