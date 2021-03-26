package com.coolapk.market.view.message;

import android.os.Bundle;
import android.text.style.URLSpan;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Message;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u0019\u0010\u000e\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/message/ChattingItemDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "message", "Lcom/coolapk/market/model/Message;", "spans", "", "Landroid/text/style/URLSpan;", "[Landroid/text/style/URLSpan;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "setMessage", "setSpans", "([Landroid/text/style/URLSpan;)V", "ChatAddTopActionItem", "DeleteActionItem", "DeleteChatActionItem", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChattingItemDialog.kt */
public final class ChattingItemDialog extends MultiItemDialogFragment {
    private Message message;
    private URLSpan[] spans;

    public final void setMessage(Message message2) {
        Intrinsics.checkNotNullParameter(message2, "message");
        this.message = message2;
    }

    public final void setSpans(URLSpan[] uRLSpanArr) {
        Intrinsics.checkNotNullParameter(uRLSpanArr, "spans");
        this.spans = uRLSpanArr;
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        updateDataList(new ChattingItemDialog$onActivityCreated$1(this));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/message/ChattingItemDialog$DeleteActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "mMessage", "Lcom/coolapk/market/model/Message;", "(Lcom/coolapk/market/view/message/ChattingItemDialog;Lcom/coolapk/market/model/Message;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChattingItemDialog.kt */
    public final class DeleteActionItem extends ActionItem {
        private final Message mMessage;
        final /* synthetic */ ChattingItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteActionItem(ChattingItemDialog chattingItemDialog, Message message) {
            super("删除此消息", null, 2, null);
            Intrinsics.checkNotNullParameter(message, "mMessage");
            this.this$0 = chattingItemDialog;
            this.mMessage = message;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager.getInstance().deleteMessage(this.mMessage.getUKey(), this.mMessage.getId()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new ChattingItemDialog$DeleteActionItem$takeAction$1(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/message/ChattingItemDialog$DeleteChatActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "message", "Lcom/coolapk/market/model/Message;", "(Lcom/coolapk/market/view/message/ChattingItemDialog;Lcom/coolapk/market/model/Message;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChattingItemDialog.kt */
    public final class DeleteChatActionItem extends ActionItem {
        private final Message message;
        final /* synthetic */ ChattingItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteChatActionItem(ChattingItemDialog chattingItemDialog, Message message2) {
            super("删除此会话", null, 2, null);
            Intrinsics.checkNotNullParameter(message2, "message");
            this.this$0 = chattingItemDialog;
            this.message = message2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            ConfirmDialog newInstance = ConfirmDialog.newInstance("确定要删除和『" + this.message.getMessageUserName() + "』的会话？", "删除会话会删除与对方所有的聊天记录，且无法恢复！", "确认删除", "取消");
            newInstance.setOnOkRunnable(new ChattingItemDialog$DeleteChatActionItem$takeAction$1(this));
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/message/ChattingItemDialog$ChatAddTopActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "mMessage", "Lcom/coolapk/market/model/Message;", "(Lcom/coolapk/market/view/message/ChattingItemDialog;Lcom/coolapk/market/model/Message;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChattingItemDialog.kt */
    public final class ChatAddTopActionItem extends ActionItem {
        private final Message mMessage;
        final /* synthetic */ ChattingItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatAddTopActionItem(ChattingItemDialog chattingItemDialog, Message message) {
            super(message.isToped() ? "取消置顶" : "置顶会话", null, 2, null);
            Intrinsics.checkNotNullParameter(message, "mMessage");
            this.this$0 = chattingItemDialog;
            this.mMessage = message;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.mMessage.isToped())).flatMap(new ChattingItemDialog$ChatAddTopActionItem$takeAction$1(this)).compose(RxUtils.applyIOSchedulers()).subscribe(new ChattingItemDialog$ChatAddTopActionItem$takeAction$2(this), new ChattingItemDialog$ChatAddTopActionItem$takeAction$3(this));
        }
    }
}
