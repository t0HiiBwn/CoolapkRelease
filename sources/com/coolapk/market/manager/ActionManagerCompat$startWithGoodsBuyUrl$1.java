package com.coolapk.market.manager;

import android.content.Context;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Goods;
import com.coolapk.market.util.ExpireCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/manager/ActionManagerCompat$startWithGoodsBuyUrl$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionManagerCompat.kt */
public final class ActionManagerCompat$startWithGoodsBuyUrl$1 extends EmptySubscriber<String> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Goods $goods;
    final /* synthetic */ String $key;

    ActionManagerCompat$startWithGoodsBuyUrl$1(String str, Context context, Goods goods) {
        this.$key = str;
        this.$context = context;
        this.$goods = goods;
    }

    public void onNext(String str) {
        Intrinsics.checkNotNullParameter(str, "t");
        super.onNext((ActionManagerCompat$startWithGoodsBuyUrl$1) str);
        ExpireCache.INSTANCE.put(this.$key, str);
        ActionManagerCompat.startActivityByUrl(this.$context, str, this.$goods.getTitle(), this.$goods.getSubTitle());
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        ExpireCache.INSTANCE.remove(this.$key);
        super.onError(th);
    }
}
