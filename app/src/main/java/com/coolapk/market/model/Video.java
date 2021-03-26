package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_Video;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class Video implements Entity {
    public abstract String getCover();

    public abstract int getDuration();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "video";
    }

    public abstract boolean getIsLive();

    public abstract String getMediaType();

    public abstract String getName();

    public abstract String getPlayHeaders();

    public abstract String getRequestParams();

    @SerializedName("redirectSource")
    public abstract boolean isRedirectSource();

    @Override // com.coolapk.market.model.Entity
    public String getTitle() {
        return getName();
    }

    public static TypeAdapter<Video> typeAdapter(Gson gson) {
        return new C$AutoValue_Video.GsonTypeAdapter(gson).setDefaultRedirectSource(true);
    }
}
