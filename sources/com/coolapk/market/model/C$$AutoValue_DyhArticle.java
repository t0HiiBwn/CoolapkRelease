package com.coolapk.market.model;

import com.coolapk.market.model.DyhArticle;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_DyhArticle  reason: invalid class name */
abstract class C$$AutoValue_DyhArticle extends DyhArticle {
    private final String adminInfo;
    private final String author;
    private final int blockStatus;
    private final String blockStatusText;
    private final Collection collectionInfo;
    private final CollectionItem collectionItem;
    private final int commentNum;
    private final String content;
    private final Long creatDate;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String displayUserName;
    private final String dyhId;
    private final DyhModel dyhModel;
    private final String dyhName;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final int favNum;
    private final String feedId;
    private final int forwardNum;
    private final String fromInfo;
    private final String id;
    private final int isHeadline;
    private final int isHeadlineV8;
    private final int isHtmlArticle;
    private final int isStickTop;
    private final String keywords;
    private final Long lastUpdate;
    private final int likeNum;
    private final String logo;
    private final String message;
    private final int messageStatus;
    private final String messageStatusText;
    private final String pic;
    private final List<String> picArr;
    private final String rawUrl;
    private final int recommend;
    private final String redirectUrl;
    private final List<FeedReply> replyMeRows;
    private final int replyNum;
    private final int shareNum;
    private final int status;
    private final String statusText;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final String urlMD5;
    private final UserAction userAction;
    private final UserInfo userInfo;
    private final String videoUrl;

