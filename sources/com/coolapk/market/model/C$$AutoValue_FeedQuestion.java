package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_FeedQuestion  reason: invalid class name */
abstract class C$$AutoValue_FeedQuestion extends FeedQuestion {
    private final int blockStatus;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String displayUserName;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String message;
    private final int messageStatus;
    private final String messageTitle;
    private final String pic;
    private final int questionAnswerNum;
    private final int questionFollowNum;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_FeedQuestion(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, UserInfo userInfo2, String str13, String str14, String str15, int i2, String str16, int i3, String str17, int i4, int i5, String str18) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityTypeId = i;
        this.entityId = str4;
        this.entityFixed = num;
        this.title = str5;
        this.url = str6;
        this.description = str7;
        this.pic = str8;
        this.logo = str9;
        this.subTitle = str10;
        this.extraData = str11;
        this.dateline = l;
        this.lastUpdate = l2;
        this.deprecatedUserAvatar = str12;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str13;
        this.displayUserName = str14;
        this.message = str15;
        this.blockStatus = i2;
        Objects.requireNonNull(str16, "Null id");
        this.id = str16;
        this.messageStatus = i3;
        this.messageTitle = str17;
        this.questionAnswerNum = i4;
        this.questionFollowNum = i5;
        this.uid = str18;
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

    @Override // com.coolapk.market.model.IUser
    @SerializedName("userAvatar")
    public String getDeprecatedUserAvatar() {
        return this.deprecatedUserAvatar;
    }

    @Override // com.coolapk.market.model.IUser
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("username")
    public String getDeprecatedUserName() {
        return this.deprecatedUserName;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("displayUsername")
    public String getDisplayUserName() {
        return this.displayUserName;
    }

    @Override // com.coolapk.market.model.FeedQuestion
    public String getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.FeedQuestion
    @SerializedName("block_status")
    public int getBlockStatus() {
        return this.blockStatus;
    }

    @Override // com.coolapk.market.model.FeedQuestion, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.FeedQuestion
    @SerializedName("message_status")
    public int getMessageStatus() {
        return this.messageStatus;
    }

    @Override // com.coolapk.market.model.FeedQuestion
    @SerializedName("message_title")
    public String getMessageTitle() {
        return this.messageTitle;
    }

    @Override // com.coolapk.market.model.FeedQuestion
    @SerializedName("question_answer_num")
    public int getQuestionAnswerNum() {
        return this.questionAnswerNum;
    }

    @Override // com.coolapk.market.model.FeedQuestion
    @SerializedName("question_follow_num")
    public int getQuestionFollowNum() {
        return this.questionFollowNum;
    }

    @Override // com.coolapk.market.model.FeedQuestion, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FeedQuestion{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", message=" + this.message + ", blockStatus=" + this.blockStatus + ", id=" + this.id + ", messageStatus=" + this.messageStatus + ", messageTitle=" + this.messageTitle + ", questionAnswerNum=" + this.questionAnswerNum + ", questionFollowNum=" + this.questionFollowNum + ", uid=" + this.uid + "}";
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
        Long l;
        Long l2;
        String str10;
        UserInfo userInfo2;
        String str11;
        String str12;
        String str13;
        String str14;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedQuestion)) {
            return false;
        }
        FeedQuestion feedQuestion = (FeedQuestion) obj;
        String str15 = this.entityTypeName;
        if (str15 != null ? str15.equals(feedQuestion.getEntityTypeName()) : feedQuestion.getEntityTypeName() == null) {
            if (this.entityType.equals(feedQuestion.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(feedQuestion.getEntityTemplate()) : feedQuestion.getEntityTemplate() == null) && this.entityTypeId == feedQuestion.getEntityTypeId() && ((str2 = this.entityId) != null ? str2.equals(feedQuestion.getEntityId()) : feedQuestion.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(feedQuestion.getEntityFixed()) : feedQuestion.getEntityFixed() == null) && ((str3 = this.title) != null ? str3.equals(feedQuestion.getTitle()) : feedQuestion.getTitle() == null) && ((str4 = this.url) != null ? str4.equals(feedQuestion.getUrl()) : feedQuestion.getUrl() == null) && ((str5 = this.description) != null ? str5.equals(feedQuestion.getDescription()) : feedQuestion.getDescription() == null) && ((str6 = this.pic) != null ? str6.equals(feedQuestion.getPic()) : feedQuestion.getPic() == null) && ((str7 = this.logo) != null ? str7.equals(feedQuestion.getLogo()) : feedQuestion.getLogo() == null) && ((str8 = this.subTitle) != null ? str8.equals(feedQuestion.getSubTitle()) : feedQuestion.getSubTitle() == null) && ((str9 = this.extraData) != null ? str9.equals(feedQuestion.getExtraData()) : feedQuestion.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(feedQuestion.getDateline()) : feedQuestion.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(feedQuestion.getLastUpdate()) : feedQuestion.getLastUpdate() == null) && ((str10 = this.deprecatedUserAvatar) != null ? str10.equals(feedQuestion.getDeprecatedUserAvatar()) : feedQuestion.getDeprecatedUserAvatar() == null) && ((userInfo2 = this.userInfo) != null ? userInfo2.equals(feedQuestion.getUserInfo()) : feedQuestion.getUserInfo() == null) && ((str11 = this.deprecatedUserName) != null ? str11.equals(feedQuestion.getDeprecatedUserName()) : feedQuestion.getDeprecatedUserName() == null) && ((str12 = this.displayUserName) != null ? str12.equals(feedQuestion.getDisplayUserName()) : feedQuestion.getDisplayUserName() == null) && ((str13 = this.message) != null ? str13.equals(feedQuestion.getMessage()) : feedQuestion.getMessage() == null) && this.blockStatus == feedQuestion.getBlockStatus() && this.id.equals(feedQuestion.getId()) && this.messageStatus == feedQuestion.getMessageStatus() && ((str14 = this.messageTitle) != null ? str14.equals(feedQuestion.getMessageTitle()) : feedQuestion.getMessageTitle() == null) && this.questionAnswerNum == feedQuestion.getQuestionAnswerNum() && this.questionFollowNum == feedQuestion.getQuestionFollowNum()) {
                String str16 = this.uid;
                if (str16 == null) {
                    if (feedQuestion.getUid() == null) {
                        return true;
                    }
                } else if (str16.equals(feedQuestion.getUid())) {
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
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.entityType.hashCode()) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.entityTypeId) * 1000003;
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
        Long l = this.dateline;
        int hashCode12 = (hashCode11 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode13 = (hashCode12 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str11 = this.deprecatedUserAvatar;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode15 = (hashCode14 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str12 = this.deprecatedUserName;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.displayUserName;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.message;
        int hashCode18 = (((((((hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.blockStatus) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.messageStatus) * 1000003;
        String str15 = this.messageTitle;
        int hashCode19 = (((((hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.questionAnswerNum) * 1000003) ^ this.questionFollowNum) * 1000003;
        String str16 = this.uid;
        if (str16 != null) {
            i = str16.hashCode();
        }
        return hashCode19 ^ i;
    }
}
