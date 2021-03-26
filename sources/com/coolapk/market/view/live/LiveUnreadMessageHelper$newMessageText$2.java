package com.coolapk.market.view.live;

import android.widget.TextView;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveUnreadMessageHelper.kt */
final class LiveUnreadMessageHelper$newMessageText$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ LiveUnreadMessageHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveUnreadMessageHelper$newMessageText$2(LiveUnreadMessageHelper liveUnreadMessageHelper) {
        super(0);
        this.this$0 = liveUnreadMessageHelper;
    }

    @Override // kotlin.jvm.functions.Function0
    public final TextView invoke() {
        TextView textView = (TextView) this.this$0.getFloatView().findViewById(2131363027);
        textView.setTextColor(AppHolder.getAppTheme().getColorAccent());
        return textView;
    }
}
