package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;

/* compiled from: AbstractMediaPlayer */
public abstract class a implements c {
    private c.e a;
    private c.b b;
    private c.a c;
    private c.f d;
    private c.g e;
    private c.AbstractC0044c f;
    private c.d g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.d = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.AbstractC0044c cVar) {
        this.f = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.e = gVar;
    }

    public void a() {
        this.a = null;
        this.c = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    protected final void b() {
        try {
            c.e eVar = this.a;
            if (eVar != null) {
                eVar.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    protected final void c() {
        try {
            c.b bVar = this.b;
            if (bVar != null) {
                bVar.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    protected final void a(int i) {
        try {
            c.a aVar = this.c;
            if (aVar != null) {
                aVar.a(this, i);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    protected final void d() {
        try {
            c.f fVar = this.d;
            if (fVar != null) {
                fVar.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    protected final void a(int i, int i2, int i3, int i4) {
        try {
            c.g gVar = this.e;
            if (gVar != null) {
                gVar.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    protected final boolean a(int i, int i2) {
        try {
            c.AbstractC0044c cVar = this.f;
            return cVar != null && cVar.a(this, i, i2);
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    protected final boolean b(int i, int i2) {
        try {
            c.d dVar = this.g;
            return dVar != null && dVar.b(this, i, i2);
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }
}
