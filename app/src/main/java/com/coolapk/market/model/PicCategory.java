package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_PicCategory;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class PicCategory implements Entity {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getPic();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    public static TypeAdapter<PicCategory> typeAdapter(Gson gson) {
        return new C$AutoValue_PicCategory.GsonTypeAdapter(gson);
    }
}
