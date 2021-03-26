package com.ss.android.socialbase.downloader.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ss.android.socialbase.downloader.downloader.b;
import java.io.File;

/* compiled from: DownloadDBHelper */
public class a extends SQLiteOpenHelper {
    private static volatile a a;
    private boolean b = false;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private a() {
        super(b.L(), "downloader.db", (SQLiteDatabase.CursorFactory) null, 14);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        Context L = b.L();
        if (this.b || L == null) {
            return super.getReadableDatabase();
        }
        try {
            File file = new File("/data/data/" + L.getPackageName() + "/database/main/");
            if (!file.exists()) {
                file.mkdir();
            }
            super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = tempDir");
            this.b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloader( _id INTEGER PRIMARY KEY, url TEXT, savePath TEXT, tempPath TEXT, name TEXT, chunkCount INTEGER, status INTEGER, curBytes INTEGER, totalBytes INTEGER, eTag TEXT, onlyWifi INTEGER, force INTEGER, retryCount INTEGER, extra TEXT, mimeType TEXT, title TEXT, notificationEnable INTEGER, notificationVisibility INTEGER, isFirstDownload INTEGER, isFirstSuccess INTEGER, needHttpsToHttpRetry INTEGER, downloadTime INTEGER, packageName TEXT, md5 TEXT, retryDelay INTEGER, curRetryTime INTEGER, retryDelayStatus INTEGER, defaultHttpServiceBackUp INTEGER, chunkRunnableReuse INTEGER, retryDelayTimeArray TEXT, chunkDowngradeRetry INTEGER, backUpUrlsStr TEXT, backUpUrlRetryCount INTEGER, realDownloadTime INTEGER, retryScheduleMinutes INTEGER, independentProcess INTEGER, auxiliaryJsonobjectString TEXT, iconUrl TEXT, appVersionCode INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloadChunk( _id INTEGER, chunkIndex INTEGER, startOffset INTEGER, curOffset INTEGER, endOffset INTEGER, chunkContentLen INTEGER, hostChunkIndex INTEGER )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD mimeType TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD title TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD notificationEnable INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD notificationVisibility INTEGER");
            case 2:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD isFirstDownload INTEGER");
            case 3:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD isFirstSuccess INTEGER");
            case 4:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD needHttpsToHttpRetry INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD downloadTime INTEGER");
            case 5:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD packageName TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD md5 TEXT");
            case 6:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryDelay INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD curRetryTime INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryDelayStatus INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD defaultHttpServiceBackUp INTEGER");
            case 7:
                sQLiteDatabase.execSQL("ALTER TABLE downloadChunk ADD chunkContentLen INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloadChunk ADD hostChunkIndex INTEGER");
            case 8:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD chunkRunnableReuse INTEGER");
            case 9:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryDelayTimeArray TEXT");
            case 10:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD chunkDowngradeRetry INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD backUpUrlsStr TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD backUpUrlRetryCount INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD realDownloadTime INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryScheduleMinutes INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD independentProcess INTEGER");
            case 11:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD auxiliaryJsonobjectString TEXT");
            case 12:
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD iconUrl TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE downloader ADD appVersionCode INTEGER");
                break;
            case 13:
                break;
            default:
                return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.a("onDowngrade");
        }
    }
}
