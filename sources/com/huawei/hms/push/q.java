package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* compiled from: NotificationUtils */
public class q {
    public static r a(o oVar) {
        r rVar = r.STYLE_DEFAULT;
        return (oVar.o() < 0 || oVar.o() >= r.values().length) ? rVar : r.values()[oVar.o()];
    }

    public static void a(Notification.Builder builder, String str, o oVar) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(oVar.q())) {
            bigTextStyle.setBigContentTitle(oVar.q());
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}
