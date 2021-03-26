package com.coolapk.market.widget.hotplug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\b\u0010\u0014\u001a\u00020\u0002H\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/widget/hotplug/BaseSingleImageArticleHotPlug;", "Lcom/coolapk/market/widget/hotplug/ViewPartHotPlug;", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "", "", "viewToReplace", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "useListPadding", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/widget/hotplug/ViewPartPool;Z)V", "initParent", "Landroid/view/ViewGroup;", "bindData", "", "viewPart", "data", "createViewPart", "onViewPartLoad", "recycleViewPart", "shouldShowView", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseSingleImageArticleHotPlug.kt */
public class BaseSingleImageArticleHotPlug extends ViewPartHotPlug<NinePicViewPart, List<? extends String>> {
    private final DataBindingComponent component;
    private final ViewGroup initParent;
    private final View viewToReplace;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.coolapk.market.viewholder.iview.ViewPart, java.lang.Object] */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public /* bridge */ /* synthetic */ void bindData(NinePicViewPart ninePicViewPart, List<? extends String> list) {
        bindData(ninePicViewPart, (List<String>) list);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public /* bridge */ /* synthetic */ boolean shouldShowView(List<? extends String> list) {
        return shouldShowView((List<String>) list);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ BaseSingleImageArticleHotPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, viewPartPool, (i & 8) != 0 ? true : z);
        if ((i & 4) != 0 && (viewPartPool = KotlinExtendKt.getViewPartPool(dataBindingComponent)) == null) {
            viewPartPool = new ViewPartPool();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseSingleImageArticleHotPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool, boolean z) {
        super(2131558662, viewPartPool, z);
        Intrinsics.checkNotNullParameter(view, "viewToReplace");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(viewPartPool, "viewPartPool");
        this.viewToReplace = view;
        this.component = dataBindingComponent;
        ViewParent parent = view.getParent();
        this.initParent = (ViewGroup) (!(parent instanceof ViewGroup) ? null : parent);
    }

    protected boolean shouldShowView(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        return NinePicViewPart.Companion.shouldShowView(list);
    }

    /* access modifiers changed from: protected */
    public void recycleViewPart(NinePicViewPart ninePicViewPart) {
        Intrinsics.checkNotNullParameter(ninePicViewPart, "viewPart");
        ViewUtil.replaceView(ninePicViewPart.getView(), this.viewToReplace);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public NinePicViewPart createViewPart() {
        NinePicViewPart ninePicViewPart = new NinePicViewPart(this.component);
        LayoutInflater from = LayoutInflater.from(this.viewToReplace.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewToReplace.context)");
        ninePicViewPart.createView(from, this.initParent);
        return ninePicViewPart;
    }

    /* access modifiers changed from: protected */
    public void onViewPartLoad(NinePicViewPart ninePicViewPart) {
        Intrinsics.checkNotNullParameter(ninePicViewPart, "viewPart");
        ViewUtil.replaceView(this.viewToReplace, ninePicViewPart.getView());
        View view = ninePicViewPart.getView();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        marginLayoutParams2.leftMargin = getAssumedPadding();
        marginLayoutParams2.rightMargin = getAssumedPadding();
        view.setLayoutParams(marginLayoutParams);
    }

    protected void bindData(NinePicViewPart ninePicViewPart, List<String> list) {
        Intrinsics.checkNotNullParameter(ninePicViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(list, "data");
        ninePicViewPart.bindToContent(list);
    }
}
