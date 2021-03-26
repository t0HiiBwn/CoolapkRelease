package com.coolapk.market.viewholder;

import com.coolapk.market.view.base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onBackKeyPressed"}, k = 3, mv = {1, 4, 2})
/* compiled from: WebViewCardViewHolder.kt */
final class WebViewCardViewHolder$enterFullScreen$2 implements BaseActivity.OnBackPressListener {
    final /* synthetic */ Function0 $exitFullScreenAction;

    WebViewCardViewHolder$enterFullScreen$2(Function0 function0) {
        this.$exitFullScreenAction = function0;
    }

    @Override // com.coolapk.market.view.base.BaseActivity.OnBackPressListener
    public final boolean onBackKeyPressed() {
        this.$exitFullScreenAction.invoke();
        return true;
    }
}
