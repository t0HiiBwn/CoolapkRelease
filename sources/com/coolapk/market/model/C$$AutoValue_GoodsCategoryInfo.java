package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_GoodsCategoryInfo  reason: invalid class name */
abstract class C$$AutoValue_GoodsCategoryInfo extends GoodsCategoryInfo {
    private final String catId;
    private final String catTitle;

    C$$AutoValue_GoodsCategoryInfo(String str, String str2) {
        Objects.requireNonNull(str, "Null catId");
        this.catId = str;
        Objects.requireNonNull(str2, "Null catTitle");
        this.catTitle = str2;
    }

    @Override // com.coolapk.market.model.GoodsCategoryInfo
    @SerializedName("cat_id")
    public String getCatId() {
        return this.catId;
    }

    @Override // com.coolapk.market.model.GoodsCategoryInfo
    @SerializedName("cat_title")
    public String getCatTitle() {
        return this.catTitle;
    }

    @Override // java.lang.Object
    public String toString() {
        return "GoodsCategoryInfo{catId=" + this.catId + ", catTitle=" + this.catTitle + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoodsCategoryInfo)) {
            return false;
        }
        GoodsCategoryInfo goodsCategoryInfo = (GoodsCategoryInfo) obj;
        if (!this.catId.equals(goodsCategoryInfo.getCatId()) || !this.catTitle.equals(goodsCategoryInfo.getCatTitle())) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.catId.hashCode() ^ 1000003) * 1000003) ^ this.catTitle.hashCode();
    }
}
