package com.coolapk.market.model;

import com.coolapk.market.model.PermissionItem;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_PermissionItem  reason: invalid class name */
abstract class C$AutoValue_PermissionItem extends PermissionItem {
    private final CharSequence description;

    /* renamed from: group  reason: collision with root package name */
    private final CharSequence f194group;
    private final CharSequence label;
    private final int level;
    private final CharSequence sourceString;

    C$AutoValue_PermissionItem(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i) {
        Objects.requireNonNull(charSequence, "Null label");
        this.label = charSequence;
        this.sourceString = charSequence2;
        this.description = charSequence3;
        this.f194group = charSequence4;
        this.level = i;
    }

    @Override // com.coolapk.market.model.PermissionItem
    public CharSequence label() {
        return this.label;
    }

    @Override // com.coolapk.market.model.PermissionItem
    public CharSequence sourceString() {
        return this.sourceString;
    }

    @Override // com.coolapk.market.model.PermissionItem
    public CharSequence description() {
        return this.description;
    }

    @Override // com.coolapk.market.model.PermissionItem
    public CharSequence group() {
        return this.f194group;
    }

    @Override // com.coolapk.market.model.PermissionItem
    public int level() {
        return this.level;
    }

    @Override // java.lang.Object
    public String toString() {
        return "PermissionItem{label=" + ((Object) this.label) + ", sourceString=" + ((Object) this.sourceString) + ", description=" + ((Object) this.description) + ", group=" + ((Object) this.f194group) + ", level=" + this.level + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PermissionItem)) {
            return false;
        }
        PermissionItem permissionItem = (PermissionItem) obj;
        if (!this.label.equals(permissionItem.label()) || ((charSequence = this.sourceString) != null ? !charSequence.equals(permissionItem.sourceString()) : permissionItem.sourceString() != null) || ((charSequence2 = this.description) != null ? !charSequence2.equals(permissionItem.description()) : permissionItem.description() != null) || ((charSequence3 = this.f194group) != null ? !charSequence3.equals(permissionItem.group()) : permissionItem.group() != null) || this.level != permissionItem.level()) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = (this.label.hashCode() ^ 1000003) * 1000003;
        CharSequence charSequence = this.sourceString;
        int i = 0;
        int hashCode2 = (hashCode ^ (charSequence == null ? 0 : charSequence.hashCode())) * 1000003;
        CharSequence charSequence2 = this.description;
        int hashCode3 = (hashCode2 ^ (charSequence2 == null ? 0 : charSequence2.hashCode())) * 1000003;
        CharSequence charSequence3 = this.f194group;
        if (charSequence3 != null) {
            i = charSequence3.hashCode();
        }
        return ((hashCode3 ^ i) * 1000003) ^ this.level;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_PermissionItem$Builder */
    static final class Builder extends PermissionItem.Builder {
        private CharSequence description;

        /* renamed from: group  reason: collision with root package name */
        private CharSequence f195group;
        private CharSequence label;
        private Integer level;
        private CharSequence sourceString;

        Builder() {
        }

        Builder(PermissionItem permissionItem) {
            this.label = permissionItem.label();
            this.sourceString = permissionItem.sourceString();
            this.description = permissionItem.description();
            this.f195group = permissionItem.group();
            this.level = Integer.valueOf(permissionItem.level());
        }

        @Override // com.coolapk.market.model.PermissionItem.Builder
        public PermissionItem.Builder label(CharSequence charSequence) {
            this.label = charSequence;
            return this;
        }

        @Override // com.coolapk.market.model.PermissionItem.Builder
        public PermissionItem.Builder sourceString(CharSequence charSequence) {
            this.sourceString = charSequence;
            return this;
        }

        @Override // com.coolapk.market.model.PermissionItem.Builder
        public PermissionItem.Builder description(CharSequence charSequence) {
            this.description = charSequence;
            return this;
        }

        @Override // com.coolapk.market.model.PermissionItem.Builder
        public PermissionItem.Builder group(CharSequence charSequence) {
            this.f195group = charSequence;
            return this;
        }

        @Override // com.coolapk.market.model.PermissionItem.Builder
        public PermissionItem.Builder level(int i) {
            this.level = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.PermissionItem.Builder
        public PermissionItem build() {
            String str = "";
            if (this.label == null) {
                str = str + " label";
            }
            if (this.level == null) {
                str = str + " level";
            }
            if (str.isEmpty()) {
                return new AutoValue_PermissionItem(this.label, this.sourceString, this.description, this.f195group, this.level.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
