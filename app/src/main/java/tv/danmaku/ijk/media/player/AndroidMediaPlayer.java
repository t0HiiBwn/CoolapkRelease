package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.AndroidTrackInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public class AndroidMediaPlayer extends AbstractMediaPlayer {
    private static MediaInfo sMediaInfo;
    private String mDataSource;
    private final Object mInitLock;
    private final AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    private final MediaPlayer mInternalMediaPlayer;
    private boolean mIsReleased;
    private MediaDataSource mMediaDataSource;

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    public AndroidMediaPlayer() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.mInitLock = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.mInternalMediaPlayer = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new AndroidMediaPlayerListenerHolder(this);
        attachInternalListeners();
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.mInternalMediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.mInternalMediaPlayer.setDataSource(str);
        } else {
            this.mInternalMediaPlayer.setDataSource(parse.getPath());
        }
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        releaseMediaDataSource();
        MediaDataSourceProxy mediaDataSourceProxy = new MediaDataSourceProxy(iMediaDataSource);
        this.mMediaDataSource = mediaDataSourceProxy;
        this.mInternalMediaPlayer.setDataSource(mediaDataSourceProxy);
    }

    private static class MediaDataSourceProxy extends MediaDataSource {
        private final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
            this.mMediaDataSource = iMediaDataSource;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
            return this.mMediaDataSource.readAt(j, bArr, i, i2);
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return this.mMediaDataSource.getSize();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mMediaDataSource.close();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mMediaDataSource = null;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.mInternalMediaPlayer.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        this.mInternalMediaPlayer.start();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        this.mInternalMediaPlayer.stop();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        this.mInternalMediaPlayer.pause();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j) throws IllegalStateException {
        this.mInternalMediaPlayer.seekTo((int) j);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        try {
            return (long) this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return 0;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        try {
            return (long) this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return 0;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        try {
            this.mInternalMediaPlayer.reset();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.mInternalMediaPlayer.setLooping(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
        this.mInternalMediaPlayer.setVolume(f, f2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo mediaInfo = new MediaInfo();
            mediaInfo.mVideoDecoder = "android";
            mediaInfo.mVideoDecoderImpl = "HW";
            mediaInfo.mAudioDecoder = "android";
            mediaInfo.mAudioDecoderImpl = "HW";
            sMediaInfo = mediaInfo;
        }
        return sMediaInfo;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i) {
        this.mInternalMediaPlayer.setWakeMode(context, i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
        this.mInternalMediaPlayer.setAudioStreamType(i);
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnTimedTextListener(this.mInternalListenerAdapter);
    }

    private class AndroidMediaPlayerListenerHolder implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnTimedTextListener {
        public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;

        public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer androidMediaPlayer) {
            this.mWeakMediaPlayer = new WeakReference<>(androidMediaPlayer);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return this.mWeakMediaPlayer.get() != null && AndroidMediaPlayer.this.notifyOnInfo(i, i2);
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return this.mWeakMediaPlayer.get() != null && AndroidMediaPlayer.this.notifyOnError(i, i2);
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnVideoSizeChanged(i, i2, 1, 1);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnBufferingUpdate(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            if (this.mWeakMediaPlayer.get() != null) {
                IjkTimedText ijkTimedText = null;
                if (timedText != null) {
                    ijkTimedText = new IjkTimedText(timedText.getBounds(), timedText.getText());
                }
                AndroidMediaPlayer.this.notifyOnTimedText(ijkTimedText);
            }
        }
    }
}
