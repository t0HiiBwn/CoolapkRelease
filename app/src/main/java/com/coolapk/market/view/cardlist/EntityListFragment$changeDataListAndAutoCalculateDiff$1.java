package com.coolapk.market.view.cardlist;

import android.os.Parcelable;
import androidx.recyclerview.widget.DiffUtil;
import com.coolapk.market.widget.SimpleDiffCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$changeDataListAndAutoCalculateDiff$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ EntityListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$changeDataListAndAutoCalculateDiff$1(EntityListFragment entityListFragment, Function1 function1) {
        super(0);
        this.this$0 = entityListFragment;
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.isChangingDataListAutoCallback = true;
        List<Parcelable> dataList = this.this$0.getDataList();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(dataList);
        this.$block.invoke(dataList);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SimpleDiffCallback(arrayList, dataList), true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(S…empList, dataList), true)");
        calculateDiff.dispatchUpdatesTo(new EntityListAdapterUpdateCallback(this.this$0));
        this.this$0.isChangingDataListAutoCallback = false;
    }
}
