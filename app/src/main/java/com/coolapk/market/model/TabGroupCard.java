package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_TabGroupCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class TabGroupCard implements Card<GridCard> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card
    public abstract List<GridCard> getEntities();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "tabGroupCard";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<TabGroupCard> typeAdapter(Gson gson) {
        return new C$AutoValue_TabGroupCard.GsonTypeAdapter(gson);
    }
}
