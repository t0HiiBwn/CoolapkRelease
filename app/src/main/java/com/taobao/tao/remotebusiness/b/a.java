package com.taobao.tao.remotebusiness.b;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import mtopsdk.mtop.common.MtopListener;

/* compiled from: DynamicProxyHandler */
final class a implements InvocationHandler {
    private d a;
    private f b;
    private c c;
    private MtopBusiness d;
    private MtopListener e;

    public a(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        this.a = new d(mtopBusiness, mtopListener);
        this.d = mtopBusiness;
        this.e = mtopListener;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        name.hashCode();
        char c2 = 65535;
        switch (name.hashCode()) {
            case -1809154262:
                if (name.equals("onDataReceived")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1030363105:
                if (name.equals("onCached")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1177139532:
                if (name.equals("onHeader")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2096292721:
                if (name.equals("onFinished")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 2:
                if (this.b == null) {
                    this.b = new f(this.d, this.e);
                }
                return method.invoke(this.b, objArr);
            case 1:
                if (this.c == null) {
                    this.c = new c(this.d, this.e);
                }
                return method.invoke(this.c, objArr);
            case 3:
                return method.invoke(this.a, objArr);
            default:
                return null;
        }
    }
}
