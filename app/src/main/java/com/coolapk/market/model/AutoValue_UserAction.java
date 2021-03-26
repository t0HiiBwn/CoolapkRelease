package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_UserAction extends C$AutoValue_UserAction {
    public static final Parcelable.Creator<AutoValue_UserAction> CREATOR = new Parcelable.Creator<AutoValue_UserAction>() {
        /* class com.coolapk.market.model.AutoValue_UserAction.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_UserAction createFromParcel(Parcel parcel) {
            return new AutoValue_UserAction(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_UserAction[] newArray(int i) {
            return new AutoValue_UserAction[i];
        }
    };

    AutoValue_UserAction(int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, int i8) {
        super(i, i2, i3, i4, i5, str, i6, i7, i8);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getFollow());
        parcel.writeInt(getRating());
        parcel.writeInt(getLike());
        parcel.writeInt(getFavorite());
        parcel.writeInt(getCollect());
        if (getRatingFeedUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRatingFeedUrl());
        }
        parcel.writeInt(getFollowAuthor());
        parcel.writeInt(getWish());
        parcel.writeInt(getBuy());
    }
}
