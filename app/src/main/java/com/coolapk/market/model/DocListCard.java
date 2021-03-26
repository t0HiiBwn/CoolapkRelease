package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_DocListCard;
import com.coolapk.market.model.C$AutoValue_DocListCard;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class DocListCard implements Card<Entity> {

    public static abstract class Builder {
        public abstract DocListCard build();

        public abstract Builder setDateline(Long l2);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntities(List<Entity> list);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setId(String str);

        public abstract Builder setLastUpdate(Long l2);

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
    public String getEntityType() {
        return "docListCard";
    }

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

    public static TypeAdapter<DocListCard> typeAdapter(Gson gson) {
        return new C$AutoValue_DocListCard.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$$AutoValue_DocListCard.Builder();
    }
}
