package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class f {
    private static Map<String, f> a = Collections.synchronizedMap(new HashMap());
    private static String b = null;
    private Context c = null;
    private String d = null;
    private JSONObject e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    public static f a(Context context, String str) {
        f fVar;
        synchronized (a) {
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                b = str;
            }
            if (str == null) {
                str = b;
                if (str == null) {
                    str = "0";
                }
            }
            fVar = a.get(str);
            if (fVar == null) {
                fVar = new f(context, str);
                a.put(str, fVar);
            }
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return fVar;
    }

    private f(Context context, String str) {
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    private void a() {
        try {
            this.e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.e = new JSONObject();
        }
    }

    private String c(String str) {
        InputStream inputStream;
        String str2;
        String str3 = "";
        try {
            if (this.d != null) {
                str2 = str + "." + this.d;
            } else {
                str2 = str;
            }
            inputStream = this.c.openFileInput(str2);
        } catch (FileNotFoundException unused) {
            try {
                inputStream = this.c.getAssets().open(str);
            } catch (IOException e2) {
                e2.printStackTrace();
                return str3;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            } catch (IOException e3) {
                e3.printStackTrace();
                inputStream.close();
                bufferedReader.close();
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        str3 = stringBuffer.toString();
        try {
            inputStream.close();
            bufferedReader.close();
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        return str3;
    }

    private void a(String str, String str2) {
        try {
            if (this.d != null) {
                str = str + "." + this.d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void b() {
        if (this.g != 0) {
            d("update thread is running, return");
            return;
        }
        this.g = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.d);
        bundle.putString("appid_for_getting_config", this.d);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", "3.3.0.lite");
        bundle.putString("sdkp", "a");
        new Thread() {
            /* class com.tencent.open.utils.f.AnonymousClass1 */

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    f.this.a(j.d(HttpUtils.openUrl2(f.this.c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).a));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                f.this.g = 0;
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = SystemClock.elapsedRealtime();
    }

    private void c() {
        int optInt = this.e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f >= ((long) (optInt * 3600000))) {
            b();
        }
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.e.optInt(str);
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    private void d(String str) {
        if (this.h) {
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", str + "; appid: " + this.d);
        }
    }
}
