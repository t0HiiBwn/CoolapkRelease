package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* compiled from: CacheDBHelper */
public class bc extends SQLiteOpenHelper {
    private static final Object b = new Object();
    private static bc c = null;
    private static final String d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";
    private static final String e = "DROP TABLE IF EXISTS stf";
    private static final String f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";
    private final Context a;

    public static final int a() {
        return 1;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public static bc a(Context context) {
        bc bcVar;
        synchronized (b) {
            if (c == null) {
                c = new bc(context, "umeng_zero_cache.db", null, 1);
            }
            bcVar = c;
        }
        return bcVar;
    }

    private bc(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.a = context;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS stf");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)");
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e("MobclickRT", "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    public void b() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null && writableDatabase.isOpen()) {
            writableDatabase.close();
        }
    }

    public void a(String str, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null && writableDatabase.isOpen()) {
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.e("MobclickRT", "--->>> [有状态]插入二级缓存数据记录 成功。");
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }

    public void a(String str, String str2, String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null && writableDatabase.isOpen()) {
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }

    private void d() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase != null && writableDatabase.isOpen()) {
            try {
                writableDatabase.execSQL("DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)");
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        if (r1 != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0077, code lost:
        if (r1 == null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        return r0;
     */
    public bd a(String str) {
        Cursor cursor;
        bd bdVar = null;
        try {
            cursor = a(str, new String[]{"_uuid", "_tp", "_hd", "_bd", "_re1", "_re2"}, null, null, null, null, null, "1");
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        bd bdVar2 = new bd();
                        try {
                            bdVar2.a = cursor.getString(0);
                            bdVar2.b = cursor.getString(1);
                            String string = cursor.getString(2);
                            String string2 = cursor.getString(3);
                            bdVar2.c = h.a(this.a).d(string);
                            bdVar2.d = h.a(this.a).d(string2);
                            bdVar2.e = cursor.getString(4);
                            bdVar2.f = cursor.getString(5);
                            bdVar = bdVar2;
                        } catch (Throwable unused) {
                            bdVar = bdVar2;
                            try {
                                d();
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    d();
                }
            }
        } catch (Throwable unused3) {
            cursor = null;
            d();
        }
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return null;
        }
        try {
            if (writableDatabase.isOpen()) {
                return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean b(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursor = null;
        if (writableDatabase != null) {
            try {
                if (writableDatabase.isOpen()) {
                    cursor = writableDatabase.query(str, null, null, null, null, null, null, null);
                }
            } catch (Throwable unused) {
                if (0 != 0) {
                    cursor.close();
                }
                if (writableDatabase == null) {
                    return false;
                }
            }
        }
        if (cursor == null || cursor.getCount() <= 0) {
            if (cursor != null) {
                cursor.close();
            }
            if (writableDatabase == null) {
                return false;
            }
            writableDatabase.close();
            return false;
        }
        if (cursor != null) {
            cursor.close();
        }
        if (writableDatabase != null) {
            writableDatabase.close();
        }
        return true;
    }

    public boolean c() {
        return !b("stf");
    }
}
