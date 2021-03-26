package com.coolapk.market.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/util/PowerSaverHelper;", "", "()V", "getDozeState", "Lcom/coolapk/market/util/PowerSaverHelper$DozeState;", "context", "Landroid/content/Context;", "getIfAppIsWhiteListedFromBatteryOptimizations", "Lcom/coolapk/market/util/PowerSaverHelper$WhiteListedInBatteryOptimizations;", "packageName", "", "getPowerSaveState", "Lcom/coolapk/market/util/PowerSaverHelper$PowerSaveState;", "prepareIntentForWhiteListingOfBatteryOptimization", "Landroid/content/Intent;", "alsoWhenWhiteListed", "", "registerPowerSaveReceiver", "receiver", "Landroid/content/BroadcastReceiver;", "DozeState", "PowerSaveState", "WhiteListedInBatteryOptimizations", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PowerSaverHelper.kt */
public final class PowerSaverHelper {
    public static final PowerSaverHelper INSTANCE = new PowerSaverHelper();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/util/PowerSaverHelper$DozeState;", "", "(Ljava/lang/String;I)V", "NORMAL_INTERACTIVE", "DOZE_TURNED_ON_IDLE", "NORMAL_NON_INTERACTIVE", "ERROR_GETTING_STATE", "IRRELEVANT_OLD_ANDROID_API", "UNKNOWN_TOO_OLD_ANDROID_API_FOR_CHECKING", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PowerSaverHelper.kt */
    public enum DozeState {
        NORMAL_INTERACTIVE,
        DOZE_TURNED_ON_IDLE,
        NORMAL_NON_INTERACTIVE,
        ERROR_GETTING_STATE,
        IRRELEVANT_OLD_ANDROID_API,
        UNKNOWN_TOO_OLD_ANDROID_API_FOR_CHECKING
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/util/PowerSaverHelper$PowerSaveState;", "", "(Ljava/lang/String;I)V", "ON", "OFF", "ERROR_GETTING_STATE", "IRRELEVANT_OLD_ANDROID_API", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PowerSaverHelper.kt */
    public enum PowerSaveState {
        ON,
        OFF,
        ERROR_GETTING_STATE,
        IRRELEVANT_OLD_ANDROID_API
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WhiteListedInBatteryOptimizations.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WhiteListedInBatteryOptimizations.WHITE_LISTED.ordinal()] = 1;
            iArr[WhiteListedInBatteryOptimizations.NOT_WHITE_LISTED.ordinal()] = 2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/util/PowerSaverHelper$WhiteListedInBatteryOptimizations;", "", "(Ljava/lang/String;I)V", "WHITE_LISTED", "NOT_WHITE_LISTED", "ERROR_GETTING_STATE", "UNKNOWN_TOO_OLD_ANDROID_API_FOR_CHECKING", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PowerSaverHelper.kt */
    public enum WhiteListedInBatteryOptimizations {
        WHITE_LISTED,
        NOT_WHITE_LISTED,
        ERROR_GETTING_STATE,
        UNKNOWN_TOO_OLD_ANDROID_API_FOR_CHECKING
    }

    private PowerSaverHelper() {
    }

    public final DozeState getDozeState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            return DozeState.UNKNOWN_TOO_OLD_ANDROID_API_FOR_CHECKING;
        }
        Object systemService = context.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService;
        if (powerManager.isDeviceIdleMode()) {
            return DozeState.DOZE_TURNED_ON_IDLE;
        }
        return powerManager.isInteractive() ? DozeState.NORMAL_INTERACTIVE : DozeState.NORMAL_NON_INTERACTIVE;
    }

    public final PowerSaveState getPowerSaveState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) systemService).isPowerSaveMode()) {
            return PowerSaveState.ON;
        }
        return PowerSaveState.OFF;
    }

    public final WhiteListedInBatteryOptimizations getIfAppIsWhiteListedFromBatteryOptimizations(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "packageName");
        if (Build.VERSION.SDK_INT < 23) {
            return WhiteListedInBatteryOptimizations.UNKNOWN_TOO_OLD_ANDROID_API_FOR_CHECKING;
        }
        Object systemService = context.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) systemService).isIgnoringBatteryOptimizations(str)) {
            return WhiteListedInBatteryOptimizations.WHITE_LISTED;
        }
        return WhiteListedInBatteryOptimizations.NOT_WHITE_LISTED;
    }

    public final Intent prepareIntentForWhiteListingOfBatteryOptimization(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "packageName");
        if (ContextCompat.checkSelfPermission(context, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") == -1) {
            return null;
        }
        Intent intent = null;
        int i = WhenMappings.$EnumSwitchMapping$0[getIfAppIsWhiteListedFromBatteryOptimizations(context, str).ordinal()];
        if (i == 1) {
            return z ? new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS") : intent;
        }
        if (i != 2) {
            return intent;
        }
        return new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + str));
    }

    public final boolean registerPowerSaveReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(broadcastReceiver, "receiver");
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        context.registerReceiver(broadcastReceiver, intentFilter);
        return true;
    }
}
