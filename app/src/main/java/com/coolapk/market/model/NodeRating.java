package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_NodeRating;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class NodeRating implements Entity {
    public static final String TARGET_TYPE_APK = "1";
    public static final String TARGET_TYPE_PRODUCT = "7";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("buy_status")
    public abstract int getBuyStatus();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "nodeRating";
    }

    @SerializedName("feed_id")
    public abstract String getFeedId();

    @SerializedName("is_owner")
    public abstract int getIsOwner();

    @SerializedName("show_owner")
    public abstract int getShowOwner();

    @SerializedName("star")
    public abstract int getStar();

    @SerializedName("target_id")
    public abstract String getTargetId();

    @SerializedName("target_info")
    public abstract NodeTargetInfo getTargetInfo();

    @SerializedName("target_type")
    public abstract String getTargetType();

    public abstract UserInfo getUserInfo();

    public static TypeAdapter<NodeRating> typeAdapter(Gson gson) {
        return new C$AutoValue_NodeRating.GsonTypeAdapter(gson);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
