package com.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
public final class ah extends SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c;
    private ad a;

    public ah(Context context, String str, ad adVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.a = adVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
