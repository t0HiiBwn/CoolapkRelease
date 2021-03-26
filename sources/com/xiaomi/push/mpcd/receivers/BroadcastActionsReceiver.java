package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.co;

public class BroadcastActionsReceiver extends BroadcastReceiver {
    private co a;

    public BroadcastActionsReceiver(co coVar) {
        this.a = coVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        co coVar = this.a;
        if (coVar != null) {
            coVar.a(context, intent);
        }
    }
}
