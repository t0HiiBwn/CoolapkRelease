package com.coolapk.market.widget.encode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

public abstract class CharacterEncoder {
    protected PrintStream pStream;

    protected abstract int bytesPerAtom();

    protected abstract int bytesPerLine();

    protected abstract void encodeAtom(OutputStream outputStream, byte[] bArr, int i, int i2) throws IOException;

    protected void encodeBufferSuffix(OutputStream outputStream) throws IOException {
    }

    protected void encodeLinePrefix(OutputStream outputStream, int i) throws IOException {
    }

    protected void encodeBufferPrefix(OutputStream outputStream) throws IOException {
        this.pStream = new PrintStream(outputStream);
    }

    protected void encodeLineSuffix(OutputStream outputStream) throws IOException {
        this.pStream.println();
    }

    protected int readFully(InputStream inputStream, byte[] bArr) throws IOException {
        for (int i = 0; i < bArr.length; i++) {
            int read = inputStream.read();
            if (read == -1) {
                return i;
            }
            bArr[i] = (byte) read;
        }
        return bArr.length;
    }

    public void encode(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[bytesPerLine()];
        encodeBufferPrefix(outputStream);
        while (true) {
            int readFully = readFully(inputStream, bArr);
            if (readFully == 0) {
                break;
            }
            encodeLinePrefix(outputStream, readFully);
            int i = 0;
            while (i < readFully) {
                if (bytesPerAtom() + i <= readFully) {
                    encodeAtom(outputStream, bArr, i, bytesPerAtom());
                } else {
                    encodeAtom(outputStream, bArr, i, readFully - i);
                }
                i += bytesPerAtom();
            }
            if (readFully < bytesPerLine()) {
                break;
            }
            encodeLineSuffix(outputStream);
        }
        encodeBufferSuffix(outputStream);
    }

    public void encode(byte[] bArr, OutputStream outputStream) throws IOException {
        encode(new ByteArrayInputStream(bArr), outputStream);
    }

    public String encode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encode(new ByteArrayInputStream(bArr), byteArrayOutputStream);
            return byteArrayOutputStream.toString("8859_1");
        } catch (Exception unused) {
            throw new Error("CharacterEncoder.encode internal error");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023  */
    private byte[] getBytes(ByteBuffer byteBuffer) {
        byte[] bArr;
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            if (bArr.length == byteBuffer.capacity() && bArr.length == byteBuffer.remaining()) {
                byteBuffer.position(byteBuffer.limit());
                if (bArr == null) {
                    return bArr;
                }
                byte[] bArr2 = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr2);
                return bArr2;
            }
        }
        bArr = null;
        if (bArr == null) {
        }
    }

    public void encode(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        encode(getBytes(byteBuffer), outputStream);
    }

    public String encode(ByteBuffer byteBuffer) {
        return encode(getBytes(byteBuffer));
    }

    public void encodeBuffer(InputStream inputStream, OutputStream outputStream) throws IOException {
        int readFully;
        byte[] bArr = new byte[bytesPerLine()];
        encodeBufferPrefix(outputStream);
        do {
            readFully = readFully(inputStream, bArr);
            if (readFully == 0) {
                break;
            }
            encodeLinePrefix(outputStream, readFully);
            int i = 0;
            while (i < readFully) {
                if (bytesPerAtom() + i <= readFully) {
                    encodeAtom(outputStream, bArr, i, bytesPerAtom());
                } else {
                    encodeAtom(outputStream, bArr, i, readFully - i);
                }
                i += bytesPerAtom();
            }
            encodeLineSuffix(outputStream);
        } while (readFully >= bytesPerLine());
        encodeBufferSuffix(outputStream);
    }

    public void encodeBuffer(byte[] bArr, OutputStream outputStream) throws IOException {
        encodeBuffer(new ByteArrayInputStream(bArr), outputStream);
    }

    public String encodeBuffer(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encodeBuffer(new ByteArrayInputStream(bArr), byteArrayOutputStream);
            return byteArrayOutputStream.toString();
        } catch (Exception unused) {
            throw new Error("CharacterEncoder.encodeBuffer internal error");
        }
    }

    public void encodeBuffer(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        encodeBuffer(getBytes(byteBuffer), outputStream);
    }

    public String encodeBuffer(ByteBuffer byteBuffer) {
        return encodeBuffer(getBytes(byteBuffer));
    }
}
