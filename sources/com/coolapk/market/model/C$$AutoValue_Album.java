package com.coolapk.market.model;

import com.coolapk.market.model.Album;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Album  reason: invalid class name */
abstract class C$$AutoValue_Album extends Album {
    private final List<FeedReply> albumHotReplies;
    private final List<AlbumItem> albumItems;
    private final String albumUrl;
    private final Collection collectionInfo;
    private final CollectionItem collectionItem;
    private final int commentBlockNum;
    private final int commentNum;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String deviceTitle;
    private final String displayUserName;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final int favoriteNum;
    private final String feedId;
    private final FeedStatus feedStatus;
    private final int forwardNum;
    private final String icon;
    private final String id;
    private final String info;
    private final String infoHtml;
    private final SimpleInfo innerInfo;
    private final String introduce;
    private final int isStickTop;
    private final String keyWords;
    private final Long lastUpdate;
    private final String likeAvatar;
    private final int likeNum;
    private final long likeTime;
    private final String likeUid;
    private final UserInfo likeUserInfo;
    private final String likeUserName;
    private final String logo;
    private final String moreCount;
    private final String pic;
    private final int recommend;
    private final List<FeedReply> replyMeRows;
    private final int replyNum;
    private final int shareNum;
    private final int status;
    private final String subTitle;
    private final String title;
    private final SimpleInfo topInfo;
    private final int totalApkNum;
    private final String uid;
    private final String url;
    private final UserAction userAction;
    private final UserInfo userInfo;

    C$$AutoValue_Album(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l, Long l2, String str9, UserInfo userInfo2, String str10, String str11, String str12, String str13, String str14, String str15, String str16, UserInfo userInfo3, String str17, String str18, long j, String str19, String str20, int i, String str21, int i2, int i3, int i4, int i5, int i6, int i7, String str22, int i8, String str23, int i9, String str24, int i10, String str25, String str26, List<AlbumItem> list, String str27, Collection collection, CollectionItem collectionItem2, List<FeedReply> list2, UserAction userAction2, List<FeedReply> list3, int i11, FeedStatus feedStatus2, SimpleInfo simpleInfo, SimpleInfo simpleInfo2) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.url = str4;
        this.pic = str5;
        this.subTitle = str6;
        this.id = str7;
        this.extraData = str8;
        this.dateline = l;
        this.lastUpdate = l2;
        this.deprecatedUserAvatar = str9;
        this.userInfo = userInfo2;
        Objects.requireNonNull(str10, "Null uid");
        this.uid = str10;
        this.deprecatedUserName = str11;
        this.displayUserName = str12;
        this.feedId = str13;
        this.title = str14;
        this.logo = str15;
        this.likeAvatar = str16;
        this.likeUserInfo = userInfo3;
        this.likeUserName = str17;
        this.likeUid = str18;
        this.likeTime = j;
        this.icon = str19;
        this.keyWords = str20;
        this.shareNum = i;
        this.description = str21;
        this.recommend = i2;
        this.totalApkNum = i3;
        this.favoriteNum = i4;
        this.commentNum = i5;
        this.forwardNum = i6;
        this.replyNum = i7;
        this.deviceTitle = str22;
        this.status = i8;
        this.albumUrl = str23;
        this.likeNum = i9;
        this.introduce = str24;
        this.commentBlockNum = i10;
        this.infoHtml = str25;
        this.info = str26;
        this.albumItems = list;
        this.moreCount = str27;
        this.collectionInfo = collection;
        this.collectionItem = collectionItem2;
        Objects.requireNonNull(list2, "Null albumHotReplies");
        this.albumHotReplies = list2;
        this.userAction = userAction2;
        Objects.requireNonNull(list3, "Null replyMeRows");
        this.replyMeRows = list3;
        this.isStickTop = i11;
        this.feedStatus = feedStatus2;
        this.topInfo = simpleInfo;
        this.innerInfo = simpleInfo2;
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
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
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

    @Override // com.coolapk.market.model.Album
    @SerializedName("feedid")
    public String getFeedId() {
        return this.feedId;
    }

