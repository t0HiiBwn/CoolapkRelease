package com.coolapk.market.model;

import com.coolapk.market.model.IgnoreInfo;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_IgnoreInfo  reason: invalid class name */
abstract class C$AutoValue_IgnoreInfo extends IgnoreInfo {
    private final String packageName;
    private final int type;
    private final int versionCode;

    C$AutoValue_IgnoreInfo(int i, String str, int i2) {
        this.type = i;
        Objects.requireNonNull(str, "Null packageName");
        this.packageName = str;
        this.versionCode = i2;
    }

    @Override // com.coolapk.market.model.IgnoreInfo
    public int getType() {
        return this.type;
    }

    @Override // com.coolapk.market.model.IgnoreInfo
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.IgnoreInfo
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // java.lang.Object
    public String toString() {
        return "IgnoreInfo{type=" + this.type + ", packageName=" + this.packageName + ", versionCode=" + this.versionCode + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IgnoreInfo)) {
            return false;
        }
        IgnoreInfo ignoreInfo = (IgnoreInfo) obj;
        if (this.type == ignoreInfo.getType() && this.packageName.equals(ignoreInfo.getPackageName()) && this.versionCode == ignoreInfo.getVersionCode()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((((this.type ^ 1000003) * 1000003) ^ this.packageName.hashCode()) * 1000003) ^ this.versionCode;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_IgnoreInfo$Builder */
    static final class Builder extends IgnoreInfo.Builder {
        private String packageName;
        private Integer type;
        private Integer versionCode;

        Builder() {
        }

        Builder(IgnoreInfo ignoreInfo) {
            this.type = Integer.valueOf(ignoreInfo.getType());
            this.packageName = ignoreInfo.getPackageName();
            this.versionCode = Integer.valueOf(ignoreInfo.getVersionCode());
        }

        @Override // com.coolapk.market.model.IgnoreInfo.Builder
        public IgnoreInfo.Builder type(int i) {
            this.type = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.IgnoreInfo.Builder
        public IgnoreInfo.Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IgnoreInfo.Builder
        public IgnoreInfo.Builder versionCode(int i) {
            this.versionCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.IgnoreInfo.Builder
        public IgnoreInfo build() {
            String str = "";
            if (this.type == null) {
                str = str + " type";
            }
            if (this.packageName == null) {
                str = str + " packageName";
            }
            if (this.versionCode == null) {
                str = str + " versionCode";
            }
            if (str.isEmpty()) {
                return new AutoValue_IgnoreInfo(this.type.intValue(), this.packageName, this.versionCode.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
