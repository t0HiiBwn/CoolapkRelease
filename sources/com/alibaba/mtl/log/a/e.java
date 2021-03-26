package com.alibaba.mtl.log.a;

import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.c.c;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.r;
import com.alibaba.mtl.log.upload.UploadEngine;
import org.json.JSONObject;

/* compiled from: SystemConfig */
public class e {
    public static void i(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SYSTEM")) {
                    i.a("SystemConfig", "server system config ", str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("SYSTEM");
                    if (optJSONObject != null) {
                        try {
                            if (optJSONObject.has("bg_interval")) {
                                a.f(optJSONObject.getInt("bg_interval") + "");
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            if (optJSONObject.has("fg_interval")) {
                                a.g(optJSONObject.getInt("fg_interval") + "");
                            }
                        } catch (Throwable unused2) {
                        }
                        i.a("SystemConfig", "UTDC.bSendToNewLogStore:", Boolean.valueOf(a.r));
                        i.a("SystemConfig", "Config.BACKGROUND_PERIOD:", Long.valueOf(a.b()));
                        i.a("SystemConfig", "Config.FOREGROUND_PERIOD:", Long.valueOf(a.a()));
                        try {
                            if (optJSONObject.has("discard")) {
                                int i = optJSONObject.getInt("discard");
                                if (i == 1) {
                                    a.B = true;
                                    UploadEngine.getInstance().stop();
                                } else if (i == 0) {
                                    a.B = false;
                                    UploadEngine.getInstance().start();
                                }
                            } else if (a.B) {
                                a.B = false;
                                UploadEngine.getInstance().start();
                            }
                        } catch (Throwable unused3) {
                        }
                        try {
                            if (optJSONObject.has("cdb") && optJSONObject.getInt("cdb") > f()) {
                                r.a().b(new Runnable() {
                                    /* class com.alibaba.mtl.log.a.e.AnonymousClass1 */

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.a().clear();
                                    }
                                });
                            }
                        } catch (Throwable unused4) {
                        }
                    }
                }
            } catch (Throwable th) {
                i.a("SystemConfig", "updateconfig", th);
            }
        }
    }

    public static int f() {
        JSONObject jSONObject;
        String h = a.h();
        if (TextUtils.isEmpty(h)) {
            return 0;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(h);
            if (!jSONObject2.has("SYSTEM") || (jSONObject = jSONObject2.getJSONObject("SYSTEM")) == null || !jSONObject.has("cdb")) {
                return 0;
            }
            return jSONObject.getInt("cdb");
        } catch (Throwable unused) {
            return 0;
        }
    }
}
