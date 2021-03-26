package com.coolapk.market.view.message;

import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.MessageEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.message.ChattingItemDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChattingItemDialog.kt */
final class ChattingItemDialog$DeleteChatActionItem$takeAction$1 implements Runnable {
    final /* synthetic */ ChattingItemDialog.DeleteChatActionItem this$0;

    ChattingItemDialog$DeleteChatActionItem$takeAction$1(ChattingItemDialog.DeleteChatActionItem deleteChatActionItem) {
        this.this$0 = deleteChatActionItem;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataManager.getInstance().deleteChat(this.this$0.message.getUKey()).compose(RxUtils.applyIOSchedulers()).subscribe(new Action1<Result<String>>(this) {
            /* class com.coolapk.market.view.message.ChattingItemDialog$DeleteChatActionItem$takeAction$1.AnonymousClass1 */
            final /* synthetic */ ChattingItemDialog$DeleteChatActionItem$takeAction$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(Result<String> result) {
                Intrinsics.checkNotNullExpressionValue(result, "it");
                if (!TextUtils.isEmpty(result.getData())) {
                    Toast.show$default(AppHolder.getCurrentActivity(), "删除成功", 0, false, 12, null);
                    EventBus.getDefault().post(new MessageEvent(this.this$0.this$0.message, 0));
                    return;
                }
                Toast.show$default(this.this$0.this$0.this$0.getActivity(), result.getMessage(), 0, false, 12, null);
            }
        }, new Action1<Throwable>(this) {
            /* class com.coolapk.market.view.message.ChattingItemDialog$DeleteChatActionItem$takeAction$1.AnonymousClass2 */
            final /* synthetic */ ChattingItemDialog$DeleteChatActionItem$takeAction$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(Throwable th) {
                Toast.error(this.this$0.this$0.this$0.getActivity(), th);
            }
        });
    }
}
