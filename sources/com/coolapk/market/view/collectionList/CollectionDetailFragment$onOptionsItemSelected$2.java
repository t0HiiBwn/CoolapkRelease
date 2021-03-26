package com.coolapk.market.view.collectionList;

import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: CollectionDetailFragment.kt */
final class CollectionDetailFragment$onOptionsItemSelected$2 implements Runnable {
    final /* synthetic */ CollectionDetailFragment this$0;

    CollectionDetailFragment$onOptionsItemSelected$2(CollectionDetailFragment collectionDetailFragment) {
        this.this$0 = collectionDetailFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataManager.getInstance().removeUnUseItem(CollectionDetailFragment.access$getColId$p(this.this$0)).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
            /* class com.coolapk.market.view.collectionList.CollectionDetailFragment$onOptionsItemSelected$2.AnonymousClass1 */
            final /* synthetic */ CollectionDetailFragment$onOptionsItemSelected$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(String str) {
                if (!TextUtils.isEmpty(str)) {
                    Toast.show$default(this.this$0.this$0.getActivity(), str, 0, false, 12, null);
                }
            }
        }, new Action1<Throwable>(this) {
            /* class com.coolapk.market.view.collectionList.CollectionDetailFragment$onOptionsItemSelected$2.AnonymousClass2 */
            final /* synthetic */ CollectionDetailFragment$onOptionsItemSelected$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(Throwable th) {
                Toast.error(this.this$0.this$0.getActivity(), th);
            }
        });
    }
}
