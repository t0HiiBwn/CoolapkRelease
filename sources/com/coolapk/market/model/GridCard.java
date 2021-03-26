package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_GridCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class GridCard implements Card<ServiceApp> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card
    public abstract List<ServiceApp> getEntities();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "gridCard";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getSubTitle();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<GridCard> typeAdapter(Gson gson) {
        return new C$AutoValue_GridCard.GsonTypeAdapter(gson);
    }
}
