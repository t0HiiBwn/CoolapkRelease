package com.coolapk.market.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;

public class CustomTabsUtils {
    private static String sSupportPackageName;

    private CustomTabsUtils() {
    }

    public static boolean isSupported(Context context, String str) {
        sSupportPackageName = CustomTabsHelper.getPackageNameToUse(context);
        return CoolMarketHook.getInstance().isSupportCustomTab(!TextUtils.isEmpty(CustomTabsHelper.getPackageNameToUse(context)), str);
    }

    public static void launchUrl(Context context, String str) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(AppHolder.getAppTheme().getColorPrimary());
        builder.setSecondaryToolbarColor(ThemeUtils.getStatusBarColor());
        builder.setShowTitle(true);
        builder.setCloseButtonIcon(createBackBitmap(context));
        CustomTabsIntent build = builder.build();
        if (sSupportPackageName != null) {
            build.intent.setPackage(sSupportPackageName);
        }
        try {
            build.launchUrl(UiUtils.getActivity(context), Uri.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
            ActionManager.startWebViewActivity(context, str);
        }
    }

    private static Bitmap createBackBitmap(Context context) {
        Drawable drawable = ResourceUtils.getDrawable(context, 2131231156);
        if (isLightColor(AppHolder.getAppTheme().getColorPrimary())) {
            drawable.setColorFilter(-12303292, PorterDuff.Mode.SRC_IN);
        } else {
            drawable.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static boolean isLightColor(int i) {
        return Math.sqrt(((Math.pow((double) Color.red(i), 2.0d) * 0.241d) + (Math.pow((double) Color.green(i), 2.0d) * 0.691d)) + (Math.pow((double) Color.blue(i), 2.0d) * 0.068d)) >= 130.0d;
    }
}
