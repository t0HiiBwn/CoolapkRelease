package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMTextElem;

public class V2TIMTextElem extends V2TIMElem {
    private String text;

    public String getText() {
        if (getTIMMessage() == null || getTIMElem() == null) {
            return this.text;
        }
        return ((TIMTextElem) getTIMElem()).getText();
    }

    public void setText(String str) {
        if (getTIMMessage() == null || getTIMElem() == null) {
            this.text = str;
        } else {
            ((TIMTextElem) getTIMElem()).setText(str);
        }
    }

    public String toString() {
        return "V2TIMTextElem--->text:" + getText();
    }
}
