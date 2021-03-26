package com.coolapk.market.manager;

import android.app.Application;
import android.os.Build;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ReflectUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;

public class SystemHookManager {
    private Application context;

    public SystemHookManager(Application application) {
        this.context = application;
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            /* class com.coolapk.market.manager.SystemHookManager.AnonymousClass1 */

            public void call(Long l2) {
                SystemHookManager.this.hookActivityThreadHandler();
                if (26 >= Build.VERSION.SDK_INT) {
                    SystemHookManager.this.hookActivityMangerNativeOreo();
                } else {
                    SystemHookManager.this.hookActivityManagerNative();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean hookActivityThreadHandler() {
        try {
            ReflectUtils.wrap(AppHolder.getApplication()).getChildField("mLoadedApk").getChildField("mActivityThread").getChildField("mH").setChildField("mCallback", new ActivityThreadHandlerCallback());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean hookActivityManagerNative() {
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            ReflectUtils.ReflectObject wrap = ReflectUtils.wrap(ReflectUtils.findField(systemClassLoader.loadClass("android.app.ActivityManagerNative"), "gDefault").get(null));
            wrap.setChildField("mInstance", Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{systemClassLoader.loadClass("android.app.IActivityManager")}, new ActivityManagerHook(wrap.getChildField("mInstance").get())));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean hookActivityMangerNativeOreo() {
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            ReflectUtils.ReflectObject wrap = ReflectUtils.wrap(ReflectUtils.findField(systemClassLoader.loadClass("android.app.ActivityManager"), "IActivityManagerSingleton").get(null));
            wrap.setChildField("mInstance", Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{systemClassLoader.loadClass("android.app.IActivityManager")}, new ActivityManagerHook(wrap.getChildField("mInstance").get())));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static abstract class BaseHandler implements InvocationHandler {
        private Object mOrigin;

        public BaseHandler(Object obj) {
            this.mOrigin = obj;
        }

        public Object getOrigin() {
            return this.mOrigin;
        }

        public Object invokeDirect(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return method.invoke(obj, objArr);
            } catch (UndeclaredThrowableException e) {
                throw e.getCause();
            }
        }

        public Object invokeTryCatch(Object obj, Method method, Object[] objArr) {
            try {
                return method.invoke(obj, objArr);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
