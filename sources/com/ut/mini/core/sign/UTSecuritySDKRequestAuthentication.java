package com.ut.mini.core.sign;

import android.content.Context;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.d.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class UTSecuritySDKRequestAuthentication implements IUTRequestAuthentication {
    private boolean F = false;
    private String Z;
    private Class a = null;

    /* renamed from: a  reason: collision with other field name */
    private Field f100a = null;

    /* renamed from: a  reason: collision with other field name */
    private Method f101a = null;
    private Object b = null;

    /* renamed from: b  reason: collision with other field name */
    private Field f102b = null;
    private Object c = null;

    /* renamed from: c  reason: collision with other field name */
    private Field f103c = null;
    private String g = null;
    private int z = 1;

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.g;
    }

    public UTSecuritySDKRequestAuthentication(String str, String str2) {
        this.g = str;
        this.Z = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    private synchronized void E() {
        Class<?> cls;
        Method method;
        boolean z2;
        Throwable th;
        if (!this.F) {
            Class<?> cls2 = null;
            try {
                cls = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
                try {
                    this.b = cls.getMethod("getInstance", Context.class).invoke(null, b.a().getContext());
                    this.c = cls.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.b, new Object[0]);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                cls = null;
                i.a("initSecurityCheck", th.getMessage());
                if (cls != null) {
                }
                this.F = true;
            }
            if (cls != null) {
                try {
                    Class<?> cls3 = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
                    this.a = cls3;
                    this.f100a = cls3.getDeclaredField("appKey");
                    this.f102b = this.a.getDeclaredField("paramMap");
                    this.f103c = this.a.getDeclaredField("requestType");
                    try {
                        method = cls.getMethod("isOpen", new Class[0]);
                    } catch (Throwable th4) {
                        i.a("initSecurityCheck", th4.getMessage());
                        method = null;
                    }
                    if (method != null) {
                        z2 = ((Boolean) method.invoke(this.b, new Object[0])).booleanValue();
                    } else {
                        try {
                            cls2 = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                        } catch (Throwable th5) {
                            i.a("initSecurityCheck", th5.getMessage());
                        }
                        z2 = cls2 == null;
                    }
                    this.z = z2 ? 1 : 12;
                    this.f101a = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", this.a, String.class);
                } catch (Throwable th6) {
                    i.a("initSecurityCheck", th6.getMessage());
                }
            }
            this.F = true;
        }
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        Class cls;
        if (!this.F) {
            E();
        }
        if (this.g == null) {
            i.a("UTSecuritySDKRequestAuthentication:getSign", "There is no appkey,please check it!");
            return null;
        } else if (str == null || this.b == null || (cls = this.a) == null || this.f100a == null || this.f102b == null || this.f103c == null || this.f101a == null || this.c == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.f100a.set(newInstance, this.g);
                ((Map) this.f102b.get(newInstance)).put("INPUT", str);
                this.f103c.set(newInstance, Integer.valueOf(this.z));
                return (String) this.f101a.invoke(this.c, newInstance, this.Z);
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    public String getAuthCode() {
        return this.Z;
    }
}
