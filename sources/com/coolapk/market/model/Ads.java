package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_Ads;
import com.coolapk.market.model.C$AutoValue_Ads;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class Ads implements Entity {

    public static abstract class Builder {
        public abstract Ads build();

        public abstract Builder setAdsType(String str);

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFollow(int i);

        public abstract Builder setId(String str);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLogo(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUid(String str);

        public abstract Builder setUrl(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getAdsType();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityType();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityTypeName();

    public abstract int getFollow();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public abstract String getSubTitle();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    public abstract String getUid();

    @Override // com.coolapk.market.model.Entity
    public abstract String getUrl();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<Ads> typeAdapter(Gson gson) {
        return new C$AutoValue_Ads.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$$AutoValue_Ads.Builder();
    }

    public static Builder builder(Ads ads) {
        return new C$$AutoValue_Ads.Builder(ads);
    }
}
