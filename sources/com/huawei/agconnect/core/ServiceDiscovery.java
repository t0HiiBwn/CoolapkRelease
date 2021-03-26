package com.huawei.agconnect.core;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServiceDiscovery extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
