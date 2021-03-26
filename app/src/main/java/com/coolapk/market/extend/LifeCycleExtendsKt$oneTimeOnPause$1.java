package com.coolapk.market.extend;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/extend/LifeCycleExtendsKt$oneTimeOnPause$1", "Lcom/coolapk/market/extend/SimpleLifeCycleObserver;", "onPause", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LifeCycleExtends.kt */
public final class LifeCycleExtendsKt$oneTimeOnPause$1 extends SimpleLifeCycleObserver {
    final /* synthetic */ Function0 $onPause;
    final /* synthetic */ Lifecycle $this_oneTimeOnPause;

    LifeCycleExtendsKt$oneTimeOnPause$1(Lifecycle lifecycle, Function0 function0) {
        this.$this_oneTimeOnPause = lifecycle;
        this.$onPause = function0;
    }

    @Override // com.coolapk.market.extend.SimpleLifeCycleObserver
    public void onPause() {
        this.$onPause.invoke();
        this.$this_oneTimeOnPause.removeObserver(this);
    }
}
