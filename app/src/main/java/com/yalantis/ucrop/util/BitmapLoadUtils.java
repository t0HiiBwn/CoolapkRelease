package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class BitmapLoadUtils {
    private static final String TAG = "BitmapLoadUtils";

    public static int exifToDegrees(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int exifToTranslation(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    public static void decodeBitmapInBackground(Context context, Uri uri, Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        new BitmapLoadTask(context, uri, uri2, i, i2, bitmapLoadCallback).execute(new Void[0]);
    }

    public static Bitmap transformBitmap(Bitmap bitmap, Matrix matrix) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(createBitmap) ? createBitmap : bitmap;
        } catch (OutOfMemoryError e) {
            Log.e("BitmapLoadUtils", "transformBitmap: ", e);
            return bitmap;
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            while (true) {
                if (i3 / i5 <= i2 && i4 / i5 <= i) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int getExifOrientation(Context context, Uri uri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return 0;
            }
            int orientation = new ImageHeaderParser(openInputStream).getOrientation();
            close(openInputStream);
            return orientation;
        } catch (IOException e) {
            Log.e("BitmapLoadUtils", "getExifOrientation: " + uri.toString(), e);
            return 0;
        }
    }

    public static int calculateMaxBitmapSize(Context context) {
        int i;
        int i2;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
            i = point.x;
            i2 = point.y;
        } else {
            int width = defaultDisplay.getWidth();
            i2 = defaultDisplay.getHeight();
            i = width;
        }
        int sqrt = (int) Math.sqrt(Math.pow((double) i, 2.0d) + Math.pow((double) i2, 2.0d));
        Canvas canvas = new Canvas();
        int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (min > 0) {
            sqrt = Math.min(sqrt, min);
        }
        int maxTextureSize = EglUtils.getMaxTextureSize();
        if (maxTextureSize > 0) {
            sqrt = Math.min(sqrt, maxTextureSize);
        }
        Log.d("BitmapLoadUtils", "maxBitmapSize: " + sqrt);
        return sqrt;
    }

    public static void close(Closeable closeable) {
        if (closeable != null && (closeable instanceof Closeable)) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
