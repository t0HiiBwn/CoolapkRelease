package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gn {
    private static volatile int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f507a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static al f508a = new al(true);

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f509a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final Object f510a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static String f511a = "";

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f512a = Collections.synchronizedList(new ArrayList());

    static class a {
        public int a = -1;

        /* renamed from: a  reason: collision with other field name */
        public long f513a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f514a = "";
        public int b = -1;

        /* renamed from: b  reason: collision with other field name */
        public long f515b = 0;

        /* renamed from: b  reason: collision with other field name */
        public String f516b = "";

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f514a = str;
            this.f513a = j;
            this.a = i;
            this.b = i2;
            this.f516b = str2;
            this.f515b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f514a, this.f514a) && TextUtils.equals(aVar.f516b, this.f516b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f513a - this.f513a) <= 5000;
        }
    }

    public static int a(Context context) {
        if (a == -1) {
            a = b(context);
        }
        return a;
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
            long j3 = f507a;
            f507a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * ((long) (i == 0 ? 13 : 11))) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m371a(Context context) {
        com.xiaomi.push.providers.a aVar = f509a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f509a = aVar2;
        return aVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m372a(Context context) {
        synchronized (gn.class) {
            if (TextUtils.isEmpty(f511a)) {
                return "";
            }
            return f511a;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m373a(Context context) {
        a = b(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(context.getPackageName()) && !"com.xiaomi.xmsf".equals(str) && -1 != (a2 = a(context))) {
            synchronized (f510a) {
                isEmpty = f512a.isEmpty();
                a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m372a(context) : "", j));
            }
            if (isEmpty) {
                f508a.a(new go(context), 5000);
            }
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f512a) {
            if (aVar2.a(aVar)) {
                aVar2.f515b += aVar.f515b;
                return;
            }
        }
        f512a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m374a(String str) {
        synchronized (gn.class) {
            if (!l.d() && !TextUtils.isEmpty(str)) {
                f511a = str;
            }
        }
    }

    private static int b(Context context) {
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

    /* access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f893a) {
                SQLiteDatabase writableDatabase = m371a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f514a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f513a));
                        contentValues.put("network_type", Integer.valueOf(aVar.a));
                        contentValues.put("bytes", Long.valueOf(aVar.f515b));
                        contentValues.put("rcv", Integer.valueOf(aVar.b));
                        contentValues.put("imsi", aVar.f516b);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e) {
            b.a(e);
        }
    }
}
