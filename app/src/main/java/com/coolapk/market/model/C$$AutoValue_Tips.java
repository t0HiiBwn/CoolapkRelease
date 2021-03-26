package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_Tips  reason: invalid class name */
abstract class C$$AutoValue_Tips extends Tips {
    private final String buttonName;
    private final int closable;
    private final String logo;
    private final String title;
    private final String url;

    C$$AutoValue_Tips(String str, String str2, String str3, String str4, int i) {
        this.title = str;
        this.buttonName = str2;
        this.url = str3;
        this.logo = str4;
        this.closable = i;
    }

    @Override // com.coolapk.market.model.Tips
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Tips
    @SerializedName("buttonName")
    public String getButtonName() {
        return this.buttonName;
    }

    @Override // com.coolapk.market.model.Tips
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Tips
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.Tips
    @SerializedName("closable")
    public int getClosable() {
        return this.closable;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Tips{title=" + this.title + ", buttonName=" + this.buttonName + ", url=" + this.url + ", logo=" + this.logo + ", closable=" + this.closable + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tips)) {
            return false;
        }
        Tips tips = (Tips) obj;
        String str = this.title;
        if (str != null ? str.equals(tips.getTitle()) : tips.getTitle() == null) {
            String str2 = this.buttonName;
            if (str2 != null ? str2.equals(tips.getButtonName()) : tips.getButtonName() == null) {
                String str3 = this.url;
                if (str3 != null ? str3.equals(tips.getUrl()) : tips.getUrl() == null) {
                    String str4 = this.logo;
                    if (str4 != null ? str4.equals(tips.getLogo()) : tips.getLogo() == null) {
                        if (this.closable == tips.getClosable()) {
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
        String str = this.title;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.buttonName;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.url;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.logo;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((hashCode3 ^ i) * 1000003) ^ this.closable;
    }
}
