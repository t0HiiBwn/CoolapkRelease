package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$$AutoValue_ProductCoupon;
import com.coolapk.market.model.C$AutoValue_ProductCoupon;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class ProductCoupon implements Parcelable {

    public static abstract class Builder {
        public abstract ProductCoupon build();

        public abstract Builder setCouponName(String str);

        public abstract Builder setExpireDate(String str);

        public abstract Builder setOpenUrl(String str);

        public abstract Builder setPrice(String str);

        public abstract Builder setProductRows(List<String> list);

        public abstract Builder setUseCouponPrice(String str);

        public abstract Builder setWorthMoney(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("coupon_name")
    public abstract String getCouponName();

    @SerializedName("expire_time")
    public abstract String getExpireDate();

    @SerializedName("open_url")
    public abstract String getOpenUrl();

    public abstract String getPrice();

    public abstract List<String> getProductRows();

    public abstract String getUseCouponPrice();

    @SerializedName("worth_money")
    public abstract String getWorthMoney();

    public static TypeAdapter<ProductCoupon> typeAdapter(Gson gson) {
        return new C$AutoValue_ProductCoupon.GsonTypeAdapter(gson);
    }

    public static Builder builder(ProductCoupon productCoupon) {
        return new C$$AutoValue_ProductCoupon.Builder(productCoupon);
    }
}
