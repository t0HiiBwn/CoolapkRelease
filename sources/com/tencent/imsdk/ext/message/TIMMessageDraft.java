package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.TIMElem;
import java.util.ArrayList;
import java.util.List;

public class TIMMessageDraft {
    private List<TIMElem> elems = new ArrayList();
    private long timestamp;
    private byte[] userDefinedData;

    public List<TIMElem> getElems() {
        return this.elems;
    }

    public void addElem(TIMElem tIMElem) {
        this.elems.add(tIMElem);
    }

    public byte[] getUserDefinedData() {
        return this.userDefinedData;
    }

    public void setUserDefinedData(byte[] bArr) {
        this.userDefinedData = bArr;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    protected void setTimestamp(long j) {
        this.timestamp = j;
    }
}
