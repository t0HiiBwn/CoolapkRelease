package com.bytedance.sdk.adnet.d;

import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.face.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* compiled from: HttpHeaderParser */
public class b {
    public static a.C0035a a(i iVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = iVar.c;
        String str = map.get("Date");
        long a = str != null ? a(str) : 0;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            int i2 = 0;
            j2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j = 0;
        }
        String str3 = map.get("Expires");
        long a2 = str3 != null ? a(str3) : 0;
        String str4 = map.get("Last-Modified");
        long a3 = str4 != null ? a(str4) : 0;
        String str5 = map.get("ETag");
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i != 0) {
                j5 = j4;
            } else {
                Long.signum(j);
                j5 = (j * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (a <= 0 || a2 < a) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (a2 - a);
                j3 = j4;
            }
        }
        a.C0035a aVar = new a.C0035a();
        aVar.a = iVar.a;
        aVar.b = iVar.b;
        aVar.c = str5;
        aVar.g = j4;
        aVar.f = j3;
        aVar.d = a;
        aVar.e = a3;
        aVar.h = map;
        aVar.i = iVar.d;
        return aVar;
    }

    public static long a(String str) {
        try {
            return a().parse(str).getTime();
        } catch (Throwable th) {
            o.a(th, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static String a(long j) {
        return a().format(new Date(j));
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static String a(Map<String, String> map) {
        return a(map, "UTF-8");
    }

    public static Map<String, String> a(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        if (list != null) {
            for (Header header : list) {
                treeMap.put(header.getName(), header.getValue());
            }
        }
        return treeMap;
    }

    public static List<Header> b(Map<String, String> map) {
        if (map == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
