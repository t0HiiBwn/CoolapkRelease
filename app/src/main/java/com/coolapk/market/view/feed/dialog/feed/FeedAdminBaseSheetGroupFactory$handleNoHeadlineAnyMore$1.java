package com.coolapk.market.view.feed.dialog.feed;

import com.coolapk.market.AppHolder;
import com.coolapk.market.event.FeedRemoveHeadlineEvent;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.widget.Toast;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"onErrorEvent", "", "throwable", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedAdminBaseSheetGroupFactory.kt */
final class FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ FeedAdminBaseSheetGroupFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$1(FeedAdminBaseSheetGroupFactory feedAdminBaseSheetGroupFactory) {
        super(1);
        this.this$0 = feedAdminBaseSheetGroupFactory;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        if ((th instanceof RuntimeException) && (th.getCause() instanceof ClientException)) {
            Throwable cause = th.getCause();
            Objects.requireNonNull(cause, "null cannot be cast to non-null type com.coolapk.market.network.ClientException");
            ClientException clientException = (ClientException) cause;
            if (clientException.getStatusCode() == -1) {
                EventBus.getDefault().post(new FeedRemoveHeadlineEvent(this.this$0.getFeed().getId()));
            }
            Toast.error(AppHolder.getApplication(), clientException);
        }
    }
}
