package com.coolapk.market.model;

import com.coolapk.market.model.Feed;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Feed  reason: invalid class name */
abstract class C$$AutoValue_Feed extends Feed {
    private final String TUrl;
    private final String adminInfo;
    private final String appName;
    private final String articleId;
    private final int blockStatus;
    private final String blockStatusText;
    private final int buyStatus;
    private final Collection collectionInfo;
    private final CollectionItem collectionItem;
    private final String commentBad;
    private final String commentBadPic;
    private final int commentBlockNum;
    private final String commentGeneral;
    private final String commentGeneralPic;
    private final String commentGood;
    private final String commentGoodPic;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final Entity detailSponsorCard;
    private final String deviceTitle;
    private final String displayUserName;
    private final String dyhId;
    private final DyhModel dyhModel;
    private final String dyhName;
    private final String editorTitle;
    private final int enableModify;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final List<Entity> extraEntities;
    private final String extraFromApi;
    private final String extraInfo;
    private final String extraKey;
    private final String extraLinkUrl;
    private final String extraPic;
    private final String extraTitle;
    private final String extraType;
    private final String extraUrl;
    private final int favoriteNum;
    private final String feedFromType;
    private final String feedType;
    private final String feedTypeName;
    private final String fetchType;
    private final String fid;
    private final int followNum;
    private final String forwardId;
    private final int forwardNum;
    private final DyhArticle forwardSourceArticle;
    private final Feed forwardSourceFeed;
    private final String forwardSourceType;
    private final FeedGoodsAction goodsAction;
    private final List<GoodsListItem> goodsListItem;
    private final List<FeedReply> hotReplyRows;
    private final Entity hotSponsorCard;
    private final String id;
    private final List<FeedGoods> includeGoods;
    private final String info;
    private final String infoHtml;
    private final SimpleInfo innerInfo;
    private final int isAnonymous;
    private final int isHeadline;
    private final int isHeadlineCommentV8;
    private final int isHeadlineV8;
    private final int isHeadlined;
    private final int isHistory;
    private final int isHtmlArticle;
    private final int isModified;
    private final int isOwner;
    private final int isRecommendVoteComment;
    private final int isStickTop;
    private final String keywords;
    private final String label;
    private final Long lastUpdate;
    private final String likeAvatar;
    private final int likeNum;
    private final long likeTime;
    private final String likeUid;
    private final UserInfo likeUserInfo;
    private final String likeUserName;
    private final String location;
    private final String longLocation;
    private final String mediaInfo;
    private final String mediaType;
    private final String mediaUrl;
    private final String message;
    private final String messageCover;
    private final String messageKeywords;
    private final String messageRawInput;
    private final String messageRawOutput;
    private final String messageSource;
    private final int messageStatus;
    private final String messageStatusText;
    private final String messageTitle;
    private final Entity noticeSponsorCard;
    private final String pic;
    private final List<String> picArray;
    private final int questionAnswerNum;
    private final int questionFollowNum;
    private final float ratingScore;
    private final float ratingScore1;
    private final float ratingScore10;
    private final float ratingScore2;
    private final float ratingScore3;
    private final float ratingScore4;
    private final float ratingScore5;
    private final float ratingScore6;
    private final float ratingScore7;
    private final float ratingScore8;
    private final float ratingScore9;
    private final String ratingType;
    private final List<String> recentLikeList;
    private final List<FeedReply> recentReplyRows;
    private final int recommend;
    private final List<RelatedData> relatedData;
    private final int relatedNum;
    private final List<FeedRelation> relationRows;
    private final List<FeedReply> replyMeRows;
    private final int replyNum;
    private final List<FeedReply> replyRows;
    private final SecondHandInfo secondHandInfo;
    private final int shareNum;
    private final String shareUrl;
    private final int showOwner;
    private final String sourceId;
    private final String spamContent;
    private final String spamReason;
    private final long spamTime;
    private final int star;
    private final int status;
    private final String statusText;
    private final String subTitle;
    private final String tags;
    private final FeedTarget targetRow;
    private final String tid;
    private final String tinfo;
    private final String title;
    private final String tkey;
    private final String tlink;
    private final SimpleInfo topInfo;
    private final List<FeedReply> topReplyRows;
    private final String tpic;
    private final String ttype;
    private final int type;
    private final String uid;
    private final String url;
    private final UserAction userAction;
    private final List<RelatedData> userFollowList;
    private final UserInfo userInfo;
    private final List<RelatedData> userLikeList;
    private final String userTags;
    private final String useragent;
    private final String videoPic;
    private final String videoUrl;
    private final Vote vote;

