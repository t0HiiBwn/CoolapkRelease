package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SystemManager {
    private static SystemManager a = new SystemManager();
    private static final Object b = new Object();
    private static SystemNotifier c = new SystemNotifier() {
        /* class com.huawei.hms.adapter.sysobs.SystemManager.AnonymousClass1 */
        private final List<SystemObserver> a = new ArrayList();

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver != null && !this.a.contains(systemObserver)) {
                synchronized (SystemManager.b) {
                    this.a.add(systemObserver);
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.b) {
                this.a.remove(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    if (it2.next().onSolutionResult(intent, str)) {
                        it2.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    if (it2.next().onUpdateResult(i)) {
                        it2.remove();
                    }
                }
            }
        }
    };

    private SystemManager() {
    }

    public static SystemManager getInstance() {
        return a;
    }

    public static SystemNotifier getSystemNotifier() {
        return c;
    }

    public void notifyResolutionResult(Intent intent, String str) {
        c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i) {
        c.notifyObservers(i);
    }
}
