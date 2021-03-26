package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.tea.crash.b.a;
import com.bytedance.tea.crash.c.c;
import com.bytedance.tea.crash.g.h;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.upload.b;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* compiled from: CrashFileCollector */
public final class d {
    private Context a;

    public d(Context context) {
        this.a = context;
    }

    public void a(boolean z) {
        a();
        if (z) {
            b();
        }
    }

    private void a() {
        try {
            SharedPreferences sharedPreferences = this.a.getSharedPreferences("npth", 0);
            long j = sharedPreferences.getLong("history_time", -1);
            if (j < 0) {
                sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                com.bytedance.tea.crash.g.d.a(h.b(this.a));
                sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b() {
        File[] a2 = a(h.a(this.a), ".npth");
        if (a2 != null) {
            Arrays.sort(a2, Collections.reverseOrder());
            int i = 0;
            while (i < a2.length && i < 50) {
                File file = a2[i];
                try {
                    if (a.a().a(file.getAbsolutePath())) {
                        com.bytedance.tea.crash.g.d.a(file);
                    } else {
                        c c = com.bytedance.tea.crash.g.d.c(file.getAbsolutePath());
                        if (!(c == null || c.b() == null)) {
                            JSONObject b = c.b();
                            a(file.getName(), b);
                            c.b().put("upload_scene", "launch_scan");
                            if (b.a(c.a(), b.toString(), c.c()).a() && !com.bytedance.tea.crash.g.d.a(file)) {
                                a.a().a(com.bytedance.tea.crash.b.a.a.a(file.getAbsolutePath()));
                            }
                        }
                    }
                } catch (Exception e) {
                    j.b(e);
                }
                i++;
            }
        }
    }

    private com.bytedance.tea.crash.c a(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return com.bytedance.tea.crash.c.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return com.bytedance.tea.crash.c.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return com.bytedance.tea.crash.c.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return com.bytedance.tea.crash.c.JAVA;
            }
        }
        return null;
    }

    private File[] a(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return file.listFiles();
        }
        return file.listFiles(new FilenameFilter() {
            /* class com.bytedance.tea.crash.e.d.AnonymousClass1 */

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str != null && str.endsWith(".npth");
            }
        });
    }
}
