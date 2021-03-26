package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fs {
    private static m a = new m(true);
    private static volatile int b = -1;
    private static long c = System.currentTimeMillis();
    private static final Object d = new Object();
    private static List<a> e = Collections.synchronizedList(new ArrayList());
    private static String f = "";
    private static com.xiaomi.push.a.a g = null;

    static class a {
        public String a = "";
        public long b = 0;
        public int c = -1;
        public int d = -1;
        public String e = "";
        public long f = 0;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.a = str;
            this.b = j;
            this.c = i;
            this.d = i2;
            this.e = str2;
            this.f = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.a, this.a) && TextUtils.equals(aVar.e, this.e) && aVar.c == this.c && aVar.d == this.d && Math.abs(aVar.b - this.b) <= 5000;
        }
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = c;
            c = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * ((long) (i == 0 ? 13 : 11))) / 10;
    }

    public static void a(Context context) {
        b = c(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int b2;
        boolean isEmpty;
        if (context != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(context.getPackageName()) && !"com.xiaomi.xmsf".equals(str) && -1 != (b2 = b(context))) {
            synchronized (d) {
                isEmpty = e.isEmpty();
                a(new a(str, j2, b2, z ? 1 : 0, b2 == 0 ? d(context) : "", j));
            }
            if (isEmpty) {
                a.a(new ft(context), 5000);
            }
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(b(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : e) {
            if (aVar2.a(aVar)) {
                aVar2.f += aVar.f;
                return;
            }
        }
        e.add(aVar);
    }

    public static int b(Context context) {
        if (b == -1) {
            b = c(context);
        }
        return b;
    }

    /* access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.a.a.a) {
                SQLiteDatabase writableDatabase = e(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.a);
                        contentValues.put("message_ts", Long.valueOf(aVar.b));
                        contentValues.put("network_type", Integer.valueOf(aVar.c));
                        contentValues.put("bytes", Long.valueOf(aVar.f));
                        contentValues.put("rcv", Integer.valueOf(aVar.d));
                        contentValues.put("imsi", aVar.e);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e2) {
            c.a(e2);
        }
    }

    private static int c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static synchronized String d(Context context) {
        synchronized (fs.class) {
            if (TextUtils.isEmpty(f)) {
                return "";
            }
            return f;
        }
    }

    private static com.xiaomi.push.a.a e(Context context) {
        com.xiaomi.push.a.a aVar = g;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.a.a aVar2 = new com.xiaomi.push.a.a(context);
        g = aVar2;
        return aVar2;
    }
}
