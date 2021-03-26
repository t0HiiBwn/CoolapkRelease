package androidx.browser.trusted;

import android.app.Notification;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityService;

public final class TrustedWebActivityServiceConnection {
    private static final String KEY_ACTIVE_NOTIFICATIONS = "android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS";
    private static final String KEY_CHANNEL_NAME = "android.support.customtabs.trusted.CHANNEL_NAME";
    private static final String KEY_NOTIFICATION = "android.support.customtabs.trusted.NOTIFICATION";
    private static final String KEY_NOTIFICATION_SUCCESS = "android.support.customtabs.trusted.NOTIFICATION_SUCCESS";
    private static final String KEY_PLATFORM_ID = "android.support.customtabs.trusted.PLATFORM_ID";
    private static final String KEY_PLATFORM_TAG = "android.support.customtabs.trusted.PLATFORM_TAG";
    private final ComponentName mComponentName;
    private final ITrustedWebActivityService mService;

    TrustedWebActivityServiceConnection(ITrustedWebActivityService iTrustedWebActivityService, ComponentName componentName) {
        this.mService = iTrustedWebActivityService;
        this.mComponentName = componentName;
    }

    public boolean areNotificationsEnabled(String str) throws RemoteException {
        return ResultArgs.fromBundle(this.mService.areNotificationsEnabled(new NotificationsEnabledArgs(str).toBundle())).success;
    }

    public boolean notify(String str, int i, Notification notification, String str2) throws RemoteException {
        return ResultArgs.fromBundle(this.mService.notifyNotificationWithChannel(new NotifyNotificationArgs(str, i, notification, str2).toBundle())).success;
    }

    public void cancel(String str, int i) throws RemoteException {
        this.mService.cancelNotification(new CancelNotificationArgs(str, i).toBundle());
    }

    public Parcelable[] getActiveNotifications() throws RemoteException {
        return ActiveNotificationsArgs.fromBundle(this.mService.getActiveNotifications()).notifications;
    }

    public int getSmallIconId() throws RemoteException {
        return this.mService.getSmallIconId();
    }

    public Bitmap getSmallIconBitmap() throws RemoteException {
        return (Bitmap) this.mService.getSmallIconBitmap().getParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP");
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    static class NotifyNotificationArgs {
        public final String channelName;
        public final Notification notification;
        public final int platformId;
        public final String platformTag;

        NotifyNotificationArgs(String str, int i, Notification notification2, String str2) {
            this.platformTag = str;
            this.platformId = i;
            this.notification = notification2;
            this.channelName = str2;
        }

        public static NotifyNotificationArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotifyNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("android.support.customtabs.trusted.PLATFORM_TAG", this.platformTag);
            bundle.putInt("android.support.customtabs.trusted.PLATFORM_ID", this.platformId);
            bundle.putParcelable("android.support.customtabs.trusted.NOTIFICATION", this.notification);
            bundle.putString("android.support.customtabs.trusted.CHANNEL_NAME", this.channelName);
            return bundle;
        }
    }

    static class CancelNotificationArgs {
        public final int platformId;
        public final String platformTag;

        CancelNotificationArgs(String str, int i) {
            this.platformTag = str;
            this.platformId = i;
        }

        public static CancelNotificationArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new CancelNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("android.support.customtabs.trusted.PLATFORM_TAG", this.platformTag);
            bundle.putInt("android.support.customtabs.trusted.PLATFORM_ID", this.platformId);
            return bundle;
        }
    }

    static class ResultArgs {
        public final boolean success;

        ResultArgs(boolean z) {
            this.success = z;
        }

        public static ResultArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.NOTIFICATION_SUCCESS");
            return new ResultArgs(bundle.getBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS"));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.success);
            return bundle;
        }
    }

    static class ActiveNotificationsArgs {
        public final Parcelable[] notifications;

        ActiveNotificationsArgs(Parcelable[] parcelableArr) {
            this.notifications = parcelableArr;
        }

        public static ActiveNotificationsArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS");
            return new ActiveNotificationsArgs(bundle.getParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS"));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.notifications);
            return bundle;
        }
    }

    static class NotificationsEnabledArgs {
        public final String channelName;

        NotificationsEnabledArgs(String str) {
            this.channelName = str;
        }

        public static NotificationsEnabledArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotificationsEnabledArgs(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("android.support.customtabs.trusted.CHANNEL_NAME", this.channelName);
            return bundle;
        }
    }

    static void ensureBundleContains(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("Bundle must contain " + str);
        }
    }
}
