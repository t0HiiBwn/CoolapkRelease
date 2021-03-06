package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;

public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {
    private static final String TAG = "ImageDecoder";
    final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();

    protected abstract Resource<T> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    public final boolean handles(ImageDecoder.Source source, Options options) {
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: com.bumptech.glide.load.Options */
    /* JADX WARN: Multi-variable type inference failed */
    public final Resource<T> decode(ImageDecoder.Source source, final int i, final int i2, Options options) throws IOException {
        final DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        final DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        final boolean z = options.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options.get(Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue();
        final PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.get(Downsampler.PREFERRED_COLOR_SPACE);
        return decode(source, i, i2, new ImageDecoder.OnHeaderDecodedListener() {
            /* class com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.AnonymousClass1 */

            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                boolean z = false;
                if (ImageDecoderResourceDecoder.this.hardwareConfigState.isHardwareConfigAllowed(i, i2, z, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() {
                    /* class com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.AnonymousClass1.AnonymousClass1 */

                    @Override // android.graphics.ImageDecoder.OnPartialImageListener
                    public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                        return false;
                    }
                });
                Size size = imageInfo.getSize();
                int i = i;
                if (i == Integer.MIN_VALUE) {
                    i = size.getWidth();
                }
                int i2 = i2;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = size.getHeight();
                }
                float scaleFactor = downsampleStrategy.getScaleFactor(size.getWidth(), size.getHeight(), i, i2);
                int round = Math.round(((float) size.getWidth()) * scaleFactor);
                int round2 = Math.round(((float) size.getHeight()) * scaleFactor);
                if (Log.isLoggable("ImageDecoder", 2)) {
                    Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + scaleFactor);
                }
                imageDecoder.setTargetSize(round, round2);
                if (Build.VERSION.SDK_INT >= 28) {
                    if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                        z = true;
                    }
                    imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
                } else if (Build.VERSION.SDK_INT >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            }
        });
    }
}
