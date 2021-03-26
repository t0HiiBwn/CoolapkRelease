package net.lingala.zip4j.model.enums;

public enum RandomAccessFileMode {
    READ("r"),
    WRITE("rw");
    
    private String value;

    private RandomAccessFileMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
