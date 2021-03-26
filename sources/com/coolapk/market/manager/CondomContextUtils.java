package com.coolapk.market.manager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.LocalApkUtils;
import com.coolapk.market.widget.condom.CondomContext;
import java.util.ArrayList;
import java.util.List;

public class CondomContextUtils {
    public static CondomContext buildContext(Context context) {
        CondomContext wrap = CondomContext.wrap(context, "MiPush");
        wrap.setOutboundJudge(new CondomContext.OutboundJudge(context) {
            /* class com.coolapk.market.manager.CondomContextUtils.AnonymousClass1 */
            List<String> blackList = new ArrayList();
            final /* synthetic */ Context val$context;
            List<String> whiteList = new ArrayList();

            {
                this.val$context = r3;
                this.whiteList.add("com.xiaomi.xmsf");
                this.whiteList.add(r3.getPackageName());
            }

            @Override // com.coolapk.market.widget.condom.CondomContext.OutboundJudge
            public boolean shouldAllow(CondomContext.OutboundType outboundType, String str) {
                if (outboundType == CondomContext.OutboundType.START_SERVICE) {
                    return isPackageAllow(str);
                }
                return true;
            }

            private boolean isPackageAllow(String str) {
                if (this.whiteList.contains(str)) {
                    return true;
                }
                if (this.blackList.contains(str)) {
                    return false;
                }
                try {
                    if (LocalApkUtils.isSystemApp(AppHolder.getApplication().getPackageManager().getApplicationInfo(str, 0))) {
                        this.whiteList.add(str);
                        return true;
                    }
                    this.blackList.add(str);
                    return false;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        });
        return wrap;
    }
}
