package com.coolapk.market.local;

import com.coolapk.market.event.UninstallEvent;
import com.coolapk.market.model.UninstallState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UninstallStore extends Store {
    public static final int ACTION_UNINSTALL_STATE_CHANGE = 1;
    private final Object stateLock = new Object();
    private final Map<String, UninstallState> stateMapping = new HashMap();

    @Override // com.coolapk.market.local.Store
    public void handleAction(int i, Object obj) {
        synchronized (this.stateLock) {
            if (i == 1) {
                UninstallState uninstallState = (UninstallState) obj;
                this.stateMapping.put(uninstallState.getKey(), uninstallState);
                postChangeEvent(new UninstallEvent(uninstallState));
            }
        }
    }

    public UninstallState getUninstallState(String str) {
        return this.stateMapping.get(str);
    }

    public List<UninstallState> getUninstallStateList() {
        return new ArrayList(this.stateMapping.values());
    }
}
