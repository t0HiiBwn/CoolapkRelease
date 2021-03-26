package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_ProductConfig extends C$AutoValue_ProductConfig {
    public static final Parcelable.Creator<AutoValue_ProductConfig> CREATOR = new Parcelable.Creator<AutoValue_ProductConfig>() {
        /* class com.coolapk.market.model.AutoValue_ProductConfig.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_ProductConfig createFromParcel(Parcel parcel) {
            return new AutoValue_ProductConfig(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readFloat(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_ProductConfig[] newArray(int i) {
            return new AutoValue_ProductConfig[i];
        }
    };

    AutoValue_ProductConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, float f, String str11, String str12) {
        super(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, f, str11, str12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getId());
        }
        if (getProductId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getProductId());
        }
        if (getZolId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getZolId());
        }
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        if (getScreenMaterial() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getScreenMaterial());
        }
        if (getCPU() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCPU());
        }
        if (getReleaseTime() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getReleaseTime());
        }
        if (getRAM() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRAM());
        }
        if (getFingerpointType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFingerpointType());
        }
        if (getPhoneMaterial() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPhoneMaterial());
        }
        parcel.writeFloat(getPrice());
        if (getKeywords() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getKeywords());
        }
        if (getConfigData() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getConfigData());
    }
}
