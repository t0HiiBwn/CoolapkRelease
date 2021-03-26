package com.coolapk.market.view.webview;

import androidx.core.app.ActivityCompat;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/webview/DyhBrowserFragment$dyhArticleFav$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "s", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhBrowserFragemnt.kt */
public final class DyhBrowserFragment$dyhArticleFav$2 extends EmptySubscriber<Integer> {
    final /* synthetic */ Ref.BooleanRef $isFav;
    final /* synthetic */ DyhBrowserFragment this$0;

    DyhBrowserFragment$dyhArticleFav$2(DyhBrowserFragment dyhBrowserFragment, Ref.BooleanRef booleanRef) {
        this.this$0 = dyhBrowserFragment;
        this.$isFav = booleanRef;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public /* bridge */ /* synthetic */ void onNext(Object obj) {
        onNext(((Number) obj).intValue());
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(int i) {
        super.onNext((DyhBrowserFragment$dyhArticleFav$2) Integer.valueOf(i));
        Toast.show$default(this.this$0.getActivity(), !this.$isFav.element ? "收藏成功" : "取消收藏成功", 0, false, 12, null);
        ActivityCompat.invalidateOptionsMenu(this.this$0.getActivity());
    }
}
