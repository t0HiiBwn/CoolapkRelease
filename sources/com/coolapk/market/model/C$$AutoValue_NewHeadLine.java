package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_NewHeadLine  reason: invalid class name */
abstract class C$$AutoValue_NewHeadLine extends NewHeadLine {
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
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_NewHeadLine(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, Long l2, Long l3, String str8, String str9, String str10, String str11) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.description = str3;
        this.pic = str4;
        this.subTitle = str5;
        this.id = str6;
        this.extraData = str7;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.logo = str8;
        this.url = str9;
        Objects.requireNonNull(str10, "Null title");
        this.title = str10;
        Objects.requireNonNull(str11, "Null entityTypeName");
        this.entityTypeName = str11;
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

    @Override // com.coolapk.market.model.NewHeadLine, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.NewHeadLine, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.NewHeadLine, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.NewHeadLine, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // java.lang.Object
    public String toString() {
        return "NewHeadLine{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", description=" + this.description + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", logo=" + this.logo + ", url=" + this.url + ", title=" + this.title + ", entityTypeName=" + this.entityTypeName + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewHeadLine)) {
            return false;
        }
        NewHeadLine newHeadLine = (NewHeadLine) obj;
        String str = this.entityTemplate;
        if (str != null ? str.equals(newHeadLine.getEntityTemplate()) : newHeadLine.getEntityTemplate() == null) {
            String str2 = this.entityId;
            if (str2 != null ? str2.equals(newHeadLine.getEntityId()) : newHeadLine.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(newHeadLine.getEntityFixed()) : newHeadLine.getEntityFixed() == null) {
                    String str3 = this.description;
                    if (str3 != null ? str3.equals(newHeadLine.getDescription()) : newHeadLine.getDescription() == null) {
                        String str4 = this.pic;
                        if (str4 != null ? str4.equals(newHeadLine.getPic()) : newHeadLine.getPic() == null) {
                            String str5 = this.subTitle;
                            if (str5 != null ? str5.equals(newHeadLine.getSubTitle()) : newHeadLine.getSubTitle() == null) {
                                String str6 = this.id;
                                if (str6 != null ? str6.equals(newHeadLine.getId()) : newHeadLine.getId() == null) {
                                    String str7 = this.extraData;
                                    if (str7 != null ? str7.equals(newHeadLine.getExtraData()) : newHeadLine.getExtraData() == null) {
                                        Long l2 = this.dateline;
                                        if (l2 != null ? l2.equals(newHeadLine.getDateline()) : newHeadLine.getDateline() == null) {
                                            Long l3 = this.lastUpdate;
                                            if (l3 != null ? l3.equals(newHeadLine.getLastUpdate()) : newHeadLine.getLastUpdate() == null) {
                                                String str8 = this.logo;
                                                if (str8 != null ? str8.equals(newHeadLine.getLogo()) : newHeadLine.getLogo() == null) {
                                                    String str9 = this.url;
                                                    if (str9 != null ? str9.equals(newHeadLine.getUrl()) : newHeadLine.getUrl() == null) {
                                                        if (this.title.equals(newHeadLine.getTitle()) && this.entityTypeName.equals(newHeadLine.getEntityTypeName())) {
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
        String str3 = this.description;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.pic;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.subTitle;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.id;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.extraData;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode9 = (hashCode8 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode10 = (hashCode9 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str8 = this.logo;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.url;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return ((((hashCode11 ^ i) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.entityTypeName.hashCode();
    }
}
