package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

public class bq {
    public s a;
    private String b;

    public bq(String str) {
        this.b = str;
        this.a = new s(str);
        n.a().a(this.b, this.a);
    }

    private p b(int i) {
        if (i == 0) {
            return this.a.b();
        }
        if (i == 1) {
            return this.a.a();
        }
        if (i == 2) {
            return this.a.c();
        }
        if (i != 3) {
            return null;
        }
        return this.a.d();
    }

    private boolean c(int i) {
        String str;
        if (i != 2) {
            p b2 = b(i);
            if (b2 != null && !TextUtils.isEmpty(b2.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i;
        } else if ("_default_config_tag".equals(this.b)) {
            return true;
        } else {
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        af.c("hmsSdk", str);
        return false;
    }

    public void a(int i) {
        af.a("hmsSdk", "HiAnalyticsInstance.onReport() is execute.TAG: %s,TYPE: %d", this.b, Integer.valueOf(i));
        bp.a().a(this.b, i);
    }

    public void a(int i, p pVar) {
        p pVar2;
        if (pVar == null) {
            af.a("hmsSdk", "HiAnalyticsInstanceImpl.refresh(). Parameter config is null.TAG : %s , TYPE : %d", this.b, Integer.valueOf(i));
            pVar2 = null;
        } else {
            pVar2 = new p(pVar);
        }
        af.a("hmsSdk", "HiAnalyticsInstanceImpl.refresh() is executed.TAG : %s , TYPE : %d", this.b, Integer.valueOf(i));
        if (i == 0) {
            c(pVar2);
            an.a().a(this.b);
        } else if (i == 1) {
            a(pVar2);
        } else if (i == 2) {
            d(pVar2);
        } else if (i != 3) {
            af.c("hmsSdk", "refresh(): HiAnalyticsType can only be OPERATION ,MAINTAIN or DIFF_PRIVACY.");
        } else {
            b(pVar2);
        }
    }

    public void a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        af.a("hmsSdk", "HiAnalyticsInstance.onEvent(int type, String eventId, Map<String, String> mapValue) is execute.TAG: %s,TYPE: %d", this.b, Integer.valueOf(i));
        if (az.a(str) || !c(i)) {
            af.c("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.b + ", TYPE: " + i);
            return;
        }
        if (!az.a(linkedHashMap)) {
            af.c("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.b + ", TYPE: " + i);
            linkedHashMap = null;
        }
        bp.a().a(this.b, i, str, linkedHashMap);
    }

    public void a(Context context, String str, String str2) {
        af.b("hmsSdk", "HiAnalyticsInstance.onEvent(eventId, mapValue) is execute.TAG : " + this.b);
        if (context == null) {
            af.c("hmsSdk", "context is null in onevent ");
        } else if (az.a(str) || !c(0)) {
            af.c("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.b);
        } else {
            if (!az.a("value", str2, 65536)) {
                af.c("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.b);
                str2 = "";
            }
            bp.a().a(this.b, context, str, str2);
        }
    }

    public void a(p pVar) {
        af.b("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.b);
        if (pVar == null) {
            af.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.a.a((p) null);
            return;
        }
        this.a.a(pVar);
    }

    public void b(p pVar) {
        af.b("hmsSdk", "HiAnalyticsInstanceImpl.setDiffConf() is executed.TAG : " + this.b);
        if (pVar == null) {
            af.c("hmsSdk", "HiAnalyticsInstanceImpl.setDiffConf(): config for diffPrivacy is null!");
            this.a.d(null);
            return;
        }
        this.a.d(pVar);
    }

    public void c(p pVar) {
        af.b("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.b);
        if (pVar == null) {
            this.a.b(null);
            af.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
            return;
        }
        this.a.b(pVar);
    }

    public void d(p pVar) {
        af.b("hmsSdk", "HiAnalyticsInstanceImpl.setPreInstallConf() is executed.TAG: " + this.b);
        if (pVar == null) {
            af.c("hmsSdk", "HiAnalyticsInstanceImpl.setPreInstallConf(): config for PRE-INSTALL is null!");
            this.a.c(null);
            return;
        }
        this.a.c(pVar);
    }
}
