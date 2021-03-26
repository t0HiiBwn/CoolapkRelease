package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_ProductSeries  reason: invalid class name */
abstract class C$$AutoValue_ProductSeries extends ProductSeries {
    private final int brandId;
    private final Long dateline;
    private final String description;
    private final int displayOrder;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final int productNum;
    private final List<Product> productRows;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_ProductSeries(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l2, Long l3, int i2, int i3, int i4, List<Product> list) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityTypeId = i;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.url = str5;
        this.description = str6;
        this.pic = str7;
        this.logo = str8;
        this.subTitle = str9;
        this.id = str10;
        this.extraData = str11;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.brandId = i2;
        this.displayOrder = i3;
        this.productNum = i4;
        Objects.requireNonNull(list, "Null productRows");
        this.productRows = list;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTemplate")
    public String getEntityTemplate() {
        return this.entityTemplate;
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return this.entityTypeId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityId")
    public String getEntityId() {
        return this.entityId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityFixed")
    public Integer getEntityFixed() {
        return this.entityFixed;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("extraData")
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public Long getDateline() {
        return this.dateline;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.ProductSeries
    @SerializedName("brand_id")
    public int getBrandId() {
        return this.brandId;
    }

    @Override // com.coolapk.market.model.ProductSeries
    @SerializedName("display_order")
    public int getDisplayOrder() {
        return this.displayOrder;
    }

    @Override // com.coolapk.market.model.ProductSeries
    @SerializedName("product_num")
    public int getProductNum() {
        return this.productNum;
    }

    @Override // com.coolapk.market.model.ProductSeries
    @SerializedName("productRows")
    public List<Product> getProductRows() {
        return this.productRows;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ProductSeries{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", brandId=" + this.brandId + ", displayOrder=" + this.displayOrder + ", productNum=" + this.productNum + ", productRows=" + this.productRows + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        Integer num;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Long l2;
        Long l3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductSeries)) {
            return false;
        }
        ProductSeries productSeries = (ProductSeries) obj;
        String str10 = this.entityTypeName;
        if (str10 != null ? str10.equals(productSeries.getEntityTypeName()) : productSeries.getEntityTypeName() == null) {
            String str11 = this.entityTemplate;
            if (str11 != null ? str11.equals(productSeries.getEntityTemplate()) : productSeries.getEntityTemplate() == null) {
                if (this.entityTypeId == productSeries.getEntityTypeId() && ((str = this.entityId) != null ? str.equals(productSeries.getEntityId()) : productSeries.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(productSeries.getEntityFixed()) : productSeries.getEntityFixed() == null) && ((str2 = this.title) != null ? str2.equals(productSeries.getTitle()) : productSeries.getTitle() == null) && ((str3 = this.url) != null ? str3.equals(productSeries.getUrl()) : productSeries.getUrl() == null) && ((str4 = this.description) != null ? str4.equals(productSeries.getDescription()) : productSeries.getDescription() == null) && ((str5 = this.pic) != null ? str5.equals(productSeries.getPic()) : productSeries.getPic() == null) && ((str6 = this.logo) != null ? str6.equals(productSeries.getLogo()) : productSeries.getLogo() == null) && ((str7 = this.subTitle) != null ? str7.equals(productSeries.getSubTitle()) : productSeries.getSubTitle() == null) && ((str8 = this.id) != null ? str8.equals(productSeries.getId()) : productSeries.getId() == null) && ((str9 = this.extraData) != null ? str9.equals(productSeries.getExtraData()) : productSeries.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(productSeries.getDateline()) : productSeries.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(productSeries.getLastUpdate()) : productSeries.getLastUpdate() == null) && this.brandId == productSeries.getBrandId() && this.displayOrder == productSeries.getDisplayOrder() && this.productNum == productSeries.getProductNum() && this.productRows.equals(productSeries.getProductRows())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.entityTypeId) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.title;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.url;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.description;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.pic;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.logo;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.subTitle;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.id;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.extraData;
        int hashCode12 = (hashCode11 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode13 = (hashCode12 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        if (l3 != null) {
            i = l3.hashCode();
        }
        return ((((((((hashCode13 ^ i) * 1000003) ^ this.brandId) * 1000003) ^ this.displayOrder) * 1000003) ^ this.productNum) * 1000003) ^ this.productRows.hashCode();
    }
}
