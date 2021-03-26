package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMCustomElem;

public class V2TIMCustomElem extends V2TIMElem {
    private byte[] data;
    private String description;
    private byte[] extension;

    public byte[] getData() {
        if (getTIMMessage() == null || getTIMElem() == null) {
            return this.data;
        }
        return ((TIMCustomElem) getTIMElem()).getData();
    }

    public void setData(byte[] bArr) {
        if (getTIMMessage() == null || getTIMElem() == null) {
            this.data = bArr;
        } else {
            ((TIMCustomElem) getTIMElem()).setData(bArr);
        }
    }

    public String getDescription() {
        if (getTIMMessage() == null || getTIMElem() == null) {
            return this.description;
        }
        return ((TIMCustomElem) getTIMElem()).getDesc();
    }

    public void setDescription(String str) {
        if (getTIMMessage() == null || getTIMElem() == null) {
            this.description = str;
        } else {
            ((TIMCustomElem) getTIMElem()).setDesc(str);
        }
    }

    public byte[] getExtension() {
        if (getTIMMessage() == null || getTIMElem() == null) {
            return this.extension;
        }
        return ((TIMCustomElem) getTIMElem()).getExt();
    }

    public void setExtension(byte[] bArr) {
        if (getTIMMessage() == null || getTIMElem() == null) {
            this.extension = bArr;
        } else {
            ((TIMCustomElem) getTIMElem()).setExt(bArr);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        byte[] data2 = getData();
        String str = "";
        String str2 = data2 != null ? new String(data2) : str;
        String description2 = getDescription() != null ? getDescription() : str;
        if (getExtension() != null) {
            str = new String(getExtension());
        }
        sb.append("V2TIMCustomElem--->");
        sb.append("data2String:");
        sb.append(str2);
        sb.append(", description:");
        sb.append(description2);
        sb.append(", extension2String:");
        sb.append(str);
        return sb.toString();
    }
}
