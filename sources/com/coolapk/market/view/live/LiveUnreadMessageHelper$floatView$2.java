package com.coolapk.market.view.live;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveUnreadMessageHelper.kt */
final class LiveUnreadMessageHelper$floatView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ LiveUnreadMessageHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveUnreadMessageHelper$floatView$2(LiveUnreadMessageHelper liveUnreadMessageHelper) {
        super(0);
        this.this$0 = liveUnreadMessageHelper;
    }

    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        View inflate = LayoutInflater.from(this.this$0.getViewGroup().getContext()).inflate(2131559017, (ViewGroup) null);
        inflate.setElevation((float) NumberExtendsKt.getDp((Number) 2));
        inflate.setVisibility(8);
        return inflate;
    }
}
