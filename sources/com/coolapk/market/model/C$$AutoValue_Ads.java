package com.coolapk.market.model;

import com.coolapk.market.model.Ads;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Ads  reason: invalid class name */
abstract class C$$AutoValue_Ads extends Ads {
    private final String adsType;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final int follow;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;

    C$$AutoValue_Ads(String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l, Long l2, String str7, String str8, int i, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.description = str3;
        this.pic = str4;
        this.id = str5;
        this.extraData = str6;
        this.dateline = l;
        this.lastUpdate = l2;
        this.entityTypeName = str7;
        this.uid = str8;
        this.follow = i;
        Objects.requireNonNull(str9, "Null entityType");
        this.entityType = str9;
        Objects.requireNonNull(str10, "Null title");
        this.title = str10;
        this.subTitle = str11;
        this.url = str12;
        Objects.requireNonNull(str13, "Null logo");
        this.logo = str13;
        this.adsType = str14;
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

    @Override // com.coolapk.market.model.Ads, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.Ads
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.Ads
    public int getFollow() {
        return this.follow;
    }

    @Override // com.coolapk.market.model.Ads, com.coolapk.market.model.Entity
    public String getEntityType() {
        return this.entityType;
    }

    @Override // com.coolapk.market.model.Ads, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Ads, com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Ads, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Ads, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.Ads
    public String getAdsType() {
        return this.adsType;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Ads{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", description=" + this.description + ", pic=" + this.pic + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", entityTypeName=" + this.entityTypeName + ", uid=" + this.uid + ", follow=" + this.follow + ", entityType=" + this.entityType + ", title=" + this.title + ", subTitle=" + this.subTitle + ", url=" + this.url + ", logo=" + this.logo + ", adsType=" + this.adsType + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ads)) {
            return false;
        }
        Ads ads = (Ads) obj;
        String str3 = this.entityTemplate;
        if (str3 != null ? str3.equals(ads.getEntityTemplate()) : ads.getEntityTemplate() == null) {
            String str4 = this.entityId;
            if (str4 != null ? str4.equals(ads.getEntityId()) : ads.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(ads.getEntityFixed()) : ads.getEntityFixed() == null) {
                    String str5 = this.description;
                    if (str5 != null ? str5.equals(ads.getDescription()) : ads.getDescription() == null) {
                        String str6 = this.pic;
                        if (str6 != null ? str6.equals(ads.getPic()) : ads.getPic() == null) {
                            String str7 = this.id;
                            if (str7 != null ? str7.equals(ads.getId()) : ads.getId() == null) {
                                String str8 = this.extraData;
                                if (str8 != null ? str8.equals(ads.getExtraData()) : ads.getExtraData() == null) {
                                    Long l = this.dateline;
                                    if (l != null ? l.equals(ads.getDateline()) : ads.getDateline() == null) {
                                        Long l2 = this.lastUpdate;
                                        if (l2 != null ? l2.equals(ads.getLastUpdate()) : ads.getLastUpdate() == null) {
                                            String str9 = this.entityTypeName;
                                            if (str9 != null ? str9.equals(ads.getEntityTypeName()) : ads.getEntityTypeName() == null) {
                                                String str10 = this.uid;
                                                if (str10 != null ? str10.equals(ads.getUid()) : ads.getUid() == null) {
                                                    if (this.follow == ads.getFollow() && this.entityType.equals(ads.getEntityType()) && this.title.equals(ads.getTitle()) && ((str = this.subTitle) != null ? str.equals(ads.getSubTitle()) : ads.getSubTitle() == null) && ((str2 = this.url) != null ? str2.equals(ads.getUrl()) : ads.getUrl() == null) && this.logo.equals(ads.getLogo())) {
                                                        String str11 = this.adsType;
                                                        if (str11 == null) {
                                                            if (ads.getAdsType() == null) {
                                                                return true;
                                                            }
                                                        } else if (str11.equals(ads.getAdsType())) {
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
        String str = this.entityTemplate;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityId;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode3 = (hashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str3 = this.description;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.pic;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.id;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.extraData;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode8 = (hashCode7 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode9 = (hashCode8 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str7 = this.entityTypeName;
        int hashCode10 = (hashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.uid;
        int hashCode11 = (((((((hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003) ^ this.follow) * 1000003) ^ this.entityType.hashCode()) * 1000003) ^ this.title.hashCode()) * 1000003;
        String str9 = this.subTitle;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.url;
        int hashCode13 = (((hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003) ^ this.logo.hashCode()) * 1000003;
        String str11 = this.adsType;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return hashCode13 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Ads$Builder */
    /* compiled from: $$AutoValue_Ads */
    static final class Builder extends Ads.Builder {
        private String adsType;
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private Integer follow;
        private String id;
        private Long lastUpdate;
        private String logo;
        private String pic;
        private String subTitle;
        private String title;
        private String uid;
        private String url;

        Builder() {
        }

        Builder(Ads ads) {
            this.entityTemplate = ads.getEntityTemplate();
            this.entityId = ads.getEntityId();
            this.entityFixed = ads.getEntityFixed();
            this.description = ads.getDescription();
            this.pic = ads.getPic();
            this.id = ads.getId();
            this.extraData = ads.getExtraData();
            this.dateline = ads.getDateline();
            this.lastUpdate = ads.getLastUpdate();
            this.entityTypeName = ads.getEntityTypeName();
            this.uid = ads.getUid();
            this.follow = Integer.valueOf(ads.getFollow());
            this.entityType = ads.getEntityType();
            this.title = ads.getTitle();
            this.subTitle = ads.getSubTitle();
            this.url = ads.getUrl();
            this.logo = ads.getLogo();
            this.adsType = ads.getAdsType();
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setFollow(int i) {
            this.follow = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads.Builder setAdsType(String str) {
            this.adsType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Ads.Builder
        public Ads build() {
            String str = "";
            if (this.follow == null) {
                str = str + " follow";
            }
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (this.title == null) {
                str = str + " title";
            }
            if (this.logo == null) {
                str = str + " logo";
            }
            if (str.isEmpty()) {
                return new AutoValue_Ads(this.entityTemplate, this.entityId, this.entityFixed, this.description, this.pic, this.id, this.extraData, this.dateline, this.lastUpdate, this.entityTypeName, this.uid, this.follow.intValue(), this.entityType, this.title, this.subTitle, this.url, this.logo, this.adsType);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
