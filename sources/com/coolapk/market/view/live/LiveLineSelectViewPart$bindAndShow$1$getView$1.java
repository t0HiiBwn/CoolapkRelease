package com.coolapk.market.view.live;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveLineSelectViewPart.kt */
final class LiveLineSelectViewPart$bindAndShow$1$getView$1 implements View.OnClickListener {
    final /* synthetic */ String $key;
    final /* synthetic */ LiveLineSelectViewPart$bindAndShow$1 this$0;

    LiveLineSelectViewPart$bindAndShow$1$getView$1(LiveLineSelectViewPart$bindAndShow$1 liveLineSelectViewPart$bindAndShow$1, String str) {
        this.this$0 = liveLineSelectViewPart$bindAndShow$1;
        this.$key = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.$clickListener.invoke(this.$key);
        this.this$0.this$0.startCloseAnimation();
    }
}
