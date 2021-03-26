package com.tencent.imsdk;

import android.net.Uri;

public class TIMOfflinePushSettings {
    private Uri c2cMsgRemindSound;
    private Uri groupMsgRemindSound;
    private int openPush = 1;
    private Uri videoSound;

    public boolean isEnabled() {
        return this.openPush == 1;
    }

    public void setEnabled(boolean z) {
        this.openPush = z ? 1 : 2;
    }

    public Uri getC2cMsgRemindSound() {
        return this.c2cMsgRemindSound;
    }

    public void setC2cMsgRemindSound(Uri uri) {
        this.c2cMsgRemindSound = uri;
    }

    public Uri getGroupMsgRemindSound() {
        return this.groupMsgRemindSound;
    }

    public void setGroupMsgRemindSound(Uri uri) {
        this.groupMsgRemindSound = uri;
    }

    public Uri getVideoSound() {
        return this.videoSound;
    }

    public void setVideoSound(Uri uri) {
        this.videoSound = uri;
    }
}
