package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_Ads extends C$AutoValue_Ads {
    public static final Parcelable.Creator<AutoValue_Ads> CREATOR = new Parcelable.Creator<AutoValue_Ads>() {
        /* class com.coolapk.market.model.AutoValue_Ads.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Ads createFromParcel(Parcel parcel) {
            return new AutoValue_Ads(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Ads[] newArray(int i) {
            return new AutoValue_Ads[i];
        }
    };

    AutoValue_Ads(String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l2, Long l3, String str7, String str8, int i, String str9, String str10, String str11, String str12, String str13, String str14) {
        super(str, str2, num, str3, str4, str5, str6, l2, l3, str7, str8, i, str9, str10, str11, str12, str13, str14);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getEntityTemplate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTemplate());
        }
        if (getEntityId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityId());
        }
        if (getEntityFixed() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(getEntityFixed().intValue());
        }
        if (getDescription() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDescription());
        }
        if (getPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPic());
        }
        if (getId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getId());
        }
        if (getExtraData() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraData());
        }
        if (getDateline() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getDateline().longValue());
        }
        if (getLastUpdate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getLastUpdate().longValue());
        }
        if (getEntityTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTypeName());
        }
        if (getUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUid());
        }
        parcel.writeInt(getFollow());
        parcel.writeString(getEntityType());
        parcel.writeString(getTitle());
        if (getSubTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSubTitle());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        parcel.writeString(getLogo());
        if (getAdsType() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getAdsType());
    }
}
