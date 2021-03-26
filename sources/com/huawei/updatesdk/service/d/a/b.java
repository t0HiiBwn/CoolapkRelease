package com.huawei.updatesdk.service.d.a;

import android.os.AsyncTask;
import com.huawei.updatesdk.a.b.d.a.a;
import com.huawei.updatesdk.service.a.c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class b {
    private static List<AsyncTask> a = new CopyOnWriteArrayList();

    public static com.huawei.updatesdk.a.b.d.b a(c cVar, a aVar) {
        com.huawei.updatesdk.a.b.d.b bVar = new com.huawei.updatesdk.a.b.d.b(cVar, aVar);
        a(bVar, cVar);
        return bVar;
    }

    public static List<AsyncTask> a() {
        return a;
    }

    public static void a(AsyncTask asyncTask) {
        if (asyncTask != null) {
            for (AsyncTask asyncTask2 : a) {
                if (asyncTask2 != null && (asyncTask2.getStatus() == AsyncTask.Status.FINISHED || asyncTask2.isCancelled())) {
                    a.remove(asyncTask);
                }
            }
            a.add(asyncTask);
        }
    }

    private static void a(com.huawei.updatesdk.a.b.d.b bVar, c cVar) {
        com.huawei.updatesdk.a.a.b.a.a.a.a("StoreAgent", "executeTask, ActiveCount:" + c.a.getActiveCount() + ", TaskCount:" + c.a.getTaskCount());
        bVar.a(c.a);
    }
}
