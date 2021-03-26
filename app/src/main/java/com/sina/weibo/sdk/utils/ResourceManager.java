package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class ResourceManager {
    private static final String DRAWABLE = "drawable";
    private static final String DRAWABLE_HDPI = "drawable-hdpi";
    private static final String DRAWABLE_LDPI = "drawable-ldpi";
    private static final String DRAWABLE_MDPI = "drawable-mdpi";
    private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    private static final String[] PRE_INSTALL_DRAWBLE_PATHS = {"drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable"};
    private static final String TAG = "com.sina.weibo.sdk.utils.ResourceManager";

    public static String getString(Context context, String str, String str2, String str3) {
        Locale language = getLanguage();
        if (Locale.SIMPLIFIED_CHINESE.equals(language) || ("zh".equals(language.getLanguage()) && language.getCountry().contains("CN"))) {
            return str2;
        }
        return (Locale.TRADITIONAL_CHINESE.equals(language) || ("zh".equals(language.getLanguage()) && language.getCountry().contains("TW"))) ? str3 : str;
    }

    public static Drawable getDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), false);
    }

    public static Drawable getNinePatchDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), true);
    }

    public static Locale getLanguage() {
        Locale locale = Locale.getDefault();
        if (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale)) {
            return locale;
        }
        return (!locale.getLanguage().equals("zh") || (!locale.getCountry().contains("CN") && !locale.getCountry().contains("TW"))) ? Locale.ENGLISH : locale;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (java.lang.Math.abs(r4 - r2) <= java.lang.Math.abs(r4 - r5)) goto L_0x0070;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f  */
    private static String getAppropriatePathOfDrawable(Context context, String str) {
        String[] strArr;
        if (TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "id is NOT correct!");
            return null;
        }
        String currentDpiFolder = getCurrentDpiFolder(context);
        LogUtil.d(TAG, "find Appropriate path...");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            strArr = PRE_INSTALL_DRAWBLE_PATHS;
            if (i >= strArr.length) {
                i = -1;
                break;
            }
            if (strArr[i].equals(currentDpiFolder)) {
                i3 = i;
            }
            String str2 = strArr[i] + "/" + str;
            if (isFileExisted(context, str2)) {
                if (i3 != i) {
                    if (i3 >= 0) {
                        break;
                    }
                    i4 = i;
                } else {
                    return str2;
                }
            }
            i++;
        }
        if (i4 <= 0 || i <= 0) {
            if (i4 <= 0 || i >= 0) {
                if (i4 >= 0 || i <= 0) {
                    LogUtil.e(TAG, "Not find the appropriate path for drawable");
                    if (i2 < 0) {
                        LogUtil.e(TAG, "Not find the appropriate path for drawable");
                        return null;
                    }
                    return strArr[i2] + "/" + str;
                }
                i2 = i;
                if (i2 < 0) {
                }
            }
        }
        i2 = i4;
        if (i2 < 0) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b A[SYNTHETIC, Splitter:B:27:0x006b] */
    private static Drawable getDrawableFromAssert(Context context, String str, boolean z) {
        Throwable th;
        InputStream inputStream;
        IOException e;
        NinePatchDrawable ninePatchDrawable = null;
        ninePatchDrawable = null;
        InputStream inputStream2 = null;
        ninePatchDrawable = null;
        try {
            inputStream = context.getAssets().open(str);
            if (inputStream != null) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (z) {
                        ninePatchDrawable = new NinePatchDrawable(new Resources(context.getAssets(), displayMetrics, context.getResources().getConfiguration()), decodeStream, decodeStream.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
                    } else {
                        decodeStream.setDensity(displayMetrics.densityDpi);
                        ninePatchDrawable = new BitmapDrawable(context.getResources(), decodeStream);
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                        }
                        return ninePatchDrawable;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
            e.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
            return ninePatchDrawable;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream2 != null) {
            }
            throw th;
        }
        return ninePatchDrawable;
    }

    private static boolean isFileExisted(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            String str2 = TAG;
            LogUtil.d(str2, "file [" + str + "] existed");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        } catch (IOException unused) {
            String str3 = TAG;
            LogUtil.d(str3, "file [" + str + "] NOT existed");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static String getCurrentDpiFolder(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i <= 120) {
            return "drawable-ldpi";
        }
        if (i > 120 && i <= 160) {
            return "drawable-mdpi";
        }
        if (i <= 160 || i > 240) {
            return (i <= 240 || i > 320) ? "drawable-xxhdpi" : "drawable-xhdpi";
        }
        return "drawable-hdpi";
    }

    private static View extractView(Context context, String str, ViewGroup viewGroup) throws Exception {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(context.getAssets().openXmlResourceParser(str), viewGroup);
    }

    private static Drawable extractDrawable(Context context, String str) throws Exception {
        InputStream open = context.getAssets().open(str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        typedValue.density = displayMetrics.densityDpi;
        Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), typedValue, open, str);
        open.close();
        return createFromResourceStream;
    }

    public static int dp2px(Context context, int i) {
        return (int) (((double) (((float) i) * context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, StateSet.WILD_CARD}, new int[]{i2, i2, i2, i});
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2) {
        Drawable drawable;
        Drawable drawable2;
        if (str.indexOf(".9") > -1) {
            drawable = getNinePatchDrawable(context, str);
        } else {
            drawable = getDrawable(context, str);
        }
        if (str2.indexOf(".9") > -1) {
            drawable2 = getNinePatchDrawable(context, str2);
        } else {
            drawable2 = getDrawable(context, str2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842913}, drawable2);
        stateListDrawable.addState(new int[]{16842908}, drawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2, String str3) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        if (str.indexOf(".9") > -1) {
            drawable = getNinePatchDrawable(context, str);
        } else {
            drawable = getDrawable(context, str);
        }
        if (str3.indexOf(".9") > -1) {
            drawable2 = getNinePatchDrawable(context, str3);
        } else {
            drawable2 = getDrawable(context, str3);
        }
        if (str2.indexOf(".9") > -1) {
            drawable3 = getNinePatchDrawable(context, str2);
        } else {
            drawable3 = getDrawable(context, str2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable3);
        stateListDrawable.addState(new int[]{16842913}, drawable3);
        stateListDrawable.addState(new int[]{16842908}, drawable3);
        stateListDrawable.addState(new int[]{16842766}, drawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }

    public static String readCountryFromAsset(Context context, String str) {
        IOException e;
        String str2 = "";
        try {
            InputStream open = context.getAssets().open(str);
            if (open == null) {
                return str2;
            }
            DataInputStream dataInputStream = new DataInputStream(open);
            byte[] bArr = new byte[dataInputStream.available()];
            dataInputStream.read(bArr);
            String str3 = new String(bArr, "UTF-8");
            try {
                open.close();
                return str3;
            } catch (IOException e2) {
                e = e2;
                str2 = str3;
                e.printStackTrace();
                return str2;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            return str2;
        }
    }
}
