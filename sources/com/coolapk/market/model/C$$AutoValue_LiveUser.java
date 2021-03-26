package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_LiveUser  reason: invalid class name */
abstract class C$$AutoValue_LiveUser extends LiveUser {
    private final Long dateline;
    private final String description;
    private final int disallowPost;
    private final int disallowPostPic;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String liveId;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final String userAvatar;
    private final User userInfo;

    C$$AutoValue_LiveUser(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l, Long l2, String str13, String str14, String str15, int i2, int i3, User user) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityTypeId = i;
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
        Objects.requireNonNull(str13, "Null liveId");
        this.liveId = str13;
        Objects.requireNonNull(str14, "Null uid");
        this.uid = str14;
        Objects.requireNonNull(str15, "Null userAvatar");
        this.userAvatar = str15;
        this.disallowPost = i2;
        this.disallowPostPic = i3;
        Objects.requireNonNull(user, "Null userInfo");
        this.userInfo = user;
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

    @Override // com.coolapk.market.model.LiveUser
    @SerializedName("live_id")
    public String getLiveId() {
        return this.liveId;
    }

    @Override // com.coolapk.market.model.LiveUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.LiveUser
    public String getUserAvatar() {
        return this.userAvatar;
    }

    @Override // com.coolapk.market.model.LiveUser
    @SerializedName("disallow_post")
    protected int getDisallowPost() {
        return this.disallowPost;
    }

    @Override // com.coolapk.market.model.LiveUser
    @SerializedName("disallow_post_pic")
    protected int getDisallowPostPic() {
        return this.disallowPostPic;
    }

    @Override // com.coolapk.market.model.LiveUser
    public User getUserInfo() {
        return this.userInfo;
    }

    @Override // java.lang.Object
    public String toString() {
        return "LiveUser{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", liveId=" + this.liveId + ", uid=" + this.uid + ", userAvatar=" + this.userAvatar + ", disallowPost=" + this.disallowPost + ", disallowPostPic=" + this.disallowPostPic + ", userInfo=" + this.userInfo + "}";
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiveUser)) {
            return false;
        }
        LiveUser liveUser = (LiveUser) obj;
        String str11 = this.entityTypeName;
        if (str11 != null ? str11.equals(liveUser.getEntityTypeName()) : liveUser.getEntityTypeName() == null) {
            if (this.entityType.equals(liveUser.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(liveUser.getEntityTemplate()) : liveUser.getEntityTemplate() == null) && this.entityTypeId == liveUser.getEntityTypeId() && ((str2 = this.entityId) != null ? str2.equals(liveUser.getEntityId()) : liveUser.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(liveUser.getEntityFixed()) : liveUser.getEntityFixed() == null) && ((str3 = this.title) != null ? str3.equals(liveUser.getTitle()) : liveUser.getTitle() == null) && ((str4 = this.url) != null ? str4.equals(liveUser.getUrl()) : liveUser.getUrl() == null) && ((str5 = this.description) != null ? str5.equals(liveUser.getDescription()) : liveUser.getDescription() == null) && ((str6 = this.pic) != null ? str6.equals(liveUser.getPic()) : liveUser.getPic() == null) && ((str7 = this.logo) != null ? str7.equals(liveUser.getLogo()) : liveUser.getLogo() == null) && ((str8 = this.subTitle) != null ? str8.equals(liveUser.getSubTitle()) : liveUser.getSubTitle() == null) && ((str9 = this.id) != null ? str9.equals(liveUser.getId()) : liveUser.getId() == null) && ((str10 = this.extraData) != null ? str10.equals(liveUser.getExtraData()) : liveUser.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(liveUser.getDateline()) : liveUser.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(liveUser.getLastUpdate()) : liveUser.getLastUpdate() == null) && this.liveId.equals(liveUser.getLiveId()) && this.uid.equals(liveUser.getUid()) && this.userAvatar.equals(liveUser.getUserAvatar()) && this.disallowPost == liveUser.getDisallowPost() && this.disallowPostPic == liveUser.getDisallowPostPic() && this.userInfo.equals(liveUser.getUserInfo())) {
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
        int hashCode2 = (((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.entityTypeId) * 1000003;
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
        if (l2 != null) {
            i = l2.hashCode();
        }
        return ((((((((((((hashCode13 ^ i) * 1000003) ^ this.liveId.hashCode()) * 1000003) ^ this.uid.hashCode()) * 1000003) ^ this.userAvatar.hashCode()) * 1000003) ^ this.disallowPost) * 1000003) ^ this.disallowPostPic) * 1000003) ^ this.userInfo.hashCode();
    }
}
