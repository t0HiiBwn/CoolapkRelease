package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_AlbumCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class AlbumCard implements Card<Album> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card
    public abstract List<Album> getEntities();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "gridCard";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<AlbumCard> typeAdapter(Gson gson) {
        return new C$AutoValue_AlbumCard.GsonTypeAdapter(gson);
    }
}
