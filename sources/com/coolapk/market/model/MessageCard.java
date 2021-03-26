package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_MessageCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class MessageCard implements Card<String> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card
    public List<String> getEntities() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "messageCard";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<MessageCard> typeAdapter(Gson gson) {
        return new C$AutoValue_MessageCard.GsonTypeAdapter(gson);
    }
}
