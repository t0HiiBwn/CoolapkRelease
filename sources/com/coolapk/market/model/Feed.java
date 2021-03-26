package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.C$$AutoValue_Feed;
import com.coolapk.market.model.C$AutoValue_Feed;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class Feed implements Entity, IUser {
    public static final String DETAIL_SPONSOR_CARD = "detailSponsorCard";
    public static final String FETCH_TYPE_CIRCLE = "circle";
    public static final String FETCH_TYPE_RECENT = "recent";
    public static final String FIELD_EXTRA_ENTITIES = "extra_entities";
    public static final String HOT_SPONSOR_CARD = "hotSponsorCard";
    public static final String NOTICE_SPONSOR_CARD = "noticeSponsorCard";

    public static abstract class Builder implements IUser.BuilderM2<Builder> {
        public abstract Builder TUrl(String str);

        public abstract Builder adminInfo(String str);

        public abstract Builder appName(String str);

        public abstract Builder articleId(String str);

        public abstract Builder blockStatus(int i);

        public abstract Builder blockStatusText(String str);

        public abstract Feed build();

        public abstract Builder buyStatus(int i);

        public abstract Builder collectionInfo(Collection collection);

        public abstract Builder collectionItem(CollectionItem collectionItem);

        public abstract Builder commentBad(String str);

        public abstract Builder commentBadPic(String str);

        public abstract Builder commentBlockNum(int i);

        public abstract Builder commentGeneral(String str);

        public abstract Builder commentGeneralPic(String str);

        public abstract Builder commentGood(String str);

        public abstract Builder commentGoodPic(String str);

        public abstract Builder dateline(Long l2);

        public abstract Builder description(String str);

        public abstract Builder detailSponsorCard(Entity entity);

        public abstract Builder deviceTitle(String str);

        public abstract Builder dyhId(String str);

        public abstract Builder dyhModel(DyhModel dyhModel);

        public abstract Builder dyhName(String str);

        public abstract Builder editorTitle(String str);

        public abstract Builder enableModify(int i);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityType(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder extraEntities(List<Entity> list);

        public abstract Builder extraFromApi(String str);

        public abstract Builder extraInfo(String str);

        public abstract Builder extraKey(String str);

        public abstract Builder extraLinkUrl(String str);

        public abstract Builder extraPic(String str);

        public abstract Builder extraTitle(String str);

        public abstract Builder extraType(String str);

        public abstract Builder extraUrl(String str);

        public abstract Builder favoriteNum(int i);

        public abstract Builder feedFromType(String str);

        public abstract Builder feedType(String str);

        public abstract Builder feedTypeName(String str);

        public abstract Builder fetchType(String str);

        public abstract Builder fid(String str);

        public abstract Builder followNum(int i);

        public abstract Builder forwardId(String str);

        public abstract Builder forwardNum(int i);

        public abstract Builder forwardSourceArticle(DyhArticle dyhArticle);

        public abstract Builder forwardSourceFeed(Feed feed);

        public abstract Builder forwardSourceType(String str);

        public abstract Builder goodsAction(FeedGoodsAction feedGoodsAction);

        public abstract Builder goodsListItem(List<GoodsListItem> list);

        public abstract Builder hotReplyRows(List<FeedReply> list);

        public abstract Builder hotSponsorCard(Entity entity);

        public abstract Builder id(String str);

        public abstract Builder info(String str);

        public abstract Builder infoHtml(String str);

        public abstract Builder innerInfo(SimpleInfo simpleInfo);

        public abstract Builder isAnonymous(int i);

        public abstract Builder isHeadline(int i);

        public abstract Builder isHeadlineCommentV8(int i);

        public abstract Builder isHeadlineV8(int i);

        public abstract Builder isHeadlined(int i);

        public abstract Builder isHistory(int i);

        public abstract Builder isHtmlArticle(int i);

        public abstract Builder isModified(int i);

        public abstract Builder isOwner(int i);

        public abstract Builder isRecommendVoteComment(int i);

        public abstract Builder isStickTop(int i);

        public abstract Builder keywords(String str);

        public abstract Builder label(String str);

        public abstract Builder lastUpdate(Long l2);

        public abstract Builder likeAvatar(String str);

        public abstract Builder likeNum(int i);

        public abstract Builder likeTime(long j);

        public abstract Builder likeUid(String str);

        public abstract Builder likeUserInfo(UserInfo userInfo);

        public abstract Builder likeUserName(String str);

        public abstract Builder location(String str);

        public abstract Builder longLocation(String str);

        public abstract Builder mediaInfo(String str);

        public abstract Builder mediaType(String str);

        public abstract Builder mediaUrl(String str);

        public abstract Builder message(String str);

        public abstract Builder messageCover(String str);

        public abstract Builder messageKeywords(String str);

        public abstract Builder messageRawInput(String str);

        public abstract Builder messageRawOutput(String str);

        public abstract Builder messageSource(String str);

        public abstract Builder messageStatus(int i);

        public abstract Builder messageStatusText(String str);

        public abstract Builder messageTitle(String str);

        public abstract Builder noticeSponsorCard(Entity entity);

        public abstract Builder pic(String str);

        public abstract Builder picArray(List<String> list);

        public abstract Builder questionAnswerNum(int i);

        public abstract Builder questionFollowNum(int i);

        public abstract Builder ratingScore(float f);

        public abstract Builder ratingScore1(float f);

        public abstract Builder ratingScore10(float f);

        public abstract Builder ratingScore2(float f);

        public abstract Builder ratingScore3(float f);

        public abstract Builder ratingScore4(float f);

        public abstract Builder ratingScore5(float f);

        public abstract Builder ratingScore6(float f);

        public abstract Builder ratingScore7(float f);

        public abstract Builder ratingScore8(float f);

        public abstract Builder ratingScore9(float f);

        public abstract Builder ratingType(String str);

        public abstract Builder recentLikeList(List<String> list);

        public abstract Builder recentReplyRows(List<FeedReply> list);

        public abstract Builder recommend(int i);

        public abstract Builder relatedData(List<RelatedData> list);

        public abstract Builder relatedNum(int i);

        public abstract Builder relationRows(List<FeedRelation> list);

        public abstract Builder replyMeRows(List<FeedReply> list);

        public abstract Builder replyNum(int i);

        public abstract Builder replyRows(List<FeedReply> list);

        public abstract Builder secondHandInfo(SecondHandInfo secondHandInfo);

        public abstract Builder shareNum(int i);

        public abstract Builder shareUrl(String str);

        public abstract Builder showOwner(int i);

        public abstract Builder sourceId(String str);

        public abstract Builder spamContent(String str);

        public abstract Builder spamReason(String str);

        public abstract Builder spamTime(long j);

        public abstract Builder star(int i);

        public abstract Builder status(int i);

        public abstract Builder statusText(String str);

        public abstract Builder subTitle(String str);

        public abstract Builder tags(String str);

        public abstract Builder targetRow(FeedTarget feedTarget);

        public abstract Builder tid(String str);

        public abstract Builder tinfo(String str);

        public abstract Builder title(String str);

        public abstract Builder tkey(String str);

        public abstract Builder tlink(String str);

        public abstract Builder topInfo(SimpleInfo simpleInfo);

        public abstract Builder topReplyRows(List<FeedReply> list);

        public abstract Builder tpic(String str);

        public abstract Builder ttype(String str);

        public abstract Builder type(int i);

        public abstract Builder url(String str);

        public abstract Builder userAction(UserAction userAction);

        public abstract Builder userFollowList(List<RelatedData> list);

        public abstract Builder userLikeList(List<RelatedData> list);

        public abstract Builder userTags(String str);

        public abstract Builder useragent(String str);

        public abstract Builder videoPic(String str);

        public abstract Builder videoUrl(String str);

        public abstract Builder vote(Vote vote);
    }

    @SerializedName("adminInfo")
    public abstract String getAdminInfo();

    @SerializedName("ttitle")
    public abstract String getAppName();

    @SerializedName("articleId")
    public abstract String getArticleId();

    @SerializedName("block_status")
    public abstract int getBlockStatus();

    @SerializedName("blockStatusText")
    public abstract String getBlockStatusText();

    @SerializedName("buy_status")
    public abstract int getBuyStatus();

    @SerializedName("collection_info")
    public abstract Collection getCollectionInfo();

    @SerializedName("collection_item_info")
    public abstract CollectionItem getCollectionItem();

    @SerializedName("comment_bad")
    public abstract String getCommentBad();

    @SerializedName("comment_bad_pic")
    public abstract String getCommentBadPic();

    @SerializedName("comment_block_num")
    public abstract int getCommentBlockNum();

    @SerializedName("comment_general")
    public abstract String getCommentGeneral();

    @SerializedName("comment_general_pic")
    public abstract String getCommentGeneralPic();

    @SerializedName("comment_good")
    public abstract String getCommentGood();

    @SerializedName("comment_good_pic")
    public abstract String getCommentGoodPic();

    @SerializedName("detailSponsorCard")
    public abstract Entity getDetailSponsorCard();

    @SerializedName("device_title")
    public abstract String getDeviceTitle();

    @SerializedName("dyh_id")
    public abstract String getDyhId();

    @SerializedName("dyh_info")
    public abstract DyhModel getDyhModel();

    @SerializedName("dyh_name")
    public abstract String getDyhName();

    @SerializedName("editor_title")
    public abstract String getEditorTitle();

    public abstract int getEnableModify();

    @SerializedName("extra_entities")
    public abstract List<Entity> getExtraEntities();

    @SerializedName("extra_fromApi")
    public abstract String getExtraFromApi();

    @SerializedName("extra_info")
    public abstract String getExtraInfo();

    @SerializedName("extra_key")
    public abstract String getExtraKey();

    @SerializedName("extra_link_url")
    public abstract String getExtraLinkUrl();

    @SerializedName("extra_pic")
    public abstract String getExtraPic();

    @SerializedName("extra_title")
    public abstract String getExtraTitle();

    @SerializedName("extra_type")
    public abstract String getExtraType();

    @SerializedName("extra_url")
    public abstract String getExtraUrl();

    @SerializedName("favnum")
    public abstract int getFavoriteNum();

    public abstract String getFeedFromType();

    public abstract String getFeedType();

    public abstract String getFeedTypeName();

    public abstract String getFetchType();

    @SerializedName("fid")
    public abstract String getFid();

    @SerializedName("follownum")
    public abstract int getFollowNum();

    @SerializedName("forwardid")
    public abstract String getForwardId();

    @SerializedName("forwardnum")
    public abstract int getForwardNum();

    public abstract DyhArticle getForwardSourceArticle();

    public abstract Feed getForwardSourceFeed();

    public abstract String getForwardSourceType();

    @SerializedName("goods")
    public abstract FeedGoodsAction getGoodsAction();

    public abstract List<GoodsListItem> getGoodsListItem();

    public abstract List<FeedReply> getHotReplyRows();

    @SerializedName("hotSponsorCard")
    public abstract Entity getHotSponsorCard();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    public abstract String getInfo();

    public abstract String getInfoHtml();

    public abstract SimpleInfo getInnerInfo();

    @SerializedName("is_anonymous")
    public abstract int getIsAnonymous();

    @SerializedName("isHeadline")
    public abstract int getIsHeadline();

    @SerializedName("isHeadlineCommentV8")
    public abstract int getIsHeadlineCommentV8();

    @SerializedName("isHeadlineV8")
    public abstract int getIsHeadlineV8();

    @SerializedName("is_headline")
    public abstract int getIsHeadlined();

    public abstract int getIsHistory();

    @SerializedName("is_html_article")
    public abstract int getIsHtmlArticle();

    public abstract int getIsModified();

    @SerializedName("is_owner")
    public abstract int getIsOwner();

    @SerializedName("is_recommend_vote_comment")
    public abstract int getIsRecommendVoteComment();

    @SerializedName("isStickTop")
    public abstract int getIsStickTop();

    @SerializedName("keywords")
    public abstract String getKeywords();

    @SerializedName("label")
    public abstract String getLabel();

    public abstract String getLikeAvatar();

    @SerializedName("likenum")
    public abstract int getLikeNum();

    public abstract long getLikeTime();

    public abstract String getLikeUid();

    @SerializedName("likeUserInfo")
    public abstract UserInfo getLikeUserInfo();

    @SerializedName("likeUsername")
    public abstract String getLikeUserName();

    @SerializedName("location")
    public abstract String getLocation();

    @SerializedName("long_location")
    public abstract String getLongLocation();

    @SerializedName("media_info")
    public abstract String getMediaInfo();

    @SerializedName("media_type")
    public abstract String getMediaType();

    @SerializedName("media_url")
    public abstract String getMediaUrl();

    public abstract String getMessage();

    @SerializedName("message_cover")
    public abstract String getMessageCover();

    @SerializedName("message_keywords")
    public abstract String getMessageKeywords();

    @SerializedName("message_raw_input")
    public abstract String getMessageRawInput();

    @SerializedName("message_raw_output")
    public abstract String getMessageRawOutput();

    @SerializedName("messagesource")
    public abstract String getMessageSource();

    @SerializedName("message_status")
    public abstract int getMessageStatus();

    @SerializedName("messageStatusText")
    public abstract String getMessageStatusText();

    @SerializedName("message_title")
    public abstract String getMessageTitle();

    @SerializedName("noticeSponsorCard")
    public abstract Entity getNoticeSponsorCard();

    @Override // com.coolapk.market.model.Entity
    public abstract String getPic();

    @SerializedName("picArr")
    public abstract List<String> getPicArray();

    @SerializedName("question_answer_num")
    public abstract int getQuestionAnswerNum();

    @SerializedName("question_follow_num")
    public abstract int getQuestionFollowNum();

    @SerializedName("rating_score")
    public abstract float getRatingScore();

    @SerializedName("rating_score_1")
    public abstract float getRatingScore1();

    @SerializedName("rating_score_10")
    public abstract float getRatingScore10();

    @SerializedName("rating_score_2")
    public abstract float getRatingScore2();

    @SerializedName("rating_score_3")
    public abstract float getRatingScore3();

    @SerializedName("rating_score_4")
    public abstract float getRatingScore4();

    @SerializedName("rating_score_5")
    public abstract float getRatingScore5();

    @SerializedName("rating_score_6")
    public abstract float getRatingScore6();

    @SerializedName("rating_score_7")
    public abstract float getRatingScore7();

    @SerializedName("rating_score_8")
    public abstract float getRatingScore8();

    @SerializedName("rating_score_9")
    public abstract float getRatingScore9();

    @SerializedName("rating_type")
    public abstract String getRatingType();

    public abstract List<String> getRecentLikeList();

    public abstract List<FeedReply> getRecentReplyRows();

    public abstract int getRecommend();

    @SerializedName("relatedata")
    public abstract List<RelatedData> getRelatedData();

    @SerializedName("relatednum")
    public abstract int getRelatedNum();

    public abstract List<FeedRelation> getRelationRows();

    public abstract List<FeedReply> getReplyMeRows();

    @SerializedName("replynum")
    public abstract int getReplyNum();

    public abstract List<FeedReply> getReplyRows();

    @SerializedName("ershou_info")
    public abstract SecondHandInfo getSecondHandInfo();

    @SerializedName("share_num")
    public abstract int getShareNum();

    @SerializedName("shareUrl")
    public abstract String getShareUrl();

    @SerializedName("show_owner")
    public abstract int getShowOwner();

    @SerializedName("source_id")
    public abstract String getSourceId();

    public abstract String getSpamContent();

    public abstract String getSpamReason();

    public abstract long getSpamTime();

    public abstract int getStar();

    public abstract int getStatus();

    @SerializedName("statusText")
    public abstract String getStatusText();

    @SerializedName("turl")
    public abstract String getTUrl();

    @SerializedName("tags")
    public abstract String getTags();

    public abstract FeedTarget getTargetRow();

    @SerializedName("tid")
    public abstract String getTid();

    @SerializedName("tinfo")
    public abstract String getTinfo();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @SerializedName("tkey")
    public abstract String getTkey();

    @SerializedName("tlink")
    public abstract String getTlink();

    public abstract SimpleInfo getTopInfo();

    @SerializedName("topReplyRows")
    public abstract List<FeedReply> getTopReplyRows();

    @SerializedName("tpic")
    public abstract String getTpic();

    @SerializedName("ttype")
    public abstract String getTtype();

    public abstract int getType();

    @Override // com.coolapk.market.model.Entity
    public abstract String getUrl();

    public abstract UserAction getUserAction();

    @SerializedName("userFollowList")
    public abstract List<RelatedData> getUserFollowList();

    @SerializedName("userLikeList")
    public abstract List<RelatedData> getUserLikeList();

    @SerializedName("user_tags")
    public abstract String getUserTags();

    @SerializedName("useragent")
    public abstract String getUseragent();

    @SerializedName("video_pic")
    public abstract String getVideoPic();

    @SerializedName("video_url")
    public abstract String getVideoUrl();

    public boolean getViewVisible() {
        return true;
    }

    @SerializedName("vote")
    public abstract Vote getVote();

    public static TypeAdapter<Feed> typeAdapter(Gson gson) {
        return new C$AutoValue_Feed.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder(Feed feed) {
        return new C$$AutoValue_Feed.Builder(feed);
    }

    public String getUserName() {
        String userName = IUser.IUserGetter.getUserName(this);
        if (getIsAnonymous() != 1 || !shouldShowUserNameAnonymousSign(getUid())) {
            return userName;
        }
        return userName + "[已匿名]";
    }

    private static boolean shouldShowUserNameAnonymousSign(String str) {
        LoginSession loginSession = DataManager.getInstance().getLoginSession();
        return loginSession.isAdmin() || loginSession.getUid().equals(str);
    }

    public String getUserAvatar() {
        return IUser.IUserGetter.getUserAvatar(this);
    }

    public boolean isTop() {
        return getIsStickTop() == 1 || isCollectionTop();
    }

    public boolean isCollectionTop() {
        return getCollectionItem() != null && getCollectionItem().isTop();
    }

    public boolean isIncludedDiscoveryFeed() {
        return "discovery".equals(getFeedType()) && getMessageStatus() == 5;
    }

    public String getPackageName() {
        return getExtraKey();
    }

    public String getSourceName() {
        return getTinfo();
    }

    @Override // com.coolapk.market.model.Entity
    public String getLogo() {
        return getTpic();
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public boolean getIsV8Headline() {
        return getIsHeadlineV8() > 0;
    }

    public boolean isForwardFeed() {
        return !TextUtils.isEmpty(getSourceId()) && !TextUtils.equals(getSourceId(), "0");
    }

    public boolean isRecommended() {
        return getRecommend() == 3;
    }

    public String getThumbnailPic() {
        if (TextUtils.isEmpty(getPic())) {
            return null;
        }
        return getPic() + ".s.jpg";
    }

    public String getThumbSquarePic() {
        if (TextUtils.isEmpty(getPic())) {
            return null;
        }
        return getPic() + ".xs.jpg";
    }

    public String getMiddleSizePic() {
        if (TextUtils.isEmpty(getPic())) {
            return null;
        }
        return getPic() + ".m.jpg";
    }

    public boolean hasAnimatingPic() {
        String pic = getPic();
        if (TextUtils.isEmpty(pic)) {
            return false;
        }
        if (pic.endsWith(".gif") || pic.contains(".gif.")) {
            return true;
        }
        return false;
    }

    public boolean showFromView() {
        if (TextUtils.isEmpty(getInfoHtml())) {
            return !TextUtils.isEmpty(getInfo());
        }
        return true;
    }

    public String getFormatFromTypeText() {
        String feedFromType = getFeedFromType();
        if (TextUtils.isEmpty(feedFromType) || feedFromType.equals("好友圈")) {
            return null;
        }
        return String.format("来自%s", feedFromType);
    }

    public boolean isSecondHand() {
        return getSecondHandInfo() != null && !TextUtils.isEmpty(getSecondHandInfo().getFeedId());
    }
}
