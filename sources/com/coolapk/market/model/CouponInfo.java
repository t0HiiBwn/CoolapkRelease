package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$$AutoValue_CouponInfo;
import com.coolapk.market.model.C$AutoValue_CouponInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class CouponInfo implements Parcelable {
    public static final int COUPON_TYPE_DEEP_LINK = 2;
    public static final int COUPON_TYPE_H5 = 1;

    public static abstract class Builder {
        public abstract CouponInfo build();

        public abstract Builder setAdApplink(String str);

        public abstract Builder setAdH5url(String str);

        public abstract Builder setAdText(String str);

        public abstract Builder setCouponId(String str);

        public abstract Builder setCouponType(int i);

        public abstract Builder setEndTime(long j);

        public abstract Builder setIsClicked(boolean z);

        public abstract Builder setStartTime(long j);

        public abstract Builder setTitle(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("ad_applink")
    public abstract String getAdApplink();

    @SerializedName("ad_h5url")
    public abstract String getAdH5url();

    @SerializedName("ad_text")
    public abstract String getAdText();

    public abstract String getCouponId();

    public abstract int getCouponType();

    @SerializedName("end_time")
    public abstract long getEndTime();

    @SerializedName("is_clicked")
    public abstract boolean getIsClicked();

    @SerializedName("start_time")
    public abstract long getStartTime();

    public abstract String getTitle();

    public static TypeAdapter<CouponInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_CouponInfo.GsonTypeAdapter(gson);
    }

    public static Builder builder(CouponInfo couponInfo) {
        return new C$$AutoValue_CouponInfo.Builder(couponInfo);
    }
}
