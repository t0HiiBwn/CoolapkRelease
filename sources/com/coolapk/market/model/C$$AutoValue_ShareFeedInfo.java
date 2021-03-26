package com.coolapk.market.model;

import com.coolapk.market.model.ShareFeedInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_ShareFeedInfo  reason: invalid class name */
abstract class C$$AutoValue_ShareFeedInfo extends ShareFeedInfo {
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final List<String> imgList;
    private final int isDiscoveryApp;
    private final Long lastUpdate;
    private final String logo;
    private final String mediaInfo;
    private final String mediaPic;
    private final int mediaType;
    private final String mediaUrl;
    private final String packageName;
    private final String pic;
    private final String reference;
    private final String sourceName;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_ShareFeedInfo(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, Long l, Long l2, String str8, String str9, List<String> list, String str10, String str11, int i, String str12, String str13, String str14, int i2, String str15, String str16, String str17) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.pic = str4;
        this.subTitle = str5;
        this.id = str6;
        this.extraData = str7;
        this.dateline = l;
        this.lastUpdate = l2;
        this.logo = str8;
        this.description = str9;
        Objects.requireNonNull(list, "Null imgList");
        this.imgList = list;
        this.url = str10;
        this.packageName = str11;
        this.isDiscoveryApp = i;
        this.title = str12;
        this.sourceName = str13;
        this.reference = str14;
        this.mediaType = i2;
        this.mediaUrl = str15;
        this.mediaPic = str16;
        this.mediaInfo = str17;
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
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
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

