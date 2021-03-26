package com.tencent.msdk.dns.base.d;

import android.app.Activity;
import android.content.Context;

/* compiled from: Platform */
public class a {
    private static a a = c();

    public Activity b() {
        return null;
    }

    private a() {
    }

    public static a a() {
        return a;
    }

    private static a c() {
        a c2 = C0129a.c();
        if (c2 != null) {
            return c2;
        }
        a c3 = b.c();
        if (c3 != null) {
            return c3;
        }
        a c4 = c.c();
        if (c4 != null) {
            return c4;
        }
        return new a();
    }

    /* renamed from: com.tencent.msdk.dns.base.d.a$a  reason: collision with other inner class name */
    /* compiled from: Platform */
    private static class C0129a extends a {
        private static Class a;
        private Activity b = null;

        private C0129a() {
            super();
        }

        static {
            try {
                a = Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
            } catch (Throwable unused) {
                a = null;
            }
        }

        static a c() {
            if (a == null) {
                return null;
            }
            return new C0129a();
        }

        @Override // com.tencent.msdk.dns.base.d.a
        public Activity b() {
            Activity activity = this.b;
            if (activity != null) {
                return activity;
            }
            try {
                Context context = (Context) a.getMethod("getContext", new Class[0]).invoke(null, new Object[0]);
                if (context instanceof Activity) {
                    this.b = (Activity) context;
                }
            } catch (Throwable th) {
                com.tencent.msdk.dns.base.log.b.b(th, "Get Activity failed", new Object[0]);
            }
            return this.b;
        }
    }

    /* compiled from: Platform */
    private static class b extends a {
        private static Class a;

        private b() {
            super();
        }

        static {
            try {
                a = Class.forName("com.unity3d.player.UnityPlayer");
            } catch (Throwable unused) {
                a = null;
            }
        }

        static a c() {
            if (a == null) {
                return null;
            }
            return new b();
        }

        @Override // com.tencent.msdk.dns.base.d.a
        public Activity b() {
            try {
                return (Activity) a.getField("currentActivity").get(null);
            } catch (Throwable th) {
                com.tencent.msdk.dns.base.log.b.b(th, "Get Activity failed", new Object[0]);
                return null;
            }
        }
    }

    /* compiled from: Platform */
    private static class c extends a {
        private static Class a;

        private c() {
            super();
        }

        static {
            try {
                a = Class.forName("com.epicgames.ue4.GameActivity");
            } catch (Throwable unused) {
                a = null;
            }
        }

        static a c() {
            if (a == null) {
                return null;
            }
            return new c();
        }

        @Override // com.tencent.msdk.dns.base.d.a
        public Activity b() {
            try {
                return (Activity) a.getMethod("Get", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.tencent.msdk.dns.base.log.b.b(th, "Get Activity failed", new Object[0]);
                return null;
            }
        }
    }
}
