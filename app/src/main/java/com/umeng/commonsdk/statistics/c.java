package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.a;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* compiled from: NetWorkManager */
public class c {
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";
    String a = null;
    private final int e = 1;
    private com.umeng.commonsdk.statistics.internal.c f;
    private ImprintHandler g;
    private e h = null;
    private ImprintHandler.a i = null;
    private ABTest j = null;
    private Defcon k = null;

    /* renamed from: l  reason: collision with root package name */
    private long f1490l = 0;
    private int m = 0;
    private int n = 0;
    private Context r;

    public c(Context context) {
        this.r = context;
        this.i = ImprintHandler.getImprintService(context).c();
        this.k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.f1490l = sharedPreferences.getLong("thtstart", 0);
        this.m = sharedPreferences.getInt("gkvc", 0);
        this.n = sharedPreferences.getInt("ekvc", 0);
        this.a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.r);
        this.g = imprintService;
        imprintService.a(new d() {
            /* class com.umeng.commonsdk.statistics.c.AnonymousClass1 */

            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.a = UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.r)) {
            this.h = e.a(this.r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f = cVar;
        cVar.a(StatTracer.getInstance(this.r));
    }

    public boolean a(File file) {
        String str;
        int i2;
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            a a2 = a.a(this.r);
            a2.d(name);
            boolean a3 = a2.a(name);
            boolean b2 = a2.b(name);
            boolean c2 = a2.c(name);
            String d2 = com.umeng.commonsdk.stateless.d.d(name);
            if (!TextUtils.isEmpty(d2)) {
                str = com.umeng.commonsdk.stateless.d.c(d2);
            } else if (c2) {
                str = UMServerURL.ZCFG_PATH;
            } else {
                str = UMServerURL.PATH_ANALYTICS;
            }
            byte[] a4 = this.f.a(byteArray, a3, c2, str);
            if (a4 == null) {
                i2 = 1;
            } else {
                i2 = a(a4);
            }
            if (UMConfigure.isDebugLog()) {
                if (c2 && i2 == 2) {
                    UMRTLog.i("MobclickRT", "Zero req: succeed.");
                } else if (b2 && i2 == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i("MobclickRT", "Send instant data: succeed.");
                } else if (!a3 || i2 != 2) {
                    UMRTLog.i("MobclickRT", "Inner req: succeed.");
                } else {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i("MobclickRT", "Send analytics data: succeed.");
                }
            }
            if (i2 == 2) {
                e eVar = this.h;
                if (eVar != null) {
                    eVar.e();
                }
                StatTracer.getInstance(this.r).saveSate();
            } else if (i2 == 3) {
                StatTracer.getInstance(this.r).saveSate();
                if (c2) {
                    FieldManager.a().a(this.r);
                    UMRTLog.e("MobclickRT", "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.r;
                    UMWorkDispatch.sendEvent(context, 32784, b.a(context).a(), null);
                    return true;
                }
            }
            if (i2 == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new bl(new ca.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.g.b(response.getImprint());
                this.g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
