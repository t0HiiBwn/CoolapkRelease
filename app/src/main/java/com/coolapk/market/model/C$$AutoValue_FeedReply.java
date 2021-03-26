package com.coolapk.market.model;

import com.coolapk.market.model.FeedReply;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_FeedReply  reason: invalid class name */
abstract class C$$AutoValue_FeedReply extends FeedReply {
    private final String adminInfo;
    private final int blockStatus;
    private final String blockStatusText;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String displayUserName;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String extraFlag;
    private final String extraPic;
    private final String extraTitle;
    private final String extraType;
    private final String extraUrl;
    private final String feedId;
    private final String fetchType;
    private final int ftype;
    private final String id;
    private final String infoHtml;
    private final SimpleInfo innerInfo;
    private final int isFeedAuthor;
    private final int isFolded;
    private final Long lastUpdate;
    private final String likeAvatar;
    private final int likeNum;
    private final long likeTime;
    private final String likeUid;
    private final UserInfo likeUserInfo;
    private final String likeUserName;
    private final String logo;
    private final String message;
    private final String messageSource;
    private final int messageStatus;
    private final String messageStatusText;
    private final String parentReplyId;
    private final String pic;
    private final DyhArticle replyArticle;
    private final FeedReply.ReplyFeed replyFeed;
    private final int replyId;
    private final int replyNum;
    private final List<FeedReply> replyRows;
    private final int replyRowsCount;
    private final int replyRowsMore;
    private final String replyUid;
    private final String replyUserAvatar;
    private final String replyUserName;
    private final String spamContent;
    private final String spamReason;
    private final long spamTime;
    private final int status;
    private final String statusText;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final FeedReply.ReplyUserAction userAction;
    private final String userAgent;
    private final UserInfo userInfo;

    C$$AutoValue_FeedReply(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, String str10, String str11, String str12, String str13, String str14, UserInfo userInfo2, int i, int i2, String str15, String str16, String str17, String str18, int i3, int i4, String str19, String str20, String str21, String str22, String str23, List<FeedReply> list, int i5, int i6, String str24, String str25, String str26, UserInfo userInfo3, int i7, String str27, int i8, int i9, int i10, int i11, String str28, String str29, String str30, String str31, String str32, String str33, String str34, FeedReply.ReplyUserAction replyUserAction, long j, String str35, String str36, long j2, String str37, String str38, String str39, FeedReply.ReplyFeed replyFeed2, DyhArticle dyhArticle, SimpleInfo simpleInfo) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.description = str5;
        this.logo = str6;
        this.subTitle = str7;
        this.extraData = str8;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.deprecatedUserAvatar = str9;
        this.displayUserName = str10;
        Objects.requireNonNull(str11, "Null id");
        this.id = str11;
        Objects.requireNonNull(str12, "Null feedId");
        this.feedId = str12;
        Objects.requireNonNull(str13, "Null uid");
        this.uid = str13;
        Objects.requireNonNull(str14, "Null deprecatedUserName");
        this.deprecatedUserName = str14;
        this.userInfo = userInfo2;
        this.ftype = i;
        this.replyId = i2;
        this.replyUserName = str15;
        this.replyUserAvatar = str16;
        this.replyUid = str17;
        Objects.requireNonNull(str18, "Null message");
        this.message = str18;
        this.replyNum = i3;
        this.isFeedAuthor = i4;
        this.pic = str19;
        this.messageSource = str20;
        this.userAgent = str21;
        this.url = str22;
        this.fetchType = str23;
        Objects.requireNonNull(list, "Null replyRows");
        this.replyRows = list;
        this.replyRowsCount = i5;
        this.replyRowsMore = i6;
        this.parentReplyId = str24;
        this.spamReason = str25;
        this.spamContent = str26;
        this.likeUserInfo = userInfo3;
        this.likeNum = i7;
        this.infoHtml = str27;
        this.isFolded = i8;
        this.blockStatus = i9;
        this.status = i10;
        this.messageStatus = i11;
        this.statusText = str28;
        this.messageStatusText = str29;
        this.blockStatusText = str30;
        this.extraTitle = str31;
        this.extraType = str32;
        this.extraPic = str33;
        this.extraUrl = str34;
        this.userAction = replyUserAction;
        this.spamTime = j;
        this.likeUserName = str35;
        this.likeUid = str36;
        this.likeTime = j2;
        this.adminInfo = str37;
        this.likeAvatar = str38;
        this.extraFlag = str39;
        this.replyFeed = replyFeed2;
        this.replyArticle = dyhArticle;
        this.innerInfo = simpleInfo;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
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
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
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
    @SerializedName("displayUsername")
    public String getDisplayUserName() {
        return this.displayUserName;
    }

