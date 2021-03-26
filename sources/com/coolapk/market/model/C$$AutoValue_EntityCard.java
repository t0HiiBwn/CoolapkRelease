package com.coolapk.market.model;

import com.coolapk.market.model.EntityCard;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_EntityCard  reason: invalid class name */
abstract class C$$AutoValue_EntityCard extends EntityCard {
    private final Long dateline;
    private final String description;
    private final List<Entity> entities;
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

    C$$AutoValue_EntityCard(String str, String str2, Integer num, String str3, String str4, String str5, Long l, String str6, String str7, String str8, String str9, List<Entity> list, String str10, Long l2, String str11, String str12) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.logo = str3;
        this.id = str4;
        this.extraData = str5;
        this.dateline = l;
        this.title = str6;
        this.subTitle = str7;
        this.url = str8;
        this.description = str9;
        this.entities = list;
        this.entityTypeName = str10;
        this.lastUpdate = l2;
        Objects.requireNonNull(str11, "Null entityType");
        this.entityType = str11;
        this.pic = str12;
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

    @Override // com.coolapk.market.model.EntityCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.EntityCard, com.coolapk.market.model.Entity
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.EntityCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.EntityCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.EntityCard, com.coolapk.market.model.Card
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override // com.coolapk.market.model.EntityCard, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.EntityCard, com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.EntityCard, com.coolapk.market.model.Entity
    public String getEntityType() {
        return this.entityType;
    }

    @Override // com.coolapk.market.model.EntityCard, com.coolapk.market.model.Entity
    public String getPic() {
        return this.pic;
    }

    @Override // java.lang.Object
    public String toString() {
        return "EntityCard{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", logo=" + this.logo + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", title=" + this.title + ", subTitle=" + this.subTitle + ", url=" + this.url + ", description=" + this.description + ", entities=" + this.entities + ", entityTypeName=" + this.entityTypeName + ", lastUpdate=" + this.lastUpdate + ", entityType=" + this.entityType + ", pic=" + this.pic + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EntityCard)) {
            return false;
        }
        EntityCard entityCard = (EntityCard) obj;
        String str = this.entityTemplate;
        if (str != null ? str.equals(entityCard.getEntityTemplate()) : entityCard.getEntityTemplate() == null) {
            String str2 = this.entityId;
            if (str2 != null ? str2.equals(entityCard.getEntityId()) : entityCard.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(entityCard.getEntityFixed()) : entityCard.getEntityFixed() == null) {
                    String str3 = this.logo;
                    if (str3 != null ? str3.equals(entityCard.getLogo()) : entityCard.getLogo() == null) {
                        String str4 = this.id;
                        if (str4 != null ? str4.equals(entityCard.getId()) : entityCard.getId() == null) {
                            String str5 = this.extraData;
                            if (str5 != null ? str5.equals(entityCard.getExtraData()) : entityCard.getExtraData() == null) {
                                Long l = this.dateline;
                                if (l != null ? l.equals(entityCard.getDateline()) : entityCard.getDateline() == null) {
                                    String str6 = this.title;
                                    if (str6 != null ? str6.equals(entityCard.getTitle()) : entityCard.getTitle() == null) {
                                        String str7 = this.subTitle;
                                        if (str7 != null ? str7.equals(entityCard.getSubTitle()) : entityCard.getSubTitle() == null) {
                                            String str8 = this.url;
                                            if (str8 != null ? str8.equals(entityCard.getUrl()) : entityCard.getUrl() == null) {
                                                String str9 = this.description;
                                                if (str9 != null ? str9.equals(entityCard.getDescription()) : entityCard.getDescription() == null) {
                                                    List<Entity> list = this.entities;
                                                    if (list != null ? list.equals(entityCard.getEntities()) : entityCard.getEntities() == null) {
                                                        String str10 = this.entityTypeName;
                                                        if (str10 != null ? str10.equals(entityCard.getEntityTypeName()) : entityCard.getEntityTypeName() == null) {
                                                            Long l2 = this.lastUpdate;
                                                            if (l2 != null ? l2.equals(entityCard.getLastUpdate()) : entityCard.getLastUpdate() == null) {
                                                                if (this.entityType.equals(entityCard.getEntityType())) {
                                                                    String str11 = this.pic;
                                                                    if (str11 == null) {
                                                                        if (entityCard.getPic() == null) {
                                                                            return true;
                                                                        }
                                                                    } else if (str11.equals(entityCard.getPic())) {
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
        String str3 = this.logo;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.id;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.extraData;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode7 = (hashCode6 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        String str6 = this.title;
        int hashCode8 = (hashCode7 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.subTitle;
        int hashCode9 = (hashCode8 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.url;
        int hashCode10 = (hashCode9 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.description;
        int hashCode11 = (hashCode10 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        List<Entity> list = this.entities;
        int hashCode12 = (hashCode11 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        String str10 = this.entityTypeName;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode14 = (((hashCode13 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ this.entityType.hashCode()) * 1000003;
        String str11 = this.pic;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return hashCode14 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_EntityCard$Builder */
    /* compiled from: $$AutoValue_EntityCard */
    static final class Builder extends EntityCard.Builder {
        private Long dateline;
        private String description;
        private List<Entity> entities;
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

        Builder(EntityCard entityCard) {
            this.entityTemplate = entityCard.getEntityTemplate();
            this.entityId = entityCard.getEntityId();
            this.entityFixed = entityCard.getEntityFixed();
            this.logo = entityCard.getLogo();
            this.id = entityCard.getId();
            this.extraData = entityCard.getExtraData();
            this.dateline = entityCard.getDateline();
            this.title = entityCard.getTitle();
            this.subTitle = entityCard.getSubTitle();
            this.url = entityCard.getUrl();
            this.description = entityCard.getDescription();
            this.entities = entityCard.getEntities();
            this.entityTypeName = entityCard.getEntityTypeName();
            this.lastUpdate = entityCard.getLastUpdate();
            this.entityType = entityCard.getEntityType();
            this.pic = entityCard.getPic();
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setEntities(List<Entity> list) {
            this.entities = list;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.EntityCard.Builder
        public EntityCard build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (str.isEmpty()) {
                return new AutoValue_EntityCard(this.entityTemplate, this.entityId, this.entityFixed, this.logo, this.id, this.extraData, this.dateline, this.title, this.subTitle, this.url, this.description, this.entities, this.entityTypeName, this.lastUpdate, this.entityType, this.pic);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
