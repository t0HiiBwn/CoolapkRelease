package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONObject;

/* compiled from: BatteryUtils */
public class c {
    private static final String a = "BatteryUtils";
    private static boolean b;
    private static Context c;
    private BroadcastReceiver d;

    private c() {
        this.d = new BroadcastReceiver() {
            /* class com.umeng.commonsdk.internal.utils.c.AnonymousClass1 */

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("le", intent.getIntExtra("level", 0));
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObject.put("vol", intent.getIntExtra("voltage", 0));
                        } catch (Exception unused2) {
                        }
                        try {
                            jSONObject.put("temp", intent.getIntExtra("temperature", 0));
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused3) {
                        }
                        int intExtra = intent.getIntExtra("status", 0);
                        int i = -1;
                        int i2 = 2;
                        if (intExtra != 1) {
                            if (intExtra == 2) {
                                i = 1;
                            } else if (intExtra == 4) {
                                i = 0;
                            } else if (intExtra == 5) {
                                i = 2;
                            }
                        }
                        try {
                            jSONObject.put("st", i);
                        } catch (Exception unused4) {
                        }
                        int intExtra2 = intent.getIntExtra("plugged", 0);
                        if (intExtra2 == 1) {
                            i2 = 1;
                        } else if (intExtra2 != 2) {
                            i2 = 0;
                        }
                        try {
                            jSONObject.put("ct", i2);
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused5) {
                        }
                        ULog.i("BatteryUtils", jSONObject.toString());
                        UMWorkDispatch.sendEvent(context, 32771, b.a(c.c).a(), jSONObject.toString());
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.c, th);
                }
            }
        };
    }

    /* compiled from: BatteryUtils */
    private static class a {
        private static final c a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (c == null && context != null) {
            c = context.getApplicationContext();
        }
        return a.a;
    }

    public synchronized boolean a() {
        return b;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            c.registerReceiver(this.d, intentFilter);
            b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(c, th);
        }
        return;
    }

    public synchronized void c() {
        try {
            c.unregisterReceiver(this.d);
            b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(c, th);
        }
        return;
    }
}
