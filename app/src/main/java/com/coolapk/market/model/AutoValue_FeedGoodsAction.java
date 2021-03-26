package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_FeedGoodsAction extends C$AutoValue_FeedGoodsAction {
    public static final Parcelable.Creator<AutoValue_FeedGoodsAction> CREATOR = new Parcelable.Creator<AutoValue_FeedGoodsAction>() {
        /* class com.coolapk.market.model.AutoValue_FeedGoodsAction.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedGoodsAction createFromParcel(Parcel parcel) {
            return new AutoValue_FeedGoodsAction(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedGoodsAction[] newArray(int i) {
            return new AutoValue_FeedGoodsAction[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_FeedGoodsAction(int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, String str3, String str4) {
        super(i, i2, i3, i4, i5, i6, str, str2, str3, str4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getStar());
        parcel.writeInt(getWishBuyStatus());
        parcel.writeInt(getCategoryId());
        parcel.writeInt(getHotNum());
        parcel.writeInt(getStatus());
        parcel.writeInt(getRecommendStatus());
        if (getCategoryName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCategoryName());
        }
        if (getSellUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSellUrl());
        }
        if (getPrice() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPrice());
        }
        parcel.writeString(getMallName());
    }
}
