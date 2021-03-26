package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import java.util.Date;
import java.util.List;

class de implements Runnable {
    final /* synthetic */ dd a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f313a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Throwable f314a;

    de(dd ddVar, String str, Throwable th) {
        this.a = ddVar;
        this.f313a = str;
        this.f314a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        dd.a().add(new Pair(String.format("%1$s %2$s %3$s ", dd.a().format(new Date()), dd.a(this.a), this.f313a), this.f314a));
        if (dd.a().size() > 20000) {
            int size = (dd.a().size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    if (dd.a().size() > 0) {
                        dd.a().remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            List a2 = dd.a();
            a2.add(new Pair(String.format("%1$s %2$s %3$s ", dd.a().format(new Date()), dd.a(this.a), "flush " + size + " lines logs."), null));
        }
        try {
            if (!aa.d()) {
                Log.w(dd.a(this.a), "SDCard is unavailable.");
            } else {
                dd.a(this.a);
            }
        } catch (Exception e) {
            Log.e(dd.a(this.a), "", e);
        }
    }
}
