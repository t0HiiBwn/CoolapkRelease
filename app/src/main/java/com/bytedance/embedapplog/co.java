package com.bytedance.embedapplog;

import android.content.Context;
import com.bun.miitmdid.core.JLibrary;

final class co {
    static void a(Context context) {
        if (JLibrary.context == null) {
            JLibrary.InitEntry(context);
        }
    }
}
