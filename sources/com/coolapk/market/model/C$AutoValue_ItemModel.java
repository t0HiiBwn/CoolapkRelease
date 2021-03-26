package com.coolapk.market.model;

import com.coolapk.market.model.ItemModel;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_ItemModel  reason: invalid class name */
abstract class C$AutoValue_ItemModel extends ItemModel {
    private final String activityName;
    private final String content;
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
    private final String packageName;
    private final String pic;
    private final String subTitle;
    private final String targetUrl;
    private final String title;
    private final String url;

    C$AutoValue_ItemModel(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, String str12, String str13, String str14, String str15) {
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
        this.title = str11;
        this.activityName = str12;
        this.packageName = str13;
        Objects.requireNonNull(str14, "Null content");
        this.content = str14;
        Objects.requireNonNull(str15, "Null targetUrl");
        this.targetUrl = str15;
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

    @Override // com.coolapk.market.model.ItemModel, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.ItemModel
    public String getActivityName() {
        return this.activityName;
    }

    @Override // com.coolapk.market.model.ItemModel
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.ItemModel
    public String getContent() {
        return this.content;
    }

    @Override // com.coolapk.market.model.ItemModel
    public String getTargetUrl() {
        return this.targetUrl;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ItemModel{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", title=" + this.title + ", activityName=" + this.activityName + ", packageName=" + this.packageName + ", content=" + this.content + ", targetUrl=" + this.targetUrl + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemModel)) {
            return false;
        }
        ItemModel itemModel = (ItemModel) obj;
        String str = this.entityTypeName;
        if (str != null ? str.equals(itemModel.getEntityTypeName()) : itemModel.getEntityTypeName() == null) {
            String str2 = this.entityTemplate;
            if (str2 != null ? str2.equals(itemModel.getEntityTemplate()) : itemModel.getEntityTemplate() == null) {
                String str3 = this.entityId;
                if (str3 != null ? str3.equals(itemModel.getEntityId()) : itemModel.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(itemModel.getEntityFixed()) : itemModel.getEntityFixed() == null) {
                        String str4 = this.url;
                        if (str4 != null ? str4.equals(itemModel.getUrl()) : itemModel.getUrl() == null) {
                            String str5 = this.description;
                            if (str5 != null ? str5.equals(itemModel.getDescription()) : itemModel.getDescription() == null) {
                                String str6 = this.pic;
                                if (str6 != null ? str6.equals(itemModel.getPic()) : itemModel.getPic() == null) {
                                    String str7 = this.logo;
                                    if (str7 != null ? str7.equals(itemModel.getLogo()) : itemModel.getLogo() == null) {
                                        String str8 = this.subTitle;
                                        if (str8 != null ? str8.equals(itemModel.getSubTitle()) : itemModel.getSubTitle() == null) {
                                            String str9 = this.id;
                                            if (str9 != null ? str9.equals(itemModel.getId()) : itemModel.getId() == null) {
                                                String str10 = this.extraData;
                                                if (str10 != null ? str10.equals(itemModel.getExtraData()) : itemModel.getExtraData() == null) {
                                                    Long l = this.dateline;
                                                    if (l != null ? l.equals(itemModel.getDateline()) : itemModel.getDateline() == null) {
                                                        Long l2 = this.lastUpdate;
                                                        if (l2 != null ? l2.equals(itemModel.getLastUpdate()) : itemModel.getLastUpdate() == null) {
                                                            String str11 = this.title;
                                                            if (str11 != null ? str11.equals(itemModel.getTitle()) : itemModel.getTitle() == null) {
                                                                String str12 = this.activityName;
                                                                if (str12 != null ? str12.equals(itemModel.getActivityName()) : itemModel.getActivityName() == null) {
                                                                    String str13 = this.packageName;
                                                                    if (str13 != null ? str13.equals(itemModel.getPackageName()) : itemModel.getPackageName() == null) {
                                                                        if (this.content.equals(itemModel.getContent()) && this.targetUrl.equals(itemModel.getTargetUrl())) {
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
        int hashCode13 = (hashCode12 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str11 = this.title;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.activityName;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.packageName;
        if (str13 != null) {
            i = str13.hashCode();
        }
        return ((((hashCode15 ^ i) * 1000003) ^ this.content.hashCode()) * 1000003) ^ this.targetUrl.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ItemModel$Builder */
    static final class Builder extends ItemModel.Builder {
        private String activityName;
        private String content;
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
        private String packageName;
        private String pic;
        private String subTitle;
        private String targetUrl;
        private String title;
        private String url;

        Builder() {
        }

        Builder(ItemModel itemModel) {
            this.entityTypeName = itemModel.getEntityTypeName();
            this.entityTemplate = itemModel.getEntityTemplate();
            this.entityId = itemModel.getEntityId();
            this.entityFixed = itemModel.getEntityFixed();
            this.url = itemModel.getUrl();
            this.description = itemModel.getDescription();
            this.pic = itemModel.getPic();
            this.logo = itemModel.getLogo();
            this.subTitle = itemModel.getSubTitle();
            this.id = itemModel.getId();
            this.extraData = itemModel.getExtraData();
            this.dateline = itemModel.getDateline();
            this.lastUpdate = itemModel.getLastUpdate();
            this.title = itemModel.getTitle();
            this.activityName = itemModel.getActivityName();
            this.packageName = itemModel.getPackageName();
            this.content = itemModel.getContent();
            this.targetUrl = itemModel.getTargetUrl();
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder dateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder lastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder activityName(String str) {
            this.activityName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder content(String str) {
            this.content = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel.Builder targetUrl(String str) {
            this.targetUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemModel.Builder
        public ItemModel build() {
            String str = "";
            if (this.content == null) {
                str = str + " content";
            }
            if (this.targetUrl == null) {
                str = str + " targetUrl";
            }
            if (str.isEmpty()) {
                return new AutoValue_ItemModel(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.title, this.activityName, this.packageName, this.content, this.targetUrl);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
