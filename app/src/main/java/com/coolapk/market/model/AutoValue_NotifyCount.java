package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_NotifyCount extends C$AutoValue_NotifyCount {
    public static final Parcelable.Creator<AutoValue_NotifyCount> CREATOR = new Parcelable.Creator<AutoValue_NotifyCount>() {
        /* class com.coolapk.market.model.AutoValue_NotifyCount.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_NotifyCount createFromParcel(Parcel parcel) {
            return new AutoValue_NotifyCount(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_NotifyCount[] newArray(int i) {
            return new AutoValue_NotifyCount[i];
        }
    };

    AutoValue_NotifyCount(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2) {
        super(i, i2, i3, i4, i5, i6, i7, i8, i9, j, j2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getCloudInstall());
        parcel.writeInt(getNotification());
        parcel.writeInt(getMessage());
        parcel.writeInt(getAtMe());
        parcel.writeInt(getAtCommentMe());
        parcel.writeInt(getCommentMe());
        parcel.writeInt(getBadge());
        parcel.writeInt(getFeedLike());
        parcel.writeInt(getFollowMe());
        parcel.writeLong(getLastSplashUpdate());
        parcel.writeLong(getDateline());
    }
}
