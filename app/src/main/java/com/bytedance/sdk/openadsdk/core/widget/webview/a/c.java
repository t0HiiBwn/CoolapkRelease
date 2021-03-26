package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.multipro.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: TmplDbHelper */
class c {
    private static volatile c a;
    private Set<String> b = Collections.synchronizedSet(new HashSet());
    private Object c = new Object();
    private LruCache<String, r> d = new LruCache<String, r>(2000) {
        /* class com.bytedance.sdk.openadsdk.core.widget.webview.a.c.AnonymousClass1 */

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, r rVar) {
            return 1;
        }
    };

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    private c() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bb, code lost:
        if (r12 != null) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bd, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c9, code lost:
        if (r12 == null) goto L_0x00d3;
     */
    r a(String str) {
        r rVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.c) {
            rVar = this.d.get(String.valueOf(str));
        }
        if (rVar != null) {
            return rVar;
        }
        Cursor a2 = a.a(p.a(), "template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (a2 != null) {
            try {
                if (a2.moveToNext()) {
                    String string = a2.getString(a2.getColumnIndex("rit"));
                    String string2 = a2.getString(a2.getColumnIndex("id"));
                    String string3 = a2.getString(a2.getColumnIndex("md5"));
                    String string4 = a2.getString(a2.getColumnIndex("url"));
                    String string5 = a2.getString(a2.getColumnIndex("data"));
                    r a3 = new r().a(string).b(string2).c(string3).d(string4).e(string5).f(a2.getString(a2.getColumnIndex("version"))).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time"))));
                    synchronized (this.c) {
                        this.d.put(string2, a3);
                    }
                    this.b.add(string2);
                    if (a2 != null) {
                        a2.close();
                    }
                    return a3;
                }
            } catch (Throwable th) {
                if (a2 != null) {
                    a2.close();
                }
                throw th;
            }
        }
        return null;
    }

    Set<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor a2 = a.a(p.a(), "template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (a2 == null) {
            return null;
        }
        while (a2.moveToNext()) {
            try {
                hashSet.add(a2.getString(a2.getColumnIndex("id")));
            } finally {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        return hashSet;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.d.r> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a8, code lost:
        if (r1 != null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00aa, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b6, code lost:
        if (r1 == null) goto L_0x00c0;
     */
    List<r> b() {
        ArrayList arrayList = new ArrayList();
        Cursor a2 = a.a(p.a(), "template_diff_new", null, null, null, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    String string = a2.getString(a2.getColumnIndex("rit"));
                    String string2 = a2.getString(a2.getColumnIndex("id"));
                    String string3 = a2.getString(a2.getColumnIndex("md5"));
                    String string4 = a2.getString(a2.getColumnIndex("url"));
                    String string5 = a2.getString(a2.getColumnIndex("data"));
                    String string6 = a2.getString(a2.getColumnIndex("version"));
                    arrayList.add(new r().a(string).b(string2).c(string3).d(string4).e(string5).f(string6).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time")))));
                    synchronized (this.c) {
                        this.d.put(string2, arrayList.get(arrayList.size() - 1));
                    }
                    this.b.add(string2);
                } catch (Throwable th) {
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }

    void a(r rVar) {
        if (rVar != null && !TextUtils.isEmpty(rVar.b())) {
            Cursor a2 = a.a(p.a(), "template_diff_new", null, "id=?", new String[]{rVar.b()}, null, null, null);
            boolean z = a2 != null && a2.getCount() > 0;
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Throwable unused) {
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("rit", rVar.a());
            contentValues.put("id", rVar.b());
            contentValues.put("md5", rVar.c());
            contentValues.put("url", rVar.d());
            contentValues.put("data", rVar.e());
            contentValues.put("version", rVar.f());
            contentValues.put("update_time", rVar.g());
            if (z) {
                a.a(p.a(), "template_diff_new", contentValues, "id=?", new String[]{rVar.b()});
            } else {
                a.a(p.a(), "template_diff_new", contentValues);
            }
            synchronized (this.c) {
                this.d.put(rVar.b(), rVar);
            }
            this.b.add(rVar.b());
        }
    }

    void a(Set<String> set) {
        if (!(set == null || set.isEmpty())) {
            String[] strArr = (String[]) set.toArray(new String[set.size()]);
            if (strArr.length > 0) {
                for (int i = 0; i < strArr.length; i++) {
                    c(strArr[i]);
                    a.a(p.a(), "template_diff_new", "id=?", new String[]{strArr[i]});
                }
            }
        }
    }

    private void c(String str) {
        LruCache<String, r> lruCache;
        if (!TextUtils.isEmpty(str) && (lruCache = this.d) != null && lruCache.size() > 0) {
            synchronized (this.c) {
                this.d.remove(str);
            }
        }
    }

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }
}
