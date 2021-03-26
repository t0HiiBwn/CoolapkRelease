package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_ProductConfig  reason: invalid class name */
abstract class C$$AutoValue_ProductConfig extends ProductConfig {
    private final String CPU;
    private final String RAM;
    private final String configData;
    private final String fingerpointType;
    private final String id;
    private final String keywords;
    private final String phoneMaterial;
    private final float price;
    private final String productId;
    private final String releaseTime;
    private final String screenMaterial;
    private final String title;
    private final String zolId;

    C$$AutoValue_ProductConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, float f, String str11, String str12) {
        this.id = str;
        this.productId = str2;
        this.zolId = str3;
        this.title = str4;
        this.screenMaterial = str5;
        this.CPU = str6;
        this.releaseTime = str7;
        this.RAM = str8;
        this.fingerpointType = str9;
        this.phoneMaterial = str10;
        this.price = f;
        this.keywords = str11;
        this.configData = str12;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("product_id")
    public String getProductId() {
        return this.productId;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("zol_id")
    public String getZolId() {
        return this.zolId;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("screen_material")
    public String getScreenMaterial() {
        return this.screenMaterial;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("cpu")
    public String getCPU() {
        return this.CPU;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("release_time")
    public String getReleaseTime() {
        return this.releaseTime;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("ram")
    public String getRAM() {
        return this.RAM;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("fingerpoint_type")
    public String getFingerpointType() {
        return this.fingerpointType;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("phone_material")
    public String getPhoneMaterial() {
        return this.phoneMaterial;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("price")
    public float getPrice() {
        return this.price;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("keywords")
    public String getKeywords() {
        return this.keywords;
    }

    @Override // com.coolapk.market.model.ProductConfig
    @SerializedName("config_data")
    public String getConfigData() {
        return this.configData;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ProductConfig{id=" + this.id + ", productId=" + this.productId + ", zolId=" + this.zolId + ", title=" + this.title + ", screenMaterial=" + this.screenMaterial + ", CPU=" + this.CPU + ", releaseTime=" + this.releaseTime + ", RAM=" + this.RAM + ", fingerpointType=" + this.fingerpointType + ", phoneMaterial=" + this.phoneMaterial + ", price=" + this.price + ", keywords=" + this.keywords + ", configData=" + this.configData + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductConfig)) {
            return false;
        }
        ProductConfig productConfig = (ProductConfig) obj;
        String str2 = this.id;
        if (str2 != null ? str2.equals(productConfig.getId()) : productConfig.getId() == null) {
            String str3 = this.productId;
            if (str3 != null ? str3.equals(productConfig.getProductId()) : productConfig.getProductId() == null) {
                String str4 = this.zolId;
                if (str4 != null ? str4.equals(productConfig.getZolId()) : productConfig.getZolId() == null) {
                    String str5 = this.title;
                    if (str5 != null ? str5.equals(productConfig.getTitle()) : productConfig.getTitle() == null) {
                        String str6 = this.screenMaterial;
                        if (str6 != null ? str6.equals(productConfig.getScreenMaterial()) : productConfig.getScreenMaterial() == null) {
                            String str7 = this.CPU;
                            if (str7 != null ? str7.equals(productConfig.getCPU()) : productConfig.getCPU() == null) {
                                String str8 = this.releaseTime;
                                if (str8 != null ? str8.equals(productConfig.getReleaseTime()) : productConfig.getReleaseTime() == null) {
                                    String str9 = this.RAM;
                                    if (str9 != null ? str9.equals(productConfig.getRAM()) : productConfig.getRAM() == null) {
                                        String str10 = this.fingerpointType;
                                        if (str10 != null ? str10.equals(productConfig.getFingerpointType()) : productConfig.getFingerpointType() == null) {
                                            String str11 = this.phoneMaterial;
                                            if (str11 != null ? str11.equals(productConfig.getPhoneMaterial()) : productConfig.getPhoneMaterial() == null) {
                                                if (Float.floatToIntBits(this.price) == Float.floatToIntBits(productConfig.getPrice()) && ((str = this.keywords) != null ? str.equals(productConfig.getKeywords()) : productConfig.getKeywords() == null)) {
                                                    String str12 = this.configData;
                                                    if (str12 == null) {
                                                        if (productConfig.getConfigData() == null) {
                                                            return true;
                                                        }
                                                    } else if (str12.equals(productConfig.getConfigData())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
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
        String str2 = this.productId;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.zolId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.title;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.screenMaterial;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.CPU;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.releaseTime;
        int hashCode7 = (hashCode6 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.RAM;
        int hashCode8 = (hashCode7 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.fingerpointType;
        int hashCode9 = (hashCode8 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.phoneMaterial;
        int hashCode10 = (((hashCode9 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003) ^ Float.floatToIntBits(this.price)) * 1000003;
        String str11 = this.keywords;
        int hashCode11 = (hashCode10 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.configData;
        if (str12 != null) {
            i = str12.hashCode();
        }
        return hashCode11 ^ i;
    }
}
