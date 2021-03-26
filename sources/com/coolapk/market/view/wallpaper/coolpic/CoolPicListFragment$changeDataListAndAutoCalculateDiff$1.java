package com.coolapk.market.view.wallpaper.coolpic;

import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.DiffUtil;
import com.coolapk.market.widget.SimpleDiffCallback;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolPicListFragment.kt */
final class CoolPicListFragment$changeDataListAndAutoCalculateDiff$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $change;
    final /* synthetic */ CoolPicListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoolPicListFragment$changeDataListAndAutoCalculateDiff$1(CoolPicListFragment coolPicListFragment, Function1 function1) {
        super(0);
        this.this$0 = coolPicListFragment;
        this.$change = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ObservableArrayList observableArrayList = this.this$0.dataList;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.this$0.dataList);
        this.$change.invoke(this.this$0.dataList);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SimpleDiffCallback(arrayList, observableArrayList), false);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(S…k(tempList, list), false)");
        MultiTypeAdapter access$getAdapter$p = CoolPicListFragment.access$getAdapter$p(this.this$0);
        Intrinsics.checkNotNull(access$getAdapter$p);
        calculateDiff.dispatchUpdatesTo(access$getAdapter$p);
    }
}
