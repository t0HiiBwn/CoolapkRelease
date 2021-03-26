package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_CardTitleItem;
import com.coolapk.market.model.C$AutoValue_CardTitleItem;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class CardTitleItem implements Entity {

    public static abstract class Builder {
        public abstract CardTitleItem build();

        public abstract Builder dateline(Long l2);

        public abstract Builder description(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder id(String str);

        public abstract Builder lastUpdate(Long l2);

        public abstract Builder logo(String str);

        public abstract Builder pageVisibility(int i);

        public abstract Builder pic(String str);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        public abstract Builder url(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "cardItem";
    }

    @SerializedName("page_visibility")
    public abstract int getPageVisibility();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    public boolean isAdded() {
        return getPageVisibility() == 1;
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public Builder builder() {
        return newBuilder(this);
    }

    public static Builder newBuilder(CardTitleItem cardTitleItem) {
        return new C$$AutoValue_CardTitleItem.Builder(cardTitleItem);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_CardTitleItem.Builder().title("").pageVisibility(0);
    }

    public static TypeAdapter<CardTitleItem> typeAdapter(Gson gson) {
        return new C$AutoValue_CardTitleItem.GsonTypeAdapter(gson);
    }
}
