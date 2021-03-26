package com.tencent.imsdk.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.TIMBackgroundParam;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConnListener;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMNetworkStatus;
import com.tencent.imsdk.TIMOfflinePushSettings;
import com.tencent.imsdk.TIMOfflinePushToken;
import com.tencent.imsdk.TIMSdkConfig;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.TIMUserStatusListener;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.common.IContextFetcher;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupBaseManager;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.IMSystemUtil;
import com.tencent.imsdk.session.IConnectionListener;
import com.tencent.imsdk.utils.IMFunc;
import java.io.File;
import java.util.UUID;
import java.util.regex.Pattern;

public class BaseManager {
    private static final String TAG = "BaseManager";
    private static final BaseManager instance = new BaseManager();
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static boolean sIsSoLoaded;
    private boolean inited;
    private boolean isV2Api = false;
    private Context mContext;
    private IConnectionListener mInternalIConnectionListener;
    private TIMUserStatusListener mInternalTIMUserStatusListener;
    private int mLoginState = 3;
    private TIMNetworkStatus mNetworkStatus;
    private TIMSdkConfig mSdkConfig = new TIMSdkConfig(0);
    private TIMUserConfig mUserConfig = new TIMUserConfig();
    private int mode = 1;

    static {
        sIsSoLoaded = false;
        sIsSoLoaded = IMSystemUtil.ExperimentalAPI.loadLibrary(null);
    }

    private BaseManager() {
        IMContext.getInstance().init(new IContextFetcher() {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass1 */

            @Override // com.tencent.imsdk.common.IContextFetcher
            public boolean isInited() {
                return BaseManager.this.isInited();
            }

            @Override // com.tencent.imsdk.common.IContextFetcher
            public boolean isOnline() {
                return BaseManager.this.isLogined();
            }

            @Override // com.tencent.imsdk.common.IContextFetcher
            public Context getContext() {
                return BaseManager.this.mContext;
            }
        });
    }

    public static BaseManager getInstance() {
        return instance;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setV2Api() {
        this.isV2Api = true;
    }

    public boolean init(Context context, TIMSdkConfig tIMSdkConfig) {
        if (!sIsSoLoaded) {
            Log.e("BaseManager", "libImSDK is not loaded!");
            return false;
        } else if (context == null || tIMSdkConfig == null) {
            QLog.e("BaseManager", "init with invalid param context: " + context + "|config: " + tIMSdkConfig);
            return false;
        } else {
            this.mContext = context.getApplicationContext();
            String version = getVersion();
            SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
            edit.putString("ebfa608d4d", version);
            edit.commit();
            String initLogPath = initLogPath(tIMSdkConfig.getLogPath());
            tIMSdkConfig.setLogPath(initLogPath);
            int clientInstType = IMFunc.getClientInstType();
            initReportFile(context);
            QLog.v("BaseManager", "init:" + tIMSdkConfig.toString() + ", BuglySdkInfos sdkappid:ebfa608d4d, ver:" + version);
            NetConnectInfoCenter.getInstance().init(context);
            initConnectionListener();
            initUserStatusListener();
            boolean isTUIKit = isTUIKit();
            this.mSdkConfig = tIMSdkConfig;
            loadConversationModule();
            loadGroupModule();
            loadFriendshipModule();
            NativeManager.nativeInitSdk((long) tIMSdkConfig.getSdkAppId(), initLogPath, getFilePath(context), getDeviceId(), Build.MODEL, Build.VERSION.RELEASE, clientInstType, isTUIKit, tIMSdkConfig.isTestEnv(), this.isV2Api);
            NativeManager.initNativeLog(tIMSdkConfig.getLogLevel(), tIMSdkConfig.getLogCallbackLevel(), tIMSdkConfig.isLogPrintEnabled(), tIMSdkConfig.getLogListener());
            this.inited = true;
            return true;
        }
    }

    private boolean isTUIKit() {
        StackTraceElement[] stackTrace;
        try {
            if (Class.forName("com.tencent.qcloud.tim.uikit.TUIKit") != null) {
                return true;
            }
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getClassName().contains("TUIKitImpl")) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
        }
    }

