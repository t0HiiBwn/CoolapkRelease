package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class HomeWatcherReceiver extends BroadcastReceiver {
    private a a;

    public interface a {
        void J();

        void K();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            Log.i("HomeReceiver", "onReceive: action: " + action);
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                Log.i("HomeReceiver", "reason: " + stringExtra);
                if ("homekey".equals(stringExtra)) {
                    Log.i("HomeReceiver", "homekey");
                    a aVar = this.a;
                    if (aVar != null) {
                        aVar.J();
                    }
                } else if ("recentapps".equals(stringExtra)) {
                    Log.i("HomeReceiver", "long press home key or activity switch");
                    a aVar2 = this.a;
                    if (aVar2 != null) {
                        aVar2.K();
                    }
                } else if ("assist".equals(stringExtra)) {
                    Log.i("HomeReceiver", "assist");
                }
            }
        }
    }

    public void a(a aVar) {
        this.a = aVar;
    }
}
