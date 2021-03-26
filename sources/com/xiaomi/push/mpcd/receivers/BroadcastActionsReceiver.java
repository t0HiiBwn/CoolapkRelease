package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.dn;

public class BroadcastActionsReceiver extends BroadcastReceiver {
    private dn a;

    public BroadcastActionsReceiver(dn dnVar) {
        this.a = dnVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        dn dnVar = this.a;
        if (dnVar != null) {
            dnVar.a(context, intent);
        }
    }
}
