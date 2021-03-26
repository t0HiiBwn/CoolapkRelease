package com.coolapk.market.model;

import com.coolapk.market.model.HolderItem;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_HolderItem  reason: invalid class name */
abstract class C$AutoValue_HolderItem extends HolderItem {
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Integer intValue;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String string;
    private final String subTitle;
    private final String title;
    private final String url;
    private final String value;

    C$AutoValue_HolderItem(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l, Long l2, String str13, String str14, Integer num2) {
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
        this.dateline = l;
        this.lastUpdate = l2;
        this.string = str13;
        this.value = str14;
        Objects.requireNonNull(num2, "Null intValue");
        this.intValue = num2;
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

    @Override // com.coolapk.market.model.HolderItem
    public String getString() {
        return this.string;
    }

    @Override // com.coolapk.market.model.HolderItem
    public String getValue() {
        return this.value;
    }

    @Override // com.coolapk.market.model.HolderItem
    public Integer getIntValue() {
        return this.intValue;
    }

    @Override // java.lang.Object
    public String toString() {
        return "HolderItem{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", string=" + this.string + ", value=" + this.value + ", intValue=" + this.intValue + "}";
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
        Long l;
        Long l2;
        String str11;
        String str12;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HolderItem)) {
            return false;
        }
        HolderItem holderItem = (HolderItem) obj;
        String str13 = this.entityTypeName;
        if (str13 != null ? str13.equals(holderItem.getEntityTypeName()) : holderItem.getEntityTypeName() == null) {
            if (this.entityType.equals(holderItem.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(holderItem.getEntityTemplate()) : holderItem.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(holderItem.getEntityId()) : holderItem.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(holderItem.getEntityFixed()) : holderItem.getEntityFixed() == null) && ((str3 = this.title) != null ? str3.equals(holderItem.getTitle()) : holderItem.getTitle() == null) && ((str4 = this.url) != null ? str4.equals(holderItem.getUrl()) : holderItem.getUrl() == null) && ((str5 = this.description) != null ? str5.equals(holderItem.getDescription()) : holderItem.getDescription() == null) && ((str6 = this.pic) != null ? str6.equals(holderItem.getPic()) : holderItem.getPic() == null) && ((str7 = this.logo) != null ? str7.equals(holderItem.getLogo()) : holderItem.getLogo() == null) && ((str8 = this.subTitle) != null ? str8.equals(holderItem.getSubTitle()) : holderItem.getSubTitle() == null) && ((str9 = this.id) != null ? str9.equals(holderItem.getId()) : holderItem.getId() == null) && ((str10 = this.extraData) != null ? str10.equals(holderItem.getExtraData()) : holderItem.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(holderItem.getDateline()) : holderItem.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(holderItem.getLastUpdate()) : holderItem.getLastUpdate() == null) && ((str11 = this.string) != null ? str11.equals(holderItem.getString()) : holderItem.getString() == null) && ((str12 = this.value) != null ? str12.equals(holderItem.getValue()) : holderItem.getValue() == null) && this.intValue.equals(holderItem.getIntValue())) {
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
        Long l = this.dateline;
        int hashCode13 = (hashCode12 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode14 = (hashCode13 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str12 = this.string;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.value;
        if (str13 != null) {
            i = str13.hashCode();
        }
        return ((hashCode15 ^ i) * 1000003) ^ this.intValue.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_HolderItem$Builder */
    static final class Builder extends HolderItem.Builder {
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private String id;
        private Integer intValue;
        private Long lastUpdate;
        private String logo;
        private String pic;
        private String string;
        private String subTitle;
        private String title;
        private String url;
        private String value;

        Builder() {
        }

        Builder(HolderItem holderItem) {
            this.entityTypeName = holderItem.getEntityTypeName();
            this.entityType = holderItem.getEntityType();
            this.entityTemplate = holderItem.getEntityTemplate();
            this.entityId = holderItem.getEntityId();
            this.entityFixed = holderItem.getEntityFixed();
            this.title = holderItem.getTitle();
            this.url = holderItem.getUrl();
            this.description = holderItem.getDescription();
            this.pic = holderItem.getPic();
            this.logo = holderItem.getLogo();
            this.subTitle = holderItem.getSubTitle();
            this.id = holderItem.getId();
            this.extraData = holderItem.getExtraData();
            this.dateline = holderItem.getDateline();
            this.lastUpdate = holderItem.getLastUpdate();
            this.string = holderItem.getString();
            this.value = holderItem.getValue();
            this.intValue = holderItem.getIntValue();
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder entityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder dateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder lastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder string(String str) {
            this.string = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder value(String str) {
            this.value = str;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem.Builder intValue(Integer num) {
            this.intValue = num;
            return this;
        }

        @Override // com.coolapk.market.model.HolderItem.Builder
        public HolderItem build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (this.intValue == null) {
                str = str + " intValue";
            }
            if (str.isEmpty()) {
                return new AutoValue_HolderItem(this.entityTypeName, this.entityType, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.string, this.value, this.intValue);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
