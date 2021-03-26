package com.coolapk.market.viewholder;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.AlbumItemEditEvent;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/viewholder/AlbumItemEditViewHolder$onItemClear$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumItemEditViewHolder.kt */
public final class AlbumItemEditViewHolder$onItemClear$1 extends EmptySubscriber<Result<String>> {
    final /* synthetic */ AlbumItemEditViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AlbumItemEditViewHolder$onItemClear$1(AlbumItemEditViewHolder albumItemEditViewHolder) {
        this.this$0 = albumItemEditViewHolder;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getContext(), th);
    }

    public void onNext(Result<String> result) {
        Toast.show$default(this.this$0.getContext(), result != null ? result.getData() : null, 0, false, 12, null);
        EventBus.getDefault().post(new AlbumItemEditEvent(this.this$0.mAlbumItem, "order"));
    }
}
