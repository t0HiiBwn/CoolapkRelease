package com.coolapk.market.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.coolapk.market.model.C$AutoValue_ProductParams;

public abstract class ProductParams implements Parcelable {

    public static abstract class Builder {
        public abstract ProductParams build();

        public abstract Builder setCheckBoxState(int i);

        public abstract Builder setItemState(int i);

        public abstract Builder setItemType(int i);

        public abstract Builder setKey(String str);

        public abstract Builder setKeyIndex(int i);

        public abstract Builder setTitle(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract int getCheckBoxState();

    public abstract int getItemState();

    public abstract int getItemType();

    public abstract String getKey();

    public abstract int getKeyIndex();

    public abstract String getTitle();

    public String getShowText() {
        if (TextUtils.isEmpty(getTitle())) {
            return "其他";
        }
        return getTitle();
    }

    public boolean isOther() {
        return getItemType() == 1;
    }

    public boolean isSingleSelect() {
        return getCheckBoxState() == 1;
    }

    public boolean isChecked() {
        return getItemState() == 1;
    }

    public static ProductParams create(String str, int i, String str2, int i2) {
        return builder().setItemType(TextUtils.equals("其他", str) ? 1 : 0).setCheckBoxState(i2).setTitle(str).setKeyIndex(getIndexByKey(str2)).setItemState(i).setKey(str2).build();
    }

    public static int getIndexByKey(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -976949631:
                if (str.equals("purity")) {
                    c = 0;
                    break;
                }
                break;
            case 112670:
                if (str.equals("ram")) {
                    c = 1;
                    break;
                }
                break;
            case 113104:
                if (str.equals("rom")) {
                    c = 2;
                    break;
                }
                break;
            case 3002509:
                if (str.equals("area")) {
                    c = 3;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 3;
            case 1:
            case 3:
                return 1;
            case 2:
                return 2;
            case 4:
                return 0;
            default:
                return 4;
        }
    }

    public static Builder builder() {
        return new C$AutoValue_ProductParams.Builder();
    }

    public static Builder newBuilder(ProductParams productParams) {
        return new C$AutoValue_ProductParams.Builder(productParams);
    }
}
