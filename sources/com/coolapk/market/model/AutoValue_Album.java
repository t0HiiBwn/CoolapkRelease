package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_Album extends C$AutoValue_Album {
    public static final Parcelable.Creator<AutoValue_Album> CREATOR = new Parcelable.Creator<AutoValue_Album>() {
        /* class com.coolapk.market.model.AutoValue_Album.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Album createFromParcel(Parcel parcel) {
            return new AutoValue_Album(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(AlbumItem.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, (Collection) parcel.readParcelable(Collection.class.getClassLoader()), (CollectionItem) parcel.readParcelable(CollectionItem.class.getClassLoader()), parcel.readArrayList(FeedReply.class.getClassLoader()), (UserAction) parcel.readParcelable(UserAction.class.getClassLoader()), parcel.readArrayList(FeedReply.class.getClassLoader()), parcel.readInt(), (FeedStatus) parcel.readParcelable(FeedStatus.class.getClassLoader()), (SimpleInfo) parcel.readParcelable(SimpleInfo.class.getClassLoader()), (SimpleInfo) parcel.readParcelable(SimpleInfo.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Album[] newArray(int i) {
            return new AutoValue_Album[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Album(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, UserInfo userInfo, String str10, String str11, String str12, String str13, String str14, String str15, String str16, UserInfo userInfo2, String str17, String str18, long j, String str19, String str20, int i, String str21, int i2, int i3, int i4, int i5, int i6, int i7, String str22, int i8, String str23, int i9, String str24, int i10, String str25, String str26, List<AlbumItem> list, String str27, Collection collection, CollectionItem collectionItem, List<FeedReply> list2, UserAction userAction, List<FeedReply> list3, int i11, FeedStatus feedStatus, SimpleInfo simpleInfo, SimpleInfo simpleInfo2) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, l2, l3, str9, userInfo, str10, str11, str12, str13, str14, str15, str16, userInfo2, str17, str18, j, str19, str20, i, str21, i2, i3, i4, i5, i6, i7, str22, i8, str23, i9, str24, i10, str25, str26, list, str27, collection, collectionItem, list2, userAction, list3, i11, feedStatus, simpleInfo, simpleInfo2);
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
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        if (getPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPic());
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
        if (getDeprecatedUserAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeprecatedUserAvatar());
        }
        parcel.writeParcelable(getUserInfo(), i);
        parcel.writeString(getUid());
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
        if (getFeedId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFeedId());
        }
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        if (getLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLogo());
        }
        if (getLikeAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLikeAvatar());
        }
        parcel.writeParcelable(getLikeUserInfo(), i);
        if (getLikeUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLikeUserName());
        }
        if (getLikeUid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLikeUid());
        }
        parcel.writeLong(getLikeTime());
        if (getIcon() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getIcon());
        }
        if (getKeyWords() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getKeyWords());
        }
        parcel.writeInt(getShareNum());
        if (getDescription() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDescription());
        }
        parcel.writeInt(getRecommend());
        parcel.writeInt(getTotalApkNum());
        parcel.writeInt(getFavoriteNum());
        parcel.writeInt(getCommentNum());
        parcel.writeInt(getForwardNum());
        parcel.writeInt(getReplyNum());
        if (getDeviceTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeviceTitle());
        }
        parcel.writeInt(getStatus());
        if (getAlbumUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAlbumUrl());
        }
        parcel.writeInt(getLikeNum());
        if (getIntroduce() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getIntroduce());
        }
        parcel.writeInt(getCommentBlockNum());
        if (getInfoHtml() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getInfoHtml());
        }
        if (getInfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getInfo());
        }
        parcel.writeList(getAlbumItems());
        if (getMoreCount() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMoreCount());
        }
        parcel.writeParcelable(getCollectionInfo(), i);
        parcel.writeParcelable(getCollectionItem(), i);
        parcel.writeList(getAlbumHotReplies());
        parcel.writeParcelable(getUserAction(), i);
        parcel.writeList(getReplyMeRows());
        parcel.writeInt(getIsStickTop());
        parcel.writeParcelable(getFeedStatus(), i);
        parcel.writeParcelable(getTopInfo(), i);
        parcel.writeParcelable(getInnerInfo(), i);
    }
}
