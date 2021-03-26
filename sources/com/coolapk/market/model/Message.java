package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.C$$AutoValue_Message;
import com.coolapk.market.model.C$AutoValue_Message;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class Message implements Entity, IUser {

    public static abstract class Builder implements IUser.BuilderM1<Builder> {
        public abstract Message build();

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

        public abstract Builder setFromUserName(String str);

        public abstract Builder setId(String str);

        public abstract Builder setIsLast(int i);

        public abstract Builder setIsLong(Integer num);

        public abstract Builder setIsNew(int i);

        public abstract Builder setIsTop(int i);

        public abstract Builder setLastUpdate(Long l2);

        public abstract Builder setLogo(String str);

        public abstract Builder setMessage(String str);

        public abstract Builder setMessageCard(String str);

        public abstract Builder setMessageExtra(String str);

        public abstract Builder setMessagePic(String str);

        public abstract Builder setMessageUid(String str);

        public abstract Builder setMessageUserAvatar(String str);

        public abstract Builder setMessageUserInfo(UserInfo userInfo);

        public abstract Builder setMessageUserName(String str);

        public abstract Builder setNotifyCount(NotifyCount notifyCount);

        public abstract Builder setPic(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUKey(String str);

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public abstract Builder setUid(String str);

        public abstract Builder setUnreadNum(int i);

        public abstract Builder setUrl(String str);
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityType();

    @SerializedName("fromuid")
    public abstract String getFromUid();

    public abstract String getFromUserAvatar();

    @SerializedName("fromusername")
    public abstract String getFromUserName();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    @SerializedName("islast")
    public abstract int getIsLast();

    @SerializedName("isLong")
    public abstract Integer getIsLong();

    @SerializedName("isnew")
    public abstract int getIsNew();

    @SerializedName("is_top")
    public abstract int getIsTop();

    public abstract String getMessage();

    @SerializedName("message_card")
    public abstract String getMessageCard();

    @SerializedName("message_extra")
    public abstract String getMessageExtra();

    @SerializedName("message_pic")
    public abstract String getMessagePic();

    public abstract String getMessageUid();

    public abstract String getMessageUserAvatar();

    public abstract UserInfo getMessageUserInfo();

    @SerializedName("messageUsername")
    public abstract String getMessageUserName();

    public abstract NotifyCount getNotifyCount();

    @SerializedName("ukey")
    public abstract String getUKey();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    public abstract int getUnreadNum();

    public static Builder builder() {
        return new C$$AutoValue_Message.Builder();
    }

    public static Builder builder(Message message) {
        return new C$$AutoValue_Message.Builder(message);
    }

    public static TypeAdapter<Message> typeAdapter(Gson gson) {
        return new C$AutoValue_Message.GsonTypeAdapter(gson);
    }

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public boolean isShowError() {
        return !TextUtils.isEmpty(getMessagePic()) && isPicBlock();
    }

    public boolean isPicBlock() {
        return !TextUtils.isEmpty(getMessageExtra()) && getMessageExtra().contains("message_pic_block");
    }

    public boolean isShowPic() {
        return !TextUtils.isEmpty(getMessagePic()) && !isPicBlock();
    }

    public String getUserAvatar() {
        return IUser.IUserGetter.getUserAvatar(this);
    }

    public String getShowUnreadNum() {
        if (getUnreadNum() > 99) {
            return "99+";
        }
        if (getUnreadNum() == 0) {
            return "";
        }
        return String.valueOf(getUnreadNum());
    }

    public boolean isToped() {
        return getIsTop() == 1;
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public boolean isMessageCard() {
        return !TextUtils.isEmpty(getMessageCard());
    }

    public boolean isSentFromMe() {
        return TextUtils.equals(DataManager.getInstance().getLoginSession().getUid(), getFromUid());
    }
}
