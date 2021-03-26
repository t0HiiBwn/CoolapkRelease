package com.yalantis.ucrop;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class UCrop {
    public static final String EXTRA_ASPECT_RATIO_X = "com.yalantis.ucrop.AspectRatioX";
    public static final String EXTRA_ASPECT_RATIO_Y = "com.yalantis.ucrop.AspectRatioY";
    public static final String EXTRA_ERROR = "com.yalantis.ucrop.Error";
    public static final String EXTRA_INPUT_URI = "com.yalantis.ucrop.InputUri";
    public static final String EXTRA_MAX_SIZE_X = "com.yalantis.ucrop.MaxSizeX";
    public static final String EXTRA_MAX_SIZE_Y = "com.yalantis.ucrop.MaxSizeY";
    public static final String EXTRA_OUTPUT_CROP_ASPECT_RATIO = "com.yalantis.ucrop.CropAspectRatio";
    public static final String EXTRA_OUTPUT_IMAGE_HEIGHT = "com.yalantis.ucrop.ImageHeight";
    public static final String EXTRA_OUTPUT_IMAGE_WIDTH = "com.yalantis.ucrop.ImageWidth";
    public static final String EXTRA_OUTPUT_URI = "com.yalantis.ucrop.OutputUri";
    private static final String EXTRA_PREFIX = "com.yalantis.ucrop";
    public static final int REQUEST_CROP = 69;
    public static final int RESULT_ERROR = 96;
    private Intent mCropIntent = new Intent();
    private Bundle mCropOptionsBundle;

    public static UCrop of(Uri uri, Uri uri2) {
        return new UCrop(uri, uri2);
    }

    private UCrop(Uri uri, Uri uri2) {
        Bundle bundle = new Bundle();
        this.mCropOptionsBundle = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        this.mCropOptionsBundle.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }

    public UCrop withAspectRatio(float f, float f2) {
        this.mCropOptionsBundle.putFloat("com.yalantis.ucrop.AspectRatioX", f);
        this.mCropOptionsBundle.putFloat("com.yalantis.ucrop.AspectRatioY", f2);
        return this;
    }

    public UCrop useSourceImageAspectRatio() {
        this.mCropOptionsBundle.putFloat("com.yalantis.ucrop.AspectRatioX", 0.0f);
        this.mCropOptionsBundle.putFloat("com.yalantis.ucrop.AspectRatioY", 0.0f);
        return this;
    }

    public UCrop withMaxResultSize(int i, int i2) {
        this.mCropOptionsBundle.putInt("com.yalantis.ucrop.MaxSizeX", i);
        this.mCropOptionsBundle.putInt("com.yalantis.ucrop.MaxSizeY", i2);
        return this;
    }

    public UCrop withOptions(Options options) {
        this.mCropOptionsBundle.putAll(options.getOptionBundle());
        return this;
    }

    public void start(Activity activity) {
        start(activity, 69);
    }

    public void start(Activity activity, int i) {
        activity.startActivityForResult(getIntent(activity), i);
    }

    public void start(Context context, Fragment fragment) {
        start(context, fragment, 69);
    }

    public void start(Context context, androidx.fragment.app.Fragment fragment) {
        start(context, fragment, 69);
    }

    public void start(Context context, Fragment fragment, int i) {
        fragment.startActivityForResult(getIntent(context), i);
    }

    public void start(Context context, androidx.fragment.app.Fragment fragment, int i) {
        fragment.startActivityForResult(getIntent(context), i);
    }

    public Intent getIntent(Context context) {
        this.mCropIntent.setClass(context, UCropActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public static Uri getOutput(Intent intent) {
        return (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
    }

    public static float getOutputCropAspectRatio(Intent intent) {
        return ((Float) intent.getParcelableExtra("com.yalantis.ucrop.CropAspectRatio")).floatValue();
    }

    public static Throwable getError(Intent intent) {
        return (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error");
    }

    public static class Options {
        public static final String EXTRA_ALLOWED_GESTURES = "com.yalantis.ucrop.AllowedGestures";
        public static final String EXTRA_ASPECT_RATIO_OPTIONS = "com.yalantis.ucrop.AspectRatioOptions";
        public static final String EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        public static final String EXTRA_CIRCLE_DIMMED_LAYER = "com.yalantis.ucrop.CircleDimmedLayer";
        public static final String EXTRA_COMPRESSION_FORMAT_NAME = "com.yalantis.ucrop.CompressionFormatName";
        public static final String EXTRA_COMPRESSION_QUALITY = "com.yalantis.ucrop.CompressionQuality";
        public static final String EXTRA_CROP_FRAME_COLOR = "com.yalantis.ucrop.CropFrameColor";
        public static final String EXTRA_CROP_FRAME_STROKE_WIDTH = "com.yalantis.ucrop.CropFrameStrokeWidth";
        public static final String EXTRA_CROP_GRID_COLOR = "com.yalantis.ucrop.CropGridColor";
        public static final String EXTRA_CROP_GRID_COLUMN_COUNT = "com.yalantis.ucrop.CropGridColumnCount";
        public static final String EXTRA_CROP_GRID_ROW_COUNT = "com.yalantis.ucrop.CropGridRowCount";
        public static final String EXTRA_CROP_GRID_STROKE_WIDTH = "com.yalantis.ucrop.CropGridStrokeWidth";
        public static final String EXTRA_DIMMED_LAYER_COLOR = "com.yalantis.ucrop.DimmedLayerColor";
        public static final String EXTRA_FREE_STYLE_CROP = "com.yalantis.ucrop.FreeStyleCrop";
        public static final String EXTRA_HIDE_BOTTOM_CONTROLS = "com.yalantis.ucrop.HideBottomControls";
        public static final String EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";
        public static final String EXTRA_MAX_BITMAP_SIZE = "com.yalantis.ucrop.MaxBitmapSize";
        public static final String EXTRA_MAX_SCALE_MULTIPLIER = "com.yalantis.ucrop.MaxScaleMultiplier";
        public static final String EXTRA_SHOW_CROP_FRAME = "com.yalantis.ucrop.ShowCropFrame";
        public static final String EXTRA_SHOW_CROP_GRID = "com.yalantis.ucrop.ShowCropGrid";
        public static final String EXTRA_STATUS_BAR_COLOR = "com.yalantis.ucrop.StatusBarColor";
        public static final String EXTRA_TOOL_BAR_COLOR = "com.yalantis.ucrop.ToolbarColor";
        public static final String EXTRA_UCROP_COLOR_WIDGET_ACTIVE = "com.yalantis.ucrop.UcropColorWidgetActive";
        public static final String EXTRA_UCROP_LOGO_COLOR = "com.yalantis.ucrop.UcropLogoColor";
        public static final String EXTRA_UCROP_TITLE_TEXT_TOOLBAR = "com.yalantis.ucrop.UcropToolbarTitleText";
        public static final String EXTRA_UCROP_WIDGET_COLOR_TOOLBAR = "com.yalantis.ucrop.UcropToolbarWidgetColor";
        private final Bundle mOptionBundle = new Bundle();

        public Bundle getOptionBundle() {
            return this.mOptionBundle;
        }

        public void setCompressionFormat(Bitmap.CompressFormat compressFormat) {
            this.mOptionBundle.putString("com.yalantis.ucrop.CompressionFormatName", compressFormat.name());
        }

        public void setCompressionQuality(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.CompressionQuality", i);
        }

        public void setAllowedGestures(int i, int i2, int i3) {
            this.mOptionBundle.putIntArray("com.yalantis.ucrop.AllowedGestures", new int[]{i, i2, i3});
        }

        public void setMaxScaleMultiplier(float f) {
            this.mOptionBundle.putFloat("com.yalantis.ucrop.MaxScaleMultiplier", f);
        }

        public void setImageToCropBoundsAnimDuration(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", i);
        }

        public void setMaxBitmapSize(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.MaxBitmapSize", i);
        }

        public void setDimmedLayerColor(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.DimmedLayerColor", i);
        }

        public void setCircleDimmedLayer(boolean z) {
            this.mOptionBundle.putBoolean("com.yalantis.ucrop.CircleDimmedLayer", z);
        }

        public void setShowCropFrame(boolean z) {
            this.mOptionBundle.putBoolean("com.yalantis.ucrop.ShowCropFrame", z);
        }

        public void setCropFrameColor(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.CropFrameColor", i);
        }

        public void setCropFrameStrokeWidth(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.CropFrameStrokeWidth", i);
        }

        public void setShowCropGrid(boolean z) {
            this.mOptionBundle.putBoolean("com.yalantis.ucrop.ShowCropGrid", z);
        }

        public void setCropGridRowCount(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.CropGridRowCount", i);
        }

        public void setCropGridColumnCount(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.CropGridColumnCount", i);
        }

        public void setCropGridColor(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.CropGridColor", i);
        }

        public void setCropGridStrokeWidth(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.CropGridStrokeWidth", i);
        }

        public void setToolbarColor(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.ToolbarColor", i);
        }

        public void setStatusBarColor(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.StatusBarColor", i);
        }

        public void setActiveWidgetColor(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.UcropColorWidgetActive", i);
        }

        public void setToolbarWidgetColor(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.UcropToolbarWidgetColor", i);
        }

        public void setToolbarTitle(String str) {
            this.mOptionBundle.putString("com.yalantis.ucrop.UcropToolbarTitleText", str);
        }

        public void setLogoColor(int i) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.UcropLogoColor", i);
        }

        public void setHideBottomControls(boolean z) {
            this.mOptionBundle.putBoolean("com.yalantis.ucrop.HideBottomControls", z);
        }

        public void setFreeStyleCropEnabled(boolean z) {
            this.mOptionBundle.putBoolean("com.yalantis.ucrop.FreeStyleCrop", z);
        }

        public void setAspectRatioOptions(int i, AspectRatio... aspectRatioArr) {
            if (i <= aspectRatioArr.length) {
                this.mOptionBundle.putInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", i);
                this.mOptionBundle.putParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions", new ArrayList<>(Arrays.asList(aspectRatioArr)));
                return;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", Integer.valueOf(i), Integer.valueOf(aspectRatioArr.length)));
        }

        public void withAspectRatio(float f, float f2) {
            this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioX", f);
            this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioY", f2);
        }

        public void useSourceImageAspectRatio() {
            this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioX", 0.0f);
            this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioY", 0.0f);
        }

        public void withMaxResultSize(int i, int i2) {
            this.mOptionBundle.putInt("com.yalantis.ucrop.MaxSizeX", i);
            this.mOptionBundle.putInt("com.yalantis.ucrop.MaxSizeY", i2);
        }
    }
}
