package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_Feed extends C$AutoValue_Feed {
    public static final Parcelable.Creator<AutoValue_Feed> CREATOR = new Parcelable.Creator<AutoValue_Feed>() {
        /* class com.coolapk.market.model.AutoValue_Feed.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Feed createFromParcel(Parcel parcel) {
            return new AutoValue_Feed(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readString(), parcel.readArrayList(String.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readString(), parcel.readArrayList(FeedReply.class.getClassLoader()), parcel.readInt(), parcel.readArrayList(RelatedData.class.getClassLoader()), parcel.readArrayList(RelatedData.class.getClassLoader()), parcel.readArrayList(RelatedData.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, (Collection) parcel.readParcelable(Collection.class.getClassLoader()), (CollectionItem) parcel.readParcelable(CollectionItem.class.getClassLoader()), (UserAction) parcel.readParcelable(UserAction.class.getClassLoader()), parcel.readArrayList(FeedReply.class.getClassLoader()), parcel.readArrayList(FeedReply.class.getClassLoader()), parcel.readArrayList(FeedReply.class.getClassLoader()), parcel.readArrayList(String.class.getClassLoader()), parcel.readArrayList(GoodsListItem.class.getClassLoader()), (Feed) parcel.readParcelable(Feed.class.getClassLoader()), (DyhArticle) parcel.readParcelable(DyhArticle.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readLong(), (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(FeedRelation.class.getClassLoader()), (FeedTarget) parcel.readParcelable(FeedTarget.class.getClassLoader()), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(Entity.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), (DyhModel) parcel.readParcelable(DyhModel.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, (Entity) parcel.readParcelable(Entity.class.getClassLoader()), (Entity) parcel.readParcelable(Entity.class.getClassLoader()), (Entity) parcel.readParcelable(Entity.class.getClassLoader()), parcel.readInt(), parcel.readArrayList(FeedReply.class.getClassLoader()), (FeedGoodsAction) parcel.readParcelable(FeedGoodsAction.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt(), (Vote) parcel.readParcelable(Vote.class.getClassLoader()), (SecondHandInfo) parcel.readParcelable(SecondHandInfo.class.getClassLoader()), parcel.readInt(), (SimpleInfo) parcel.readParcelable(SimpleInfo.class.getClassLoader()), (SimpleInfo) parcel.readParcelable(SimpleInfo.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Feed[] newArray(int i) {
            return new AutoValue_Feed[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Feed(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Long l2, Long l3, String str8, UserInfo userInfo, String str9, String str10, String str11, String str12, String str13, String str14, int i, String str15, List<String> list, String str16, String str17, int i2, int i3, int i4, int i5, int i6, int i7, String str18, String str19, int i8, String str20, int i9, int i10, String str21, String str22, String str23, int i11, int i12, int i13, int i14, String str24, String str25, String str26, List<FeedReply> list2, int i15, List<RelatedData> list3, List<RelatedData> list4, List<RelatedData> list5, String str27, Collection collection, CollectionItem collectionItem, UserAction userAction, List<FeedReply> list6, List<FeedReply> list7, List<FeedReply> list8, List<String> list9, List<GoodsListItem> list10, Feed feed, DyhArticle dyhArticle, String str28, String str29, String str30, String str31, long j, UserInfo userInfo2, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, int i16, int i17, int i18, int i19, long j2, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, List<FeedRelation> list11, FeedTarget feedTarget, int i20, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, String str59, String str60, List<Entity> list12, String str61, String str62, String str63, String str64, String str65, String str66, String str67, int i21, String str68, String str69, int i22, DyhModel dyhModel, String str70, String str71, String str72, String str73, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, String str74, String str75, String str76, String str77, String str78, String str79, String str80, String str81, Entity entity, Entity entity2, Entity entity3, int i23, List<FeedReply> list13, FeedGoodsAction feedGoodsAction, String str82, int i24, int i25, int i26, Vote vote, SecondHandInfo secondHandInfo, int i27, SimpleInfo simpleInfo, SimpleInfo simpleInfo2, int i28, int i29, int i30) {
        super(str, str2, str3, str4, num, str5, str6, str7, l2, l3, str8, userInfo, str9, str10, str11, str12, str13, str14, i, str15, list, str16, str17, i2, i3, i4, i5, i6, i7, str18, str19, i8, str20, i9, i10, str21, str22, str23, i11, i12, i13, i14, str24, str25, str26, list2, i15, list3, list4, list5, str27, collection, collectionItem, userAction, list6, list7, list8, list9, list10, feed, dyhArticle, str28, str29, str30, str31, j, userInfo2, str32, str33, str34, str35, str36, str37, str38, str39, str40, i16, i17, i18, i19, j2, str41, str42, str43, str44, str45, str46, str47, str48, list11, feedTarget, i20, str49, str50, str51, str52, str53, str54, str55, str56, str57, str58, str59, str60, list12, str61, str62, str63, str64, str65, str66, str67, i21, str68, str69, i22, dyhModel, str70, str71, str72, str73, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, str74, str75, str76, str77, str78, str79, str80, str81, entity, entity2, entity3, i23, list13, feedGoodsAction, str82, i24, i25, i26, vote, secondHandInfo, i27, simpleInfo, simpleInfo2, i28, i29, i30);
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
        parcel.writeString(getTitle());
        parcel.writeString(getId());
        if (getLabel() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLabel());
        }
        parcel.writeInt(getType());
        parcel.writeString(getPic());
        parcel.writeList(getPicArray());
        parcel.writeString(getInfoHtml());
        parcel.writeString(getInfo());
        parcel.writeInt(getForwardNum());
        parcel.writeInt(getShareNum());
        parcel.writeInt(getLikeNum());
        parcel.writeInt(getReplyNum());
        parcel.writeInt(getRelatedNum());
        parcel.writeInt(getFollowNum());
        if (getUseragent() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUseragent());
        }
        if (getArticleId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getArticleId());
        }
        parcel.writeInt(getStatus());
        parcel.writeString(getMessage());
        parcel.writeInt(getIsHtmlArticle());
        parcel.writeInt(getIsStickTop());
        if (getMessageRawOutput() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageRawOutput());
        }
        if (getMessageRawInput() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageRawInput());
        }
        if (getFeedTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFeedTypeName());
        }
        parcel.writeInt(getRecommend());
        parcel.writeInt(getFavoriteNum());
        parcel.writeInt(getCommentBlockNum());
        parcel.writeInt(getBlockStatus());
        if (getFeedFromType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFeedFromType());
        }
        parcel.writeString(getFeedType());
        parcel.writeString(getFetchType());
        parcel.writeList(getReplyRows());
        parcel.writeInt(getMessageStatus());
        parcel.writeList(getRelatedData());
        parcel.writeList(getUserLikeList());
        parcel.writeList(getUserFollowList());
        if (getDeviceTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeviceTitle());
        }
        parcel.writeParcelable(getCollectionInfo(), i);
        parcel.writeParcelable(getCollectionItem(), i);
        parcel.writeParcelable(getUserAction(), i);
        parcel.writeList(getReplyMeRows());
        parcel.writeList(getRecentReplyRows());
        parcel.writeList(getHotReplyRows());
        parcel.writeList(getRecentLikeList());
        parcel.writeList(getGoodsListItem());
        parcel.writeParcelable(getForwardSourceFeed(), i);
        parcel.writeParcelable(getForwardSourceArticle(), i);
        if (getForwardSourceType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getForwardSourceType());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
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
        parcel.writeParcelable(getLikeUserInfo(), i);
        if (getLikeAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLikeAvatar());
        }
        if (getForwardId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getForwardId());
        }
        if (getSourceId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSourceId());
        }
        if (getSpamReason() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSpamReason());
        }
        if (getSpamContent() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSpamContent());
        }
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
        if (getBlockStatusText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBlockStatusText());
        }
        parcel.writeInt(getIsHeadline());
        parcel.writeInt(getIsHeadlined());
        parcel.writeInt(getIsHeadlineV8());
        parcel.writeInt(getIsHeadlineCommentV8());
        parcel.writeLong(getSpamTime());
        parcel.writeString(getAppName());
        if (getTkey() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTkey());
        }
        if (getTtype() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTtype());
        }
        if (getTid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTid());
        }
        if (getTUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTUrl());
        }
        if (getTpic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTpic());
        }
        if (getTinfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTinfo());
        }
        if (getTlink() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTlink());
        }
        parcel.writeList(getRelationRows());
        parcel.writeParcelable(getTargetRow(), i);
        parcel.writeInt(getStar());
        if (getFid() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFid());
        }
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
        if (getUserTags() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUserTags());
        }
        if (getKeywords() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getKeywords());
        }
        if (getExtraKey() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraKey());
        }
        if (getExtraTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraTitle());
        }
        if (getExtraType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraType());
        }
        if (getExtraUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraUrl());
        }
        if (getExtraInfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraInfo());
        }
        if (getExtraLinkUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraLinkUrl());
        }
        if (getExtraPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraPic());
        }
        parcel.writeList(getExtraEntities());
        if (getVideoPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVideoPic());
        }
        if (getVideoUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getVideoUrl());
        }
        if (getLocation() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLocation());
        }
        if (getLongLocation() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLongLocation());
        }
        if (getMessageTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageTitle());
        }
        if (getMessageKeywords() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageKeywords());
        }
        if (getMessageCover() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageCover());
        }
        parcel.writeInt(getQuestionAnswerNum());
        if (getTags() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTags());
        }
        if (getMessageSource() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageSource());
        }
        parcel.writeInt(getQuestionFollowNum());
        parcel.writeParcelable(getDyhModel(), i);
        if (getMediaInfo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMediaInfo());
        }
        if (getMediaUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMediaUrl());
        }
        if (getMediaType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMediaType());
        }
        if (getRatingType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRatingType());
        }
        parcel.writeFloat(getRatingScore());
        parcel.writeFloat(getRatingScore1());
        parcel.writeFloat(getRatingScore2());
        parcel.writeFloat(getRatingScore3());
        parcel.writeFloat(getRatingScore4());
        parcel.writeFloat(getRatingScore5());
        parcel.writeFloat(getRatingScore6());
        parcel.writeFloat(getRatingScore7());
        parcel.writeFloat(getRatingScore8());
        parcel.writeFloat(getRatingScore9());
        parcel.writeFloat(getRatingScore10());
        if (getCommentGood() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCommentGood());
        }
        if (getCommentGoodPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCommentGoodPic());
        }
        if (getCommentBad() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCommentBad());
        }
        if (getCommentBadPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCommentBadPic());
        }
        if (getCommentGeneral() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCommentGeneral());
        }
        if (getCommentGeneralPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCommentGeneralPic());
        }
        if (getExtraFromApi() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraFromApi());
        }
        if (getShareUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getShareUrl());
        }
        parcel.writeParcelable(getDetailSponsorCard(), i);
        parcel.writeParcelable(getHotSponsorCard(), i);
        parcel.writeParcelable(getNoticeSponsorCard(), i);
        parcel.writeInt(getBuyStatus());
        parcel.writeList(getTopReplyRows());
        parcel.writeParcelable(getGoodsAction(), i);
        if (getEditorTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEditorTitle());
        }
        parcel.writeInt(getIsOwner());
        parcel.writeInt(getShowOwner());
        parcel.writeInt(getIsAnonymous());
        parcel.writeParcelable(getVote(), i);
        parcel.writeParcelable(getSecondHandInfo(), i);
        parcel.writeInt(getIsRecommendVoteComment());
        parcel.writeParcelable(getTopInfo(), i);
        parcel.writeParcelable(getInnerInfo(), i);
        parcel.writeInt(getIsModified());
        parcel.writeInt(getEnableModify());
        parcel.writeInt(getIsHistory());
    }
}
