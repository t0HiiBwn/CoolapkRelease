package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_InstallState extends C$AutoValue_InstallState {
    public static final Parcelable.Creator<AutoValue_InstallState> CREATOR = new Parcelable.Creator<AutoValue_InstallState>() {
        /* class com.coolapk.market.model.AutoValue_InstallState.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_InstallState createFromParcel(Parcel parcel) {
            return new AutoValue_InstallState(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readString(), (Extra) parcel.readParcelable(Extra.class.getClassLoader()), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_InstallState[] newArray(int i) {
            return new AutoValue_InstallState[i];
        }
    };

    AutoValue_InstallState(String str, int i, String str2, Extra extra, long j, long j2, int i2, String str3, String str4) {
        super(str, i, str2, extra, j, j2, i2, str3, str4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getFrom() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFrom());
        }
        parcel.writeInt(getState());
        parcel.writeString(getPath());
        parcel.writeParcelable(getExtra(), i);
        parcel.writeLong(getUpdateTime());
        parcel.writeLong(getStartTime());
        parcel.writeInt(getErrorCode());
        if (getErrorMessage() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getErrorMessage());
        }
        if (getApkFilePath() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getApkFilePath());
    }
}
