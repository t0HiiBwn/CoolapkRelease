package com.alibaba.baichuan.trade.biz.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.Environment;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTradeHelper;
import com.alibaba.baichuan.trade.common.utils.AlibcCodeUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;
import com.alibaba.baichuan.trade.common.utils.http.HttpHelper;
import com.alibaba.baichuan.trade.common.utils.network.NetworkUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlibcConfigBusiness {
    private String a;
    private Context b;
    private ConfigPullCallback c;
    private final long d = 5000000;

    /* renamed from: com.alibaba.baichuan.trade.biz.core.config.AlibcConfigBusiness$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Environment.values().length];
            a = iArr;
            try {
                iArr[Environment.PRE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Environment.TEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public interface ConfigPullCallback {
        void onError(String str);

        void onSuccess(AlibcConfigAdapter alibcConfigAdapter, String str);
    }

    public AlibcConfigBusiness(Context context, ConfigPullCallback configPullCallback, String str) {
        this.b = context;
        this.c = configPullCallback;
        b(str);
    }

    /* access modifiers changed from: private */
    public void a() {
        AlibcUserTradeHelper.sendUsabilitySuccess("Fetch_Config");
    }

    private static void a(Object obj, StringBuilder sb) {
        StringBuilder sb2;
        if (obj != null) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        if (!next.equals("sign")) {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                sb.append(next);
                            }
                            a(obj2, sb);
                        }
                    } catch (JSONException e) {
                        e = e;
                        sb2 = new StringBuilder();
                        sb2.append("json解析异常: msg=");
                        sb2.append(e.getMessage());
                        AlibcLogger.e("AlibcConfigBusiness", sb2.toString());
                        return;
                    }
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        a(jSONArray.get(i), sb);
                    } catch (JSONException e2) {
                        e = e2;
                        sb2 = new StringBuilder();
                        sb2.append("json解析异常: msg=");
                        sb2.append(e.getMessage());
                        AlibcLogger.e("AlibcConfigBusiness", sb2.toString());
                        return;
                    }
                }
            } else {
                sb.append(obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        AlibcUserTradeHelper.sendUsabilityFailure("Fetch_Config", str2, "1301" + str);
    }

    /* access modifiers changed from: private */
    public boolean a(ConfigDO configDO, String str) {
        if (configDO == null) {
            return false;
        }
        String sign = configDO.getSign();
        String d2 = d(str);
        if (!TextUtils.isEmpty(d2)) {
            return d2.equals(sign);
        }
        return false;
    }

    private void b(String str) {
        this.a = f(str);
    }

    private void c(final String str) {
        ExecutorServiceUtils.getInstance().postDelayTask(new Runnable() {
            /* class com.alibaba.baichuan.trade.biz.core.config.AlibcConfigBusiness.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                String str;
                ConfigPullCallback configPullCallback;
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(AlibcConfigBusiness.this.a)) {
                        AlibcConfigBusiness.this.a = AlibcConfigBusiness.f(str);
                    }
                    AlibcLogger.d("AlibcConfigBusiness", "开始从网络拉取config数据,url为：" + AlibcConfigBusiness.this.a);
                    if (TextUtils.isEmpty(AlibcConfigBusiness.this.a)) {
                        AlibcLogger.e("AlibcConfigBusiness", "配置类型传入错误");
                        return;
                    }
                    String str3 = HttpHelper.get(AlibcConfigBusiness.this.a, null);
                    if (str.equals("100")) {
                        AlibcConfigAdapter alibcConfigAdapter = new AlibcConfigAdapter();
                        if (AlibcConfigBusiness.this.a(alibcConfigAdapter.parseJsonString(str3), str3)) {
                            AlibcConfigBusiness.this.a();
                            AlibcConfigBusiness.this.c.onSuccess(alibcConfigAdapter, str3);
                            return;
                        }
                        AlibcConfigBusiness.this.e("校验错误");
                        AlibcConfigBusiness.this.c.onError("config文件校验失败");
                    }
                } catch (JSONException e) {
                    AlibcLogger.e("AlibcConfigBusiness", "解析JSON出错" + e.getMessage());
                    AlibcConfigBusiness.this.e("解析错误");
                    configPullCallback = AlibcConfigBusiness.this.c;
                    str = e.getMessage();
                    configPullCallback.onError(str);
                } catch (Exception e2) {
                    if (e2 instanceof HttpHelper.HttpHelperException) {
                        AlibcLogger.e("AlibcConfigBusiness", "获取Http网络错误" + e2.getMessage());
                        HttpHelper.HttpHelperException httpHelperException = (HttpHelper.HttpHelperException) e2;
                        if (httpHelperException.statusCode != -999) {
                            str2 = String.valueOf(httpHelperException.statusCode);
                        }
                        AlibcConfigBusiness.this.a(str2, "网络错误");
                        configPullCallback = AlibcConfigBusiness.this.c;
                        str = e2.getMessage();
                        configPullCallback.onError(str);
                    }
                }
            }
        }, 2000);
    }

    private static String d(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            a(new JSONObject(str), sb);
            try {
                sb.append("ALITRADE20160628");
                char[] charArray = sb.toString().toCharArray();
                Arrays.sort(charArray);
                return AlibcCodeUtils.md5Digest(new String(charArray).getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                AlibcLogger.e("AlibcConfigBusiness", "生成摘要错误" + e.getMessage());
                return null;
            }
        } catch (JSONException e2) {
            AlibcLogger.e("AlibcConfigBusiness", "json解析异常: msg=" + e2.getMessage());
            return "";
        }
    }

    public static boolean dataIsReal(String str, String str2) {
        String d2 = d(str2);
        if (!TextUtils.isEmpty(d2)) {
            return d2.equals(str);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            String str3 = "校验错误";
            if (str.equals(str3)) {
                str2 = "130101";
            } else {
                str3 = "解析错误";
                if (str.equals(str3)) {
                    str2 = "130102";
                } else {
                    return;
                }
            }
            AlibcUserTradeHelper.sendUsabilityFailure("Fetch_Config", str3, str2);
        }
    }

    /* access modifiers changed from: private */
    public static String f(String str) {
        String str2;
        int i = AnonymousClass2.a[AlibcTradeCommon.getEnvironment().ordinal()];
        boolean equals = str.equals("100");
        if (i != 1) {
            if (i != 2) {
                if (equals) {
                    str2 = "https://baichuan-sdk.alicdn.com/%s/%s/%s/%s/rule.htm";
                    return String.format(str2, AlibcTradeBiz.systemVersion, AlibcTradeCommon.getAppKey(), "1.0.0", "android");
                }
            } else if (equals) {
                str2 = "https://test-baichuan-sdk.alibaba.net/%s/%s/%s/%s/rule.htm";
                return String.format(str2, AlibcTradeBiz.systemVersion, AlibcTradeCommon.getAppKey(), "1.0.0", "android");
            }
        } else if (equals) {
            str2 = "https://pre-baichuan-sdk.taobao.com/%s/%s/%s/%s/rule.htm";
            return String.format(str2, AlibcTradeBiz.systemVersion, AlibcTradeCommon.getAppKey(), "1.0.0", "android");
        }
        str2 = "";
        return String.format(str2, AlibcTradeBiz.systemVersion, AlibcTradeCommon.getAppKey(), "1.0.0", "android");
    }

    public void startProcessor(String str) {
        AlibcLogger.d("AlibcConfigBusiness", "开启拉取网络配置");
        if (NetworkUtils.isNetworkAvailable(this.b)) {
            c(str);
            return;
        }
        this.c.onError("没有网络，无法拉取config配置");
        AlibcLogger.i("AlibcConfigBusiness", "没有网络，无法拉取config配置");
    }
}
