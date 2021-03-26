package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_ImageUrl extends C$AutoValue_ImageUrl {
    public static final Parcelable.Creator<AutoValue_ImageUrl> CREATOR = new Parcelable.Creator<AutoValue_ImageUrl>() {
        /* class com.coolapk.market.model.AutoValue_ImageUrl.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_ImageUrl createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String str = null;
            String readString2 = parcel.readInt() == 0 ? parcel.readString() : null;
            if (parcel.readInt() == 0) {
                str = parcel.readString();
            }
            return new AutoValue_ImageUrl(readString, readString2, str);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_ImageUrl[] newArray(int i) {
            return new AutoValue_ImageUrl[i];
        }
    };

    AutoValue_ImageUrl(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getSourceUrl());
        if (getCompressedUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCompressedUrl());
        }
        if (getUploadDir() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getUploadDir());
    }
}
