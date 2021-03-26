package com.bytedance.sdk.openadsdk.core.video.d;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: AndroidMediaPlayer */
public class b extends a {
    private final MediaPlayer a;
    private final a b;
    private com.bytedance.sdk.openadsdk.core.video.a.b c;
    private Surface d;
    private final Object e;
    private boolean f;

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
        }
        a(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "setAudioStreamType error: ", th);
        }
        this.b = new a(this);
        n();
    }

    private void a(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 28) {
            try {
                Class<?> cls = Class.forName("android.media.MediaTimeProvider");
                Class<?> cls2 = Class.forName("android.media.SubtitleController");
                Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
                Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(p.a(), null, null);
                Field declaredField = cls2.getDeclaredField("mHandler");
                declaredField.setAccessible(true);
                try {
                    declaredField.set(newInstance, new Handler());
                    declaredField.setAccessible(false);
                    mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
                } catch (Throwable th) {
                    declaredField.setAccessible(false);
                    throw th;
                }
            } catch (Throwable th2) {
                u.c("AndroidMediaPlayer", "setSubtitleController error: ", th2);
            }
        }
    }

    public MediaPlayer e() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.e) {
            if (!this.f) {
                this.a.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(Surface surface) {
        o();
        this.d = surface;
        this.a.setSurface(surface);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(String str) throws Throwable {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.a.setDataSource(str);
        } else {
            this.a.setDataSource(parse.getPath());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(FileDescriptor fileDescriptor) throws Throwable {
        this.a.setDataSource(fileDescriptor);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.i.g.b.a(str);
        }
        com.bytedance.sdk.openadsdk.core.video.a.b a2 = com.bytedance.sdk.openadsdk.core.video.a.a.a(str2);
        this.c = a2;
        if (a2 == null) {
            com.bytedance.sdk.openadsdk.core.video.a.b bVar = new com.bytedance.sdk.openadsdk.core.video.a.b(p.a(), str, str2);
            this.c = bVar;
            if (bVar.a()) {
                com.bytedance.sdk.openadsdk.core.video.a.a.a(str2, this.c);
            }
        }
        this.a.setDataSource(this.c);
    }

    private void m() {
        com.bytedance.sdk.openadsdk.core.video.a.b bVar;
        if (Build.VERSION.SDK_INT >= 23 && (bVar = this.c) != null) {
            try {
                bVar.close();
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "releaseMediaDataSource error: ", th);
            }
            this.c = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void f() throws Throwable {
        this.a.start();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void g() throws Throwable {
        this.a.stop();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void h() throws Throwable {
        this.a.pause();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(boolean z) throws Throwable {
        this.a.setScreenOnWhilePlaying(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(long j) throws Throwable {
        this.a.seekTo((int) j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public long i() {
        try {
            return (long) this.a.getCurrentPosition();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "getCurrentPosition error: ", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public long j() {
        try {
            return (long) this.a.getDuration();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "getDuration error: ", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void k() throws Throwable {
        this.f = true;
        this.a.release();
        o();
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void l() throws Throwable {
        try {
            this.a.reset();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "reset error: ", th);
        }
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void b(boolean z) throws Throwable {
        this.a.setLooping(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(float f2, float f3) throws Throwable {
        this.a.setVolume(f2, f3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(Context context, int i) throws Throwable {
        this.a.setWakeMode(context, i);
    }

    private void n() {
        this.a.setOnPreparedListener(this.b);
        this.a.setOnBufferingUpdateListener(this.b);
        this.a.setOnCompletionListener(this.b);
        this.a.setOnSeekCompleteListener(this.b);
        this.a.setOnVideoSizeChangedListener(this.b);
        this.a.setOnErrorListener(this.b);
        this.a.setOnInfoListener(this.b);
    }

    /* compiled from: AndroidMediaPlayer */
    private class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<b> b;

        public a(b bVar) {
            this.b = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                if (this.b.get() == null || !b.this.b(i, i2)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                if (this.b.get() == null || !b.this.a(i, i2)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                if (this.b.get() != null) {
                    b.this.a(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                if (this.b.get() != null) {
                    b.this.d();
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (this.b.get() != null) {
                    b.this.a(i);
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                if (this.b.get() != null) {
                    b.this.c();
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                if (this.b.get() != null) {
                    b.this.b();
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        o();
    }

    private void o() {
        try {
            Surface surface = this.d;
            if (surface != null) {
                surface.release();
                this.d = null;
            }
        } catch (Throwable unused) {
        }
    }
}
