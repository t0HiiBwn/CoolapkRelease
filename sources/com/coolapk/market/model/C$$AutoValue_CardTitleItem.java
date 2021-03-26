package com.coolapk.market.model;

import com.coolapk.market.model.CardTitleItem;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_CardTitleItem  reason: invalid class name */
abstract class C$$AutoValue_CardTitleItem extends CardTitleItem {
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
    private final int pageVisibility;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_CardTitleItem(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, int i) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.url = str4;
        this.description = str5;
        this.pic = str6;
        this.logo = str7;
        this.subTitle = str8;
        this.id = str9;
        this.extraData = str10;
        this.dateline = l;
        this.lastUpdate = l2;
        Objects.requireNonNull(str11, "Null title");
        this.title = str11;
        this.pageVisibility = i;
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

    @Override // com.coolapk.market.model.CardTitleItem, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.CardTitleItem
    @SerializedName("page_visibility")
    public int getPageVisibility() {
        return this.pageVisibility;
    }

    @Override // java.lang.Object
    public String toString() {
        return "CardTitleItem{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", title=" + this.title + ", pageVisibility=" + this.pageVisibility + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardTitleItem)) {
            return false;
        }
        CardTitleItem cardTitleItem = (CardTitleItem) obj;
        String str = this.entityTypeName;
        if (str != null ? str.equals(cardTitleItem.getEntityTypeName()) : cardTitleItem.getEntityTypeName() == null) {
            String str2 = this.entityTemplate;
            if (str2 != null ? str2.equals(cardTitleItem.getEntityTemplate()) : cardTitleItem.getEntityTemplate() == null) {
                String str3 = this.entityId;
                if (str3 != null ? str3.equals(cardTitleItem.getEntityId()) : cardTitleItem.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(cardTitleItem.getEntityFixed()) : cardTitleItem.getEntityFixed() == null) {
                        String str4 = this.url;
                        if (str4 != null ? str4.equals(cardTitleItem.getUrl()) : cardTitleItem.getUrl() == null) {
                            String str5 = this.description;
                            if (str5 != null ? str5.equals(cardTitleItem.getDescription()) : cardTitleItem.getDescription() == null) {
                                String str6 = this.pic;
                                if (str6 != null ? str6.equals(cardTitleItem.getPic()) : cardTitleItem.getPic() == null) {
                                    String str7 = this.logo;
                                    if (str7 != null ? str7.equals(cardTitleItem.getLogo()) : cardTitleItem.getLogo() == null) {
                                        String str8 = this.subTitle;
                                        if (str8 != null ? str8.equals(cardTitleItem.getSubTitle()) : cardTitleItem.getSubTitle() == null) {
                                            String str9 = this.id;
                                            if (str9 != null ? str9.equals(cardTitleItem.getId()) : cardTitleItem.getId() == null) {
                                                String str10 = this.extraData;
                                                if (str10 != null ? str10.equals(cardTitleItem.getExtraData()) : cardTitleItem.getExtraData() == null) {
                                                    Long l = this.dateline;
                                                    if (l != null ? l.equals(cardTitleItem.getDateline()) : cardTitleItem.getDateline() == null) {
                                                        Long l2 = this.lastUpdate;
                                                        if (l2 != null ? l2.equals(cardTitleItem.getLastUpdate()) : cardTitleItem.getLastUpdate() == null) {
                                                            if (this.title.equals(cardTitleItem.getTitle()) && this.pageVisibility == cardTitleItem.getPageVisibility()) {
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
        String str4 = this.url;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.description;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.pic;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.logo;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.subTitle;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.id;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.extraData;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode12 = (hashCode11 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return ((((hashCode12 ^ i) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.pageVisibility;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_CardTitleItem$Builder */
    /* compiled from: $$AutoValue_CardTitleItem */
    static final class Builder extends CardTitleItem.Builder {
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private String id;
        private Long lastUpdate;
        private String logo;
        private Integer pageVisibility;
        private String pic;
        private String subTitle;
        private String title;
        private String url;

        Builder() {
        }

        Builder(CardTitleItem cardTitleItem) {
            this.entityTypeName = cardTitleItem.getEntityTypeName();
            this.entityTemplate = cardTitleItem.getEntityTemplate();
            this.entityId = cardTitleItem.getEntityId();
            this.entityFixed = cardTitleItem.getEntityFixed();
            this.url = cardTitleItem.getUrl();
            this.description = cardTitleItem.getDescription();
            this.pic = cardTitleItem.getPic();
            this.logo = cardTitleItem.getLogo();
            this.subTitle = cardTitleItem.getSubTitle();
            this.id = cardTitleItem.getId();
            this.extraData = cardTitleItem.getExtraData();
            this.dateline = cardTitleItem.getDateline();
            this.lastUpdate = cardTitleItem.getLastUpdate();
            this.title = cardTitleItem.getTitle();
            this.pageVisibility = Integer.valueOf(cardTitleItem.getPageVisibility());
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder dateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder lastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem.Builder pageVisibility(int i) {
            this.pageVisibility = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.CardTitleItem.Builder
        public CardTitleItem build() {
            String str = "";
            if (this.title == null) {
                str = str + " title";
            }
            if (this.pageVisibility == null) {
                str = str + " pageVisibility";
            }
            if (str.isEmpty()) {
                return new AutoValue_CardTitleItem(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.title, this.pageVisibility.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
