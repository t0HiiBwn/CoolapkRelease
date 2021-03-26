package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_UserHistory  reason: invalid class name */
abstract class C$$AutoValue_UserHistory extends UserHistory {
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String historyType;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String typeName;
    private final String url;

    C$$AutoValue_UserHistory(String str, String str2, Integer num, String str3, String str4, String str5, Long l, Long l2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.pic = str3;
        this.subTitle = str4;
        this.extraData = str5;
        this.dateline = l;
        this.lastUpdate = l2;
        Objects.requireNonNull(str6, "Null id");
        this.id = str6;
        this.logo = str7;
        this.description = str8;
        Objects.requireNonNull(str9, "Null historyType");
        this.historyType = str9;
        this.url = str10;
        this.typeName = str11;
        this.title = str12;
        this.entityTypeName = str13;
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

    @Override // com.coolapk.market.model.UserHistory, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.UserHistory, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.UserHistory, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.UserHistory
    public String getHistoryType() {
        return this.historyType;
    }

    @Override // com.coolapk.market.model.UserHistory, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.UserHistory
    public String getTypeName() {
        return this.typeName;
    }

    @Override // com.coolapk.market.model.UserHistory, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.UserHistory, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // java.lang.Object
    public String toString() {
        return "UserHistory{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", logo=" + this.logo + ", description=" + this.description + ", historyType=" + this.historyType + ", url=" + this.url + ", typeName=" + this.typeName + ", title=" + this.title + ", entityTypeName=" + this.entityTypeName + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserHistory)) {
            return false;
        }
        UserHistory userHistory = (UserHistory) obj;
        String str6 = this.entityTemplate;
        if (str6 != null ? str6.equals(userHistory.getEntityTemplate()) : userHistory.getEntityTemplate() == null) {
            String str7 = this.entityId;
            if (str7 != null ? str7.equals(userHistory.getEntityId()) : userHistory.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(userHistory.getEntityFixed()) : userHistory.getEntityFixed() == null) {
                    String str8 = this.pic;
                    if (str8 != null ? str8.equals(userHistory.getPic()) : userHistory.getPic() == null) {
                        String str9 = this.subTitle;
                        if (str9 != null ? str9.equals(userHistory.getSubTitle()) : userHistory.getSubTitle() == null) {
                            String str10 = this.extraData;
                            if (str10 != null ? str10.equals(userHistory.getExtraData()) : userHistory.getExtraData() == null) {
                                Long l = this.dateline;
                                if (l != null ? l.equals(userHistory.getDateline()) : userHistory.getDateline() == null) {
                                    Long l2 = this.lastUpdate;
                                    if (l2 != null ? l2.equals(userHistory.getLastUpdate()) : userHistory.getLastUpdate() == null) {
                                        if (this.id.equals(userHistory.getId()) && ((str = this.logo) != null ? str.equals(userHistory.getLogo()) : userHistory.getLogo() == null) && ((str2 = this.description) != null ? str2.equals(userHistory.getDescription()) : userHistory.getDescription() == null) && this.historyType.equals(userHistory.getHistoryType()) && ((str3 = this.url) != null ? str3.equals(userHistory.getUrl()) : userHistory.getUrl() == null) && ((str4 = this.typeName) != null ? str4.equals(userHistory.getTypeName()) : userHistory.getTypeName() == null) && ((str5 = this.title) != null ? str5.equals(userHistory.getTitle()) : userHistory.getTitle() == null)) {
                                            String str11 = this.entityTypeName;
                                            if (str11 == null) {
                                                if (userHistory.getEntityTypeName() == null) {
                                                    return true;
                                                }
                                            } else if (str11.equals(userHistory.getEntityTypeName())) {
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
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTemplate;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityId;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode3 = (hashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str3 = this.pic;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.subTitle;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.extraData;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode7 = (hashCode6 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode8 = (((hashCode7 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003;
        String str6 = this.logo;
        int hashCode9 = (hashCode8 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.description;
        int hashCode10 = (((hashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003) ^ this.historyType.hashCode()) * 1000003;
        String str8 = this.url;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.typeName;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.title;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.entityTypeName;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return hashCode13 ^ i;
    }
}
