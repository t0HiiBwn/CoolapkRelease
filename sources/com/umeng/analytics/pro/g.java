package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: UMDBUtils */
public class g {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        if (r1 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (0 == 0) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        return r0;
     */
    public static boolean a(String str, SQLiteDatabase sQLiteDatabase) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        Cursor cursor = null;
        try {
            str.trim();
            cursor = sQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type=? and name=?", new String[]{"table", str.trim()});
            if (cursor.moveToNext() && cursor.getInt(0) > 0) {
                z = true;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                File databasePath = context.getDatabasePath("ua.db");
                if (databasePath != null && databasePath.exists()) {
                    databasePath.delete();
                }
                e.a(context).a();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b(Context context) {
        File databasePath = context.getDatabasePath("ua.db");
        return databasePath.getParent() + File.separator;
    }

    public static String c(Context context) {
        return b(context) + "subprocess/";
    }

    public static String a(List<String> list) {
        return TextUtils.join("!", list);
    }

    public static List<String> a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    public static List<String> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        if (r0.isClosed() == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        if (r0.isClosed() == false) goto L_0x002f;
     */
    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            if (!(cursor == null || cursor.getColumnIndex(str2) == -1)) {
                z = true;
            }
            if (cursor != null) {
            }
        } catch (Exception unused) {
            if (0 != 0) {
            }
        } catch (Throwable th) {
            if (0 != 0 && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        return z;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + " " + str3);
    }
}
