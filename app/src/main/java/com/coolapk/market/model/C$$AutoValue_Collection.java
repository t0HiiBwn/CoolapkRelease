package com.coolapk.market.model;

import com.coolapk.market.model.Collection;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_Collection  reason: invalid class name */
abstract class C$$AutoValue_Collection extends Collection {
    private final int apkNum;
    private final int copyNum;
    private final String coverPic;
    private final Long createdate;
    private final Long dateline;
    private final int defaultCollected;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String displayUserName;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final int feedNum;
    private final int followNum;
    private final String id;
    private final int isBeCollected;
    private final int isOpen;
    private final int itemNum;
    private final Long lastUpdate;
    private final int likeNum;
    private final String logo;
    private final String pic;
    private final int replyNum;
    private final int shareNum;
    private final String sourceId;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final UserAction userAction;
    private final UserInfo userInfo;

    C$$AutoValue_Collection(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, Long l2, Long l3, String str8, UserInfo userInfo2, String str9, String str10, String str11, String str12, String str13, String str14, int i, int i2, String str15, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String str16, int i11, Long l4, UserAction userAction2, String str17) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.url = str4;
        this.pic = str5;
        this.subTitle = str6;
        this.extraData = str7;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.deprecatedUserAvatar = str8;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str9;
        this.displayUserName = str10;
        this.id = str11;
        this.title = str12;
        this.logo = str13;
        this.uid = str14;
        this.isBeCollected = i;
        this.defaultCollected = i2;
        this.sourceId = str15;
        this.followNum = i3;
        this.copyNum = i4;
        this.replyNum = i5;
        this.likeNum = i6;
        this.feedNum = i7;
        this.apkNum = i8;
        this.shareNum = i9;
        this.itemNum = i10;
        this.coverPic = str16;
        this.isOpen = i11;
        this.createdate = l4;
        this.userAction = userAction2;
        this.description = str17;
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

    @Override // com.coolapk.market.model.Collection, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Collection, com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Collection, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.Collection, com.coolapk.market.model.IUser
    @SerializedName("uid")
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.Collection
    public int getIsBeCollected() {
        return this.isBeCollected;
    }

