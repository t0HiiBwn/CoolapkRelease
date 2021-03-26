package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.StandardEncrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jUtil;

class ZipStandardCipherOutputStream extends CipherOutputStream<StandardEncrypter> {
    public ZipStandardCipherOutputStream(ZipEntryOutputStream zipEntryOutputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        super(zipEntryOutputStream, zipParameters, cArr);
    }

    /* access modifiers changed from: protected */
    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream
    public StandardEncrypter initializeEncrypter(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        StandardEncrypter standardEncrypter = new StandardEncrypter(cArr, getEncryptionKey(zipParameters));
        writeHeaders(standardEncrypter.getHeaderBytes());
        return standardEncrypter;
    }

    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        super.write(bArr, i, i2);
    }

    private long getEncryptionKey(ZipParameters zipParameters) {
        if (zipParameters.isWriteExtendedLocalFileHeader()) {
            return (Zip4jUtil.epochToExtendedDosTime(zipParameters.getLastModifiedFileTime()) & 65535) << 16;
        }
        return zipParameters.getEntryCRC();
    }
}
