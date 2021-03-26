package com.coolapk.market.model;

import com.coolapk.market.model.FeedGoodsAction;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_FeedGoodsAction  reason: invalid class name */
abstract class C$$AutoValue_FeedGoodsAction extends FeedGoodsAction {
    private final int categoryId;
    private final String categoryName;
    private final int hotNum;
    private final String mallName;
    private final String price;
    private final int recommendStatus;
    private final String sellUrl;
    private final int star;
    private final int status;
    private final int wishBuyStatus;

    C$$AutoValue_FeedGoodsAction(int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, String str3, String str4) {
        this.star = i;
        this.wishBuyStatus = i2;
        this.categoryId = i3;
        this.hotNum = i4;
        this.status = i5;
        this.recommendStatus = i6;
        this.categoryName = str;
        this.sellUrl = str2;
        this.price = str3;
        Objects.requireNonNull(str4, "Null mallName");
        this.mallName = str4;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    public int getStar() {
        return this.star;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    @SerializedName("wish_buy_status")
    public int getWishBuyStatus() {
        return this.wishBuyStatus;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    @SerializedName("category_id")
    public int getCategoryId() {
        return this.categoryId;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    @SerializedName("hot_num")
    public int getHotNum() {
        return this.hotNum;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    @SerializedName("status")
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    @SerializedName("recommend_status")
    public int getRecommendStatus() {
        return this.recommendStatus;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    @SerializedName("category_name")
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    @SerializedName("sell_url")
    public String getSellUrl() {
        return this.sellUrl;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    public String getPrice() {
        return this.price;
    }

    @Override // com.coolapk.market.model.FeedGoodsAction
    @SerializedName("mall_name")
    public String getMallName() {
        return this.mallName;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FeedGoodsAction{star=" + this.star + ", wishBuyStatus=" + this.wishBuyStatus + ", categoryId=" + this.categoryId + ", hotNum=" + this.hotNum + ", status=" + this.status + ", recommendStatus=" + this.recommendStatus + ", categoryName=" + this.categoryName + ", sellUrl=" + this.sellUrl + ", price=" + this.price + ", mallName=" + this.mallName + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedGoodsAction)) {
            return false;
        }
        FeedGoodsAction feedGoodsAction = (FeedGoodsAction) obj;
        if (this.star == feedGoodsAction.getStar() && this.wishBuyStatus == feedGoodsAction.getWishBuyStatus() && this.categoryId == feedGoodsAction.getCategoryId() && this.hotNum == feedGoodsAction.getHotNum() && this.status == feedGoodsAction.getStatus() && this.recommendStatus == feedGoodsAction.getRecommendStatus() && ((str = this.categoryName) != null ? str.equals(feedGoodsAction.getCategoryName()) : feedGoodsAction.getCategoryName() == null) && ((str2 = this.sellUrl) != null ? str2.equals(feedGoodsAction.getSellUrl()) : feedGoodsAction.getSellUrl() == null) && ((str3 = this.price) != null ? str3.equals(feedGoodsAction.getPrice()) : feedGoodsAction.getPrice() == null) && this.mallName.equals(feedGoodsAction.getMallName())) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = (((((((((((this.star ^ 1000003) * 1000003) ^ this.wishBuyStatus) * 1000003) ^ this.categoryId) * 1000003) ^ this.hotNum) * 1000003) ^ this.status) * 1000003) ^ this.recommendStatus) * 1000003;
        String str = this.categoryName;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.sellUrl;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.price;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode2 ^ i2) * 1000003) ^ this.mallName.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_FeedGoodsAction$Builder */
    /* compiled from: $$AutoValue_FeedGoodsAction */
    static final class Builder extends FeedGoodsAction.Builder {
        private Integer categoryId;
        private String categoryName;
        private Integer hotNum;
        private String mallName;
        private String price;
        private Integer recommendStatus;
        private String sellUrl;
        private Integer star;
        private Integer status;
        private Integer wishBuyStatus;

        Builder() {
        }

        Builder(FeedGoodsAction feedGoodsAction) {
            this.star = Integer.valueOf(feedGoodsAction.getStar());
            this.wishBuyStatus = Integer.valueOf(feedGoodsAction.getWishBuyStatus());
            this.categoryId = Integer.valueOf(feedGoodsAction.getCategoryId());
            this.hotNum = Integer.valueOf(feedGoodsAction.getHotNum());
            this.status = Integer.valueOf(feedGoodsAction.getStatus());
            this.recommendStatus = Integer.valueOf(feedGoodsAction.getRecommendStatus());
            this.categoryName = feedGoodsAction.getCategoryName();
            this.sellUrl = feedGoodsAction.getSellUrl();
            this.price = feedGoodsAction.getPrice();
            this.mallName = feedGoodsAction.getMallName();
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder star(int i) {
            this.star = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder wishBuyStatus(int i) {
            this.wishBuyStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder categoryId(int i) {
            this.categoryId = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder hotNum(int i) {
            this.hotNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder status(int i) {
            this.status = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder recommendStatus(int i) {
            this.recommendStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder categoryName(String str) {
            this.categoryName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder sellUrl(String str) {
            this.sellUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder price(String str) {
            this.price = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction.Builder mallName(String str) {
            this.mallName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedGoodsAction.Builder
        public FeedGoodsAction build() {
            String str = "";
            if (this.star == null) {
                str = str + " star";
            }
            if (this.wishBuyStatus == null) {
                str = str + " wishBuyStatus";
            }
            if (this.categoryId == null) {
                str = str + " categoryId";
            }
            if (this.hotNum == null) {
                str = str + " hotNum";
            }
            if (this.status == null) {
                str = str + " status";
            }
            if (this.recommendStatus == null) {
                str = str + " recommendStatus";
            }
            if (this.mallName == null) {
                str = str + " mallName";
            }
            if (str.isEmpty()) {
                return new AutoValue_FeedGoodsAction(this.star.intValue(), this.wishBuyStatus.intValue(), this.categoryId.intValue(), this.hotNum.intValue(), this.status.intValue(), this.recommendStatus.intValue(), this.categoryName, this.sellUrl, this.price, this.mallName);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
