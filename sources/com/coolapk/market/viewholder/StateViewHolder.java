package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.DownloadEvent;
import com.coolapk.market.event.Event;
import com.coolapk.market.event.InstallEvent;
import com.coolapk.market.event.UninstallEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.LocalApk;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.model.VersionApp;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.util.StateUtils;

public abstract class StateViewHolder extends BindingViewHolder implements RVStateEventChangedAdapter.IStateViewHolder {
    @Override // com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public abstract boolean onStateEventChanged(Event event);

    public StateViewHolder(View view, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
    }

    public StateViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0074: APUT  (r5v1 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r8v4 java.lang.String) */
    public static boolean isEventBelongTo(Event event, ServiceApp serviceApp) {
        UpgradeInfo upgradeInfo;
        if (event instanceof DownloadEvent) {
            DownloadEvent downloadEvent = (DownloadEvent) event;
            if (TextUtils.equals(serviceApp.getDownloadUrlMd5(0), downloadEvent.key) || TextUtils.equals(serviceApp.getDownloadUrlMd5(2), downloadEvent.key)) {
                return true;
            }
            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
            if (mobileAppExistFast != null && (upgradeInfo = mobileAppExistFast.getUpgradeInfo()) != null && TextUtils.equals(upgradeInfo.getDownloadUrlMd5(1), downloadEvent.key)) {
                return true;
            }
        } else if (event instanceof InstallEvent) {
            MobileApp mobileAppExistFast2 = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
            String str = null;
            UpgradeInfo upgradeInfo2 = mobileAppExistFast2 != null ? mobileAppExistFast2.getUpgradeInfo() : null;
            String[] strArr = new String[4];
            strArr[0] = serviceApp.getDownloadUrlMd5(0);
            strArr[1] = serviceApp.getDownloadUrlMd5(2);
            strArr[2] = upgradeInfo2 != null ? upgradeInfo2.getDownloadUrlMd5(0) : null;
            if (upgradeInfo2 != null) {
                str = upgradeInfo2.getDownloadUrlMd5(1);
            }
            strArr[3] = str;
            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(strArr);
            if (findLatestDownloadState == null || !TextUtils.equals(findLatestDownloadState.getFilePathMd5(), ((InstallEvent) event).key)) {
                return false;
            }
            return true;
        } else if (event instanceof UninstallEvent) {
            return TextUtils.equals(serviceApp.getPackageName(), ((UninstallEvent) event).packageName);
        } else {
            if (event instanceof AppEvent) {
                return TextUtils.equals(serviceApp.getPackageName(), ((AppEvent) event).packageName);
            }
        }
        return false;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0060: APUT  (r4v1 java.lang.String[]), (1 ??[boolean, int, float, short, byte, char]), (r6v4 java.lang.String) */
    public static boolean isEventBelongTo(Event event, AlbumItem albumItem) {
        UpgradeInfo upgradeInfo;
        if (event instanceof DownloadEvent) {
            DownloadEvent downloadEvent = (DownloadEvent) event;
            if (TextUtils.equals(albumItem.getDownloadUrlMd5(), downloadEvent.key)) {
                return true;
            }
            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(albumItem.getPackageName());
            if (mobileAppExistFast != null && (upgradeInfo = mobileAppExistFast.getUpgradeInfo()) != null && TextUtils.equals(upgradeInfo.getDownloadUrlMd5(1), downloadEvent.key)) {
                return true;
            }
        } else if (event instanceof InstallEvent) {
            MobileApp mobileAppExistFast2 = DataManager.getInstance().getMobileAppExistFast(albumItem.getPackageName());
            String str = null;
            UpgradeInfo upgradeInfo2 = mobileAppExistFast2 != null ? mobileAppExistFast2.getUpgradeInfo() : null;
            String[] strArr = new String[3];
            strArr[0] = albumItem.getDownloadUrlMd5();
            strArr[1] = upgradeInfo2 != null ? upgradeInfo2.getDownloadUrlMd5(0) : null;
            if (upgradeInfo2 != null) {
                str = upgradeInfo2.getDownloadUrlMd5(1);
            }
            strArr[2] = str;
            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(strArr);
            if (findLatestDownloadState == null || !TextUtils.equals(findLatestDownloadState.getFilePathMd5(), ((InstallEvent) event).key)) {
                return false;
            }
            return true;
        } else if (event instanceof UninstallEvent) {
            return TextUtils.equals(albumItem.getPackageName(), ((UninstallEvent) event).packageName);
        } else {
            if (event instanceof AppEvent) {
                return TextUtils.equals(albumItem.getPackageName(), ((AppEvent) event).packageName);
            }
        }
        return false;
    }

    public static boolean isEventBelongTo(Event event, MobileApp mobileApp) {
        if (event instanceof UninstallEvent) {
            return TextUtils.equals(mobileApp.getPackageName(), ((UninstallEvent) event).packageName);
        }
        if (event instanceof AppEvent) {
            return TextUtils.equals(mobileApp.getPackageName(), ((AppEvent) event).packageName);
        }
        return false;
    }

    public static boolean isEventBelongTo(Event event, UpgradeInfo upgradeInfo) {
        if (event instanceof DownloadEvent) {
            if (upgradeInfo != null) {
                DownloadEvent downloadEvent = (DownloadEvent) event;
                if (TextUtils.equals(upgradeInfo.getDownloadUrlMd5(0), downloadEvent.key) || TextUtils.equals(upgradeInfo.getDownloadUrlMd5(1), downloadEvent.key)) {
                    return true;
                }
            }
        } else if (event instanceof InstallEvent) {
            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(upgradeInfo.getDownloadUrlMd5(0), upgradeInfo.getDownloadUrlMd5(1));
            if (findLatestDownloadState != null) {
                return TextUtils.equals(((InstallEvent) event).key, findLatestDownloadState.getFilePathMd5());
            }
        } else if (event instanceof UninstallEvent) {
            return TextUtils.equals(upgradeInfo.getPackageName(), ((UninstallEvent) event).packageName);
        } else {
            if (event instanceof AppEvent) {
                return TextUtils.equals(upgradeInfo.getPackageName(), ((AppEvent) event).packageName);
            }
        }
        return false;
    }

    public static boolean isEventBelongTo(Event event, DownloadInfo downloadInfo) {
        Extra extra;
        if (event instanceof DownloadEvent) {
            return TextUtils.equals(downloadInfo.getUrlMd5(), ((DownloadEvent) event).key);
        }
        if (event instanceof InstallEvent) {
            DownloadState downloadState = DataManager.getInstance().getDownloadState(downloadInfo.getUrlMd5());
            if (downloadState != null) {
                return TextUtils.equals(downloadState.getFilePathMd5(), ((InstallEvent) event).key);
            }
            return false;
        } else if (!(event instanceof AppEvent) || (extra = downloadInfo.getExtra()) == null) {
            return false;
        } else {
            String string = extra.getString("PACKAGE_NAME");
            if (!TextUtils.isEmpty(string)) {
                return TextUtils.equals(((AppEvent) event).packageName, string);
            }
            return false;
        }
    }

    public static boolean isEventBelongTo(Event event, LocalApk localApk) {
        if (event instanceof InstallEvent) {
            return TextUtils.equals(((InstallEvent) event).key, localApk.getFilePathMd5());
        }
        return false;
    }

    public static boolean isEventBelongTo(Event event, VersionApp versionApp, String str) {
        if (event instanceof DownloadEvent) {
            if (TextUtils.equals(versionApp.getDownloadUrlMd5(str), ((DownloadEvent) event).key)) {
                return true;
            }
        } else if (event instanceof InstallEvent) {
            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(versionApp.getDownloadUrlMd5(str));
            if (findLatestDownloadState == null || !TextUtils.equals(findLatestDownloadState.getFilePathMd5(), ((InstallEvent) event).key)) {
                return false;
            }
            return true;
        } else if (event instanceof AppEvent) {
            return TextUtils.equals(versionApp.getPackageName(), ((AppEvent) event).packageName);
        }
        return false;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0080: APUT  (r5v1 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r8v4 java.lang.String) */
    public static boolean isEventBelongTo(Event event, Feed feed) {
        UpgradeInfo upgradeInfo;
        if (feed != null && "apk".equals(feed.getExtraType())) {
            String apkExtraPackageName = EntityExtendsKt.getApkExtraPackageName(feed);
            if (event instanceof DownloadEvent) {
                DownloadEvent downloadEvent = (DownloadEvent) event;
                if (TextUtils.equals(EntityExtendsKt.getDownloadUrlMd5(feed, 0), downloadEvent.key) || TextUtils.equals(EntityExtendsKt.getDownloadUrlMd5(feed, 2), downloadEvent.key)) {
                    return true;
                }
                MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(apkExtraPackageName);
                if (mobileAppExistFast != null && (upgradeInfo = mobileAppExistFast.getUpgradeInfo()) != null && TextUtils.equals(upgradeInfo.getDownloadUrlMd5(1), downloadEvent.key)) {
                    return true;
                }
            } else if (event instanceof InstallEvent) {
                MobileApp mobileAppExistFast2 = DataManager.getInstance().getMobileAppExistFast(apkExtraPackageName);
                String str = null;
                UpgradeInfo upgradeInfo2 = mobileAppExistFast2 != null ? mobileAppExistFast2.getUpgradeInfo() : null;
                String[] strArr = new String[4];
                strArr[0] = EntityExtendsKt.getDownloadUrlMd5(feed, 0);
                strArr[1] = EntityExtendsKt.getDownloadUrlMd5(feed, 2);
                strArr[2] = upgradeInfo2 != null ? upgradeInfo2.getDownloadUrlMd5(0) : null;
                if (upgradeInfo2 != null) {
                    str = upgradeInfo2.getDownloadUrlMd5(1);
                }
                strArr[3] = str;
                DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(strArr);
                if (findLatestDownloadState == null || !TextUtils.equals(findLatestDownloadState.getFilePathMd5(), ((InstallEvent) event).key)) {
                    return false;
                }
                return true;
            } else if (event instanceof UninstallEvent) {
                return TextUtils.equals(apkExtraPackageName, ((UninstallEvent) event).packageName);
            } else {
                if (event instanceof AppEvent) {
                    return TextUtils.equals(apkExtraPackageName, ((AppEvent) event).packageName);
                }
            }
        }
        return false;
    }
}
