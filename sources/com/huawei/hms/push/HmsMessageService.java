package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.aaid.task.ReportAaidToken;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HmsMessageService extends Service {
    private final Messenger a = new Messenger(new a());

    public void onDeletedMessages() {
    }

    public void onMessageDelivered(String str, Exception exc) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    public void onTokenError(Exception exc) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.i("HmsMessageService", "start to bind");
        return this.a.getBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        HMSLog.i("HmsMessageService", "start to command , startId = " + i2);
        a(intent);
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        HMSLog.i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                HMSLog.e("HmsMessageService", "receive message is null");
                return;
            }
            HMSLog.i("HmsMessageService", "handle message start ");
            Bundle data = message.getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtra("message_id", data.getString("message_id"));
                intent.putExtra("message_type", data.getString("message_type"));
                intent.putExtra("message_body", data.getByteArray("message_body"));
                intent.putExtra("device_token", data.getString("device_token"));
                intent.putExtra("error", data.getInt("error"));
                intent.putExtra("transaction_id", data.getString("transaction_id"));
                intent.putExtra("inputType", data.getInt("inputType", -1));
                HmsMessageService.this.a(intent);
            }
            super.handleMessage(message);
        }
    }

    /* access modifiers changed from: private */
    public void a(Intent intent) {
        if (intent == null) {
            HMSLog.e("HmsMessageService", "receive message is null");
            return;
        }
        String stringExtra = intent.getStringExtra("message_id");
        String stringExtra2 = intent.getStringExtra("message_type");
        String stringExtra3 = intent.getStringExtra("transaction_id");
        if ("new_token".equals(stringExtra2)) {
            HMSLog.i("HmsMessageService", "onNewToken");
            a(intent, stringExtra3);
        } else if ("received_message".equals(stringExtra2)) {
            HMSLog.i("HmsMessageService", "onMessageReceived, message id:" + stringExtra);
            a("push.receiveMessage", stringExtra, a.SUCCESS.a());
            onMessageReceived(new RemoteMessage(b(intent)));
        } else if ("sent_message".equals(stringExtra2)) {
            a(stringExtra3, stringExtra);
        } else if ("send_error".equals(stringExtra2)) {
            b(stringExtra3, stringExtra, intent.getIntExtra("error", a.ERROR_UNKNOWN.a()));
        } else if ("delivery".equals(stringExtra2)) {
            int intExtra = intent.getIntExtra("error", a.ERROR_APP_SERVER_NOT_ONLINE.a());
            HMSLog.i("HmsMessageService", "onMessageDelivery, message id:" + stringExtra + ", status:" + intExtra + ", transactionId: " + stringExtra3);
            a("push.deliveryMessage", stringExtra3, intExtra);
            onMessageDelivered(stringExtra, new SendException(intExtra));
        } else if ("server_deleted_message".equals(stringExtra2)) {
            HMSLog.i("HmsMessageService", "delete message, message id:" + stringExtra);
            onDeletedMessages();
        } else if ("batchSent".equals(stringExtra2)) {
            c(intent);
        } else {
            HMSLog.e("HmsMessageService", "Receive unknown message: " + stringExtra2);
        }
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context applicationContext = getApplicationContext();
            ac acVar = new ac(applicationContext, "push_client_self_info");
            acVar.a("reqTokenTime", Long.valueOf(System.currentTimeMillis()));
            if (!str.equals(y.a(applicationContext, "push_client_self_info"))) {
                HMSLog.i("HmsMessageService", "receive a token, refresh the local token");
                acVar.d("token_info");
            }
            y.a(applicationContext, "push_client_self_info", str);
            ReportAaidToken.report(applicationContext, str);
        }
    }

    private Bundle b(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString("message_id", intent.getStringExtra("message_id"));
        bundle.putByteArray("message_body", intent.getByteArrayExtra("message_body"));
        bundle.putString("device_token", intent.getStringExtra("device_token"));
        if (1 == intent.getIntExtra("inputType", -1)) {
            bundle.putInt("inputType", 1);
        }
        return bundle;
    }

    private void a(Intent intent, String str) {
        int intExtra = intent.getIntExtra("error", a.SUCCESS.a());
        HMSLog.i("HmsMessageService", "doOnNewToken:transactionId = " + str + " , internalCode = " + intExtra);
        a("push.onNewToken", str, intExtra);
        if (intExtra == a.SUCCESS.a()) {
            a(intent.getStringExtra("device_token"));
            onNewToken(intent.getStringExtra("device_token"));
            return;
        }
        onTokenError(new BaseException(intExtra));
    }

    private void a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "null";
        }
        g.a(getApplicationContext(), str, str2, i);
    }

    private void c(Intent intent) {
        HMSLog.i("HmsMessageService", "parse batch response.");
        String stringExtra = intent.getStringExtra("batchMsgbody");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONArray jSONArray = new JSONArray(stringExtra);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("transactionId");
                    String optString2 = jSONObject.optString("msgId");
                    int optInt = jSONObject.optInt("ret", a.ERROR_UNKNOWN.a());
                    if (a.SUCCESS.a() == optInt) {
                        a(optString, optString2);
                    } else {
                        b(optString, optString2, optInt);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("HmsMessageService", "parse batch response failed.");
            }
        }
    }

    private void a(String str, String str2) {
        HMSLog.i("HmsMessageService", "onMessageSent, message id:" + str2 + ", transactionId: " + str);
        a("push.sendMessageRet", str, a.SUCCESS.a());
        onMessageSent(str2);
    }

    private void b(String str, String str2, int i) {
        HMSLog.i("HmsMessageService", "onSendError, message id:" + str2 + " error:" + i + ", transactionId: " + str);
        a("push.sendMessageRet", str, i);
        onSendError(str2, new SendException(i));
    }
}
