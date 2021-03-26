package com.coolapk.market.local;

import com.coolapk.market.event.InstallEvent;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class InstallStore extends Store {
    public static final int ACTION_INSTALL_STATE_CHANGED = 1;
    public static final int ACTION_INSTALL_STATE_CLEAR_COMPLETE = 2;
    private static final int THRESHOLD = 300;
    private final Object stateLock = new Object();
    private final Map<String, InstallState> stateMapping = new HashMap();
    private final Timer timer = new Timer(true);
    private final Map<String, TimerTask> timerTaskMapping = new HashMap();

    @Override // com.coolapk.market.local.Store
    public void handleAction(int i, Object obj) {
        synchronized (this.stateLock) {
            if (i == 1) {
                doActionInstallStateChanged((InstallState) obj);
            } else if (i == 2) {
                doActionInstallStateClearComplete();
            }
        }
    }

    public void doActionInstallStateClearComplete() {
        LogUtils.v("Clear install state with complete", new Object[0]);
        Iterator<InstallState> it2 = this.stateMapping.values().iterator();
        while (it2.hasNext()) {
            if (it2.next().isComplete()) {
                it2.remove();
            }
        }
    }

    public void doActionInstallStateChanged(InstallState installState) {
        LogUtils.v("Install state: %s, [%s]", Integer.valueOf(installState.getState()), installState.getPath());
        this.stateMapping.put(installState.getKey(), installState);
        postChangeEvent(new InstallEvent(installState));
    }

    public InstallState getInstallState(String str) {
        return this.stateMapping.get(str);
    }

    public List<InstallState> getInstallStateList() {
        return new ArrayList(this.stateMapping.values());
    }
}
