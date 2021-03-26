package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_HolderItem;

public abstract class HolderItem implements Entity {
    public static final String HOLDER_TYPE_ORDER_SELECTOR = "holder_order_selector";
    public static final String HOLDER_TYPE_SPACE = "holder_space";
    public static final String HOLDER_TYPE_TITLE = "holder_title";

    public static abstract class Builder {
        public abstract HolderItem build();

        public abstract Builder dateline(Long l2);

        public abstract Builder description(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityType(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder id(String str);

        public abstract Builder intValue(Integer num);

        public abstract Builder lastUpdate(Long l2);

        public abstract Builder logo(String str);

        public abstract Builder pic(String str);

        public abstract Builder string(String str);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        public abstract Builder url(String str);

        public abstract Builder value(String str);
    }

    public abstract Integer getIntValue();

    public abstract String getString();

    public abstract String getValue();

    public static Builder newBuilder() {
        return new C$AutoValue_HolderItem.Builder().intValue(0);
    }

    public static Builder newBuilder(HolderItem holderItem) {
        return new C$AutoValue_HolderItem.Builder(holderItem);
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
