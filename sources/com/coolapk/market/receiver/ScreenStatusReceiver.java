package com.coolapk.market.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/receiver/ScreenStatusReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "resetScreenOnWithoutAd", "Ljava/lang/Runnable;", "<set-?>", "", "screenOnWithoutAd", "getScreenOnWithoutAd", "()Z", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "register", "unregister", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ScreenStatusReceiver.kt */
public final class ScreenStatusReceiver extends BroadcastReceiver {
    private final Runnable resetScreenOnWithoutAd = new ScreenStatusReceiver$resetScreenOnWithoutAd$1(this);
    private boolean screenOnWithoutAd;

    public final boolean getScreenOnWithoutAd() {
        return this.screenOnWithoutAd;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent != null && (action = intent.getAction()) != null) {
            Intrinsics.checkNotNullExpressionValue(action, "intent?.action ?: return");
            int hashCode = action.hashCode();
            if (hashCode != -2128145023) {
                if (hashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                    LogUtils.d("屏幕亮屏了", new Object[0]);
                    AppHolder.getMainThreadHandler().removeCallbacks(this.resetScreenOnWithoutAd);
                    AppHolder.getMainThreadHandler().postDelayed(this.resetScreenOnWithoutAd, 5000);
                }
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                LogUtils.d("屏幕关闭了", new Object[0]);
                AppHolder.getMainThreadHandler().removeCallbacks(this.resetScreenOnWithoutAd);
                this.screenOnWithoutAd = true;
            }
        }
    }

    public final void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(this, intentFilter);
    }

    public final void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.unregisterReceiver(this);
    }
}
