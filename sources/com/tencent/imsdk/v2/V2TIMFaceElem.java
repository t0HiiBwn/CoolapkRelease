package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMFaceElem;

public class V2TIMFaceElem extends V2TIMElem {
    public int getIndex() {
        if (getTIMElem() == null) {
            return 0;
        }
        return ((TIMFaceElem) getTIMElem()).getIndex();
    }

    public byte[] getData() {
        if (getTIMElem() == null) {
            return null;
        }
        return ((TIMFaceElem) getTIMElem()).getData();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V2TIMFaceElem--->");
        sb.append("index:");
        sb.append(getIndex());
        sb.append(", has data:");
        sb.append(getData() == null ? "false" : "true");
        return sb.toString();
    }
}
