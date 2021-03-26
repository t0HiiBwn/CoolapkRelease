package com.coolapk.market.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.coolapk.market.util.LogUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/coolapk/market/receiver/InstallStatusReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "register", "unregister", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: InstallStatusReceiver.kt */
public final class InstallStatusReceiver extends BroadcastReceiver {
    public static final String ACTION_INSTALL_STATUS = "com.coolapk.market.action.INSTALL_STATUS";
    public static final Companion Companion = new Companion(null);
    private static final String PACKAGE_TAG = "com.coolapk.market.action";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/receiver/InstallStatusReceiver$Companion;", "", "()V", "ACTION_INSTALL_STATUS", "", "PACKAGE_TAG", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: InstallStatusReceiver.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent != null && (extras = intent.getExtras()) != null) {
            Intrinsics.checkNotNullExpressionValue(extras, "intent?.extras ?: return");
            if (Intrinsics.areEqual("com.coolapk.market.action.INSTALL_STATUS", intent.getAction())) {
                int i = extras.getInt("android.content.pm.extra.STATUS");
                String string = extras.getString("android.content.pm.extra.STATUS_MESSAGE");
                switch (i) {
                    case -1:
                        Object obj = extras.get("android.intent.extra.INTENT");
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type android.content.Intent");
                        Intent intent2 = (Intent) obj;
                        intent2.addFlags(268435456);
                        context.startActivity(intent2);
                        return;
                    case 0:
                        LogUtils.i("Install succeeded!", new Object[0]);
                        return;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        LogUtils.i("Install failed! " + i + ", " + string, new Object[0]);
                        return;
                    default:
                        LogUtils.i("Unrecognized status received from installer: " + i, new Object[0]);
                        return;
                }
            }
        }
    }

    public final void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolapk.market.action.INSTALL_STATUS");
        context.registerReceiver(this, intentFilter);
    }

    public final void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.unregisterReceiver(this);
    }
}
