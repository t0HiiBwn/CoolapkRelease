package com.coolapk.market.widget.video;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0010H\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0001J\u0011\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014H\u0001J\t\u0010\u0016\u001a\u00020\u0012H\u0001J\u0011\u0010\u0017\u001a\n \u0015*\u0004\u0018\u00010\u00180\u0018H\u0001J4\u0010\u0019\u001a(\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u001b0\u001b \u0015*\u0014\u0012\u000e\b\u0001\u0012\n \u0015*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u001a0\u001aH\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0010H\u0001J\t\u0010\u001e\u001a\u00020\u0010H\u0001J\t\u0010\u001f\u001a\u00020\u0010H\u0001J\t\u0010 \u001a\u00020\u0010H\u0001J\t\u0010!\u001a\u00020\"H\u0001J\t\u0010#\u001a\u00020\"H\u0001J\t\u0010$\u001a\u00020\"H\u0001J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0012H\u0016J\u0010\u0010,\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0010H\u0016Jq\u0010-\u001a\u00020&2\u000e\u0010+\u001a\n \u0015*\u0004\u0018\u00010.0.2\u000e\u0010/\u001a\n \u0015*\u0004\u0018\u000100002F\u00101\u001aB\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u0014\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u0014 \u0015* \u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u0014\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u0014\u0018\u00010302H\u0001J\u001c\u0010-\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u0010-\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010-\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010\u0014H\u0016J\u0019\u0010-\u001a\u00020&2\u000e\u0010+\u001a\n \u0015*\u0004\u0018\u00010505H\u0001J\u0012\u00106\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u000107H\u0016J\u0011\u00108\u001a\u00020&2\u0006\u0010+\u001a\u00020\"H\u0001J\u0011\u00109\u001a\u00020&2\u0006\u0010+\u001a\u00020\"H\u0001J\u0011\u0010:\u001a\u00020&2\u0006\u0010+\u001a\u00020\"H\u0001J\u0012\u0010;\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010=\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010A\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010C\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010E\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010FH\u0016J\u0019\u0010G\u001a\u00020&2\u000e\u0010+\u001a\n \u0015*\u0004\u0018\u00010H0HH\u0001J\u0012\u0010I\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010JH\u0016J\u001e\u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u0012J \u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u00142\b\u0010N\u001a\u0004\u0018\u00010\u0014J\u0011\u0010O\u001a\u00020&2\u0006\u0010+\u001a\u00020\"H\u0001J\u000e\u0010P\u001a\u00020&2\u0006\u0010Q\u001a\u00020RJ\u0012\u0010S\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010TH\u0016J\u0018\u0010U\u001a\u00020&2\u0006\u0010+\u001a\u00020R2\u0006\u0010/\u001a\u00020RH\u0016J!\u0010V\u001a\u00020&2\u000e\u0010+\u001a\n \u0015*\u0004\u0018\u00010.0.2\u0006\u0010/\u001a\u00020\u0010H\u0001J\b\u0010W\u001a\u00020&H\u0016J\b\u0010X\u001a\u00020&H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/coolapk/market/widget/video/IjkWrapMediaPlayer;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "ijkPlayer", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "(Ltv/danmaku/ijk/media/player/IjkMediaPlayer;)V", "forwardListener", "com/coolapk/market/widget/video/IjkWrapMediaPlayer$forwardListener$1", "Lcom/coolapk/market/widget/video/IjkWrapMediaPlayer$forwardListener$1;", "getIjkPlayer", "()Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "ijkThread", "Landroid/os/HandlerThread;", "mainHandler", "Landroid/os/Handler;", "mediaHandler", "getAudioSessionId", "", "getCurrentPosition", "", "getDataSource", "", "kotlin.jvm.PlatformType", "getDuration", "getMediaInfo", "Ltv/danmaku/ijk/media/player/MediaInfo;", "getTrackInfo", "", "Ltv/danmaku/ijk/media/player/misc/ITrackInfo;", "()[Ltv/danmaku/ijk/media/player/misc/ITrackInfo;", "getVideoHeight", "getVideoSarDen", "getVideoSarNum", "getVideoWidth", "isLooping", "", "isPlayable", "isPlaying", "pause", "", "prepareAsync", "release", "reset", "seekTo", "p0", "setAudioStreamType", "setDataSource", "Landroid/content/Context;", "p1", "Landroid/net/Uri;", "p2", "", "", "Ljava/io/FileDescriptor;", "Ltv/danmaku/ijk/media/player/misc/IMediaDataSource;", "setDisplay", "Landroid/view/SurfaceHolder;", "setKeepInBackground", "setLogEnabled", "setLooping", "setOnBufferingUpdateListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "setOnCompletionListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "setOnErrorListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "setOnInfoListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "setOnPreparedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "setOnSeekCompleteListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "setOnTimedTextListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnTimedTextListener;", "setOnVideoSizeChangedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "setOption", "category", "name", "value", "setScreenOnWhilePlaying", "setSpeed", "speed", "", "setSurface", "Landroid/view/Surface;", "setVolume", "setWakeMode", "start", "stop", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IjkWrapMediaPlayer.kt */
public final class IjkWrapMediaPlayer implements IMediaPlayer {
    private final IjkWrapMediaPlayer$forwardListener$1 forwardListener = new IjkWrapMediaPlayer$forwardListener$1(this);
    private final IjkMediaPlayer ijkPlayer;
    private final HandlerThread ijkThread;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Handler mediaHandler;

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.ijkPlayer.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        return this.ijkPlayer.getCurrentPosition();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return this.ijkPlayer.getDataSource();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        return this.ijkPlayer.getDuration();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        return this.ijkPlayer.getMediaInfo();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return this.ijkPlayer.getTrackInfo();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.ijkPlayer.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.ijkPlayer.getVideoSarDen();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.ijkPlayer.getVideoSarNum();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.ijkPlayer.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.ijkPlayer.isLooping();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @Deprecated(message = "Deprecated in Java")
    public boolean isPlayable() {
        return this.ijkPlayer.isPlayable();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        return this.ijkPlayer.isPlaying();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.ijkPlayer.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this.ijkPlayer.setDataSource(iMediaDataSource);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @Deprecated(message = "Deprecated in Java")
    public void setKeepInBackground(boolean z) {
        this.ijkPlayer.setKeepInBackground(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @Deprecated(message = "Deprecated in Java")
    public void setLogEnabled(boolean z) {
        this.ijkPlayer.setLogEnabled(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.ijkPlayer.setLooping(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        this.ijkPlayer.setOnTimedTextListener(onTimedTextListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.ijkPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @Deprecated(message = "Deprecated in Java")
    public void setWakeMode(Context context, int i) {
        this.ijkPlayer.setWakeMode(context, i);
    }

    public IjkWrapMediaPlayer(IjkMediaPlayer ijkMediaPlayer) {
        Intrinsics.checkNotNullParameter(ijkMediaPlayer, "ijkPlayer");
        this.ijkPlayer = ijkMediaPlayer;
        HandlerThread handlerThread = new HandlerThread("IjkWrapMediaPlayer", -19);
        this.ijkThread = handlerThread;
        handlerThread.start();
        this.mediaHandler = new Handler(handlerThread.getLooper());
        ijkMediaPlayer.setOnNativeInvokeListener(AnonymousClass1.INSTANCE);
    }

    public final IjkMediaPlayer getIjkPlayer() {
        return this.ijkPlayer;
    }

    public final void setOption(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.mediaHandler.post(new IjkWrapMediaPlayer$setOption$1(this, i, str, str2));
    }

    public final void setOption(int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.mediaHandler.post(new IjkWrapMediaPlayer$setOption$2(this, i, str, j));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) {
        this.mediaHandler.post(new IjkWrapMediaPlayer$setDataSource$1(this, str));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
        this.mediaHandler.post(new IjkWrapMediaPlayer$setDataSource$2(this, fileDescriptor));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        this.mediaHandler.post(new IjkWrapMediaPlayer$setDataSource$3(this, context, uri));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
        this.ijkPlayer.setAudioStreamType(i);
    }

    public final void setSpeed(float f) {
        this.ijkPlayer.setSpeed(f);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.forwardListener.setOnPreparedListener(onPreparedListener);
        this.ijkPlayer.setOnPreparedListener(this.forwardListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.forwardListener.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        this.ijkPlayer.setOnVideoSizeChangedListener(this.forwardListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.forwardListener.setOnBufferingUpdateListener(onBufferingUpdateListener);
        this.ijkPlayer.setOnBufferingUpdateListener(this.forwardListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.forwardListener.setOnInfoListener(onInfoListener);
        this.ijkPlayer.setOnInfoListener(this.forwardListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.forwardListener.setOnCompletionListener(onCompletionListener);
        this.ijkPlayer.setOnCompletionListener(this.forwardListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.forwardListener.setOnSeekCompleteListener(onSeekCompleteListener);
        this.ijkPlayer.setOnSeekCompleteListener(this.forwardListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.forwardListener.setOnErrorListener(onErrorListener);
        this.ijkPlayer.setOnErrorListener(this.forwardListener);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mediaHandler.post(new IjkWrapMediaPlayer$setDisplay$1(this, surfaceHolder));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() {
        this.mediaHandler.post(new IjkWrapMediaPlayer$start$1(this));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
        this.ijkPlayer.setVolume(f, f2);
        this.mediaHandler.post(new IjkWrapMediaPlayer$setVolume$1(this, f, f2));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() {
        this.mediaHandler.post(new IjkWrapMediaPlayer$prepareAsync$1(this));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.mediaHandler.post(new IjkWrapMediaPlayer$setSurface$1(this, surface));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() {
        this.mediaHandler.post(new IjkWrapMediaPlayer$stop$1(this));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j) {
        this.mediaHandler.post(new IjkWrapMediaPlayer$seekTo$1(this, j));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        this.mediaHandler.post(new IjkWrapMediaPlayer$reset$1(this));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() {
        this.mediaHandler.post(new IjkWrapMediaPlayer$pause$1(this));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.mediaHandler.post(new IjkWrapMediaPlayer$release$1(this));
    }
}
