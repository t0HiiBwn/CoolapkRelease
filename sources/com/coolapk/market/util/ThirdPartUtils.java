package com.coolapk.market.util;

import android.app.Application;
import android.content.Context;
import com.blankj.utilcode.util.LogUtils;
import com.coolapk.market.AppMetadata;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.widget.Toast;
import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.Map;

public class ThirdPartUtils {
    private String lastUid;

    public ThirdPartUtils(final Application application, AppMetadata appMetadata) {
        LogUtils.v("ThirdPartUtils init", new Object[0]);
        CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(application);
        userStrategy.setAppChannel(appMetadata.getChannel());
        userStrategy.setCrashHandleCallback((CrashReport.CrashHandleCallback) new CrashReport.CrashHandleCallback() {
            /* class com.coolapk.market.util.ThirdPartUtils.AnonymousClass1 */

            @Override // com.tencent.bugly.BuglyStrategy.a
            public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
                try {
                    LogUtils.file(str2 + "\n" + str3);
                } catch (Exception e) {
                    try {
                        Application application = application;
                        Toast.show(application, "Crash: " + e.getMessage());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return super.onCrashHandleStart(i, str, str2, str3);
            }

            @Override // com.tencent.bugly.BuglyStrategy.a
            public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
                return super.onCrashHandleStart2GetExtraDatas(i, str, str2, str3);
            }
        });
        CrashReport.initCrashReport(application, "900030315", false, userStrategy);
        LoginSession loginSession = DataManager.getInstance().getLoginSession();
        if (loginSession.isLogin()) {
            setUserId(loginSession.getUid());
        }
        LogUtils.v("ThirdPartUtils init end", new Object[0]);
    }

    public void log(String str, String str2) {
        BuglyLog.v(str, str2);
    }

    public void setUserId(String str) {
        this.lastUid = str;
        CrashReport.setUserId(str);
    }

    public void removeUserData(Context context) {
        String str = this.lastUid;
        if (str != null) {
            CrashReport.removeUserData(context, str);
        }
    }

    public void markException(Throwable th) {
        CrashReport.postCatchedException(th);
    }
}
