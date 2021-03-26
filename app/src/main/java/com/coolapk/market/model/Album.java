package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_Album;
import com.coolapk.market.model.C$AutoValue_Album;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class Album implements Entity, IUser {

    public static abstract class Builder implements IUser.BuilderM2<Builder> {
        public abstract Builder albumHotReplies(List<FeedReply> list);

        public abstract Builder albumItems(List<AlbumItem> list);

        public abstract Builder albumUrl(String str);

        public abstract Album build();

        public abstract Builder collectionInfo(Collection collection);

        public abstract Builder collectionItem(CollectionItem collectionItem);

        public abstract Builder commentBlockNum(int i);

        public abstract Builder commentNum(int i);

        public abstract Builder dateline(Long l2);

        public abstract Builder description(String str);

        public abstract Builder deviceTitle(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder favoriteNum(int i);

        public abstract Builder feedId(String str);

        public abstract Builder feedStatus(FeedStatus feedStatus);

        public abstract Builder forwardNum(int i);

        public abstract Builder icon(String str);

        public abstract Builder id(String str);

        public abstract Builder info(String str);

        public abstract Builder infoHtml(String str);

        public abstract Builder innerInfo(SimpleInfo simpleInfo);

        public abstract Builder introduce(String str);

        public abstract Builder isStickTop(int i);

        public abstract Builder keyWords(String str);

        public abstract Builder lastUpdate(Long l2);

        public abstract Builder likeAvatar(String str);

        public abstract Builder likeNum(int i);

        public abstract Builder likeTime(long j);

        public abstract Builder likeUid(String str);

        public abstract Builder likeUserInfo(UserInfo userInfo);

        public abstract Builder likeUserName(String str);

        public abstract Builder logo(String str);

        public abstract Builder moreCount(String str);

        public abstract Builder pic(String str);

        public abstract Builder recommend(int i);

        public abstract Builder replyMeRows(List<FeedReply> list);

        public abstract Builder replyNum(int i);

        public abstract Builder shareNum(int i);

        public abstract Builder status(int i);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        public abstract Builder topInfo(SimpleInfo simpleInfo);

        public abstract Builder totalApkNum(int i);

        public abstract Builder url(String str);

        public abstract Builder userAction(UserAction userAction);
    }

    public abstract List<FeedReply> getAlbumHotReplies();

    @SerializedName("apkRows")
    public abstract List<AlbumItem> getAlbumItems();

    public abstract String getAlbumUrl();

    @SerializedName("collection_info")
    public abstract Collection getCollectionInfo();

    @SerializedName("collection_item_info")
    public abstract CollectionItem getCollectionItem();

    @SerializedName("comment_block_num")
    public abstract int getCommentBlockNum();

    @SerializedName("commentnum")
    public abstract int getCommentNum();

    @Override // com.coolapk.market.model.Entity
    public abstract String getDescription();

    @SerializedName("device_title")
    public abstract String getDeviceTitle();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "album";
    }

    @SerializedName("favnum")
    public abstract int getFavoriteNum();

    @SerializedName("feedid")
    public abstract String getFeedId();

    public abstract FeedStatus getFeedStatus();

    @SerializedName("forwardnum")
    public abstract int getForwardNum();

    @SerializedName("icon")
    public abstract String getIcon();

    public abstract String getInfo();

    public abstract String getInfoHtml();

    public abstract SimpleInfo getInnerInfo();

    @SerializedName("intro")
    public abstract String getIntroduce();

    @SerializedName("isStickTop")
    public abstract int getIsStickTop();

    @SerializedName("keywords")
    public abstract String getKeyWords();

    public abstract String getLikeAvatar();

    @SerializedName("likenum")
    public abstract int getLikeNum();

    public abstract long getLikeTime();

    public abstract String getLikeUid();

    @SerializedName("likeUserInfo")
    public abstract UserInfo getLikeUserInfo();

    @SerializedName("likeUsername")
    public abstract String getLikeUserName();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

    @SerializedName("apkRowsMoreCount")
    public abstract String getMoreCount();

    public abstract int getRecommend();

    public abstract List<FeedReply> getReplyMeRows();

    @SerializedName("replynum")
    public abstract int getReplyNum();

    @SerializedName("share_num")
    public abstract int getShareNum();

    public abstract int getStatus();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public abstract String getTitle();

    public abstract SimpleInfo getTopInfo();

    @SerializedName("apknum")
    public abstract int getTotalApkNum();

    public abstract UserAction getUserAction();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getAlbumId() {
        return getId();
    }

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public String getUserAvatar() {
        return IUser.IUserGetter.getUserAvatar(this);
    }

    public boolean isCollectionTop() {
        return getCollectionItem() != null && getCollectionItem().isTop();
    }

    public String getStatusText() {
        return getFeedStatus() != null ? getFeedStatus().getStatusText() : "";
    }

    public String getMessageStatusText() {
        return getFeedStatus() != null ? getFeedStatus().getMessageStatusText() : "";
    }

    public String getBlockStatusText() {
        return getFeedStatus() != null ? getFeedStatus().getBlockStatusText() : "";
    }

    public int getIsHeadlineV8() {
        if (getFeedStatus() != null) {
            return getFeedStatus().getIsHeadlineV8();
        }
        return 0;
    }

    public boolean getIsV8Headline() {
        return getIsHeadlineV8() > 0;
    }

    public int getMessageStatus() {
        if (getFeedStatus() != null) {
            return getFeedStatus().getMessageStatus();
        }
        return 0;
    }

    public int getBlockStatus() {
        if (getFeedStatus() != null) {
            return getFeedStatus().getBlockStatus();
        }
        return 0;
    }

    public boolean isTop() {
        return getIsStickTop() == 1 || isCollectionTop();
    }

    public static TypeAdapter<Album> typeAdapter(Gson gson) {
        return new C$AutoValue_Album.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_Album.Builder().id("").feedId("");
    }

    public static Builder newBuilder(Album album) {
        return new C$$AutoValue_Album.Builder(album);
    }
}
