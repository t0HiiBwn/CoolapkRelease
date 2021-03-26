package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMMessageOfflinePushSettings;

public class V2TIMOfflinePushInfo {
    public static final String IOS_OFFLINE_PUSH_NO_SOUND = "push.no_sound";
    private TIMMessageOfflinePushSettings timMessageOfflinePushSettings = new TIMMessageOfflinePushSettings();

    void setTIMMessageOfflinePushConfig(TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings) {
        this.timMessageOfflinePushSettings = tIMMessageOfflinePushSettings;
    }

    TIMMessageOfflinePushSettings getTimMessageOfflinePushConfig() {
        return this.timMessageOfflinePushSettings;
    }

    public void setTitle(String str) {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            tIMMessageOfflinePushSettings.setTitle(str);
            this.timMessageOfflinePushSettings.setEnabled(true);
        }
    }

    public String getTitle() {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            return tIMMessageOfflinePushSettings.getTitle();
        }
        return null;
    }

    public void setDesc(String str) {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            tIMMessageOfflinePushSettings.setDescr(str);
            this.timMessageOfflinePushSettings.setEnabled(true);
        }
    }

    public String getDesc() {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            return tIMMessageOfflinePushSettings.getDescr();
        }
        return null;
    }

    public void setExt(byte[] bArr) {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            tIMMessageOfflinePushSettings.setExt(bArr);
            this.timMessageOfflinePushSettings.setEnabled(true);
        }
    }

    public void disablePush(boolean z) {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            tIMMessageOfflinePushSettings.setEnabled(!z);
        }
    }

    public boolean isDisablePush() {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            return !tIMMessageOfflinePushSettings.isEnabled();
        }
        return false;
    }

    public void setIOSSound(String str) {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            tIMMessageOfflinePushSettings.getIosSettings().setSound(str);
        }
    }

    public void setIgnoreIOSBadge(boolean z) {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            tIMMessageOfflinePushSettings.getIosSettings().setBadgeEnabled(!z);
        }
    }

    public void setAndroidOPPOChannelID(String str) {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = this.timMessageOfflinePushSettings;
        if (tIMMessageOfflinePushSettings != null) {
            tIMMessageOfflinePushSettings.getAndroidSettings().setOPPOChannelID(str);
        }
    }
}
