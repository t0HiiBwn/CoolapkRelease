package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: CCDBHelper */
public class z extends SQLiteOpenHelper {
    public static final String a = "cc.db";
    private static Context c;
    private String b;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* compiled from: CCDBHelper */
    private static class a {
        private static final z a = new z(z.c);

        private a() {
        }
    }

    public static z a(Context context) {
        if (c == null) {
            c = context.getApplicationContext();
        }
        return a.a;
    }

    private z(Context context) {
        super(context, "cc.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.b = null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.b = "create table if not exists __cc(id INTEGER primary key autoincrement, __ts TEXT, __c TEXT, __a TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __cc(id INTEGER primary key autoincrement, __ts TEXT, __c TEXT, __a TEXT)");
        } catch (SQLException unused) {
        }
    }
}
