package com.xiaomi.b.c;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.al;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class d implements b {
    protected Context a;
    private HashMap<String, HashMap<String, com.xiaomi.b.a.d>> b;

    public d(Context context) {
        this.a = context;
    }

    public static String a(com.xiaomi.b.a.d dVar) {
        return String.valueOf(dVar.e) + "#" + dVar.f;
    }

    private String c(com.xiaomi.b.a.d dVar) {
        String str;
        int i = dVar.e;
        String str2 = dVar.f;
        if (i <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i) + "#" + str2;
        }
        File externalFilesDir = this.a.getExternalFilesDir("perf");
        if (externalFilesDir == null) {
            c.d("cannot get folder when to write perf");
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return new File(externalFilesDir, str).getAbsolutePath();
    }

    private String d(com.xiaomi.b.a.d dVar) {
        String c = c(dVar);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        for (int i = 0; i < 20; i++) {
            String str = c + i;
            if (al.b(this.a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // com.xiaomi.b.c.e
    public void a() {
        al.a(this.a, "perf", "perfUploading");
        File[] c = al.c(this.a, "perfUploading");
        if (c != null && c.length > 0) {
            for (File file : c) {
                if (file != null) {
                    List<String> a2 = g.a(this.a, file.getAbsolutePath());
                    file.delete();
                    a(a2);
                }
            }
        }
    }

    @Override // com.xiaomi.b.c.b
    public void a(HashMap<String, HashMap<String, com.xiaomi.b.a.d>> hashMap) {
        this.b = hashMap;
    }

    public void a(List<String> list) {
        al.a(this.a, list);
    }

    public void a(com.xiaomi.b.a.d[] dVarArr) {
        String d = d(dVarArr[0]);
        if (!TextUtils.isEmpty(d)) {
            g.a(d, dVarArr);
        }
    }

    @Override // com.xiaomi.b.c.f
    public void b() {
        HashMap<String, HashMap<String, com.xiaomi.b.a.d>> hashMap = this.b;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str : this.b.keySet()) {
                    HashMap<String, com.xiaomi.b.a.d> hashMap2 = this.b.get(str);
                    if (hashMap2 != null && hashMap2.size() > 0) {
                        com.xiaomi.b.a.d[] dVarArr = new com.xiaomi.b.a.d[hashMap2.size()];
                        hashMap2.values().toArray(dVarArr);
                        a(dVarArr);
                    }
                }
            }
            this.b.clear();
        }
    }

    @Override // com.xiaomi.b.c.f
    public void b(com.xiaomi.b.a.d dVar) {
        if ((dVar instanceof com.xiaomi.b.a.c) && this.b != null) {
            com.xiaomi.b.a.c cVar = (com.xiaomi.b.a.c) dVar;
            String a2 = a(cVar);
            String a3 = g.a(cVar);
            HashMap<String, com.xiaomi.b.a.d> hashMap = this.b.get(a2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            com.xiaomi.b.a.c cVar2 = (com.xiaomi.b.a.c) hashMap.get(a3);
            if (cVar2 != null) {
                cVar.b += cVar2.b;
                cVar.c += cVar2.c;
            }
            hashMap.put(a3, cVar);
            this.b.put(a2, hashMap);
        }
    }
}