    C$$AutoValue_DyhArticle(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, Long l2, Long l3, String str8, UserInfo userInfo2, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i2, String str18, String str19, String str20, int i3, String str21, String str22, String str23, String str24, int i4, String str25, List<String> list, String str26, String str27, int i5, int i6, int i7, int i8, int i9, int i10, int i11, DyhModel dyhModel2, List<FeedReply> list2, int i12, String str28, String str29, String str30, int i13, String str31, String str32, int i14, UserAction userAction2, int i15, Long l4, Collection collection, CollectionItem collectionItem2) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityTypeId = i;
        this.entityId = str4;
        this.entityFixed = num;
        this.logo = str5;
        this.subTitle = str6;
        this.extraData = str7;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.deprecatedUserAvatar = str8;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str9;
        this.displayUserName = str10;
        Objects.requireNonNull(str11, "Null id");
        this.id = str11;
        this.dyhId = str12;
        this.dyhName = str13;
        this.feedId = str14;
        this.uid = str15;
        this.author = str16;
        this.title = str17;
        this.forwardNum = i2;
        this.keywords = str18;
        this.message = str19;
        this.description = str20;
        this.shareNum = i3;
        this.url = str21;
        this.urlMD5 = str22;
        this.videoUrl = str23;
        this.redirectUrl = str24;
        this.isStickTop = i4;
        this.rawUrl = str25;
        this.picArr = list;
        this.pic = str26;
        this.content = str27;
        this.isHtmlArticle = i5;
        this.commentNum = i6;
        this.replyNum = i7;
        this.likeNum = i8;
        this.favNum = i9;
        this.blockStatus = i10;
        this.recommend = i11;
        this.dyhModel = dyhModel2;
        Objects.requireNonNull(list2, "Null replyMeRows");
        this.replyMeRows = list2;
        this.isHeadline = i12;
        this.adminInfo = str28;
        this.statusText = str29;
        this.messageStatusText = str30;
        this.messageStatus = i13;
        this.blockStatusText = str31;
        this.fromInfo = str32;
        this.isHeadlineV8 = i14;
        this.userAction = userAction2;
        this.status = i15;
        this.creatDate = l4;
        this.collectionInfo = collection;
        this.collectionItem = collectionItem2;
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
    public int getEntityTypeId() {
        return this.entityTypeId;
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
    public UserInfo getUserInfo() {
        return this.userInfo;
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

    @Override // com.coolapk.market.model.DyhArticle, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("dyh_id")
    public String getDyhId() {
        return this.dyhId;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("dyh_name")
    public String getDyhName() {
        return this.dyhName;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("feed_id")
    public String getFeedId() {
        return this.feedId;
    }

    @Override // com.coolapk.market.model.DyhArticle, com.coolapk.market.model.IUser
    @SerializedName("uid")
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("author")
    public String getAuthor() {
        return this.author;
    }

    @Override // com.coolapk.market.model.DyhArticle, com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("forwardnum")
    public int getForwardNum() {
        return this.forwardNum;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("keywords")
    public String getKeywords() {
        return this.keywords;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("message")
    public String getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.DyhArticle, com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("share_num")
    public int getShareNum() {
        return this.shareNum;
    }

    @Override // com.coolapk.market.model.DyhArticle, com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("url_md5")
    public String getUrlMD5() {
        return this.urlMD5;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("video_url")
    public String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("redirectUrl")
    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("isStickTop")
    public int getIsStickTop() {
        return this.isStickTop;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("rawUrl")
    public String getRawUrl() {
        return this.rawUrl;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("picArr")
    public List<String> getPicArr() {
        return this.picArr;
    }

    @Override // com.coolapk.market.model.DyhArticle, com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("content")
    public String getContent() {
        return this.content;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("is_html_article")
    public int getIsHtmlArticle() {
        return this.isHtmlArticle;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("commentnum")
    public int getCommentNum() {
        return this.commentNum;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("replynum")
    public int getReplyNum() {
        return this.replyNum;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("likenum")
    public int getLikeNum() {
        return this.likeNum;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("favnum")
    public int getFavNum() {
        return this.favNum;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("block_status")
    public int getBlockStatus() {
        return this.blockStatus;
    }

    @Override // com.coolapk.market.model.DyhArticle
    public int getRecommend() {
        return this.recommend;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("dyh_info")
    public DyhModel getDyhModel() {
        return this.dyhModel;
    }

    @Override // com.coolapk.market.model.DyhArticle
    public List<FeedReply> getReplyMeRows() {
        return this.replyMeRows;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("isHeadline")
    public int getIsHeadline() {
        return this.isHeadline;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("adminInfo")
    public String getAdminInfo() {
        return this.adminInfo;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("statusText")
    public String getStatusText() {
        return this.statusText;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("messageStatusText")
    public String getMessageStatusText() {
        return this.messageStatusText;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("message_status")
    public int getMessageStatus() {
        return this.messageStatus;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("blockStatusText")
    public String getBlockStatusText() {
        return this.blockStatusText;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("fromInfo")
    public String getFromInfo() {
        return this.fromInfo;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("isHeadlineV8")
    public int getIsHeadlineV8() {
        return this.isHeadlineV8;
    }

    @Override // com.coolapk.market.model.DyhArticle
    public UserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("status")
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("createdate")
    public Long getCreatDate() {
        return this.creatDate;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("collection_info")
    public Collection getCollectionInfo() {
        return this.collectionInfo;
    }

    @Override // com.coolapk.market.model.DyhArticle
    @SerializedName("collection_item_info")
    public CollectionItem getCollectionItem() {
        return this.collectionItem;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DyhArticle{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", id=" + this.id + ", dyhId=" + this.dyhId + ", dyhName=" + this.dyhName + ", feedId=" + this.feedId + ", uid=" + this.uid + ", author=" + this.author + ", title=" + this.title + ", forwardNum=" + this.forwardNum + ", keywords=" + this.keywords + ", message=" + this.message + ", description=" + this.description + ", shareNum=" + this.shareNum + ", url=" + this.url + ", urlMD5=" + this.urlMD5 + ", videoUrl=" + this.videoUrl + ", redirectUrl=" + this.redirectUrl + ", isStickTop=" + this.isStickTop + ", rawUrl=" + this.rawUrl + ", picArr=" + this.picArr + ", pic=" + this.pic + ", content=" + this.content + ", isHtmlArticle=" + this.isHtmlArticle + ", commentNum=" + this.commentNum + ", replyNum=" + this.replyNum + ", likeNum=" + this.likeNum + ", favNum=" + this.favNum + ", blockStatus=" + this.blockStatus + ", recommend=" + this.recommend + ", dyhModel=" + this.dyhModel + ", replyMeRows=" + this.replyMeRows + ", isHeadline=" + this.isHeadline + ", adminInfo=" + this.adminInfo + ", statusText=" + this.statusText + ", messageStatusText=" + this.messageStatusText + ", messageStatus=" + this.messageStatus + ", blockStatusText=" + this.blockStatusText + ", fromInfo=" + this.fromInfo + ", isHeadlineV8=" + this.isHeadlineV8 + ", userAction=" + this.userAction + ", status=" + this.status + ", creatDate=" + this.creatDate + ", collectionInfo=" + this.collectionInfo + ", collectionItem=" + this.collectionItem + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        String str5;
        Long l2;
        Long l3;
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
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        List<String> list;
        String str23;
        String str24;
        DyhModel dyhModel2;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        UserAction userAction2;
        Long l4;
        Collection collection;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DyhArticle)) {
            return false;
        }
        DyhArticle dyhArticle = (DyhArticle) obj;
        String str30 = this.entityTypeName;
        if (str30 != null ? str30.equals(dyhArticle.getEntityTypeName()) : dyhArticle.getEntityTypeName() == null) {
            if (this.entityType.equals(dyhArticle.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(dyhArticle.getEntityTemplate()) : dyhArticle.getEntityTemplate() == null) && this.entityTypeId == dyhArticle.getEntityTypeId() && ((str2 = this.entityId) != null ? str2.equals(dyhArticle.getEntityId()) : dyhArticle.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(dyhArticle.getEntityFixed()) : dyhArticle.getEntityFixed() == null) && ((str3 = this.logo) != null ? str3.equals(dyhArticle.getLogo()) : dyhArticle.getLogo() == null) && ((str4 = this.subTitle) != null ? str4.equals(dyhArticle.getSubTitle()) : dyhArticle.getSubTitle() == null) && ((str5 = this.extraData) != null ? str5.equals(dyhArticle.getExtraData()) : dyhArticle.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(dyhArticle.getDateline()) : dyhArticle.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(dyhArticle.getLastUpdate()) : dyhArticle.getLastUpdate() == null) && ((str6 = this.deprecatedUserAvatar) != null ? str6.equals(dyhArticle.getDeprecatedUserAvatar()) : dyhArticle.getDeprecatedUserAvatar() == null) && ((userInfo2 = this.userInfo) != null ? userInfo2.equals(dyhArticle.getUserInfo()) : dyhArticle.getUserInfo() == null) && ((str7 = this.deprecatedUserName) != null ? str7.equals(dyhArticle.getDeprecatedUserName()) : dyhArticle.getDeprecatedUserName() == null) && ((str8 = this.displayUserName) != null ? str8.equals(dyhArticle.getDisplayUserName()) : dyhArticle.getDisplayUserName() == null) && this.id.equals(dyhArticle.getId()) && ((str9 = this.dyhId) != null ? str9.equals(dyhArticle.getDyhId()) : dyhArticle.getDyhId() == null) && ((str10 = this.dyhName) != null ? str10.equals(dyhArticle.getDyhName()) : dyhArticle.getDyhName() == null) && ((str11 = this.feedId) != null ? str11.equals(dyhArticle.getFeedId()) : dyhArticle.getFeedId() == null) && ((str12 = this.uid) != null ? str12.equals(dyhArticle.getUid()) : dyhArticle.getUid() == null) && ((str13 = this.author) != null ? str13.equals(dyhArticle.getAuthor()) : dyhArticle.getAuthor() == null) && ((str14 = this.title) != null ? str14.equals(dyhArticle.getTitle()) : dyhArticle.getTitle() == null) && this.forwardNum == dyhArticle.getForwardNum() && ((str15 = this.keywords) != null ? str15.equals(dyhArticle.getKeywords()) : dyhArticle.getKeywords() == null) && ((str16 = this.message) != null ? str16.equals(dyhArticle.getMessage()) : dyhArticle.getMessage() == null) && ((str17 = this.description) != null ? str17.equals(dyhArticle.getDescription()) : dyhArticle.getDescription() == null) && this.shareNum == dyhArticle.getShareNum() && ((str18 = this.url) != null ? str18.equals(dyhArticle.getUrl()) : dyhArticle.getUrl() == null) && ((str19 = this.urlMD5) != null ? str19.equals(dyhArticle.getUrlMD5()) : dyhArticle.getUrlMD5() == null) && ((str20 = this.videoUrl) != null ? str20.equals(dyhArticle.getVideoUrl()) : dyhArticle.getVideoUrl() == null) && ((str21 = this.redirectUrl) != null ? str21.equals(dyhArticle.getRedirectUrl()) : dyhArticle.getRedirectUrl() == null) && this.isStickTop == dyhArticle.getIsStickTop() && ((str22 = this.rawUrl) != null ? str22.equals(dyhArticle.getRawUrl()) : dyhArticle.getRawUrl() == null) && ((list = this.picArr) != null ? list.equals(dyhArticle.getPicArr()) : dyhArticle.getPicArr() == null) && ((str23 = this.pic) != null ? str23.equals(dyhArticle.getPic()) : dyhArticle.getPic() == null) && ((str24 = this.content) != null ? str24.equals(dyhArticle.getContent()) : dyhArticle.getContent() == null) && this.isHtmlArticle == dyhArticle.getIsHtmlArticle() && this.commentNum == dyhArticle.getCommentNum() && this.replyNum == dyhArticle.getReplyNum() && this.likeNum == dyhArticle.getLikeNum() && this.favNum == dyhArticle.getFavNum() && this.blockStatus == dyhArticle.getBlockStatus() && this.recommend == dyhArticle.getRecommend() && ((dyhModel2 = this.dyhModel) != null ? dyhModel2.equals(dyhArticle.getDyhModel()) : dyhArticle.getDyhModel() == null) && this.replyMeRows.equals(dyhArticle.getReplyMeRows()) && this.isHeadline == dyhArticle.getIsHeadline() && ((str25 = this.adminInfo) != null ? str25.equals(dyhArticle.getAdminInfo()) : dyhArticle.getAdminInfo() == null) && ((str26 = this.statusText) != null ? str26.equals(dyhArticle.getStatusText()) : dyhArticle.getStatusText() == null) && ((str27 = this.messageStatusText) != null ? str27.equals(dyhArticle.getMessageStatusText()) : dyhArticle.getMessageStatusText() == null) && this.messageStatus == dyhArticle.getMessageStatus() && ((str28 = this.blockStatusText) != null ? str28.equals(dyhArticle.getBlockStatusText()) : dyhArticle.getBlockStatusText() == null) && ((str29 = this.fromInfo) != null ? str29.equals(dyhArticle.getFromInfo()) : dyhArticle.getFromInfo() == null) && this.isHeadlineV8 == dyhArticle.getIsHeadlineV8() && ((userAction2 = this.userAction) != null ? userAction2.equals(dyhArticle.getUserAction()) : dyhArticle.getUserAction() == null) && this.status == dyhArticle.getStatus() && ((l4 = this.creatDate) != null ? l4.equals(dyhArticle.getCreatDate()) : dyhArticle.getCreatDate() == null) && ((collection = this.collectionInfo) != null ? collection.equals(dyhArticle.getCollectionInfo()) : dyhArticle.getCollectionInfo() == null)) {
                CollectionItem collectionItem2 = this.collectionItem;
                if (collectionItem2 == null) {
                    if (dyhArticle.getCollectionItem() == null) {
                        return true;
                    }
                } else if (collectionItem2.equals(dyhArticle.getCollectionItem())) {
                    return true;
                }
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
        int hashCode2 = (((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.entityTypeId) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.logo;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.subTitle;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.extraData;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode8 = (hashCode7 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode9 = (hashCode8 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str7 = this.deprecatedUserAvatar;
        int hashCode10 = (hashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode11 = (hashCode10 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str8 = this.deprecatedUserName;
        int hashCode12 = (hashCode11 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.displayUserName;
        int hashCode13 = (((hashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003;
        String str10 = this.dyhId;
        int hashCode14 = (hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.dyhName;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.feedId;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.uid;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.author;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.title;
        int hashCode19 = (((hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.forwardNum) * 1000003;
        String str16 = this.keywords;
        int hashCode20 = (hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.message;
        int hashCode21 = (hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.description;
        int hashCode22 = (((hashCode21 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003) ^ this.shareNum) * 1000003;
        String str19 = this.url;
        int hashCode23 = (hashCode22 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        String str20 = this.urlMD5;
        int hashCode24 = (hashCode23 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        String str21 = this.videoUrl;
        int hashCode25 = (hashCode24 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003;
        String str22 = this.redirectUrl;
        int hashCode26 = (((hashCode25 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003) ^ this.isStickTop) * 1000003;
        String str23 = this.rawUrl;
        int hashCode27 = (hashCode26 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
        List<String> list = this.picArr;
        int hashCode28 = (hashCode27 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        String str24 = this.pic;
        int hashCode29 = (hashCode28 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
        String str25 = this.content;
        int hashCode30 = (((((((((((((((hashCode29 ^ (str25 == null ? 0 : str25.hashCode())) * 1000003) ^ this.isHtmlArticle) * 1000003) ^ this.commentNum) * 1000003) ^ this.replyNum) * 1000003) ^ this.likeNum) * 1000003) ^ this.favNum) * 1000003) ^ this.blockStatus) * 1000003) ^ this.recommend) * 1000003;
        DyhModel dyhModel2 = this.dyhModel;
        int hashCode31 = (((((hashCode30 ^ (dyhModel2 == null ? 0 : dyhModel2.hashCode())) * 1000003) ^ this.replyMeRows.hashCode()) * 1000003) ^ this.isHeadline) * 1000003;
        String str26 = this.adminInfo;
        int hashCode32 = (hashCode31 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003;
        String str27 = this.statusText;
        int hashCode33 = (hashCode32 ^ (str27 == null ? 0 : str27.hashCode())) * 1000003;
        String str28 = this.messageStatusText;
        int hashCode34 = (((hashCode33 ^ (str28 == null ? 0 : str28.hashCode())) * 1000003) ^ this.messageStatus) * 1000003;
        String str29 = this.blockStatusText;
        int hashCode35 = (hashCode34 ^ (str29 == null ? 0 : str29.hashCode())) * 1000003;
        String str30 = this.fromInfo;
        int hashCode36 = (((hashCode35 ^ (str30 == null ? 0 : str30.hashCode())) * 1000003) ^ this.isHeadlineV8) * 1000003;
        UserAction userAction2 = this.userAction;
        int hashCode37 = (((hashCode36 ^ (userAction2 == null ? 0 : userAction2.hashCode())) * 1000003) ^ this.status) * 1000003;
        Long l4 = this.creatDate;
        int hashCode38 = (hashCode37 ^ (l4 == null ? 0 : l4.hashCode())) * 1000003;
        Collection collection = this.collectionInfo;
        int hashCode39 = (hashCode38 ^ (collection == null ? 0 : collection.hashCode())) * 1000003;
        CollectionItem collectionItem2 = this.collectionItem;
        if (collectionItem2 != null) {
            i = collectionItem2.hashCode();
        }
        return hashCode39 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_DyhArticle$Builder */
    /* compiled from: $$AutoValue_DyhArticle */
    static final class Builder extends DyhArticle.Builder {
        private String adminInfo;
        private String author;
        private Integer blockStatus;
        private String blockStatusText;
        private Collection collectionInfo;
        private CollectionItem collectionItem;
        private Integer commentNum;
        private String content;
        private Long creatDate;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private String displayUserName;
        private String dyhId;
        private DyhModel dyhModel;
        private String dyhName;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private Integer entityTypeId;
        private String entityTypeName;
        private String extraData;
        private Integer favNum;
        private String feedId;
        private Integer forwardNum;
        private String fromInfo;
        private String id;
        private Integer isHeadline;
        private Integer isHeadlineV8;
        private Integer isHtmlArticle;
        private Integer isStickTop;
        private String keywords;
        private Long lastUpdate;
        private Integer likeNum;
        private String logo;
        private String message;
        private Integer messageStatus;
        private String messageStatusText;
        private String pic;
        private List<String> picArr;
        private String rawUrl;
        private Integer recommend;
        private String redirectUrl;
        private List<FeedReply> replyMeRows;
        private Integer replyNum;
        private Integer shareNum;
        private Integer status;
        private String statusText;
        private String subTitle;
        private String title;
        private String uid;
        private String url;
        private String urlMD5;
        private UserAction userAction;
        private UserInfo userInfo;
        private String videoUrl;

        Builder() {
        }

        Builder(DyhArticle dyhArticle) {
            this.entityTypeName = dyhArticle.getEntityTypeName();
            this.entityType = dyhArticle.getEntityType();
            this.entityTemplate = dyhArticle.getEntityTemplate();
            this.entityTypeId = Integer.valueOf(dyhArticle.getEntityTypeId());
            this.entityId = dyhArticle.getEntityId();
            this.entityFixed = dyhArticle.getEntityFixed();
            this.logo = dyhArticle.getLogo();
            this.subTitle = dyhArticle.getSubTitle();
            this.extraData = dyhArticle.getExtraData();
            this.dateline = dyhArticle.getDateline();
            this.lastUpdate = dyhArticle.getLastUpdate();
            this.deprecatedUserAvatar = dyhArticle.getDeprecatedUserAvatar();
            this.userInfo = dyhArticle.getUserInfo();
            this.deprecatedUserName = dyhArticle.getDeprecatedUserName();
            this.displayUserName = dyhArticle.getDisplayUserName();
            this.id = dyhArticle.getId();
            this.dyhId = dyhArticle.getDyhId();
            this.dyhName = dyhArticle.getDyhName();
            this.feedId = dyhArticle.getFeedId();
            this.uid = dyhArticle.getUid();
            this.author = dyhArticle.getAuthor();
            this.title = dyhArticle.getTitle();
            this.forwardNum = Integer.valueOf(dyhArticle.getForwardNum());
            this.keywords = dyhArticle.getKeywords();
            this.message = dyhArticle.getMessage();
            this.description = dyhArticle.getDescription();
            this.shareNum = Integer.valueOf(dyhArticle.getShareNum());
            this.url = dyhArticle.getUrl();
            this.urlMD5 = dyhArticle.getUrlMD5();
            this.videoUrl = dyhArticle.getVideoUrl();
            this.redirectUrl = dyhArticle.getRedirectUrl();
            this.isStickTop = Integer.valueOf(dyhArticle.getIsStickTop());
            this.rawUrl = dyhArticle.getRawUrl();
            this.picArr = dyhArticle.getPicArr();
            this.pic = dyhArticle.getPic();
            this.content = dyhArticle.getContent();
            this.isHtmlArticle = Integer.valueOf(dyhArticle.getIsHtmlArticle());
            this.commentNum = Integer.valueOf(dyhArticle.getCommentNum());
            this.replyNum = Integer.valueOf(dyhArticle.getReplyNum());
            this.likeNum = Integer.valueOf(dyhArticle.getLikeNum());
            this.favNum = Integer.valueOf(dyhArticle.getFavNum());
            this.blockStatus = Integer.valueOf(dyhArticle.getBlockStatus());
            this.recommend = Integer.valueOf(dyhArticle.getRecommend());
            this.dyhModel = dyhArticle.getDyhModel();
            this.replyMeRows = dyhArticle.getReplyMeRows();
            this.isHeadline = Integer.valueOf(dyhArticle.getIsHeadline());
            this.adminInfo = dyhArticle.getAdminInfo();
            this.statusText = dyhArticle.getStatusText();
            this.messageStatusText = dyhArticle.getMessageStatusText();
            this.messageStatus = Integer.valueOf(dyhArticle.getMessageStatus());
            this.blockStatusText = dyhArticle.getBlockStatusText();
            this.fromInfo = dyhArticle.getFromInfo();
            this.isHeadlineV8 = Integer.valueOf(dyhArticle.getIsHeadlineV8());
            this.userAction = dyhArticle.getUserAction();
            this.status = Integer.valueOf(dyhArticle.getStatus());
            this.creatDate = dyhArticle.getCreatDate();
            this.collectionInfo = dyhArticle.getCollectionInfo();
            this.collectionItem = dyhArticle.getCollectionItem();
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder entityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder entityTypeId(int i) {
            this.entityTypeId = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder dateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder lastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public DyhArticle.Builder deprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public DyhArticle.Builder userInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public DyhArticle.Builder deprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public DyhArticle.Builder displayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder dyhId(String str) {
            this.dyhId = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder dyhName(String str) {
            this.dyhName = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder feedId(String str) {
            this.feedId = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder, com.coolapk.market.model.IUser.BuilderM2
        public DyhArticle.Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder author(String str) {
            this.author = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder forwardNum(int i) {
            this.forwardNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder keywords(String str) {
            this.keywords = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder message(String str) {
            this.message = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder shareNum(int i) {
            this.shareNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder urlMD5(String str) {
            this.urlMD5 = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder videoUrl(String str) {
            this.videoUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder redirectUrl(String str) {
            this.redirectUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder isStickTop(int i) {
            this.isStickTop = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder rawUrl(String str) {
            this.rawUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder picArr(List<String> list) {
            this.picArr = list;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder content(String str) {
            this.content = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder isHtmlArticle(int i) {
            this.isHtmlArticle = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder commentNum(int i) {
            this.commentNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder replyNum(int i) {
            this.replyNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder likeNum(int i) {
            this.likeNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder favNum(int i) {
            this.favNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder blockStatus(int i) {
            this.blockStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder recommend(int i) {
            this.recommend = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder dyhModel(DyhModel dyhModel2) {
            this.dyhModel = dyhModel2;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder replyMeRows(List<FeedReply> list) {
            this.replyMeRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder isHeadline(int i) {
            this.isHeadline = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder adminInfo(String str) {
            this.adminInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder statusText(String str) {
            this.statusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder messageStatusText(String str) {
            this.messageStatusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder messageStatus(int i) {
            this.messageStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder blockStatusText(String str) {
            this.blockStatusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder fromInfo(String str) {
            this.fromInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder isHeadlineV8(int i) {
            this.isHeadlineV8 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder userAction(UserAction userAction2) {
            this.userAction = userAction2;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder status(int i) {
            this.status = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder creatDate(Long l2) {
            this.creatDate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder collectionInfo(Collection collection) {
            this.collectionInfo = collection;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle.Builder collectionItem(CollectionItem collectionItem2) {
            this.collectionItem = collectionItem2;
            return this;
        }

        @Override // com.coolapk.market.model.DyhArticle.Builder
        public DyhArticle build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (this.entityTypeId == null) {
                str = str + " entityTypeId";
            }
            if (this.id == null) {
                str = str + " id";
            }
            if (this.forwardNum == null) {
                str = str + " forwardNum";
            }
            if (this.shareNum == null) {
                str = str + " shareNum";
            }
            if (this.isStickTop == null) {
                str = str + " isStickTop";
            }
            if (this.isHtmlArticle == null) {
                str = str + " isHtmlArticle";
            }
            if (this.commentNum == null) {
                str = str + " commentNum";
            }
            if (this.replyNum == null) {
                str = str + " replyNum";
            }
            if (this.likeNum == null) {
                str = str + " likeNum";
            }
            if (this.favNum == null) {
                str = str + " favNum";
            }
            if (this.blockStatus == null) {
                str = str + " blockStatus";
            }
            if (this.recommend == null) {
                str = str + " recommend";
            }
            if (this.replyMeRows == null) {
                str = str + " replyMeRows";
            }
            if (this.isHeadline == null) {
                str = str + " isHeadline";
            }
            if (this.messageStatus == null) {
                str = str + " messageStatus";
            }
            if (this.isHeadlineV8 == null) {
                str = str + " isHeadlineV8";
            }
            if (this.status == null) {
                str = str + " status";
            }
            if (str.isEmpty()) {
                return new AutoValue_DyhArticle(this.entityTypeName, this.entityType, this.entityTemplate, this.entityTypeId.intValue(), this.entityId, this.entityFixed, this.logo, this.subTitle, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.deprecatedUserName, this.displayUserName, this.id, this.dyhId, this.dyhName, this.feedId, this.uid, this.author, this.title, this.forwardNum.intValue(), this.keywords, this.message, this.description, this.shareNum.intValue(), this.url, this.urlMD5, this.videoUrl, this.redirectUrl, this.isStickTop.intValue(), this.rawUrl, this.picArr, this.pic, this.content, this.isHtmlArticle.intValue(), this.commentNum.intValue(), this.replyNum.intValue(), this.likeNum.intValue(), this.favNum.intValue(), this.blockStatus.intValue(), this.recommend.intValue(), this.dyhModel, this.replyMeRows, this.isHeadline.intValue(), this.adminInfo, this.statusText, this.messageStatusText, this.messageStatus.intValue(), this.blockStatusText, this.fromInfo, this.isHeadlineV8.intValue(), this.userAction, this.status.intValue(), this.creatDate, this.collectionInfo, this.collectionItem);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
