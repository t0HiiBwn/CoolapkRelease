package com.coolapk.market.model;

import com.coolapk.market.model.ImInfo;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_ImInfo  reason: invalid class name */
abstract class C$AutoValue_ImInfo extends ImInfo {
    private final String userId;
    private final String userSig;

    C$AutoValue_ImInfo(String str, String str2) {
        Objects.requireNonNull(str, "Null userId");
        this.userId = str;
        Objects.requireNonNull(str2, "Null userSig");
        this.userSig = str2;
    }

    @Override // com.coolapk.market.model.ImInfo
    public String userId() {
        return this.userId;
    }

    @Override // com.coolapk.market.model.ImInfo
    public String userSig() {
        return this.userSig;
    }

    public String toString() {
        return "ImInfo{userId=" + this.userId + ", userSig=" + this.userSig + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImInfo)) {
            return false;
        }
        ImInfo imInfo = (ImInfo) obj;
        if (!this.userId.equals(imInfo.userId()) || !this.userSig.equals(imInfo.userSig())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.userId.hashCode() ^ 1000003) * 1000003) ^ this.userSig.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ImInfo$Builder */
    static final class Builder extends ImInfo.Builder {
        private String userId;
        private String userSig;

        Builder() {
        }

        Builder(ImInfo imInfo) {
            this.userId = imInfo.userId();
            this.userSig = imInfo.userSig();
        }

        @Override // com.coolapk.market.model.ImInfo.Builder
        public ImInfo.Builder userId(String str) {
            this.userId = str;
            return this;
        }

        @Override // com.coolapk.market.model.ImInfo.Builder
        public ImInfo.Builder userSig(String str) {
            this.userSig = str;
            return this;
        }

        @Override // com.coolapk.market.model.ImInfo.Builder
        public ImInfo build() {
            String str = "";
            if (this.userId == null) {
                str = str + " userId";
            }
            if (this.userSig == null) {
                str = str + " userSig";
            }
            if (str.isEmpty()) {
                return new AutoValue_ImInfo(this.userId, this.userSig);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
