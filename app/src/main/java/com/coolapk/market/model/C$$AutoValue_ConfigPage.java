package com.coolapk.market.model;

import com.coolapk.market.model.ConfigPage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_ConfigPage  reason: invalid class name */
abstract class C$$AutoValue_ConfigPage extends ConfigPage {
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
    private final int order;
    private final int pageFixed;
    private final String pageName;
    private final String pic;
    private final List<SimpleEntity> rawEntities;
    private final String subTitle;
    private final String title;
    private final String url;
    private final int visibility;

    C$$AutoValue_ConfigPage(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l2, Long l3, String str13, int i, int i2, int i3, List<SimpleEntity> list) {
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
        Objects.requireNonNull(str13, "Null pageName");
        this.pageName = str13;
        this.visibility = i;
        this.order = i2;
        this.pageFixed = i3;
        Objects.requireNonNull(list, "Null rawEntities");
        this.rawEntities = list;
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

    @Override // com.coolapk.market.model.ConfigPage
    @SerializedName("page_name")
    public String getPageName() {
        return this.pageName;
    }

    @Override // com.coolapk.market.model.ConfigPage
    @SerializedName("page_visibility")
    protected int getVisibility() {
        return this.visibility;
    }

    @Override // com.coolapk.market.model.ConfigPage
    public int getOrder() {
        return this.order;
    }

    @Override // com.coolapk.market.model.ConfigPage
    @SerializedName("page_fixed")
    protected int getPageFixed() {
        return this.pageFixed;
    }

    @Override // com.coolapk.market.model.ConfigPage
    @SerializedName("entities")
    public List<SimpleEntity> getRawEntities() {
        return this.rawEntities;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ConfigPage{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", pageName=" + this.pageName + ", visibility=" + this.visibility + ", order=" + this.order + ", pageFixed=" + this.pageFixed + ", rawEntities=" + this.rawEntities + "}";
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
        Long l3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfigPage)) {
            return false;
        }
        ConfigPage configPage = (ConfigPage) obj;
        String str11 = this.entityTypeName;
        if (str11 != null ? str11.equals(configPage.getEntityTypeName()) : configPage.getEntityTypeName() == null) {
            if (this.entityType.equals(configPage.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(configPage.getEntityTemplate()) : configPage.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(configPage.getEntityId()) : configPage.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(configPage.getEntityFixed()) : configPage.getEntityFixed() == null) && ((str3 = this.title) != null ? str3.equals(configPage.getTitle()) : configPage.getTitle() == null) && ((str4 = this.url) != null ? str4.equals(configPage.getUrl()) : configPage.getUrl() == null) && ((str5 = this.description) != null ? str5.equals(configPage.getDescription()) : configPage.getDescription() == null) && ((str6 = this.pic) != null ? str6.equals(configPage.getPic()) : configPage.getPic() == null) && ((str7 = this.logo) != null ? str7.equals(configPage.getLogo()) : configPage.getLogo() == null) && ((str8 = this.subTitle) != null ? str8.equals(configPage.getSubTitle()) : configPage.getSubTitle() == null) && ((str9 = this.id) != null ? str9.equals(configPage.getId()) : configPage.getId() == null) && ((str10 = this.extraData) != null ? str10.equals(configPage.getExtraData()) : configPage.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(configPage.getDateline()) : configPage.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(configPage.getLastUpdate()) : configPage.getLastUpdate() == null) && this.pageName.equals(configPage.getPageName()) && this.visibility == configPage.getVisibility() && this.order == configPage.getOrder() && this.pageFixed == configPage.getPageFixed() && this.rawEntities.equals(configPage.getRawEntities())) {
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
        return ((((((((((hashCode13 ^ i) * 1000003) ^ this.pageName.hashCode()) * 1000003) ^ this.visibility) * 1000003) ^ this.order) * 1000003) ^ this.pageFixed) * 1000003) ^ this.rawEntities.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_ConfigPage$Builder */
    /* compiled from: $$AutoValue_ConfigPage */
    static final class Builder extends ConfigPage.Builder {
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
        private Integer order;
        private Integer pageFixed;
        private String pageName;
        private String pic;
        private List<SimpleEntity> rawEntities;
        private String subTitle;
        private String title;
        private String url;
        private Integer visibility;

        Builder() {
        }

        Builder(ConfigPage configPage) {
            this.entityTypeName = configPage.getEntityTypeName();
            this.entityType = configPage.getEntityType();
            this.entityTemplate = configPage.getEntityTemplate();
            this.entityId = configPage.getEntityId();
            this.entityFixed = configPage.getEntityFixed();
            this.title = configPage.getTitle();
            this.url = configPage.getUrl();
            this.description = configPage.getDescription();
            this.pic = configPage.getPic();
            this.logo = configPage.getLogo();
            this.subTitle = configPage.getSubTitle();
            this.id = configPage.getId();
            this.extraData = configPage.getExtraData();
            this.dateline = configPage.getDateline();
            this.lastUpdate = configPage.getLastUpdate();
            this.pageName = configPage.getPageName();
            this.visibility = Integer.valueOf(configPage.getVisibility());
            this.order = Integer.valueOf(configPage.getOrder());
            this.pageFixed = Integer.valueOf(configPage.getPageFixed());
            this.rawEntities = configPage.getRawEntities();
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder entityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder dateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder lastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder pageName(String str) {
            this.pageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder visibility(int i) {
            this.visibility = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder order(int i) {
            this.order = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder pageFixed(int i) {
            this.pageFixed = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage.Builder rawEntities(List<SimpleEntity> list) {
            this.rawEntities = list;
            return this;
        }

        @Override // com.coolapk.market.model.ConfigPage.Builder
        public ConfigPage build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (this.pageName == null) {
                str = str + " pageName";
            }
            if (this.visibility == null) {
                str = str + " visibility";
            }
            if (this.order == null) {
                str = str + " order";
            }
            if (this.pageFixed == null) {
                str = str + " pageFixed";
            }
            if (this.rawEntities == null) {
                str = str + " rawEntities";
            }
            if (str.isEmpty()) {
                return new AutoValue_ConfigPage(this.entityTypeName, this.entityType, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.pageName, this.visibility.intValue(), this.order.intValue(), this.pageFixed.intValue(), this.rawEntities);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
