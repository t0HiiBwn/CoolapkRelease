package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DBHelper */
class g {
    private static final Object c = new Object();
    private c a;
    private Context b;

    g(Context context) {
        Context context2;
        if (context == null) {
            try {
                context2 = p.a();
            } catch (Throwable unused) {
                return;
            }
        } else {
            context2 = context.getApplicationContext();
        }
        this.b = context2;
        if (this.a == null) {
            this.a = new c();
        }
    }

    /* access modifiers changed from: private */
    public Context c() {
        Context context = this.b;
        return context == null ? p.a() : context;
    }

    /* compiled from: DBHelper */
    public class c {
        private SQLiteDatabase b = null;

        public c() {
        }

        private synchronized void d() {
            try {
                synchronized (g.c) {
                    SQLiteDatabase sQLiteDatabase = this.b;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        g gVar = g.this;
                        SQLiteDatabase writableDatabase = new a(gVar.c()).getWritableDatabase();
                        this.b = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (e()) {
                    throw th;
                }
            }
        }

        public synchronized void a(String str) throws SQLException {
            try {
                d();
                this.b.execSQL(str);
            } catch (Throwable th) {
                if (e()) {
                    throw th;
                }
            }
        }

        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                d();
                cursor = this.b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                b bVar = new b();
                if (!e()) {
                    cursor = bVar;
                } else {
                    throw th;
                }
            }
            return cursor;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i;
            try {
                d();
                i = this.b.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!e()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            long j;
            try {
                d();
                j = this.b.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (!e()) {
                    j = -1;
                } else {
                    throw e;
                }
            }
            return j;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            int i;
            try {
                d();
                i = this.b.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!e()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        public synchronized void a() {
            d();
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.beginTransaction();
            }
        }

        public synchronized void b() {
            d();
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.setTransactionSuccessful();
            }
        }

        public synchronized void c() {
            d();
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }

        private synchronized boolean e() {
            SQLiteDatabase sQLiteDatabase;
            sQLiteDatabase = this.b;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    /* compiled from: DBHelper */
    private class a extends SQLiteOpenHelper {
        final Context a;

        public a(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 7);
            this.a = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a(sQLiteDatabase, this.a);
            } catch (Throwable unused) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            u.b("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(f.d());
            sQLiteDatabase.execSQL(n.f());
            sQLiteDatabase.execSQL(l.d());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.k.g.b());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                u.b("DBHelper", "onUpgrade....数据库版本升级.....old:" + i + ",new:" + i2);
                if (i > i2) {
                    a(sQLiteDatabase);
                    a(sQLiteDatabase, g.this.b);
                    u.b("DBHelper", "onUpgrade...逆向安装.数据库重置-创建表.....");
                } else {
                    a(sQLiteDatabase, g.this.b);
                }
                if (i == 1) {
                    u.b("DBHelper", "onUpgrade.....执行表创建.....");
                } else if (i == 2) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                } else if (i == 3) {
                    sQLiteDatabase.execSQL(n.f());
                } else if (i == 4) {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c());
                } else if (i == 5) {
                    sQLiteDatabase.execSQL(l.d());
                }
            } catch (Throwable unused) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> b2 = b(sQLiteDatabase);
            if (b2 != null && b2.size() > 0) {
                Iterator<String> it2 = b2.iterator();
                while (it2.hasNext()) {
                    sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it2.next()));
                }
            }
        }

        private ArrayList<String> b(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (rawQuery != null) {
                    while (rawQuery.moveToNext()) {
                        String string = rawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                    rawQuery.close();
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
    }

    public c a() {
        return this.a;
    }

    /* compiled from: DBHelper */
    private class b extends AbstractCursor {
        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }

        private b() {
        }
    }
}
