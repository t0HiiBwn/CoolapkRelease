package com.alibaba.alibclinkpartner.linkpartner.param;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.ALPTBLinkPartnerSDK;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLSystemUtil;
import java.util.HashMap;
import java.util.Map;

public abstract class a {
    protected HashMap<String, String> a = new HashMap<>();
    protected HashMap<String, String> b = new HashMap<>();
    public String backUrl;
    protected HashMap<String, String> c = new HashMap<>();
    private String d = "linkPartner";
    public String h5Url;
    public ALPTBLinkPartnerSDK.JumpIntentProcessor intentProcessor;
    public String linkKey = "taobao";
    public String packageName;
    public String pluginRules;
    public String visa;

    public a() {
    }

    public a(String str, String str2, String str3) {
        this.linkKey = str;
        this.backUrl = str2;
        this.h5Url = str3;
    }

    protected void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.a.put(str, str2);
        }
    }

    protected void b(String str, String str2) {
        if (str != null && str2 != null) {
            this.c.put(str, str2);
        }
    }

    protected void c(String str, String str2) {
        if (str != null && str2 != null) {
            this.b.put(str, str2);
        }
    }

    public boolean checkParam() {
        return this.linkKey != null;
    }

    public String getBackUpH5Url() {
        return this.h5Url;
    }

    public HashMap<String, String> getH5DegradeParams() {
        return this.c;
    }

    public String getModule() {
        return "";
    }

    public HashMap<String, String> getParams() {
        String str = this.backUrl;
        if (str != null) {
            a("backURL", str);
        }
        String str2 = this.d;
        if (str2 != null) {
            a("sdkName", str2);
        }
        String str3 = this.pluginRules;
        if (str3 != null) {
            a("pluginRules", str3);
        }
        a("appName", ALSLSystemUtil.getAppName(ALSLContext.instance().mApplication));
        a("packageName", ALSLSystemUtil.getPackageName(ALSLContext.instance().mApplication));
        a("v", ALSLContext.instance().ALSLSDKVersion);
        return this.a;
    }

    public String getPostfix() {
        return "";
    }

    public HashMap<String, String> getUnUrlEnCodeParams() {
        return this.b;
    }

    public boolean isTaobaoOrTmall() {
        if (TextUtils.isEmpty(this.linkKey)) {
            return false;
        }
        String[] strArr = {"taobao_scheme", "taobao", "tmall_scheme", "tmall"};
        for (int i = 0; i < 4; i++) {
            if (strArr[i].equals(this.linkKey)) {
                return true;
            }
        }
        return false;
    }

    public void putParam(String str, String str2) {
        if (str != null && str2 != null) {
            a(str, str2);
        }
    }

    public void putParams(Map<String, String> map) {
        if (!(map == null || map.size() == 0)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!(entry.getKey() == null || entry.getValue() == null)) {
                    a(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
