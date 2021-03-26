package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_UserInfo  reason: invalid class name */
abstract class C$$AutoValue_UserInfo extends UserInfo {
    private final int adminType;
    private final int avatarStatus;
    private final String bio;
    private final String displayUserName;
    private final String fans;
    private final String follow;
    private final int groupId;
    private final int level;
    private final long loginTime;
    private final int status;
    private final String uid;
    private final String url;
    private final String userAvatar;
    private final String userBigAvatar;
    private final int userGroupId;
    private final String userName;
    private final int userNameStatus;
    private final String userSmallAvatar;
    private final String verifyIcon;
    private final String verifyLabel;
    private final int verifyStatus;
    private final String verifyTitle;

    C$$AutoValue_UserInfo(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, String str3, String str4, int i7, String str5, String str6, String str7, String str8, String str9, long j, String str10, int i8, String str11, String str12, String str13) {
        this.uid = str;
        this.userName = str2;
        this.adminType = i;
        this.groupId = i2;
        this.userGroupId = i3;
        this.status = i4;
        this.userNameStatus = i5;
        this.avatarStatus = i6;
        this.displayUserName = str3;
        this.url = str4;
        this.level = i7;
        this.userAvatar = str5;
        this.fans = str6;
        this.follow = str7;
        this.bio = str8;
        this.userSmallAvatar = str9;
        this.loginTime = j;
        this.userBigAvatar = str10;
        this.verifyStatus = i8;
        this.verifyIcon = str11;
        this.verifyLabel = str12;
        this.verifyTitle = str13;
    }

    @Override // com.coolapk.market.model.UserInfo
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("username")
    public String getUserName() {
        return this.userName;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("admintype")
    public int getAdminType() {
        return this.adminType;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("groupid")
    public int getGroupId() {
        return this.groupId;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("usergroupid")
    public int getUserGroupId() {
        return this.userGroupId;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("status")
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("usernamestatus")
    public int getUserNameStatus() {
        return this.userNameStatus;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("avatarstatus")
    public int getAvatarStatus() {
        return this.avatarStatus;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("displayUsername")
    public String getDisplayUserName() {
        return this.displayUserName;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.UserInfo
    public int getLevel() {
        return this.level;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("userAvatar")
    public String getUserAvatar() {
        return this.userAvatar;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("fans")
    public String getFans() {
        return this.fans;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("follow")
    public String getFollow() {
        return this.follow;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("bio")
    public String getBio() {
        return this.bio;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("userSmallAvatar")
    public String getUserSmallAvatar() {
        return this.userSmallAvatar;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("logintime")
    public long getLoginTime() {
        return this.loginTime;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("userBigAvatar")
    public String getUserBigAvatar() {
        return this.userBigAvatar;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("verify_status")
    public int getVerifyStatus() {
        return this.verifyStatus;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("verify_icon")
    public String getVerifyIcon() {
        return this.verifyIcon;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("verify_label")
    public String getVerifyLabel() {
        return this.verifyLabel;
    }

    @Override // com.coolapk.market.model.UserInfo
    @SerializedName("verify_title")
    public String getVerifyTitle() {
        return this.verifyTitle;
    }

    @Override // java.lang.Object
    public String toString() {
        return "UserInfo{uid=" + this.uid + ", userName=" + this.userName + ", adminType=" + this.adminType + ", groupId=" + this.groupId + ", userGroupId=" + this.userGroupId + ", status=" + this.status + ", userNameStatus=" + this.userNameStatus + ", avatarStatus=" + this.avatarStatus + ", displayUserName=" + this.displayUserName + ", url=" + this.url + ", level=" + this.level + ", userAvatar=" + this.userAvatar + ", fans=" + this.fans + ", follow=" + this.follow + ", bio=" + this.bio + ", userSmallAvatar=" + this.userSmallAvatar + ", loginTime=" + this.loginTime + ", userBigAvatar=" + this.userBigAvatar + ", verifyStatus=" + this.verifyStatus + ", verifyIcon=" + this.verifyIcon + ", verifyLabel=" + this.verifyLabel + ", verifyTitle=" + this.verifyTitle + "}";
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
        String str8;
        String str9;
        String str10;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        String str11 = this.uid;
        if (str11 != null ? str11.equals(userInfo.getUid()) : userInfo.getUid() == null) {
            String str12 = this.userName;
            if (str12 != null ? str12.equals(userInfo.getUserName()) : userInfo.getUserName() == null) {
                if (this.adminType == userInfo.getAdminType() && this.groupId == userInfo.getGroupId() && this.userGroupId == userInfo.getUserGroupId() && this.status == userInfo.getStatus() && this.userNameStatus == userInfo.getUserNameStatus() && this.avatarStatus == userInfo.getAvatarStatus() && ((str = this.displayUserName) != null ? str.equals(userInfo.getDisplayUserName()) : userInfo.getDisplayUserName() == null) && ((str2 = this.url) != null ? str2.equals(userInfo.getUrl()) : userInfo.getUrl() == null) && this.level == userInfo.getLevel() && ((str3 = this.userAvatar) != null ? str3.equals(userInfo.getUserAvatar()) : userInfo.getUserAvatar() == null) && ((str4 = this.fans) != null ? str4.equals(userInfo.getFans()) : userInfo.getFans() == null) && ((str5 = this.follow) != null ? str5.equals(userInfo.getFollow()) : userInfo.getFollow() == null) && ((str6 = this.bio) != null ? str6.equals(userInfo.getBio()) : userInfo.getBio() == null) && ((str7 = this.userSmallAvatar) != null ? str7.equals(userInfo.getUserSmallAvatar()) : userInfo.getUserSmallAvatar() == null) && this.loginTime == userInfo.getLoginTime() && ((str8 = this.userBigAvatar) != null ? str8.equals(userInfo.getUserBigAvatar()) : userInfo.getUserBigAvatar() == null) && this.verifyStatus == userInfo.getVerifyStatus() && ((str9 = this.verifyIcon) != null ? str9.equals(userInfo.getVerifyIcon()) : userInfo.getVerifyIcon() == null) && ((str10 = this.verifyLabel) != null ? str10.equals(userInfo.getVerifyLabel()) : userInfo.getVerifyLabel() == null)) {
                    String str13 = this.verifyTitle;
                    if (str13 == null) {
                        if (userInfo.getVerifyTitle() == null) {
                            return true;
                        }
                    } else if (str13.equals(userInfo.getVerifyTitle())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.uid;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.userName;
        int hashCode2 = (((((((((((((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.adminType) * 1000003) ^ this.groupId) * 1000003) ^ this.userGroupId) * 1000003) ^ this.status) * 1000003) ^ this.userNameStatus) * 1000003) ^ this.avatarStatus) * 1000003;
        String str3 = this.displayUserName;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.url;
        int hashCode4 = (((hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003) ^ this.level) * 1000003;
        String str5 = this.userAvatar;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.fans;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.follow;
        int hashCode7 = (hashCode6 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.bio;
        int hashCode8 = (hashCode7 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.userSmallAvatar;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        long j = this.loginTime;
        int i2 = ((int) (((long) ((hashCode8 ^ hashCode9) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003;
        String str10 = this.userBigAvatar;
        int hashCode10 = (((i2 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003) ^ this.verifyStatus) * 1000003;
        String str11 = this.verifyIcon;
        int hashCode11 = (hashCode10 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.verifyLabel;
        int hashCode12 = (hashCode11 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.verifyTitle;
        if (str13 != null) {
            i = str13.hashCode();
        }
        return hashCode12 ^ i;
    }
}
