package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_Favorite;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class Favorite implements Entity, IUser {
    public abstract String getContent();

    @Override // com.coolapk.market.model.Entity
    public abstract String getDescription();

    public abstract String getExtra();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    public abstract int getIsEdit();

    @Override // com.coolapk.market.model.Entity
    public abstract String getPic();

    public abstract String getTag();

    @SerializedName("tags")
    public abstract List<String> getTagList();

    public abstract String getTargetId();

    public abstract String getTargetKey();

    public abstract String getTargetType();

    public abstract String getTargetUid();

    @SerializedName("targetAvatar")
    public abstract String getTargetUserAvatar();

    @SerializedName("targetUsername")
    public abstract String getTargetUserName();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    @Override // com.coolapk.market.model.Entity
    public abstract String getUrl();

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<Favorite> typeAdapter(Gson gson) {
        return new C$AutoValue_Favorite.GsonTypeAdapter(gson);
    }
}
