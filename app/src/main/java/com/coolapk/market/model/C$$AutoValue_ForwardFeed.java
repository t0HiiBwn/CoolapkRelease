package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_ForwardFeed  reason: invalid class name */
abstract class C$$AutoValue_ForwardFeed extends ForwardFeed {
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String message;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_ForwardFeed(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, UserInfo userInfo2, String str11, String str12) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.url = str5;
        this.description = str6;
        this.pic = str7;
        this.logo = str8;
        this.subTitle = str9;
        this.extraData = str10;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.userInfo = userInfo2;
        Objects.requireNonNull(str11, "Null message");
        this.message = str11;
        Objects.requireNonNull(str12, "Null id");
        this.id = str12;
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

    @Override // com.coolapk.market.model.ForwardFeed
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.ForwardFeed
    public String getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.ForwardFeed, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ForwardFeed{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", userInfo=" + this.userInfo + ", message=" + this.message + ", id=" + this.id + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ForwardFeed)) {
            return false;
        }
        ForwardFeed forwardFeed = (ForwardFeed) obj;
        String str = this.entityTypeName;
        if (str != null ? str.equals(forwardFeed.getEntityTypeName()) : forwardFeed.getEntityTypeName() == null) {
            String str2 = this.entityTemplate;
            if (str2 != null ? str2.equals(forwardFeed.getEntityTemplate()) : forwardFeed.getEntityTemplate() == null) {
                String str3 = this.entityId;
                if (str3 != null ? str3.equals(forwardFeed.getEntityId()) : forwardFeed.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(forwardFeed.getEntityFixed()) : forwardFeed.getEntityFixed() == null) {
                        String str4 = this.title;
                        if (str4 != null ? str4.equals(forwardFeed.getTitle()) : forwardFeed.getTitle() == null) {
                            String str5 = this.url;
                            if (str5 != null ? str5.equals(forwardFeed.getUrl()) : forwardFeed.getUrl() == null) {
                                String str6 = this.description;
                                if (str6 != null ? str6.equals(forwardFeed.getDescription()) : forwardFeed.getDescription() == null) {
                                    String str7 = this.pic;
                                    if (str7 != null ? str7.equals(forwardFeed.getPic()) : forwardFeed.getPic() == null) {
                                        String str8 = this.logo;
                                        if (str8 != null ? str8.equals(forwardFeed.getLogo()) : forwardFeed.getLogo() == null) {
                                            String str9 = this.subTitle;
                                            if (str9 != null ? str9.equals(forwardFeed.getSubTitle()) : forwardFeed.getSubTitle() == null) {
                                                String str10 = this.extraData;
                                                if (str10 != null ? str10.equals(forwardFeed.getExtraData()) : forwardFeed.getExtraData() == null) {
                                                    Long l2 = this.dateline;
                                                    if (l2 != null ? l2.equals(forwardFeed.getDateline()) : forwardFeed.getDateline() == null) {
                                                        Long l3 = this.lastUpdate;
                                                        if (l3 != null ? l3.equals(forwardFeed.getLastUpdate()) : forwardFeed.getLastUpdate() == null) {
                                                            UserInfo userInfo2 = this.userInfo;
                                                            if (userInfo2 != null ? userInfo2.equals(forwardFeed.getUserInfo()) : forwardFeed.getUserInfo() == null) {
                                                                if (this.message.equals(forwardFeed.getMessage()) && this.id.equals(forwardFeed.getId())) {
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
        String str10 = this.extraData;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode12 = (hashCode11 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode13 = (hashCode12 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        if (userInfo2 != null) {
            i = userInfo2.hashCode();
        }
        return ((((hashCode13 ^ i) * 1000003) ^ this.message.hashCode()) * 1000003) ^ this.id.hashCode();
    }
}
