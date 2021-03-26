package com.tencent.bugly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;

/* compiled from: BUGLY */
public abstract class a {
    public int id;
    public String moduleName;
    public String version;
    public String versionKey;

    public abstract String[] getTables();

    public abstract void init(Context context, boolean z, BuglyStrategy buglyStrategy);

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() != null) {
                String[] tables = getTables();
                for (String str : tables) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                }
                onDbCreate(sQLiteDatabase);
            }
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
        }
    }

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() != null) {
                String[] tables = getTables();
                for (String str : tables) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                }
                onDbCreate(sQLiteDatabase);
            }
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
        }
    }
}
