package net.lingala.zip4j.model.enums;

public enum AesKeyStrength {
    KEY_STRENGTH_128(1, 8, 16, 16),
    KEY_STRENGTH_192(2, 12, 24, 24),
    KEY_STRENGTH_256(3, 16, 32, 32);
    
    private int keyLength;
    private int macLength;
    private int rawCode;
    private int saltLength;

    private AesKeyStrength(int i, int i2, int i3, int i4) {
        this.rawCode = i;
        this.saltLength = i2;
        this.macLength = i3;
        this.keyLength = i4;
    }

    public int getRawCode() {
        return this.rawCode;
    }

    public int getSaltLength() {
        return this.saltLength;
    }

    public int getMacLength() {
        return this.macLength;
    }

    public int getKeyLength() {
        return this.keyLength;
    }

    public static AesKeyStrength getAesKeyStrengthFromRawCode(int i) {
        AesKeyStrength[] values = values();
        for (AesKeyStrength aesKeyStrength : values) {
            if (aesKeyStrength.getRawCode() == i) {
                return aesKeyStrength;
            }
        }
        return null;
    }
}
