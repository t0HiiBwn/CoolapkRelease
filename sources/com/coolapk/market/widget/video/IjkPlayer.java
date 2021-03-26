package com.coolapk.market.widget.video;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.StringUtils;
import com.kk.taurus.playerbase.config.AppContextAttach;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.event.BundlePool;
import com.kk.taurus.playerbase.player.BaseInternalPlayer;
import java.io.File;
import java.io.FileDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001bH\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0014H\u0016J\u0012\u0010+\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0016J\u0012\u00104\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0018\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u0002032\u0006\u00109\u001a\u000203H\u0016J\b\u0010:\u001a\u00020\u001bH\u0016J\u0010\u0010:\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0014H\u0016J\b\u0010;\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/coolapk/market/widget/video/IjkPlayer;", "Lcom/kk/taurus/playerbase/player/BaseInternalPlayer;", "()V", "mediaPlayer", "Lcom/coolapk/market/widget/video/IjkWrapMediaPlayer;", "onBufferingUpdateListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "onCompletionListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "onErrorListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "onInfoListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "onPreparedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "onSeekCompleteListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "onVideoSizeChangedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "startSeekPos", "", "targetState", "videoHeight", "videoWidth", "available", "", "destroy", "", "getAudioSessionId", "getCurrentPosition", "getDuration", "getVideoHeight", "getVideoWidth", "isPlaying", "openVideo", "dataSource", "Lcom/kk/taurus/playerbase/entity/DataSource;", "pause", "reset", "resetListener", "resume", "seekTo", "msc", "setDataSource", "data", "setDisplay", "surfaceHolder", "Landroid/view/SurfaceHolder;", "setInitOptions", "setSpeed", "speed", "", "setSurface", "surface", "Landroid/view/Surface;", "setVolume", "leftVolume", "rightVolume", "start", "stop", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IjkPlayer.kt */
public final class IjkPlayer extends BaseInternalPlayer {
    public static final String CACHA_PROTOCOL = "";
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "IjkPlayer";
    private final IjkWrapMediaPlayer mediaPlayer = new IjkWrapMediaPlayer(new IjkMediaPlayer());
    private final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = new IjkPlayer$onBufferingUpdateListener$1(this);
    private final IMediaPlayer.OnCompletionListener onCompletionListener = new IjkPlayer$onCompletionListener$1(this);
    private final IMediaPlayer.OnErrorListener onErrorListener = new IjkPlayer$onErrorListener$1(this);
    private final IMediaPlayer.OnInfoListener onInfoListener = new IjkPlayer$onInfoListener$1(this);
    private IMediaPlayer.OnPreparedListener onPreparedListener = new IjkPlayer$onPreparedListener$1(this);
    private final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = new IjkPlayer$onSeekCompleteListener$1(this);
    private IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = new IjkPlayer$onVideoSizeChangedListener$1(this);
    private int startSeekPos;
    private int targetState;
    private int videoHeight;
    private int videoWidth;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/video/IjkPlayer$Companion;", "", "()V", "CACHA_PROTOCOL", "", "TAG", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IjkPlayer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
    }

    private final void setInitOptions(DataSource dataSource) {
        String str;
        IjkWrapMediaPlayer ijkWrapMediaPlayer = this.mediaPlayer;
        ijkWrapMediaPlayer.setOption(4, "mediacodec", 1);
        ijkWrapMediaPlayer.setOption(4, "enable-accurate-seek", 1);
        ijkWrapMediaPlayer.setOption(4, "mediacodec-auto-rotate", 1);
        ijkWrapMediaPlayer.setOption(4, "framedrop", 5);
        ijkWrapMediaPlayer.setOption(4, "start-on-prepared", 0);
        ijkWrapMediaPlayer.setOption(4, "soundtouch", 1);
        ijkWrapMediaPlayer.setOption(1, "timeout", 8000);
        ijkWrapMediaPlayer.setOption(1, "reconnect", 1);
        ijkWrapMediaPlayer.setOption(1, "http-detect-range-support", 0);
        ijkWrapMediaPlayer.setOption(2, "skip_loop_filter", 48);
        ijkWrapMediaPlayer.setOption(1, "analyzeduration", 1);
        ijkWrapMediaPlayer.setOption(1, "protocol_whitelist", "rtsp,rtmp,concat,ffconcat,file,subfile,http,https,tls,rtp,tcp,udp,crypto,ijkio,cache,ffio");
        ijkWrapMediaPlayer.setOption(1, "safe", 0);
        ijkWrapMediaPlayer.setOption(1, "dns_cache_clear", 1);
        ijkWrapMediaPlayer.setOption(4, "packet-buffering", 0);
        ijkWrapMediaPlayer.setOption(4, "reconnect", 2);
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> extra = dataSource.getExtra();
        HashMap<String, String> emptyMap = extra != null ? extra : Collections.emptyMap();
        Intrinsics.checkNotNullExpressionValue(emptyMap, "dataSource.extra ?: Coll…mptyMap<String, String>()");
        for (Map.Entry entry : emptyMap.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append(": ");
            sb.append((String) entry.getValue());
            sb.append("\r\n");
        }
        ijkWrapMediaPlayer.setOption(1, "headers", sb.toString());
        if (dataSource.getUri() != null) {
            String uri = dataSource.getUri().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "dataSource.uri.toString()");
            str = StringsKt.replace$default(uri, "", "", false, 4, (Object) null);
        } else {
            str = "";
        }
        boolean z = false;
        if (!(dataSource.isLive() || StringsKt.startsWith$default(str, "rtmp", false, 2, null) || StringsKt.startsWith$default(str, "rtsp", false, 2, null) || StringsKt.startsWith$default(str, "tcp", false, 2, null) || StringsKt.startsWith$default(str, "udp", false, 2, null) || StringsKt.startsWith$default(str, "rtp", false, 2, null) || StringsKt.contains$default(str, ".m3u8", false, 2, null))) {
            if (str.length() > 0) {
                z = true;
            }
            if (z) {
                dataSource.setUri(Uri.parse(String.valueOf(str)));
                VideoManager videoManager = VideoManager.INSTANCE;
                Application application = AppHolder.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
                File videoCacheDir = videoManager.getVideoCacheDir(application);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(StringUtils.toMd5(str + "file"));
                sb2.append(".file");
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(StringUtils.toMd5(str + "map"));
                sb4.append(".map");
                String sb5 = sb4.toString();
                ijkWrapMediaPlayer.setOption(1, "cache_file_path", new File(videoCacheDir, sb3).getAbsolutePath());
                ijkWrapMediaPlayer.setOption(1, "cache_map_path", new File(videoCacheDir, sb5).getAbsolutePath());
                ijkWrapMediaPlayer.setOption(1, "parse_cache_map", 1);
                ijkWrapMediaPlayer.setOption(1, "auto_save_map", 1);
                Log.d("IjkPlayer", "uri : " + dataSource.getUri() + ", cacheName : " + sb3 + ", mapName: " + sb5);
            }
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setDataSource(DataSource dataSource) {
        if (dataSource != null) {
            openVideo(dataSource);
        }
    }

    private final void openVideo(DataSource dataSource) {
        try {
            stop();
            reset();
            resetListener();
            setInitOptions(dataSource);
            this.mediaPlayer.setOnPreparedListener(this.onPreparedListener);
            this.mediaPlayer.setOnVideoSizeChangedListener(this.onVideoSizeChangedListener);
            this.mediaPlayer.setOnCompletionListener(this.onCompletionListener);
            this.mediaPlayer.setOnErrorListener(this.onErrorListener);
            this.mediaPlayer.setOnInfoListener(this.onInfoListener);
            this.mediaPlayer.setOnSeekCompleteListener(this.onSeekCompleteListener);
            this.mediaPlayer.setOnBufferingUpdateListener(this.onBufferingUpdateListener);
            updateStatus(1);
            String data = dataSource.getData();
            Uri uri = dataSource.getUri();
            FileDescriptor fileDescriptor = dataSource.getFileDescriptor();
            if (data != null) {
                this.mediaPlayer.setDataSource(data);
            } else if (uri != null) {
                this.mediaPlayer.setDataSource(AppContextAttach.getApplicationContext(), uri);
            } else if (fileDescriptor != null) {
                this.mediaPlayer.setDataSource(fileDescriptor);
            }
            this.mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setScreenOnWhilePlaying(true);
            this.mediaPlayer.prepareAsync();
            Bundle obtain = BundlePool.obtain();
            obtain.putSerializable("serializable_data", dataSource);
            submitPlayerEvent(-99001, obtain);
        } catch (Exception e) {
            e.printStackTrace();
            updateStatus(-1);
            this.targetState = -1;
            submitErrorEvent(-88011, null);
        }
    }

    private final boolean available() {
        return this.mediaPlayer != null;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void start() {
        if (available() && (getState() == 2 || getState() == 4 || getState() == 6)) {
            this.mediaPlayer.start();
            updateStatus(3);
            submitPlayerEvent(-99004, null);
        }
        this.targetState = 3;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void start(int i) {
        if (i > 0) {
            this.startSeekPos = i;
        }
        if (available()) {
            start();
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void pause() {
        try {
            if (available()) {
                this.mediaPlayer.pause();
                updateStatus(4);
                submitPlayerEvent(-99005, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.targetState = 4;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void resume() {
        try {
            if (available() && getState() == 4) {
                this.mediaPlayer.start();
                updateStatus(3);
                submitPlayerEvent(-99006, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.targetState = 3;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void seekTo(int i) {
        if (!available()) {
            return;
        }
        if (getState() == 2 || getState() == 3 || getState() == 4 || getState() == 6) {
            this.mediaPlayer.seekTo((long) i);
            Bundle obtain = BundlePool.obtain();
            obtain.putInt("int_data", i);
            submitPlayerEvent(-99013, obtain);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void stop() {
        if (available() && (getState() == 2 || getState() == 3 || getState() == 4 || getState() == 6)) {
            this.mediaPlayer.stop();
            updateStatus(5);
            submitPlayerEvent(-99007, null);
        }
        this.targetState = 5;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void reset() {
        if (available() && this.targetState != 0) {
            this.mediaPlayer.reset();
            updateStatus(0);
            submitPlayerEvent(-99008, null);
        }
        this.targetState = 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public boolean isPlaying() {
        return available() && getState() != -1 && this.mediaPlayer.isPlaying();
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getCurrentPosition() {
        if (!available() || (getState() != 2 && getState() != 3 && getState() != 4 && getState() != 6)) {
            return 0;
        }
        return (int) this.mediaPlayer.getCurrentPosition();
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getDuration() {
        if (!available() || getState() == -1 || getState() == 1 || getState() == 0) {
            return 0;
        }
        return (int) this.mediaPlayer.getDuration();
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getVideoWidth() {
        if (available()) {
            return this.mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getVideoHeight() {
        if (available()) {
            return this.mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void destroy() {
        if (available()) {
            updateStatus(-2);
            resetListener();
            this.mediaPlayer.release();
            submitPlayerEvent(-99009, null);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            if (available()) {
                this.mediaPlayer.setDisplay(surfaceHolder);
                submitPlayerEvent(-99002, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setSurface(Surface surface) {
        try {
            if (available()) {
                this.mediaPlayer.setSurface(surface);
                submitPlayerEvent(-99003, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setVolume(float f, float f2) {
        if (available()) {
            this.mediaPlayer.setVolume(f, f2);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setSpeed(float f) {
        if (available()) {
            this.mediaPlayer.setSpeed(f);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getAudioSessionId() {
        if (available()) {
            return this.mediaPlayer.getAudioSessionId();
        }
        return 0;
    }

    private final void resetListener() {
        this.mediaPlayer.setOnPreparedListener(null);
        this.mediaPlayer.setOnVideoSizeChangedListener(null);
        this.mediaPlayer.setOnCompletionListener(null);
        this.mediaPlayer.setOnErrorListener(null);
        this.mediaPlayer.setOnInfoListener(null);
        this.mediaPlayer.setOnBufferingUpdateListener(null);
    }
}
