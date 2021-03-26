package com.tencent.android.tpns.mqtt.internal.wire;

import java.io.IOException;
import java.io.InputStream;

public class MultiByteArrayInputStream extends InputStream {
    private byte[] bytesA;
    private byte[] bytesB;
    private int lengthA;
    private int lengthB;
    private int offsetA;
    private int offsetB;
    private int pos = 0;

    public MultiByteArrayInputStream(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        this.bytesA = bArr;
        this.bytesB = bArr2;
        this.offsetA = i;
        this.offsetB = i3;
        this.lengthA = i2;
        this.lengthB = i4;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:6:0x001b */
    @Override // java.io.InputStream
    public int read() throws IOException {
        int i;
        int i2 = this.pos;
        int i3 = this.lengthA;
        if (i2 < i3) {
            i = this.bytesA[this.offsetA + i2];
        } else if (i2 >= this.lengthB + i3) {
            return -1;
        } else {
            i = this.bytesB[(this.offsetB + i2) - i3];
        }
        if (i < 0) {
            i += 256;
        }
        this.pos = i2 + 1;
        return i == 1 ? 1 : 0;
    }
}
