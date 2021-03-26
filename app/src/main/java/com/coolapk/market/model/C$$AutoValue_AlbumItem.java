package com.coolapk.market.model;

import com.coolapk.market.model.AlbumItem;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_AlbumItem  reason: invalid class name */
abstract class C$$AutoValue_AlbumItem extends AlbumItem {
    private final String albumId;
    private final String apkId;
    private final Long dateline;
    private final String description;
    private final int displayOrder;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraAnalysisData;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String note;
    private final String packageName;
    private final String pic;
    private final String sourceName;
    private final String subTitle;
    private final String title;
    private final String url;
    private final int versionCode;
    private final String versionName;

    C$$AutoValue_AlbumItem(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, String str13, int i, String str14, String str15, String str16, int i2, String str17, String str18) {
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
        this.albumId = str10;
        this.title = str11;
        this.apkId = str12;
        Objects.requireNonNull(str13, "Null packageName");
        this.packageName = str13;
        this.versionCode = i;
        this.versionName = str14;
        this.note = str15;
        this.sourceName = str16;
        this.displayOrder = i2;
        this.extraAnalysisData = str17;
        this.url = str18;
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

    @Override // com.coolapk.market.model.AlbumItem
    @SerializedName("albumid")
    public String getAlbumId() {
        return this.albumId;
    }

    @Override // com.coolapk.market.model.AlbumItem, com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.AlbumItem
    @SerializedName("aid")
    public String getApkId() {
        return this.apkId;
    }

    @Override // com.coolapk.market.model.AlbumItem
    @SerializedName("apkname")
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.AlbumItem
    @SerializedName("apkversioncode")
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // com.coolapk.market.model.AlbumItem
    @SerializedName("apkversionname")
    public String getVersionName() {
        return this.versionName;
    }

    @Override // com.coolapk.market.model.AlbumItem
    public String getNote() {
        return this.note;
    }

    @Override // com.coolapk.market.model.AlbumItem
    public String getSourceName() {
        return this.sourceName;
    }

    @Override // com.coolapk.market.model.AlbumItem
    @SerializedName("displayorder")
    public int getDisplayOrder() {
        return this.displayOrder;
    }

    @Override // com.coolapk.market.model.AlbumItem
    public String getExtraAnalysisData() {
        return this.extraAnalysisData;
    }

    @Override // com.coolapk.market.model.AlbumItem, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // java.lang.Object
    public String toString() {
        return "AlbumItem{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", albumId=" + this.albumId + ", title=" + this.title + ", apkId=" + this.apkId + ", packageName=" + this.packageName + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", note=" + this.note + ", sourceName=" + this.sourceName + ", displayOrder=" + this.displayOrder + ", extraAnalysisData=" + this.extraAnalysisData + ", url=" + this.url + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AlbumItem)) {
            return false;
        }
        AlbumItem albumItem = (AlbumItem) obj;
        String str5 = this.entityTypeName;
        if (str5 != null ? str5.equals(albumItem.getEntityTypeName()) : albumItem.getEntityTypeName() == null) {
            String str6 = this.entityTemplate;
            if (str6 != null ? str6.equals(albumItem.getEntityTemplate()) : albumItem.getEntityTemplate() == null) {
                String str7 = this.entityId;
                if (str7 != null ? str7.equals(albumItem.getEntityId()) : albumItem.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(albumItem.getEntityFixed()) : albumItem.getEntityFixed() == null) {
                        String str8 = this.description;
                        if (str8 != null ? str8.equals(albumItem.getDescription()) : albumItem.getDescription() == null) {
                            String str9 = this.pic;
                            if (str9 != null ? str9.equals(albumItem.getPic()) : albumItem.getPic() == null) {
                                String str10 = this.logo;
                                if (str10 != null ? str10.equals(albumItem.getLogo()) : albumItem.getLogo() == null) {
                                    String str11 = this.subTitle;
                                    if (str11 != null ? str11.equals(albumItem.getSubTitle()) : albumItem.getSubTitle() == null) {
                                        String str12 = this.id;
                                        if (str12 != null ? str12.equals(albumItem.getId()) : albumItem.getId() == null) {
                                            String str13 = this.extraData;
                                            if (str13 != null ? str13.equals(albumItem.getExtraData()) : albumItem.getExtraData() == null) {
                                                Long l2 = this.dateline;
                                                if (l2 != null ? l2.equals(albumItem.getDateline()) : albumItem.getDateline() == null) {
                                                    Long l3 = this.lastUpdate;
                                                    if (l3 != null ? l3.equals(albumItem.getLastUpdate()) : albumItem.getLastUpdate() == null) {
                                                        String str14 = this.albumId;
                                                        if (str14 != null ? str14.equals(albumItem.getAlbumId()) : albumItem.getAlbumId() == null) {
                                                            String str15 = this.title;
                                                            if (str15 != null ? str15.equals(albumItem.getTitle()) : albumItem.getTitle() == null) {
                                                                String str16 = this.apkId;
                                                                if (str16 != null ? str16.equals(albumItem.getApkId()) : albumItem.getApkId() == null) {
                                                                    if (this.packageName.equals(albumItem.getPackageName()) && this.versionCode == albumItem.getVersionCode() && ((str = this.versionName) != null ? str.equals(albumItem.getVersionName()) : albumItem.getVersionName() == null) && ((str2 = this.note) != null ? str2.equals(albumItem.getNote()) : albumItem.getNote() == null) && ((str3 = this.sourceName) != null ? str3.equals(albumItem.getSourceName()) : albumItem.getSourceName() == null) && this.displayOrder == albumItem.getDisplayOrder() && ((str4 = this.extraAnalysisData) != null ? str4.equals(albumItem.getExtraAnalysisData()) : albumItem.getExtraAnalysisData() == null)) {
                                                                        String str17 = this.url;
                                                                        if (str17 == null) {
                                                                            if (albumItem.getUrl() == null) {
                                                                                return true;
                                                                            }
                                                                        } else if (str17.equals(albumItem.getUrl())) {
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
        String str10 = this.albumId;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.title;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.apkId;
        int hashCode15 = (((((hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003) ^ this.packageName.hashCode()) * 1000003) ^ this.versionCode) * 1000003;
        String str13 = this.versionName;
        int hashCode16 = (hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.note;
        int hashCode17 = (hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.sourceName;
        int hashCode18 = (((hashCode17 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.displayOrder) * 1000003;
        String str16 = this.extraAnalysisData;
        int hashCode19 = (hashCode18 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.url;
        if (str17 != null) {
            i = str17.hashCode();
        }
        return hashCode19 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_AlbumItem$Builder */
    /* compiled from: $$AutoValue_AlbumItem */
    static final class Builder extends AlbumItem.Builder {
        private String albumId;
        private String apkId;
        private Long dateline;
        private String description;
        private Integer displayOrder;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraAnalysisData;
        private String extraData;
        private String id;
        private Long lastUpdate;
        private String logo;
        private String note;
        private String packageName;
        private String pic;
        private String sourceName;
        private String subTitle;
        private String title;
        private String url;
        private Integer versionCode;
        private String versionName;

        Builder() {
        }

        Builder(AlbumItem albumItem) {
            this.entityTypeName = albumItem.getEntityTypeName();
            this.entityTemplate = albumItem.getEntityTemplate();
            this.entityId = albumItem.getEntityId();
            this.entityFixed = albumItem.getEntityFixed();
            this.description = albumItem.getDescription();
            this.pic = albumItem.getPic();
            this.logo = albumItem.getLogo();
            this.subTitle = albumItem.getSubTitle();
            this.id = albumItem.getId();
            this.extraData = albumItem.getExtraData();
            this.dateline = albumItem.getDateline();
            this.lastUpdate = albumItem.getLastUpdate();
            this.albumId = albumItem.getAlbumId();
            this.title = albumItem.getTitle();
            this.apkId = albumItem.getApkId();
            this.packageName = albumItem.getPackageName();
            this.versionCode = Integer.valueOf(albumItem.getVersionCode());
            this.versionName = albumItem.getVersionName();
            this.note = albumItem.getNote();
            this.sourceName = albumItem.getSourceName();
            this.displayOrder = Integer.valueOf(albumItem.getDisplayOrder());
            this.extraAnalysisData = albumItem.getExtraAnalysisData();
            this.url = albumItem.getUrl();
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setDateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setLastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setAlbumId(String str) {
            this.albumId = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setApkId(String str) {
            this.apkId = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setPackageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setVersionCode(int i) {
            this.versionCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setVersionName(String str) {
            this.versionName = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setNote(String str) {
            this.note = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setSourceName(String str) {
            this.sourceName = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setDisplayOrder(int i) {
            this.displayOrder = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setExtraAnalysisData(String str) {
            this.extraAnalysisData = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.AlbumItem.Builder
        public AlbumItem build() {
            String str = "";
            if (this.packageName == null) {
                str = str + " packageName";
            }
            if (this.versionCode == null) {
                str = str + " versionCode";
            }
            if (this.displayOrder == null) {
                str = str + " displayOrder";
            }
            if (str.isEmpty()) {
                return new AutoValue_AlbumItem(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.albumId, this.title, this.apkId, this.packageName, this.versionCode.intValue(), this.versionName, this.note, this.sourceName, this.displayOrder.intValue(), this.extraAnalysisData, this.url);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
