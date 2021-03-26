package com.coolapk.market.view.feed;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.view.feed.ReplyActivity;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feed/ReplyActivity$onPhotoPick$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "Lcom/coolapk/market/model/ImageUrl;", "onError", "", "e", "", "onNext", "imageUrlList", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
public final class ReplyActivity$onPhotoPick$2 extends EmptySubscriber<List<? extends ImageUrl>> {
    final /* synthetic */ List $pathList;
    final /* synthetic */ ReplyActivity this$0;

    ReplyActivity$onPhotoPick$2(ReplyActivity replyActivity, List list) {
        this.this$0 = replyActivity;
        this.$pathList = list;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(List<? extends ImageUrl> list) {
        Intrinsics.checkNotNullParameter(list, "imageUrlList");
        ReplyActivity.access$getFeedDraft$p(this.this$0).getImageUriList().clear();
        ReplyActivity.access$getFeedDraft$p(this.this$0).getImageUriList().addAll(list);
        ArrayList arrayList = new ArrayList();
        for (String str : this.$pathList) {
            arrayList.add(CoolFileUtils.wrap(str));
        }
        ArrayList arrayList2 = arrayList;
        if (this.$pathList.size() > 1) {
            arrayList2.add("ADD");
        }
        ReplyActivity replyActivity = this.this$0;
        replyActivity.updateUiConfig(ReplyActivity.ReplyUiConfig.copy$default(ReplyActivity.access$getUiConfig$p(replyActivity), null, null, null, arrayList2, null, false, null, false, false, false, false, 0, 4087, null));
        this.this$0.checkPostButtonState();
    }
}
