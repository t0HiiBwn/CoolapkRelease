package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;
import androidx.media.MediaBrowserServiceCompatApi26;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
    private static final float EPSILON = 1.0E-5f;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap<>();
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler = new ServiceHandler();
    private MediaBrowserServiceImpl mImpl;
    MediaSessionCompat.Token mSession;

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token token);
    }

    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract BrowserRoot onGetRoot(String str, int i, Bundle bundle);

    public abstract void onLoadChildren(String str, Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onSubscribe(String str, Bundle bundle) {
    }

    public void onUnsubscribe(String str) {
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;

        MediaBrowserServiceImplBase() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
                return this.mMessenger.getBinder();
            }
            return null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<ConnectionRecord> it2 = MediaBrowserServiceCompat.this.mConnections.values().iterator();
                    while (it2.hasNext()) {
                        ConnectionRecord next = it2.next();
                        try {
                            next.callbacks.onConnect(next.root.getRootId(), token, next.root.getExtras());
                        } catch (RemoteException unused) {
                            Log.w("MBServiceCompat", "Connection for " + next.pkg + " is no longer valid.");
                            it2.remove();
                        }
                    }
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        ArrayMap<IBinder, ConnectionRecord> arrayMap = MediaBrowserServiceCompat.this.mConnections;
                        MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(arrayMap.get(iBinder), str, bundle);
                    }
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(final MediaSessionManager.RemoteUserInfo remoteUserInfo, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.size(); i++) {
                        ConnectionRecord valueAt = MediaBrowserServiceCompat.this.mConnections.valueAt(i);
                        if (valueAt.browserInfo.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(valueAt, str, bundle);
                            return;
                        }
                    }
                }
            });
        }

        void notifyChildrenChangedOnHandler(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair<IBinder, Bundle> pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.second, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
    }

    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList = new ArrayList();
        Object mServiceObj;

        MediaBrowserServiceImplApi21() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object createService = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
            this.mServiceObj = createService;
            MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty()) {
                        IMediaSession extraBinder = token.getExtraBinder();
                        if (extraBinder != null) {
                            for (Bundle bundle : MediaBrowserServiceImplApi21.this.mRootExtrasList) {
                                BundleCompat.putBinder(bundle, "extra_session_binder", extraBinder.asBinder());
                            }
                        }
                        MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
                    }
                    MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceImplApi21.this.mServiceObj, token.getToken());
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String str, Bundle bundle) {
            notifyChildrenChangedForFramework(str, bundle);
            notifyChildrenChangedForCompat(str, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            notifyChildrenChangedForCompat(remoteUserInfo, str, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            Bundle bundle2;
            IBinder iBinder;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                BundleCompat.putBinder(bundle2, "extra_messenger", this.mMessenger.getBinder());
                if (MediaBrowserServiceCompat.this.mSession != null) {
                    IMediaSession extraBinder = MediaBrowserServiceCompat.this.mSession.getExtraBinder();
                    if (extraBinder == null) {
                        iBinder = null;
                    } else {
                        iBinder = extraBinder.asBinder();
                    }
                    BundleCompat.putBinder(bundle2, "extra_session_binder", iBinder);
                } else {
                    this.mRootExtrasList.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.mCurConnection = new ConnectionRecord(str, -1, i, bundle, null);
            BrowserRoot onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            MediaBrowserServiceCompat.this.mCurConnection = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle2.putAll(onGetRoot.getExtras());
            }
            return new MediaBrowserServiceCompatApi21.BrowserRoot(onGetRoot.getRootId(), bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(String str, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) {
                /* class androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.AnonymousClass2 */

                /* access modifiers changed from: package-private */
                public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList);
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    resultWrapper.detach();
                }
            });
        }

        void notifyChildrenChangedForFramework(String str, Bundle bundle) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
        }

        void notifyChildrenChangedForCompat(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        ArrayMap<IBinder, ConnectionRecord> arrayMap = MediaBrowserServiceCompat.this.mConnections;
                        MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(arrayMap.get(iBinder), str, bundle);
                    }
                }
            });
        }

        void notifyChildrenChangedForCompat(final MediaSessionManager.RemoteUserInfo remoteUserInfo, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.size(); i++) {
                        ConnectionRecord valueAt = MediaBrowserServiceCompat.this.mConnections.valueAt(i);
                        if (valueAt.browserInfo.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(valueAt, str, bundle);
                        }
                    }
                }
            });
        }

        void notifyChildrenChangedForCompatOnHandler(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair<IBinder, Bundle> pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.second, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.mMessenger == null) {
                return null;
            }
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
    }

    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        MediaBrowserServiceImplApi23() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(String str, final MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new Result<MediaBrowserCompat.MediaItem>(str) {
                /* class androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
                    if (mediaItem == null) {
                        resultWrapper.sendResult(null);
                        return;
                    }
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    resultWrapper.sendResult(obtain);
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    resultWrapper.detach();
                }
            });
        }
    }

    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        MediaBrowserServiceImplApi26() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi26.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(String str, final MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) {
                /* class androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList, getFlags());
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    resultWrapper.detach();
                }
            }, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
            }
            if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        void notifyChildrenChangedForFramework(String str, Bundle bundle) {
            if (bundle != null) {
                MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, str, bundle);
            } else {
                super.notifyChildrenChangedForFramework(str, bundle);
            }
        }
    }

    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        MediaBrowserServiceImplApi28() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
            }
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.mServiceObj).getCurrentBrowserInfo());
        }
    }

    private final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;

        ServiceHandler() {
            this.mServiceBinderImpl = new ServiceBinderImpl();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.mServiceBinderImpl.connect(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 2:
                    this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.mServiceBinderImpl.addSubscription(data.getString("data_media_item_id"), BundleCompat.getBinder(data, "data_callback_token"), bundle2, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 4:
                    this.mServiceBinderImpl.removeSubscription(data.getString("data_media_item_id"), BundleCompat.getBinder(data, "data_callback_token"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 5:
                    this.mServiceBinderImpl.getMediaItem(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.mServiceBinderImpl.search(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.mServiceBinderImpl.sendCustomAction(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }

        public void postOrRun(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    private class ConnectionRecord implements IBinder.DeathRecipient {
        public final MediaSessionManager.RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap<>();
        public final int uid;

        ConnectionRecord(String str, int i, int i2, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.pkg = str;
            this.pid = i;
            this.uid = i2;
            this.browserInfo = new MediaSessionManager.RemoteUserInfo(str, i, i2);
            this.rootHints = bundle;
            this.callbacks = serviceCallbacks;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.ConnectionRecord.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserServiceCompat.this.mConnections.remove(ConnectionRecord.this.callbacks.asBinder());
                }
            });
        }
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        void onResultSent(T t) {
        }

        Result(Object obj) {
            this.mDebug = obj;
        }

        public void sendResult(T t) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendResultCalled = true;
            onResultSent(t);
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            checkExtraFields(bundle);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(bundle);
        }

        public void sendError(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendErrorCalled = true;
            onErrorSent(bundle);
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            } else if (this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            } else if (!this.mSendErrorCalled) {
                this.mDetachCalled = true;
            } else {
                throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
            }
        }

        boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
        }

        void setFlags(int i) {
            this.mFlags = i;
        }

        int getFlags() {
            return this.mFlags;
        }

        void onProgressUpdateSent(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        void onErrorSent(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        private void checkExtraFields(Bundle bundle) {
            if (bundle != null && bundle.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS")) {
                float f = bundle.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
                if (f < -1.0E-5f || f > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }
    }

    private class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void connect(final String str, final int i, final int i2, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
            if (MediaBrowserServiceCompat.this.isValidPackage(str, i2)) {
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                    /* class androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        IBinder asBinder = serviceCallbacks.asBinder();
                        MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                        ConnectionRecord connectionRecord = new ConnectionRecord(str, i, i2, bundle, serviceCallbacks);
                        MediaBrowserServiceCompat.this.mCurConnection = connectionRecord;
                        connectionRecord.root = MediaBrowserServiceCompat.this.onGetRoot(str, i2, bundle);
                        MediaBrowserServiceCompat.this.mCurConnection = null;
                        if (connectionRecord.root == null) {
                            Log.i("MBServiceCompat", "No root for client " + str + " from service " + getClass().getName());
                            try {
                                serviceCallbacks.onConnectFailed();
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                            }
                        } else {
                            try {
                                MediaBrowserServiceCompat.this.mConnections.put(asBinder, connectionRecord);
                                asBinder.linkToDeath(connectionRecord, 0);
                                if (MediaBrowserServiceCompat.this.mSession != null) {
                                    serviceCallbacks.onConnect(connectionRecord.root.getRootId(), MediaBrowserServiceCompat.this.mSession, connectionRecord.root.getExtras());
                                }
                            } catch (RemoteException unused2) {
                                Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str);
                                MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
        }

        public void disconnect(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.mConnections.remove(serviceCallbacks.asBinder());
                    if (remove != null) {
                        remove.callbacks.asBinder().unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void addSubscription(final String str, final IBinder iBinder, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                        return;
                    }
                    MediaBrowserServiceCompat.this.addSubscription(str, connectionRecord, iBinder, bundle);
                }
            });
        }

        public void removeSubscription(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!MediaBrowserServiceCompat.this.removeSubscription(str, connectionRecord, iBinder)) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        public void getMediaItem(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                    /* class androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass5 */

                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                            return;
                        }
                        MediaBrowserServiceCompat.this.performLoadItem(str, connectionRecord, resultReceiver);
                    }
                });
            }
        }

        public void registerCallbacks(final ServiceCallbacks serviceCallbacks, final String str, final int i, final int i2, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass6 */

                @Override // java.lang.Runnable
                public void run() {
                    IBinder asBinder = serviceCallbacks.asBinder();
                    MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                    ConnectionRecord connectionRecord = new ConnectionRecord(str, i, i2, bundle, serviceCallbacks);
                    MediaBrowserServiceCompat.this.mConnections.put(asBinder, connectionRecord);
                    try {
                        asBinder.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        public void unregisterCallbacks(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass7 */

                @Override // java.lang.Runnable
                public void run() {
                    IBinder asBinder = serviceCallbacks.asBinder();
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                    if (remove != null) {
                        asBinder.unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void search(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                    /* class androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass8 */

                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str);
                            return;
                        }
                        MediaBrowserServiceCompat.this.performSearch(str, bundle, connectionRecord, resultReceiver);
                    }
                });
            }
        }

        public void sendCustomAction(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                    /* class androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass9 */

                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
                            return;
                        }
                        MediaBrowserServiceCompat.this.performCustomAction(str, bundle, connectionRecord, resultReceiver);
                    }
                });
            }
        }
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger messenger) {
            this.mCallbacks = messenger;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            sendRequest(1, bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() throws RemoteException {
            sendRequest(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            sendRequest(3, bundle3);
        }

        private void sendRequest(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.mCallbacks.send(obtain);
        }
    }

    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaBrowserServiceImplApi28();
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new MediaBrowserServiceImplApi26();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserServiceImplApi23();
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserServiceImplApi21();
        } else {
            this.mImpl = new MediaBrowserServiceImplBase();
        }
        this.mImpl.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void onLoadChildren(String str, Result<List<MediaBrowserCompat.MediaItem>> result, Bundle bundle) {
        result.setFlags(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, Result<MediaBrowserCompat.MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(String str, Bundle bundle, Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    public void onCustomAction(String str, Bundle bundle, Result<Bundle> result) {
        result.sendError(null);
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.mSession == null) {
            this.mSession = token;
            this.mImpl.setSessionToken(token);
        } else {
            throw new IllegalStateException("The session token has already been set.");
        }
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    public void notifyChildrenChanged(String str) {
        if (str != null) {
            this.mImpl.notifyChildrenChanged(str, null);
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(String str, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.mImpl.notifyChildrenChanged(str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        } else if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.mImpl.notifyChildrenChanged(remoteUserInfo, str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    boolean isValidPackage(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    void addSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair<IBinder, Bundle> pair : list) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                return;
            }
        }
        list.add(new Pair<>(iBinder, bundle));
        connectionRecord.subscriptions.put(str, list);
        performLoadChildren(str, connectionRecord, bundle, null);
        this.mCurConnection = connectionRecord;
        onSubscribe(str, bundle);
        this.mCurConnection = null;
    }

    boolean removeSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = true;
        boolean z2 = false;
        ConnectionRecord connectionRecord2 = null;
        if (iBinder == null) {
            try {
                if (connectionRecord.subscriptions.remove(str) == null) {
                    z = false;
                }
                return z;
            } finally {
                this.mCurConnection = connectionRecord;
                onUnsubscribe(str);
                this.mCurConnection = connectionRecord2;
            }
        } else {
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                Iterator<Pair<IBinder, Bundle>> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (iBinder == it2.next().first) {
                        it2.remove();
                        z2 = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.subscriptions.remove(str);
                }
            }
            this.mCurConnection = connectionRecord;
            onUnsubscribe(str);
            this.mCurConnection = null;
            return z2;
        }
    }

    void performLoadChildren(final String str, final ConnectionRecord connectionRecord, final Bundle bundle, final Bundle bundle2) {
        AnonymousClass1 r7 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
            /* class androidx.media.MediaBrowserServiceCompat.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                if (MediaBrowserServiceCompat.this.mConnections.get(connectionRecord.callbacks.asBinder()) == connectionRecord) {
                    if ((getFlags() & 1) != 0) {
                        list = MediaBrowserServiceCompat.this.applyOptions(list, bundle);
                    }
                    try {
                        connectionRecord.callbacks.onLoadChildren(str, list, bundle, bundle2);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str + " package=" + connectionRecord.pkg);
                    }
                } else if (MediaBrowserServiceCompat.DEBUG) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + connectionRecord.pkg + " id=" + str);
                }
            }
        };
        this.mCurConnection = connectionRecord;
        if (bundle == null) {
            onLoadChildren(str, r7);
        } else {
            onLoadChildren(str, r7, bundle);
        }
        this.mCurConnection = null;
        if (!r7.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.pkg + " id=" + str);
        }
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int i4 = i3 + i2;
        if (i < 0 || i2 < 1 || i3 >= list.size()) {
            return Collections.emptyList();
        }
        if (i4 > list.size()) {
            i4 = list.size();
        }
        return list.subList(i3, i4);
    }

    void performLoadItem(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass2 r0 = new Result<MediaBrowserCompat.MediaItem>(str) {
            /* class androidx.media.MediaBrowserServiceCompat.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
                if ((getFlags() & 2) != 0) {
                    resultReceiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onLoadItem(str, r0);
        this.mCurConnection = null;
        if (!r0.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    void performSearch(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass3 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
            /* class androidx.media.MediaBrowserServiceCompat.AnonymousClass3 */

            /* access modifiers changed from: package-private */
            public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                if ((getFlags() & 4) != 0 || list == null) {
                    resultReceiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.send(0, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onSearch(str, bundle, r0);
        this.mCurConnection = null;
        if (!r0.isDone()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    void performCustomAction(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass4 r0 = new Result<Bundle>(str) {
            /* class androidx.media.MediaBrowserServiceCompat.AnonymousClass4 */

            /* access modifiers changed from: package-private */
            public void onResultSent(Bundle bundle) {
                resultReceiver.send(0, bundle);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            void onProgressUpdateSent(Bundle bundle) {
                resultReceiver.send(1, bundle);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            void onErrorSent(Bundle bundle) {
                resultReceiver.send(-1, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onCustomAction(str, bundle, r0);
        this.mCurConnection = null;
        if (!r0.isDone()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(String str, Bundle bundle) {
            if (str != null) {
                this.mRootId = str;
                this.mExtras = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }

        public String getRootId() {
            return this.mRootId;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }
    }
}
