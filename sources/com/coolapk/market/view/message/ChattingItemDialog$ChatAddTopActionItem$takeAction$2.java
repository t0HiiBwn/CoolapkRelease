package com.coolapk.market.view.message;

import android.text.TextUtils;
import com.coolapk.market.event.MessageEvent;
import com.coolapk.market.model.Message;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.message.ChattingItemDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChattingItemDialog.kt */
final class ChattingItemDialog$ChatAddTopActionItem$takeAction$2<T> implements Action1<Result<String>> {
    final /* synthetic */ ChattingItemDialog.ChatAddTopActionItem this$0;

    ChattingItemDialog$ChatAddTopActionItem$takeAction$2(ChattingItemDialog.ChatAddTopActionItem chatAddTopActionItem) {
        this.this$0 = chatAddTopActionItem;
    }

    public final void call(Result<String> result) {
        Intrinsics.checkNotNullExpressionValue(result, "it");
        if (!TextUtils.isEmpty(result.getData())) {
            Toast.show$default(this.this$0.this$0.getActivity(), result.getData(), 0, false, 12, null);
            EventBus eventBus = EventBus.getDefault();
            Message message = this.this$0.mMessage;
            int i = 3;
            if (!this.this$0.mMessage.isToped()) {
                i = 2;
            }
            eventBus.post(new MessageEvent(message, i));
            return;
        }
        Toast.show$default(this.this$0.this$0.getActivity(), result.getMessage(), 0, false, 12, null);
    }
}
