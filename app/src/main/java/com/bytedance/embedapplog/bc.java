package com.bytedance.embedapplog;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class bc {
    static boolean a;
    private static Class b;
    private static Method c;
    private static boolean d = a("com.tencent.smtt.sdk.WebView");
    private static boolean e = a("androidx.recyclerview.widget.RecyclerView");
    private static boolean f = a("androidx.viewpager.widget.ViewPager");
    private static boolean g = a("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
    private static boolean h = a("androidx.fragment.app.Fragment");
    private static boolean i = a("androidx.fragment.app.FragmentActivity");
    private static boolean j = a("androidx.appcompat.app.AlertDialog");
    private static boolean k = a("androidx.appcompat.view.menu.ListMenuItemView");

    /* renamed from: l  reason: collision with root package name */
    private static boolean f1260l = a("androidx.recyclerview.widget.RecyclerView");
    private static boolean m = a("androidx.viewpager.widget.ViewPager");
    private static boolean n = a("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
    private static boolean o = a("androidx.fragment.app.Fragment");
    private static boolean p = a("androidx.fragment.app.FragmentActivity");
    private static boolean q = a("androidx.appcompat.app.AlertDialog");
    private static boolean r = a("androidx.appcompat.view.menu.ListMenuItemView");

    private static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static int a(View view, View view2) {
        try {
            if (view.getClass() == b) {
                return ((Integer) c.invoke(view, view2)).intValue();
            }
            return -1;
        } catch (IllegalAccessException e2) {
            bo.a(e2);
            return -1;
        } catch (InvocationTargetException e3) {
            bo.a(e3);
            return -1;
        }
    }

    static void a(Class<?> cls, String str) {
        if (!f1260l && !e && !a && str != null && str.contains("RecyclerView")) {
            try {
                if (a(cls) != null && c != null) {
                    b = cls;
                    a = true;
                }
            } catch (Exception e2) {
                bo.a(e2);
            }
        }
    }

    private static Class<?> a(Class<?> cls) {
        while (cls != null && !cls.equals(ViewGroup.class)) {
            try {
                c = cls.getDeclaredMethod("getChildAdapterPosition", View.class);
            } catch (NoSuchMethodException unused) {
            }
            if (c == null) {
                try {
                    c = cls.getDeclaredMethod("getChildPosition", View.class);
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (c != null) {
                return cls;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    static boolean a(Object obj) {
        return c(obj) || b(obj) || (a && obj != null && b.isAssignableFrom(obj.getClass()));
    }

    static boolean b(Object obj) {
        return e && (obj instanceof RecyclerView);
    }

    static boolean c(Object obj) {
        return f1260l && (obj instanceof RecyclerView);
    }

    static boolean d(Object obj) {
        return f && (obj instanceof ViewPager);
    }

    static boolean e(Object obj) {
        return m && (obj instanceof ViewPager);
    }

    static boolean f(Object obj) {
        return g && (obj instanceof SwipeRefreshLayout);
    }

    static boolean g(Object obj) {
        return n && (obj instanceof SwipeRefreshLayout);
    }

    static boolean h(Object obj) {
        return d && (obj instanceof WebView);
    }

    public static boolean i(Object obj) {
        return j && (obj instanceof AlertDialog);
    }

    public static boolean j(Object obj) {
        return q && (obj instanceof AlertDialog);
    }

    static boolean k(Object obj) {
        return k && (obj instanceof ListMenuItemView);
    }

    static boolean l(Object obj) {
        return r && (obj instanceof ListMenuItemView);
    }
}
