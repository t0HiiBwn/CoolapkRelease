package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_MallInfo  reason: invalid class name */
abstract class C$$AutoValue_MallInfo extends MallInfo {
    private final String id;
    private final String mallDomain;
    private final String mallLogo;
    private final String mallTitle;
    private final String name;

    C$$AutoValue_MallInfo(String str, String str2, String str3, String str4, String str5) {
        this.id = str;
        this.mallTitle = str2;
        this.name = str3;
        this.mallLogo = str4;
        this.mallDomain = str5;
    }

    @Override // com.coolapk.market.model.MallInfo
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.MallInfo
    @SerializedName("mall_title")
    public String getMallTitle() {
        return this.mallTitle;
    }

    @Override // com.coolapk.market.model.MallInfo
    @SerializedName("name")
    public String getName() {
        return this.name;
    }

    @Override // com.coolapk.market.model.MallInfo
    @SerializedName("mall_logo")
    public String getMallLogo() {
        return this.mallLogo;
    }

    @Override // com.coolapk.market.model.MallInfo
    @SerializedName("mall_domain")
    public String getMallDomain() {
        return this.mallDomain;
    }

    @Override // java.lang.Object
    public String toString() {
        return "MallInfo{id=" + this.id + ", mallTitle=" + this.mallTitle + ", name=" + this.name + ", mallLogo=" + this.mallLogo + ", mallDomain=" + this.mallDomain + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MallInfo)) {
            return false;
        }
        MallInfo mallInfo = (MallInfo) obj;
        String str = this.id;
        if (str != null ? str.equals(mallInfo.getId()) : mallInfo.getId() == null) {
            String str2 = this.mallTitle;
            if (str2 != null ? str2.equals(mallInfo.getMallTitle()) : mallInfo.getMallTitle() == null) {
                String str3 = this.name;
                if (str3 != null ? str3.equals(mallInfo.getName()) : mallInfo.getName() == null) {
                    String str4 = this.mallLogo;
                    if (str4 != null ? str4.equals(mallInfo.getMallLogo()) : mallInfo.getMallLogo() == null) {
                        String str5 = this.mallDomain;
                        if (str5 == null) {
                            if (mallInfo.getMallDomain() == null) {
                                return true;
                            }
                        } else if (str5.equals(mallInfo.getMallDomain())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.mallTitle;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.name;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.mallLogo;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.mallDomain;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 ^ i;
    }
}
