package com.alibaba.mtl.appmonitor.d;

import android.content.Context;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.f.b;
import com.alibaba.mtl.log.d.i;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: SampleRules */
public class j {
    private static final String TAG = null;
    private static j a;
    private String A;
    private int r;
    private Map<f, g> s = new HashMap();

    private j() {
        f[] values = f.values();
        for (f fVar : values) {
            if (fVar == f.ALARM) {
                this.s.put(fVar, new f(fVar, fVar.e()));
            } else {
                this.s.put(fVar, new g(fVar, fVar.e()));
            }
        }
    }

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
                }
            }
        }
        return a;
    }

    public void a(Context context) {
        j();
    }

    public static boolean a(f fVar, String str, String str2) {
        return a().b(fVar, str, str2, (Map<String, String>) null);
    }

    public static boolean a(f fVar, String str, String str2, Map<String, String> map) {
        return a().b(fVar, str, str2, map);
    }

    public static boolean a(String str, String str2, Boolean bool, Map<String, String> map) {
        return a().b(str, str2, bool, map);
    }

    public boolean b(f fVar, String str, String str2, Map<String, String> map) {
        g gVar = this.s.get(fVar);
        if (gVar != null) {
            return gVar.a(this.r, str, str2, map);
        }
        return false;
    }

    public boolean b(String str, String str2, Boolean bool, Map<String, String> map) {
        g gVar = this.s.get(f.ALARM);
        if (gVar == null || !(gVar instanceof f)) {
            return false;
        }
        return ((f) gVar).a(this.r, str, str2, bool, map);
    }

    public void j() {
        this.r = new Random(System.currentTimeMillis()).nextInt(10000);
    }

    public void b(String str) {
        i.a("SampleRules", "config:", str);
        synchronized (this) {
            if (!b.d(str)) {
                String str2 = this.A;
                if (str2 == null || !str2.equals(str)) {
                }
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f[] values = f.values();
            for (f fVar : values) {
                JSONObject optJSONObject = jSONObject.optJSONObject(fVar.toString());
                g gVar = this.s.get(fVar);
                if (!(optJSONObject == null || gVar == null)) {
                    i.a(TAG, fVar, optJSONObject);
                    gVar.b(optJSONObject);
                }
            }
            this.A = str;
        } catch (Throwable unused) {
        }
    }

    public void a(f fVar, int i) {
        g gVar = this.s.get(fVar);
        if (gVar != null) {
            gVar.setSampling(i);
        }
    }
}
