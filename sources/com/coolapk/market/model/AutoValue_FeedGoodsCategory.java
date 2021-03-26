package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_FeedGoodsCategory extends C$AutoValue_FeedGoodsCategory {
    public static final Parcelable.Creator<AutoValue_FeedGoodsCategory> CREATOR = new Parcelable.Creator<AutoValue_FeedGoodsCategory>() {
        /* class com.coolapk.market.model.AutoValue_FeedGoodsCategory.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedGoodsCategory createFromParcel(Parcel parcel) {
            return new AutoValue_FeedGoodsCategory(parcel.readLong(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedGoodsCategory[] newArray(int i) {
            return new AutoValue_FeedGoodsCategory[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_FeedGoodsCategory(long j, int i, String str, String str2, String str3, String str4, long j2, String str5, long j3, String str6) {
        super(j, i, str, str2, str3, str4, j2, str5, j3, str6);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(getId());
        parcel.writeInt(getDisplayOrder());
        if (getGoodsCount() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getGoodsCount());
        }
        if (getLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLogo());
        }
        parcel.writeString(getTitle());
        if (getKeyWords() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getKeyWords());
        }
        parcel.writeLong(getCreateTime());
        parcel.writeString(getCreateUid());
        parcel.writeLong(getUpdateTime());
        parcel.writeString(getUpdateUid());
    }
}
