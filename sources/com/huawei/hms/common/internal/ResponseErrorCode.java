package com.huawei.hms.common.internal;

import android.os.Parcelable;

public interface ResponseErrorCode {
    int getErrorCode();

    String getErrorReason();

    Parcelable getParcelable();

    String getResolution();

    int getStatusCode();

    String getTransactionId();
}
