package com.coolapk.market.model;

import com.coolapk.market.model.ProductParams;

/* renamed from: com.coolapk.market.model.$AutoValue_ProductParams  reason: invalid class name */
abstract class C$AutoValue_ProductParams extends ProductParams {
    private final int checkBoxState;
    private final int itemState;
    private final int itemType;
    private final String key;
    private final int keyIndex;
    private final String title;

    C$AutoValue_ProductParams(String str, String str2, int i, int i2, int i3, int i4) {
        this.title = str;
        this.key = str2;
        this.itemState = i;
        this.itemType = i2;
        this.checkBoxState = i3;
        this.keyIndex = i4;
    }

    @Override // com.coolapk.market.model.ProductParams
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.ProductParams
    public String getKey() {
        return this.key;
    }

    @Override // com.coolapk.market.model.ProductParams
    public int getItemState() {
        return this.itemState;
    }

    @Override // com.coolapk.market.model.ProductParams
    public int getItemType() {
        return this.itemType;
    }

    @Override // com.coolapk.market.model.ProductParams
    public int getCheckBoxState() {
        return this.checkBoxState;
    }

    @Override // com.coolapk.market.model.ProductParams
    public int getKeyIndex() {
        return this.keyIndex;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ProductParams{title=" + this.title + ", key=" + this.key + ", itemState=" + this.itemState + ", itemType=" + this.itemType + ", checkBoxState=" + this.checkBoxState + ", keyIndex=" + this.keyIndex + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductParams)) {
            return false;
        }
        ProductParams productParams = (ProductParams) obj;
        String str = this.title;
        if (str != null ? str.equals(productParams.getTitle()) : productParams.getTitle() == null) {
            String str2 = this.key;
            if (str2 != null ? str2.equals(productParams.getKey()) : productParams.getKey() == null) {
                if (this.itemState == productParams.getItemState() && this.itemType == productParams.getItemType() && this.checkBoxState == productParams.getCheckBoxState() && this.keyIndex == productParams.getKeyIndex()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.key;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((((hashCode ^ i) * 1000003) ^ this.itemState) * 1000003) ^ this.itemType) * 1000003) ^ this.checkBoxState) * 1000003) ^ this.keyIndex;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ProductParams$Builder */
    static final class Builder extends ProductParams.Builder {
        private Integer checkBoxState;
        private Integer itemState;
        private Integer itemType;
        private String key;
        private Integer keyIndex;
        private String title;

        Builder() {
        }

        Builder(ProductParams productParams) {
            this.title = productParams.getTitle();
            this.key = productParams.getKey();
            this.itemState = Integer.valueOf(productParams.getItemState());
            this.itemType = Integer.valueOf(productParams.getItemType());
            this.checkBoxState = Integer.valueOf(productParams.getCheckBoxState());
            this.keyIndex = Integer.valueOf(productParams.getKeyIndex());
        }

        @Override // com.coolapk.market.model.ProductParams.Builder
        public ProductParams.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.ProductParams.Builder
        public ProductParams.Builder setKey(String str) {
            this.key = str;
            return this;
        }

        @Override // com.coolapk.market.model.ProductParams.Builder
        public ProductParams.Builder setItemState(int i) {
            this.itemState = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ProductParams.Builder
        public ProductParams.Builder setItemType(int i) {
            this.itemType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ProductParams.Builder
        public ProductParams.Builder setCheckBoxState(int i) {
            this.checkBoxState = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ProductParams.Builder
        public ProductParams.Builder setKeyIndex(int i) {
            this.keyIndex = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ProductParams.Builder
        public ProductParams build() {
            String str = "";
            if (this.itemState == null) {
                str = str + " itemState";
            }
            if (this.itemType == null) {
                str = str + " itemType";
            }
            if (this.checkBoxState == null) {
                str = str + " checkBoxState";
            }
            if (this.keyIndex == null) {
                str = str + " keyIndex";
            }
            if (str.isEmpty()) {
                return new AutoValue_ProductParams(this.title, this.key, this.itemState.intValue(), this.itemType.intValue(), this.checkBoxState.intValue(), this.keyIndex.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
