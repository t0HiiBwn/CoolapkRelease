package com.coolapk.market.view.user;

import android.content.DialogInterface;
import com.coolapk.market.model.Product;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: MyDigitTabListActivity.kt */
final class MyDigitDataListFragment$confirmCancelBuy$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ Product $data;
    final /* synthetic */ MyDigitDataListFragment this$0;

    MyDigitDataListFragment$confirmCancelBuy$1(MyDigitDataListFragment myDigitDataListFragment, Product product) {
        this.this$0 = myDigitDataListFragment;
        this.$data = product;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MyDigitDataListFragment.access$doCancelBuy(this.this$0, this.$data);
    }
}
