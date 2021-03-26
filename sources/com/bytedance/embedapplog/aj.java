package com.bytedance.embedapplog;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

class aj extends u {
    aj() {
        super(true, false);
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(16);
        if (a()) {
            sb.append("MIUI-");
        } else if (b()) {
            sb.append("FLYME-");
        } else {
            String d = d();
            if (a(d)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(d)) {
                sb.append(d);
                sb.append("-");
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put("rom", sb.toString());
        return true;
    }

    private boolean a() {
        try {
            if (Class.forName("miui.os.Build").getName().length() > 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean b() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    private boolean c() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = d();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("emotionui")) {
            return c();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[SYNTHETIC, Splitter:B:15:0x002f] */
    private String d() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.emui").getInputStream()), 1024);
            try {
                str = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                try {
                    bo.a(th);
                    return str;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            bo.a(th);
            return str;
        }
    }
}
