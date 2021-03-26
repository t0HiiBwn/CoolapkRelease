package com.coolapk.market.event;

import com.coolapk.market.model.InstallState;

public class InstallEvent implements Event {
    public final InstallState installState;
    public final String key;
    public final String path;

    public InstallEvent(InstallState installState2) {
        this.key = installState2.getKey();
        this.path = installState2.getPath();
        this.installState = installState2;
    }
}
