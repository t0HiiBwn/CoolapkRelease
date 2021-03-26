package com.coolapk.market.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_FeedReply;
import com.coolapk.market.model.C$$AutoValue_FeedReply_ReplyUserAction;
import com.coolapk.market.model.C$AutoValue_FeedReply;
import com.coolapk.market.model.C$AutoValue_FeedReply_ReplyFeed;
import com.coolapk.market.model.C$AutoValue_FeedReply_ReplyUserAction;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class FeedReply implements Entity, IUser {

    public static abstract class Builder implements IUser.BuilderM1<Builder> {
        public abstract FeedReply build();

        public abstract Builder setAdminInfo(String str);

        public abstract Builder setBlockStatus(int i);

        public abstract Builder setBlockStatusText(String str);

        public abstract Builder setDateline(Long l2);

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public abstract Builder setDeprecatedUserName(String str);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setExtraFlag(String str);

        public abstract Builder setExtraPic(String str);

        public abstract Builder setExtraTitle(String str);

        public abstract Builder setExtraType(String str);

        public abstract Builder setExtraUrl(String str);

        public abstract Builder setFeedId(String str);

        public abstract Builder setFetchType(String str);

        public abstract Builder setFtype(int i);

        public abstract Builder setId(String str);

        public abstract Builder setInfoHtml(String str);

        public abstract Builder setInnerInfo(SimpleInfo simpleInfo);

        public abstract Builder setIsFeedAuthor(int i);

        public abstract Builder setIsFolded(int i);

        public abstract Builder setLastUpdate(Long l2);

        public abstract Builder setLikeAvatar(String str);

        public abstract Builder setLikeNum(int i);

        public abstract Builder setLikeTime(long j);

        public abstract Builder setLikeUid(String str);

        public abstract Builder setLikeUserInfo(UserInfo userInfo);

        public abstract Builder setLikeUserName(String str);

        public abstract Builder setLogo(String str);

        public abstract Builder setMessage(String str);

        public abstract Builder setMessageSource(String str);

        public abstract Builder setMessageStatus(int i);

        public abstract Builder setMessageStatusText(String str);

        public abstract Builder setParentReplyId(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setReplyArticle(DyhArticle dyhArticle);

        public abstract Builder setReplyFeed(ReplyFeed replyFeed);

        public abstract Builder setReplyId(int i);

        public abstract Builder setReplyNum(int i);

        public abstract Builder setReplyRows(List<FeedReply> list);

        public abstract Builder setReplyRowsCount(int i);

        public abstract Builder setReplyRowsMore(int i);

        public abstract Builder setReplyUid(String str);

        public abstract Builder setReplyUserAvatar(String str);

        public abstract Builder setReplyUserName(String str);

        public abstract Builder setSpamContent(String str);

        public abstract Builder setSpamReason(String str);

        public abstract Builder setSpamTime(long j);

        public abstract Builder setStatus(int i);

        public abstract Builder setStatusText(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public abstract Builder setUid(String str);

        public abstract Builder setUrl(String str);

        public abstract Builder setUserAction(ReplyUserAction replyUserAction);

        public abstract Builder setUserAgent(String str);

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public abstract Builder setUserInfo(UserInfo userInfo);
    }

    @SerializedName("adminInfo")
    public abstract String getAdminInfo();

    @SerializedName("block_status")
    public abstract int getBlockStatus();

    @SerializedName("blockStatusText")
    public abstract String getBlockStatusText();

    @Override // com.coolapk.market.model.IUser
    @SerializedName("username")
    public abstract String getDeprecatedUserName();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "feed_reply";
    }

    public abstract String getExtraFlag();

    @SerializedName("extra_pic")
    public abstract String getExtraPic();

    @SerializedName("extra_title")
    public abstract String getExtraTitle();

    @SerializedName("extra_type")
    public abstract String getExtraType();

    @SerializedName("extra_url")
    public abstract String getExtraUrl();

    @SerializedName("fid")
    public abstract String getFeedId();

    @SerializedName("fetchType")
    public abstract String getFetchType();

    @SerializedName("ftype")
    public abstract int getFtype();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    public abstract String getInfoHtml();

    public abstract SimpleInfo getInnerInfo();

    @SerializedName("isFeedAuthor")
    public abstract int getIsFeedAuthor();

    @SerializedName("is_folded")
    public abstract int getIsFolded();

    public abstract String getLikeAvatar();

    @SerializedName("likenum")
    public abstract int getLikeNum();

    public abstract long getLikeTime();

    public abstract String getLikeUid();

    @SerializedName("likeUserInfo")
    public abstract UserInfo getLikeUserInfo();

    @SerializedName("likeUsername")
    public abstract String getLikeUserName();

    public abstract String getMessage();

    @SerializedName("messagesource")
    public abstract String getMessageSource();

    @SerializedName("message_status")
    public abstract int getMessageStatus();

    @SerializedName("messageStatusText")
    public abstract String getMessageStatusText();

    @SerializedName("rrid")
    public abstract String getParentReplyId();

    @Override // com.coolapk.market.model.Entity
    public abstract String getPic();

    @SerializedName("article")
    public abstract DyhArticle getReplyArticle();

    @SerializedName("feed")
    public abstract ReplyFeed getReplyFeed();

    @SerializedName("rid")
    public abstract int getReplyId();

    @SerializedName("replynum")
    public abstract int getReplyNum();

    @SerializedName("replyRows")
    public abstract List<FeedReply> getReplyRows();

    @SerializedName("replyRowsCount")
    public abstract int getReplyRowsCount();

    @SerializedName("replyRowsMore")
    public abstract int getReplyRowsMore();

    @SerializedName("ruid")
    public abstract String getReplyUid();

    @SerializedName("ravatar")
    public abstract String getReplyUserAvatar();

    @SerializedName("rusername")
    public abstract String getReplyUserName();

    public abstract String getSpamContent();

    public abstract String getSpamReason();

    public abstract long getSpamTime();

    public abstract int getStatus();

    @SerializedName("statusText")
    public abstract String getStatusText();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    @Override // com.coolapk.market.model.Entity
    public abstract String getUrl();

    @SerializedName("userAction")
    public abstract ReplyUserAction getUserAction();

    @SerializedName("useragent")
    public abstract String getUserAgent();

    @Override // com.coolapk.market.model.IUser
    public abstract UserInfo getUserInfo();

    public static TypeAdapter<FeedReply> typeAdapter(Gson gson) {
        return new C$AutoValue_FeedReply.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$$AutoValue_FeedReply.Builder();
    }

    public static Builder builder(FeedReply feedReply) {
        return new C$$AutoValue_FeedReply.Builder(feedReply);
    }

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public String getReplyType() {
        return getFtype() == 1 ? "article_reply" : "feed_reply";
    }

    public String getUserAvatar() {
        return IUser.IUserGetter.getUserAvatar(this);
    }

    public boolean hasParentReply() {
        return !TextUtils.isEmpty(getParentReplyId()) && !TextUtils.equals("0", getParentReplyId());
    }

    public boolean hasLike() {
        if (getUserAction() != null && getUserAction().getLike() > 0) {
            return true;
        }
        return false;
    }

    public String getXsPic() {
        String pic = getPic();
        if (TextUtils.isEmpty(pic)) {
            return null;
        }
        return pic + ".xs.jpg";
    }

    public String getMiddleSizePic() {
        if (TextUtils.isEmpty(getPic())) {
            return null;
        }
        return getPic() + ".m.jpg";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public int getIsAnonymous() {
        return (TextUtils.equals(getUid(), "999") || TextUtils.equals(getDisplayUserName(), "匿名酷友")) ? 1 : 0;
    }

    public boolean hasOtherReplyUser() {
        return !TextUtils.isEmpty(getReplyUid()) && Integer.parseInt(getReplyUid()) > 0 && !TextUtils.equals(getUid(), getReplyUid()) && !TextUtils.isEmpty(getReplyUserName());
    }

    public static abstract class ReplyUserAction implements Parcelable {

        public static abstract class Builder {
            public abstract ReplyUserAction build();

            public abstract Builder like(int i);
        }

        public abstract int getLike();

        public static TypeAdapter<ReplyUserAction> typeAdapter(Gson gson) {
            return new C$AutoValue_FeedReply_ReplyUserAction.GsonTypeAdapter(gson);
        }

        public static Builder newBuilder() {
            return new C$$AutoValue_FeedReply_ReplyUserAction.Builder();
        }

        public static Builder newBuilder(ReplyUserAction replyUserAction) {
            return new C$$AutoValue_FeedReply_ReplyUserAction.Builder(replyUserAction);
        }
    }

    public static abstract class ReplyFeed implements Parcelable, IUser {
        public abstract String getId();

        public abstract String getMessage();

        public abstract String getPic();

        @Override // com.coolapk.market.model.IUser
        public abstract String getUid();

        public abstract String getUrl();

        public static TypeAdapter<ReplyFeed> typeAdapter(Gson gson) {
            return new C$AutoValue_FeedReply_ReplyFeed.GsonTypeAdapter(gson);
        }

        public String getUserName() {
            return IUser.IUserGetter.getUserName(this);
        }

        public String getXsPic() {
            String pic = getPic();
            if (TextUtils.isEmpty(pic)) {
                return null;
            }
            return pic + ".xs.jpg";
        }
    }
}
