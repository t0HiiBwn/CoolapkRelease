package com.tencent.beacon.core;

import android.content.Context;
import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.strategy.a;
import java.util.Map;

/* compiled from: BeaconModule */
public class c {
    private boolean firstStrategyQueryFinishedCalled = true;
    protected Context mContext;

    public void onAppFirstRun() {
    }

    public void onFirstStrategyQueryFinished() {
    }

    public void onModuleStarted() {
    }

    public void onModuleStrategyUpdated(int i, Map<String, String> map) {
    }

    public void onSDKInit(Context context) {
    }

    public void onStrategyQueryStarted() {
    }

    public void onStrategyUpdated(a aVar) {
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void onStrategyQueryFinished() {
        if (this.firstStrategyQueryFinishedCalled) {
            onFirstStrategyQueryFinished();
            if (!i.a(this.mContext).a() || !f.a(this.mContext).a("sig_1") || !i.a(this.mContext).b()) {
                b.c("[strategy] get lock failed, on call module started", new Object[0]);
            } else {
                onModuleStarted();
            }
            this.firstStrategyQueryFinishedCalled = false;
        }
    }
}
