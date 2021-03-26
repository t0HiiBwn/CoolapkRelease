package com.coolapk.market.widget.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.Toast;
import cn.bertsir.zbar.CameraManager;
import cn.bertsir.zbar.ScanCallback;

public class CameraPreview extends FrameLayout implements SurfaceHolder.Callback {
    private boolean isPreviewStart;
    private Runnable mAutoFocusTask;
    private CameraManager mCameraManager;
    private Camera.AutoFocusCallback mFocusCallback;
    private CameraScanAnalysis mPreviewCallback;
    private SurfaceView mSurfaceView;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public CameraPreview(Context context) {
        this(context, null);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isPreviewStart = false;
        this.mFocusCallback = new Camera.AutoFocusCallback() {
            /* class com.coolapk.market.widget.camera.CameraPreview.AnonymousClass2 */

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                CameraPreview cameraPreview = CameraPreview.this;
                cameraPreview.postDelayed(cameraPreview.mAutoFocusTask, 500);
            }
        };
        this.mAutoFocusTask = new Runnable() {
            /* class com.coolapk.market.widget.camera.CameraPreview.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                CameraPreview.this.mCameraManager.autoFocus(CameraPreview.this.mFocusCallback);
            }
        };
        this.mCameraManager = new CameraManager(context);
        this.mPreviewCallback = new CameraScanAnalysis(context);
    }

    public void setScanCallback(ScanCallback scanCallback) {
        this.mPreviewCallback.setScanCallback(scanCallback);
    }

    public boolean start() {
        try {
            this.mCameraManager.openDriver();
            this.mPreviewCallback.onStart();
            if (this.mSurfaceView == null) {
                SurfaceView surfaceView = new SurfaceView(getContext());
                this.mSurfaceView = surfaceView;
                addView(surfaceView, new FrameLayout.LayoutParams(-1, -1));
                SurfaceHolder holder = this.mSurfaceView.getHolder();
                holder.addCallback(this);
                holder.setType(3);
            }
            startCameraPreview(this.mSurfaceView.getHolder());
            return true;
        } catch (Exception unused) {
            Toast.makeText(getContext(), "摄像头权限被拒绝！", 0).show();
            return false;
        }
    }

    public void stop() {
        removeCallbacks(this.mAutoFocusTask);
        this.mPreviewCallback.onStop();
        this.mCameraManager.stopPreview();
        this.mCameraManager.closeDriver();
        this.isPreviewStart = false;
    }

    private void startCameraPreview(SurfaceHolder surfaceHolder) {
        try {
            this.mCameraManager.startPreview(surfaceHolder, this.mPreviewCallback);
            this.mCameraManager.autoFocus(this.mFocusCallback);
            this.isPreviewStart = true;
        } catch (Exception e) {
            e.printStackTrace();
            new Handler().postDelayed(new Runnable() {
                /* class com.coolapk.market.widget.camera.CameraPreview.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    CameraPreview.this.mCameraManager.autoFocus(CameraPreview.this.mFocusCallback);
                }
            }, 200);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() != null) {
            this.mCameraManager.stopPreview();
            startCameraPreview(surfaceHolder);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        stop();
        super.onDetachedFromWindow();
    }

    public void setFlash() {
        this.mCameraManager.setFlash();
    }

    public void setFlash(boolean z) {
        this.mCameraManager.setFlash(z);
    }

    public void setZoom(float f) {
        this.mCameraManager.setCameraZoom(f);
    }

    public void handleZoom(boolean z) {
        this.mCameraManager.handleZoom(z);
    }

    public boolean isPreviewStart() {
        return this.isPreviewStart;
    }

    public void destroy() {
        this.mPreviewCallback.destroy();
    }
}
