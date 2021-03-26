package net.lingala.zip4j.model.enums;

public enum AesVersion {
    ONE(1),
    TWO(2);
    
    private int versionNumber;

    private AesVersion(int i) {
        this.versionNumber = i;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public static AesVersion getFromVersionNumber(int i) {
        AesVersion[] values = values();
        for (AesVersion aesVersion : values) {
            if (aesVersion.versionNumber == i) {
                return aesVersion;
            }
        }
        throw new IllegalArgumentException("Unsupported Aes version");
    }
}
