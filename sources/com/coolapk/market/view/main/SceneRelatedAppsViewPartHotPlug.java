package com.coolapk.market.view.main;

import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.viewholder.ServiceAppViewHolder;
import com.coolapk.market.widget.hotplug.ViewPartHotPlug;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0014J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0003H\u0014R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/main/SceneRelatedAppsViewPartHotPlug;", "Lcom/coolapk/market/widget/hotplug/ViewPartHotPlug;", "Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart;", "Lcom/coolapk/market/model/ServiceApp;", "serviceAppViewHolder", "Lcom/coolapk/market/viewholder/ServiceAppViewHolder;", "sceneRelatedAppsHelper", "Lcom/coolapk/market/view/main/SceneRelatedAppsHelper;", "component", "Landroidx/databinding/DataBindingComponent;", "(Lcom/coolapk/market/viewholder/ServiceAppViewHolder;Lcom/coolapk/market/view/main/SceneRelatedAppsHelper;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ServiceAppBinding;", "kotlin.jvm.PlatformType", "bindData", "", "viewPart", "data", "createViewPart", "onViewPartLoad", "recycleViewPart", "removeView", "view", "Landroid/view/View;", "shouldShowView", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SceneRelatedAppsHelper.kt */
public final class SceneRelatedAppsViewPartHotPlug extends ViewPartHotPlug<SceneRelatedAppsViewPart, ServiceApp> {
    private final ServiceAppBinding binding;
    private final SceneRelatedAppsHelper sceneRelatedAppsHelper;
    private final ServiceAppViewHolder serviceAppViewHolder;

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ SceneRelatedAppsViewPartHotPlug(ServiceAppViewHolder serviceAppViewHolder2, SceneRelatedAppsHelper sceneRelatedAppsHelper2, DataBindingComponent dataBindingComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(serviceAppViewHolder2, sceneRelatedAppsHelper2, dataBindingComponent);
        if ((i & 4) != 0) {
            dataBindingComponent = serviceAppViewHolder2.getComponent();
            Intrinsics.checkNotNullExpressionValue(dataBindingComponent, "serviceAppViewHolder.component");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public SceneRelatedAppsViewPartHotPlug(ServiceAppViewHolder serviceAppViewHolder2, SceneRelatedAppsHelper sceneRelatedAppsHelper2, DataBindingComponent dataBindingComponent) {
        super(2131558903, r9 == null ? new ViewPartPool() : r9, false, 4, null);
        Intrinsics.checkNotNullParameter(serviceAppViewHolder2, "serviceAppViewHolder");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ViewPartPool viewPartPool = KotlinExtendKt.getViewPartPool(dataBindingComponent);
        this.serviceAppViewHolder = serviceAppViewHolder2;
        this.sceneRelatedAppsHelper = sceneRelatedAppsHelper2;
        this.binding = (ServiceAppBinding) serviceAppViewHolder2.getBinding();
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowView(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "data");
        SceneRelatedAppsHelper sceneRelatedAppsHelper2 = this.sceneRelatedAppsHelper;
        return sceneRelatedAppsHelper2 != null && sceneRelatedAppsHelper2.shouldShow(EntityExtendsKt.entityUniqueId(serviceApp));
    }

    /* access modifiers changed from: protected */
    public void recycleViewPart(SceneRelatedAppsViewPart sceneRelatedAppsViewPart) {
        Intrinsics.checkNotNullParameter(sceneRelatedAppsViewPart, "viewPart");
        removeView(sceneRelatedAppsViewPart.getView());
    }

    private final void removeView(View view) {
        FrameLayout frameLayout = this.binding.alsoDownloadLayout;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.alsoDownloadLayout");
        if (frameLayout.getChildCount() > 0) {
            FrameLayout frameLayout2 = this.binding.alsoDownloadLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.alsoDownloadLayout");
            ViewParent parent = frameLayout2.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "binding.alsoDownloadLayout.parent");
            ViewParent parent2 = parent.getParent();
            Intrinsics.checkNotNullExpressionValue(parent2, "binding.alsoDownloadLayout.parent.parent");
            ViewParent parent3 = parent2.getParent();
            if (!(parent3 instanceof ViewGroup)) {
                parent3 = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent3;
            if (viewGroup != null) {
                TransitionManager.beginDelayedTransition(viewGroup);
            }
            this.binding.alsoDownloadLayout.removeView(view);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public SceneRelatedAppsViewPart createViewPart() {
        DataBindingComponent component = this.serviceAppViewHolder.getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "serviceAppViewHolder.component");
        SceneRelatedAppsViewPart sceneRelatedAppsViewPart = new SceneRelatedAppsViewPart(component, false, 2, null);
        LayoutInflater from = LayoutInflater.from(this.serviceAppViewHolder.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(serviceAppViewHolder.context)");
        sceneRelatedAppsViewPart.createView(from, this.binding.alsoDownloadLayout);
        return sceneRelatedAppsViewPart;
    }

    /* access modifiers changed from: protected */
    public void bindData(SceneRelatedAppsViewPart sceneRelatedAppsViewPart, ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(sceneRelatedAppsViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(serviceApp, "data");
        SceneRelatedAppsHelper sceneRelatedAppsHelper2 = this.sceneRelatedAppsHelper;
        Intrinsics.checkNotNull(sceneRelatedAppsHelper2);
        Entity card = sceneRelatedAppsHelper2.getCard();
        Intrinsics.checkNotNull(card);
        sceneRelatedAppsViewPart.bindToContent(card);
    }

    /* access modifiers changed from: protected */
    public void onViewPartLoad(SceneRelatedAppsViewPart sceneRelatedAppsViewPart) {
        Intrinsics.checkNotNullParameter(sceneRelatedAppsViewPart, "viewPart");
        FrameLayout frameLayout = this.binding.alsoDownloadLayout;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.alsoDownloadLayout");
        if (frameLayout.getChildCount() == 0) {
            FrameLayout frameLayout2 = this.binding.alsoDownloadLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.alsoDownloadLayout");
            ViewParent parent = frameLayout2.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "binding.alsoDownloadLayout.parent");
            ViewParent parent2 = parent.getParent();
            Intrinsics.checkNotNullExpressionValue(parent2, "binding.alsoDownloadLayout.parent.parent");
            ViewParent parent3 = parent2.getParent();
            if (!(parent3 instanceof ViewGroup)) {
                parent3 = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent3;
            if (viewGroup != null) {
                TransitionManager.beginDelayedTransition(viewGroup);
            }
            this.binding.alsoDownloadLayout.addView(sceneRelatedAppsViewPart.getView());
        }
        View view = sceneRelatedAppsViewPart.getView();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = NumberExtendsKt.getDp((Number) 12);
        view.setLayoutParams(marginLayoutParams);
    }
}