    private void initUserStatusListener() {
        this.mInternalTIMUserStatusListener = new TIMUserStatusListener() {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass2 */

            @Override // com.tencent.imsdk.TIMUserStatusListener
            public void onForceOffline() {
                QLog.i("BaseManager", "onForceOffline user id:" + BaseManager.this.getLoginUser());
                BaseManager.this.mLoginState = 3;
                if (BaseManager.this.getUserConfig() == null) {
                    QLog.e("BaseManager", "onForceOffline no user config found");
                    return;
                }
                final TIMUserStatusListener userStatusListener = BaseManager.this.getUserConfig().getUserStatusListener();
                if (userStatusListener == null) {
                    QLog.e("BaseManager", "onForceOffline no listener of userConfig found");
                } else {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass2.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            TIMUserStatusListener tIMUserStatusListener = userStatusListener;
                            if (tIMUserStatusListener != null) {
                                tIMUserStatusListener.onForceOffline();
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.imsdk.TIMUserStatusListener
            public void onUserSigExpired() {
                QLog.i("BaseManager", "onUserSigExpired user id:" + BaseManager.this.getLoginUser());
                BaseManager.this.mLoginState = 3;
                if (TextUtils.isEmpty(BaseManager.this.getLoginUser())) {
                    QLog.i("BaseManager", "onUserSigExpired login user is empty, no need to logout and callback");
                } else if (BaseManager.this.getUserConfig() == null) {
                    QLog.e("BaseManager", "onUserSigExpired no user config found");
                } else {
                    final TIMUserStatusListener userStatusListener = BaseManager.this.getUserConfig().getUserStatusListener();
                    if (userStatusListener == null) {
                        QLog.e("BaseManager", "onUserSigExpired no listener of userConfig found");
                    } else {
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass2.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public void run() {
                                TIMUserStatusListener tIMUserStatusListener = userStatusListener;
                                if (tIMUserStatusListener != null) {
                                    tIMUserStatusListener.onUserSigExpired();
                                }
                            }
                        });
                    }
                }
            }
        };
    }

    private void initConnectionListener() {
        this.mInternalIConnectionListener = new IConnectionListener() {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass3 */

            @Override // com.tencent.imsdk.session.IConnectionListener
            public void onConnected() {
                QLog.i("BaseManager", "onConnected");
                BaseManager.this.mNetworkStatus = TIMNetworkStatus.TIM_NETWORK_STATUS_CONNECTED;
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass3.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        TIMUserConfig userConfig = BaseManager.this.getUserConfig();
                        if (userConfig == null) {
                            QLog.e("BaseManager", "onConnected no user config found");
                            return;
                        }
                        TIMConnListener connectionListener = userConfig.getConnectionListener();
                        if (connectionListener != null) {
                            connectionListener.onConnected();
                        } else {
                            QLog.i("BaseManager", "no connection listener found");
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.session.IConnectionListener
            public void onDisconnected(final int i, final String str) {
                QLog.i("BaseManager", "onDisconnected, code: " + i + "|descr: " + str);
                BaseManager.this.mNetworkStatus = TIMNetworkStatus.TIM_NETWORK_STATUS_DISCONNECTED;
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass3.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        TIMUserConfig userConfig = BaseManager.this.getUserConfig();
                        if (userConfig == null) {
                            QLog.e("BaseManager", "onDisconnected no user config found");
                            return;
                        }
                        TIMConnListener connectionListener = userConfig.getConnectionListener();
                        if (connectionListener != null) {
                            connectionListener.onDisconnected(i, str);
                        } else {
                            QLog.i("BaseManager", "no connection listener found");
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.session.IConnectionListener
            public void onConnecting() {
                QLog.i("BaseManager", "onConnecting");
            }

            @Override // com.tencent.imsdk.session.IConnectionListener
            public void onConnectFailed(int i, String str) {
                QLog.i("BaseManager", "onConnectFailed, code: " + i + "|descr: " + str);
            }

            @Override // com.tencent.imsdk.session.IConnectionListener
            public void onWifiNeedAuth(final String str) {
                QLog.i("BaseManager", "onWifiNeedAuth, wifi name: " + str);
                BaseManager.this.mNetworkStatus = TIMNetworkStatus.TIM_NETWORK_STATUS_DISCONNECTED;
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass3.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        TIMUserConfig userConfig = BaseManager.this.getUserConfig();
                        if (userConfig == null) {
                            QLog.e("BaseManager", "onWifiNeedAuth no user config found");
                            return;
                        }
                        TIMConnListener connectionListener = userConfig.getConnectionListener();
                        if (connectionListener != null) {
                            connectionListener.onWifiNeedAuth(str);
                        } else {
                            QLog.i("BaseManager", "no connection listener found");
                        }
                    }
                });
            }
        };
    }

    IConnectionListener getConnectionListener() {
        return this.mInternalIConnectionListener;
    }

    TIMUserStatusListener getTIMUserStatusListener() {
        return this.mInternalTIMUserStatusListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    private String getDeviceId() {
        String str;
        String uuid;
        boolean z = false;
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("DeviceInfo", 0);
        if (!sharedPreferences.contains("DeviceID")) {
            uuid = UUID.randomUUID().toString();
        } else {
            str = sharedPreferences.getString("DeviceID", "");
            if (!Pattern.matches("\\w{8}(-\\w{4}){3}-\\w{12}", str) || TextUtils.isEmpty(str)) {
                uuid = UUID.randomUUID().toString();
            }
            if (z) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("DeviceID", str);
                edit.apply();
            }
            return str;
        }
        str = uuid;
        z = true;
        if (z) {
        }
        return str;
    }

    public String initLogPath(String str) {
        QLog.i("BaseManager", "initLogPath logPath: " + str);
        if (this.mContext == null) {
            QLog.e("BaseManager", "initLogPath mContext is null");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            File externalFilesDir = this.mContext.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                str = "/sdcard/Android/data/" + this.mContext.getPackageName() + "/log/tencent/imsdk";
            } else {
                str = externalFilesDir.getAbsolutePath() + "/log/tencent/imsdk";
            }
        }
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            file = this.mContext.getFilesDir();
            QLog.d("BaseManager", "create imsdklogs folder failed");
        }
        QLog.v("BaseManager", "logPath: " + file.getAbsolutePath() + "/");
        return file.getAbsolutePath() + "/";
    }

