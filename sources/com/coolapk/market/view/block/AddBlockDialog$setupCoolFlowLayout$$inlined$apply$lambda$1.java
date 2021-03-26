package com.coolapk.market.view.block;

import android.app.Activity;
import com.coolapk.market.widget.CoolFlowLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"toggleState", "", "position", "", "invoke", "com/coolapk/market/view/block/AddBlockDialog$setupCoolFlowLayout$6$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: AddBlockDialog.kt */
final class AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Activity $activity$inlined;
    final /* synthetic */ List $blockItemList$inlined;
    final /* synthetic */ AddBlockDialog$setupCoolFlowLayout$5 $syncOKButtonUI$5$inlined;
    final /* synthetic */ CoolFlowLayout $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1(CoolFlowLayout coolFlowLayout, List list, AddBlockDialog$setupCoolFlowLayout$5 addBlockDialog$setupCoolFlowLayout$5, Activity activity) {
        super(1);
        this.$this_apply = coolFlowLayout;
        this.$blockItemList$inlined = list;
        this.$syncOKButtonUI$5$inlined = addBlockDialog$setupCoolFlowLayout$5;
        this.$activity$inlined = activity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        List list = this.$blockItemList$inlined;
        BlockItem blockItem = (BlockItem) list.get(i);
        list.set(i, BlockItem.copy$default(blockItem, null, null, null, null, !blockItem.getActive(), null, null, 111, null));
        CoolFlowLayout coolFlowLayout = this.$this_apply;
        coolFlowLayout.setAdapter(coolFlowLayout.getAdapter());
        this.$syncOKButtonUI$5$inlined.invoke();
    }
}