    @Override // com.coolapk.market.model.Album, com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Album, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.Album
    public String getLikeAvatar() {
        return this.likeAvatar;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("likeUserInfo")
    public UserInfo getLikeUserInfo() {
        return this.likeUserInfo;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("likeUsername")
    public String getLikeUserName() {
        return this.likeUserName;
    }

    @Override // com.coolapk.market.model.Album
    public String getLikeUid() {
        return this.likeUid;
    }

    @Override // com.coolapk.market.model.Album
    public long getLikeTime() {
        return this.likeTime;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("icon")
    public String getIcon() {
        return this.icon;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("keywords")
    public String getKeyWords() {
        return this.keyWords;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("share_num")
    public int getShareNum() {
        return this.shareNum;
    }

    @Override // com.coolapk.market.model.Album, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Album
    public int getRecommend() {
        return this.recommend;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("apknum")
    public int getTotalApkNum() {
        return this.totalApkNum;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("favnum")
    public int getFavoriteNum() {
        return this.favoriteNum;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("commentnum")
    public int getCommentNum() {
        return this.commentNum;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("forwardnum")
    public int getForwardNum() {
        return this.forwardNum;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("replynum")
    public int getReplyNum() {
        return this.replyNum;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("device_title")
    public String getDeviceTitle() {
        return this.deviceTitle;
    }

    @Override // com.coolapk.market.model.Album
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.Album
    public String getAlbumUrl() {
        return this.albumUrl;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("likenum")
    public int getLikeNum() {
        return this.likeNum;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("intro")
    public String getIntroduce() {
        return this.introduce;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("comment_block_num")
    public int getCommentBlockNum() {
        return this.commentBlockNum;
    }

    @Override // com.coolapk.market.model.Album
    public String getInfoHtml() {
        return this.infoHtml;
    }

    @Override // com.coolapk.market.model.Album
    public String getInfo() {
        return this.info;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("apkRows")
    public List<AlbumItem> getAlbumItems() {
        return this.albumItems;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("apkRowsMoreCount")
    public String getMoreCount() {
        return this.moreCount;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("collection_info")
    public Collection getCollectionInfo() {
        return this.collectionInfo;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("collection_item_info")
    public CollectionItem getCollectionItem() {
        return this.collectionItem;
    }

    @Override // com.coolapk.market.model.Album
    public List<FeedReply> getAlbumHotReplies() {
        return this.albumHotReplies;
    }

    @Override // com.coolapk.market.model.Album
    public UserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.Album
    public List<FeedReply> getReplyMeRows() {
        return this.replyMeRows;
    }

    @Override // com.coolapk.market.model.Album
    @SerializedName("isStickTop")
    public int getIsStickTop() {
        return this.isStickTop;
    }

    @Override // com.coolapk.market.model.Album
    public FeedStatus getFeedStatus() {
        return this.feedStatus;
    }

    @Override // com.coolapk.market.model.Album
    public SimpleInfo getTopInfo() {
        return this.topInfo;
    }

    @Override // com.coolapk.market.model.Album
    public SimpleInfo getInnerInfo() {
        return this.innerInfo;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Album{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", uid=" + this.uid + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", feedId=" + this.feedId + ", title=" + this.title + ", logo=" + this.logo + ", likeAvatar=" + this.likeAvatar + ", likeUserInfo=" + this.likeUserInfo + ", likeUserName=" + this.likeUserName + ", likeUid=" + this.likeUid + ", likeTime=" + this.likeTime + ", icon=" + this.icon + ", keyWords=" + this.keyWords + ", shareNum=" + this.shareNum + ", description=" + this.description + ", recommend=" + this.recommend + ", totalApkNum=" + this.totalApkNum + ", favoriteNum=" + this.favoriteNum + ", commentNum=" + this.commentNum + ", forwardNum=" + this.forwardNum + ", replyNum=" + this.replyNum + ", deviceTitle=" + this.deviceTitle + ", status=" + this.status + ", albumUrl=" + this.albumUrl + ", likeNum=" + this.likeNum + ", introduce=" + this.introduce + ", commentBlockNum=" + this.commentBlockNum + ", infoHtml=" + this.infoHtml + ", info=" + this.info + ", albumItems=" + this.albumItems + ", moreCount=" + this.moreCount + ", collectionInfo=" + this.collectionInfo + ", collectionItem=" + this.collectionItem + ", albumHotReplies=" + this.albumHotReplies + ", userAction=" + this.userAction + ", replyMeRows=" + this.replyMeRows + ", isStickTop=" + this.isStickTop + ", feedStatus=" + this.feedStatus + ", topInfo=" + this.topInfo + ", innerInfo=" + this.innerInfo + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
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
        List<AlbumItem> list;
        String str17;
        Collection collection;
        CollectionItem collectionItem2;
        UserAction userAction2;
        FeedStatus feedStatus2;
        SimpleInfo simpleInfo;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Album)) {
            return false;
        }
        Album album = (Album) obj;
        String str18 = this.entityTypeName;
        if (str18 != null ? str18.equals(album.getEntityTypeName()) : album.getEntityTypeName() == null) {
            String str19 = this.entityTemplate;
            if (str19 != null ? str19.equals(album.getEntityTemplate()) : album.getEntityTemplate() == null) {
                String str20 = this.entityId;
                if (str20 != null ? str20.equals(album.getEntityId()) : album.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(album.getEntityFixed()) : album.getEntityFixed() == null) {
                        String str21 = this.url;
                        if (str21 != null ? str21.equals(album.getUrl()) : album.getUrl() == null) {
                            String str22 = this.pic;
                            if (str22 != null ? str22.equals(album.getPic()) : album.getPic() == null) {
                                String str23 = this.subTitle;
                                if (str23 != null ? str23.equals(album.getSubTitle()) : album.getSubTitle() == null) {
                                    String str24 = this.id;
                                    if (str24 != null ? str24.equals(album.getId()) : album.getId() == null) {
                                        String str25 = this.extraData;
                                        if (str25 != null ? str25.equals(album.getExtraData()) : album.getExtraData() == null) {
                                            Long l = this.dateline;
                                            if (l != null ? l.equals(album.getDateline()) : album.getDateline() == null) {
                                                Long l2 = this.lastUpdate;
                                                if (l2 != null ? l2.equals(album.getLastUpdate()) : album.getLastUpdate() == null) {
                                                    String str26 = this.deprecatedUserAvatar;
                                                    if (str26 != null ? str26.equals(album.getDeprecatedUserAvatar()) : album.getDeprecatedUserAvatar() == null) {
                                                        UserInfo userInfo3 = this.userInfo;
                                                        if (userInfo3 != null ? userInfo3.equals(album.getUserInfo()) : album.getUserInfo() == null) {
                                                            if (this.uid.equals(album.getUid()) && ((str = this.deprecatedUserName) != null ? str.equals(album.getDeprecatedUserName()) : album.getDeprecatedUserName() == null) && ((str2 = this.displayUserName) != null ? str2.equals(album.getDisplayUserName()) : album.getDisplayUserName() == null) && ((str3 = this.feedId) != null ? str3.equals(album.getFeedId()) : album.getFeedId() == null) && ((str4 = this.title) != null ? str4.equals(album.getTitle()) : album.getTitle() == null) && ((str5 = this.logo) != null ? str5.equals(album.getLogo()) : album.getLogo() == null) && ((str6 = this.likeAvatar) != null ? str6.equals(album.getLikeAvatar()) : album.getLikeAvatar() == null) && ((userInfo2 = this.likeUserInfo) != null ? userInfo2.equals(album.getLikeUserInfo()) : album.getLikeUserInfo() == null) && ((str7 = this.likeUserName) != null ? str7.equals(album.getLikeUserName()) : album.getLikeUserName() == null) && ((str8 = this.likeUid) != null ? str8.equals(album.getLikeUid()) : album.getLikeUid() == null) && this.likeTime == album.getLikeTime() && ((str9 = this.icon) != null ? str9.equals(album.getIcon()) : album.getIcon() == null) && ((str10 = this.keyWords) != null ? str10.equals(album.getKeyWords()) : album.getKeyWords() == null) && this.shareNum == album.getShareNum() && ((str11 = this.description) != null ? str11.equals(album.getDescription()) : album.getDescription() == null) && this.recommend == album.getRecommend() && this.totalApkNum == album.getTotalApkNum() && this.favoriteNum == album.getFavoriteNum() && this.commentNum == album.getCommentNum() && this.forwardNum == album.getForwardNum() && this.replyNum == album.getReplyNum() && ((str12 = this.deviceTitle) != null ? str12.equals(album.getDeviceTitle()) : album.getDeviceTitle() == null) && this.status == album.getStatus() && ((str13 = this.albumUrl) != null ? str13.equals(album.getAlbumUrl()) : album.getAlbumUrl() == null) && this.likeNum == album.getLikeNum() && ((str14 = this.introduce) != null ? str14.equals(album.getIntroduce()) : album.getIntroduce() == null) && this.commentBlockNum == album.getCommentBlockNum() && ((str15 = this.infoHtml) != null ? str15.equals(album.getInfoHtml()) : album.getInfoHtml() == null) && ((str16 = this.info) != null ? str16.equals(album.getInfo()) : album.getInfo() == null) && ((list = this.albumItems) != null ? list.equals(album.getAlbumItems()) : album.getAlbumItems() == null) && ((str17 = this.moreCount) != null ? str17.equals(album.getMoreCount()) : album.getMoreCount() == null) && ((collection = this.collectionInfo) != null ? collection.equals(album.getCollectionInfo()) : album.getCollectionInfo() == null) && ((collectionItem2 = this.collectionItem) != null ? collectionItem2.equals(album.getCollectionItem()) : album.getCollectionItem() == null) && this.albumHotReplies.equals(album.getAlbumHotReplies()) && ((userAction2 = this.userAction) != null ? userAction2.equals(album.getUserAction()) : album.getUserAction() == null) && this.replyMeRows.equals(album.getReplyMeRows()) && this.isStickTop == album.getIsStickTop() && ((feedStatus2 = this.feedStatus) != null ? feedStatus2.equals(album.getFeedStatus()) : album.getFeedStatus() == null) && ((simpleInfo = this.topInfo) != null ? simpleInfo.equals(album.getTopInfo()) : album.getTopInfo() == null)) {
                                                                SimpleInfo simpleInfo2 = this.innerInfo;
                                                                if (simpleInfo2 == null) {
                                                                    if (album.getInnerInfo() == null) {
                                                                        return true;
                                                                    }
                                                                } else if (simpleInfo2.equals(album.getInnerInfo())) {
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
        String str4 = this.url;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.pic;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.subTitle;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.id;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.extraData;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode10 = (hashCode9 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode11 = (hashCode10 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str9 = this.deprecatedUserAvatar;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode13 = (((hashCode12 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003) ^ this.uid.hashCode()) * 1000003;
        String str10 = this.deprecatedUserName;
        int hashCode14 = (hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.displayUserName;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.feedId;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.title;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.logo;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.likeAvatar;
        int hashCode19 = (hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        UserInfo userInfo3 = this.likeUserInfo;
        int hashCode20 = (hashCode19 ^ (userInfo3 == null ? 0 : userInfo3.hashCode())) * 1000003;
        String str16 = this.likeUserName;
        int hashCode21 = (hashCode20 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.likeUid;
        int hashCode22 = str17 == null ? 0 : str17.hashCode();
        long j = this.likeTime;
        int i2 = ((int) (((long) ((hashCode21 ^ hashCode22) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003;
        String str18 = this.icon;
        int hashCode23 = (i2 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.keyWords;
        int hashCode24 = (((hashCode23 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003) ^ this.shareNum) * 1000003;
        String str20 = this.description;
        int hashCode25 = (((((((((((((hashCode24 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003) ^ this.recommend) * 1000003) ^ this.totalApkNum) * 1000003) ^ this.favoriteNum) * 1000003) ^ this.commentNum) * 1000003) ^ this.forwardNum) * 1000003) ^ this.replyNum) * 1000003;
        String str21 = this.deviceTitle;
        int hashCode26 = (((hashCode25 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003) ^ this.status) * 1000003;
        String str22 = this.albumUrl;
        int hashCode27 = (((hashCode26 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003) ^ this.likeNum) * 1000003;
        String str23 = this.introduce;
        int hashCode28 = (((hashCode27 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003) ^ this.commentBlockNum) * 1000003;
        String str24 = this.infoHtml;
        int hashCode29 = (hashCode28 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
        String str25 = this.info;
        int hashCode30 = (hashCode29 ^ (str25 == null ? 0 : str25.hashCode())) * 1000003;
        List<AlbumItem> list = this.albumItems;
        int hashCode31 = (hashCode30 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        String str26 = this.moreCount;
        int hashCode32 = (hashCode31 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003;
        Collection collection = this.collectionInfo;
        int hashCode33 = (hashCode32 ^ (collection == null ? 0 : collection.hashCode())) * 1000003;
        CollectionItem collectionItem2 = this.collectionItem;
        int hashCode34 = (((hashCode33 ^ (collectionItem2 == null ? 0 : collectionItem2.hashCode())) * 1000003) ^ this.albumHotReplies.hashCode()) * 1000003;
        UserAction userAction2 = this.userAction;
        int hashCode35 = (((((hashCode34 ^ (userAction2 == null ? 0 : userAction2.hashCode())) * 1000003) ^ this.replyMeRows.hashCode()) * 1000003) ^ this.isStickTop) * 1000003;
        FeedStatus feedStatus2 = this.feedStatus;
        int hashCode36 = (hashCode35 ^ (feedStatus2 == null ? 0 : feedStatus2.hashCode())) * 1000003;
        SimpleInfo simpleInfo = this.topInfo;
        int hashCode37 = (hashCode36 ^ (simpleInfo == null ? 0 : simpleInfo.hashCode())) * 1000003;
        SimpleInfo simpleInfo2 = this.innerInfo;
        if (simpleInfo2 != null) {
            i = simpleInfo2.hashCode();
        }
        return hashCode37 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Album$Builder */
    /* compiled from: $$AutoValue_Album */
    static final class Builder extends Album.Builder {
        private List<FeedReply> albumHotReplies;
        private List<AlbumItem> albumItems;
        private String albumUrl;
        private Collection collectionInfo;
        private CollectionItem collectionItem;
        private Integer commentBlockNum;
        private Integer commentNum;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private String deviceTitle;
        private String displayUserName;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private Integer favoriteNum;
        private String feedId;
        private FeedStatus feedStatus;
        private Integer forwardNum;
        private String icon;
        private String id;
        private String info;
        private String infoHtml;
        private SimpleInfo innerInfo;
        private String introduce;
        private Integer isStickTop;
        private String keyWords;
        private Long lastUpdate;
        private String likeAvatar;
        private Integer likeNum;
        private Long likeTime;
        private String likeUid;
        private UserInfo likeUserInfo;
        private String likeUserName;
        private String logo;
        private String moreCount;
        private String pic;
        private Integer recommend;
        private List<FeedReply> replyMeRows;
        private Integer replyNum;
        private Integer shareNum;
        private Integer status;
        private String subTitle;
        private String title;
        private SimpleInfo topInfo;
        private Integer totalApkNum;
        private String uid;
        private String url;
        private UserAction userAction;
        private UserInfo userInfo;

        Builder() {
        }

        Builder(Album album) {
            this.entityTypeName = album.getEntityTypeName();
            this.entityTemplate = album.getEntityTemplate();
            this.entityId = album.getEntityId();
            this.entityFixed = album.getEntityFixed();
            this.url = album.getUrl();
            this.pic = album.getPic();
            this.subTitle = album.getSubTitle();
            this.id = album.getId();
            this.extraData = album.getExtraData();
            this.dateline = album.getDateline();
            this.lastUpdate = album.getLastUpdate();
            this.deprecatedUserAvatar = album.getDeprecatedUserAvatar();
            this.userInfo = album.getUserInfo();
            this.uid = album.getUid();
            this.deprecatedUserName = album.getDeprecatedUserName();
            this.displayUserName = album.getDisplayUserName();
            this.feedId = album.getFeedId();
            this.title = album.getTitle();
            this.logo = album.getLogo();
            this.likeAvatar = album.getLikeAvatar();
            this.likeUserInfo = album.getLikeUserInfo();
            this.likeUserName = album.getLikeUserName();
            this.likeUid = album.getLikeUid();
            this.likeTime = Long.valueOf(album.getLikeTime());
            this.icon = album.getIcon();
            this.keyWords = album.getKeyWords();
            this.shareNum = Integer.valueOf(album.getShareNum());
            this.description = album.getDescription();
            this.recommend = Integer.valueOf(album.getRecommend());
            this.totalApkNum = Integer.valueOf(album.getTotalApkNum());
            this.favoriteNum = Integer.valueOf(album.getFavoriteNum());
            this.commentNum = Integer.valueOf(album.getCommentNum());
            this.forwardNum = Integer.valueOf(album.getForwardNum());
            this.replyNum = Integer.valueOf(album.getReplyNum());
            this.deviceTitle = album.getDeviceTitle();
            this.status = Integer.valueOf(album.getStatus());
            this.albumUrl = album.getAlbumUrl();
            this.likeNum = Integer.valueOf(album.getLikeNum());
            this.introduce = album.getIntroduce();
            this.commentBlockNum = Integer.valueOf(album.getCommentBlockNum());
            this.infoHtml = album.getInfoHtml();
            this.info = album.getInfo();
            this.albumItems = album.getAlbumItems();
            this.moreCount = album.getMoreCount();
            this.collectionInfo = album.getCollectionInfo();
            this.collectionItem = album.getCollectionItem();
            this.albumHotReplies = album.getAlbumHotReplies();
            this.userAction = album.getUserAction();
            this.replyMeRows = album.getReplyMeRows();
            this.isStickTop = Integer.valueOf(album.getIsStickTop());
            this.feedStatus = album.getFeedStatus();
            this.topInfo = album.getTopInfo();
            this.innerInfo = album.getInnerInfo();
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder dateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder lastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Album.Builder deprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Album.Builder userInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Album.Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Album.Builder deprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Album.Builder displayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder feedId(String str) {
            this.feedId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder likeAvatar(String str) {
            this.likeAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder likeUserInfo(UserInfo userInfo2) {
            this.likeUserInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder likeUserName(String str) {
            this.likeUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder likeUid(String str) {
            this.likeUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder likeTime(long j) {
            this.likeTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder icon(String str) {
            this.icon = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder keyWords(String str) {
            this.keyWords = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder shareNum(int i) {
            this.shareNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder recommend(int i) {
            this.recommend = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder totalApkNum(int i) {
            this.totalApkNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder favoriteNum(int i) {
            this.favoriteNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder commentNum(int i) {
            this.commentNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder forwardNum(int i) {
            this.forwardNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder replyNum(int i) {
            this.replyNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder deviceTitle(String str) {
            this.deviceTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder status(int i) {
            this.status = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder albumUrl(String str) {
            this.albumUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder likeNum(int i) {
            this.likeNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder introduce(String str) {
            this.introduce = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder commentBlockNum(int i) {
            this.commentBlockNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder infoHtml(String str) {
            this.infoHtml = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder info(String str) {
            this.info = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder albumItems(List<AlbumItem> list) {
            this.albumItems = list;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder moreCount(String str) {
            this.moreCount = str;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder collectionInfo(Collection collection) {
            this.collectionInfo = collection;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder collectionItem(CollectionItem collectionItem2) {
            this.collectionItem = collectionItem2;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder albumHotReplies(List<FeedReply> list) {
            this.albumHotReplies = list;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder userAction(UserAction userAction2) {
            this.userAction = userAction2;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder replyMeRows(List<FeedReply> list) {
            this.replyMeRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder isStickTop(int i) {
            this.isStickTop = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder feedStatus(FeedStatus feedStatus2) {
            this.feedStatus = feedStatus2;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder topInfo(SimpleInfo simpleInfo) {
            this.topInfo = simpleInfo;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album.Builder innerInfo(SimpleInfo simpleInfo) {
            this.innerInfo = simpleInfo;
            return this;
        }

        @Override // com.coolapk.market.model.Album.Builder
        public Album build() {
            String str = "";
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.likeTime == null) {
                str = str + " likeTime";
            }
            if (this.shareNum == null) {
                str = str + " shareNum";
            }
            if (this.recommend == null) {
                str = str + " recommend";
            }
            if (this.totalApkNum == null) {
                str = str + " totalApkNum";
            }
            if (this.favoriteNum == null) {
                str = str + " favoriteNum";
            }
            if (this.commentNum == null) {
                str = str + " commentNum";
            }
            if (this.forwardNum == null) {
                str = str + " forwardNum";
            }
            if (this.replyNum == null) {
                str = str + " replyNum";
            }
            if (this.status == null) {
                str = str + " status";
            }
            if (this.likeNum == null) {
                str = str + " likeNum";
            }
            if (this.commentBlockNum == null) {
                str = str + " commentBlockNum";
            }
            if (this.albumHotReplies == null) {
                str = str + " albumHotReplies";
            }
            if (this.replyMeRows == null) {
                str = str + " replyMeRows";
            }
            if (this.isStickTop == null) {
                str = str + " isStickTop";
            }
            if (str.isEmpty()) {
                return new AutoValue_Album(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.url, this.pic, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.uid, this.deprecatedUserName, this.displayUserName, this.feedId, this.title, this.logo, this.likeAvatar, this.likeUserInfo, this.likeUserName, this.likeUid, this.likeTime.longValue(), this.icon, this.keyWords, this.shareNum.intValue(), this.description, this.recommend.intValue(), this.totalApkNum.intValue(), this.favoriteNum.intValue(), this.commentNum.intValue(), this.forwardNum.intValue(), this.replyNum.intValue(), this.deviceTitle, this.status.intValue(), this.albumUrl, this.likeNum.intValue(), this.introduce, this.commentBlockNum.intValue(), this.infoHtml, this.info, this.albumItems, this.moreCount, this.collectionInfo, this.collectionItem, this.albumHotReplies, this.userAction, this.replyMeRows, this.isStickTop.intValue(), this.feedStatus, this.topInfo, this.innerInfo);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
