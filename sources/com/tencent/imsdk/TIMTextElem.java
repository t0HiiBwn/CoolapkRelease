package com.tencent.imsdk;

public class TIMTextElem extends TIMElem {
    private String text;

    public TIMTextElem() {
        this.type = TIMElemType.Text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }
}
