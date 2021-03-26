package com.coolapk.market.view.live;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.coolapk.market.databinding.ItemLiveVideoViewPartBinding;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "<anonymous parameter 5>", "<anonymous parameter 6>", "<anonymous parameter 7>", "<anonymous parameter 8>", "onLayoutChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
final class LiveVideoViewPart$onViewCreated$6 implements View.OnLayoutChangeListener {
    final /* synthetic */ LiveVideoViewPart this$0;

    LiveVideoViewPart$onViewCreated$6(LiveVideoViewPart liveVideoViewPart) {
        this.this$0 = liveVideoViewPart;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        FrameLayout frameLayout = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuFrame;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.danmakuFrame");
        FrameLayout frameLayout2 = frameLayout;
        ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout frameLayout3 = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).videoPlayer;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.videoPlayer");
            int height = (int) ((((float) frameLayout3.getHeight()) * 3.0f) / ((float) 4));
            if (height != layoutParams.height) {
                layoutParams.height = height;
                this.this$0.getDanmakuManager().onLayoutSizeChanged();
            }
            frameLayout2.setLayoutParams(layoutParams);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
