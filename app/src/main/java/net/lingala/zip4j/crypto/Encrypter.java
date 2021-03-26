package net.lingala.zip4j.crypto;

import net.lingala.zip4j.exception.ZipException;

public interface Encrypter {
    int encryptData(byte[] bArr) throws ZipException;

    int encryptData(byte[] bArr, int i, int i2) throws ZipException;
}
