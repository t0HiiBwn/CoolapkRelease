package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.BundleCompat;
import androidx.core.content.FileProvider;
import java.io.File;

public class TrustedWebUtils {
    public static final String ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA = "android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA";
    public static final String EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY = "android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY";

    private TrustedWebUtils() {
    }

    public static void launchBrowserSiteSettings(Context context, CustomTabsSession customTabsSession, Uri uri) {
        Intent intent = new Intent("android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA");
        intent.setPackage(customTabsSession.getComponentName().getPackageName());
        intent.setData(uri);
        Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", customTabsSession.getBinder());
        intent.putExtras(bundle);
        PendingIntent id = customTabsSession.getId();
        if (id != null) {
            intent.putExtra("android.support.customtabs.extra.SESSION_ID", id);
        }
        context.startActivity(intent);
    }

    public static boolean areSplashScreensSupported(Context context, String str, String str2) {
        ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent().setAction("android.support.customtabs.action.CustomTabsService").setPackage(str), 64);
        if (resolveService == null || resolveService.filter == null) {
            return false;
        }
        return resolveService.filter.hasCategory(str2);
    }

    public static boolean transferSplashImage(Context context, File file, String str, String str2, CustomTabsSession customTabsSession) {
        Uri uriForFile = FileProvider.getUriForFile(context, str, file);
        context.grantUriPermission(str2, uriForFile, 1);
        return customTabsSession.receiveFile(uriForFile, 1, null);
    }

    @Deprecated
    public static void launchAsTrustedWebActivity(Context context, CustomTabsIntent customTabsIntent, Uri uri) {
        if (BundleCompat.getBinder(customTabsIntent.intent.getExtras(), "android.support.customtabs.extra.SESSION") != null) {
            customTabsIntent.intent.putExtra("android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY", true);
            customTabsIntent.launchUrl(context, uri);
            return;
        }
        throw new IllegalArgumentException("Given CustomTabsIntent should be associated with a valid CustomTabsSession");
    }
}
