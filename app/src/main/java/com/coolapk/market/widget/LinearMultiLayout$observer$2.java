package com.coolapk.market.widget;

import android.database.DataSetObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/coolapk/market/widget/LinearMultiLayout$observer$2$1", "invoke", "()Lcom/coolapk/market/widget/LinearMultiLayout$observer$2$1;"}, k = 3, mv = {1, 4, 2})
/* compiled from: LinearMutliLayout.kt */
final class LinearMultiLayout$observer$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ LinearMultiLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinearMultiLayout$observer$2(LinearMultiLayout linearMultiLayout) {
        super(0);
        this.this$0 = linearMultiLayout;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        return new DataSetObserver(this) {
            /* class com.coolapk.market.widget.LinearMultiLayout$observer$2.AnonymousClass1 */
            final /* synthetic */ LinearMultiLayout$observer$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                this.this$0.this$0.updateChildView();
            }
        };
    }
}
