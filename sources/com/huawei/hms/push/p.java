package com.huawei.hms.push;

import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: NotificationIconUtil */
public class p {
    private static int b(Context context, o oVar) {
        int i = 0;
        if (context == null || oVar == null) {
            HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        if (!TextUtils.isEmpty(oVar.x())) {
            String[] split = oVar.x().split("/");
            if (split.length == 3) {
                i = v.a(context, split[1], split[2]);
            }
        }
        if (i == 0) {
            i = v.a(context, "com.huawei.messaging.default_notification_icon");
        }
        if (i != 0) {
            return i;
        }
        return a(context);
    }

    private static int a(Context context) {
        int i = context.getApplicationInfo().icon;
        if (i != 0) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
        HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (identifier != 0) {
            return identifier;
        }
        HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return 17301651;
    }

    public static Bitmap a(Context context, o oVar) {
        if (context == null || oVar == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            } else if ("com.huawei.android.pushagent".equals(oVar.i())) {
                return null;
            } else {
                HMSLog.i("PushSelfShowLog", "get left bitmap from " + oVar.i());
                return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(oVar.i())).getBitmap();
            }
        } catch (PackageManager.NameNotFoundException e) {
            HMSLog.e("PushSelfShowLog", "" + e.toString(), e);
            return null;
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "" + e2.toString(), e2);
            return null;
        }
    }

    public static void a(Context context, Notification.Builder builder, o oVar) {
        if (context == null || builder == null || oVar == null) {
            HMSLog.e("PushSelfShowLog", "msg is null");
        } else {
            builder.setSmallIcon(b(context, oVar));
        }
    }
}
