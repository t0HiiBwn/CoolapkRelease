package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.b.g;
import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* compiled from: ProGuard */
public abstract class XGPushBaseReceiver extends BroadcastReceiver {
    public static final int SUCCESS = 0;
    private long a = 0;

    public abstract void onDeleteAccountResult(Context context, int i, String str);

    public abstract void onDeleteAttributeResult(Context context, int i, String str);

    public abstract void onDeleteTagResult(Context context, int i, String str);

    public abstract void onNotificationClickedResult(Context context, XGPushClickedResult xGPushClickedResult);

    public abstract void onNotificationShowedResult(Context context, XGPushShowedResult xGPushShowedResult);

    public abstract void onRegisterResult(Context context, int i, XGPushRegisterResult xGPushRegisterResult);

    public abstract void onSetAccountResult(Context context, int i, String str);

    public abstract void onSetAttributeResult(Context context, int i, String str);

    public abstract void onSetTagResult(Context context, int i, String str);

    public abstract void onTextMessage(Context context, XGPushTextMessage xGPushTextMessage);

    public abstract void onUnregisterResult(Context context, int i);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (context != null && intent != null) {
            try {
                if (j.a(context) <= 0) {
                    String action = intent.getAction();
                    if ("com.tencent.android.xg.vip.action.PUSH_MESSAGE".equals(action)) {
                        a(context, intent);
                    } else if ("com.tencent.android.xg.vip.action.FEEDBACK".equals(action)) {
                        CommonWorkingThread.getInstance().execute(new Runnable() {
                            /* class com.tencent.android.tpush.XGPushBaseReceiver.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                XGPushBaseReceiver.this.b(context, intent);
                            }
                        });
                    } else {
                        TLogger.e("XGPushBaseReceiver", "未知的action:" + action);
                    }
                }
            } catch (Throwable th) {
                TLogger.e("XGPushBaseReceiver", "onReceive handle error.", th);
            }
        }
    }

    private void a(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("PUSH.CHANNEL", 100);
        if (intExtra == 100) {
            g a2 = g.a(context, intent);
            if (a2.m().b() == 2) {
                XGPushTextMessage xGPushTextMessage = new XGPushTextMessage();
                xGPushTextMessage.d = intExtra;
                xGPushTextMessage.a = a2.m().d();
                xGPushTextMessage.b = a2.m().e();
                xGPushTextMessage.c = a2.m().f();
                xGPushTextMessage.a(intent);
                onTextMessage(context, xGPushTextMessage);
                return;
            }
            return;
        }
        XGPushTextMessage xGPushTextMessage2 = new XGPushTextMessage();
        xGPushTextMessage2.d = intExtra;
        xGPushTextMessage2.b = intent.getStringExtra("content");
        xGPushTextMessage2.a = intent.getStringExtra("title");
        xGPushTextMessage2.c = intent.getStringExtra("custom_content");
        intent.putExtra("accId", XGPushConfig.getAccessId(context));
        e(context, intent);
        onTextMessage(context, xGPushTextMessage2);
    }

    /* access modifiers changed from: private */
    public void b(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("TPUSH.FEEDBACK", -1);
        int intExtra2 = intent.getIntExtra("TPUSH.ERRORCODE", -1);
        TLogger.i("XGPushBaseReceiver", "action - feedbackHandler, feedbackType: " + intExtra);
        switch (intExtra) {
            case 1:
                d(context, intent, intExtra2);
                return;
            case 2:
                new XGPushRegisterResult().parseIntent(intent);
                onUnregisterResult(context, intExtra2);
                return;
            case 3:
                c(context, intent, intExtra2);
                return;
            case 4:
                d(context, intent);
                return;
            case 5:
                c(context, intent);
                return;
            case 6:
                b(context, intent, intExtra2);
                return;
            case 7:
                a(context, intent, intExtra2);
                return;
            default:
                TLogger.e("XGPushBaseReceiver", "未知的feedbackType:" + intExtra);
                return;
        }
    }

    private void c(Context context, Intent intent) {
        XGPushShowedResult xGPushShowedResult = new XGPushShowedResult();
        int intExtra = intent.getIntExtra("PUSH.CHANNEL", 100);
        if (intExtra == 100 || intExtra == 101 || intExtra == 99) {
            xGPushShowedResult.parseIntent(intent);
        } else {
            xGPushShowedResult.c = intent.getStringExtra("content");
            xGPushShowedResult.b = intent.getStringExtra("title");
            xGPushShowedResult.d = intent.getStringExtra("custom_content");
            xGPushShowedResult.h = intent.getIntExtra("PUSH.CHANNEL", 0);
            intent.putExtra("accId", XGPushConfig.getAccessId(context));
        }
        onNotificationShowedResult(context, xGPushShowedResult);
    }

    private void a(Context context, Intent intent, int i) {
        String decrypt = Rijndael.decrypt(intent.getStringExtra("attributesName"));
        if (!j.b(decrypt)) {
            int intExtra = intent.getIntExtra("attributesFlag", -1);
            String stringExtra = intent.getStringExtra("attributesOperateName");
            TLogger.i("XGPushBaseReceiver", "attributes, opType:" + intExtra + " ,attributesName:" + decrypt + ", operateName:" + stringExtra);
            if (intExtra == 2 || intExtra == 1) {
                onSetAttributeResult(context, i, stringExtra);
            } else if (intExtra == 4 || intExtra == 3) {
                onDeleteAttributeResult(context, i, stringExtra);
            } else {
                TLogger.e("XGPushBaseReceiver", "error attributes：" + intExtra + " ,attributesName：" + decrypt + ", intent:" + intent.getExtras());
            }
        }
    }

    private void b(Context context, Intent intent, int i) {
        String decrypt = Rijndael.decrypt(intent.getStringExtra("accountName"));
        if (!j.b(decrypt)) {
            int intExtra = intent.getIntExtra("operateType", -1);
            String stringExtra = intent.getStringExtra("accountFeedBack");
            if (intExtra == 0 || intExtra == 2 || intExtra == 6) {
                onSetAccountResult(context, i, stringExtra);
            } else if (intExtra == 3 || intExtra == 1 || intExtra == 7) {
                onDeleteAccountResult(context, i, stringExtra);
            } else {
                TLogger.e("XGPushBaseReceiver", "错误的帐号处理类型：" + intExtra + " ,accountName：" + decrypt);
            }
        }
    }

    private void d(Context context, Intent intent) {
        XGPushConfig.changeHuaweiBadgeNum(context, -1);
        int intExtra = intent.getIntExtra("PUSH.CHANNEL", 100);
        long longExtra = intent.getLongExtra("accId", 0);
        List<Long> accessidList = XGPushConfig.getAccessidList(context);
        if (accessidList == null || accessidList.size() <= 0) {
            TLogger.e("XGPushBaseReceiver", "accessIdList " + accessidList + " local accessid " + longExtra);
            TLogger.e("XGPushBaseReceiver", "give up msg");
        } else if (!accessidList.contains(Long.valueOf(longExtra)) || !(intExtra == 100 || intExtra == 101 || intExtra == 99)) {
            XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
            xGPushClickedResult.content = intent.getStringExtra("content");
            xGPushClickedResult.title = intent.getStringExtra("title");
            xGPushClickedResult.customContent = intent.getStringExtra("custom_content");
            xGPushClickedResult.pushChannel = intent.getIntExtra("PUSH.CHANNEL", 0);
            xGPushClickedResult.actionType = intent.getIntExtra("action", 0);
            xGPushClickedResult.customContent = intent.getStringExtra("custom_content");
            xGPushClickedResult.msgId = intent.getLongExtra("msgId", 0);
            xGPushClickedResult.notificationActionType = intent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
            xGPushClickedResult.activityName = intent.getStringExtra("activity");
            xGPushClickedResult.templateId = intent.getStringExtra("templateId");
            xGPushClickedResult.traceId = intent.getStringExtra("traceId");
            onNotificationClickedResult(context, xGPushClickedResult);
        } else {
            XGPushClickedResult xGPushClickedResult2 = new XGPushClickedResult();
            xGPushClickedResult2.parseIntent(intent);
            onNotificationClickedResult(context, xGPushClickedResult2);
        }
    }

    private void c(Context context, Intent intent, int i) {
        String decrypt = Rijndael.decrypt(intent.getStringExtra("tagName"));
        if (!j.b(decrypt)) {
            int intExtra = intent.getIntExtra("tagFlag", -1);
            String stringExtra = intent.getStringExtra("tagOperageName");
            if (intExtra == 1 || intExtra == 6 || intExtra == 5) {
                onSetTagResult(context, i, stringExtra);
            } else if (intExtra == 2 || intExtra == 7 || intExtra == 8) {
                onDeleteTagResult(context, i, stringExtra);
            } else {
                TLogger.e("XGPushBaseReceiver", "错误的标签处理类型：" + intExtra + " ,标签名：" + decrypt);
            }
        }
    }

    private void d(Context context, Intent intent, int i) {
        XGPushRegisterResult xGPushRegisterResult = new XGPushRegisterResult();
        if (!intent.getBooleanExtra("registerFromCloudControl", false)) {
            if (intent.getIntExtra("PUSH.CHANNEL", 100) == 100) {
                xGPushRegisterResult.parseIntent(intent);
            } else {
                xGPushRegisterResult.h = intent.getIntExtra("PUSH.CHANNEL", 0);
                xGPushRegisterResult.g = intent.getStringExtra("other_push_token");
            }
            onRegisterResult(context, i, xGPushRegisterResult);
        }
    }

    private void e(Context context, Intent intent) {
        MessageId messageId = new MessageId();
        messageId.id = intent.getLongExtra("msgId", 0);
        messageId.isAck = 0;
        messageId.accessId = intent.getLongExtra("accId", 0);
        messageId.host = intent.getLongExtra("extra_host", 0);
        messageId.port = intent.getIntExtra("extra_port", 0);
        messageId.pact = intent.getByteExtra("extra_pact", (byte) 0);
        messageId.apn = DeviceInfos.getNetworkType(context);
        messageId.isp = j.o(context);
        messageId.serviceHost = intent.getStringExtra("svrPkgName");
        messageId.receivedTime = System.currentTimeMillis();
        messageId.pkgName = context.getPackageName();
        messageId.busiMsgId = intent.getLongExtra("busiMsgId", 0);
        messageId.timestamp = intent.getLongExtra("timestamps", 0);
        messageId.msgType = intent.getLongExtra("type", 0);
        messageId.multiPkg = intent.getLongExtra("multiPkg", 0);
        messageId.date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String stringExtra = intent.getStringExtra("group_id");
        if (!j.b(stringExtra)) {
            messageId.groupId = stringExtra;
        }
        intent.putExtra("MessageId", messageId);
        Intent intent2 = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.MSG_ACK.V4");
        intent2.putExtras(intent);
        d.a(context, intent2);
    }
}
