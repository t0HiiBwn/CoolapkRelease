package com.coolapk.market.event;

public class BackupDelEvent {
    private String backupId;

    public BackupDelEvent(String str) {
        this.backupId = str;
    }

    public String getBackupId() {
        return this.backupId;
    }
}
