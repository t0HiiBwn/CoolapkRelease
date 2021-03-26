package com.tencent.msdk.dns.base.b;

import android.app.Activity;
import android.app.ActivityThread;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ActivityLifecycleDetector */
public final class b {
    private static List<a> a = Collections.emptyList();
    private static boolean b = false;

    public static void a(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            b(context);
        } else {
            b();
        }
    }

    public static synchronized boolean a(a aVar) {
        boolean z;
        synchronized (b.class) {
            if (b) {
                if (a.isEmpty()) {
                    a = new ArrayList();
                }
                a.add(aVar);
            }
            z = b;
        }
        return z;
    }

    private static void b() {
        try {
            ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
            Field declaredField = ActivityThread.class.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            final Instrumentation instrumentation = (Instrumentation) declaredField.get(currentActivityThread);
            if (instrumentation != null) {
                b = true;
                declaredField.set(currentActivityThread, new Instrumentation() {
                    /* class com.tencent.msdk.dns.base.b.b.AnonymousClass1 */

                    @Override // android.app.Instrumentation
                    public void callActivityOnCreate(Activity activity, Bundle bundle) {
                        com.tencent.msdk.dns.base.log.b.b("%s.onCreate", activity);
                        for (a aVar : b.a) {
                            aVar.a(activity, bundle);
                        }
                        instrumentation.callActivityOnCreate(activity, bundle);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
                        com.tencent.msdk.dns.base.log.b.b("%s.onCreate", activity);
                        for (a aVar : b.a) {
                            aVar.a(activity, bundle);
                        }
                        instrumentation.callActivityOnCreate(activity, bundle, persistableBundle);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnStart(Activity activity) {
                        com.tencent.msdk.dns.base.log.b.b("%s.onStart", activity);
                        for (a aVar : b.a) {
                            aVar.a(activity);
                        }
                        instrumentation.callActivityOnStart(activity);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnResume(Activity activity) {
                        com.tencent.msdk.dns.base.log.b.b("%s.onResume", activity);
                        for (a aVar : b.a) {
                            aVar.b(activity);
                        }
                        instrumentation.callActivityOnResume(activity);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnPause(Activity activity) {
                        com.tencent.msdk.dns.base.log.b.b("%s.onPause", activity);
                        for (a aVar : b.a) {
                            aVar.c(activity);
                        }
                        instrumentation.callActivityOnPause(activity);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnStop(Activity activity) {
                        com.tencent.msdk.dns.base.log.b.b("%s.onStop", activity);
                        for (a aVar : b.a) {
                            aVar.d(activity);
                        }
                        instrumentation.callActivityOnStop(activity);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
                        com.tencent.msdk.dns.base.log.b.b("%s.onSaveInstanceState", activity);
                        for (a aVar : b.a) {
                            aVar.b(activity, bundle);
                        }
                        instrumentation.callActivityOnSaveInstanceState(activity, bundle);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
                        com.tencent.msdk.dns.base.log.b.b("%s.onSaveInstanceState", activity);
                        for (a aVar : b.a) {
                            aVar.b(activity, bundle);
                        }
                        instrumentation.callActivityOnSaveInstanceState(activity, bundle, persistableBundle);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnDestroy(Activity activity) {
                        com.tencent.msdk.dns.base.log.b.b("%s.onDestroy", activity);
                        for (a aVar : b.a) {
                            aVar.e(activity);
                        }
                        instrumentation.callActivityOnDestroy(activity);
                    }

                    @Override // android.app.Instrumentation
                    public void onCreate(Bundle bundle) {
                        instrumentation.onCreate(bundle);
                    }

                    @Override // android.app.Instrumentation
                    public void start() {
                        instrumentation.start();
                    }

                    @Override // android.app.Instrumentation
                    public void onStart() {
                        instrumentation.onStart();
                    }

                    @Override // android.app.Instrumentation
                    public boolean onException(Object obj, Throwable th) {
                        return instrumentation.onException(obj, th);
                    }

                    @Override // android.app.Instrumentation
                    public void sendStatus(int i, Bundle bundle) {
                        instrumentation.sendStatus(i, bundle);
                    }

                    @Override // android.app.Instrumentation
                    public void finish(int i, Bundle bundle) {
                        instrumentation.finish(i, bundle);
                    }

                    @Override // android.app.Instrumentation
                    public void setAutomaticPerformanceSnapshots() {
                        instrumentation.setAutomaticPerformanceSnapshots();
                    }

                    @Override // android.app.Instrumentation
                    public void startPerformanceSnapshot() {
                        instrumentation.startPerformanceSnapshot();
                    }

                    @Override // android.app.Instrumentation
                    public void endPerformanceSnapshot() {
                        instrumentation.endPerformanceSnapshot();
                    }

                    @Override // android.app.Instrumentation
                    public void onDestroy() {
                        instrumentation.onDestroy();
                    }

                    @Override // android.app.Instrumentation
                    public Context getContext() {
                        return instrumentation.getContext();
                    }

                    @Override // android.app.Instrumentation
                    public ComponentName getComponentName() {
                        return instrumentation.getComponentName();
                    }

                    @Override // android.app.Instrumentation
                    public Context getTargetContext() {
                        return instrumentation.getTargetContext();
                    }

                    @Override // android.app.Instrumentation
                    public boolean isProfiling() {
                        return instrumentation.isProfiling();
                    }

                    @Override // android.app.Instrumentation
                    public void startProfiling() {
                        instrumentation.startProfiling();
                    }

                    @Override // android.app.Instrumentation
                    public void stopProfiling() {
                        instrumentation.stopProfiling();
                    }

                    @Override // android.app.Instrumentation
                    public void setInTouchMode(boolean z) {
                        instrumentation.setInTouchMode(z);
                    }

                    @Override // android.app.Instrumentation
                    public void waitForIdle(Runnable runnable) {
                        instrumentation.waitForIdle(runnable);
                    }

                    @Override // android.app.Instrumentation
                    public void waitForIdleSync() {
                        instrumentation.waitForIdleSync();
                    }

                    @Override // android.app.Instrumentation
                    public void runOnMainSync(Runnable runnable) {
                        instrumentation.runOnMainSync(runnable);
                    }

                    @Override // android.app.Instrumentation
                    public Activity startActivitySync(Intent intent) {
                        return instrumentation.startActivitySync(intent);
                    }

                    @Override // android.app.Instrumentation
                    public void addMonitor(Instrumentation.ActivityMonitor activityMonitor) {
                        instrumentation.addMonitor(activityMonitor);
                    }

                    @Override // android.app.Instrumentation
                    public Instrumentation.ActivityMonitor addMonitor(IntentFilter intentFilter, Instrumentation.ActivityResult activityResult, boolean z) {
                        return instrumentation.addMonitor(intentFilter, activityResult, z);
                    }

                    @Override // android.app.Instrumentation
                    public Instrumentation.ActivityMonitor addMonitor(String str, Instrumentation.ActivityResult activityResult, boolean z) {
                        return instrumentation.addMonitor(str, activityResult, z);
                    }

                    @Override // android.app.Instrumentation
                    public boolean checkMonitorHit(Instrumentation.ActivityMonitor activityMonitor, int i) {
                        return instrumentation.checkMonitorHit(activityMonitor, i);
                    }

                    @Override // android.app.Instrumentation
                    public Activity waitForMonitor(Instrumentation.ActivityMonitor activityMonitor) {
                        return instrumentation.waitForMonitor(activityMonitor);
                    }

                    @Override // android.app.Instrumentation
                    public Activity waitForMonitorWithTimeout(Instrumentation.ActivityMonitor activityMonitor, long j) {
                        return instrumentation.waitForMonitorWithTimeout(activityMonitor, j);
                    }

                    @Override // android.app.Instrumentation
                    public void removeMonitor(Instrumentation.ActivityMonitor activityMonitor) {
                        instrumentation.removeMonitor(activityMonitor);
                    }

                    @Override // android.app.Instrumentation
                    public boolean invokeMenuActionSync(Activity activity, int i, int i2) {
                        return instrumentation.invokeMenuActionSync(activity, i, i2);
                    }

                    @Override // android.app.Instrumentation
                    public boolean invokeContextMenuAction(Activity activity, int i, int i2) {
                        return instrumentation.invokeContextMenuAction(activity, i, i2);
                    }

                    @Override // android.app.Instrumentation
                    public void sendStringSync(String str) {
                        instrumentation.sendStringSync(str);
                    }

                    @Override // android.app.Instrumentation
                    public void sendKeySync(KeyEvent keyEvent) {
                        instrumentation.sendKeySync(keyEvent);
                    }

                    @Override // android.app.Instrumentation
                    public void sendKeyDownUpSync(int i) {
                        instrumentation.sendKeyDownUpSync(i);
                    }

                    @Override // android.app.Instrumentation
                    public void sendCharacterSync(int i) {
                        instrumentation.sendCharacterSync(i);
                    }

                    @Override // android.app.Instrumentation
                    public void sendPointerSync(MotionEvent motionEvent) {
                        instrumentation.sendPointerSync(motionEvent);
                    }

                    @Override // android.app.Instrumentation
                    public void sendTrackballEventSync(MotionEvent motionEvent) {
                        instrumentation.sendTrackballEventSync(motionEvent);
                    }

                    @Override // android.app.Instrumentation
                    public Application newApplication(ClassLoader classLoader, String str, Context context) {
                        return instrumentation.newApplication(classLoader, str, context);
                    }

                    @Override // android.app.Instrumentation
                    public void callApplicationOnCreate(Application application) {
                        instrumentation.callApplicationOnCreate(application);
                    }

                    @Override // android.app.Instrumentation
                    public Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) {
                        return instrumentation.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
                    }

                    @Override // android.app.Instrumentation
                    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
                        return instrumentation.newActivity(classLoader, str, intent);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle) {
                        instrumentation.callActivityOnRestoreInstanceState(activity, bundle);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnPostCreate(Activity activity, Bundle bundle) {
                        instrumentation.callActivityOnPostCreate(activity, bundle);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnNewIntent(Activity activity, Intent intent) {
                        instrumentation.callActivityOnNewIntent(activity, intent);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnRestart(Activity activity) {
                        instrumentation.callActivityOnRestart(activity);
                    }

                    @Override // android.app.Instrumentation
                    public void callActivityOnUserLeaving(Activity activity) {
                        instrumentation.callActivityOnUserLeaving(activity);
                    }

                    @Override // android.app.Instrumentation
                    public void startAllocCounting() {
                        instrumentation.startAllocCounting();
                    }

                    @Override // android.app.Instrumentation
                    public void stopAllocCounting() {
                        instrumentation.stopAllocCounting();
                    }

                    @Override // android.app.Instrumentation
                    public Bundle getAllocCounts() {
                        return instrumentation.getAllocCounts();
                    }

                    @Override // android.app.Instrumentation
                    public Bundle getBinderCounts() {
                        return instrumentation.getBinderCounts();
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context) {
        Application a2 = c.a(context);
        if (a2 != null) {
            b = true;
            a2.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                /* class com.tencent.msdk.dns.base.b.b.AnonymousClass2 */

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    com.tencent.msdk.dns.base.log.b.b("%s.onCreate", activity);
                    for (a aVar : b.a) {
                        aVar.a(activity, bundle);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    com.tencent.msdk.dns.base.log.b.b("%s.onStart", activity);
                    for (a aVar : b.a) {
                        aVar.a(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    com.tencent.msdk.dns.base.log.b.b("%s.onResume", activity);
                    for (a aVar : b.a) {
                        aVar.b(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    com.tencent.msdk.dns.base.log.b.b("%s.onPause", activity);
                    for (a aVar : b.a) {
                        aVar.c(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    com.tencent.msdk.dns.base.log.b.b("%s.onStop", activity);
                    for (a aVar : b.a) {
                        aVar.d(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    com.tencent.msdk.dns.base.log.b.b("%s.onSaveInstanceState", activity);
                    for (a aVar : b.a) {
                        aVar.b(activity, bundle);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    com.tencent.msdk.dns.base.log.b.b("%s.onDestroy", activity);
                    for (a aVar : b.a) {
                        aVar.e(activity);
                    }
                }
            });
        }
    }
}
