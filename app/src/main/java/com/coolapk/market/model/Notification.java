package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_Notification;
import com.coolapk.market.model.C$AutoValue_Notification;
import com.coolapk.market.util.UserUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class Notification implements Entity {

    public static abstract class Builder {
        public abstract Notification build();

        public abstract Builder setDateline(Long l2);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFromUid(String str);

        public abstract Builder setFromUserAvatar(String str);

        public abstract Builder setFromUserInfo(UserInfo userInfo);

        public abstract Builder setFromUserName(String str);

        public abstract Builder setId(String str);

        public abstract Builder setIsNew(int i);

        public abstract Builder setLastUpdate(Long l2);

        public abstract Builder setLogo(String str);

        public abstract Builder setNote(String str);

        public abstract Builder setNotifyCount(NotifyCount notifyCount);

        public abstract Builder setPic(String str);

        public abstract Builder setSlug(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setType(String str);

        public abstract Builder setUid(String str);

        public abstract Builder setUrl(String str);
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityType")
    public abstract String getEntityType();

    @SerializedName("fromuid")
    public abstract String getFromUid();

    @SerializedName("fromUserAvatar")
    public abstract String getFromUserAvatar();

    @SerializedName("fromUserInfo")
    public abstract UserInfo getFromUserInfo();

    @SerializedName("fromusername")
    public abstract String getFromUserName();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    @SerializedName("isnew")
    public abstract int getIsNew();

    @SerializedName("note")
    public abstract String getNote();

    @SerializedName("notifyCount")
    public abstract NotifyCount getNotifyCount();

    @SerializedName("slug")
    public abstract String getSlug();

    @SerializedName("type")
    public abstract String getType();

    @SerializedName("uid")
    public abstract String getUid();

    public static TypeAdapter<Notification> typeAdapter(Gson gson) {
        return new C$AutoValue_Notification.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$$AutoValue_Notification.Builder();
    }

    public static Builder builder(Notification notification) {
        return new C$$AutoValue_Notification.Builder(notification);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getUserAvatar() {
        return UserUtils.getAvatarUrl(getFromUid());
    }
}
