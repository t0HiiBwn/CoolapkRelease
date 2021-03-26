package com.coolapk.market.view.live;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemLiveLineViewPartBinding;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.iview.ViewPart;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/coolapk/market/view/live/LiveLineSelectViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "()V", "binding", "Lcom/coolapk/market/databinding/ItemLiveLineViewPartBinding;", "closeListener", "Lkotlin/Function0;", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "isAnimating", "", "bindAndShow", "isLandscape", "keys", "", "", "activeKey", "clickListener", "Lkotlin/Function1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "setDisplayRatio", "ratio", "", "setOnCloseListener", "action", "startCloseAnimation", "startShowAnimation", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveLineSelectViewPart.kt */
public final class LiveLineSelectViewPart extends ViewPart {
    private ItemLiveLineViewPartBinding binding;
    private Function0<Unit> closeListener;
    private boolean isAnimating;

    private final Context getContext() {
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding = this.binding;
        if (itemLiveLineViewPartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = itemLiveLineViewPartBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root.getContext();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558807, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…w_part, viewGroup, false)");
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding = (ItemLiveLineViewPartBinding) inflate;
        this.binding = itemLiveLineViewPartBinding;
        if (itemLiveLineViewPartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = itemLiveLineViewPartBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding = this.binding;
        if (itemLiveLineViewPartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemLiveLineViewPartBinding.flowLayout.setHorizontalDividerWidth(NumberExtendsKt.getDp((Number) 24));
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding2 = this.binding;
        if (itemLiveLineViewPartBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemLiveLineViewPartBinding2.flowLayout.setVerticalDividerHeight(NumberExtendsKt.getDp((Number) 16));
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding3 = this.binding;
        if (itemLiveLineViewPartBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemLiveLineViewPartBinding3.flowLayout.setLayoutMode("FLEX");
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding4 = this.binding;
        if (itemLiveLineViewPartBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemLiveLineViewPartBinding4.closeView.setOnClickListener(new LiveLineSelectViewPart$onViewCreated$1(this));
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding5 = this.binding;
        if (itemLiveLineViewPartBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = itemLiveLineViewPartBinding5.portalView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.portalView");
        frameLayout.setClickable(true);
    }

    public final void setOnCloseListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.closeListener = function0;
    }

    public final void bindAndShow(boolean z, List<String> list, String str, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "keys");
        Intrinsics.checkNotNullParameter(str, "activeKey");
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding = this.binding;
        if (itemLiveLineViewPartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemLiveLineViewPartBinding.flowLayout.setAdapter(new LiveLineSelectViewPart$bindAndShow$1(this, str, function1, list, getContext(), 0, list));
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding2 = this.binding;
        if (itemLiveLineViewPartBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemLiveLineViewPartBinding2.flowLayout.executePendingUpdate();
        LinearLayout.LayoutParams layoutParams = null;
        if (z) {
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding3 = this.binding;
            if (itemLiveLineViewPartBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            itemLiveLineViewPartBinding3.getRoot().setOnClickListener(new LiveLineSelectViewPart$bindAndShow$2(this));
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding4 = this.binding;
            if (itemLiveLineViewPartBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = itemLiveLineViewPartBinding4.portalView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.portalView");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(frameLayout);
            if (marginParams != null) {
                marginParams.width = NumberExtendsKt.getDp((Number) 160);
            }
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding5 = this.binding;
            if (itemLiveLineViewPartBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ScrollView scrollView = itemLiveLineViewPartBinding5.scrollView;
            Intrinsics.checkNotNullExpressionValue(scrollView, "binding.scrollView");
            ViewGroup.MarginLayoutParams marginParams2 = ViewExtendsKt.getMarginParams(scrollView);
            if (marginParams2 != null) {
                marginParams2.width = NumberExtendsKt.getDp((Number) 84);
            }
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding6 = this.binding;
            if (itemLiveLineViewPartBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = itemLiveLineViewPartBinding6.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                layoutParams = layoutParams2;
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (layoutParams3 != null) {
                layoutParams3.gravity = 17;
            }
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding7 = this.binding;
            if (itemLiveLineViewPartBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView = itemLiveLineViewPartBinding7.closeView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeView");
            imageView.setVisibility(8);
        } else {
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding8 = this.binding;
            if (itemLiveLineViewPartBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            itemLiveLineViewPartBinding8.getRoot().setOnClickListener(null);
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding9 = this.binding;
            if (itemLiveLineViewPartBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout2 = itemLiveLineViewPartBinding9.portalView;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.portalView");
            ViewGroup.MarginLayoutParams marginParams3 = ViewExtendsKt.getMarginParams(frameLayout2);
            if (marginParams3 != null) {
                marginParams3.width = -1;
            }
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding10 = this.binding;
            if (itemLiveLineViewPartBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ScrollView scrollView2 = itemLiveLineViewPartBinding10.scrollView;
            Intrinsics.checkNotNullExpressionValue(scrollView2, "binding.scrollView");
            ViewGroup.MarginLayoutParams marginParams4 = ViewExtendsKt.getMarginParams(scrollView2);
            if (marginParams4 != null) {
                marginParams4.width = NumberExtendsKt.getDp((Number) 301);
            }
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding11 = this.binding;
            if (itemLiveLineViewPartBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = itemLiveLineViewPartBinding11.titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            ViewGroup.LayoutParams layoutParams4 = textView2.getLayoutParams();
            if (layoutParams4 instanceof LinearLayout.LayoutParams) {
                layoutParams = layoutParams4;
            }
            LinearLayout.LayoutParams layoutParams5 = layoutParams;
            if (layoutParams5 != null) {
                layoutParams5.gravity = 8388611;
            }
            ItemLiveLineViewPartBinding itemLiveLineViewPartBinding12 = this.binding;
            if (itemLiveLineViewPartBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView2 = itemLiveLineViewPartBinding12.closeView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.closeView");
            imageView2.setVisibility(0);
        }
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding13 = this.binding;
        if (itemLiveLineViewPartBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout3 = itemLiveLineViewPartBinding13.portalView;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.portalView");
        FrameLayout frameLayout4 = frameLayout3;
        frameLayout4.getViewTreeObserver().addOnPreDrawListener(new LiveLineSelectViewPart$bindAndShow$$inlined$doOnNextPreDraw$1(frameLayout4, this));
    }

    /* access modifiers changed from: private */
    public final void startShowAnimation() {
        if (!this.isAnimating) {
            this.isAnimating = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new LiveLineSelectViewPart$startShowAnimation$$inlined$apply$lambda$1(this));
            ExtraExtendsKt.addListeners$default(ofFloat, null, new LiveLineSelectViewPart$startShowAnimation$$inlined$apply$lambda$2(this), 1, null);
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    public final void startCloseAnimation() {
        if (!this.isAnimating) {
            this.isAnimating = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new LiveLineSelectViewPart$startCloseAnimation$$inlined$apply$lambda$1(this));
            ExtraExtendsKt.addListeners$default(ofFloat, null, new LiveLineSelectViewPart$startCloseAnimation$$inlined$apply$lambda$2(this), 1, null);
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    public final void setDisplayRatio(float f) {
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding = this.binding;
        if (itemLiveLineViewPartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = itemLiveLineViewPartBinding.portalView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.portalView");
        ItemLiveLineViewPartBinding itemLiveLineViewPartBinding2 = this.binding;
        if (itemLiveLineViewPartBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout2 = itemLiveLineViewPartBinding2.portalView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.portalView");
        frameLayout.setTranslationX(((float) frameLayout2.getWidth()) * f);
    }
}
