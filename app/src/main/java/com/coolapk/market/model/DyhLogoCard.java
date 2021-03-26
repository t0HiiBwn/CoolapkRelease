package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_DyhLogoCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class DyhLogoCard implements Card<Entity> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getDescription();

    @Override // com.coolapk.market.model.Card
    public abstract List<Entity> getEntities();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityType();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityTypeName();

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getUrl();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<DyhLogoCard> typeAdapter(Gson gson) {
        return new C$AutoValue_DyhLogoCard.GsonTypeAdapter(gson);
    }
}
