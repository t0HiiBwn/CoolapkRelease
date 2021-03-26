package com.coolapk.market.model;

import com.coolapk.market.model.SimpleEntity;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_SimpleEntity  reason: invalid class name */
abstract class C$$AutoValue_SimpleEntity extends SimpleEntity {
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_SimpleEntity(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l2, Long l3) {
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
        this.dateline = l2;
        this.lastUpdate = l3;
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

    @Override // java.lang.Object
    public String toString() {
        return "SimpleEntity{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + "}";
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
        Long l2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SimpleEntity)) {
            return false;
        }
        SimpleEntity simpleEntity = (SimpleEntity) obj;
        String str11 = this.entityTypeName;
        if (str11 != null ? str11.equals(simpleEntity.getEntityTypeName()) : simpleEntity.getEntityTypeName() == null) {
            if (this.entityType.equals(simpleEntity.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(simpleEntity.getEntityTemplate()) : simpleEntity.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(simpleEntity.getEntityId()) : simpleEntity.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(simpleEntity.getEntityFixed()) : simpleEntity.getEntityFixed() == null) && ((str3 = this.title) != null ? str3.equals(simpleEntity.getTitle()) : simpleEntity.getTitle() == null) && ((str4 = this.url) != null ? str4.equals(simpleEntity.getUrl()) : simpleEntity.getUrl() == null) && ((str5 = this.description) != null ? str5.equals(simpleEntity.getDescription()) : simpleEntity.getDescription() == null) && ((str6 = this.pic) != null ? str6.equals(simpleEntity.getPic()) : simpleEntity.getPic() == null) && ((str7 = this.logo) != null ? str7.equals(simpleEntity.getLogo()) : simpleEntity.getLogo() == null) && ((str8 = this.subTitle) != null ? str8.equals(simpleEntity.getSubTitle()) : simpleEntity.getSubTitle() == null) && ((str9 = this.id) != null ? str9.equals(simpleEntity.getId()) : simpleEntity.getId() == null) && ((str10 = this.extraData) != null ? str10.equals(simpleEntity.getExtraData()) : simpleEntity.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(simpleEntity.getDateline()) : simpleEntity.getDateline() == null)) {
                Long l3 = this.lastUpdate;
                if (l3 == null) {
                    if (simpleEntity.getLastUpdate() == null) {
                        return true;
                    }
                } else if (l3.equals(simpleEntity.getLastUpdate())) {
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
        Long l2 = this.dateline;
        int hashCode13 = (hashCode12 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        if (l3 != null) {
            i = l3.hashCode();
        }
        return hashCode13 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_SimpleEntity$Builder */
    /* compiled from: $$AutoValue_SimpleEntity */
    static final class Builder extends SimpleEntity.Builder {
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private String id;
        private Long lastUpdate;
        private String logo;
        private String pic;
        private String subTitle;
        private String title;
        private String url;

        Builder() {
        }

        Builder(SimpleEntity simpleEntity) {
            this.entityTypeName = simpleEntity.getEntityTypeName();
            this.entityType = simpleEntity.getEntityType();
            this.entityTemplate = simpleEntity.getEntityTemplate();
            this.entityId = simpleEntity.getEntityId();
            this.entityFixed = simpleEntity.getEntityFixed();
            this.title = simpleEntity.getTitle();
            this.url = simpleEntity.getUrl();
            this.description = simpleEntity.getDescription();
            this.pic = simpleEntity.getPic();
            this.logo = simpleEntity.getLogo();
            this.subTitle = simpleEntity.getSubTitle();
            this.id = simpleEntity.getId();
            this.extraData = simpleEntity.getExtraData();
            this.dateline = simpleEntity.getDateline();
            this.lastUpdate = simpleEntity.getLastUpdate();
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setDateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity.Builder setLastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.SimpleEntity.Builder
        public SimpleEntity build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (str.isEmpty()) {
                return new AutoValue_SimpleEntity(this.entityTypeName, this.entityType, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
