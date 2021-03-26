package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = "AbsDownloadListener";

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            a.b(str, " onPrepare -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            a.b(str, " onStart -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (a.a() && downloadInfo != null && downloadInfo.getTotalBytes() != 0) {
            a.b(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((((float) downloadInfo.getCurBytes()) / ((float) downloadInfo.getTotalBytes())) * 100.0f)));
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            a.b(str, " onPause -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            a.b(str, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001f: APUT  (r1v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r5v1 java.lang.String) */
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            a.b(str, String.format("onFailed on %s because of : %s", objArr));
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            a.b(str, " onCanceled -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            a.b(str, " onFirstStart -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            a.b(str, " onFirstSuccess -- " + downloadInfo.getName());
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001f: APUT  (r1v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r5v1 java.lang.String) */
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            a.b(str, String.format("onRetry on %s because of : %s", objArr));
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001f: APUT  (r1v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r5v1 java.lang.String) */
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            a.b(str, String.format("onRetryDelay on %s because of : %s", objArr));
        }
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (a.a() && downloadInfo != null) {
            String str = TAG;
            a.b(str, " onIntercept -- " + downloadInfo.getName());
        }
    }
}
