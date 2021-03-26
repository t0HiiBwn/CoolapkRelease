package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_FileDetail extends C$AutoValue_FileDetail {
    public static final Parcelable.Creator<AutoValue_FileDetail> CREATOR = new Parcelable.Creator<AutoValue_FileDetail>() {
        /* class com.coolapk.market.model.AutoValue_FileDetail.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FileDetail createFromParcel(Parcel parcel) {
            return new AutoValue_FileDetail(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FileDetail[] newArray(int i) {
            return new AutoValue_FileDetail[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_FileDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l, String str10, Long l2, int i, int i2, int i3, int i4, int i5) {
        super(str, str2, str3, str4, str5, str6, str7, str8, str9, l, str10, l2, i, i2, i3, i4, i5);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (id() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(id());
        }
        if (fileMd5() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(fileMd5());
        }
        if (url() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(url());
        }
        if (urlMd5() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(urlMd5());
        }
        if (uploadType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(uploadType());
        }
        if (uploadDir() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(uploadDir());
        }
        if (fileSize() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(fileSize());
        }
        if (fileExt() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(fileExt());
        }
        if (firstUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(firstUid());
        }
        if (dateline() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(dateline().longValue());
        }
        if (lastUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(lastUid());
        }
        if (lastUpdateTime() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(lastUpdateTime().longValue());
        }
        parcel.writeInt(uploadCount());
        parcel.writeInt(isBlock());
        parcel.writeInt(isForbid());
        parcel.writeInt(isBanned());
        parcel.writeInt(spamStatus());
    }
}