    @Override // com.coolapk.market.model.Collection
    public int getDefaultCollected() {
        return this.defaultCollected;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("source_id")
    public String getSourceId() {
        return this.sourceId;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("follow_num")
    public int getFollowNum() {
        return this.followNum;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("copy_num")
    public int getCopyNum() {
        return this.copyNum;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("reply_num")
    public int getReplyNum() {
        return this.replyNum;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("like_num")
    public int getLikeNum() {
        return this.likeNum;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("feed_num")
    public int getFeedNum() {
        return this.feedNum;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("apk_num")
    public int getApkNum() {
        return this.apkNum;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("share_num")
    public int getShareNum() {
        return this.shareNum;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("item_num")
    public int getItemNum() {
        return this.itemNum;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("cover_pic")
    public String getCoverPic() {
        return this.coverPic;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("is_open")
    public int getIsOpen() {
        return this.isOpen;
    }

    @Override // com.coolapk.market.model.Collection
    @SerializedName("createdate")
    public Long getCreatedate() {
        return this.createdate;
    }

    @Override // com.coolapk.market.model.Collection
    public UserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.Collection, com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Collection{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", id=" + this.id + ", title=" + this.title + ", logo=" + this.logo + ", uid=" + this.uid + ", isBeCollected=" + this.isBeCollected + ", defaultCollected=" + this.defaultCollected + ", sourceId=" + this.sourceId + ", followNum=" + this.followNum + ", copyNum=" + this.copyNum + ", replyNum=" + this.replyNum + ", likeNum=" + this.likeNum + ", feedNum=" + this.feedNum + ", apkNum=" + this.apkNum + ", shareNum=" + this.shareNum + ", itemNum=" + this.itemNum + ", coverPic=" + this.coverPic + ", isOpen=" + this.isOpen + ", createdate=" + this.createdate + ", userAction=" + this.userAction + ", description=" + this.description + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Long l2;
        UserAction userAction2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Collection)) {
            return false;
        }
        Collection collection = (Collection) obj;
        String str3 = this.entityTypeName;
        if (str3 != null ? str3.equals(collection.getEntityTypeName()) : collection.getEntityTypeName() == null) {
            String str4 = this.entityTemplate;
            if (str4 != null ? str4.equals(collection.getEntityTemplate()) : collection.getEntityTemplate() == null) {
                String str5 = this.entityId;
                if (str5 != null ? str5.equals(collection.getEntityId()) : collection.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(collection.getEntityFixed()) : collection.getEntityFixed() == null) {
                        String str6 = this.url;
                        if (str6 != null ? str6.equals(collection.getUrl()) : collection.getUrl() == null) {
                            String str7 = this.pic;
                            if (str7 != null ? str7.equals(collection.getPic()) : collection.getPic() == null) {
                                String str8 = this.subTitle;
                                if (str8 != null ? str8.equals(collection.getSubTitle()) : collection.getSubTitle() == null) {
                                    String str9 = this.extraData;
                                    if (str9 != null ? str9.equals(collection.getExtraData()) : collection.getExtraData() == null) {
                                        Long l3 = this.dateline;
                                        if (l3 != null ? l3.equals(collection.getDateline()) : collection.getDateline() == null) {
                                            Long l4 = this.lastUpdate;
                                            if (l4 != null ? l4.equals(collection.getLastUpdate()) : collection.getLastUpdate() == null) {
                                                String str10 = this.deprecatedUserAvatar;
                                                if (str10 != null ? str10.equals(collection.getDeprecatedUserAvatar()) : collection.getDeprecatedUserAvatar() == null) {
                                                    UserInfo userInfo2 = this.userInfo;
                                                    if (userInfo2 != null ? userInfo2.equals(collection.getUserInfo()) : collection.getUserInfo() == null) {
                                                        String str11 = this.deprecatedUserName;
                                                        if (str11 != null ? str11.equals(collection.getDeprecatedUserName()) : collection.getDeprecatedUserName() == null) {
                                                            String str12 = this.displayUserName;
                                                            if (str12 != null ? str12.equals(collection.getDisplayUserName()) : collection.getDisplayUserName() == null) {
                                                                String str13 = this.id;
                                                                if (str13 != null ? str13.equals(collection.getId()) : collection.getId() == null) {
                                                                    String str14 = this.title;
                                                                    if (str14 != null ? str14.equals(collection.getTitle()) : collection.getTitle() == null) {
                                                                        String str15 = this.logo;
                                                                        if (str15 != null ? str15.equals(collection.getLogo()) : collection.getLogo() == null) {
                                                                            String str16 = this.uid;
                                                                            if (str16 != null ? str16.equals(collection.getUid()) : collection.getUid() == null) {
                                                                                if (this.isBeCollected == collection.getIsBeCollected() && this.defaultCollected == collection.getDefaultCollected() && ((str = this.sourceId) != null ? str.equals(collection.getSourceId()) : collection.getSourceId() == null) && this.followNum == collection.getFollowNum() && this.copyNum == collection.getCopyNum() && this.replyNum == collection.getReplyNum() && this.likeNum == collection.getLikeNum() && this.feedNum == collection.getFeedNum() && this.apkNum == collection.getApkNum() && this.shareNum == collection.getShareNum() && this.itemNum == collection.getItemNum() && ((str2 = this.coverPic) != null ? str2.equals(collection.getCoverPic()) : collection.getCoverPic() == null) && this.isOpen == collection.getIsOpen() && ((l2 = this.createdate) != null ? l2.equals(collection.getCreatedate()) : collection.getCreatedate() == null) && ((userAction2 = this.userAction) != null ? userAction2.equals(collection.getUserAction()) : collection.getUserAction() == null)) {
                                                                                    String str17 = this.description;
                                                                                    if (str17 == null) {
                                                                                        if (collection.getDescription() == null) {
                                                                                            return true;
                                                                                        }
                                                                                    } else if (str17.equals(collection.getDescription())) {
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
        String str7 = this.extraData;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode9 = (hashCode8 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode10 = (hashCode9 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str8 = this.deprecatedUserAvatar;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode12 = (hashCode11 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str9 = this.deprecatedUserName;
        int hashCode13 = (hashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.displayUserName;
        int hashCode14 = (hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.id;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.title;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.logo;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.uid;
        int hashCode18 = (((((hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.isBeCollected) * 1000003) ^ this.defaultCollected) * 1000003;
        String str15 = this.sourceId;
        int hashCode19 = (((((((((((((((((hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.followNum) * 1000003) ^ this.copyNum) * 1000003) ^ this.replyNum) * 1000003) ^ this.likeNum) * 1000003) ^ this.feedNum) * 1000003) ^ this.apkNum) * 1000003) ^ this.shareNum) * 1000003) ^ this.itemNum) * 1000003;
        String str16 = this.coverPic;
        int hashCode20 = (((hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.isOpen) * 1000003;
        Long l4 = this.createdate;
        int hashCode21 = (hashCode20 ^ (l4 == null ? 0 : l4.hashCode())) * 1000003;
        UserAction userAction2 = this.userAction;
        int hashCode22 = (hashCode21 ^ (userAction2 == null ? 0 : userAction2.hashCode())) * 1000003;
        String str17 = this.description;
        if (str17 != null) {
            i = str17.hashCode();
        }
        return hashCode22 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Collection$Builder */
    /* compiled from: $$AutoValue_Collection */
    static final class Builder extends Collection.Builder {
        private Integer apkNum;
        private Integer copyNum;
        private String coverPic;
        private Long createdate;
        private Long dateline;
        private Integer defaultCollected;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private String displayUserName;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private Integer feedNum;
        private Integer followNum;
        private String id;
        private Integer isBeCollected;
        private Integer isOpen;
        private Integer itemNum;
        private Long lastUpdate;
        private Integer likeNum;
        private String logo;
        private String pic;
        private Integer replyNum;
        private Integer shareNum;
        private String sourceId;
        private String subTitle;
        private String title;
        private String uid;
        private String url;
        private UserAction userAction;
        private UserInfo userInfo;

        Builder() {
        }

        Builder(Collection collection) {
            this.entityTypeName = collection.getEntityTypeName();
            this.entityTemplate = collection.getEntityTemplate();
            this.entityId = collection.getEntityId();
            this.entityFixed = collection.getEntityFixed();
            this.url = collection.getUrl();
            this.pic = collection.getPic();
            this.subTitle = collection.getSubTitle();
            this.extraData = collection.getExtraData();
            this.dateline = collection.getDateline();
            this.lastUpdate = collection.getLastUpdate();
            this.deprecatedUserAvatar = collection.getDeprecatedUserAvatar();
            this.userInfo = collection.getUserInfo();
            this.deprecatedUserName = collection.getDeprecatedUserName();
            this.displayUserName = collection.getDisplayUserName();
            this.id = collection.getId();
            this.title = collection.getTitle();
            this.logo = collection.getLogo();
            this.uid = collection.getUid();
            this.isBeCollected = Integer.valueOf(collection.getIsBeCollected());
            this.defaultCollected = Integer.valueOf(collection.getDefaultCollected());
            this.sourceId = collection.getSourceId();
            this.followNum = Integer.valueOf(collection.getFollowNum());
            this.copyNum = Integer.valueOf(collection.getCopyNum());
            this.replyNum = Integer.valueOf(collection.getReplyNum());
            this.likeNum = Integer.valueOf(collection.getLikeNum());
            this.feedNum = Integer.valueOf(collection.getFeedNum());
            this.apkNum = Integer.valueOf(collection.getApkNum());
            this.shareNum = Integer.valueOf(collection.getShareNum());
            this.itemNum = Integer.valueOf(collection.getItemNum());
            this.coverPic = collection.getCoverPic();
            this.isOpen = Integer.valueOf(collection.getIsOpen());
            this.createdate = collection.getCreatedate();
            this.userAction = collection.getUserAction();
            this.description = collection.getDescription();
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder dateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder lastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Collection.Builder deprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Collection.Builder userInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Collection.Builder deprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public Collection.Builder displayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder, com.coolapk.market.model.IUser.BuilderM2
        public Collection.Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder isBeCollected(int i) {
            this.isBeCollected = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder defaultCollected(int i) {
            this.defaultCollected = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder sourceId(String str) {
            this.sourceId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder followNum(int i) {
            this.followNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder copyNum(int i) {
            this.copyNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder replyNum(int i) {
            this.replyNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder likeNum(int i) {
            this.likeNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder feedNum(int i) {
            this.feedNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder apkNum(int i) {
            this.apkNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder shareNum(int i) {
            this.shareNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder itemNum(int i) {
            this.itemNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder coverPic(String str) {
            this.coverPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder isOpen(int i) {
            this.isOpen = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder createdate(Long l2) {
            this.createdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder userAction(UserAction userAction2) {
            this.userAction = userAction2;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Collection.Builder
        public Collection build() {
            String str = "";
            if (this.isBeCollected == null) {
                str = str + " isBeCollected";
            }
            if (this.defaultCollected == null) {
                str = str + " defaultCollected";
            }
            if (this.followNum == null) {
                str = str + " followNum";
            }
            if (this.copyNum == null) {
                str = str + " copyNum";
            }
            if (this.replyNum == null) {
                str = str + " replyNum";
            }
            if (this.likeNum == null) {
                str = str + " likeNum";
            }
            if (this.feedNum == null) {
                str = str + " feedNum";
            }
            if (this.apkNum == null) {
                str = str + " apkNum";
            }
            if (this.shareNum == null) {
                str = str + " shareNum";
            }
            if (this.itemNum == null) {
                str = str + " itemNum";
            }
            if (this.isOpen == null) {
                str = str + " isOpen";
            }
            if (str.isEmpty()) {
                return new AutoValue_Collection(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.url, this.pic, this.subTitle, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.deprecatedUserName, this.displayUserName, this.id, this.title, this.logo, this.uid, this.isBeCollected.intValue(), this.defaultCollected.intValue(), this.sourceId, this.followNum.intValue(), this.copyNum.intValue(), this.replyNum.intValue(), this.likeNum.intValue(), this.feedNum.intValue(), this.apkNum.intValue(), this.shareNum.intValue(), this.itemNum.intValue(), this.coverPic, this.isOpen.intValue(), this.createdate, this.userAction, this.description);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
