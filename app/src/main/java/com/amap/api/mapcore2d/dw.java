package com.amap.api.mapcore2d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
public class dw extends SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c;
    private ds a;

    public dw(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, ds dsVar) {
        super(context, str, cursorFactory, i);
        this.a = dsVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.a(sQLiteDatabase, i, i2);
    }
}
