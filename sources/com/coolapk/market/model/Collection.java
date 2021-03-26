package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_Collection;
import com.coolapk.market.model.C$AutoValue_Collection;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class Collection implements Entity, IUser {

    public static abstract class Builder implements IUser.BuilderM2<Builder> {
        public abstract Builder apkNum(int i);

        public abstract Collection build();

        public abstract Builder copyNum(int i);

        public abstract Builder coverPic(String str);

        public abstract Builder createdate(Long l2);

        public abstract Builder dateline(Long l2);

        public abstract Builder defaultCollected(int i);

        public abstract Builder description(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder feedNum(int i);

        public abstract Builder followNum(int i);

        public abstract Builder id(String str);

        public abstract Builder isBeCollected(int i);

        public abstract Builder isOpen(int i);

        public abstract Builder itemNum(int i);

        public abstract Builder lastUpdate(Long l2);

        public abstract Builder likeNum(int i);

        public abstract Builder logo(String str);

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

    @SerializedName("apk_num")
    public abstract int getApkNum();

    @SerializedName("copy_num")
    public abstract int getCopyNum();

    @SerializedName("cover_pic")
    public abstract String getCoverPic();

    @SerializedName("createdate")
    public abstract Long getCreatedate();

    public abstract int getDefaultCollected();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public abstract String getDescription();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "collection";
    }

    @SerializedName("feed_num")
    public abstract int getFeedNum();

    @SerializedName("follow_num")
    public abstract int getFollowNum();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    public abstract int getIsBeCollected();

    @SerializedName("is_open")
    public abstract int getIsOpen();

    @SerializedName("item_num")
    public abstract int getItemNum();

    @SerializedName("like_num")
    public abstract int getLikeNum();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

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

    public boolean isDefaultCollected() {
        return getDefaultCollected() == 1;
    }

    public boolean isBeCollected() {
        return getIsBeCollected() == 1;
    }

    public String getSubDes() {
        return getFollowNum() + "人关注  " + getItemNum() + "个内容";
    }

    public String getStatusText() {
        return getIsOpen() == 1 ? "公开" : "私密";
    }

    public boolean hasCover() {
        return !TextUtils.isEmpty(getCoverPic());
    }

    public boolean getIsOpened() {
        return getIsOpen() == 1;
    }

    public static TypeAdapter<Collection> typeAdapter(Gson gson) {
        return new C$AutoValue_Collection.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_Collection.Builder();
    }

    public static Builder newBuilder(Collection collection) {
        if (collection == null) {
            return newBuilder();
        }
        return new C$$AutoValue_Collection.Builder(collection);
    }
}
