package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_DownloadInfo extends C$AutoValue_DownloadInfo {
    public static final Parcelable.Creator<AutoValue_DownloadInfo> CREATOR = new Parcelable.Creator<AutoValue_DownloadInfo>() {
        /* class com.coolapk.market.model.AutoValue_DownloadInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_DownloadInfo createFromParcel(Parcel parcel) {
            return new AutoValue_DownloadInfo(parcel.readLong(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_DownloadInfo[] newArray(int i) {
            return new AutoValue_DownloadInfo[i];
        }
    };

    AutoValue_DownloadInfo(long j, String str, String str2, String str3, String str4, long j2, long j3, String str5, String str6, long j4, long j5, long j6) {
        super(j, str, str2, str3, str4, j2, j3, str5, str6, j4, j5, j6);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(getDbId());
        parcel.writeString(getUrl());
        if (getFilePath() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFilePath());
        }
        if (getApkFilePath() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getApkFilePath());
        }
        parcel.writeString(getFileName());
        parcel.writeLong(getCurrentLength());
        parcel.writeLong(getTotalLength());
        if (getMimeType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMimeType());
        }
        if (getExtraString() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraString());
        }
        parcel.writeLong(getCreateTime());
        parcel.writeLong(getStartTime());
        parcel.writeLong(getUpdateTime());
    }
}
