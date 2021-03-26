package com.yalantis.ucrop.callback;

import android.graphics.Bitmap;
import com.yalantis.ucrop.model.ExifInfo;

public interface BitmapLoadCallback {
    void onBitmapLoaded(Bitmap bitmap, ExifInfo exifInfo, String str, String str2);

    void onFailure(Exception exc);
}
