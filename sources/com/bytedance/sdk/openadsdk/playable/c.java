package com.bytedance.sdk.openadsdk.playable;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PlayableJsBridge */
public class c {
    private Context a;
    private WeakReference<e> b;
    private Map<String, a> c = new HashMap();
    private SensorEventListener d = new SensorEventListener() {
        /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass1 */

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            e d;
            if (sensorEvent.sensor.getType() == 1 && (d = c.this.d()) != null) {
                float f = sensorEvent.values[0];
                float f2 = sensorEvent.values[1];
                float f3 = sensorEvent.values[2];
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", Math.round(f));
                    jSONObject.put("y", Math.round(f2));
                    jSONObject.put("z", Math.round(f3));
                    d.a("accelerometer_callback", jSONObject);
                } catch (Throwable unused) {
                }
            }
        }
    };
    private SensorEventListener e = new SensorEventListener() {
        /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass10 */

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            e d;
            if (sensorEvent.sensor.getType() == 4 && (d = c.this.d()) != null) {
                float degrees = (float) Math.toDegrees((double) sensorEvent.values[0]);
                float degrees2 = (float) Math.toDegrees((double) sensorEvent.values[1]);
                float degrees3 = (float) Math.toDegrees((double) sensorEvent.values[2]);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", Math.round(degrees));
                    jSONObject.put("y", Math.round(degrees2));
                    jSONObject.put("z", Math.round(degrees3));
                    d.a("gyro_callback", jSONObject);
                } catch (Throwable unused) {
                }
            }
        }
    };

    /* compiled from: PlayableJsBridge */
    interface a {
        JSONObject a(JSONObject jSONObject) throws Throwable;
    }

    public c(e eVar) {
        this.a = eVar.a();
        this.b = new WeakReference<>(eVar);
        c();
    }

    public Set<String> a() {
        return this.c.keySet();
    }

    private void c() {
        this.c.put("adInfo", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass11 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) {
                e d = c.this.d();
                if (d != null) {
                    return d.n();
                }
                return null;
            }
        });
        this.c.put("appInfo", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass12 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "1.0.0.0");
                JSONArray jSONArray = new JSONArray();
                for (String str : c.this.a()) {
                    jSONArray.put(str);
                }
                jSONObject2.put("supportList", jSONArray);
                e d = c.this.d();
                if (d != null) {
                    jSONObject2.put("deviceId", d.g());
                    jSONObject2.put("netType", d.k());
                    jSONObject2.put("innerAppName", d.d());
                    jSONObject2.put("appName", d.e());
                    jSONObject2.put("appVersion", d.f());
                    Map<String, String> b = d.b();
                    for (String str2 : b.keySet()) {
                        jSONObject2.put(str2, b.get(str2));
                    }
                }
                return jSONObject2;
            }
        });
        this.c.put("subscribe_app_ad", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass13 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) {
                a e = c.this.e();
                if (e == null) {
                    return null;
                }
                e.a(jSONObject);
                return null;
            }
        });
        this.c.put("download_app_ad", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass14 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) {
                a e = c.this.e();
                if (e == null) {
                    return null;
                }
                e.b(jSONObject);
                return null;
            }
        });
        this.c.put("isViewable", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass15 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d = c.this.d();
                if (d == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("viewStatus", d.i());
                return jSONObject2;
            }
        });
        this.c.put("getVolume", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass16 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d = c.this.d();
                if (d == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("endcard_mute", d.h());
                return jSONObject2;
            }
        });
        this.c.put("getScreenSize", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass17 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d = c.this.d();
                if (d == null) {
                    return new JSONObject();
                }
                return d.m();
            }
        });
        this.c.put("start_accelerometer_observer", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        d.a("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -2);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                g.a(c.this.a, c.this.d, i);
                jSONObject2.put("code", 0);
                return jSONObject2;
            }
        });
        this.c.put("close_accelerometer_observer", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass3 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    g.a(c.this.a, c.this.d);
                    jSONObject2.put("code", 0);
                    return jSONObject2;
                } catch (Throwable th) {
                    d.a("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.c.put("start_gyro_observer", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass4 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        d.a("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -2);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                g.b(c.this.a, c.this.e, i);
                jSONObject2.put("code", 0);
                return jSONObject2;
            }
        });
        this.c.put("close_gyro_observer", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass5 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    g.a(c.this.a, c.this.e);
                    jSONObject2.put("code", 0);
                    return jSONObject2;
                } catch (Throwable th) {
                    d.a("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.c.put("device_shake", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass6 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    g.a(c.this.a);
                    jSONObject2.put("code", 0);
                    return jSONObject2;
                } catch (Throwable th) {
                    d.a("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.c.put("playable_style", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass7 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d = c.this.d();
                if (d != null) {
                    return d.c();
                }
                return null;
            }
        });
        this.c.put("sendReward", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass8 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d = c.this.d();
                if (d == null) {
                    return null;
                }
                d.o();
                return null;
            }
        });
        this.c.put("webview_time_track", new a() {
            /* class com.bytedance.sdk.openadsdk.playable.c.AnonymousClass9 */

            @Override // com.bytedance.sdk.openadsdk.playable.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                a e = c.this.e();
                if (e == null) {
                    return null;
                }
                e.c(jSONObject);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public e d() {
        WeakReference<e> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* access modifiers changed from: private */
    public a e() {
        e d2 = d();
        if (d2 == null) {
            return null;
        }
        return d2.l();
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            a aVar = this.c.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.a(jSONObject);
        } catch (Throwable th) {
            d.a("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }

    public void b() {
        g.a(this.a, this.d);
        g.a(this.a, this.e);
    }
}
