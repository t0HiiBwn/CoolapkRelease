package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_CollectionItem extends C$AutoValue_CollectionItem {
    public static final Parcelable.Creator<AutoValue_CollectionItem> CREATOR = new Parcelable.Creator<AutoValue_CollectionItem>() {
        /* class com.coolapk.market.model.AutoValue_CollectionItem.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_CollectionItem createFromParcel(Parcel parcel) {
            return new AutoValue_CollectionItem(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_CollectionItem[] newArray(int i) {
            return new AutoValue_CollectionItem[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_CollectionItem(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        super(str, str2, str3, str4, str5, str6, i, i2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getId());
        }
        if (getCollectionId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCollectionId());
        }
        if (getUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUid());
        }
        if (getTargetUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTargetUid());
        }
        if (getContent() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getContent());
        }
        if (getTargetType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTargetType());
        }
        parcel.writeInt(getIsTop());
        parcel.writeInt(getIsDelete());
    }
}
