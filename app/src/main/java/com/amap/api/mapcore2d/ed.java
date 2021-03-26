package com.amap.api.mapcore2d;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: DynamicFileDBCreator */
public class ed implements ds {
    private static ed a;

    @Override // com.amap.api.mapcore2d.ds
    public String a() {
        return "dafile.db";
    }

    @Override // com.amap.api.mapcore2d.ds
    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.amap.api.mapcore2d.ds
    public int b() {
        return 1;
    }

    public static synchronized ed c() {
        ed edVar;
        synchronized (ed.class) {
            if (a == null) {
                a = new ed();
            }
            edVar = a;
        }
        return edVar;
    }

    private ed() {
    }

    @Override // com.amap.api.mapcore2d.ds
    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            eh.a(th, "DynamicFileDBCreator", "onCreate");
        }
    }
}
