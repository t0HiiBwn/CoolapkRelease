package com.coolapk.market.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;

public class Db implements Closeable {
    private static final boolean DEBUG = false;
    private final Object databaseLock = new Object();
    private final SQLiteOpenHelper helper;
    private volatile SQLiteDatabase readableDatabase;
    private volatile SQLiteDatabase writeableDatabase;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConflictAlgorithm {
    }

    public Db(SQLiteOpenHelper sQLiteOpenHelper) {
        this.helper = sQLiteOpenHelper;
    }

    SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase = this.readableDatabase;
        if (sQLiteDatabase == null) {
            synchronized (this.databaseLock) {
                sQLiteDatabase = this.readableDatabase;
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = this.helper.getReadableDatabase();
                    this.readableDatabase = sQLiteDatabase;
                }
            }
        }
        return sQLiteDatabase;
    }

    SQLiteDatabase getWriteableDatabase() {
        SQLiteDatabase sQLiteDatabase = this.writeableDatabase;
        if (sQLiteDatabase == null) {
            synchronized (this.databaseLock) {
                sQLiteDatabase = this.writeableDatabase;
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = this.helper.getWritableDatabase();
                    this.writeableDatabase = sQLiteDatabase;
                }
            }
        }
        return sQLiteDatabase;
    }

    public Cursor query(String str, String... strArr) {
        long nanoTime = System.nanoTime();
        Cursor rawQuery = getReadableDatabase().rawQuery(str, strArr);
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        return rawQuery;
    }

    public long insert(String str, ContentValues contentValues) {
        return insert(str, contentValues, 0);
    }

    public long insert(String str, ContentValues contentValues, int i) {
        return getWriteableDatabase().insertWithOnConflict(str, null, contentValues, i);
    }

    public int update(String str, ContentValues contentValues, String str2, String... strArr) {
        return update(str, contentValues, 0, str2, strArr);
    }

    public int update(String str, ContentValues contentValues, int i, String str2, String... strArr) {
        return getWriteableDatabase().updateWithOnConflict(str, contentValues, str2, strArr, i);
    }

    public int delete(String str, String str2, String... strArr) {
        return getWriteableDatabase().delete(str, str2, strArr);
    }

    public void execute(String str) {
        getWriteableDatabase().execSQL(str);
    }

    public void execute(String str, Object... objArr) {
        getWriteableDatabase().execSQL(str, objArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.databaseLock) {
            this.readableDatabase = null;
            this.writeableDatabase = null;
            this.helper.close();
        }
    }

    private static String indentSql(String str) {
        return str.replace("\n", "\n       ");
    }

    private static String conflictString(int i) {
        if (i == 0) {
            return "none";
        }
        if (i == 1) {
            return "rollback";
        }
        if (i == 2) {
            return "abort";
        }
        if (i == 3) {
            return "fail";
        }
        if (i == 4) {
            return "ignore";
        }
        if (i == 5) {
            return "replace";
        }
        return "unknown (" + i + ')';
    }
}
