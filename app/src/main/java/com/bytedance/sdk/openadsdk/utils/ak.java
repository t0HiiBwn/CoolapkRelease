package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: UIUtils */
public class ak {
    private static float a = -1.0f;
    private static int b = -1;
    private static float c = -1.0f;
    private static int d = -1;
    private static int e = -1;
    private static WindowManager f;
    private static float g;

    private static boolean a(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    static {
        a(p.a());
    }

    private static boolean b() {
        return a < 0.0f || b < 0 || c < 0.0f || d < 0 || e < 0;
    }

    public static void a(Context context) {
        Context a2 = context == null ? p.a() : context;
        f = (WindowManager) p.a().getSystemService("window");
        if (a2 != null) {
            if (b()) {
                DisplayMetrics displayMetrics = a2.getResources().getDisplayMetrics();
                a = displayMetrics.density;
                b = displayMetrics.densityDpi;
                c = displayMetrics.scaledDensity;
                d = displayMetrics.widthPixels;
                e = displayMetrics.heightPixels;
            }
            if (context != null && context.getResources() != null && context.getResources().getConfiguration() != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    int i = d;
                    int i2 = e;
                    if (i > i2) {
                        d = i2;
                        e = i;
                        return;
                    }
                    return;
                }
                int i3 = d;
                int i4 = e;
                if (i3 < i4) {
                    d = i4;
                    e = i3;
                }
            }
        }
    }

    public static float a(Context context, float f2) {
        a(context);
        return (f2 * e(context)) + 0.5f;
    }

    public static int b(Context context, float f2) {
        a(context);
        float e2 = e(context);
        if (e2 <= 0.0f) {
            e2 = 1.0f;
        }
        return (int) ((f2 / e2) + 0.5f);
    }

    public static int[] b(Context context) {
        if (context == null) {
            return null;
        }
        if (f == null) {
            f = (WindowManager) p.a().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = f;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
                try {
                    i = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    i2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    Point point = new Point();
                    Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                    i = point.x;
                    i2 = point.y;
                } catch (Exception unused2) {
                }
            }
            iArr[0] = i;
            iArr[1] = i2;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int c(Context context) {
        a(context);
        return d;
    }

    public static int d(Context context) {
        a(context);
        return e;
    }

    public static float e(Context context) {
        a(context);
        return a;
    }

    public static int f(Context context) {
        a(context);
        return b;
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new n(rect, view));
    }

