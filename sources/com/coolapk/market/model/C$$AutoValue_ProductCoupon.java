package com.coolapk.market.model;

import com.coolapk.market.model.ProductCoupon;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.coolapk.market.model.$$AutoValue_ProductCoupon  reason: invalid class name */
abstract class C$$AutoValue_ProductCoupon extends ProductCoupon {
    private final String couponName;
    private final String expireDate;
    private final String openUrl;
    private final String price;
    private final List<String> productRows;
    private final String useCouponPrice;
    private final String worthMoney;

    C$$AutoValue_ProductCoupon(String str, String str2, String str3, String str4, String str5, String str6, List<String> list) {
        this.couponName = str;
        this.worthMoney = str2;
        this.price = str3;
        this.useCouponPrice = str4;
        this.expireDate = str5;
        this.openUrl = str6;
        this.productRows = list;
    }

    @Override // com.coolapk.market.model.ProductCoupon
    @SerializedName("coupon_name")
    public String getCouponName() {
        return this.couponName;
    }

    @Override // com.coolapk.market.model.ProductCoupon
    @SerializedName("worth_money")
    public String getWorthMoney() {
        return this.worthMoney;
    }

    @Override // com.coolapk.market.model.ProductCoupon
    public String getPrice() {
        return this.price;
    }

    @Override // com.coolapk.market.model.ProductCoupon
    public String getUseCouponPrice() {
        return this.useCouponPrice;
    }

    @Override // com.coolapk.market.model.ProductCoupon
    @SerializedName("expire_time")
    public String getExpireDate() {
        return this.expireDate;
    }

    @Override // com.coolapk.market.model.ProductCoupon
    @SerializedName("open_url")
    public String getOpenUrl() {
        return this.openUrl;
    }

    @Override // com.coolapk.market.model.ProductCoupon
    public List<String> getProductRows() {
        return this.productRows;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ProductCoupon{couponName=" + this.couponName + ", worthMoney=" + this.worthMoney + ", price=" + this.price + ", useCouponPrice=" + this.useCouponPrice + ", expireDate=" + this.expireDate + ", openUrl=" + this.openUrl + ", productRows=" + this.productRows + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductCoupon)) {
            return false;
        }
        ProductCoupon productCoupon = (ProductCoupon) obj;
        String str = this.couponName;
        if (str != null ? str.equals(productCoupon.getCouponName()) : productCoupon.getCouponName() == null) {
            String str2 = this.worthMoney;
            if (str2 != null ? str2.equals(productCoupon.getWorthMoney()) : productCoupon.getWorthMoney() == null) {
                String str3 = this.price;
                if (str3 != null ? str3.equals(productCoupon.getPrice()) : productCoupon.getPrice() == null) {
                    String str4 = this.useCouponPrice;
                    if (str4 != null ? str4.equals(productCoupon.getUseCouponPrice()) : productCoupon.getUseCouponPrice() == null) {
                        String str5 = this.expireDate;
                        if (str5 != null ? str5.equals(productCoupon.getExpireDate()) : productCoupon.getExpireDate() == null) {
                            String str6 = this.openUrl;
                            if (str6 != null ? str6.equals(productCoupon.getOpenUrl()) : productCoupon.getOpenUrl() == null) {
                                List<String> list = this.productRows;
                                if (list == null) {
                                    if (productCoupon.getProductRows() == null) {
                                        return true;
                                    }
                                } else if (list.equals(productCoupon.getProductRows())) {
                                    return true;
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
        String str = this.couponName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.worthMoney;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.price;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.useCouponPrice;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.expireDate;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.openUrl;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        List<String> list = this.productRows;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode6 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_ProductCoupon$Builder */
    /* compiled from: $$AutoValue_ProductCoupon */
    static final class Builder extends ProductCoupon.Builder {
        private String couponName;
        private String expireDate;
        private String openUrl;
        private String price;
        private List<String> productRows;
        private String useCouponPrice;
        private String worthMoney;

        Builder() {
        }

        Builder(ProductCoupon productCoupon) {
            this.couponName = productCoupon.getCouponName();
            this.worthMoney = productCoupon.getWorthMoney();
            this.price = productCoupon.getPrice();
            this.useCouponPrice = productCoupon.getUseCouponPrice();
            this.expireDate = productCoupon.getExpireDate();
            this.openUrl = productCoupon.getOpenUrl();
            this.productRows = productCoupon.getProductRows();
        }

        @Override // com.coolapk.market.model.ProductCoupon.Builder
        public ProductCoupon.Builder setCouponName(String str) {
            this.couponName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ProductCoupon.Builder
        public ProductCoupon.Builder setWorthMoney(String str) {
            this.worthMoney = str;
            return this;
        }

        @Override // com.coolapk.market.model.ProductCoupon.Builder
        public ProductCoupon.Builder setPrice(String str) {
            this.price = str;
            return this;
        }

        @Override // com.coolapk.market.model.ProductCoupon.Builder
        public ProductCoupon.Builder setUseCouponPrice(String str) {
            this.useCouponPrice = str;
            return this;
        }

        @Override // com.coolapk.market.model.ProductCoupon.Builder
        public ProductCoupon.Builder setExpireDate(String str) {
            this.expireDate = str;
            return this;
        }

        @Override // com.coolapk.market.model.ProductCoupon.Builder
        public ProductCoupon.Builder setOpenUrl(String str) {
            this.openUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.ProductCoupon.Builder
        public ProductCoupon.Builder setProductRows(List<String> list) {
            this.productRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.ProductCoupon.Builder
        public ProductCoupon build() {
            return new AutoValue_ProductCoupon(this.couponName, this.worthMoney, this.price, this.useCouponPrice, this.expireDate, this.openUrl, this.productRows);
        }
    }
}
