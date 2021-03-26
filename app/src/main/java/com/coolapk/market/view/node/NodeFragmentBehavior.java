package com.coolapk.market.view.node;

import android.graphics.Rect;
import com.coolapk.market.model.Entity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/node/NodeFragmentBehavior;", "", "getData", "Lcom/coolapk/market/model/Entity;", "onApplyWindowsInset", "", "inset", "Landroid/graphics/Rect;", "onFloatingButtonAction", "translationY", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeBehavior.kt */
public interface NodeFragmentBehavior {
    Entity getData();

    void onApplyWindowsInset(Rect rect);

    void onFloatingButtonAction(float f);
}
