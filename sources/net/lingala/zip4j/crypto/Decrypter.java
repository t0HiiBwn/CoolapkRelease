package net.lingala.zip4j.crypto;

import net.lingala.zip4j.exception.ZipException;

public interface Decrypter {
    int decryptData(byte[] bArr, int i, int i2) throws ZipException;
}
