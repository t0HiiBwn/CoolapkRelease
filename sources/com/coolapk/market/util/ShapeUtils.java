package com.coolapk.market.util;

import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.coolapk.market.AppHolder;

public class ShapeUtils {
    public static Drawable createSearchBoxBg(Context context) {
        int dp2px = DisplayUtils.dp2px(context, 4.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = (float) dp2px;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setColor(createSearchBoxColor());
        return gradientDrawable;
    }

    public static Drawable createMessageErrorBg(Context context, boolean z) {
        int dp2px = DisplayUtils.dp2px(context, 8.0f);
        int dp2px2 = DisplayUtils.dp2px(context, 1.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (z) {
            float f = (float) dp2px2;
            float f2 = (float) dp2px;
            gradientDrawable.setCornerRadii(new float[]{f, f, f2, f2, f2, f2, f2, f2});
        } else {
            float f3 = (float) dp2px;
            float f4 = (float) dp2px2;
            gradientDrawable.setCornerRadii(new float[]{f3, f3, f4, f4, f3, f3, f3, f3});
        }
        gradientDrawable.setColor(ResourceUtils.resolveData(context, 2130969227));
        return gradientDrawable;
    }

    public static Drawable createMessageErrorBg(Context context) {
        return createMessageErrorBg(context, true);
    }

    public static int createSearchBoxColor() {
        if (AppHolder.getAppTheme().isDarkTheme()) {
            return Color.parseColor("#14FFFFFF");
        }
        if (AppHolder.getAppTheme().isLightColorTheme()) {
            return Color.parseColor("#F2F2F2");
        }
        return Color.parseColor("#33FFFFFF");
    }

    public static Drawable createRevealBg(Context context, Float f) {
        if (f == null) {
            f = Float.valueOf(DisplayUtils.dp2pxf(context, 2.0f));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue()});
        gradientDrawable.setStroke(DisplayUtils.dp2px(context, 1.0f), AppHolder.getAppTheme().getColorAccent());
        gradientDrawable.setColor(0);
        return gradientDrawable;
    }

    public static Drawable createNormalBg(Context context) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{AppHolder.getAppTheme().getColorControlActivated()});
        int dp2px = DisplayUtils.dp2px(context, 2.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = (float) dp2px;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
        return new RippleDrawable(colorStateList, gradientDrawable, null);
    }

    public static Drawable createStrokeBg(Context context, int i) {
        return createStrokeBg(context, i, AppHolder.getAppTheme().getColorAccent(), 1.0f, AppHolder.getAppTheme().getContentBackgroundColor());
    }

    public static Drawable createBgOnlyStroke(Context context, int i, int i2) {
        return createStrokeBg(context, i, i2, 1.0f, 0);
    }

    public static Drawable createStrokeBg(Context context, int i, int i2, float f, int i3) {
        return createStrokeBg(context, i, i, i, i, i2, f, i3);
    }

    public static Drawable createStrokeBg(Context context, int i, int i2, int i3, float f, int i4) {
        return createStrokeBg(context, i, i2, i2, i, i3, f, i4);
    }

    public static Drawable createStrokeBg(Context context, int i, int i2, int i3, int i4, int i5, float f, int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f2 = (float) i;
        float f3 = (float) i2;
        float f4 = (float) i3;
        float f5 = (float) i4;
        gradientDrawable.setCornerRadii(new float[]{(float) DisplayUtils.dp2px(context, f2), (float) DisplayUtils.dp2px(context, f2), (float) DisplayUtils.dp2px(context, f3), (float) DisplayUtils.dp2px(context, f3), (float) DisplayUtils.dp2px(context, f4), (float) DisplayUtils.dp2px(context, f4), (float) DisplayUtils.dp2px(context, f5), (float) DisplayUtils.dp2px(context, f5)});
        gradientDrawable.setColor(i6);
        gradientDrawable.setStroke(DisplayUtils.dp2px(context, f), i5);
        return gradientDrawable;
    }

