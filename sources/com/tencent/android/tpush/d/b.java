package com.tencent.android.tpush.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

/* compiled from: ProGuard */
public class b {
    public static void a(final Context context) {
        if (context == null) {
            TLogger.ee("OtherPushClient", "updateToken Error: context is null");
        } else {
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.d.b.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    b.c(context);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context) {
        String token = XGPushConfig.getToken(context);
        if (token == null) {
            TLogger.ee("OtherPushClient", "updateToken Error: get XG Token is null");
            return;
        }
        long accessId = XGPushConfig.getAccessId(context);
        String accessKey = XGPushConfig.getAccessKey(context);
        String i = d.a(context).i();
        String f = d.a(context).f();
        TLogger.ii("OtherPushClient", "handleUpdateToken other push token is : " + f + " other push type: " + i);
        if (j.b(i) || j.b(f)) {
            TLogger.ww("OtherPushClient", "updateToken Error: get otherPushType or otherPushToken is null");
            return;
        }
        try {
            Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4");
            intent.putExtra("accId", Rijndael.encrypt("" + accessId));
            intent.putExtra("accKey", Rijndael.encrypt("" + accessKey));
            intent.putExtra("token", Rijndael.encrypt(token));
            intent.putExtra("other_push_type", Rijndael.encrypt(i));
            intent.putExtra("other_push_token", Rijndael.encrypt(f));
            d.a(context, intent);
        } catch (Throwable th) {
            TLogger.e("OtherPushClient", "sendBroadcast action ACTION_UPDATE_OTHER_PUSH_TOKEN error", th);
        }
    }
}
