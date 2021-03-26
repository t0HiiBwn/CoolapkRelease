package com.bytedance.tea.crash.e.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: BatteryWatcher */
class d {
    private int a;

    d(Context context) {
        try {
            a(context);
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int a() {
        return this.a;
    }

    /* compiled from: BatteryWatcher */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                d.this.a = (int) ((((float) intent.getIntExtra("level", 0)) * 100.0f) / ((float) intent.getIntExtra("scale", 100)));
            }
        }
    }
}
