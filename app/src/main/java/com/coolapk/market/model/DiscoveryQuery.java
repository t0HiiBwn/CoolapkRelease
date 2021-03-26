package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_DiscoveryQuery;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class DiscoveryQuery implements Entity {
    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "shareApp";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityTypeName();

    @SerializedName("intro")
    public abstract String getIntroduce();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

    public abstract String getPackageName();

    public abstract String getQuery();

    @SerializedName("referer")
    public abstract String getReference();

    @SerializedName("screenshotsArr")
    public abstract List<String> getScreenShotList();

    public abstract String getSourceName();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<DiscoveryQuery> typeAdapter(Gson gson) {
        return new C$AutoValue_DiscoveryQuery.GsonTypeAdapter(gson);
    }
}
