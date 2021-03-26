package com.tencent.imsdk.common;

import android.content.Context;

public interface IContextFetcher {
    Context getContext();

    boolean isInited();

    boolean isOnline();
}
