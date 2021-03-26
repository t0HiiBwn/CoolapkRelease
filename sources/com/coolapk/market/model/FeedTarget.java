package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_FeedTarget;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class FeedTarget implements Entity {
    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "feedTarget";
    }

    @SerializedName("star_average_score")
    public abstract float getStarAverageScore();

    @SerializedName("star_total_count")
    public abstract int getStarTotalCount();

    public static TypeAdapter<FeedTarget> typeAdapter(Gson gson) {
        return new C$AutoValue_FeedTarget.GsonTypeAdapter(gson);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
