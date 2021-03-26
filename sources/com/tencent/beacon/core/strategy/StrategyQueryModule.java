package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.c.g;
import com.tencent.beacon.core.c.h;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.event.o;
import com.tencent.beacon.upload.InitHandleListener;
import java.util.Map;

public class StrategyQueryModule extends c {
    public static final int CheckApp = 1;
    public static final int EndQuery = 3;
    public static final String LAST_SUCCESS_STRATEGY_QUERY_TIME = "last_success_strategy_query_time";
    public static final int Launch = 0;
    public static final int StartQuery = 2;
    public static final String TODAY_SUCCESS_STRATEGY_QUERY_TIMES = "today_success_strategy_query_times";
    public static final int WaitNextQuery = 4;
    private static StrategyQueryModule mInstance;
    private boolean atLeastAComQueryEnd = false;
    private boolean atLeastAComQuerySuccess = false;
    private int commonQueryTime = 0;
    protected int currentQueryStep = 0;
    private Runnable getInitConfigTask = new Runnable() {
        /* class com.tencent.beacon.core.strategy.StrategyQueryModule.AnonymousClass1 */

        @Override // java.lang.Runnable
        public final void run() {
            if (StrategyQueryModule.this.mContext != null && StrategyQueryModule.this.strategy != null) {
                StrategyQueryModule.this.strategy.a(StrategyQueryModule.this.mContext);
            }
        }
    };
    protected boolean isAppFirstRun = false;
    private InitHandleListener mInitHandleListener;
    private Object queryStateLock = new Object();
    protected a strategy = null;
    private g strategyHandler = null;
    private c strategyQueryRunner = null;
    protected h uploadHandler = null;

    public static synchronized StrategyQueryModule getInstance(Context context) {
        StrategyQueryModule strategyQueryModule;
        synchronized (StrategyQueryModule.class) {
            if (mInstance == null && context != null) {
                mInstance = new StrategyQueryModule(context);
            }
            strategyQueryModule = mInstance;
        }
        return strategyQueryModule;
    }

    public static synchronized StrategyQueryModule getInstance() {
        StrategyQueryModule strategyQueryModule;
        synchronized (StrategyQueryModule.class) {
            strategyQueryModule = mInstance;
        }
        return strategyQueryModule;
    }

    @Override // com.tencent.beacon.core.c
    public void onSDKInit(Context context) {
        super.onSDKInit(context);
        b.b("[module] strategy module > TRUE", new Object[0]);
        startQuery();
    }

    @Override // com.tencent.beacon.core.c
    public void onStrategyUpdated(a aVar) {
        super.onStrategyUpdated(aVar);
        this.strategy.j();
    }

    public boolean isAtLeastAComQuerySuccess() {
        boolean z;
        synchronized (this.queryStateLock) {
            z = this.atLeastAComQuerySuccess;
        }
        return z;
    }

    public void setAtLeastAComQuerySuccess(boolean z) {
        synchronized (this.queryStateLock) {
            this.atLeastAComQuerySuccess = z;
        }
    }

    public static synchronized h getMyUpload() {
        synchronized (StrategyQueryModule.class) {
            StrategyQueryModule strategyQueryModule = mInstance;
            if (strategyQueryModule == null) {
                return null;
            }
            return strategyQueryModule.getStrategyUploadHandler();
        }
    }

    private StrategyQueryModule(Context context) {
        super(context);
        this.uploadHandler = i.a(context);
        this.strategy = a.a();
        com.tencent.beacon.core.a.b.a().a(this.getInitConfigTask);
        this.strategyHandler = new d(context);
        this.uploadHandler.a(getStrategyHandler());
        this.strategyQueryRunner = new c(context);
    }

    public synchronized void startQuery() {
        if (!this.strategyQueryRunner.a) {
            com.tencent.beacon.core.a.b.a().a(this.strategyQueryRunner);
        }
    }

    public synchronized void setCommonStrategy(a aVar) {
        this.strategy = aVar;
    }

    public synchronized a getStrategy() {
        return this.strategy;
    }

    private synchronized h getStrategyUploadHandler() {
        return this.uploadHandler;
    }

    public synchronized g getStrategyHandler() {
        return this.strategyHandler;
    }

    public synchronized boolean isAppFirstRun() {
        return this.isAppFirstRun;
    }

    public synchronized void setAppFirstRun(boolean z) {
        this.isAppFirstRun = z;
        b.f("[strategy] set isFirst: %b", Boolean.valueOf(z));
    }

    public int getCurrentQueryStep() {
        int i;
        synchronized (this.queryStateLock) {
            i = this.currentQueryStep;
        }
        return i;
    }

    public void setCurrentQueryStep(int i) {
        synchronized (this.queryStateLock) {
            this.currentQueryStep = i;
            b.f("[strategy] current query step:%d", Integer.valueOf(i));
            if (i == 3) {
                setAtLeastAComQueryEnd(true);
            }
        }
    }

    public void notifyStrategyChanged(a aVar) {
        for (c cVar : o.b) {
            try {
                cVar.onStrategyUpdated(aVar);
            } catch (Throwable th) {
                b.a(th);
                b.d("[strategy] error %s", th.toString());
            }
        }
    }

    public void notifyModuleDetailChanged(int i, Map<String, String> map) {
        for (c cVar : o.b) {
            cVar.onModuleStrategyUpdated(i, map);
        }
    }

    public boolean isAtLeastAComQueryEnd() {
        boolean z;
        synchronized (this.queryStateLock) {
            z = this.atLeastAComQueryEnd;
        }
        return z;
    }

    public void setAtLeastAComQueryEnd(boolean z) {
        synchronized (this.queryStateLock) {
            this.atLeastAComQueryEnd = z;
        }
    }

    public int getCommonQueryTime() {
        int i;
        synchronized (this.queryStateLock) {
            i = this.commonQueryTime;
        }
        return i;
    }

    public void setCommonQueryTime(int i) {
        synchronized (this.queryStateLock) {
            this.commonQueryTime = i;
        }
    }

    public void setInitHandleListener(InitHandleListener initHandleListener) {
        this.mInitHandleListener = initHandleListener;
    }

    @Override // com.tencent.beacon.core.c
    public void onFirstStrategyQueryFinished() {
        super.onFirstStrategyQueryFinished();
        InitHandleListener initHandleListener = this.mInitHandleListener;
        if (initHandleListener != null) {
            initHandleListener.onInitEnd();
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onStrategyQueryFinished() {
        super.onStrategyQueryFinished();
        InitHandleListener initHandleListener = this.mInitHandleListener;
        if (initHandleListener != null) {
            initHandleListener.onStrategyQuerySuccess();
        }
    }
}
