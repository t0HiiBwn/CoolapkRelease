package androidx.work;

import android.content.Context;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DelegatingWorkerFactory extends WorkerFactory {
    private static final String TAG = Logger.tagWithPrefix("DelegatingWkrFctry");
    private final List<WorkerFactory> mFactories = new CopyOnWriteArrayList();

    List<WorkerFactory> getFactories() {
        return this.mFactories;
    }

    public final void addFactory(WorkerFactory workerFactory) {
        this.mFactories.add(workerFactory);
    }

    @Override // androidx.work.WorkerFactory
    public final ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters) {
        for (WorkerFactory workerFactory : this.mFactories) {
            try {
                ListenableWorker createWorker = workerFactory.createWorker(context, str, workerParameters);
                if (createWorker != null) {
                    return createWorker;
                }
            } catch (Throwable th) {
                Logger.get().error(TAG, String.format("Unable to instantiate a ListenableWorker (%s)", str), th);
                throw th;
            }
        }
        return null;
    }
}
