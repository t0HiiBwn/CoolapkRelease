package com.coolapk.market.widget.subsamplingview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

public interface ImageDecoder {
    Bitmap decode(Context context, Uri uri) throws Exception;
}
