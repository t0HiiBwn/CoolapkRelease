package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {
    private final Downsampler downsampler;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler2) {
        this.downsampler = downsampler2;
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor, Options options) {
        return this.downsampler.handles(parcelFileDescriptor);
    }

    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) throws IOException {
        return this.downsampler.decode(parcelFileDescriptor, i, i2, options);
    }
}
