package com.coolapk.market.service;

import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.service.action.AppLoadServiceAction;
import com.coolapk.market.service.action.CheckForUpgradeAction;
import com.coolapk.market.service.action.UpdateAppStatusAction;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/service/AppService;", "Lcom/coolapk/market/service/TaskService;", "()V", "isFirstForeground", "", "serviceActions", "Ljava/util/ArrayList;", "Lcom/coolapk/market/service/ServiceAction;", "Lkotlin/collections/ArrayList;", "getServiceActions", "", "onCreate", "", "onDestroy", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppService.kt */
public final class AppService extends TaskService {
    public static final String ACTION_CHECK_FOR_UPGRADE = "ACTION_CHECK_FOR_UPGRADE";
    public static final String ACTION_LOAD_MOBILE_APP = "ACTION_LOAD_MOBILE_APP";
    public static final String ACTION_UPDATE_MOBILE_APP_STATUS = "ACTION_UPDATE_MOBILE_APP_STATUS";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_FOREGROUND = "FOREGROUND";
    public static final String KEY_NOTIFY = "NOTIFY";
    public static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";
    private boolean isFirstForeground = true;
    private final ArrayList<ServiceAction> serviceActions = CollectionsKt.arrayListOf(new AppLoadServiceAction(), new CheckForUpgradeAction(), new UpdateAppStatusAction());

    public AppService() {
        super("AppService");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/service/AppService$Companion;", "", "()V", "ACTION_CHECK_FOR_UPGRADE", "", "ACTION_LOAD_MOBILE_APP", "ACTION_UPDATE_MOBILE_APP_STATUS", "KEY_FOREGROUND", "KEY_NOTIFY", "KEY_PACKAGE_NAME", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtils.i("AppService on create", new Object[0]);
    }

    @Override // com.coolapk.market.service.TaskService, android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.isFirstForeground && Build.VERSION.SDK_INT >= 26) {
            if (intent != null ? intent.getBooleanExtra("FOREGROUND", false) : false) {
                this.isFirstForeground = false;
                startForeground(6, new NotificationCompat.Builder(getApplicationContext(), String.valueOf(6)).setContentTitle("酷安后台服务").setSmallIcon(2131231756).setColor(ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099784)).setContentText("").setAutoCancel(true).build());
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i("AppService on destroy", new Object[0]);
    }

    @Override // com.coolapk.market.service.TaskService
    protected List<ServiceAction> getServiceActions() {
        return this.serviceActions;
    }
}
