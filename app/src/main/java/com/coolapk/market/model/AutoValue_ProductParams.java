package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_ProductParams extends C$AutoValue_ProductParams {
    public static final Parcelable.Creator<AutoValue_ProductParams> CREATOR = new Parcelable.Creator<AutoValue_ProductParams>() {
        /* class com.coolapk.market.model.AutoValue_ProductParams.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_ProductParams createFromParcel(Parcel parcel) {
            return new AutoValue_ProductParams(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_ProductParams[] newArray(int i) {
            return new AutoValue_ProductParams[i];
        }
    };

    AutoValue_ProductParams(String str, String str2, int i, int i2, int i3, int i4) {
        super(str, str2, i, i2, i3, i4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        if (getKey() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getKey());
        }
        parcel.writeInt(getItemState());
        parcel.writeInt(getItemType());
        parcel.writeInt(getCheckBoxState());
        parcel.writeInt(getKeyIndex());
    }
}
