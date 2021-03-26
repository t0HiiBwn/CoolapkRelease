package mtopsdk.a.a.c;

import com.alibaba.wireless.security.open.middletier.fc.FCAction;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.c;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import mtopsdk.a.c.a;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SDKUtils;

/* compiled from: FCDuplexFilter */
final class e implements Runnable {
    private /* synthetic */ long a;
    private /* synthetic */ FCAction.FCMainAction b;
    private /* synthetic */ long c;
    private /* synthetic */ HashMap d;
    private /* synthetic */ d e;

    e(d dVar, long j, FCAction.FCMainAction fCMainAction, long j2, HashMap hashMap) {
        this.e = dVar;
        this.a = j;
        this.b = fCMainAction;
        this.c = j2;
        this.d = hashMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TBSdkLog.e("mtopsdk.FCDuplexFilter", " [IFCActionCallback] onAction: " + ("--->###sessionId = " + this.a + ", MainAction = " + this.b + ", subAction = " + this.c + ", extraInfo = " + this.d.toString() + "### ") + this.e.a.h);
        this.e.a.g.fcProcessCallbackTime = this.e.a.g.currentTimeMillis();
        this.e.a.g.bxMainAction = this.b.ordinal();
        this.e.a.g.bxSubAction = this.c;
        if (this.b == FCAction.FCMainAction.RETRY) {
            this.e.a.g.bxRetry = 1;
            String str = (String) this.d.get("x-bx-resend");
            if (StringUtils.isNotBlank(str)) {
                HashMap hashMap = new HashMap();
                try {
                    hashMap.put("x-bx-resend", URLEncoder.encode(str, "utf-8"));
                    this.e.b.headers(hashMap);
                } catch (UnsupportedEncodingException unused) {
                    TBSdkLog.e("mtopsdk.FCDuplexFilter", "[IFCActionCallback]urlEncode x-bx-resend=" + str + "error");
                }
            }
            if ((this.c & FCAction.FCSubAction.LOGIN.getValue()) > 0) {
                c.a("ANTI").c(this.e.c, "", (MtopBusiness) this.e.b);
                String str2 = this.e.b.mtopProp.userInfo;
                c.a("SESSION").a(this.e.c, str2, (MtopBusiness) this.e.b);
                RemoteLogin.login(this.e.c, str2, true, this.e.b);
                return;
            }
            if ((this.c & FCAction.FCSubAction.WUA.getValue()) > 0) {
                this.e.a.d.wuaRetry = true;
            }
            c.a("ANTI").b(this.e.c, "", (MtopBusiness) this.e.b);
        } else if (this.b != FCAction.FCMainAction.FAIL) {
            c.a("ANTI").c(this.e.c, "", (MtopBusiness) this.e.b);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.w("mtopsdk.FCDuplexFilter", this.e.a.h, "[IFCActionCallback][SUCCESS/CANCEL/TIMEOUT] execute FCDuplexFilter apiKey=" + this.e.a.b.getKey());
            }
            this.e.a.c.setRetCode("ANDROID_SYS_API_41X_ANTI_ATTACK");
            this.e.a.c.setRetMsg("哎哟喂,被挤爆啦,请稍后重试(419)!");
            a.a(this.e.a);
        } else if ((this.c & FCAction.FCSubAction.LOGIN.getValue()) > 0) {
            RemoteLogin.login(this.e.c, this.e.b.mtopProp.userInfo, true, this.e.b);
            c.a("ANTI").c(this.e.c, "", (MtopBusiness) this.e.b);
            this.e.d.setRetCode("ANDROID_SYS_API_41X_ANTI_ATTACK");
            this.e.d.setRetMsg("哎哟喂,被挤爆啦,请稍后重试(419)!");
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.w("mtopsdk.FCDuplexFilter", this.e.a.h, "[IFCActionCallback] execute FCDuplexFilter apiKey=" + this.e.a.b.getKey());
            }
            a.a(this.e.a);
        } else if ((this.c & FCAction.FCSubAction.FL.getValue()) > 0) {
            c.a("ANTI").c(this.e.c, "", (MtopBusiness) this.e.b);
            String key = this.e.a.b.getKey();
            long longValue = ((Long) this.d.get("bx-sleep")).longValue();
            mtopsdk.mtop.antiattack.a.a(key, SDKUtils.getCorrectionTime(), longValue);
            this.e.a.g.bxSleep = longValue;
            a.a(this.e.d);
            if (StringUtils.isBlank(this.e.d.getRetCode())) {
                this.e.a.c.setRetCode("ANDROID_SYS_API_FLOW_LIMIT_LOCKED");
                this.e.a.c.setRetMsg("哎哟喂,被挤爆啦,请稍后重试(420)");
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.w("mtopsdk.FCDuplexFilter", this.e.a.h, "[IFCActionCallback] doAfter execute FlowLimitDuplexFilter apiKey=" + key + " ,retCode=" + this.e.d.getRetCode());
            }
            a.a(this.e.a);
        } else {
            c.a("ANTI").c(this.e.c, "", (MtopBusiness) this.e.b);
            this.e.a.c.setRetCode("ANDROID_SYS_API_41X_ANTI_ATTACK");
            this.e.a.c.setRetMsg("哎哟喂,被挤爆啦,请稍后重试(419)!");
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.w("mtopsdk.FCDuplexFilter", this.e.a.h, "[IFCActionCallback][FAIL] execute FCDuplexFilter apiKey=" + this.e.a.b.getKey());
            }
            a.a(this.e.a);
        }
    }
}
