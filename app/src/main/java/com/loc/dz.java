package com.loc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: Cache */
public final class dz {
    Hashtable<String, ArrayList<a>> a = new Hashtable<>();
    boolean b = true;
    long c = 0;
    String d = null;
    dv e = null;
    boolean f = true;
    boolean g = true;
    String h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
    private long i = 0;
    private boolean j = false;
    private String k = "2.0.201501131131".replace(".", "");

    /* renamed from: l  reason: collision with root package name */
    private String f1370l = null;
    private String m = null;
    private long n = 0;

    /* compiled from: Cache */
    static class a {
        private ds a = null;
        private String b = null;

        protected a() {
        }

        public final ds a() {
            return this.a;
        }

        public final void a(ds dsVar) {
            this.a = dsVar;
        }

        public final void a(String str) {
            this.b = TextUtils.isEmpty(str) ? null : str.replace("##", "#");
        }

        public final String b() {
            return this.b;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0101 A[EDGE_INSN: B:106:0x0101->B:50:0x0101 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x018c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f3 A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0107 A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0129 A[LOOP:1: B:54:0x0121->B:57:0x0129, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0142 A[LOOP:2: B:59:0x013c->B:61:0x0142, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01f6  */
    private ds a(String str, StringBuilder sb) {
        a aVar;
        Hashtable hashtable;
        a aVar2;
        a aVar3;
        String str2;
        String str3;
        boolean z;
        a aVar4;
        boolean z2;
        double[] dArr;
        double[] dArr2;
        Iterator it2;
        int i2;
        double[] a2;
        String str4;
        String str5 = "#";
        String str6 = ",access";
        try {
            char c2 = 0;
            if (!str.contains("cgiwifi")) {
                if (!str.contains("wifi")) {
                    if (str.contains("cgi") && this.a.containsKey(str) && this.a.get(str).size() > 0) {
                        aVar = this.a.get(str).get(0);
                        if (aVar == null && ep.a(aVar.a())) {
                            ds a3 = aVar.a();
                            a3.e("mem");
                            a3.h(aVar.b());
                            if (ei.a(a3.getTime())) {
                                if (ep.a(a3)) {
                                    this.c = 0;
                                }
                                a3.setLocationType(4);
                                return a3;
                            }
                            Hashtable<String, ArrayList<a>> hashtable2 = this.a;
                            if (hashtable2 == null || !hashtable2.containsKey(str)) {
                                return null;
                            }
                            this.a.get(str).remove(aVar);
                            return null;
                        }
                    }
                    aVar = null;
                    return aVar == null ? null : null;
                }
            }
            if (!this.a.isEmpty()) {
                if (!TextUtils.isEmpty(sb)) {
                    if (this.a.containsKey(str)) {
                        Hashtable hashtable3 = new Hashtable();
                        Hashtable hashtable4 = new Hashtable();
                        Hashtable hashtable5 = new Hashtable();
                        ArrayList<a> arrayList = this.a.get(str);
                        int i3 = 1;
                        int size = arrayList.size() - 1;
                        while (true) {
                            if (size < 0) {
                                hashtable = hashtable3;
                                aVar2 = null;
                                break;
                            }
                            aVar3 = arrayList.get(size);
                            if (!TextUtils.isEmpty(aVar3.b())) {
                                String b2 = aVar3.b();
                                if (!TextUtils.isEmpty(b2)) {
                                    if (!TextUtils.isEmpty(sb)) {
                                        if (b2.contains(str6)) {
                                            if (sb.indexOf(str6) != -1) {
                                                String[] split = b2.split(str6);
                                                String substring = split[c2].contains(str5) ? split[c2].substring(split[c2].lastIndexOf(str5) + i3) : split[c2];
                                                if (!TextUtils.isEmpty(substring)) {
                                                    z = sb.toString().contains(substring + str6);
                                                    if (!z) {
                                                        z2 = false;
                                                        a(aVar3.b(), hashtable3);
                                                        a(sb.toString(), hashtable4);
                                                        hashtable5.clear();
                                                        while (r13.hasNext()) {
                                                        }
                                                        while (r13.hasNext()) {
                                                        }
                                                        Set keySet = hashtable5.keySet();
                                                        dArr = new double[keySet.size()];
                                                        dArr2 = new double[keySet.size()];
                                                        it2 = keySet.iterator();
                                                        i2 = 0;
                                                        while (it2 != null) {
                                                            str4 = (String) it2.next();
                                                            double d2 = 1.0d;
                                                            dArr[i2] = !hashtable3.containsKey(str4) ? 1.0d : 0.0d;
                                                            if (hashtable4.containsKey(str4)) {
                                                            }
                                                            dArr2[i2] = d2;
                                                            i2++;
                                                        }
                                                        keySet.clear();
                                                        a2 = a(dArr, dArr2);
                                                        if (a2[0] < 0.800000011920929d) {
                                                        }
                                                    } else if (ep.a(aVar3.b(), sb.toString())) {
                                                        break;
                                                    } else {
                                                        z2 = true;
                                                        a(aVar3.b(), hashtable3);
                                                        a(sb.toString(), hashtable4);
                                                        hashtable5.clear();
                                                        for (String str7 : hashtable3.keySet()) {
                                                            hashtable5.put(str7, "");
                                                        }
                                                        for (String str8 : hashtable4.keySet()) {
                                                            hashtable5.put(str8, "");
                                                        }
                                                        Set keySet = hashtable5.keySet();
                                                        dArr = new double[keySet.size()];
                                                        dArr2 = new double[keySet.size()];
                                                        it2 = keySet.iterator();
                                                        i2 = 0;
                                                        while (it2 != null && it2.hasNext()) {
                                                            str4 = (String) it2.next();
                                                            double d2 = 1.0d;
                                                            dArr[i2] = !hashtable3.containsKey(str4) ? 1.0d : 0.0d;
                                                            if (hashtable4.containsKey(str4)) {
                                                                d2 = 0.0d;
                                                            }
                                                            dArr2[i2] = d2;
                                                            i2++;
                                                        }
                                                        keySet.clear();
                                                        a2 = a(dArr, dArr2);
                                                        if (a2[0] < 0.800000011920929d) {
                                                            break;
                                                        }
                                                        aVar4 = aVar3;
                                                        str3 = str5;
                                                        str2 = str6;
                                                        if (a2[1] >= Math.min(ei.g(), 0.618d)) {
                                                            hashtable = hashtable3;
                                                            break;
                                                        } else if (z2) {
                                                            double d3 = a2[0];
                                                            hashtable = hashtable3;
                                                            if (d3 >= Math.min(ei.g(), 0.618d)) {
                                                                break;
                                                            }
                                                            size--;
                                                            hashtable3 = hashtable;
                                                            str5 = str3;
                                                            str6 = str2;
                                                            c2 = 0;
                                                            i3 = 1;
                                                        }
                                                    }
                                                }
                                            }
                                            z = false;
                                            if (!z) {
                                            }
                                        }
                                    }
                                }
                                z = false;
                                if (!z) {
                                }
                            } else {
                                str3 = str5;
                                str2 = str6;
                            }
                            hashtable = hashtable3;
                            size--;
                            hashtable3 = hashtable;
                            str5 = str3;
                            str6 = str2;
                            c2 = 0;
                            i3 = 1;
                        }
                        hashtable = hashtable3;
                        aVar4 = aVar3;
                        aVar2 = aVar4;
                        hashtable.clear();
                        hashtable4.clear();
                        hashtable5.clear();
                        aVar = aVar2;
                        if (aVar == null) {
                        }
                    }
                }
            }
            aVar = null;
            if (aVar == null) {
            }
        } catch (Throwable th) {
            ej.a(th, "Cache", "get1");
            return null;
        }
    }

    private String a(String str, StringBuilder sb, Context context) {
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f1370l == null) {
            this.f1370l = dy.a("MD5", k.c(context));
        }
        if (str.contains("&")) {
            str = str.substring(0, str.indexOf("&"));
        }
        String substring = str.substring(str.lastIndexOf("#") + 1);
        if (substring.equals("cgi")) {
            jSONObject.put("cgi", str.substring(0, str.length() - 12));
        } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
            jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
            String[] split = sb.toString().split(",access");
            jSONObject.put("mmac", split[0].contains("#") ? split[0].substring(split[0].lastIndexOf("#") + 1) : split[0]);
        }
        try {
            return o.b(dy.a(jSONObject.toString().getBytes("UTF-8"), this.f1370l));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0242 A[EDGE_INSN: B:110:0x0242->B:76:0x0242 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0252 A[LOOP:0: B:33:0x00b0->B:77:0x0252, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x027e A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0283 A[DONT_GENERATE] */
    private void a(Context context, String str) throws Exception {
        Cursor cursor;
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        if (ei.e() && context != null) {
            SQLiteDatabase sQLiteDatabase2 = null;
            int i2 = 0;
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                try {
                    if (ep.a(openOrCreateDatabase, "hist")) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("time >");
                        sb3.append(ep.a() - ei.d());
                        if (str != null) {
                            sb3.append(" and feature = '");
                            sb3.append(str + "'");
                        }
                        StringBuilder sb4 = sb3;
                        cursor = openOrCreateDatabase.query("hist" + this.k, new String[]{"feature", " nb", "loc"}, sb3.toString(), null, null, null, "time ASC", null);
                        try {
                            StringBuilder sb5 = new StringBuilder();
                            if (this.f1370l == null) {
                                try {
                                    this.f1370l = dy.a("MD5", k.c(context));
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            if (cursor == null || !cursor.moveToFirst()) {
                                sQLiteDatabase = openOrCreateDatabase;
                            } else {
                                while (true) {
                                    String str3 = ",access";
                                    if (cursor.getString(i2).startsWith("{")) {
                                        jSONObject2 = new JSONObject(cursor.getString(i2));
                                        sb5.delete(i2, sb5.length());
                                        if (!TextUtils.isEmpty(cursor.getString(1))) {
                                            str3 = cursor.getString(1);
                                        } else {
                                            if (ep.a(jSONObject2, "mmac")) {
                                                sb5.append("#");
                                                sb5.append(jSONObject2.getString("mmac"));
                                            }
                                            jSONObject = new JSONObject(cursor.getString(2));
                                            if (ep.a(jSONObject, "type")) {
                                                jSONObject.put("type", "new");
                                            }
                                        }
                                        sb5.append(str3);
                                        jSONObject = new JSONObject(cursor.getString(2));
                                        if (ep.a(jSONObject, "type")) {
                                        }
                                    } else {
                                        JSONObject jSONObject3 = new JSONObject(new String(dy.b(o.b(cursor.getString(i2)), this.f1370l), "UTF-8"));
                                        sb5.delete(0, sb5.length());
                                        if (!TextUtils.isEmpty(cursor.getString(1))) {
                                            str3 = new String(dy.b(o.b(cursor.getString(1)), this.f1370l), "UTF-8");
                                        } else {
                                            if (ep.a(jSONObject3, "mmac")) {
                                                sb5.append("#");
                                                sb5.append(jSONObject3.getString("mmac"));
                                            }
                                            jSONObject = new JSONObject(new String(dy.b(o.b(cursor.getString(2)), this.f1370l), "UTF-8"));
                                            if (ep.a(jSONObject, "type")) {
                                                jSONObject.put("type", "new");
                                            }
                                            jSONObject2 = jSONObject3;
                                        }
                                        sb5.append(str3);
                                        jSONObject = new JSONObject(new String(dy.b(o.b(cursor.getString(2)), this.f1370l), "UTF-8"));
                                        if (ep.a(jSONObject, "type")) {
                                        }
                                        jSONObject2 = jSONObject3;
                                    }
                                    ds dsVar = new ds("");
                                    dsVar.b(jSONObject);
                                    if (!ep.a(jSONObject2, "mmac") || !ep.a(jSONObject2, "cgi")) {
                                        if (ep.a(jSONObject2, "cgi")) {
                                            String str4 = (jSONObject2.getString("cgi") + "#") + "network#";
                                            if (jSONObject2.getString("cgi").contains("#")) {
                                                str2 = str4 + "cgi";
                                            }
                                        }
                                        sb = sb4;
                                        sQLiteDatabase = openOrCreateDatabase;
                                        if (cursor.moveToNext()) {
                                            break;
                                        }
                                        sb4 = sb;
                                        openOrCreateDatabase = sQLiteDatabase;
                                        i2 = 0;
                                    } else {
                                        String str5 = (jSONObject2.getString("cgi") + "#") + "network#";
                                        if (jSONObject2.getString("cgi").contains("#")) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str5);
                                            sb2.append("cgiwifi");
                                        } else {
                                            sb2 = new StringBuilder();
                                            sb2.append(str5);
                                            sb2.append("wifi");
                                        }
                                        str2 = sb2.toString();
                                    }
                                    sb = sb4;
                                    sQLiteDatabase = openOrCreateDatabase;
                                    try {
                                        a(str2, sb5, dsVar, context, false);
                                        if (cursor.moveToNext()) {
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sQLiteDatabase2 = sQLiteDatabase;
                                        ej.a(th, "DB", "fetchHist p2");
                                        if (sQLiteDatabase2 == null) {
                                            return;
                                        }
                                    }
                                }
                                sb5.delete(0, sb5.length());
                                sb.delete(0, sb.length());
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            sQLiteDatabase = openOrCreateDatabase;
                            sQLiteDatabase2 = sQLiteDatabase;
                            ej.a(th, "DB", "fetchHist p2");
                        }
                    } else if (openOrCreateDatabase != null) {
                        try {
                            if (openOrCreateDatabase.isOpen()) {
                                openOrCreateDatabase.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            cursor = null;
                            sQLiteDatabase2 = openOrCreateDatabase;
                            try {
                                ej.a(th, "DB", "fetchHist p2");
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                                    sQLiteDatabase2.close();
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    sQLiteDatabase = openOrCreateDatabase;
                    cursor = null;
                    sQLiteDatabase2 = sQLiteDatabase;
                    ej.a(th, "DB", "fetchHist p2");
                }
            } catch (Throwable th7) {
                th = th7;
                cursor = null;
                ej.a(th, "DB", "fetchHist p2");
            }
        }
    }

    private void a(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context != null) {
            if (this.f1370l == null) {
                this.f1370l = dy.a("MD5", k.c(context));
            }
            String a2 = a(str, sb, context);
            StringBuilder sb2 = new StringBuilder();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                sb2.append("CREATE TABLE IF NOT EXISTS hist");
                sb2.append(this.k);
                sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
                openOrCreateDatabase.execSQL(sb2.toString());
                sb2.delete(0, sb2.length());
                sb2.append("REPLACE INTO ");
                sb2.append("hist");
                sb2.append(this.k);
                sb2.append(" VALUES (?, ?, ?, ?)");
                byte[] a3 = dy.a(sb.toString().getBytes("UTF-8"), this.f1370l);
                Object[] objArr = {a2, a3, dy.a(aMapLocation.toStr().getBytes("UTF-8"), this.f1370l), Long.valueOf(aMapLocation.getTime())};
                for (int i2 = 1; i2 < 3; i2++) {
                    objArr[i2] = o.b((byte[]) objArr[i2]);
                }
                openOrCreateDatabase.execSQL(sb2.toString(), objArr);
                sb2.delete(0, sb2.length());
                sb2.delete(0, sb2.length());
                if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                    openOrCreateDatabase.close();
                }
            } catch (Throwable th) {
                sb2.delete(0, sb2.length());
                if (0 != 0 && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        if (!TextUtils.isEmpty(str)) {
            hashtable.clear();
            String[] split = str.split("#");
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                    hashtable.put(str2, "");
                }
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0045: APUT  
      (r1v1 double[])
      (0 ??[int, short, byte, char])
      (wrap: double : 0x0044: ARITH  (r2v2 double) = (r2v1 double) / (wrap: double : 0x0042: ARITH  (r5v3 double) = (wrap: double : 0x003a: INVOKE  (r5v2 double) = (r5v1 double) type: STATIC call: java.lang.Math.sqrt(double):double) * (wrap: double : 0x003e: INVOKE  (r7v2 double) = (r7v1 double) type: STATIC call: java.lang.Math.sqrt(double):double)))
     */
    private static double[] a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < dArr.length; i4++) {
            d3 += dArr[i4] * dArr[i4];
            d4 += dArr2[i4] * dArr2[i4];
            d2 += dArr[i4] * dArr2[i4];
            if (dArr2[i4] == 1.0d) {
                i3++;
                if (dArr[i4] == 1.0d) {
                    i2++;
                }
            }
        }
        dArr3[0] = d2 / (Math.sqrt(d3) * Math.sqrt(d4));
        double d5 = (double) i2;
        dArr3[1] = (d5 * 1.0d) / ((double) i3);
        dArr3[2] = d5;
        for (int i5 = 0; i5 < 2; i5++) {
            if (dArr3[i5] > 1.0d) {
                dArr3[i5] = 1.0d;
            }
        }
        return dArr3;
    }

    private boolean b() {
        long b2 = ep.b();
        long j2 = this.i;
        long j3 = b2 - j2;
        if (j2 == 0) {
            return false;
        }
        return this.a.size() > 360 || j3 > 36000000;
    }

    private void c() {
        this.i = 0;
        if (!this.a.isEmpty()) {
            this.a.clear();
        }
        this.j = false;
    }

    public final ds a(Context context, String str, StringBuilder sb, boolean z) {
        if (TextUtils.isEmpty(str) || !ei.e()) {
            return null;
        }
        String str2 = str + "&" + this.f + "&" + this.g + "&" + this.h;
        if (str2.contains("gps") || !ei.e() || sb == null) {
            return null;
        }
        if (b()) {
            c();
            return null;
        }
        if (z && !this.j) {
            try {
                String a2 = a(str2, sb, context);
                c();
                a(context, a2);
            } catch (Throwable unused) {
            }
        }
        if (this.a.isEmpty()) {
            return null;
        }
        return a(str2, sb);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0052 A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0071 A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ac A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b3 A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b9 A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00da A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00df A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e8 A[ADDED_TO_REGION, Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f6 A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0100 A[Catch:{ all -> 0x010d }] */
    public final ds a(dw dwVar, boolean z, ds dsVar, dx dxVar, StringBuilder sb, String str, Context context, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        String str2;
        String str3;
        long a2;
        String str4;
        boolean z6 = true;
        if (!(((ei.e() || z2) && (this.b || ei.f() || z2)) && (dsVar == null || ei.a(dsVar.getTime()) || z2))) {
            return null;
        }
        try {
            dv d2 = dwVar.d();
            if (!(d2 == null && this.e == null)) {
                dv dvVar = this.e;
                if (dvVar != null) {
                    if (!dvVar.equals(d2)) {
                    }
                }
                z3 = true;
                if (dsVar != null) {
                    int size = dxVar.e().size();
                    if (dsVar.getAccuracy() > 299.0f && size > 5) {
                        z4 = true;
                        if (dsVar != null || (str4 = this.d) == null || z4 || z3) {
                            z5 = false;
                        } else {
                            z5 = ep.a(str4, sb.toString());
                            boolean z7 = this.c != 0 && ep.b() - this.c < 3000;
                            if ((z5 || z7) && ep.a(dsVar)) {
                                dsVar.e("mem");
                                dsVar.setLocationType(2);
                                return dsVar;
                            }
                        }
                        if (!z5) {
                            this.c = ep.b();
                        } else {
                            this.c = 0;
                        }
                        str2 = this.m;
                        if (str2 != null || str.equals(str2)) {
                            if (this.m == null) {
                                a2 = ep.a();
                            } else {
                                this.n = ep.a();
                                str3 = str;
                                ds a3 = (!z4 || z) ? null : a(context, str3, sb, false);
                                if (!z || ep.a(a3)) {
                                    z6 = false;
                                }
                                if (!z6) {
                                    if (!z4) {
                                        if (z) {
                                            return null;
                                        }
                                        this.c = 0;
                                        a3.setLocationType(4);
                                        return a3;
                                    }
                                }
                                return null;
                            }
                        } else if (ep.a() - this.n < 3000) {
                            str3 = this.m;
                            if (!z4) {
                            }
                            if (!z) {
                            }
                            z6 = false;
                            if (!z6) {
                            }
                            return null;
                        } else {
                            a2 = ep.a();
                        }
                        this.n = a2;
                        this.m = str;
                        str3 = str;
                        if (!z4) {
                        }
                        if (!z) {
                        }
                        z6 = false;
                        if (!z6) {
                        }
                        return null;
                    }
                }
                z4 = false;
                if (dsVar != null) {
                }
                z5 = false;
                if (!z5) {
                }
                str2 = this.m;
                if (str2 != null) {
                }
                if (this.m == null) {
                }
            }
            z3 = false;
            if (dsVar != null) {
            }
            z4 = false;
            if (dsVar != null) {
            }
            z5 = false;
            if (!z5) {
            }
            str2 = this.m;
            if (str2 != null) {
            }
            if (this.m == null) {
            }
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        this.c = 0;
        this.d = null;
    }

    public final void a(Context context) {
        if (!this.j) {
            try {
                c();
                a(context, (String) null);
            } catch (Throwable th) {
                ej.a(th, "Cache", "loadDB");
            }
            this.j = true;
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.g = aMapLocationClientOption.isNeedAddress();
        this.f = aMapLocationClientOption.isOffset();
        this.b = aMapLocationClientOption.isLocationCacheEnable();
        this.h = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void a(dv dvVar) {
        this.e = dvVar;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(String str, StringBuilder sb, ds dsVar, Context context, boolean z) {
        try {
            if (ep.a(dsVar)) {
                String str2 = str + "&" + dsVar.isOffset() + "&" + dsVar.i() + "&" + dsVar.j();
                if (((TextUtils.isEmpty(str2) || !ep.a(dsVar) || str2.startsWith("#")) ? false : str2.contains("network")) && !dsVar.e().equals("mem") && !dsVar.e().equals("file") && !dsVar.e().equals("wifioff") && !"-3".equals(dsVar.d())) {
                    if (b()) {
                        c();
                    }
                    JSONObject f2 = dsVar.f();
                    if (ep.a(f2, "offpct")) {
                        f2.remove("offpct");
                        dsVar.a(f2);
                    }
                    if (str2.contains("wifi")) {
                        if (!TextUtils.isEmpty(sb)) {
                            if (dsVar.getAccuracy() >= 300.0f) {
                                int i2 = 0;
                                for (String str3 : sb.toString().split("#")) {
                                    if (str3.contains(",")) {
                                        i2++;
                                    }
                                }
                                if (i2 >= 8) {
                                    return;
                                }
                            } else if (dsVar.getAccuracy() <= 3.0f) {
                                return;
                            }
                            if (str2.contains("cgiwifi") && !TextUtils.isEmpty(dsVar.g())) {
                                String replace = str2.replace("cgiwifi", "cgi");
                                ds h2 = dsVar.h();
                                if (ep.a(h2)) {
                                    a(replace, new StringBuilder(), h2, context, true);
                                }
                            }
                        } else {
                            return;
                        }
                    } else if (str2.contains("cgi") && (!(sb == null || sb.indexOf(",") == -1) || "4".equals(dsVar.d()))) {
                        return;
                    }
                    ds a2 = a(str2, sb);
                    if (!ep.a(a2) || !a2.toStr().equals(dsVar.toStr(3))) {
                        this.i = ep.b();
                        a aVar = new a();
                        aVar.a(dsVar);
                        aVar.a(TextUtils.isEmpty(sb) ? null : sb.toString());
                        if (this.a.containsKey(str2)) {
                            this.a.get(str2).add(aVar);
                        } else {
                            ArrayList<a> arrayList = new ArrayList<>();
                            arrayList.add(aVar);
                            this.a.put(str2, arrayList);
                        }
                        if (z) {
                            try {
                                a(str2, dsVar, sb, context);
                            } catch (Throwable th) {
                                ej.a(th, "Cache", "add");
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            ej.a(th2, "Cache", "add");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        if (r11.isOpen() != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0078, code lost:
        if (r11.isOpen() != false) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074  */
    public final void b(Context context) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        try {
            c();
            if (context != null) {
                try {
                    sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                    try {
                        if (ep.a(sQLiteDatabase, "hist")) {
                            try {
                                sQLiteDatabase.delete("hist" + this.k, "time<?", new String[]{String.valueOf(ep.a() - 86400000)});
                            } catch (Throwable th2) {
                                ej.a(th2, "DB", "clearHist");
                                String message = th2.getMessage();
                                if (!TextUtils.isEmpty(message)) {
                                    message.contains("no such table");
                                }
                            }
                            if (sQLiteDatabase != null) {
                            }
                        } else if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            ej.a(th, "DB", "clearHist p2");
                            if (sQLiteDatabase != null) {
                            }
                            this.j = false;
                            this.d = null;
                            this.n = 0;
                        } catch (Throwable th4) {
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = null;
                    ej.a(th, "DB", "clearHist p2");
                    if (sQLiteDatabase != null) {
                    }
                    this.j = false;
                    this.d = null;
                    this.n = 0;
                }
            }
            this.j = false;
            this.d = null;
            this.n = 0;
        } catch (Throwable th6) {
            ej.a(th6, "Cache", "destroy part");
        }
    }
}
