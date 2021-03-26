package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

public interface SystemNotifier {
    void notifyObservers(int i);

    void notifyObservers(Intent intent, String str);

    void registerObserver(SystemObserver systemObserver);

    void unRegisterObserver(SystemObserver systemObserver);
}
