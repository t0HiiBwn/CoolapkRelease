package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_NodeRating  reason: invalid class name */
abstract class C$$AutoValue_NodeRating extends NodeRating {
    private final int buyStatus;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String feedId;
    private final String id;
    private final int isOwner;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final int showOwner;
    private final int star;
    private final String subTitle;
    private final String targetId;
    private final NodeTargetInfo targetInfo;
    private final String targetType;
    private final String title;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_NodeRating(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l2, Long l3, String str12, String str13, int i, String str14, UserInfo userInfo2, NodeTargetInfo nodeTargetInfo, int i2, int i3, int i4) {
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
        this.targetType = str12;
        this.targetId = str13;
        this.star = i;
        this.feedId = str14;
        this.userInfo = userInfo2;
        this.targetInfo = nodeTargetInfo;
        this.buyStatus = i2;
        this.isOwner = i3;
        this.showOwner = i4;
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

    @Override // com.coolapk.market.model.NodeRating
    @SerializedName("target_type")
    public String getTargetType() {
        return this.targetType;
    }

    @Override // com.coolapk.market.model.NodeRating
    @SerializedName("target_id")
    public String getTargetId() {
        return this.targetId;
    }

    @Override // com.coolapk.market.model.NodeRating
    @SerializedName("star")
    public int getStar() {
        return this.star;
    }

    @Override // com.coolapk.market.model.NodeRating
    @SerializedName("feed_id")
    public String getFeedId() {
        return this.feedId;
    }

    @Override // com.coolapk.market.model.NodeRating
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.NodeRating
    @SerializedName("target_info")
    public NodeTargetInfo getTargetInfo() {
        return this.targetInfo;
    }

    @Override // com.coolapk.market.model.NodeRating
    @SerializedName("buy_status")
    public int getBuyStatus() {
        return this.buyStatus;
    }

    @Override // com.coolapk.market.model.NodeRating
    @SerializedName("is_owner")
    public int getIsOwner() {
        return this.isOwner;
    }

    @Override // com.coolapk.market.model.NodeRating
    @SerializedName("show_owner")
    public int getShowOwner() {
        return this.showOwner;
    }

    @Override // java.lang.Object
    public String toString() {
        return "NodeRating{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", targetType=" + this.targetType + ", targetId=" + this.targetId + ", star=" + this.star + ", feedId=" + this.feedId + ", userInfo=" + this.userInfo + ", targetInfo=" + this.targetInfo + ", buyStatus=" + this.buyStatus + ", isOwner=" + this.isOwner + ", showOwner=" + this.showOwner + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        UserInfo userInfo2;
        NodeTargetInfo nodeTargetInfo;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NodeRating)) {
            return false;
        }
        NodeRating nodeRating = (NodeRating) obj;
        String str2 = this.entityTypeName;
        if (str2 != null ? str2.equals(nodeRating.getEntityTypeName()) : nodeRating.getEntityTypeName() == null) {
            String str3 = this.entityTemplate;
            if (str3 != null ? str3.equals(nodeRating.getEntityTemplate()) : nodeRating.getEntityTemplate() == null) {
                String str4 = this.entityId;
                if (str4 != null ? str4.equals(nodeRating.getEntityId()) : nodeRating.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(nodeRating.getEntityFixed()) : nodeRating.getEntityFixed() == null) {
                        String str5 = this.title;
                        if (str5 != null ? str5.equals(nodeRating.getTitle()) : nodeRating.getTitle() == null) {
                            String str6 = this.url;
                            if (str6 != null ? str6.equals(nodeRating.getUrl()) : nodeRating.getUrl() == null) {
                                String str7 = this.description;
                                if (str7 != null ? str7.equals(nodeRating.getDescription()) : nodeRating.getDescription() == null) {
                                    String str8 = this.pic;
                                    if (str8 != null ? str8.equals(nodeRating.getPic()) : nodeRating.getPic() == null) {
                                        String str9 = this.logo;
                                        if (str9 != null ? str9.equals(nodeRating.getLogo()) : nodeRating.getLogo() == null) {
                                            String str10 = this.subTitle;
                                            if (str10 != null ? str10.equals(nodeRating.getSubTitle()) : nodeRating.getSubTitle() == null) {
                                                String str11 = this.id;
                                                if (str11 != null ? str11.equals(nodeRating.getId()) : nodeRating.getId() == null) {
                                                    String str12 = this.extraData;
                                                    if (str12 != null ? str12.equals(nodeRating.getExtraData()) : nodeRating.getExtraData() == null) {
                                                        Long l2 = this.dateline;
                                                        if (l2 != null ? l2.equals(nodeRating.getDateline()) : nodeRating.getDateline() == null) {
                                                            Long l3 = this.lastUpdate;
                                                            if (l3 != null ? l3.equals(nodeRating.getLastUpdate()) : nodeRating.getLastUpdate() == null) {
                                                                String str13 = this.targetType;
                                                                if (str13 != null ? str13.equals(nodeRating.getTargetType()) : nodeRating.getTargetType() == null) {
                                                                    String str14 = this.targetId;
                                                                    if (str14 != null ? str14.equals(nodeRating.getTargetId()) : nodeRating.getTargetId() == null) {
                                                                        if (this.star == nodeRating.getStar() && ((str = this.feedId) != null ? str.equals(nodeRating.getFeedId()) : nodeRating.getFeedId() == null) && ((userInfo2 = this.userInfo) != null ? userInfo2.equals(nodeRating.getUserInfo()) : nodeRating.getUserInfo() == null) && ((nodeTargetInfo = this.targetInfo) != null ? nodeTargetInfo.equals(nodeRating.getTargetInfo()) : nodeRating.getTargetInfo() == null) && this.buyStatus == nodeRating.getBuyStatus() && this.isOwner == nodeRating.getIsOwner() && this.showOwner == nodeRating.getShowOwner()) {
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
        String str12 = this.targetType;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.targetId;
        int hashCode16 = (((hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003) ^ this.star) * 1000003;
        String str14 = this.feedId;
        int hashCode17 = (hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode18 = (hashCode17 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        NodeTargetInfo nodeTargetInfo = this.targetInfo;
        if (nodeTargetInfo != null) {
            i = nodeTargetInfo.hashCode();
        }
        return ((((((hashCode18 ^ i) * 1000003) ^ this.buyStatus) * 1000003) ^ this.isOwner) * 1000003) ^ this.showOwner;
    }
}
