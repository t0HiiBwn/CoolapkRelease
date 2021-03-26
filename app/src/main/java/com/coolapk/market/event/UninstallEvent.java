package com.coolapk.market.event;

import com.coolapk.market.model.UninstallState;

public class UninstallEvent implements Event {
    public final String key;
    public final String packageName;
    public final UninstallState uninstallState;

    public UninstallEvent(UninstallState uninstallState2) {
        this.key = uninstallState2.getKey();
        this.packageName = uninstallState2.getPackageName();
        this.uninstallState = uninstallState2;
    }
}
