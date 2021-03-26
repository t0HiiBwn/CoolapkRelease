package com.ali.auth.third.core.registry.a;

import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.registry.ServiceRegistration;
import com.ali.auth.third.core.registry.a;
import com.ali.auth.third.core.trace.SDKLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class b implements a {
    private a a;

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.ali.auth.third.core.registry.a
    public ServiceRegistration a(Class<?>[] clsArr, Object obj, Map<String, String> map) {
        return this.a.a(clsArr, obj, map);
    }

    @Override // com.ali.auth.third.core.registry.a
    public Object a(ServiceRegistration serviceRegistration) {
        return this.a.a(serviceRegistration);
    }

    @Override // com.ali.auth.third.core.registry.a
    public <T> T a(final Class<T> cls, final Map<String, String> map) {
        T t = (T) this.a.a(cls, map);
        if (t != null || map == null) {
            return t;
        }
        map.get("$isv_scope$");
        return cls.isInterface() ? cls.cast(Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            /* class com.ali.auth.third.core.registry.a.b.AnonymousClass1 */

            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002a: APUT  (r4v2 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r0v4 java.lang.String) */
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                Object a2 = b.this.a.a(cls, map);
                if (a2 != null) {
                    return method.invoke(a2, objArr);
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = cls.getName();
                Map map = map;
                objArr2[1] = map != null ? map.toString() : "";
                SDKLogger.e("kernel", Message.create(17, objArr2).toString());
                return null;
            }
        })) : t;
    }

    @Override // com.ali.auth.third.core.registry.a
    public <T> T[] b(Class<T> cls, Map<String, String> map) {
        return (T[]) this.a.b(cls, map);
    }
}
