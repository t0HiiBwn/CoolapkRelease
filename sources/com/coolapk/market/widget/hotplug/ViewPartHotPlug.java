package com.coolapk.market.widget.hotplug;

import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.iview.ViewPart;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0012\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0001¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0019J\r\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\r\u0010!\u001a\u00028\u0000H$¢\u0006\u0002\u0010 J\r\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\b\u0010#\u001a\u00020\u0019H\u0016J\u0015\u0010$\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00028\u0000H$¢\u0006\u0002\u0010%J\r\u0010&\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010 J\b\u0010'\u001a\u00020\u0019H\u0002J\u0015\u0010(\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00028\u0000H$¢\u0006\u0002\u0010%J\u0015\u0010)\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00028\u0001H$¢\u0006\u0002\u0010*R\u001b\u0010\f\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006+"}, d2 = {"Lcom/coolapk/market/widget/hotplug/ViewPartHotPlug;", "VP", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "T", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "viewType", "", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "useListPadding", "", "(ILcom/coolapk/market/widget/hotplug/ViewPartPool;Z)V", "assumedPadding", "getAssumedPadding", "()I", "assumedPadding$delegate", "Lkotlin/Lazy;", "getUseListPadding", "()Z", "viewPart", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "getViewPartPool", "()Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "getViewType", "bindData", "", "data", "(Lcom/coolapk/market/viewholder/iview/ViewPart;Ljava/lang/Object;)V", "bindTo", "(Ljava/lang/Object;)V", "cacheIntoViewPoolIfNeed", "createSampleViewPart", "()Lcom/coolapk/market/viewholder/iview/ViewPart;", "createViewPart", "ensureViewPart", "onRecycled", "onViewPartLoad", "(Lcom/coolapk/market/viewholder/iview/ViewPart;)V", "optViewPart", "recycleInternal", "recycleViewPart", "shouldShowView", "(Ljava/lang/Object;)Z", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewPartHotPlug.kt */
public abstract class ViewPartHotPlug<VP extends ViewPart, T> implements Recyclable {
    private final Lazy assumedPadding$delegate;
    private final boolean useListPadding;
    private VP viewPart;
    private final ViewPartPool viewPartPool;
    private final int viewType;

    protected abstract void bindData(VP vp, T t);

    protected abstract VP createViewPart();

    public final int getAssumedPadding() {
        return ((Number) this.assumedPadding$delegate.getValue()).intValue();
    }

    protected abstract void onViewPartLoad(VP vp);

    protected abstract void recycleViewPart(VP vp);

    protected abstract boolean shouldShowView(T t);

    public ViewPartHotPlug(int i, ViewPartPool viewPartPool2, boolean z) {
        Intrinsics.checkNotNullParameter(viewPartPool2, "viewPartPool");
        this.viewType = i;
        this.viewPartPool = viewPartPool2;
        this.useListPadding = z;
        this.assumedPadding$delegate = LazyKt.lazy(new ViewPartHotPlug$assumedPadding$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewPartHotPlug(int i, ViewPartPool viewPartPool2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, viewPartPool2, (i2 & 4) != 0 ? true : z);
    }

    public final boolean getUseListPadding() {
        return this.useListPadding;
    }

    public final ViewPartPool getViewPartPool() {
        return this.viewPartPool;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public final void bindTo(T t) {
        if (!shouldShowView(t)) {
            recycleInternal();
            return;
        }
        ensureViewPart();
        VP vp = this.viewPart;
        Intrinsics.checkNotNull(vp);
        bindData(vp, t);
    }

    private final VP ensureViewPart() {
        if (this.viewPart == null) {
            VP vp = (VP) this.viewPartPool.getRecycledViewPart(this.viewType);
            this.viewPart = vp;
            if (vp == null) {
                this.viewPart = createViewPart();
            }
            VP vp2 = this.viewPart;
            Intrinsics.checkNotNull(vp2);
            onViewPartLoad(vp2);
        }
        VP vp3 = this.viewPart;
        Intrinsics.checkNotNull(vp3);
        return vp3;
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        recycleInternal();
    }

    private final void recycleInternal() {
        VP vp = this.viewPart;
        if (vp != null) {
            recycleViewPart(vp);
            this.viewPartPool.putRecycledViewPart(vp, this.viewType);
            this.viewPart = (VP) null;
        }
    }

    public final VP optViewPart() {
        return this.viewPart;
    }

    private final VP createSampleViewPart() {
        return createViewPart();
    }

    public final void cacheIntoViewPoolIfNeed() {
        if (this.viewPartPool.getRecycledViewPartCount(this.viewType) == 0) {
            this.viewPartPool.putRecycledViewPart(createSampleViewPart(), this.viewType);
        }
    }
}
