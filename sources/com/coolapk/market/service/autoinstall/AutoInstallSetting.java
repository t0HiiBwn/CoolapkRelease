package com.coolapk.market.service.autoinstall;

import com.coolapk.market.AppHolder;
import com.coolapk.market.util.PackageUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010$\u001a\u00020\u001fH\u0007J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0005R,\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR,\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\t¨\u0006("}, d2 = {"Lcom/coolapk/market/service/autoinstall/AutoInstallSetting;", "", "()V", "installPackageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInstallPackageList$annotations", "getInstallPackageList", "()Ljava/util/ArrayList;", "invokeEnable", "", "getInvokeEnable$annotations", "getInvokeEnable", "()Z", "setInvokeEnable", "(Z)V", "invokeGlobal", "getInvokeGlobal$annotations", "getInvokeGlobal", "setInvokeGlobal", "lastPerformBackTime", "", "getLastPerformBackTime", "()J", "setLastPerformBackTime", "(J)V", "uninstallPackageList", "getUninstallPackageList$annotations", "getUninstallPackageList", "addToInstallPackageList", "", "path", "title", "addToUninstallPackageList", "packageName", "clearPackageList", "removeFromInstallPackageList", "appName", "removeFromUninstallPackageList", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AutoInstallUtil.kt */
public final class AutoInstallSetting {
    public static final AutoInstallSetting INSTANCE = new AutoInstallSetting();
    private static final ArrayList<String> installPackageList = new ArrayList<>();
    private static boolean invokeEnable;
    private static boolean invokeGlobal;
    private static long lastPerformBackTime = -1;
    private static final ArrayList<String> uninstallPackageList = new ArrayList<>();

    @JvmStatic
    public static /* synthetic */ void getInstallPackageList$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getInvokeEnable$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getInvokeGlobal$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getUninstallPackageList$annotations() {
    }

    private AutoInstallSetting() {
    }

    public final long getLastPerformBackTime() {
        return lastPerformBackTime;
    }

    public final void setLastPerformBackTime(long j) {
        lastPerformBackTime = j;
    }

    public static final boolean getInvokeEnable() {
        return invokeEnable;
    }

    public static final void setInvokeEnable(boolean z) {
        invokeEnable = z;
    }

    public static final boolean getInvokeGlobal() {
        return invokeGlobal;
    }

    public static final void setInvokeGlobal(boolean z) {
        invokeGlobal = z;
    }

    public static final ArrayList<String> getInstallPackageList() {
        return installPackageList;
    }

    public static final ArrayList<String> getUninstallPackageList() {
        return uninstallPackageList;
    }

    @JvmStatic
    public static final void addToInstallPackageList(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "path");
        String archiveLabel = PackageUtils.getArchiveLabel(AppHolder.getApplication(), str);
        if (archiveLabel != null) {
            str2 = archiveLabel;
        }
        if (str2 != null) {
            invokeEnable = true;
            ArrayList<String> arrayList = installPackageList;
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
            AutoInstallUtilKt.autoInstallLogD("addToInstallPackageList: " + str2, new Object[0]);
        }
    }

    public final void removeFromInstallPackageList(String str) {
        Intrinsics.checkNotNullParameter(str, "appName");
        installPackageList.remove(str);
    }

    @JvmStatic
    public static final void addToUninstallPackageList(String str, String str2) {
        String obj;
        Intrinsics.checkNotNullParameter(str, "packageName");
        CharSequence applicationLabel = PackageUtils.getApplicationLabel(AppHolder.getApplication(), str);
        if (!(applicationLabel == null || (obj = applicationLabel.toString()) == null)) {
            str2 = obj;
        }
        if (str2 != null) {
            invokeEnable = true;
            ArrayList<String> arrayList = uninstallPackageList;
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
            AutoInstallUtilKt.autoInstallLogD("addToUninstallPackageList: " + str2, new Object[0]);
        }
    }

    public final void removeFromUninstallPackageList(String str) {
        Intrinsics.checkNotNullParameter(str, "appName");
        uninstallPackageList.remove(str);
    }

    @JvmStatic
    public static final void clearPackageList() {
        invokeEnable = false;
        installPackageList.clear();
        uninstallPackageList.clear();
    }
}
