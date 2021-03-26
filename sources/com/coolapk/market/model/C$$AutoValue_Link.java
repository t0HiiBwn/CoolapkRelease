package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Link  reason: invalid class name */
abstract class C$$AutoValue_Link extends Link {
    private final String color;
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

    C$$AutoValue_Link(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, String str10, String str11, String str12) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.description = str4;
        this.pic = str5;
        this.logo = str6;
        this.id = str7;
        this.extraData = str8;
        this.dateline = l2;
        this.lastUpdate = l3;
        Objects.requireNonNull(str9, "Null title");
        this.title = str9;
        this.subTitle = str10;
        Objects.requireNonNull(str11, "Null url");
        this.url = str11;
        this.color = str12;
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

    @Override // com.coolapk.market.model.Link, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Link, com.coolapk.market.model.Entity
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Link, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Link
    public String getColor() {
        return this.color;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Link{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", title=" + this.title + ", subTitle=" + this.subTitle + ", url=" + this.url + ", color=" + this.color + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Link)) {
            return false;
        }
        Link link = (Link) obj;
        String str2 = this.entityTypeName;
        if (str2 != null ? str2.equals(link.getEntityTypeName()) : link.getEntityTypeName() == null) {
            String str3 = this.entityTemplate;
            if (str3 != null ? str3.equals(link.getEntityTemplate()) : link.getEntityTemplate() == null) {
                String str4 = this.entityId;
                if (str4 != null ? str4.equals(link.getEntityId()) : link.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(link.getEntityFixed()) : link.getEntityFixed() == null) {
                        String str5 = this.description;
                        if (str5 != null ? str5.equals(link.getDescription()) : link.getDescription() == null) {
                            String str6 = this.pic;
                            if (str6 != null ? str6.equals(link.getPic()) : link.getPic() == null) {
                                String str7 = this.logo;
                                if (str7 != null ? str7.equals(link.getLogo()) : link.getLogo() == null) {
                                    String str8 = this.id;
                                    if (str8 != null ? str8.equals(link.getId()) : link.getId() == null) {
                                        String str9 = this.extraData;
                                        if (str9 != null ? str9.equals(link.getExtraData()) : link.getExtraData() == null) {
                                            Long l2 = this.dateline;
                                            if (l2 != null ? l2.equals(link.getDateline()) : link.getDateline() == null) {
                                                Long l3 = this.lastUpdate;
                                                if (l3 != null ? l3.equals(link.getLastUpdate()) : link.getLastUpdate() == null) {
                                                    if (this.title.equals(link.getTitle()) && ((str = this.subTitle) != null ? str.equals(link.getSubTitle()) : link.getSubTitle() == null) && this.url.equals(link.getUrl())) {
                                                        String str10 = this.color;
                                                        if (str10 == null) {
                                                            if (link.getColor() == null) {
                                                                return true;
                                                            }
                                                        } else if (str10.equals(link.getColor())) {
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
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.description;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.pic;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.logo;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.id;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.extraData;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode10 = (hashCode9 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode11 = (((hashCode10 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003) ^ this.title.hashCode()) * 1000003;
        String str9 = this.subTitle;
        int hashCode12 = (((hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003) ^ this.url.hashCode()) * 1000003;
        String str10 = this.color;
        if (str10 != null) {
            i = str10.hashCode();
        }
        return hashCode12 ^ i;
    }
}
