package com.tencent.beacon.core.strategy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.beacon.core.a.a.e;
import java.util.Locale;

/* compiled from: StrategyDAO */
public final class b {
    private static synchronized boolean a(Context context, e eVar) {
        synchronized (b.class) {
            boolean z = false;
            if (context == null) {
                com.tencent.beacon.core.d.b.c("[db] context or bean is null}", new Object[0]);
                return false;
            }
            try {
                SQLiteDatabase writableDatabase = e.a(context, com.tencent.beacon.core.b.b.a(context).a()).getWritableDatabase();
                if (writableDatabase == null) {
                    com.tencent.beacon.core.d.b.d("[db] get db fail!,return false ", new Object[0]);
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                if (eVar.a >= 0) {
                    contentValues.put("_id", Long.valueOf(eVar.a));
                }
                contentValues.put("_key", Integer.valueOf(eVar.b));
                contentValues.put("_datas", eVar.c);
                long replace = writableDatabase.replace("t_strategy", "_id", contentValues);
                if (replace < 0) {
                    com.tencent.beacon.core.d.b.c("[db] insert failure! return false ", new Object[0]);
                } else {
                    eVar.a = replace;
                    com.tencent.beacon.core.d.b.e("[db] update strategy %d true ", Integer.valueOf(eVar.b));
                    z = true;
                }
                return z;
            } catch (Throwable th) {
                com.tencent.beacon.core.d.b.d("[db] error: %s", th.toString());
            }
        }
    }

    public static void a(Context context, int i, byte[] bArr) {
        if (bArr != null) {
            e eVar = new e();
            eVar.b = i;
            eVar.c = bArr;
            a(context, eVar);
        }
    }

    public static synchronized e a(Context context) {
        Throwable th;
        e eVar;
        synchronized (b.class) {
            Cursor cursor = null;
            r2 = null;
            r2 = null;
            r2 = null;
            r2 = null;
            e eVar2 = null;
            if (context == null) {
                com.tencent.beacon.core.d.b.c("[db] context is null", new Object[0]);
                return null;
            }
            try {
                SQLiteDatabase writableDatabase = e.a(context, com.tencent.beacon.core.b.b.a(context).a()).getWritableDatabase();
                if (writableDatabase == null) {
                    com.tencent.beacon.core.d.b.c("[db] getWritableDatabase fail!", new Object[0]);
                    return null;
                }
                Cursor query = writableDatabase.query("t_strategy", null, String.format(Locale.US, " %s = %d ", "_key", 101), null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            if (query != null && !query.isBeforeFirst()) {
                                if (!query.isAfterLast()) {
                                    com.tencent.beacon.core.d.b.b("[db] parse bean.", new Object[0]);
                                    e eVar3 = new e();
                                    eVar3.a = query.getLong(query.getColumnIndex("_id"));
                                    eVar3.b = query.getInt(query.getColumnIndex("_key"));
                                    eVar3.c = query.getBlob(query.getColumnIndex("_datas"));
                                    eVar2 = eVar3;
                                }
                            }
                            if (eVar2 != null) {
                                com.tencent.beacon.core.d.b.g("[db] read strategy key: %d", Integer.valueOf(eVar2.b));
                            }
                        }
                    } catch (Throwable th2) {
                        cursor = query;
                        th = th2;
                        eVar = null;
                        try {
                            com.tencent.beacon.core.d.b.a(th);
                            eVar2 = eVar;
                            return eVar2;
                        } finally {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
                return eVar2;
            } catch (Throwable th3) {
                th = th3;
                eVar = null;
                com.tencent.beacon.core.d.b.a(th);
                eVar2 = eVar;
                return eVar2;
            }
        }
    }

    public static synchronized int b(Context context) {
        int i;
        Throwable th;
        synchronized (b.class) {
            int i2 = 0;
            if (context == null) {
                com.tencent.beacon.core.d.b.c("[db] params error.", new Object[0]);
                return 0;
            }
            try {
                SQLiteDatabase writableDatabase = e.a(context, com.tencent.beacon.core.b.b.a(context).a()).getWritableDatabase();
                if (writableDatabase == null) {
                    com.tencent.beacon.core.d.b.d("get db fail!,return ", new Object[0]);
                    return 0;
                }
                i = writableDatabase.delete("t_strategy", String.format("%s = %d", "_key", 101), null);
                try {
                    com.tencent.beacon.core.d.b.g("[db] key:%d , num: %d", 101, Integer.valueOf(i));
                } catch (Throwable th2) {
                    i2 = i;
                    th = th2;
                }
                return i;
            } catch (Throwable th3) {
                th = th3;
                com.tencent.beacon.core.d.b.a(th);
                i = i2;
                return i;
            }
        }
    }
}
