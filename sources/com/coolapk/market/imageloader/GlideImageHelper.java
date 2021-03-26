package com.coolapk.market.imageloader;

import android.view.View;
import android.widget.ImageView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import java.lang.reflect.Field;

public class GlideImageHelper {
    private static Field sListenerInfoField;
    private static Field sOnClickListenerField;

    public static boolean shouldLoadRightNow(ImageView imageView) {
        if (imageView == null) {
            return true;
        }
        checkAndClearOldTag(imageView);
        if (isClickedView(imageView)) {
            clearClickFlag(imageView);
            return true;
        } else if (isForceToLoadImageView(imageView)) {
            return true;
        } else {
            if (isAppIconImageView(imageView)) {
                return shouldLoadAppIcon();
            }
            return shouldLoadOtherImage();
        }
    }

    private static void checkAndClearOldTag(ImageView imageView) {
        if (imageView.getTag(2131362706) != null) {
            imageView.setTag(2131362706, null);
            imageView.setTag(2131362705, null);
            imageView.setTag(2131362717, null);
            imageView.setTag(2131362711, null);
            imageView.setTag(2131362709, null);
            imageView.setTag(2131362716, null);
            imageView.setTag(2131362713, null);
            imageView.setTag(2131362699, null);
        }
    }

    public static boolean shouldLoadAppIcon() {
        if (AppHolder.getAppSetting().isAutoDisableImageLoadEnabled() && !AppHolder.getAppSetting().isAlwaysLoadAppIconEnabled()) {
            return AppHolder.getAppSetting().isWifiAvailable();
        }
        return true;
    }

    public static boolean shouldLoadOtherImage() {
        if (!AppHolder.getAppSetting().isAutoDisableImageLoadEnabled()) {
            return true;
        }
        return AppHolder.getAppSetting().isWifiAvailable();
    }

    public static void saveArgumentsAndSetListener(GlideImageLoader glideImageLoader, GlideRequestComponent glideRequestComponent, String str, ImageView imageView, ImageLoaderOptions imageLoaderOptions, OnImageLoadListener onImageLoadListener, OnBitmapTransformListener onBitmapTransformListener) {
        imageView.setTag(2131362706, glideImageLoader);
        imageView.setTag(2131362705, glideRequestComponent);
        imageView.setTag(2131362717, str);
        imageView.setTag(2131362711, imageLoaderOptions);
        imageView.setTag(2131362709, onImageLoadListener);
        imageView.setTag(2131362716, onBitmapTransformListener);
        imageView.setTag(2131362701, Boolean.valueOf(imageView.isClickable()));
        if (isClickToload(imageView)) {
            View.OnClickListener itsOnClickListener = getItsOnClickListener(imageView);
            if (!(itsOnClickListener instanceof ClickToLoadListener)) {
                if (itsOnClickListener != null && !itsOnClickListener.getClass().getName().contains(GlideImageHelper.class.getName())) {
                    imageView.setTag(2131362699, itsOnClickListener);
                }
                imageView.setOnClickListener(new ClickToLoadListener());
            }
        }
    }

    private static class ClickToLoadListener implements View.OnClickListener {
        private ClickToLoadListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageView imageView = (ImageView) view;
            if (GlideImageHelper.getItsOnClickListener(imageView) instanceof ClickToLoadListener) {
                view.setOnClickListener(GlideImageHelper.getPrevOnClickListenerFromTag(view));
                view.setTag(2131362708, true);
                GlideImageLoader glideImageLoader = (GlideImageLoader) view.getTag(2131362706);
                if (glideImageLoader != null) {
                    view.setClickable(GlideImageHelper.isTagClickableImageView(imageView));
                    glideImageLoader.displayImage((GlideRequestComponent) view.getTag(2131362705), (String) view.getTag(2131362717), imageView, (ImageLoaderOptions) view.getTag(2131362711), (OnImageLoadListener) view.getTag(2131362709), (OnBitmapTransformListener) view.getTag(2131362716));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static View.OnClickListener getItsOnClickListener(ImageView imageView) {
        if (sListenerInfoField == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mListenerInfo");
                sListenerInfoField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (sOnClickListenerField == null) {
            try {
                Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                sOnClickListenerField = declaredField2;
                declaredField2.setAccessible(true);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        try {
            Object obj = sListenerInfoField.get(imageView);
            if (obj != null) {
                return (View.OnClickListener) sOnClickListenerField.get(obj);
            }
            return null;
        } catch (Throwable th3) {
            th3.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static View.OnClickListener getPrevOnClickListenerFromTag(View view) {
        return (View.OnClickListener) view.getTag(2131362699);
    }

    public static void setForceToLoad(ImageView imageView, Boolean bool) {
        if (bool != null) {
            imageView.setTag(2131362704, bool);
        }
    }

    public static void setClickToLoad(ImageView imageView, Boolean bool) {
        if (bool != null) {
            imageView.setTag(2131362700, bool);
        }
    }

    private static void clearClickFlag(ImageView imageView) {
        imageView.setTag(2131362708, false);
    }

    private static boolean isClickedView(ImageView imageView) {
        Boolean bool = (Boolean) imageView.getTag(2131362708);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static boolean isClickToload(ImageView imageView) {
        Boolean bool = (Boolean) imageView.getTag(2131362700);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static boolean isAppIconImageView(ImageView imageView) {
        Boolean bool = (Boolean) imageView.getTag(2131362707);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static boolean isForceToLoadImageView(ImageView imageView) {
        Boolean bool = (Boolean) imageView.getTag(2131362704);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public static boolean isTagClickableImageView(ImageView imageView) {
        Boolean bool = (Boolean) imageView.getTag(2131362701);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
