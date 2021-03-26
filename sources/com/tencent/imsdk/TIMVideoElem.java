package com.tencent.imsdk;

public class TIMVideoElem extends TIMElem {
    private TIMSnapshot snapshot;
    private String snapshotPath = "";
    private long taskId = 0;
    private TIMVideo video;
    private String videoPath = "";

    public TIMVideoElem() {
        this.type = TIMElemType.Video;
    }

    public long getTaskId() {
        return this.taskId;
    }

    void setTaskId(long j) {
        this.taskId = j;
    }

    public void setVideo(TIMVideo tIMVideo) {
        this.video = tIMVideo;
    }

    public TIMVideo getVideoInfo() {
        return this.video;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setSnapshot(TIMSnapshot tIMSnapshot) {
        this.snapshot = tIMSnapshot;
    }

    public TIMSnapshot getSnapshotInfo() {
        return this.snapshot;
    }

    public String getSnapshotPath() {
        return this.snapshotPath;
    }

    public void setSnapshotPath(String str) {
        this.snapshotPath = str;
    }
}
