package com.huawei.agconnect;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.core.a.a;

public abstract class AGConnectInstance {
    private static AGConnectInstance INSTANCE;

    public static AGConnectInstance getInstance() {
        return INSTANCE;
    }

    public static synchronized void initialize(Context context) {
        synchronized (AGConnectInstance.class) {
            Log.i("AGConnectInstance", "AGConnectInstance#initialize");
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (INSTANCE == null) {
                INSTANCE = new a(context);
            }
        }
    }

    public abstract Context getContext();

    public abstract <T> T getService(Class<? super T> cls);
}
