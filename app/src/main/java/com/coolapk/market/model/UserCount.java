package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_UserCount;
import com.coolapk.market.model.C$AutoValue_UserCount;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class UserCount implements Entity, IUser {
    public static final String TYPE = "userCount";

    public static abstract class Builder implements IUser.BuilderM1<Builder> {
        public abstract UserCount build();

        public abstract Builder setAtMeCount(int i);

        public abstract Builder setAtMeInCommentCount(int i);

        public abstract Builder setBadge(int i);

        public abstract Builder setDateline(Long l2);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFans(int i);

        public abstract Builder setFeed(int i);

        public abstract Builder setFollow(int i);

        public abstract Builder setFollowApp(int i);

        public abstract Builder setId(String str);

        public abstract Builder setLastUpdate(Long l2);

        public abstract Builder setLogo(String str);

        public abstract Builder setMessage(int i);

        public abstract Builder setNotification(int i);

        public abstract Builder setPic(String str);

        public abstract Builder setReplyMeCount(int i);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public abstract Builder setUid(String str);

        public abstract Builder setUrl(String str);
    }

    @SerializedName("atme")
    public abstract int getAtMeCount();

    @SerializedName("atcommentme")
    public abstract int getAtMeInCommentCount();

    public abstract int getBadge();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "userCount";
    }

    public abstract int getFans();

    @SerializedName("feed")
    public abstract int getFeed();

    public abstract int getFollow();

    @SerializedName("count2")
    public abstract int getFollowApp();

    @SerializedName("message")
    public abstract int getMessage();

    @SerializedName("notification")
    public abstract int getNotification();

    @SerializedName("commentme")
    public abstract int getReplyMeCount();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<UserCount> typeAdapter(Gson gson) {
        return new C$AutoValue_UserCount.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$$AutoValue_UserCount.Builder();
    }

    public static Builder builder(UserCount userCount) {
        return new C$$AutoValue_UserCount.Builder(userCount);
    }
}
