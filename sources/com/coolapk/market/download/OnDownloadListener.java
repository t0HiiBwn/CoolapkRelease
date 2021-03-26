package com.coolapk.market.download;

public interface OnDownloadListener {
    void onDownloadJobCancel(DownloadJob downloadJob);

    void onDownloadJobError(DownloadJob downloadJob, Throwable th);

    void onDownloadJobRunning(DownloadJob downloadJob);

    void onDownloadJobStart(DownloadJob downloadJob);

    void onDownloadJobSuccess(DownloadJob downloadJob);

    void onDownloadJobWait(DownloadJob downloadJob);
}
