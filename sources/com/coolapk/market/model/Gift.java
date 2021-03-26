package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_Gift;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class Gift implements Entity, IUser {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("apk_id")
    public abstract String getApkId();

    @SerializedName("apk_logo")
    public abstract String getApkLogo();

    @SerializedName("apk_name")
    public abstract String getApkName();

    @SerializedName("apk_title")
    public abstract String getApkTitle();

    public abstract String getAuthor();

    public abstract String getContent();

    @Override // com.coolapk.market.model.Entity
    public abstract String getDescription();

    public abstract String getExtraAnalysisData();

    @Override // com.coolapk.market.model.Entity
    public abstract String getExtraData();

    @SerializedName("feed_id")
    public abstract String getFeedId();

    @SerializedName("isGet")
    protected abstract Integer getGet();

    @SerializedName("gift_card")
    public abstract String getGiftCard();

    @SerializedName("gift_data")
    public abstract String getGiftData();

    public abstract int getGiftExpires();

    public abstract String getGiftIntro();

    public abstract String getGiftUseable();

    public abstract String getGiftUsed();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    public abstract String getLabel();

    @SerializedName("parent_id")
    public abstract String getParentId();

    @SerializedName("pie_id")
    public abstract String getPieId();

    public abstract String getPieName();

    public abstract String getRelatedPackages();

    @SerializedName("is_require_installed")
    protected abstract Integer getRequireInstalled();

    public abstract Integer getStatus();

    public abstract String getTags();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    public abstract String getTotalCount();

    public abstract int getType();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    public abstract String getUseCount();

    public boolean isRequireInstalled() {
        return getRequireInstalled() != null && getRequireInstalled().intValue() == 1;
    }

    public boolean isGet() {
        return getGet() != null && getGet().intValue() == 1;
    }

    public static TypeAdapter<Gift> typeAdapter(Gson gson) {
        return new C$AutoValue_Gift.GsonTypeAdapter(gson);
    }
}
