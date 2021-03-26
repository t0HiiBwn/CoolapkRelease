package me.zhanghai.android.appiconloader.iconloaderlib;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GraphicsUtils {
    private static final String TAG = "GraphicsUtils";

    public static int setColorAlphaBound(int i, int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 255) {
            i2 = 255;
        }
        return (i & 16777215) | (i2 << 24);
    }

    public static byte[] flattenBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getWidth() * bitmap.getHeight() * 4);
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            Log.w("GraphicsUtils", "Could not write bitmap");
            return null;
        }
    }

    public static int getArea(Region region) {
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        int i = 0;
        while (regionIterator.next(rect)) {
            i += rect.width() * rect.height();
        }
        return i;
    }
}
