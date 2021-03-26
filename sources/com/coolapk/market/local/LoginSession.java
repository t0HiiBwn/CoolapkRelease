package com.coolapk.market.local;

import android.text.TextUtils;
import com.coolapk.market.model.LoginInfo;
import com.coolapk.market.util.PreferencesUtils;
import com.coolapk.market.util.UserUtils;

public class LoginSession {
    private int adminType = -1;
    private final PreferencesUtils preferencesUtils;
    private String pushId;
    private String token;
    private String uid;
    private String userAvatar;
    private String userName;

    public LoginSession(PreferencesUtils preferencesUtils2) {
        this.preferencesUtils = preferencesUtils2;
        this.uid = preferencesUtils2.getString("uid", "");
        this.userName = preferencesUtils2.getString("username", "");
        this.token = preferencesUtils2.getString("token", "");
        this.userAvatar = preferencesUtils2.getString("userAvatar", "");
        this.adminType = preferencesUtils2.getInt("adminType", -1);
        this.pushId = preferencesUtils2.getString("pushId", "");
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getToken() {
        return this.token;
    }

    public int getAdminType() {
        return this.adminType;
    }

    public boolean isAdmin() {
        return this.adminType > 0;
    }

    public String getPushId() {
        return this.pushId;
    }

    public boolean isLogin() {
        return !TextUtils.isEmpty(this.uid) && !this.uid.equals("0") && !TextUtils.isEmpty(this.userName) && !TextUtils.isEmpty(this.token);
    }

    public boolean update(LoginInfo loginInfo) {
        this.uid = loginInfo.getUid();
        this.userName = loginInfo.getUserName();
        String token2 = loginInfo.getToken();
        if (!TextUtils.isEmpty(loginInfo.getRefreshToken())) {
            token2 = loginInfo.getRefreshToken();
        }
        this.token = token2;
        this.userAvatar = loginInfo.getUserAvatar();
        this.adminType = loginInfo.getAdminType();
        this.pushId = loginInfo.getPushId();
        return save();
    }

    public boolean reset() {
        this.uid = "";
        this.userName = "";
        this.token = "";
        this.userAvatar = null;
        this.adminType = -1;
        return clear();
    }

    public String getUserAvatar() {
        if (!TextUtils.isEmpty(this.userAvatar) || TextUtils.isEmpty(this.uid)) {
            return this.userAvatar;
        }
        return UserUtils.getBigAvatarUrl(this.uid);
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
        save();
    }

    public void setUserName(String str) {
        this.userName = str;
        save();
    }

    private boolean save() {
        return this.preferencesUtils.edit().putString("uid", this.uid).putString("username", this.userName).putString("token", this.token).putString("userAvatar", this.userAvatar).putInt("adminType", this.adminType).putString("pushId", this.pushId).commit();
    }

    private boolean clear() {
        return this.preferencesUtils.edit().remove("uid").remove("username").remove("token").remove("userAvatar").remove("adminType").remove("pushId").commit();
    }
}
