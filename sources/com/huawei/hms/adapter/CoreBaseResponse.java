package com.huawei.hms.adapter;

import android.app.PendingIntent;
import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class CoreBaseResponse implements IMessageEntity {
    @Packed
    public Intent intent;
    @Packed
    private String jsonBody;
    @Packed
    private String jsonHeader;
    @Packed
    public PendingIntent pendingIntent;

    public Intent getIntent() {
        return this.intent;
    }

    public void setIntent(Intent intent2) {
        this.intent = intent2;
    }

    public PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public void setPendingIntent(PendingIntent pendingIntent2) {
        this.pendingIntent = pendingIntent2;
    }

    public String getJsonHeader() {
        return this.jsonHeader;
    }

    public void setJsonHeader(String str) {
        this.jsonHeader = str;
    }

    public String getJsonBody() {
        return this.jsonBody;
    }

    public void setJsonBody(String str) {
        this.jsonBody = str;
    }
}
