package com.tencent.imsdk;

public class TIMFaceElem extends TIMElem {
    private byte[] data;
    private int index;

    public TIMFaceElem() {
        this.type = TIMElemType.Face;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }
}
