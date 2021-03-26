package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SPMultiHelper */
public class a {
    private static Context a;

    public static boolean a() {
        if (a != null && p.a() != null) {
            return true;
        }
        u.b("The context of SPHelper is null, please initialize sdk in main process");
        return false;
    }

    private static ContentResolver b() {
        try {
            if (a()) {
                return c().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context) {
        a = context == null ? p.a() : context.getApplicationContext();
    }

    private static Context c() {
        Context context = a;
        return context == null ? p.a() : context;
    }

    private static String d() {
        return e.b + "/t_sp/";
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=" + str;
    }

    public static synchronized void a(String str, Boolean bool) {
        synchronized (a.class) {
            a((String) null, str, bool);
        }
    }

    public static synchronized void a(String str, String str2, Boolean bool) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "boolean/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", bool);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (a.class) {
            a((String) null, str, str2);
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "string/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", str3);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, Integer num) {
        synchronized (a.class) {
            a((String) null, str, num);
        }
    }

    public static synchronized void a(String str, String str2, Integer num) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "int/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", num);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, Long l) {
        synchronized (a.class) {
            a((String) null, str, l);
        }
    }

    public static synchronized void a(String str, String str2, Long l) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "long/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", l);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Float f) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "float/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", f);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Set<String> set) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "string_set/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        HashSet hashSet = new HashSet();
                        for (String str3 : set) {
                            hashSet.add(str3.replace(",", "__COMMA__"));
                        }
                        contentValues.put("value", hashSet.toString());
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String b(String str, String str2) {
        return b((String) null, str, str2);
    }

    public static String b(String str, String str2, String str3) {
        if (!a()) {
            return str3;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "string/" + str2 + b(str)));
                if (type != null && !type.equals("null")) {
                    return type;
                }
            }
        } catch (Throwable unused) {
        }
        return str3;
    }

    public static int a(String str, String str2, int i) {
        if (!a()) {
            return i;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "int/" + str2 + b(str)));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Integer.parseInt(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static float a(String str, String str2, float f) {
        if (!a()) {
            return f;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "float/" + str2 + b(str)));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Float.parseFloat(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    public static boolean a(String str, boolean z) {
        return a((String) null, str, z);
    }

    public static boolean a(String str, String str2, boolean z) {
        if (!a()) {
            return z;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "boolean/" + str2 + b(str)));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Boolean.parseBoolean(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long a(String str, long j) {
        return a((String) null, str, j);
    }

    public static long a(String str, String str2, long j) {
        if (!a()) {
            return j;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "long/" + str2 + b(str)));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Long.parseLong(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static Set<String> b(String str, String str2, Set<String> set) {
        if (!a()) {
            return set;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "string_set/" + str2 + b(str)));
                if (type != null) {
                    if (!type.equals("null")) {
                        if (!type.matches("\\[.*\\]")) {
                            return set;
                        }
                        String[] split = type.substring(1, type.length() - 1).split(", ");
                        HashSet hashSet = new HashSet();
                        for (String str3 : split) {
                            hashSet.add(str3.replace("__COMMA__", ", "));
                        }
                        return hashSet;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return set;
    }

    public static void c(String str, String str2) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    b.delete(Uri.parse(d() + "long/" + str2 + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    b.delete(Uri.parse(d() + "clean" + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