    public static Drawable createDyhUnFollowedRevealBg(Context context) {
        int dp2px = DisplayUtils.dp2px(context, 14.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = (float) dp2px;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
        return gradientDrawable;
    }

    public static Drawable createActionCornerBg(Context context, int i) {
        return createActionCornerBg(context, i, 14, 14, 14, 14);
    }

    public static Drawable createActionCornerBg(Context context, int i, int i2) {
        DisplayUtils.dp2px(context, (float) i2);
        return createActionCornerBg(context, i, i2, i2, i2, i2);
    }

    public static Drawable createActionCornerBg(Context context, int i, int i2, int i3) {
        return createActionCornerBg(context, i, i2, i3, i3, i2);
    }

    public static Drawable createActionCornerBg(Context context, int i, int i2, int i3, int i4, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = (float) i2;
        float f2 = (float) i3;
        float f3 = (float) i4;
        float f4 = (float) i5;
        gradientDrawable.setCornerRadii(new float[]{(float) DisplayUtils.dp2px(context, f), (float) DisplayUtils.dp2px(context, f), (float) DisplayUtils.dp2px(context, f2), (float) DisplayUtils.dp2px(context, f2), (float) DisplayUtils.dp2px(context, f3), (float) DisplayUtils.dp2px(context, f3), (float) DisplayUtils.dp2px(context, f4), (float) DisplayUtils.dp2px(context, f4)});
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    public static Drawable createDyhFollowedRevealBg(Context context) {
        int dp2px = DisplayUtils.dp2px(context, 14.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = (float) dp2px;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        return gradientDrawable;
    }

    public static Drawable createDyhUnFollowBg(Context context) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent()});
        int dp2px = DisplayUtils.dp2px(context, 14.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = (float) dp2px;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
        return new RippleDrawable(colorStateList, gradientDrawable, null);
    }

    public static Drawable createDyhFollowBg(Context context) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#CCCCCC")});
        int dp2px = DisplayUtils.dp2px(context, 14.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = (float) dp2px;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        return new RippleDrawable(colorStateList, gradientDrawable, null);
    }

    public static Drawable createDownloadBg(Context context, Float f) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#CCCCCC")});
        if (f == null) {
            f = Float.valueOf(DisplayUtils.dp2pxf(context, 2.0f));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue(), f.floatValue()});
        gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{createRevealBg(context, f), new ClipDrawable(gradientDrawable, 3, 1)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        return new RippleDrawable(colorStateList, layerDrawable, null);
    }

    public static Drawable createBorderBg(Context context) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#CCCCCC")});
        int dp2px = DisplayUtils.dp2px(context, 2.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = (float) dp2px;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setStroke(DisplayUtils.dp2px(context, 1.0f), AppHolder.getAppTheme().getColorAccent());
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        return new RippleDrawable(colorStateList, gradientDrawable, null);
    }

    public static Drawable createDownloadIcon(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
        LayerDrawable layerDrawable = (LayerDrawable) ResourceUtils.getDrawable(context, 2131231276);
        layerDrawable.setDrawableByLayerId(16908288, gradientDrawable);
        return layerDrawable;
    }

    public static Drawable createCircleShapeIcon(Drawable drawable) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
        return new LayerDrawable(new Drawable[]{gradientDrawable, drawable});
    }

    public static Drawable createCircleShapeIcon(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    public static Drawable createCircleStorkShapeIcon(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(DisplayUtils.dp2px(context, 2.0f), AppHolder.getAppTheme().getContentBackgroundColor());
        return gradientDrawable;
    }

    public static Drawable createSelectableItemBackgroundWith(Context context, Drawable drawable) {
        return new LayerDrawable(new Drawable[]{createSelectableItemBackground(context), drawable});
    }

    public static Drawable createSelectableItemBackground(Context context) {
        return ResourceUtils.getDrawable(context, ResourceUtils.resolveResId(context, 16843534));
    }

    public static Bitmap createRoundedNumberBitmap(int i) {
        Application application = AppHolder.getApplication();
        int dp2px = DisplayUtils.dp2px(application, 24.0f);
        int dp2px2 = DisplayUtils.dp2px(application, 1.6f);
        Bitmap createBitmap = Bitmap.createBitmap(dp2px, dp2px, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setTextSize((float) DisplayUtils.dp2px(application, 13.0f));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        int dp2px3 = DisplayUtils.dp2px(application, 2.0f);
        int dp2px4 = DisplayUtils.dp2px(application, 3.0f);
        RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        float f = (float) dp2px4;
        rectF.inset(f, f);
        float f2 = (float) dp2px3;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float f3 = (float) dp2px2;
        RectF rectF2 = new RectF(f3, f3, (float) (canvas.getWidth() - dp2px2), (float) (canvas.getHeight() - dp2px2));
        rectF2.inset(f, f);
        float f4 = (float) (dp2px3 - 1);
        canvas.drawRoundRect(rectF2, f4, f4, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        canvas.drawText(String.valueOf(i), (float) (canvas.getWidth() / 2), (float) ((canvas.getHeight() / 2) - ((paint.getFontMetricsInt().bottom + paint.getFontMetricsInt().top) / 2)), paint);
        return createBitmap;
    }
}
