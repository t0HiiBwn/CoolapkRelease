package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_LiveMessage;
import com.coolapk.market.model.C$AutoValue_LiveMessage;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class LiveMessage implements Entity {

    public static abstract class Builder {
        public abstract LiveMessage build();

        public abstract Builder setDateline(Long l2);

        public abstract Builder setDatelineFormat(String str);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setId(String str);

        public abstract Builder setIsBroadcast(int i);

        public abstract Builder setIsRead(int i);

        public abstract Builder setLastUpdate(Long l2);

        public abstract Builder setLiveId(String str);

        public abstract Builder setLogo(String str);

        public abstract Builder setMessage(String str);

        public abstract Builder setMessageSource(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setSourceRow(LiveMessage liveMessage);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUid(String str);

        public abstract Builder setUrl(String str);

        public abstract Builder setUserInfo(User user);

        public abstract Builder setUserName(String str);
    }

    @SerializedName("datelineFormat")
    public abstract String getDatelineFormat();

    @SerializedName("is_broadcast")
    public abstract int getIsBroadcast();

    @SerializedName("is_read")
    protected abstract int getIsRead();

    @SerializedName("live_id")
    public abstract String getLiveId();

    public abstract String getMessage();

    @SerializedName("message_source")
    public abstract String getMessageSource();

    public abstract LiveMessage getSourceRow();

    public abstract String getUid();

    public abstract User getUserInfo();

    @SerializedName("username")
    public abstract String getUserName();

    public static TypeAdapter<LiveMessage> typeAdapter(Gson gson) {
        return new C$AutoValue_LiveMessage.GsonTypeAdapter(gson);
    }

    public boolean isRead() {
        return getIsRead() == 0;
    }

    public String getMiddleSizePic() {
        if (TextUtils.isEmpty(getPic())) {
            return null;
        }
        return getPic() + ".m.jpg";
    }

    public String getThumbSquarePic() {
        if (TextUtils.isEmpty(getPic())) {
            return null;
        }
        return getPic() + ".xs.jpg";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static Builder builder() {
        return new C$$AutoValue_LiveMessage.Builder();
    }

    public static Builder builder(LiveMessage liveMessage) {
        return new C$$AutoValue_LiveMessage.Builder(liveMessage);
    }
}
