package com.huawei.hms.adapter;

import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

class CoreBaseRequest implements IMessageEntity {
    @Packed
    private String jsonHeader;
    @Packed
    private String jsonObject;
    @Packed
    private Parcelable parcelable;

    public String getJsonHeader() {
        return this.jsonHeader;
    }

    public void setJsonHeader(String str) {
        this.jsonHeader = str;
    }

    public String getJsonObject() {
        return this.jsonObject;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public void setParcelable(Parcelable parcelable2) {
        this.parcelable = parcelable2;
    }

    public void setJsonObject(String str) {
        this.jsonObject = str;
    }
}
