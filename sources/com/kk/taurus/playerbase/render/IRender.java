package com.kk.taurus.playerbase.render;

import android.view.View;
import com.kk.taurus.playerbase.player.IPlayer;

public interface IRender {
    public static final int RENDER_TYPE_SURFACE_VIEW = 1;
    public static final int RENDER_TYPE_TEXTURE_VIEW = 0;

    public interface IRenderCallback {
        void onSurfaceChanged(IRenderHolder iRenderHolder, int i, int i2, int i3);

        void onSurfaceCreated(IRenderHolder iRenderHolder, int i, int i2);

        void onSurfaceDestroy(IRenderHolder iRenderHolder);
    }

    public interface IRenderHolder {
        void bindPlayer(IPlayer iPlayer);
    }

    View getRenderView();

    void release();

    void setRenderCallback(IRenderCallback iRenderCallback);

    void setVideoRotation(int i);

    void setVideoSampleAspectRatio(int i, int i2);

    void updateAspectRatio(AspectRatio aspectRatio);

    void updateVideoSize(int i, int i2);
}
