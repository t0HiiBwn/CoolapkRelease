package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_DyhArticleCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class DyhArticleCard implements Card<DyhArticle> {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Card
    public abstract List<DyhArticle> getEntities();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityType();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityTypeName();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public abstract Long getLastUpdate();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public abstract String getPic();

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getUrl();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<DyhArticleCard> typeAdapter(Gson gson) {
        return new C$AutoValue_DyhArticleCard.GsonTypeAdapter(gson);
    }
}
