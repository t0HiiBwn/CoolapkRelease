package com.coolapk.market.model;

import com.coolapk.market.model.SimpleInfo;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_SimpleInfo  reason: invalid class name */
abstract class C$$AutoValue_SimpleInfo extends SimpleInfo {
    private final String icon;
    private final String message;
    private final String url;

    C$$AutoValue_SimpleInfo(String str, String str2, String str3) {
        this.icon = str;
        this.message = str2;
        this.url = str3;
    }

    @Override // com.coolapk.market.model.SimpleInfo
    @SerializedName("icon")
    public String getIcon() {
        return this.icon;
    }

    @Override // com.coolapk.market.model.SimpleInfo
    @SerializedName("message")
    public String getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.SimpleInfo
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // java.lang.Object
    public String toString() {
        return "SimpleInfo{icon=" + this.icon + ", message=" + this.message + ", url=" + this.url + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SimpleInfo)) {
            return false;
        }
        SimpleInfo simpleInfo = (SimpleInfo) obj;
        String str = this.icon;
        if (str != null ? str.equals(simpleInfo.getIcon()) : simpleInfo.getIcon() == null) {
            String str2 = this.message;
            if (str2 != null ? str2.equals(simpleInfo.getMessage()) : simpleInfo.getMessage() == null) {
                String str3 = this.url;
                if (str3 == null) {
                    if (simpleInfo.getUrl() == null) {
                        return true;
                    }
                } else if (str3.equals(simpleInfo.getUrl())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.icon;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.message;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.url;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_SimpleInfo$Builder */
    /* compiled from: $$AutoValue_SimpleInfo */
    static final class Builder extends SimpleInfo.Builder {
        private String icon;
        private String message;
        private String url;

        Builder() {
        }

        Builder(SimpleInfo simpleInfo) {
            this.icon = simpleInfo.getIcon();
            this.message = simpleInfo.getMessage();
            this.url = simpleInfo.getUrl();
        }

        @Override // com.coolapk.market.model.SimpleInfo.Builder
        public SimpleInfo.Builder setIcon(String str) {
            this.icon = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleInfo.Builder
        public SimpleInfo.Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleInfo.Builder
        public SimpleInfo.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleInfo.Builder
        public SimpleInfo build() {
            return new AutoValue_SimpleInfo(this.icon, this.message, this.url);
        }
    }
}
