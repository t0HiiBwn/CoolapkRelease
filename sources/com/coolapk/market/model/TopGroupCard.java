package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_TopGroupCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class TopGroupCard implements Card<TopCard> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card
    public abstract List<TopCard> getEntities();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "topGroupCard";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<TopGroupCard> typeAdapter(Gson gson) {
        return new C$AutoValue_TopGroupCard.GsonTypeAdapter(gson);
    }
}
