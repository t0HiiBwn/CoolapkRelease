package com.coolapk.market.view.base.asynclist;

import androidx.recyclerview.widget.DiffUtil;
import com.coolapk.market.widget.SimpleDiffCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "DATA", "Landroid/os/Parcelable;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ShortAsyncListFragment.kt */
final class ShortAsyncListFragment$changeDataListAndAutoCalculateDiff$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ ShortAsyncListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShortAsyncListFragment$changeDataListAndAutoCalculateDiff$1(ShortAsyncListFragment shortAsyncListFragment, Function1 function1) {
        super(0);
        this.this$0 = shortAsyncListFragment;
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.this$0.getDataList());
        this.$block.invoke(this.this$0.getDataList());
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SimpleDiffCallback(arrayList, this.this$0.getDataList()), true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(S…empList, dataList), true)");
        calculateDiff.dispatchUpdatesTo(this.this$0.getAdapter());
    }
}
