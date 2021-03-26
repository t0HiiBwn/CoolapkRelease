package com.bytedance.embedapplog;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class bh {
    static Class a;
    private static Object b;
    private static Field c;
    private static Class d;
    private static Class<?> e;
    private static Method f;
    private static boolean g;
    private static boolean h;
    private static boolean i;

    public static void a() {
        String str;
        if (!g) {
            try {
                Class<?> cls = Class.forName(Build.VERSION.SDK_INT >= 17 ? "android.view.WindowManagerGlobal" : "android.view.WindowManagerImpl");
                if (Build.VERSION.SDK_INT >= 17) {
                    str = "sDefaultWindowManager";
                } else {
                    str = Build.VERSION.SDK_INT >= 13 ? "sWindowManager" : "mWindowManager";
                }
                c = cls.getDeclaredField("mViews");
                Field declaredField = cls.getDeclaredField(str);
                c.setAccessible(true);
                if (c.getType() == ArrayList.class) {
                    h = true;
                } else if (c.getType() == View[].class) {
                    i = true;
                }
                declaredField.setAccessible(true);
                b = declaredField.get(null);
            } catch (NoSuchFieldException e2) {
                bo.a(e2);
            } catch (IllegalAccessException e3) {
                bo.a(e3);
            } catch (ClassNotFoundException e4) {
                bo.a(e4);
            }
            try {
                e = Class.forName("com.android.internal.view.menu.ListMenuItemView");
                f = Class.forName("com.android.internal.view.menu.MenuView$ItemView").getDeclaredMethod("getItemData", new Class[0]);
            } catch (ClassNotFoundException e5) {
                bo.a(e5);
            } catch (NoSuchMethodException e6) {
                bo.a(e6);
            }
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        d = Class.forName("com.android.internal.policy.PhoneWindow$DecorView");
                    } catch (ClassNotFoundException unused) {
                        d = Class.forName("com.android.internal.policy.DecorView");
                    }
                } else {
                    d = Class.forName("com.android.internal.policy.impl.PhoneWindow$DecorView");
                }
            } catch (ClassNotFoundException e7) {
                bo.a(e7);
            }
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    a = Class.forName("android.widget.PopupWindow$PopupDecorView");
                } else {
                    a = Class.forName("android.widget.PopupWindow$PopupViewContainer");
                }
            } catch (ClassNotFoundException e8) {
                bo.a(e8);
            }
            g = true;
        }
    }

    public static View[] b() {
        View[] viewArr = new View[0];
        Object obj = b;
        if (obj == null) {
            Activity a2 = f.a();
            return a2 != null ? new View[]{a2.getWindow().getDecorView()} : viewArr;
        }
        View[] viewArr2 = null;
        try {
            if (h) {
                viewArr2 = (View[]) ((ArrayList) c.get(obj)).toArray(viewArr);
            } else if (i) {
                viewArr2 = (View[]) c.get(obj);
            }
            if (viewArr2 != null) {
                viewArr = viewArr2;
            }
        } catch (Exception e2) {
            bo.a(e2);
        }
        return a(viewArr);
    }

    private static View[] a(View[] viewArr) {
        ArrayList arrayList = new ArrayList(viewArr.length);
        int length = viewArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            View view = viewArr[(length - 1) - i2];
            if (view != null && view.getWindowVisibility() == 0 && view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0 && !(view instanceof ca)) {
                arrayList.add(0, view);
                if (b(view)) {
                    break;
                }
            }
        }
        View[] viewArr2 = new View[arrayList.size()];
        arrayList.toArray(viewArr2);
        return viewArr2;
    }

    static String a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams) {
            int i2 = ((WindowManager.LayoutParams) layoutParams).type;
            if (i2 == 1) {
                return "/MainWindow";
            }
            if (i2 < 99 && view.getClass() == d) {
                return "/DialogWindow";
            }
            if (i2 < 1999 && view.getClass() == a) {
                return "/PopupWindow";
            }
            if (i2 < 2999) {
                return "/CustomWindow";
            }
        }
        Class<?> cls = view.getClass();
        if (cls == d) {
            return "/MainWindow";
        }
        return cls == a ? "/PopupWindow" : "/CustomWindow";
    }

    static boolean b(View view) {
        if (!g) {
            a();
        }
        Class<?> cls = view.getClass();
        return cls == d || cls == a;
    }

    static Object c(View view) {
        if (view.getClass() == e) {
            return f.invoke(view, new Object[0]);
        }
        if (bc.l(view)) {
            return ((ListMenuItemView) view).getItemData();
        }
        if (bc.k(view)) {
            return ((ListMenuItemView) view).getItemData();
        }
        return null;
    }
}
