package com.coolapk.market.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.coolapk.market.util.LogUtils;

public class DbOpenHelper extends SQLiteOpenHelper {
    public DbOpenHelper(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE app (_id INTEGER PRIMARY KEY AUTOINCREMENT,packageName TEXT UNIQUE NOT NULL,appName TEXT DEFAULT '',versionName TEXT DEFAULT '',versionCode INTEGER DEFAULT 0,apkLength INTEGER DEFAULT 0,isSystem INTEGER DEFAULT 0,isExist INTEGER DEFAULT 0,apkPath TEXT DEFAULT '',firstInstallTime INTEGER DEFAULT 0,lastUpdateTime INTEGER DEFAULT 0,apkMd5 TEXT DEFAULT '',upgradeApkId TEXT DEFAULT '',upgradeDisplayVersionName TEXT DEFAULT '',upgradeVersionName TEXT DEFAULT '',upgradeVersionCode INTEGER DEFAULT 0,upgradeApkSize INTEGER DEFAULT 0,upgradeLastUpdate INTEGER DEFAULT 0,upgradeChangeLog TEXT DEFAULT '',upgradeLogo TEXT DEFAULT '',upgradePatchKey TEXT DEFAULT '',upgradePatchSize TEXT DEFAULT '',upgradePatchLength INTEGER DEFAULT 0,upgradePatchMd5 TEXT DEFAULT '',extraAnalysisData TEXT DEFAULT '',extraFlag TEXT DEFAULT '',ignoreVersionCode INTEGER DEFAULT 0,ignoredType INTEGER DEFAULT 0,created INTEGER DEFAULT 0,modified INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE download (_id INTEGER PRIMARY KEY AUTOINCREMENT,url TEXT DEFAULT '',urlMd5 TEXT UNIQUE DEFAULT '',fileName TEXT DEFAULT '',filePath TEXT DEFAULT '',apkFilePath TEXT DEFAULT '',totalLength INTEGER DEFAULT 0,currentLength INTEGER DEFAULT 0,extra TEXT DEFAULT '',mimeType TEXT DEFAULT '',startTime INTEGER DEFAULT 0,created INTEGER DEFAULT 0,modified INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE searchHistory (_id INTEGER PRIMARY KEY AUTOINCREMENT,keyword TEXT DEFAULT '',type INTEGER DEFAULT 0,created INTEGER DEFAULT 0,modified INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE qrCodeHistory (_id INTEGER PRIMARY KEY AUTOINCREMENT,result TEXT DEFAULT '',apkName TEXT DEFAULT '',shortTitle TEXT DEFAULT '',extraInfo TEXT DEFAULT '',logo TEXT DEFAULT '',type INTEGER DEFAULT 0,created INTEGER DEFAULT 0,modified INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE log (_id INTEGER PRIMARY KEY AUTOINCREMENT,tag TEXT DEFAULT '',message TEXT DEFAULT '',error TEXT DEFAULT '',created INTEGER DEFAULT 0,modified INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE article (_id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT DEFAULT '',coverUrl TEXT DEFAULT '',content TEXT DEFAULT '',created INTEGER DEFAULT 0,modified INTEGER DEFAULT 0);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        LogUtils.v("Upgrade sql, oldVersion: %d, newVersion: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i < 2 && i2 >= 2) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("ignoredType", (Integer) 0);
            LogUtils.v("Fix ignore info, the number of rows affected: %d", Integer.valueOf(sQLiteDatabase.update("app", contentValues, "(upgradeApkId IS NULL OR upgradeApkId =='') AND ignoredType != 0", null)));
        }
        if (i < 3 && i2 >= 3) {
            sQLiteDatabase.execSQL("CREATE TABLE log (_id INTEGER PRIMARY KEY AUTOINCREMENT,tag TEXT DEFAULT '',message TEXT DEFAULT '',error TEXT DEFAULT '',created INTEGER DEFAULT 0,modified INTEGER DEFAULT 0);");
            LogUtils.v("Create log table", new Object[0]);
        }
        if (i < 4 && i2 >= 4) {
            sQLiteDatabase.execSQL("ALTER TABLE app ADD COLUMN extraAnalysisData TEXT DEFAULT ''");
            LogUtils.v("Alter app table add column extraAnalysisData", new Object[0]);
        }
        if (i < 5 && i2 >= 5) {
            sQLiteDatabase.execSQL("CREATE TABLE article (_id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT DEFAULT '',coverUrl TEXT DEFAULT '',content TEXT DEFAULT '',created INTEGER DEFAULT 0,modified INTEGER DEFAULT 0);");
            LogUtils.v("Create article table", new Object[0]);
        }
        if (i < 6 && i2 >= 6) {
            sQLiteDatabase.execSQL("ALTER TABLE app ADD COLUMN extraFlag TEXT DEFAULT ''");
            LogUtils.v("Alter app table add column extraFlag", new Object[0]);
        }
    }

    private void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }
}
