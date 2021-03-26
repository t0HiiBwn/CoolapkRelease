package com.coolapk.market.view.message;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onDoubleClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewBaseChatActivity.kt */
final class NewBaseChatActivity$onCreate$4 implements ViewUtil.OnDoubleClickListener {
    final /* synthetic */ NewBaseChatActivity this$0;

    NewBaseChatActivity$onCreate$4(NewBaseChatActivity newBaseChatActivity) {
        this.this$0 = newBaseChatActivity;
    }

    @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
    public final boolean onDoubleClick(View view) {
        Fragment findFragmentById = this.this$0.getSupportFragmentManager().findFragmentById(2131363614);
        if (!(findFragmentById instanceof ScrollableFragment) || !findFragmentById.isVisible()) {
            return false;
        }
        ((ScrollableFragment) findFragmentById).scrollToTop(true);
        return true;
    }
}
