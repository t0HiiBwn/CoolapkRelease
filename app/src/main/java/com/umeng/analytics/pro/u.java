package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.h;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.analytics.vshelper.a;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ViewPageTracker */
public class u {
    private static final int c = 5;
    private static JSONArray d = new JSONArray();
    private static Object e = new Object();
    Stack<String> a = new Stack<>();
    a b = PageNameMonitor.getInstance();
    private final Map<String, Long> f = new HashMap();

    protected int a() {
        return 2;
    }

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (e) {
                    jSONArray = d.toString();
                    d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        h.a(context).a(t.a().c(), jSONObject, h.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog() && this.a.size() != 0) {
                UMLog.aq(i.F, 0, "\\|", new String[]{"@"}, new String[]{this.a.peek()}, null, null);
            }
            this.b.customPageBegin(str);
            synchronized (this.f) {
                this.f.put(str, Long.valueOf(System.currentTimeMillis()));
                if (UMConfigure.isDebugLog()) {
                    this.a.push(str);
                }
            }
        }
    }

    public void b(String str) {
        Long l2;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f.containsKey(str)) {
            synchronized (this.f) {
                l2 = this.f.get(str);
            }
            if (l2 != null) {
                if (UMConfigure.isDebugLog() && this.a.size() > 0 && str.equals(this.a.peek())) {
                    this.a.pop();
                }
                long currentTimeMillis = System.currentTimeMillis() - l2.longValue();
                synchronized (e) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("page_name", str);
                        jSONObject.put("duration", currentTimeMillis);
                        jSONObject.put("page_start", l2);
                        jSONObject.put("type", a());
                        d.put(jSONObject);
                        if (d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                            UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (UMConfigure.isDebugLog() && this.a.size() != 0) {
                    UMLog.aq(i.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                }
            }
        } else if (UMConfigure.isDebugLog() && this.a.size() == 0) {
            UMLog.aq(i.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        }
    }

    public void b() {
        String str;
        synchronized (this.f) {
            str = null;
            long j = 0;
            for (Map.Entry<String, Long> entry : this.f.entrySet()) {
                if (entry.getValue().longValue() > j) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }
}