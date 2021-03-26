package com.coolapk.market.view.node.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.transition.TransitionManager;
import com.coolapk.market.databinding.AppNodeHeaderBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.main.SceneRelatedAppsViewPart;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "id", "", "card", "Lcom/coolapk/market/model/Entity;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeViewPart.kt */
final class AppNodeViewPart$onViewCreated$7 extends Lambda implements Function2<String, Entity, Unit> {
    final /* synthetic */ AppNodeViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeViewPart$onViewCreated$7(AppNodeViewPart appNodeViewPart) {
        super(2);
        this.this$0 = appNodeViewPart;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Entity entity) {
        invoke(str, entity);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, Entity entity) {
        ServiceApp serviceApp = this.this$0.viewModel.getServiceApp().get();
        if (serviceApp != null && Intrinsics.areEqual(str, EntityExtendsKt.entityUniqueId(serviceApp)) && entity != null) {
            FrameLayout frameLayout = ((AppNodeHeaderBinding) this.this$0.getBinding()).alsoDownloadLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.alsoDownloadLayout");
            ViewParent parent = frameLayout.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            TransitionManager.beginDelayedTransition((ViewGroup) parent);
            SceneRelatedAppsViewPart sceneRelatedAppsViewPart = this.this$0.getSceneRelatedAppsViewPart();
            LayoutInflater from = LayoutInflater.from(this.this$0.activity);
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
            View createView = sceneRelatedAppsViewPart.createView(from, ((AppNodeHeaderBinding) this.this$0.getBinding()).alsoDownloadLayout);
            ((AppNodeHeaderBinding) this.this$0.getBinding()).alsoDownloadLayout.addView(createView);
            ViewGroup.LayoutParams layoutParams = createView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            int dimensionPixelSize = this.this$0.getContext().getResources().getDimensionPixelSize(2131165563);
            marginLayoutParams2.leftMargin = dimensionPixelSize;
            marginLayoutParams2.rightMargin = dimensionPixelSize;
            marginLayoutParams2.topMargin = NumberExtendsKt.getDp((Number) 16);
            createView.setLayoutParams(marginLayoutParams);
            this.this$0.getSceneRelatedAppsViewPart().bindToContent(entity);
        }
    }
}
