package net.lingala.zip4j.headers;

public enum VersionNeededToExtract {
    DEFAULT(10),
    DEFLATE_COMPRESSED(20),
    ZIP_64_FORMAT(45),
    AES_ENCRYPTED(51);
    
    private int code;

    private VersionNeededToExtract(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
