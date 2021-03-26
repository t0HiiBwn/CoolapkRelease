package com.coolapk.market.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.KotlinExtendKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ \u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/widget/RecyclerScrollHeaderListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "headerRange", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "lastValue", "getLastValue", "()F", "setLastValue", "(F)V", "wrapCallback", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecyclerScrollHeaderListener.kt */
public final class RecyclerScrollHeaderListener extends RecyclerView.OnScrollListener {
    private final int headerRange;
    private float lastValue = -1.0f;
    private final Function1<Float, Unit> wrapCallback;

    public RecyclerScrollHeaderListener(int i, final Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.headerRange = i;
        this.wrapCallback = new Function1<Float, Unit>(this) {
            /* class com.coolapk.market.widget.RecyclerScrollHeaderListener.AnonymousClass1 */
            final /* synthetic */ RecyclerScrollHeaderListener this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                if (f != this.this$0.getLastValue()) {
                    this.this$0.setLastValue(f);
                    function1.invoke(Float.valueOf(this.this$0.getLastValue()));
                }
            }
        };
    }

    public final float getLastValue() {
        return this.lastValue;
    }

    public final void setLastValue(float f) {
        this.lastValue = f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition >= 1) {
                this.wrapCallback.invoke(Float.valueOf(1.0f));
            } else if (findFirstVisibleItemPosition == 0) {
                View childAt = linearLayoutManager.getChildAt(0);
                Intrinsics.checkNotNull(childAt);
                this.wrapCallback.invoke(Float.valueOf(KotlinExtendKt.constrain(((float) Math.abs(childAt.getTop() - recyclerView.getPaddingTop())) / ((float) this.headerRange), 1.0f, 0.0f)));
            } else {
                this.wrapCallback.invoke(Float.valueOf(1.0f));
            }
        }
    }
}
