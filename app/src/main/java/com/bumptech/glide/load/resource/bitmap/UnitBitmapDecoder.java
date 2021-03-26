package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {
    public boolean handles(Bitmap bitmap, Options options) {
        return true;
    }

    public Resource<Bitmap> decode(Bitmap bitmap, int i, int i2, Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }

    private static final class NonOwnedBitmapResource implements Resource<Bitmap> {
        private final Bitmap bitmap;

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
        }

        NonOwnedBitmapResource(Bitmap bitmap2) {
            this.bitmap = bitmap2;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Bitmap get() {
            return this.bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return Util.getBitmapByteSize(this.bitmap);
        }
    }
}
