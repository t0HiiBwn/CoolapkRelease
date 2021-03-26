package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.regex.Pattern;

public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";
    private static final Pattern a = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    private Context b;
    private HuaweiApi<Api.ApiOptions.NoOptions> c;

    private HmsMessaging(Context context) {
        Preconditions.checkNotNull(context);
        this.b = context;
        Api api = new Api("HuaweiPush.API");
        if (context instanceof Activity) {
            this.c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new i());
        } else {
            this.c = new HuaweiApi<>(context, api, (Api.ApiOptions) null, new i());
        }
        this.c.setKitSdkVersion(50002300);
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        HmsMessaging hmsMessaging;
        synchronized (HmsMessaging.class) {
            hmsMessaging = new HmsMessaging(context);
        }
        return hmsMessaging;
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.b);
    }

    public void setAutoInitEnabled(boolean z) {
        AutoInitHelper.setAutoInitEnabled(this.b, z);
    }

    public Task<Void> subscribe(String str) {
        if (ProxyCenter.getInstance().getProxy() != null) {
            HMSLog.e("HmsMessaging", "Operation(subscribe) unsupported");
            return a();
        }
        String a2 = g.a(this.b, "push.subscribe");
        HMSLog.i("HmsMessaging", "invoke subscribe");
        return a(str, "Sub", a2);
    }

    public Task<Void> unsubscribe(String str) {
        if (ProxyCenter.getInstance().getProxy() != null) {
            HMSLog.e("HmsMessaging", "Operation(unsubscribe) unsupported");
            return a();
        }
        String a2 = g.a(this.b, "push.subscribe");
        HMSLog.i("HmsMessaging", "invoke unsubscribe");
        return a(str, "UnSub", a2);
    }

    private Task<Void> a(String str, String str2, String str3) {
        if (str == null || !a.matcher(str).matches()) {
            g.a(this.b, "push.subscribe", str3, a.ERROR_ARGUMENTS_INVALID);
            HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
            throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        }
        try {
            HMSLog.i("HmsMessaging", "EMUI:" + HwBuildEx.VERSION.EMUI_SDK_INT);
            a a2 = j.a(this.b);
            if (a2 != a.SUCCESS) {
                throw a.a(a2);
            } else if (NetWorkUtil.getNetworkType(this.b) != 0) {
                SubscribeReq subscribeReq = new SubscribeReq(this.b.getPackageName(), str2, str);
                subscribeReq.setToken(y.a(this.b, "push_client_self_info"));
                if (w.a()) {
                    return this.c.doWrite(new b("push.subscribe", JsonUtil.createJsonString(subscribeReq), str3));
                }
                return this.c.doWrite(new e("push.subscribe", JsonUtil.createJsonString(subscribeReq), str3));
            } else {
                HMSLog.e("HmsMessaging", "no network");
                throw a.a(a.ERROR_NO_NETWORK);
            }
        } catch (ApiException e) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(e);
            g.a(this.b, "push.subscribe", str3, e.getStatusCode());
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.setException(a.a(a.ERROR_INTERNAL_ERROR));
            g.a(this.b, "push.subscribe", str3, a.ERROR_INTERNAL_ERROR);
            return taskCompletionSource2.getTask();
        }
    }

    public void send(RemoteMessage remoteMessage) {
        if (ProxyCenter.getInstance().getProxy() == null) {
            String a2 = g.a(this.b, "push.sendMessage");
            HMSLog.i("HmsMessaging", "send upstream message");
            a(remoteMessage, a2);
            return;
        }
        HMSLog.e("HmsMessaging", "Operation(send) unsupported");
        throw new UnsupportedOperationException("Operation(send) unsupported");
    }

    private void a(RemoteMessage remoteMessage, String str) {
        a a2 = j.a(this.b);
        if (a2 != a.SUCCESS) {
            HMSLog.e("HmsMessaging", "Message sent failed:" + a2.b() + ':' + a2.c());
            g.a(this.b, "push.sendMessage", str, a2);
            throw new UnsupportedOperationException(a2.c());
        } else if (TextUtils.isEmpty(remoteMessage.getTo())) {
            HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
            g.a(this.b, "push.sendMessage", str, a.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'to' missing");
        } else if (TextUtils.isEmpty(remoteMessage.getMessageId())) {
            HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
            g.a(this.b, "push.sendMessage", str, a.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
        } else if (!TextUtils.isEmpty(remoteMessage.getData())) {
            UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
            upSendMsgReq.setPackageName(this.b.getPackageName());
            upSendMsgReq.setMessageId(remoteMessage.getMessageId());
            upSendMsgReq.setTo(remoteMessage.getTo());
            upSendMsgReq.setData(remoteMessage.getData());
            upSendMsgReq.setMessageType(remoteMessage.getMessageType());
            upSendMsgReq.setTtl(remoteMessage.getTtl());
            upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
            upSendMsgReq.setSendMode(remoteMessage.getSendMode());
            upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
            if (w.a()) {
                this.c.doWrite(new b("push.sendMessage", JsonUtil.createJsonString(upSendMsgReq), str));
            } else {
                a(upSendMsgReq, str);
            }
        } else {
            HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
            g.a(this.b, "push.sendMessage", str, a.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'data' missing");
        }
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getInstance().getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn on for proxy");
            new ac(this.b, "push_notify_flag").a("notify_msg_enable", false);
            return b();
        }
        String a2 = g.a(this.b, "push.setNotifyFlag");
        HMSLog.i("HmsMessaging", "invoke turnOnPush");
        return a(true, a2);
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getInstance().getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn off for proxy");
            new ac(this.b, "push_notify_flag").a("notify_msg_enable", true);
            return b();
        }
        String a2 = g.a(this.b, "push.setNotifyFlag");
        HMSLog.i("HmsMessaging", "invoke turnOffPush");
        return a(false, a2);
    }

    private Task<Void> a(boolean z, String str) {
        if (!w.a(this.b) || w.a()) {
            HMSLog.i("HmsMessaging", "turn on/off with AIDL");
            EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
            enableNotifyReq.setPackageName(this.b.getPackageName());
            enableNotifyReq.setEnable(z);
            return this.c.doWrite(new b("push.setNotifyFlag", JsonUtil.createJsonString(enableNotifyReq), str));
        } else if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
            HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(a.a(a.ERROR_OPERATION_NOT_SUPPORTED));
            g.a(this.b, "push.setNotifyFlag", str, a.ERROR_OPERATION_NOT_SUPPORTED);
            return taskCompletionSource.getTask();
        } else if (w.b(this.b) < 90101310) {
            HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
            Context context = this.b;
            Intent putExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(context, this.b.getPackageName() + "#" + z));
            putExtra.setPackage("android");
            return Tasks.callInBackground(new c(this.b, putExtra, str));
        } else {
            HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
            new ac(this.b, "push_notify_flag").a("notify_msg_enable", !z);
            Uri parse = Uri.parse("content://" + this.b.getPackageName() + ".huawei.push.provider/push_notify_flag.xml");
            Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
            intent.putExtra("type", "enalbeFlag");
            intent.putExtra("pkgName", this.b.getPackageName());
            intent.putExtra("url", parse);
            intent.setPackage("android");
            return Tasks.callInBackground(new c(this.b, intent, str));
        }
    }

    private void a(UpSendMsgReq upSendMsgReq, String str) {
        upSendMsgReq.setToken(y.a(this.b, "push_client_self_info"));
        try {
            this.c.doWrite(new d("push.sendMessage", JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                g.a(this.b, "push.sendMessage", str, ((ApiException) e.getCause()).getStatusCode());
            } else {
                g.a(this.b, "push.sendMessage", str, a.ERROR_INTERNAL_ERROR);
            }
        }
    }

    private Task<Void> a() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(a.a(a.ERROR_OPERATION_NOT_SUPPORTED));
        return taskCompletionSource.getTask();
    }

    private Task<Void> b() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(null);
        return taskCompletionSource.getTask();
    }
}
