package com.coolapk.market.widget.encode;

import java.io.IOException;
import java.io.OutputStream;

public class UUEncoder extends CharacterEncoder {
    private String bufferName;
    private int mode;

    @Override // com.coolapk.market.widget.encode.CharacterEncoder
    protected int bytesPerAtom() {
        return 3;
    }

    @Override // com.coolapk.market.widget.encode.CharacterEncoder
    protected int bytesPerLine() {
        return 45;
    }

    public UUEncoder() {
        this.bufferName = "encoder.buf";
        this.mode = 644;
    }

    public UUEncoder(String str) {
        this.bufferName = str;
        this.mode = 644;
    }

    public UUEncoder(String str, int i) {
        this.bufferName = str;
        this.mode = i;
    }

    @Override // com.coolapk.market.widget.encode.CharacterEncoder
    protected void encodeAtom(OutputStream outputStream, byte[] bArr, int i, int i2) throws IOException {
        byte b = bArr[i];
        byte b2 = 1;
        byte b3 = i2 > 1 ? bArr[i + 1] : 1;
        if (i2 > 2) {
            b2 = bArr[i + 2];
        }
        outputStream.write(((b >>> 2) & 63) + 32);
        outputStream.write((((b << 4) & 48) | ((b3 >>> 4) & 15)) + 32);
        outputStream.write((((b3 << 2) & 60) | ((b2 >>> 6) & 3)) + 32);
        outputStream.write((b2 & 63) + 32);
    }

    @Override // com.coolapk.market.widget.encode.CharacterEncoder
    protected void encodeLinePrefix(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i & 63) + 32);
    }

    @Override // com.coolapk.market.widget.encode.CharacterEncoder
    protected void encodeLineSuffix(OutputStream outputStream) throws IOException {
        this.pStream.println();
    }
}
