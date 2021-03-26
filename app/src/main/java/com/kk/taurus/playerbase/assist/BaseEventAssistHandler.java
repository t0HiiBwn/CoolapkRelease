package com.kk.taurus.playerbase.assist;

import android.os.Bundle;

public abstract class BaseEventAssistHandler<T> implements OnEventAssistHandler<T> {
    @Override // com.kk.taurus.playerbase.assist.OnEventAssistHandler
    public void onAssistHandle(T t, int i, Bundle bundle) {
        switch (i) {
            case -660011:
                requestRetry(t, bundle);
                return;
            case -66014:
                requestPlayDataSource(t, bundle);
                return;
            case -66013:
                requestReplay(t, bundle);
                return;
            case -66009:
                requestReset(t, bundle);
                return;
            case -66007:
                requestStop(t, bundle);
                return;
            case -66005:
                requestSeek(t, bundle);
                return;
            case -66003:
                requestResume(t, bundle);
                return;
            case -66001:
                requestPause(t, bundle);
                return;
            default:
                return;
        }
    }
}
