package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

public interface SystemObserver {
    boolean onSolutionResult(Intent intent, String str);

    boolean onUpdateResult(int i);
}