    private void initReportFile(Context context) {
        try {
            context.openFileOutput("imsdk_report", 32768).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getFilePath(Context context) {
        return context.getFilesDir().toString();
    }

    public boolean unInit() {
        try {
            this.inited = false;
            NetConnectInfoCenter.getInstance().uninit();
            NativeManager.nativeUnInitSdk();
            return true;
        } catch (Exception e) {
            QLog.writeException("BaseManager", "unInit fail, exception: ", e);
            return false;
        }
    }

    public void login(String str, String str2, boolean z, TIMCallBack tIMCallBack) {
        if (!this.inited) {
            QLog.e("BaseManager", "sdk not initialized");
            tIMCallBack.onError(6017, "sdk not initialized");
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("BaseManager", "identifier is empty");
            tIMCallBack.onError(6017, "identifier is empty");
        } else {
            final TIMUser tIMUser = new TIMUser();
            tIMUser.setIdentifier(str);
            tIMUser.setSdkAppid((long) getSdkAppId());
            tIMUser.setAppIdAt3rd(String.valueOf(getSdkAppId()));
            this.mLoginState = 2;
            NativeManager.nativeLogin(str, str2, z, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass4 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    BaseManager.this.mLoginState = 1;
                    QLog.i("BaseManager", "Login succ, user:" + tIMUser);
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    BaseManager.this.mLoginState = 3;
                    QLog.i("BaseManager", "Login failed, code:" + i + "|msg:" + str);
                    super.fail(i, str);
                }
            });
        }
    }

