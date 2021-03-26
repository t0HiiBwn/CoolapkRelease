package com.huawei.hms.support.log.a;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.support.log.b;

/* compiled from: LogCatNode */
public class a implements b {
    private b a;

    @Override // com.huawei.hms.support.log.b
    public void a(Context context, String str) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.support.log.b
    public void a(String str, int i, String str2, String str3) {
        Log.println(i, "HMSSDK_" + str2, str3);
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(str, i, str2, str3);
        }
    }
}
