package com.tencent.beacon.core.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.beacon.core.b.b;
import java.util.Date;

/* compiled from: ConfigDAO */
public final class c {
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
        if (r12.isClosed() == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ac, code lost:
        if (r12.isClosed() == false) goto L_0x0094;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a8  */
    public static Object[] a(Context context, String str) {
        Cursor cursor;
        Throwable th;
        String a = b.a(context).a();
        synchronized (e.a(a)) {
            Cursor cursor2 = null;
            if (context == null) {
                com.tencent.beacon.core.d.b.d("[db] context == null ", new Object[0]);
                return null;
            }
            try {
                SQLiteDatabase writableDatabase = e.a(context, a).getWritableDatabase();
                if (writableDatabase == null) {
                    com.tencent.beacon.core.d.b.d("[db] getWritableDatabase fail! ", new Object[0]);
                    return null;
                }
                cursor = writableDatabase.query("t_conf", null, "_key = '" + str + "'", null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            Object[] objArr = {str, cursor.getString(cursor.getColumnIndex("_value")), Long.valueOf(cursor.getLong(cursor.getColumnIndex("_vdate")))};
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return objArr;
                        }
                    } catch (Exception unused) {
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                }
                return null;
            } catch (Exception unused2) {
                cursor = null;
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2.close();
                throw th;
            }
        }
    }

    public static boolean a(Context context, String str, Object[] objArr) {
        String a = b.a(context).a();
        synchronized (e.a(a)) {
            boolean z = false;
            if (context == null) {
                return false;
            }
            try {
                SQLiteDatabase writableDatabase = e.a(context, a).getWritableDatabase();
                writableDatabase.delete("t_conf", "_key = '" + str + "'", null);
                ContentValues contentValues = new ContentValues();
                contentValues.put("_key", str);
                contentValues.put("_value", (String) objArr[0]);
                contentValues.put("_vdate", (Long) objArr[1]);
                contentValues.put("_time", Long.valueOf(new Date().getTime()));
                if (writableDatabase.insert("t_conf", null, contentValues) < 0) {
                    com.tencent.beacon.core.d.b.d("[db] insertOrUpdateByKey failure! return false!", new Object[0]);
                } else {
                    z = true;
                }
            } catch (Exception unused) {
            }
            return z;
        }
    }
}
