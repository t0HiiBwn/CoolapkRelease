package com.coolapk.market.view.block;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/block/BlockWordListFragment$removeBlockWord$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlockWordListFragment.kt */
public final class BlockWordListFragment$removeBlockWord$1 extends EmptySubscriber<String> {
    final /* synthetic */ BlockItem $item;
    final /* synthetic */ BlockWordListFragment this$0;

    BlockWordListFragment$removeBlockWord$1(BlockWordListFragment blockWordListFragment, BlockItem blockItem) {
        this.this$0 = blockWordListFragment;
        this.$item = blockItem;
    }

    public void onNext(String str) {
        super.onNext((BlockWordListFragment$removeBlockWord$1) str);
        CollectionsKt.removeAll((List) this.this$0.getDataList(), (Function1) new BlockWordListFragment$removeBlockWord$1$onNext$1(this));
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Toast.error(this.this$0.getActivity(), th);
    }
}
