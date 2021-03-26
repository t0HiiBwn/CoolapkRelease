package com.coolapk.market.view.message;

import com.coolapk.market.widget.emotion.EmotionPanel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewBaseChatActivity.kt */
final class NewBaseChatActivity$onClick$1 implements Runnable {
    final /* synthetic */ NewBaseChatActivity this$0;

    NewBaseChatActivity$onClick$1(NewBaseChatActivity newBaseChatActivity) {
        this.this$0 = newBaseChatActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if ((this.this$0.mShouldShowEmotionBoardAfterKeyBoardClosed) && !NewBaseChatActivity.access$getMBinding$p(this.this$0).emotionPanel.isShown()) {
            EmotionPanel emotionPanel = NewBaseChatActivity.access$getMBinding$p(this.this$0).emotionPanel;
            Intrinsics.checkNotNullExpressionValue(emotionPanel, "mBinding.emotionPanel");
            emotionPanel.setVisibility(0);
            this.this$0.mShouldShowEmotionBoardAfterKeyBoardClosed = false;
        }
    }
}
