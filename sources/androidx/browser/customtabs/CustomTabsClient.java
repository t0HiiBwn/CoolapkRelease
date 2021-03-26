package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.ArrayList;
import java.util.List;

public class CustomTabsClient {
    private final Context mApplicationContext;
    private final ICustomTabsService mService;
    private final ComponentName mServiceComponentName;

    CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.mService = iCustomTabsService;
        this.mServiceComponentName = componentName;
        this.mApplicationContext = context;
    }

    public static boolean bindCustomTabsService(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    public static String getPackageName(Context context, List<String> list) {
        return getPackageName(context, list, false);
    }

    public static String getPackageName(Context context, List<String> list, boolean z) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = list == null ? new ArrayList() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        return null;
    }

    public static boolean connectAndInitialize(Context context, String str) {
        if (str == null) {
            return false;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            return bindCustomTabsService(applicationContext, str, new CustomTabsServiceConnection() {
                /* class androidx.browser.customtabs.CustomTabsClient.AnonymousClass1 */

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }

                @Override // androidx.browser.customtabs.CustomTabsServiceConnection
                public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                    customTabsClient.warmup(0);
                    applicationContext.unbindService(this);
                }
            });
        } catch (SecurityException unused) {
            return false;
        }
    }

    public boolean warmup(long j) {
        try {
            return this.mService.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    private static PendingIntent createSessionId(Context context, int i) {
        return PendingIntent.getActivity(context, i, new Intent(), 0);
    }

    public CustomTabsSession newSession(CustomTabsCallback customTabsCallback) {
        return newSessionInternal(customTabsCallback, null);
    }

    public CustomTabsSession newSession(CustomTabsCallback customTabsCallback, int i) {
        return newSessionInternal(customTabsCallback, createSessionId(this.mApplicationContext, i));
    }

    public static CustomTabsSession.PendingSession newPendingSession(Context context, CustomTabsCallback customTabsCallback, int i) {
        return new CustomTabsSession.PendingSession(customTabsCallback, createSessionId(context, i));
    }

    private CustomTabsSession newSessionInternal(CustomTabsCallback customTabsCallback, PendingIntent pendingIntent) {
        boolean z;
        ICustomTabsCallback.Stub createCallbackWrapper = createCallbackWrapper(customTabsCallback);
        if (pendingIntent != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                z = this.mService.newSessionWithExtras(createCallbackWrapper, bundle);
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            z = this.mService.newSession(createCallbackWrapper);
        }
        if (!z) {
            return null;
        }
        return new CustomTabsSession(this.mService, createCallbackWrapper, this.mServiceComponentName, pendingIntent);
    }

    public Bundle extraCommand(String str, Bundle bundle) {
        try {
            return this.mService.extraCommand(str, bundle);
        } catch (RemoteException unused) {
            return null;
        }
    }

    private ICustomTabsCallback.Stub createCallbackWrapper(final CustomTabsCallback customTabsCallback) {
        return new ICustomTabsCallback.Stub() {
            /* class androidx.browser.customtabs.CustomTabsClient.AnonymousClass2 */
            private Handler mHandler = new Handler(Looper.getMainLooper());

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onNavigationEvent(final int i, final Bundle bundle) {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        /* class androidx.browser.customtabs.CustomTabsClient.AnonymousClass2.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            customTabsCallback.onNavigationEvent(i, bundle);
                        }
                    });
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void extraCallback(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        /* class androidx.browser.customtabs.CustomTabsClient.AnonymousClass2.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            customTabsCallback.extraCallback(str, bundle);
                        }
                    });
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
                CustomTabsCallback customTabsCallback = customTabsCallback;
                if (customTabsCallback == null) {
                    return null;
                }
                return customTabsCallback.extraCallbackWithResult(str, bundle);
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onMessageChannelReady(final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        /* class androidx.browser.customtabs.CustomTabsClient.AnonymousClass2.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public void run() {
                            customTabsCallback.onMessageChannelReady(bundle);
                        }
                    });
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onPostMessage(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        /* class androidx.browser.customtabs.CustomTabsClient.AnonymousClass2.AnonymousClass4 */

                        @Override // java.lang.Runnable
                        public void run() {
                            customTabsCallback.onPostMessage(str, bundle);
                        }
                    });
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onRelationshipValidationResult(final int i, final Uri uri, final boolean z, final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        /* class androidx.browser.customtabs.CustomTabsClient.AnonymousClass2.AnonymousClass5 */

                        @Override // java.lang.Runnable
                        public void run() {
                            customTabsCallback.onRelationshipValidationResult(i, uri, z, bundle);
                        }
                    });
                }
            }
        };
    }

    public CustomTabsSession attachSession(CustomTabsSession.PendingSession pendingSession) {
        return newSessionInternal(pendingSession.getCallback(), pendingSession.getId());
    }
}
