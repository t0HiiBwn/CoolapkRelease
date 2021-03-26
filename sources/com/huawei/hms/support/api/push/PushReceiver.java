package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.aa;
import com.huawei.hms.push.l;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.w;
import com.huawei.hms.push.z;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

public final class PushReceiver extends BroadcastReceiver {

    public interface BoundKey {
        public static final String DEVICE_TOKEN_KEY = "deviceToken";
    }

    public void onPushMsg(Context context, byte[] bArr, String str) {
    }

    public void onToken(Context context, String str) {
    }

    public void onToken(Context context, String str, Bundle bundle) {
        onToken(context, str);
    }

    public boolean onPushMsg(Context context, byte[] bArr, Bundle bundle) {
        onPushMsg(context, bArr, bundle != null ? bundle.getString("deviceToken") : "");
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            HMSLog.i("PushReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
            try {
                intent.getStringExtra("TestIntent");
                String action = intent.getAction();
                if (ResourceLoaderUtil.getmContext() == null) {
                    ResourceLoaderUtil.setmContext(context.getApplicationContext());
                }
                if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                    a(context, intent);
                } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                    b(context, intent);
                } else {
                    HMSLog.i("PushReceiver", "message can't be recognised:" + intent.toUri(0));
                }
            } catch (Exception unused) {
                HMSLog.e("PushReceiver", "intent has some error");
            }
        }
    }

    private void a(Context context, Intent intent) {
        try {
            if (intent.hasExtra("device_token")) {
                z.a().execute(new b(context, intent));
            } else {
                HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
        }
    }

    private void b(Context context, Intent intent) {
        try {
            if (intent.hasExtra("msg_data")) {
                z.a().execute(new a(context, intent));
            } else {
                HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
        }
    }

    static class b implements Runnable {
        private Context a;
        private Intent b;

        private b(Context context, Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] byteArrayExtra = this.b.getByteArrayExtra("device_token");
                if (byteArrayExtra != null) {
                    if (byteArrayExtra.length != 0) {
                        HMSLog.i("PushReceiver", "receive a push token: " + this.a.getPackageName());
                        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                        intent.setPackage(this.b.getPackage());
                        Bundle bundle = new Bundle();
                        bundle.putString("message_type", "new_token");
                        bundle.putString("device_token", aa.a(byteArrayExtra));
                        bundle.putString("transaction_id", this.b.getStringExtra("transaction_id"));
                        bundle.putInt("error", this.b.getIntExtra("error", com.huawei.hms.push.a.SUCCESS.a()));
                        if (!new l().a(this.a, bundle, intent)) {
                            HMSLog.e("PushReceiver", "receive " + this.b.getAction() + " and start service failed");
                            return;
                        }
                        return;
                    }
                }
                HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");
            } catch (RejectedExecutionException unused) {
                HMSLog.e("PushReceiver", "execute task error");
            } catch (Exception unused2) {
                HMSLog.e("PushReceiver", "handle push token error");
            }
        }
    }

    static class a implements Runnable {
        private Context a;
        private Intent b;

        private a(Context context, Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.b.getPackage());
            JSONObject b2 = PushReceiver.b(this.b);
            String string = JsonUtil.getString(b2, "moduleName", "");
            int i = JsonUtil.getInt(b2, "msgType", 0);
            int i2 = JsonUtil.getInt(b2, "status", 0);
            if (com.huawei.hms.push.a.SUCCESS.a() != i2) {
                i2 = com.huawei.hms.push.a.ERROR_APP_SERVER_NOT_ONLINE.a();
            }
            Bundle bundle = new Bundle();
            if (!"Push".equals(string) || 1 != i) {
                bundle.putString("message_type", "received_message");
                bundle.putString("message_id", this.b.getStringExtra("msgIdStr"));
                bundle.putByteArray("message_body", this.b.getByteArrayExtra("msg_data"));
                bundle.putString("device_token", aa.a(this.b.getByteArrayExtra("device_token")));
                bundle.putInt("inputType", 1);
                bundle.putInt("message_proxy_type", this.b.getIntExtra("message_proxy_type", -1));
            } else {
                bundle.putString("message_type", "delivery");
                bundle.putString("message_id", JsonUtil.getString(b2, "msgId", ""));
                bundle.putInt("error", i2);
                bundle.putString("transaction_id", JsonUtil.getString(b2, "transactionId", ""));
            }
            if (new l().a(this.a, bundle, intent)) {
                HMSLog.i("PushReceiver", "receive " + this.b.getAction() + " and start service success");
                return;
            }
            HMSLog.e("PushReceiver", "receive " + this.b.getAction() + " and start service failed");
        }
    }

    private static JSONObject a(byte[] bArr) {
        try {
            return new JSONObject(aa.a(bArr));
        } catch (JSONException unused) {
            HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
    }

    private static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("psContent");
        }
        return null;
    }

    private static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("msgContent");
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static JSONObject b(Intent intent) {
        JSONObject a2 = a(intent.getByteArrayExtra("msg_data"));
        JSONObject b2 = b(a2);
        String string = JsonUtil.getString(b2, "data", null);
        if (w.a(b2, a(b2), string)) {
            return a2;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }
}
