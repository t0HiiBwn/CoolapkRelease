package com.coolapk.market.model;

import com.coolapk.market.model.FunThings;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_FunThings  reason: invalid class name */
abstract class C$$AutoValue_FunThings extends FunThings {
    private final int copyNum;
    private final String coverPic;
    private final Long createdate;
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
    private final int favNum;
    private final int followNum;
    private final String id;
    private final int isAdded;
    private final int isOpen;
    private final int itemNum;
    private final Long lastUpdate;
    private final int likeNum;
    private final String logo;
    private final String message;
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

    C$$AutoValue_FunThings(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, UserInfo userInfo2, String str10, String str11, String str12, String str13, String str14, String str15, int i, String str16, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str17, int i9, Long l4, UserAction userAction2, String str18) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.url = str4;
        this.description = str5;
        this.pic = str6;
        this.subTitle = str7;
        this.extraData = str8;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.deprecatedUserAvatar = str9;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str10;
        this.displayUserName = str11;
        this.id = str12;
        this.title = str13;
        this.logo = str14;
        this.uid = str15;
        this.isAdded = i;
        this.sourceId = str16;
        this.followNum = i2;
        this.copyNum = i3;
        this.replyNum = i4;
        this.likeNum = i5;
        this.favNum = i6;
        this.shareNum = i7;
        this.itemNum = i8;
        this.coverPic = str17;
        this.isOpen = i9;
        this.createdate = l4;
        this.userAction = userAction2;
        this.message = str18;
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
    @SerializedName("description")
    public String getDescription() {
        return this.description;
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

    @Override // com.coolapk.market.model.FunThings, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.FunThings, com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.FunThings, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.FunThings, com.coolapk.market.model.IUser
    @SerializedName("uid")
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.FunThings
    public int getIsAdded() {
        return this.isAdded;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("source_id")
    public String getSourceId() {
        return this.sourceId;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("follow_num")
    public int getFollowNum() {
        return this.followNum;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("copy_num")
    public int getCopyNum() {
        return this.copyNum;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("reply_num")
    public int getReplyNum() {
        return this.replyNum;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("like_num")
    public int getLikeNum() {
        return this.likeNum;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("fav_num")
    public int getFavNum() {
        return this.favNum;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("share_num")
    public int getShareNum() {
        return this.shareNum;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("item_num")
    public int getItemNum() {
        return this.itemNum;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("cover")
    public String getCoverPic() {
        return this.coverPic;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("is_open")
    public int getIsOpen() {
        return this.isOpen;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("createdate")
    public Long getCreatedate() {
        return this.createdate;
    }

    @Override // com.coolapk.market.model.FunThings
    public UserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.FunThings
    @SerializedName("message")
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FunThings{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", id=" + this.id + ", title=" + this.title + ", logo=" + this.logo + ", uid=" + this.uid + ", isAdded=" + this.isAdded + ", sourceId=" + this.sourceId + ", followNum=" + this.followNum + ", copyNum=" + this.copyNum + ", replyNum=" + this.replyNum + ", likeNum=" + this.likeNum + ", favNum=" + this.favNum + ", shareNum=" + this.shareNum + ", itemNum=" + this.itemNum + ", coverPic=" + this.coverPic + ", isOpen=" + this.isOpen + ", createdate=" + this.createdate + ", userAction=" + this.userAction + ", message=" + this.message + "}";
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
        if (!(obj instanceof FunThings)) {
            return false;
        }
        FunThings funThings = (FunThings) obj;
        String str3 = this.entityTypeName;
        if (str3 != null ? str3.equals(funThings.getEntityTypeName()) : funThings.getEntityTypeName() == null) {
            String str4 = this.entityTemplate;
            if (str4 != null ? str4.equals(funThings.getEntityTemplate()) : funThings.getEntityTemplate() == null) {
                String str5 = this.entityId;
                if (str5 != null ? str5.equals(funThings.getEntityId()) : funThings.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(funThings.getEntityFixed()) : funThings.getEntityFixed() == null) {
                        String str6 = this.url;
                        if (str6 != null ? str6.equals(funThings.getUrl()) : funThings.getUrl() == null) {
                            String str7 = this.description;
                            if (str7 != null ? str7.equals(funThings.getDescription()) : funThings.getDescription() == null) {
                                String str8 = this.pic;
                                if (str8 != null ? str8.equals(funThings.getPic()) : funThings.getPic() == null) {
                                    String str9 = this.subTitle;
                                    if (str9 != null ? str9.equals(funThings.getSubTitle()) : funThings.getSubTitle() == null) {
                                        String str10 = this.extraData;
                                        if (str10 != null ? str10.equals(funThings.getExtraData()) : funThings.getExtraData() == null) {
                                            Long l3 = this.dateline;
                                            if (l3 != null ? l3.equals(funThings.getDateline()) : funThings.getDateline() == null) {
                                                Long l4 = this.lastUpdate;
                                                if (l4 != null ? l4.equals(funThings.getLastUpdate()) : funThings.getLastUpdate() == null) {
                                                    String str11 = this.deprecatedUserAvatar;
                                                    if (str11 != null ? str11.equals(funThings.getDeprecatedUserAvatar()) : funThings.getDeprecatedUserAvatar() == null) {
                                                        UserInfo userInfo2 = this.userInfo;
                                                        if (userInfo2 != null ? userInfo2.equals(funThings.getUserInfo()) : funThings.getUserInfo() == null) {
                                                            String str12 = this.deprecatedUserName;
                                                            if (str12 != null ? str12.equals(funThings.getDeprecatedUserName()) : funThings.getDeprecatedUserName() == null) {
                                                                String str13 = this.displayUserName;
                                                                if (str13 != null ? str13.equals(funThings.getDisplayUserName()) : funThings.getDisplayUserName() == null) {
                                                                    String str14 = this.id;
                                                                    if (str14 != null ? str14.equals(funThings.getId()) : funThings.getId() == null) {
                                                                        String str15 = this.title;
                                                                        if (str15 != null ? str15.equals(funThings.getTitle()) : funThings.getTitle() == null) {
                                                                            String str16 = this.logo;
                                                                            if (str16 != null ? str16.equals(funThings.getLogo()) : funThings.getLogo() == null) {
                                                                                String str17 = this.uid;
                                                                                if (str17 != null ? str17.equals(funThings.getUid()) : funThings.getUid() == null) {
                                                                                    if (this.isAdded == funThings.getIsAdded() && ((str = this.sourceId) != null ? str.equals(funThings.getSourceId()) : funThings.getSourceId() == null) && this.followNum == funThings.getFollowNum() && this.copyNum == funThings.getCopyNum() && this.replyNum == funThings.getReplyNum() && this.likeNum == funThings.getLikeNum() && this.favNum == funThings.getFavNum() && this.shareNum == funThings.getShareNum() && this.itemNum == funThings.getItemNum() && ((str2 = this.coverPic) != null ? str2.equals(funThings.getCoverPic()) : funThings.getCoverPic() == null) && this.isOpen == funThings.getIsOpen() && ((l2 = this.createdate) != null ? l2.equals(funThings.getCreatedate()) : funThings.getCreatedate() == null) && ((userAction2 = this.userAction) != null ? userAction2.equals(funThings.getUserAction()) : funThings.getUserAction() == null)) {
                                                                                        String str18 = this.message;
                                                                                        if (str18 == null) {
                                                                                            if (funThings.getMessage() == null) {
                                                                                                return true;
                                                                                            }
                                                                                        } else if (str18.equals(funThings.getMessage())) {
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
        String str5 = this.description;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.pic;
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
        UserInfo userInfo2 = this.userInfo;
        int hashCode13 = (hashCode12 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str10 = this.deprecatedUserName;
        int hashCode14 = (hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.displayUserName;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.id;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.title;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.logo;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.uid;
        int hashCode19 = (((hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.isAdded) * 1000003;
        String str16 = this.sourceId;
        int hashCode20 = (((((((((((((((hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.followNum) * 1000003) ^ this.copyNum) * 1000003) ^ this.replyNum) * 1000003) ^ this.likeNum) * 1000003) ^ this.favNum) * 1000003) ^ this.shareNum) * 1000003) ^ this.itemNum) * 1000003;
        String str17 = this.coverPic;
        int hashCode21 = (((hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003) ^ this.isOpen) * 1000003;
        Long l4 = this.createdate;
        int hashCode22 = (hashCode21 ^ (l4 == null ? 0 : l4.hashCode())) * 1000003;
        UserAction userAction2 = this.userAction;
        int hashCode23 = (hashCode22 ^ (userAction2 == null ? 0 : userAction2.hashCode())) * 1000003;
        String str18 = this.message;
        if (str18 != null) {
            i = str18.hashCode();
        }
        return hashCode23 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_FunThings$Builder */
    /* compiled from: $$AutoValue_FunThings */
    static final class Builder extends FunThings.Builder {
        private Integer copyNum;
        private String coverPic;
        private Long createdate;
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
        private Integer favNum;
        private Integer followNum;
        private String id;
        private Integer isAdded;
        private Integer isOpen;
        private Integer itemNum;
        private Long lastUpdate;
        private Integer likeNum;
        private String logo;
        private String message;
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

        Builder(FunThings funThings) {
            this.entityTypeName = funThings.getEntityTypeName();
            this.entityTemplate = funThings.getEntityTemplate();
            this.entityId = funThings.getEntityId();
            this.entityFixed = funThings.getEntityFixed();
            this.url = funThings.getUrl();
            this.description = funThings.getDescription();
            this.pic = funThings.getPic();
            this.subTitle = funThings.getSubTitle();
            this.extraData = funThings.getExtraData();
            this.dateline = funThings.getDateline();
            this.lastUpdate = funThings.getLastUpdate();
            this.deprecatedUserAvatar = funThings.getDeprecatedUserAvatar();
            this.userInfo = funThings.getUserInfo();
            this.deprecatedUserName = funThings.getDeprecatedUserName();
            this.displayUserName = funThings.getDisplayUserName();
            this.id = funThings.getId();
            this.title = funThings.getTitle();
            this.logo = funThings.getLogo();
            this.uid = funThings.getUid();
            this.isAdded = Integer.valueOf(funThings.getIsAdded());
            this.sourceId = funThings.getSourceId();
            this.followNum = Integer.valueOf(funThings.getFollowNum());
            this.copyNum = Integer.valueOf(funThings.getCopyNum());
            this.replyNum = Integer.valueOf(funThings.getReplyNum());
            this.likeNum = Integer.valueOf(funThings.getLikeNum());
            this.favNum = Integer.valueOf(funThings.getFavNum());
            this.shareNum = Integer.valueOf(funThings.getShareNum());
            this.itemNum = Integer.valueOf(funThings.getItemNum());
            this.coverPic = funThings.getCoverPic();
            this.isOpen = Integer.valueOf(funThings.getIsOpen());
            this.createdate = funThings.getCreatedate();
            this.userAction = funThings.getUserAction();
            this.message = funThings.getMessage();
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder dateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder lastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public FunThings.Builder deprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public FunThings.Builder userInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public FunThings.Builder deprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public FunThings.Builder displayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder, com.coolapk.market.model.IUser.BuilderM2
        public FunThings.Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder isAdded(int i) {
            this.isAdded = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder sourceId(String str) {
            this.sourceId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder followNum(int i) {
            this.followNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder copyNum(int i) {
            this.copyNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder replyNum(int i) {
            this.replyNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder likeNum(int i) {
            this.likeNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder favNum(int i) {
            this.favNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder shareNum(int i) {
            this.shareNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder itemNum(int i) {
            this.itemNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder coverPic(String str) {
            this.coverPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder isOpen(int i) {
            this.isOpen = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder createdate(Long l2) {
            this.createdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder userAction(UserAction userAction2) {
            this.userAction = userAction2;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings.Builder message(String str) {
            this.message = str;
            return this;
        }

        @Override // com.coolapk.market.model.FunThings.Builder
        public FunThings build() {
            String str = "";
            if (this.isAdded == null) {
                str = str + " isAdded";
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
            if (this.favNum == null) {
                str = str + " favNum";
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
                return new AutoValue_FunThings(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.url, this.description, this.pic, this.subTitle, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.deprecatedUserName, this.displayUserName, this.id, this.title, this.logo, this.uid, this.isAdded.intValue(), this.sourceId, this.followNum.intValue(), this.copyNum.intValue(), this.replyNum.intValue(), this.likeNum.intValue(), this.favNum.intValue(), this.shareNum.intValue(), this.itemNum.intValue(), this.coverPic, this.isOpen.intValue(), this.createdate, this.userAction, this.message);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
