package com.coolapk.market.model;

import android.graphics.Color;
import com.coolapk.market.model.C$AutoValue_Link;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class Link implements Entity {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getColor();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "link";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getSubTitle();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Entity
    public abstract String getUrl();

    public static TypeAdapter<Link> typeAdapter(Gson gson) {
        return new C$AutoValue_Link.GsonTypeAdapter(gson);
    }

    public int getColorInt() {
        return Color.parseColor(getColor());
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
