package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.cconfig.UMRemoteConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: HttpPostThread */
public class ai implements Runnable {
    public static final String a = "https://ucc.umeng.com/v1/fetch";
    public static final String b = "https://pslog.umeng.com/ablog";
    private String c;
    private String d;

    public ai(String str, JSONObject jSONObject) {
        this.c = str;
        this.d = jSONObject.toString();
    }

    public ai(String str, JSONArray jSONArray) {
        this.c = str;
        this.d = jSONArray.toString();
    }

    public ai(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[Catch:{ Exception -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[Catch:{ Exception -> 0x003e }] */
    @Override // java.lang.Runnable
    public void run() {
        String str;
        String a2 = ah.a(this.c, this.d);
        int i = -1;
        if (this.c.contains("https://ucc.umeng.com/v1/fetch")) {
            i = 1;
        } else if (this.c.contains("https://pslog.umeng.com/ablog")) {
            i = 2;
        } else {
            str = null;
            if (!TextUtils.isEmpty(a2)) {
                UMRemoteConfig.getInstance().handlerMessage(i, str, this.d);
                return;
            } else {
                UMRemoteConfig.getInstance().handlerMessage(i, str, null);
                return;
            }
        }
        str = a2;
        if (!TextUtils.isEmpty(a2)) {
        }
    }
}
