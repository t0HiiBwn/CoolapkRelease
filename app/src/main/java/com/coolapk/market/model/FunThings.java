package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_FunThings;
import com.coolapk.market.model.C$AutoValue_FunThings;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class FunThings implements Entity, IUser {

    public static abstract class Builder implements IUser.BuilderM2<Builder> {
        public abstract FunThings build();

        public abstract Builder copyNum(int i);

        public abstract Builder coverPic(String str);

        public abstract Builder createdate(Long l2);

        public abstract Builder dateline(Long l2);

        public abstract Builder description(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder favNum(int i);

        public abstract Builder followNum(int i);

        public abstract Builder id(String str);

        public abstract Builder isAdded(int i);

        public abstract Builder isOpen(int i);

        public abstract Builder itemNum(int i);

        public abstract Builder lastUpdate(Long l2);

        public abstract Builder likeNum(int i);

        public abstract Builder logo(String str);

        public abstract Builder message(String str);

        public abstract Builder pic(String str);

        public abstract Builder replyNum(int i);

        public abstract Builder shareNum(int i);

        public abstract Builder sourceId(String str);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public abstract Builder uid(String str);

        public abstract Builder url(String str);

        public abstract Builder userAction(UserAction userAction);
    }

    @SerializedName("copy_num")
    public abstract int getCopyNum();

    @SerializedName("cover")
    public abstract String getCoverPic();

    @SerializedName("createdate")
    public abstract Long getCreatedate();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "goodsList";
    }

    @SerializedName("fav_num")
    public abstract int getFavNum();

    @SerializedName("follow_num")
    public abstract int getFollowNum();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    public abstract int getIsAdded();

    @SerializedName("is_open")
    public abstract int getIsOpen();

    @SerializedName("item_num")
    public abstract int getItemNum();

    @SerializedName("like_num")
    public abstract int getLikeNum();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

    @SerializedName("message")
    public abstract String getMessage();

    @SerializedName("reply_num")
    public abstract int getReplyNum();

    @SerializedName("share_num")
    public abstract int getShareNum();

    @SerializedName("source_id")
    public abstract String getSourceId();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public abstract String getTitle();

    @Override // com.coolapk.market.model.IUser
    @SerializedName("uid")
    public abstract String getUid();

    public abstract UserAction getUserAction();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public boolean isAdded() {
        return getIsAdded() == 1;
    }

    public String getSubDes() {
        return getFollowNum() + "人关注  " + getItemNum() + "个内容";
    }

    public boolean hasCover() {
        return !TextUtils.isEmpty(getCoverPic());
    }

    public boolean getIsOpened() {
        return getIsOpen() == 1;
    }

    public static TypeAdapter<FunThings> typeAdapter(Gson gson) {
        return new C$AutoValue_FunThings.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_FunThings.Builder();
    }

    public static Builder newBuilder(FunThings funThings) {
        if (funThings == null) {
            return newBuilder();
        }
        return new C$$AutoValue_FunThings.Builder(funThings);
    }
}
