package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.en;
import com.xiaomi.push.ew;
import com.xiaomi.push.hg;
import com.xiaomi.push.im;
import com.xiaomi.push.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PushMessageHandler extends BaseService {
    private static List<MiPushClient.ICallbackResult> a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f138a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private static List<MiPushClient.MiPushClientCallback> b = new ArrayList();

    interface a extends Serializable {
    }

    protected static void a() {
        synchronized (b) {
            b.clear();
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                miPushClientCallback.onInitializeResult(j, str, str2);
            }
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e) {
            b.m41a(e.getMessage());
        }
    }

    public static void a(Context context, Intent intent) {
        b.c("addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    private static void a(Context context, Intent intent, ResolveInfo resolveInfo) {
        try {
            MessageHandleService.addJob(context.getApplicationContext(), new MessageHandleService.a(intent, (PushMessageReceiver) t.a(context, resolveInfo.activityInfo.name).newInstance()));
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), MessageHandleService.class));
        } catch (Throwable th) {
            b.a(th);
        }
    }

    protected static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (a) {
            for (MiPushClient.ICallbackResult iCallbackResult : a) {
                if (iCallbackResult instanceof MiPushClient.UPSRegisterCallBack) {
                    MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                    if (!(miPushCommandMessage == null || miPushCommandMessage.getCommandArguments() == null || miPushCommandMessage.getCommandArguments().size() <= 0)) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    iCallbackResult.onResult(tokenResult);
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (ew.COMMAND_REGISTER.f419a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (ew.COMMAND_SET_ALIAS.f419a.equals(command) || ew.COMMAND_UNSET_ALIAS.f419a.equals(command) || ew.COMMAND_SET_ACCEPT_TIME.f419a.equals(command)) {
                a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (ew.COMMAND_SUBSCRIBE_TOPIC.f419a.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (ew.COMMAND_UNSUBSCRIBE_TOPIC.f419a.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    protected static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    protected static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    protected static void a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (a) {
            if (!a.contains(iCallbackResult)) {
                a.add(iCallbackResult);
            }
        }
    }

    protected static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (b) {
            if (!b.contains(miPushClientCallback)) {
                b.add(miPushClientCallback);
            }
        }
    }

    protected static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    protected static void b() {
        synchronized (a) {
            a.clear();
        }
    }

    protected static void b(Context context, Intent intent) {
        try {
            ResolveInfo resolveInfo = null;
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                n.a(context, intent, null);
            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                hg hgVar = new hg();
                im.a(hgVar, intent.getByteArrayExtra("mipush_payload"));
                b.c("PushMessageHandler.onHandleIntent " + hgVar.d());
                MiTinyDataClient.upload(context, hgVar);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (m55b()) {
                    b.d("receive a message before application calling initialize");
                    return;
                }
                a a2 = ai.a(context).a(intent);
                if (a2 != null) {
                    a(context, a2);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    if (queryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it2 = queryBroadcastReceivers.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            ResolveInfo next = it2.next();
                            if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(t.a(context, next.activityInfo.name))) {
                                resolveInfo = next;
                                break;
                            }
                        }
                    }
                    if (resolveInfo != null) {
                        a(context, intent2, resolveInfo);
                        return;
                    }
                    b.d("cannot find the receiver to handler this message, check your manifest");
                    en.a(context).a(context.getPackageName(), intent, "11");
                } catch (Exception e) {
                    b.a(e);
                    en.a(context).a(context.getPackageName(), intent, "9");
                }
            }
        } catch (Throwable th) {
            b.a(th);
            en.a(context).a(context.getPackageName(), intent, "10");
        }
    }

    protected static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m55b() {
        return b.isEmpty();
    }

    private static void c(Context context, Intent intent) {
        if (intent != null && !f138a.isShutdown()) {
            f138a.execute(new ah(context, intent));
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a  reason: collision with other method in class */
    protected boolean mo56a() {
        ThreadPoolExecutor threadPoolExecutor = f138a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f138a.getQueue().size() <= 0) ? false : true;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        c(getApplicationContext(), intent);
    }
}
