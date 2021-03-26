package com.coolapk.market.model;

import com.coolapk.market.model.LocalApp;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_LocalApp  reason: invalid class name */
abstract class C$$AutoValue_LocalApp extends LocalApp {
    private final String apkId;
    private final String apkSize;
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
    private final String title;
    private final String url;

    C$$AutoValue_LocalApp(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, String str13, String str14) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.description = str4;
        this.pic = str5;
        this.logo = str6;
        this.subTitle = str7;
        this.id = str8;
        this.extraData = str9;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.title = str10;
        this.apkId = str11;
        Objects.requireNonNull(str12, "Null packageName");
        this.packageName = str12;
        this.apkSize = str13;
        this.url = str14;
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

    @Override // com.coolapk.market.model.LocalApp, com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.LocalApp
    @SerializedName("aid")
    public String getApkId() {
        return this.apkId;
    }

    @Override // com.coolapk.market.model.LocalApp
    @SerializedName("apkname")
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.LocalApp
    public String getApkSize() {
        return this.apkSize;
    }

    @Override // com.coolapk.market.model.LocalApp, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // java.lang.Object
    public String toString() {
        return "LocalApp{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", title=" + this.title + ", apkId=" + this.apkId + ", packageName=" + this.packageName + ", apkSize=" + this.apkSize + ", url=" + this.url + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalApp)) {
            return false;
        }
        LocalApp localApp = (LocalApp) obj;
        String str2 = this.entityTypeName;
        if (str2 != null ? str2.equals(localApp.getEntityTypeName()) : localApp.getEntityTypeName() == null) {
            String str3 = this.entityTemplate;
            if (str3 != null ? str3.equals(localApp.getEntityTemplate()) : localApp.getEntityTemplate() == null) {
                String str4 = this.entityId;
                if (str4 != null ? str4.equals(localApp.getEntityId()) : localApp.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(localApp.getEntityFixed()) : localApp.getEntityFixed() == null) {
                        String str5 = this.description;
                        if (str5 != null ? str5.equals(localApp.getDescription()) : localApp.getDescription() == null) {
                            String str6 = this.pic;
                            if (str6 != null ? str6.equals(localApp.getPic()) : localApp.getPic() == null) {
                                String str7 = this.logo;
                                if (str7 != null ? str7.equals(localApp.getLogo()) : localApp.getLogo() == null) {
                                    String str8 = this.subTitle;
                                    if (str8 != null ? str8.equals(localApp.getSubTitle()) : localApp.getSubTitle() == null) {
                                        String str9 = this.id;
                                        if (str9 != null ? str9.equals(localApp.getId()) : localApp.getId() == null) {
                                            String str10 = this.extraData;
                                            if (str10 != null ? str10.equals(localApp.getExtraData()) : localApp.getExtraData() == null) {
                                                Long l2 = this.dateline;
                                                if (l2 != null ? l2.equals(localApp.getDateline()) : localApp.getDateline() == null) {
                                                    Long l3 = this.lastUpdate;
                                                    if (l3 != null ? l3.equals(localApp.getLastUpdate()) : localApp.getLastUpdate() == null) {
                                                        String str11 = this.title;
                                                        if (str11 != null ? str11.equals(localApp.getTitle()) : localApp.getTitle() == null) {
                                                            String str12 = this.apkId;
                                                            if (str12 != null ? str12.equals(localApp.getApkId()) : localApp.getApkId() == null) {
                                                                if (this.packageName.equals(localApp.getPackageName()) && ((str = this.apkSize) != null ? str.equals(localApp.getApkSize()) : localApp.getApkSize() == null)) {
                                                                    String str13 = this.url;
                                                                    if (str13 == null) {
                                                                        if (localApp.getUrl() == null) {
                                                                            return true;
                                                                        }
                                                                    } else if (str13.equals(localApp.getUrl())) {
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
        String str7 = this.subTitle;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.id;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.extraData;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode11 = (hashCode10 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode12 = (hashCode11 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str10 = this.title;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.apkId;
        int hashCode14 = (((hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003) ^ this.packageName.hashCode()) * 1000003;
        String str12 = this.apkSize;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.url;
        if (str13 != null) {
            i = str13.hashCode();
        }
        return hashCode15 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_LocalApp$Builder */
    /* compiled from: $$AutoValue_LocalApp */
    static final class Builder extends LocalApp.Builder {
        private String apkId;
        private String apkSize;
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
        private String title;
        private String url;

        Builder() {
        }

        Builder(LocalApp localApp) {
            this.entityTypeName = localApp.getEntityTypeName();
            this.entityTemplate = localApp.getEntityTemplate();
            this.entityId = localApp.getEntityId();
            this.entityFixed = localApp.getEntityFixed();
            this.description = localApp.getDescription();
            this.pic = localApp.getPic();
            this.logo = localApp.getLogo();
            this.subTitle = localApp.getSubTitle();
            this.id = localApp.getId();
            this.extraData = localApp.getExtraData();
            this.dateline = localApp.getDateline();
            this.lastUpdate = localApp.getLastUpdate();
            this.title = localApp.getTitle();
            this.apkId = localApp.getApkId();
            this.packageName = localApp.getPackageName();
            this.apkSize = localApp.getApkSize();
            this.url = localApp.getUrl();
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setDateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setLastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setApkId(String str) {
            this.apkId = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setPackageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setApkSize(String str) {
            this.apkSize = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApp.Builder
        public LocalApp build() {
            String str = "";
            if (this.packageName == null) {
                str = str + " packageName";
            }
            if (str.isEmpty()) {
                return new AutoValue_LocalApp(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.title, this.apkId, this.packageName, this.apkSize, this.url);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
