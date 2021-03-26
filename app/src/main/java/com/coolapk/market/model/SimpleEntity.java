package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_SimpleEntity;
import com.coolapk.market.model.C$AutoValue_SimpleEntity;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class SimpleEntity implements Entity {

    public static abstract class Builder {
        public abstract SimpleEntity build();

        public abstract Builder setDateline(Long l2);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

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

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<SimpleEntity> typeAdapter(Gson gson) {
        return new C$AutoValue_SimpleEntity.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$$AutoValue_SimpleEntity.Builder();
    }
}
