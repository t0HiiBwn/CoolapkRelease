package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.coolapk.market.model.$$AutoValue_BackupInfo  reason: invalid class name */
abstract class C$$AutoValue_BackupInfo extends BackupInfo {
    private final int apkNum;
    private final int backNum;
    private final Long createTime;
    private final Long dateline;
    private final String description;
    private final String deviceName;
    private final String deviceTitle;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final List<LocalApp> localApps;
    private final String logo;
    private final String pic;
    private final Long recoveryTime;
    private final List<ServiceApp> serviceApps;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final String userName;
    private final String versionMD5;

    C$$AutoValue_BackupInfo(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, int i2, Long l4, Long l5, List<ServiceApp> list, List<LocalApp> list2) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.url = str4;
        this.description = str5;
        this.pic = str6;
        this.logo = str7;
        this.subTitle = str8;
        this.extraData = str9;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.id = str10;
        this.title = str11;
        this.uid = str12;
        this.userName = str13;
        this.versionMD5 = str14;
        this.deviceName = str15;
        this.deviceTitle = str16;
        this.apkNum = i;
        this.backNum = i2;
        this.recoveryTime = l4;
        this.createTime = l5;
        this.serviceApps = list;
        this.localApps = list2;
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

    @Override // com.coolapk.market.model.BackupInfo, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.BackupInfo, com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("uid")
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("username")
    public String getUserName() {
        return this.userName;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("version_md5")
    public String getVersionMD5() {
        return this.versionMD5;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("device_name")
    public String getDeviceName() {
        return this.deviceName;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("device_title")
    public String getDeviceTitle() {
        return this.deviceTitle;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("apk_num")
    public int getApkNum() {
        return this.apkNum;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("backNum")
    public int getBackNum() {
        return this.backNum;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("recovery_time")
    public Long getRecoveryTime() {
        return this.recoveryTime;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("createdate")
    public Long getCreateTime() {
        return this.createTime;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("localEntities")
    public List<ServiceApp> getServiceApps() {
        return this.serviceApps;
    }

    @Override // com.coolapk.market.model.BackupInfo
    @SerializedName("unLocalEntities")
    public List<LocalApp> getLocalApps() {
        return this.localApps;
    }

    @Override // java.lang.Object
    public String toString() {
        return "BackupInfo{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", title=" + this.title + ", uid=" + this.uid + ", userName=" + this.userName + ", versionMD5=" + this.versionMD5 + ", deviceName=" + this.deviceName + ", deviceTitle=" + this.deviceTitle + ", apkNum=" + this.apkNum + ", backNum=" + this.backNum + ", recoveryTime=" + this.recoveryTime + ", createTime=" + this.createTime + ", serviceApps=" + this.serviceApps + ", localApps=" + this.localApps + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        Long l2;
        Long l3;
        List<ServiceApp> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackupInfo)) {
            return false;
        }
        BackupInfo backupInfo = (BackupInfo) obj;
        String str = this.entityTypeName;
        if (str != null ? str.equals(backupInfo.getEntityTypeName()) : backupInfo.getEntityTypeName() == null) {
            String str2 = this.entityTemplate;
            if (str2 != null ? str2.equals(backupInfo.getEntityTemplate()) : backupInfo.getEntityTemplate() == null) {
                String str3 = this.entityId;
                if (str3 != null ? str3.equals(backupInfo.getEntityId()) : backupInfo.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(backupInfo.getEntityFixed()) : backupInfo.getEntityFixed() == null) {
                        String str4 = this.url;
                        if (str4 != null ? str4.equals(backupInfo.getUrl()) : backupInfo.getUrl() == null) {
                            String str5 = this.description;
                            if (str5 != null ? str5.equals(backupInfo.getDescription()) : backupInfo.getDescription() == null) {
                                String str6 = this.pic;
                                if (str6 != null ? str6.equals(backupInfo.getPic()) : backupInfo.getPic() == null) {
                                    String str7 = this.logo;
                                    if (str7 != null ? str7.equals(backupInfo.getLogo()) : backupInfo.getLogo() == null) {
                                        String str8 = this.subTitle;
                                        if (str8 != null ? str8.equals(backupInfo.getSubTitle()) : backupInfo.getSubTitle() == null) {
                                            String str9 = this.extraData;
                                            if (str9 != null ? str9.equals(backupInfo.getExtraData()) : backupInfo.getExtraData() == null) {
                                                Long l4 = this.dateline;
                                                if (l4 != null ? l4.equals(backupInfo.getDateline()) : backupInfo.getDateline() == null) {
                                                    Long l5 = this.lastUpdate;
                                                    if (l5 != null ? l5.equals(backupInfo.getLastUpdate()) : backupInfo.getLastUpdate() == null) {
                                                        String str10 = this.id;
                                                        if (str10 != null ? str10.equals(backupInfo.getId()) : backupInfo.getId() == null) {
                                                            String str11 = this.title;
                                                            if (str11 != null ? str11.equals(backupInfo.getTitle()) : backupInfo.getTitle() == null) {
                                                                String str12 = this.uid;
                                                                if (str12 != null ? str12.equals(backupInfo.getUid()) : backupInfo.getUid() == null) {
                                                                    String str13 = this.userName;
                                                                    if (str13 != null ? str13.equals(backupInfo.getUserName()) : backupInfo.getUserName() == null) {
                                                                        String str14 = this.versionMD5;
                                                                        if (str14 != null ? str14.equals(backupInfo.getVersionMD5()) : backupInfo.getVersionMD5() == null) {
                                                                            String str15 = this.deviceName;
                                                                            if (str15 != null ? str15.equals(backupInfo.getDeviceName()) : backupInfo.getDeviceName() == null) {
                                                                                String str16 = this.deviceTitle;
                                                                                if (str16 != null ? str16.equals(backupInfo.getDeviceTitle()) : backupInfo.getDeviceTitle() == null) {
                                                                                    if (this.apkNum == backupInfo.getApkNum() && this.backNum == backupInfo.getBackNum() && ((l2 = this.recoveryTime) != null ? l2.equals(backupInfo.getRecoveryTime()) : backupInfo.getRecoveryTime() == null) && ((l3 = this.createTime) != null ? l3.equals(backupInfo.getCreateTime()) : backupInfo.getCreateTime() == null) && ((list = this.serviceApps) != null ? list.equals(backupInfo.getServiceApps()) : backupInfo.getServiceApps() == null)) {
                                                                                        List<LocalApp> list2 = this.localApps;
                                                                                        if (list2 == null) {
                                                                                            if (backupInfo.getLocalApps() == null) {
                                                                                                return true;
                                                                                            }
                                                                                        } else if (list2.equals(backupInfo.getLocalApps())) {
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
        String str9 = this.extraData;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode11 = (hashCode10 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode12 = (hashCode11 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str10 = this.id;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.title;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.uid;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.userName;
        int hashCode16 = (hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.versionMD5;
        int hashCode17 = (hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.deviceName;
        int hashCode18 = (hashCode17 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.deviceTitle;
        int hashCode19 = (((((hashCode18 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.apkNum) * 1000003) ^ this.backNum) * 1000003;
        Long l4 = this.recoveryTime;
        int hashCode20 = (hashCode19 ^ (l4 == null ? 0 : l4.hashCode())) * 1000003;
        Long l5 = this.createTime;
        int hashCode21 = (hashCode20 ^ (l5 == null ? 0 : l5.hashCode())) * 1000003;
        List<ServiceApp> list = this.serviceApps;
        int hashCode22 = (hashCode21 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<LocalApp> list2 = this.localApps;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode22 ^ i;
    }
}
