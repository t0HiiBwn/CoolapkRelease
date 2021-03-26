package com.jd.kepler.res;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.kepler.sdk.af;
import com.kepler.sdk.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ApkResources {
    public static float DEVICE_DENSITY = -1.0f;
    public static final String TYPE_ANIM = "anim";
    public static final String TYPE_ARRAY = "array";
    public static final String TYPE_ATTR = "attr";
    public static final String TYPE_COLOR = "color";
    public static final String TYPE_DIMEN = "dimen";
    public static final String TYPE_DRAWABLE = "drawable";
    public static final String TYPE_ID = "id";
    public static final String TYPE_LAYOUT = "layout";
    public static final String TYPE_PLURALS = "plurals";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_STYLE = "style";
    private static volatile ApkResources g;
    private Resources a;
    private ContextWrapper b;
    private Application c;
    private boolean d;
    private Map<String, Integer> e = new HashMap();
    private final LongSparseArray<WeakReference<Drawable.ConstantState>> f = new LongSparseArray<>();

    private ApkResources() {
    }

    public static ApkResources getSingleton() {
        if (g == null) {
            synchronized (ApkResources.class) {
                if (g == null) {
                    g = new ApkResources();
                }
            }
        }
        return g;
    }

    public Resources getResources() {
        return this.a;
    }

    public void init(Application application, String str) {
        this.c = application;
        if (af.c(str)) {
            this.b = application;
            this.d = false;
        } else {
            this.b = new c(application, str);
            this.d = true;
        }
        this.a = this.b.getResources();
        DEVICE_DENSITY = a();
    }

    public Context getResourceContext() {
        return this.b;
    }

    public int loadIdentifierResource(String str, String str2) {
        String str3 = str2 + "/" + str;
        if (this.d && this.e.containsKey(str3)) {
            return this.e.get(str3).intValue();
        }
        int identifier = this.a.getIdentifier(str, str2, this.b.getPackageName());
        String packageName = this.b.getPackageName();
        if (identifier != 0) {
            if (this.d) {
                this.e.put(str3, Integer.valueOf(identifier));
            }
            return identifier;
        }
        throw new Resources.NotFoundException("name:" + str + ",type:" + str2 + ",packageName:" + packageName);
    }

    public int getDimensionPixelSize(String str) {
        try {
            return this.a.getDimensionPixelOffset(loadIdentifierResource(str, "dimen"));
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
            return 0;
        }
    }

    public CharSequence getText(String str, String str2) {
        try {
            return this.a.getText(loadIdentifierResource(str, str2));
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    @Deprecated
    public LayoutInflater getLayoutInflater() {
        if (this.d) {
            return ((c) this.b).a();
        }
        return (LayoutInflater) this.c.getSystemService("layout_inflater");
    }

    public CharSequence getText(String str) {
        try {
            return this.a.getText(loadIdentifierResource(str, "string"));
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    public String getQuantityString(String str, int i) {
        try {
            return this.a.getQuantityString(loadIdentifierResource(str, "string"), i);
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    public String getString(String str) {
        try {
            return this.a.getString(loadIdentifierResource(str, "string"));
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.a.getString(loadIdentifierResource(str, str2));
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    public String getString(String str, Object... objArr) {
        return String.format(getString(str), objArr);
    }

    public String[] getStringArray(String str, String str2) {
        try {
            return this.a.getStringArray(loadIdentifierResource(str, str2));
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    public String[] getStringArray(String str) {
        try {
            return this.a.getStringArray(loadIdentifierResource(str, "array"));
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    public int[] getIntArray(String str) {
        return this.a.getIntArray(loadIdentifierResource(str, "array"));
    }

    public void getValue(String str, TypedValue typedValue, boolean z) {
        try {
            this.a.getValue(str, typedValue, z);
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
        }
    }

    public Bitmap decodeResource(String str, BitmapFactory.Options options) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.a, loadIdentifierResource(str, "drawable"), options);
        if (decodeResource != null) {
            return decodeResource;
        }
        a((Throwable) new Exception("decodeResource:" + str), true);
        return null;
    }

    public View getLayoutView(String str) {
        try {
            return getLayoutInflater().inflate((XmlPullParser) this.a.getLayout(loadIdentifierResource(str, "layout")), (ViewGroup) null, false);
        } catch (Exception e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    public View getViewByID(String str) {
        try {
            return getLayoutInflater().inflate((XmlPullParser) this.a.getLayout(loadIdentifierResource(str, "id")), (ViewGroup) null, false);
        } catch (Exception e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    public int getColor(String str) {
        try {
            return this.a.getColor(loadIdentifierResource(str, "color"));
        } catch (Exception e2) {
            a((Throwable) e2, true);
            return 0;
        }
    }

    public Bitmap getBitmap(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScreenDensity = (int) DEVICE_DENSITY;
            return decodeResource(str, options);
        } catch (Throwable th) {
            a(th, false);
            return null;
        }
    }

    public Drawable getDrawable(String str) {
        try {
            long loadIdentifierResource = (long) loadIdentifierResource(str, "drawable");
            Drawable a2 = a(this.f, loadIdentifierResource);
            if (a2 != null) {
                Log.d("TESResource", "getDrawableFromCache");
                return a2;
            }
            Rect rect = new Rect();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScreenDensity = (int) DEVICE_DENSITY;
            Bitmap decodeResource = decodeResource(str, options);
            if (decodeResource == null) {
                return a2;
            }
            byte[] ninePatchChunk = decodeResource.getNinePatchChunk();
            if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                ninePatchChunk = null;
                rect = null;
            }
            Drawable a3 = a(decodeResource, ninePatchChunk, rect, str);
            this.f.put(loadIdentifierResource, new WeakReference<>(a3.getConstantState()));
            return a3;
        } catch (Throwable th) {
            a(th, true);
            return null;
        }
    }

    private Drawable a(LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray, long j) {
        synchronized (longSparseArray) {
            WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j);
            if (weakReference != null) {
                Drawable.ConstantState constantState = weakReference.get();
                if (constantState != null) {
                    return constantState.newDrawable(this.a);
                }
                longSparseArray.delete(j);
            }
            return null;
        }
    }

    public Animation getAnimation(String str) {
        try {
            return AnimationUtils.loadAnimation(this.b, loadIdentifierResource(str, "anim"));
        } catch (Resources.NotFoundException e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    @Deprecated
    public String getResourceName(int i) {
        try {
            String resourceName = this.a.getResourceName(i);
            return resourceName.substring(resourceName.indexOf("/") + 1, resourceName.length());
        } catch (Exception e2) {
            a((Throwable) e2, true);
            return null;
        }
    }

    private Drawable a(Bitmap bitmap, byte[] bArr, Rect rect, String str) {
        if (bArr != null) {
            return new NinePatchDrawable(this.a, bitmap, bArr, rect, str);
        }
        return new BitmapDrawable(this.a, bitmap);
    }

    private float a() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    private void a(Throwable th, boolean z) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        Log.e("TESResource", "exceptions(" + z + "):" + stringWriter.toString());
        if (z) {
            System.exit(-1);
        }
    }

    public View findViewById(int i, View view) {
        return view.findViewById(i);
    }

    public View getViewByid(String str) {
        return getLayoutView(str);
    }

    public int getStyle(String str) {
        return loadIdentifierResource(str, "style");
    }
}
