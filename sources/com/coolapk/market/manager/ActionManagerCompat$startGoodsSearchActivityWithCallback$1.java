package com.coolapk.market.manager;

import android.content.Intent;
import com.coolapk.market.model.FeedGoods;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "i", "", "intent", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ActionManagerCompat.kt */
final class ActionManagerCompat$startGoodsSearchActivityWithCallback$1 extends Lambda implements Function2<Integer, Intent, Unit> {
    final /* synthetic */ Function1 $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionManagerCompat$startGoodsSearchActivityWithCallback$1(Function1 function1) {
        super(2);
        this.$callback = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Intent intent) {
        invoke(num.intValue(), intent);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, Intent intent) {
        this.$callback.invoke(intent != null ? (FeedGoods) intent.getParcelableExtra("FEED_GOODS") : null);
    }
}
