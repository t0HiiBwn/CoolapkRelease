package com.coolapk.market.view.wallpaper.coolpic;

import android.graphics.Rect;
import androidx.fragment.app.Fragment;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolPicDetailActivity.kt */
final class CoolPicDetailActivity$onCreate$4 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ CoolPicDetailActivity this$0;

    CoolPicDetailActivity$onCreate$4(CoolPicDetailActivity coolPicDetailActivity) {
        this.this$0 = coolPicDetailActivity;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        Fragment findFragmentById = this.this$0.getSupportFragmentManager().findFragmentById(2131362324);
        if (!(findFragmentById instanceof CoolPicListFragment)) {
            findFragmentById = null;
        }
        CoolPicListFragment coolPicListFragment = (CoolPicListFragment) findFragmentById;
        if (coolPicListFragment != null) {
            Intrinsics.checkNotNullExpressionValue(rect, "it");
            coolPicListFragment.applyWindowsInset(rect);
        }
    }
}
