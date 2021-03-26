package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.dv;
import com.xiaomi.push.ea;
import com.xiaomi.push.j;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MessageHandleService extends BaseService {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f105a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static class a {
        private Intent a;

        /* renamed from: a  reason: collision with other field name */
        private PushMessageReceiver f106a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f106a = pushMessageReceiver;
            this.a = intent;
        }

        public Intent a() {
            return this.a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m30a() {
            return this.f106a;
        }
    }

    protected static void a(Context context, Intent intent) {
        if (intent != null) {
            b(context);
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(Context context) {
        if (!f105a.isShutdown()) {
            f105a.execute(new ab(context));
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context) {
        String[] stringArrayExtra;
        try {
            a poll = a.poll();
            if (poll != null) {
                PushMessageReceiver a2 = poll.m30a();
                Intent a3 = poll.a();
                int intExtra = a3.getIntExtra("message_type", 1);
                if (intExtra == 1) {
                    PushMessageHandler.a a4 = an.a(context).a(a3);
                    int intExtra2 = a3.getIntExtra("eventMessageType", -1);
                    if (a4 == null) {
                        return;
                    }
                    if (a4 instanceof MiPushMessage) {
                        MiPushMessage miPushMessage = (MiPushMessage) a4;
                        if (!miPushMessage.isArrivedMessage()) {
                            a2.onReceiveMessage(context, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            dv.a(context.getApplicationContext()).a(context.getPackageName(), a3, 2004, (String) null);
                            c.a("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                            a2.onReceivePassThroughMessage(context, miPushMessage);
                            return;
                        } else if (miPushMessage.isNotified()) {
                            if (intExtra2 == 1000) {
                                dv.a(context.getApplicationContext()).a(context.getPackageName(), a3, 1007, (String) null);
                            } else {
                                dv.a(context.getApplicationContext()).a(context.getPackageName(), a3, 3007, (String) null);
                            }
                            c.a("begin execute onNotificationMessageClicked from　" + miPushMessage.getMessageId());
                            a2.onNotificationMessageClicked(context, miPushMessage);
                            return;
                        } else {
                            a2.onNotificationMessageArrived(context, miPushMessage);
                            return;
                        }
                    } else if (a4 instanceof MiPushCommandMessage) {
                        MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a4;
                        c.a("begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                        a2.onCommandResult(context, miPushCommandMessage);
                        if (TextUtils.equals(miPushCommandMessage.getCommand(), ea.COMMAND_REGISTER.k)) {
                            a2.onReceiveRegisterResult(context, miPushCommandMessage);
                            PushMessageHandler.a(context, miPushCommandMessage);
                            if (miPushCommandMessage.getResultCode() != 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (intExtra == 3) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a3.getSerializableExtra("key_command");
                    c.a("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    a2.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), ea.COMMAND_REGISTER.k)) {
                        a2.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() != 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (intExtra == 5 && "error_lack_of_permission".equals(a3.getStringExtra("error_type")) && (stringArrayExtra = a3.getStringArrayExtra("error_message")) != null) {
                    c.a("begin execute onRequirePermissions, lack of necessary permissions");
                    a2.onRequirePermissions(context, stringArrayExtra);
                    return;
                } else {
                    return;
                }
                h.b(context);
            }
        } catch (RuntimeException e) {
            c.a(e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        j.a(context).a(new aa(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo35a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
