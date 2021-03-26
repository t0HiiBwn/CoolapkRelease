package com.coolapk.market.view.message;

import android.app.Activity;
import android.view.View;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.message.ChatListFragment;
import com.coolapk.market.widget.emotion.EmotionPanel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$ChatTipViewHolder$bindToContent$1 implements View.OnClickListener {
    final /* synthetic */ ChatListFragment.ChatTipViewHolder this$0;

    ChatListFragment$ChatTipViewHolder$bindToContent$1(ChatListFragment.ChatTipViewHolder chatTipViewHolder) {
        this.this$0 = chatTipViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity = UiUtils.getActivity(this.this$0.getContext());
        if (activity != null && (activity instanceof ChattingActivity)) {
            ChattingActivity chattingActivity = (ChattingActivity) activity;
            if (chattingActivity.getViewMode().isKeyBoardShow()) {
                UiUtils.closeKeyboard(chattingActivity.getEditText());
            }
            EmotionPanel emotionPanel = chattingActivity.getBinding().emotionPanel;
            Intrinsics.checkNotNullExpressionValue(emotionPanel, "activity.binding.emotionPanel");
            if (emotionPanel.isShown()) {
                EmotionPanel emotionPanel2 = chattingActivity.getBinding().emotionPanel;
                Intrinsics.checkNotNullExpressionValue(emotionPanel2, "activity.binding.emotionPanel");
                chattingActivity.setEmotionPanelVisibleWithAnim(!emotionPanel2.isShown());
                chattingActivity.getBinding().menuEmotion.setImageResource(2131231289);
            }
        }
    }
}
