package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_ItemModel;

public abstract class ItemModel implements Entity {

    public static abstract class Builder {
        public abstract Builder activityName(String str);

        public abstract ItemModel build();

        public abstract Builder content(String str);

        public abstract Builder dateline(Long l);

        public abstract Builder description(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder id(String str);

        public abstract Builder lastUpdate(Long l);

        public abstract Builder logo(String str);

        public abstract Builder packageName(String str);

        public abstract Builder pic(String str);

        public abstract Builder subTitle(String str);

        public abstract Builder targetUrl(String str);

        public abstract Builder title(String str);

        public abstract Builder url(String str);
    }

    public abstract String getActivityName();

    public abstract String getContent();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "ITEM_MODEL";
    }

    public abstract String getPackageName();

    public abstract String getTargetUrl();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    public static Builder newBuilder() {
        return new C$AutoValue_ItemModel.Builder();
    }

    public static Builder newBuilder(ItemModel itemModel) {
        return new C$AutoValue_ItemModel.Builder(itemModel);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
