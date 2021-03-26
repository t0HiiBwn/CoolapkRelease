package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Gift  reason: invalid class name */
abstract class C$$AutoValue_Gift extends Gift {
    private final String apkId;
    private final String apkLogo;
    private final String apkName;
    private final String apkTitle;
    private final String author;
    private final String content;
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
    private final String extraAnalysisData;
    private final String extraData;
    private final String feedId;
    private final Integer get;
    private final String giftCard;
    private final String giftData;
    private final int giftExpires;
    private final String giftIntro;
    private final String giftUseable;
    private final String giftUsed;
    private final String id;
    private final String label;
    private final Long lastUpdate;
    private final String logo;
    private final String parentId;
    private final String pic;
    private final String pieId;
    private final String pieName;
    private final String relatedPackages;
    private final Integer requireInstalled;
    private final Integer status;
    private final String subTitle;
    private final String tags;
    private final String title;
    private final String totalCount;
    private final int type;
    private final String uid;
    private final String url;
    private final String useCount;
    private final UserInfo userInfo;

    C$$AutoValue_Gift(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, UserInfo userInfo2, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, int i2, String str28, String str29, String str30, String str31, String str32, String str33, String str34, int i3, String str35, String str36, Integer num2, Integer num3, Integer num4, String str37) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityTypeId = i;
        this.entityId = str4;
        this.entityFixed = num;
        this.url = str5;
        this.pic = str6;
        this.logo = str7;
        this.subTitle = str8;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.deprecatedUserAvatar = str9;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str10;
        this.displayUserName = str11;
        Objects.requireNonNull(str12, "Null title");
        this.title = str12;
        this.useCount = str13;
        this.totalCount = str14;
        this.giftData = str15;
        this.giftCard = str16;
        Objects.requireNonNull(str17, "Null id");
        this.id = str17;
        this.parentId = str18;
        Objects.requireNonNull(str19, "Null feedId");
        this.feedId = str19;
        Objects.requireNonNull(str20, "Null apkId");
        this.apkId = str20;
        Objects.requireNonNull(str21, "Null apkName");
        this.apkName = str21;
        Objects.requireNonNull(str22, "Null apkTitle");
        this.apkTitle = str22;
        Objects.requireNonNull(str23, "Null apkLogo");
        this.apkLogo = str23;
        this.pieId = str24;
        this.pieName = str25;
        this.uid = str26;
        this.author = str27;
        this.type = i2;
        this.label = str28;
        this.tags = str29;
        this.description = str30;
        this.content = str31;
        this.relatedPackages = str32;
        this.extraData = str33;
        this.giftUseable = str34;
        this.giftExpires = i3;
        this.giftIntro = str35;
        this.giftUsed = str36;
        this.status = num2;
        this.requireInstalled = num3;
        this.get = num4;
        this.extraAnalysisData = str37;
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
    @SerializedName("url")
    public String getUrl() {
        return this.url;
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

    @Override // com.coolapk.market.model.Gift, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Gift
    public String getUseCount() {
        return this.useCount;
    }

    @Override // com.coolapk.market.model.Gift
    public String getTotalCount() {
        return this.totalCount;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("gift_data")
    public String getGiftData() {
        return this.giftData;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("gift_card")
    public String getGiftCard() {
        return this.giftCard;
    }

    @Override // com.coolapk.market.model.Gift, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("parent_id")
    public String getParentId() {
        return this.parentId;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("feed_id")
    public String getFeedId() {
        return this.feedId;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("apk_id")
    public String getApkId() {
        return this.apkId;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("apk_name")
    public String getApkName() {
        return this.apkName;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("apk_title")
    public String getApkTitle() {
        return this.apkTitle;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("apk_logo")
    public String getApkLogo() {
        return this.apkLogo;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("pie_id")
    public String getPieId() {
        return this.pieId;
    }

    @Override // com.coolapk.market.model.Gift
    public String getPieName() {
        return this.pieName;
    }

    @Override // com.coolapk.market.model.Gift, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.Gift
    public String getAuthor() {
        return this.author;
    }

    @Override // com.coolapk.market.model.Gift
    public int getType() {
        return this.type;
    }

    @Override // com.coolapk.market.model.Gift
    public String getLabel() {
        return this.label;
    }

    @Override // com.coolapk.market.model.Gift
    public String getTags() {
        return this.tags;
    }

    @Override // com.coolapk.market.model.Gift, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Gift
    public String getContent() {
        return this.content;
    }

    @Override // com.coolapk.market.model.Gift
    public String getRelatedPackages() {
        return this.relatedPackages;
    }

    @Override // com.coolapk.market.model.Gift, com.coolapk.market.model.Entity
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.coolapk.market.model.Gift
    public String getGiftUseable() {
        return this.giftUseable;
    }

    @Override // com.coolapk.market.model.Gift
    public int getGiftExpires() {
        return this.giftExpires;
    }

    @Override // com.coolapk.market.model.Gift
    public String getGiftIntro() {
        return this.giftIntro;
    }

    @Override // com.coolapk.market.model.Gift
    public String getGiftUsed() {
        return this.giftUsed;
    }

    @Override // com.coolapk.market.model.Gift
    public Integer getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("is_require_installed")
    protected Integer getRequireInstalled() {
        return this.requireInstalled;
    }

    @Override // com.coolapk.market.model.Gift
    @SerializedName("isGet")
    protected Integer getGet() {
        return this.get;
    }

    @Override // com.coolapk.market.model.Gift
    public String getExtraAnalysisData() {
        return this.extraAnalysisData;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Gift{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", title=" + this.title + ", useCount=" + this.useCount + ", totalCount=" + this.totalCount + ", giftData=" + this.giftData + ", giftCard=" + this.giftCard + ", id=" + this.id + ", parentId=" + this.parentId + ", feedId=" + this.feedId + ", apkId=" + this.apkId + ", apkName=" + this.apkName + ", apkTitle=" + this.apkTitle + ", apkLogo=" + this.apkLogo + ", pieId=" + this.pieId + ", pieName=" + this.pieName + ", uid=" + this.uid + ", author=" + this.author + ", type=" + this.type + ", label=" + this.label + ", tags=" + this.tags + ", description=" + this.description + ", content=" + this.content + ", relatedPackages=" + this.relatedPackages + ", extraData=" + this.extraData + ", giftUseable=" + this.giftUseable + ", giftExpires=" + this.giftExpires + ", giftIntro=" + this.giftIntro + ", giftUsed=" + this.giftUsed + ", status=" + this.status + ", requireInstalled=" + this.requireInstalled + ", get=" + this.get + ", extraAnalysisData=" + this.extraAnalysisData + "}";
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
        Long l2;
        Long l3;
        String str7;
        UserInfo userInfo2;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        Integer num2;
        Integer num3;
        Integer num4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Gift)) {
            return false;
        }
        Gift gift = (Gift) obj;
        String str28 = this.entityTypeName;
        if (str28 != null ? str28.equals(gift.getEntityTypeName()) : gift.getEntityTypeName() == null) {
            if (this.entityType.equals(gift.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(gift.getEntityTemplate()) : gift.getEntityTemplate() == null) && this.entityTypeId == gift.getEntityTypeId() && ((str2 = this.entityId) != null ? str2.equals(gift.getEntityId()) : gift.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(gift.getEntityFixed()) : gift.getEntityFixed() == null) && ((str3 = this.url) != null ? str3.equals(gift.getUrl()) : gift.getUrl() == null) && ((str4 = this.pic) != null ? str4.equals(gift.getPic()) : gift.getPic() == null) && ((str5 = this.logo) != null ? str5.equals(gift.getLogo()) : gift.getLogo() == null) && ((str6 = this.subTitle) != null ? str6.equals(gift.getSubTitle()) : gift.getSubTitle() == null) && ((l2 = this.dateline) != null ? l2.equals(gift.getDateline()) : gift.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(gift.getLastUpdate()) : gift.getLastUpdate() == null) && ((str7 = this.deprecatedUserAvatar) != null ? str7.equals(gift.getDeprecatedUserAvatar()) : gift.getDeprecatedUserAvatar() == null) && ((userInfo2 = this.userInfo) != null ? userInfo2.equals(gift.getUserInfo()) : gift.getUserInfo() == null) && ((str8 = this.deprecatedUserName) != null ? str8.equals(gift.getDeprecatedUserName()) : gift.getDeprecatedUserName() == null) && ((str9 = this.displayUserName) != null ? str9.equals(gift.getDisplayUserName()) : gift.getDisplayUserName() == null) && this.title.equals(gift.getTitle()) && ((str10 = this.useCount) != null ? str10.equals(gift.getUseCount()) : gift.getUseCount() == null) && ((str11 = this.totalCount) != null ? str11.equals(gift.getTotalCount()) : gift.getTotalCount() == null) && ((str12 = this.giftData) != null ? str12.equals(gift.getGiftData()) : gift.getGiftData() == null) && ((str13 = this.giftCard) != null ? str13.equals(gift.getGiftCard()) : gift.getGiftCard() == null) && this.id.equals(gift.getId()) && ((str14 = this.parentId) != null ? str14.equals(gift.getParentId()) : gift.getParentId() == null) && this.feedId.equals(gift.getFeedId()) && this.apkId.equals(gift.getApkId()) && this.apkName.equals(gift.getApkName()) && this.apkTitle.equals(gift.getApkTitle()) && this.apkLogo.equals(gift.getApkLogo()) && ((str15 = this.pieId) != null ? str15.equals(gift.getPieId()) : gift.getPieId() == null) && ((str16 = this.pieName) != null ? str16.equals(gift.getPieName()) : gift.getPieName() == null) && ((str17 = this.uid) != null ? str17.equals(gift.getUid()) : gift.getUid() == null) && ((str18 = this.author) != null ? str18.equals(gift.getAuthor()) : gift.getAuthor() == null) && this.type == gift.getType() && ((str19 = this.label) != null ? str19.equals(gift.getLabel()) : gift.getLabel() == null) && ((str20 = this.tags) != null ? str20.equals(gift.getTags()) : gift.getTags() == null) && ((str21 = this.description) != null ? str21.equals(gift.getDescription()) : gift.getDescription() == null) && ((str22 = this.content) != null ? str22.equals(gift.getContent()) : gift.getContent() == null) && ((str23 = this.relatedPackages) != null ? str23.equals(gift.getRelatedPackages()) : gift.getRelatedPackages() == null) && ((str24 = this.extraData) != null ? str24.equals(gift.getExtraData()) : gift.getExtraData() == null) && ((str25 = this.giftUseable) != null ? str25.equals(gift.getGiftUseable()) : gift.getGiftUseable() == null) && this.giftExpires == gift.getGiftExpires() && ((str26 = this.giftIntro) != null ? str26.equals(gift.getGiftIntro()) : gift.getGiftIntro() == null) && ((str27 = this.giftUsed) != null ? str27.equals(gift.getGiftUsed()) : gift.getGiftUsed() == null) && ((num2 = this.status) != null ? num2.equals(gift.getStatus()) : gift.getStatus() == null) && ((num3 = this.requireInstalled) != null ? num3.equals(gift.getRequireInstalled()) : gift.getRequireInstalled() == null) && ((num4 = this.get) != null ? num4.equals(gift.getGet()) : gift.getGet() == null)) {
                String str29 = this.extraAnalysisData;
                if (str29 == null) {
                    if (gift.getExtraAnalysisData() == null) {
                        return true;
                    }
                } else if (str29.equals(gift.getExtraAnalysisData())) {
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
        String str4 = this.url;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.pic;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.logo;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.subTitle;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode9 = (hashCode8 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode10 = (hashCode9 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str8 = this.deprecatedUserAvatar;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode12 = (hashCode11 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str9 = this.deprecatedUserName;
        int hashCode13 = (hashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.displayUserName;
        int hashCode14 = (((hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003) ^ this.title.hashCode()) * 1000003;
        String str11 = this.useCount;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.totalCount;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.giftData;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.giftCard;
        int hashCode18 = (((hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003;
        String str15 = this.parentId;
        int hashCode19 = (((((((((((hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.feedId.hashCode()) * 1000003) ^ this.apkId.hashCode()) * 1000003) ^ this.apkName.hashCode()) * 1000003) ^ this.apkTitle.hashCode()) * 1000003) ^ this.apkLogo.hashCode()) * 1000003;
        String str16 = this.pieId;
        int hashCode20 = (hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.pieName;
        int hashCode21 = (hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.uid;
        int hashCode22 = (hashCode21 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.author;
        int hashCode23 = (((hashCode22 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003) ^ this.type) * 1000003;
        String str20 = this.label;
        int hashCode24 = (hashCode23 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        String str21 = this.tags;
        int hashCode25 = (hashCode24 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003;
        String str22 = this.description;
        int hashCode26 = (hashCode25 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003;
        String str23 = this.content;
        int hashCode27 = (hashCode26 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
        String str24 = this.relatedPackages;
        int hashCode28 = (hashCode27 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
        String str25 = this.extraData;
        int hashCode29 = (hashCode28 ^ (str25 == null ? 0 : str25.hashCode())) * 1000003;
        String str26 = this.giftUseable;
        int hashCode30 = (((hashCode29 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003) ^ this.giftExpires) * 1000003;
        String str27 = this.giftIntro;
        int hashCode31 = (hashCode30 ^ (str27 == null ? 0 : str27.hashCode())) * 1000003;
        String str28 = this.giftUsed;
        int hashCode32 = (hashCode31 ^ (str28 == null ? 0 : str28.hashCode())) * 1000003;
        Integer num2 = this.status;
        int hashCode33 = (hashCode32 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Integer num3 = this.requireInstalled;
        int hashCode34 = (hashCode33 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
        Integer num4 = this.get;
        int hashCode35 = (hashCode34 ^ (num4 == null ? 0 : num4.hashCode())) * 1000003;
        String str29 = this.extraAnalysisData;
        if (str29 != null) {
            i = str29.hashCode();
        }
        return hashCode35 ^ i;
    }
}
