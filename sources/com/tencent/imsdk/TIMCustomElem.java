package com.tencent.imsdk;

public class TIMCustomElem extends TIMElem {
    byte[] data;
    private String desc;
    byte[] ext;
    byte[] sound;

    public TIMCustomElem() {
        this.type = TIMElemType.Custom;
    }

    public byte[] getData() {
        byte[] bArr = this.data;
        return bArr == null ? "".getBytes() : bArr;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    @Deprecated
    public String getDesc() {
        String str = this.desc;
        return str == null ? "" : str;
    }

    @Deprecated
    public void setDesc(String str) {
        this.desc = str;
    }

    @Deprecated
    public byte[] getExt() {
        byte[] bArr = this.ext;
        return bArr == null ? "".getBytes() : bArr;
    }

    @Deprecated
    public void setExt(byte[] bArr) {
        this.ext = bArr;
    }

    @Deprecated
    public byte[] getSound() {
        byte[] bArr = this.sound;
        return bArr == null ? "".getBytes() : bArr;
    }

    @Deprecated
    public void setSound(byte[] bArr) {
        this.sound = bArr;
    }
}
