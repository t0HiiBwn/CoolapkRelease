package com.bytedance.tea.crash.f;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.h;

/* compiled from: DeviceIdTask */
public class b extends a {
    b(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String e = h.a().e();
        if (TextUtils.isEmpty(e) || "0".equals(e)) {
            a(c());
            j.a("[DeviceIdTask] did is null, continue check.");
            return;
        }
        h.c().a(e);
        j.a("[DeviceIdTask] did is " + e);
    }
}
