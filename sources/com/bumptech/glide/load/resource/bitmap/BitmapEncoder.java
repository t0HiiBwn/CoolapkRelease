package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.BufferedOutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    private static final String TAG = "BitmapEncoder";
    private final ArrayPool arrayPool;

    public BitmapEncoder(ArrayPool arrayPool2) {
        this.arrayPool = arrayPool2;
    }

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (r6 == null) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[Catch:{ all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bc A[SYNTHETIC, Splitter:B:34:0x00bc] */
    public boolean encode(Resource<Bitmap> resource, File file, Options options) {
        Throwable th;
        IOException e;
        Bitmap bitmap = resource.get();
        Bitmap.CompressFormat format = getFormat(bitmap, options);
        GlideTrace.beginSectionFormat("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), format);
        try {
            long logTime = LogTime.getLogTime();
            int intValue = ((Integer) options.get(COMPRESSION_QUALITY)).intValue();
            boolean z = false;
            BufferedOutputStream bufferedOutputStream = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    bufferedOutputStream = this.arrayPool != null ? new BufferedOutputStream(fileOutputStream, this.arrayPool) : fileOutputStream;
                    bitmap.compress(format, intValue, bufferedOutputStream);
                    bufferedOutputStream.close();
                    z = true;
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream = fileOutputStream;
                    try {
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = fileOutputStream;
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                if (Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                }
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException unused2) {
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + format + " of size " + Util.getBitmapByteSize(bitmap) + " in " + LogTime.getElapsedMillis(logTime) + ", options format: " + options.get(COMPRESSION_FORMAT) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z;
        } finally {
            GlideTrace.endSection();
        }
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