    public void logout(TIMCallBack tIMCallBack) {
        final String loginUser = getLoginUser();
        QLog.i("BaseManager", "Logout, user " + loginUser);
        if (!this.inited) {
            QLog.e("BaseManager", "Logout failed, sdk not initialized");
            if (tIMCallBack != null) {
                tIMCallBack.onError(6017, "sdk not initialized");
                return;
            }
            return;
        }
        NativeManager.nativeLogout(new ICallback(tIMCallBack) {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass5 */

            @Override // com.tencent.imsdk.common.ICallback
            public void done(Object obj) {
                QLog.i("BaseManager", "Logout succ, user " + loginUser);
                BaseManager.this.mLoginState = 3;
                super.done(obj);
            }

            @Override // com.tencent.imsdk.common.ICallback
            public void fail(int i, String str) {
                BaseManager.this.mLoginState = 3;
                QLog.e("BaseManager", "Logout failed, user " + loginUser + ", code " + i + "|descr " + str);
                super.fail(i, str);
            }
        });
    }

    public int getLoginStatus() {
        if (this.mLoginState == 1 && TextUtils.isEmpty(getLoginUser())) {
            this.mLoginState = 3;
        }
        return this.mLoginState;
    }

    public TIMUserConfig getUserConfig() {
        return this.mUserConfig;
    }

    public void setUserConfig(TIMUserConfig tIMUserConfig) {
        this.mUserConfig = tIMUserConfig;
        NativeManager.nativeSetUserConfig(tIMUserConfig);
    }

    public TIMNetworkStatus getNetworkStatus() {
        return this.mNetworkStatus;
    }

    public void setToken(TIMOfflinePushToken tIMOfflinePushToken, TIMCallBack tIMCallBack) {
        int clientInstType = IMFunc.getClientInstType();
        QLog.i("BaseManager", "setToken: token=" + tIMOfflinePushToken.getBussid() + ":" + tIMOfflinePushToken.getToken() + ":" + clientInstType);
        NativeManager.nativeSetToken(clientInstType, (int) tIMOfflinePushToken.getBussid(), tIMOfflinePushToken.getToken(), new ICallback(tIMCallBack) {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass6 */

            @Override // com.tencent.imsdk.common.ICallback
            public void done(Object obj) {
                QLog.i("BaseManager", "setToken succ");
                super.done(obj);
            }

            @Override // com.tencent.imsdk.common.ICallback
            public void fail(int i, String str) {
                QLog.e("BaseManager", "setToken failed, code " + i + "|descr " + str);
                super.fail(i, str);
            }
        });
    }

