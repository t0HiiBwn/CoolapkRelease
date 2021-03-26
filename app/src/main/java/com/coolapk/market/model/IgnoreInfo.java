package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_IgnoreInfo;

public abstract class IgnoreInfo implements Parcelable {
    public static final int TYPE_CURRENT = 1;
    public static final int TYPE_EVER = -1;
    public static final int TYPE_NONE = 0;

    public static abstract class Builder {
        public abstract IgnoreInfo build();

        public abstract Builder packageName(String str);

        public abstract Builder type(int i);

        public abstract Builder versionCode(int i);
    }

    public abstract String getPackageName();

    public abstract int getType();

    public abstract int getVersionCode();

    public boolean isIgnore() {
        return getType() != 0;
    }

    public static Builder newBuilder() {
        return new C$AutoValue_IgnoreInfo.Builder();
    }
}
