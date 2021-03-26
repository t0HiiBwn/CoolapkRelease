package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_TopCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class TopCard implements Card<ServiceApp> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card
    public abstract List<ServiceApp> getEntities();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "topCard";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getPic();

    @Override // com.coolapk.market.model.Entity
    public abstract String getSubTitle();

    public abstract String getSubUrl();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<TopCard> typeAdapter(Gson gson) {
        return new C$AutoValue_TopCard.GsonTypeAdapter(gson);
    }
}
