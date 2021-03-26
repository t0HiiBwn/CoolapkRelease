package com.kepler.jd.sdk.bean;

import com.kepler.sdk.q;

public class KelperTask {
    private boolean isCancel;
    private q netLinker;

    public boolean isCancel() {
        return this.isCancel;
    }

    public void setCancel(boolean z) {
        this.isCancel = z;
        q qVar = this.netLinker;
        if (qVar != null) {
            qVar.b();
        }
    }

    public void setNetLinker(q qVar) {
        this.netLinker = qVar;
    }
}
