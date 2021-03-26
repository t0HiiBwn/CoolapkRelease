package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner implements Runnable {
    static final int BACKOFF_RATIO = 4;
    private static final Clock DEFAULT_CLOCK = new Clock();
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);
    static final long MAX_DURATION_MS = 32;
    static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set<PreFillType> seenTypes;
    private final PreFillQueue toPrefill;

    public BitmapPreFillRunner(BitmapPool bitmapPool2, MemoryCache memoryCache2, PreFillQueue preFillQueue) {
        this(bitmapPool2, memoryCache2, preFillQueue, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    BitmapPreFillRunner(BitmapPool bitmapPool2, MemoryCache memoryCache2, PreFillQueue preFillQueue, Clock clock2, Handler handler2) {
        this.seenTypes = new HashSet();
        this.currentDelay = 40;
        this.bitmapPool = bitmapPool2;
        this.memoryCache = memoryCache2;
        this.toPrefill = preFillQueue;
        this.clock = clock2;
        this.handler = handler2;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    boolean allocate() {
        Bitmap bitmap;
        long now = this.clock.now();
        while (!this.toPrefill.isEmpty() && !isGcDetected(now)) {
            PreFillType remove = this.toPrefill.remove();
            if (!this.seenTypes.contains(remove)) {
                this.seenTypes.add(remove);
                bitmap = this.bitmapPool.getDirty(remove.getWidth(), remove.getHeight(), remove.getConfig());
            } else {
                bitmap = Bitmap.createBitmap(remove.getWidth(), remove.getHeight(), remove.getConfig());
            }
            int bitmapByteSize = Util.getBitmapByteSize(bitmap);
            if (getFreeMemoryCacheBytes() >= ((long) bitmapByteSize)) {
                this.memoryCache.put(new UniqueKey(), BitmapResource.obtain(bitmap, this.bitmapPool));
            } else {
                this.bitmapPool.put(bitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                Log.d("PreFillRunner", "allocated [" + remove.getWidth() + "x" + remove.getHeight() + "] " + remove.getConfig() + " size: " + bitmapByteSize);
            }
        }
        return !this.isCancelled && !this.toPrefill.isEmpty();
    }

    private boolean isGcDetected(long j) {
        return this.clock.now() - j >= 32;
    }

    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (allocate()) {
            this.handler.postDelayed(this, getNextDelay());
        }
    }

    private long getNextDelay() {
        long j = this.currentDelay;
        this.currentDelay = Math.min(4 * j, MAX_BACKOFF_MS);
        return j;
    }

    private static final class UniqueKey implements Key {
        UniqueKey() {
        }

        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    static class Clock {
        Clock() {
        }

        long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }
}
