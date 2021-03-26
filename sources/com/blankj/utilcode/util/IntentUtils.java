package com.blankj.utilcode.util;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class IntentUtils {
    private IntentUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isIntentAvailable(Intent intent) {
        return Utils.getApp().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static Intent getInstallAppIntent(String str) {
        return getInstallAppIntent(UtilsBridge.getFileByPath(str));
    }

    public static Intent getInstallAppIntent(File file) {
        Uri uri;
        if (!UtilsBridge.isFileExists(file)) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            uri = Uri.fromFile(file);
        } else {
            uri = FileProvider.getUriForFile(Utils.getApp(), Utils.getApp().getPackageName() + ".utilcode.provider", file);
        }
        return getInstallAppIntent(uri);
    }

    public static Intent getInstallAppIntent(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.setFlags(1);
        }
        return intent.addFlags(268435456);
    }

    public static Intent getUninstallAppIntent(String str) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        return intent.addFlags(268435456);
    }

    public static Intent getLaunchAppIntent(String str) {
        String launcherActivity = UtilsBridge.getLauncherActivity(str);
        if (UtilsBridge.isSpace(launcherActivity)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(str, launcherActivity);
        return intent.addFlags(268435456);
    }

    public static Intent getLaunchAppDetailsSettingsIntent(String str) {
        return getLaunchAppDetailsSettingsIntent(str, false);
    }

    public static Intent getLaunchAppDetailsSettingsIntent(String str, boolean z) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return getIntent(intent, z);
    }

    public static Intent getShareTextIntent(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        return getIntent(Intent.createChooser(intent, ""), true);
    }

    public static Intent getShareImageIntent(String str) {
        return getShareTextImageIntent("", str);
    }

    public static Intent getShareImageIntent(File file) {
        return getShareTextImageIntent("", file);
    }

    public static Intent getShareImageIntent(Uri uri) {
        return getShareTextImageIntent("", uri);
    }

    public static Intent getShareTextImageIntent(String str, String str2) {
        return getShareTextImageIntent(str, UtilsBridge.getFileByPath(str2));
    }

    public static Intent getShareTextImageIntent(String str, File file) {
        return getShareTextImageIntent(str, UtilsBridge.file2Uri(file));
    }

    public static Intent getShareTextImageIntent(String str, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType("image/*");
        return getIntent(Intent.createChooser(intent, ""), true);
    }

    public static Intent getShareImageIntent(LinkedList<String> linkedList) {
        return getShareTextImageIntent("", linkedList);
    }

    public static Intent getShareImageIntent(List<File> list) {
        return getShareTextImageIntent("", list);
    }

    public static Intent getShareImageIntent(ArrayList<Uri> arrayList) {
        return getShareTextImageIntent("", arrayList);
    }

    public static Intent getShareTextImageIntent(String str, LinkedList<String> linkedList) {
        ArrayList arrayList = new ArrayList();
        if (linkedList != null) {
            Iterator<String> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                File fileByPath = UtilsBridge.getFileByPath(it2.next());
                if (fileByPath != null) {
                    arrayList.add(fileByPath);
                }
            }
        }
        return getShareTextImageIntent(str, (List<File>) arrayList);
    }

    public static Intent getShareTextImageIntent(String str, List<File> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (File file : list) {
                Uri file2Uri = UtilsBridge.file2Uri(file);
                if (file2Uri != null) {
                    arrayList.add(file2Uri);
                }
            }
        }
        return getShareTextImageIntent(str, (ArrayList<Uri>) arrayList);
    }

    public static Intent getShareTextImageIntent(String str, ArrayList<Uri> arrayList) {
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        intent.setType("image/*");
        return getIntent(Intent.createChooser(intent, ""), true);
    }

    public static Intent getComponentIntent(String str, String str2) {
        return getComponentIntent(str, str2, null, false);
    }

    public static Intent getComponentIntent(String str, String str2, boolean z) {
        return getComponentIntent(str, str2, null, z);
    }

    public static Intent getComponentIntent(String str, String str2, Bundle bundle) {
        return getComponentIntent(str, str2, bundle, false);
    }

    public static Intent getComponentIntent(String str, String str2, Bundle bundle, boolean z) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return getIntent(intent, z);
    }

    public static Intent getShutdownIntent() {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = new Intent("com.android.internal.intent.action.REQUEST_SHUTDOWN");
        } else {
            intent = new Intent("android.intent.action.ACTION_REQUEST_SHUTDOWN");
        }
        intent.putExtra("android.intent.extra.KEY_CONFIRM", false);
        return intent.addFlags(268435456);
    }

    public static Intent getDialIntent(String str) {
        Objects.requireNonNull(str, "Argument 'phoneNumber' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getIntent(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str))), true);
    }

    public static Intent getCallIntent(String str) {
        Objects.requireNonNull(str, "Argument 'phoneNumber' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getIntent(new Intent("android.intent.action.CALL", Uri.parse("tel:" + Uri.encode(str))), true);
    }

    public static Intent getSendSmsIntent(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'phoneNumber' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + Uri.encode(str)));
        intent.putExtra("sms_body", str2);
        return getIntent(intent, true);
    }

    public static Intent getCaptureIntent(Uri uri) {
        return getCaptureIntent(uri, false);
    }

    public static Intent getCaptureIntent(Uri uri, boolean z) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        intent.addFlags(1);
        return getIntent(intent, z);
    }

    private static Intent getIntent(Intent intent, boolean z) {
        return z ? intent.addFlags(268435456) : intent;
    }
}
