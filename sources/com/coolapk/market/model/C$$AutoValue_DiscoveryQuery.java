package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_DiscoveryQuery  reason: invalid class name */
abstract class C$$AutoValue_DiscoveryQuery extends DiscoveryQuery {
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final String introduce;
    private final Long lastUpdate;
    private final String logo;
    private final String packageName;
    private final String pic;
    private final String query;
    private final String reference;
    private final List<String> screenShotList;
    private final String sourceName;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_DiscoveryQuery(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, String str10, String str11, String str12, String str13, List<String> list, String str14, String str15, String str16) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.url = str3;
        this.description = str4;
        this.pic = str5;
        this.subTitle = str6;
        this.id = str7;
        this.extraData = str8;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.entityTypeName = str9;
        this.title = str10;
        this.logo = str11;
        this.introduce = str12;
        Objects.requireNonNull(str13, "Null packageName");
        this.packageName = str13;
        Objects.requireNonNull(list, "Null screenShotList");
        this.screenShotList = list;
        Objects.requireNonNull(str14, "Null sourceName");
        this.sourceName = str14;
        Objects.requireNonNull(str15, "Null query");
        this.query = str15;
        this.reference = str16;
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

    @Override // com.coolapk.market.model.DiscoveryQuery, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.DiscoveryQuery, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.DiscoveryQuery, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.DiscoveryQuery
    @SerializedName("intro")
    public String getIntroduce() {
        return this.introduce;
    }

    @Override // com.coolapk.market.model.DiscoveryQuery
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.DiscoveryQuery
    @SerializedName("screenshotsArr")
    public List<String> getScreenShotList() {
        return this.screenShotList;
    }

    @Override // com.coolapk.market.model.DiscoveryQuery
    public String getSourceName() {
        return this.sourceName;
    }

    @Override // com.coolapk.market.model.DiscoveryQuery
    public String getQuery() {
        return this.query;
    }

    @Override // com.coolapk.market.model.DiscoveryQuery
    @SerializedName("referer")
    public String getReference() {
        return this.reference;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DiscoveryQuery{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", entityTypeName=" + this.entityTypeName + ", title=" + this.title + ", logo=" + this.logo + ", introduce=" + this.introduce + ", packageName=" + this.packageName + ", screenShotList=" + this.screenShotList + ", sourceName=" + this.sourceName + ", query=" + this.query + ", reference=" + this.reference + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DiscoveryQuery)) {
            return false;
        }
        DiscoveryQuery discoveryQuery = (DiscoveryQuery) obj;
        String str = this.entityTemplate;
        if (str != null ? str.equals(discoveryQuery.getEntityTemplate()) : discoveryQuery.getEntityTemplate() == null) {
            String str2 = this.entityId;
            if (str2 != null ? str2.equals(discoveryQuery.getEntityId()) : discoveryQuery.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(discoveryQuery.getEntityFixed()) : discoveryQuery.getEntityFixed() == null) {
                    String str3 = this.url;
                    if (str3 != null ? str3.equals(discoveryQuery.getUrl()) : discoveryQuery.getUrl() == null) {
                        String str4 = this.description;
                        if (str4 != null ? str4.equals(discoveryQuery.getDescription()) : discoveryQuery.getDescription() == null) {
                            String str5 = this.pic;
                            if (str5 != null ? str5.equals(discoveryQuery.getPic()) : discoveryQuery.getPic() == null) {
                                String str6 = this.subTitle;
                                if (str6 != null ? str6.equals(discoveryQuery.getSubTitle()) : discoveryQuery.getSubTitle() == null) {
                                    String str7 = this.id;
                                    if (str7 != null ? str7.equals(discoveryQuery.getId()) : discoveryQuery.getId() == null) {
                                        String str8 = this.extraData;
                                        if (str8 != null ? str8.equals(discoveryQuery.getExtraData()) : discoveryQuery.getExtraData() == null) {
                                            Long l2 = this.dateline;
                                            if (l2 != null ? l2.equals(discoveryQuery.getDateline()) : discoveryQuery.getDateline() == null) {
                                                Long l3 = this.lastUpdate;
                                                if (l3 != null ? l3.equals(discoveryQuery.getLastUpdate()) : discoveryQuery.getLastUpdate() == null) {
                                                    String str9 = this.entityTypeName;
                                                    if (str9 != null ? str9.equals(discoveryQuery.getEntityTypeName()) : discoveryQuery.getEntityTypeName() == null) {
                                                        String str10 = this.title;
                                                        if (str10 != null ? str10.equals(discoveryQuery.getTitle()) : discoveryQuery.getTitle() == null) {
                                                            String str11 = this.logo;
                                                            if (str11 != null ? str11.equals(discoveryQuery.getLogo()) : discoveryQuery.getLogo() == null) {
                                                                String str12 = this.introduce;
                                                                if (str12 != null ? str12.equals(discoveryQuery.getIntroduce()) : discoveryQuery.getIntroduce() == null) {
                                                                    if (this.packageName.equals(discoveryQuery.getPackageName()) && this.screenShotList.equals(discoveryQuery.getScreenShotList()) && this.sourceName.equals(discoveryQuery.getSourceName()) && this.query.equals(discoveryQuery.getQuery())) {
                                                                        String str13 = this.reference;
                                                                        if (str13 == null) {
                                                                            if (discoveryQuery.getReference() == null) {
                                                                                return true;
                                                                            }
                                                                        } else if (str13.equals(discoveryQuery.getReference())) {
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
        String str3 = this.url;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.description;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.pic;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.subTitle;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.id;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.extraData;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode10 = (hashCode9 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode11 = (hashCode10 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str9 = this.entityTypeName;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.title;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.logo;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.introduce;
        int hashCode15 = (((((((((hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003) ^ this.packageName.hashCode()) * 1000003) ^ this.screenShotList.hashCode()) * 1000003) ^ this.sourceName.hashCode()) * 1000003) ^ this.query.hashCode()) * 1000003;
        String str13 = this.reference;
        if (str13 != null) {
            i = str13.hashCode();
        }
        return hashCode15 ^ i;
    }
}
