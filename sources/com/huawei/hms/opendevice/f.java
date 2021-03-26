package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: QueryGrs */
public abstract class f {
    public static String a(Context context) {
        String string = AGConnectServicesConfig.fromContext(context).getString("region");
        if (TextUtils.isEmpty(string)) {
            HMSLog.i("QueryGrs", "The data storage region is empty.");
            return "";
        }
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(string);
        String synGetGrsUrl = new GrsClient(context, grsBaseInfo).synGetGrsUrl("com.huawei.hms.opendevicesdk", "ROOT");
        if (TextUtils.isEmpty(synGetGrsUrl)) {
            HMSLog.i("QueryGrs", "Query Grs base url is empty.");
            return "";
        }
        HMSLog.i("QueryGrs", "Query Grs base url: " + synGetGrsUrl);
        return synGetGrsUrl;
    }
}
