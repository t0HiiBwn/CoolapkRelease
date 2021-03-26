package com.coolapk.market.util.uri;

import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: TaoBaoAction.kt */
final class TaoBaoAction$takeAction$1$onFailure$1 implements Runnable {
    final /* synthetic */ TaoBaoAction$takeAction$1 this$0;

    TaoBaoAction$takeAction$1$onFailure$1(TaoBaoAction$takeAction$1 taoBaoAction$takeAction$1) {
        this.this$0 = taoBaoAction$takeAction$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActionManager.startWebViewActivity(this.this$0.$context, this.this$0.$uri.toString());
    }
}
