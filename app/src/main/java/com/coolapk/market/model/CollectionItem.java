package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$$AutoValue_CollectionItem;
import com.coolapk.market.model.C$AutoValue_CollectionItem;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class CollectionItem implements Parcelable {

    public static abstract class Builder {
        public abstract CollectionItem build();

        public abstract Builder collectionId(String str);

        public abstract Builder content(String str);

        public abstract Builder id(String str);

        public abstract Builder isDelete(int i);

        public abstract Builder isTop(int i);

        public abstract Builder targetType(String str);

        public abstract Builder targetUid(String str);

        public abstract Builder uid(String str);
    }

    @SerializedName("collection_id")
    public abstract String getCollectionId();

    public abstract String getContent();

    public String getEntityType() {
        return "collectionitem";
    }

    @SerializedName("id")
    public abstract String getId();

    @SerializedName("is_delete")
    public abstract int getIsDelete();

    @SerializedName("is_top")
    public abstract int getIsTop();

    @SerializedName("target_type")
    public abstract String getTargetType();

    @SerializedName("target_uid")
    public abstract String getTargetUid();

    @SerializedName("uid")
    public abstract String getUid();

    public boolean isTop() {
        return getIsTop() == 1;
    }

    public boolean isDelete() {
        return getIsDelete() == 1;
    }

    public static TypeAdapter<CollectionItem> typeAdapter(Gson gson) {
        return new C$AutoValue_CollectionItem.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_CollectionItem.Builder();
    }

    public static Builder newBuilder(CollectionItem collectionItem) {
        if (collectionItem == null) {
            return newBuilder();
        }
        return new C$$AutoValue_CollectionItem.Builder(collectionItem);
    }
}
