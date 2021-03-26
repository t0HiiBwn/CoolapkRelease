package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Favorite  reason: invalid class name */
abstract class C$$AutoValue_Favorite extends Favorite {
    private final String content;
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
    private final String extra;
    private final String extraData;
    private final String id;
    private final int isEdit;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String tag;
    private final List<String> tagList;
    private final String targetId;
    private final String targetKey;
    private final String targetType;
    private final String targetUid;
    private final String targetUserAvatar;
    private final String targetUserName;
    private final String title;
    private final String uid;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_Favorite(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Long l2, Long l3, String str8, UserInfo userInfo2, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, int i, List<String> list) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
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
        Objects.requireNonNull(str12, "Null uid");
        this.uid = str12;
        Objects.requireNonNull(str13, "Null targetType");
        this.targetType = str13;
        this.targetId = str14;
        this.targetUid = str15;
        this.targetUserName = str16;
        this.targetUserAvatar = str17;
        this.targetKey = str18;
        this.description = str19;
        this.pic = str20;
        this.url = str21;
        this.content = str22;
        this.title = str23;
        Objects.requireNonNull(str24, "Null extra");
        this.extra = str24;
        Objects.requireNonNull(str25, "Null tag");
        this.tag = str25;
        this.isEdit = i;
        Objects.requireNonNull(list, "Null tagList");
        this.tagList = list;
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

    @Override // com.coolapk.market.model.Favorite, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Favorite, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.Favorite
    public String getTargetType() {
        return this.targetType;
    }

    @Override // com.coolapk.market.model.Favorite
    public String getTargetId() {
        return this.targetId;
    }

    @Override // com.coolapk.market.model.Favorite
    public String getTargetUid() {
        return this.targetUid;
    }

    @Override // com.coolapk.market.model.Favorite
    @SerializedName("targetUsername")
    public String getTargetUserName() {
        return this.targetUserName;
    }

    @Override // com.coolapk.market.model.Favorite
    @SerializedName("targetAvatar")
    public String getTargetUserAvatar() {
        return this.targetUserAvatar;
    }

    @Override // com.coolapk.market.model.Favorite
    public String getTargetKey() {
        return this.targetKey;
    }

    @Override // com.coolapk.market.model.Favorite, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Favorite, com.coolapk.market.model.Entity
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Favorite, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Favorite
    public String getContent() {
        return this.content;
    }

    @Override // com.coolapk.market.model.Favorite, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Favorite
    public String getExtra() {
        return this.extra;
    }

    @Override // com.coolapk.market.model.Favorite
    public String getTag() {
        return this.tag;
    }

    @Override // com.coolapk.market.model.Favorite
    public int getIsEdit() {
        return this.isEdit;
    }

    @Override // com.coolapk.market.model.Favorite
    @SerializedName("tags")
    public List<String> getTagList() {
        return this.tagList;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Favorite{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", id=" + this.id + ", uid=" + this.uid + ", targetType=" + this.targetType + ", targetId=" + this.targetId + ", targetUid=" + this.targetUid + ", targetUserName=" + this.targetUserName + ", targetUserAvatar=" + this.targetUserAvatar + ", targetKey=" + this.targetKey + ", description=" + this.description + ", pic=" + this.pic + ", url=" + this.url + ", content=" + this.content + ", title=" + this.title + ", extra=" + this.extra + ", tag=" + this.tag + ", isEdit=" + this.isEdit + ", tagList=" + this.tagList + "}";
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Favorite)) {
            return false;
        }
        Favorite favorite = (Favorite) obj;
        String str19 = this.entityTypeName;
        if (str19 != null ? str19.equals(favorite.getEntityTypeName()) : favorite.getEntityTypeName() == null) {
            if (this.entityType.equals(favorite.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(favorite.getEntityTemplate()) : favorite.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(favorite.getEntityId()) : favorite.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(favorite.getEntityFixed()) : favorite.getEntityFixed() == null) && ((str3 = this.logo) != null ? str3.equals(favorite.getLogo()) : favorite.getLogo() == null) && ((str4 = this.subTitle) != null ? str4.equals(favorite.getSubTitle()) : favorite.getSubTitle() == null) && ((str5 = this.extraData) != null ? str5.equals(favorite.getExtraData()) : favorite.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(favorite.getDateline()) : favorite.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(favorite.getLastUpdate()) : favorite.getLastUpdate() == null) && ((str6 = this.deprecatedUserAvatar) != null ? str6.equals(favorite.getDeprecatedUserAvatar()) : favorite.getDeprecatedUserAvatar() == null) && ((userInfo2 = this.userInfo) != null ? userInfo2.equals(favorite.getUserInfo()) : favorite.getUserInfo() == null) && ((str7 = this.deprecatedUserName) != null ? str7.equals(favorite.getDeprecatedUserName()) : favorite.getDeprecatedUserName() == null) && ((str8 = this.displayUserName) != null ? str8.equals(favorite.getDisplayUserName()) : favorite.getDisplayUserName() == null) && this.id.equals(favorite.getId()) && this.uid.equals(favorite.getUid()) && this.targetType.equals(favorite.getTargetType()) && ((str9 = this.targetId) != null ? str9.equals(favorite.getTargetId()) : favorite.getTargetId() == null) && ((str10 = this.targetUid) != null ? str10.equals(favorite.getTargetUid()) : favorite.getTargetUid() == null) && ((str11 = this.targetUserName) != null ? str11.equals(favorite.getTargetUserName()) : favorite.getTargetUserName() == null) && ((str12 = this.targetUserAvatar) != null ? str12.equals(favorite.getTargetUserAvatar()) : favorite.getTargetUserAvatar() == null) && ((str13 = this.targetKey) != null ? str13.equals(favorite.getTargetKey()) : favorite.getTargetKey() == null) && ((str14 = this.description) != null ? str14.equals(favorite.getDescription()) : favorite.getDescription() == null) && ((str15 = this.pic) != null ? str15.equals(favorite.getPic()) : favorite.getPic() == null) && ((str16 = this.url) != null ? str16.equals(favorite.getUrl()) : favorite.getUrl() == null) && ((str17 = this.content) != null ? str17.equals(favorite.getContent()) : favorite.getContent() == null) && ((str18 = this.title) != null ? str18.equals(favorite.getTitle()) : favorite.getTitle() == null) && this.extra.equals(favorite.getExtra()) && this.tag.equals(favorite.getTag()) && this.isEdit == favorite.getIsEdit() && this.tagList.equals(favorite.getTagList())) {
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
        int hashCode13 = (((((((hashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.uid.hashCode()) * 1000003) ^ this.targetType.hashCode()) * 1000003;
        String str10 = this.targetId;
        int hashCode14 = (hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.targetUid;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.targetUserName;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.targetUserAvatar;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.targetKey;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.description;
        int hashCode19 = (hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.pic;
        int hashCode20 = (hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.url;
        int hashCode21 = (hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.content;
        int hashCode22 = (hashCode21 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.title;
        if (str19 != null) {
            i = str19.hashCode();
        }
        return ((((((((hashCode22 ^ i) * 1000003) ^ this.extra.hashCode()) * 1000003) ^ this.tag.hashCode()) * 1000003) ^ this.isEdit) * 1000003) ^ this.tagList.hashCode();
    }
}
