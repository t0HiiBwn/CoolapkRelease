package com.coolapk.market.model;

import android.os.Bundle;
import java.util.Objects;

final class AutoValue_ImageUploadOption extends ImageUploadOption {
    private final String api;
    private final Bundle bundle;
    private final String uploadDir;
    private final String url;

    AutoValue_ImageUploadOption(String str, String str2, String str3, Bundle bundle2) {
        Objects.requireNonNull(str, "Null url");
        this.url = str;
        Objects.requireNonNull(str2, "Null uploadDir");
        this.uploadDir = str2;
        Objects.requireNonNull(str3, "Null api");
        this.api = str3;
        this.bundle = bundle2;
    }

    @Override // com.coolapk.market.model.ImageUploadOption
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.ImageUploadOption
    public String getUploadDir() {
        return this.uploadDir;
    }

    @Override // com.coolapk.market.model.ImageUploadOption
    public String getApi() {
        return this.api;
    }

    @Override // com.coolapk.market.model.ImageUploadOption
    public Bundle getBundle() {
        return this.bundle;
    }

    public String toString() {
        return "ImageUploadOption{url=" + this.url + ", uploadDir=" + this.uploadDir + ", api=" + this.api + ", bundle=" + this.bundle + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageUploadOption)) {
            return false;
        }
        ImageUploadOption imageUploadOption = (ImageUploadOption) obj;
        if (this.url.equals(imageUploadOption.getUrl()) && this.uploadDir.equals(imageUploadOption.getUploadDir()) && this.api.equals(imageUploadOption.getApi())) {
            Bundle bundle2 = this.bundle;
            if (bundle2 == null) {
                if (imageUploadOption.getBundle() == null) {
                    return true;
                }
            } else if (bundle2.equals(imageUploadOption.getBundle())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((this.url.hashCode() ^ 1000003) * 1000003) ^ this.uploadDir.hashCode()) * 1000003) ^ this.api.hashCode()) * 1000003;
        Bundle bundle2 = this.bundle;
        return hashCode ^ (bundle2 == null ? 0 : bundle2.hashCode());
    }
}
