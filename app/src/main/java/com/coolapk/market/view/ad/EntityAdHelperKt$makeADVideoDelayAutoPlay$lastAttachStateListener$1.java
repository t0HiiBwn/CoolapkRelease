package com.coolapk.market.view.ad;

import android.view.View;
import com.coolapk.market.util.LogUtils;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import kotlin.Metadata;
import rx.Observable;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/ad/EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "Ljava/lang/Runnable;", "interval", "", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "run", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1 implements View.OnAttachStateChangeListener, Runnable {
    final /* synthetic */ NativeUnifiedADData $adData;
    final /* synthetic */ MediaView $view;
    private long interval = 1000;

    EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1(NativeUnifiedADData nativeUnifiedADData, MediaView mediaView) {
        this.$adData = nativeUnifiedADData;
        this.$view = mediaView;
        if (mediaView.isAttachedToWindow()) {
            mediaView.postDelayed(this, this.interval);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        if (view != null) {
            view.postDelayed(this, this.interval);
        }
        LogUtils.d("onViewAttachedToWindow()", new Object[0]);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        if (view != null) {
            view.removeCallbacks(this);
        }
        LogUtils.d("onViewDetachedFromWindow()", new Object[0]);
    }

    @Override // java.lang.Runnable
    public void run() {
        Observable.defer(new EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1$run$1(this)).observeOn(Schedulers.io()).subscribe();
    }
}
