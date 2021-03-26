package com.coolapk.market.viewholder;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.coolapk.market.util.DisplayUtils;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: NotificationNavViewHolder.kt */
final class NotificationNavViewHolder$setBubbleView$1 implements Runnable {
    final /* synthetic */ TextView $textView;
    final /* synthetic */ NotificationNavViewHolder this$0;

    NotificationNavViewHolder$setBubbleView$1(NotificationNavViewHolder notificationNavViewHolder, TextView textView) {
        this.this$0 = notificationNavViewHolder;
        this.$textView = textView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Rect rect = new Rect();
        this.$textView.getHitRect(rect);
        int i = -DisplayUtils.dp2px(this.this$0.getContext(), 12.0f);
        rect.inset(i, i);
        TouchDelegate touchDelegate = new TouchDelegate(rect, this.$textView);
        ViewParent parent = this.$textView.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setTouchDelegate(touchDelegate);
    }
}
