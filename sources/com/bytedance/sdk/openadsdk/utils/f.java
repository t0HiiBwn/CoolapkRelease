package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapUtils */
public class f {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r1 != null) goto L_0x001f;
     */
    public static String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str = null;
        if (bitmap == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
        try {
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (Throwable unused3) {
        }
        return str;
    }

    public static Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return bitmap;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i >= width) {
                return bitmap;
            }
            if (i2 >= height) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Throwable th) {
            u.a(th.getMessage());
            return null;
        }
    }
}
