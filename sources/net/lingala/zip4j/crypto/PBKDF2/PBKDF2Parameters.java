package net.lingala.zip4j.crypto.PBKDF2;

public class PBKDF2Parameters {
    protected byte[] derivedKey;
    protected String hashAlgorithm;
    protected String hashCharset;
    protected int iterationCount;
    protected byte[] salt;

    public PBKDF2Parameters() {
        this.hashAlgorithm = null;
        this.hashCharset = "UTF-8";
        this.salt = null;
        this.iterationCount = 1000;
        this.derivedKey = null;
    }

    public PBKDF2Parameters(String str, String str2, byte[] bArr, int i) {
        this(str, str2, bArr, i, null);
    }

    public PBKDF2Parameters(String str, String str2, byte[] bArr, int i, byte[] bArr2) {
        this.hashAlgorithm = str;
        this.hashCharset = str2;
        this.salt = bArr;
        this.iterationCount = i;
        this.derivedKey = bArr2;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public void setIterationCount(int i) {
        this.iterationCount = i;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public void setSalt(byte[] bArr) {
        this.salt = bArr;
    }

    public byte[] getDerivedKey() {
        return this.derivedKey;
    }

    public void setDerivedKey(byte[] bArr) {
        this.derivedKey = bArr;
    }

    public String getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public void setHashAlgorithm(String str) {
        this.hashAlgorithm = str;
    }

    public String getHashCharset() {
        return this.hashCharset;
    }

    public void setHashCharset(String str) {
        this.hashCharset = str;
    }
}
