package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_LinkCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class LinkCard implements Card<Link> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card
    public abstract List<Link> getEntities();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "linkCard";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<LinkCard> typeAdapter(Gson gson) {
        return new C$AutoValue_LinkCard.GsonTypeAdapter(gson);
    }
}
