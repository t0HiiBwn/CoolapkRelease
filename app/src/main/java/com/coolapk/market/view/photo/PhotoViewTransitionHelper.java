package com.coolapk.market.view.photo;

import android.animation.FloatEvaluator;
import android.animation.RectEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.PhotoBinding;
import com.coolapk.market.manager.ActivityStackManager;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.widget.CatchErrorViewPager;
import com.coolapk.market.widget.photoview.PhotoView;
import com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView;
import com.coolapk.market.widget.view.SwipeScaleView;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bJ\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\bJ\u0016\u0010!\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/photo/PhotoViewTransitionHelper;", "", "activity", "Lcom/coolapk/market/view/photo/PhotoViewActivity;", "urls", "", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "initIndex", "", "(Lcom/coolapk/market/view/photo/PhotoViewActivity;Ljava/util/List;I)V", "getActivity", "()Lcom/coolapk/market/view/photo/PhotoViewActivity;", "binding", "Lcom/coolapk/market/databinding/PhotoBinding;", "colorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "getInitIndex", "()I", "getUrls", "()Ljava/util/List;", "viewMap", "Landroid/util/SparseArray;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "doEnterTransition", "", "doFinishAnimation", "getScreenOffsetComparedWithLastActivity", "onSourceLoad", "view", "Lcom/coolapk/market/widget/photoview/PhotoView;", "index", "Lcom/coolapk/market/widget/subsamplingview/SubsamplingScaleImageView;", "onThumbnailLoad", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewTransitionHelper.kt */
public final class PhotoViewTransitionHelper {
    private final PhotoViewActivity activity;
    private final PhotoBinding binding;
    private final ColorDrawable colorDrawable;
    private final int initIndex;
    private final List<PhotoViewUrl> urls;
    private final SparseArray<WeakReference<View>> viewMap = new SparseArray<>();

    public PhotoViewTransitionHelper(PhotoViewActivity photoViewActivity, List<PhotoViewUrl> list, int i) {
        Intrinsics.checkNotNullParameter(photoViewActivity, "activity");
        Intrinsics.checkNotNullParameter(list, "urls");
        this.activity = photoViewActivity;
        this.urls = list;
        this.initIndex = i;
        this.binding = photoViewActivity.getBinding();
        this.colorDrawable = new ColorDrawable(-16777216);
        doEnterTransition();
    }

    public final PhotoViewActivity getActivity() {
        return this.activity;
    }

    public final int getInitIndex() {
        return this.initIndex;
    }

    public final List<PhotoViewUrl> getUrls() {
        return this.urls;
    }

    public final void onThumbnailLoad(PhotoView photoView, int i) {
        Intrinsics.checkNotNullParameter(photoView, "view");
        LogUtils.d("onThumbnailLoad index:" + i, new Object[0]);
        this.viewMap.put(i, new WeakReference<>(photoView));
    }

    public final void onSourceLoad(PhotoView photoView, int i) {
        Intrinsics.checkNotNullParameter(photoView, "view");
        LogUtils.d("onSourceLoad index:" + i, new Object[0]);
        this.viewMap.put(i, new WeakReference<>(photoView));
    }

    public final void onSourceLoad(SubsamplingScaleImageView subsamplingScaleImageView, int i) {
        Intrinsics.checkNotNullParameter(subsamplingScaleImageView, "view");
        LogUtils.d("onSourceLoad SubsamplingScaleImageView index:" + i, new Object[0]);
        this.viewMap.put(i, new WeakReference<>(subsamplingScaleImageView));
    }

