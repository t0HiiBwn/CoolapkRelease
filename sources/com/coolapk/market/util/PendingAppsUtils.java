package com.coolapk.market.util;

import android.content.Context;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.model.PendingCheckStateApp;
import com.github.salomonbrys.kotson.GsonBuilderKt;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0003J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J(\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/util/PendingAppsUtils;", "", "()V", "ACTION_ADD", "", "ACTION_REINSTALL", "ACTION_REMOVE", "doAddAction", "", "context", "Landroid/content/Context;", "packageName", "doPendingActions", "doPendingReinstallAction", "doRemoveAction", "getPendingApps", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/PendingCheckStateApp;", "Lkotlin/collections/ArrayList;", "prefKey", "pendingAppToCheck", "action", "pendingAppToReinstall", "key", "savePendingApps", "apps", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PendingAppsUtils.kt */
public final class PendingAppsUtils {
    public static final String ACTION_ADD = "add";
    public static final String ACTION_REINSTALL = "re-install";
    public static final String ACTION_REMOVE = "remove";
    public static final PendingAppsUtils INSTANCE = new PendingAppsUtils();

    private PendingAppsUtils() {
    }

    @JvmStatic
    public static final void pendingAppToCheck(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "packageName");
        LogUtils.v("加入延迟检测状态 [" + str + " : " + str2 + ']', new Object[0]);
        ArrayList<PendingCheckStateApp> pendingApps = getPendingApps("PENDING_CHECK_STATE_APPS");
        for (int size = pendingApps.size() + -1; size >= 0; size--) {
            PendingCheckStateApp pendingCheckStateApp = pendingApps.get(size);
            Intrinsics.checkNotNullExpressionValue(pendingCheckStateApp, "apps[index]");
            if (Intrinsics.areEqual(pendingCheckStateApp.getPackageName(), str2)) {
                pendingApps.remove(size);
            }
        }
        pendingApps.add(new PendingCheckStateApp(str, str2, null, null, 12, null));
        INSTANCE.savePendingApps("PENDING_CHECK_STATE_APPS", pendingApps);
    }

    @JvmStatic
    public static final void pendingAppToReinstall(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "key");
        Intrinsics.checkNotNullParameter(str3, "packageName");
        LogUtils.v("加入延迟检测状态 [" + str + " : " + str2 + ']', new Object[0]);
        ArrayList<PendingCheckStateApp> pendingApps = getPendingApps("PENDING_REINSTALL_APPS");
        for (int size = pendingApps.size() + -1; size >= 0; size--) {
            PendingCheckStateApp pendingCheckStateApp = pendingApps.get(size);
            Intrinsics.checkNotNullExpressionValue(pendingCheckStateApp, "apps[index]");
            if (Intrinsics.areEqual(pendingCheckStateApp.getKey(), str2)) {
                pendingApps.remove(size);
            }
        }
        pendingApps.add(new PendingCheckStateApp(str, str3, str2, Long.valueOf(System.currentTimeMillis())));
        INSTANCE.savePendingApps("PENDING_REINSTALL_APPS", pendingApps);
    }

    private final void savePendingApps(String str, ArrayList<PendingCheckStateApp> arrayList) {
        String json = new Gson().toJson(arrayList);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString(str, json).apply();
    }

    @JvmStatic
    private static final ArrayList<PendingCheckStateApp> getPendingApps(String str) {
        Type type;
        String preferencesString = DataManager.getInstance().getPreferencesString(str, "[]");
        Gson gson = new Gson();
        Intrinsics.checkNotNullExpressionValue(preferencesString, "jsonString");
        Type type2 = new PendingAppsUtils$getPendingApps$$inlined$fromJson$1().getType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (GsonBuilderKt.isWildcard(parameterizedType)) {
                type = parameterizedType.getRawType();
                Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                Object fromJson = gson.fromJson(preferencesString, type);
                Intrinsics.checkExpressionValueIsNotNull(fromJson, "fromJson(json, typeToken<T>())");
                return (ArrayList) fromJson;
            }
        }
        type = GsonBuilderKt.removeTypeWildcards(type2);
        Object fromJson = gson.fromJson(preferencesString, type);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "fromJson(json, typeToken<T>())");
        return (ArrayList) fromJson;
    }

    @JvmStatic
    public static final void doPendingActions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<PendingCheckStateApp> pendingApps = getPendingApps("PENDING_CHECK_STATE_APPS");
        if (pendingApps.isEmpty()) {
            LogUtils.v("没有需要检查状态的App", new Object[0]);
            return;
        }
        LogUtils.v("清除需要检查状态的Apps", new Object[0]);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("PENDING_CHECK_STATE_APPS", "[]").apply();
        for (T t : pendingApps) {
            LogUtils.v("检查" + t.getPackageName() + "的状态", new Object[0]);
            String action = t.getAction();
            int hashCode = action.hashCode();
            if (hashCode != -934610812) {
                if (hashCode == 96417 && action.equals("add")) {
                    doAddAction(context, t.getPackageName());
                }
            } else if (action.equals("remove")) {
                doRemoveAction(context, t.getPackageName());
            }
        }
    }

    public final void doPendingReinstallAction(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "packageName");
        ArrayList<PendingCheckStateApp> pendingApps = getPendingApps("PENDING_REINSTALL_APPS");
        if (pendingApps.isEmpty()) {
            LogUtils.v("没有需要重装的App", new Object[0]);
            return;
        }
        LogUtils.v("清除需要重装的Apps", new Object[0]);
        Integer num = null;
        Iterator<T> it2 = pendingApps.iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (Intrinsics.areEqual(it2.next().getPackageName(), str)) {
                num = Integer.valueOf(i);
            }
            i++;
        }
        if (num != null) {
            PendingCheckStateApp remove = pendingApps.remove(num.intValue());
            Intrinsics.checkNotNullExpressionValue(remove, "apps.removeAt(reinstallAppIndex)");
            PendingCheckStateApp pendingCheckStateApp = remove;
            long currentTimeMillis = System.currentTimeMillis();
            Long timestamp = pendingCheckStateApp.getTimestamp();
            Intrinsics.checkNotNull(timestamp);
            if (currentTimeMillis - timestamp.longValue() > ((long) 120000)) {
                LogUtils.v("重装检测超时，忽略" + pendingCheckStateApp.getPackageName() + "的重装", new Object[0]);
            }
            InstallState installState = DataManager.getInstance().getInstallState(pendingCheckStateApp.getKey());
            if (installState != null) {
                LogUtils.v("重装" + pendingCheckStateApp.getPackageName(), new Object[0]);
                ActionManager.install(context, installState.getPath(), installState.getFrom(), installState.getExtra(), false);
            }
            savePendingApps("PENDING_REINSTALL_APPS", pendingApps);
        }
    }

    @JvmStatic
    public static final void doAddAction(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "packageName");
        ActionManager.startUpdateMobileAppStatus(context, str);
        ActionManager.startCheckMobileAppForUpgrade(context, str);
        ActionManager.packageAdded(context, str);
    }

    @JvmStatic
    public static final void doRemoveAction(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "packageName");
        ActionManager.startUpdateMobileAppStatus(context, str);
        ActionManager.statUninstall(context, str, null, null, null);
    }
}
