package com.bytedance.sdk.openadsdk.i.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.reflect.Method;

/* compiled from: StorageList */
public class c {
    private static c e;
    private Context a = null;
    private Object b = null;
    private Method c = null;
    private Method d = null;

    public static c a() {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c();
                }
            }
        }
        return e;
    }

    private c() {
        Context a2 = p.a();
        this.a = a2;
        if (a2 != null) {
            Object systemService = a2.getSystemService("storage");
            this.b = systemService;
            try {
                this.c = systemService.getClass().getMethod("getVolumeList", new Class[0]);
                this.d = this.b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean b() {
        Method method;
        Object obj = this.b;
        if (!(obj == null || (method = this.c) == null || this.d == null)) {
            try {
                Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                if (objArr != null) {
                    if (objArr.length != 0) {
                        Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                        Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                        if (method2 != null) {
                            if (method3 != null) {
                                for (Object obj2 : objArr) {
                                    if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue()) {
                                        if (this.d.invoke(this.b, (String) method2.invoke(obj2, new Object[0])).equals("mounted")) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
