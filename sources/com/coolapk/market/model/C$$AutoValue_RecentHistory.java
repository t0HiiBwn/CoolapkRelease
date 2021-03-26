package com.coolapk.market.model;

import com.coolapk.market.model.RecentHistory;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_RecentHistory  reason: invalid class name */
abstract class C$$AutoValue_RecentHistory extends RecentHistory {
    private final int answerNum;
    private final int commentNum;
    private final int count;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final int fansNum;
    private final int followNum;
    private final String id;
    private final int isTop;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String targetId;
    private final String targetType;
    private final String title;
    private final String uid;
    private final String url;

    C$$AutoValue_RecentHistory(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, int i, int i2, String str12, String str13, String str14, int i3, int i4, int i5, int i6) {
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
        this.extraData = str10;
        this.dateline = l2;
        this.lastUpdate = l3;
        Objects.requireNonNull(str11, "Null id");
        this.id = str11;
        this.count = i;
        this.isTop = i2;
        this.targetId = str12;
        this.targetType = str13;
        this.uid = str14;
        this.followNum = i3;
        this.commentNum = i4;
        this.fansNum = i5;
        this.answerNum = i6;
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

    @Override // com.coolapk.market.model.RecentHistory, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.RecentHistory
    public int getCount() {
        return this.count;
    }

    @Override // com.coolapk.market.model.RecentHistory
    @SerializedName("is_top")
    public int getIsTop() {
        return this.isTop;
    }

    @Override // com.coolapk.market.model.RecentHistory
    @SerializedName("target_id")
    public String getTargetId() {
        return this.targetId;
    }

    @Override // com.coolapk.market.model.RecentHistory
    @SerializedName("target_type")
    public String getTargetType() {
        return this.targetType;
    }

    @Override // com.coolapk.market.model.RecentHistory
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.RecentHistory
    @SerializedName("follow_num")
    public int getFollowNum() {
        return this.followNum;
    }

    @Override // com.coolapk.market.model.RecentHistory
    @SerializedName("comment_num")
    public int getCommentNum() {
        return this.commentNum;
    }

    @Override // com.coolapk.market.model.RecentHistory
    @SerializedName("fans_num")
    public int getFansNum() {
        return this.fansNum;
    }

    @Override // com.coolapk.market.model.RecentHistory
    @SerializedName("answer_num")
    public int getAnswerNum() {
        return this.answerNum;
    }

    @Override // java.lang.Object
    public String toString() {
        return "RecentHistory{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", count=" + this.count + ", isTop=" + this.isTop + ", targetId=" + this.targetId + ", targetType=" + this.targetType + ", uid=" + this.uid + ", followNum=" + this.followNum + ", commentNum=" + this.commentNum + ", fansNum=" + this.fansNum + ", answerNum=" + this.answerNum + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecentHistory)) {
            return false;
        }
        RecentHistory recentHistory = (RecentHistory) obj;
        String str4 = this.entityTypeName;
        if (str4 != null ? str4.equals(recentHistory.getEntityTypeName()) : recentHistory.getEntityTypeName() == null) {
            String str5 = this.entityTemplate;
            if (str5 != null ? str5.equals(recentHistory.getEntityTemplate()) : recentHistory.getEntityTemplate() == null) {
                String str6 = this.entityId;
                if (str6 != null ? str6.equals(recentHistory.getEntityId()) : recentHistory.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(recentHistory.getEntityFixed()) : recentHistory.getEntityFixed() == null) {
                        String str7 = this.title;
                        if (str7 != null ? str7.equals(recentHistory.getTitle()) : recentHistory.getTitle() == null) {
                            String str8 = this.url;
                            if (str8 != null ? str8.equals(recentHistory.getUrl()) : recentHistory.getUrl() == null) {
                                String str9 = this.description;
                                if (str9 != null ? str9.equals(recentHistory.getDescription()) : recentHistory.getDescription() == null) {
                                    String str10 = this.pic;
                                    if (str10 != null ? str10.equals(recentHistory.getPic()) : recentHistory.getPic() == null) {
                                        String str11 = this.logo;
                                        if (str11 != null ? str11.equals(recentHistory.getLogo()) : recentHistory.getLogo() == null) {
                                            String str12 = this.subTitle;
                                            if (str12 != null ? str12.equals(recentHistory.getSubTitle()) : recentHistory.getSubTitle() == null) {
                                                String str13 = this.extraData;
                                                if (str13 != null ? str13.equals(recentHistory.getExtraData()) : recentHistory.getExtraData() == null) {
                                                    Long l2 = this.dateline;
                                                    if (l2 != null ? l2.equals(recentHistory.getDateline()) : recentHistory.getDateline() == null) {
                                                        Long l3 = this.lastUpdate;
                                                        if (l3 != null ? l3.equals(recentHistory.getLastUpdate()) : recentHistory.getLastUpdate() == null) {
                                                            if (this.id.equals(recentHistory.getId()) && this.count == recentHistory.getCount() && this.isTop == recentHistory.getIsTop() && ((str = this.targetId) != null ? str.equals(recentHistory.getTargetId()) : recentHistory.getTargetId() == null) && ((str2 = this.targetType) != null ? str2.equals(recentHistory.getTargetType()) : recentHistory.getTargetType() == null) && ((str3 = this.uid) != null ? str3.equals(recentHistory.getUid()) : recentHistory.getUid() == null) && this.followNum == recentHistory.getFollowNum() && this.commentNum == recentHistory.getCommentNum() && this.fansNum == recentHistory.getFansNum() && this.answerNum == recentHistory.getAnswerNum()) {
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
        String str10 = this.extraData;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode12 = (hashCode11 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode13 = (((((((hashCode12 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.count) * 1000003) ^ this.isTop) * 1000003;
        String str11 = this.targetId;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.targetType;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.uid;
        if (str13 != null) {
            i = str13.hashCode();
        }
        return ((((((((hashCode15 ^ i) * 1000003) ^ this.followNum) * 1000003) ^ this.commentNum) * 1000003) ^ this.fansNum) * 1000003) ^ this.answerNum;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_RecentHistory$Builder */
    /* compiled from: $$AutoValue_RecentHistory */
    static final class Builder extends RecentHistory.Builder {
        private Integer answerNum;
        private Integer commentNum;
        private Integer count;
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private Integer fansNum;
        private Integer followNum;
        private String id;
        private Integer isTop;
        private Long lastUpdate;
        private String logo;
        private String pic;
        private String subTitle;
        private String targetId;
        private String targetType;
        private String title;
        private String uid;
        private String url;

        Builder() {
        }

        Builder(RecentHistory recentHistory) {
            this.entityTypeName = recentHistory.getEntityTypeName();
            this.entityTemplate = recentHistory.getEntityTemplate();
            this.entityId = recentHistory.getEntityId();
            this.entityFixed = recentHistory.getEntityFixed();
            this.title = recentHistory.getTitle();
            this.url = recentHistory.getUrl();
            this.description = recentHistory.getDescription();
            this.pic = recentHistory.getPic();
            this.logo = recentHistory.getLogo();
            this.subTitle = recentHistory.getSubTitle();
            this.extraData = recentHistory.getExtraData();
            this.dateline = recentHistory.getDateline();
            this.lastUpdate = recentHistory.getLastUpdate();
            this.id = recentHistory.getId();
            this.count = Integer.valueOf(recentHistory.getCount());
            this.isTop = Integer.valueOf(recentHistory.getIsTop());
            this.targetId = recentHistory.getTargetId();
            this.targetType = recentHistory.getTargetType();
            this.uid = recentHistory.getUid();
            this.followNum = Integer.valueOf(recentHistory.getFollowNum());
            this.commentNum = Integer.valueOf(recentHistory.getCommentNum());
            this.fansNum = Integer.valueOf(recentHistory.getFansNum());
            this.answerNum = Integer.valueOf(recentHistory.getAnswerNum());
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setDateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setLastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setCount(int i) {
            this.count = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setIsTop(int i) {
            this.isTop = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setTargetId(String str) {
            this.targetId = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setTargetType(String str) {
            this.targetType = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setFollowNum(int i) {
            this.followNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setCommentNum(int i) {
            this.commentNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setFansNum(int i) {
            this.fansNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory.Builder setAnswerNum(int i) {
            this.answerNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.RecentHistory.Builder
        public RecentHistory build() {
            String str = "";
            if (this.id == null) {
                str = str + " id";
            }
            if (this.count == null) {
                str = str + " count";
            }
            if (this.isTop == null) {
                str = str + " isTop";
            }
            if (this.followNum == null) {
                str = str + " followNum";
            }
            if (this.commentNum == null) {
                str = str + " commentNum";
            }
            if (this.fansNum == null) {
                str = str + " fansNum";
            }
            if (this.answerNum == null) {
                str = str + " answerNum";
            }
            if (str.isEmpty()) {
                return new AutoValue_RecentHistory(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.extraData, this.dateline, this.lastUpdate, this.id, this.count.intValue(), this.isTop.intValue(), this.targetId, this.targetType, this.uid, this.followNum.intValue(), this.commentNum.intValue(), this.fansNum.intValue(), this.answerNum.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
