package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.x;

/* compiled from: BUGLY */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;
    private static int c;
    private static CrashModule e = new CrashModule();
    private long a;
    private BuglyStrategy.a b;
    private boolean d = false;

    public static CrashModule getInstance() {
        e.id = 1004;
        return e;
    }

    public synchronized boolean hasInitialized() {
        return this.d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008a  */
    @Override // com.tencent.bugly.a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        if (context != null) {
            if (!this.d) {
                x.a("Initializing crash module.", new Object[0]);
                n a2 = n.a();
                int i = c + 1;
                c = i;
                a2.a(1004, i);
                this.d = true;
                CrashReport.setContext(context);
                a(context, buglyStrategy);
                c a3 = c.a(1004, context, z, this.b, (o) null, (String) null);
                a3.e();
                if (buglyStrategy != null) {
                    a3.a(buglyStrategy.getCallBackType());
                    a3.a(buglyStrategy.getCloseErrorCallback());
                }
                if (buglyStrategy != null && buglyStrategy.isEnableCatchAnrTrace()) {
                    a3.j();
                }
                a3.n();
                if (buglyStrategy != null) {
                    if (!buglyStrategy.isEnableNativeCrashMonitor()) {
                        x.a("[crash] Closed native crash monitor!", new Object[0]);
                        a3.f();
                        if (buglyStrategy != null) {
                            if (!buglyStrategy.isEnableANRCrashMonitor()) {
                                x.a("[crash] Closed ANR monitor!", new Object[0]);
                                a3.i();
                                a3.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0);
                                a3.m();
                                d.a(context);
                                BuglyBroadcastReceiver instance = BuglyBroadcastReceiver.getInstance();
                                instance.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                                instance.register(context);
                                n a4 = n.a();
                                int i2 = c - 1;
                                c = i2;
                                a4.a(1004, i2);
                            }
                        }
                        a3.h();
                        a3.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0);
                        a3.m();
                        d.a(context);
                        BuglyBroadcastReceiver instance = BuglyBroadcastReceiver.getInstance();
                        instance.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        instance.register(context);
                        n a4 = n.a();
                        int i2 = c - 1;
                        c = i2;
                        a4.a(1004, i2);
                    }
                }
                a3.g();
                if (buglyStrategy != null) {
                }
                a3.h();
                a3.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0);
                a3.m();
                d.a(context);
                BuglyBroadcastReceiver instance = BuglyBroadcastReceiver.getInstance();
                instance.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                instance.register(context);
                n a4 = n.a();
                int i2 = c - 1;
                c = i2;
                a4.a(1004, i2);
            }
        }
    }

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy != null) {
            String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
            if (!TextUtils.isEmpty(libBuglySOFilePath)) {
                a.a(context).n = libBuglySOFilePath;
                x.a("setted libBugly.so file path :%s", libBuglySOFilePath);
            }
            if (buglyStrategy.getCrashHandleCallback() != null) {
                this.b = buglyStrategy.getCrashHandleCallback();
                x.a("setted CrashHanldeCallback", new Object[0]);
            }
            if (buglyStrategy.getAppReportDelay() > 0) {
                long appReportDelay = buglyStrategy.getAppReportDelay();
                this.a = appReportDelay;
                x.a("setted delay: %d", Long.valueOf(appReportDelay));
            }
        }
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        c a2;
        if (strategyBean != null && (a2 = c.a()) != null) {
            a2.a(strategyBean);
        }
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }
}
