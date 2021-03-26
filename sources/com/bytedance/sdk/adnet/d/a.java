package com.bytedance.sdk.adnet.d;

import android.util.Log;
import com.bytedance.sdk.adnet.d.c;

/* compiled from: DefaultLoggerDelegate */
public class a implements c.b {
    @Override // com.bytedance.sdk.adnet.d.c.b
    public void a(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.bytedance.sdk.adnet.d.c.b
    public void b(String str, String str2) {
        Log.d(str, str2);
    }
}
