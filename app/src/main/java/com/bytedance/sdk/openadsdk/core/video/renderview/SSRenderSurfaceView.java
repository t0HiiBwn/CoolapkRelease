package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, b {
    private static final ArrayList<c> c = new ArrayList<>();
    private WeakReference<a> a;
    private c b;
    private b.a d;

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public View getView() {
        return this;
    }

    public SSRenderSurfaceView(Context context) {
        super(context);
        a();
    }

    private void a() {
        c cVar = new c(this);
        this.b = cVar;
        c.add(cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(a aVar) {
        this.a = new WeakReference<>(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<c> it2 = c.iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            if (next.a() == null) {
                holder.removeCallback(next);
                it2.remove();
            }
        }
        holder.addCallback(this.b);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().a(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        WeakReference<a> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().a(surfaceHolder, i, i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().b(surfaceHolder);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.SSSurfaceView, android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b.a aVar = this.d;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.d = aVar;
    }
}
