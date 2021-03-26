package com.alibaba.mtl.log.sign;

import android.content.Context;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.d.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class SecurityRequestAuth implements IRequestAuth {
    private boolean F = false;
    private String Z;
    private Class a = null;

    /* renamed from: a  reason: collision with other field name */
    private Field f67a = null;

    /* renamed from: a  reason: collision with other field name */
    private Method f68a = null;
    private Object b = null;

    /* renamed from: b  reason: collision with other field name */
    private Field f69b = null;
    private Object c = null;

    /* renamed from: c  reason: collision with other field name */
    private Field f70c = null;
    private String g = null;
    private int z = 1;

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getAppkey() {
        return this.g;
    }

    public SecurityRequestAuth(String str, String str2) {
        this.g = str;
        this.Z = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
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
                    this.b = cls.getMethod("getInstance", Context.class).invoke(null, a.getContext());
                    this.c = cls.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.b, new Object[0]);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                cls = null;
                i.a("SecurityRequestAuth", "initSecurityCheck", th);
                if (cls != null) {
                }
                this.F = true;
            }
            if (cls != null) {
                try {
                    Class<?> cls3 = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
                    this.a = cls3;
                    this.f67a = cls3.getDeclaredField("appKey");
                    this.f69b = this.a.getDeclaredField("paramMap");
                    this.f70c = this.a.getDeclaredField("requestType");
                    try {
                        method = cls.getMethod("isOpen", new Class[0]);
                    } catch (Throwable th4) {
                        i.a("SecurityRequestAuth", "initSecurityCheck", th4);
                        method = null;
                    }
                    if (method != null) {
                        z2 = ((Boolean) method.invoke(this.b, new Object[0])).booleanValue();
                    } else {
                        try {
                            cls2 = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                        } catch (Throwable th5) {
                            i.a("SecurityRequestAuth", "initSecurityCheck", th5);
                        }
                        z2 = cls2 == null;
                    }
                    this.z = z2 ? 1 : 12;
                    this.f68a = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", this.a, String.class);
                } catch (Throwable th6) {
                    i.a("SecurityRequestAuth", "initSecurityCheck", th6);
                }
            }
            this.F = true;
        }
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getSign(String str) {
        Class cls;
        if (!this.F) {
            E();
        }
        if (this.g == null) {
            i.a("SecurityRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null || this.b == null || (cls = this.a) == null || this.f67a == null || this.f69b == null || this.f70c == null || this.f68a == null || this.c == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.f67a.set(newInstance, this.g);
                ((Map) this.f69b.get(newInstance)).put("INPUT", str);
                this.f70c.set(newInstance, Integer.valueOf(this.z));
                return (String) this.f68a.invoke(this.c, newInstance, this.Z);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
