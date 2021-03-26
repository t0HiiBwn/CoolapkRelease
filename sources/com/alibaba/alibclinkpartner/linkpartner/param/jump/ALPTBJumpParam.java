package com.alibaba.alibclinkpartner.linkpartner.param.jump;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibclinkpartner.linkpartner.param.a;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import java.util.HashMap;
import java.util.Map;

public class ALPTBJumpParam extends a {
    public String bcFlSrc;
    public String currentViewName;
    protected String d;
    private String e = "lp";
    public HashMap<String, String> extraParams = new HashMap<>();
    public String module;

    protected void d(String str, String str2) {
        if (str != null && str2 != null) {
            this.extraParams.put(str, str2);
        }
    }

    public HashMap<String, String> getExtraParams() {
        d("time", String.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(this.currentViewName)) {
            d("sourceVC", this.currentViewName);
        }
        return this.extraParams;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public HashMap<String, String> getH5DegradeParams() {
        String str;
        String str2;
        for (Map.Entry<String, String> entry : getExtraParams().entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                b(entry.getKey(), entry.getValue());
            }
        }
        if (this.a.get("tag") != null) {
            b("tag", (String) this.a.get("tag"));
        }
        if (this.a.get("TTID") != null) {
            str2 = (String) this.a.get("TTID");
        } else {
            if (ALSLContext.instance().TTID != null) {
                str2 = ALSLContext.instance().TTID;
            }
            str = this.e;
            if (str != null) {
                b("source", str);
            }
            return super.getH5DegradeParams();
        }
        b("TTID", str2);
        str = this.e;
        if (str != null) {
        }
        return super.getH5DegradeParams();
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getModule() {
        return "nav";
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public HashMap<String, String> getParams() {
        String str = this.module;
        if (str != null) {
            a("module", str);
        }
        String str2 = this.d;
        if (str2 != null) {
            a("action", str2);
        }
        String str3 = this.e;
        if (str3 != null) {
            a("source", str3);
        }
        if (ALSLContext.instance().appkey != null) {
            a("appkey", ALSLContext.instance().appkey);
        }
        if (ALSLContext.instance().TTID != null) {
            a("TTID", ALSLContext.instance().TTID);
        }
        if (TextUtils.isEmpty(this.linkKey) || (!this.linkKey.equals("tmall") && !this.linkKey.equals("tmall_scheme"))) {
            getExtraParams();
            HashMap<String, String> hashMap = this.extraParams;
            if (hashMap != null && hashMap.size() > 0) {
                a("params", com.alibaba.alibclinkpartner.linkpartner.b.a.a(this.extraParams));
            }
        } else {
            a("paramsKVEncode", "ture");
        }
        return super.getParams();
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public HashMap<String, String> getUnUrlEnCodeParams() {
        if (!TextUtils.isEmpty(this.linkKey) && (this.linkKey.equals("tmall") || this.linkKey.equals("tmall_scheme"))) {
            getExtraParams();
            HashMap<String, String> hashMap = this.extraParams;
            if (hashMap != null && hashMap.size() > 0) {
                c("params", com.alibaba.alibclinkpartner.linkpartner.b.a.b(this.extraParams));
            }
        }
        return super.getUnUrlEnCodeParams();
    }

    public boolean isInFirstParam(String str) {
        if (str != null) {
            for (String str2 : ALPParamConstant.FIRST_PARAM_KEYS) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public void putParam(String str, String str2) {
        if (str != null && str2 != null) {
            if (isInFirstParam(str)) {
                a(str, str2);
            } else {
                d(str, str2);
            }
        }
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public void putParams(Map<String, String> map) {
        if (!(map == null || map.size() == 0)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!(entry.getKey() == null || entry.getValue() == null)) {
                    if (isInFirstParam(entry.getKey())) {
                        a(entry.getKey(), entry.getValue());
                    } else {
                        d(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }
}
