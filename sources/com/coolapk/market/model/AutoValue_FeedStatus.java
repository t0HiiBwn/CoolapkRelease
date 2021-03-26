package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_FeedStatus extends C$AutoValue_FeedStatus {
    public static final Parcelable.Creator<AutoValue_FeedStatus> CREATOR = new Parcelable.Creator<AutoValue_FeedStatus>() {
        /* class com.coolapk.market.model.AutoValue_FeedStatus.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedStatus createFromParcel(Parcel parcel) {
            return new AutoValue_FeedStatus(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedStatus[] newArray(int i) {
            return new AutoValue_FeedStatus[i];
        }
    };

    AutoValue_FeedStatus(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3) {
        super(i, i2, i3, i4, i5, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getRecommend());
        parcel.writeInt(getStatus());
        parcel.writeInt(getMessageStatus());
        parcel.writeInt(getBlockStatus());
        parcel.writeInt(getIsHeadlineV8());
        parcel.writeString(getStatusText());
        parcel.writeString(getMessageStatusText());
        parcel.writeString(getBlockStatusText());
    }
}
