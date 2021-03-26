package com.bytedance.embedapplog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.embedapplog.bo;
import com.bytedance.embedapplog.k;

public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            bo.a(null);
        } else {
            k.a(stringArrayExtra);
        }
    }
}
