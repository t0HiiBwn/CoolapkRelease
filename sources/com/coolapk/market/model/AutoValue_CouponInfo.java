package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_CouponInfo extends C$AutoValue_CouponInfo {
    public static final Parcelable.Creator<AutoValue_CouponInfo> CREATOR = new Parcelable.Creator<AutoValue_CouponInfo>() {
        /* class com.coolapk.market.model.AutoValue_CouponInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_CouponInfo createFromParcel(Parcel parcel) {
            return new AutoValue_CouponInfo(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 1);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_CouponInfo[] newArray(int i) {
            return new AutoValue_CouponInfo[i];
        }
    };

    AutoValue_CouponInfo(String str, String str2, String str3, String str4, int i, long j, long j2, String str5, boolean z) {
        super(str, str2, str3, str4, i, j, j2, str5, z);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getAdApplink() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAdApplink());
        }
        if (getAdH5url() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAdH5url());
        }
        if (getAdText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAdText());
        }
        if (getCouponId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCouponId());
        }
        parcel.writeInt(getCouponType());
        parcel.writeLong(getStartTime());
        parcel.writeLong(getEndTime());
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        parcel.writeInt(getIsClicked() ? 1 : 0);
    }
}
