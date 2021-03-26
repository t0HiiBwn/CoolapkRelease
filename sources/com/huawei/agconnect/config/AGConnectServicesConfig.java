package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.a.a;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class AGConnectServicesConfig {
    private static final Map<String, AGConnectServicesConfig> INSTANCES = new HashMap();
    private static final Object INSTANCES_LOCK = new Object();

    public static AGConnectServicesConfig fromContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return fromContext(context, context.getPackageName());
    }

    public static AGConnectServicesConfig fromContext(Context context, String str) {
        AGConnectServicesConfig aGConnectServicesConfig;
        synchronized (INSTANCES_LOCK) {
            Map<String, AGConnectServicesConfig> map = INSTANCES;
            aGConnectServicesConfig = map.get(str);
            if (aGConnectServicesConfig == null) {
                aGConnectServicesConfig = new a(context, str);
                map.put(str, aGConnectServicesConfig);
            }
        }
        return aGConnectServicesConfig;
    }

    public abstract boolean getBoolean(String str);

    public abstract boolean getBoolean(String str, boolean z);

    public abstract int getInt(String str);

    public abstract int getInt(String str, int i);

    public abstract String getString(String str);

    public abstract String getString(String str, String str2);

    public abstract void overlayWith(LazyInputStream lazyInputStream);

    public abstract void overlayWith(InputStream inputStream);
}
