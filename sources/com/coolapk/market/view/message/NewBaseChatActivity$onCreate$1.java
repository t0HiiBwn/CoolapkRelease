package com.coolapk.market.view.message;

import com.coolapk.market.widget.OnKeyBoardEventAdapter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/message/NewBaseChatActivity$onCreate$1", "Lcom/coolapk/market/widget/OnKeyBoardEventAdapter;", "onKeyBoardHide", "", "onKeyBoardShow", "height", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NewBaseChatActivity.kt */
public final class NewBaseChatActivity$onCreate$1 extends OnKeyBoardEventAdapter {
    final /* synthetic */ NewBaseChatActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NewBaseChatActivity$onCreate$1(NewBaseChatActivity newBaseChatActivity) {
        this.this$0 = newBaseChatActivity;
    }

    @Override // com.coolapk.market.widget.KeyBoardListener
    public void onKeyBoardShow(int i) {
        this.this$0.onKeyBoardShow(i);
    }

    @Override // com.coolapk.market.widget.KeyBoardListener
    public void onKeyBoardHide() {
        this.this$0.onKeyBoardHide();
    }
}
