package com.coolapk.market.view.cardlist;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$refreshDataOnNextResumed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EntityListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$refreshDataOnNextResumed$1(EntityListFragment entityListFragment) {
        super(0);
        this.this$0 = entityListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.scrollToTopOnNextRefresh = true;
        View view = this.this$0.getView();
        if (view != null) {
            view.postDelayed(new Runnable(this) {
                /* class com.coolapk.market.view.cardlist.EntityListFragment$refreshDataOnNextResumed$1.AnonymousClass1 */
                final /* synthetic */ EntityListFragment$refreshDataOnNextResumed$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.this$0.scrollToTop(true);
                }
            }, 100);
        }
    }
}
