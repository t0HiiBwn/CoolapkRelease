package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_FeedGoods extends C$AutoValue_FeedGoods {
    public static final Parcelable.Creator<AutoValue_FeedGoods> CREATOR = new Parcelable.Creator<AutoValue_FeedGoods>() {
        /* class com.coolapk.market.model.AutoValue_FeedGoods.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedGoods createFromParcel(Parcel parcel) {
            return new AutoValue_FeedGoods(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readArrayList(FeedGoodsCategory.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(ConfigPage.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedGoods[] newArray(int i) {
            return new AutoValue_FeedGoods[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_FeedGoods(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, String str13, long j, String str14, String str15, String str16, String str17, String str18, String str19, long j2, int i2, long j3, String str20, long j4, String str21, List<FeedGoodsCategory> list, String str22, String str23, String str24, List<ConfigPage> list2) {
        super(str, str2, i, str3, num, str4, str5, str6, str7, str8, str9, l2, l3, str10, str11, str12, str13, j, str14, str15, str16, str17, str18, str19, j2, i2, j3, str20, j4, str21, list, str22, str23, str24, list2);
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
        parcel.writeString(getId());
        parcel.writeString(getMallName());
        if (getSkuId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSkuId());
        }
        if (getMallSku() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMallSku());
        }
        parcel.writeLong(getCategoryId());
        parcel.writeString(getTitle());
        if (getCover() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCover());
        }
        parcel.writeString(getWishCount());
        parcel.writeString(getBuyCount());
        if (getKeyWords() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getKeyWords());
        }
        if (getSellUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSellUrl());
        }
        parcel.writeLong(getSellTime());
        parcel.writeInt(getBlockStatus());
        parcel.writeLong(getCreateTime());
        parcel.writeString(getCreateUid());
        parcel.writeLong(getUpdateTime());
        parcel.writeString(getUpdateUid());
        parcel.writeList(getCategoryRows());
        if (getBgColor() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBgColor());
        }
        if (getBackendCategoryName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBackendCategoryName());
        }
        if (getPrice() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPrice());
        }
        parcel.writeList(getTabApiList());
    }
}
