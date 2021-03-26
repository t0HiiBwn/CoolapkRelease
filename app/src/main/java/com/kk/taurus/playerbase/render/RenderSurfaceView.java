package com.kk.taurus.playerbase.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.kk.taurus.playerbase.log.PLog;
import com.kk.taurus.playerbase.player.IPlayer;
import com.kk.taurus.playerbase.render.IRender;
import java.lang.ref.WeakReference;

public class RenderSurfaceView extends SurfaceView implements IRender {
    final String TAG;
    private IRender.IRenderCallback mRenderCallback;
    private RenderMeasure mRenderMeasure;

    @Override // com.kk.taurus.playerbase.render.IRender
    public View getRenderView() {
        return this;
    }

    @Override // com.kk.taurus.playerbase.render.IRender
    public void release() {
    }

    public RenderSurfaceView(Context context) {
        this(context, null);
    }

    public RenderSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "RenderSurfaceView";
        this.mRenderMeasure = new RenderMeasure();
        getHolder().addCallback(new InternalSurfaceHolderCallback());
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
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
        PLog.e("RenderSurfaceView", "surface view not support rotation ... ");
    }

    @Override // com.kk.taurus.playerbase.render.IRender
    public void updateAspectRatio(AspectRatio aspectRatio) {
        this.mRenderMeasure.setAspectRatio(aspectRatio);
        requestLayout();
    }

    @Override // com.kk.taurus.playerbase.render.IRender
    public void updateVideoSize(int i, int i2) {
        this.mRenderMeasure.setVideoSize(i, i2);
        fixedSize(i, i2);
        requestLayout();
    }

    void fixedSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            getHolder().setFixedSize(i, i2);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PLog.d("RenderSurfaceView", "onSurfaceViewDetachedFromWindow");
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        PLog.d("RenderSurfaceView", "onSurfaceViewAttachedToWindow");
    }

    private static final class InternalRenderHolder implements IRender.IRenderHolder {
        private WeakReference<SurfaceHolder> mSurfaceHolder;

        public InternalRenderHolder(SurfaceHolder surfaceHolder) {
            this.mSurfaceHolder = new WeakReference<>(surfaceHolder);
        }

        @Override // com.kk.taurus.playerbase.render.IRender.IRenderHolder
        public void bindPlayer(IPlayer iPlayer) {
            if (iPlayer != null && this.mSurfaceHolder.get() != null) {
                iPlayer.setDisplay(this.mSurfaceHolder.get());
            }
        }
    }

    private class InternalSurfaceHolderCallback implements SurfaceHolder.Callback {
        private InternalSurfaceHolderCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            PLog.d("RenderSurfaceView", "<---surfaceCreated---->");
            if (RenderSurfaceView.this.mRenderCallback != null) {
                RenderSurfaceView.this.mRenderCallback.onSurfaceCreated(new InternalRenderHolder(surfaceHolder), 0, 0);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            PLog.d("RenderSurfaceView", "surfaceChanged : width = " + i2 + " height = " + i3);
            if (RenderSurfaceView.this.mRenderCallback != null) {
                RenderSurfaceView.this.mRenderCallback.onSurfaceChanged(new InternalRenderHolder(surfaceHolder), i, i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            PLog.d("RenderSurfaceView", "***surfaceDestroyed***");
            if (RenderSurfaceView.this.mRenderCallback != null) {
                RenderSurfaceView.this.mRenderCallback.onSurfaceDestroy(new InternalRenderHolder(surfaceHolder));
            }
        }
    }
}
