package cn.bertsir.zbar;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import cn.bertsir.zbar.utils.QRUtils;
import java.io.IOException;

public final class CameraManager {
    private static final String TAG = "CameraManager";
    private Context context;
    private Camera mCamera;
    private final CameraConfiguration mConfiguration;

    public CameraManager(Context context2) {
        this.context = context2;
        this.mConfiguration = new CameraConfiguration(context2);
    }

    public synchronized void openDriver() throws Exception {
        String str;
        if (this.mCamera == null) {
            Camera open = Camera.open();
            this.mCamera = open;
            if (open != null) {
                this.mConfiguration.initFromCameraParameters(open);
                Camera.Parameters parameters = this.mCamera.getParameters();
                if (parameters == null) {
                    str = null;
                } else {
                    str = parameters.flatten();
                }
                try {
                    this.mConfiguration.setDesiredCameraParameters(this.mCamera, false);
                } catch (RuntimeException unused) {
                    if (str != null) {
                        Camera.Parameters parameters2 = this.mCamera.getParameters();
                        parameters2.unflatten(str);
                        try {
                            this.mCamera.setParameters(parameters2);
                            this.mConfiguration.setDesiredCameraParameters(this.mCamera, true);
                        } catch (RuntimeException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return;
            }
            throw new IOException("The camera is occupied.");
        }
    }

    public synchronized void closeDriver() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public boolean isOpen() {
        return this.mCamera != null;
    }

    public CameraConfiguration getConfiguration() {
        return this.mConfiguration;
    }

    public void startPreview(SurfaceHolder surfaceHolder, Camera.PreviewCallback previewCallback) throws IOException {
        if (this.mCamera != null) {
            if (!Build.MANUFACTURER.equals("LGE") || !Build.MODEL.equals("Nexus 5X")) {
                this.mCamera.setDisplayOrientation(QRUtils.getInstance().isScreenOriatationPortrait(this.context) ? 90 : 0);
            } else {
                this.mCamera.setDisplayOrientation(QRUtils.getInstance().isScreenOriatationPortrait(this.context) ? 270 : 180);
            }
            this.mCamera.setPreviewDisplay(surfaceHolder);
            this.mCamera.setPreviewCallback(previewCallback);
            this.mCamera.startPreview();
        }
    }

    public void stopPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.stopPreview();
            } catch (Exception unused) {
            }
            try {
                this.mCamera.setPreviewDisplay(null);
            } catch (IOException unused2) {
            }
        }
    }

    public void autoFocus(Camera.AutoFocusCallback autoFocusCallback) {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.autoFocus(autoFocusCallback);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setFlash() {
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() != null) {
                if (parameters.getFlashMode().endsWith("torch")) {
                    parameters.setFlashMode("off");
                } else {
                    parameters.setFlashMode("torch");
                }
                this.mCamera.setParameters(parameters);
            }
        }
    }

    public void setFlash(boolean z) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() != null) {
                if (!z) {
                    if (parameters.getFlashMode().endsWith("torch")) {
                        parameters.setFlashMode("off");
                    }
                } else if (parameters.getFlashMode().endsWith("off")) {
                    parameters.setFlashMode("torch");
                }
                this.mCamera.setParameters(parameters);
            }
        }
    }

    public void setCameraZoom(float f) {
        int maxZoom;
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported() && (maxZoom = parameters.getMaxZoom()) != 0) {
                parameters.setZoom((int) (((float) maxZoom) * f));
                this.mCamera.setParameters(parameters);
            }
        }
    }

    public void handleZoom(boolean z) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                int maxZoom = parameters.getMaxZoom();
                int zoom = parameters.getZoom();
                if (z && zoom < maxZoom) {
                    zoom++;
                } else if (zoom > 0) {
                    zoom--;
                }
                parameters.setZoom(zoom);
                this.mCamera.setParameters(parameters);
                return;
            }
            Log.i("CameraManager", "zoom not supported");
        }
    }
}
