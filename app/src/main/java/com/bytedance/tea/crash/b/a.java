package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.b.b.b;
import com.bytedance.tea.crash.g.j;

/* compiled from: NpthDataManager */
public class a {
    private static volatile a a;
    private b b;
    private SQLiteDatabase c;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(Context context) {
        try {
            this.c = new b(context).getWritableDatabase();
        } catch (Throwable th) {
            j.b(th);
        }
        this.b = new b();
    }

    public synchronized void a(com.bytedance.tea.crash.b.a.a aVar) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.c, aVar);
        }
    }

    public synchronized boolean a(String str) {
        b bVar = this.b;
        if (bVar == null) {
            return false;
        }
        return bVar.a(this.c, str);
    }
}
