package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_UserInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class UserInfo implements Parcelable {
    @SerializedName("admintype")
    public abstract int getAdminType();

    @SerializedName("avatarstatus")
    public abstract int getAvatarStatus();

    @SerializedName("bio")
    public abstract String getBio();

    @SerializedName("displayUsername")
    public abstract String getDisplayUserName();

    @SerializedName("fans")
    public abstract String getFans();

    @SerializedName("follow")
    public abstract String getFollow();

    @SerializedName("groupid")
    public abstract int getGroupId();

    public abstract int getLevel();

    @SerializedName("logintime")
    public abstract long getLoginTime();

    @SerializedName("status")
    public abstract int getStatus();

    public abstract String getUid();

    @SerializedName("url")
    public abstract String getUrl();

    @SerializedName("userAvatar")
    public abstract String getUserAvatar();

    @SerializedName("userBigAvatar")
    public abstract String getUserBigAvatar();

    @SerializedName("usergroupid")
    public abstract int getUserGroupId();

    @SerializedName("username")
    public abstract String getUserName();

    @SerializedName("usernamestatus")
    public abstract int getUserNameStatus();

    @SerializedName("userSmallAvatar")
    public abstract String getUserSmallAvatar();

    @SerializedName("verify_icon")
    public abstract String getVerifyIcon();

    @SerializedName("verify_label")
    public abstract String getVerifyLabel();

    @SerializedName("verify_status")
    public abstract int getVerifyStatus();

    @SerializedName("verify_title")
    public abstract String getVerifyTitle();

    public String getVerifyStatusIcon() {
        if (getVerifyStatus() == 1) {
            return getVerifyIcon();
        }
        return null;
    }

    public static TypeAdapter<UserInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_UserInfo.GsonTypeAdapter(gson);
    }
}
