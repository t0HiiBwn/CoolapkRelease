package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_MobileApp extends C$AutoValue_MobileApp {
    public static final Parcelable.Creator<AutoValue_MobileApp> CREATOR = new Parcelable.Creator<AutoValue_MobileApp>() {
        /* class com.coolapk.market.model.AutoValue_MobileApp.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_MobileApp createFromParcel(Parcel parcel) {
            return new AutoValue_MobileApp(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), parcel.readLong(), parcel.readInt() == 1, parcel.readString(), parcel.readInt() == 1, (UpgradeInfo) parcel.readParcelable(UpgradeInfo.class.getClassLoader()), (IgnoreInfo) parcel.readParcelable(IgnoreInfo.class.getClassLoader()), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_MobileApp[] newArray(int i) {
            return new AutoValue_MobileApp[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_MobileApp(long j, String str, String str2, int i, String str3, long j2, String str4, long j3, long j4, boolean z, String str5, boolean z2, UpgradeInfo upgradeInfo, IgnoreInfo ignoreInfo, long j5, long j6) {
        super(j, str, str2, i, str3, j2, str4, j3, j4, z, str5, z2, upgradeInfo, ignoreInfo, j5, j6);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(getDbId());
        parcel.writeString(getPackageName());
        parcel.writeString(getVersionName());
        parcel.writeInt(getVersionCode());
        parcel.writeString(getAppName());
        parcel.writeLong(getApkLength());
        if (getApkMd5() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getApkMd5());
        }
        parcel.writeLong(getFirstInstallTime());
        parcel.writeLong(getLastUpdateTime());
        parcel.writeInt(isExist() ? 1 : 0);
        parcel.writeString(getApkPath());
        parcel.writeInt(isSystemApp() ? 1 : 0);
        parcel.writeParcelable(getUpgradeInfo(), i);
        parcel.writeParcelable(getIgnoreInfo(), i);
        parcel.writeLong(getCreated());
        parcel.writeLong(getModified());
    }
}
