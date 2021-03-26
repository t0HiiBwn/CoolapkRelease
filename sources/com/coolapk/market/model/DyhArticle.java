package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_DyhArticle;
import com.coolapk.market.model.C$AutoValue_DyhArticle;
import com.coolapk.market.model.IUser;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class DyhArticle implements Entity, IUser {

    public static abstract class Builder implements IUser.BuilderM2<Builder> {
        public abstract Builder adminInfo(String str);

        public abstract Builder author(String str);

        public abstract Builder blockStatus(int i);

        public abstract Builder blockStatusText(String str);

        public abstract DyhArticle build();

        public abstract Builder collectionInfo(Collection collection);

        public abstract Builder collectionItem(CollectionItem collectionItem);

        public abstract Builder commentNum(int i);

        public abstract Builder content(String str);

        public abstract Builder creatDate(Long l);

        public abstract Builder dateline(Long l);

        public abstract Builder description(String str);

        public abstract Builder dyhId(String str);

        public abstract Builder dyhModel(DyhModel dyhModel);

        public abstract Builder dyhName(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityType(String str);

        public abstract Builder entityTypeId(int i);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder favNum(int i);

        public abstract Builder feedId(String str);

        public abstract Builder forwardNum(int i);

        public abstract Builder fromInfo(String str);

        public abstract Builder id(String str);

        public abstract Builder isHeadline(int i);

        public abstract Builder isHeadlineV8(int i);

        public abstract Builder isHtmlArticle(int i);

        public abstract Builder isStickTop(int i);

        public abstract Builder keywords(String str);

        public abstract Builder lastUpdate(Long l);

        public abstract Builder likeNum(int i);

        public abstract Builder logo(String str);

        public abstract Builder message(String str);

        public abstract Builder messageStatus(int i);

        public abstract Builder messageStatusText(String str);

        public abstract Builder pic(String str);

        public abstract Builder picArr(List<String> list);

        public abstract Builder rawUrl(String str);

        public abstract Builder recommend(int i);

        public abstract Builder redirectUrl(String str);

        public abstract Builder replyMeRows(List<FeedReply> list);

        public abstract Builder replyNum(int i);

        public abstract Builder shareNum(int i);

        public abstract Builder status(int i);

        public abstract Builder statusText(String str);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public abstract Builder uid(String str);

        public abstract Builder url(String str);

        public abstract Builder urlMD5(String str);

        public abstract Builder userAction(UserAction userAction);

        public abstract Builder videoUrl(String str);
    }

    @SerializedName("adminInfo")
    public abstract String getAdminInfo();

    @SerializedName("author")
    public abstract String getAuthor();

    @SerializedName("block_status")
    public abstract int getBlockStatus();

    @SerializedName("blockStatusText")
    public abstract String getBlockStatusText();

    @SerializedName("collection_info")
    public abstract Collection getCollectionInfo();

    @SerializedName("collection_item_info")
    public abstract CollectionItem getCollectionItem();

    @SerializedName("commentnum")
    public abstract int getCommentNum();

    @SerializedName("content")
    public abstract String getContent();

    @SerializedName("createdate")
    public abstract Long getCreatDate();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public abstract String getDescription();

    @SerializedName("dyh_id")
    public abstract String getDyhId();

    @SerializedName("dyh_info")
    public abstract DyhModel getDyhModel();

    @SerializedName("dyh_name")
    public abstract String getDyhName();

    @SerializedName("favnum")
    public abstract int getFavNum();

    @SerializedName("feed_id")
    public abstract String getFeedId();

    @SerializedName("forwardnum")
    public abstract int getForwardNum();

    @SerializedName("fromInfo")
    public abstract String getFromInfo();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    @SerializedName("isHeadline")
    public abstract int getIsHeadline();

    @SerializedName("isHeadlineV8")
    public abstract int getIsHeadlineV8();

    @SerializedName("is_html_article")
    public abstract int getIsHtmlArticle();

    @SerializedName("isStickTop")
    public abstract int getIsStickTop();

    @SerializedName("keywords")
    public abstract String getKeywords();

    @SerializedName("likenum")
    public abstract int getLikeNum();

    @SerializedName("message")
    public abstract String getMessage();

    @SerializedName("message_status")
    public abstract int getMessageStatus();

    @SerializedName("messageStatusText")
    public abstract String getMessageStatusText();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public abstract String getPic();

    @SerializedName("picArr")
    public abstract List<String> getPicArr();

    @SerializedName("rawUrl")
    public abstract String getRawUrl();

    public abstract int getRecommend();

    @SerializedName("redirectUrl")
    public abstract String getRedirectUrl();

    public abstract List<FeedReply> getReplyMeRows();

    @SerializedName("replynum")
    public abstract int getReplyNum();

    @SerializedName("share_num")
    public abstract int getShareNum();

    @SerializedName("status")
    public abstract int getStatus();

    @SerializedName("statusText")
    public abstract String getStatusText();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public abstract String getTitle();

    @Override // com.coolapk.market.model.IUser
    @SerializedName("uid")
    public abstract String getUid();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public abstract String getUrl();

    @SerializedName("url_md5")
    public abstract String getUrlMD5();

    public abstract UserAction getUserAction();

    @SerializedName("video_url")
    public abstract String getVideoUrl();

    public String getDyhShortName() {
        return StringUtils.getShortString(getDyhName(), 12);
    }

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public String getFinalMessage() {
        return getMessage().replace("\n\n", "");
    }

    public boolean isTop() {
        return getIsStickTop() == 1 || isCollectionTop();
    }

    public boolean isCollectionTop() {
        return getCollectionItem() != null && getCollectionItem().isTop();
    }

    public String getShowFromInfo() {
        if (!TextUtils.isEmpty(getFromInfo())) {
            return getFromInfo();
        }
        if (getDyhModel() == null || TextUtils.isEmpty(getDyhModel().getFromInfo())) {
            return null;
        }
        return getDyhModel().getFromInfo();
    }

    public boolean getIsV8Headline() {
        return getIsHeadlineV8() > 0;
    }

    public boolean isLiked() {
        return getUserAction() != null && getUserAction().getLike() > 0;
    }

    public boolean isFavorite() {
        return getUserAction() != null && getUserAction().getFavorite() > 0;
    }

    public String getThumbnailPic() {
        if (CollectionUtils.isEmpty(getPicArr()) || TextUtils.isEmpty(getPicArr().get(0))) {
            return null;
        }
        return getPicArr().get(0) + ".s.jpg";
    }

    public String getThumbSquarePic() {
        if (CollectionUtils.isEmpty(getPicArr()) || TextUtils.isEmpty(getPicArr().get(0))) {
            return null;
        }
        return getPicArr().get(0) + ".xs.jpg";
    }

    public String getMiddleSizePic() {
        if (CollectionUtils.isEmpty(getPicArr()) || TextUtils.isEmpty(getPicArr().get(0))) {
            return null;
        }
        return getPicArr().get(0) + ".m.jpg";
    }

    public static TypeAdapter<DyhArticle> typeAdapter(Gson gson) {
        return new C$AutoValue_DyhArticle.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_DyhArticle.Builder();
    }

    public static Builder newBuilder(DyhArticle dyhArticle) {
        if (dyhArticle == null) {
            return newBuilder();
        }
        return new C$$AutoValue_DyhArticle.Builder(dyhArticle);
    }
}
