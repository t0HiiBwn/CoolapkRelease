package com.ali.auth.third.core.util;

import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.trace.SDKLogger;

public class ResourceUtils {
    public static final String TAG = "ResourceUtils";

    public static float getDimen(Context context, String str) {
        return (KernelContext.resources != null ? KernelContext.resources : context.getResources()).getDimension(getIdentifier(context, "dimen", str));
    }

    public static int getIdentifier(Context context, String str, String str2) {
        String packageName = !TextUtils.isEmpty(KernelContext.packageName) ? KernelContext.packageName : context.getPackageName();
        SDKLogger.i("resources", "resources = " + KernelContext.resources + " packageName = " + KernelContext.packageName);
        return (KernelContext.resources != null ? KernelContext.resources : context.getResources()).getIdentifier(str2, str, packageName);
    }

    public static int getIdentifier(String str, String str2) {
        return getIdentifier(KernelContext.getApplicationContext(), str, str2);
    }

    public static int getRDrawable(Context context, String str) {
        return getIdentifier(context, "drawable", str);
    }

    public static int getRId(Context context, String str) {
        return getIdentifier(context, "id", str);
    }

    public static int getRLayout(Context context, String str) {
        return getIdentifier(context, "layout", str);
    }

    public static int getRLayout(String str) {
        return getIdentifier(KernelContext.getApplicationContext(), "layout", str);
    }

    public static String getString(Context context, String str) {
        return (KernelContext.resources != null ? KernelContext.resources : context.getResources()).getString(getIdentifier(context, "string", str));
    }

    public static String getString(String str) {
        return getString(KernelContext.getApplicationContext(), str);
    }
}
