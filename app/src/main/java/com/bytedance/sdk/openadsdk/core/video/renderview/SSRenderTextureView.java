package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;

public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, b {
    private a a;
    private b.a b;

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public View getView() {
        return this;
    }

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(a aVar) {
        this.a = aVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a aVar = this.a;
        return aVar != null && aVar.a(surfaceTexture);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(surfaceTexture);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b.a aVar = this.b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.b = aVar;
    }
}
