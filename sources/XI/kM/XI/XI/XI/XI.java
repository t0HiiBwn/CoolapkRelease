package XI.kM.XI.XI.XI;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class XI implements ServiceConnection {
    public static final ThreadPoolExecutor kM = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    public final LinkedBlockingQueue<IBinder> K0 = new LinkedBlockingQueue<>(1);

    /* renamed from: XI  reason: collision with root package name */
    public boolean f185XI = false;

    /* renamed from: XI.kM.XI.XI.XI.XI$XI  reason: collision with other inner class name */
    public class RunnableC0006XI implements Runnable {

        /* renamed from: XI  reason: collision with root package name */
        public final /* synthetic */ IBinder f186XI;

        public RunnableC0006XI(IBinder iBinder) {
            this.f186XI = iBinder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                System.currentTimeMillis();
                XI.this.K0.offer(this.f186XI);
            } catch (Throwable th) {
                th.getClass().getSimpleName();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        kM.execute(new RunnableC0006XI(iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        System.currentTimeMillis();
    }
}
