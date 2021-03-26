package com.coolapk.market.view.message;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/message/ChatListFragment$loadLongMessageAndAdd$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "onError", "", "e", "", "onNext", "messageResult", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
public final class ChatListFragment$loadLongMessageAndAdd$1 extends EmptySubscriber<Result<List<? extends Entity>>> {
    final /* synthetic */ ChatListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ChatListFragment$loadLongMessageAndAdd$1(ChatListFragment chatListFragment) {
        this.this$0 = chatListFragment;
    }

    public void onNext(Result<List<Entity>> result) {
        Intrinsics.checkNotNullParameter(result, "messageResult");
        super.onNext((ChatListFragment$loadLongMessageAndAdd$1) result);
        this.this$0.insertMessageList(result.getData());
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getActivity(), th);
    }
}
