package com.yalantis.ucrop.callback;

import android.net.Uri;

public interface BitmapCropCallback {
    void onBitmapCropped(Uri uri, int i, int i2);

    void onCropFailure(Throwable th);
}
