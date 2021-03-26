package com.alibaba.baichuan.trade.common.adapter.ut.a;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;
import com.alibaba.baichuan.trade.common.utils.http.HttpHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final String a = "a";
    private Map<String, String> b = new HashMap();
    private String c;

    private a() {
    }

    public static a a() {
        return new a();
    }

    public static String b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2 != null) {
                try {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    AlibcLogger.e(a, e.getMessage());
                }
            }
            str = URLEncoder.encode(str, "UTF-8");
            if (str2 != null) {
                stringBuffer.append("&");
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString().substring(1);
    }

    public a a(long j) {
        if (j > 0) {
            Map<String, String> map = this.b;
            map.put("time", "" + j);
        }
        return this;
    }

    public a a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
        }
        return this;
    }

    public a a(Map<String, String> map) {
        if (map != null) {
            this.b.putAll(map);
        }
        return this;
    }

    public a b() {
        String str = AlibcTradeCommon.ttid;
        if (!this.b.containsKey("ttid") && !TextUtils.isEmpty(str)) {
            Map<String, String> map = this.b;
            map.put("ttid", "" + str);
        }
        return this;
    }

    public a b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.put("sdktype", str);
        }
        return this;
    }

    public a c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.put("page", str);
        }
        return this;
    }

    public void c() {
        if (!TextUtils.isEmpty(this.c)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format("https://wgo.mmstat.com/%s?", this.c));
            stringBuffer.append(b(this.b));
            if (stringBuffer.toString().length() > 8000) {
                if (this.b.containsKey("param")) {
                    this.b.remove("param");
                }
                stringBuffer = new StringBuffer();
                stringBuffer.append(String.format("https://wgo.mmstat.com/%s?", this.c));
                stringBuffer.append(b(this.b));
                if (stringBuffer.toString().length() > 8000) {
                    this.b.clear();
                    this.b.put("ttid", AlibcTradeCommon.ttid);
                    this.b.put("appkey", AlibcTradeCommon.getAppKey());
                    this.b.put("sdktype", "mini");
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(String.format("https://wgo.mmstat.com/%s?", this.c));
                    stringBuffer.append(b(this.b));
                }
            }
            final String stringBuffer2 = stringBuffer.toString();
            AlibcLogger.d("Aplus", stringBuffer2);
            ExecutorServiceUtils.getInstance().postHandlerTask(new Runnable() {
                /* class com.alibaba.baichuan.trade.common.adapter.ut.a.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    AlibcLogger.d("Aplus", HttpHelper.getHttp(stringBuffer2));
                }
            });
            return;
        }
        throw new IllegalArgumentException("spm is null");
    }
}
