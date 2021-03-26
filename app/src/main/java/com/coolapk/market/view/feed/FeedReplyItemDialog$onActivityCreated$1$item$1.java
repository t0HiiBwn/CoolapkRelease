package com.coolapk.market.view.feed;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyItemDialog.kt */
final class FeedReplyItemDialog$onActivityCreated$1$item$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ FeedReplyItemDialog$onActivityCreated$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyItemDialog$onActivityCreated$1$item$1(FeedReplyItemDialog$onActivityCreated$1 feedReplyItemDialog$onActivityCreated$1) {
        super(1);
        this.this$0 = feedReplyItemDialog$onActivityCreated$1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        MultiItemDialogFragmentKt.addItem(list, "加入Spam特征库", new Function0<Unit>(this) {
            /* class com.coolapk.market.view.feed.FeedReplyItemDialog$onActivityCreated$1$item$1.AnonymousClass1 */
            final /* synthetic */ FeedReplyItemDialog$onActivityCreated$1$item$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                DataManager instance = DataManager.getInstance();
                String id = this.this$0.this$0.$feedReply.getId();
                Intrinsics.checkNotNull(id);
                instance.reportAddSimText(id, "feed_reply").compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                    /* class com.coolapk.market.view.feed.FeedReplyItemDialog$onActivityCreated$1$item$1.AnonymousClass1.AnonymousClass1 */

                    public void onNext(String str) {
                        super.onNext((AnonymousClass1) str);
                        Toast.show$default(AppHolder.getApplication(), "加入成功", 0, false, 12, null);
                    }

                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                    public void onError(Throwable th) {
                        Toast.error(AppHolder.getApplication(), th);
                    }
                });
            }
        });
    }
}
