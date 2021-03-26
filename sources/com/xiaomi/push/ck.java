package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.l;

final class ck implements co {
    ck() {
    }

    private void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                if (!cm.a(context, String.valueOf(12), 1)) {
                    gq gqVar = new gq();
                    gqVar.a(str + ":" + str2);
                    gqVar.a(System.currentTimeMillis());
                    gqVar.a(gk.BroadcastAction);
                    cw.a(context, gqVar);
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
                    boolean a2 = l.a(context).a(gn.BroadcastActionCollectionSwitch.a(), true);
                    if (TextUtils.equals("android.intent.action.PACKAGE_RESTARTED", intent.getAction())) {
                        if (!cm.a(context, String.valueOf(12), 1) && a2) {
                            if (TextUtils.isEmpty(cv.a)) {
                                cv.a += cn.b + ":";
                            }
                            cv.a += str + "(" + currentTimeMillis + "),";
                        }
                    } else if (!TextUtils.equals("android.intent.action.PACKAGE_CHANGED", intent.getAction())) {
                        if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                            if (!intent.getExtras().getBoolean("android.intent.extra.REPLACING") && a2) {
                                a = gk.BroadcastActionAdded.a();
                            } else {
                                return;
                            }
                        } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                            if (!intent.getExtras().getBoolean("android.intent.extra.REPLACING") && a2) {
                                a = gk.BroadcastActionRemoved.a();
                            } else {
                                return;
                            }
                        } else if (TextUtils.equals("android.intent.action.PACKAGE_REPLACED", intent.getAction())) {
                            if (a2) {
                                a = gk.BroadcastActionReplaced.a();
                            } else {
                                return;
                            }
                        } else if (TextUtils.equals("android.intent.action.PACKAGE_DATA_CLEARED", intent.getAction()) && a2) {
                            a = gk.BroadcastActionDataCleared.a();
                        } else {
                            return;
                        }
                        a(context, String.valueOf(a), str);
                    } else if (!cm.a(context, String.valueOf(12), 1) && a2) {
                        if (TextUtils.isEmpty(cv.b)) {
                            cv.b += cn.c + ":";
                        }
                        cv.b += str + "(" + currentTimeMillis + "),";
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.xiaomi.push.co
    public void a(Context context, Intent intent) {
        if (intent != null) {
            j.a(context).a(new cl(this, context, intent));
        }
    }
}
