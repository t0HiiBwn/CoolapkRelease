package com.coolapk.market;

import android.app.Application;
import android.os.Bundle;
import com.blankj.utilcode.util.AppUtils;
import com.coolapk.market.util.SystemUtils;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0019\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0019\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0019\u0010\u001e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b \u0010\"R\u0011\u0010#\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010$\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0019\u0010%\u001a\n \u0007*\u0004\u0018\u00010&0&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/coolapk/market/AppMetadata;", "", "appContext", "Landroid/app/Application;", "(Landroid/app/Application;)V", "appMode", "", "kotlin.jvm.PlatformType", "getAppMode", "()Ljava/lang/String;", "appMode$delegate", "Lkotlin/Lazy;", "appModeFromMeta", "getAppModeFromMeta", "appVersionCode", "", "getAppVersionCode", "()I", "appVersionName", "getAppVersionName", "authority", "getAuthority", "channel", "getChannel", "defaultCacheDir", "Ljava/io/File;", "getDefaultCacheDir", "()Ljava/io/File;", "defaultDownloadDir", "getDefaultDownloadDir", "deviceId", "getDeviceId", "isCommunityMode", "", "()Z", "isDefaultMode", "isMarketMode", "metaData", "Landroid/os/Bundle;", "getMetaData", "()Landroid/os/Bundle;", "changeAppMode", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppMetadata.kt */
public final class AppMetadata {
    public static final String APP_MODE_COMMUNITY = "community";
    public static final String APP_MODE_MARKET = "market";
    public static final String APP_MODE_UNIVERSAL = "universal";
    public static final Companion Companion = new Companion(null);
    public static final String PREFERENCES_NAME = "coolapk_preferences_v7";
    private final Application appContext;
    private final Lazy appMode$delegate;
    private final String appModeFromMeta;
    private final int appVersionCode = AppUtils.getAppVersionCode();
    private final String appVersionName = AppUtils.getAppVersionName();
    private final String authority;
    private final String channel;
    private final String deviceId;
    private final boolean isCommunityMode;
    private final boolean isDefaultMode;
    private final boolean isMarketMode;
    private final Bundle metaData;

    public final String getAppMode() {
        return (String) this.appMode$delegate.getValue();
    }

    public AppMetadata(Application application) {
        Intrinsics.checkNotNullParameter(application, "appContext");
        this.appContext = application;
        this.deviceId = SystemUtils.getDeviceId(application);
        this.authority = SystemUtils.getAuthority(application);
        Bundle metaData2 = SystemUtils.getMetaData(application);
        this.metaData = metaData2;
        this.channel = metaData2.getString("CHANNEL", "coolapk");
        this.appMode$delegate = LazyKt.lazy(new AppMetadata$appMode$2(this));
        this.appModeFromMeta = metaData2.getString("APP_MODE", "universal");
        this.isDefaultMode = Intrinsics.areEqual(getAppMode(), "universal");
        this.isCommunityMode = Intrinsics.areEqual(getAppMode(), "community");
        this.isMarketMode = Intrinsics.areEqual(getAppMode(), "universal");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/AppMetadata$Companion;", "", "()V", "APP_MODE_COMMUNITY", "", "APP_MODE_MARKET", "APP_MODE_UNIVERSAL", "PREFERENCES_NAME", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppMetadata.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getAppVersionName() {
        return this.appVersionName;
    }

    public final int getAppVersionCode() {
        return this.appVersionCode;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getAuthority() {
        return this.authority;
    }

    public final Bundle getMetaData() {
        return this.metaData;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getAppModeFromMeta() {
        return this.appModeFromMeta;
    }

    public final boolean isDefaultMode() {
        return this.isDefaultMode;
    }

    public final boolean isCommunityMode() {
        return this.isCommunityMode;
    }

    public final boolean isMarketMode() {
        return this.isMarketMode;
    }

    public final File getDefaultDownloadDir() {
        File defaultDownloadDir = SystemUtils.getDefaultDownloadDir(this.appContext);
        Intrinsics.checkNotNullExpressionValue(defaultDownloadDir, "SystemUtils.getDefaultDownloadDir(appContext)");
        return defaultDownloadDir;
    }

    public final File getDefaultCacheDir() {
        File defaultCacheDir = SystemUtils.getDefaultCacheDir(this.appContext);
        Intrinsics.checkNotNullExpressionValue(defaultCacheDir, "SystemUtils.getDefaultCacheDir(appContext)");
        return defaultCacheDir;
    }

    public final void changeAppMode(String str) {
        Intrinsics.checkNotNullParameter(str, "appMode");
        this.appContext.getSharedPreferences("coolapk_preferences_v7", 0).edit().putString("app_mode", str).apply();
    }
}
