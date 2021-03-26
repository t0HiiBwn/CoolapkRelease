package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_TitleCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class TitleCard implements Card {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card
    public abstract List getEntities();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityType();

    @Override // com.coolapk.market.model.Entity
    public abstract String getSubTitle();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<TitleCard> typeAdapter(Gson gson) {
        return new C$AutoValue_TitleCard.GsonTypeAdapter(gson);
    }
}
