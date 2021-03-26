package com.coolapk.market.download;

import com.coolapk.market.model.Extra;
import com.coolapk.market.util.LogUtils;

public class Downloader {
    private static volatile Downloader ourInstance;
    private final DownloadQueue mTaskQueue = new DownloadQueue(2);

    public static Downloader getInstance() {
        if (ourInstance == null) {
            synchronized (Downloader.class) {
                ourInstance = new Downloader();
            }
        }
        return ourInstance;
    }

    private Downloader() {
    }

    public synchronized void start(String str, String str2, String str3, OnDownloadListener onDownloadListener, Extra extra, NetworkExecutor networkExecutor) {
        if (this.mTaskQueue.isDownloadJobAlive(str)) {
            LogUtils.v("Already in task queue, abort it, [%s]", str);
        } else {
            this.mTaskQueue.add(str, str2, str3, onDownloadListener, extra, networkExecutor);
        }
    }

    public synchronized void stop(String str) {
        if (this.mTaskQueue.isDownloadJobAlive(str)) {
            this.mTaskQueue.cancel(str);
        }
    }

    public boolean isDownloadJobAlive(String str) {
        return this.mTaskQueue.isDownloadJobAlive(str);
    }

    public int count() {
        return this.mTaskQueue.count();
    }

    public synchronized void destroy() {
        this.mTaskQueue.cancelAll();
    }
}
