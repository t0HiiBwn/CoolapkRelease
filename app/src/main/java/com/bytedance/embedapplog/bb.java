package com.bytedance.embedapplog;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

final class bb {
    static Activity a(Context context) {
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        while (true) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper instanceof Activity) {
                return (Activity) contextWrapper;
            }
            context = contextWrapper.getBaseContext();
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
        }
    }
}
