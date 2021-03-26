package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_User;
import com.coolapk.market.model.C$AutoValue_User;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class User implements Entity, IUser {
    public static final int FOLLOW_TYPE_FOLLOWED = 1;
    public static final int FOLLOW_TYPE_ME = -1;
    public static final int FOLLOW_TYPE_UNFOLLOW = 0;

    public static abstract class Builder implements IUser.BuilderM1<Builder> {
        public abstract User build();

        public abstract Builder setBio(String str);

        public abstract Builder setDateline(Long l2);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFans(String str);

        public abstract Builder setFollow(String str);

        public abstract Builder setId(String str);

        public abstract Builder setIsFollow(int i);

        public abstract Builder setLastUpdate(Long l2);

        public abstract Builder setLikeNum(int i);

        public abstract Builder setLoginTime(long j);

        public abstract Builder setLogo(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setType(String str);

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public abstract Builder setUid(String str);

        public abstract Builder setUrl(String str);
    }

    public abstract String getBio();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityType();

    public abstract String getFans();

    public abstract String getFollow();

    @SerializedName("isFollow")
    public abstract int getIsFollow();

    @SerializedName("be_like_num")
    public abstract int getLikeNum();

    @SerializedName("logintime")
    public abstract long getLoginTime();

    @Override // com.coolapk.market.model.Entity
    public abstract String getSubTitle();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    public abstract String getType();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    public String getUserAvatar() {
        return IUser.IUserGetter.getUserAvatar(this);
    }

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public int getIsAnonymous() {
        return (TextUtils.equals(getUid(), "999") || TextUtils.equals(getDisplayUserName(), "匿名酷友")) ? 1 : 0;
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static Builder builder() {
        return new C$$AutoValue_User.Builder().setLoginTime(0).setLikeNum(0);
    }

    public static Builder builder(User user) {
        return new C$$AutoValue_User.Builder(user);
    }

    public static TypeAdapter<User> typeAdapter(Gson gson) {
        return new C$AutoValue_User.GsonTypeAdapter(gson);
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uid", getUid()).put("userName", getUserName()).put("userAvatar", getUserAvatar());
        return jSONObject;
    }

    public static User fromJson(JSONObject jSONObject) {
        return ((Builder) ((Builder) builder().setEntityType("user").setIsFollow(0).setUid(jSONObject.optString("uid")).setDeprecatedUserAvatar(jSONObject.optString("userAvatar"))).setDeprecatedUserName(jSONObject.optString("userName"))).build();
    }
}
