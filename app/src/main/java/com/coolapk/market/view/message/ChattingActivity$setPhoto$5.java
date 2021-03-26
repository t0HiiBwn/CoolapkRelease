package com.coolapk.market.view.message;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/view/message/ChattingActivity$setPhoto$5", "Lrx/Subscriber;", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "onCompleted", "", "onError", "e", "", "onNext", "stringResult", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChattingActivity.kt */
public final class ChattingActivity$setPhoto$5 extends Subscriber<Result<List<? extends Entity>>> {
    final /* synthetic */ ChattingActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ChattingActivity$setPhoto$5(ChattingActivity chattingActivity) {
        this.this$0 = chattingActivity;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.this$0.setPosting(false);
        this.this$0.setEditing(false);
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getActivity(), th);
        if (!TextUtils.isEmpty(this.this$0.getEditText().getText().toString())) {
            this.this$0.setEditing(true);
        } else {
            this.this$0.setEditing(false);
        }
        this.this$0.setPosting(false);
    }

    public void onNext(Result<List<Entity>> result) {
        Intrinsics.checkNotNullParameter(result, "stringResult");
        Fragment findFragmentById = this.this$0.getSupportFragmentManager().findFragmentById(2131363592);
        Objects.requireNonNull(findFragmentById, "null cannot be cast to non-null type com.coolapk.market.view.message.ChatListFragment");
        ((ChatListFragment) findFragmentById).insertMessageList(result.getData());
    }
}
