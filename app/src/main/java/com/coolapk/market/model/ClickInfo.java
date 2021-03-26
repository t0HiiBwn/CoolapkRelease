package com.coolapk.market.model;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.AutoValue_ClickInfo;
import java.util.Arrays;
import java.util.List;

public abstract class ClickInfo {

    public interface ClickHandleListener {
        boolean onClickHandleDownload(State state);

        boolean onClickHandleInstall(State state);

        boolean onClickHandleNone(State state);

        boolean onClickHandleOpen(State state);

        boolean onClickHandleStop(State state);
    }

    public static class ClickHandleListenerAdapter implements ClickHandleListener {
        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleDownload(State state) {
            return false;
        }

        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleInstall(State state) {
            return false;
        }

        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleNone(State state) {
            return false;
        }

        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleOpen(State state) {
            return false;
        }

        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleStop(State state) {
            return false;
        }
    }

    public static class DownloadOnlyClickHandleAdapter implements ClickHandleListener {
        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleDownload(State state) {
            return false;
        }

        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleInstall(State state) {
            return true;
        }

        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleNone(State state) {
            return true;
        }

        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleOpen(State state) {
            return true;
        }

        @Override // com.coolapk.market.model.ClickInfo.ClickHandleListener
        public boolean onClickHandleStop(State state) {
            return true;
        }
    }

    public abstract ClickHandleListener getClickHandleListener();

    abstract List<String> getDownloadKeys();

    public abstract String getPackageName();

    public abstract Extra getTargetExtra();

    public abstract int getTargetFlag();

    public abstract String getTargetUrl();

    public abstract String getUninstallKey();

    public String[] getDownloadKeyArray() {
        return (String[]) getDownloadKeys().toArray(new String[getDownloadKeys().size()]);
    }

    public static Builder newBuilder(AppForum appForum) {
        Extra extra = new Extra();
        extra.put("TITLE", appForum.appName());
        extra.put("PACKAGE_NAME", appForum.packageName());
        extra.put("VERSION_NAME", appForum.versionName());
        extra.put("VERSION_CODE", appForum.versionCode());
        extra.put("APK_SIZE", appForum.apkSize());
        extra.put("LOGO", appForum.logo());
        extra.put("APK_ID", appForum.id());
        extra.put("EXTRA_ANALYSIS_DATA", appForum.extraAnalysisData());
        return new AutoValue_ClickInfo.Builder().targetExtra(extra).uninstallKey(appForum.packageName()).targetFlag(0);
    }

    public static Builder newBuilder(ServiceApp serviceApp) {
        Extra extra = new Extra();
        extra.put("TITLE", serviceApp.getAppName());
        extra.put("PACKAGE_NAME", serviceApp.getPackageName());
        extra.put("VERSION_NAME", serviceApp.getVersionName());
        extra.put("VERSION_CODE", serviceApp.getVersionCode());
        extra.put("APK_SIZE", serviceApp.getApkSize());
        extra.put("LOGO", serviceApp.getLogo());
        extra.put("APK_ID", serviceApp.getApkId());
        extra.put("EXTRA_ANALYSIS_DATA", serviceApp.getExtraAnalysisData());
        extra.put("EXTRA_OPEN_LINK", serviceApp.getOpenLink());
        return new AutoValue_ClickInfo.Builder().packageName(serviceApp.getPackageName()).targetExtra(extra).uninstallKey(serviceApp.getPackageName()).targetFlag(0);
    }

    public static Builder newBuilder(AlbumItem albumItem) {
        Extra extra = new Extra();
        extra.put("TITLE", albumItem.getTitle());
        extra.put("PACKAGE_NAME", albumItem.getPackageName());
        extra.put("VERSION_NAME", albumItem.getVersionName());
        extra.put("VERSION_CODE", albumItem.getVersionCode());
        extra.put("LOGO", albumItem.getLogoUrl());
        extra.put("APK_ID", albumItem.getApkId());
        extra.put("EXTRA_ANALYSIS_DATA", albumItem.getExtraAnalysisData());
        return new AutoValue_ClickInfo.Builder().targetExtra(extra).uninstallKey(albumItem.getPackageName()).targetFlag(0);
    }

