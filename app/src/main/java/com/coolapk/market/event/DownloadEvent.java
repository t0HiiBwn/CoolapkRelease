package com.coolapk.market.event;

import com.coolapk.market.model.DownloadState;

public class DownloadEvent implements Event {
    public final DownloadState downloadState;
    public final String key;
    public final String url;

    public DownloadEvent(DownloadState downloadState2) {
        this.key = downloadState2.getKey();
        this.url = downloadState2.getUrl();
        this.downloadState = downloadState2;
    }
}
