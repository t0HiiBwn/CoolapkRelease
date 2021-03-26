package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_Tips extends C$AutoValue_Tips {
    public static final Parcelable.Creator<AutoValue_Tips> CREATOR = new Parcelable.Creator<AutoValue_Tips>() {
        /* class com.coolapk.market.model.AutoValue_Tips.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Tips createFromParcel(Parcel parcel) {
            return new AutoValue_Tips(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Tips[] newArray(int i) {
            return new AutoValue_Tips[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Tips(String str, String str2, String str3, String str4, int i) {
        super(str, str2, str3, str4, i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        if (getButtonName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getButtonName());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        if (getLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLogo());
        }
        parcel.writeInt(getClosable());
    }
}
