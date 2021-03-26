package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.util.zip.Deflater;
import net.lingala.zip4j.model.enums.CompressionLevel;

class DeflaterOutputStream extends CompressedOutputStream {
    private byte[] buff = new byte[4096];
    protected Deflater deflater;

    public DeflaterOutputStream(CipherOutputStream cipherOutputStream, CompressionLevel compressionLevel) {
        super(cipherOutputStream);
        this.deflater = new Deflater(compressionLevel.getLevel(), true);
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.deflater.setInput(bArr, i, i2);
        while (!this.deflater.needsInput()) {
            deflate();
        }
    }

    private void deflate() throws IOException {
        Deflater deflater2 = this.deflater;
        byte[] bArr = this.buff;
        int deflate = deflater2.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            super.write(this.buff, 0, deflate);
        }
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream
    public void closeEntry() throws IOException {
        if (!this.deflater.finished()) {
            this.deflater.finish();
            while (!this.deflater.finished()) {
                deflate();
            }
        }
        this.deflater.end();
        super.closeEntry();
    }
}
