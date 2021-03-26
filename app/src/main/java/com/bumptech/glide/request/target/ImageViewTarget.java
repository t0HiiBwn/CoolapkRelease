package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    private Animatable animatable;

    protected abstract void setResource(Z z);

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        setResourceInternal(null);
        setDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        setResourceInternal(null);
        setDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.stop();
        }
        setResourceInternal(null);
        setDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z z, Transition<? super Z> transition) {
        if (transition == null || !transition.transition(z, this)) {
            setResourceInternal(z);
        } else {
            maybeUpdateAnimatable(z);
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.start();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.stop();
        }
    }

    private void setResourceInternal(Z z) {
        setResource(z);
        maybeUpdateAnimatable(z);
    }

    private void maybeUpdateAnimatable(Z z) {
        if (z instanceof Animatable) {
            Z z2 = z;
            this.animatable = z2;
            z2.start();
            return;
        }
        this.animatable = null;
    }
}
