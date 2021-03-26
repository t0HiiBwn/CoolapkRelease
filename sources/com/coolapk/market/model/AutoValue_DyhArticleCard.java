package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_DyhArticleCard extends C$AutoValue_DyhArticleCard {
    public static final Parcelable.Creator<AutoValue_DyhArticleCard> CREATOR = new Parcelable.Creator<AutoValue_DyhArticleCard>() {
        /* class com.coolapk.market.model.AutoValue_DyhArticleCard.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_DyhArticleCard createFromParcel(Parcel parcel) {
            return new AutoValue_DyhArticleCard(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(DyhArticle.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readString(), Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_DyhArticleCard[] newArray(int i) {
            return new AutoValue_DyhArticleCard[i];
        }
    };

    AutoValue_DyhArticleCard(String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l, String str7, String str8, String str9, List<DyhArticle> list, String str10, String str11, String str12, Long l2) {
        super(str, str2, num, str3, str4, str5, str6, l, str7, str8, str9, list, str10, str11, str12, l2);
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
        if (getLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLogo());
        }
        if (getSubTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSubTitle());
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
        if (getDescription() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDescription());
        }
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        parcel.writeList(getEntities());
        if (getEntityTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTypeName());
        }
        parcel.writeString(getEntityType());
        parcel.writeString(getPic());
        parcel.writeLong(getLastUpdate().longValue());
    }
}
