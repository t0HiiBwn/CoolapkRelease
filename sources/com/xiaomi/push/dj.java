package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.an;

final class dj implements dn {
    dj() {
    }

    private void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                if (!dl.a(context, "12", 1)) {
                    hk hkVar = new hk();
                    hkVar.a(str + ":" + str2);
                    hkVar.a(System.currentTimeMillis());
                    hkVar.a(he.BroadcastAction);
                    ds.a(context, hkVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(Context context, Intent intent) {
        int a;
        try {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String[] split = dataString.split(":");
                if (split.length < 2) {
                    return;
                }
                if (!TextUtils.isEmpty(split[1])) {
                    String str = split[1];
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a2 = an.a(context).a(hh.BroadcastActionCollectionSwitch.a(), true);
                    if (TextUtils.equals("android.intent.action.PACKAGE_RESTARTED", intent.getAction())) {
                        if (!dl.a(context, "12", 1) && a2) {
                            if (TextUtils.isEmpty(dr.a)) {
                                dr.a += dm.f319a + ":";
                            }
                            dr.a += str + "(" + currentTimeMillis + "),";
                        }
                    } else if (!TextUtils.equals("android.intent.action.PACKAGE_CHANGED", intent.getAction())) {
                        if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                            if (!intent.getExtras().getBoolean("android.intent.extra.REPLACING") && a2) {
                                a = he.BroadcastActionAdded.a();
                            } else {
                                return;
                            }
                        } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                            if (!intent.getExtras().getBoolean("android.intent.extra.REPLACING") && a2) {
                                a = he.BroadcastActionRemoved.a();
                            } else {
                                return;
                            }
                        } else if (TextUtils.equals("android.intent.action.PACKAGE_REPLACED", intent.getAction())) {
                            if (a2) {
                                a = he.BroadcastActionReplaced.a();
                            } else {
                                return;
                            }
                        } else if (TextUtils.equals("android.intent.action.PACKAGE_DATA_CLEARED", intent.getAction()) && a2) {
                            a = he.BroadcastActionDataCleared.a();
                        } else {
                            return;
                        }
                        a(context, String.valueOf(a), str);
                    } else if (!dl.a(context, "12", 1) && a2) {
                        if (TextUtils.isEmpty(dr.b)) {
                            dr.b += dm.b + ":";
                        }
                        dr.b += str + "(" + currentTimeMillis + "),";
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.xiaomi.push.dn
    public void a(Context context, Intent intent) {
        if (intent != null) {
            ai.a(context).a(new dk(this, context, intent));
        }
    }
}
