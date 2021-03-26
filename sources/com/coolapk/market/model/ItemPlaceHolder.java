package com.coolapk.market.model;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.C$$AutoValue_ItemPlaceHolder;
import com.coolapk.market.model.C$AutoValue_ItemPlaceHolder;
import com.coolapk.market.model.IUser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class ItemPlaceHolder implements Entity, IUser {

    public static abstract class Builder implements IUser.BuilderM2<Builder> {
        public abstract ItemPlaceHolder build();

        public abstract Builder collectionItemInfo(CollectionItem collectionItem);

        public abstract Builder dateline(Long l2);

        public abstract Builder description(String str);

        public abstract Builder dyhModel(DyhModel dyhModel);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder id(String str);

        public abstract Builder lastUpdate(Long l2);

        public abstract Builder logo(String str);

        public abstract Builder pic(String str);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        public abstract Builder url(String str);
    }

    @SerializedName("collection_item_info")
    public abstract CollectionItem getCollectionItemInfo();

    @SerializedName("dyh_info")
    public abstract DyhModel getDyhModel();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "itemPlaceHolder";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        if (getUserInfo() != null) {
            sb.append(getUserInfo().getDisplayUserName());
            sb.append("：");
        }
        if (getCollectionItemInfo() != null) {
            sb.append(getCollectionItemInfo().getContent());
        }
        return sb.toString();
    }

    public boolean isMe() {
        return (getCollectionItemInfo() == null || getCollectionItemInfo().getUid() == null || !getCollectionItemInfo().getUid().equals(DataManager.getInstance().getLoginSession().getUid())) ? false : true;
    }

    public String getDisplayUserAvatar() {
        if (getDyhModel() != null) {
            return getDyhModel().getLogo();
        }
        return IUser.IUserGetter.getUserAvatar(this);
    }

    public String getShowUserName() {
        if (getDyhModel() != null) {
            return getDyhModel().getTitle();
        }
        return IUser.IUserGetter.getUserName(this);
    }

    public static TypeAdapter<ItemPlaceHolder> typeAdapter(Gson gson) {
        return new C$AutoValue_ItemPlaceHolder.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_ItemPlaceHolder.Builder();
    }

    public static Builder newBuilder(ItemPlaceHolder itemPlaceHolder) {
        if (itemPlaceHolder == null) {
            return newBuilder();
        }
        return new C$$AutoValue_ItemPlaceHolder.Builder(itemPlaceHolder);
    }
}
