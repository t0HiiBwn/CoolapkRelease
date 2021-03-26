package com.ss.android.socialbase.downloader.model;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.d.a;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.g;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class DownloadTask {
    private f chunkAdjustCalculator;
    private g chunkStrategy;
    private n depend;
    private r diskSpaceHandler;
    private final List<m> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.a downloadInfoBuilder;
    private t fileUriProvider;
    private x forbiddenHandler;
    private y interceptor;
    private final SparseArray<IDownloadListener> mainThreadListeners;
    private z monitorDepend;
    private boolean needDelayForCacheSync;
    private ah notificationClickCallback;
    private ab notificationEventListener;
    private final SparseArray<IDownloadListener> notificationListeners;
    private q retryDelayTimeCalculator;
    private final SparseArray<com.ss.android.socialbase.downloader.constants.g> singleListenerHashCodeMap;
    private final Map<com.ss.android.socialbase.downloader.constants.g, IDownloadListener> singleListenerMap;
    private final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.downloadInfoBuilder = new DownloadInfo.a();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    public DownloadTask(DownloadInfo downloadInfo2) {
        this();
        this.downloadInfo = downloadInfo2;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public void setNeedDelayForCacheSync(boolean z) {
        this.needDelayForCacheSync = z;
    }

    public y getInterceptor() {
        return this.interceptor;
    }

    public n getDepend() {
        return this.depend;
    }

    public z getMonitorDepend() {
        return this.monitorDepend;
    }

    public g getChunkStrategy() {
        return this.chunkStrategy;
    }

    public q getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public x getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public r getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public ab getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public ah getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public t getFileUriProvider() {
        return this.fileUriProvider;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo2 = this.downloadInfo;
        if (downloadInfo2 != null) {
            return downloadInfo2.canShowNotification();
        }
        return false;
    }

    public DownloadTask chunkStategy(g gVar) {
        this.chunkStrategy = gVar;
        return this;
    }

    public DownloadTask chunkAdjustCalculator(f fVar) {
        this.chunkAdjustCalculator = fVar;
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(q qVar) {
        this.retryDelayTimeCalculator = qVar;
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i, iDownloadListener);
            }
            this.singleListenerMap.put(com.ss.android.socialbase.downloader.constants.g.MAIN, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, com.ss.android.socialbase.downloader.constants.g.MAIN);
            }
        }
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i, iDownloadListener);
            }
            this.singleListenerMap.put(com.ss.android.socialbase.downloader.constants.g.SUB, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, com.ss.android.socialbase.downloader.constants.g.SUB);
            }
        }
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i, iDownloadListener);
            }
            this.singleListenerMap.put(com.ss.android.socialbase.downloader.constants.g.NOTIFICATION, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, com.ss.android.socialbase.downloader.constants.g.NOTIFICATION);
            }
        }
        return this;
    }

    public DownloadTask notificationEventListener(ab abVar) {
        this.notificationEventListener = abVar;
        return this;
    }

    public DownloadTask interceptor(y yVar) {
        this.interceptor = yVar;
        return this;
    }

    public DownloadTask depend(n nVar) {
        this.depend = nVar;
        return this;
    }

    public DownloadTask monitorDepend(z zVar) {
        this.monitorDepend = zVar;
        return this;
    }

    public DownloadTask notificationClickCallback(ah ahVar) {
        this.notificationClickCallback = ahVar;
        return this;
    }

    public DownloadTask forbiddenHandler(x xVar) {
        this.forbiddenHandler = xVar;
        return this;
    }

    public DownloadTask diskSpaceHandler(r rVar) {
        this.diskSpaceHandler = rVar;
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.a(str);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.b(str);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.c(str);
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.d(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.e(str);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.f(str);
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.a(z);
        return this;
    }

    public DownloadTask extraHeaders(List<c> list) {
        this.downloadInfoBuilder.a(list);
        return this;
    }

    public DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.a(i);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.a(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.a(iArr);
        return this;
    }

    public DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.b(i);
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.c(i);
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.b(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.c(z);
        return this;
    }

    public DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.d(i);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.e(i);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.b(list);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.g(str);
        return this;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.e(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.d(z);
        return this;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.f(z);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.g(z);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.h(str);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.i(str);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.a(j);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.j(z);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.j(str);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.h(z);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.k(z);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.o(z);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.i(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.l(z);
        return this;
    }

    public DownloadTask enqueueType(com.ss.android.socialbase.downloader.constants.f fVar) {
        this.downloadInfoBuilder.a(fVar);
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.m(z);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.n(z);
        return this;
    }

    public DownloadTask fileUriProvider(t tVar) {
        this.fileUriProvider = tVar;
        return this;
    }

    public DownloadTask newSaveTempFileEnable(boolean z) {
        this.downloadInfoBuilder.p(z);
        return this;
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.q(z);
        return this;
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.a(jSONObject);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.l(str);
        return this;
    }

    public DownloadTask executorGroup(int i) {
        this.downloadInfoBuilder.f(i);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.b(j);
        return this;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.s(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.r(z);
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.k(str);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.b(iArr);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.t(z);
        return this;
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.u(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.a();
        if (b.x().b(this.downloadInfo.getId()) == null) {
            a.a(this, (BaseException) null, 0);
        }
        setChunkCalculator();
        c.a().a(this);
        DownloadInfo downloadInfo2 = this.downloadInfo;
        if (downloadInfo2 == null) {
            return 0;
        }
        return downloadInfo2.getId();
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo2 = this.downloadInfo;
        if (downloadInfo2 == null) {
            return 0;
        }
        return downloadInfo2.getId();
    }

    public void addListenerToDownloadingSameTask() {
        com.ss.android.socialbase.downloader.c.a.b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        addListenerToDownloadingSameTask(com.ss.android.socialbase.downloader.constants.g.MAIN);
        addListenerToDownloadingSameTask(com.ss.android.socialbase.downloader.constants.g.SUB);
        a.a(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    private void addListenerToDownloadingSameTask(com.ss.android.socialbase.downloader.constants.g gVar) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(gVar);
        synchronized (downloadListeners) {
            for (int i = 0; i < downloadListeners.size(); i++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                if (iDownloadListener != null) {
                    c.a().b(getDownloadId(), iDownloadListener, gVar, false);
                }
            }
        }
    }

    public SparseArray<IDownloadListener> getDownloadListeners(com.ss.android.socialbase.downloader.constants.g gVar) {
        if (gVar == com.ss.android.socialbase.downloader.constants.g.MAIN) {
            return this.mainThreadListeners;
        }
        if (gVar == com.ss.android.socialbase.downloader.constants.g.SUB) {
            return this.subThreadListeners;
        }
        if (gVar == com.ss.android.socialbase.downloader.constants.g.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public int getDownloadListenerSize(com.ss.android.socialbase.downloader.constants.g gVar) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(gVar);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public IDownloadListener getDownloadListenerByIndex(com.ss.android.socialbase.downloader.constants.g gVar, int i) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(gVar);
        if (downloadListeners == null || i < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            if (i >= downloadListeners.size()) {
                return null;
            }
            return downloadListeners.get(downloadListeners.keyAt(i));
        }
    }

    public IDownloadListener getSingleDownloadListener(com.ss.android.socialbase.downloader.constants.g gVar) {
        return this.singleListenerMap.get(gVar);
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        int indexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(gVar);
        if (downloadListeners != null) {
            synchronized (downloadListeners) {
                if (z) {
                    if (this.singleListenerMap.containsKey(gVar)) {
                        iDownloadListener = this.singleListenerMap.get(gVar);
                        this.singleListenerMap.remove(gVar);
                    }
                    if (iDownloadListener != null && (indexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && indexOfValue < downloadListeners.size()) {
                        downloadListeners.removeAt(indexOfValue);
                    }
                } else {
                    downloadListeners.remove(i);
                    synchronized (this.singleListenerHashCodeMap) {
                        com.ss.android.socialbase.downloader.constants.g gVar2 = this.singleListenerHashCodeMap.get(i);
                        if (gVar2 != null && this.singleListenerMap.containsKey(gVar2)) {
                            this.singleListenerMap.remove(gVar2);
                            this.singleListenerHashCodeMap.remove(i);
                        }
                    }
                }
            }
        } else if (z && this.singleListenerMap.containsKey(gVar)) {
            this.singleListenerMap.remove(gVar);
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        Map<com.ss.android.socialbase.downloader.constants.g, IDownloadListener> map;
        if (iDownloadListener != null) {
            if (z && (map = this.singleListenerMap) != null) {
                map.put(gVar, iDownloadListener);
                synchronized (this.singleListenerHashCodeMap) {
                    this.singleListenerHashCodeMap.put(i, gVar);
                }
            }
            SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(gVar);
            if (downloadListeners != null) {
                synchronized (downloadListeners) {
                    downloadListeners.put(i, iDownloadListener);
                }
            }
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int keyAt = sparseArray2.keyAt(i);
            IDownloadListener iDownloadListener = sparseArray2.get(keyAt);
            if (iDownloadListener != null) {
                sparseArray.put(keyAt, iDownloadListener);
            }
        }
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, com.ss.android.socialbase.downloader.constants.g gVar) {
        if (sparseArray != null) {
            try {
                if (gVar == com.ss.android.socialbase.downloader.constants.g.MAIN) {
                    synchronized (this.mainThreadListeners) {
                        copyListeners(this.mainThreadListeners, sparseArray);
                    }
                } else if (gVar == com.ss.android.socialbase.downloader.constants.g.SUB) {
                    synchronized (this.subThreadListeners) {
                        copyListeners(this.subThreadListeners, sparseArray);
                    }
                } else if (gVar == com.ss.android.socialbase.downloader.constants.g.NOTIFICATION) {
                    synchronized (this.notificationListeners) {
                        copyListeners(this.notificationListeners, sparseArray);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setNotificationEventListener(ab abVar) {
        this.notificationEventListener = abVar;
    }

    public f getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
        this.chunkStrategy = downloadTask.chunkStrategy;
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        for (Map.Entry<com.ss.android.socialbase.downloader.constants.g, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (!(sparseArray == null || sparseArray2 == null)) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                sparseArray2.put(keyAt, sparseArray.get(keyAt));
            }
        }
    }

    private void removeAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (!(sparseArray == null || sparseArray2 == null)) {
            int size = sparseArray2.size();
            for (int i = 0; i < size; i++) {
                sparseArray.remove(sparseArray2.keyAt(i));
            }
        }
    }

    public List<m> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public m getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            if (i >= this.downloadCompleteHandlers.size()) {
                return null;
            }
            return this.downloadCompleteHandlers.get(i);
        }
    }

    public DownloadTask addDownloadCompleteHandler(m mVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (mVar != null) {
                if (!this.downloadCompleteHandlers.contains(mVar)) {
                    this.downloadCompleteHandlers.add(mVar);
                    return this;
                }
            }
            return this;
        }
    }

    public DownloadTask setDownloadCompleteHandlers(List<m> list) {
        if (list != null && !list.isEmpty()) {
            for (m mVar : list) {
                addDownloadCompleteHandler(mVar);
            }
        }
        return this;
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new g() {
                /* class com.ss.android.socialbase.downloader.model.DownloadTask.AnonymousClass1 */

                @Override // com.ss.android.socialbase.downloader.downloader.g
                public int a(long j) {
                    return 1;
                }
            });
        }
    }
}
