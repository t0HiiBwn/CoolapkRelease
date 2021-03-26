package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_FeedRelation;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class FeedRelation implements Entity {
    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "feedRelation";
    }

    public static TypeAdapter<FeedRelation> typeAdapter(Gson gson) {
        return new C$AutoValue_FeedRelation.GsonTypeAdapter(gson);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
