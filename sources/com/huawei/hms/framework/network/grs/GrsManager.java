package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.BasePlugin;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import java.io.IOException;

public class GrsManager implements BasePlugin {
    private static final int GRS_KEY_INDEX = 1;
    private static final int GRS_PATH_INDEX = 2;
    private static final String GRS_SCHEMA = "grs://";
    private static final int GRS_SERVICE_INDEX = 0;
    private static final int MAX_GRS_SPLIT = 3;
    private static final String SEPARATOR = "/";
    private static final String TAG = "GrsManager";
    private static volatile GrsManager instance;
    private GrsConfig grsConfig;
    private e grsInterceptor;

    private GrsManager() {
    }

    public static GrsManager getInstance() {
        if (instance == null) {
            synchronized (GrsManager.class) {
                if (instance == null) {
                    instance = new GrsManager();
                }
            }
        }
        return instance;
    }

    private String getServiceNameUrl(String str, String str2) {
        return GrsApi.synGetGrsUrl(str, str2);
    }

    public static boolean isGRSSchema(String str) {
        return str != null && str.startsWith("grs://");
    }

    private String[] parseGRSSchema(String str) {
        return str.substring(str.toLowerCase().indexOf("grs://") + 6).split("/", 3);
    }

    public PluginInterceptor getInterceptor() {
        if (this.grsInterceptor == null) {
            this.grsInterceptor = new e();
        }
        return this.grsInterceptor;
    }

    public boolean initGrs(Context context, GrsConfig grsConfig2) {
        GrsConfig grsConfig3 = this.grsConfig;
        if (grsConfig3 != null && grsConfig3.equal(grsConfig2)) {
            return true;
        }
        this.grsConfig = grsConfig2;
        if (context != null) {
            context = context.getApplicationContext();
        }
        GrsConfig grsConfig4 = this.grsConfig;
        GrsApi.grsSdkInit(context, grsConfig4 != null ? grsConfig4.getGrsBaseInfo(context) : null);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071  */
    protected String parseGrs(String str) {
        String str2;
        String str3;
        String str4;
        if (str.endsWith("/")) {
            str = str.substring(str.indexOf("grs://"), str.length() - 1);
        }
        String[] parseGRSSchema = parseGRSSchema(str);
        if (parseGRSSchema.length == 1) {
            str3 = parseGRSSchema[0];
            str4 = "ROOT";
        } else if (parseGRSSchema.length >= 2) {
            str3 = parseGRSSchema[0];
            str4 = parseGRSSchema[1];
        } else {
            Logger.i("GrsManager", "parseGrs params.length<1.");
            str2 = "";
            if (!TextUtils.isEmpty(str2)) {
                throw new IOException("can not get url, do grsUrl(serviceName or key) error?");
            } else if (parseGRSSchema.length <= 2) {
                return str2;
            } else {
                if (str2.endsWith("/")) {
                    return str2 + parseGRSSchema[2];
                }
                return str2 + "/" + parseGRSSchema[2];
            }
        }
        str2 = getServiceNameUrl(str3, str4);
        if (!TextUtils.isEmpty(str2)) {
        }
    }
}