    public static int[] a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] b(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] c(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static void a(View view, int i) {
        if (view != null && view.getVisibility() != i && a(i)) {
            view.setVisibility(i);
        }
    }

    public static void a(View view, float f2) {
        if (view != null) {
            view.setAlpha(f2);
        }
    }

    public static boolean d(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean e(View view) {
        return view != null && view.getVisibility() == 0 && view.getAlpha() == 1.0f;
    }

    public static boolean a(WebView webView) {
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        webView.goBack();
        return true;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setText(charSequence);
        }
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            a(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
        }
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view != null && marginLayoutParams != null) {
            if (marginLayoutParams.leftMargin != i || marginLayoutParams.topMargin != i2 || marginLayoutParams.rightMargin != i3 || marginLayoutParams.bottomMargin != i4) {
                if (i != -3) {
                    marginLayoutParams.leftMargin = i;
                }
                if (i2 != -3) {
                    marginLayoutParams.topMargin = i2;
                }
                if (i3 != -3) {
                    marginLayoutParams.rightMargin = i3;
                }
                if (i4 != -3) {
                    marginLayoutParams.bottomMargin = i4;
                }
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public static boolean a() {
        try {
            return !((KeyguardManager) p.a().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i = 1;
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", i.d().a() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                if (!(!a())) {
                    i = 0;
                }
                jSONObject.put("lock_scene", i);
            }
        } catch (Throwable th) {
            u.b("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    private static Bitmap c(WebView webView) {
        try {
            Picture capturePicture = webView.capturePicture();
            if (capturePicture == null || capturePicture.getWidth() <= 0) {
                return null;
            }
            if (capturePicture.getHeight() <= 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            capturePicture.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void f(final View view) {
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            ofFloat.addListener(new AnimatorListenerAdapter() {
                /* class com.bytedance.sdk.openadsdk.utils.ak.AnonymousClass1 */

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ak.a(view, 8);
                    ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
                }
            });
            ofFloat.setDuration(800L);
            ofFloat.start();
        }
    }

    public static void g(View view) {
        if (view != null) {
            a(view, 0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            ofFloat.addListener(new AnimatorListenerAdapter() {
                /* class com.bytedance.sdk.openadsdk.utils.ak.AnonymousClass2 */

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int g(Context context) {
        if (context == null) {
            context = p.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int h(Context context) {
        if (context == null) {
            context = p.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float i(Context context) {
        if (context == null) {
            context = p.a();
        }
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return (float) context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
    }

    public static void a(Activity activity) {
        if (activity != null) {
            try {
                if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(8);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(3846);
                    activity.getWindow().addFlags(134217728);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void h(View view) {
        if (view != null) {
            try {
                if (Build.VERSION.SDK_INT >= 28 && g == 0.0f) {
                    DisplayCutout displayCutout = null;
                    WindowInsets rootWindowInsets = view.getRootWindowInsets();
                    if (rootWindowInsets != null) {
                        displayCutout = rootWindowInsets.getDisplayCutout();
                    }
                    if (displayCutout != null) {
                        g = (float) displayCutout.getSafeInsetTop();
                    }
                }
                if (g != 0.0f) {
                    float max = Math.max(i(view.getContext()), g);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.topMargin = (int) (((float) layoutParams2.topMargin) + max);
                    }
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams3.topMargin = (int) (((float) layoutParams3.topMargin) + max);
                    }
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
                        layoutParams4.topMargin = (int) (((float) layoutParams4.topMargin) + max);
                    }
                    view.setLayoutParams(layoutParams);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            u.f("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void a(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            u.f("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static Bitmap b(WebView webView) {
        int layerType = webView.getLayerType();
        webView.setLayerType(1, null);
        Bitmap d2 = d(webView);
        if (d2 == null) {
            d2 = c(webView);
        }
        webView.setLayerType(layerType, null);
        if (d2 == null) {
            return null;
        }
        return f.a(d2, d2.getWidth() / 6, d2.getHeight() / 6);
    }

    public static void a(final Context context, final l lVar, final String str, final String str2, final Bitmap bitmap, final boolean z, final int i) {
        e.a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.utils.ak.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                ak.c(context, lVar, str, str2, bitmap, z, i);
            }
        }, 5);
    }

    /* access modifiers changed from: private */
    public static void c(Context context, l lVar, String str, String str2, Bitmap bitmap, boolean z, int i) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                    if (!bitmap.isRecycled()) {
                        int a2 = a(bitmap);
                        if (a2 >= 50 || z) {
                            d.a(context, lVar, str, str2, a2, i);
                        }
                    }
                }
            } catch (Throwable th) {
                u.f("UIUtils", "(开发者可忽略此检测异常)checkWebViewIsTransparent->throwable ex>>>" + th.toString());
            }
        }
    }

    private static ArrayList<Integer> b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = iArr[i2];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i3) >> 16, (65280 & i3) >> 8, i3 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a(Bitmap bitmap) {
        try {
            ArrayList<Integer> b2 = b(bitmap);
            if (b2 == null) {
                return -1;
            }
            HashMap hashMap = new HashMap();
            Iterator<Integer> it2 = b2.iterator();
            while (it2.hasNext()) {
                Integer next = it2.next();
                if (hashMap.containsKey(next)) {
                    Integer valueOf = Integer.valueOf(((Integer) hashMap.get(next)).intValue() + 1);
                    hashMap.remove(next);
                    hashMap.put(next, valueOf);
                } else {
                    hashMap.put(next, 1);
                }
            }
            int i = 0;
            int i2 = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((Integer) entry.getValue()).intValue();
                if (i2 < intValue) {
                    i = ((Integer) entry.getKey()).intValue();
                    i2 = intValue;
                }
            }
            if (i == 0) {
                return -1;
            }
            return (int) ((((float) i2) / (((float) (bitmap.getWidth() * bitmap.getHeight())) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static Bitmap d(WebView webView) {
        if (webView == null) {
            return null;
        }
        try {
            webView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());
            webView.setDrawingCacheEnabled(true);
            webView.buildDrawingCache();
            if (webView.getMeasuredWidth() > 0) {
                if (webView.getMeasuredHeight() > 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(webView.getMeasuredWidth(), webView.getMeasuredHeight(), Bitmap.Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(createBitmap, 0.0f, (float) createBitmap.getHeight(), new Paint());
                    webView.draw(canvas);
                    return createBitmap;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
