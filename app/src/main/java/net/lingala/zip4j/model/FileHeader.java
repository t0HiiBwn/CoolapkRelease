package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class FileHeader extends AbstractFileHeader {
    private int diskNumberStart;
    private byte[] externalFileAttributes;
    private String fileComment;
    private int fileCommentLength = 0;
    private byte[] internalFileAttributes;
    private long offsetLocalHeader;
    private int versionMadeBy;

    public FileHeader() {
        setSignature(HeaderSignature.CENTRAL_DIRECTORY);
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public void setVersionMadeBy(int i) {
        this.versionMadeBy = i;
    }

    public int getFileCommentLength() {
        return this.fileCommentLength;
    }

    public void setFileCommentLength(int i) {
        this.fileCommentLength = i;
    }

    public int getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public void setDiskNumberStart(int i) {
        this.diskNumberStart = i;
    }

    public byte[] getInternalFileAttributes() {
        return this.internalFileAttributes;
    }

    public void setInternalFileAttributes(byte[] bArr) {
        this.internalFileAttributes = bArr;
    }

    public byte[] getExternalFileAttributes() {
        return this.externalFileAttributes;
    }

    public void setExternalFileAttributes(byte[] bArr) {
        this.externalFileAttributes = bArr;
    }

    public long getOffsetLocalHeader() {
        return this.offsetLocalHeader;
    }

    public void setOffsetLocalHeader(long j) {
        this.offsetLocalHeader = j;
    }

    public String getFileComment() {
        return this.fileComment;
    }

    public void setFileComment(String str) {
        this.fileComment = str;
    }

    public String toString() {
        return getFileName();
    }
}
