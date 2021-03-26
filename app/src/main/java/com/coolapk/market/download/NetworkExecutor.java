package com.coolapk.market.download;

public interface NetworkExecutor {
    DownloadResponse execute(String str) throws Throwable;
}
