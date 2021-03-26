package com.coolapk.market.view.main;

import android.view.View;
import com.coolapk.market.manager.DataManager;
import it.sephiroth.android.library.xtooltip.Tooltip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fJ\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/main/TooltipHelper;", "", "fragment", "Lcom/coolapk/market/view/main/MainFragment;", "(Lcom/coolapk/market/view/main/MainFragment;)V", "getFragment", "()Lcom/coolapk/market/view/main/MainFragment;", "getCoolPicSign", "", "getKeyTipsSign", "key", "", "getLinkPic", "getPostButton", "showPostButtonTip", "", "view", "Landroid/view/View;", "tipText", "gravity", "Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;", "tipCoolPic", "tipLinkPic", "tipPostButton", "tipSign", "showFlag", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ToolTipHelper.kt */
public final class TooltipHelper {
    private final MainFragment fragment;

    public TooltipHelper(MainFragment mainFragment) {
        Intrinsics.checkNotNullParameter(mainFragment, "fragment");
        this.fragment = mainFragment;
    }

    public final MainFragment getFragment() {
        return this.fragment;
    }

    public final void showPostButtonTip(View view, String str, Tooltip.Gravity gravity) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "tipText");
        Intrinsics.checkNotNullParameter(gravity, "gravity");
        view.post(new TooltipHelper$showPostButtonTip$1(this, view, str, gravity));
    }

    private final void tipSign(String str, boolean z) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean(str, z).apply();
    }

    private final boolean getKeyTipsSign(String str) {
        return DataManager.getInstance().getPreferencesBoolean(str, false);
    }

    public final boolean getCoolPicSign() {
        return getKeyTipsSign("TIP_TAB_COOLPIC_SHOW");
    }

    public final boolean getPostButton() {
        return getKeyTipsSign("TIP_TAB_SUBMIT_BUTTON");
    }

    public final void tipPostButton() {
        tipSign("TIP_TAB_SUBMIT_BUTTON", true);
    }

    public final void tipCoolPic() {
        tipSign("TIP_TAB_COOLPIC_SHOW", true);
    }

    public final void tipLinkPic() {
        tipSign("TIP_LINK_PIC", true);
    }

    public final boolean getLinkPic() {
        return getKeyTipsSign("TIP_LINK_PIC");
    }
}
