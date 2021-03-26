package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_LocalApk extends C$AutoValue_LocalApk {
    public static final Parcelable.Creator<AutoValue_LocalApk> CREATOR = new Parcelable.Creator<AutoValue_LocalApk>() {
        /* class com.coolapk.market.model.AutoValue_LocalApk.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_LocalApk createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            return new AutoValue_LocalApk(readString, readString2, readInt, readString3, readLong, readLong2, readLong3, z, parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_LocalApk[] newArray(int i) {
            return new AutoValue_LocalApk[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_LocalApk(String str, String str2, int i, String str3, long j, long j2, long j3, boolean z, String str4, int i2) {
        super(str, str2, i, str3, j, j2, j3, z, str4, i2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getPackageName());
        parcel.writeString(getVersionName());
        parcel.writeInt(getVersionCode());
        parcel.writeString(getAppName());
        parcel.writeLong(getApkLength());
        parcel.writeLong(getFirstInstallTime());
        parcel.writeLong(getLastUpdateTime());
        parcel.writeInt(isSystemApp() ? 1 : 0);
        parcel.writeString(getFilePath());
        parcel.writeInt(getTargetSdkVersion());
    }
}
