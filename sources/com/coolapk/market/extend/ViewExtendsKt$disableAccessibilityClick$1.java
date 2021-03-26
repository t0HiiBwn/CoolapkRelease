package com.coolapk.market.extend;

import android.os.Bundle;
import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$disableAccessibilityClick$1", "Landroid/view/View$AccessibilityDelegate;", "performAccessibilityAction", "", "host", "Landroid/view/View;", "action", "", "args", "Landroid/os/Bundle;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ViewExtendsKt$disableAccessibilityClick$1 extends View.AccessibilityDelegate {
    ViewExtendsKt$disableAccessibilityClick$1() {
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (i == 16 || i == 32) {
            return true;
        }
        return super.performAccessibilityAction(view, i, bundle);
    }
}
