package com.coolapk.market.model;

import com.coolapk.market.model.User;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_User  reason: invalid class name */
abstract class C$$AutoValue_User extends User {
    private final String bio;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String displayUserName;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final String fans;
    private final String follow;
    private final String id;
    private final int isFollow;
    private final Long lastUpdate;
    private final int likeNum;
    private final long loginTime;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String type;
    private final String uid;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_User(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l, Long l2, String str10, UserInfo userInfo2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i, String str18, String str19, long j, int i2, String str20) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.url = str4;
        this.description = str5;
        this.pic = str6;
        this.logo = str7;
        this.id = str8;
        this.extraData = str9;
        this.dateline = l;
        this.lastUpdate = l2;
        this.deprecatedUserAvatar = str10;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str11;
        this.displayUserName = str12;
        this.entityType = str13;
        this.title = str14;
        this.subTitle = str15;
        this.type = str16;
        Objects.requireNonNull(str17, "Null uid");
        this.uid = str17;
        this.isFollow = i;
        this.fans = str18;
        this.follow = str19;
        this.loginTime = j;
        this.likeNum = i2;
        this.bio = str20;
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
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
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
    @SerializedName("username")
    public String getDeprecatedUserName() {
        return this.deprecatedUserName;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("displayUsername")
    public String getDisplayUserName() {
        return this.displayUserName;
    }

    @Override // com.coolapk.market.model.User, com.coolapk.market.model.Entity
    public String getEntityType() {
        return this.entityType;
    }

    @Override // com.coolapk.market.model.User, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.User, com.coolapk.market.model.Entity
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.User
    public String getType() {
        return this.type;
    }

    @Override // com.coolapk.market.model.User, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.User
    @SerializedName("isFollow")
    public int getIsFollow() {
        return this.isFollow;
    }

    @Override // com.coolapk.market.model.User
    public String getFans() {
        return this.fans;
    }

    @Override // com.coolapk.market.model.User
    public String getFollow() {
        return this.follow;
    }

    @Override // com.coolapk.market.model.User
    @SerializedName("logintime")
    public long getLoginTime() {
        return this.loginTime;
    }

    @Override // com.coolapk.market.model.User
    @SerializedName("be_like_num")
    public int getLikeNum() {
        return this.likeNum;
    }

    @Override // com.coolapk.market.model.User
    public String getBio() {
        return this.bio;
    }

    @Override // java.lang.Object
    public String toString() {
        return "User{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", entityType=" + this.entityType + ", title=" + this.title + ", subTitle=" + this.subTitle + ", type=" + this.type + ", uid=" + this.uid + ", isFollow=" + this.isFollow + ", fans=" + this.fans + ", follow=" + this.follow + ", loginTime=" + this.loginTime + ", likeNum=" + this.likeNum + ", bio=" + this.bio + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        String str3 = this.entityTypeName;
        if (str3 != null ? str3.equals(user.getEntityTypeName()) : user.getEntityTypeName() == null) {
            String str4 = this.entityTemplate;
            if (str4 != null ? str4.equals(user.getEntityTemplate()) : user.getEntityTemplate() == null) {
                String str5 = this.entityId;
                if (str5 != null ? str5.equals(user.getEntityId()) : user.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(user.getEntityFixed()) : user.getEntityFixed() == null) {
                        String str6 = this.url;
                        if (str6 != null ? str6.equals(user.getUrl()) : user.getUrl() == null) {
                            String str7 = this.description;
                            if (str7 != null ? str7.equals(user.getDescription()) : user.getDescription() == null) {
                                String str8 = this.pic;
                                if (str8 != null ? str8.equals(user.getPic()) : user.getPic() == null) {
                                    String str9 = this.logo;
                                    if (str9 != null ? str9.equals(user.getLogo()) : user.getLogo() == null) {
                                        String str10 = this.id;
                                        if (str10 != null ? str10.equals(user.getId()) : user.getId() == null) {
                                            String str11 = this.extraData;
                                            if (str11 != null ? str11.equals(user.getExtraData()) : user.getExtraData() == null) {
                                                Long l = this.dateline;
                                                if (l != null ? l.equals(user.getDateline()) : user.getDateline() == null) {
                                                    Long l2 = this.lastUpdate;
                                                    if (l2 != null ? l2.equals(user.getLastUpdate()) : user.getLastUpdate() == null) {
                                                        String str12 = this.deprecatedUserAvatar;
                                                        if (str12 != null ? str12.equals(user.getDeprecatedUserAvatar()) : user.getDeprecatedUserAvatar() == null) {
                                                            UserInfo userInfo2 = this.userInfo;
                                                            if (userInfo2 != null ? userInfo2.equals(user.getUserInfo()) : user.getUserInfo() == null) {
                                                                String str13 = this.deprecatedUserName;
                                                                if (str13 != null ? str13.equals(user.getDeprecatedUserName()) : user.getDeprecatedUserName() == null) {
                                                                    String str14 = this.displayUserName;
                                                                    if (str14 != null ? str14.equals(user.getDisplayUserName()) : user.getDisplayUserName() == null) {
                                                                        String str15 = this.entityType;
                                                                        if (str15 != null ? str15.equals(user.getEntityType()) : user.getEntityType() == null) {
                                                                            String str16 = this.title;
                                                                            if (str16 != null ? str16.equals(user.getTitle()) : user.getTitle() == null) {
                                                                                String str17 = this.subTitle;
                                                                                if (str17 != null ? str17.equals(user.getSubTitle()) : user.getSubTitle() == null) {
                                                                                    String str18 = this.type;
                                                                                    if (str18 != null ? str18.equals(user.getType()) : user.getType() == null) {
                                                                                        if (this.uid.equals(user.getUid()) && this.isFollow == user.getIsFollow() && ((str = this.fans) != null ? str.equals(user.getFans()) : user.getFans() == null) && ((str2 = this.follow) != null ? str2.equals(user.getFollow()) : user.getFollow() == null) && this.loginTime == user.getLoginTime() && this.likeNum == user.getLikeNum()) {
                                                                                            String str19 = this.bio;
                                                                                            if (str19 == null) {
                                                                                                if (user.getBio() == null) {
                                                                                                    return true;
                                                                                                }
                                                                                            } else if (str19.equals(user.getBio())) {
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
        String str7 = this.logo;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.id;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.extraData;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode11 = (hashCode10 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode12 = (hashCode11 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str10 = this.deprecatedUserAvatar;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode14 = (hashCode13 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str11 = this.deprecatedUserName;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.displayUserName;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.entityType;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.title;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.subTitle;
        int hashCode19 = (hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.type;
        int hashCode20 = (((((hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.uid.hashCode()) * 1000003) ^ this.isFollow) * 1000003;
        String str17 = this.fans;
        int hashCode21 = (hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.follow;
        int hashCode22 = str18 == null ? 0 : str18.hashCode();
        long j = this.loginTime;
        int i2 = ((((int) (((long) ((hashCode21 ^ hashCode22) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003) ^ this.likeNum) * 1000003;
        String str19 = this.bio;
        if (str19 != null) {
            i = str19.hashCode();
        }
        return i2 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_User$Builder */
    /* compiled from: $$AutoValue_User */
    static final class Builder extends User.Builder {
        private String bio;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private String displayUserName;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private String fans;
        private String follow;
        private String id;
        private Integer isFollow;
        private Long lastUpdate;
        private Integer likeNum;
        private Long loginTime;
        private String logo;
        private String pic;
        private String subTitle;
        private String title;
        private String type;
        private String uid;
        private String url;
        private UserInfo userInfo;

        Builder() {
        }

        Builder(User user) {
            this.entityTypeName = user.getEntityTypeName();
            this.entityTemplate = user.getEntityTemplate();
            this.entityId = user.getEntityId();
            this.entityFixed = user.getEntityFixed();
            this.url = user.getUrl();
            this.description = user.getDescription();
            this.pic = user.getPic();
            this.logo = user.getLogo();
            this.id = user.getId();
            this.extraData = user.getExtraData();
            this.dateline = user.getDateline();
            this.lastUpdate = user.getLastUpdate();
            this.deprecatedUserAvatar = user.getDeprecatedUserAvatar();
            this.userInfo = user.getUserInfo();
            this.deprecatedUserName = user.getDeprecatedUserName();
            this.displayUserName = user.getDisplayUserName();
            this.entityType = user.getEntityType();
            this.title = user.getTitle();
            this.subTitle = user.getSubTitle();
            this.type = user.getType();
            this.uid = user.getUid();
            this.isFollow = Integer.valueOf(user.getIsFollow());
            this.fans = user.getFans();
            this.follow = user.getFollow();
            this.loginTime = Long.valueOf(user.getLoginTime());
            this.likeNum = Integer.valueOf(user.getLikeNum());
            this.bio = user.getBio();
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public User.Builder setDeprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public User.Builder setUserInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public User.Builder setDeprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public User.Builder setDisplayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setType(String str) {
            this.type = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder, com.coolapk.market.model.IUser.BuilderM1
        public User.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setIsFollow(int i) {
            this.isFollow = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setFans(String str) {
            this.fans = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setFollow(String str) {
            this.follow = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setLoginTime(long j) {
            this.loginTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setLikeNum(int i) {
            this.likeNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User.Builder setBio(String str) {
            this.bio = str;
            return this;
        }

        @Override // com.coolapk.market.model.User.Builder
        public User build() {
            String str = "";
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.isFollow == null) {
                str = str + " isFollow";
            }
            if (this.loginTime == null) {
                str = str + " loginTime";
            }
            if (this.likeNum == null) {
                str = str + " likeNum";
            }
            if (str.isEmpty()) {
                return new AutoValue_User(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.url, this.description, this.pic, this.logo, this.id, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.deprecatedUserName, this.displayUserName, this.entityType, this.title, this.subTitle, this.type, this.uid, this.isFollow.intValue(), this.fans, this.follow, this.loginTime.longValue(), this.likeNum.intValue(), this.bio);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
