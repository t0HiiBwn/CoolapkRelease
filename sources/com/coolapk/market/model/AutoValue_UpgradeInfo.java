package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_UpgradeInfo extends C$AutoValue_UpgradeInfo {
    public static final Parcelable.Creator<AutoValue_UpgradeInfo> CREATOR = new Parcelable.Creator<AutoValue_UpgradeInfo>() {
        /* class com.coolapk.market.model.AutoValue_UpgradeInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_UpgradeInfo createFromParcel(Parcel parcel) {
            return new AutoValue_UpgradeInfo(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_UpgradeInfo[] newArray(int i) {
            return new AutoValue_UpgradeInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_UpgradeInfo(String str, String str2, String str3, String str4, int i, String str5, long j, String str6, String str7, String str8, String str9, Long l2, String str10, String str11, String str12) {
        super(str, str2, str3, str4, i, str5, j, str6, str7, str8, str9, l2, str10, str11, str12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getPackageName());
        parcel.writeString(getApkId());
        if (getDisplayVersionName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDisplayVersionName());
        }
        parcel.writeString(getVersionName());
        parcel.writeInt(getVersionCode());
        parcel.writeString(getApkSize());
        parcel.writeLong(getLastUpdate());
        if (getChangeLog() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getChangeLog());
        }
        if (getLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLogo());
        }
        if (getPatchKey() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPatchKey());
        }
        if (getPatchSize() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPatchSize());
        }
        if (getPatchLength() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getPatchLength().longValue());
        }
        if (getPatchMd5() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPatchMd5());
        }
        if (getExtraAnalysisData() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraAnalysisData());
        }
        if (getExtraFlag() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getExtraFlag());
    }
}