    public final void doFinishAnimation() {
        int i;
        int i2;
        Float f;
        Rect rect;
        float f2;
        float f3;
        CatchErrorViewPager catchErrorViewPager = this.binding.viewPager;
        Intrinsics.checkNotNullExpressionValue(catchErrorViewPager, "binding.viewPager");
        int currentItem = catchErrorViewPager.getCurrentItem();
        View root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Drawable background = root.getBackground();
        int valueOf = background != null ? Integer.valueOf(background.getAlpha()) : null;
        if (valueOf == null) {
            valueOf = 255;
        }
        int intValue = valueOf.intValue();
        PhotoViewUrl photoViewUrl = (PhotoViewUrl) CollectionsKt.getOrNull(this.urls, currentItem);
        Rect rect2 = photoViewUrl != null ? photoViewUrl.getRect() : null;
        if (rect2 != null) {
            SwipeScaleView swipeScaleView = this.binding.swipeScaleView;
            Intrinsics.checkNotNullExpressionValue(swipeScaleView, "binding.swipeScaleView");
            float scaleX = swipeScaleView.getScaleX();
            float translationX = swipeScaleView.getTranslationX();
            float translationY = swipeScaleView.getTranslationY();
            Rect rect3 = new Rect();
            float f4 = (float) 1;
            float f5 = (float) 2;
            rect3.left = (int) (translationX + ((((float) swipeScaleView.getWidth()) * (f4 - swipeScaleView.getScaleX())) / f5));
            rect3.top = (int) (translationY + ((((float) swipeScaleView.getHeight()) * (f4 - swipeScaleView.getScaleY())) / f5));
            rect3.right = (int) (translationX + ((((float) swipeScaleView.getWidth()) * (swipeScaleView.getScaleX() + f4)) / f5));
            rect3.bottom = (int) (translationY + ((((float) swipeScaleView.getHeight()) * (f4 + swipeScaleView.getScaleY())) / f5));
            Rect rect4 = new Rect(rect2);
            rect4.offset(0, -getScreenOffsetComparedWithLastActivity());
            FloatEvaluator floatEvaluator = new FloatEvaluator();
            float width = ((float) rect4.width()) / ((float) rect4.height());
            String source = this.urls.get(currentItem).getSource();
            AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(source);
            if (size != null) {
                Intrinsics.checkNotNullExpressionValue(size, "it");
                f = Float.valueOf(((float) size.getWidth()) / ((float) size.getHeight()));
            } else {
                f = null;
            }
            if (f == null) {
                if (StringsKt.startsWith$default(source, "file://", false, 2, (Object) null)) {
                    Uri parse = Uri.parse(source);
                    Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
                    Pair<Integer, Integer> bitmapSize = KotlinExtendKt.getBitmapSize(parse, this.activity);
                    f3 = bitmapSize.getFirst().floatValue() / ((float) bitmapSize.getSecond().intValue());
                } else {
                    f3 = ((float) rect3.width()) / ((float) rect3.height());
                }
                f = Float.valueOf(f3);
            }
            float floatValue = f.floatValue();
            float centerX = translationX - (((float) rect3.centerX()) - ((float) rect4.centerX()));
            float centerY = translationY - (((float) rect3.centerY()) - ((float) rect4.centerY()));
            RectEvaluator rectEvaluator = new RectEvaluator(new Rect());
            Rect rect5 = new Rect(0, 0, swipeScaleView.getWidth(), swipeScaleView.getHeight());
            if (((double) (width - floatValue)) <= -0.05d) {
                f2 = scaleX / ((((float) rect3.width()) / floatValue) / ((float) rect4.height()));
                int width2 = (int) (((float) swipeScaleView.getWidth()) / floatValue);
                int i3 = ((int) (((float) width2) * width)) / 2;
                int i4 = width2 / 2;
                rect = new Rect(rect5.centerX() - i3, rect5.centerY() - i4, rect5.centerX() + i3, rect5.centerY() + i4);
            } else {
                f2 = scaleX / (((float) rect3.width()) / ((float) rect4.width()));
                int width3 = (int) (((float) swipeScaleView.getWidth()) / width);
                int i5 = ((int) (((float) width3) * width)) / 2;
                int i6 = width3 / 2;
                rect = new Rect(rect5.centerX() - i5, rect5.centerY() - i6, rect5.centerX() + i5, rect5.centerY() + i6);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(1.0f, 0.0f);
            i = currentItem;
            valueAnimator.addUpdateListener(new PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$1(this, swipeScaleView, floatEvaluator, translationX, centerX, translationY, centerY, scaleX, f2, rectEvaluator, rect5, rect, intValue));
            valueAnimator.addListener(new PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$2(this, swipeScaleView, floatEvaluator, translationX, centerX, translationY, centerY, scaleX, f2, rectEvaluator, rect5, rect, intValue));
            valueAnimator.start();
            i2 = 2;
        } else {
            i = currentItem;
            ValueAnimator valueAnimator2 = new ValueAnimator();
            SwipeScaleView swipeScaleView2 = this.binding.swipeScaleView;
            Intrinsics.checkNotNullExpressionValue(swipeScaleView2, "binding.swipeScaleView");
            float scaleX2 = swipeScaleView2.getScaleX();
            i2 = 2;
            valueAnimator2.setFloatValues(1.0f, 0.0f);
            valueAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator2.addUpdateListener(new PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$3(scaleX2, this, intValue));
            valueAnimator2.addListener(new PhotoViewTransitionHelper$doFinishAnimation$$inlined$apply$lambda$4(this, intValue));
            if (scaleX2 < 1.0f) {
                valueAnimator2.setDuration(200L);
            } else {
                valueAnimator2.setDuration(300L);
            }
            valueAnimator2.start();
        }
        Activity activityUnder$default = ActivityStackManager.getActivityUnder$default(AppHolder.getActivityStackManager(), this.activity, false, i2, null);
        if (activityUnder$default instanceof PhotoActivityCallback) {
            ((PhotoActivityCallback) activityUnder$default).onDismissPhoto(this.urls.get(i).getSource(), i);
        }
    }

    private final void doEnterTransition() {
        PhotoViewUrl photoViewUrl = (PhotoViewUrl) CollectionsKt.getOrNull(this.urls, this.initIndex);
        Rect rect = photoViewUrl != null ? photoViewUrl.getRect() : null;
        if (rect != null) {
            SwipeScaleView swipeScaleView = this.binding.swipeScaleView;
            Intrinsics.checkNotNullExpressionValue(swipeScaleView, "binding.swipeScaleView");
            View root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.getViewTreeObserver().addOnPreDrawListener(new PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1(root, this, swipeScaleView, rect));
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new PhotoViewTransitionHelper$doEnterTransition$$inlined$apply$lambda$1(this));
        valueAnimator.setDuration(300L);
        valueAnimator.start();
    }

    /* access modifiers changed from: private */
    public final int getScreenOffsetComparedWithLastActivity() {
        Activity activityUnder$default;
        if (Build.VERSION.SDK_INT < 28 || (activityUnder$default = ActivityStackManager.getActivityUnder$default(AppHolder.getActivityStackManager(), this.activity, false, 2, null)) == null) {
            return 0;
        }
        Window window = activityUnder$default.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "bgActivity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "bgActivity.window.decorView");
        int measuredHeight = decorView.getMeasuredHeight();
        Window window2 = this.activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "activity.window");
        View decorView2 = window2.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
        return measuredHeight - decorView2.getMeasuredHeight();
    }
}
