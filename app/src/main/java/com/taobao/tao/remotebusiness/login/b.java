package com.taobao.tao.remotebusiness.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: DefaultLoginImpl */
final class b extends BroadcastReceiver {
    b(a aVar) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[onReceive]Login Broadcast Received. action=" + action);
            }
            action.hashCode();
            char c = 65535;
            switch (action.hashCode()) {
                case -1186442906:
                    if (action.equals("NOTIFY_LOGIN_CANCEL")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1100695767:
                    if (action.equals("NOTIFY_LOGIN_FAILED")) {
                        c = 1;
                        break;
                    }
                    break;
                case -542410121:
                    if (action.equals("NOTIFY_LOGIN_SUCCESS")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    d.a().onLoginCancel();
                    return;
                case 1:
                    d.a().onLoginFail();
                    return;
                case 2:
                    d.a().onLoginSuccess();
                    return;
                default:
                    return;
            }
        }
    }
}
