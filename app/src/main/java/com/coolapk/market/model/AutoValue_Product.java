package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_Product extends C$AutoValue_Product {
    public static final Parcelable.Creator<AutoValue_Product> CREATOR = new Parcelable.Creator<AutoValue_Product>() {
        /* class com.coolapk.market.model.AutoValue_Product.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Product createFromParcel(Parcel parcel) {
            return new AutoValue_Product(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()), parcel.readInt(), parcel.readFloat(), parcel.readFloat(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readArrayList(String.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(ProductConfig.class.getClassLoader()), (UserAction) parcel.readParcelable(UserAction.class.getClassLoader()), parcel.readArrayList(ConfigPage.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readFloat(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readFloat(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(ProductCoupon.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()), parcel.readArrayList(RelatedData.class.getClassLoader()), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readArrayList(NewHeadLine.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Product[] newArray(int i) {
            return new AutoValue_Product[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Product(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l2, Long l3, String str12, String str13, List<String> list, int i, float f, float f2, String str14, int i2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int i3, int i4, int i5, List<String> list2, int i6, int i7, int i8, int i9, int i10, int i11, String str15, int i12, String str16, int i13, int i14, int i15, String str17, String str18, String str19, String str20, List<ProductConfig> list3, UserAction userAction, List<ConfigPage> list4, String str21, float f14, String str22, float f15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, float f16, int i27, int i28, int i29, String str23, String str24, List<ProductCoupon> list5, String str25, List<String> list6, List<RelatedData> list7, int i30, String str26, String str27, int i31, int i32, int i33, int i34, int i35, List<NewHeadLine> list8) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l2, l3, str12, str13, list, i, f, f2, str14, i2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, i3, i4, i5, list2, i6, i7, i8, i9, i10, i11, str15, i12, str16, i13, i14, i15, str17, str18, str19, str20, list3, userAction, list4, str21, f14, str22, f15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, f16, i27, i28, i29, str23, str24, list5, str25, list6, list7, i30, str26, str27, i31, i32, i33, i34, i35, list8);
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
        if (getBrandId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBrandId());
        }
        if (getSeriesId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSeriesId());
        }
        parcel.writeList(getCoverPicList());
        parcel.writeInt(getConfigNum());
        parcel.writeFloat(getPriceMin());
        parcel.writeFloat(getPriceMax());
        if (getPriceCurrency() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPriceCurrency());
        }
        parcel.writeInt(getFollowNum());
        parcel.writeFloat(getRatingAverageScore());
        parcel.writeFloat(getRatingAverageScore1());
        parcel.writeFloat(getRatingAverageScore2());
        parcel.writeFloat(getRatingAverageScore3());
        parcel.writeFloat(getRatingAverageScore4());
        parcel.writeFloat(getRatingAverageScore5());
        parcel.writeFloat(getRatingAverageScore6());
        parcel.writeFloat(getRatingAverageScore7());
        parcel.writeFloat(getRatingAverageScore8());
        parcel.writeFloat(getRatingAverageScore9());
        parcel.writeFloat(getRatingAverageScore10());
        parcel.writeInt(getRatingTotalNum());
        parcel.writeInt(getVoteDigNum());
        parcel.writeInt(getVoteBuryNum());
        parcel.writeList(getTagArr());
        parcel.writeInt(getFeedCommentNum());
        parcel.writeInt(getFeedAnswerNum());
        parcel.writeInt(getFeedArticleNum());
        parcel.writeInt(getFeedVideoNum());
        parcel.writeInt(getRecommendImageNum());
        parcel.writeInt(getRecommendVideoNum());
        if (getReleaseTime() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getReleaseTime());
        }
        parcel.writeInt(getShareNum());
        if (getShareUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getShareUrl());
        }
        parcel.writeInt(getBlockStatus());
        parcel.writeInt(getReleaseStatus());
        parcel.writeInt(getStatus());
        if (getCreateUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCreateUid());
        }
        if (getCreateTime() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCreateTime());
        }
        if (getUpdateTime() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUpdateTime());
        }
        if (getUpdateUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUpdateUid());
        }
        parcel.writeList(getConfigRows());
        parcel.writeParcelable(getUserAction(), i);
        parcel.writeList(getTabApiList());
        if (getSelectedTab() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSelectedTab());
        }
        parcel.writeFloat(getVoteDigPercentage());
        if (getSecondHandFeedNum() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSecondHandFeedNum());
        }
        parcel.writeFloat(getStarAverageScore());
        parcel.writeInt(getStarTotalCount());
        parcel.writeInt(getStar1Count());
        parcel.writeInt(getStar2Count());
        parcel.writeInt(getStar3Count());
        parcel.writeInt(getStar4Count());
        parcel.writeInt(getStar5Count());
        parcel.writeInt(getOwnerStar1Count());
        parcel.writeInt(getOwnerStar2Count());
        parcel.writeInt(getOwnerStar3Count());
        parcel.writeInt(getOwnerStar4Count());
        parcel.writeInt(getOwnerStar5Count());
        parcel.writeFloat(getOwnerStarAverageScore());
        parcel.writeInt(getOwnerStarTotalCount());
        parcel.writeInt(getOwnerRatingTotalNum());
        parcel.writeInt(getOwnerBuyCount());
        if (getSecondHandSthType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSecondHandSthType());
        }
        if (getCouponTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCouponTitle());
        }
        parcel.writeList(getCouponList());
        if (getType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getType());
        }
        parcel.writeList(getTopIds());
        parcel.writeList(getRecentFollowList());
        parcel.writeInt(getHotNum());
        if (getHotNumText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getHotNumText());
        }
        if (getBgColor() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBgColor());
        }
        parcel.writeInt(getAllowRating());
        parcel.writeInt(getWishCount());
        parcel.writeInt(getBuyCount());
        parcel.writeInt(getCategoryId());
        parcel.writeInt(getIsOwner());
        parcel.writeList(getRecommendRows());
    }
}
