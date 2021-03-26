package com.coolapk.market.model;

import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_LiveProduct  reason: invalid class name */
abstract class C$$AutoValue_LiveProduct extends LiveProduct {
    private final String id;
    private final String logo;
    private final String title;

    C$$AutoValue_LiveProduct(String str, String str2, String str3) {
        Objects.requireNonNull(str, "Null id");
        this.id = str;
        Objects.requireNonNull(str2, "Null title");
        this.title = str2;
        Objects.requireNonNull(str3, "Null logo");
        this.logo = str3;
    }

    @Override // com.coolapk.market.model.LiveProduct
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.LiveProduct
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.LiveProduct
    public String getLogo() {
        return this.logo;
    }

    @Override // java.lang.Object
    public String toString() {
        return "LiveProduct{id=" + this.id + ", title=" + this.title + ", logo=" + this.logo + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiveProduct)) {
            return false;
        }
        LiveProduct liveProduct = (LiveProduct) obj;
        if (!this.id.equals(liveProduct.getId()) || !this.title.equals(liveProduct.getTitle()) || !this.logo.equals(liveProduct.getLogo())) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.logo.hashCode();
    }
}
