package com.kk.taurus.playerbase.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.kk.taurus.playerbase.log.PLog;
import com.kk.taurus.playerbase.player.IPlayer;
import com.kk.taurus.playerbase.render.IRender;
import java.lang.ref.WeakReference;

public class RenderTextureView extends TextureView implements IRender {
    final String TAG;
    private IRender.IRenderCallback mRenderCallback;
    private RenderMeasure mRenderMeasure;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private boolean mTakeOverSurfaceTexture;

    @Override // com.kk.taurus.playerbase.render.IRender
    public View getRenderView() {
        return this;
    }

    public RenderTextureView(Context context) {
        this(context, null);
    }

    public RenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "RenderTextureView";
        this.mRenderMeasure = new RenderMeasure();
        setSurfaceTextureListener(new InternalSurfaceTextureListener());
    }

    public void setTakeOverSurfaceTexture(boolean z) {
        this.mTakeOverSurfaceTexture = z;
    }

    public boolean isTakeOverSurfaceTexture() {
        return this.mTakeOverSurfaceTexture;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRenderMeasure.doMeasure(i, i2);
        setMeasuredDimension(this.mRenderMeasure.getMeasureWidth(), this.mRenderMeasure.getMeasureHeight());
    }

    @Override // com.kk.taurus.playerbase.render.IRender
    public void setRenderCallback(IRender.IRenderCallback iRenderCallback) {
        this.mRenderCallback = iRenderCallback;
    }

    @Override // com.kk.taurus.playerbase.render.IRender
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mRenderMeasure.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    @Override // com.kk.taurus.playerbase.render.IRender
    public void setVideoRotation(int i) {
        this.mRenderMeasure.setVideoRotation(i);
        setRotation((float) i);
    }

    @Override // com.kk.taurus.playerbase.render.IRender
    public void updateAspectRatio(AspectRatio aspectRatio) {
        this.mRenderMeasure.setAspectRatio(aspectRatio);
        requestLayout();
    }

    @Override // com.kk.taurus.playerbase.render.IRender
    public void updateVideoSize(int i, int i2) {
        PLog.d("RenderTextureView", "onUpdateVideoSize : videoWidth = " + i + " videoHeight = " + i2);
        this.mRenderMeasure.setVideoSize(i, i2);
        requestLayout();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        PLog.d("RenderTextureView", "onTextureViewAttachedToWindow");
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PLog.d("RenderTextureView", "onTextureViewDetachedFromWindow");
    }

    @Override // com.kk.taurus.playerbase.render.IRender
    public void release() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        setSurfaceTextureListener(null);
    }

    void setSurface(Surface surface) {
        this.mSurface = surface;
    }

    Surface getSurface() {
        return this.mSurface;
    }

    SurfaceTexture getOwnSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    private static final class InternalRenderHolder implements IRender.IRenderHolder {
        private WeakReference<Surface> mSurfaceRefer;
        private WeakReference<RenderTextureView> mTextureRefer;

        public InternalRenderHolder(RenderTextureView renderTextureView, SurfaceTexture surfaceTexture) {
            this.mTextureRefer = new WeakReference<>(renderTextureView);
            this.mSurfaceRefer = new WeakReference<>(new Surface(surfaceTexture));
        }

        RenderTextureView getTextureView() {
            WeakReference<RenderTextureView> weakReference = this.mTextureRefer;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // com.kk.taurus.playerbase.render.IRender.IRenderHolder
        public void bindPlayer(IPlayer iPlayer) {
            RenderTextureView textureView = getTextureView();
            if (iPlayer != null && this.mSurfaceRefer != null && textureView != null) {
                SurfaceTexture ownSurfaceTexture = textureView.getOwnSurfaceTexture();
                SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
                boolean z = false;
                boolean isReleased = (ownSurfaceTexture == null || Build.VERSION.SDK_INT < 26) ? false : ownSurfaceTexture.isReleased();
                if (ownSurfaceTexture != null && !isReleased) {
                    z = true;
                }
                if (!textureView.isTakeOverSurfaceTexture() || !z || Build.VERSION.SDK_INT < 16) {
                    Surface surface = this.mSurfaceRefer.get();
                    if (surface != null) {
                        iPlayer.setSurface(surface);
                        textureView.setSurface(surface);
                        PLog.d("RenderTextureView", "****bindSurface****");
                    }
                } else if (!ownSurfaceTexture.equals(surfaceTexture)) {
                    textureView.setSurfaceTexture(ownSurfaceTexture);
                    PLog.d("RenderTextureView", "****setSurfaceTexture****");
                } else {
                    Surface surface2 = textureView.getSurface();
                    if (surface2 != null) {
                        surface2.release();
                    }
                    Surface surface3 = new Surface(ownSurfaceTexture);
                    iPlayer.setSurface(surface3);
                    textureView.setSurface(surface3);
                    PLog.d("RenderTextureView", "****bindSurface****");
                }
            }
        }
    }

    private class InternalSurfaceTextureListener implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        private InternalSurfaceTextureListener() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            PLog.d("RenderTextureView", "<---onSurfaceTextureAvailable---> : width = " + i + " height = " + i2);
            if (RenderTextureView.this.mRenderCallback != null) {
                RenderTextureView.this.mRenderCallback.onSurfaceCreated(new InternalRenderHolder(RenderTextureView.this, surfaceTexture), i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            PLog.d("RenderTextureView", "onSurfaceTextureSizeChanged : width = " + i + " height = " + i2);
            if (RenderTextureView.this.mRenderCallback != null) {
                RenderTextureView.this.mRenderCallback.onSurfaceChanged(new InternalRenderHolder(RenderTextureView.this, surfaceTexture), 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            PLog.d("RenderTextureView", "***onSurfaceTextureDestroyed***");
            if (RenderTextureView.this.mRenderCallback != null) {
                RenderTextureView.this.mRenderCallback.onSurfaceDestroy(new InternalRenderHolder(RenderTextureView.this, surfaceTexture));
            }
            if (RenderTextureView.this.mTakeOverSurfaceTexture) {
                RenderTextureView.this.mSurfaceTexture = surfaceTexture;
            }
            return !RenderTextureView.this.mTakeOverSurfaceTexture;
        }
    }
}
