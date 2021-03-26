package com.kk.taurus.playerbase.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kk.taurus.playerbase.config.AppContextAttach;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.event.BundlePool;
import com.kk.taurus.playerbase.log.PLog;
import java.io.FileDescriptor;
import java.util.HashMap;

public class SysMediaPlayer extends BaseInternalPlayer {
    private final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    final String TAG = "SysMediaPlayer";
    private long mBandWidth;
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
        /* class com.kk.taurus.playerbase.player.SysMediaPlayer.AnonymousClass7 */

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            SysMediaPlayer.this.submitBufferingUpdate(i, null);
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        /* class com.kk.taurus.playerbase.player.SysMediaPlayer.AnonymousClass3 */

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            SysMediaPlayer.this.updateStatus(6);
            SysMediaPlayer.this.mTargetState = 6;
            SysMediaPlayer.this.submitPlayerEvent(-99016, null);
        }
    };
    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() {
        /* class com.kk.taurus.playerbase.player.SysMediaPlayer.AnonymousClass6 */

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            PLog.d("SysMediaPlayer", "Error: " + i + "," + i2);
            SysMediaPlayer.this.updateStatus(-1);
            SysMediaPlayer.this.mTargetState = -1;
            SysMediaPlayer.this.submitErrorEvent(i != -1010 ? i != -1007 ? i != -1004 ? i != -110 ? i != 1 ? i != 100 ? i != 200 ? -88011 : -88014 : -88013 : -88012 : -88018 : -88015 : -88016 : -88017, BundlePool.obtain());
            return true;
        }
    };
    private MediaPlayer.OnInfoListener mInfoListener = new MediaPlayer.OnInfoListener() {
        /* class com.kk.taurus.playerbase.player.SysMediaPlayer.AnonymousClass4 */

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 3) {
                PLog.d("SysMediaPlayer", "MEDIA_INFO_VIDEO_RENDERING_START");
                SysMediaPlayer.this.startSeekPos = 0;
                SysMediaPlayer.this.submitPlayerEvent(-99015, null);
                return true;
            } else if (i == 901) {
                PLog.d("SysMediaPlayer", "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                SysMediaPlayer.this.submitPlayerEvent(-99029, null);
                return true;
            } else if (i != 902) {
                switch (i) {
                    case 700:
                        PLog.d("SysMediaPlayer", "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case 701:
                        PLog.d("SysMediaPlayer", "MEDIA_INFO_BUFFERING_START:" + i2);
                        Bundle obtain = BundlePool.obtain();
                        obtain.putLong("long_data", SysMediaPlayer.this.mBandWidth);
                        SysMediaPlayer.this.submitPlayerEvent(-99010, obtain);
                        return true;
                    case 702:
                        PLog.d("SysMediaPlayer", "MEDIA_INFO_BUFFERING_END:" + i2);
                        Bundle obtain2 = BundlePool.obtain();
                        obtain2.putLong("long_data", SysMediaPlayer.this.mBandWidth);
                        SysMediaPlayer.this.submitPlayerEvent(-99011, obtain2);
                        return true;
                    case 703:
                        PLog.d("SysMediaPlayer", "band_width : " + i2);
                        SysMediaPlayer.this.mBandWidth = (long) (i2 * 1000);
                        return true;
                    default:
                        switch (i) {
                            case 800:
                                PLog.d("SysMediaPlayer", "MEDIA_INFO_BAD_INTERLEAVING:");
                                SysMediaPlayer.this.submitPlayerEvent(-99025, null);
                                return true;
                            case 801:
                                PLog.d("SysMediaPlayer", "MEDIA_INFO_NOT_SEEKABLE:");
                                SysMediaPlayer.this.submitPlayerEvent(-99026, null);
                                return true;
                            case 802:
                                PLog.d("SysMediaPlayer", "MEDIA_INFO_METADATA_UPDATE:");
                                SysMediaPlayer.this.submitPlayerEvent(-99027, null);
                                return true;
                            default:
                                return true;
                        }
                }
            } else {
                PLog.d("SysMediaPlayer", "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                SysMediaPlayer.this.submitPlayerEvent(-99030, null);
                return true;
            }
        }
    };
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = new MediaPlayer.OnSeekCompleteListener() {
        /* class com.kk.taurus.playerbase.player.SysMediaPlayer.AnonymousClass5 */

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            PLog.d("SysMediaPlayer", "EVENT_CODE_SEEK_COMPLETE");
            SysMediaPlayer.this.submitPlayerEvent(-99014, null);
        }
    };
    MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener() {
        /* class com.kk.taurus.playerbase.player.SysMediaPlayer.AnonymousClass1 */

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            PLog.d("SysMediaPlayer", "onPrepared...");
            SysMediaPlayer.this.updateStatus(2);
            SysMediaPlayer.this.mVideoWidth = mediaPlayer.getVideoWidth();
            SysMediaPlayer.this.mVideoHeight = mediaPlayer.getVideoHeight();
            Bundle obtain = BundlePool.obtain();
            obtain.putInt("int_arg1", SysMediaPlayer.this.mVideoWidth);
            obtain.putInt("int_arg2", SysMediaPlayer.this.mVideoHeight);
            SysMediaPlayer.this.submitPlayerEvent(-99018, obtain);
            int i = SysMediaPlayer.this.startSeekPos;
            if (i != 0) {
                SysMediaPlayer.this.mMediaPlayer.seekTo(i);
                SysMediaPlayer.this.startSeekPos = 0;
            }
            PLog.d("SysMediaPlayer", "mTargetState = " + SysMediaPlayer.this.mTargetState);
            if (SysMediaPlayer.this.mTargetState == 3) {
                SysMediaPlayer.this.start();
            } else if (SysMediaPlayer.this.mTargetState == 4) {
                SysMediaPlayer.this.pause();
            } else if (SysMediaPlayer.this.mTargetState == 5 || SysMediaPlayer.this.mTargetState == 0) {
                SysMediaPlayer.this.reset();
            }
        }
    };
    MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() {
        /* class com.kk.taurus.playerbase.player.SysMediaPlayer.AnonymousClass2 */

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            SysMediaPlayer.this.mVideoWidth = mediaPlayer.getVideoWidth();
            SysMediaPlayer.this.mVideoHeight = mediaPlayer.getVideoHeight();
            Bundle obtain = BundlePool.obtain();
            obtain.putInt("int_arg1", SysMediaPlayer.this.mVideoWidth);
            obtain.putInt("int_arg2", SysMediaPlayer.this.mVideoHeight);
            SysMediaPlayer.this.submitPlayerEvent(-99017, obtain);
        }
    };
    private int mTargetState;
    private int mVideoHeight;
    private int mVideoWidth;
    private int startSeekPos;

    public SysMediaPlayer() {
        init();
    }

    private void init() {
        this.mMediaPlayer = new MediaPlayer();
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setDataSource(DataSource dataSource) {
        try {
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
            } else {
                stop();
                reset();
                resetListener();
            }
            this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
            updateStatus(1);
            String data = dataSource.getData();
            Uri uri = dataSource.getUri();
            HashMap<String, String> extra = dataSource.getExtra();
            FileDescriptor fileDescriptor = dataSource.getFileDescriptor();
            AssetFileDescriptor assetFileDescriptor = dataSource.getAssetFileDescriptor();
            if (data != null) {
                this.mMediaPlayer.setDataSource(data);
            } else if (uri != null) {
                Context applicationContext = AppContextAttach.getApplicationContext();
                if (extra == null) {
                    this.mMediaPlayer.setDataSource(applicationContext, uri);
                } else {
                    this.mMediaPlayer.setDataSource(applicationContext, uri, extra);
                }
            } else if (fileDescriptor != null) {
                this.mMediaPlayer.setDataSource(fileDescriptor);
            } else if (assetFileDescriptor != null && Build.VERSION.SDK_INT >= 24) {
                this.mMediaPlayer.setDataSource(assetFileDescriptor);
            }
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
            this.mMediaPlayer.prepareAsync();
            Bundle obtain = BundlePool.obtain();
            obtain.putSerializable("serializable_data", dataSource);
            submitPlayerEvent(-99001, obtain);
        } catch (Exception e) {
            e.printStackTrace();
            updateStatus(-1);
            this.mTargetState = -1;
        }
    }

    private boolean available() {
        return this.mMediaPlayer != null;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            if (available()) {
                this.mMediaPlayer.setDisplay(surfaceHolder);
                submitPlayerEvent(-99002, null);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setSurface(Surface surface) {
        try {
            if (available()) {
                this.mMediaPlayer.setSurface(surface);
                submitPlayerEvent(-99003, null);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setVolume(float f, float f2) {
        if (available()) {
            this.mMediaPlayer.setVolume(f, f2);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setSpeed(float f) {
        try {
            if (!available() || Build.VERSION.SDK_INT < 23) {
                PLog.e("SysMediaPlayer", "not support play speed setting.");
                return;
            }
            PlaybackParams playbackParams = this.mMediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f);
            this.mMediaPlayer.setPlaybackParams(playbackParams);
            if (f <= 0.0f) {
                pause();
            } else if (f > 0.0f && getState() == 4) {
                resume();
            }
        } catch (Exception unused) {
            PLog.e("SysMediaPlayer", "IllegalStateException， if the internal player engine has not been initialized or has been released.");
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public boolean isPlaying() {
        if (!available() || getState() == -1) {
            return false;
        }
        return this.mMediaPlayer.isPlaying();
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getCurrentPosition() {
        if (!available()) {
            return 0;
        }
        if (getState() == 2 || getState() == 3 || getState() == 4 || getState() == 6) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getDuration() {
        if (!available() || getState() == -1 || getState() == 1 || getState() == 0) {
            return 0;
        }
        return this.mMediaPlayer.getDuration();
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getAudioSessionId() {
        if (available()) {
            return this.mMediaPlayer.getAudioSessionId();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getVideoWidth() {
        if (available()) {
            return this.mMediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getVideoHeight() {
        if (available()) {
            return this.mMediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void start() {
        try {
            if (available() && (getState() == 2 || getState() == 4 || getState() == 6)) {
                this.mMediaPlayer.start();
                updateStatus(3);
                submitPlayerEvent(-99004, null);
            }
        } catch (Exception e) {
            handleException(e);
        }
        this.mTargetState = 3;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void start(int i) {
        if (available()) {
            if (i > 0) {
                this.startSeekPos = i;
            }
            start();
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void pause() {
        try {
            if (available()) {
                this.mMediaPlayer.pause();
                updateStatus(4);
                submitPlayerEvent(-99005, null);
            }
        } catch (Exception e) {
            handleException(e);
        }
        this.mTargetState = 4;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void resume() {
        try {
            if (available() && getState() == 4) {
                this.mMediaPlayer.start();
                updateStatus(3);
                submitPlayerEvent(-99006, null);
            }
        } catch (Exception e) {
            handleException(e);
        }
        this.mTargetState = 3;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void seekTo(int i) {
        if (!available()) {
            return;
        }
        if (getState() == 2 || getState() == 3 || getState() == 4 || getState() == 6) {
            this.mMediaPlayer.seekTo(i);
            Bundle obtain = BundlePool.obtain();
            obtain.putInt("int_data", i);
            submitPlayerEvent(-99013, obtain);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void stop() {
        if (available() && (getState() == 2 || getState() == 3 || getState() == 4 || getState() == 6)) {
            this.mMediaPlayer.stop();
            updateStatus(5);
            submitPlayerEvent(-99007, null);
        }
        this.mTargetState = 5;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void reset() {
        if (available()) {
            this.mMediaPlayer.reset();
            updateStatus(0);
            submitPlayerEvent(-99008, null);
        }
        this.mTargetState = 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void destroy() {
        if (available()) {
            updateStatus(-2);
            resetListener();
            this.mMediaPlayer.release();
            submitPlayerEvent(-99009, null);
        }
    }

    private void handleException(Exception exc) {
        if (exc != null) {
            exc.printStackTrace();
        }
        reset();
    }

    private void resetListener() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(null);
            this.mMediaPlayer.setOnVideoSizeChangedListener(null);
            this.mMediaPlayer.setOnCompletionListener(null);
            this.mMediaPlayer.setOnErrorListener(null);
            this.mMediaPlayer.setOnInfoListener(null);
            this.mMediaPlayer.setOnBufferingUpdateListener(null);
        }
    }
}
