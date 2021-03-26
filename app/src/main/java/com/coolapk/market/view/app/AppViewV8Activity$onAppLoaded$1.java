package com.coolapk.market.view.app;

import android.view.View;
import com.coolapk.market.widget.CoolMarketURLSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/app/AppViewV8Activity$onAppLoaded$1", "Lcom/coolapk/market/widget/CoolMarketURLSpan;", "onClick", "", "widget", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
public final class AppViewV8Activity$onAppLoaded$1 extends CoolMarketURLSpan {
    final /* synthetic */ CoolMarketURLSpan $span;
    final /* synthetic */ AppViewV8Activity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppViewV8Activity$onAppLoaded$1(AppViewV8Activity appViewV8Activity, CoolMarketURLSpan coolMarketURLSpan, String str, int i, boolean z) {
        super(str, i, z);
        this.this$0 = appViewV8Activity;
        this.$span = coolMarketURLSpan;
    }

    @Override // com.coolapk.market.widget.CoolMarketURLSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        super.onClick(view);
        this.this$0.finish();
    }
}
