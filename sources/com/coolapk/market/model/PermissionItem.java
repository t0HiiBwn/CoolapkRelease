package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_PermissionItem;

public abstract class PermissionItem implements Parcelable {
    public static final int LEVEL_DANGEROUS = 1;
    public static final int LEVEL_NORMAL = 0;
    public static final int LEVEL_SIGNATURE = 2;
    public static final int LEVEL_SIGNATURE_OR_SYSTEM = 3;
    public static final int LEVEL_UNKNOW = -1;

    public static abstract class Builder {
        public abstract PermissionItem build();

        public abstract Builder description(CharSequence charSequence);

        public abstract Builder group(CharSequence charSequence);

        public abstract Builder label(CharSequence charSequence);

        public abstract Builder level(int i);

        public abstract Builder sourceString(CharSequence charSequence);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract CharSequence description();

    public abstract CharSequence group();

    public abstract CharSequence label();

    public abstract int level();

    public abstract CharSequence sourceString();

    public String levelText() {
        return String.valueOf(level());
    }

    public static Builder builder() {
        return new C$AutoValue_PermissionItem.Builder().level(-1);
    }
}
