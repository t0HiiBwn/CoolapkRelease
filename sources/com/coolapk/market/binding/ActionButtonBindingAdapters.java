package com.coolapk.market.binding;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class ActionButtonBindingAdapters {
    public static void setActionButtonBackground(ActionButton actionButton, ServiceApp serviceApp, boolean z) {
        if (serviceApp != null) {
            actionButton.bindWithApp(serviceApp, z);
        }
    }

    public static void setActionButtonBackground(View view, String str, Long l, Long l2) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1383304148:
                    if (str.equals("border")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1039745817:
                    if (str.equals("normal")) {
                        c = 1;
                        break;
                    }
                    break;
                case -934352947:
                    if (str.equals("reveal")) {
                        c = 2;
                        break;
                    }
                    break;
                case -625596190:
                    if (str.equals("uninstall")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1427818632:
                    if (str.equals("download")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            Float f = null;
            switch (c) {
                case 0:
                    view.setBackground(ShapeUtils.createBorderBg(view.getContext()));
                    return;
                case 1:
                    view.setBackground(ShapeUtils.createNormalBg(view.getContext()));
                    return;
                case 2:
                    if ((view instanceof ActionButtonFrameLayout) && !((ActionButtonFrameLayout) view).isCapsule()) {
                        f = Float.valueOf((float) DisplayUtils.dp2px(view.getContext(), 6.0f));
                    }
                    if (f == null) {
                        int height = view.getHeight();
                        if (height == 0) {
                            height = view.getMinimumHeight();
                        }
                        if (height != 0) {
                            f = Float.valueOf(((float) height) / 2.0f);
                        }
                    }
                    view.setBackground(ShapeUtils.createRevealBg(view.getContext(), f));
                    return;
                case 3:
                    view.setBackground(ShapeUtils.createNormalBg(view.getContext()));
                    return;
                case 4:
                    if (view instanceof ActionButtonFrameLayout) {
                        boolean isCapsule = ((ActionButtonFrameLayout) view).isCapsule();
                        LogUtils.d("ActionButtonFrameLayout %s, %b", view.toString(), Boolean.valueOf(isCapsule));
                        if (!isCapsule) {
                            f = Float.valueOf((float) DisplayUtils.dp2px(view.getContext(), 6.0f));
                        }
                    }
                    if (f == null) {
                        int height2 = view.getHeight();
                        if (height2 == 0) {
                            height2 = view.getMinimumHeight();
                        }
                        if (height2 != 0) {
                            f = Float.valueOf(((float) height2) / 2.0f);
                        }
                    }
                    Drawable createDownloadBg = ShapeUtils.createDownloadBg(view.getContext(), f);
                    if (!(l == null || l2 == null || !(createDownloadBg instanceof RippleDrawable))) {
                        RippleDrawable rippleDrawable = (RippleDrawable) createDownloadBg;
                        if (rippleDrawable.getDrawable(0) instanceof LayerDrawable) {
                            ((LayerDrawable) rippleDrawable.getDrawable(0)).findDrawableByLayerId(16908301).setLevel(l2.longValue() != 0 ? (int) ((l.longValue() * 10000) / l2.longValue()) : 0);
                        }
                    }
                    view.setBackground(createDownloadBg);
                    return;
                default:
                    LogUtils.e("Unknown backgroundName: %s", str);
                    return;
            }
        }
    }

    public static void setActionButtonBackground(ActionButtonFrameLayout actionButtonFrameLayout, ServiceApp serviceApp, boolean z) {
        if (serviceApp != null) {
            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(getUrlMd5s(serviceApp));
            String actionButtonBackground = StateUtils.getActionButtonBackground(findLatestDownloadState);
            if (z && TextUtils.equals("normal", actionButtonBackground)) {
                actionButtonBackground = "border";
            }
            long j = 0;
            long currentLength = findLatestDownloadState != null ? findLatestDownloadState.getCurrentLength() : 0;
            if (findLatestDownloadState != null) {
                j = findLatestDownloadState.getTotalLength();
            }
            setActionButtonBackground(actionButtonFrameLayout, actionButtonBackground, Long.valueOf(currentLength), Long.valueOf(j));
        }
    }

    public static void setActionText(TextView textView, ServiceApp serviceApp) {
        if (serviceApp != null) {
            String[] urlMd5s = getUrlMd5s(serviceApp);
            textView.setText(StateUtils.getActionText(textView.getContext(), serviceApp.getPackageName(), serviceApp.getPackageName(), urlMd5s));
            textView.setTextColor(StateUtils.getActionButtonTextColor(StateUtils.findLatestDownloadState(urlMd5s)));
        }
    }

    public static void setActionText(TextView textView, ServiceApp serviceApp, boolean z) {
        if (serviceApp != null) {
            String[] urlMd5s = getUrlMd5s(serviceApp);
            textView.setText(StateUtils.getActionText(textView.getContext(), serviceApp.getPackageName(), serviceApp.getPackageName(), urlMd5s));
            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(urlMd5s);
            int actionButtonTextColor = StateUtils.getActionButtonTextColor(findLatestDownloadState);
            String actionButtonBackground = StateUtils.getActionButtonBackground(findLatestDownloadState);
            if (z && TextUtils.equals("normal", actionButtonBackground)) {
                actionButtonTextColor = AppHolder.getAppTheme().getColorAccent();
                actionButtonBackground = "border";
            }
            textView.setTextColor(actionButtonTextColor);
            long j = 0;
            long currentLength = findLatestDownloadState != null ? findLatestDownloadState.getCurrentLength() : 0;
            if (findLatestDownloadState != null) {
                j = findLatestDownloadState.getTotalLength();
            }
            setActionButtonBackground(textView, actionButtonBackground, Long.valueOf(currentLength), Long.valueOf(j));
        }
    }

    public static void setActionButtonBackground(ActionButtonFrameLayout actionButtonFrameLayout, AlbumItem albumItem, boolean z) {
        if (albumItem != null) {
            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(getUrlMd5s(albumItem));
            String actionButtonBackground = StateUtils.getActionButtonBackground(findLatestDownloadState);
            if (z && TextUtils.equals("normal", actionButtonBackground)) {
                actionButtonBackground = "border";
            }
            long j = 0;
            long currentLength = findLatestDownloadState != null ? findLatestDownloadState.getCurrentLength() : 0;
            if (findLatestDownloadState != null) {
                j = findLatestDownloadState.getTotalLength();
            }
            setActionButtonBackground(actionButtonFrameLayout, actionButtonBackground, Long.valueOf(currentLength), Long.valueOf(j));
        }
    }

    public static void setActionText(TextView textView, AlbumItem albumItem) {
        String str;
        if (albumItem != null) {
            String[] urlMd5s = getUrlMd5s(albumItem);
            if (TextUtils.equals(albumItem.getApkId(), "0")) {
                str = "查看";
            } else {
                str = StateUtils.getActionText(textView.getContext(), albumItem.getPackageName(), albumItem.getPackageName(), urlMd5s);
            }
            textView.setText(str);
            textView.setTextColor(StateUtils.getActionButtonTextColor(StateUtils.findLatestDownloadState(urlMd5s)));
        }
    }

    public static void setActionText(TextView textView, AlbumItem albumItem, boolean z) {
        if (albumItem != null) {
            String[] urlMd5s = getUrlMd5s(albumItem);
            textView.setText(StateUtils.getActionText(textView.getContext(), albumItem.getPackageName(), albumItem.getPackageName(), urlMd5s));
            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(urlMd5s);
            int actionButtonTextColor = StateUtils.getActionButtonTextColor(findLatestDownloadState);
            String actionButtonBackground = StateUtils.getActionButtonBackground(findLatestDownloadState);
            if (z && TextUtils.equals("normal", actionButtonBackground)) {
                actionButtonTextColor = AppHolder.getAppTheme().getColorAccent();
                actionButtonBackground = "border";
            }
            textView.setTextColor(actionButtonTextColor);
            long j = 0;
            long currentLength = findLatestDownloadState != null ? findLatestDownloadState.getCurrentLength() : 0;
            if (findLatestDownloadState != null) {
                j = findLatestDownloadState.getTotalLength();
            }
            setActionButtonBackground(textView, actionButtonBackground, Long.valueOf(currentLength), Long.valueOf(j));
        }
    }

    public static String[] getUrlMd5s(ServiceApp serviceApp) {
        UpgradeInfo upgradeInfo;
        String[] strArr = new String[4];
        strArr[0] = serviceApp.getDownloadUrlMd5(0);
        strArr[1] = serviceApp.getDownloadUrlMd5(2);
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
        if (!(mobileAppExistFast == null || (upgradeInfo = mobileAppExistFast.getUpgradeInfo()) == null)) {
            strArr[2] = upgradeInfo.getDownloadUrlMd5(0);
            strArr[3] = upgradeInfo.getDownloadUrlMd5(1);
        }
        return strArr;
    }

    private static String[] getUrlMd5s(AlbumItem albumItem) {
        UpgradeInfo upgradeInfo;
        String[] strArr = new String[3];
        strArr[0] = albumItem.getDownloadUrlMd5(0);
        strArr[1] = albumItem.getDownloadUrlMd5(2);
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(albumItem.getPackageName());
        if (!(mobileAppExistFast == null || (upgradeInfo = mobileAppExistFast.getUpgradeInfo()) == null)) {
            strArr[1] = upgradeInfo.getDownloadUrlMd5(0);
            strArr[2] = upgradeInfo.getDownloadUrlMd5(1);
        }
        return strArr;
    }

    public static void setActionButtonBackground(ActionButtonFrameLayout actionButtonFrameLayout, Feed feed, boolean z) {
        if (feed != null) {
            if ("apk".equals(feed.getExtraType())) {
                actionButtonFrameLayout.setVisibility(0);
                DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(getUrlMd5s(feed));
                String actionButtonBackground = StateUtils.getActionButtonBackground(findLatestDownloadState);
                if (z && TextUtils.equals("normal", actionButtonBackground)) {
                    actionButtonBackground = "border";
                }
                long j = 0;
                long currentLength = findLatestDownloadState != null ? findLatestDownloadState.getCurrentLength() : 0;
                if (findLatestDownloadState != null) {
                    j = findLatestDownloadState.getTotalLength();
                }
                setActionButtonBackground(actionButtonFrameLayout, actionButtonBackground, Long.valueOf(currentLength), Long.valueOf(j));
                return;
            }
            actionButtonFrameLayout.setVisibility(8);
        }
    }

    public static void setActionText(TextView textView, Feed feed) {
        if (feed != null && "apk".equals(feed.getExtraType())) {
            String[] urlMd5s = getUrlMd5s(feed);
            String apkExtraPackageName = EntityExtendsKt.getApkExtraPackageName(feed);
            textView.setText(StateUtils.getActionText(textView.getContext(), apkExtraPackageName, apkExtraPackageName, urlMd5s));
            textView.setTextColor(StateUtils.getActionButtonTextColor(StateUtils.findLatestDownloadState(urlMd5s)));
        }
    }

    private static String[] getUrlMd5s(Feed feed) {
        UpgradeInfo upgradeInfo;
        String[] strArr = new String[3];
        String apkExtraPackageName = EntityExtendsKt.getApkExtraPackageName(feed);
        strArr[0] = EntityExtendsKt.getDownloadUrlMd5(feed, 0);
        strArr[1] = EntityExtendsKt.getDownloadUrlMd5(feed, 2);
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(apkExtraPackageName);
        if (!(mobileAppExistFast == null || (upgradeInfo = mobileAppExistFast.getUpgradeInfo()) == null)) {
            strArr[1] = upgradeInfo.getDownloadUrlMd5(0);
            strArr[2] = upgradeInfo.getDownloadUrlMd5(1);
        }
        return strArr;
    }
}
