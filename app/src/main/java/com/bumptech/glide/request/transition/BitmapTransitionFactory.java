package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class BitmapTransitionFactory extends BitmapContainerTransitionFactory<Bitmap> {
    /* access modifiers changed from: protected */
    public Bitmap getBitmap(Bitmap bitmap) {
        return bitmap;
    }

    public BitmapTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        super(transitionFactory);
    }
}
