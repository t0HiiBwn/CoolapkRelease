package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_Video  reason: invalid class name */
abstract class C$$AutoValue_Video extends Video {
    private final String cover;
    private final Long dateline;
    private final String description;
    private final int duration;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final boolean isLive;
    private final Long lastUpdate;
    private final String logo;
    private final String mediaType;
    private final String name;
    private final String pic;
    private final String playHeaders;
    private final boolean redirectSource;
    private final String requestParams;
    private final String subTitle;
    private final String url;

    C$$AutoValue_Video(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, String str12, int i2, boolean z, String str13, String str14, String str15, boolean z2) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityTypeId = i;
        this.entityId = str3;
        this.entityFixed = num;
        this.url = str4;
        this.description = str5;
        this.pic = str6;
        this.logo = str7;
        this.subTitle = str8;
        this.id = str9;
        this.extraData = str10;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.name = str11;
        this.cover = str12;
        this.duration = i2;
        this.isLive = z;
        this.mediaType = str13;
        this.requestParams = str14;
        this.playHeaders = str15;
        this.redirectSource = z2;
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
    public int getEntityTypeId() {
        return this.entityTypeId;
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

    @Override // com.coolapk.market.model.Video
    public String getName() {
        return this.name;
    }

    @Override // com.coolapk.market.model.Video
    public String getCover() {
        return this.cover;
    }

    @Override // com.coolapk.market.model.Video
    public int getDuration() {
        return this.duration;
    }

    @Override // com.coolapk.market.model.Video
    public boolean getIsLive() {
        return this.isLive;
    }

    @Override // com.coolapk.market.model.Video
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // com.coolapk.market.model.Video
    public String getRequestParams() {
        return this.requestParams;
    }

    @Override // com.coolapk.market.model.Video
    public String getPlayHeaders() {
        return this.playHeaders;
    }

    @Override // com.coolapk.market.model.Video
    @SerializedName("redirectSource")
    public boolean isRedirectSource() {
        return this.redirectSource;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Video{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", name=" + this.name + ", cover=" + this.cover + ", duration=" + this.duration + ", isLive=" + this.isLive + ", mediaType=" + this.mediaType + ", requestParams=" + this.requestParams + ", playHeaders=" + this.playHeaders + ", redirectSource=" + this.redirectSource + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        Integer num;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Long l2;
        Long l3;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Video)) {
            return false;
        }
        Video video = (Video) obj;
        String str14 = this.entityTypeName;
        if (str14 != null ? str14.equals(video.getEntityTypeName()) : video.getEntityTypeName() == null) {
            String str15 = this.entityTemplate;
            if (str15 != null ? str15.equals(video.getEntityTemplate()) : video.getEntityTemplate() == null) {
                if (this.entityTypeId == video.getEntityTypeId() && ((str = this.entityId) != null ? str.equals(video.getEntityId()) : video.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(video.getEntityFixed()) : video.getEntityFixed() == null) && ((str2 = this.url) != null ? str2.equals(video.getUrl()) : video.getUrl() == null) && ((str3 = this.description) != null ? str3.equals(video.getDescription()) : video.getDescription() == null) && ((str4 = this.pic) != null ? str4.equals(video.getPic()) : video.getPic() == null) && ((str5 = this.logo) != null ? str5.equals(video.getLogo()) : video.getLogo() == null) && ((str6 = this.subTitle) != null ? str6.equals(video.getSubTitle()) : video.getSubTitle() == null) && ((str7 = this.id) != null ? str7.equals(video.getId()) : video.getId() == null) && ((str8 = this.extraData) != null ? str8.equals(video.getExtraData()) : video.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(video.getDateline()) : video.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(video.getLastUpdate()) : video.getLastUpdate() == null) && ((str9 = this.name) != null ? str9.equals(video.getName()) : video.getName() == null) && ((str10 = this.cover) != null ? str10.equals(video.getCover()) : video.getCover() == null) && this.duration == video.getDuration() && this.isLive == video.getIsLive() && ((str11 = this.mediaType) != null ? str11.equals(video.getMediaType()) : video.getMediaType() == null) && ((str12 = this.requestParams) != null ? str12.equals(video.getRequestParams()) : video.getRequestParams() == null) && ((str13 = this.playHeaders) != null ? str13.equals(video.getPlayHeaders()) : video.getPlayHeaders() == null) && this.redirectSource == video.isRedirectSource()) {
                    return true;
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
        int hashCode2 = (((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.entityTypeId) * 1000003;
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
        Long l2 = this.dateline;
        int hashCode12 = (hashCode11 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode13 = (hashCode12 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str11 = this.name;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.cover;
        int i2 = 1231;
        int hashCode15 = (((((hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003) ^ this.duration) * 1000003) ^ (this.isLive ? 1231 : 1237)) * 1000003;
        String str13 = this.mediaType;
        int hashCode16 = (hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.requestParams;
        int hashCode17 = (hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.playHeaders;
        if (str15 != null) {
            i = str15.hashCode();
        }
        int i3 = (hashCode17 ^ i) * 1000003;
        if (!this.redirectSource) {
            i2 = 1237;
        }
        return i3 ^ i2;
    }
}
