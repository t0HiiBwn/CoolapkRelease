package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_SimpleInfo extends C$AutoValue_SimpleInfo {
    public static final Parcelable.Creator<AutoValue_SimpleInfo> CREATOR = new Parcelable.Creator<AutoValue_SimpleInfo>() {
        /* class com.coolapk.market.model.AutoValue_SimpleInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_SimpleInfo createFromParcel(Parcel parcel) {
            String str = null;
            String readString = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString2 = parcel.readInt() == 0 ? parcel.readString() : null;
            if (parcel.readInt() == 0) {
                str = parcel.readString();
            }
            return new AutoValue_SimpleInfo(readString, readString2, str);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_SimpleInfo[] newArray(int i) {
            return new AutoValue_SimpleInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_SimpleInfo(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getIcon() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getIcon());
        }
        if (getMessage() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessage());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getUrl());
    }
}
