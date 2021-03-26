package com.huawei.agconnect.core;

import android.content.Context;
import java.util.List;

public interface ServiceRegistrar {
    List<Service> getServices(Context context);

    void initialize(Context context);
}
