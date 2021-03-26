package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_ConfigPage;
import com.coolapk.market.model.C$AutoValue_ConfigPage;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class ConfigPage implements Entity {

    public static abstract class Builder {
        public abstract ConfigPage build();

        public abstract Builder dateline(Long l);

        public abstract Builder description(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityType(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder id(String str);

        public abstract Builder lastUpdate(Long l);

        public abstract Builder logo(String str);

        public abstract Builder order(int i);

        public abstract Builder pageFixed(int i);

        public abstract Builder pageName(String str);

        public abstract Builder pic(String str);

        public abstract Builder rawEntities(List<SimpleEntity> list);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        public abstract Builder url(String str);

        public abstract Builder visibility(int i);
    }

    public abstract int getOrder();

    @SerializedName("page_fixed")
    protected abstract int getPageFixed();

    @SerializedName("page_name")
    public abstract String getPageName();

    @SerializedName("entities")
    public abstract List<SimpleEntity> getRawEntities();

    @SerializedName("page_visibility")
    protected abstract int getVisibility();

    public boolean isFixed() {
        return getPageFixed() == 1;
    }

    public boolean isVisibility() {
        return getVisibility() == 1;
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static Builder newBuilder(ConfigPage configPage) {
        return new C$$AutoValue_ConfigPage.Builder(configPage);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_ConfigPage.Builder().pageName("").order(0).pageFixed(0).visibility(1);
    }

    public static TypeAdapter<ConfigPage> typeAdapter(Gson gson) {
        return new C$AutoValue_ConfigPage.GsonTypeAdapter(gson).setDefaultPageName("").setDefaultOrder(0).setDefaultPageFixed(0).setDefaultVisibility(1);
    }
}
