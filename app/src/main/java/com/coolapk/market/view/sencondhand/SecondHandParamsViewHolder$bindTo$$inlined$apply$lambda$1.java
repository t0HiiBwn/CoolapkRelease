package com.coolapk.market.view.sencondhand;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.sencondhand.SecondHandParamsViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"<anonymous>", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "checked", "", "type", "", "invoke", "com/coolapk/market/view/sencondhand/SecondHandParamsViewHolder$bindTo$2$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: SecondHandParamsViewHolder.kt */
final class SecondHandParamsViewHolder$bindTo$$inlined$apply$lambda$1 extends Lambda implements Function3<RecyclerView.ViewHolder, Boolean, Integer, Unit> {
    final /* synthetic */ MultiCheckHelper $this_apply;
    final /* synthetic */ SecondHandParamsViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SecondHandParamsViewHolder$bindTo$$inlined$apply$lambda$1(MultiCheckHelper multiCheckHelper, SecondHandParamsViewHolder secondHandParamsViewHolder) {
        super(3);
        this.$this_apply = multiCheckHelper;
        this.this$0 = secondHandParamsViewHolder;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder, Boolean bool, Integer num) {
        invoke(viewHolder, bool.booleanValue(), num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RecyclerView.ViewHolder viewHolder, boolean z, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        SecondHandParamsViewHolder.DataViewHolder dataViewHolder = (SecondHandParamsViewHolder.DataViewHolder) viewHolder;
        SecondHandParamsViewHolder.DataViewHolder.stateChange$default(dataViewHolder, z || (i == 0 ? SecondHandParamsViewHolder.access$getParamText$p(this.this$0).contains(dataViewHolder.paramText()) : false), SecondHandParamsViewHolder.access$getOptions$p(this.this$0), this.this$0.getMap(), i, null, 16, null);
    }
}
