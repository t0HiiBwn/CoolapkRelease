package com.coolapk.market.view.photo;

import android.animation.FloatEvaluator;
import android.animation.RectEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.widget.view.SwipeScaleView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$doOnNextPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ Rect $sourceRect$inlined;
    final /* synthetic */ View $this_doOnNextPreDraw;
    final /* synthetic */ SwipeScaleView $view$inlined;
    final /* synthetic */ PhotoViewTransitionHelper this$0;

    public PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1(View view, PhotoViewTransitionHelper photoViewTransitionHelper, SwipeScaleView swipeScaleView, Rect rect) {
        this.$this_doOnNextPreDraw = view;
        this.this$0 = photoViewTransitionHelper;
        this.$view$inlined = swipeScaleView;
        this.$sourceRect$inlined = rect;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        Float f;
        Rect rect;
        float f2;
        float f3;
        this.$this_doOnNextPreDraw.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.$view$inlined.getWidth() <= 0 || this.$view$inlined.getHeight() <= 0) {
            return true;
        }
        Rect rect2 = new Rect(this.$sourceRect$inlined);
        rect2.offset(0, -this.this$0.getScreenOffsetComparedWithLastActivity());
        Rect rect3 = new Rect(0, 0, this.$view$inlined.getWidth(), this.$view$inlined.getHeight());
        float centerX = (((float) rect2.centerX()) - ((float) rect3.centerX())) + 0.0f;
        float centerY = (((float) rect2.centerY()) - ((float) rect3.centerY())) + 0.0f;
        FloatEvaluator floatEvaluator = new FloatEvaluator();
        float width = ((float) rect2.width()) / ((float) rect2.height());
        String source = this.this$0.getUrls().get(this.this$0.getInitIndex()).getSource();
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
                Pair<Integer, Integer> bitmapSize = KotlinExtendKt.getBitmapSize(parse, this.this$0.getActivity());
                f3 = bitmapSize.getFirst().floatValue() / ((float) bitmapSize.getSecond().intValue());
            } else {
                f3 = ((float) rect3.width()) / ((float) rect3.height());
            }
            f = Float.valueOf(f3);
        }
        float floatValue = f.floatValue();
        if (((double) (width - floatValue)) >= 0.05d) {
            int width2 = ((int) (((float) this.$view$inlined.getWidth()) / width)) / 2;
            f2 = (((float) rect2.width()) / ((float) rect3.width())) * 1.0f;
            rect = new Rect(0, rect3.centerY() - width2, this.$view$inlined.getWidth(), rect3.centerY() + width2);
        } else {
            int width3 = (int) (((float) this.$view$inlined.getWidth()) / floatValue);
            int i = ((int) (((float) width3) * width)) / 2;
            int i2 = width3 / 2;
            f2 = ((((float) rect2.height()) * floatValue) / ((float) rect3.width())) * 1.0f;
            rect = new Rect(rect3.centerX() - i, rect3.centerY() - i2, rect3.centerX() + i, rect3.centerY() + i2);
        }
        RectEvaluator rectEvaluator = new RectEvaluator(new Rect());
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1$lambda$1(floatEvaluator, centerX, centerY, f2, rectEvaluator, rect, rect3, this));
        valueAnimator.addListener(new PhotoViewTransitionHelper$doEnterTransition$$inlined$doOnNextPreDraw$1$lambda$2(floatEvaluator, centerX, centerY, f2, rectEvaluator, rect, rect3, this));
        valueAnimator.setDuration(300L);
        valueAnimator.start();
        return false;
    }
}
