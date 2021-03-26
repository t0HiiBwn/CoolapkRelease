package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.google.gson.annotations.SerializedName;

public interface IUser {

    public interface BuilderM1<T extends BuilderM1> {
        T setDeprecatedUserAvatar(String str);

        T setDeprecatedUserName(String str);

        T setDisplayUserName(String str);

        T setUid(String str);

        T setUserInfo(UserInfo userInfo);
    }

    public interface BuilderM2<T extends BuilderM2> {
        T deprecatedUserAvatar(String str);

        T deprecatedUserName(String str);

        T displayUserName(String str);

        T uid(String str);

        T userInfo(UserInfo userInfo);
    }

    @SerializedName("userAvatar")
    String getDeprecatedUserAvatar();

    @SerializedName("username")
    String getDeprecatedUserName();

    @SerializedName("displayUsername")
    String getDisplayUserName();

    String getUid();

    UserInfo getUserInfo();

    public static class IUserGetter {
        public static String getUserName(IUser iUser) {
            if (TextUtils.equals(iUser.getUid(), DataManager.getInstance().getLoginSession().getUid())) {
                UserInfo userInfo = iUser.getUserInfo();
                if (userInfo != null) {
                    return userInfo.getUserName();
                }
                return iUser.getDeprecatedUserName();
            }
            UserInfo userInfo2 = iUser.getUserInfo();
            if (userInfo2 != null) {
                if (!TextUtils.isEmpty(userInfo2.getDisplayUserName())) {
                    return userInfo2.getDisplayUserName();
                }
                if (!TextUtils.isEmpty(userInfo2.getUserName())) {
                    return userInfo2.getUserName();
                }
            }
            if (!TextUtils.isEmpty(iUser.getDisplayUserName())) {
                return iUser.getDisplayUserName();
            }
            return iUser.getDeprecatedUserName();
        }

        public static String getUserAvatar(IUser iUser) {
            LoginSession loginSession = DataManager.getInstance().getLoginSession();
            if (TextUtils.equals(iUser.getUid(), loginSession.getUid())) {
                return loginSession.getUserAvatar();
            }
            UserInfo userInfo = iUser.getUserInfo();
            if (userInfo == null || TextUtils.isEmpty(userInfo.getUserAvatar())) {
                return iUser.getDeprecatedUserAvatar();
            }
            return userInfo.getUserAvatar();
        }
    }
}
