package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_GoodsCategoryInfo extends C$AutoValue_GoodsCategoryInfo {
    public static final Parcelable.Creator<AutoValue_GoodsCategoryInfo> CREATOR = new Parcelable.Creator<AutoValue_GoodsCategoryInfo>() {
        /* class com.coolapk.market.model.AutoValue_GoodsCategoryInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_GoodsCategoryInfo createFromParcel(Parcel parcel) {
            return new AutoValue_GoodsCategoryInfo(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_GoodsCategoryInfo[] newArray(int i) {
            return new AutoValue_GoodsCategoryInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_GoodsCategoryInfo(String str, String str2) {
        super(str, str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getCatId());
        parcel.writeString(getCatTitle());
    }
}
