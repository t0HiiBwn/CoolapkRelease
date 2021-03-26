package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_Contacts;
import com.coolapk.market.model.C$AutoValue_Contacts;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class Contacts implements Entity, IUser {

    public static abstract class Builder implements IUser.BuilderM1<Builder> {
        public abstract Contacts build();

        public abstract Builder setDateline(Long l2);

        public abstract Builder setDeprecatedFollowUserName(String str);

        public abstract Builder setDeprecatedFollowerUserAvatar(String str);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFollowUid(String str);

        public abstract Builder setFollowerUserInfo(UserInfo userInfo);

        public abstract Builder setId(String str);

        public abstract Builder setIsFriend(int i);

        public abstract Builder setLastUpdate(Long l2);

        public abstract Builder setLogo(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public abstract Builder setUid(String str);

        public abstract Builder setUrl(String str);

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public abstract Builder setUserInfo(UserInfo userInfo);
    }

    @SerializedName("fusername")
    public abstract String getDeprecatedFollowUserName();

    @SerializedName("fUserAvatar")
    public abstract String getDeprecatedFollowerUserAvatar();

    @SerializedName("fuid")
    public abstract String getFollowUid();

    @SerializedName("fUserInfo")
    public abstract UserInfo getFollowerUserInfo();

    @SerializedName("isfriend")
    public abstract int getIsFriend();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    @Override // com.coolapk.market.model.IUser
    @SerializedName("userInfo")
    public abstract UserInfo getUserInfo();

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public String getFollowUserName() {
        if (getFollowerUserInfo() == null || TextUtils.isEmpty(getFollowerUserInfo().getDisplayUserName())) {
            return getDeprecatedFollowUserName();
        }
        return getFollowerUserInfo().getDisplayUserName();
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static Builder builder() {
        return new C$$AutoValue_Contacts.Builder();
    }

    public static Builder builder(Contacts contacts) {
        return new C$$AutoValue_Contacts.Builder(contacts);
    }

    public static TypeAdapter<Contacts> typeAdapter(Gson gson) {
        return new C$AutoValue_Contacts.GsonTypeAdapter(gson);
    }

    public String getUserAvatar() {
        return IUser.IUserGetter.getUserAvatar(this);
    }

    public String getFollowerUserAvatar() {
        if (getFollowerUserInfo() == null || TextUtils.isEmpty(getFollowerUserInfo().getUserAvatar())) {
            return getDeprecatedFollowerUserAvatar();
        }
        return getFollowerUserInfo().getUserAvatar();
    }
}
