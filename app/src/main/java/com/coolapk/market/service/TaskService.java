package com.coolapk.market.service;

import android.app.IntentService;
import android.content.Intent;
import com.coolapk.market.util.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\bH$J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\"\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R2\u0010\u0005\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u0003 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/service/TaskService;", "Landroid/app/IntentService;", "name", "", "(Ljava/lang/String;)V", "taskQueue", "", "kotlin.jvm.PlatformType", "", "getServiceAction", "Lcom/coolapk/market/service/ServiceAction;", "action", "getServiceActions", "onHandleIntent", "", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "removeRepeatedIntentAction", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TaskService.kt */
public abstract class TaskService extends IntentService {
    public static final Companion Companion = new Companion(null);
    private final List<String> taskQueue = Collections.synchronizedList(new ArrayList());

    protected abstract List<ServiceAction> getServiceActions();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskService(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "name");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/service/TaskService$Companion;", "", "()V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TaskService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        removeRepeatedIntentAction(intent);
        return super.onStartCommand(intent, i, i2);
    }

    private final void removeRepeatedIntentAction(Intent intent) {
        String action;
        if (intent != null && (action = intent.getAction()) != null) {
            Intrinsics.checkNotNullExpressionValue(action, "intent.action ?: return");
            ServiceAction serviceAction = getServiceAction(action);
            if (serviceAction != null) {
                String taskKey = serviceAction.getTaskKey(intent);
                LogUtils.v("接收到Action: " + action + "，任务Key: " + taskKey, new Object[0]);
                if (!this.taskQueue.contains(taskKey)) {
                    LogUtils.i("任务(" + taskKey + ")加入队列", new Object[0]);
                    this.taskQueue.add(taskKey);
                    serviceAction.onStartAction(this, intent);
                    return;
                }
                LogUtils.v("任务(" + taskKey + ")已存在，不需要加入队列", new Object[0]);
            }
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String action;
        if (intent != null && (action = intent.getAction()) != null) {
            Intrinsics.checkNotNullExpressionValue(action, "intent.action ?: return");
            ServiceAction serviceAction = getServiceAction(action);
            if (serviceAction != null) {
                String taskKey = serviceAction.getTaskKey(intent);
                if (this.taskQueue.contains(taskKey)) {
                    LogUtils.v("任务(" + taskKey + ")执行", new Object[0]);
                    serviceAction.onHandleAction(this, intent);
                    this.taskQueue.remove(taskKey);
                    return;
                }
                LogUtils.v("任务(" + taskKey + ")被移除，不执行", new Object[0]);
            }
        }
    }

    private final ServiceAction getServiceAction(String str) {
        T t;
        Iterator<T> it2 = getServiceActions().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t.isThisAction(str)) {
                break;
            }
        }
        return t;
    }
}
