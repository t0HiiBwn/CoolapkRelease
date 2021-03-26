package com.coolapk.market.view.notification;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "rect", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NotificationListFragment.kt */
final class NotificationListFragment$onViewCreated$1 extends Lambda implements Function1<Rect, Unit> {
    final /* synthetic */ NotificationListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationListFragment$onViewCreated$1(NotificationListFragment notificationListFragment) {
        super(1);
        this.this$0 = notificationListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
        invoke(rect);
        return Unit.INSTANCE;
    }

    public final void invoke(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.this$0.getRecyclerView().setPadding(0, 0, 0, rect.bottom);
    }
}
