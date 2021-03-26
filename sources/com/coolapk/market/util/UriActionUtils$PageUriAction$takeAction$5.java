package com.coolapk.market.util;

import android.content.Context;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/coolapk/market/util/UriActionUtils$PageUriAction$takeAction$5", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onNext", "", "aBoolean", "(Ljava/lang/Boolean;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UriActionUtils.kt */
public final class UriActionUtils$PageUriAction$takeAction$5 extends EmptySubscriber<Boolean> {
    final /* synthetic */ Context $context;

    UriActionUtils$PageUriAction$takeAction$5(Context context) {
        this.$context = context;
    }

    public void onNext(Boolean bool) {
        super.onNext((UriActionUtils$PageUriAction$takeAction$5) bool);
        ActionManager.startFallsListFragment(this.$context, UriUtils.getSecondhandFilterUrl("", "", "", ""), "同城交易", "");
    }
}
