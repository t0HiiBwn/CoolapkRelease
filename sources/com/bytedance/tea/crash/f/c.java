package com.bytedance.tea.crash.f;

import android.content.Context;
import android.os.Handler;
import com.bytedance.tea.crash.g.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ScheduleTaskManager */
public final class c {
    private List<a> a;

    private c(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.a = arrayList;
        arrayList.add(new b(handler, 0, 15000));
    }

    public static c a(Handler handler, Context context) {
        return new c(handler, context);
    }

    public void a() {
        j.a("[ScheduleTaskManager] execute, task size=" + this.a.size());
        for (a aVar : this.a) {
            try {
                aVar.a();
            } catch (Throwable unused) {
            }
        }
    }
}
