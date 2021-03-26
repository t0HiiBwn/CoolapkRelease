package com.coolapk.market.model;

import com.coolapk.market.model.LoginInfo;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_LoginInfo  reason: invalid class name */
abstract class C$AutoValue_LoginInfo extends LoginInfo {
    private final int adminType;
    private final NotifyCount notifyCount;
    private final String pushId;
    private final String refreshToken;
    private final String token;
    private final String uid;
    private final String userAvatar;
    private final String userName;

    C$AutoValue_LoginInfo(String str, String str2, String str3, String str4, int i, NotifyCount notifyCount2, String str5, String str6) {
        Objects.requireNonNull(str, "Null uid");
        this.uid = str;
        Objects.requireNonNull(str2, "Null userName");
        this.userName = str2;
        Objects.requireNonNull(str3, "Null token");
        this.token = str3;
        this.refreshToken = str4;
        this.adminType = i;
        Objects.requireNonNull(notifyCount2, "Null notifyCount");
        this.notifyCount = notifyCount2;
        Objects.requireNonNull(str5, "Null userAvatar");
        this.userAvatar = str5;
        this.pushId = str6;
    }

    @Override // com.coolapk.market.model.LoginInfo
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.LoginInfo
    @SerializedName("username")
    public String getUserName() {
        return this.userName;
    }

    @Override // com.coolapk.market.model.LoginInfo
    public String getToken() {
        return this.token;
    }

    @Override // com.coolapk.market.model.LoginInfo
    @SerializedName("refreshToken")
    public String getRefreshToken() {
        return this.refreshToken;
    }

    @Override // com.coolapk.market.model.LoginInfo
    public int getAdminType() {
        return this.adminType;
    }

    @Override // com.coolapk.market.model.LoginInfo
    public NotifyCount getNotifyCount() {
        return this.notifyCount;
    }

    @Override // com.coolapk.market.model.LoginInfo
    public String getUserAvatar() {
        return this.userAvatar;
    }

    @Override // com.coolapk.market.model.LoginInfo
    @SerializedName("pushId")
    public String getPushId() {
        return this.pushId;
    }

    public String toString() {
        return "LoginInfo{uid=" + this.uid + ", userName=" + this.userName + ", token=" + this.token + ", refreshToken=" + this.refreshToken + ", adminType=" + this.adminType + ", notifyCount=" + this.notifyCount + ", userAvatar=" + this.userAvatar + ", pushId=" + this.pushId + "}";
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoginInfo)) {
            return false;
        }
        LoginInfo loginInfo = (LoginInfo) obj;
        if (this.uid.equals(loginInfo.getUid()) && this.userName.equals(loginInfo.getUserName()) && this.token.equals(loginInfo.getToken()) && ((str = this.refreshToken) != null ? str.equals(loginInfo.getRefreshToken()) : loginInfo.getRefreshToken() == null) && this.adminType == loginInfo.getAdminType() && this.notifyCount.equals(loginInfo.getNotifyCount()) && this.userAvatar.equals(loginInfo.getUserAvatar())) {
            String str2 = this.pushId;
            if (str2 == null) {
                if (loginInfo.getPushId() == null) {
                    return true;
                }
            } else if (str2.equals(loginInfo.getPushId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((this.uid.hashCode() ^ 1000003) * 1000003) ^ this.userName.hashCode()) * 1000003) ^ this.token.hashCode()) * 1000003;
        String str = this.refreshToken;
        int i = 0;
        int hashCode2 = (((((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.adminType) * 1000003) ^ this.notifyCount.hashCode()) * 1000003) ^ this.userAvatar.hashCode()) * 1000003;
        String str2 = this.pushId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_LoginInfo$Builder */
    static final class Builder extends LoginInfo.Builder {
        private Integer adminType;
        private NotifyCount notifyCount;
        private String pushId;
        private String refreshToken;
        private String token;
        private String uid;
        private String userAvatar;
        private String userName;

        Builder() {
        }

        Builder(LoginInfo loginInfo) {
            this.uid = loginInfo.getUid();
            this.userName = loginInfo.getUserName();
            this.token = loginInfo.getToken();
            this.refreshToken = loginInfo.getRefreshToken();
            this.adminType = Integer.valueOf(loginInfo.getAdminType());
            this.notifyCount = loginInfo.getNotifyCount();
            this.userAvatar = loginInfo.getUserAvatar();
            this.pushId = loginInfo.getPushId();
        }

        @Override // com.coolapk.market.model.LoginInfo.Builder
        public LoginInfo.Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.LoginInfo.Builder
        public LoginInfo.Builder userName(String str) {
            this.userName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LoginInfo.Builder
        public LoginInfo.Builder token(String str) {
            this.token = str;
            return this;
        }

        @Override // com.coolapk.market.model.LoginInfo.Builder
        public LoginInfo.Builder refreshToken(String str) {
            this.refreshToken = str;
            return this;
        }

        @Override // com.coolapk.market.model.LoginInfo.Builder
        public LoginInfo.Builder adminType(int i) {
            this.adminType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.LoginInfo.Builder
        public LoginInfo.Builder notifyCount(NotifyCount notifyCount2) {
            this.notifyCount = notifyCount2;
            return this;
        }

        @Override // com.coolapk.market.model.LoginInfo.Builder
        public LoginInfo.Builder userAvatar(String str) {
            this.userAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.LoginInfo.Builder
        public LoginInfo.Builder pushId(String str) {
            this.pushId = str;
            return this;
        }

        @Override // com.coolapk.market.model.LoginInfo.Builder
        public LoginInfo build() {
            String str = "";
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.userName == null) {
                str = str + " userName";
            }
            if (this.token == null) {
                str = str + " token";
            }
            if (this.adminType == null) {
                str = str + " adminType";
            }
            if (this.notifyCount == null) {
                str = str + " notifyCount";
            }
            if (this.userAvatar == null) {
                str = str + " userAvatar";
            }
            if (str.isEmpty()) {
                return new AutoValue_LoginInfo(this.uid, this.userName, this.token, this.refreshToken, this.adminType.intValue(), this.notifyCount, this.userAvatar, this.pushId);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
