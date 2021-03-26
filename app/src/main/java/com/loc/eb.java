package com.loc;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: SdCardDbCreator */
public class eb implements ad {
    @Override // com.loc.ad
    public final String a() {
        return "alsn20170807.db";
    }

    @Override // com.loc.ad
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            ej.a(th, "SdCardDbCreator", "onCreate");
        }
    }
}
