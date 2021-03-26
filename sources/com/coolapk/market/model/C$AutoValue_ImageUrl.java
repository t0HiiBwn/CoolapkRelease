package com.coolapk.market.model;

import com.coolapk.market.model.ImageUrl;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_ImageUrl  reason: invalid class name */
abstract class C$AutoValue_ImageUrl extends ImageUrl {
    private final String compressedUrl;
    private final String sourceUrl;
    private final String uploadDir;

    C$AutoValue_ImageUrl(String str, String str2, String str3) {
        Objects.requireNonNull(str, "Null sourceUrl");
        this.sourceUrl = str;
        this.compressedUrl = str2;
        this.uploadDir = str3;
    }

    @Override // com.coolapk.market.model.ImageUrl
    public String getSourceUrl() {
        return this.sourceUrl;
    }

    @Override // com.coolapk.market.model.ImageUrl
    public String getCompressedUrl() {
        return this.compressedUrl;
    }

    @Override // com.coolapk.market.model.ImageUrl
    public String getUploadDir() {
        return this.uploadDir;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ImageUrl{sourceUrl=" + this.sourceUrl + ", compressedUrl=" + this.compressedUrl + ", uploadDir=" + this.uploadDir + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageUrl)) {
            return false;
        }
        ImageUrl imageUrl = (ImageUrl) obj;
        if (this.sourceUrl.equals(imageUrl.getSourceUrl()) && ((str = this.compressedUrl) != null ? str.equals(imageUrl.getCompressedUrl()) : imageUrl.getCompressedUrl() == null)) {
            String str2 = this.uploadDir;
            if (str2 == null) {
                if (imageUrl.getUploadDir() == null) {
                    return true;
                }
            } else if (str2.equals(imageUrl.getUploadDir())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = (this.sourceUrl.hashCode() ^ 1000003) * 1000003;
        String str = this.compressedUrl;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.uploadDir;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_ImageUrl$Builder */
    static final class Builder extends ImageUrl.Builder {
        private String compressedUrl;
        private String sourceUrl;
        private String uploadDir;

        Builder() {
        }

        Builder(ImageUrl imageUrl) {
            this.sourceUrl = imageUrl.getSourceUrl();
            this.compressedUrl = imageUrl.getCompressedUrl();
            this.uploadDir = imageUrl.getUploadDir();
        }

        @Override // com.coolapk.market.model.ImageUrl.Builder
        public ImageUrl.Builder setSourceUrl(String str) {
            this.sourceUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.ImageUrl.Builder
        public ImageUrl.Builder setCompressedUrl(String str) {
            this.compressedUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.ImageUrl.Builder
        public ImageUrl.Builder setUploadDir(String str) {
            this.uploadDir = str;
            return this;
        }

        @Override // com.coolapk.market.model.ImageUrl.Builder
        public ImageUrl build() {
            String str = "";
            if (this.sourceUrl == null) {
                str = str + " sourceUrl";
            }
            if (str.isEmpty()) {
                return new AutoValue_ImageUrl(this.sourceUrl, this.compressedUrl, this.uploadDir);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
