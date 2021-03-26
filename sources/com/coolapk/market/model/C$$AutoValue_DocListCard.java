package com.coolapk.market.model;

import com.coolapk.market.model.DocListCard;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_DocListCard  reason: invalid class name */
abstract class C$$AutoValue_DocListCard extends DocListCard {
    private final Long dateline;
    private final String description;
    private final List<Entity> entities;
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

    C$$AutoValue_DocListCard(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, Long l, Long l2, String str8, String str9, String str10, String str11, List<Entity> list) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.pic = str3;
        this.logo = str4;
        this.subTitle = str5;
        this.id = str6;
        this.extraData = str7;
        this.dateline = l;
        this.lastUpdate = l2;
        this.title = str8;
        this.url = str9;
        this.description = str10;
        this.entityTypeName = str11;
        Objects.requireNonNull(list, "Null entities");
        this.entities = list;
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

    @Override // com.coolapk.market.model.DocListCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.DocListCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.DocListCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.DocListCard, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.DocListCard, com.coolapk.market.model.Card
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DocListCard{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", entityTypeName=" + this.entityTypeName + ", entities=" + this.entities + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DocListCard)) {
            return false;
        }
        DocListCard docListCard = (DocListCard) obj;
        String str = this.entityTemplate;
        if (str != null ? str.equals(docListCard.getEntityTemplate()) : docListCard.getEntityTemplate() == null) {
            String str2 = this.entityId;
            if (str2 != null ? str2.equals(docListCard.getEntityId()) : docListCard.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(docListCard.getEntityFixed()) : docListCard.getEntityFixed() == null) {
                    String str3 = this.pic;
                    if (str3 != null ? str3.equals(docListCard.getPic()) : docListCard.getPic() == null) {
                        String str4 = this.logo;
                        if (str4 != null ? str4.equals(docListCard.getLogo()) : docListCard.getLogo() == null) {
                            String str5 = this.subTitle;
                            if (str5 != null ? str5.equals(docListCard.getSubTitle()) : docListCard.getSubTitle() == null) {
                                String str6 = this.id;
                                if (str6 != null ? str6.equals(docListCard.getId()) : docListCard.getId() == null) {
                                    String str7 = this.extraData;
                                    if (str7 != null ? str7.equals(docListCard.getExtraData()) : docListCard.getExtraData() == null) {
                                        Long l = this.dateline;
                                        if (l != null ? l.equals(docListCard.getDateline()) : docListCard.getDateline() == null) {
                                            Long l2 = this.lastUpdate;
                                            if (l2 != null ? l2.equals(docListCard.getLastUpdate()) : docListCard.getLastUpdate() == null) {
                                                String str8 = this.title;
                                                if (str8 != null ? str8.equals(docListCard.getTitle()) : docListCard.getTitle() == null) {
                                                    String str9 = this.url;
                                                    if (str9 != null ? str9.equals(docListCard.getUrl()) : docListCard.getUrl() == null) {
                                                        String str10 = this.description;
                                                        if (str10 != null ? str10.equals(docListCard.getDescription()) : docListCard.getDescription() == null) {
                                                            String str11 = this.entityTypeName;
                                                            if (str11 != null ? str11.equals(docListCard.getEntityTypeName()) : docListCard.getEntityTypeName() == null) {
                                                                if (this.entities.equals(docListCard.getEntities())) {
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
        String str = this.entityTemplate;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityId;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode3 = (hashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str3 = this.pic;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.logo;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.subTitle;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.id;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.extraData;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode9 = (hashCode8 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode10 = (hashCode9 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str8 = this.title;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.url;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.description;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.entityTypeName;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return ((hashCode13 ^ i) * 1000003) ^ this.entities.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_DocListCard$Builder */
    /* compiled from: $$AutoValue_DocListCard */
    static final class Builder extends DocListCard.Builder {
        private Long dateline;
        private String description;
        private List<Entity> entities;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
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

        Builder(DocListCard docListCard) {
            this.entityTemplate = docListCard.getEntityTemplate();
            this.entityId = docListCard.getEntityId();
            this.entityFixed = docListCard.getEntityFixed();
            this.pic = docListCard.getPic();
            this.logo = docListCard.getLogo();
            this.subTitle = docListCard.getSubTitle();
            this.id = docListCard.getId();
            this.extraData = docListCard.getExtraData();
            this.dateline = docListCard.getDateline();
            this.lastUpdate = docListCard.getLastUpdate();
            this.title = docListCard.getTitle();
            this.url = docListCard.getUrl();
            this.description = docListCard.getDescription();
            this.entityTypeName = docListCard.getEntityTypeName();
            this.entities = docListCard.getEntities();
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard.Builder setEntities(List<Entity> list) {
            this.entities = list;
            return this;
        }

        @Override // com.coolapk.market.model.DocListCard.Builder
        public DocListCard build() {
            String str = "";
            if (this.entities == null) {
                str = str + " entities";
            }
            if (str.isEmpty()) {
                return new AutoValue_DocListCard(this.entityTemplate, this.entityId, this.entityFixed, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.title, this.url, this.description, this.entityTypeName, this.entities);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
