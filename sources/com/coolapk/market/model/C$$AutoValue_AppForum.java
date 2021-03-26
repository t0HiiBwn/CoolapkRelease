package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_AppForum  reason: invalid class name */
abstract class C$$AutoValue_AppForum extends AppForum {
    private final String apkName;
    private final String apkSize;
    private final int apkType;
    private final String appName;
    private final String appUrl;
    private final int commentBlockNum;
    private final String commentCount;
    private final String downCount;
    private final String extendFile;
    private final String extraAnalysisData;
    private final String followCount;
    private final Long getDateline;
    private final String getDescription;
    private final Integer getEntityFixed;
    private final String getEntityId;
    private final String getEntityTemplate;
    private final String getExtraData;
    private final String getId;
    private final Long getLastUpdate;
    private final String getLogo;
    private final String getPic;
    private final String getSubTitle;
    private final String getTargetId;
    private final String getTitle;
    private final String getUrl;
    private final String introduce;
    private final int is_download_app;
    private final String packageName;
    private final List<String> screenList;
    private final int supportAndroidVersion;
    private final List<String> thumbList;
    private final UserAction userAction;
    private final int versionCode;
    private final String versionName;

    C$$AutoValue_AppForum(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, String str12, int i, String str13, String str14, String str15, int i2, int i3, String str16, String str17, String str18, String str19, String str20, String str21, int i4, UserAction userAction2, int i5, String str22, String str23, List<String> list, List<String> list2) {
        this.getEntityTemplate = str;
        this.getEntityId = str2;
        this.getEntityFixed = num;
        this.getTitle = str3;
        this.getUrl = str4;
        this.getDescription = str5;
        this.getPic = str6;
        this.getLogo = str7;
        this.getSubTitle = str8;
        this.getId = str9;
        this.getExtraData = str10;
        this.getDateline = l;
        this.getLastUpdate = l2;
        Objects.requireNonNull(str11, "Null getTargetId");
        this.getTargetId = str11;
        Objects.requireNonNull(str12, "Null appName");
        this.appName = str12;
        this.apkType = i;
        Objects.requireNonNull(str13, "Null apkName");
        this.apkName = str13;
        this.apkSize = str14;
        Objects.requireNonNull(str15, "Null versionName");
        this.versionName = str15;
        this.versionCode = i2;
        this.supportAndroidVersion = i3;
        this.extendFile = str16;
        Objects.requireNonNull(str17, "Null followCount");
        this.followCount = str17;
        this.downCount = str18;
        Objects.requireNonNull(str19, "Null commentCount");
        this.commentCount = str19;
        this.packageName = str20;
        this.appUrl = str21;
        this.is_download_app = i4;
        this.userAction = userAction2;
        this.commentBlockNum = i5;
        this.extraAnalysisData = str22;
        this.introduce = str23;
        this.thumbList = list;
        this.screenList = list2;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTemplate")
    public String getEntityTemplate() {
        return this.getEntityTemplate;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityId")
    public String getEntityId() {
        return this.getEntityId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityFixed")
    public Integer getEntityFixed() {
        return this.getEntityFixed;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.getTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.getUrl;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.getDescription;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.getPic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.getLogo;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.getSubTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.getId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("extraData")
    public String getExtraData() {
        return this.getExtraData;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public Long getDateline() {
        return this.getDateline;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.getLastUpdate;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("target_id")
    public String getTargetId() {
        return this.getTargetId;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("shorttitle")
    public String appName() {
        return this.appName;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("apktype")
    public int apkType() {
        return this.apkType;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("apkname")
    public String apkName() {
        return this.apkName;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("apksize")
    public String apkSize() {
        return this.apkSize;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("apkversionname")
    public String versionName() {
        return this.versionName;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("apkversioncode")
    public int versionCode() {
        return this.versionCode;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("sdkversion")
    public int supportAndroidVersion() {
        return this.supportAndroidVersion;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("extendfile")
    public String extendFile() {
        return this.extendFile;
    }

    @Override // com.coolapk.market.model.AppForum
    public String followCount() {
        return this.followCount;
    }

    @Override // com.coolapk.market.model.AppForum
    public String downCount() {
        return this.downCount;
    }

    @Override // com.coolapk.market.model.AppForum
    public String commentCount() {
        return this.commentCount;
    }

    @Override // com.coolapk.market.model.AppForum
    public String packageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.AppForum
    public String appUrl() {
        return this.appUrl;
    }

    @Override // com.coolapk.market.model.AppForum
    protected int is_download_app() {
        return this.is_download_app;
    }

    @Override // com.coolapk.market.model.AppForum
    public UserAction userAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.AppForum
    @SerializedName("comment_block_num")
    public int commentBlockNum() {
        return this.commentBlockNum;
    }

    @Override // com.coolapk.market.model.AppForum
    public String extraAnalysisData() {
        return this.extraAnalysisData;
    }

    @Override // com.coolapk.market.model.AppForum
    public String introduce() {
        return this.introduce;
    }

    @Override // com.coolapk.market.model.AppForum
    public List<String> thumbList() {
        return this.thumbList;
    }

    @Override // com.coolapk.market.model.AppForum
    public List<String> screenList() {
        return this.screenList;
    }

    @Override // java.lang.Object
    public String toString() {
        return "AppForum{getEntityTemplate=" + this.getEntityTemplate + ", getEntityId=" + this.getEntityId + ", getEntityFixed=" + this.getEntityFixed + ", getTitle=" + this.getTitle + ", getUrl=" + this.getUrl + ", getDescription=" + this.getDescription + ", getPic=" + this.getPic + ", getLogo=" + this.getLogo + ", getSubTitle=" + this.getSubTitle + ", getId=" + this.getId + ", getExtraData=" + this.getExtraData + ", getDateline=" + this.getDateline + ", getLastUpdate=" + this.getLastUpdate + ", getTargetId=" + this.getTargetId + ", appName=" + this.appName + ", apkType=" + this.apkType + ", apkName=" + this.apkName + ", apkSize=" + this.apkSize + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", supportAndroidVersion=" + this.supportAndroidVersion + ", extendFile=" + this.extendFile + ", followCount=" + this.followCount + ", downCount=" + this.downCount + ", commentCount=" + this.commentCount + ", packageName=" + this.packageName + ", appUrl=" + this.appUrl + ", is_download_app=" + this.is_download_app + ", userAction=" + this.userAction + ", commentBlockNum=" + this.commentBlockNum + ", extraAnalysisData=" + this.extraAnalysisData + ", introduce=" + this.introduce + ", thumbList=" + this.thumbList + ", screenList=" + this.screenList + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        UserAction userAction2;
        String str6;
        String str7;
        List<String> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppForum)) {
            return false;
        }
        AppForum appForum = (AppForum) obj;
        String str8 = this.getEntityTemplate;
        if (str8 != null ? str8.equals(appForum.getEntityTemplate()) : appForum.getEntityTemplate() == null) {
            String str9 = this.getEntityId;
            if (str9 != null ? str9.equals(appForum.getEntityId()) : appForum.getEntityId() == null) {
                Integer num = this.getEntityFixed;
                if (num != null ? num.equals(appForum.getEntityFixed()) : appForum.getEntityFixed() == null) {
                    String str10 = this.getTitle;
                    if (str10 != null ? str10.equals(appForum.getTitle()) : appForum.getTitle() == null) {
                        String str11 = this.getUrl;
                        if (str11 != null ? str11.equals(appForum.getUrl()) : appForum.getUrl() == null) {
                            String str12 = this.getDescription;
                            if (str12 != null ? str12.equals(appForum.getDescription()) : appForum.getDescription() == null) {
                                String str13 = this.getPic;
                                if (str13 != null ? str13.equals(appForum.getPic()) : appForum.getPic() == null) {
                                    String str14 = this.getLogo;
                                    if (str14 != null ? str14.equals(appForum.getLogo()) : appForum.getLogo() == null) {
                                        String str15 = this.getSubTitle;
                                        if (str15 != null ? str15.equals(appForum.getSubTitle()) : appForum.getSubTitle() == null) {
                                            String str16 = this.getId;
                                            if (str16 != null ? str16.equals(appForum.getId()) : appForum.getId() == null) {
                                                String str17 = this.getExtraData;
                                                if (str17 != null ? str17.equals(appForum.getExtraData()) : appForum.getExtraData() == null) {
                                                    Long l = this.getDateline;
                                                    if (l != null ? l.equals(appForum.getDateline()) : appForum.getDateline() == null) {
                                                        Long l2 = this.getLastUpdate;
                                                        if (l2 != null ? l2.equals(appForum.getLastUpdate()) : appForum.getLastUpdate() == null) {
                                                            if (this.getTargetId.equals(appForum.getTargetId()) && this.appName.equals(appForum.appName()) && this.apkType == appForum.apkType() && this.apkName.equals(appForum.apkName()) && ((str = this.apkSize) != null ? str.equals(appForum.apkSize()) : appForum.apkSize() == null) && this.versionName.equals(appForum.versionName()) && this.versionCode == appForum.versionCode() && this.supportAndroidVersion == appForum.supportAndroidVersion() && ((str2 = this.extendFile) != null ? str2.equals(appForum.extendFile()) : appForum.extendFile() == null) && this.followCount.equals(appForum.followCount()) && ((str3 = this.downCount) != null ? str3.equals(appForum.downCount()) : appForum.downCount() == null) && this.commentCount.equals(appForum.commentCount()) && ((str4 = this.packageName) != null ? str4.equals(appForum.packageName()) : appForum.packageName() == null) && ((str5 = this.appUrl) != null ? str5.equals(appForum.appUrl()) : appForum.appUrl() == null) && this.is_download_app == appForum.is_download_app() && ((userAction2 = this.userAction) != null ? userAction2.equals(appForum.userAction()) : appForum.userAction() == null) && this.commentBlockNum == appForum.commentBlockNum() && ((str6 = this.extraAnalysisData) != null ? str6.equals(appForum.extraAnalysisData()) : appForum.extraAnalysisData() == null) && ((str7 = this.introduce) != null ? str7.equals(appForum.introduce()) : appForum.introduce() == null) && ((list = this.thumbList) != null ? list.equals(appForum.thumbList()) : appForum.thumbList() == null)) {
                                                                List<String> list2 = this.screenList;
                                                                if (list2 == null) {
                                                                    if (appForum.screenList() == null) {
                                                                        return true;
                                                                    }
                                                                } else if (list2.equals(appForum.screenList())) {
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
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.getEntityTemplate;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.getEntityId;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.getEntityFixed;
        int hashCode3 = (hashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str3 = this.getTitle;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.getUrl;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.getDescription;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.getPic;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.getLogo;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.getSubTitle;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.getId;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.getExtraData;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l = this.getDateline;
        int hashCode12 = (hashCode11 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.getLastUpdate;
        int hashCode13 = (((((((((hashCode12 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ this.getTargetId.hashCode()) * 1000003) ^ this.appName.hashCode()) * 1000003) ^ this.apkType) * 1000003) ^ this.apkName.hashCode()) * 1000003;
        String str11 = this.apkSize;
        int hashCode14 = (((((((hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.versionCode) * 1000003) ^ this.supportAndroidVersion) * 1000003;
        String str12 = this.extendFile;
        int hashCode15 = (((hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003) ^ this.followCount.hashCode()) * 1000003;
        String str13 = this.downCount;
        int hashCode16 = (((hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003) ^ this.commentCount.hashCode()) * 1000003;
        String str14 = this.packageName;
        int hashCode17 = (hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.appUrl;
        int hashCode18 = (((hashCode17 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.is_download_app) * 1000003;
        UserAction userAction2 = this.userAction;
        int hashCode19 = (((hashCode18 ^ (userAction2 == null ? 0 : userAction2.hashCode())) * 1000003) ^ this.commentBlockNum) * 1000003;
        String str16 = this.extraAnalysisData;
        int hashCode20 = (hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.introduce;
        int hashCode21 = (hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        List<String> list = this.thumbList;
        int hashCode22 = (hashCode21 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.screenList;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode22 ^ i;
    }
}
