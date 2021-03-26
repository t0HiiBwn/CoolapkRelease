package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_NewHeadLine;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class NewHeadLine implements Entity {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "headline";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityTypeName();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Entity
    public abstract String getUrl();

    public static TypeAdapter<NewHeadLine> typeAdapter(Gson gson) {
        return new C$AutoValue_NewHeadLine.GsonTypeAdapter(gson);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
