package com.coolapk.market.manager;

import android.content.Context;
import com.coolapk.market.model.ImInfo;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e*\u0001\u0018\u0018\u0000 82\u00020\u0001:\u000389:B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bJ\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\u0019\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0006\u0010(\u001a\u00020\u001dJ!\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0011\u0010/\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0019\u00100\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u00101\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u000e\u00102\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u00103\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u00104\u001a\u00020\u001dJ\b\u00105\u001a\u00020\u001dH\u0002J\u0019\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010&R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u000ej\b\u0012\u0004\u0012\u00020\u001b`\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lcom/coolapk/market/manager/AppIMManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionList", "", "", "kotlin.jvm.PlatformType", "", "currentImInfo", "Lcom/coolapk/market/model/ImInfo;", "groupList", "groupMessageListener", "Ljava/util/ArrayList;", "Lcom/coolapk/market/manager/AppIMManager$GroupMessageListener;", "Lkotlin/collections/ArrayList;", "<set-?>", "", "isInit", "()Z", "releaseJob", "Lkotlinx/coroutines/Job;", "simpleMsgListener", "com/coolapk/market/manager/AppIMManager$simpleMsgListener$1", "Lcom/coolapk/market/manager/AppIMManager$simpleMsgListener$1;", "stateListener", "Lcom/coolapk/market/manager/AppIMManager$StateListener;", "addGroupMessageListener", "", "listener", "addStateListener", "bindListener", "ensureInit", "getLoginUser", "isLogin", "joinGroup", "groupId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinLiveGroup", "lazyRelease", "login", "userId", "userSig", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quitAllGroup", "quitGroup", "quitLiveGroup", "removeGroupMessageListener", "removeStateListener", "resume", "unbindListener", "updateImInfo", "roomId", "Companion", "GroupMessageListener", "StateListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppIMManager.kt */
public final class AppIMManager {
    public static final String ACTION_JOIN_LIVE_GROUP = "JOIN_LIVE_GROUP";
    public static final Companion Companion = new Companion(null);
    public static final int RESULT_ERROR_INIT = -1;
    public static final int RESULT_ERROR_JOIN_GROUP = -5;
    public static final int RESULT_ERROR_LOGIN = -3;
    public static final int RESULT_ERROR_LOGOUT = -4;
    public static final int RESULT_ERROR_QUIT_GROUP = -6;
    public static final int RESULT_ERROR_UPDATE_IM_INFO = -2;
    public static final int RESULT_OK = 1;
    private static final int SDK_APP_ID = 1400488950;
    private final List<String> actionList = Collections.synchronizedList(new ArrayList());
    private final Context context;
    private ImInfo currentImInfo;
    private final List<String> groupList = Collections.synchronizedList(new ArrayList());
    private final ArrayList<GroupMessageListener> groupMessageListener = new ArrayList<>();
    private boolean isInit;
    private Job releaseJob;
    private final AppIMManager$simpleMsgListener$1 simpleMsgListener = new AppIMManager$simpleMsgListener$1(this);
    private final ArrayList<StateListener> stateListener = new ArrayList<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/manager/AppIMManager$GroupMessageListener;", "", "onRecvAddToBroadcast", "", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "onRecvDeleteAllMessage", "uid", "", "onRecvDeleteMessage", "messageId", "onRecvLiveDetail", "live", "Lcom/coolapk/market/model/Live;", "onRecvNewMessage", "onRecvRemoveFromBroadcast", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppIMManager.kt */
    public interface GroupMessageListener {
        void onRecvAddToBroadcast(LiveMessage liveMessage);

        void onRecvDeleteAllMessage(String str);

        void onRecvDeleteMessage(String str);

        void onRecvLiveDetail(Live live);

        void onRecvNewMessage(LiveMessage liveMessage);

        void onRecvRemoveFromBroadcast(String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/manager/AppIMManager$StateListener;", "", "onKickedOffline", "", "onUserSigExpired", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppIMManager.kt */
    public interface StateListener {
        void onKickedOffline();

        void onUserSigExpired();
    }

    public AppIMManager(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/manager/AppIMManager$Companion;", "", "()V", "ACTION_JOIN_LIVE_GROUP", "", "RESULT_ERROR_INIT", "", "RESULT_ERROR_JOIN_GROUP", "RESULT_ERROR_LOGIN", "RESULT_ERROR_LOGOUT", "RESULT_ERROR_QUIT_GROUP", "RESULT_ERROR_UPDATE_IM_INFO", "RESULT_OK", "SDK_APP_ID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppIMManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean isInit() {
        return this.isInit;
    }

    public final void resume() {
        LogUtils.d("[resume] 恢复IM", new Object[0]);
        Job job = this.releaseJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.releaseJob = null;
    }

    public final void lazyRelease() {
        this.releaseJob = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AppIMManager$lazyRelease$1(this, null), 3, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02e1  */
    public final Object joinLiveGroup(String str, Continuation<? super Unit> continuation) throws AppIMException {
        AppIMManager$joinLiveGroup$1 appIMManager$joinLiveGroup$1;
        int i;
        AppIMManager appIMManager;
        Throwable th;
        AppIMManager appIMManager2;
        String str2;
        String str3;
        String str4;
        String str5;
        ImInfo imInfo;
        String str6;
        ImInfo imInfo2;
        String str7;
        String str8;
        Exception e;
        AppIMManager appIMManager3;
        Object obj;
        String userId;
        ImInfo imInfo3;
        String str9 = str;
        if (continuation instanceof AppIMManager$joinLiveGroup$1) {
            appIMManager$joinLiveGroup$1 = (AppIMManager$joinLiveGroup$1) continuation;
            if ((appIMManager$joinLiveGroup$1.label & Integer.MIN_VALUE) != 0) {
                appIMManager$joinLiveGroup$1.label -= Integer.MIN_VALUE;
                Object obj2 = appIMManager$joinLiveGroup$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appIMManager$joinLiveGroup$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    str7 = "[joinLiveGroup]";
                    LogUtils.d(str7 + " 开始加入直播群 " + str9, new Object[0]);
                    if (this.actionList.contains("JOIN_LIVE_GROUP")) {
                        LogUtils.d(str7 + " 已存在加群任务，跳过", new Object[0]);
                        return Unit.INSTANCE;
                    }
                    this.actionList.add("JOIN_LIVE_GROUP");
                    try {
                        ensureInit();
                        if (this.isInit) {
                            LogUtils.d(str7 + " 更新imInfo", new Object[0]);
                            appIMManager$joinLiveGroup$1.L$0 = this;
                            appIMManager$joinLiveGroup$1.L$1 = str9;
                            appIMManager$joinLiveGroup$1.L$2 = str7;
                            appIMManager$joinLiveGroup$1.label = 1;
                            obj = updateImInfo(str9, appIMManager$joinLiveGroup$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            appIMManager2 = this;
                        } else {
                            LogUtils.d(str7 + " 初始化失败", new Object[0]);
                            throw new AppIMException(-1, "初始化失败");
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        appIMManager = this;
                        appIMManager.actionList.remove("JOIN_LIVE_GROUP");
                        throw th;
                    }
                } else if (i == 1) {
                    String str10 = (String) appIMManager$joinLiveGroup$1.L$2;
                    String str11 = (String) appIMManager$joinLiveGroup$1.L$1;
                    appIMManager2 = (AppIMManager) appIMManager$joinLiveGroup$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        str7 = str10;
                        str9 = str11;
                        obj = obj2;
                    } catch (Throwable th3) {
                        th = th3;
                        appIMManager = appIMManager2;
                        appIMManager.actionList.remove("JOIN_LIVE_GROUP");
                        throw th;
                    }
                } else if (i == 2) {
                    ImInfo imInfo4 = (ImInfo) appIMManager$joinLiveGroup$1.L$3;
                    String str12 = (String) appIMManager$joinLiveGroup$1.L$2;
                    str6 = (String) appIMManager$joinLiveGroup$1.L$1;
                    AppIMManager appIMManager4 = (AppIMManager) appIMManager$joinLiveGroup$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        str7 = str12;
                        appIMManager2 = appIMManager4;
                        imInfo2 = imInfo4;
                        if (appIMManager2.isLogin()) {
                            LogUtils.d(str7 + " 退出登录 " + appIMManager2.getLoginUser(), new Object[0]);
                            try {
                                appIMManager$joinLiveGroup$1.L$0 = appIMManager2;
                                appIMManager$joinLiveGroup$1.L$1 = str6;
                                appIMManager$joinLiveGroup$1.L$2 = str7;
                                appIMManager$joinLiveGroup$1.L$3 = imInfo2;
                                appIMManager$joinLiveGroup$1.label = 3;
                                if (appIMManager2.logout(appIMManager$joinLiveGroup$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str8 = str7;
                                appIMManager3 = appIMManager2;
                                imInfo = imInfo2;
                                str5 = str8;
                                appIMManager2 = appIMManager3;
                                if (appIMManager2.isLogin()) {
                                }
                            } catch (Exception e2) {
                                e = e2;
                                str8 = str7;
                                e.printStackTrace();
                                imInfo = imInfo2;
                                str5 = str8;
                                if (appIMManager2.isLogin()) {
                                }
                            }
                        }
                        imInfo = imInfo2;
                        str5 = str7;
                        if (appIMManager2.isLogin()) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        appIMManager = appIMManager4;
                        appIMManager.actionList.remove("JOIN_LIVE_GROUP");
                        throw th;
                    }
                } else if (i == 3) {
                    imInfo2 = (ImInfo) appIMManager$joinLiveGroup$1.L$3;
                    str8 = (String) appIMManager$joinLiveGroup$1.L$2;
                    str6 = (String) appIMManager$joinLiveGroup$1.L$1;
                    appIMManager3 = (AppIMManager) appIMManager$joinLiveGroup$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        imInfo = imInfo2;
                        str5 = str8;
                        appIMManager2 = appIMManager3;
                    } catch (Exception e3) {
                        e = e3;
                        appIMManager2 = appIMManager3;
                    }
                    if (appIMManager2.isLogin()) {
                        LogUtils.d(str5 + " 开始登录 " + imInfo.userId(), new Object[0]);
                        String userId2 = imInfo.userId();
                        Intrinsics.checkNotNullExpressionValue(userId2, "imInfo.userId()");
                        String userSig = imInfo.userSig();
                        Intrinsics.checkNotNullExpressionValue(userSig, "imInfo.userSig()");
                        appIMManager$joinLiveGroup$1.L$0 = appIMManager2;
                        appIMManager$joinLiveGroup$1.L$1 = str6;
                        appIMManager$joinLiveGroup$1.L$2 = str5;
                        appIMManager$joinLiveGroup$1.L$3 = imInfo;
                        appIMManager$joinLiveGroup$1.label = 4;
                        if (appIMManager2.login(userId2, userSig, appIMManager$joinLiveGroup$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str4 = str6;
                        LogUtils.d(str5 + " 登录成功 " + imInfo.userId(), new Object[0]);
                        str3 = str5;
                        if (!appIMManager2.groupList.contains(str4)) {
                        }
                    } else {
                        LogUtils.d(str5 + " 已登录 " + imInfo.userId(), new Object[0]);
                        str3 = str5;
                        str4 = str6;
                        if (!appIMManager2.groupList.contains(str4)) {
                        }
                    }
                } else if (i == 4) {
                    imInfo = (ImInfo) appIMManager$joinLiveGroup$1.L$3;
                    str5 = (String) appIMManager$joinLiveGroup$1.L$2;
                    str4 = (String) appIMManager$joinLiveGroup$1.L$1;
                    AppIMManager appIMManager5 = (AppIMManager) appIMManager$joinLiveGroup$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        appIMManager2 = appIMManager5;
                        LogUtils.d(str5 + " 登录成功 " + imInfo.userId(), new Object[0]);
                        str3 = str5;
                        if (!appIMManager2.groupList.contains(str4)) {
                            LogUtils.d(str3 + " 开始加群 " + str4, new Object[0]);
                            appIMManager$joinLiveGroup$1.L$0 = appIMManager2;
                            appIMManager$joinLiveGroup$1.L$1 = str4;
                            appIMManager$joinLiveGroup$1.L$2 = str3;
                            appIMManager$joinLiveGroup$1.L$3 = null;
                            appIMManager$joinLiveGroup$1.label = 5;
                            if (appIMManager2.joinGroup(str4, appIMManager$joinLiveGroup$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str2 = str4;
                            appIMManager = appIMManager2;
                            LogUtils.d(str3 + " 加群成功 " + str2, new Object[0]);
                            appIMManager.groupList.add(str2);
                            appIMManager2 = appIMManager;
                            appIMManager2.actionList.remove("JOIN_LIVE_GROUP");
                            return Unit.INSTANCE;
                        }
                        LogUtils.d(str3 + " 已加群 " + str4, new Object[0]);
                        appIMManager2.actionList.remove("JOIN_LIVE_GROUP");
                        return Unit.INSTANCE;
                    } catch (Throwable th5) {
                        th = th5;
                        appIMManager = appIMManager5;
                        appIMManager.actionList.remove("JOIN_LIVE_GROUP");
                        throw th;
                    }
                } else if (i == 5) {
                    str3 = (String) appIMManager$joinLiveGroup$1.L$2;
                    str2 = (String) appIMManager$joinLiveGroup$1.L$1;
                    appIMManager = (AppIMManager) appIMManager$joinLiveGroup$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        LogUtils.d(str3 + " 加群成功 " + str2, new Object[0]);
                        appIMManager.groupList.add(str2);
                        appIMManager2 = appIMManager;
                        appIMManager2.actionList.remove("JOIN_LIVE_GROUP");
                        return Unit.INSTANCE;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                imInfo2 = (ImInfo) obj;
                LogUtils.d(str7 + " 最新的ImInfo信息 " + imInfo2, new Object[0]);
                userId = imInfo2.userId();
                imInfo3 = appIMManager2.currentImInfo;
                if (!(!Intrinsics.areEqual(userId, imInfo3 == null ? imInfo3.userId() : null))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str7);
                    sb.append(" ImInfo信息变更 ");
                    ImInfo imInfo5 = appIMManager2.currentImInfo;
                    sb.append(imInfo5 != null ? imInfo5.userId() : null);
                    sb.append(" -> ");
                    sb.append(imInfo2.userId());
                    LogUtils.d(sb.toString(), new Object[0]);
                    appIMManager2.currentImInfo = imInfo2;
                    appIMManager$joinLiveGroup$1.L$0 = appIMManager2;
                    appIMManager$joinLiveGroup$1.L$1 = str9;
                    appIMManager$joinLiveGroup$1.L$2 = str7;
                    appIMManager$joinLiveGroup$1.L$3 = imInfo2;
                    appIMManager$joinLiveGroup$1.label = 2;
                    if (appIMManager2.quitAllGroup(appIMManager$joinLiveGroup$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str6 = str9;
                    if (appIMManager2.isLogin()) {
                    }
                    imInfo = imInfo2;
                    str5 = str7;
                    if (appIMManager2.isLogin()) {
                    }
                } else {
                    LogUtils.d(str7 + " ImInfo信息没有变化", new Object[0]);
                    str6 = str9;
                    imInfo = imInfo2;
                    str5 = str7;
                    if (appIMManager2.isLogin()) {
                    }
                }
            }
        }
        appIMManager$joinLiveGroup$1 = new AppIMManager$joinLiveGroup$1(this, continuation);
        Object obj2 = appIMManager$joinLiveGroup$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appIMManager$joinLiveGroup$1.label;
        if (i != 0) {
        }
        imInfo2 = (ImInfo) obj;
        LogUtils.d(str7 + " 最新的ImInfo信息 " + imInfo2, new Object[0]);
        userId = imInfo2.userId();
        imInfo3 = appIMManager2.currentImInfo;
        if (!(!Intrinsics.areEqual(userId, imInfo3 == null ? imInfo3.userId() : null))) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public final Object quitLiveGroup(String str, Continuation<? super Unit> continuation) {
        AppIMManager$quitLiveGroup$1 appIMManager$quitLiveGroup$1;
        int i;
        AppIMManager appIMManager;
        Exception e;
        if (continuation instanceof AppIMManager$quitLiveGroup$1) {
            appIMManager$quitLiveGroup$1 = (AppIMManager$quitLiveGroup$1) continuation;
            if ((appIMManager$quitLiveGroup$1.label & Integer.MIN_VALUE) != 0) {
                appIMManager$quitLiveGroup$1.label -= Integer.MIN_VALUE;
                Object obj = appIMManager$quitLiveGroup$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appIMManager$quitLiveGroup$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.groupList.contains(str)) {
                        try {
                            if (isLogin()) {
                                LogUtils.d("[quitLiveGroup] 退出直播群聊 " + str, new Object[0]);
                                appIMManager$quitLiveGroup$1.L$0 = this;
                                appIMManager$quitLiveGroup$1.L$1 = str;
                                appIMManager$quitLiveGroup$1.label = 1;
                                if (quitGroup(str, appIMManager$quitLiveGroup$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            appIMManager = this;
                        } catch (Exception e2) {
                            e = e2;
                            appIMManager = this;
                            e.printStackTrace();
                            appIMManager.groupList.remove(str);
                            return Unit.INSTANCE;
                        }
                    }
                    return Unit.INSTANCE;
                } else if (i == 1) {
                    str = (String) appIMManager$quitLiveGroup$1.L$1;
                    appIMManager = (AppIMManager) appIMManager$quitLiveGroup$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e3) {
                        e = e3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                appIMManager.groupList.remove(str);
                return Unit.INSTANCE;
            }
        }
        appIMManager$quitLiveGroup$1 = new AppIMManager$quitLiveGroup$1(this, continuation);
        Object obj = appIMManager$quitLiveGroup$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appIMManager$quitLiveGroup$1.label;
        if (i != 0) {
        }
        appIMManager.groupList.remove(str);
        return Unit.INSTANCE;
    }

    public final void addStateListener(StateListener stateListener2) {
        Intrinsics.checkNotNullParameter(stateListener2, "listener");
        if (!this.stateListener.contains(stateListener2)) {
            this.stateListener.add(stateListener2);
        }
    }

    public final void removeStateListener(StateListener stateListener2) {
        Intrinsics.checkNotNullParameter(stateListener2, "listener");
        this.stateListener.remove(stateListener2);
    }

    private final void ensureInit() {
        if (!this.isInit) {
            LogUtils.d("[ensureInit] 初始化", new Object[0]);
            V2TIMSDKConfig v2TIMSDKConfig = new V2TIMSDKConfig();
            v2TIMSDKConfig.setLogLevel(0);
            this.isInit = V2TIMManager.getInstance().initSDK(this.context, 1400488950, v2TIMSDKConfig, new AppIMManager$ensureInit$1(this, "[ensureInit]"));
            bindListener();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    final /* synthetic */ Object quitAllGroup(Continuation<? super Unit> continuation) {
        AppIMManager$quitAllGroup$1 appIMManager$quitAllGroup$1;
        int i;
        AppIMManager appIMManager;
        Iterator<String> it2;
        if (continuation instanceof AppIMManager$quitAllGroup$1) {
            appIMManager$quitAllGroup$1 = (AppIMManager$quitAllGroup$1) continuation;
            if ((appIMManager$quitAllGroup$1.label & Integer.MIN_VALUE) != 0) {
                appIMManager$quitAllGroup$1.label -= Integer.MIN_VALUE;
                Object obj = appIMManager$quitAllGroup$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appIMManager$quitAllGroup$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    appIMManager = this;
                    it2 = this.groupList.iterator();
                } else if (i == 1) {
                    it2 = (Iterator) appIMManager$quitAllGroup$1.L$1;
                    appIMManager = (AppIMManager) appIMManager$quitAllGroup$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    it2.remove();
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it2.hasNext()) {
                    String next = it2.next();
                    LogUtils.d("退出群聊 " + next, new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(next, "id");
                    appIMManager$quitAllGroup$1.L$0 = appIMManager;
                    appIMManager$quitAllGroup$1.L$1 = it2;
                    appIMManager$quitAllGroup$1.label = 1;
                    if (appIMManager.quitGroup(next, appIMManager$quitAllGroup$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it2.remove();
                    if (it2.hasNext()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        appIMManager$quitAllGroup$1 = new AppIMManager$quitAllGroup$1(this, continuation);
        Object obj = appIMManager$quitAllGroup$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appIMManager$quitAllGroup$1.label;
        if (i != 0) {
        }
        if (it2.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    public final void addGroupMessageListener(GroupMessageListener groupMessageListener2) {
        Intrinsics.checkNotNullParameter(groupMessageListener2, "listener");
        if (!this.groupMessageListener.contains(groupMessageListener2)) {
            this.groupMessageListener.add(groupMessageListener2);
        }
    }

    public final void removeGroupMessageListener(GroupMessageListener groupMessageListener2) {
        Intrinsics.checkNotNullParameter(groupMessageListener2, "listener");
        this.groupMessageListener.remove(groupMessageListener2);
    }

    private final void bindListener() {
        V2TIMManager.getInstance().addSimpleMsgListener(this.simpleMsgListener);
    }

    /* access modifiers changed from: private */
    public final void unbindListener() {
        V2TIMManager.getInstance().removeSimpleMsgListener(this.simpleMsgListener);
    }

    final /* synthetic */ Object updateImInfo(String str, Continuation<? super ImInfo> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        DataManager.getInstance().getImInfo(str).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe(new AppIMManager$updateImInfo$2$1(safeContinuation2), new AppIMManager$updateImInfo$2$2(safeContinuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    final /* synthetic */ Object login(String str, String str2, Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        V2TIMManager.getInstance().login(str, str2, new AppIMManager$login$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    final /* synthetic */ Object logout(Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        V2TIMManager.getInstance().logout(new AppIMManager$logout$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final String getLoginUser() {
        V2TIMManager instance = V2TIMManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "V2TIMManager.getInstance()");
        return instance.getLoginUser();
    }

    /* access modifiers changed from: private */
    public final boolean isLogin() {
        V2TIMManager instance = V2TIMManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "V2TIMManager.getInstance()");
        int loginStatus = instance.getLoginStatus();
        return loginStatus == 2 || loginStatus == 1;
    }

    final /* synthetic */ Object joinGroup(String str, Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        V2TIMManager.getInstance().joinGroup(str, null, new AppIMManager$joinGroup$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    final /* synthetic */ Object quitGroup(String str, Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        V2TIMManager.getInstance().quitGroup(str, new AppIMManager$quitGroup$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
