package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.coolapk.market.util.ReflectUtils;

public class ControlGifImageView extends ScalingImageView {
    private Callback mCallback;
    private long mLoopStartTime;
    private int mMaxLoopCount;

    public interface Callback {
        void onGifDisplayFinish();

        void onGifLoaded();
    }

    public ControlGifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.coolapk.market.widget.view.ScalingImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (obtainGifDrawable(drawable) != null) {
            this.mMaxLoopCount = 0;
            this.mLoopStartTime = System.currentTimeMillis();
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onGifLoaded();
            }
        }
    }

    @Override // android.widget.ImageView, android.graphics.drawable.Drawable.Callback, android.view.View
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        GifDrawable obtainGifDrawable = obtainGifDrawable(drawable);
        if (obtainGifDrawable != null && this.mCallback != null) {
            try {
                int intValue = ((Integer) ReflectUtils.wrap(obtainGifDrawable).getChildField("loopCount").get()).intValue();
                if (intValue == 1 && this.mMaxLoopCount == 0) {
                    int floor = (int) Math.floor(3000.0d / ((double) (System.currentTimeMillis() - this.mLoopStartTime)));
                    this.mMaxLoopCount = floor;
                    if (floor <= 0) {
                        this.mMaxLoopCount = 1;
                    }
                }
                int i = this.mMaxLoopCount;
                if (i > 0 && intValue >= i) {
                    this.mCallback.onGifDisplayFinish();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setCallBack(Callback callback) {
        this.mCallback = callback;
    }

    public GifDrawable obtainGifDrawable(Drawable drawable) {
        if (drawable instanceof GifDrawable) {
            return (GifDrawable) drawable;
        }
        if (!(drawable instanceof TransitionDrawable)) {
            return null;
        }
        Drawable drawable2 = ((TransitionDrawable) drawable).getDrawable(1);
        if (drawable2 instanceof GifDrawable) {
            return (GifDrawable) drawable2;
        }
        return null;
    }
}
