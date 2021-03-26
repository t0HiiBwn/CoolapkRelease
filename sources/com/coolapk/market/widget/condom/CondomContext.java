package com.coolapk.market.widget.condom;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.util.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CondomContext extends ContextWrapper {
    static final int FLAG_RECEIVER_EXCLUDE_BACKGROUND = 8388608;
    private final boolean DEBUG;
    private final String TAG;
    private final Context mApplicationContext;
    private final Context mBaseContext = new PseudoContextImpl(this);
    private boolean mDryRun;
    private boolean mExcludeBackgroundPackages = true;
    private boolean mExcludeStoppedPackages = true;
    private OutboundJudge mOutboundJudge;
    private final PackageManager mPackageManager;

    public interface OutboundJudge {
        boolean shouldAllow(OutboundType outboundType, String str);
    }

    public enum OutboundType {
        START_SERVICE,
        BIND_SERVICE,
        BROADCAST,
        QUERY_SERVICES,
        QUERY_RECEIVERS
    }

    private interface WrappedValueProcedure<R> {
        R proceed(Intent intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    public static CondomContext wrap(Context context, String str) {
        CondomContext condomContext;
        if (context instanceof CondomContext) {
            return (CondomContext) context;
        }
        Context applicationContext = context.getApplicationContext();
        boolean z = (context.getApplicationInfo().flags & 2) != 0;
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            CondomApplication condomApplication = new CondomApplication(application, str, z);
            CondomContext condomContext2 = new CondomContext(context, condomApplication, str, z);
            if (context == applicationContext) {
                condomContext = condomContext2;
            } else {
                condomContext = new CondomContext(application, application, str, z);
            }
            condomApplication.attachBaseContext(condomContext);
            return condomContext2;
        }
        return new CondomContext(context, context == applicationContext ? null : new CondomContext(applicationContext, applicationContext, str, z), str, z);
    }

    public CondomContext setOutboundJudge(OutboundJudge outboundJudge) {
        this.mOutboundJudge = outboundJudge;
        return this;
    }

    public CondomContext setDryRun(boolean z) {
        if (z == this.mDryRun) {
            return this;
        }
        this.mDryRun = z;
        if (z) {
            Log.w(this.TAG, "Start dry-run mode, no outbound requests will be blocked actually, despite stated in log.");
        } else {
            Log.w(this.TAG, "Stop dry-run mode.");
        }
        return this;
    }

    public CondomContext preventWakingUpStoppedPackages(boolean z) {
        this.mExcludeStoppedPackages = z;
        return this;
    }

    public CondomContext preventBroadcastToBackgroundPackages(boolean z) {
        this.mExcludeBackgroundPackages = z;
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, final ServiceConnection serviceConnection, final int i) {
        return ((Boolean) proceed(OutboundType.BIND_SERVICE, intent, Boolean.FALSE, new WrappedValueProcedure<Boolean>() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass1 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedValueProcedure
            public Boolean proceed(Intent intent) {
                return Boolean.valueOf(CondomContext.super.bindService(intent, serviceConnection, i));
            }
        })).booleanValue();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return (ComponentName) proceed(OutboundType.START_SERVICE, intent, null, new WrappedValueProcedure<ComponentName>() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass2 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedValueProcedure
            public ComponentName proceed(Intent intent) {
                return CondomContext.super.startService(intent);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass3 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendBroadcast(intent);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, final String str) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass4 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendBroadcast(intent, str);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcastAsUser(Intent intent, final UserHandle userHandle) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass5 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendBroadcastAsUser(intent, userHandle);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcastAsUser(Intent intent, final UserHandle userHandle, final String str) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass6 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendBroadcastAsUser(intent, userHandle, str);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, final String str) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass7 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendOrderedBroadcast(intent, str);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, final String str, final BroadcastReceiver broadcastReceiver, final Handler handler, final int i, final String str2, final Bundle bundle) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass8 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i, str2, bundle);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcastAsUser(Intent intent, final UserHandle userHandle, final String str, final BroadcastReceiver broadcastReceiver, final Handler handler, final int i, final String str2, final Bundle bundle) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass9 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendOrderedBroadcastAsUser(intent, userHandle, str, broadcastReceiver, handler, i, str2, bundle);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass10 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendStickyBroadcast(intent);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcastAsUser(Intent intent, final UserHandle userHandle) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass11 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendStickyBroadcastAsUser(intent, userHandle);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, final BroadcastReceiver broadcastReceiver, final Handler handler, final int i, final String str, final Bundle bundle) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass12 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i, str, bundle);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcastAsUser(Intent intent, final UserHandle userHandle, final BroadcastReceiver broadcastReceiver, final Handler handler, final int i, final String str, final Bundle bundle) {
        proceed(OutboundType.BROADCAST, intent, new WrappedProcedure() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass13 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedProcedure
            public void run(Intent intent) {
                CondomContext.super.sendStickyOrderedBroadcastAsUser(intent, userHandle, broadcastReceiver, handler, i, str, bundle);
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return super.getContentResolver();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.mPackageManager;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        if (this.DEBUG) {
            Log.d(this.TAG, "getBaseContext() is invoked", new Throwable());
        }
        return this.mBaseContext;
    }

    private static abstract class WrappedProcedure implements WrappedValueProcedure<Void> {
        abstract void run(Intent intent);

        private WrappedProcedure() {
        }

        @Override // com.coolapk.market.widget.condom.CondomContext.WrappedValueProcedure
        public Void proceed(Intent intent) {
            run(intent);
            return null;
        }
    }

    private void proceed(OutboundType outboundType, Intent intent, WrappedProcedure wrappedProcedure) {
        proceed(outboundType, intent, null, wrappedProcedure);
    }

    /* access modifiers changed from: private */
    public <T> T proceed(OutboundType outboundType, Intent intent, T t, WrappedValueProcedure<T> wrappedValueProcedure) {
        ComponentName component = intent.getComponent();
        String packageName = component != null ? component.getPackageName() : intent.getPackage();
        if (getPackageName().equals(packageName)) {
            return wrappedValueProcedure.proceed(intent);
        }
        int adjustIntentFlags = adjustIntentFlags(intent);
        if (shouldBlockRequestTarget(outboundType, packageName)) {
            if (this.DEBUG) {
                String str = this.TAG;
                Log.w(str, "Blocked outbound " + outboundType + ": " + intent);
            }
            return t;
        }
        try {
            return wrappedValueProcedure.proceed(intent);
        } finally {
            intent.setFlags(adjustIntentFlags);
        }
    }

    /* access modifiers changed from: private */
    public List<ResolveInfo> proceedQuery(final OutboundType outboundType, Intent intent, final WrappedValueProcedure<List<ResolveInfo>> wrappedValueProcedure) {
        return (List) proceed(outboundType, intent, Collections.emptyList(), new WrappedValueProcedure<List<ResolveInfo>>() {
            /* class com.coolapk.market.widget.condom.CondomContext.AnonymousClass14 */

            @Override // com.coolapk.market.widget.condom.CondomContext.WrappedValueProcedure
            public List<ResolveInfo> proceed(Intent intent) {
                List<ResolveInfo> list = (List) wrappedValueProcedure.proceed(intent);
                Iterator<ResolveInfo> it2 = list.iterator();
                while (it2.hasNext()) {
                    ResolveInfo next = it2.next();
                    String str = outboundType == OutboundType.QUERY_SERVICES ? next.serviceInfo.packageName : outboundType == OutboundType.QUERY_RECEIVERS ? next.activityInfo.packageName : null;
                    if (CondomContext.this.shouldBlockRequestTarget(outboundType, str)) {
                        it2.remove();
                        String str2 = CondomContext.this.TAG;
                        Log.w(str2, "Filtered " + str + " from " + outboundType + ": " + intent);
                    }
                }
                return list;
            }
        });
    }

    private int adjustIntentFlags(Intent intent) {
        int flags = intent.getFlags();
        if (this.mDryRun) {
            return flags;
        }
        if (this.mExcludeBackgroundPackages) {
            intent.addFlags(Build.VERSION.SDK_INT >= 24 ? 8388608 : 1073741824);
        }
        if (Build.VERSION.SDK_INT >= 12 && this.mExcludeStoppedPackages) {
            intent.setFlags((intent.getFlags() & -33) | 16);
        }
        return flags;
    }

    /* access modifiers changed from: private */
    public boolean shouldBlockRequestTarget(OutboundType outboundType, String str) {
        OutboundJudge outboundJudge;
        return str != null && (outboundJudge = this.mOutboundJudge) != null && !outboundJudge.shouldAllow(outboundType, str) && !this.mDryRun;
    }

    private CondomContext(Context context, Context context2, String str, boolean z) {
        super(context);
        String str2;
        this.mApplicationContext = context2 == null ? this : context2;
        this.mPackageManager = new CondomPackageManager(context.getPackageManager());
        if (str == null) {
            str2 = "Condom";
        } else {
            str2 = "Condom." + str;
        }
        this.TAG = str2;
        this.DEBUG = z;
    }

    private class CondomPackageManager extends PackageManagerWrapper {
        @Override // com.coolapk.market.widget.condom.PackageManagerWrapper, android.content.pm.PackageManager
        public List<ResolveInfo> queryBroadcastReceivers(Intent intent, final int i) {
            return CondomContext.this.proceedQuery(OutboundType.QUERY_RECEIVERS, intent, new WrappedValueProcedure<List<ResolveInfo>>() {
                /* class com.coolapk.market.widget.condom.CondomContext.CondomPackageManager.AnonymousClass1 */

                @Override // com.coolapk.market.widget.condom.CondomContext.WrappedValueProcedure
                public List<ResolveInfo> proceed(Intent intent) {
                    return CondomPackageManager.super.queryBroadcastReceivers(intent, i);
                }
            });
        }

        @Override // com.coolapk.market.widget.condom.PackageManagerWrapper, android.content.pm.PackageManager
        public List<ResolveInfo> queryIntentServices(Intent intent, final int i) {
            return CondomContext.this.proceedQuery(OutboundType.QUERY_SERVICES, intent, new WrappedValueProcedure<List<ResolveInfo>>() {
                /* class com.coolapk.market.widget.condom.CondomContext.CondomPackageManager.AnonymousClass2 */

                @Override // com.coolapk.market.widget.condom.CondomContext.WrappedValueProcedure
                public List<ResolveInfo> proceed(Intent intent) {
                    return CondomPackageManager.super.queryIntentServices(intent, i);
                }
            });
        }

        @Override // com.coolapk.market.widget.condom.PackageManagerWrapper, android.content.pm.PackageManager
        public ResolveInfo resolveService(Intent intent, final int i) {
            return (ResolveInfo) CondomContext.this.proceed(OutboundType.QUERY_SERVICES, intent, null, new WrappedValueProcedure<ResolveInfo>() {
                /* class com.coolapk.market.widget.condom.CondomContext.CondomPackageManager.AnonymousClass3 */

                @Override // com.coolapk.market.widget.condom.CondomContext.WrappedValueProcedure
                public ResolveInfo proceed(Intent intent) {
                    return CondomPackageManager.super.resolveService(intent, i);
                }
            });
        }

        CondomPackageManager(PackageManager packageManager) {
            super(packageManager);
        }
    }

    private static class CondomApplication extends Application {
        private final boolean DEBUG;
        private final String TAG;
        private final Application mApplication;

        @Override // android.app.Application, android.content.Context
        public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
            if (Build.VERSION.SDK_INT >= 14) {
                this.mApplication.registerComponentCallbacks(componentCallbacks);
            }
        }

        @Override // android.app.Application, android.content.Context
        public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
            if (Build.VERSION.SDK_INT >= 14) {
                this.mApplication.unregisterComponentCallbacks(componentCallbacks);
            }
        }

        @Override // android.app.Application
        public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            if (Build.VERSION.SDK_INT >= 14) {
                this.mApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }

        @Override // android.app.Application
        public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            if (Build.VERSION.SDK_INT >= 14) {
                this.mApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }

        @Override // android.app.Application
        public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.mApplication.registerOnProvideAssistDataListener(onProvideAssistDataListener);
            }
        }

        @Override // android.app.Application
        public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.mApplication.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
            }
        }

        @Override // android.content.ContextWrapper
        public Context getBaseContext() {
            if (this.DEBUG) {
                Log.w(this.TAG, "Application.getBaseContext() is invoked", new Throwable());
            }
            return super.getBaseContext();
        }

        @Override // android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(context);
        }

        CondomApplication(Application application, String str, boolean z) {
            String str2;
            this.mApplication = application;
            if (str == null) {
                str2 = "CondomApp";
            } else {
                str2 = "CondomApp." + str;
            }
            this.TAG = str2;
            this.DEBUG = z;
        }
    }

    private static class PseudoContextImpl extends PseudoContextWrapper {
        public PseudoContextImpl(CondomContext condomContext) {
            super(condomContext);
        }
    }
}
