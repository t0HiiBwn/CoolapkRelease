package com.coolapk.market.view.app;

import android.view.View;
import com.coolapk.market.util.ViewUtil;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onDoubleClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
final class AppViewV8Activity$onCreate$2 implements ViewUtil.OnDoubleClickListener {
    final /* synthetic */ Ref.ObjectRef $appViewFragment;
    final /* synthetic */ AppViewV8Activity this$0;

    AppViewV8Activity$onCreate$2(AppViewV8Activity appViewV8Activity, Ref.ObjectRef objectRef) {
        this.this$0 = appViewV8Activity;
        this.$appViewFragment = objectRef;
    }

    @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
    public final boolean onDoubleClick(View view) {
        T t = this.$appViewFragment.element;
        if (t.isVisible()) {
            Objects.requireNonNull(t, "null cannot be cast to non-null type com.coolapk.market.view.base.refresh.ScrollableFragment");
            t.scrollToTop(true);
            return true;
        }
        AppViewV8Activity.access$getBinding$p(this.this$0).appBar.setExpanded(true, false);
        return false;
    }
}
