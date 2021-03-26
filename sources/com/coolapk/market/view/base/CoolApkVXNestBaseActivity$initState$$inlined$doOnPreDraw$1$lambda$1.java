package com.coolapk.market.view.base;

import android.graphics.Rect;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange", "com/coolapk/market/view/base/CoolApkVXNestBaseActivity$initState$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolApkVXNestBaseActivity.kt */
final class CoolApkVXNestBaseActivity$initState$$inlined$doOnPreDraw$1$lambda$1 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ CoolApkVXNestBaseActivity$initState$$inlined$doOnPreDraw$1 this$0;

    CoolApkVXNestBaseActivity$initState$$inlined$doOnPreDraw$1$lambda$1(CoolApkVXNestBaseActivity$initState$$inlined$doOnPreDraw$1 coolApkVXNestBaseActivity$initState$$inlined$doOnPreDraw$1) {
        this.this$0 = coolApkVXNestBaseActivity$initState$$inlined$doOnPreDraw$1;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        CoolApkVXNestBaseActivity.access$getHelper$p(this.this$0.this$0).syncUIState(rect.top + UiUtils.getActionBarSize(this.this$0.this$0.getActivity()) + ((int) this.this$0.this$0.cornerRadiusHeight), rect.bottom);
    }
}
