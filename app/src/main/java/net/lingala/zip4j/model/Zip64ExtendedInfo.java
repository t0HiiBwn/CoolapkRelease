package net.lingala.zip4j.model;

public class Zip64ExtendedInfo extends ZipHeader {
    private long compressedSize = -1;
    private int diskNumberStart = -1;
    private long offsetLocalHeader = -1;
    private int size;
    private long uncompressedSize = -1;

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
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

    public long getOffsetLocalHeader() {
        return this.offsetLocalHeader;
    }

    public void setOffsetLocalHeader(long j) {
        this.offsetLocalHeader = j;
    }

    public int getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public void setDiskNumberStart(int i) {
        this.diskNumberStart = i;
    }
}
