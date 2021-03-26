package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Rect;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.misc.IAndroidIO;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public final class IjkMediaPlayer extends AbstractMediaPlayer {
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    public static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    public static final int FFP_PROP_INT64_BIT_RATE = 20100;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES = 20208;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS = 20206;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS = 20207;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS = 20205;
    public static final int FFP_PROP_INT64_IMMEDIATE_RECONNECT = 20211;
    public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    public static final int FFP_PROP_INT64_LOGICAL_FILE_SIZE = 20209;
    public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
    public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    public static final int FFP_PROP_INT64_SHARE_CACHE_DATA = 20210;
    public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    protected static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    public static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    private static final String TAG = "tv.danmaku.ijk.media.player.IjkMediaPlayer";
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;
    private static final IjkLibLoader sLocalLibLoader = new IjkLibLoader() {
        /* class tv.danmaku.ijk.media.player.IjkMediaPlayer.AnonymousClass1 */

        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public void loadLibrary(String str) throws UnsatisfiedLinkError, SecurityException {
            System.loadLibrary(str);
        }
    };
    private String mDataSource;
    private EventHandler mEventHandler;
    private int mListenerContext;
    private long mNativeAndroidIO;
    private long mNativeMediaDataSource;
    private long mNativeMediaPlayer;
    private int mNativeSurfaceTexture;
    private OnControlMessageListener mOnControlMessageListener;
    private OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private PowerManager.WakeLock mWakeLock;

    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i);
    }

    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    public interface OnNativeInvokeListener {
        public static final String ARG_ERROR = "error";
        public static final String ARG_FAMILIY = "family";
        public static final String ARG_FD = "fd";
        public static final String ARG_FILE_SIZE = "file_size";
        public static final String ARG_HTTP_CODE = "http_code";
        public static final String ARG_IP = "ip";
        public static final String ARG_OFFSET = "offset";
        public static final String ARG_PORT = "port";
        public static final String ARG_RETRY_COUNTER = "retry_counter";
        public static final String ARG_SEGMENT_INDEX = "segment_index";
        public static final String ARG_URL = "url";
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_DID_HTTP_SEEK = 4;
        public static final int EVENT_WILL_HTTP_OPEN = 1;
        public static final int EVENT_WILL_HTTP_SEEK = 3;

        boolean onNativeInvoke(int i, Bundle bundle);
    }

    private native String _getAudioCodecInfo();

    private static native String _getColorFormatName(int i);

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i, float f);

    private native long _getPropertyLong(int i, long j);

    private native String _getVideoCodecInfo();

    private native void _pause() throws IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSourceFd(int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setFrameAtTime(String str, long j, long j2, int i, int i2) throws IllegalArgumentException, IllegalStateException;

    private native void _setLoopCount(int i);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setPropertyFloat(int i, float f);

    private native void _setPropertyLong(int i, long j);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setVideoSurface(Surface surface);

    private native void _start() throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i);

    private native void native_setup(Object obj);

    public native void _prepareAsync() throws IllegalStateException;

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native int getAudioSessionId();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native long getCurrentPosition();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native long getDuration();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native boolean isPlaying();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native void seekTo(long j) throws IllegalStateException;

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native void setVolume(float f, float f2);

    public static void loadLibrariesOnce(IjkLibLoader ijkLibLoader) {
        synchronized (IjkMediaPlayer.class) {
            if (!mIsLibLoaded) {
                if (ijkLibLoader == null) {
                    ijkLibLoader = sLocalLibLoader;
                }
                ijkLibLoader.loadLibrary("ijkffmpeg");
                ijkLibLoader.loadLibrary("ijksdl");
                ijkLibLoader.loadLibrary("ijkplayer");
                mIsLibLoaded = true;
            }
        }
    }

    private static void initNativeOnce() {
        synchronized (IjkMediaPlayer.class) {
            if (!mIsNativeInitialized) {
                native_init();
                mIsNativeInitialized = true;
            }
        }
    }

    public IjkMediaPlayer() {
        this(sLocalLibLoader);
    }

    public IjkMediaPlayer(IjkLibLoader ijkLibLoader) {
        this.mWakeLock = null;
        initPlayer(ijkLibLoader);
    }

    private void initPlayer(IjkLibLoader ijkLibLoader) {
        loadLibrariesOnce(ijkLibLoader);
        initNativeOnce();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new WeakReference(this));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007e, code lost:
        if (0 == 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        if (0 == 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0084, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
        android.util.Log.d(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Couldn't open file on client side, trying server side");
        setDataSource(r9.toString(), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0095, code lost:
        return;
     */
    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            setDataSource(uri.getPath());
        } else if (!"content".equals(scheme) || !"settings".equals(uri.getAuthority()) || (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) != null) {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
                if (openAssetFileDescriptor != null) {
                    if (openAssetFileDescriptor.getDeclaredLength() < 0) {
                        setDataSource(openAssetFileDescriptor.getFileDescriptor());
                    } else {
                        setDataSource(openAssetFileDescriptor.getFileDescriptor(), openAssetFileDescriptor.getStartOffset(), openAssetFileDescriptor.getDeclaredLength());
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                } else if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
            } catch (SecurityException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th) {
                if (0 != 0) {
                    assetFileDescriptor.close();
                }
                throw th;
            }
        } else {
            throw new FileNotFoundException("Failed to resolve default ringtone");
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        _setDataSource(str, null, null);
    }

    public void setDataSource(String str, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                if (!TextUtils.isEmpty(entry.getValue())) {
                    sb.append(entry.getValue());
                }
                sb.append("\r\n");
                setOption(1, "headers", sb.toString());
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
            }
        }
        setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        if (Build.VERSION.SDK_INT < 12) {
            try {
                Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                _setDataSourceFd(declaredField.getInt(fileDescriptor));
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
            try {
                _setDataSourceFd(dup.getFd());
            } finally {
                dup.close();
            }
        }
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException, IllegalArgumentException, IllegalStateException {
        setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setDataSource(iMediaDataSource);
    }

    public void setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setAndroidIOCallback(iAndroidIO);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        _prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        stayAwake(true);
        _start();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.mWakeLock.release();
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, IjkMediaPlayer.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    /* access modifiers changed from: private */
    public void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public IjkTrackInfo[] getTrackInfo() {
        IjkMediaMeta parse;
        Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (parse = IjkMediaMeta.parse(mediaMeta)) == null || parse.mStreams == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<IjkMediaMeta.IjkStreamMeta> it2 = parse.mStreams.iterator();
        while (it2.hasNext()) {
            IjkMediaMeta.IjkStreamMeta next = it2.next();
            IjkTrackInfo ijkTrackInfo = new IjkTrackInfo(next);
            if (next.mType.equalsIgnoreCase("video")) {
                ijkTrackInfo.setTrackType(1);
            } else if (next.mType.equalsIgnoreCase("audio")) {
                ijkTrackInfo.setTrackType(2);
            } else if (next.mType.equalsIgnoreCase("timedtext")) {
                ijkTrackInfo.setTrackType(3);
            }
            arrayList.add(ijkTrackInfo);
        }
        return (IjkTrackInfo[]) arrayList.toArray(new IjkTrackInfo[arrayList.size()]);
    }

    public int getSelectedTrack(int i) {
        long _getPropertyLong;
        if (i == 1) {
            _getPropertyLong = _getPropertyLong(20001, -1);
        } else if (i == 2) {
            _getPropertyLong = _getPropertyLong(20002, -1);
        } else if (i != 3) {
            return -1;
        } else {
            _getPropertyLong = _getPropertyLong(20011, -1);
        }
        return (int) _getPropertyLong;
    }

    public void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    public void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        resetListeners();
        _release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        stayAwake(false);
        _reset();
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        int i = !z ? 1 : 0;
        setOption(4, "loop", (long) i);
        _setLoopCount(i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return _getLoopCount() != 1;
    }

    public void setSpeed(float f) {
        _setPropertyFloat(10003, f);
    }

    public float getSpeed(float f) {
        return _getPropertyFloat(10003, 0.0f);
    }

    public int getVideoDecoder() {
        return (int) _getPropertyLong(20003, 0);
    }

    public float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    public float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    public long getVideoCachedDuration() {
        return _getPropertyLong(20005, 0);
    }

    public long getAudioCachedDuration() {
        return _getPropertyLong(20006, 0);
    }

    public long getVideoCachedBytes() {
        return _getPropertyLong(20007, 0);
    }

    public long getAudioCachedBytes() {
        return _getPropertyLong(20008, 0);
    }

    public long getVideoCachedPackets() {
        return _getPropertyLong(20009, 0);
    }

    public long getAudioCachedPackets() {
        return _getPropertyLong(20010, 0);
    }

    public long getAsyncStatisticBufBackwards() {
        return _getPropertyLong(20201, 0);
    }

    public long getAsyncStatisticBufForwards() {
        return _getPropertyLong(20202, 0);
    }

    public long getAsyncStatisticBufCapacity() {
        return _getPropertyLong(20203, 0);
    }

    public long getTrafficStatisticByteCount() {
        return _getPropertyLong(20204, 0);
    }

    public long getCacheStatisticPhysicalPos() {
        return _getPropertyLong(20205, 0);
    }

    public long getCacheStatisticFileForwards() {
        return _getPropertyLong(20206, 0);
    }

    public long getCacheStatisticFilePos() {
        return _getPropertyLong(20207, 0);
    }

    public long getCacheStatisticCountBytes() {
        return _getPropertyLong(20208, 0);
    }

    public long getFileSize() {
        return _getPropertyLong(20209, 0);
    }

    public long getBitRate() {
        return _getPropertyLong(20100, 0);
    }

    public long getTcpSpeed() {
        return _getPropertyLong(20200, 0);
    }

    public long getSeekLoadDuration() {
        return _getPropertyLong(20300, 0);
    }

    public float getDropFrameRate() {
        return _getPropertyFloat(10007, 0.0f);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "ijkplayer";
        String _getVideoCodecInfo = _getVideoCodecInfo();
        if (!TextUtils.isEmpty(_getVideoCodecInfo)) {
            String[] split = _getVideoCodecInfo.split(",");
            if (split.length >= 2) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = split[1];
            } else if (split.length >= 1) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        String _getAudioCodecInfo = _getAudioCodecInfo();
        if (!TextUtils.isEmpty(_getAudioCodecInfo)) {
            String[] split2 = _getAudioCodecInfo.split(",");
            if (split2.length >= 2) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = split2[1];
            } else if (split2.length >= 1) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = IjkMediaMeta.parse(_getMediaMeta());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mediaInfo;
    }

    public void setOption(int i, String str, String str2) {
        _setOption(i, str, str2);
    }

    public void setOption(int i, String str, long j) {
        _setOption(i, str, j);
    }

    public Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    public static String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
    }

    public void httphookReconnect() {
        _setPropertyLong(20211, 1);
    }

    public void setCacheShare(int i) {
        _setPropertyLong(20210, (long) i);
    }

    private static class EventHandler extends Handler {
        private final WeakReference<IjkMediaPlayer> mWeakPlayer;

        public EventHandler(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IjkMediaPlayer ijkMediaPlayer = this.mWeakPlayer.get();
            if (ijkMediaPlayer != null) {
                long j = 0;
                if (ijkMediaPlayer.mNativeMediaPlayer != 0) {
                    int i = message.what;
                    if (i == 0) {
                        return;
                    }
                    if (i == 1) {
                        ijkMediaPlayer.notifyOnPrepared();
                        return;
                    } else if (i == 2) {
                        ijkMediaPlayer.stayAwake(false);
                        ijkMediaPlayer.notifyOnCompletion();
                        return;
                    } else if (i == 3) {
                        long j2 = (long) message.arg1;
                        if (j2 < 0) {
                            j2 = 0;
                        }
                        long duration = ijkMediaPlayer.getDuration();
                        long j3 = 100;
                        if (duration > 0) {
                            j = (j2 * 100) / duration;
                        }
                        if (j < 100) {
                            j3 = j;
                        }
                        ijkMediaPlayer.notifyOnBufferingUpdate((int) j3);
                        return;
                    } else if (i == 4) {
                        ijkMediaPlayer.notifyOnSeekComplete();
                        return;
                    } else if (i == 5) {
                        ijkMediaPlayer.mVideoWidth = message.arg1;
                        ijkMediaPlayer.mVideoHeight = message.arg2;
                        ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                        return;
                    } else if (i != 99) {
                        if (i == 100) {
                            DebugLog.e(IjkMediaPlayer.TAG, "Error (" + message.arg1 + "," + message.arg2 + ")");
                            if (!ijkMediaPlayer.notifyOnError(message.arg1, message.arg2)) {
                                ijkMediaPlayer.notifyOnCompletion();
                            }
                            ijkMediaPlayer.stayAwake(false);
                            return;
                        } else if (i == 200) {
                            if (message.arg1 == 3) {
                                DebugLog.i(IjkMediaPlayer.TAG, "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                            }
                            ijkMediaPlayer.notifyOnInfo(message.arg1, message.arg2);
                            return;
                        } else if (i != 10001) {
                            DebugLog.e(IjkMediaPlayer.TAG, "Unknown message type " + message.what);
                            return;
                        } else {
                            ijkMediaPlayer.mVideoSarNum = message.arg1;
                            ijkMediaPlayer.mVideoSarDen = message.arg2;
                            ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                            return;
                        }
                    } else if (message.obj == null) {
                        ijkMediaPlayer.notifyOnTimedText(null);
                        return;
                    } else {
                        ijkMediaPlayer.notifyOnTimedText(new IjkTimedText(new Rect(0, 0, 1, 1), (String) message.obj));
                        return;
                    }
                }
            }
            DebugLog.w(IjkMediaPlayer.TAG, "IjkMediaPlayer went away with unhandled events");
        }
    }

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj != null && (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) != null) {
            if (i == 200 && i2 == 2) {
                ijkMediaPlayer.start();
            }
            EventHandler eventHandler = ijkMediaPlayer.mEventHandler;
            if (eventHandler != null) {
                ijkMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
            }
        }
    }

    public void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    public void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    private static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        OnControlMessageListener onControlMessageListener;
        DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i));
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
        if (ijkMediaPlayer != null) {
            OnNativeInvokeListener onNativeInvokeListener = ijkMediaPlayer.mOnNativeInvokeListener;
            if (onNativeInvokeListener != null && onNativeInvokeListener.onNativeInvoke(i, bundle)) {
                return true;
            }
            if (i != 131079 || (onControlMessageListener = ijkMediaPlayer.mOnControlMessageListener) == null) {
                return false;
            }
            int i2 = bundle.getInt("segment_index", -1);
            if (i2 >= 0) {
                String onControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i2);
                if (onControlResolveSegmentUrl != null) {
                    bundle.putString("url", onControlResolveSegmentUrl);
                    return true;
                }
                throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
            }
            throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
        }
        throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
    }

    public void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer
    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = ijkMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(ijkMediaPlayer, str, i, i2);
    }

    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener
        public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2) {
            String[] supportedTypes;
            IjkMediaCodecInfo ijkMediaCodecInfo;
            if (Build.VERSION.SDK_INT < 16 || TextUtils.isEmpty(str)) {
                return null;
            }
            Log.i(IjkMediaPlayer.TAG, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, Integer.valueOf(i), Integer.valueOf(i2)));
            ArrayList arrayList = new ArrayList();
            int codecCount = MediaCodecList.getCodecCount();
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                Log.d(IjkMediaPlayer.TAG, String.format(Locale.US, "  found codec: %s", codecInfoAt.getName()));
                if (!codecInfoAt.isEncoder() && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                    for (String str2 : supportedTypes) {
                        if (!TextUtils.isEmpty(str2)) {
                            Log.d(IjkMediaPlayer.TAG, String.format(Locale.US, "    mime: %s", str2));
                            if (str2.equalsIgnoreCase(str) && (ijkMediaCodecInfo = IjkMediaCodecInfo.setupCandidate(codecInfoAt, str)) != null) {
                                arrayList.add(ijkMediaCodecInfo);
                                Log.i(IjkMediaPlayer.TAG, String.format(Locale.US, "candidate codec: %s rank=%d", codecInfoAt.getName(), Integer.valueOf(ijkMediaCodecInfo.mRank)));
                                ijkMediaCodecInfo.dumpProfileLevels(str);
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            IjkMediaCodecInfo ijkMediaCodecInfo2 = (IjkMediaCodecInfo) arrayList.get(0);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                IjkMediaCodecInfo ijkMediaCodecInfo3 = (IjkMediaCodecInfo) it2.next();
                if (ijkMediaCodecInfo3.mRank > ijkMediaCodecInfo2.mRank) {
                    ijkMediaCodecInfo2 = ijkMediaCodecInfo3;
                }
            }
            if (ijkMediaCodecInfo2.mRank < 600) {
                Log.w(IjkMediaPlayer.TAG, String.format(Locale.US, "unaccetable codec: %s", ijkMediaCodecInfo2.mCodecInfo.getName()));
                return null;
            }
            Log.i(IjkMediaPlayer.TAG, String.format(Locale.US, "selected codec: %s rank=%d", ijkMediaCodecInfo2.mCodecInfo.getName(), Integer.valueOf(ijkMediaCodecInfo2.mRank)));
            return ijkMediaCodecInfo2.mCodecInfo.getName();
        }
    }
}
