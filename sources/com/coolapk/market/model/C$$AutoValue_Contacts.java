package com.coolapk.market.model;

import com.coolapk.market.model.Contacts;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Contacts  reason: invalid class name */
abstract class C$$AutoValue_Contacts extends Contacts {
    private final Long dateline;
    private final String deprecatedFollowUserName;
    private final String deprecatedFollowerUserAvatar;
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
    private final String followUid;
    private final UserInfo followerUserInfo;
    private final String id;
    private final int isFriend;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_Contacts(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l, Long l2, String str13, String str14, String str15, String str16, String str17, String str18, int i, String str19, UserInfo userInfo2, UserInfo userInfo3) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityId = str4;
        this.entityFixed = num;
        this.title = str5;
        this.url = str6;
        this.description = str7;
        this.pic = str8;
        this.logo = str9;
        this.subTitle = str10;
        this.id = str11;
        this.extraData = str12;
        this.dateline = l;
        this.lastUpdate = l2;
        this.deprecatedUserAvatar = str13;
        this.deprecatedUserName = str14;
        this.displayUserName = str15;
        Objects.requireNonNull(str16, "Null uid");
        this.uid = str16;
        this.followUid = str17;
        this.deprecatedFollowUserName = str18;
        this.isFriend = i;
        this.deprecatedFollowerUserAvatar = str19;
        this.followerUserInfo = userInfo2;
        this.userInfo = userInfo3;
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
    @SerializedName("title")
    public String getTitle() {
        return this.title;
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
    @SerializedName("username")
    public String getDeprecatedUserName() {
        return this.deprecatedUserName;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("displayUsername")
    public String getDisplayUserName() {
        return this.displayUserName;
    }

    @Override // com.coolapk.market.model.Contacts, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.Contacts
    @SerializedName("fuid")
    public String getFollowUid() {
        return this.followUid;
    }

    @Override // com.coolapk.market.model.Contacts
    @SerializedName("fusername")
    public String getDeprecatedFollowUserName() {
        return this.deprecatedFollowUserName;
    }

    @Override // com.coolapk.market.model.Contacts
    @SerializedName("isfriend")
    public int getIsFriend() {
        return this.isFriend;
    }

    @Override // com.coolapk.market.model.Contacts
    @SerializedName("fUserAvatar")
    public String getDeprecatedFollowerUserAvatar() {
        return this.deprecatedFollowerUserAvatar;
    }

    @Override // com.coolapk.market.model.Contacts
    @SerializedName("fUserInfo")
    public UserInfo getFollowerUserInfo() {
        return this.followerUserInfo;
    }

    @Override // com.coolapk.market.model.Contacts, com.coolapk.market.model.IUser
    @SerializedName("userInfo")
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Contacts{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", uid=" + this.uid + ", followUid=" + this.followUid + ", deprecatedFollowUserName=" + this.deprecatedFollowUserName + ", isFriend=" + this.isFriend + ", deprecatedFollowerUserAvatar=" + this.deprecatedFollowerUserAvatar + ", followerUserInfo=" + this.followerUserInfo + ", userInfo=" + this.userInfo + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Long l;
        Long l2;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        UserInfo userInfo2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Contacts)) {
            return false;
        }
        Contacts contacts = (Contacts) obj;
        String str17 = this.entityTypeName;
        if (str17 != null ? str17.equals(contacts.getEntityTypeName()) : contacts.getEntityTypeName() == null) {
            if (this.entityType.equals(contacts.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(contacts.getEntityTemplate()) : contacts.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(contacts.getEntityId()) : contacts.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(contacts.getEntityFixed()) : contacts.getEntityFixed() == null) && ((str3 = this.title) != null ? str3.equals(contacts.getTitle()) : contacts.getTitle() == null) && ((str4 = this.url) != null ? str4.equals(contacts.getUrl()) : contacts.getUrl() == null) && ((str5 = this.description) != null ? str5.equals(contacts.getDescription()) : contacts.getDescription() == null) && ((str6 = this.pic) != null ? str6.equals(contacts.getPic()) : contacts.getPic() == null) && ((str7 = this.logo) != null ? str7.equals(contacts.getLogo()) : contacts.getLogo() == null) && ((str8 = this.subTitle) != null ? str8.equals(contacts.getSubTitle()) : contacts.getSubTitle() == null) && ((str9 = this.id) != null ? str9.equals(contacts.getId()) : contacts.getId() == null) && ((str10 = this.extraData) != null ? str10.equals(contacts.getExtraData()) : contacts.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(contacts.getDateline()) : contacts.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(contacts.getLastUpdate()) : contacts.getLastUpdate() == null) && ((str11 = this.deprecatedUserAvatar) != null ? str11.equals(contacts.getDeprecatedUserAvatar()) : contacts.getDeprecatedUserAvatar() == null) && ((str12 = this.deprecatedUserName) != null ? str12.equals(contacts.getDeprecatedUserName()) : contacts.getDeprecatedUserName() == null) && ((str13 = this.displayUserName) != null ? str13.equals(contacts.getDisplayUserName()) : contacts.getDisplayUserName() == null) && this.uid.equals(contacts.getUid()) && ((str14 = this.followUid) != null ? str14.equals(contacts.getFollowUid()) : contacts.getFollowUid() == null) && ((str15 = this.deprecatedFollowUserName) != null ? str15.equals(contacts.getDeprecatedFollowUserName()) : contacts.getDeprecatedFollowUserName() == null) && this.isFriend == contacts.getIsFriend() && ((str16 = this.deprecatedFollowerUserAvatar) != null ? str16.equals(contacts.getDeprecatedFollowerUserAvatar()) : contacts.getDeprecatedFollowerUserAvatar() == null) && ((userInfo2 = this.followerUserInfo) != null ? userInfo2.equals(contacts.getFollowerUserInfo()) : contacts.getFollowerUserInfo() == null)) {
                UserInfo userInfo3 = this.userInfo;
                if (userInfo3 == null) {
                    if (contacts.getUserInfo() == null) {
                        return true;
                    }
                } else if (userInfo3.equals(contacts.getUserInfo())) {
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
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.title;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.url;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.description;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.pic;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.logo;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.subTitle;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.id;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.extraData;
        int hashCode12 = (hashCode11 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode13 = (hashCode12 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode14 = (hashCode13 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str12 = this.deprecatedUserAvatar;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.deprecatedUserName;
        int hashCode16 = (hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.displayUserName;
        int hashCode17 = (((hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.uid.hashCode()) * 1000003;
        String str15 = this.followUid;
        int hashCode18 = (hashCode17 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.deprecatedFollowUserName;
        int hashCode19 = (((hashCode18 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.isFriend) * 1000003;
        String str17 = this.deprecatedFollowerUserAvatar;
        int hashCode20 = (hashCode19 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        UserInfo userInfo2 = this.followerUserInfo;
        int hashCode21 = (hashCode20 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        UserInfo userInfo3 = this.userInfo;
        if (userInfo3 != null) {
            i = userInfo3.hashCode();
        }
        return hashCode21 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Contacts$Builder */
    /* compiled from: $$AutoValue_Contacts */
    static final class Builder extends Contacts.Builder {
        private Long dateline;
        private String deprecatedFollowUserName;
        private String deprecatedFollowerUserAvatar;
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
        private String followUid;
        private UserInfo followerUserInfo;
        private String id;
        private Integer isFriend;
        private Long lastUpdate;
        private String logo;
        private String pic;
        private String subTitle;
        private String title;
        private String uid;
        private String url;
        private UserInfo userInfo;

        Builder() {
        }

        Builder(Contacts contacts) {
            this.entityTypeName = contacts.getEntityTypeName();
            this.entityType = contacts.getEntityType();
            this.entityTemplate = contacts.getEntityTemplate();
            this.entityId = contacts.getEntityId();
            this.entityFixed = contacts.getEntityFixed();
            this.title = contacts.getTitle();
            this.url = contacts.getUrl();
            this.description = contacts.getDescription();
            this.pic = contacts.getPic();
            this.logo = contacts.getLogo();
            this.subTitle = contacts.getSubTitle();
            this.id = contacts.getId();
            this.extraData = contacts.getExtraData();
            this.dateline = contacts.getDateline();
            this.lastUpdate = contacts.getLastUpdate();
            this.deprecatedUserAvatar = contacts.getDeprecatedUserAvatar();
            this.deprecatedUserName = contacts.getDeprecatedUserName();
            this.displayUserName = contacts.getDisplayUserName();
            this.uid = contacts.getUid();
            this.followUid = contacts.getFollowUid();
            this.deprecatedFollowUserName = contacts.getDeprecatedFollowUserName();
            this.isFriend = Integer.valueOf(contacts.getIsFriend());
            this.deprecatedFollowerUserAvatar = contacts.getDeprecatedFollowerUserAvatar();
            this.followerUserInfo = contacts.getFollowerUserInfo();
            this.userInfo = contacts.getUserInfo();
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public Contacts.Builder setDeprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public Contacts.Builder setDeprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public Contacts.Builder setDisplayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder, com.coolapk.market.model.IUser.BuilderM1
        public Contacts.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setFollowUid(String str) {
            this.followUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setDeprecatedFollowUserName(String str) {
            this.deprecatedFollowUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setIsFriend(int i) {
            this.isFriend = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setDeprecatedFollowerUserAvatar(String str) {
            this.deprecatedFollowerUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts.Builder setFollowerUserInfo(UserInfo userInfo2) {
            this.followerUserInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder, com.coolapk.market.model.IUser.BuilderM1
        public Contacts.Builder setUserInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.Contacts.Builder
        public Contacts build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.isFriend == null) {
                str = str + " isFriend";
            }
            if (str.isEmpty()) {
                return new AutoValue_Contacts(this.entityTypeName, this.entityType, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.deprecatedUserName, this.displayUserName, this.uid, this.followUid, this.deprecatedFollowUserName, this.isFriend.intValue(), this.deprecatedFollowerUserAvatar, this.followerUserInfo, this.userInfo);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
