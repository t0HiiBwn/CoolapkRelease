package com.bytedance.sdk.openadsdk.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;

/* compiled from: VolumeChangeObserver */
public class g {
    private int a = -1;
    private f b;
    private a c;
    private Context d;
    private AudioManager e;
    private boolean f = false;
    private boolean g = false;
    private int h = -1;

    public g(Context context) {
        this.d = context;
        this.e = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public int b() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    public boolean c() {
        if (!this.g) {
            return false;
        }
        this.g = false;
        return true;
    }

    public int d() {
        try {
            AudioManager audioManager = this.e;
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return 15;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "getMaxMusicVolumeError: ", th);
            return 15;
        }
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        if (this.e != null) {
            int i = 0;
            if (z) {
                int g2 = g();
                if (g2 != 0) {
                    this.a = g2;
                }
                u.b("VolumeChangeObserver", "mute set volume to 0");
                this.e.setStreamVolume(3, 0, 0);
                this.g = true;
                return;
            }
            int i2 = this.a;
            if (i2 == 0) {
                i2 = d() / 15;
            } else {
                if (i2 == -1) {
                    if (z2) {
                        i2 = d() / 15;
                    } else {
                        return;
                    }
                }
                u.b("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.a);
                this.a = -1;
                this.e.setStreamVolume(3, i2, i);
                this.g = true;
            }
            i = 1;
            u.b("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.a);
            this.a = -1;
            this.e.setStreamVolume(3, i2, i);
            this.g = true;
        }
    }

    public void a(f fVar) {
        this.b = fVar;
    }

    public void e() {
        try {
            this.c = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.d.registerReceiver(this.c, intentFilter);
            this.f = true;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    public void f() {
        if (this.f) {
            try {
                this.d.unregisterReceiver(this.c);
                this.b = null;
                this.f = false;
            } catch (Throwable th) {
                u.a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public int g() {
        try {
            AudioManager audioManager = this.e;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    public f h() {
        return this.b;
    }

    /* compiled from: VolumeChangeObserver */
    private static class a extends BroadcastReceiver {
        private WeakReference<g> a;

        public a(g gVar) {
            this.a = new WeakReference<>(gVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f h;
            int g;
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    u.b("VolumeChangeObserver", "媒体音量改变通.......");
                    g gVar = this.a.get();
                    if (gVar != null && (h = gVar.h()) != null && (g = gVar.g()) != gVar.a()) {
                        gVar.a(g);
                        if (g >= 0) {
                            h.c(g);
                        }
                    }
                }
            } catch (Throwable th) {
                u.a("VolumeChangeObserver", "onVolumeChangedError: ", th);
            }
        }
    }
}
