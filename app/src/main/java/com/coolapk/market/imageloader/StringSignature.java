package com.coolapk.market.imageloader;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Objects;

public class StringSignature implements Key {
    private final String signature;

    public StringSignature(String str) {
        Objects.requireNonNull(str, "Signature cannot be null!");
        this.signature = str;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.signature.equals(((StringSignature) obj).signature);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        try {
            messageDigest.update(this.signature.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
