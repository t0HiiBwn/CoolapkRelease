package com.huawei.hms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import com.huawei.hms.support.api.client.Status;

public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        this.mStatus.startResolutionForResult(activity, i);
    }

    public PendingIntent getResolution() {
        return this.mStatus.getResolution();
    }
}
