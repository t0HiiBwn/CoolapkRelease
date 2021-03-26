package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: NpthDbHelper */
public class b extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public b(Context context) {
        super(context, "npth_log.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        new com.bytedance.tea.crash.b.b.b().a(sQLiteDatabase);
    }
}
