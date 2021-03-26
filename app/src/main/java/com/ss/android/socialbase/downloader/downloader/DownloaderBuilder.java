package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.b;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.f;
import com.ss.android.socialbase.downloader.network.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class DownloaderBuilder {
    private f chunkAdjustCalculator;
    private g chunkCntCalculator;
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private i downloadCache;
    private List<m> downloadCompleteHandlers = new ArrayList();
    private f downloadDns;
    private int downloadExpSwitch = 1056964607;
    private boolean downloadInMultiProcess;
    private k downloadLaunchHandler;
    private b downloadMonitorListener;
    private ac downloadSetting;
    private h headHttpService;
    private IDownloadHttpService httpService;
    private j idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private o monitorConfig;
    private boolean needAutoRefreshUnSuccessTask = true;
    private ah notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private int writeBufferSize;

    public DownloaderBuilder(Context context2) {
        this.context = context2;
    }

    public DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }

    public DownloaderBuilder chunkAdjustCalculator(f fVar) {
        this.chunkAdjustCalculator = fVar;
        return this;
    }

    public DownloaderBuilder idGenerator(j jVar) {
        this.idGenerator = jVar;
        return this;
    }

    public DownloaderBuilder downloadCache(i iVar) {
        this.downloadCache = iVar;
        return this;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i) {
        this.maxDownloadPoolSize = i;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(g gVar) {
        this.chunkCntCalculator = gVar;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder headHttpService(h hVar) {
        this.headHttpService = hVar;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(k kVar) {
        this.downloadLaunchHandler = kVar;
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService executorService) {
        this.cpuThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService executorService) {
        this.mixDefaultDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService executorService) {
        this.mixFrequentDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService executorService) {
        this.mixApkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService executorService) {
        this.dbThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService executorService) {
        this.chunkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z) {
        this.downloadInMultiProcess = z;
        return this;
    }

    public DownloaderBuilder monitorConfig(o oVar) {
        this.monitorConfig = oVar;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i) {
        this.downloadExpSwitch = i;
        return this;
    }

    public DownloaderBuilder addDownloadCompleteHandler(m mVar) {
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

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(ah ahVar) {
        this.notificationClickCallback = ahVar;
        return this;
    }

    public DownloaderBuilder downloadSetting(ac acVar) {
        this.downloadSetting = acVar;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(b bVar) {
        this.downloadMonitorListener = bVar;
        return this;
    }

    public DownloaderBuilder downloadDns(f fVar) {
        this.downloadDns = fVar;
        return this;
    }

    public Context getContext() {
        return this.context;
    }

    public i getDownloadCache() {
        return this.downloadCache;
    }

    public j getIdGenerator() {
        return this.idGenerator;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public h getHeadHttpService() {
        return this.headHttpService;
    }

    public k getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public List<m> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public g getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public f getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public o getMonitorConfig() {
        return this.monitorConfig;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }

    public ah getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ac getDownloadSetting() {
        return this.downloadSetting;
    }

    public b getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public f getDownloadDns() {
        return this.downloadDns;
    }

    public Downloader build() {
        return new Downloader(this);
    }
}
