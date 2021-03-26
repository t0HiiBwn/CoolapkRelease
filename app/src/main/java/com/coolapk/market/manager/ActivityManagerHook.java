package com.coolapk.market.manager;

import android.content.ComponentName;
import android.os.DeadObjectException;
import com.coolapk.market.manager.SystemHookManager;
import java.lang.reflect.Method;

public class ActivityManagerHook extends SystemHookManager.BaseHandler {
    ActivityManagerHook(Object obj) {
        super(obj);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        name.hashCode();
        int i = 0;
        char c = 65535;
        switch (name.hashCode()) {
            case -1528850031:
                if (name.equals("startActivity")) {
                    c = 0;
                    break;
                }
                break;
            case -1358530626:
                if (name.equals("activityStopped")) {
                    c = 1;
                    break;
                }
                break;
            case 1849706483:
                if (name.equals("startService")) {
                    c = 2;
                    break;
                }
                break;
        }
        Integer num = null;
        switch (c) {
            case 0:
                try {
                    num = (Integer) invokeDirect(getOrigin(), method, objArr);
                } catch (NullPointerException e) {
                    if (!e.getMessage().contains("FileDescriptor must not be null")) {
                        throw e;
                    }
                } catch (DeadObjectException e2) {
                    e2.printStackTrace();
                }
                if (num != null) {
                    i = num.intValue();
                }
                return Integer.valueOf(i);
            case 1:
                invokeTryCatch(getOrigin(), method, objArr);
                return null;
            case 2:
                try {
                    return (ComponentName) invokeDirect(getOrigin(), method, objArr);
                } catch (IllegalArgumentException e3) {
                    if (e3.getMessage().contains("callingPackage cannot be null")) {
                        return null;
                    }
                    throw e3;
                }
            default:
                return invokeDirect(getOrigin(), method, objArr);
        }
    }
}
