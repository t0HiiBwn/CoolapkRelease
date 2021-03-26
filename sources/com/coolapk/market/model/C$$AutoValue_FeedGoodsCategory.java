package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_FeedGoodsCategory  reason: invalid class name */
abstract class C$$AutoValue_FeedGoodsCategory extends FeedGoodsCategory {
    private final long createTime;
    private final String createUid;
    private final int displayOrder;
    private final String goodsCount;
    private final long id;
    private final String keyWords;
    private final String logo;
    private final String title;
    private final long updateTime;
    private final String updateUid;

    C$$AutoValue_FeedGoodsCategory(long j, int i, String str, String str2, String str3, String str4, long j2, String str5, long j3, String str6) {
        this.id = j;
        this.displayOrder = i;
        this.goodsCount = str;
        this.logo = str2;
        Objects.requireNonNull(str3, "Null title");
        this.title = str3;
        this.keyWords = str4;
        this.createTime = j2;
        Objects.requireNonNull(str5, "Null createUid");
        this.createUid = str5;
        this.updateTime = j3;
        Objects.requireNonNull(str6, "Null updateUid");
        this.updateUid = str6;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("id")
    public long getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("display_order")
    public int getDisplayOrder() {
        return this.displayOrder;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("goods_count")
    public String getGoodsCount() {
        return this.goodsCount;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("log")
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("keywords")
    public String getKeyWords() {
        return this.keyWords;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("create_time")
    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("create_uid")
    public String getCreateUid() {
        return this.createUid;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("update_time")
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.coolapk.market.model.FeedGoodsCategory
    @SerializedName("update_uid")
    public String getUpdateUid() {
        return this.updateUid;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FeedGoodsCategory{id=" + this.id + ", displayOrder=" + this.displayOrder + ", goodsCount=" + this.goodsCount + ", logo=" + this.logo + ", title=" + this.title + ", keyWords=" + this.keyWords + ", createTime=" + this.createTime + ", createUid=" + this.createUid + ", updateTime=" + this.updateTime + ", updateUid=" + this.updateUid + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedGoodsCategory)) {
            return false;
        }
        FeedGoodsCategory feedGoodsCategory = (FeedGoodsCategory) obj;
        if (this.id != feedGoodsCategory.getId() || this.displayOrder != feedGoodsCategory.getDisplayOrder() || ((str = this.goodsCount) != null ? !str.equals(feedGoodsCategory.getGoodsCount()) : feedGoodsCategory.getGoodsCount() != null) || ((str2 = this.logo) != null ? !str2.equals(feedGoodsCategory.getLogo()) : feedGoodsCategory.getLogo() != null) || !this.title.equals(feedGoodsCategory.getTitle()) || ((str3 = this.keyWords) != null ? !str3.equals(feedGoodsCategory.getKeyWords()) : feedGoodsCategory.getKeyWords() != null) || this.createTime != feedGoodsCategory.getCreateTime() || !this.createUid.equals(feedGoodsCategory.getCreateUid()) || this.updateTime != feedGoodsCategory.getUpdateTime() || !this.updateUid.equals(feedGoodsCategory.getUpdateUid())) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        long j = this.id;
        int i = (this.displayOrder ^ (((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) * 1000003)) * 1000003;
        String str = this.goodsCount;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.logo;
        int hashCode2 = (((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.title.hashCode()) * 1000003;
        String str3 = this.keyWords;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        long j2 = this.createTime;
        int hashCode3 = this.createUid.hashCode();
        long j3 = this.updateTime;
        return this.updateUid.hashCode() ^ (((int) (((long) ((hashCode3 ^ (((int) (((long) ((hashCode2 ^ i2) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003)) * 1000003)) ^ (j3 ^ (j3 >>> 32)))) * 1000003);
    }
}
