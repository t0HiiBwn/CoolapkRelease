package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.h;

/* compiled from: TableStatements */
public class g {
    private final SQLiteDatabase a;
    private final String b;
    private final String[] c;
    private final String[] d;
    private SQLiteStatement e;
    private SQLiteStatement f;
    private SQLiteStatement g;
    private SQLiteStatement h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.e == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(h.a("INSERT INTO ", this.b, this.c));
            synchronized (this) {
                if (this.e == null) {
                    this.e = compileStatement;
                }
            }
            if (this.e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.e;
    }

    public SQLiteStatement b() {
        if (this.g == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(h.a(this.b, this.d));
            synchronized (this) {
                if (this.g == null) {
                    this.g = compileStatement;
                }
            }
            if (this.g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.g;
    }

    public SQLiteStatement c() {
        if (this.f == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(h.a(this.b, this.c, this.d));
            synchronized (this) {
                if (this.f == null) {
                    this.f = compileStatement;
                }
            }
            if (this.f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f;
    }

    public SQLiteStatement d() {
        if (this.h == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(h.b(this.b, this.c, this.d));
            synchronized (this) {
                if (this.h == null) {
                    this.h = compileStatement;
                }
            }
            if (this.h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.h;
    }
}
