package com.coolapk.market.widget.video;

import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007J\u001a\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\"\u00102\u001a\u0002032\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00104\u001a\u000200H\u0016J\"\u00105\u001a\u0002032\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00104\u001a\u000200H\u0016J\u0012\u00106\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00107\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J2\u00108\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00104\u001a\u0002002\u0006\u00109\u001a\u0002002\u0006\u0010:\u001a\u000200H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006;"}, d2 = {"com/coolapk/market/widget/video/IjkWrapMediaPlayer$forwardListener$1", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "onBufferingUpdateListener", "getOnBufferingUpdateListener", "()Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "setOnBufferingUpdateListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;)V", "onCompletionListener", "getOnCompletionListener", "()Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "setOnCompletionListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;)V", "onErrorListener", "getOnErrorListener", "()Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "setOnErrorListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;)V", "onInfoListener", "getOnInfoListener", "()Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "setOnInfoListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;)V", "onPreparedListener", "getOnPreparedListener", "()Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "setOnPreparedListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;)V", "onSeekCompleteListener", "getOnSeekCompleteListener", "()Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "setOnSeekCompleteListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;)V", "onVideoSizeChangedListener", "getOnVideoSizeChangedListener", "()Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "setOnVideoSizeChangedListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;)V", "onBufferingUpdate", "", "p0", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "p1", "", "onCompletion", "onError", "", "p2", "onInfo", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "p3", "p4", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IjkWrapMediaPlayer.kt */
public final class IjkWrapMediaPlayer$forwardListener$1 implements IMediaPlayer.OnPreparedListener, IMediaPlayer.OnVideoSizeChangedListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnBufferingUpdateListener {
    private IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
    private IMediaPlayer.OnCompletionListener onCompletionListener;
    private IMediaPlayer.OnErrorListener onErrorListener;
    private IMediaPlayer.OnInfoListener onInfoListener;
    private IMediaPlayer.OnPreparedListener onPreparedListener;
    private IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
    private IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
    final /* synthetic */ IjkWrapMediaPlayer this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    IjkWrapMediaPlayer$forwardListener$1(IjkWrapMediaPlayer ijkWrapMediaPlayer) {
        this.this$0 = ijkWrapMediaPlayer;
    }

    public final IMediaPlayer.OnPreparedListener getOnPreparedListener() {
        return this.onPreparedListener;
    }

    public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener2) {
        this.onPreparedListener = onPreparedListener2;
    }

    public final IMediaPlayer.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        return this.onVideoSizeChangedListener;
    }

    public final void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener2) {
        this.onVideoSizeChangedListener = onVideoSizeChangedListener2;
    }

    public final IMediaPlayer.OnCompletionListener getOnCompletionListener() {
        return this.onCompletionListener;
    }

    public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener2) {
        this.onCompletionListener = onCompletionListener2;
    }

    public final IMediaPlayer.OnInfoListener getOnInfoListener() {
        return this.onInfoListener;
    }

    public final void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener2) {
        this.onInfoListener = onInfoListener2;
    }

    public final IMediaPlayer.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.onSeekCompleteListener;
    }

    public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener2) {
        this.onSeekCompleteListener = onSeekCompleteListener2;
    }

    public final IMediaPlayer.OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public final IMediaPlayer.OnBufferingUpdateListener getOnBufferingUpdateListener() {
        return this.onBufferingUpdateListener;
    }

    public final void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener2) {
        this.onBufferingUpdateListener = onBufferingUpdateListener2;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
        this.this$0.mainHandler.post(new IjkWrapMediaPlayer$forwardListener$1$onInfo$1(this, iMediaPlayer, i, i2));
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(IMediaPlayer iMediaPlayer) {
        this.this$0.mainHandler.post(new IjkWrapMediaPlayer$forwardListener$1$onSeekComplete$1(this, iMediaPlayer));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
        this.this$0.mainHandler.post(new IjkWrapMediaPlayer$forwardListener$1$onError$1(this, iMediaPlayer, i, i2));
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
        this.this$0.mainHandler.post(new IjkWrapMediaPlayer$forwardListener$1$onBufferingUpdate$1(this, iMediaPlayer, i));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        this.this$0.mainHandler.post(new IjkWrapMediaPlayer$forwardListener$1$onPrepared$1(this, iMediaPlayer));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
        this.this$0.mainHandler.post(new IjkWrapMediaPlayer$forwardListener$1$onVideoSizeChanged$1(this, iMediaPlayer, i, i2, i3, i4));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        this.this$0.mainHandler.post(new IjkWrapMediaPlayer$forwardListener$1$onCompletion$1(this, iMediaPlayer));
    }
}
