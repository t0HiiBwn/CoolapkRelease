package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_LiveProduct extends C$AutoValue_LiveProduct {
    public static final Parcelable.Creator<AutoValue_LiveProduct> CREATOR = new Parcelable.Creator<AutoValue_LiveProduct>() {
        /* class com.coolapk.market.model.AutoValue_LiveProduct.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_LiveProduct createFromParcel(Parcel parcel) {
            return new AutoValue_LiveProduct(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_LiveProduct[] newArray(int i) {
            return new AutoValue_LiveProduct[i];
        }
    };

    AutoValue_LiveProduct(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getId());
        parcel.writeString(getTitle());
        parcel.writeString(getLogo());
    }
}
