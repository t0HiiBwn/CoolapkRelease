package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

/* compiled from: UMDBCreater */
class e extends SQLiteOpenHelper {
    private static Context b;
    private String a;

    /* compiled from: UMDBCreater */
    private static class a {
        private static final e a = new e(e.b, g.b(e.b), "ua.db", null, 2);

        private a() {
        }
    }

    public static e a(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
        }
        return a.a;
    }

    private e(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new b(context, str), str2, cursorFactory, i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? "ua.db" : str, cursorFactory, i);
        this.a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!g.a("__sd", writableDatabase)) {
                c(writableDatabase);
            }
            if (!g.a("__is", writableDatabase)) {
                d(writableDatabase);
            }
            if (!g.a("__et", writableDatabase)) {
                b(writableDatabase);
            }
            if (!g.a("__er", writableDatabase)) {
                a(writableDatabase);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            c(sQLiteDatabase);
            d(sQLiteDatabase);
            b(sQLiteDatabase);
            a(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (SQLiteDatabaseCorruptException unused) {
            g.a(b);
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused3) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i && i == 1) {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                try {
                    e(sQLiteDatabase);
                } catch (Exception unused2) {
                    f(sQLiteDatabase);
                }
            }
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!g.a(sQLiteDatabase, "__sd", "__av")) {
            g.a(sQLiteDatabase, "__sd", "__sp", "TEXT");
            g.a(sQLiteDatabase, "__sd", "__pp", "TEXT");
            g.a(sQLiteDatabase, "__sd", "__av", "TEXT");
            g.a(sQLiteDatabase, "__sd", "__vc", "TEXT");
        }
        if (!g.a(sQLiteDatabase, "__et", "__av")) {
            g.a(sQLiteDatabase, "__et", "__av", "TEXT");
            g.a(sQLiteDatabase, "__et", "__vc", "TEXT");
        }
        if (!g.a(sQLiteDatabase, "__er", "__av")) {
            g.a(sQLiteDatabase, "__er", "__av", "TEXT");
            g.a(sQLiteDatabase, "__er", "__vc", "TEXT");
        }
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "__sd");
        a(sQLiteDatabase, "__et");
        a(sQLiteDatabase, "__er");
        a();
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
