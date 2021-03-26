package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CCDBManager */
public class aa {
    private static SQLiteOpenHelper b;
    private static Context d;
    private AtomicInteger a;
    private SQLiteDatabase c;

    private aa() {
        this.a = new AtomicInteger();
    }

    /* compiled from: CCDBManager */
    private static class a {
        private static final aa a = new aa();

        private a() {
        }
    }

    public static aa a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = z.a(applicationContext);
        }
        return a.a;
    }

    public synchronized SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.c = b.getWritableDatabase();
        }
        return this.c;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.c.close();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        if (r8 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0057, code lost:
        if (r8 == null) goto L_0x005c;
     */
    public void a(String str, String str2, String str3) {
        SQLiteDatabase sQLiteDatabase;
        try {
            a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ts", str);
            contentValues.put("__c", str2);
            contentValues.put("__a", str3);
            ULog.i("jessie", "[DbManager] insert timeStamp: " + str + " content: " + str2 + " active: " + str3);
            this.c.insert("__cc", null, contentValues);
            this.c.setTransactionSuccessful();
            sQLiteDatabase = this.c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLiteDatabaseCorruptException unused) {
            ULog.i("jessie", "[DbManager] insert failed");
            sQLiteDatabase = this.c;
        } catch (Throwable th) {
            try {
                SQLiteDatabase sQLiteDatabase2 = this.c;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.endTransaction();
                }
            } catch (Throwable unused2) {
            }
            b();
            throw th;
        }
        b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        if (r1 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        if (r1 == null) goto L_0x007b;
     */
    public String c() {
        SQLiteDatabase sQLiteDatabase;
        String str = "";
        try {
            a();
            this.c.beginTransaction();
            Cursor rawQuery = this.c.rawQuery("select *  from __cc", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(rawQuery.getColumnIndex("__ts"));
                    String string2 = rawQuery.getString(rawQuery.getColumnIndex("__c"));
                    String string3 = rawQuery.getString(rawQuery.getColumnIndex("__a"));
                    str = str + String.format("timeStamp = %s, content = %s, active = %s", string, string2, string3) + "\n";
                }
            }
            this.c.setTransactionSuccessful();
            sQLiteDatabase = this.c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLiteDatabaseCorruptException e) {
            e.printStackTrace();
            sQLiteDatabase = this.c;
        } catch (Throwable th) {
            try {
                if (this.c != null) {
                    this.c.endTransaction();
                }
            } catch (Throwable unused) {
            }
            b();
            throw th;
        }
        b();
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ac, code lost:
        if (r1 == null) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b5, code lost:
        if (r1 == null) goto L_0x00ba;
     */
    public af d() {
        SQLiteDatabase sQLiteDatabase;
        af afVar = new af();
        try {
            a();
            this.c.beginTransaction();
            Cursor rawQuery = this.c.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
            if (rawQuery == null || !rawQuery.moveToNext()) {
                this.c.setTransactionSuccessful();
                sQLiteDatabase = this.c;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                b();
                return afVar;
            }
            String string = rawQuery.getString(rawQuery.getColumnIndex("__ts"));
            String string2 = rawQuery.getString(rawQuery.getColumnIndex("__c"));
            String string3 = rawQuery.getString(rawQuery.getColumnIndex("__a"));
            String string4 = rawQuery.getString(rawQuery.getColumnIndex("id"));
            ULog.i("jessie", "[DbManager] selectRecentActiveOne" + (String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, string4) + "\n"));
            af afVar2 = new af();
            afVar2.a(string);
            afVar2.b(string2);
            afVar2.c(string3);
            try {
                SQLiteDatabase sQLiteDatabase2 = this.c;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.endTransaction();
                }
            } catch (Throwable unused) {
            }
            b();
            return afVar2;
        } catch (SQLiteDatabaseCorruptException e) {
            e.printStackTrace();
            sQLiteDatabase = this.c;
        } catch (Throwable th) {
            try {
                if (this.c != null) {
                    this.c.endTransaction();
                }
            } catch (Throwable unused2) {
            }
            b();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004c, code lost:
        if (r7 == null) goto L_0x0051;
     */
    public boolean a(String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            a();
            this.c.beginTransaction();
            String str2 = "update  __cc set __a=\"1\" where __ts=\"" + str + "\"";
            ULog.i("jessie", "[DbManager] updateCloudConfigByTimestamp：" + str2);
            this.c.execSQL(str2);
            this.c.setTransactionSuccessful();
            sQLiteDatabase = this.c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLiteDatabaseCorruptException e) {
            e.printStackTrace();
            SQLiteDatabase sQLiteDatabase2 = this.c;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
        } catch (Throwable unused) {
        }
        b();
        return true;
        b();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0108, code lost:
        if (r12 == null) goto L_0x010d;
     */
    public boolean b(String str) {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        try {
            a();
            this.c.beginTransaction();
            Cursor rawQuery = this.c.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(rawQuery.getColumnIndex("__ts"));
                    String string2 = rawQuery.getString(rawQuery.getColumnIndex("__c"));
                    String string3 = rawQuery.getString(rawQuery.getColumnIndex("__a"));
                    String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, rawQuery.getString(rawQuery.getColumnIndex("id")));
                    af afVar = new af();
                    afVar.a(string);
                    afVar.b(string2);
                    afVar.c(string3);
                    if (!TextUtils.isEmpty(string) && !str.equals(string)) {
                        arrayList.add(afVar);
                    }
                }
            }
            int size = arrayList.size();
            String str2 = "";
            for (int i = 0; i < size; i++) {
                af afVar2 = (af) arrayList.get(i);
                str2 = i != size - 1 ? str2 + "__ts=\"" + afVar2.a() + "\" or " : str2 + "__ts=\"" + afVar2.a() + "\"";
                String str3 = "update  __cc set __a=\"0\" where " + str2;
                ULog.i("jessie", "[DbManager] updateOtherCloudConfigInfo : " + str3);
                this.c.execSQL(str3);
                this.c.setTransactionSuccessful();
            }
            sQLiteDatabase = this.c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLiteDatabaseCorruptException e) {
            e.printStackTrace();
            SQLiteDatabase sQLiteDatabase2 = this.c;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
        } catch (Throwable unused) {
        }
        b();
        return true;
        b();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00be, code lost:
        if (r0 == null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c7, code lost:
        if (r0 == null) goto L_0x00cc;
     */
    public boolean e() {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        try {
            a();
            this.c.beginTransaction();
            Cursor rawQuery = this.c.rawQuery("select *  from __cc where __a=\"0\" order by __ts asc", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("__ts")));
                }
            }
            int size = arrayList.size() - 5;
            String str = "";
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    str = i != size - 1 ? str + "__ts=\"" + ((String) arrayList.get(i)) + "\" or " : str + "__ts=\"" + ((String) arrayList.get(i)) + "\"";
                }
                String str2 = "delete from __cc where " + str;
                ULog.i("jessie", "[DbManager] deleteExtraCloudConfigInfo: " + str2);
                this.c.execSQL(str2);
                this.c.setTransactionSuccessful();
            }
            sQLiteDatabase = this.c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLiteDatabaseCorruptException e) {
            e.printStackTrace();
            sQLiteDatabase = this.c;
        } catch (Throwable th) {
            try {
                if (this.c != null) {
                    this.c.endTransaction();
                }
            } catch (Throwable unused) {
            }
            b();
            throw th;
        }
        b();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a9, code lost:
        if (r1 == null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b2, code lost:
        if (r1 == null) goto L_0x00b7;
     */
    public af f() {
        SQLiteDatabase sQLiteDatabase;
        af afVar = new af();
        try {
            a();
            this.c.beginTransaction();
            Cursor rawQuery = this.c.rawQuery("select *  from __cc order by __ts desc", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(rawQuery.getColumnIndex("__ts"));
                    String string2 = rawQuery.getString(rawQuery.getColumnIndex("__c"));
                    String string3 = rawQuery.getString(rawQuery.getColumnIndex("__a"));
                    String string4 = rawQuery.getString(rawQuery.getColumnIndex("id"));
                    ULog.i("jessie", "[DbManager] getLastestConfigInfo" + (String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, string4) + "\n"));
                    afVar.a(string);
                    afVar.b(string2);
                    afVar.c(string3);
                    if (string != null) {
                        try {
                            SQLiteDatabase sQLiteDatabase2 = this.c;
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.endTransaction();
                            }
                        } catch (Throwable unused) {
                        }
                        b();
                        return afVar;
                    }
                }
            }
            this.c.setTransactionSuccessful();
            sQLiteDatabase = this.c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLiteDatabaseCorruptException e) {
            e.printStackTrace();
            sQLiteDatabase = this.c;
        } catch (Throwable th) {
            try {
                if (this.c != null) {
                    this.c.endTransaction();
                }
            } catch (Throwable unused2) {
            }
            b();
            throw th;
        }
        b();
        return afVar;
    }
}
