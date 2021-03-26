package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMStoreManager */
public class h {
    public static final int a = 2049;
    public static final int b = 2050;
    private static final int c = 1000;
    private static Context d = null;
    private static String e = null;
    private static final String f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* compiled from: UMStoreManager */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* compiled from: UMStoreManager */
    private static class b {
        private static final h a = new h();

        private b() {
        }
    }

    private h() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    public static h a(Context context) {
        h hVar = b.a;
        if (d == null && context != null) {
            d = context.getApplicationContext();
            hVar.k();
        }
        return hVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    public void a() {
        this.i.clear();
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009a, code lost:
        if (r2 != null) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
        if (r2 != null) goto L_0x009c;
     */
    public void a(JSONArray jSONArray) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = f.a(d).a();
            try {
                a2.beginTransaction();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        ContentValues contentValues = new ContentValues();
                        String optString = jSONObject.optString("__i");
                        if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                            optString = t.a().b();
                            if (TextUtils.isEmpty(optString)) {
                                optString = "-1";
                            }
                        }
                        contentValues.put("__i", optString);
                        contentValues.put("__e", jSONObject.optString("id"));
                        contentValues.put("__t", Integer.valueOf(jSONObject.optInt("__t")));
                        contentValues.put("__av", UMUtils.getAppVersionName(d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                        jSONObject.remove("__i");
                        jSONObject.remove("__t");
                        contentValues.put("__s", c(jSONObject.toString()));
                        a2.insert("__et", null, contentValues);
                    } catch (Exception unused) {
                    }
                }
                a2.setTransactionSuccessful();
                if (a2 != null) {
                    a2.endTransaction();
                }
            } catch (SQLiteDatabaseCorruptException unused2) {
                sQLiteDatabase = a2;
                try {
                    g.a(d);
                } catch (Throwable unused3) {
                }
            } catch (Throwable unused4) {
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
            g.a(d);
        } catch (Throwable unused6) {
        }
        f.a(d).b();
        return;
        f.a(d).b();
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if (r0 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (r0 != null) goto L_0x005a;
     */
    public boolean a(String str, String str2, int i2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = f.a(d).a();
            try {
                a2.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("__i", str);
                String c2 = c(str2);
                if (!TextUtils.isEmpty(c2)) {
                    contentValues.put("__a", c2);
                    contentValues.put("__t", Integer.valueOf(i2));
                    contentValues.put("__av", UMUtils.getAppVersionName(d));
                    contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                    a2.insert("__er", null, contentValues);
                }
                a2.setTransactionSuccessful();
                if (a2 != null) {
                    a2.endTransaction();
                }
            } catch (SQLiteDatabaseCorruptException unused) {
                sQLiteDatabase = a2;
                try {
                    g.a(d);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            g.a(d);
        } catch (Throwable unused5) {
        }
        f.a(d).b();
        return false;
        f.a(d).b();
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
        if (r0 != null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006e, code lost:
        if (r0 == null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        if (r0 == null) goto L_0x0073;
     */
    public void d() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f.a(d).a();
            sQLiteDatabase.beginTransaction();
            String c2 = t.a().c();
            if (TextUtils.isEmpty(c2)) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                f.a(d).b();
                return;
            }
            String[] strArr = {"", "-1"};
            for (int i2 = 0; i2 < 2; i2++) {
                sQLiteDatabase.execSQL("update __et set __i=\"" + c2 + "\" where __i=\"" + strArr[i2] + "\"");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteDatabaseCorruptException unused2) {
            g.a(d);
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            f.a(d).b();
            throw th;
        }
        f.a(d).b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
        if (r2 != null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0089, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009b, code lost:
        if (r2 != null) goto L_0x0089;
     */
    public boolean a(String str, JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = f.a(d).a();
            try {
                a2.beginTransaction();
                if (aVar == a.BEGIN) {
                    long longValue = ((Long) jSONObject.opt("__e")).longValue();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("__ii", str);
                    contentValues.put("__e", String.valueOf(longValue));
                    contentValues.put("__av", UMUtils.getAppVersionName(d));
                    contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                    a2.insert("__sd", null, contentValues);
                } else if (aVar == a.INSTANTSESSIONBEGIN) {
                    b(str, jSONObject, a2);
                } else if (aVar == a.END) {
                    a(str, jSONObject, a2);
                } else if (aVar == a.PAGE) {
                    a(str, jSONObject, a2, "__a");
                } else if (aVar == a.AUTOPAGE) {
                    a(str, jSONObject, a2, "__b");
                } else if (aVar == a.NEWSESSION) {
                    c(str, jSONObject, a2);
                }
                a2.setTransactionSuccessful();
                if (a2 != null) {
                    a2.endTransaction();
                }
            } catch (SQLiteDatabaseCorruptException unused) {
                sQLiteDatabase = a2;
                try {
                    g.a(d);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            g.a(d);
        } catch (Throwable unused5) {
        }
        f.a(d).b();
        return false;
        f.a(d).b();
        throw th;
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt("__f")).longValue();
            long j2 = 0;
            Object opt = jSONObject.opt("__g");
            if (opt != null && (opt instanceof Long)) {
                j2 = ((Long) opt).longValue();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? str2 : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", __g=\"" + j2 + "\", __sp=\"" + c2 + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? str2 : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c2);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
            sQLiteDatabase.insert("__is", null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r4 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        if (r4 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        r4.endTransaction();
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[SYNTHETIC, Splitter:B:15:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A[Catch:{ Exception -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
    public long a(String str) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        Cursor cursor = null;
        long j2 = 0;
        try {
            sQLiteDatabase = f.a(d).a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor rawQuery = sQLiteDatabase.rawQuery("select __f from __sd where __ii=?", new String[]{str});
                if (rawQuery != null) {
                    rawQuery.moveToFirst();
                    j2 = rawQuery.getLong(rawQuery.getColumnIndex("__f"));
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                if (0 != 0) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception unused3) {
                        f.a(d).b();
                        throw th;
                    }
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                f.a(d).b();
                throw th;
            }
        } catch (Exception unused4) {
            sQLiteDatabase = null;
            if (0 != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
            if (0 != 0) {
            }
            if (sQLiteDatabase != null) {
            }
            f.a(d).b();
            throw th;
        }
        f.a(d).b();
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Cursor cursor2 = null;
        r1 = null;
        r1 = null;
        String str2 = null;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("__d");
            if (optJSONObject != null) {
                cursor = sQLiteDatabase.rawQuery("select __d from __sd where __ii=?", new String[]{str});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            str2 = d(cursor.getString(cursor.getColumnIndex("__d")));
                        } catch (Throwable unused) {
                            cursor2 = cursor;
                            if (cursor2 == null) {
                                cursor2.close();
                                return;
                            }
                            return;
                        }
                    }
                }
            } else {
                cursor = null;
            }
            if (optJSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(str2)) {
                    jSONArray = new JSONArray(str2);
                }
                jSONArray.put(optJSONObject);
                String c2 = c(jSONArray.toString());
                if (!TextUtils.isEmpty(c2)) {
                    sQLiteDatabase.execSQL("update  __sd set __d=\"" + c2 + "\" where __ii=\"" + str + "\"");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__c");
            if (optJSONObject2 != null) {
                String c3 = c(optJSONObject2.toString());
                if (!TextUtils.isEmpty(c3)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + c3 + "\" where __ii=\"" + str + "\"");
                }
            }
            long optLong = jSONObject.optLong("__f");
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(optLong) + "\" where __ii=\"" + str + "\"");
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable unused2) {
            if (cursor2 == null) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws JSONException {
        JSONArray jSONArray;
        Cursor cursor = null;
        r4 = null;
        String str3 = null;
        try {
            if ("__a".equals(str2)) {
                jSONArray = jSONObject.optJSONArray("__a");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    return;
                }
            } else if ("__b".equals(str2)) {
                jSONArray = jSONObject.optJSONArray("__b");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    return;
                }
            } else {
                jSONArray = null;
            }
            Cursor rawQuery = sQLiteDatabase.rawQuery("select " + str2 + " from __sd where __ii=?", new String[]{str});
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    try {
                        str3 = d(rawQuery.getString(rawQuery.getColumnIndex(str2)));
                    } catch (Throwable unused) {
                        cursor = rawQuery;
                        if (cursor == null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(str3)) {
                jSONArray2 = new JSONArray(str3);
            }
            if (jSONArray2.length() <= 1000) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (jSONObject2 != null) {
                            jSONArray2.put(jSONObject2);
                        }
                    } catch (JSONException unused2) {
                    }
                }
                String c2 = c(jSONArray2.toString());
                if (!TextUtils.isEmpty(c2)) {
                    sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + c2 + "\" where __ii=\"" + str + "\"");
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Throwable unused3) {
            if (cursor == null) {
            }
        }
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    public JSONObject a(boolean z) {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String a2 = a(jSONObject, z);
            if (!TextUtils.isEmpty(a2)) {
                b(jSONObject, a2);
                a(jSONObject, a2);
            }
        }
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        if (r2 == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0097, code lost:
        if (r2 == null) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0094  */
    public JSONObject f() {
        JSONObject jSONObject;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.l.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = f.a(d).a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor rawQuery = sQLiteDatabase.rawQuery("select *  from __is where __ii=?", new String[]{this.l.get(0)});
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = rawQuery.getString(rawQuery.getColumnIndex("__av"));
                                String string2 = rawQuery.getString(rawQuery.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor = rawQuery;
                                try {
                                    g.a(d);
                                    if (cursor != null) {
                                    }
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable unused3) {
                                cursor2 = rawQuery;
                                if (cursor2 != null) {
                                }
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = null;
                        cursor = rawQuery;
                        g.a(d);
                        if (cursor != null) {
                        }
                    } catch (Throwable unused5) {
                        jSONObject = null;
                        cursor2 = rawQuery;
                        if (cursor2 != null) {
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                f.a(d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
                g.a(d);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable unused8) {
                jSONObject = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
            g.a(d);
            if (cursor != null) {
            }
        } catch (Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
            if (cursor2 != null) {
            }
        }
        f.a(d).b();
        return jSONObject;
        f.a(d).b();
        throw th;
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0162, code lost:
        if (r1 != null) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0170, code lost:
        if (r1 == null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x017e, code lost:
        if (r1 == null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x017b  */
    private void a(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = f.a(d).a();
            try {
                sQLiteDatabase.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    cursor = sQLiteDatabase.rawQuery("select *  from __et where __i=?", new String[]{str});
                } else {
                    cursor = sQLiteDatabase.rawQuery("select *  from __et", null);
                }
                if (cursor != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    String b2 = t.a().b();
                    while (cursor.moveToNext()) {
                        int i2 = cursor.getInt(cursor.getColumnIndex("__t"));
                        String string = cursor.getString(cursor.getColumnIndex("__i"));
                        String string2 = cursor.getString(cursor.getColumnIndex("__s"));
                        if (TextUtils.isEmpty(string) || "-1".equals(string)) {
                            if (!TextUtils.isEmpty(b2)) {
                                string = b2;
                            }
                        }
                        this.j.add(Integer.valueOf(cursor.getInt(0)));
                        if (i2 != 2049) {
                            if (i2 == 2050) {
                                if (!TextUtils.isEmpty(string2)) {
                                    JSONObject jSONObject4 = new JSONObject(d(string2));
                                    if (jSONObject3.has(string)) {
                                        jSONArray2 = jSONObject3.optJSONArray(string);
                                    } else {
                                        jSONArray2 = new JSONArray();
                                    }
                                    jSONArray2.put(jSONObject4);
                                    jSONObject3.put(string, jSONArray2);
                                }
                            }
                        } else if (!TextUtils.isEmpty(string2)) {
                            JSONObject jSONObject5 = new JSONObject(d(string2));
                            if (jSONObject2.has(string)) {
                                jSONArray = jSONObject2.optJSONArray(string);
                            } else {
                                jSONArray = new JSONArray();
                            }
                            jSONArray.put(jSONObject5);
                            jSONObject2.put(string, jSONArray);
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            JSONObject jSONObject6 = new JSONObject();
                            String next = keys.next();
                            jSONObject6.put(next, new JSONArray(jSONObject2.optString(next)));
                            if (jSONObject6.length() > 0) {
                                jSONArray3.put(jSONObject6);
                            }
                        }
                        if (jSONArray3.length() > 0) {
                            jSONObject.put("ekv", jSONArray3);
                        }
                    }
                    if (jSONObject3.length() > 0) {
                        JSONArray jSONArray4 = new JSONArray();
                        Iterator<String> keys2 = jSONObject3.keys();
                        while (keys2.hasNext()) {
                            JSONObject jSONObject7 = new JSONObject();
                            String next2 = keys2.next();
                            jSONObject7.put(next2, new JSONArray(jSONObject3.optString(next2)));
                            if (jSONObject7.length() > 0) {
                                jSONArray4.put(jSONObject7);
                            }
                        }
                        if (jSONArray4.length() > 0) {
                            jSONObject.put("gkv", jSONArray4);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteDatabaseCorruptException unused) {
                g.a(d);
                if (0 != 0) {
                }
            } catch (Throwable unused2) {
                try {
                    g.a(d);
                    if (0 != 0) {
                    }
                } catch (Throwable unused3) {
                }
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            sQLiteDatabase = null;
            g.a(d);
            if (0 != 0) {
                cursor2.close();
            }
        } catch (Throwable unused5) {
            sQLiteDatabase = null;
            g.a(d);
            if (0 != 0) {
                cursor2.close();
            }
        }
        f.a(d).b();
        return;
        f.a(d).b();
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        if (r1 != null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
        if (r1 == null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0081, code lost:
        if (r1 == null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
    private void b(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = f.a(d).a();
            try {
                sQLiteDatabase.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    cursor = sQLiteDatabase.rawQuery("select *  from __er where __i=?", new String[]{str});
                } else {
                    cursor = sQLiteDatabase.rawQuery("select *  from __er", null);
                }
                if (cursor != null) {
                    JSONArray jSONArray = new JSONArray();
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("__a"));
                        if (!TextUtils.isEmpty(string)) {
                            jSONArray.put(new JSONObject(d(string)));
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("error", jSONArray);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteDatabaseCorruptException unused) {
                g.a(d);
                if (0 != 0) {
                }
            } catch (Throwable unused2) {
                try {
                    g.a(d);
                    if (0 != 0) {
                    }
                } catch (Throwable unused3) {
                }
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            sQLiteDatabase = null;
            g.a(d);
            if (0 != 0) {
                cursor2.close();
            }
        } catch (Throwable unused5) {
            sQLiteDatabase = null;
            g.a(d);
            if (0 != 0) {
                cursor2.close();
            }
        }
        f.a(d).b();
        return;
        f.a(d).b();
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        if (r2 == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0097, code lost:
        if (r2 == null) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0094  */
    public JSONObject g() {
        JSONObject jSONObject;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.i.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = f.a(d).a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor rawQuery = sQLiteDatabase.rawQuery("select *  from __sd where __ii=?", new String[]{this.i.get(0)});
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = rawQuery.getString(rawQuery.getColumnIndex("__av"));
                                String string2 = rawQuery.getString(rawQuery.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor = rawQuery;
                                try {
                                    g.a(d);
                                    if (cursor != null) {
                                    }
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable unused3) {
                                cursor2 = rawQuery;
                                if (cursor2 != null) {
                                }
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = null;
                        cursor = rawQuery;
                        g.a(d);
                        if (cursor != null) {
                        }
                    } catch (Throwable unused5) {
                        jSONObject = null;
                        cursor2 = rawQuery;
                        if (cursor2 != null) {
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                f.a(d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
                g.a(d);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable unused8) {
                jSONObject = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
            g.a(d);
            if (cursor != null) {
            }
        } catch (Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
            if (cursor2 != null) {
            }
        }
        f.a(d).b();
        return jSONObject;
        f.a(d).b();
        throw th;
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0225, code lost:
        if (r12 != null) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0235, code lost:
        if (r12 != null) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r12.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x020d, code lost:
        if (r12 != null) goto L_0x0237;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0232  */
    private String a(JSONObject jSONObject, boolean z) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        String str;
        String str2 = null;
        try {
            SQLiteDatabase a2 = f.a(d).a();
            try {
                a2.beginTransaction();
                Cursor rawQuery = a2.rawQuery("select *  from __sd", null);
                if (rawQuery != null) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        while (true) {
                            if (!rawQuery.moveToNext()) {
                                sQLiteDatabase = a2;
                                cursor = rawQuery;
                                break;
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            String string = rawQuery.getString(rawQuery.getColumnIndex("__f"));
                            String string2 = rawQuery.getString(rawQuery.getColumnIndex("__e"));
                            String string3 = rawQuery.getString(rawQuery.getColumnIndex("__g"));
                            str2 = rawQuery.getString(rawQuery.getColumnIndex("__ii"));
                            try {
                                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                                    str = str2;
                                    sQLiteDatabase = a2;
                                    cursor = rawQuery;
                                } else {
                                    if (Long.parseLong(string) - Long.parseLong(string2) > 0) {
                                        String string4 = rawQuery.getString(rawQuery.getColumnIndex("__a"));
                                        String string5 = rawQuery.getString(rawQuery.getColumnIndex("__b"));
                                        String string6 = rawQuery.getString(rawQuery.getColumnIndex("__c"));
                                        String string7 = rawQuery.getString(rawQuery.getColumnIndex("__d"));
                                        this.i.add(str2);
                                        String string8 = rawQuery.getString(rawQuery.getColumnIndex("__sp"));
                                        String string9 = rawQuery.getString(rawQuery.getColumnIndex("__pp"));
                                        jSONObject2.put("id", str2);
                                        jSONObject2.put("start_time", string2);
                                        jSONObject2.put("end_time", string);
                                        str = str2;
                                        if (FieldManager.allow("header_foreground_count")) {
                                            try {
                                                if (Long.parseLong(string3) <= 0) {
                                                    jSONObject2.put("duration", Long.parseLong(string) - Long.parseLong(string2));
                                                    sQLiteDatabase = a2;
                                                    cursor = rawQuery;
                                                } else {
                                                    sQLiteDatabase = a2;
                                                    cursor = rawQuery;
                                                    try {
                                                        jSONObject2.put("duration", Long.parseLong(string3));
                                                        jSONObject2.put("duration_old", Long.parseLong(string) - Long.parseLong(string2));
                                                    } catch (SQLiteDatabaseCorruptException unused) {
                                                        str2 = str;
                                                        g.a(d);
                                                        if (cursor != null) {
                                                        }
                                                    } catch (Throwable unused2) {
                                                        str2 = str;
                                                        try {
                                                            g.a(d);
                                                            if (cursor != null) {
                                                            }
                                                        } catch (Throwable unused3) {
                                                        }
                                                    }
                                                }
                                            } catch (SQLiteDatabaseCorruptException unused4) {
                                                sQLiteDatabase = a2;
                                                cursor = rawQuery;
                                                str2 = str;
                                                g.a(d);
                                                if (cursor != null) {
                                                }
                                            } catch (Throwable unused5) {
                                                sQLiteDatabase = a2;
                                                cursor = rawQuery;
                                                str2 = str;
                                                g.a(d);
                                                if (cursor != null) {
                                                }
                                            }
                                        } else {
                                            sQLiteDatabase = a2;
                                            cursor = rawQuery;
                                            jSONObject2.put("duration", Long.parseLong(string) - Long.parseLong(string2));
                                        }
                                        if (!TextUtils.isEmpty(string4)) {
                                            jSONObject2.put("pages", new JSONArray(d(string4)));
                                        }
                                        if (!TextUtils.isEmpty(string5) && k.b == MobclickAgent.PageMode.AUTO) {
                                            JSONArray jSONArray2 = new JSONArray(d(string5));
                                            JSONArray jSONArray3 = new JSONArray();
                                            if (jSONArray2.length() > 0) {
                                                jSONArray3 = b(jSONArray2);
                                            }
                                            jSONObject2.put("autopages", jSONArray3);
                                        }
                                        if (!TextUtils.isEmpty(string6)) {
                                            jSONObject2.put("traffic", new JSONObject(d(string6)));
                                        }
                                        if (!TextUtils.isEmpty(string7)) {
                                            jSONObject2.put("locations", new JSONArray(d(string7)));
                                        }
                                        if (!TextUtils.isEmpty(string8)) {
                                            jSONObject2.put("_$sp", new JSONObject(d(string8)));
                                        }
                                        if (!TextUtils.isEmpty(string9)) {
                                            jSONObject2.put("_$pp", new JSONObject(d(string9)));
                                        }
                                        if (jSONObject2.length() > 0) {
                                            jSONArray.put(jSONObject2);
                                        }
                                    } else {
                                        str = str2;
                                        sQLiteDatabase = a2;
                                        cursor = rawQuery;
                                    }
                                    if (z) {
                                        str2 = str;
                                        break;
                                    }
                                }
                                a2 = sQLiteDatabase;
                                rawQuery = cursor;
                                str2 = str;
                            } catch (SQLiteDatabaseCorruptException unused6) {
                                sQLiteDatabase = a2;
                                cursor = rawQuery;
                                g.a(d);
                                if (cursor != null) {
                                }
                            } catch (Throwable unused7) {
                                sQLiteDatabase = a2;
                                cursor = rawQuery;
                                g.a(d);
                                if (cursor != null) {
                                }
                            }
                        }
                        try {
                            if (this.i.size() < 1) {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Throwable unused8) {
                                    }
                                }
                                f.a(d).b();
                                return str2;
                            } else if (jSONArray.length() > 0) {
                                jSONObject.put("sessions", jSONArray);
                            }
                        } catch (SQLiteDatabaseCorruptException unused9) {
                            g.a(d);
                            if (cursor != null) {
                            }
                        } catch (Throwable unused10) {
                            g.a(d);
                            if (cursor != null) {
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused11) {
                        sQLiteDatabase = a2;
                        cursor = rawQuery;
                        g.a(d);
                        if (cursor != null) {
                        }
                    } catch (Throwable unused12) {
                        sQLiteDatabase = a2;
                        cursor = rawQuery;
                        g.a(d);
                        if (cursor != null) {
                        }
                    }
                } else {
                    sQLiteDatabase = a2;
                    cursor = rawQuery;
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteDatabaseCorruptException unused13) {
                sQLiteDatabase = a2;
                cursor = null;
                g.a(d);
                if (cursor != null) {
                }
            } catch (Throwable unused14) {
                sQLiteDatabase = a2;
                cursor = null;
                g.a(d);
                if (cursor != null) {
                }
            }
        } catch (SQLiteDatabaseCorruptException unused15) {
            sQLiteDatabase = null;
            cursor = null;
            g.a(d);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable unused16) {
            sQLiteDatabase = null;
            cursor = null;
            g.a(d);
            if (cursor != null) {
                cursor.close();
            }
        }
        f.a(d).b();
        return str2;
        f.a(d).b();
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r1 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dd, code lost:
        if (r1 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00da  */
    private String b(JSONObject jSONObject, boolean z) {
        String str;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        r0 = null;
        String str2 = null;
        r0 = null;
        cursor = null;
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = f.a(d).a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor rawQuery = sQLiteDatabase.rawQuery("select *  from __is", null);
                if (rawQuery != null) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        while (rawQuery.moveToNext()) {
                            JSONObject jSONObject2 = new JSONObject();
                            String string = rawQuery.getString(rawQuery.getColumnIndex("__e"));
                            str2 = rawQuery.getString(rawQuery.getColumnIndex("__ii"));
                            this.l.add(str2);
                            String string2 = rawQuery.getString(rawQuery.getColumnIndex("__sp"));
                            String string3 = rawQuery.getString(rawQuery.getColumnIndex("__pp"));
                            if (!TextUtils.isEmpty(string2)) {
                                jSONObject2.put("_$sp", new JSONObject(d(string2)));
                            }
                            if (!TextUtils.isEmpty(string3)) {
                                jSONObject2.put("_$pp", new JSONObject(d(string3)));
                            }
                            if (!TextUtils.isEmpty(string)) {
                                jSONObject2.put("id", str2);
                                jSONObject2.put("start_time", string);
                                if (jSONObject2.length() > 0) {
                                    jSONArray.put(jSONObject2);
                                }
                                if (z) {
                                    break;
                                }
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("sessions", jSONArray);
                        }
                    } catch (SQLiteDatabaseCorruptException unused) {
                        str = null;
                        cursor = rawQuery;
                        g.a(d);
                        if (cursor != null) {
                        }
                    } catch (Throwable unused2) {
                        str = null;
                        cursor2 = rawQuery;
                        try {
                            g.a(d);
                            if (cursor2 != null) {
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused4) {
                    }
                }
                f.a(d).b();
                return str2;
            } catch (SQLiteDatabaseCorruptException unused5) {
                str = null;
                g.a(d);
                if (cursor != null) {
                }
            } catch (Throwable unused6) {
                str = null;
                g.a(d);
                if (cursor2 != null) {
                }
            }
        } catch (SQLiteDatabaseCorruptException unused7) {
            str = null;
            sQLiteDatabase = null;
            g.a(d);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable unused8) {
            str = null;
            sQLiteDatabase = null;
            g.a(d);
            if (cursor2 != null) {
                cursor2.close();
            }
        }
        f.a(d).b();
        return str;
        f.a(d).b();
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (r0 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (0 == 0) goto L_0x006b;
     */
    public void a(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f.a(d).a();
            sQLiteDatabase.beginTransaction();
            if (!z2) {
                int size = this.l.size();
                int i2 = 0;
                if (size > 0) {
                    int i3 = 0;
                    while (i2 < size) {
                        String str = this.l.get(i2);
                        if (str == null) {
                            i3 = 1;
                        }
                        sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
                        i2++;
                    }
                    i2 = i3;
                }
                if (i2 != 0) {
                    sQLiteDatabase.execSQL("delete from __is where __ii is null");
                }
            } else if (z) {
                sQLiteDatabase.execSQL("delete from __is");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteDatabaseCorruptException unused) {
            g.a(d);
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                }
            }
            f.a(d).b();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0050, code lost:
        if (r0 != null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        if (0 == 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        if (0 == 0) goto L_0x0058;
     */
    public void b(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f.a(d).a();
            sQLiteDatabase.beginTransaction();
            if (z2) {
                if (z) {
                    sQLiteDatabase.execSQL("delete from __sd");
                }
            } else if (this.i.size() > 0) {
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + this.i.get(i2) + "\"");
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteDatabaseCorruptException unused) {
            g.a(d);
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                }
            }
            f.a(d).b();
            throw th;
        }
        f.a(d).b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0047, code lost:
        if (0 == 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        if (0 == 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
        if (r0 != null) goto L_0x0049;
     */
    public void h() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f.a(d).a();
            sQLiteDatabase.beginTransaction();
            if (this.j.size() > 0) {
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    sQLiteDatabase.execSQL("delete from __et where rowid=" + this.j.get(i2));
                }
            }
            this.j.clear();
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteDatabaseCorruptException unused) {
            g.a(d);
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                }
            }
            f.a(d).b();
            throw th;
        }
        f.a(d).b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r0 == null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (r0 != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        if (r0 == null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r0.endTransaction();
     */
    public void i() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f.a(d).a();
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("delete from __er");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteDatabaseCorruptException unused) {
            g.a(d);
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                }
            }
            f.a(d).b();
            throw th;
        }
        f.a(d).b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        if (r1 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x004d, code lost:
        if (r1 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0051, code lost:
        if (r1 != null) goto L_0x0053;
     */
    public void j() {
        SQLiteDatabase sQLiteDatabase;
        if (!TextUtils.isEmpty(this.k)) {
            try {
                sQLiteDatabase = f.a(d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("delete from __er where __i=\"" + this.k + "\"");
                    sQLiteDatabase.execSQL("delete from __et where __i=\"" + this.k + "\"");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    try {
                        g.a(d);
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabase = null;
                g.a(d);
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
            }
        }
        this.k = null;
        return;
        f.a(d).b();
        this.k = null;
        return;
        f.a(d).b();
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007a, code lost:
        if (0 == 0) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0063, code lost:
        if (r0 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0066, code lost:
        if (0 == 0) goto L_0x006b;
     */
    public void a(boolean z, String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f.a(d).a();
            sQLiteDatabase.beginTransaction();
            if (!TextUtils.isEmpty(str)) {
                sQLiteDatabase.execSQL("delete from __er where __i=\"" + str + "\"");
                sQLiteDatabase.execSQL("delete from __et where __i=\"" + str + "\"");
                this.j.clear();
                sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + str + "\"");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteDatabaseCorruptException unused) {
            g.a(d);
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                }
            }
            f.a(d).b();
            throw th;
        }
        f.a(d).b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (0 == 0) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0030, code lost:
        if (r0 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0033, code lost:
        if (0 == 0) goto L_0x0038;
     */
    public void b(String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f.a(d).a();
            sQLiteDatabase.beginTransaction();
            if (!TextUtils.isEmpty(str)) {
                sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteDatabaseCorruptException unused) {
            g.a(d);
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                }
            }
            f.a(d).b();
            throw th;
        }
        f.a(d).b();
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(d, "ek__id");
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(d).getString("ek__id", null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(d, "ek__id", multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < substring.length(); i2++) {
                        char charAt = substring.charAt(i2);
                        if (!Character.isDigit(charAt)) {
                            sb.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    e = sb.toString();
                }
                if (!TextUtils.isEmpty(e)) {
                    e += new StringBuilder(e).reverse().toString();
                    String multiProcessSP2 = UMUtils.getMultiProcessSP(d, "ek_key");
                    if (TextUtils.isEmpty(multiProcessSP2)) {
                        UMUtils.setMultiProcessSP(d, "ek_key", c("umeng+"));
                    } else if (!"umeng+".equals(d(multiProcessSP2))) {
                        b(true, false);
                        a(true, false);
                        h();
                        i();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public String d(String str) {
        try {
            if (TextUtils.isEmpty(e)) {
                return str;
            }
            return new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                new JSONObject(str);
                UMRTLog.e("MobclickRT", "--->>> UMStoreManager decrypt failed, return origin data.");
                return str;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }
}
