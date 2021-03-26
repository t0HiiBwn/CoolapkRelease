package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.be;

class bg implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ be.a b;

    bg(be.a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Exception e;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase d = this.b.d();
            if (d != null && d.isOpen()) {
                d.beginTransaction();
                this.b.a(this.a, d);
                d.setTransactionSuccessful();
            }
            if (d != null) {
                try {
                    d.endTransaction();
                } catch (Exception e2) {
                    e = e2;
                    c.a(e);
                    this.b.a(this.a);
                }
            }
            if (this.b.c != null) {
                this.b.c.close();
            }
        } catch (Exception e3) {
            c.a(e3);
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    e = e4;
                    c.a(e);
                    this.b.a(this.a);
                }
            }
            if (this.b.c != null) {
                this.b.c.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e5) {
                    c.a(e5);
                    this.b.a(this.a);
                    throw th;
                }
            }
            if (this.b.c != null) {
                this.b.c.close();
            }
            this.b.a(this.a);
            throw th;
        }
        this.b.a(this.a);
    }
}
