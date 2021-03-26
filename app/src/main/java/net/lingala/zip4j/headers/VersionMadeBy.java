package net.lingala.zip4j.headers;

public enum VersionMadeBy {
    SPECIFICATION_VERSION((byte) 51),
    WINDOWS((byte) 0),
    UNIX((byte) 3);
    
    private byte code;

    private VersionMadeBy(byte b) {
        this.code = b;
    }

    public byte getCode() {
        return this.code;
    }
}
