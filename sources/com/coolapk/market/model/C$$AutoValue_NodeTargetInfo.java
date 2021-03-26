package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_NodeTargetInfo  reason: invalid class name */
abstract class C$$AutoValue_NodeTargetInfo extends NodeTargetInfo {
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
    private final String pic;
    private final String ratingAverageScore;
    private final String ratingTotalNum;
    private final String score;
    private final String subTitle;
    private final String title;
    private final String url;
    private final String voteCount;

    C$$AutoValue_NodeTargetInfo(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l2, Long l3, String str12, String str13, String str14, String str15) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.url = str5;
        this.description = str6;
        this.pic = str7;
        this.logo = str8;
        this.subTitle = str9;
        this.id = str10;
        this.extraData = str11;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.score = str12;
        this.voteCount = str13;
        this.ratingTotalNum = str14;
        this.ratingAverageScore = str15;
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

    @Override // com.coolapk.market.model.NodeTargetInfo
    @SerializedName("score")
    public String getScore() {
        return this.score;
    }

    @Override // com.coolapk.market.model.NodeTargetInfo
    @SerializedName("voteCount")
    public String getVoteCount() {
        return this.voteCount;
    }

    @Override // com.coolapk.market.model.NodeTargetInfo
    @SerializedName("rating_total_num")
    public String getRatingTotalNum() {
        return this.ratingTotalNum;
    }

    @Override // com.coolapk.market.model.NodeTargetInfo
    @SerializedName("rating_average_score")
    public String getRatingAverageScore() {
        return this.ratingAverageScore;
    }

    @Override // java.lang.Object
    public String toString() {
        return "NodeTargetInfo{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", score=" + this.score + ", voteCount=" + this.voteCount + ", ratingTotalNum=" + this.ratingTotalNum + ", ratingAverageScore=" + this.ratingAverageScore + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NodeTargetInfo)) {
            return false;
        }
        NodeTargetInfo nodeTargetInfo = (NodeTargetInfo) obj;
        String str = this.entityTypeName;
        if (str != null ? str.equals(nodeTargetInfo.getEntityTypeName()) : nodeTargetInfo.getEntityTypeName() == null) {
            String str2 = this.entityTemplate;
            if (str2 != null ? str2.equals(nodeTargetInfo.getEntityTemplate()) : nodeTargetInfo.getEntityTemplate() == null) {
                String str3 = this.entityId;
                if (str3 != null ? str3.equals(nodeTargetInfo.getEntityId()) : nodeTargetInfo.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(nodeTargetInfo.getEntityFixed()) : nodeTargetInfo.getEntityFixed() == null) {
                        String str4 = this.title;
                        if (str4 != null ? str4.equals(nodeTargetInfo.getTitle()) : nodeTargetInfo.getTitle() == null) {
                            String str5 = this.url;
                            if (str5 != null ? str5.equals(nodeTargetInfo.getUrl()) : nodeTargetInfo.getUrl() == null) {
                                String str6 = this.description;
                                if (str6 != null ? str6.equals(nodeTargetInfo.getDescription()) : nodeTargetInfo.getDescription() == null) {
                                    String str7 = this.pic;
                                    if (str7 != null ? str7.equals(nodeTargetInfo.getPic()) : nodeTargetInfo.getPic() == null) {
                                        String str8 = this.logo;
                                        if (str8 != null ? str8.equals(nodeTargetInfo.getLogo()) : nodeTargetInfo.getLogo() == null) {
                                            String str9 = this.subTitle;
                                            if (str9 != null ? str9.equals(nodeTargetInfo.getSubTitle()) : nodeTargetInfo.getSubTitle() == null) {
                                                String str10 = this.id;
                                                if (str10 != null ? str10.equals(nodeTargetInfo.getId()) : nodeTargetInfo.getId() == null) {
                                                    String str11 = this.extraData;
                                                    if (str11 != null ? str11.equals(nodeTargetInfo.getExtraData()) : nodeTargetInfo.getExtraData() == null) {
                                                        Long l2 = this.dateline;
                                                        if (l2 != null ? l2.equals(nodeTargetInfo.getDateline()) : nodeTargetInfo.getDateline() == null) {
                                                            Long l3 = this.lastUpdate;
                                                            if (l3 != null ? l3.equals(nodeTargetInfo.getLastUpdate()) : nodeTargetInfo.getLastUpdate() == null) {
                                                                String str12 = this.score;
                                                                if (str12 != null ? str12.equals(nodeTargetInfo.getScore()) : nodeTargetInfo.getScore() == null) {
                                                                    String str13 = this.voteCount;
                                                                    if (str13 != null ? str13.equals(nodeTargetInfo.getVoteCount()) : nodeTargetInfo.getVoteCount() == null) {
                                                                        String str14 = this.ratingTotalNum;
                                                                        if (str14 != null ? str14.equals(nodeTargetInfo.getRatingTotalNum()) : nodeTargetInfo.getRatingTotalNum() == null) {
                                                                            String str15 = this.ratingAverageScore;
                                                                            if (str15 == null) {
                                                                                if (nodeTargetInfo.getRatingAverageScore() == null) {
                                                                                    return true;
                                                                                }
                                                                            } else if (str15.equals(nodeTargetInfo.getRatingAverageScore())) {
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
        int hashCode14 = (hashCode13 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str12 = this.score;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.voteCount;
        int hashCode16 = (hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.ratingTotalNum;
        int hashCode17 = (hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.ratingAverageScore;
        if (str15 != null) {
            i = str15.hashCode();
        }
        return hashCode17 ^ i;
    }
}
