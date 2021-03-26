package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_DyhArticle extends C$AutoValue_DyhArticle {
    public static final Parcelable.Creator<AutoValue_DyhArticle> CREATOR = new Parcelable.Creator<AutoValue_DyhArticle>() {
        /* class com.coolapk.market.model.AutoValue_DyhArticle.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_DyhArticle createFromParcel(Parcel parcel) {
            return new AutoValue_DyhArticle(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (DyhModel) parcel.readParcelable(DyhModel.class.getClassLoader()), parcel.readArrayList(FeedReply.class.getClassLoader()), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), (UserAction) parcel.readParcelable(UserAction.class.getClassLoader()), parcel.readInt(), parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, (Collection) parcel.readParcelable(Collection.class.getClassLoader()), (CollectionItem) parcel.readParcelable(CollectionItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_DyhArticle[] newArray(int i) {
            return new AutoValue_DyhArticle[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_DyhArticle(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, Long l2, Long l3, String str8, UserInfo userInfo, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i2, String str18, String str19, String str20, int i3, String str21, String str22, String str23, String str24, int i4, String str25, List<String> list, String str26, String str27, int i5, int i6, int i7, int i8, int i9, int i10, int i11, DyhModel dyhModel, List<FeedReply> list2, int i12, String str28, String str29, String str30, int i13, String str31, String str32, int i14, UserAction userAction, int i15, Long l4, Collection collection, CollectionItem collectionItem) {
        super(str, str2, str3, i, str4, num, str5, str6, str7, l2, l3, str8, userInfo, str9, str10, str11, str12, str13, str14, str15, str16, str17, i2, str18, str19, str20, i3, str21, str22, str23, str24, i4, str25, list, str26, str27, i5, i6, i7, i8, i9, i10, i11, dyhModel, list2, i12, str28, str29, str30, i13, str31, str32, i14, userAction, i15, l4, collection, collectionItem);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getEntityTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTypeName());
        }
        parcel.writeString(getEntityType());
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
        if (getDeprecatedUserAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeprecatedUserAvatar());
        }
        parcel.writeParcelable(getUserInfo(), i);
        if (getDeprecatedUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeprecatedUserName());
        }
        if (getDisplayUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDisplayUserName());
        }
        parcel.writeString(getId());
        if (getDyhId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDyhId());
        }
        if (getDyhName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDyhName());
        }
        if (getFeedId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFeedId());
        }
        if (getUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUid());
        }
        if (getAuthor() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAuthor());
        }
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        parcel.writeInt(getForwardNum());
        if (getKeywords() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getKeywords());
        }
        if (getMessage() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessage());
        }
        if (getDescription() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDescription());
        }
        parcel.writeInt(getShareNum());
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        if (getUrlMD5() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrlMD5());
        }
        if (getVideoUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVideoUrl());
        }
        if (getRedirectUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRedirectUrl());
        }
        parcel.writeInt(getIsStickTop());
        if (getRawUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRawUrl());
        }
        parcel.writeList(getPicArr());
        if (getPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPic());
        }
        if (getContent() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getContent());
        }
        parcel.writeInt(getIsHtmlArticle());
        parcel.writeInt(getCommentNum());
        parcel.writeInt(getReplyNum());
        parcel.writeInt(getLikeNum());
        parcel.writeInt(getFavNum());
        parcel.writeInt(getBlockStatus());
        parcel.writeInt(getRecommend());
        parcel.writeParcelable(getDyhModel(), i);
        parcel.writeList(getReplyMeRows());
        parcel.writeInt(getIsHeadline());
        if (getAdminInfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAdminInfo());
        }
        if (getStatusText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getStatusText());
        }
        if (getMessageStatusText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageStatusText());
        }
        parcel.writeInt(getMessageStatus());
        if (getBlockStatusText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBlockStatusText());
        }
        if (getFromInfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFromInfo());
        }
        parcel.writeInt(getIsHeadlineV8());
        parcel.writeParcelable(getUserAction(), i);
        parcel.writeInt(getStatus());
        if (getCreatDate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getCreatDate().longValue());
        }
        parcel.writeParcelable(getCollectionInfo(), i);
        parcel.writeParcelable(getCollectionItem(), i);
    }
}