    C$$AutoValue_Feed(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Long l, Long l2, String str8, UserInfo userInfo2, String str9, String str10, String str11, String str12, String str13, String str14, int i, String str15, List<String> list, String str16, String str17, int i2, int i3, int i4, int i5, int i6, int i7, String str18, String str19, int i8, String str20, int i9, int i10, String str21, String str22, String str23, int i11, int i12, int i13, int i14, String str24, String str25, String str26, List<FeedReply> list2, int i15, List<RelatedData> list3, List<RelatedData> list4, List<RelatedData> list5, String str27, Collection collection, CollectionItem collectionItem2, UserAction userAction2, List<FeedReply> list6, List<FeedReply> list7, List<FeedReply> list8, List<String> list9, List<GoodsListItem> list10, Feed feed, DyhArticle dyhArticle, String str28, String str29, String str30, String str31, long j, UserInfo userInfo3, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, int i16, int i17, int i18, int i19, long j2, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, List<FeedRelation> list11, FeedTarget feedTarget, int i20, List<FeedGoods> list12, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, String str59, String str60, List<Entity> list13, String str61, String str62, String str63, String str64, String str65, String str66, String str67, int i21, String str68, String str69, int i22, DyhModel dyhModel2, String str70, String str71, String str72, String str73, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, String str74, String str75, String str76, String str77, String str78, String str79, String str80, String str81, Entity entity, Entity entity2, Entity entity3, int i23, List<FeedReply> list14, FeedGoodsAction feedGoodsAction, String str82, int i24, int i25, int i26, Vote vote2, SecondHandInfo secondHandInfo2, int i27, SimpleInfo simpleInfo, SimpleInfo simpleInfo2, int i28, int i29, int i30) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityId = str4;
        this.entityFixed = num;
        this.description = str5;
        this.subTitle = str6;
        this.extraData = str7;
        this.dateline = l;
        this.lastUpdate = l2;
        this.deprecatedUserAvatar = str8;
        this.userInfo = userInfo2;
        Objects.requireNonNull(str9, "Null uid");
        this.uid = str9;
        this.deprecatedUserName = str10;
        this.displayUserName = str11;
        Objects.requireNonNull(str12, "Null title");
        this.title = str12;
        Objects.requireNonNull(str13, "Null id");
        this.id = str13;
        this.label = str14;
        this.type = i;
        Objects.requireNonNull(str15, "Null pic");
        this.pic = str15;
        Objects.requireNonNull(list, "Null picArray");
        this.picArray = list;
        Objects.requireNonNull(str16, "Null infoHtml");
        this.infoHtml = str16;
        Objects.requireNonNull(str17, "Null info");
        this.info = str17;
        this.forwardNum = i2;
        this.shareNum = i3;
        this.likeNum = i4;
        this.replyNum = i5;
        this.relatedNum = i6;
        this.followNum = i7;
        this.useragent = str18;
        this.articleId = str19;
        this.status = i8;
        Objects.requireNonNull(str20, "Null message");
        this.message = str20;
        this.isHtmlArticle = i9;
        this.isStickTop = i10;
        this.messageRawOutput = str21;
        this.messageRawInput = str22;
        this.feedTypeName = str23;
        this.recommend = i11;
        this.favoriteNum = i12;
        this.commentBlockNum = i13;
        this.blockStatus = i14;
        this.feedFromType = str24;
        Objects.requireNonNull(str25, "Null feedType");
        this.feedType = str25;
        Objects.requireNonNull(str26, "Null fetchType");
        this.fetchType = str26;
        this.replyRows = list2;
        this.messageStatus = i15;
        this.relatedData = list3;
        this.userLikeList = list4;
        Objects.requireNonNull(list5, "Null userFollowList");
        this.userFollowList = list5;
        this.deviceTitle = str27;
        this.collectionInfo = collection;
        this.collectionItem = collectionItem2;
        this.userAction = userAction2;
        Objects.requireNonNull(list6, "Null replyMeRows");
        this.replyMeRows = list6;
        Objects.requireNonNull(list7, "Null recentReplyRows");
        this.recentReplyRows = list7;
        Objects.requireNonNull(list8, "Null hotReplyRows");
        this.hotReplyRows = list8;
        Objects.requireNonNull(list9, "Null recentLikeList");
        this.recentLikeList = list9;
        Objects.requireNonNull(list10, "Null goodsListItem");
        this.goodsListItem = list10;
        this.forwardSourceFeed = feed;
        this.forwardSourceArticle = dyhArticle;
        this.forwardSourceType = str28;
        this.url = str29;
        this.likeUserName = str30;
        this.likeUid = str31;
        this.likeTime = j;
        this.likeUserInfo = userInfo3;
        this.likeAvatar = str32;
        this.forwardId = str33;
        this.sourceId = str34;
        this.spamReason = str35;
        this.spamContent = str36;
        this.adminInfo = str37;
        this.statusText = str38;
        this.messageStatusText = str39;
        this.blockStatusText = str40;
        this.isHeadline = i16;
        this.isHeadlined = i17;
        this.isHeadlineV8 = i18;
        this.isHeadlineCommentV8 = i19;
        this.spamTime = j2;
        Objects.requireNonNull(str41, "Null appName");
        this.appName = str41;
        this.tkey = str42;
        this.ttype = str43;
        this.tid = str44;
        this.TUrl = str45;
        this.tpic = str46;
        this.tinfo = str47;
        this.tlink = str48;
        Objects.requireNonNull(list11, "Null relationRows");
        this.relationRows = list11;
        this.targetRow = feedTarget;
        this.star = i20;
        Objects.requireNonNull(list12, "Null includeGoods");
        this.includeGoods = list12;
        this.fid = str49;
        this.dyhId = str50;
        this.dyhName = str51;
        this.userTags = str52;
        this.keywords = str53;
        this.extraKey = str54;
        this.extraTitle = str55;
        this.extraType = str56;
        this.extraUrl = str57;
        this.extraInfo = str58;
        this.extraLinkUrl = str59;
        this.extraPic = str60;
        Objects.requireNonNull(list13, "Null extraEntities");
        this.extraEntities = list13;
        this.videoPic = str61;
        this.videoUrl = str62;
        this.location = str63;
        this.longLocation = str64;
        this.messageTitle = str65;
        this.messageKeywords = str66;
        this.messageCover = str67;
        this.questionAnswerNum = i21;
        this.tags = str68;
        this.messageSource = str69;
        this.questionFollowNum = i22;
        this.dyhModel = dyhModel2;
        this.mediaInfo = str70;
        this.mediaUrl = str71;
        this.mediaType = str72;
        this.ratingType = str73;
        this.ratingScore = f;
        this.ratingScore1 = f2;
        this.ratingScore2 = f3;
        this.ratingScore3 = f4;
        this.ratingScore4 = f5;
        this.ratingScore5 = f6;
        this.ratingScore6 = f7;
        this.ratingScore7 = f8;
        this.ratingScore8 = f9;
        this.ratingScore9 = f10;
        this.ratingScore10 = f11;
        this.commentGood = str74;
        this.commentGoodPic = str75;
        this.commentBad = str76;
        this.commentBadPic = str77;
        this.commentGeneral = str78;
        this.commentGeneralPic = str79;
        this.extraFromApi = str80;
        this.shareUrl = str81;
        this.detailSponsorCard = entity;
        this.hotSponsorCard = entity2;
        this.noticeSponsorCard = entity3;
        this.buyStatus = i23;
        Objects.requireNonNull(list14, "Null topReplyRows");
        this.topReplyRows = list14;
        this.goodsAction = feedGoodsAction;
        this.editorTitle = str82;
        this.isOwner = i24;
        this.showOwner = i25;
        this.isAnonymous = i26;
        this.vote = vote2;
        this.secondHandInfo = secondHandInfo2;
        this.isRecommendVoteComment = i27;
        this.topInfo = simpleInfo;
        this.innerInfo = simpleInfo2;
        this.isModified = i28;
        this.enableModify = i29;
        this.isHistory = i30;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityType")
    public String getEntityType() {
        return this.entityType;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTemplate")
    public String getEntityTemplate() {
        return this.entityTemplate;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityId")
    public String getEntityId() {
        return this.entityId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityFixed")
    public Integer getEntityFixed() {
        return this.entityFixed;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("extraData")
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public Long getDateline() {
        return this.dateline;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("userAvatar")
    public String getDeprecatedUserAvatar() {
        return this.deprecatedUserAvatar;
    }

    @Override // com.coolapk.market.model.IUser
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("username")
    public String getDeprecatedUserName() {
        return this.deprecatedUserName;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("displayUsername")
    public String getDisplayUserName() {
        return this.displayUserName;
    }

    @Override // com.coolapk.market.model.Feed, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Feed, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("label")
    public String getLabel() {
        return this.label;
    }

    @Override // com.coolapk.market.model.Feed
    public int getType() {
        return this.type;
    }

    @Override // com.coolapk.market.model.Feed, com.coolapk.market.model.Entity
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("picArr")
    public List<String> getPicArray() {
        return this.picArray;
    }

    @Override // com.coolapk.market.model.Feed
    public String getInfoHtml() {
        return this.infoHtml;
    }

    @Override // com.coolapk.market.model.Feed
    public String getInfo() {
        return this.info;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("forwardnum")
    public int getForwardNum() {
        return this.forwardNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("share_num")
    public int getShareNum() {
        return this.shareNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("likenum")
    public int getLikeNum() {
        return this.likeNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("replynum")
    public int getReplyNum() {
        return this.replyNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("relatednum")
    public int getRelatedNum() {
        return this.relatedNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("follownum")
    public int getFollowNum() {
        return this.followNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("useragent")
    public String getUseragent() {
        return this.useragent;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("articleId")
    public String getArticleId() {
        return this.articleId;
    }

    @Override // com.coolapk.market.model.Feed
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.Feed
    public String getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("is_html_article")
    public int getIsHtmlArticle() {
        return this.isHtmlArticle;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("isStickTop")
    public int getIsStickTop() {
        return this.isStickTop;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("message_raw_output")
    public String getMessageRawOutput() {
        return this.messageRawOutput;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("message_raw_input")
    public String getMessageRawInput() {
        return this.messageRawInput;
    }

    @Override // com.coolapk.market.model.Feed
    public String getFeedTypeName() {
        return this.feedTypeName;
    }

    @Override // com.coolapk.market.model.Feed
    public int getRecommend() {
        return this.recommend;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("favnum")
    public int getFavoriteNum() {
        return this.favoriteNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("comment_block_num")
    public int getCommentBlockNum() {
        return this.commentBlockNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("block_status")
    public int getBlockStatus() {
        return this.blockStatus;
    }

    @Override // com.coolapk.market.model.Feed
    public String getFeedFromType() {
        return this.feedFromType;
    }

    @Override // com.coolapk.market.model.Feed
    public String getFeedType() {
        return this.feedType;
    }

    @Override // com.coolapk.market.model.Feed
    public String getFetchType() {
        return this.fetchType;
    }

    @Override // com.coolapk.market.model.Feed
    public List<FeedReply> getReplyRows() {
        return this.replyRows;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("message_status")
    public int getMessageStatus() {
        return this.messageStatus;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("relatedata")
    public List<RelatedData> getRelatedData() {
        return this.relatedData;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("userLikeList")
    public List<RelatedData> getUserLikeList() {
        return this.userLikeList;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("userFollowList")
    public List<RelatedData> getUserFollowList() {
        return this.userFollowList;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("device_title")
    public String getDeviceTitle() {
        return this.deviceTitle;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("collection_info")
    public Collection getCollectionInfo() {
        return this.collectionInfo;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("collection_item_info")
    public CollectionItem getCollectionItem() {
        return this.collectionItem;
    }

    @Override // com.coolapk.market.model.Feed
    public UserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.Feed
    public List<FeedReply> getReplyMeRows() {
        return this.replyMeRows;
    }

    @Override // com.coolapk.market.model.Feed
    public List<FeedReply> getRecentReplyRows() {
        return this.recentReplyRows;
    }

    @Override // com.coolapk.market.model.Feed
    public List<FeedReply> getHotReplyRows() {
        return this.hotReplyRows;
    }

    @Override // com.coolapk.market.model.Feed
    public List<String> getRecentLikeList() {
        return this.recentLikeList;
    }

    @Override // com.coolapk.market.model.Feed
    public List<GoodsListItem> getGoodsListItem() {
        return this.goodsListItem;
    }

    @Override // com.coolapk.market.model.Feed
    public Feed getForwardSourceFeed() {
        return this.forwardSourceFeed;
    }

    @Override // com.coolapk.market.model.Feed
    public DyhArticle getForwardSourceArticle() {
        return this.forwardSourceArticle;
    }

    @Override // com.coolapk.market.model.Feed
    public String getForwardSourceType() {
        return this.forwardSourceType;
    }

    @Override // com.coolapk.market.model.Feed, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("likeUsername")
    public String getLikeUserName() {
        return this.likeUserName;
    }

    @Override // com.coolapk.market.model.Feed
    public String getLikeUid() {
        return this.likeUid;
    }

    @Override // com.coolapk.market.model.Feed
    public long getLikeTime() {
        return this.likeTime;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("likeUserInfo")
    public UserInfo getLikeUserInfo() {
        return this.likeUserInfo;
    }

    @Override // com.coolapk.market.model.Feed
    public String getLikeAvatar() {
        return this.likeAvatar;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("forwardid")
    public String getForwardId() {
        return this.forwardId;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("source_id")
    public String getSourceId() {
        return this.sourceId;
    }

    @Override // com.coolapk.market.model.Feed
    public String getSpamReason() {
        return this.spamReason;
    }

    @Override // com.coolapk.market.model.Feed
    public String getSpamContent() {
        return this.spamContent;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("adminInfo")
    public String getAdminInfo() {
        return this.adminInfo;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("statusText")
    public String getStatusText() {
        return this.statusText;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("messageStatusText")
    public String getMessageStatusText() {
        return this.messageStatusText;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("blockStatusText")
    public String getBlockStatusText() {
        return this.blockStatusText;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("isHeadline")
    public int getIsHeadline() {
        return this.isHeadline;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("is_headline")
    public int getIsHeadlined() {
        return this.isHeadlined;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("isHeadlineV8")
    public int getIsHeadlineV8() {
        return this.isHeadlineV8;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("isHeadlineCommentV8")
    public int getIsHeadlineCommentV8() {
        return this.isHeadlineCommentV8;
    }

    @Override // com.coolapk.market.model.Feed
    public long getSpamTime() {
        return this.spamTime;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("ttitle")
    public String getAppName() {
        return this.appName;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("tkey")
    public String getTkey() {
        return this.tkey;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("ttype")
    public String getTtype() {
        return this.ttype;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("tid")
    public String getTid() {
        return this.tid;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("turl")
    public String getTUrl() {
        return this.TUrl;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("tpic")
    public String getTpic() {
        return this.tpic;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("tinfo")
    public String getTinfo() {
        return this.tinfo;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("tlink")
    public String getTlink() {
        return this.tlink;
    }

    @Override // com.coolapk.market.model.Feed
    public List<FeedRelation> getRelationRows() {
        return this.relationRows;
    }

    @Override // com.coolapk.market.model.Feed
    public FeedTarget getTargetRow() {
        return this.targetRow;
    }

    @Override // com.coolapk.market.model.Feed
    public int getStar() {
        return this.star;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("include_goods")
    public List<FeedGoods> getIncludeGoods() {
        return this.includeGoods;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("fid")
    public String getFid() {
        return this.fid;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("dyh_id")
    public String getDyhId() {
        return this.dyhId;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("dyh_name")
    public String getDyhName() {
        return this.dyhName;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("user_tags")
    public String getUserTags() {
        return this.userTags;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("keywords")
    public String getKeywords() {
        return this.keywords;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("extra_key")
    public String getExtraKey() {
        return this.extraKey;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("extra_title")
    public String getExtraTitle() {
        return this.extraTitle;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("extra_type")
    public String getExtraType() {
        return this.extraType;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("extra_url")
    public String getExtraUrl() {
        return this.extraUrl;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("extra_info")
    public String getExtraInfo() {
        return this.extraInfo;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("extra_link_url")
    public String getExtraLinkUrl() {
        return this.extraLinkUrl;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("extra_pic")
    public String getExtraPic() {
        return this.extraPic;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("extra_entities")
    public List<Entity> getExtraEntities() {
        return this.extraEntities;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("video_pic")
    public String getVideoPic() {
        return this.videoPic;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("video_url")
    public String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("location")
    public String getLocation() {
        return this.location;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("long_location")
    public String getLongLocation() {
        return this.longLocation;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("message_title")
    public String getMessageTitle() {
        return this.messageTitle;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("message_keywords")
    public String getMessageKeywords() {
        return this.messageKeywords;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("message_cover")
    public String getMessageCover() {
        return this.messageCover;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("question_answer_num")
    public int getQuestionAnswerNum() {
        return this.questionAnswerNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("tags")
    public String getTags() {
        return this.tags;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("messagesource")
    public String getMessageSource() {
        return this.messageSource;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("question_follow_num")
    public int getQuestionFollowNum() {
        return this.questionFollowNum;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("dyh_info")
    public DyhModel getDyhModel() {
        return this.dyhModel;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("media_info")
    public String getMediaInfo() {
        return this.mediaInfo;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("media_url")
    public String getMediaUrl() {
        return this.mediaUrl;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("media_type")
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_type")
    public String getRatingType() {
        return this.ratingType;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score")
    public float getRatingScore() {
        return this.ratingScore;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_1")
    public float getRatingScore1() {
        return this.ratingScore1;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_2")
    public float getRatingScore2() {
        return this.ratingScore2;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_3")
    public float getRatingScore3() {
        return this.ratingScore3;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_4")
    public float getRatingScore4() {
        return this.ratingScore4;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_5")
    public float getRatingScore5() {
        return this.ratingScore5;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_6")
    public float getRatingScore6() {
        return this.ratingScore6;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_7")
    public float getRatingScore7() {
        return this.ratingScore7;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_8")
    public float getRatingScore8() {
        return this.ratingScore8;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_9")
    public float getRatingScore9() {
        return this.ratingScore9;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("rating_score_10")
    public float getRatingScore10() {
        return this.ratingScore10;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("comment_good")
    public String getCommentGood() {
        return this.commentGood;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("comment_good_pic")
    public String getCommentGoodPic() {
        return this.commentGoodPic;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("comment_bad")
    public String getCommentBad() {
        return this.commentBad;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("comment_bad_pic")
    public String getCommentBadPic() {
        return this.commentBadPic;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("comment_general")
    public String getCommentGeneral() {
        return this.commentGeneral;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("comment_general_pic")
    public String getCommentGeneralPic() {
        return this.commentGeneralPic;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("extra_fromApi")
    public String getExtraFromApi() {
        return this.extraFromApi;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("shareUrl")
    public String getShareUrl() {
        return this.shareUrl;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("detailSponsorCard")
    public Entity getDetailSponsorCard() {
        return this.detailSponsorCard;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("hotSponsorCard")
    public Entity getHotSponsorCard() {
        return this.hotSponsorCard;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("noticeSponsorCard")
    public Entity getNoticeSponsorCard() {
        return this.noticeSponsorCard;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("buy_status")
    public int getBuyStatus() {
        return this.buyStatus;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("topReplyRows")
    public List<FeedReply> getTopReplyRows() {
        return this.topReplyRows;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("goods")
    public FeedGoodsAction getGoodsAction() {
        return this.goodsAction;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("editor_title")
    public String getEditorTitle() {
        return this.editorTitle;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("is_owner")
    public int getIsOwner() {
        return this.isOwner;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("show_owner")
    public int getShowOwner() {
        return this.showOwner;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("is_anonymous")
    public int getIsAnonymous() {
        return this.isAnonymous;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("vote")
    public Vote getVote() {
        return this.vote;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("ershou_info")
    public SecondHandInfo getSecondHandInfo() {
        return this.secondHandInfo;
    }

    @Override // com.coolapk.market.model.Feed
    @SerializedName("is_recommend_vote_comment")
    public int getIsRecommendVoteComment() {
        return this.isRecommendVoteComment;
    }

    @Override // com.coolapk.market.model.Feed
    public SimpleInfo getTopInfo() {
        return this.topInfo;
    }

    @Override // com.coolapk.market.model.Feed
    public SimpleInfo getInnerInfo() {
        return this.innerInfo;
    }

    @Override // com.coolapk.market.model.Feed
    public int getIsModified() {
        return this.isModified;
    }

    @Override // com.coolapk.market.model.Feed
    public int getEnableModify() {
        return this.enableModify;
    }

    @Override // com.coolapk.market.model.Feed
    public int getIsHistory() {
        return this.isHistory;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Feed{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", description=" + this.description + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", uid=" + this.uid + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", title=" + this.title + ", id=" + this.id + ", label=" + this.label + ", type=" + this.type + ", pic=" + this.pic + ", picArray=" + this.picArray + ", infoHtml=" + this.infoHtml + ", info=" + this.info + ", forwardNum=" + this.forwardNum + ", shareNum=" + this.shareNum + ", likeNum=" + this.likeNum + ", replyNum=" + this.replyNum + ", relatedNum=" + this.relatedNum + ", followNum=" + this.followNum + ", useragent=" + this.useragent + ", articleId=" + this.articleId + ", status=" + this.status + ", message=" + this.message + ", isHtmlArticle=" + this.isHtmlArticle + ", isStickTop=" + this.isStickTop + ", messageRawOutput=" + this.messageRawOutput + ", messageRawInput=" + this.messageRawInput + ", feedTypeName=" + this.feedTypeName + ", recommend=" + this.recommend + ", favoriteNum=" + this.favoriteNum + ", commentBlockNum=" + this.commentBlockNum + ", blockStatus=" + this.blockStatus + ", feedFromType=" + this.feedFromType + ", feedType=" + this.feedType + ", fetchType=" + this.fetchType + ", replyRows=" + this.replyRows + ", messageStatus=" + this.messageStatus + ", relatedData=" + this.relatedData + ", userLikeList=" + this.userLikeList + ", userFollowList=" + this.userFollowList + ", deviceTitle=" + this.deviceTitle + ", collectionInfo=" + this.collectionInfo + ", collectionItem=" + this.collectionItem + ", userAction=" + this.userAction + ", replyMeRows=" + this.replyMeRows + ", recentReplyRows=" + this.recentReplyRows + ", hotReplyRows=" + this.hotReplyRows + ", recentLikeList=" + this.recentLikeList + ", goodsListItem=" + this.goodsListItem + ", forwardSourceFeed=" + this.forwardSourceFeed + ", forwardSourceArticle=" + this.forwardSourceArticle + ", forwardSourceType=" + this.forwardSourceType + ", url=" + this.url + ", likeUserName=" + this.likeUserName + ", likeUid=" + this.likeUid + ", likeTime=" + this.likeTime + ", likeUserInfo=" + this.likeUserInfo + ", likeAvatar=" + this.likeAvatar + ", forwardId=" + this.forwardId + ", sourceId=" + this.sourceId + ", spamReason=" + this.spamReason + ", spamContent=" + this.spamContent + ", adminInfo=" + this.adminInfo + ", statusText=" + this.statusText + ", messageStatusText=" + this.messageStatusText + ", blockStatusText=" + this.blockStatusText + ", isHeadline=" + this.isHeadline + ", isHeadlined=" + this.isHeadlined + ", isHeadlineV8=" + this.isHeadlineV8 + ", isHeadlineCommentV8=" + this.isHeadlineCommentV8 + ", spamTime=" + this.spamTime + ", appName=" + this.appName + ", tkey=" + this.tkey + ", ttype=" + this.ttype + ", tid=" + this.tid + ", TUrl=" + this.TUrl + ", tpic=" + this.tpic + ", tinfo=" + this.tinfo + ", tlink=" + this.tlink + ", relationRows=" + this.relationRows + ", targetRow=" + this.targetRow + ", star=" + this.star + ", includeGoods=" + this.includeGoods + ", fid=" + this.fid + ", dyhId=" + this.dyhId + ", dyhName=" + this.dyhName + ", userTags=" + this.userTags + ", keywords=" + this.keywords + ", extraKey=" + this.extraKey + ", extraTitle=" + this.extraTitle + ", extraType=" + this.extraType + ", extraUrl=" + this.extraUrl + ", extraInfo=" + this.extraInfo + ", extraLinkUrl=" + this.extraLinkUrl + ", extraPic=" + this.extraPic + ", extraEntities=" + this.extraEntities + ", videoPic=" + this.videoPic + ", videoUrl=" + this.videoUrl + ", location=" + this.location + ", longLocation=" + this.longLocation + ", messageTitle=" + this.messageTitle + ", messageKeywords=" + this.messageKeywords + ", messageCover=" + this.messageCover + ", questionAnswerNum=" + this.questionAnswerNum + ", tags=" + this.tags + ", messageSource=" + this.messageSource + ", questionFollowNum=" + this.questionFollowNum + ", dyhModel=" + this.dyhModel + ", mediaInfo=" + this.mediaInfo + ", mediaUrl=" + this.mediaUrl + ", mediaType=" + this.mediaType + ", ratingType=" + this.ratingType + ", ratingScore=" + this.ratingScore + ", ratingScore1=" + this.ratingScore1 + ", ratingScore2=" + this.ratingScore2 + ", ratingScore3=" + this.ratingScore3 + ", ratingScore4=" + this.ratingScore4 + ", ratingScore5=" + this.ratingScore5 + ", ratingScore6=" + this.ratingScore6 + ", ratingScore7=" + this.ratingScore7 + ", ratingScore8=" + this.ratingScore8 + ", ratingScore9=" + this.ratingScore9 + ", ratingScore10=" + this.ratingScore10 + ", commentGood=" + this.commentGood + ", commentGoodPic=" + this.commentGoodPic + ", commentBad=" + this.commentBad + ", commentBadPic=" + this.commentBadPic + ", commentGeneral=" + this.commentGeneral + ", commentGeneralPic=" + this.commentGeneralPic + ", extraFromApi=" + this.extraFromApi + ", shareUrl=" + this.shareUrl + ", detailSponsorCard=" + this.detailSponsorCard + ", hotSponsorCard=" + this.hotSponsorCard + ", noticeSponsorCard=" + this.noticeSponsorCard + ", buyStatus=" + this.buyStatus + ", topReplyRows=" + this.topReplyRows + ", goodsAction=" + this.goodsAction + ", editorTitle=" + this.editorTitle + ", isOwner=" + this.isOwner + ", showOwner=" + this.showOwner + ", isAnonymous=" + this.isAnonymous + ", vote=" + this.vote + ", secondHandInfo=" + this.secondHandInfo + ", isRecommendVoteComment=" + this.isRecommendVoteComment + ", topInfo=" + this.topInfo + ", innerInfo=" + this.innerInfo + ", isModified=" + this.isModified + ", enableModify=" + this.enableModify + ", isHistory=" + this.isHistory + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        String str5;
        Long l;
        Long l2;
        String str6;
        UserInfo userInfo2;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        List<FeedReply> list;
        List<RelatedData> list2;
        List<RelatedData> list3;
        String str16;
        Collection collection;
        CollectionItem collectionItem2;
        UserAction userAction2;
        Feed feed;
        DyhArticle dyhArticle;
        String str17;
        String str18;
        String str19;
        String str20;
        UserInfo userInfo3;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        FeedTarget feedTarget;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        String str52;
        String str53;
        String str54;
        String str55;
        String str56;
        String str57;
        DyhModel dyhModel2;
        String str58;
        String str59;
        String str60;
        String str61;
        String str62;
        String str63;
        String str64;
        String str65;
        String str66;
        String str67;
        String str68;
        String str69;
        Entity entity;
        Entity entity2;
        Entity entity3;
        FeedGoodsAction feedGoodsAction;
        String str70;
        Vote vote2;
        SecondHandInfo secondHandInfo2;
        SimpleInfo simpleInfo;
        SimpleInfo simpleInfo2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Feed)) {
            return false;
        }
        Feed feed2 = (Feed) obj;
        String str71 = this.entityTypeName;
        if (str71 != null ? str71.equals(feed2.getEntityTypeName()) : feed2.getEntityTypeName() == null) {
            if (this.entityType.equals(feed2.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(feed2.getEntityTemplate()) : feed2.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(feed2.getEntityId()) : feed2.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(feed2.getEntityFixed()) : feed2.getEntityFixed() == null) && ((str3 = this.description) != null ? str3.equals(feed2.getDescription()) : feed2.getDescription() == null) && ((str4 = this.subTitle) != null ? str4.equals(feed2.getSubTitle()) : feed2.getSubTitle() == null) && ((str5 = this.extraData) != null ? str5.equals(feed2.getExtraData()) : feed2.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(feed2.getDateline()) : feed2.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(feed2.getLastUpdate()) : feed2.getLastUpdate() == null) && ((str6 = this.deprecatedUserAvatar) != null ? str6.equals(feed2.getDeprecatedUserAvatar()) : feed2.getDeprecatedUserAvatar() == null) && ((userInfo2 = this.userInfo) != null ? userInfo2.equals(feed2.getUserInfo()) : feed2.getUserInfo() == null) && this.uid.equals(feed2.getUid()) && ((str7 = this.deprecatedUserName) != null ? str7.equals(feed2.getDeprecatedUserName()) : feed2.getDeprecatedUserName() == null) && ((str8 = this.displayUserName) != null ? str8.equals(feed2.getDisplayUserName()) : feed2.getDisplayUserName() == null) && this.title.equals(feed2.getTitle()) && this.id.equals(feed2.getId()) && ((str9 = this.label) != null ? str9.equals(feed2.getLabel()) : feed2.getLabel() == null) && this.type == feed2.getType() && this.pic.equals(feed2.getPic()) && this.picArray.equals(feed2.getPicArray()) && this.infoHtml.equals(feed2.getInfoHtml()) && this.info.equals(feed2.getInfo()) && this.forwardNum == feed2.getForwardNum() && this.shareNum == feed2.getShareNum() && this.likeNum == feed2.getLikeNum() && this.replyNum == feed2.getReplyNum() && this.relatedNum == feed2.getRelatedNum() && this.followNum == feed2.getFollowNum() && ((str10 = this.useragent) != null ? str10.equals(feed2.getUseragent()) : feed2.getUseragent() == null) && ((str11 = this.articleId) != null ? str11.equals(feed2.getArticleId()) : feed2.getArticleId() == null) && this.status == feed2.getStatus() && this.message.equals(feed2.getMessage()) && this.isHtmlArticle == feed2.getIsHtmlArticle() && this.isStickTop == feed2.getIsStickTop() && ((str12 = this.messageRawOutput) != null ? str12.equals(feed2.getMessageRawOutput()) : feed2.getMessageRawOutput() == null) && ((str13 = this.messageRawInput) != null ? str13.equals(feed2.getMessageRawInput()) : feed2.getMessageRawInput() == null) && ((str14 = this.feedTypeName) != null ? str14.equals(feed2.getFeedTypeName()) : feed2.getFeedTypeName() == null) && this.recommend == feed2.getRecommend() && this.favoriteNum == feed2.getFavoriteNum() && this.commentBlockNum == feed2.getCommentBlockNum() && this.blockStatus == feed2.getBlockStatus() && ((str15 = this.feedFromType) != null ? str15.equals(feed2.getFeedFromType()) : feed2.getFeedFromType() == null) && this.feedType.equals(feed2.getFeedType()) && this.fetchType.equals(feed2.getFetchType()) && ((list = this.replyRows) != null ? list.equals(feed2.getReplyRows()) : feed2.getReplyRows() == null) && this.messageStatus == feed2.getMessageStatus() && ((list2 = this.relatedData) != null ? list2.equals(feed2.getRelatedData()) : feed2.getRelatedData() == null) && ((list3 = this.userLikeList) != null ? list3.equals(feed2.getUserLikeList()) : feed2.getUserLikeList() == null) && this.userFollowList.equals(feed2.getUserFollowList()) && ((str16 = this.deviceTitle) != null ? str16.equals(feed2.getDeviceTitle()) : feed2.getDeviceTitle() == null) && ((collection = this.collectionInfo) != null ? collection.equals(feed2.getCollectionInfo()) : feed2.getCollectionInfo() == null) && ((collectionItem2 = this.collectionItem) != null ? collectionItem2.equals(feed2.getCollectionItem()) : feed2.getCollectionItem() == null) && ((userAction2 = this.userAction) != null ? userAction2.equals(feed2.getUserAction()) : feed2.getUserAction() == null) && this.replyMeRows.equals(feed2.getReplyMeRows()) && this.recentReplyRows.equals(feed2.getRecentReplyRows()) && this.hotReplyRows.equals(feed2.getHotReplyRows()) && this.recentLikeList.equals(feed2.getRecentLikeList()) && this.goodsListItem.equals(feed2.getGoodsListItem()) && ((feed = this.forwardSourceFeed) != null ? feed.equals(feed2.getForwardSourceFeed()) : feed2.getForwardSourceFeed() == null) && ((dyhArticle = this.forwardSourceArticle) != null ? dyhArticle.equals(feed2.getForwardSourceArticle()) : feed2.getForwardSourceArticle() == null) && ((str17 = this.forwardSourceType) != null ? str17.equals(feed2.getForwardSourceType()) : feed2.getForwardSourceType() == null) && ((str18 = this.url) != null ? str18.equals(feed2.getUrl()) : feed2.getUrl() == null) && ((str19 = this.likeUserName) != null ? str19.equals(feed2.getLikeUserName()) : feed2.getLikeUserName() == null) && ((str20 = this.likeUid) != null ? str20.equals(feed2.getLikeUid()) : feed2.getLikeUid() == null) && this.likeTime == feed2.getLikeTime() && ((userInfo3 = this.likeUserInfo) != null ? userInfo3.equals(feed2.getLikeUserInfo()) : feed2.getLikeUserInfo() == null) && ((str21 = this.likeAvatar) != null ? str21.equals(feed2.getLikeAvatar()) : feed2.getLikeAvatar() == null) && ((str22 = this.forwardId) != null ? str22.equals(feed2.getForwardId()) : feed2.getForwardId() == null) && ((str23 = this.sourceId) != null ? str23.equals(feed2.getSourceId()) : feed2.getSourceId() == null) && ((str24 = this.spamReason) != null ? str24.equals(feed2.getSpamReason()) : feed2.getSpamReason() == null) && ((str25 = this.spamContent) != null ? str25.equals(feed2.getSpamContent()) : feed2.getSpamContent() == null) && ((str26 = this.adminInfo) != null ? str26.equals(feed2.getAdminInfo()) : feed2.getAdminInfo() == null) && ((str27 = this.statusText) != null ? str27.equals(feed2.getStatusText()) : feed2.getStatusText() == null) && ((str28 = this.messageStatusText) != null ? str28.equals(feed2.getMessageStatusText()) : feed2.getMessageStatusText() == null) && ((str29 = this.blockStatusText) != null ? str29.equals(feed2.getBlockStatusText()) : feed2.getBlockStatusText() == null) && this.isHeadline == feed2.getIsHeadline() && this.isHeadlined == feed2.getIsHeadlined() && this.isHeadlineV8 == feed2.getIsHeadlineV8() && this.isHeadlineCommentV8 == feed2.getIsHeadlineCommentV8() && this.spamTime == feed2.getSpamTime() && this.appName.equals(feed2.getAppName()) && ((str30 = this.tkey) != null ? str30.equals(feed2.getTkey()) : feed2.getTkey() == null) && ((str31 = this.ttype) != null ? str31.equals(feed2.getTtype()) : feed2.getTtype() == null) && ((str32 = this.tid) != null ? str32.equals(feed2.getTid()) : feed2.getTid() == null) && ((str33 = this.TUrl) != null ? str33.equals(feed2.getTUrl()) : feed2.getTUrl() == null) && ((str34 = this.tpic) != null ? str34.equals(feed2.getTpic()) : feed2.getTpic() == null) && ((str35 = this.tinfo) != null ? str35.equals(feed2.getTinfo()) : feed2.getTinfo() == null) && ((str36 = this.tlink) != null ? str36.equals(feed2.getTlink()) : feed2.getTlink() == null) && this.relationRows.equals(feed2.getRelationRows()) && ((feedTarget = this.targetRow) != null ? feedTarget.equals(feed2.getTargetRow()) : feed2.getTargetRow() == null) && this.star == feed2.getStar() && this.includeGoods.equals(feed2.getIncludeGoods()) && ((str37 = this.fid) != null ? str37.equals(feed2.getFid()) : feed2.getFid() == null) && ((str38 = this.dyhId) != null ? str38.equals(feed2.getDyhId()) : feed2.getDyhId() == null) && ((str39 = this.dyhName) != null ? str39.equals(feed2.getDyhName()) : feed2.getDyhName() == null) && ((str40 = this.userTags) != null ? str40.equals(feed2.getUserTags()) : feed2.getUserTags() == null) && ((str41 = this.keywords) != null ? str41.equals(feed2.getKeywords()) : feed2.getKeywords() == null) && ((str42 = this.extraKey) != null ? str42.equals(feed2.getExtraKey()) : feed2.getExtraKey() == null) && ((str43 = this.extraTitle) != null ? str43.equals(feed2.getExtraTitle()) : feed2.getExtraTitle() == null) && ((str44 = this.extraType) != null ? str44.equals(feed2.getExtraType()) : feed2.getExtraType() == null) && ((str45 = this.extraUrl) != null ? str45.equals(feed2.getExtraUrl()) : feed2.getExtraUrl() == null) && ((str46 = this.extraInfo) != null ? str46.equals(feed2.getExtraInfo()) : feed2.getExtraInfo() == null) && ((str47 = this.extraLinkUrl) != null ? str47.equals(feed2.getExtraLinkUrl()) : feed2.getExtraLinkUrl() == null) && ((str48 = this.extraPic) != null ? str48.equals(feed2.getExtraPic()) : feed2.getExtraPic() == null) && this.extraEntities.equals(feed2.getExtraEntities()) && ((str49 = this.videoPic) != null ? str49.equals(feed2.getVideoPic()) : feed2.getVideoPic() == null) && ((str50 = this.videoUrl) != null ? str50.equals(feed2.getVideoUrl()) : feed2.getVideoUrl() == null) && ((str51 = this.location) != null ? str51.equals(feed2.getLocation()) : feed2.getLocation() == null) && ((str52 = this.longLocation) != null ? str52.equals(feed2.getLongLocation()) : feed2.getLongLocation() == null) && ((str53 = this.messageTitle) != null ? str53.equals(feed2.getMessageTitle()) : feed2.getMessageTitle() == null) && ((str54 = this.messageKeywords) != null ? str54.equals(feed2.getMessageKeywords()) : feed2.getMessageKeywords() == null) && ((str55 = this.messageCover) != null ? str55.equals(feed2.getMessageCover()) : feed2.getMessageCover() == null) && this.questionAnswerNum == feed2.getQuestionAnswerNum() && ((str56 = this.tags) != null ? str56.equals(feed2.getTags()) : feed2.getTags() == null) && ((str57 = this.messageSource) != null ? str57.equals(feed2.getMessageSource()) : feed2.getMessageSource() == null) && this.questionFollowNum == feed2.getQuestionFollowNum() && ((dyhModel2 = this.dyhModel) != null ? dyhModel2.equals(feed2.getDyhModel()) : feed2.getDyhModel() == null) && ((str58 = this.mediaInfo) != null ? str58.equals(feed2.getMediaInfo()) : feed2.getMediaInfo() == null) && ((str59 = this.mediaUrl) != null ? str59.equals(feed2.getMediaUrl()) : feed2.getMediaUrl() == null) && ((str60 = this.mediaType) != null ? str60.equals(feed2.getMediaType()) : feed2.getMediaType() == null) && ((str61 = this.ratingType) != null ? str61.equals(feed2.getRatingType()) : feed2.getRatingType() == null) && Float.floatToIntBits(this.ratingScore) == Float.floatToIntBits(feed2.getRatingScore()) && Float.floatToIntBits(this.ratingScore1) == Float.floatToIntBits(feed2.getRatingScore1()) && Float.floatToIntBits(this.ratingScore2) == Float.floatToIntBits(feed2.getRatingScore2()) && Float.floatToIntBits(this.ratingScore3) == Float.floatToIntBits(feed2.getRatingScore3()) && Float.floatToIntBits(this.ratingScore4) == Float.floatToIntBits(feed2.getRatingScore4()) && Float.floatToIntBits(this.ratingScore5) == Float.floatToIntBits(feed2.getRatingScore5()) && Float.floatToIntBits(this.ratingScore6) == Float.floatToIntBits(feed2.getRatingScore6()) && Float.floatToIntBits(this.ratingScore7) == Float.floatToIntBits(feed2.getRatingScore7()) && Float.floatToIntBits(this.ratingScore8) == Float.floatToIntBits(feed2.getRatingScore8()) && Float.floatToIntBits(this.ratingScore9) == Float.floatToIntBits(feed2.getRatingScore9()) && Float.floatToIntBits(this.ratingScore10) == Float.floatToIntBits(feed2.getRatingScore10()) && ((str62 = this.commentGood) != null ? str62.equals(feed2.getCommentGood()) : feed2.getCommentGood() == null) && ((str63 = this.commentGoodPic) != null ? str63.equals(feed2.getCommentGoodPic()) : feed2.getCommentGoodPic() == null) && ((str64 = this.commentBad) != null ? str64.equals(feed2.getCommentBad()) : feed2.getCommentBad() == null) && ((str65 = this.commentBadPic) != null ? str65.equals(feed2.getCommentBadPic()) : feed2.getCommentBadPic() == null) && ((str66 = this.commentGeneral) != null ? str66.equals(feed2.getCommentGeneral()) : feed2.getCommentGeneral() == null) && ((str67 = this.commentGeneralPic) != null ? str67.equals(feed2.getCommentGeneralPic()) : feed2.getCommentGeneralPic() == null) && ((str68 = this.extraFromApi) != null ? str68.equals(feed2.getExtraFromApi()) : feed2.getExtraFromApi() == null) && ((str69 = this.shareUrl) != null ? str69.equals(feed2.getShareUrl()) : feed2.getShareUrl() == null) && ((entity = this.detailSponsorCard) != null ? entity.equals(feed2.getDetailSponsorCard()) : feed2.getDetailSponsorCard() == null) && ((entity2 = this.hotSponsorCard) != null ? entity2.equals(feed2.getHotSponsorCard()) : feed2.getHotSponsorCard() == null) && ((entity3 = this.noticeSponsorCard) != null ? entity3.equals(feed2.getNoticeSponsorCard()) : feed2.getNoticeSponsorCard() == null) && this.buyStatus == feed2.getBuyStatus() && this.topReplyRows.equals(feed2.getTopReplyRows()) && ((feedGoodsAction = this.goodsAction) != null ? feedGoodsAction.equals(feed2.getGoodsAction()) : feed2.getGoodsAction() == null) && ((str70 = this.editorTitle) != null ? str70.equals(feed2.getEditorTitle()) : feed2.getEditorTitle() == null) && this.isOwner == feed2.getIsOwner() && this.showOwner == feed2.getShowOwner() && this.isAnonymous == feed2.getIsAnonymous() && ((vote2 = this.vote) != null ? vote2.equals(feed2.getVote()) : feed2.getVote() == null) && ((secondHandInfo2 = this.secondHandInfo) != null ? secondHandInfo2.equals(feed2.getSecondHandInfo()) : feed2.getSecondHandInfo() == null) && this.isRecommendVoteComment == feed2.getIsRecommendVoteComment() && ((simpleInfo = this.topInfo) != null ? simpleInfo.equals(feed2.getTopInfo()) : feed2.getTopInfo() == null) && ((simpleInfo2 = this.innerInfo) != null ? simpleInfo2.equals(feed2.getInnerInfo()) : feed2.getInnerInfo() == null) && this.isModified == feed2.getIsModified() && this.enableModify == feed2.getEnableModify() && this.isHistory == feed2.getIsHistory()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.entityType.hashCode()) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.description;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.subTitle;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.extraData;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode8 = (hashCode7 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode9 = (hashCode8 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str7 = this.deprecatedUserAvatar;
        int hashCode10 = (hashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode11 = (((hashCode10 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003) ^ this.uid.hashCode()) * 1000003;
        String str8 = this.deprecatedUserName;
        int hashCode12 = (hashCode11 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.displayUserName;
        int hashCode13 = (((((hashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.id.hashCode()) * 1000003;
        String str10 = this.label;
        int hashCode14 = (((((((((((((((((((((((hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003) ^ this.type) * 1000003) ^ this.pic.hashCode()) * 1000003) ^ this.picArray.hashCode()) * 1000003) ^ this.infoHtml.hashCode()) * 1000003) ^ this.info.hashCode()) * 1000003) ^ this.forwardNum) * 1000003) ^ this.shareNum) * 1000003) ^ this.likeNum) * 1000003) ^ this.replyNum) * 1000003) ^ this.relatedNum) * 1000003) ^ this.followNum) * 1000003;
        String str11 = this.useragent;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.articleId;
        int hashCode16 = (((((((((hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003) ^ this.status) * 1000003) ^ this.message.hashCode()) * 1000003) ^ this.isHtmlArticle) * 1000003) ^ this.isStickTop) * 1000003;
        String str13 = this.messageRawOutput;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.messageRawInput;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.feedTypeName;
        int hashCode19 = (((((((((hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.recommend) * 1000003) ^ this.favoriteNum) * 1000003) ^ this.commentBlockNum) * 1000003) ^ this.blockStatus) * 1000003;
        String str16 = this.feedFromType;
        int hashCode20 = (((((hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.feedType.hashCode()) * 1000003) ^ this.fetchType.hashCode()) * 1000003;
        List<FeedReply> list = this.replyRows;
        int hashCode21 = (((hashCode20 ^ (list == null ? 0 : list.hashCode())) * 1000003) ^ this.messageStatus) * 1000003;
        List<RelatedData> list2 = this.relatedData;
        int hashCode22 = (hashCode21 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        List<RelatedData> list3 = this.userLikeList;
        int hashCode23 = (((hashCode22 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003) ^ this.userFollowList.hashCode()) * 1000003;
        String str17 = this.deviceTitle;
        int hashCode24 = (hashCode23 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        Collection collection = this.collectionInfo;
        int hashCode25 = (hashCode24 ^ (collection == null ? 0 : collection.hashCode())) * 1000003;
        CollectionItem collectionItem2 = this.collectionItem;
        int hashCode26 = (hashCode25 ^ (collectionItem2 == null ? 0 : collectionItem2.hashCode())) * 1000003;
        UserAction userAction2 = this.userAction;
        int hashCode27 = (((((((((((hashCode26 ^ (userAction2 == null ? 0 : userAction2.hashCode())) * 1000003) ^ this.replyMeRows.hashCode()) * 1000003) ^ this.recentReplyRows.hashCode()) * 1000003) ^ this.hotReplyRows.hashCode()) * 1000003) ^ this.recentLikeList.hashCode()) * 1000003) ^ this.goodsListItem.hashCode()) * 1000003;
        Feed feed = this.forwardSourceFeed;
        int hashCode28 = (hashCode27 ^ (feed == null ? 0 : feed.hashCode())) * 1000003;
        DyhArticle dyhArticle = this.forwardSourceArticle;
        int hashCode29 = (hashCode28 ^ (dyhArticle == null ? 0 : dyhArticle.hashCode())) * 1000003;
        String str18 = this.forwardSourceType;
        int hashCode30 = (hashCode29 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.url;
        int hashCode31 = (hashCode30 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        String str20 = this.likeUserName;
        int hashCode32 = (hashCode31 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        String str21 = this.likeUid;
        int hashCode33 = str21 == null ? 0 : str21.hashCode();
        long j = this.likeTime;
        int i2 = ((int) (((long) ((hashCode32 ^ hashCode33) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003;
        UserInfo userInfo3 = this.likeUserInfo;
        int hashCode34 = ((userInfo3 == null ? 0 : userInfo3.hashCode()) ^ i2) * 1000003;
        String str22 = this.likeAvatar;
        int hashCode35 = (hashCode34 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003;
        String str23 = this.forwardId;
        int hashCode36 = (hashCode35 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
        String str24 = this.sourceId;
        int hashCode37 = (hashCode36 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
        String str25 = this.spamReason;
        int hashCode38 = (hashCode37 ^ (str25 == null ? 0 : str25.hashCode())) * 1000003;
        String str26 = this.spamContent;
        int hashCode39 = (hashCode38 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003;
        String str27 = this.adminInfo;
        int hashCode40 = (hashCode39 ^ (str27 == null ? 0 : str27.hashCode())) * 1000003;
        String str28 = this.statusText;
        int hashCode41 = (hashCode40 ^ (str28 == null ? 0 : str28.hashCode())) * 1000003;
        String str29 = this.messageStatusText;
        int hashCode42 = (hashCode41 ^ (str29 == null ? 0 : str29.hashCode())) * 1000003;
        String str30 = this.blockStatusText;
        int hashCode43 = str30 == null ? 0 : str30.hashCode();
        long j2 = this.spamTime;
        int hashCode44 = ((((int) (((long) ((((((((((hashCode42 ^ hashCode43) * 1000003) ^ this.isHeadline) * 1000003) ^ this.isHeadlined) * 1000003) ^ this.isHeadlineV8) * 1000003) ^ this.isHeadlineCommentV8) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.appName.hashCode()) * 1000003;
        String str31 = this.tkey;
        int hashCode45 = (hashCode44 ^ (str31 == null ? 0 : str31.hashCode())) * 1000003;
        String str32 = this.ttype;
        int hashCode46 = (hashCode45 ^ (str32 == null ? 0 : str32.hashCode())) * 1000003;
        String str33 = this.tid;
        int hashCode47 = (hashCode46 ^ (str33 == null ? 0 : str33.hashCode())) * 1000003;
        String str34 = this.TUrl;
        int hashCode48 = (hashCode47 ^ (str34 == null ? 0 : str34.hashCode())) * 1000003;
        String str35 = this.tpic;
        int hashCode49 = (hashCode48 ^ (str35 == null ? 0 : str35.hashCode())) * 1000003;
        String str36 = this.tinfo;
        int hashCode50 = (hashCode49 ^ (str36 == null ? 0 : str36.hashCode())) * 1000003;
        String str37 = this.tlink;
        int hashCode51 = (((hashCode50 ^ (str37 == null ? 0 : str37.hashCode())) * 1000003) ^ this.relationRows.hashCode()) * 1000003;
        FeedTarget feedTarget = this.targetRow;
        int hashCode52 = (((((hashCode51 ^ (feedTarget == null ? 0 : feedTarget.hashCode())) * 1000003) ^ this.star) * 1000003) ^ this.includeGoods.hashCode()) * 1000003;
        String str38 = this.fid;
        int hashCode53 = (hashCode52 ^ (str38 == null ? 0 : str38.hashCode())) * 1000003;
        String str39 = this.dyhId;
        int hashCode54 = (hashCode53 ^ (str39 == null ? 0 : str39.hashCode())) * 1000003;
        String str40 = this.dyhName;
        int hashCode55 = (hashCode54 ^ (str40 == null ? 0 : str40.hashCode())) * 1000003;
        String str41 = this.userTags;
        int hashCode56 = (hashCode55 ^ (str41 == null ? 0 : str41.hashCode())) * 1000003;
        String str42 = this.keywords;
        int hashCode57 = (hashCode56 ^ (str42 == null ? 0 : str42.hashCode())) * 1000003;
        String str43 = this.extraKey;
        int hashCode58 = (hashCode57 ^ (str43 == null ? 0 : str43.hashCode())) * 1000003;
        String str44 = this.extraTitle;
        int hashCode59 = (hashCode58 ^ (str44 == null ? 0 : str44.hashCode())) * 1000003;
        String str45 = this.extraType;
        int hashCode60 = (hashCode59 ^ (str45 == null ? 0 : str45.hashCode())) * 1000003;
        String str46 = this.extraUrl;
        int hashCode61 = (hashCode60 ^ (str46 == null ? 0 : str46.hashCode())) * 1000003;
        String str47 = this.extraInfo;
        int hashCode62 = (hashCode61 ^ (str47 == null ? 0 : str47.hashCode())) * 1000003;
        String str48 = this.extraLinkUrl;
        int hashCode63 = (hashCode62 ^ (str48 == null ? 0 : str48.hashCode())) * 1000003;
        String str49 = this.extraPic;
        int hashCode64 = (((hashCode63 ^ (str49 == null ? 0 : str49.hashCode())) * 1000003) ^ this.extraEntities.hashCode()) * 1000003;
        String str50 = this.videoPic;
        int hashCode65 = (hashCode64 ^ (str50 == null ? 0 : str50.hashCode())) * 1000003;
        String str51 = this.videoUrl;
        int hashCode66 = (hashCode65 ^ (str51 == null ? 0 : str51.hashCode())) * 1000003;
        String str52 = this.location;
        int hashCode67 = (hashCode66 ^ (str52 == null ? 0 : str52.hashCode())) * 1000003;
        String str53 = this.longLocation;
        int hashCode68 = (hashCode67 ^ (str53 == null ? 0 : str53.hashCode())) * 1000003;
        String str54 = this.messageTitle;
        int hashCode69 = (hashCode68 ^ (str54 == null ? 0 : str54.hashCode())) * 1000003;
        String str55 = this.messageKeywords;
        int hashCode70 = (hashCode69 ^ (str55 == null ? 0 : str55.hashCode())) * 1000003;
        String str56 = this.messageCover;
        int hashCode71 = (((hashCode70 ^ (str56 == null ? 0 : str56.hashCode())) * 1000003) ^ this.questionAnswerNum) * 1000003;
        String str57 = this.tags;
        int hashCode72 = (hashCode71 ^ (str57 == null ? 0 : str57.hashCode())) * 1000003;
        String str58 = this.messageSource;
        int hashCode73 = (((hashCode72 ^ (str58 == null ? 0 : str58.hashCode())) * 1000003) ^ this.questionFollowNum) * 1000003;
        DyhModel dyhModel2 = this.dyhModel;
        int hashCode74 = (hashCode73 ^ (dyhModel2 == null ? 0 : dyhModel2.hashCode())) * 1000003;
        String str59 = this.mediaInfo;
        int hashCode75 = (hashCode74 ^ (str59 == null ? 0 : str59.hashCode())) * 1000003;
        String str60 = this.mediaUrl;
        int hashCode76 = (hashCode75 ^ (str60 == null ? 0 : str60.hashCode())) * 1000003;
        String str61 = this.mediaType;
        int hashCode77 = (hashCode76 ^ (str61 == null ? 0 : str61.hashCode())) * 1000003;
        String str62 = this.ratingType;
        int hashCode78 = (((((((((((((((((((((((hashCode77 ^ (str62 == null ? 0 : str62.hashCode())) * 1000003) ^ Float.floatToIntBits(this.ratingScore)) * 1000003) ^ Float.floatToIntBits(this.ratingScore1)) * 1000003) ^ Float.floatToIntBits(this.ratingScore2)) * 1000003) ^ Float.floatToIntBits(this.ratingScore3)) * 1000003) ^ Float.floatToIntBits(this.ratingScore4)) * 1000003) ^ Float.floatToIntBits(this.ratingScore5)) * 1000003) ^ Float.floatToIntBits(this.ratingScore6)) * 1000003) ^ Float.floatToIntBits(this.ratingScore7)) * 1000003) ^ Float.floatToIntBits(this.ratingScore8)) * 1000003) ^ Float.floatToIntBits(this.ratingScore9)) * 1000003) ^ Float.floatToIntBits(this.ratingScore10)) * 1000003;
        String str63 = this.commentGood;
        int hashCode79 = (hashCode78 ^ (str63 == null ? 0 : str63.hashCode())) * 1000003;
        String str64 = this.commentGoodPic;
        int hashCode80 = (hashCode79 ^ (str64 == null ? 0 : str64.hashCode())) * 1000003;
        String str65 = this.commentBad;
        int hashCode81 = (hashCode80 ^ (str65 == null ? 0 : str65.hashCode())) * 1000003;
        String str66 = this.commentBadPic;
        int hashCode82 = (hashCode81 ^ (str66 == null ? 0 : str66.hashCode())) * 1000003;
        String str67 = this.commentGeneral;
        int hashCode83 = (hashCode82 ^ (str67 == null ? 0 : str67.hashCode())) * 1000003;
        String str68 = this.commentGeneralPic;
        int hashCode84 = (hashCode83 ^ (str68 == null ? 0 : str68.hashCode())) * 1000003;
        String str69 = this.extraFromApi;
        int hashCode85 = (hashCode84 ^ (str69 == null ? 0 : str69.hashCode())) * 1000003;
        String str70 = this.shareUrl;
        int hashCode86 = (hashCode85 ^ (str70 == null ? 0 : str70.hashCode())) * 1000003;
        Entity entity = this.detailSponsorCard;
        int hashCode87 = (hashCode86 ^ (entity == null ? 0 : entity.hashCode())) * 1000003;
        Entity entity2 = this.hotSponsorCard;
        int hashCode88 = (hashCode87 ^ (entity2 == null ? 0 : entity2.hashCode())) * 1000003;
        Entity entity3 = this.noticeSponsorCard;
        int hashCode89 = (((((hashCode88 ^ (entity3 == null ? 0 : entity3.hashCode())) * 1000003) ^ this.buyStatus) * 1000003) ^ this.topReplyRows.hashCode()) * 1000003;
        FeedGoodsAction feedGoodsAction = this.goodsAction;
        int hashCode90 = (hashCode89 ^ (feedGoodsAction == null ? 0 : feedGoodsAction.hashCode())) * 1000003;
        String str71 = this.editorTitle;
        int hashCode91 = (((((((hashCode90 ^ (str71 == null ? 0 : str71.hashCode())) * 1000003) ^ this.isOwner) * 1000003) ^ this.showOwner) * 1000003) ^ this.isAnonymous) * 1000003;
        Vote vote2 = this.vote;
        int hashCode92 = (hashCode91 ^ (vote2 == null ? 0 : vote2.hashCode())) * 1000003;
        SecondHandInfo secondHandInfo2 = this.secondHandInfo;
        int hashCode93 = (((hashCode92 ^ (secondHandInfo2 == null ? 0 : secondHandInfo2.hashCode())) * 1000003) ^ this.isRecommendVoteComment) * 1000003;
        SimpleInfo simpleInfo = this.topInfo;
        int hashCode94 = (hashCode93 ^ (simpleInfo == null ? 0 : simpleInfo.hashCode())) * 1000003;
        SimpleInfo simpleInfo2 = this.innerInfo;
        if (simpleInfo2 != null) {
            i = simpleInfo2.hashCode();
        }
        return ((((((hashCode94 ^ i) * 1000003) ^ this.isModified) * 1000003) ^ this.enableModify) * 1000003) ^ this.isHistory;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Feed$Builder */
    /* compiled from: $$AutoValue_Feed */
    static final class Builder extends Feed.Builder {
        private String TUrl;
        private String adminInfo;
        private String appName;
        private String articleId;
        private Integer blockStatus;
        private String blockStatusText;
        private Integer buyStatus;
        private Collection collectionInfo;
        private CollectionItem collectionItem;
        private String commentBad;
        private String commentBadPic;
        private Integer commentBlockNum;
        private String commentGeneral;
        private String commentGeneralPic;
        private String commentGood;
        private String commentGoodPic;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private Entity detailSponsorCard;
        private String deviceTitle;
        private String displayUserName;
        private String dyhId;
        private DyhModel dyhModel;
        private String dyhName;
        private String editorTitle;
        private Integer enableModify;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private List<Entity> extraEntities;
        private String extraFromApi;
        private String extraInfo;
        private String extraKey;
        private String extraLinkUrl;
        private String extraPic;
        private String extraTitle;
        private String extraType;
        private String extraUrl;
        private Integer favoriteNum;
        private String feedFromType;
        private String feedType;
        private String feedTypeName;
        private String fetchType;
        private String fid;
        private Integer followNum;
        private String forwardId;
        private Integer forwardNum;
        private DyhArticle forwardSourceArticle;
        private Feed forwardSourceFeed;
        private String forwardSourceType;
        private FeedGoodsAction goodsAction;
        private List<GoodsListItem> goodsListItem;
        private List<FeedReply> hotReplyRows;
        private Entity hotSponsorCard;
        private String id;
        private List<FeedGoods> includeGoods;
        private String info;
        private String infoHtml;
        private SimpleInfo innerInfo;
        private Integer isAnonymous;
        private Integer isHeadline;
        private Integer isHeadlineCommentV8;
        private Integer isHeadlineV8;
        private Integer isHeadlined;
        private Integer isHistory;
        private Integer isHtmlArticle;
        private Integer isModified;
        private Integer isOwner;
        private Integer isRecommendVoteComment;
        private Integer isStickTop;
        private String keywords;
        private String label;
        private Long lastUpdate;
        private String likeAvatar;
        private Integer likeNum;
        private Long likeTime;
        private String likeUid;
        private UserInfo likeUserInfo;
        private String likeUserName;
        private String location;
        private String longLocation;
        private String mediaInfo;
        private String mediaType;
        private String mediaUrl;
        private String message;
        private String messageCover;
        private String messageKeywords;
        private String messageRawInput;
        private String messageRawOutput;
        private String messageSource;
        private Integer messageStatus;
        private String messageStatusText;
        private String messageTitle;
        private Entity noticeSponsorCard;
        private String pic;
        private List<String> picArray;
        private Integer questionAnswerNum;
        private Integer questionFollowNum;
        private Float ratingScore;
        private Float ratingScore1;
        private Float ratingScore10;
        private Float ratingScore2;
        private Float ratingScore3;
        private Float ratingScore4;
        private Float ratingScore5;
        private Float ratingScore6;
        private Float ratingScore7;
        private Float ratingScore8;
        private Float ratingScore9;
        private String ratingType;
        private List<String> recentLikeList;
        private List<FeedReply> recentReplyRows;
        private Integer recommend;
        private List<RelatedData> relatedData;
        private Integer relatedNum;
        private List<FeedRelation> relationRows;
        private List<FeedReply> replyMeRows;
        private Integer replyNum;
        private List<FeedReply> replyRows;
        private SecondHandInfo secondHandInfo;
        private Integer shareNum;
        private String shareUrl;
        private Integer showOwner;
        private String sourceId;
        private String spamContent;
        private String spamReason;
        private Long spamTime;
        private Integer star;
        private Integer status;
        private String statusText;
        private String subTitle;
        private String tags;
        private FeedTarget targetRow;
        private String tid;
        private String tinfo;
        private String title;
        private String tkey;
        private String tlink;
        private SimpleInfo topInfo;
        private List<FeedReply> topReplyRows;
        private String tpic;
        private String ttype;
        private Integer type;
        private String uid;
        private String url;
        private UserAction userAction;
        private List<RelatedData> userFollowList;
        private UserInfo userInfo;
        private List<RelatedData> userLikeList;
        private String userTags;
        private String useragent;
        private String videoPic;
        private String videoUrl;
        private Vote vote;

        Builder() {
        }

        Builder(Feed feed) {
            this.entityTypeName = feed.getEntityTypeName();
            this.entityType = feed.getEntityType();
            this.entityTemplate = feed.getEntityTemplate();
            this.entityId = feed.getEntityId();
            this.entityFixed = feed.getEntityFixed();
            this.description = feed.getDescription();
            this.subTitle = feed.getSubTitle();
            this.extraData = feed.getExtraData();
            this.dateline = feed.getDateline();
            this.lastUpdate = feed.getLastUpdate();
            this.deprecatedUserAvatar = feed.getDeprecatedUserAvatar();
            this.userInfo = feed.getUserInfo();
            this.uid = feed.getUid();
            this.deprecatedUserName = feed.getDeprecatedUserName();
            this.displayUserName = feed.getDisplayUserName();
            this.title = feed.getTitle();
            this.id = feed.getId();
            this.label = feed.getLabel();
            this.type = Integer.valueOf(feed.getType());
            this.pic = feed.getPic();
            this.picArray = feed.getPicArray();
            this.infoHtml = feed.getInfoHtml();
            this.info = feed.getInfo();
            this.forwardNum = Integer.valueOf(feed.getForwardNum());
            this.shareNum = Integer.valueOf(feed.getShareNum());
            this.likeNum = Integer.valueOf(feed.getLikeNum());
            this.replyNum = Integer.valueOf(feed.getReplyNum());
            this.relatedNum = Integer.valueOf(feed.getRelatedNum());
            this.followNum = Integer.valueOf(feed.getFollowNum());
            this.useragent = feed.getUseragent();
            this.articleId = feed.getArticleId();
            this.status = Integer.valueOf(feed.getStatus());
            this.message = feed.getMessage();
            this.isHtmlArticle = Integer.valueOf(feed.getIsHtmlArticle());
            this.isStickTop = Integer.valueOf(feed.getIsStickTop());
            this.messageRawOutput = feed.getMessageRawOutput();
            this.messageRawInput = feed.getMessageRawInput();
            this.feedTypeName = feed.getFeedTypeName();
            this.recommend = Integer.valueOf(feed.getRecommend());
            this.favoriteNum = Integer.valueOf(feed.getFavoriteNum());
            this.commentBlockNum = Integer.valueOf(feed.getCommentBlockNum());
            this.blockStatus = Integer.valueOf(feed.getBlockStatus());
            this.feedFromType = feed.getFeedFromType();
            this.feedType = feed.getFeedType();
            this.fetchType = feed.getFetchType();
            this.replyRows = feed.getReplyRows();
            this.messageStatus = Integer.valueOf(feed.getMessageStatus());
            this.relatedData = feed.getRelatedData();
            this.userLikeList = feed.getUserLikeList();
            this.userFollowList = feed.getUserFollowList();
            this.deviceTitle = feed.getDeviceTitle();
            this.collectionInfo = feed.getCollectionInfo();
            this.collectionItem = feed.getCollectionItem();
            this.userAction = feed.getUserAction();
            this.replyMeRows = feed.getReplyMeRows();
            this.recentReplyRows = feed.getRecentReplyRows();
            this.hotReplyRows = feed.getHotReplyRows();
            this.recentLikeList = feed.getRecentLikeList();
            this.goodsListItem = feed.getGoodsListItem();
            this.forwardSourceFeed = feed.getForwardSourceFeed();
            this.forwardSourceArticle = feed.getForwardSourceArticle();
            this.forwardSourceType = feed.getForwardSourceType();
            this.url = feed.getUrl();
            this.likeUserName = feed.getLikeUserName();
            this.likeUid = feed.getLikeUid();
            this.likeTime = Long.valueOf(feed.getLikeTime());
            this.likeUserInfo = feed.getLikeUserInfo();
            this.likeAvatar = feed.getLikeAvatar();
            this.forwardId = feed.getForwardId();
            this.sourceId = feed.getSourceId();
            this.spamReason = feed.getSpamReason();
            this.spamContent = feed.getSpamContent();
            this.adminInfo = feed.getAdminInfo();
            this.statusText = feed.getStatusText();
            this.messageStatusText = feed.getMessageStatusText();
            this.blockStatusText = feed.getBlockStatusText();
            this.isHeadline = Integer.valueOf(feed.getIsHeadline());
            this.isHeadlined = Integer.valueOf(feed.getIsHeadlined());
            this.isHeadlineV8 = Integer.valueOf(feed.getIsHeadlineV8());
            this.isHeadlineCommentV8 = Integer.valueOf(feed.getIsHeadlineCommentV8());
            this.spamTime = Long.valueOf(feed.getSpamTime());
            this.appName = feed.getAppName();
            this.tkey = feed.getTkey();
            this.ttype = feed.getTtype();
            this.tid = feed.getTid();
            this.TUrl = feed.getTUrl();
            this.tpic = feed.getTpic();
            this.tinfo = feed.getTinfo();
            this.tlink = feed.getTlink();
            this.relationRows = feed.getRelationRows();
            this.targetRow = feed.getTargetRow();
            this.star = Integer.valueOf(feed.getStar());
            this.includeGoods = feed.getIncludeGoods();
            this.fid = feed.getFid();
            this.dyhId = feed.getDyhId();
            this.dyhName = feed.getDyhName();
            this.userTags = feed.getUserTags();
            this.keywords = feed.getKeywords();
            this.extraKey = feed.getExtraKey();
            this.extraTitle = feed.getExtraTitle();
            this.extraType = feed.getExtraType();
            this.extraUrl = feed.getExtraUrl();
            this.extraInfo = feed.getExtraInfo();
            this.extraLinkUrl = feed.getExtraLinkUrl();
            this.extraPic = feed.getExtraPic();
            this.extraEntities = feed.getExtraEntities();
            this.videoPic = feed.getVideoPic();
            this.videoUrl = feed.getVideoUrl();
            this.location = feed.getLocation();
            this.longLocation = feed.getLongLocation();
            this.messageTitle = feed.getMessageTitle();
            this.messageKeywords = feed.getMessageKeywords();
            this.messageCover = feed.getMessageCover();
            this.questionAnswerNum = Integer.valueOf(feed.getQuestionAnswerNum());
            this.tags = feed.getTags();
            this.messageSource = feed.getMessageSource();
            this.questionFollowNum = Integer.valueOf(feed.getQuestionFollowNum());
            this.dyhModel = feed.getDyhModel();
            this.mediaInfo = feed.getMediaInfo();
            this.mediaUrl = feed.getMediaUrl();
            this.mediaType = feed.getMediaType();
            this.ratingType = feed.getRatingType();
            this.ratingScore = Float.valueOf(feed.getRatingScore());
            this.ratingScore1 = Float.valueOf(feed.getRatingScore1());
            this.ratingScore2 = Float.valueOf(feed.getRatingScore2());
            this.ratingScore3 = Float.valueOf(feed.getRatingScore3());
            this.ratingScore4 = Float.valueOf(feed.getRatingScore4());
            this.ratingScore5 = Float.valueOf(feed.getRatingScore5());
            this.ratingScore6 = Float.valueOf(feed.getRatingScore6());
            this.ratingScore7 = Float.valueOf(feed.getRatingScore7());
            this.ratingScore8 = Float.valueOf(feed.getRatingScore8());
            this.ratingScore9 = Float.valueOf(feed.getRatingScore9());
            this.ratingScore10 = Float.valueOf(feed.getRatingScore10());
            this.commentGood = feed.getCommentGood();
            this.commentGoodPic = feed.getCommentGoodPic();
            this.commentBad = feed.getCommentBad();
            this.commentBadPic = feed.getCommentBadPic();
            this.commentGeneral = feed.getCommentGeneral();
            this.commentGeneralPic = feed.getCommentGeneralPic();
            this.extraFromApi = feed.getExtraFromApi();
            this.shareUrl = feed.getShareUrl();
            this.detailSponsorCard = feed.getDetailSponsorCard();
            this.hotSponsorCard = feed.getHotSponsorCard();
            this.noticeSponsorCard = feed.getNoticeSponsorCard();
            this.buyStatus = Integer.valueOf(feed.getBuyStatus());
            this.topReplyRows = feed.getTopReplyRows();
            this.goodsAction = feed.getGoodsAction();
            this.editorTitle = feed.getEditorTitle();
            this.isOwner = Integer.valueOf(feed.getIsOwner());
            this.showOwner = Integer.valueOf(feed.getShowOwner());
            this.isAnonymous = Integer.valueOf(feed.getIsAnonymous());
            this.vote = feed.getVote();
            this.secondHandInfo = feed.getSecondHandInfo();
            this.isRecommendVoteComment = Integer.valueOf(feed.getIsRecommendVoteComment());
            this.topInfo = feed.getTopInfo();
            this.innerInfo = feed.getInnerInfo();
            this.isModified = Integer.valueOf(feed.getIsModified());
            this.enableModify = Integer.valueOf(feed.getEnableModify());
            this.isHistory = Integer.valueOf(feed.getIsHistory());
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder entityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder dateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder lastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Feed.Builder deprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Feed.Builder userInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Feed.Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Feed.Builder deprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Feed.Builder displayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder label(String str) {
            this.label = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder type(int i) {
            this.type = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder picArray(List<String> list) {
            this.picArray = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder infoHtml(String str) {
            this.infoHtml = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder info(String str) {
            this.info = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder forwardNum(int i) {
            this.forwardNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder shareNum(int i) {
            this.shareNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder likeNum(int i) {
            this.likeNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder replyNum(int i) {
            this.replyNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder relatedNum(int i) {
            this.relatedNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder followNum(int i) {
            this.followNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder useragent(String str) {
            this.useragent = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder articleId(String str) {
            this.articleId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder status(int i) {
            this.status = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder message(String str) {
            this.message = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isHtmlArticle(int i) {
            this.isHtmlArticle = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isStickTop(int i) {
            this.isStickTop = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder messageRawOutput(String str) {
            this.messageRawOutput = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder messageRawInput(String str) {
            this.messageRawInput = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder feedTypeName(String str) {
            this.feedTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder recommend(int i) {
            this.recommend = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder favoriteNum(int i) {
            this.favoriteNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder commentBlockNum(int i) {
            this.commentBlockNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder blockStatus(int i) {
            this.blockStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder feedFromType(String str) {
            this.feedFromType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder feedType(String str) {
            this.feedType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder fetchType(String str) {
            this.fetchType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder replyRows(List<FeedReply> list) {
            this.replyRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder messageStatus(int i) {
            this.messageStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder relatedData(List<RelatedData> list) {
            this.relatedData = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder userLikeList(List<RelatedData> list) {
            this.userLikeList = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder userFollowList(List<RelatedData> list) {
            this.userFollowList = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder deviceTitle(String str) {
            this.deviceTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder collectionInfo(Collection collection) {
            this.collectionInfo = collection;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder collectionItem(CollectionItem collectionItem2) {
            this.collectionItem = collectionItem2;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder userAction(UserAction userAction2) {
            this.userAction = userAction2;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder replyMeRows(List<FeedReply> list) {
            this.replyMeRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder recentReplyRows(List<FeedReply> list) {
            this.recentReplyRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder hotReplyRows(List<FeedReply> list) {
            this.hotReplyRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder recentLikeList(List<String> list) {
            this.recentLikeList = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder goodsListItem(List<GoodsListItem> list) {
            this.goodsListItem = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder forwardSourceFeed(Feed feed) {
            this.forwardSourceFeed = feed;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder forwardSourceArticle(DyhArticle dyhArticle) {
            this.forwardSourceArticle = dyhArticle;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder forwardSourceType(String str) {
            this.forwardSourceType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder likeUserName(String str) {
            this.likeUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder likeUid(String str) {
            this.likeUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder likeTime(long j) {
            this.likeTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder likeUserInfo(UserInfo userInfo2) {
            this.likeUserInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder likeAvatar(String str) {
            this.likeAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder forwardId(String str) {
            this.forwardId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder sourceId(String str) {
            this.sourceId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder spamReason(String str) {
            this.spamReason = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder spamContent(String str) {
            this.spamContent = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder adminInfo(String str) {
            this.adminInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder statusText(String str) {
            this.statusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder messageStatusText(String str) {
            this.messageStatusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder blockStatusText(String str) {
            this.blockStatusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isHeadline(int i) {
            this.isHeadline = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isHeadlined(int i) {
            this.isHeadlined = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isHeadlineV8(int i) {
            this.isHeadlineV8 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isHeadlineCommentV8(int i) {
            this.isHeadlineCommentV8 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder spamTime(long j) {
            this.spamTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder appName(String str) {
            this.appName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder tkey(String str) {
            this.tkey = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ttype(String str) {
            this.ttype = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder tid(String str) {
            this.tid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder TUrl(String str) {
            this.TUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder tpic(String str) {
            this.tpic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder tinfo(String str) {
            this.tinfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder tlink(String str) {
            this.tlink = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder relationRows(List<FeedRelation> list) {
            this.relationRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder targetRow(FeedTarget feedTarget) {
            this.targetRow = feedTarget;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder star(int i) {
            this.star = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder includeGoods(List<FeedGoods> list) {
            this.includeGoods = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder fid(String str) {
            this.fid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder dyhId(String str) {
            this.dyhId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder dyhName(String str) {
            this.dyhName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder userTags(String str) {
            this.userTags = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder keywords(String str) {
            this.keywords = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraKey(String str) {
            this.extraKey = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraTitle(String str) {
            this.extraTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraType(String str) {
            this.extraType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraUrl(String str) {
            this.extraUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraInfo(String str) {
            this.extraInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraLinkUrl(String str) {
            this.extraLinkUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraPic(String str) {
            this.extraPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraEntities(List<Entity> list) {
            this.extraEntities = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder videoPic(String str) {
            this.videoPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder videoUrl(String str) {
            this.videoUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder location(String str) {
            this.location = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder longLocation(String str) {
            this.longLocation = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder messageTitle(String str) {
            this.messageTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder messageKeywords(String str) {
            this.messageKeywords = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder messageCover(String str) {
            this.messageCover = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder questionAnswerNum(int i) {
            this.questionAnswerNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder tags(String str) {
            this.tags = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder messageSource(String str) {
            this.messageSource = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder questionFollowNum(int i) {
            this.questionFollowNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder dyhModel(DyhModel dyhModel2) {
            this.dyhModel = dyhModel2;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder mediaInfo(String str) {
            this.mediaInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder mediaUrl(String str) {
            this.mediaUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder mediaType(String str) {
            this.mediaType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingType(String str) {
            this.ratingType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore(float f) {
            this.ratingScore = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore1(float f) {
            this.ratingScore1 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore2(float f) {
            this.ratingScore2 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore3(float f) {
            this.ratingScore3 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore4(float f) {
            this.ratingScore4 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore5(float f) {
            this.ratingScore5 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore6(float f) {
            this.ratingScore6 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore7(float f) {
            this.ratingScore7 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore8(float f) {
            this.ratingScore8 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore9(float f) {
            this.ratingScore9 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder ratingScore10(float f) {
            this.ratingScore10 = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder commentGood(String str) {
            this.commentGood = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder commentGoodPic(String str) {
            this.commentGoodPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder commentBad(String str) {
            this.commentBad = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder commentBadPic(String str) {
            this.commentBadPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder commentGeneral(String str) {
            this.commentGeneral = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder commentGeneralPic(String str) {
            this.commentGeneralPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder extraFromApi(String str) {
            this.extraFromApi = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder shareUrl(String str) {
            this.shareUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder detailSponsorCard(Entity entity) {
            this.detailSponsorCard = entity;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder hotSponsorCard(Entity entity) {
            this.hotSponsorCard = entity;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder noticeSponsorCard(Entity entity) {
            this.noticeSponsorCard = entity;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder buyStatus(int i) {
            this.buyStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder topReplyRows(List<FeedReply> list) {
            this.topReplyRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder goodsAction(FeedGoodsAction feedGoodsAction) {
            this.goodsAction = feedGoodsAction;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder editorTitle(String str) {
            this.editorTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isOwner(int i) {
            this.isOwner = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder showOwner(int i) {
            this.showOwner = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isAnonymous(int i) {
            this.isAnonymous = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder vote(Vote vote2) {
            this.vote = vote2;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder secondHandInfo(SecondHandInfo secondHandInfo2) {
            this.secondHandInfo = secondHandInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isRecommendVoteComment(int i) {
            this.isRecommendVoteComment = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder topInfo(SimpleInfo simpleInfo) {
            this.topInfo = simpleInfo;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder innerInfo(SimpleInfo simpleInfo) {
            this.innerInfo = simpleInfo;
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isModified(int i) {
            this.isModified = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder enableModify(int i) {
            this.enableModify = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed.Builder isHistory(int i) {
            this.isHistory = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Feed.Builder
        public Feed build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.title == null) {
                str = str + " title";
            }
            if (this.id == null) {
                str = str + " id";
            }
            if (this.type == null) {
                str = str + " type";
            }
            if (this.pic == null) {
                str = str + " pic";
            }
            if (this.picArray == null) {
                str = str + " picArray";
            }
            if (this.infoHtml == null) {
                str = str + " infoHtml";
            }
            if (this.info == null) {
                str = str + " info";
            }
            if (this.forwardNum == null) {
                str = str + " forwardNum";
            }
            if (this.shareNum == null) {
                str = str + " shareNum";
            }
            if (this.likeNum == null) {
                str = str + " likeNum";
            }
            if (this.replyNum == null) {
                str = str + " replyNum";
            }
            if (this.relatedNum == null) {
                str = str + " relatedNum";
            }
            if (this.followNum == null) {
                str = str + " followNum";
            }
            if (this.status == null) {
                str = str + " status";
            }
            if (this.message == null) {
                str = str + " message";
            }
            if (this.isHtmlArticle == null) {
                str = str + " isHtmlArticle";
            }
            if (this.isStickTop == null) {
                str = str + " isStickTop";
            }
            if (this.recommend == null) {
                str = str + " recommend";
            }
            if (this.favoriteNum == null) {
                str = str + " favoriteNum";
            }
            if (this.commentBlockNum == null) {
                str = str + " commentBlockNum";
            }
            if (this.blockStatus == null) {
                str = str + " blockStatus";
            }
            if (this.feedType == null) {
                str = str + " feedType";
            }
            if (this.fetchType == null) {
                str = str + " fetchType";
            }
            if (this.messageStatus == null) {
                str = str + " messageStatus";
            }
            if (this.userFollowList == null) {
                str = str + " userFollowList";
            }
            if (this.replyMeRows == null) {
                str = str + " replyMeRows";
            }
            if (this.recentReplyRows == null) {
                str = str + " recentReplyRows";
            }
            if (this.hotReplyRows == null) {
                str = str + " hotReplyRows";
            }
            if (this.recentLikeList == null) {
                str = str + " recentLikeList";
            }
            if (this.goodsListItem == null) {
                str = str + " goodsListItem";
            }
            if (this.likeTime == null) {
                str = str + " likeTime";
            }
            if (this.isHeadline == null) {
                str = str + " isHeadline";
            }
            if (this.isHeadlined == null) {
                str = str + " isHeadlined";
            }
            if (this.isHeadlineV8 == null) {
                str = str + " isHeadlineV8";
            }
            if (this.isHeadlineCommentV8 == null) {
                str = str + " isHeadlineCommentV8";
            }
            if (this.spamTime == null) {
                str = str + " spamTime";
            }
            if (this.appName == null) {
                str = str + " appName";
            }
            if (this.relationRows == null) {
                str = str + " relationRows";
            }
            if (this.star == null) {
                str = str + " star";
            }
            if (this.includeGoods == null) {
                str = str + " includeGoods";
            }
            if (this.extraEntities == null) {
                str = str + " extraEntities";
            }
            if (this.questionAnswerNum == null) {
                str = str + " questionAnswerNum";
            }
            if (this.questionFollowNum == null) {
                str = str + " questionFollowNum";
            }
            if (this.ratingScore == null) {
                str = str + " ratingScore";
            }
            if (this.ratingScore1 == null) {
                str = str + " ratingScore1";
            }
            if (this.ratingScore2 == null) {
                str = str + " ratingScore2";
            }
            if (this.ratingScore3 == null) {
                str = str + " ratingScore3";
            }
            if (this.ratingScore4 == null) {
                str = str + " ratingScore4";
            }
            if (this.ratingScore5 == null) {
                str = str + " ratingScore5";
            }
            if (this.ratingScore6 == null) {
                str = str + " ratingScore6";
            }
            if (this.ratingScore7 == null) {
                str = str + " ratingScore7";
            }
            if (this.ratingScore8 == null) {
                str = str + " ratingScore8";
            }
            if (this.ratingScore9 == null) {
                str = str + " ratingScore9";
            }
            if (this.ratingScore10 == null) {
                str = str + " ratingScore10";
            }
            if (this.buyStatus == null) {
                str = str + " buyStatus";
            }
            if (this.topReplyRows == null) {
                str = str + " topReplyRows";
            }
            if (this.isOwner == null) {
                str = str + " isOwner";
            }
            if (this.showOwner == null) {
                str = str + " showOwner";
            }
            if (this.isAnonymous == null) {
                str = str + " isAnonymous";
            }
            if (this.isRecommendVoteComment == null) {
                str = str + " isRecommendVoteComment";
            }
            if (this.isModified == null) {
                str = str + " isModified";
            }
            if (this.enableModify == null) {
                str = str + " enableModify";
            }
            if (this.isHistory == null) {
                str = str + " isHistory";
            }
            if (str.isEmpty()) {
                return new AutoValue_Feed(this.entityTypeName, this.entityType, this.entityTemplate, this.entityId, this.entityFixed, this.description, this.subTitle, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.uid, this.deprecatedUserName, this.displayUserName, this.title, this.id, this.label, this.type.intValue(), this.pic, this.picArray, this.infoHtml, this.info, this.forwardNum.intValue(), this.shareNum.intValue(), this.likeNum.intValue(), this.replyNum.intValue(), this.relatedNum.intValue(), this.followNum.intValue(), this.useragent, this.articleId, this.status.intValue(), this.message, this.isHtmlArticle.intValue(), this.isStickTop.intValue(), this.messageRawOutput, this.messageRawInput, this.feedTypeName, this.recommend.intValue(), this.favoriteNum.intValue(), this.commentBlockNum.intValue(), this.blockStatus.intValue(), this.feedFromType, this.feedType, this.fetchType, this.replyRows, this.messageStatus.intValue(), this.relatedData, this.userLikeList, this.userFollowList, this.deviceTitle, this.collectionInfo, this.collectionItem, this.userAction, this.replyMeRows, this.recentReplyRows, this.hotReplyRows, this.recentLikeList, this.goodsListItem, this.forwardSourceFeed, this.forwardSourceArticle, this.forwardSourceType, this.url, this.likeUserName, this.likeUid, this.likeTime.longValue(), this.likeUserInfo, this.likeAvatar, this.forwardId, this.sourceId, this.spamReason, this.spamContent, this.adminInfo, this.statusText, this.messageStatusText, this.blockStatusText, this.isHeadline.intValue(), this.isHeadlined.intValue(), this.isHeadlineV8.intValue(), this.isHeadlineCommentV8.intValue(), this.spamTime.longValue(), this.appName, this.tkey, this.ttype, this.tid, this.TUrl, this.tpic, this.tinfo, this.tlink, this.relationRows, this.targetRow, this.star.intValue(), this.includeGoods, this.fid, this.dyhId, this.dyhName, this.userTags, this.keywords, this.extraKey, this.extraTitle, this.extraType, this.extraUrl, this.extraInfo, this.extraLinkUrl, this.extraPic, this.extraEntities, this.videoPic, this.videoUrl, this.location, this.longLocation, this.messageTitle, this.messageKeywords, this.messageCover, this.questionAnswerNum.intValue(), this.tags, this.messageSource, this.questionFollowNum.intValue(), this.dyhModel, this.mediaInfo, this.mediaUrl, this.mediaType, this.ratingType, this.ratingScore.floatValue(), this.ratingScore1.floatValue(), this.ratingScore2.floatValue(), this.ratingScore3.floatValue(), this.ratingScore4.floatValue(), this.ratingScore5.floatValue(), this.ratingScore6.floatValue(), this.ratingScore7.floatValue(), this.ratingScore8.floatValue(), this.ratingScore9.floatValue(), this.ratingScore10.floatValue(), this.commentGood, this.commentGoodPic, this.commentBad, this.commentBadPic, this.commentGeneral, this.commentGeneralPic, this.extraFromApi, this.shareUrl, this.detailSponsorCard, this.hotSponsorCard, this.noticeSponsorCard, this.buyStatus.intValue(), this.topReplyRows, this.goodsAction, this.editorTitle, this.isOwner.intValue(), this.showOwner.intValue(), this.isAnonymous.intValue(), this.vote, this.secondHandInfo, this.isRecommendVoteComment.intValue(), this.topInfo, this.innerInfo, this.isModified.intValue(), this.enableModify.intValue(), this.isHistory.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