    @Override // com.coolapk.market.model.FeedReply, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("fid")
    public String getFeedId() {
        return this.feedId;
    }

    @Override // com.coolapk.market.model.FeedReply, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.FeedReply, com.coolapk.market.model.IUser
    @SerializedName("username")
    public String getDeprecatedUserName() {
        return this.deprecatedUserName;
    }

    @Override // com.coolapk.market.model.FeedReply, com.coolapk.market.model.IUser
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("ftype")
    public int getFtype() {
        return this.ftype;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("rid")
    public int getReplyId() {
        return this.replyId;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("rusername")
    public String getReplyUserName() {
        return this.replyUserName;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("ravatar")
    public String getReplyUserAvatar() {
        return this.replyUserAvatar;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("ruid")
    public String getReplyUid() {
        return this.replyUid;
    }

    @Override // com.coolapk.market.model.FeedReply
    public String getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("replynum")
    public int getReplyNum() {
        return this.replyNum;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("isFeedAuthor")
    public int getIsFeedAuthor() {
        return this.isFeedAuthor;
    }

    @Override // com.coolapk.market.model.FeedReply, com.coolapk.market.model.Entity
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("messagesource")
    public String getMessageSource() {
        return this.messageSource;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("useragent")
    public String getUserAgent() {
        return this.userAgent;
    }

    @Override // com.coolapk.market.model.FeedReply, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("fetchType")
    public String getFetchType() {
        return this.fetchType;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("replyRows")
    public List<FeedReply> getReplyRows() {
        return this.replyRows;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("replyRowsCount")
    public int getReplyRowsCount() {
        return this.replyRowsCount;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("replyRowsMore")
    public int getReplyRowsMore() {
        return this.replyRowsMore;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("rrid")
    public String getParentReplyId() {
        return this.parentReplyId;
    }

    @Override // com.coolapk.market.model.FeedReply
    public String getSpamReason() {
        return this.spamReason;
    }

    @Override // com.coolapk.market.model.FeedReply
    public String getSpamContent() {
        return this.spamContent;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("likeUserInfo")
    public UserInfo getLikeUserInfo() {
        return this.likeUserInfo;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("likenum")
    public int getLikeNum() {
        return this.likeNum;
    }

    @Override // com.coolapk.market.model.FeedReply
    public String getInfoHtml() {
        return this.infoHtml;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("is_folded")
    public int getIsFolded() {
        return this.isFolded;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("block_status")
    public int getBlockStatus() {
        return this.blockStatus;
    }

    @Override // com.coolapk.market.model.FeedReply
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("message_status")
    public int getMessageStatus() {
        return this.messageStatus;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("statusText")
    public String getStatusText() {
        return this.statusText;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("messageStatusText")
    public String getMessageStatusText() {
        return this.messageStatusText;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("blockStatusText")
    public String getBlockStatusText() {
        return this.blockStatusText;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("extra_title")
    public String getExtraTitle() {
        return this.extraTitle;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("extra_type")
    public String getExtraType() {
        return this.extraType;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("extra_pic")
    public String getExtraPic() {
        return this.extraPic;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("extra_url")
    public String getExtraUrl() {
        return this.extraUrl;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("userAction")
    public FeedReply.ReplyUserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.FeedReply
    public long getSpamTime() {
        return this.spamTime;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("likeUsername")
    public String getLikeUserName() {
        return this.likeUserName;
    }

    @Override // com.coolapk.market.model.FeedReply
    public String getLikeUid() {
        return this.likeUid;
    }

    @Override // com.coolapk.market.model.FeedReply
    public long getLikeTime() {
        return this.likeTime;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("adminInfo")
    public String getAdminInfo() {
        return this.adminInfo;
    }

    @Override // com.coolapk.market.model.FeedReply
    public String getLikeAvatar() {
        return this.likeAvatar;
    }

    @Override // com.coolapk.market.model.FeedReply
    public String getExtraFlag() {
        return this.extraFlag;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("feed")
    public FeedReply.ReplyFeed getReplyFeed() {
        return this.replyFeed;
    }

    @Override // com.coolapk.market.model.FeedReply
    @SerializedName("article")
    public DyhArticle getReplyArticle() {
        return this.replyArticle;
    }

    @Override // com.coolapk.market.model.FeedReply
    public SimpleInfo getInnerInfo() {
        return this.innerInfo;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FeedReply{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", description=" + this.description + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", displayUserName=" + this.displayUserName + ", id=" + this.id + ", feedId=" + this.feedId + ", uid=" + this.uid + ", deprecatedUserName=" + this.deprecatedUserName + ", userInfo=" + this.userInfo + ", ftype=" + this.ftype + ", replyId=" + this.replyId + ", replyUserName=" + this.replyUserName + ", replyUserAvatar=" + this.replyUserAvatar + ", replyUid=" + this.replyUid + ", message=" + this.message + ", replyNum=" + this.replyNum + ", isFeedAuthor=" + this.isFeedAuthor + ", pic=" + this.pic + ", messageSource=" + this.messageSource + ", userAgent=" + this.userAgent + ", url=" + this.url + ", fetchType=" + this.fetchType + ", replyRows=" + this.replyRows + ", replyRowsCount=" + this.replyRowsCount + ", replyRowsMore=" + this.replyRowsMore + ", parentReplyId=" + this.parentReplyId + ", spamReason=" + this.spamReason + ", spamContent=" + this.spamContent + ", likeUserInfo=" + this.likeUserInfo + ", likeNum=" + this.likeNum + ", infoHtml=" + this.infoHtml + ", isFolded=" + this.isFolded + ", blockStatus=" + this.blockStatus + ", status=" + this.status + ", messageStatus=" + this.messageStatus + ", statusText=" + this.statusText + ", messageStatusText=" + this.messageStatusText + ", blockStatusText=" + this.blockStatusText + ", extraTitle=" + this.extraTitle + ", extraType=" + this.extraType + ", extraPic=" + this.extraPic + ", extraUrl=" + this.extraUrl + ", userAction=" + this.userAction + ", spamTime=" + this.spamTime + ", likeUserName=" + this.likeUserName + ", likeUid=" + this.likeUid + ", likeTime=" + this.likeTime + ", adminInfo=" + this.adminInfo + ", likeAvatar=" + this.likeAvatar + ", extraFlag=" + this.extraFlag + ", replyFeed=" + this.replyFeed + ", replyArticle=" + this.replyArticle + ", innerInfo=" + this.innerInfo + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        UserInfo userInfo2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        UserInfo userInfo3;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        FeedReply.ReplyUserAction replyUserAction;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        FeedReply.ReplyFeed replyFeed2;
        DyhArticle dyhArticle;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedReply)) {
            return false;
        }
        FeedReply feedReply = (FeedReply) obj;
        String str25 = this.entityTypeName;
        if (str25 != null ? str25.equals(feedReply.getEntityTypeName()) : feedReply.getEntityTypeName() == null) {
            String str26 = this.entityTemplate;
            if (str26 != null ? str26.equals(feedReply.getEntityTemplate()) : feedReply.getEntityTemplate() == null) {
                String str27 = this.entityId;
                if (str27 != null ? str27.equals(feedReply.getEntityId()) : feedReply.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(feedReply.getEntityFixed()) : feedReply.getEntityFixed() == null) {
                        String str28 = this.title;
                        if (str28 != null ? str28.equals(feedReply.getTitle()) : feedReply.getTitle() == null) {
                            String str29 = this.description;
                            if (str29 != null ? str29.equals(feedReply.getDescription()) : feedReply.getDescription() == null) {
                                String str30 = this.logo;
                                if (str30 != null ? str30.equals(feedReply.getLogo()) : feedReply.getLogo() == null) {
                                    String str31 = this.subTitle;
                                    if (str31 != null ? str31.equals(feedReply.getSubTitle()) : feedReply.getSubTitle() == null) {
                                        String str32 = this.extraData;
                                        if (str32 != null ? str32.equals(feedReply.getExtraData()) : feedReply.getExtraData() == null) {
                                            Long l2 = this.dateline;
                                            if (l2 != null ? l2.equals(feedReply.getDateline()) : feedReply.getDateline() == null) {
                                                Long l3 = this.lastUpdate;
                                                if (l3 != null ? l3.equals(feedReply.getLastUpdate()) : feedReply.getLastUpdate() == null) {
                                                    String str33 = this.deprecatedUserAvatar;
                                                    if (str33 != null ? str33.equals(feedReply.getDeprecatedUserAvatar()) : feedReply.getDeprecatedUserAvatar() == null) {
                                                        String str34 = this.displayUserName;
                                                        if (str34 != null ? str34.equals(feedReply.getDisplayUserName()) : feedReply.getDisplayUserName() == null) {
                                                            if (this.id.equals(feedReply.getId()) && this.feedId.equals(feedReply.getFeedId()) && this.uid.equals(feedReply.getUid()) && this.deprecatedUserName.equals(feedReply.getDeprecatedUserName()) && ((userInfo2 = this.userInfo) != null ? userInfo2.equals(feedReply.getUserInfo()) : feedReply.getUserInfo() == null) && this.ftype == feedReply.getFtype() && this.replyId == feedReply.getReplyId() && ((str = this.replyUserName) != null ? str.equals(feedReply.getReplyUserName()) : feedReply.getReplyUserName() == null) && ((str2 = this.replyUserAvatar) != null ? str2.equals(feedReply.getReplyUserAvatar()) : feedReply.getReplyUserAvatar() == null) && ((str3 = this.replyUid) != null ? str3.equals(feedReply.getReplyUid()) : feedReply.getReplyUid() == null) && this.message.equals(feedReply.getMessage()) && this.replyNum == feedReply.getReplyNum() && this.isFeedAuthor == feedReply.getIsFeedAuthor() && ((str4 = this.pic) != null ? str4.equals(feedReply.getPic()) : feedReply.getPic() == null) && ((str5 = this.messageSource) != null ? str5.equals(feedReply.getMessageSource()) : feedReply.getMessageSource() == null) && ((str6 = this.userAgent) != null ? str6.equals(feedReply.getUserAgent()) : feedReply.getUserAgent() == null) && ((str7 = this.url) != null ? str7.equals(feedReply.getUrl()) : feedReply.getUrl() == null) && ((str8 = this.fetchType) != null ? str8.equals(feedReply.getFetchType()) : feedReply.getFetchType() == null) && this.replyRows.equals(feedReply.getReplyRows()) && this.replyRowsCount == feedReply.getReplyRowsCount() && this.replyRowsMore == feedReply.getReplyRowsMore() && ((str9 = this.parentReplyId) != null ? str9.equals(feedReply.getParentReplyId()) : feedReply.getParentReplyId() == null) && ((str10 = this.spamReason) != null ? str10.equals(feedReply.getSpamReason()) : feedReply.getSpamReason() == null) && ((str11 = this.spamContent) != null ? str11.equals(feedReply.getSpamContent()) : feedReply.getSpamContent() == null) && ((userInfo3 = this.likeUserInfo) != null ? userInfo3.equals(feedReply.getLikeUserInfo()) : feedReply.getLikeUserInfo() == null) && this.likeNum == feedReply.getLikeNum() && ((str12 = this.infoHtml) != null ? str12.equals(feedReply.getInfoHtml()) : feedReply.getInfoHtml() == null) && this.isFolded == feedReply.getIsFolded() && this.blockStatus == feedReply.getBlockStatus() && this.status == feedReply.getStatus() && this.messageStatus == feedReply.getMessageStatus() && ((str13 = this.statusText) != null ? str13.equals(feedReply.getStatusText()) : feedReply.getStatusText() == null) && ((str14 = this.messageStatusText) != null ? str14.equals(feedReply.getMessageStatusText()) : feedReply.getMessageStatusText() == null) && ((str15 = this.blockStatusText) != null ? str15.equals(feedReply.getBlockStatusText()) : feedReply.getBlockStatusText() == null) && ((str16 = this.extraTitle) != null ? str16.equals(feedReply.getExtraTitle()) : feedReply.getExtraTitle() == null) && ((str17 = this.extraType) != null ? str17.equals(feedReply.getExtraType()) : feedReply.getExtraType() == null) && ((str18 = this.extraPic) != null ? str18.equals(feedReply.getExtraPic()) : feedReply.getExtraPic() == null) && ((str19 = this.extraUrl) != null ? str19.equals(feedReply.getExtraUrl()) : feedReply.getExtraUrl() == null) && ((replyUserAction = this.userAction) != null ? replyUserAction.equals(feedReply.getUserAction()) : feedReply.getUserAction() == null) && this.spamTime == feedReply.getSpamTime() && ((str20 = this.likeUserName) != null ? str20.equals(feedReply.getLikeUserName()) : feedReply.getLikeUserName() == null) && ((str21 = this.likeUid) != null ? str21.equals(feedReply.getLikeUid()) : feedReply.getLikeUid() == null) && this.likeTime == feedReply.getLikeTime() && ((str22 = this.adminInfo) != null ? str22.equals(feedReply.getAdminInfo()) : feedReply.getAdminInfo() == null) && ((str23 = this.likeAvatar) != null ? str23.equals(feedReply.getLikeAvatar()) : feedReply.getLikeAvatar() == null) && ((str24 = this.extraFlag) != null ? str24.equals(feedReply.getExtraFlag()) : feedReply.getExtraFlag() == null) && ((replyFeed2 = this.replyFeed) != null ? replyFeed2.equals(feedReply.getReplyFeed()) : feedReply.getReplyFeed() == null) && ((dyhArticle = this.replyArticle) != null ? dyhArticle.equals(feedReply.getReplyArticle()) : feedReply.getReplyArticle() == null)) {
                                                                SimpleInfo simpleInfo = this.innerInfo;
                                                                if (simpleInfo == null) {
                                                                    if (feedReply.getInnerInfo() == null) {
                                                                        return true;
                                                                    }
                                                                } else if (simpleInfo.equals(feedReply.getInnerInfo())) {
                                                                    return true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.title;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.description;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.logo;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.subTitle;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.extraData;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode10 = (hashCode9 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode11 = (hashCode10 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str9 = this.deprecatedUserAvatar;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.displayUserName;
        int hashCode13 = (((((((((hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.feedId.hashCode()) * 1000003) ^ this.uid.hashCode()) * 1000003) ^ this.deprecatedUserName.hashCode()) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode14 = (((((hashCode13 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003) ^ this.ftype) * 1000003) ^ this.replyId) * 1000003;
        String str11 = this.replyUserName;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.replyUserAvatar;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.replyUid;
        int hashCode17 = (((((((hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003) ^ this.message.hashCode()) * 1000003) ^ this.replyNum) * 1000003) ^ this.isFeedAuthor) * 1000003;
        String str14 = this.pic;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.messageSource;
        int hashCode19 = (hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.userAgent;
        int hashCode20 = (hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.url;
        int hashCode21 = (hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.fetchType;
        int hashCode22 = (((((((hashCode21 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003) ^ this.replyRows.hashCode()) * 1000003) ^ this.replyRowsCount) * 1000003) ^ this.replyRowsMore) * 1000003;
        String str19 = this.parentReplyId;
        int hashCode23 = (hashCode22 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        String str20 = this.spamReason;
        int hashCode24 = (hashCode23 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        String str21 = this.spamContent;
        int hashCode25 = (hashCode24 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003;
        UserInfo userInfo3 = this.likeUserInfo;
        int hashCode26 = (((hashCode25 ^ (userInfo3 == null ? 0 : userInfo3.hashCode())) * 1000003) ^ this.likeNum) * 1000003;
        String str22 = this.infoHtml;
        int hashCode27 = (((((((((hashCode26 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003) ^ this.isFolded) * 1000003) ^ this.blockStatus) * 1000003) ^ this.status) * 1000003) ^ this.messageStatus) * 1000003;
        String str23 = this.statusText;
        int hashCode28 = (hashCode27 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
        String str24 = this.messageStatusText;
        int hashCode29 = (hashCode28 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
        String str25 = this.blockStatusText;
        int hashCode30 = (hashCode29 ^ (str25 == null ? 0 : str25.hashCode())) * 1000003;
        String str26 = this.extraTitle;
        int hashCode31 = (hashCode30 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003;
        String str27 = this.extraType;
        int hashCode32 = (hashCode31 ^ (str27 == null ? 0 : str27.hashCode())) * 1000003;
        String str28 = this.extraPic;
        int hashCode33 = (hashCode32 ^ (str28 == null ? 0 : str28.hashCode())) * 1000003;
        String str29 = this.extraUrl;
        int hashCode34 = (hashCode33 ^ (str29 == null ? 0 : str29.hashCode())) * 1000003;
        FeedReply.ReplyUserAction replyUserAction = this.userAction;
        int hashCode35 = replyUserAction == null ? 0 : replyUserAction.hashCode();
        long j = this.spamTime;
        int i2 = ((int) (((long) ((hashCode34 ^ hashCode35) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003;
        String str30 = this.likeUserName;
        int hashCode36 = ((str30 == null ? 0 : str30.hashCode()) ^ i2) * 1000003;
        String str31 = this.likeUid;
        int hashCode37 = str31 == null ? 0 : str31.hashCode();
        long j2 = this.likeTime;
        int i3 = ((int) (((long) ((hashCode36 ^ hashCode37) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003;
        String str32 = this.adminInfo;
        int hashCode38 = (i3 ^ (str32 == null ? 0 : str32.hashCode())) * 1000003;
        String str33 = this.likeAvatar;
        int hashCode39 = (hashCode38 ^ (str33 == null ? 0 : str33.hashCode())) * 1000003;
        String str34 = this.extraFlag;
        int hashCode40 = (hashCode39 ^ (str34 == null ? 0 : str34.hashCode())) * 1000003;
        FeedReply.ReplyFeed replyFeed2 = this.replyFeed;
        int hashCode41 = (hashCode40 ^ (replyFeed2 == null ? 0 : replyFeed2.hashCode())) * 1000003;
        DyhArticle dyhArticle = this.replyArticle;
        int hashCode42 = (hashCode41 ^ (dyhArticle == null ? 0 : dyhArticle.hashCode())) * 1000003;
        SimpleInfo simpleInfo = this.innerInfo;
        if (simpleInfo != null) {
            i = simpleInfo.hashCode();
        }
        return hashCode42 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_FeedReply$Builder */
    /* compiled from: $$AutoValue_FeedReply */
    static final class Builder extends FeedReply.Builder {
        private String adminInfo;
        private Integer blockStatus;
        private String blockStatusText;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private String displayUserName;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private String extraFlag;
        private String extraPic;
        private String extraTitle;
        private String extraType;
        private String extraUrl;
        private String feedId;
        private String fetchType;
        private Integer ftype;
        private String id;
        private String infoHtml;
        private SimpleInfo innerInfo;
        private Integer isFeedAuthor;
        private Integer isFolded;
        private Long lastUpdate;
        private String likeAvatar;
        private Integer likeNum;
        private Long likeTime;
        private String likeUid;
        private UserInfo likeUserInfo;
        private String likeUserName;
        private String logo;
        private String message;
        private String messageSource;
        private Integer messageStatus;
        private String messageStatusText;
        private String parentReplyId;
        private String pic;
        private DyhArticle replyArticle;
        private FeedReply.ReplyFeed replyFeed;
        private Integer replyId;
        private Integer replyNum;
        private List<FeedReply> replyRows;
        private Integer replyRowsCount;
        private Integer replyRowsMore;
        private String replyUid;
        private String replyUserAvatar;
        private String replyUserName;
        private String spamContent;
        private String spamReason;
        private Long spamTime;
        private Integer status;
        private String statusText;
        private String subTitle;
        private String title;
        private String uid;
        private String url;
        private FeedReply.ReplyUserAction userAction;
        private String userAgent;
        private UserInfo userInfo;

        Builder() {
        }

        Builder(FeedReply feedReply) {
            this.entityTypeName = feedReply.getEntityTypeName();
            this.entityTemplate = feedReply.getEntityTemplate();
            this.entityId = feedReply.getEntityId();
            this.entityFixed = feedReply.getEntityFixed();
            this.title = feedReply.getTitle();
            this.description = feedReply.getDescription();
            this.logo = feedReply.getLogo();
            this.subTitle = feedReply.getSubTitle();
            this.extraData = feedReply.getExtraData();
            this.dateline = feedReply.getDateline();
            this.lastUpdate = feedReply.getLastUpdate();
            this.deprecatedUserAvatar = feedReply.getDeprecatedUserAvatar();
            this.displayUserName = feedReply.getDisplayUserName();
            this.id = feedReply.getId();
            this.feedId = feedReply.getFeedId();
            this.uid = feedReply.getUid();
            this.deprecatedUserName = feedReply.getDeprecatedUserName();
            this.userInfo = feedReply.getUserInfo();
            this.ftype = Integer.valueOf(feedReply.getFtype());
            this.replyId = Integer.valueOf(feedReply.getReplyId());
            this.replyUserName = feedReply.getReplyUserName();
            this.replyUserAvatar = feedReply.getReplyUserAvatar();
            this.replyUid = feedReply.getReplyUid();
            this.message = feedReply.getMessage();
            this.replyNum = Integer.valueOf(feedReply.getReplyNum());
            this.isFeedAuthor = Integer.valueOf(feedReply.getIsFeedAuthor());
            this.pic = feedReply.getPic();
            this.messageSource = feedReply.getMessageSource();
            this.userAgent = feedReply.getUserAgent();
            this.url = feedReply.getUrl();
            this.fetchType = feedReply.getFetchType();
            this.replyRows = feedReply.getReplyRows();
            this.replyRowsCount = Integer.valueOf(feedReply.getReplyRowsCount());
            this.replyRowsMore = Integer.valueOf(feedReply.getReplyRowsMore());
            this.parentReplyId = feedReply.getParentReplyId();
            this.spamReason = feedReply.getSpamReason();
            this.spamContent = feedReply.getSpamContent();
            this.likeUserInfo = feedReply.getLikeUserInfo();
            this.likeNum = Integer.valueOf(feedReply.getLikeNum());
            this.infoHtml = feedReply.getInfoHtml();
            this.isFolded = Integer.valueOf(feedReply.getIsFolded());
            this.blockStatus = Integer.valueOf(feedReply.getBlockStatus());
            this.status = Integer.valueOf(feedReply.getStatus());
            this.messageStatus = Integer.valueOf(feedReply.getMessageStatus());
            this.statusText = feedReply.getStatusText();
            this.messageStatusText = feedReply.getMessageStatusText();
            this.blockStatusText = feedReply.getBlockStatusText();
            this.extraTitle = feedReply.getExtraTitle();
            this.extraType = feedReply.getExtraType();
            this.extraPic = feedReply.getExtraPic();
            this.extraUrl = feedReply.getExtraUrl();
            this.userAction = feedReply.getUserAction();
            this.spamTime = Long.valueOf(feedReply.getSpamTime());
            this.likeUserName = feedReply.getLikeUserName();
            this.likeUid = feedReply.getLikeUid();
            this.likeTime = Long.valueOf(feedReply.getLikeTime());
            this.adminInfo = feedReply.getAdminInfo();
            this.likeAvatar = feedReply.getLikeAvatar();
            this.extraFlag = feedReply.getExtraFlag();
            this.replyFeed = feedReply.getReplyFeed();
            this.replyArticle = feedReply.getReplyArticle();
            this.innerInfo = feedReply.getInnerInfo();
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setDateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setLastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public FeedReply.Builder setDeprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public FeedReply.Builder setDisplayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setFeedId(String str) {
            this.feedId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder, com.coolapk.market.model.IUser.BuilderM1
        public FeedReply.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder, com.coolapk.market.model.IUser.BuilderM1
        public FeedReply.Builder setDeprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder, com.coolapk.market.model.IUser.BuilderM1
        public FeedReply.Builder setUserInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setFtype(int i) {
            this.ftype = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyId(int i) {
            this.replyId = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyUserName(String str) {
            this.replyUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyUserAvatar(String str) {
            this.replyUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyUid(String str) {
            this.replyUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyNum(int i) {
            this.replyNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setIsFeedAuthor(int i) {
            this.isFeedAuthor = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setMessageSource(String str) {
            this.messageSource = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setFetchType(String str) {
            this.fetchType = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyRows(List<FeedReply> list) {
            this.replyRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyRowsCount(int i) {
            this.replyRowsCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyRowsMore(int i) {
            this.replyRowsMore = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setParentReplyId(String str) {
            this.parentReplyId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setSpamReason(String str) {
            this.spamReason = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setSpamContent(String str) {
            this.spamContent = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setLikeUserInfo(UserInfo userInfo2) {
            this.likeUserInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setLikeNum(int i) {
            this.likeNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setInfoHtml(String str) {
            this.infoHtml = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setIsFolded(int i) {
            this.isFolded = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setBlockStatus(int i) {
            this.blockStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setStatus(int i) {
            this.status = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setMessageStatus(int i) {
            this.messageStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setStatusText(String str) {
            this.statusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setMessageStatusText(String str) {
            this.messageStatusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setBlockStatusText(String str) {
            this.blockStatusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setExtraTitle(String str) {
            this.extraTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setExtraType(String str) {
            this.extraType = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setExtraPic(String str) {
            this.extraPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setExtraUrl(String str) {
            this.extraUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setUserAction(FeedReply.ReplyUserAction replyUserAction) {
            this.userAction = replyUserAction;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setSpamTime(long j) {
            this.spamTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setLikeUserName(String str) {
            this.likeUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setLikeUid(String str) {
            this.likeUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setLikeTime(long j) {
            this.likeTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setAdminInfo(String str) {
            this.adminInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setLikeAvatar(String str) {
            this.likeAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setExtraFlag(String str) {
            this.extraFlag = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyFeed(FeedReply.ReplyFeed replyFeed2) {
            this.replyFeed = replyFeed2;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setReplyArticle(DyhArticle dyhArticle) {
            this.replyArticle = dyhArticle;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply.Builder setInnerInfo(SimpleInfo simpleInfo) {
            this.innerInfo = simpleInfo;
            return this;
        }

        @Override // com.coolapk.market.model.FeedReply.Builder
        public FeedReply build() {
            String str = "";
            if (this.id == null) {
                str = str + " id";
            }
            if (this.feedId == null) {
                str = str + " feedId";
            }
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.deprecatedUserName == null) {
                str = str + " deprecatedUserName";
            }
            if (this.ftype == null) {
                str = str + " ftype";
            }
            if (this.replyId == null) {
                str = str + " replyId";
            }
            if (this.message == null) {
                str = str + " message";
            }
            if (this.replyNum == null) {
                str = str + " replyNum";
            }
            if (this.isFeedAuthor == null) {
                str = str + " isFeedAuthor";
            }
            if (this.replyRows == null) {
                str = str + " replyRows";
            }
            if (this.replyRowsCount == null) {
                str = str + " replyRowsCount";
            }
            if (this.replyRowsMore == null) {
                str = str + " replyRowsMore";
            }
            if (this.likeNum == null) {
                str = str + " likeNum";
            }
            if (this.isFolded == null) {
                str = str + " isFolded";
            }
            if (this.blockStatus == null) {
                str = str + " blockStatus";
            }
            if (this.status == null) {
                str = str + " status";
            }
            if (this.messageStatus == null) {
                str = str + " messageStatus";
            }
            if (this.spamTime == null) {
                str = str + " spamTime";
            }
            if (this.likeTime == null) {
                str = str + " likeTime";
            }
            if (str.isEmpty()) {
                return new AutoValue_FeedReply(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.description, this.logo, this.subTitle, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.displayUserName, this.id, this.feedId, this.uid, this.deprecatedUserName, this.userInfo, this.ftype.intValue(), this.replyId.intValue(), this.replyUserName, this.replyUserAvatar, this.replyUid, this.message, this.replyNum.intValue(), this.isFeedAuthor.intValue(), this.pic, this.messageSource, this.userAgent, this.url, this.fetchType, this.replyRows, this.replyRowsCount.intValue(), this.replyRowsMore.intValue(), this.parentReplyId, this.spamReason, this.spamContent, this.likeUserInfo, this.likeNum.intValue(), this.infoHtml, this.isFolded.intValue(), this.blockStatus.intValue(), this.status.intValue(), this.messageStatus.intValue(), this.statusText, this.messageStatusText, this.blockStatusText, this.extraTitle, this.extraType, this.extraPic, this.extraUrl, this.userAction, this.spamTime.longValue(), this.likeUserName, this.likeUid, this.likeTime.longValue(), this.adminInfo, this.likeAvatar, this.extraFlag, this.replyFeed, this.replyArticle, this.innerInfo);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