    public int initStorage(String str, TIMCallBack tIMCallBack) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("BaseManager", "initStorage, identifier is empty, ignore");
            return 1;
        } else if (TextUtils.isEmpty(getLoginUser())) {
            return NativeManager.nativeInitStorage(str, new ICallback(tIMCallBack) {
                /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass7 */

                @Override // com.tencent.imsdk.common.ICallback
                public void done(Object obj) {
                    QLog.i("BaseManager", "initStorage succ");
                    super.done(obj);
                }

                @Override // com.tencent.imsdk.common.ICallback
                public void fail(int i, String str) {
                    QLog.e("BaseManager", "initStorage failed, code " + i + "|descr " + str);
                    super.fail(i, str);
                }
            });
        } else {
            QLog.e("BaseManager", "initStorage, current login user is " + getLoginUser() + ", you need call logout first");
            return 1;
        }
    }

    public void setOfflinePushConfig(TIMOfflinePushSettings tIMOfflinePushSettings) {
        int i = tIMOfflinePushSettings.isEnabled() ? 1 : 2;
        String str = "";
        String uri = tIMOfflinePushSettings.getC2cMsgRemindSound() != null ? tIMOfflinePushSettings.getC2cMsgRemindSound().toString() : str;
        String uri2 = tIMOfflinePushSettings.getGroupMsgRemindSound() != null ? tIMOfflinePushSettings.getGroupMsgRemindSound().toString() : str;
        if (tIMOfflinePushSettings.getVideoSound() != null) {
            str = tIMOfflinePushSettings.getVideoSound().toString();
        }
        NativeManager.nativeSetOfflinePushConfig(i, uri, uri2, str, new ICallback(null) {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass8 */

            @Override // com.tencent.imsdk.common.ICallback
            public void done(Object obj) {
                QLog.i("BaseManager", "setOfflinePushConfig succ");
                super.done(obj);
            }

            @Override // com.tencent.imsdk.common.ICallback
            public void fail(int i, String str) {
                QLog.e("BaseManager", "setOfflinePushConfig failed, code = " + i + ", descr = " + str);
                super.fail(i, str);
            }
        });
    }

    public void getOfflinePushConfig(TIMValueCallBack<TIMOfflinePushSettings> tIMValueCallBack) {
        NativeManager.nativeGetOfflinePushConfig(new ICallback<TIMOfflinePushSettings>(tIMValueCallBack) {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass9 */

            public void done(TIMOfflinePushSettings tIMOfflinePushSettings) {
                QLog.i("BaseManager", "getOfflinePushConfig succ");
                super.done((AnonymousClass9) tIMOfflinePushSettings);
            }

            @Override // com.tencent.imsdk.common.ICallback
            public void fail(int i, String str) {
                QLog.e("BaseManager", "getOfflinePushConfig failed, code = " + i + ", descr = " + str);
                super.fail(i, str);
            }
        });
    }

    public void doBackground(TIMBackgroundParam tIMBackgroundParam, TIMCallBack tIMCallBack) {
        NativeManager.nativeDoBackground(IMFunc.getClientInstType(), tIMBackgroundParam, new ICallback(tIMCallBack) {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass10 */

            @Override // com.tencent.imsdk.common.ICallback
            public void done(Object obj) {
                QLog.i("BaseManager", "doBackground success");
                super.done(obj);
            }

            @Override // com.tencent.imsdk.common.ICallback
            public void fail(int i, String str) {
                QLog.i("BaseManager", "doBackground err code = " + i + ", desc = " + str);
                super.fail(i, str);
            }
        });
    }

    public void doForeground(TIMCallBack tIMCallBack) {
        NativeManager.nativeDoForeground(IMFunc.getClientInstType(), new ICallback(tIMCallBack) {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass11 */

            @Override // com.tencent.imsdk.common.ICallback
            public void done(Object obj) {
                QLog.i("BaseManager", "doForeground success");
                super.done(obj);
            }

            @Override // com.tencent.imsdk.common.ICallback
            public void fail(int i, String str) {
                QLog.i("BaseManager", "doForeground err code = " + i + ", desc = " + str);
                super.fail(i, str);
            }
        });
    }

    public void setCustomVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("BaseManager", "setCustomVersion empty, ignore");
            return;
        }
        QLog.e("BaseManager", "setCustomVersion = " + str);
        NativeManager.nativeSetCustomVersion(str);
    }

    public void setOnlyDNSSource() {
        NativeManager.nativeSetOnlyDNSSource();
    }

    public void reduceUnreadNumberWhenRemoveMessage() {
        NativeManager.nativeReduceUnreadNumberWhenRemoveMessage();
    }

    public String getLoginUser() {
        return NativeManager.nativeGetIdentifier();
    }

    public long getTinyId() {
        return NativeManager.nativeGetTinyid();
    }

    public int getSdkAppId() {
        TIMSdkConfig tIMSdkConfig = this.mSdkConfig;
        if (tIMSdkConfig == null) {
            return 0;
        }
        return tIMSdkConfig.getSdkAppId();
    }

    public TIMSdkConfig getmSdkConfig() {
        return this.mSdkConfig;
    }

    public long getServerTimeDiff() {
        return NativeManager.nativeGetServerTimeDiff();
    }

    public long getServerTime() {
        return NativeManager.nativeGetServerTime();
    }

    public boolean isInited() {
        return this.inited;
    }

    public boolean isLogined() {
        return this.mLoginState == 1;
    }

    public String getVersion() {
        return NativeManager.nativeGetVersion();
    }

    public static void loginErrOnMainthread(final TIMCallBack tIMCallBack, final int i, final String str) {
        mainHandler.post(new Runnable() {
            /* class com.tencent.imsdk.manager.BaseManager.AnonymousClass12 */

            @Override // java.lang.Runnable
            public void run() {
                tIMCallBack.onError(i, str);
            }
        });
    }

    private void loadConversationModule() {
        ConversationManager.getInstance().init();
    }

    private void loadGroupModule() {
        GroupBaseManager.getInstance().initGroupModule();
    }

    private void loadFriendshipModule() {
        QLog.v("BaseManager", "loadFriendshipModule init statt");
        TIMFriendshipManager.getInstance().init();
    }
}
