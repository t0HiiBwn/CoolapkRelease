package com.coolapk.market.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.coolapk.market.AppHolder;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

public class BlurUtils {
    private static RenderScript mRenderScript;

    private static RenderScript getInstance(Context context) {
        if (mRenderScript == null) {
            mRenderScript = (RenderScript) Observable.just(0).observeOn(AndroidSchedulers.mainThread()).map(new Func1<Integer, RenderScript>() {
                /* class com.coolapk.market.util.BlurUtils.AnonymousClass1 */

                public RenderScript call(Integer num) {
                    return RenderScript.create(AppHolder.getApplication());
                }
            }).toBlocking().first();
        }
        return mRenderScript;
    }

    public static Bitmap blurLogoCover(Context context, Bitmap bitmap) {
        if (!(context == null || bitmap == null)) {
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmap, bitmap.getWidth() / 10, bitmap.getHeight() / 10, (bitmap.getWidth() * 4) / 5, (bitmap.getHeight() * 4) / 5), 36, 36, true);
                fastBlur(context, createScaledBitmap, 20.0f);
                reduceBrightness(createScaledBitmap);
                return createScaledBitmap;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Bitmap blurLogoCover2(Context context, Bitmap bitmap) {
        if (!(context == null || bitmap == null)) {
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmap, bitmap.getWidth() / 10, bitmap.getHeight() / 10, (bitmap.getWidth() * 4) / 5, (bitmap.getHeight() * 4) / 5), 36, 36, true);
                fastBlur(context, createScaledBitmap, 20.0f);
                return createScaledBitmap;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Bitmap blurUserLogoCover(Context context, Bitmap bitmap) {
        if (context == null || bitmap == null) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 36, 36, true);
        fastBlur(context, createScaledBitmap, 5.0f);
        reduceBrightness(createScaledBitmap);
        return createScaledBitmap;
    }

    public static void fastBlur(Context context, Bitmap bitmap, float f) {
        RenderScript instance = getInstance(context.getApplicationContext());
        Allocation createFromBitmap = Allocation.createFromBitmap(instance, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        Allocation createTyped = Allocation.createTyped(instance, createFromBitmap.getType());
        ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(instance, Element.U8_4(mRenderScript));
        create.setRadius(f);
        create.setInput(createFromBitmap);
        create.forEach(createTyped);
        createTyped.copyTo(bitmap);
    }

    private static Bitmap reduceBrightness(Bitmap bitmap) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(0.8f, 0.8f, 0.8f, 1.0f);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmap;
    }
}