    public static Builder newBuilder(Feed feed) {
        Extra extra = new Extra();
        extra.put("TITLE", feed.getExtraTitle());
        extra.put("PACKAGE_NAME", EntityExtendsKt.getApkExtraPackageName(feed));
        extra.put("VERSION_NAME", EntityExtendsKt.getApkExtraVersionName(feed));
        extra.put("VERSION_CODE", EntityExtendsKt.getApkExtraVersionCode(feed));
        extra.put("APK_SIZE", EntityExtendsKt.getApkSize(feed));
        extra.put("LOGO", feed.getExtraPic());
        extra.put("APK_ID", EntityExtendsKt.getApkExtraId(feed));
        extra.put("EXTRA_ANALYSIS_DATA", EntityExtendsKt.getApkExtraAnalysisData(feed));
        return new AutoValue_ClickInfo.Builder().targetExtra(extra).uninstallKey(EntityExtendsKt.getApkExtraPackageName(feed)).targetFlag(0);
    }

    public static Builder newBuilder(MobileApp mobileApp) {
        UpgradeInfo upgradeInfo = mobileApp.getUpgradeInfo();
        if (upgradeInfo != null) {
            Extra extra = new Extra();
            extra.put("TITLE", mobileApp.getAppName());
            extra.put("PACKAGE_NAME", upgradeInfo.getPackageName());
            extra.put("VERSION_NAME", upgradeInfo.getVersionName());
            extra.put("VERSION_CODE", upgradeInfo.getVersionCode());
            extra.put("APK_SIZE", upgradeInfo.getApkSize());
            extra.put("LOGO", upgradeInfo.getLogo());
            extra.put("APK_ID", upgradeInfo.getApkId());
            extra.put("EXTRA_ANALYSIS_DATA", upgradeInfo.getExtraAnalysisData());
            return new AutoValue_ClickInfo.Builder().targetExtra(extra).targetFlag(0);
        }
        throw new RuntimeException("UpgradeInfo can not be null");
    }

    public static Builder newBuilder(VersionApp versionApp, String str, String str2) {
        Extra extra = new Extra();
        extra.put("TITLE", versionApp.getAppName());
        extra.put("PACKAGE_NAME", versionApp.getPackageName());
        extra.put("VERSION_NAME", versionApp.getVersionName());
        extra.put("VERSION_CODE", 0);
        extra.put("APK_SIZE", versionApp.getVersionSize());
        extra.put("LOGO", str2);
        extra.put("APK_ID", str);
        extra.put("VERSION_ID", versionApp.getVersionId());
        extra.put("DOWNLOAD_FROM", versionApp.getDownloadFrom());
        return new AutoValue_ClickInfo.Builder().targetExtra(extra).uninstallKey(versionApp.getPackageName()).targetFlag(0);
    }

    public static Builder newBuilder(DownloadInfo downloadInfo) {
        if (downloadInfo.getExtra() != null) {
            return new AutoValue_ClickInfo.Builder().targetExtra(downloadInfo.getExtra()).targetFlag(0);
        }
        throw new RuntimeException("DownloadInfo's extra can not be null");
    }

    public static abstract class Builder {
        public abstract ClickInfo build();

        public abstract Builder clickHandleListener(ClickHandleListener clickHandleListener);

        abstract Builder downloadKeys(List<String> list);

        public abstract Builder packageName(String str);

        abstract Builder targetExtra(Extra extra);

        public abstract Builder targetFlag(int i);

        public abstract Builder targetUrl(String str);

        public abstract Builder uninstallKey(String str);

        public Builder downloadKeys(String... strArr) {
            return downloadKeys(Arrays.asList(strArr));
        }
    }
}
