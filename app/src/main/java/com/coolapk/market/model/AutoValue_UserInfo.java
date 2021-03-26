package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_UserInfo extends C$AutoValue_UserInfo {
    public static final Parcelable.Creator<AutoValue_UserInfo> CREATOR = new Parcelable.Creator<AutoValue_UserInfo>() {
        /* class com.coolapk.market.model.AutoValue_UserInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_UserInfo createFromParcel(Parcel parcel) {
            return new AutoValue_UserInfo(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_UserInfo[] newArray(int i) {
            return new AutoValue_UserInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_UserInfo(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, String str3, String str4, int i7, String str5, String str6, String str7, String str8, String str9, long j, String str10, int i8, String str11, String str12, String str13) {
        super(str, str2, i, i2, i3, i4, i5, i6, str3, str4, i7, str5, str6, str7, str8, str9, j, str10, i8, str11, str12, str13);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUid());
        }
        if (getUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUserName());
        }
        parcel.writeInt(getAdminType());
        parcel.writeInt(getGroupId());
        parcel.writeInt(getUserGroupId());
        parcel.writeInt(getStatus());
        parcel.writeInt(getUserNameStatus());
        parcel.writeInt(getAvatarStatus());
        if (getDisplayUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDisplayUserName());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        parcel.writeInt(getLevel());
        if (getUserAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUserAvatar());
        }
        if (getFans() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFans());
        }
        if (getFollow() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFollow());
        }
        if (getBio() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBio());
        }
        if (getUserSmallAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUserSmallAvatar());
        }
        parcel.writeLong(getLoginTime());
        if (getUserBigAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUserBigAvatar());
        }
        parcel.writeInt(getVerifyStatus());
        if (getVerifyIcon() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVerifyIcon());
        }
        if (getVerifyLabel() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVerifyLabel());
        }
        if (getVerifyTitle() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getVerifyTitle());
    }
}
