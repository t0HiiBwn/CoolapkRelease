package com.alibaba.fastjson.asm;

public class Label {
    static final int FORWARD_REFERENCE_HANDLE_MASK = 268435455;
    static final int FORWARD_REFERENCE_TYPE_MASK = -268435456;
    static final int FORWARD_REFERENCE_TYPE_SHORT = 268435456;
    static final int FORWARD_REFERENCE_TYPE_WIDE = 536870912;
    int inputStackTop;
    Label next;
    int outputStackMax;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int status;
    Label successor;

    void put(MethodWriter methodWriter, ByteVector byteVector, int i, boolean z) {
        if ((this.status & 2) == 0) {
            if (z) {
                addReference(i, byteVector.length, 536870912);
                byteVector.putInt(-1);
                return;
            }
            addReference(i, byteVector.length, 268435456);
            byteVector.putShort(-1);
        } else if (z) {
            byteVector.putInt(this.position - i);
        } else {
            byteVector.putShort(this.position - i);
        }
    }

    private void addReference(int i, int i2, int i3) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        int i4 = this.referenceCount;
        int[] iArr = this.srcAndRefPositions;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 6)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.srcAndRefPositions = iArr2;
        }
        int[] iArr3 = this.srcAndRefPositions;
        int i5 = this.referenceCount;
        int i6 = i5 + 1;
        this.referenceCount = i6;
        iArr3[i5] = i;
        this.referenceCount = i6 + 1;
        iArr3[i6] = i2 | i3;
    }

    void resolve(MethodWriter methodWriter, int i, byte[] bArr) {
        this.status |= 2;
        this.position = i;
        int i2 = 0;
        while (i2 < this.referenceCount) {
            int[] iArr = this.srcAndRefPositions;
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            int i6 = iArr[i3];
            int i7 = 268435455 & i6;
            int i8 = i - i4;
            if ((i6 & -268435456) == 268435456) {
                bArr[i7] = (byte) (i8 >>> 8);
                bArr[i7 + 1] = (byte) i8;
            } else {
                int i9 = i7 + 1;
                bArr[i7] = (byte) (i8 >>> 24);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (i8 >>> 16);
                bArr[i10] = (byte) (i8 >>> 8);
                bArr[i10 + 1] = (byte) i8;
            }
            i2 = i5;
        }
    }
}
