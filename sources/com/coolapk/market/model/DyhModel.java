package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_DyhModel;
import com.coolapk.market.model.C$AutoValue_DyhModel;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class DyhModel implements Entity, IUser {

    public static abstract class Builder implements IUser.BuilderM2<Builder> {
        public abstract Builder author(String str);

        public abstract DyhModel build();

        public abstract Builder dateline(Long l2);

        public abstract Builder description(String str);

        public abstract Builder editorInfo(EditorInfo editorInfo);

        public abstract Builder editors(List<String> list);

        public abstract Builder entities(List<DyhArticle> list);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder followNum(int i);

        public abstract Builder fromInfo(String str);

        public abstract Builder hasTab(int i);

        public abstract Builder id(String str);

        public abstract Builder keywords(String str);

        public abstract Builder lastUpdate(Long l2);

        public abstract Builder likeNum(int i);

        public abstract Builder logo(String str);

        public abstract Builder newsNum(int i);

        public abstract Builder pic(String str);

        public abstract Builder recommend(int i);

        public abstract Builder status(int i);

        public abstract Builder statusText(String str);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        public abstract Builder unread(Unread unread);

        public abstract Builder url(String str);

        public abstract Builder userAction(UserAction userAction);
    }

    public abstract String getAuthor();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public abstract String getDescription();

    public abstract EditorInfo getEditorInfo();

    @SerializedName("uniteEditor")
    public abstract List<String> getEditors();

    public abstract List<DyhArticle> getEntities();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "dyh";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityTypeName();

    @SerializedName("follownum")
    public abstract int getFollowNum();

    @SerializedName("fromInfo")
    public abstract String getFromInfo();

    @SerializedName("is_open_discuss")
    public abstract int getHasTab();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    @SerializedName("keywords")
    public abstract String getKeywords();

    @SerializedName("likenum")
    public abstract int getLikeNum();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public abstract String getLogo();

    @SerializedName("newsnum")
    public abstract int getNewsNum();

    public abstract int getRecommend();

    public abstract int getStatus();

    public abstract String getStatusText();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public abstract String getTitle();

    @Override // com.coolapk.market.model.IUser
    @SerializedName("uid")
    public abstract String getUid();

    public abstract Unread getUnread();

    public abstract UserAction getUserAction();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public String getEditTitle() {
        if (getEditorInfo() != null) {
            return getEditorInfo().getEditorLevel();
        }
        return null;
    }

    public boolean hasTab() {
        return getHasTab() == 1;
    }

    public boolean isDyhFollowed() {
        if (getUserAction() != null && getUserAction().getFollow() <= 0) {
            return false;
        }
        return true;
    }

    public boolean hasUnread() {
        return getUnread() != null && getUnread().getUnreadNum() > 0;
    }

    public static TypeAdapter<DyhModel> typeAdapter(Gson gson) {
        return new C$AutoValue_DyhModel.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_DyhModel.Builder();
    }

    public static Builder newBuilder(DyhModel dyhModel) {
        if (dyhModel == null) {
            return newBuilder();
        }
        return new C$$AutoValue_DyhModel.Builder(dyhModel);
    }
}
