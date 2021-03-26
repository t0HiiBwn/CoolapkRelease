package com.coolapk.market.view.notification;

import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.PushMessage;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lcom/coolapk/market/manager/PushMessage;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NotificationListFragment.kt */
final class NotificationListFragment$onActivityCreated$5 extends Lambda implements Function1<PushMessage, Boolean> {
    final /* synthetic */ NotificationListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationListFragment$onActivityCreated$5(NotificationListFragment notificationListFragment) {
        super(1);
        this.this$0 = notificationListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PushMessage pushMessage) {
        return Boolean.valueOf(invoke(pushMessage));
    }

    public final boolean invoke(PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(pushMessage, "<name for destructuring parameter 0>");
        String component1 = pushMessage.component1();
        boolean z = false;
        if (ArraysKt.contains(new String[]{"notify_xms", "answer_invite", "question_follow", "dyh_include_feed"}, component1) || (StringsKt.contains$default((CharSequence) component1, (CharSequence) "reply", false, 2, (Object) null) && this.this$0.isResumed())) {
            z = true;
        }
        if (z) {
            AppHolder.getMainThreadHandler().post(new Runnable(this) {
                /* class com.coolapk.market.view.notification.NotificationListFragment$onActivityCreated$5.AnonymousClass1 */
                final /* synthetic */ NotificationListFragment$onActivityCreated$5 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.this$0.scrollToTop(true);
                }
            });
        }
        return z;
    }
}
