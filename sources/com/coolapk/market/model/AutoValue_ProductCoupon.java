package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_ProductCoupon extends C$AutoValue_ProductCoupon {
    public static final Parcelable.Creator<AutoValue_ProductCoupon> CREATOR = new Parcelable.Creator<AutoValue_ProductCoupon>() {
        /* class com.coolapk.market.model.AutoValue_ProductCoupon.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_ProductCoupon createFromParcel(Parcel parcel) {
            return new AutoValue_ProductCoupon(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_ProductCoupon[] newArray(int i) {
            return new AutoValue_ProductCoupon[i];
        }
    };

    AutoValue_ProductCoupon(String str, String str2, String str3, String str4, String str5, String str6, List<String> list) {
        super(str, str2, str3, str4, str5, str6, list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getCouponName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCouponName());
        }
        if (getWorthMoney() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getWorthMoney());
        }
        if (getPrice() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPrice());
        }
        if (getUseCouponPrice() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUseCouponPrice());
        }
        if (getExpireDate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExpireDate());
        }
        if (getOpenUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getOpenUrl());
        }
        parcel.writeList(getProductRows());
    }
}
