package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.widget.view.SwipeScaleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicDetailActivity$onCreate$6", "Lcom/coolapk/market/widget/view/SwipeScaleView$OnSwipeListener;", "colorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "screenHeight", "", "downSwipe", "", "onSwiping", "y", "", "overSwipe", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailActivity.kt */
public final class CoolPicDetailActivity$onCreate$6 implements SwipeScaleView.OnSwipeListener {
    private final ColorDrawable colorDrawable = new ColorDrawable(-16777216);
    private final int screenHeight;
    final /* synthetic */ CoolPicDetailActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CoolPicDetailActivity$onCreate$6(CoolPicDetailActivity coolPicDetailActivity) {
        this.this$0 = coolPicDetailActivity;
        this.screenHeight = DisplayUtils.getHeightPixels(coolPicDetailActivity.getActivity());
    }

    @Override // com.coolapk.market.widget.view.SwipeScaleView.OnSwipeListener
    public void downSwipe() {
        this.this$0.getActivity().finish();
        this.this$0.getActivity().overridePendingTransition(0, 0);
    }

    @Override // com.coolapk.market.widget.view.SwipeScaleView.OnSwipeListener
    public void onSwiping(float f) {
        if (f < ((float) 0)) {
            f = 0.0f;
        }
        this.colorDrawable.setAlpha((int) ((((float) 1) - (f / ((float) this.screenHeight))) * ((float) 255)));
        View root = CoolPicDetailActivity.access$getBinding$p(this.this$0).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.colorDrawable);
    }

    @Override // com.coolapk.market.widget.view.SwipeScaleView.OnSwipeListener
    public void overSwipe() {
        int alpha = this.colorDrawable.getAlpha();
        int i = 255 - alpha;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new CoolPicDetailActivity$onCreate$6$overSwipe$$inlined$apply$lambda$1(this, i, alpha));
        ofFloat.addListener(new CoolPicDetailActivity$onCreate$6$overSwipe$$inlined$apply$lambda$2(this, i, alpha));
        ofFloat.start();
    }
}