    @Override // com.coolapk.market.model.ShareFeedInfo, com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo, com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo
    @SerializedName("imgList")
    public List<String> getImgList() {
        return this.imgList;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo, com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo
    @SerializedName("packageName")
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo
    @SerializedName("is_share_app")
    public int getIsDiscoveryApp() {
        return this.isDiscoveryApp;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo
    public String getSourceName() {
        return this.sourceName;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo
    @SerializedName("referer")
    public String getReference() {
        return this.reference;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo
    @SerializedName("media_type")
    public int getMediaType() {
        return this.mediaType;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo
    @SerializedName("media_url")
    public String getMediaUrl() {
        return this.mediaUrl;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo
    @SerializedName("media_pic")
    public String getMediaPic() {
        return this.mediaPic;
    }

    @Override // com.coolapk.market.model.ShareFeedInfo
    @SerializedName("media_info")
    public String getMediaInfo() {
        return this.mediaInfo;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ShareFeedInfo{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", logo=" + this.logo + ", description=" + this.description + ", imgList=" + this.imgList + ", url=" + this.url + ", packageName=" + this.packageName + ", isDiscoveryApp=" + this.isDiscoveryApp + ", title=" + this.title + ", sourceName=" + this.sourceName + ", reference=" + this.reference + ", mediaType=" + this.mediaType + ", mediaUrl=" + this.mediaUrl + ", mediaPic=" + this.mediaPic + ", mediaInfo=" + this.mediaInfo + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareFeedInfo)) {
            return false;
        }
        ShareFeedInfo shareFeedInfo = (ShareFeedInfo) obj;
        String str8 = this.entityTypeName;
        if (str8 != null ? str8.equals(shareFeedInfo.getEntityTypeName()) : shareFeedInfo.getEntityTypeName() == null) {
            String str9 = this.entityTemplate;
            if (str9 != null ? str9.equals(shareFeedInfo.getEntityTemplate()) : shareFeedInfo.getEntityTemplate() == null) {
                String str10 = this.entityId;
                if (str10 != null ? str10.equals(shareFeedInfo.getEntityId()) : shareFeedInfo.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(shareFeedInfo.getEntityFixed()) : shareFeedInfo.getEntityFixed() == null) {
                        String str11 = this.pic;
                        if (str11 != null ? str11.equals(shareFeedInfo.getPic()) : shareFeedInfo.getPic() == null) {
                            String str12 = this.subTitle;
                            if (str12 != null ? str12.equals(shareFeedInfo.getSubTitle()) : shareFeedInfo.getSubTitle() == null) {
                                String str13 = this.id;
                                if (str13 != null ? str13.equals(shareFeedInfo.getId()) : shareFeedInfo.getId() == null) {
                                    String str14 = this.extraData;
                                    if (str14 != null ? str14.equals(shareFeedInfo.getExtraData()) : shareFeedInfo.getExtraData() == null) {
                                        Long l = this.dateline;
                                        if (l != null ? l.equals(shareFeedInfo.getDateline()) : shareFeedInfo.getDateline() == null) {
                                            Long l2 = this.lastUpdate;
                                            if (l2 != null ? l2.equals(shareFeedInfo.getLastUpdate()) : shareFeedInfo.getLastUpdate() == null) {
                                                String str15 = this.logo;
                                                if (str15 != null ? str15.equals(shareFeedInfo.getLogo()) : shareFeedInfo.getLogo() == null) {
                                                    String str16 = this.description;
                                                    if (str16 != null ? str16.equals(shareFeedInfo.getDescription()) : shareFeedInfo.getDescription() == null) {
                                                        if (this.imgList.equals(shareFeedInfo.getImgList()) && ((str = this.url) != null ? str.equals(shareFeedInfo.getUrl()) : shareFeedInfo.getUrl() == null) && ((str2 = this.packageName) != null ? str2.equals(shareFeedInfo.getPackageName()) : shareFeedInfo.getPackageName() == null) && this.isDiscoveryApp == shareFeedInfo.getIsDiscoveryApp() && ((str3 = this.title) != null ? str3.equals(shareFeedInfo.getTitle()) : shareFeedInfo.getTitle() == null) && ((str4 = this.sourceName) != null ? str4.equals(shareFeedInfo.getSourceName()) : shareFeedInfo.getSourceName() == null) && ((str5 = this.reference) != null ? str5.equals(shareFeedInfo.getReference()) : shareFeedInfo.getReference() == null) && this.mediaType == shareFeedInfo.getMediaType() && ((str6 = this.mediaUrl) != null ? str6.equals(shareFeedInfo.getMediaUrl()) : shareFeedInfo.getMediaUrl() == null) && ((str7 = this.mediaPic) != null ? str7.equals(shareFeedInfo.getMediaPic()) : shareFeedInfo.getMediaPic() == null)) {
                                                            String str17 = this.mediaInfo;
                                                            if (str17 == null) {
                                                                if (shareFeedInfo.getMediaInfo() == null) {
                                                                    return true;
                                                                }
                                                            } else if (str17.equals(shareFeedInfo.getMediaInfo())) {
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
        String str4 = this.pic;
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
        String str8 = this.logo;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.description;
        int hashCode12 = (((hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003) ^ this.imgList.hashCode()) * 1000003;
        String str10 = this.url;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.packageName;
        int hashCode14 = (((hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003) ^ this.isDiscoveryApp) * 1000003;
        String str12 = this.title;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.sourceName;
        int hashCode16 = (hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.reference;
        int hashCode17 = (((hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.mediaType) * 1000003;
        String str15 = this.mediaUrl;
        int hashCode18 = (hashCode17 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.mediaPic;
        int hashCode19 = (hashCode18 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.mediaInfo;
        if (str17 != null) {
            i = str17.hashCode();
        }
        return hashCode19 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_ShareFeedInfo$Builder */
    /* compiled from: $$AutoValue_ShareFeedInfo */
    static final class Builder extends ShareFeedInfo.Builder {
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private String id;
        private List<String> imgList;
        private Integer isDiscoveryApp;
        private Long lastUpdate;
        private String logo;
        private String mediaInfo;
        private String mediaPic;
        private Integer mediaType;
        private String mediaUrl;
        private String packageName;
        private String pic;
        private String reference;
        private String sourceName;
        private String subTitle;
        private String title;
        private String url;

        Builder() {
        }

        Builder(ShareFeedInfo shareFeedInfo) {
            this.entityTypeName = shareFeedInfo.getEntityTypeName();
            this.entityTemplate = shareFeedInfo.getEntityTemplate();
            this.entityId = shareFeedInfo.getEntityId();
            this.entityFixed = shareFeedInfo.getEntityFixed();
            this.pic = shareFeedInfo.getPic();
            this.subTitle = shareFeedInfo.getSubTitle();
            this.id = shareFeedInfo.getId();
            this.extraData = shareFeedInfo.getExtraData();
            this.dateline = shareFeedInfo.getDateline();
            this.lastUpdate = shareFeedInfo.getLastUpdate();
            this.logo = shareFeedInfo.getLogo();
            this.description = shareFeedInfo.getDescription();
            this.imgList = shareFeedInfo.getImgList();
            this.url = shareFeedInfo.getUrl();
            this.packageName = shareFeedInfo.getPackageName();
            this.isDiscoveryApp = Integer.valueOf(shareFeedInfo.getIsDiscoveryApp());
            this.title = shareFeedInfo.getTitle();
            this.sourceName = shareFeedInfo.getSourceName();
            this.reference = shareFeedInfo.getReference();
            this.mediaType = Integer.valueOf(shareFeedInfo.getMediaType());
            this.mediaUrl = shareFeedInfo.getMediaUrl();
            this.mediaPic = shareFeedInfo.getMediaPic();
            this.mediaInfo = shareFeedInfo.getMediaInfo();
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setImgList(List<String> list) {
            this.imgList = list;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setPackageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setIsDiscoveryApp(int i) {
            this.isDiscoveryApp = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setSourceName(String str) {
            this.sourceName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setReference(String str) {
            this.reference = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setMediaType(int i) {
            this.mediaType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setMediaUrl(String str) {
            this.mediaUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setMediaPic(String str) {
            this.mediaPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo.Builder setMediaInfo(String str) {
            this.mediaInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.ShareFeedInfo.Builder
        public ShareFeedInfo build() {
            String str = "";
            if (this.imgList == null) {
                str = str + " imgList";
            }
            if (this.isDiscoveryApp == null) {
                str = str + " isDiscoveryApp";
            }
            if (this.mediaType == null) {
                str = str + " mediaType";
            }
            if (str.isEmpty()) {
                return new AutoValue_ShareFeedInfo(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.pic, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.logo, this.description, this.imgList, this.url, this.packageName, this.isDiscoveryApp.intValue(), this.title, this.sourceName, this.reference, this.mediaType.intValue(), this.mediaUrl, this.mediaPic, this.mediaInfo);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
