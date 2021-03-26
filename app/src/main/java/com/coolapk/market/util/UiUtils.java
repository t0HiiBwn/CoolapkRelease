package com.coolapk.market.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;

public class UiUtils {
    public static final int NO_POSITION = -1;
    private static Field solidColorsField;
    private static Field strokeWidthField;

    public static boolean isInvalidPosition(int i) {
        return i == -1;
    }

    public static Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        Toast.show(context, "this context doesn't contain activity");
        throw new NullPointerException("this context doesn't contain activity");
    }

    public static Activity getActivityNullable(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivityNullable(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static Bitmap takeSnapshot(View view) {
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        return createBitmap;
    }

    public static Bitmap takeScaledSnapshot(View view, int i) {
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(drawingCache, drawingCache.getWidth() / i, drawingCache.getHeight() / i, false);
        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        return createScaledBitmap;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getStatusBarHeight(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (hasNavigationBar(context) && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean hasNavigationBar(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point fullWindowsPoint = getFullWindowsPoint(context);
        return Math.max(fullWindowsPoint.y, fullWindowsPoint.x) > Math.max(point.y, point.x);
    }

    private static Point getFullWindowsPoint(Context context) {
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
                defaultDisplay.getSize(point);
            }
        } else {
            defaultDisplay.getSize(point);
        }
        return point;
    }

    public static int getActionBarSize(Context context) {
        return context.getResources().getDimensionPixelSize(2131165599);
    }

    public static boolean canScrollDown(View view) {
        return ViewCompat.canScrollVertically(view, -1);
    }

    public static boolean canScrollRight(View view) {
        return ViewCompat.canScrollHorizontally(view, -1);
    }

    public static void tintBackground(View view, int i) {
        Drawable background = view.getBackground();
        if (background != null) {
            background.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            view.setBackground(background);
        }
    }

    public static <T extends View> T findFirstChildViewByType(ViewGroup viewGroup, Class<T> cls) {
        T t;
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            T t2 = (T) viewGroup.getChildAt(i);
            if (cls.isAssignableFrom(t2.getClass())) {
                return t2;
            }
            if ((t2 instanceof ViewGroup) && (t = (T) findFirstChildViewByType((ViewGroup) t2, cls)) != null) {
                return t;
            }
        }
        return null;
    }

    public static boolean canVerticalScroll(EditText editText) {
        int scrollY = editText.getScrollY();
        int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height - 1;
    }

    public static boolean canScrollUp(View view) {
        return ViewCompat.canScrollVertically(view, 1);
    }

    public static Drawable createInsertDivider(Context context, int i, int i2, int i3, int i4, int i5) {
        Drawable drawable = ResourceUtils.getDrawable(context, i);
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? drawable : new InsetDrawable(drawable, i2, i3, i4, i5);
    }

    public static TextView getToolbarTitleView(Toolbar toolbar) {
        try {
            return (TextView) ReflectUtils.findField(toolbar.getClass(), "mTitleTextView").get(toolbar);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void closeKeyboard(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void openKeyboard(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    public static void fastScrollToTop(RecyclerView recyclerView) {
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                recyclerView.stopScroll();
                recyclerView.stopNestedScroll();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
                return;
            }
            layoutManager.scrollToPosition(0);
        }
    }

    public static View getToolbarNavigationIcon(Toolbar toolbar) {
        boolean isEmpty = TextUtils.isEmpty(toolbar.getNavigationContentDescription());
        String navigationContentDescription = !isEmpty ? toolbar.getNavigationContentDescription() : "navigationIcon";
        toolbar.setNavigationContentDescription(navigationContentDescription);
        ArrayList<View> arrayList = new ArrayList<>();
        toolbar.findViewsWithText(arrayList, navigationContentDescription, 2);
        View view = arrayList.size() > 0 ? arrayList.get(0) : null;
        if (isEmpty) {
            toolbar.setNavigationContentDescription((CharSequence) null);
        }
        return view;
    }

    public static View getToolbarLogo(Toolbar toolbar) {
        boolean isEmpty = TextUtils.isEmpty(toolbar.getLogoDescription());
        String logoDescription = !isEmpty ? toolbar.getLogoDescription() : "logoIcon";
        toolbar.setLogoDescription(logoDescription);
        ArrayList<View> arrayList = new ArrayList<>();
        toolbar.findViewsWithText(arrayList, logoDescription, 2);
        View view = arrayList.size() > 0 ? arrayList.get(0) : null;
        if (isEmpty) {
            toolbar.setLogoDescription((CharSequence) null);
        }
        return view;
    }

    public static void setDrawableSolidColors(Drawable drawable, int[] iArr, int i) {
        GradientDrawable targetDrawable = getTargetDrawable(drawable, 0, iArr);
        if (targetDrawable != null) {
            targetDrawable.setColor(i);
        }
    }

    public static void setDrawableStrokeColors(Drawable drawable, int[] iArr, int i) {
        GradientDrawable targetDrawable = getTargetDrawable(drawable, 0, iArr);
        if (targetDrawable != null) {
            targetDrawable.getConstantState();
            try {
                if (strokeWidthField == null) {
                    Field field = Class.forName("android.graphics.drawable.GradientDrawable$GradientState").getField("mStrokeWidth");
                    strokeWidthField = field;
                    field.setAccessible(true);
                }
                int i2 = strokeWidthField.getInt(targetDrawable.getConstantState());
                if (i2 >= 0) {
                    targetDrawable.setStroke(i2, i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setDrawableColors(Drawable drawable, int[] iArr, int i) {
        GradientDrawable targetDrawable = getTargetDrawable(drawable, 0, iArr);
        if (targetDrawable != null) {
            targetDrawable.getConstantState();
            try {
                if (solidColorsField == null || strokeWidthField == null) {
                    Class<?> cls = Class.forName("android.graphics.drawable.GradientDrawable$GradientState");
                    Field field = cls.getField("mSolidColors");
                    solidColorsField = field;
                    field.setAccessible(true);
                    Field field2 = cls.getField("mStrokeWidth");
                    strokeWidthField = field2;
                    field2.setAccessible(true);
                }
                if (solidColorsField.get(targetDrawable.getConstantState()) != null) {
                    targetDrawable.setColor(i);
                }
                int i2 = strokeWidthField.getInt(targetDrawable.getConstantState());
                if (i2 >= 0) {
                    targetDrawable.setStroke(i2, i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static GradientDrawable getTargetDrawable(Drawable drawable, int i, int[] iArr) {
        if (i >= iArr.length) {
            return null;
        }
        if (drawable instanceof GradientDrawable) {
            return (GradientDrawable) drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            return null;
        }
        Drawable drawable2 = ((LayerDrawable) drawable).getDrawable(iArr[i]);
        if (drawable2 instanceof GradientDrawable) {
            return (GradientDrawable) drawable2;
        }
        if (drawable2 instanceof LayerDrawable) {
            return getTargetDrawable(drawable, i + 1, iArr);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    public static void changeLanguage(Context context, String str) {
        char c;
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int hashCode = str.hashCode();
        if (hashCode != -887328209) {
            if (hashCode != -704712386) {
                if (hashCode != -704711850) {
                    if (hashCode == 3383 && str.equals("ja")) {
                        c = 2;
                        if (c == 0) {
                            configuration.locale = Locale.getDefault();
                        } else if (c == 1) {
                            configuration.locale = Locale.TAIWAN;
                        } else if (c != 2) {
                            configuration.locale = Locale.SIMPLIFIED_CHINESE;
                        } else {
                            configuration.locale = Locale.JAPANESE;
                        }
                        resources.updateConfiguration(configuration, displayMetrics);
                    }
                } else if (str.equals("zh-rTW")) {
                    c = 1;
                    if (c == 0) {
                    }
                    resources.updateConfiguration(configuration, displayMetrics);
                }
            } else if (str.equals("zh-rCN")) {
                c = 4;
                if (c == 0) {
                }
                resources.updateConfiguration(configuration, displayMetrics);
            }
        } else if (str.equals("system")) {
            c = 0;
            if (c == 0) {
            }
            resources.updateConfiguration(configuration, displayMetrics);
        }
        c = 65535;
        if (c == 0) {
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public static FrameLayout getContentView(Activity activity) {
        return (FrameLayout) activity.findViewById(16908290);
    }

    public static void fixContentViewInitFailError(AppCompatActivity appCompatActivity) {
        if (appCompatActivity.getWindow().getDecorView().findViewById(16908290) == null) {
            FrameLayout frameLayout = new FrameLayout(appCompatActivity);
            frameLayout.setId(16908290);
            appCompatActivity.getWindow().setContentView(frameLayout);
        }
    }

    public static boolean isHideNavigationBar(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0;
    }
}
