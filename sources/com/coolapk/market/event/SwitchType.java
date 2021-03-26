package com.coolapk.market.event;

import android.text.TextUtils;

public class SwitchType {
    private String currentTag = "";
    private String switchType = "recommend";

    public void setCurrentTag(String str) {
        this.currentTag = str;
    }

    public String getCurrentTag() {
        return this.currentTag;
    }

    public String getType() {
        return !TextUtils.isEmpty(this.switchType) ? this.switchType : "recommend";
    }

    public void setType(String str) {
        this.switchType = str;
    }

    public boolean isRecommendList() {
        return TextUtils.equals(this.switchType, "recommend") || TextUtils.equals(this.switchType, "splash");
    }
}
