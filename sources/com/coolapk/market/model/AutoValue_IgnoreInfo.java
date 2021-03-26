package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_IgnoreInfo extends C$AutoValue_IgnoreInfo {
    public static final Parcelable.Creator<AutoValue_IgnoreInfo> CREATOR = new Parcelable.Creator<AutoValue_IgnoreInfo>() {
        /* class com.coolapk.market.model.AutoValue_IgnoreInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_IgnoreInfo createFromParcel(Parcel parcel) {
            return new AutoValue_IgnoreInfo(parcel.readInt(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_IgnoreInfo[] newArray(int i) {
            return new AutoValue_IgnoreInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_IgnoreInfo(int i, String str, int i2) {
        super(i, str, i2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getType());
        parcel.writeString(getPackageName());
        parcel.writeInt(getVersionCode());
    }
}
