package com.coolapk.market.view.danmaku.easy.danmaku;

import com.coolapk.market.view.danmaku.easy.danmaku.DanmakuView;
import com.coolapk.market.view.danmaku.easy.utils.EasyL;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CachedDanmakuViewPool implements Pool<DanmakuView> {
    private static final String TAG = "CachedDanmakuViewPool";
    private LinkedList<DanmakuViewWithExpireTime> mCache = new LinkedList<>();
    private ScheduledExecutorService mChecker = Executors.newSingleThreadScheduledExecutor();
    private ViewCreator<DanmakuView> mCreator;
    private int mInUseSize;
    private long mKeepAliveTime;
    private int mMaxSize;

    public interface ViewCreator<T> {
        T create();
    }

    CachedDanmakuViewPool(long j, int i, ViewCreator<DanmakuView> viewCreator) {
        this.mKeepAliveTime = j;
        this.mMaxSize = i;
        this.mCreator = viewCreator;
        this.mInUseSize = 0;
        scheduleCheckUnusedViews();
    }

    private void scheduleCheckUnusedViews() {
        this.mChecker.scheduleWithFixedDelay(new Runnable() {
            /* class com.coolapk.market.view.danmaku.easy.danmaku.$$Lambda$CachedDanmakuViewPool$0AhM_NacGu31fHFFUIRTEDASDwQ */

            @Override // java.lang.Runnable
            public final void run() {
                CachedDanmakuViewPool.this.lambda$scheduleCheckUnusedViews$0$CachedDanmakuViewPool();
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }

    public /* synthetic */ void lambda$scheduleCheckUnusedViews$0$CachedDanmakuViewPool() {
        EasyL.v("CachedDanmakuViewPool", "scheduleCheckUnusedViews: mInUseSize=" + this.mInUseSize + ", mCacheSize=" + this.mCache.size());
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.mCache.isEmpty()) {
            DanmakuViewWithExpireTime first = this.mCache.getFirst();
            if (currentTimeMillis > first.expireTime) {
                this.mCache.remove(first);
            } else {
                return;
            }
        }
    }

    @Override // com.coolapk.market.view.danmaku.easy.danmaku.Pool
    public DanmakuView get() {
        DanmakuView danmakuView;
        if (!this.mCache.isEmpty()) {
            danmakuView = this.mCache.poll().danmakuView;
        } else if (this.mInUseSize >= this.mMaxSize) {
            return null;
        } else {
            danmakuView = this.mCreator.create();
        }
        danmakuView.addOnExitListener(new DanmakuView.OnExitListener() {
            /* class com.coolapk.market.view.danmaku.easy.danmaku.$$Lambda$CachedDanmakuViewPool$xhD5Nb_OhVn1RWBkXHXdhEyS9_E */

            @Override // com.coolapk.market.view.danmaku.easy.danmaku.DanmakuView.OnExitListener
            public final void onExit(DanmakuView danmakuView) {
                CachedDanmakuViewPool.this.lambda$get$1$CachedDanmakuViewPool(danmakuView);
            }
        });
        this.mInUseSize++;
        return danmakuView;
    }

    public /* synthetic */ void lambda$get$1$CachedDanmakuViewPool(DanmakuView danmakuView) {
        long currentTimeMillis = System.currentTimeMillis() + this.mKeepAliveTime;
        danmakuView.restore();
        DanmakuViewWithExpireTime danmakuViewWithExpireTime = new DanmakuViewWithExpireTime();
        danmakuViewWithExpireTime.danmakuView = danmakuView;
        danmakuViewWithExpireTime.expireTime = currentTimeMillis;
        this.mCache.offer(danmakuViewWithExpireTime);
        this.mInUseSize--;
    }

    @Override // com.coolapk.market.view.danmaku.easy.danmaku.Pool
    public void release() {
        this.mCache.clear();
    }

    @Override // com.coolapk.market.view.danmaku.easy.danmaku.Pool
    public int count() {
        return this.mCache.size() + this.mInUseSize;
    }

    @Override // com.coolapk.market.view.danmaku.easy.danmaku.Pool
    public void setMaxSize(int i) {
        this.mMaxSize = i;
    }

    private class DanmakuViewWithExpireTime {
        private DanmakuView danmakuView;
        private long expireTime;

        private DanmakuViewWithExpireTime() {
        }
    }
}
