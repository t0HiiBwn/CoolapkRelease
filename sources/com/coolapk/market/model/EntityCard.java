package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_EntityCard;
import com.coolapk.market.model.C$AutoValue_EntityCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class EntityCard implements Card<Entity> {

    public static abstract class Builder {
        public abstract EntityCard build();

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntities(List<Entity> list);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setId(String str);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLogo(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUrl(String str);
    }

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

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public abstract Long getLastUpdate();

    @Override // com.coolapk.market.model.Entity
    public abstract String getPic();

    @Override // com.coolapk.market.model.Entity
    public abstract String getSubTitle();

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public abstract String getUrl();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static Builder builder() {
        return new C$$AutoValue_EntityCard.Builder();
    }

    public static Builder builder(EntityCard entityCard) {
        return new C$$AutoValue_EntityCard.Builder(entityCard);
    }

    public static TypeAdapter<EntityCard> typeAdapter(Gson gson) {
        return new C$AutoValue_EntityCard.GsonTypeAdapter(gson);
    }
}
