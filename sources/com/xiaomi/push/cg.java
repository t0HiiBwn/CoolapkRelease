package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ce;

class cg implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ce.a f265a;

    cg(ce.a aVar, Context context) {
        this.f265a = aVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Exception e;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = this.f265a.a();
            if (a2 != null && a2.isOpen()) {
                a2.beginTransaction();
                this.f265a.a(this.a, a2);
                a2.setTransactionSuccessful();
            }
            if (a2 != null) {
                try {
                    a2.endTransaction();
                } catch (Exception e2) {
                    e = e2;
                    b.a(e);
                    this.f265a.a(this.a);
                }
            }
            if (this.f265a.f256a != null) {
                this.f265a.f256a.close();
            }
        } catch (Exception e3) {
            b.a(e3);
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    e = e4;
                    b.a(e);
                    this.f265a.a(this.a);
                }
            }
            if (this.f265a.f256a != null) {
                this.f265a.f256a.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e5) {
                    b.a(e5);
                    this.f265a.a(this.a);
                    throw th;
                }
            }
            if (this.f265a.f256a != null) {
                this.f265a.f256a.close();
            }
            this.f265a.a(this.a);
            throw th;
        }
        this.f265a.a(this.a);
    }
}
