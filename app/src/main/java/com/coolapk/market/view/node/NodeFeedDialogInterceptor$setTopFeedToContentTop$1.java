package com.coolapk.market.view.node;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodeFeedDialogInterceptor.kt */
final class NodeFeedDialogInterceptor$setTopFeedToContentTop$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $feedId;
    final /* synthetic */ NodeFeedDialogInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NodeFeedDialogInterceptor$setTopFeedToContentTop$1(NodeFeedDialogInterceptor nodeFeedDialogInterceptor, String str) {
        super(1);
        this.this$0 = nodeFeedDialogInterceptor;
        this.$feedId = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke(str);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        DataManager.getInstance().addToContentTopNode(this.this$0.getNodeType(), this.this$0.getNodeId(), this.$feedId, new Regex("[\\n\\r]").replace(str, " ")).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>(this) {
            /* class com.coolapk.market.view.node.NodeFeedDialogInterceptor$setTopFeedToContentTop$1.AnonymousClass1 */
            final /* synthetic */ NodeFeedDialogInterceptor$setTopFeedToContentTop$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            public void onNext(String str) {
                super.onNext((AnonymousClass1) str);
                Toast.show$default(this.this$0.this$0.getActivity(), str, 0, false, 12, null);
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Toast.error(this.this$0.this$0.getActivity(), th);
            }
        });
    }
}
