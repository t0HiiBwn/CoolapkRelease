package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$AutoValue_MenuCard;
import com.coolapk.market.util.CollectionUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class MenuCard implements Card<MenuCard> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getDescription();

    @Override // com.coolapk.market.model.Card
    public abstract List<MenuCard> getEntities();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityType();

    @Override // com.coolapk.market.model.Entity
    public abstract int getEntityTypeId();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityTypeName();

    @Override // com.coolapk.market.model.Entity
    public abstract String getSubTitle();

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getUrl();

    public boolean hasChildItem() {
        return !CollectionUtils.isEmpty(getEntities());
    }

    public boolean hasSubTitle() {
        return !TextUtils.isEmpty(getSubTitle());
    }

    public static TypeAdapter<MenuCard> typeAdapter(Gson gson) {
        return new C$AutoValue_MenuCard.GsonTypeAdapter(gson);
    }
}
