package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.b;
import com.ss.android.socialbase.downloader.constants.f;
import com.ss.android.socialbase.downloader.constants.h;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.e;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = new Parcelable.Creator<DownloadInfo>() {
        /* class com.ss.android.socialbase.downloader.model.DownloadInfo.AnonymousClass1 */

        /* renamed from: a */
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        /* renamed from: a */
        public DownloadInfo[] newArray(int i) {
            return new DownloadInfo[i];
        }
    };
    private static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    private static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    private static final int RESERVE_STATUS_NEVER = 0;
    private static final int RESERVE_STATUS_NOW = 2;
    private static final int RESERVE_STATUS_ONCE = 1;
    private static final String TAG = "DownloadInfo";
    private boolean addListenerToSameTask;
    private AtomicLong allConnectTime;
    private int appVersionCode;
    private com.ss.android.socialbase.downloader.constants.a asyncHandleStatus;
    private boolean autoResumed;
    private int backUpUrlRetryCount;
    private boolean backUpUrlUsed;
    private List<String> backUpUrls;
    private String backUpUrlsStr;
    private int bindValueCount;
    private b byteInvalidRetryStatus;
    private int chunkCount;
    private boolean chunkDowngradeRetryUsed;
    private int curBackUpUrlIndex;
    private AtomicLong curBytes;
    private int curRetryTime;
    private JSONObject dbJsonData;
    private String dbJsonDataString;
    private boolean deleteCacheIfCheckFailed;
    private long downloadTime;
    private String eTag;
    private f enqueueType;
    private StringBuffer errorBytesLog;
    private boolean expiredRedownload;
    private String extra;
    private List<c> extraHeaders;
    private int[] extraMonitorStatus;
    private BaseException failedException;
    private String filePackageName;
    private List<String> forbiddenBackupUrls;
    private boolean force;
    private boolean forceIgnoreRecommendSize;
    private boolean headConnectionAvailable;
    private String headConnectionException;
    private int httpStatusCode;
    private String httpStatusMessage;
    private boolean httpsToHttpRetryUsed;
    private String iconUrl;
    private int id;
    private boolean ignoreDataVerify;
    private Boolean isAutoInstallWithoutNotification;
    private boolean isFirstDownload;
    private boolean isFirstSuccess;
    private boolean isForbiddenRetryed;
    private volatile boolean isSaveTempFile;
    private AtomicLong lastNotifyProgressTime;
    private boolean mDownloadFromReserveWifi;
    private int maxBytes;
    private int maxProgressCount;
    private String md5;
    private String mimeType;
    private int minProgressTimeMsInterval;
    private String monitorScene;
    private String name;
    private boolean needChunkDowngradeRetry;
    private boolean needDefaultHttpServiceBackUp;
    private boolean needHttpsToHttpRetry;
    private boolean needIndependentProcess;
    private boolean needPostProgress;
    private boolean needRetryDelay;
    private boolean needReuseChunkRunnable;
    private boolean needReuseFirstConnection;
    private boolean needSDKMonitor;
    private String networkQuality;
    private boolean newSaveTempFileEnable;
    private int notificationVisibility;
    private boolean onlyWifi;
    private boolean openLimitSpeed;
    private String[] outIp;
    private int[] outSize;
    private SoftReference<PackageInfo> packageInfoRef;
    private String packageName;
    private long realDownloadTime;
    private long realStartDownloadTime;
    private int retryCount;
    private h retryDelayStatus;
    private String retryDelayTimeArray;
    @Deprecated
    private int retryScheduleMinutes;
    private String savePath;
    private boolean showNotification;
    private boolean showNotificationForAutoResumed;
    private boolean showNotificationForNetworkResumed;
    private JSONObject spData;
    private long startDownloadTime;
    private AtomicInteger status;
    private int statusAtDbInit;
    private boolean successByCache;
    private boolean supportPartial;
    private ConcurrentHashMap<String, Object> tempCacheData;
    private volatile List<aj> tempFileSaveCompleteCallbacks;
    private String tempPath;
    private long throttleNetSpeed;
    private String title;
    private long totalBytes;
    private String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isNeedRetryDelay() {
        return false;
    }

    public DownloadInfo() {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = f.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0);
        this.newSaveTempFileEnable = true;
        this.isAutoInstallWithoutNotification = null;
    }

    private DownloadInfo(a aVar) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = f.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0);
        this.newSaveTempFileEnable = true;
        this.isAutoInstallWithoutNotification = null;
        if (aVar != null) {
            this.name = aVar.a;
            this.title = aVar.b;
            this.url = aVar.c;
            String str = aVar.d;
            if (TextUtils.isEmpty(str)) {
                try {
                    str = e.e();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.savePath = str;
            this.tempPath = aVar.e;
            this.status = new AtomicInteger(0);
            this.curBytes = new AtomicLong(0);
            this.extra = aVar.g;
            this.onlyWifi = aVar.f;
            this.extraHeaders = aVar.h;
            this.maxBytes = aVar.i;
            this.retryCount = aVar.f1418l;
            this.backUpUrlRetryCount = aVar.m;
            this.force = aVar.n;
            this.outIp = aVar.j;
            this.outSize = aVar.k;
            this.needPostProgress = aVar.o;
            this.maxProgressCount = aVar.p;
            this.minProgressTimeMsInterval = aVar.q;
            this.backUpUrls = aVar.r;
            this.showNotification = aVar.s;
            this.mimeType = aVar.t;
            this.needHttpsToHttpRetry = aVar.u;
            this.needRetryDelay = aVar.C;
            this.retryDelayTimeArray = aVar.D;
            this.autoResumed = aVar.v;
            this.showNotificationForAutoResumed = aVar.w;
            this.needDefaultHttpServiceBackUp = aVar.x;
            this.needReuseChunkRunnable = aVar.y;
            this.packageName = aVar.z;
            this.md5 = aVar.A;
            this.needReuseFirstConnection = aVar.E;
            this.needIndependentProcess = aVar.F;
            this.enqueueType = aVar.G;
            this.headConnectionAvailable = aVar.H;
            this.ignoreDataVerify = aVar.I;
            this.newSaveTempFileEnable = aVar.N;
            this.addListenerToSameTask = aVar.O;
            this.needChunkDowngradeRetry = aVar.J;
            this.iconUrl = aVar.K;
            this.throttleNetSpeed = aVar.L;
            this.openLimitSpeed = aVar.M;
            JSONObject jSONObject = aVar.P;
            if (jSONObject != null) {
                safePutToDBJsonData("download_setting", jSONObject.toString());
            }
            safePutToDBJsonData("dbjson_key_expect_file_length", Long.valueOf(aVar.B));
            safePutToDBJsonData("executor_group", Integer.valueOf(aVar.T));
            this.needSDKMonitor = aVar.Q;
            this.monitorScene = aVar.R;
            this.extraMonitorStatus = aVar.S;
            this.expiredRedownload = aVar.U;
            this.deleteCacheIfCheckFailed = aVar.V;
            putMonitorSetting();
        }
    }

    private void putMonitorSetting() {
        safePutToDBJsonData("need_sdk_monitor", Boolean.valueOf(this.needSDKMonitor));
        safePutToDBJsonData("monitor_scene", this.monitorScene);
        try {
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.extraMonitorStatus;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.extraMonitorStatus;
                    if (i >= iArr2.length) {
                        break;
                    }
                    jSONArray.put(iArr2[i]);
                    i++;
                }
            }
            safePutToDBJsonData("extra_monitor_status", jSONArray);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void parseMonitorSetting() {
        ensureDBJsonData();
        this.needSDKMonitor = this.dbJsonData.optBoolean("need_sdk_monitor", false);
        this.monitorScene = this.dbJsonData.optString("monitor_scene", "");
        JSONArray optJSONArray = this.dbJsonData.optJSONArray("extra_monitor_status");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.extraMonitorStatus = new int[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.extraMonitorStatus[i] = optJSONArray.optInt(i);
            }
        }
    }

    public void readFromParcel(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.url = parcel.readString();
        this.savePath = parcel.readString();
        this.tempPath = parcel.readString();
        boolean z = true;
        this.onlyWifi = parcel.readByte() != 0;
        this.extra = parcel.readString();
        this.extraHeaders = parcel.createTypedArrayList(c.CREATOR);
        this.maxBytes = parcel.readInt();
        this.outIp = parcel.createStringArray();
        this.outSize = parcel.createIntArray();
        this.retryCount = parcel.readInt();
        this.backUpUrlRetryCount = parcel.readInt();
        this.force = parcel.readByte() != 0;
        this.needPostProgress = parcel.readByte() != 0;
        this.maxProgressCount = parcel.readInt();
        this.minProgressTimeMsInterval = parcel.readInt();
        this.backUpUrls = parcel.createStringArrayList();
        this.showNotification = parcel.readByte() != 0;
        this.mimeType = parcel.readString();
        this.needHttpsToHttpRetry = parcel.readByte() != 0;
        this.packageName = parcel.readString();
        this.md5 = parcel.readString();
        this.needRetryDelay = parcel.readByte() != 0;
        this.needDefaultHttpServiceBackUp = parcel.readByte() != 0;
        this.needReuseChunkRunnable = parcel.readByte() != 0;
        this.retryDelayTimeArray = parcel.readString();
        this.eTag = parcel.readString();
        this.curRetryTime = parcel.readInt();
        convertRetryDelayStatus(parcel.readInt());
        this.needReuseFirstConnection = parcel.readByte() != 0;
        this.forceIgnoreRecommendSize = parcel.readByte() != 0;
        this.networkQuality = parcel.readString();
        this.curBackUpUrlIndex = parcel.readInt();
        this.notificationVisibility = parcel.readInt();
        this.chunkCount = parcel.readInt();
        setCurBytes(parcel.readLong());
        this.totalBytes = parcel.readLong();
        setStatus(parcel.readInt());
        this.downloadTime = parcel.readLong();
        this.realDownloadTime = parcel.readLong();
        this.backUpUrlUsed = parcel.readByte() != 0;
        this.httpsToHttpRetryUsed = parcel.readByte() != 0;
        try {
            StringBuffer stringBuffer = this.errorBytesLog;
            if (stringBuffer == null) {
                this.errorBytesLog = new StringBuffer(parcel.readString());
            } else {
                stringBuffer.delete(0, stringBuffer.length()).append(parcel.readString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.autoResumed = parcel.readByte() != 0;
        this.showNotificationForAutoResumed = parcel.readByte() != 0;
        this.showNotificationForNetworkResumed = parcel.readByte() != 0;
        this.forbiddenBackupUrls = parcel.createStringArrayList();
        this.needIndependentProcess = parcel.readByte() != 0;
        convertEnqueueType(parcel.readInt());
        this.headConnectionAvailable = parcel.readByte() != 0;
        this.httpStatusCode = parcel.readInt();
        this.httpStatusMessage = parcel.readString();
        this.isSaveTempFile = parcel.readByte() != 0;
        this.isForbiddenRetryed = parcel.readByte() != 0;
        this.newSaveTempFileEnable = parcel.readByte() != 0;
        this.addListenerToSameTask = parcel.readByte() != 0;
        this.needChunkDowngradeRetry = parcel.readByte() != 0;
        this.chunkDowngradeRetryUsed = parcel.readByte() != 0;
        this.failedException = (BaseException) parcel.readParcelable(BaseException.class.getClassLoader());
        this.retryScheduleMinutes = parcel.readInt();
        this.dbJsonDataString = parcel.readString();
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.supportPartial = z;
        this.iconUrl = parcel.readString();
        this.appVersionCode = parcel.readInt();
        parseMonitorSetting();
    }

    private JSONObject convertStrToJson(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new JSONObject(str);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String getBackUpUrlsStr() {
        List<String> list;
        if (this.backUpUrlsStr == null && (list = this.backUpUrls) != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.backUpUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                this.backUpUrlsStr = jSONArray.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.backUpUrlsStr == null) {
            this.backUpUrlsStr = "";
        }
        return this.backUpUrlsStr;
    }

    private void setBackUpUrlsStr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.backUpUrlsStr = str;
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String optString = jSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    this.backUpUrls = arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isWaitingWifiStatus() {
        BaseException baseException = this.failedException;
        return baseException != null && baseException.getErrorCode() == 1013;
    }

    public boolean canNotifyProgress() {
        long j = this.lastNotifyProgressTime.get();
        return j == 0 || SystemClock.uptimeMillis() - j > 20;
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime.set(SystemClock.uptimeMillis());
    }

    public String getHeadConnectionException() {
        return this.headConnectionException;
    }

    public void setHeadConnectionException(String str) {
        this.headConnectionException = str;
    }

    protected DownloadInfo(Parcel parcel) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = f.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0);
        this.newSaveTempFileEnable = true;
        this.isAutoInstallWithoutNotification = null;
        readFromParcel(parcel);
    }

    private void convertEnqueueType(int i) {
        if (i == f.ENQUEUE_HEAD.ordinal()) {
            this.enqueueType = f.ENQUEUE_HEAD;
        } else if (i == f.ENQUEUE_TAIL.ordinal()) {
            this.enqueueType = f.ENQUEUE_TAIL;
        } else {
            this.enqueueType = f.ENQUEUE_NONE;
        }
    }

    private void convertRetryDelayStatus(int i) {
        if (i == h.DELAY_RETRY_WAITING.ordinal()) {
            this.retryDelayStatus = h.DELAY_RETRY_WAITING;
        } else if (i == h.DELAY_RETRY_DOWNLOADING.ordinal()) {
            this.retryDelayStatus = h.DELAY_RETRY_DOWNLOADING;
        } else if (i == h.DELAY_RETRY_DOWNLOADED.ordinal()) {
            this.retryDelayStatus = h.DELAY_RETRY_DOWNLOADED;
        } else {
            this.retryDelayStatus = h.DELAY_RETRY_NONE;
        }
    }

    public int getDownloadProcess() {
        if (this.totalBytes <= 0) {
            return 0;
        }
        if (getCurBytes() > this.totalBytes) {
            return 100;
        }
        return (int) ((getCurBytes() * 100) / this.totalBytes);
    }

    public void addErrorBytesLog(long j, int i, String str) {
        try {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                if (this.errorBytesLog == null) {
                    this.errorBytesLog = new StringBuffer();
                }
                if (this.errorBytesLog.length() != 0) {
                    this.errorBytesLog.append(",");
                }
                StringBuffer stringBuffer = this.errorBytesLog;
                stringBuffer.append("[type:");
                stringBuffer.append(i);
                stringBuffer.append(",bytes:");
                stringBuffer.append(j);
                stringBuffer.append(",method:");
                stringBuffer.append(str);
                stringBuffer.append("]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getErrorBytesLog() {
        StringBuffer stringBuffer = this.errorBytesLog;
        return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.errorBytesLog.toString();
    }

    public DownloadInfo(Cursor cursor) {
        boolean z = true;
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = f.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0);
        this.newSaveTempFileEnable = true;
        this.isAutoInstallWithoutNotification = null;
        if (cursor != null) {
            try {
                int columnIndex = cursor.getColumnIndex("_id");
                if (columnIndex != -1) {
                    this.id = cursor.getInt(columnIndex);
                }
                int columnIndex2 = cursor.getColumnIndex("name");
                if (columnIndex2 != -1) {
                    this.name = cursor.getString(columnIndex2);
                }
                int columnIndex3 = cursor.getColumnIndex("title");
                if (columnIndex3 != -1) {
                    this.title = cursor.getString(columnIndex3);
                }
                int columnIndex4 = cursor.getColumnIndex("url");
                if (columnIndex4 != -1) {
                    this.url = cursor.getString(columnIndex4);
                }
                int columnIndex5 = cursor.getColumnIndex("savePath");
                if (columnIndex5 != -1) {
                    this.savePath = cursor.getString(columnIndex5);
                }
                int columnIndex6 = cursor.getColumnIndex("tempPath");
                if (columnIndex6 != -1) {
                    this.tempPath = cursor.getString(columnIndex6);
                }
                int columnIndex7 = cursor.getColumnIndex("chunkCount");
                if (columnIndex7 != -1) {
                    this.chunkCount = cursor.getInt(columnIndex7);
                }
                int columnIndex8 = cursor.getColumnIndex("status");
                if (columnIndex8 != -1) {
                    this.status = new AtomicInteger(cursor.getInt(columnIndex8));
                } else {
                    this.status = new AtomicInteger(0);
                }
                int columnIndex9 = cursor.getColumnIndex("curBytes");
                if (columnIndex9 != -1) {
                    this.curBytes = new AtomicLong(cursor.getLong(columnIndex9));
                } else {
                    this.curBytes = new AtomicLong(0);
                }
                int columnIndex10 = cursor.getColumnIndex("totalBytes");
                if (columnIndex10 != -1) {
                    this.totalBytes = cursor.getLong(columnIndex10);
                }
                int columnIndex11 = cursor.getColumnIndex("eTag");
                if (columnIndex11 != -1) {
                    this.eTag = cursor.getString(columnIndex11);
                }
                int columnIndex12 = cursor.getColumnIndex("onlyWifi");
                if (columnIndex12 != -1) {
                    this.onlyWifi = cursor.getInt(columnIndex12) != 0;
                }
                int columnIndex13 = cursor.getColumnIndex("force");
                if (columnIndex13 != -1) {
                    this.force = cursor.getInt(columnIndex13) != 0;
                }
                int columnIndex14 = cursor.getColumnIndex("retryCount");
                if (columnIndex14 != -1) {
                    this.retryCount = cursor.getInt(columnIndex14);
                }
                int columnIndex15 = cursor.getColumnIndex("extra");
                if (columnIndex15 != -1) {
                    this.extra = cursor.getString(columnIndex15);
                }
                int columnIndex16 = cursor.getColumnIndex("mimeType");
                if (columnIndex16 != -1) {
                    this.mimeType = cursor.getString(columnIndex16);
                }
                int columnIndex17 = cursor.getColumnIndex("notificationEnable");
                if (columnIndex17 != -1) {
                    this.showNotification = cursor.getInt(columnIndex17) != 0;
                }
                int columnIndex18 = cursor.getColumnIndex("notificationVisibility");
                if (columnIndex18 != -1) {
                    this.notificationVisibility = cursor.getInt(columnIndex18);
                }
                int columnIndex19 = cursor.getColumnIndex("isFirstDownload");
                if (columnIndex19 != -1) {
                    this.isFirstDownload = cursor.getInt(columnIndex19) == 1;
                }
                int columnIndex20 = cursor.getColumnIndex("isFirstSuccess");
                if (columnIndex20 != -1) {
                    this.isFirstSuccess = cursor.getInt(columnIndex20) == 1;
                }
                int columnIndex21 = cursor.getColumnIndex("needHttpsToHttpRetry");
                if (columnIndex21 != -1) {
                    this.needHttpsToHttpRetry = cursor.getInt(columnIndex21) == 1;
                }
                int columnIndex22 = cursor.getColumnIndex("downloadTime");
                if (columnIndex22 != -1) {
                    this.downloadTime = cursor.getLong(columnIndex22);
                }
                int columnIndex23 = cursor.getColumnIndex("packageName");
                if (columnIndex23 != -1) {
                    this.packageName = cursor.getString(columnIndex23);
                }
                int columnIndex24 = cursor.getColumnIndex("md5");
                if (columnIndex24 != -1) {
                    this.md5 = cursor.getString(columnIndex24);
                }
                int columnIndex25 = cursor.getColumnIndex("retryDelay");
                if (columnIndex25 != -1) {
                    this.needRetryDelay = cursor.getInt(columnIndex25) == 1;
                }
                int columnIndex26 = cursor.getColumnIndex("curRetryTime");
                if (columnIndex26 != -1) {
                    this.curRetryTime = cursor.getInt(columnIndex26);
                }
                int columnIndex27 = cursor.getColumnIndex("retryDelayStatus");
                if (columnIndex27 != -1) {
                    int i = cursor.getInt(columnIndex27);
                    if (i == h.DELAY_RETRY_WAITING.ordinal()) {
                        this.retryDelayStatus = h.DELAY_RETRY_WAITING;
                    } else if (i == h.DELAY_RETRY_DOWNLOADING.ordinal()) {
                        this.retryDelayStatus = h.DELAY_RETRY_DOWNLOADING;
                    } else if (i == h.DELAY_RETRY_DOWNLOADED.ordinal()) {
                        this.retryDelayStatus = h.DELAY_RETRY_DOWNLOADED;
                    } else {
                        this.retryDelayStatus = h.DELAY_RETRY_NONE;
                    }
                }
                int columnIndex28 = cursor.getColumnIndex("defaultHttpServiceBackUp");
                if (columnIndex28 != -1) {
                    this.needDefaultHttpServiceBackUp = cursor.getInt(columnIndex28) == 1;
                }
                int columnIndex29 = cursor.getColumnIndex("chunkRunnableReuse");
                if (columnIndex29 != -1) {
                    this.needReuseChunkRunnable = cursor.getInt(columnIndex29) == 1;
                }
                int columnIndex30 = cursor.getColumnIndex("retryDelayTimeArray");
                if (columnIndex30 != -1) {
                    this.retryDelayTimeArray = cursor.getString(columnIndex30);
                }
                int columnIndex31 = cursor.getColumnIndex("chunkDowngradeRetry");
                if (columnIndex31 != -1) {
                    this.needChunkDowngradeRetry = cursor.getInt(columnIndex31) == 1;
                }
                int columnIndex32 = cursor.getColumnIndex("backUpUrlsStr");
                if (columnIndex32 != -1) {
                    setBackUpUrlsStr(cursor.getString(columnIndex32));
                }
                int columnIndex33 = cursor.getColumnIndex("backUpUrlRetryCount");
                if (columnIndex33 != -1) {
                    this.backUpUrlRetryCount = cursor.getInt(columnIndex33);
                }
                int columnIndex34 = cursor.getColumnIndex("realDownloadTime");
                if (columnIndex34 != -1) {
                    this.realDownloadTime = cursor.getLong(columnIndex34);
                }
                int columnIndex35 = cursor.getColumnIndex("retryScheduleMinutes");
                if (columnIndex35 != -1) {
                    this.retryScheduleMinutes = cursor.getInt(columnIndex35);
                }
                int columnIndex36 = cursor.getColumnIndex("independentProcess");
                if (columnIndex36 != -1) {
                    if (cursor.getInt(columnIndex36) != 1) {
                        z = false;
                    }
                    this.needIndependentProcess = z;
                }
                int columnIndex37 = cursor.getColumnIndex("auxiliaryJsonobjectString");
                if (columnIndex37 != -1) {
                    this.dbJsonDataString = cursor.getString(columnIndex37);
                }
                int columnIndex38 = cursor.getColumnIndex("iconUrl");
                if (columnIndex38 != -1) {
                    this.iconUrl = cursor.getString(columnIndex38);
                }
                int columnIndex39 = cursor.getColumnIndex("appVersionCode");
                if (columnIndex39 != -1) {
                    this.appVersionCode = cursor.getInt(columnIndex39);
                }
                parseMonitorSetting();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.id));
        contentValues.put("url", this.url);
        contentValues.put("savePath", this.savePath);
        contentValues.put("tempPath", this.tempPath);
        contentValues.put("name", this.name);
        contentValues.put("chunkCount", Integer.valueOf(this.chunkCount));
        contentValues.put("status", Integer.valueOf(getStatus()));
        contentValues.put("curBytes", Long.valueOf(getCurBytes()));
        contentValues.put("totalBytes", Long.valueOf(this.totalBytes));
        contentValues.put("eTag", this.eTag);
        contentValues.put("onlyWifi", Integer.valueOf(this.onlyWifi ? 1 : 0));
        contentValues.put("force", Integer.valueOf(this.force ? 1 : 0));
        contentValues.put("retryCount", Integer.valueOf(this.retryCount));
        contentValues.put("extra", this.extra);
        contentValues.put("mimeType", this.mimeType);
        contentValues.put("title", this.title);
        contentValues.put("notificationEnable", Integer.valueOf(this.showNotification ? 1 : 0));
        contentValues.put("notificationVisibility", Integer.valueOf(this.notificationVisibility));
        contentValues.put("isFirstDownload", Integer.valueOf(this.isFirstDownload ? 1 : 0));
        contentValues.put("isFirstSuccess", Integer.valueOf(this.isFirstSuccess ? 1 : 0));
        contentValues.put("needHttpsToHttpRetry", Integer.valueOf(this.needHttpsToHttpRetry ? 1 : 0));
        contentValues.put("downloadTime", Long.valueOf(this.downloadTime));
        contentValues.put("packageName", this.packageName);
        contentValues.put("md5", this.md5);
        contentValues.put("retryDelay", Integer.valueOf(this.needRetryDelay ? 1 : 0));
        contentValues.put("curRetryTime", Integer.valueOf(this.curRetryTime));
        contentValues.put("retryDelayStatus", Integer.valueOf(this.retryDelayStatus.ordinal()));
        contentValues.put("defaultHttpServiceBackUp", Integer.valueOf(this.needDefaultHttpServiceBackUp ? 1 : 0));
        contentValues.put("chunkRunnableReuse", Integer.valueOf(this.needReuseChunkRunnable ? 1 : 0));
        contentValues.put("retryDelayTimeArray", this.retryDelayTimeArray);
        contentValues.put("chunkDowngradeRetry", Integer.valueOf(this.needChunkDowngradeRetry ? 1 : 0));
        contentValues.put("backUpUrlsStr", getBackUpUrlsStr());
        contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.backUpUrlRetryCount));
        contentValues.put("realDownloadTime", Long.valueOf(this.realDownloadTime));
        contentValues.put("retryScheduleMinutes", Integer.valueOf(this.retryScheduleMinutes));
        contentValues.put("independentProcess", Integer.valueOf(this.needIndependentProcess ? 1 : 0));
        contentValues.put("auxiliaryJsonobjectString", getDBJsonDataString());
        contentValues.put("iconUrl", this.iconUrl);
        contentValues.put("appVersionCode", Integer.valueOf(this.appVersionCode));
        return contentValues;
    }

    private String getDBJsonDataString() {
        String jSONObject;
        String str = this.dbJsonDataString;
        if (str != null) {
            return str;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            jSONObject = this.dbJsonData.toString();
            this.dbJsonDataString = jSONObject;
        }
        return jSONObject;
    }

    public void bindValue(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            this.bindValueCount = 0;
            sQLiteStatement.clearBindings();
            int i = this.bindValueCount + 1;
            this.bindValueCount = i;
            sQLiteStatement.bindLong(i, (long) this.id);
            int i2 = this.bindValueCount + 1;
            this.bindValueCount = i2;
            String str = this.url;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            sQLiteStatement.bindString(i2, str);
            int i3 = this.bindValueCount + 1;
            this.bindValueCount = i3;
            String str3 = this.savePath;
            if (str3 == null) {
                str3 = str2;
            }
            sQLiteStatement.bindString(i3, str3);
            int i4 = this.bindValueCount + 1;
            this.bindValueCount = i4;
            String str4 = this.tempPath;
            if (str4 == null) {
                str4 = str2;
            }
            sQLiteStatement.bindString(i4, str4);
            int i5 = this.bindValueCount + 1;
            this.bindValueCount = i5;
            String str5 = this.name;
            if (str5 == null) {
                str5 = str2;
            }
            sQLiteStatement.bindString(i5, str5);
            int i6 = this.bindValueCount + 1;
            this.bindValueCount = i6;
            sQLiteStatement.bindLong(i6, (long) this.chunkCount);
            int i7 = this.bindValueCount + 1;
            this.bindValueCount = i7;
            sQLiteStatement.bindLong(i7, (long) getStatus());
            int i8 = this.bindValueCount + 1;
            this.bindValueCount = i8;
            sQLiteStatement.bindLong(i8, getCurBytes());
            int i9 = this.bindValueCount + 1;
            this.bindValueCount = i9;
            sQLiteStatement.bindLong(i9, this.totalBytes);
            int i10 = this.bindValueCount + 1;
            this.bindValueCount = i10;
            String str6 = this.eTag;
            if (str6 == null) {
                str6 = str2;
            }
            sQLiteStatement.bindString(i10, str6);
            int i11 = this.bindValueCount + 1;
            this.bindValueCount = i11;
            long j = 1;
            sQLiteStatement.bindLong(i11, this.onlyWifi ? 1 : 0);
            int i12 = this.bindValueCount + 1;
            this.bindValueCount = i12;
            sQLiteStatement.bindLong(i12, this.force ? 1 : 0);
            int i13 = this.bindValueCount + 1;
            this.bindValueCount = i13;
            sQLiteStatement.bindLong(i13, (long) this.retryCount);
            int i14 = this.bindValueCount + 1;
            this.bindValueCount = i14;
            String str7 = this.extra;
            if (str7 == null) {
                str7 = str2;
            }
            sQLiteStatement.bindString(i14, str7);
            int i15 = this.bindValueCount + 1;
            this.bindValueCount = i15;
            String str8 = this.mimeType;
            if (str8 == null) {
                str8 = str2;
            }
            sQLiteStatement.bindString(i15, str8);
            int i16 = this.bindValueCount + 1;
            this.bindValueCount = i16;
            String str9 = this.title;
            if (str9 == null) {
                str9 = str2;
            }
            sQLiteStatement.bindString(i16, str9);
            int i17 = this.bindValueCount + 1;
            this.bindValueCount = i17;
            sQLiteStatement.bindLong(i17, this.showNotification ? 1 : 0);
            int i18 = this.bindValueCount + 1;
            this.bindValueCount = i18;
            sQLiteStatement.bindLong(i18, (long) this.notificationVisibility);
            int i19 = this.bindValueCount + 1;
            this.bindValueCount = i19;
            sQLiteStatement.bindLong(i19, this.isFirstDownload ? 1 : 0);
            int i20 = this.bindValueCount + 1;
            this.bindValueCount = i20;
            sQLiteStatement.bindLong(i20, this.isFirstSuccess ? 1 : 0);
            int i21 = this.bindValueCount + 1;
            this.bindValueCount = i21;
            sQLiteStatement.bindLong(i21, this.needHttpsToHttpRetry ? 1 : 0);
            int i22 = this.bindValueCount + 1;
            this.bindValueCount = i22;
            sQLiteStatement.bindLong(i22, this.downloadTime);
            int i23 = this.bindValueCount + 1;
            this.bindValueCount = i23;
            String str10 = this.packageName;
            if (str10 == null) {
                str10 = str2;
            }
            sQLiteStatement.bindString(i23, str10);
            int i24 = this.bindValueCount + 1;
            this.bindValueCount = i24;
            String str11 = this.md5;
            if (str11 == null) {
                str11 = str2;
            }
            sQLiteStatement.bindString(i24, str11);
            int i25 = this.bindValueCount + 1;
            this.bindValueCount = i25;
            sQLiteStatement.bindLong(i25, this.needRetryDelay ? 1 : 0);
            int i26 = this.bindValueCount + 1;
            this.bindValueCount = i26;
            sQLiteStatement.bindLong(i26, (long) this.curRetryTime);
            int i27 = this.bindValueCount + 1;
            this.bindValueCount = i27;
            sQLiteStatement.bindLong(i27, (long) this.retryDelayStatus.ordinal());
            int i28 = this.bindValueCount + 1;
            this.bindValueCount = i28;
            sQLiteStatement.bindLong(i28, this.needDefaultHttpServiceBackUp ? 1 : 0);
            int i29 = this.bindValueCount + 1;
            this.bindValueCount = i29;
            sQLiteStatement.bindLong(i29, this.needReuseChunkRunnable ? 1 : 0);
            int i30 = this.bindValueCount + 1;
            this.bindValueCount = i30;
            String str12 = this.retryDelayTimeArray;
            if (str12 == null) {
                str12 = str2;
            }
            sQLiteStatement.bindString(i30, str12);
            int i31 = this.bindValueCount + 1;
            this.bindValueCount = i31;
            sQLiteStatement.bindLong(i31, this.needChunkDowngradeRetry ? 1 : 0);
            int i32 = this.bindValueCount + 1;
            this.bindValueCount = i32;
            sQLiteStatement.bindString(i32, getBackUpUrlsStr());
            int i33 = this.bindValueCount + 1;
            this.bindValueCount = i33;
            sQLiteStatement.bindLong(i33, (long) this.backUpUrlRetryCount);
            int i34 = this.bindValueCount + 1;
            this.bindValueCount = i34;
            sQLiteStatement.bindLong(i34, this.realDownloadTime);
            int i35 = this.bindValueCount + 1;
            this.bindValueCount = i35;
            sQLiteStatement.bindLong(i35, (long) this.retryScheduleMinutes);
            int i36 = this.bindValueCount + 1;
            this.bindValueCount = i36;
            if (!this.needIndependentProcess) {
                j = 0;
            }
            sQLiteStatement.bindLong(i36, j);
            int i37 = this.bindValueCount + 1;
            this.bindValueCount = i37;
            sQLiteStatement.bindString(i37, getDBJsonDataString());
            int i38 = this.bindValueCount + 1;
            this.bindValueCount = i38;
            String str13 = this.iconUrl;
            if (str13 != null) {
                str2 = str13;
            }
            sQLiteStatement.bindString(i38, str2);
            int i39 = this.bindValueCount + 1;
            this.bindValueCount = i39;
            sQLiteStatement.bindLong(i39, (long) this.appVersionCode);
        }
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public int getId() {
        if (this.id == 0) {
            this.id = com.ss.android.socialbase.downloader.downloader.b.a(this);
        }
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        if (TextUtils.isEmpty(this.title)) {
            return this.name;
        }
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getTempPath() {
        return e.b(this.savePath, this.tempPath);
    }

    public String getTempName() {
        return e.c(this.name);
    }

    public String getTargetFilePath() {
        return e.a(this.savePath, this.name);
    }

    public String getTempFilePath() {
        return e.a(this.savePath, this.tempPath, this.name);
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        return this.needDefaultHttpServiceBackUp;
    }

    public boolean isNeedReuseChunkRunnable() {
        return this.needReuseChunkRunnable;
    }

    public int getStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger == null) {
            return 0;
        }
        int i = atomicInteger.get();
        if (i == -5) {
            return -2;
        }
        return i;
    }

    public f getEnqueueType() {
        return this.enqueueType;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public boolean isHttpsToHttpRetryUsed() {
        return this.httpsToHttpRetryUsed;
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public void setAutoResumed(boolean z) {
        this.autoResumed = z;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public void setShowNotificationForAutoResumed(boolean z) {
        this.showNotificationForAutoResumed = z;
    }

    public boolean isShowNotificationForNetworkResumed() {
        return this.showNotificationForNetworkResumed;
    }

    public void setShowNotificationForNetworkResumed(boolean z) {
        this.showNotificationForNetworkResumed = z;
    }

    public int getRealStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public boolean isOnlyWifi() {
        return this.onlyWifi;
    }

    public void setOnlyWifi(boolean z) {
        this.onlyWifi = z;
    }

    public long getFirstSpeedTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_first_speed_time");
    }

    public void setFirstSpeedTime(long j) {
        safePutToDBJsonData("dbjson_key_first_speed_time", Long.valueOf(j));
    }

    public int getTTMd5CheckStatus() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("ttmd5_check_status", -1);
    }

    public void setTTMd5CheckStatus(int i) {
        safePutToDBJsonData("ttmd5_check_status", Integer.valueOf(i));
    }

    public long getAllConnectTime() {
        ensureDBJsonData();
        if (this.allConnectTime == null) {
            this.allConnectTime = new AtomicLong(this.dbJsonData.optLong("dbjson_key_all_connect_time"));
        }
        return this.allConnectTime.get();
    }

    public void increaseAllConnectTime(long j) {
        if (j > 0) {
            getAllConnectTime();
            safePutToDBJsonData("dbjson_key_all_connect_time", Long.valueOf(this.allConnectTime.addAndGet(j)));
        }
    }

    public long getDownloadPrepareTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_download_prepare_time");
    }

    public void increaseDownloadPrepareTime(long j) {
        if (j > 0) {
            safePutToDBJsonData("dbjson_key_download_prepare_time", Long.valueOf(getDownloadPrepareTime() + j));
        }
    }

    public String getExtra() {
        return this.extra;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getFilePackageName() {
        return this.filePackageName;
    }

    public void setFilePackageName(String str) {
        this.filePackageName = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public long getExpectFileLength() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_expect_file_length");
    }

    public List<c> getExtraHeaders() {
        return this.extraHeaders;
    }

    public int getMaxBytes() {
        return this.maxBytes;
    }

    public String[] getOutIp() {
        return this.outIp;
    }

    public int[] getOutSize() {
        return this.outSize;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public int getTotalRetryCount() {
        int i = this.retryCount;
        List<String> list = this.backUpUrls;
        return (list == null || list.isEmpty()) ? i : i + (this.backUpUrlRetryCount * this.backUpUrls.size());
    }

    public int getCurRetryTimeInTotal() {
        int i = this.curRetryTime;
        if (!this.backUpUrlUsed) {
            return i;
        }
        int i2 = i + this.retryCount;
        int i3 = this.curBackUpUrlIndex;
        return i3 > 0 ? i2 + (i3 * this.backUpUrlRetryCount) : i2;
    }

    public List<String> getForbiddenBackupUrls() {
        return this.forbiddenBackupUrls;
    }

    public void setForbiddenBackupUrls(List<String> list, boolean z) {
        this.forbiddenBackupUrls = list;
        refreshBackupUrls(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private void refreshBackupUrls(boolean z) {
        List<String> list = this.forbiddenBackupUrls;
        if (list != null && list.size() > z) {
            List<String> list2 = this.backUpUrls;
            if (list2 == null) {
                this.backUpUrls = new ArrayList();
            } else {
                list2.clear();
            }
            this.backUpUrlUsed = false;
            this.curBackUpUrlIndex = 0;
            int i = z;
            while (i < this.forbiddenBackupUrls.size()) {
                this.backUpUrls.add(this.forbiddenBackupUrls.get(i == 1 ? 1 : 0));
                i++;
            }
        }
    }

    public String getConnectionUrl() {
        List<String> list;
        int i;
        List<String> list2;
        String str = this.url;
        if (getStatus() == 8 && (list2 = this.forbiddenBackupUrls) != null && !list2.isEmpty() && !this.backUpUrlUsed) {
            return this.forbiddenBackupUrls.get(0);
        }
        if (!this.backUpUrlUsed || (list = this.backUpUrls) == null || list.size() <= 0 || (i = this.curBackUpUrlIndex) < 0 || i >= this.backUpUrls.size()) {
            return (TextUtils.isEmpty(this.url) || !this.url.startsWith("https") || !this.needHttpsToHttpRetry || !this.httpsToHttpRetryUsed) ? str : this.url.replaceFirst("https", "http");
        }
        String str2 = this.backUpUrls.get(this.curBackUpUrlIndex);
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public boolean isBackUpUrlUsed() {
        return this.backUpUrlUsed;
    }

    public String getBackUpUrl() {
        List<String> list;
        int i;
        if (this.backUpUrlUsed && (list = this.backUpUrls) != null && list.size() > 0 && (i = this.curBackUpUrlIndex) >= 0 && i < this.backUpUrls.size()) {
            String str = this.backUpUrls.get(this.curBackUpUrlIndex);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public void updateStartDownloadTime() {
        this.startDownloadTime = SystemClock.uptimeMillis();
        safePutToDBJsonData("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    }

    public void safePutToDBJsonData(String str, Object obj) {
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                this.dbJsonData.put(str, obj);
            } catch (Exception unused) {
            }
            this.dbJsonDataString = null;
        }
    }

    public String getDownloadSettingString() {
        ensureDBJsonData();
        return this.dbJsonData.optString("download_setting");
    }

    public int getRetryScheduleCount() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("retry_schedule_count", 0);
    }

    public void setRetryScheduleCount(int i) {
        safePutToDBJsonData("retry_schedule_count", Integer.valueOf(i));
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public void setDownloadFromReserveWifi(boolean z) {
        this.mDownloadFromReserveWifi = z;
    }

    public int getLinkMode() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("link_mode");
    }

    public void setLinkMode(int i) {
        safePutToDBJsonData("link_mode", Integer.valueOf(i));
    }

    public boolean isPauseReserveOnWifi() {
        return (getReserveWifiStatus() & 2) > 0;
    }

    public boolean hasPauseReservedOnWifi() {
        return (getReserveWifiStatus() & 1) > 0;
    }

    public boolean statusInPause() {
        return getRealStatus() == -2 || getRealStatus() == -5;
    }

    private int getReserveWifiStatus() {
        ensureSpData();
        try {
            return this.spData.optInt("pause_reserve_on_wifi", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void startPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 3);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void stopPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 1);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void setCacheExpiredTime(long j) {
        ensureSpData();
        try {
            this.spData.put("cache-control/expired_time", j);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public long getCacheExpiredTime() {
        ensureSpData();
        try {
            return this.spData.optLong("cache-control/expired_time", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public void setCacheControl(String str) {
        ensureSpData();
        try {
            this.spData.put("cache-control", str);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public String getCacheControl() {
        ensureSpData();
        try {
            return this.spData.optString("cache-control", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public void setLastModified(String str) {
        ensureSpData();
        try {
            this.spData.put("last-modified", str);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public String getLastModified() {
        ensureSpData();
        try {
            return this.spData.optString("last-modified", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public void setIsRwConcurrent(boolean z) {
        safePutToDBJsonData("rw_concurrent", Integer.valueOf(z ? 1 : 0));
    }

    public boolean isRwConcurrent() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("rw_concurrent", 0) == 1;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public String getMonitorScene() {
        return this.monitorScene;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public void updateDownloadTime() {
        if (this.startDownloadTime != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.startDownloadTime;
            if (this.downloadTime < 0) {
                this.downloadTime = 0;
            }
            if (uptimeMillis > 0) {
                this.downloadTime = uptimeMillis;
            }
        }
    }

    public void updateRealStartDownloadTime() {
        if (this.realStartDownloadTime == 0) {
            this.realStartDownloadTime = System.nanoTime();
        }
    }

    public void resetRealStartDownloadTime() {
        this.realStartDownloadTime = 0;
    }

    public void updateRealDownloadTime(boolean z) {
        long nanoTime = System.nanoTime();
        long j = this.realStartDownloadTime;
        if (j > 0) {
            long j2 = nanoTime - j;
            if (z) {
                this.realStartDownloadTime = nanoTime;
            } else {
                this.realStartDownloadTime = 0;
            }
            if (j2 > 0) {
                this.realDownloadTime += j2;
            }
        } else if (z) {
            this.realStartDownloadTime = nanoTime;
        }
    }

    public void setDownloadTime(long j) {
        if (j >= 0) {
            this.downloadTime = j;
        }
    }

    public boolean isNeedReuseFirstConnection() {
        return this.needReuseFirstConnection;
    }

    public boolean isNeedIndependentProcess() {
        return this.needIndependentProcess;
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public boolean isHeadConnectionAvailable() {
        return this.headConnectionAvailable;
    }

    public boolean isIgnoreDataVerify() {
        return this.ignoreDataVerify;
    }

    public boolean isNewSaveTempFileEnable() {
        return this.newSaveTempFileEnable;
    }

    public boolean isAddListenerToSameTask() {
        return this.addListenerToSameTask;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isExpiredRedownload() {
        return this.expiredRedownload;
    }

    public boolean isSuccessByCache() {
        return this.successByCache;
    }

    public void setSuccessByCache(boolean z) {
        this.successByCache = z;
    }

    public long getCurBytes() {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0;
    }

    public void setCurBytes(long j) {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.curBytes = new AtomicLong(j);
        }
    }

    public void setCurBytes(long j, boolean z) {
        if (z) {
            setCurBytes(j);
        } else if (j > getCurBytes()) {
            setCurBytes(j);
        }
    }

    public b getByteInvalidRetryStatus() {
        return this.byteInvalidRetryStatus;
    }

    public void setByteInvalidRetryStatus(b bVar) {
        this.byteInvalidRetryStatus = bVar;
    }

    public void setFirstDownload(boolean z) {
        this.isFirstDownload = z;
    }

    public void setFirstSuccess(boolean z) {
        this.isFirstSuccess = z;
    }

    public void increaseCurBytes(long j) {
        this.curBytes.addAndGet(j);
    }

    public void seteTag(String str) {
        this.eTag = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public void setStatus(int i) {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            atomicInteger.set(i);
        } else {
            this.status = new AtomicInteger(i);
        }
    }

    public void setSupportPartial(boolean z) {
        this.supportPartial = z;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public String geteTag() {
        return this.eTag;
    }

    public String getNetworkQuality() {
        return this.networkQuality;
    }

    public void setNetworkQuality(String str) {
        this.networkQuality = str;
    }

    public void setChunkCount(int i) {
        this.chunkCount = i;
    }

    public int getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public void setNotificationVisibility(int i) {
        this.notificationVisibility = i;
    }

    public boolean isForceIgnoreRecommendSize() {
        return this.forceIgnoreRecommendSize;
    }

    public void setForceIgnoreRecommendSize(boolean z) {
        this.forceIgnoreRecommendSize = z;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setHttpStatusCode(int i) {
        this.httpStatusCode = i;
    }

    public String getHttpStatusMessage() {
        return this.httpStatusMessage;
    }

    public void setHttpStatusMessage(String str) {
        this.httpStatusMessage = str;
    }

    public boolean canShowNotification() {
        boolean z = this.autoResumed;
        return (!z && this.showNotification) || (z && (this.showNotificationForAutoResumed || this.showNotificationForNetworkResumed));
    }

    public void setShowNotification(boolean z) {
        this.showNotification = z;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isAutoInstallWithoutNotification() {
        if (this.isAutoInstallWithoutNotification == null) {
            if (!TextUtils.isEmpty(this.extra)) {
                try {
                    this.isAutoInstallWithoutNotification = Boolean.valueOf(new JSONObject(this.extra).optBoolean("auto_install_without_notification", false));
                } catch (JSONException unused) {
                    this.isAutoInstallWithoutNotification = false;
                }
            } else {
                this.isAutoInstallWithoutNotification = false;
            }
        }
        return this.isAutoInstallWithoutNotification.booleanValue();
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public boolean isNeedHttpsToHttpRetry() {
        return this.needHttpsToHttpRetry;
    }

    public String getRetryDelayTimeArray() {
        return this.retryDelayTimeArray;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
    }

    public boolean isForbiddenRetryed() {
        return this.isForbiddenRetryed;
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setAppVersionCode(int i) {
        this.appVersionCode = i;
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public boolean isNeedChunkDowngradeRetry() {
        return this.needChunkDowngradeRetry;
    }

    public boolean isChunkDowngradeRetryUsed() {
        return this.chunkDowngradeRetryUsed;
    }

    public h getRetryDelayStatus() {
        return this.retryDelayStatus;
    }

    public com.ss.android.socialbase.downloader.constants.a getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public boolean canSkipStatusHandler() {
        int status2 = getStatus();
        return status2 == 7 || this.retryDelayStatus == h.DELAY_RETRY_WAITING || status2 == 8 || this.asyncHandleStatus == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING || this.asyncHandleStatus == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART || this.byteInvalidRetryStatus == b.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public void changeSkipStatus() {
        int status2 = getStatus();
        if (status2 == 7 || this.retryDelayStatus == h.DELAY_RETRY_WAITING) {
            setRetryDelayStatus(h.DELAY_RETRY_DOWNLOADING);
        }
        if (status2 == 8 || this.asyncHandleStatus == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING || this.asyncHandleStatus == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART) {
            setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.byteInvalidRetryStatus == b.BYTE_INVALID_RETRY_STATUS_RESTART) {
            setByteInvalidRetryStatus(b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public boolean canStartRetryDelayTask() {
        return isNeedRetryDelay() && getStatus() != -3 && this.retryDelayStatus == h.DELAY_RETRY_WAITING;
    }

    public void setRetryDelayStatus(h hVar) {
        this.retryDelayStatus = hVar;
    }

    public boolean canReStartAsyncTask() {
        return getStatus() != -3 && this.asyncHandleStatus == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING;
    }

    public void setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a aVar) {
        this.asyncHandleStatus = aVar;
    }

    public void updateCurRetryTime(int i) {
        int i2 = (this.backUpUrlUsed ? this.backUpUrlRetryCount : this.retryCount) - i;
        this.curRetryTime = i2;
        if (i2 < 0) {
            this.curRetryTime = 0;
        }
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public long getRealDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime);
    }

    public void copyFromCacheData(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo != null) {
            setChunkCount(downloadInfo.getChunkCount());
            setTotalBytes(downloadInfo.getTotalBytes());
            setCurBytes(downloadInfo.getCurBytes(), true);
            this.realDownloadTime = downloadInfo.realDownloadTime;
            if (downloadInfo.canSkipStatusHandler() || canSkipStatusHandler()) {
                this.curRetryTime = downloadInfo.getCurRetryTime();
            } else {
                this.curRetryTime = 0;
                this.isForbiddenRetryed = false;
                this.backUpUrlUsed = false;
                this.curBackUpUrlIndex = 0;
                this.httpsToHttpRetryUsed = false;
            }
            seteTag(downloadInfo.geteTag());
            if (z) {
                setStatus(downloadInfo.getStatus());
            }
            this.isFirstDownload = downloadInfo.getIsFirstDownload();
            this.isFirstSuccess = downloadInfo.isFirstSuccess();
            this.retryDelayStatus = downloadInfo.getRetryDelayStatus();
            mergeAuxiliaryJSONObject(downloadInfo.dbJsonData);
        }
    }

    private void ensureDBJsonData() {
        if (this.dbJsonData == null) {
            synchronized (this) {
                if (this.dbJsonData == null) {
                    try {
                        if (!TextUtils.isEmpty(this.dbJsonDataString)) {
                            this.dbJsonData = new JSONObject(this.dbJsonDataString);
                        } else {
                            this.dbJsonData = new JSONObject();
                        }
                    } catch (Throwable unused) {
                        this.dbJsonData = new JSONObject();
                    }
                }
            }
        }
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    private void mergeAuxiliaryJSONObject(JSONObject jSONObject) {
        if (jSONObject != null) {
            ensureDBJsonData();
            synchronized (this.dbJsonData) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject.opt(next);
                        if (!this.dbJsonData.has(next)) {
                            if (opt != null) {
                                this.dbJsonData.put(next, opt);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
                this.dbJsonDataString = null;
            }
            parseMonitorSetting();
        }
    }

    public boolean getIsFirstDownload() {
        return this.isFirstDownload;
    }

    public boolean isFirstSuccess() {
        return this.isFirstSuccess;
    }

    public boolean equalsTask(DownloadInfo downloadInfo) {
        String str;
        String str2;
        return (downloadInfo == null || (str = this.url) == null || !str.equals(downloadInfo.getUrl()) || (str2 = this.savePath) == null || !str2.equals(downloadInfo.getSavePath())) ? false : true;
    }

    public void setId(int i) {
        this.id = i;
    }

    public boolean isDownloadWithWifiValid() {
        return !isOnlyWifi() || e.b(com.ss.android.socialbase.downloader.downloader.b.L());
    }

    public boolean isPauseReserveWithWifiValid() {
        if (!this.mDownloadFromReserveWifi) {
            return true;
        }
        if (!isPauseReserveOnWifi() || !e.b(com.ss.android.socialbase.downloader.downloader.b.L())) {
            return false;
        }
        return true;
    }

    public boolean isDownloadingStatus() {
        return DownloadStatus.isDownloading(getStatus());
    }

    public boolean isDownloadOverStatus() {
        return DownloadStatus.isDownloadOver(getStatus());
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public boolean isChunked() {
        return e.b(this.totalBytes);
    }

    public boolean isNeedPostProgress() {
        return this.needPostProgress;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public long getMinByteIntervalForPostToMainThread(long j) {
        int i = this.maxProgressCount;
        if (i <= 0) {
            i = 100;
        }
        long j2 = j / ((long) (i + 1));
        if (j2 <= 0) {
            return 1048576;
        }
        return j2;
    }

    public int getMinProgressTimeMsInterval() {
        int i = this.minProgressTimeMsInterval;
        if (i < 1000) {
            return 1000;
        }
        return i;
    }

    public boolean isEntityInvalid() {
        return TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.savePath);
    }

    public boolean isDownloaded() {
        return e.c(this);
    }

    public boolean trySwitchToNextBackupUrl() {
        if (this.backUpUrlUsed) {
            this.curBackUpUrlIndex++;
        }
        List<String> list = this.backUpUrls;
        if (!(list == null || list.size() == 0 || this.curBackUpUrlIndex < 0)) {
            while (this.curBackUpUrlIndex < this.backUpUrls.size()) {
                if (!TextUtils.isEmpty(this.backUpUrls.get(this.curBackUpUrlIndex))) {
                    this.backUpUrlUsed = true;
                    return true;
                }
                this.curBackUpUrlIndex++;
            }
        }
        return false;
    }

    public boolean hasNextBackupUrl() {
        List<String> list = this.backUpUrls;
        if (list != null && list.size() > 0) {
            if (!this.backUpUrlUsed) {
                return true;
            }
            int i = this.curBackUpUrlIndex;
            if (i >= 0 && i < this.backUpUrls.size() - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canReplaceHttpForRetry() {
        return !TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && !this.httpsToHttpRetryUsed;
    }

    public void setHttpsToHttpRetryUsed(boolean z) {
        this.httpsToHttpRetryUsed = z;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public synchronized void registerTempFileSaveCallback(aj ajVar) {
        if (ajVar != null) {
            try {
                com.ss.android.socialbase.downloader.c.a.b("DownloadInfo", "registerTempFileSaveCallback");
                if (this.tempFileSaveCompleteCallbacks == null) {
                    this.tempFileSaveCompleteCallbacks = new ArrayList();
                }
                if (!this.tempFileSaveCompleteCallbacks.contains(ajVar)) {
                    this.tempFileSaveCompleteCallbacks.add(ajVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                ajVar.a(new BaseException(1038, e.b(th, "registerTempFileSaveCallback")));
            }
            return;
        }
        return;
    }

    public void resetDataForEtagEndure(String str) {
        setCurBytes(0, true);
        setTotalBytes(0);
        seteTag(str);
        setChunkCount(1);
        this.downloadTime = 0;
        this.realStartDownloadTime = 0;
        this.realDownloadTime = 0;
    }

    public void reset() {
        setCurBytes(0, true);
        this.totalBytes = 0;
        this.chunkCount = 1;
        this.downloadTime = 0;
        this.realStartDownloadTime = 0;
        this.realDownloadTime = 0;
    }

    public void erase() {
        setCurBytes(0, true);
        this.totalBytes = 0;
        this.chunkCount = 1;
        this.downloadTime = 0;
        this.realStartDownloadTime = 0;
        this.realDownloadTime = 0;
        this.curRetryTime = 0;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.backUpUrlUsed = false;
        this.httpsToHttpRetryUsed = false;
        this.eTag = null;
        this.failedException = null;
        this.tempCacheData = null;
        this.packageInfoRef = null;
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long curBytes2 = getCurBytes();
            if (com.ss.android.socialbase.downloader.g.a.c().a("fix_file_data_valid")) {
                if (curBytes2 > 0) {
                    long j = this.totalBytes;
                    if (j > 0 && this.chunkCount > 0 && length >= curBytes2 && length <= j) {
                        return true;
                    }
                }
                com.ss.android.socialbase.downloader.c.a.d("DownloadInfo", "isFileDataValid: cur = " + curBytes2 + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
                return false;
            }
            if (length > 0 && curBytes2 > 0) {
                long j2 = this.totalBytes;
                if (j2 > 0 && this.chunkCount > 0 && length >= curBytes2 && length <= j2 && curBytes2 < j2) {
                    return true;
                }
            }
            com.ss.android.socialbase.downloader.c.a.d("DownloadInfo", "isFileDataValid: cur = " + curBytes2 + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
        }
        return false;
    }

    public boolean isFileDataExists() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (!exists || isDirectory) {
            return false;
        }
        return true;
    }

    public boolean isChunkBreakpointAvailable() {
        i x;
        if (this.chunkCount > 1 && (x = com.ss.android.socialbase.downloader.downloader.b.x()) != null) {
            List<b> c = x.c(getId());
            if (c == null || c.size() != this.chunkCount) {
                return false;
            }
            long j = 0;
            for (b bVar : c) {
                if (bVar != null) {
                    j += bVar.o();
                }
            }
            if (j != getCurBytes()) {
                setCurBytes(j);
            }
        }
        return true;
    }

    public synchronized boolean isSaveTempFile() {
        return this.isSaveTempFile;
    }

    public synchronized void setIsSaveTempFile(boolean z) {
        this.isSaveTempFile = z;
    }

    public synchronized void handleTempSaveCallback(boolean z, BaseException baseException) {
        this.isSaveTempFile = false;
        if (this.tempFileSaveCompleteCallbacks != null) {
            com.ss.android.socialbase.downloader.c.a.b("DownloadInfo", "handleTempSaveCallback isSuccess " + z + " callback size:" + this.tempFileSaveCompleteCallbacks.size());
            for (aj ajVar : this.tempFileSaveCompleteCallbacks) {
                if (ajVar != null) {
                    if (z) {
                        ajVar.a();
                    } else {
                        ajVar.a(baseException);
                    }
                }
            }
        }
    }

    public void setChunkDowngradeRetryUsed(boolean z) {
        this.chunkDowngradeRetryUsed = z;
    }

    public boolean isBreakpointAvailable() {
        if (!isFileDataValid()) {
            return false;
        }
        return isChunkBreakpointAvailable();
    }

    public boolean isFirstDownload() {
        if (this.isFirstDownload && !TextUtils.isEmpty(getTempPath()) && !TextUtils.isEmpty(getTempName())) {
            return !new File(getTempPath(), getTempName()).exists();
        }
        return false;
    }

    public boolean checkMd5Valid() {
        return e.c(getSavePath(), getName(), this.md5);
    }

    public int checkMd5Status() {
        return e.b(getSavePath(), getName(), this.md5);
    }

    public boolean isCanResumeFromBreakPointStatus() {
        int status2 = getStatus();
        if (status2 == 4 || status2 == 3 || status2 == -1 || status2 == 5 || status2 == 8) {
            return true;
        }
        if ((status2 == 1 || status2 == 2) && getCurBytes() > 0) {
            return true;
        }
        return false;
    }

    public boolean isNewTask() {
        return getStatus() == 0;
    }

    public int getChunkCount() {
        return this.chunkCount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeString(this.savePath);
        parcel.writeString(this.tempPath);
        parcel.writeByte(this.onlyWifi ? (byte) 1 : 0);
        parcel.writeString(this.extra);
        parcel.writeTypedList(this.extraHeaders);
        parcel.writeInt(this.maxBytes);
        parcel.writeStringArray(this.outIp);
        parcel.writeIntArray(this.outSize);
        parcel.writeInt(this.retryCount);
        parcel.writeInt(this.backUpUrlRetryCount);
        parcel.writeByte(this.force ? (byte) 1 : 0);
        parcel.writeByte(this.needPostProgress ? (byte) 1 : 0);
        parcel.writeInt(this.maxProgressCount);
        parcel.writeInt(this.minProgressTimeMsInterval);
        parcel.writeStringList(this.backUpUrls);
        parcel.writeByte(this.showNotification ? (byte) 1 : 0);
        parcel.writeString(this.mimeType);
        parcel.writeByte(this.needHttpsToHttpRetry ? (byte) 1 : 0);
        parcel.writeString(this.packageName);
        parcel.writeString(this.md5);
        parcel.writeByte(this.needRetryDelay ? (byte) 1 : 0);
        parcel.writeByte(this.needDefaultHttpServiceBackUp ? (byte) 1 : 0);
        parcel.writeByte(this.needReuseChunkRunnable ? (byte) 1 : 0);
        parcel.writeString(this.retryDelayTimeArray);
        parcel.writeString(this.eTag);
        parcel.writeInt(this.curRetryTime);
        parcel.writeInt(this.retryDelayStatus.ordinal());
        parcel.writeByte(this.needReuseFirstConnection ? (byte) 1 : 0);
        parcel.writeByte(this.forceIgnoreRecommendSize ? (byte) 1 : 0);
        parcel.writeString(this.networkQuality);
        parcel.writeInt(this.curBackUpUrlIndex);
        parcel.writeInt(this.notificationVisibility);
        parcel.writeInt(this.chunkCount);
        parcel.writeLong(getCurBytes());
        parcel.writeLong(this.totalBytes);
        parcel.writeInt(getRealStatus());
        parcel.writeLong(this.downloadTime);
        parcel.writeLong(this.realDownloadTime);
        parcel.writeByte(this.backUpUrlUsed ? (byte) 1 : 0);
        parcel.writeByte(this.httpsToHttpRetryUsed ? (byte) 1 : 0);
        StringBuffer stringBuffer = this.errorBytesLog;
        parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
        parcel.writeByte(this.autoResumed ? (byte) 1 : 0);
        parcel.writeByte(this.showNotificationForAutoResumed ? (byte) 1 : 0);
        parcel.writeByte(this.showNotificationForNetworkResumed ? (byte) 1 : 0);
        parcel.writeStringList(this.forbiddenBackupUrls);
        parcel.writeByte(this.needIndependentProcess ? (byte) 1 : 0);
        parcel.writeInt(this.enqueueType.ordinal());
        parcel.writeByte(this.headConnectionAvailable ? (byte) 1 : 0);
        parcel.writeInt(this.httpStatusCode);
        parcel.writeString(this.httpStatusMessage);
        parcel.writeByte(this.isSaveTempFile ? (byte) 1 : 0);
        parcel.writeByte(this.isForbiddenRetryed ? (byte) 1 : 0);
        parcel.writeByte(this.newSaveTempFileEnable ? (byte) 1 : 0);
        parcel.writeByte(this.addListenerToSameTask ? (byte) 1 : 0);
        parcel.writeByte(this.needChunkDowngradeRetry ? (byte) 1 : 0);
        parcel.writeByte(this.chunkDowngradeRetryUsed ? (byte) 1 : 0);
        parcel.writeParcelable(this.failedException, i);
        parcel.writeInt(this.retryScheduleMinutes);
        parcel.writeString(getDBJsonDataString());
        parcel.writeByte(this.supportPartial ? (byte) 1 : 0);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.appVersionCode);
    }

    public BaseException getFailedException() {
        return this.failedException;
    }

    public void setFailedException(BaseException baseException) {
        this.failedException = baseException;
    }

    private void ensureSpData() {
        if (this.spData == null) {
            Context L = com.ss.android.socialbase.downloader.downloader.b.L();
            if (L != null) {
                String string = L.getSharedPreferences("sp_download_info", 0).getString(Long.toString((long) getId()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.spData = new JSONObject(string);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (this.spData == null) {
                this.spData = new JSONObject();
            }
        }
    }

    public void updateSpData() {
        Context L;
        if (this.spData != null && (L = com.ss.android.socialbase.downloader.downloader.b.L()) != null) {
            L.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
        }
    }

    public void clearSpData() {
        Context L = com.ss.android.socialbase.downloader.downloader.b.L();
        if (L != null) {
            try {
                L.getSharedPreferences("sp_download_info", 0).edit().remove(Integer.toString(getId())).apply();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public int getFailedResumeCount() {
        ensureSpData();
        return this.spData.optInt("failed_resume_count", 0);
    }

    public void setFailedResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put("failed_resume_count", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getLastFailedResumeTime() {
        ensureSpData();
        return this.spData.optLong("last_failed_resume_time", 0);
    }

    public void setLastFailedResumeTime(long j) {
        ensureSpData();
        try {
            this.spData.put("last_failed_resume_time", j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getUninstallResumeCount() {
        ensureSpData();
        return this.spData.optInt("unins_resume_count", 0);
    }

    public void setUninstallResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put("unins_resume_count", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getLastUninstallResumeTime() {
        ensureSpData();
        return this.spData.optLong("last_unins_resume_time", 0);
    }

    public void setLastUninstallResumeTime(long j) {
        ensureSpData();
        try {
            this.spData.put("last_unins_resume_time", j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSpStringVal(String str) {
        ensureSpData();
        return this.spData.optString(str, null);
    }

    public int getSpIntVal(String str) {
        ensureSpData();
        return this.spData.optInt(str, 0);
    }

    public long getSpLongVal(String str) {
        ensureSpData();
        return this.spData.optLong(str, 0);
    }

    public void setSpValue(String str, String str2) {
        ensureSpData();
        try {
            this.spData.put(str, str2);
            updateSpData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getLastDownloadTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_last_start_download_time", 0);
    }

    public int getAntiHijackErrorCode(int i) {
        ensureDBJsonData();
        return this.dbJsonData.optInt("anti_hijack_error_code", i);
    }

    public void setAntiHijackErrorCode(int i) {
        safePutToDBJsonData("anti_hijack_error_code", Integer.valueOf(i));
    }

    public boolean isSavePathRedirected() {
        ensureDBJsonData();
        return this.dbJsonData.optBoolean("is_save_path_redirected", false);
    }

    public void setSavePathRedirected(boolean z) {
        safePutToDBJsonData("is_save_path_redirected", Boolean.valueOf(z));
    }

    @Override // java.lang.Object
    public String toString() {
        return "DownloadInfo{id=" + this.id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "'}";
    }

    public int getPreconnectLevel() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("dbjson_key_preconnect_level", 0);
    }

    public void setPreconnectLevel(int i) {
        ensureDBJsonData();
        safePutToDBJsonData("dbjson_key_preconnect_level", Integer.valueOf(i));
    }

    private void ensureTempCacheData() {
        if (this.tempCacheData == null) {
            synchronized (this) {
                if (this.tempCacheData == null) {
                    this.tempCacheData = new ConcurrentHashMap<>();
                }
            }
        }
    }

    public ConcurrentHashMap<String, Object> getTempCacheData() {
        ensureTempCacheData();
        return this.tempCacheData;
    }

    public boolean isSupportPartial() {
        return this.supportPartial;
    }

    public int getExecutorGroup() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("executor_group", 2);
    }

    public String getDBJsonString(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optString(str);
    }

    public int getDBJsonInt(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(str);
    }

    public void setThrottleNetSpeed(long j) {
        this.throttleNetSpeed = j;
    }

    public void setOpenLimitSpeed(boolean z) {
        this.openLimitSpeed = z;
    }

    public boolean getOpenLimitSpeed() {
        return this.openLimitSpeed;
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public int getStatusAtDbInit() {
        return this.statusAtDbInit;
    }

    public void setStatusAtDbInit(int i) {
        this.statusAtDbInit = i;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfoRef = new SoftReference<>(packageInfo);
    }

    public PackageInfo getPackageInfo() {
        SoftReference<PackageInfo> softReference = this.packageInfoRef;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public double getDownloadSpeed() {
        double curBytes2 = ((double) getCurBytes()) / 1048576.0d;
        double realDownloadTime2 = ((double) getRealDownloadTime()) / 1000.0d;
        if (curBytes2 <= 0.0d || realDownloadTime2 <= 0.0d) {
            return -1.0d;
        }
        return curBytes2 / realDownloadTime2;
    }

    public int getPausedResumeCount() {
        ensureSpData();
        return this.spData.optInt("paused_resume_count", 0);
    }

    public void setPausedResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put("paused_resume_count", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class a {
        private String A;
        private long B;
        private boolean C;
        private String D;
        private boolean E;
        private boolean F;
        private f G = f.ENQUEUE_NONE;
        private boolean H;
        private boolean I;
        private boolean J;
        private String K;
        private long L;
        private boolean M;
        private boolean N = true;
        private boolean O;
        private JSONObject P;
        private boolean Q = true;
        private String R;
        private int[] S;
        private int T;
        private boolean U;
        private boolean V;
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private boolean f;
        private String g;
        private List<c> h;
        private int i;
        private String[] j;
        private int[] k;

        /* renamed from: l  reason: collision with root package name */
        private int f1418l;
        private int m;
        private boolean n;
        private boolean o = true;
        private int p;
        private int q;
        private List<String> r;
        private boolean s;
        private String t;
        private boolean u;
        private boolean v;
        private boolean w;
        private boolean x = true;
        private boolean y;
        private String z;

        public a() {
        }

        public a(String str) {
            this.c = str;
        }

        public a a(String str) {
            this.a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a d(String str) {
            this.d = str;
            return this;
        }

        public a e(String str) {
            this.e = str;
            return this;
        }

        public a f(String str) {
            this.g = str;
            return this;
        }

        public a a(boolean z2) {
            this.f = z2;
            return this;
        }

        public a a(List<c> list) {
            this.h = list;
            return this;
        }

        public a a(int i2) {
            this.i = i2;
            return this;
        }

        public a a(String[] strArr) {
            this.j = strArr;
            return this;
        }

        public a a(int[] iArr) {
            this.k = iArr;
            return this;
        }

        public a b(int i2) {
            this.f1418l = i2;
            return this;
        }

        public a c(int i2) {
            this.m = i2;
            return this;
        }

        public a b(boolean z2) {
            this.n = z2;
            return this;
        }

        public a c(boolean z2) {
            this.o = z2;
            return this;
        }

        public a d(int i2) {
            this.p = i2;
            return this;
        }

        public a e(int i2) {
            this.q = i2;
            return this;
        }

        public a b(List<String> list) {
            this.r = list;
            return this;
        }

        public a g(String str) {
            this.t = str;
            return this;
        }

        public a d(boolean z2) {
            this.u = z2;
            return this;
        }

        public a e(boolean z2) {
            this.s = z2;
            return this;
        }

        public a f(boolean z2) {
            this.v = z2;
            return this;
        }

        public a g(boolean z2) {
            this.w = z2;
            return this;
        }

        public a h(boolean z2) {
            this.x = z2;
            return this;
        }

        public a i(boolean z2) {
            this.y = z2;
            return this;
        }

        public a h(String str) {
            this.z = str;
            return this;
        }

        public a i(String str) {
            this.A = str;
            return this;
        }

        public a a(long j2) {
            this.B = j2;
            return this;
        }

        public a j(boolean z2) {
            this.C = z2;
            return this;
        }

        public a j(String str) {
            this.D = str;
            return this;
        }

        public a k(boolean z2) {
            this.E = z2;
            return this;
        }

        public a l(boolean z2) {
            this.F = z2;
            return this;
        }

        public a a(f fVar) {
            this.G = fVar;
            return this;
        }

        public a m(boolean z2) {
            this.H = z2;
            return this;
        }

        public a n(boolean z2) {
            this.I = z2;
            return this;
        }

        public a o(boolean z2) {
            this.J = z2;
            return this;
        }

        public a p(boolean z2) {
            this.N = z2;
            return this;
        }

        public a q(boolean z2) {
            this.O = z2;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.P = jSONObject;
            return this;
        }

        public a r(boolean z2) {
            this.Q = z2;
            return this;
        }

        public a k(String str) {
            this.R = str;
            return this;
        }

        public a b(int[] iArr) {
            this.S = iArr;
            return this;
        }

        public a l(String str) {
            this.K = str;
            return this;
        }

        public a f(int i2) {
            this.T = i2;
            return this;
        }

        public a b(long j2) {
            this.L = j2;
            return this;
        }

        public a s(boolean z2) {
            this.M = z2;
            return this;
        }

        public a t(boolean z2) {
            this.U = z2;
            return this;
        }

        public a u(boolean z2) {
            this.V = z2;
            return this;
        }

        public DownloadInfo a() {
            return new DownloadInfo(this);
        }
    }
}
