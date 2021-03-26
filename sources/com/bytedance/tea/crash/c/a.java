package com.bytedance.tea.crash.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tea.crash.e.a.b;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.g.m;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashBody */
public class a {
    protected JSONObject a;

    public a() {
        this.a = new JSONObject();
    }

    public a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public static a a(long j, Context context, Thread thread, Throwable th) {
        String str;
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.a("isJava", (Object) 1);
        aVar.a("event_type", "java_crash");
        aVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
        aVar.a("data", m.a(th));
        aVar.a("isOOM", Boolean.valueOf(m.b(th)));
        aVar.a("crash_time", Long.valueOf(j));
        aVar.a("process_name", com.bytedance.tea.crash.g.a.d(context));
        if (!com.bytedance.tea.crash.g.a.b(context)) {
            aVar.a("remote_process", (Object) 1);
        }
        com.bytedance.tea.crash.g.a.a(context, aVar.a());
        if (thread == null) {
            str = null;
        } else {
            str = thread.getName();
        }
        if (str != null) {
            aVar.a("crash_thread_name", str);
        }
        aVar.a("all_thread_stacks", m.a(str));
        return aVar;
    }

    public JSONObject a() {
        return this.a;
    }

    public a a(b bVar) {
        a("header", bVar.a());
        return this;
    }

    public a a(long j) {
        try {
            a("start_time", Long.valueOf(j));
            a("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public a a(String str) {
        if (!TextUtils.isEmpty(str)) {
            a("session_id", str);
        }
        return this;
    }

    public a a(b bVar) {
        a("activity_trace", bVar.a());
        a("running_tasks", bVar.b());
        return this;
    }

    public a a(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            try {
                this.a.put("plugin_info", jSONArray);
                return this;
            } catch (Exception unused) {
            }
        } else {
            for (String str : map.keySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("package_name", str);
                jSONObject.put("version_code", map.get(str));
                jSONArray.put(jSONObject);
            }
            this.a.put("plugin_info", jSONArray);
            return this;
        }
    }

    public a b(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    j.b(e);
                }
            }
            try {
                this.a.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public a a(int i, String str) {
        try {
            this.a.put("miniapp_id", i);
            this.a.put("miniapp_version", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public a a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            a("patch_info", jSONArray);
            return this;
        }
        for (String str : list) {
            jSONArray.put(str);
        }
        a("patch_info", jSONArray);
        return this;
    }

    public a a(JSONObject jSONObject) {
        a("storage", jSONObject);
        return this;
    }

    public a b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        a("logcat", jSONArray);
        return this;
    }

    public a c(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            a("filters", jSONObject);
        }
        return this;
    }

    public void a(String str, Object obj) {
        try {
            this.a.put(str, obj);
        } catch (Exception e) {
            j.b(e);
        }
    }
}
