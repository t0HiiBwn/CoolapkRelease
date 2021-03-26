package com.bytedance.tea.crash.g;

import java.util.HashSet;
import java.util.Set;

/* compiled from: Filters */
public final class e {
    private static final Set<String> a;

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        hashSet.add("HeapTaskDaemon");
        hashSet.add("ThreadPlus");
        hashSet.add("ApiDispatcher");
        hashSet.add("ApiLocalDispatcher");
        hashSet.add("AsyncLoader");
        hashSet.add("AsyncTask");
        hashSet.add("Binder");
        hashSet.add("PackageProcessor");
        hashSet.add("SettingsObserver");
        hashSet.add("WifiManager");
        hashSet.add("JavaBridge");
        hashSet.add("Compiler");
        hashSet.add("Signal Catcher");
        hashSet.add("GC");
        hashSet.add("ReferenceQueueDaemon");
        hashSet.add("FinalizerDaemon");
        hashSet.add("FinalizerWatchdogDaemon");
        hashSet.add("CookieSyncManager");
        hashSet.add("RefQueueWorker");
        hashSet.add("CleanupReference");
        hashSet.add("VideoManager");
        hashSet.add("DBHelper-AsyncOp");
        hashSet.add("InstalledAppTracker2");
        hashSet.add("AppData-AsyncOp");
        hashSet.add("IdleConnectionMonitor");
        hashSet.add("LogReaper");
        hashSet.add("ActionReaper");
        hashSet.add("Okio Watchdog");
        hashSet.add("CheckWaitingQueue");
        hashSet.add("NPTH-CrashTimer");
        hashSet.add("NPTH-JavaCallback");
        hashSet.add("NPTH-LocalParser");
        hashSet.add("ANR_FILE_MODIFY");
    }

    public static Set<String> a() {
        return a;
    }
}
