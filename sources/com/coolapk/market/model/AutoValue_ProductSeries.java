package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_ProductSeries extends C$AutoValue_ProductSeries {
    public static final Parcelable.Creator<AutoValue_ProductSeries> CREATOR = new Parcelable.Creator<AutoValue_ProductSeries>() {
        /* class com.coolapk.market.model.AutoValue_ProductSeries.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_ProductSeries createFromParcel(Parcel parcel) {
            return new AutoValue_ProductSeries(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readArrayList(Product.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_ProductSeries[] newArray(int i) {
            return new AutoValue_ProductSeries[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_ProductSeries(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l2, Long l3, int i2, int i3, int i4, List<Product> list) {
        super(str, str2, i, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l2, l3, i2, i3, i4, list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getEntityTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTypeName());
        }
        if (getEntityTemplate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTemplate());
        }
        parcel.writeInt(getEntityTypeId());
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
        if (getLastUpdate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getLastUpdate().longValue());
        }
        parcel.writeInt(getBrandId());
        parcel.writeInt(getDisplayOrder());
        parcel.writeInt(getProductNum());
        parcel.writeList(getProductRows());
    }
}
