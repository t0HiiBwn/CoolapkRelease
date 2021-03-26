package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefconProcesser */
public class q {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private final long e;

    private q() {
        this.e = 60000;
    }

    /* compiled from: DefconProcesser */
    private static class a {
        public static final q a = new q();

        private a() {
        }
    }

    public static q a() {
        return a.a;
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    private void a(JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has("sessions")) {
            jSONObject.remove("sessions");
        }
        if (jSONObject.has("active_user")) {
            jSONObject.remove("active_user");
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has("gkv")) {
            jSONObject.remove("gkv");
        }
        if (jSONObject.has("active_user")) {
            jSONObject.remove("active_user");
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            a(jSONObject, true);
            h.a(context).b(false, true);
        } else if (a2 == 2) {
            jSONObject.remove("sessions");
            try {
                jSONObject.put("sessions", b());
            } catch (Exception unused) {
            }
            a(jSONObject, true);
            h.a(context).b(false, true);
        } else if (a2 == 3) {
            a(jSONObject, false);
            h.a(context).b(false, true);
        }
    }

    public void b(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            if (jSONObject.has("active_user")) {
                jSONObject.remove("active_user");
            }
            if (jSONObject.has("sessions")) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("sessions");
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has("_$sp")) {
                            jSONObject2.remove("_$sp");
                        }
                        if (jSONObject2.has("_$pp")) {
                            jSONObject2.remove("_$pp");
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            h.a(context).a(false, true);
        } else if (a2 == 2) {
            if (jSONObject.has("active_user")) {
                jSONObject.remove("active_user");
            }
            if (jSONObject.has("sessions")) {
                jSONObject.remove("sessions");
            }
            try {
                jSONObject.put("sessions", c());
            } catch (Exception unused2) {
            }
            h.a(context).a(false, true);
        } else if (a2 == 3) {
            if (jSONObject.has("active_user")) {
                jSONObject.remove("active_user");
            }
            jSONObject.remove("sessions");
            h.a(context).a(false, true);
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", x.a().a(UMGlobalContext.getAppContext(null)));
            jSONObject.put("start_time", currentTimeMillis);
            jSONObject.put("end_time", currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", x.a().d(UMGlobalContext.getAppContext(null)));
            jSONObject.put("start_time", currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}
