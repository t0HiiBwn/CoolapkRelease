package com.coolapk.market.util;

import android.content.Context;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.kepler.jd.Listener.OpenAppAction;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "status", "", "url", "", "kotlin.jvm.PlatformType", "onStatus"}, k = 3, mv = {1, 4, 2})
/* compiled from: UriActionUtils.kt */
final class UriActionUtils$JDAction$takeAction$openAppAction$1 implements OpenAppAction {
    final /* synthetic */ Context $context;

    UriActionUtils$JDAction$takeAction$openAppAction$1(Context context) {
        this.$context = context;
    }

    @Override // com.kepler.jd.Listener.OpenAppAction
    public final void onStatus(int i, final String str) {
        LogUtils.d("status : " + i + ' ' + str, new Object[0]);
        if (i != 0 && i != 1) {
            AppHolder.getMainThreadHandler().post(new Runnable(this) {
                /* class com.coolapk.market.util.UriActionUtils$JDAction$takeAction$openAppAction$1.AnonymousClass1 */
                final /* synthetic */ UriActionUtils$JDAction$takeAction$openAppAction$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ActionManager.startWebViewActivity(this.this$0.$context, str);
                }
            });
        }
    }
}
