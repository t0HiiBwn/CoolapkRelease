package com.coolapk.market.view.message;

import com.coolapk.market.view.message.NewBaseChatActivity;
import com.coolapk.market.widget.emotion.EmotionPanel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewBaseChatActivity.kt */
final class NewBaseChatActivity$ViewMode$isKeyBoardShow$1 implements Runnable {
    final /* synthetic */ NewBaseChatActivity.ViewMode this$0;

    NewBaseChatActivity$ViewMode$isKeyBoardShow$1(NewBaseChatActivity.ViewMode viewMode) {
        this.this$0 = viewMode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EmotionPanel emotionPanel = NewBaseChatActivity.access$getMBinding$p(NewBaseChatActivity.this).emotionPanel;
        Intrinsics.checkNotNullExpressionValue(emotionPanel, "mBinding.emotionPanel");
        if (emotionPanel.isShown()) {
            NewBaseChatActivity.access$getMBinding$p(NewBaseChatActivity.this).menuEmotion.setImageResource(2131231386);
        } else {
            NewBaseChatActivity.access$getMBinding$p(NewBaseChatActivity.this).menuEmotion.setImageResource(2131231278);
        }
    }
}
