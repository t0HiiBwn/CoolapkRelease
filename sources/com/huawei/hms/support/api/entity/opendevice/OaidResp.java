package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class OaidResp extends AbstractMessageEntity {
    @Packed
    private String id;
    @Packed
    private boolean isTrackLimited;
    @Packed
    private PendingIntent settingIntent;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public boolean isTrackLimited() {
        return this.isTrackLimited;
    }

    public void setTrackLimited(boolean z) {
        this.isTrackLimited = z;
    }

    public PendingIntent getSettingIntent() {
        return this.settingIntent;
    }

    public void setSettingIntent(PendingIntent pendingIntent) {
        this.settingIntent = pendingIntent;
    }
}
