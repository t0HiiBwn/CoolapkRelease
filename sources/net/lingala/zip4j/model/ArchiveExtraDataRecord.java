package net.lingala.zip4j.model;

public class ArchiveExtraDataRecord extends ZipHeader {
    private String extraFieldData;
    private int extraFieldLength;

    public int getExtraFieldLength() {
        return this.extraFieldLength;
    }

    public void setExtraFieldLength(int i) {
        this.extraFieldLength = i;
    }

    public String getExtraFieldData() {
        return this.extraFieldData;
    }

    public void setExtraFieldData(String str) {
        this.extraFieldData = str;
    }
}
