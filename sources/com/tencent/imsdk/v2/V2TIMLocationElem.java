package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMLocationElem;

public class V2TIMLocationElem extends V2TIMElem {
    public String getDesc() {
        if (getTIMElem() == null) {
            return null;
        }
        return ((TIMLocationElem) getTIMElem()).getDesc();
    }

    public double getLongitude() {
        if (getTIMElem() == null) {
            return 0.0d;
        }
        return ((TIMLocationElem) getTIMElem()).getLongitude();
    }

    public double getLatitude() {
        if (getTIMElem() == null) {
            return 0.0d;
        }
        return ((TIMLocationElem) getTIMElem()).getLatitude();
    }

    public String toString() {
        return "V2TIMLocationElem--->longitude:" + getLongitude() + ", latitude:" + getLatitude() + ", desc:" + getDesc();
    }
}
