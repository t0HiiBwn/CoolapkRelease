package com.coolapk.market.model;

import com.coolapk.market.model.AutoValue_LoginInfo;
import com.coolapk.market.model.C$AutoValue_LoginInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class LoginInfo {

    public static abstract class Builder {
        public abstract Builder adminType(int i);

        public abstract LoginInfo build();

        public abstract Builder notifyCount(NotifyCount notifyCount);

        public abstract Builder pushId(String str);

        public abstract Builder refreshToken(String str);

        public abstract Builder token(String str);

        public abstract Builder uid(String str);

        public abstract Builder userAvatar(String str);

        public abstract Builder userName(String str);
    }

    public abstract int getAdminType();

    public abstract NotifyCount getNotifyCount();

    @SerializedName("pushId")
    public abstract String getPushId();

    @SerializedName("refreshToken")
    public abstract String getRefreshToken();

    public abstract String getToken();

    public abstract String getUid();

    public abstract String getUserAvatar();

    @SerializedName("username")
    public abstract String getUserName();

    public static TypeAdapter<LoginInfo> typeAdapter(Gson gson) {
        return new AutoValue_LoginInfo.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$AutoValue_LoginInfo.Builder();
    }
}
