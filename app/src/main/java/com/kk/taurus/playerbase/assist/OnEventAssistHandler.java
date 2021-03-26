package com.kk.taurus.playerbase.assist;

import android.os.Bundle;

public interface OnEventAssistHandler<T> {
    void onAssistHandle(T t, int i, Bundle bundle);

    void requestPause(T t, Bundle bundle);

    void requestPlayDataSource(T t, Bundle bundle);

    void requestReplay(T t, Bundle bundle);

    void requestReset(T t, Bundle bundle);

    void requestResume(T t, Bundle bundle);

    void requestRetry(T t, Bundle bundle);

    void requestSeek(T t, Bundle bundle);

    void requestStop(T t, Bundle bundle);
}
