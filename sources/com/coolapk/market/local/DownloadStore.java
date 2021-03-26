package com.coolapk.market.local;

import com.coolapk.market.event.DownloadEvent;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DownloadStore extends Store {
    public static final int ACTION_DOWNLOAD_STATE_CHANGE = 1;
    public static final int ACTION_DOWNLOAD_STATE_CHANGE_NO_EVENT = 2;
    public static final int ACTION_DOWNLOAD_STATE_DELETE = 3;
    private final DbHelper dataBase;
    private final Object stateLock = new Object();
    private final Map<String, DownloadState> stateMapping = new HashMap();

    public DownloadStore(DbHelper dbHelper) {
        this.dataBase = dbHelper;
        for (DownloadInfo downloadInfo : dbHelper.getDownloadInfoList(0)) {
            this.stateMapping.put(downloadInfo.getUrlMd5(), DownloadState.newBuilder(downloadInfo.getUrl()).dbId(Long.valueOf(downloadInfo.getDbId())).state(0).filePath(downloadInfo.getFilePath()).fileName(downloadInfo.getFileName()).extra(downloadInfo.getExtra()).currentLength(downloadInfo.getCurrentLength()).totalLength(downloadInfo.getTotalLength()).startTime(downloadInfo.getStartTime()).updateTime(downloadInfo.getUpdateTime()).mimeType(downloadInfo.getMimeType()).build());
        }
    }

    @Override // com.coolapk.market.local.Store
    public void handleAction(int i, Object obj) {
        if (i == 1) {
            synchronized (this.stateLock) {
                DownloadState downloadState = (DownloadState) obj;
                LogUtils.v("Download state: [%s], %s", downloadState.getFileName(), Integer.valueOf(downloadState.getState()));
                DownloadState build = DownloadState.newBuilder(downloadState).dbId(Long.valueOf(saveDownloadInfo(downloadState))).build();
                this.stateMapping.put(build.getKey(), build);
                postChangeEvent(new DownloadEvent(build));
            }
        } else if (i == 2) {
            synchronized (this.stateLock) {
                DownloadState downloadState2 = (DownloadState) obj;
                DownloadState build2 = DownloadState.newBuilder(downloadState2).dbId(Long.valueOf(saveDownloadInfo(downloadState2))).build();
                this.stateMapping.put(build2.getKey(), build2);
            }
        } else if (i == 3) {
            synchronized (this.stateLock) {
                this.stateMapping.remove(((DownloadState) obj).getKey());
            }
        } else {
            throw new RuntimeException("Unknown action: " + i + " data: " + obj.toString());
        }
    }

    private long saveDownloadInfo(DownloadState downloadState) {
        long j;
        boolean z = downloadState.getDbId() == null;
        DownloadInfo.Builder newBuilder = DownloadInfo.newBuilder();
        if (z) {
            j = 0;
        } else {
            j = downloadState.getDbId().longValue();
        }
        return this.dataBase.saveDownloadInfo(newBuilder.dbId(j).url(downloadState.getUrl()).filePath(downloadState.getFilePath()).fileName(downloadState.getFileName()).currentLength(downloadState.getCurrentLength()).totalLength(downloadState.getTotalLength()).extraString(downloadState.getExtra() != null ? downloadState.getExtra().toString() : null).mimeType(downloadState.getMimeType()).createTime(0).startTime(downloadState.getStartTime()).updateTime(downloadState.getUpdateTime()).build());
    }

    public DownloadState getDownloadStateWithUrl(String str) {
        return this.stateMapping.get(DownloadState.generateUriKey(str));
    }

    public DownloadState getDownloadState(String str) {
        return this.stateMapping.get(str);
    }

    public List<DownloadState> getDownloadStates() {
        return new ArrayList(this.stateMapping.values());
    }
}
