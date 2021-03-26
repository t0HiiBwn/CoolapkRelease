package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_MallInfo extends C$AutoValue_MallInfo {
    public static final Parcelable.Creator<AutoValue_MallInfo> CREATOR = new Parcelable.Creator<AutoValue_MallInfo>() {
        /* class com.coolapk.market.model.AutoValue_MallInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_MallInfo createFromParcel(Parcel parcel) {
            return new AutoValue_MallInfo(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_MallInfo[] newArray(int i) {
            return new AutoValue_MallInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_MallInfo(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3, str4, str5);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getId());
        }
        if (getMallTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMallTitle());
        }
        if (getName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getName());
        }
        if (getMallLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMallLogo());
        }
        if (getMallDomain() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getMallDomain());
    }
}
