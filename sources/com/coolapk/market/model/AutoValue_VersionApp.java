package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_VersionApp extends C$AutoValue_VersionApp {
    public static final Parcelable.Creator<AutoValue_VersionApp> CREATOR = new Parcelable.Creator<AutoValue_VersionApp>() {
        /* class com.coolapk.market.model.AutoValue_VersionApp.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_VersionApp createFromParcel(Parcel parcel) {
            return new AutoValue_VersionApp(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_VersionApp[] newArray(int i) {
            return new AutoValue_VersionApp[i];
        }
    };

    AutoValue_VersionApp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getPackageName());
        parcel.writeString(getVersionName());
        parcel.writeString(getAppName());
        parcel.writeString(getVersionId());
        parcel.writeString(getVersionSize());
        parcel.writeString(getVersionLength());
        parcel.writeString(getVersionDate());
        parcel.writeString(getDownloadFrom());
    }
}
