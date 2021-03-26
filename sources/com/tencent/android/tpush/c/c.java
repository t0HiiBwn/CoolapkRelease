package com.tencent.android.tpush.c;

import android.content.Context;
import android.preference.PreferenceManager;
import com.tencent.android.tpush.stat.a.a;
import com.tencent.android.tpush.stat.a.b;

/* compiled from: ProGuard */
public class c extends d {
    @Override // com.tencent.android.tpush.c.d
    protected boolean b() {
        return true;
    }

    public c(Context context, int i) {
        super(context, i);
    }

    @Override // com.tencent.android.tpush.c.d
    protected String a() {
        return a(c());
    }

    public String a(String str) {
        String string;
        synchronized (this) {
            if (this.a == null) {
                this.a = a.b();
            }
            b bVar = this.a;
            bVar.b("read mid from sharedPreferences， key=" + str);
            string = PreferenceManager.getDefaultSharedPreferences(this.b).getString(str, null);
        }
        return string;
    }
}
