package com.coolapk.market.view.live;

import android.os.Bundle;
import android.util.SparseArray;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.Video;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.live.LiveContract;
import com.coolapk.market.widget.video.VideoModelKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u000223B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000bH\u0016J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0019H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010)\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u0019H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0015H\u0016J\u0012\u0010-\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020/H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u00064"}, d2 = {"Lcom/coolapk/market/view/live/LivePresenter;", "Lcom/coolapk/market/view/live/LiveContract$Presenter;", "view", "Lcom/coolapk/market/view/live/LiveContract$View;", "liveId", "", "(Lcom/coolapk/market/view/live/LiveContract$View;Ljava/lang/String;)V", "live", "Lcom/coolapk/market/model/Live;", "requestSet", "Ljava/util/HashMap;", "", "Lcom/coolapk/market/view/live/LivePresenter$Request;", "Lkotlin/collections/HashMap;", "videoLineMap", "Landroid/util/SparseArray;", "", "Lcom/coolapk/market/model/Video;", "getView", "()Lcom/coolapk/market/view/live/LiveContract$View;", "addToBroadcast", "", "messageId", "banAllPost", "ban", "", "banAllPostPic", "banUser", "uid", "banType", "banUserAndClean", "cancelAddToBroadcast", "cancelFollowLive", "cancelLoadLive", "changeLiveStatus", "status", "deleteMessage", "followLive", "isFollow", "getLive", "getVideoLineMap", "liveStatus", "isFollowLiveLoading", "isLoadingLive", "loadLive", "onInitPresenterState", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "Companion", "Request", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LivePresenter.kt */
public final class LivePresenter implements LiveContract.Presenter {
    public static final Companion Companion = new Companion(null);
    public static final int REQUEST_ADD_TO_BROAD = 3;
    public static final int REQUEST_BAN_ALL_POST = 7;
    public static final int REQUEST_BAN_ALL_POST_PIC = 8;
    public static final int REQUEST_BAN_USER = 6;
    public static final int REQUEST_BAN_USER_AND_CLEAN = 5;
    public static final int REQUEST_CHANGE_LIVE_STATUS = 9;
    public static final int REQUEST_DELETE_MESSAGE = 4;
    public static final int REQUEST_FOLLOW = 2;
    public static final int REQUEST_LIVE = 1;
    private Live live;
    private final String liveId;
    private HashMap<Integer, Request> requestSet = new HashMap<>();
    private final SparseArray<Map<String, Video>> videoLineMap = new SparseArray<>();
    private final LiveContract.View view;

    public LivePresenter(LiveContract.View view2, String str) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(str, "liveId");
        this.view = view2;
        this.liveId = str;
    }

    public final LiveContract.View getView() {
        return this.view;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        this.live = bundle != null ? (Live) bundle.getParcelable("live") : null;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putParcelable("live", this.live);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public Live getLive() {
        return this.live;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/live/LivePresenter$Companion;", "", "()V", "REQUEST_ADD_TO_BROAD", "", "REQUEST_BAN_ALL_POST", "REQUEST_BAN_ALL_POST_PIC", "REQUEST_BAN_USER", "REQUEST_BAN_USER_AND_CLEAN", "REQUEST_CHANGE_LIVE_STATUS", "REQUEST_DELETE_MESSAGE", "REQUEST_FOLLOW", "REQUEST_LIVE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LivePresenter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void loadLive() {
        Request newInstance = Request.Companion.newInstance(new LivePresenter$loadLive$1(this));
        newInstance.run();
        Unit unit = Unit.INSTANCE;
        this.requestSet.put(1, newInstance);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void cancelLoadLive() {
        Request request = this.requestSet.get(1);
        if (request != null) {
            request.cancel();
        }
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public boolean isLoadingLive() {
        Request request = this.requestSet.get(1);
        return request != null && request.isLoading();
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void followLive(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        cancelFollowLive();
        Request newInstance = Request.Companion.newInstance(new LivePresenter$followLive$1(this, str, z));
        newInstance.run();
        Unit unit = Unit.INSTANCE;
        this.requestSet.put(2, newInstance);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void cancelFollowLive() {
        Request request = this.requestSet.get(2);
        if (request != null) {
            request.cancel();
        }
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public boolean isFollowLiveLoading() {
        Request request = this.requestSet.get(2);
        return request != null && request.isLoading();
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void addToBroadcast(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        Intrinsics.checkNotNullParameter(str2, "messageId");
        Request newInstance = Request.Companion.newInstance(new LivePresenter$addToBroadcast$1(this, str, str2));
        newInstance.run();
        Unit unit = Unit.INSTANCE;
        this.requestSet.put(3, newInstance);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void cancelAddToBroadcast() {
        Request request = this.requestSet.get(3);
        if (request != null) {
            request.cancel();
        }
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void deleteMessage(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        Intrinsics.checkNotNullParameter(str2, "messageId");
        Request newInstance = Request.Companion.newInstance(new LivePresenter$deleteMessage$1(this, str, str2));
        newInstance.run();
        Unit unit = Unit.INSTANCE;
        this.requestSet.put(4, newInstance);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void banUser(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        Intrinsics.checkNotNullParameter(str2, "uid");
        Request newInstance = Request.Companion.newInstance(new LivePresenter$banUser$1(this, str, str2, i));
        newInstance.run();
        Unit unit = Unit.INSTANCE;
        this.requestSet.put(6, newInstance);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void banUserAndClean(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        Intrinsics.checkNotNullParameter(str2, "uid");
        Request newInstance = Request.Companion.newInstance(new LivePresenter$banUserAndClean$1(this, str, str2));
        newInstance.run();
        Unit unit = Unit.INSTANCE;
        this.requestSet.put(5, newInstance);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void banAllPost(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        Request newInstance = Request.Companion.newInstance(new LivePresenter$banAllPost$1(this, str, z));
        newInstance.run();
        Unit unit = Unit.INSTANCE;
        this.requestSet.put(7, newInstance);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void banAllPostPic(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        Request newInstance = Request.Companion.newInstance(new LivePresenter$banAllPostPic$1(this, str, z));
        newInstance.run();
        Unit unit = Unit.INSTANCE;
        this.requestSet.put(8, newInstance);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public void changeLiveStatus(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        Request newInstance = Request.Companion.newInstance(new LivePresenter$changeLiveStatus$1(this, str, i));
        newInstance.run();
        Unit unit = Unit.INSTANCE;
        this.requestSet.put(9, newInstance);
    }

    @Override // com.coolapk.market.view.live.LiveContract.Presenter
    public Map<String, Video> getVideoLineMap(int i) {
        Live live2 = this.live;
        if (live2 == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = this.videoLineMap.get(i);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            for (T t : VideoModelKt.getVideoList(live2, i)) {
                Iterator<T> it2 = VideoModelKt.getRequestParamsMap(t).keySet().iterator();
                while (it2.hasNext()) {
                    linkedHashMap.put(it2.next(), t);
                }
            }
            this.videoLineMap.put(i, linkedHashMap);
        }
        return linkedHashMap;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\tH&J\u0006\u0010\u0010\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/live/LivePresenter$Request;", "", "()V", "isLoading", "", "()Z", "setLoading", "(Z)V", "subscription", "Lrx/Subscription;", "applyLoading", "Lrx/Observable$Transformer;", "T", "cancel", "", "onCreate", "run", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LivePresenter.kt */
    public static abstract class Request {
        public static final Companion Companion = new Companion(null);
        private boolean isLoading;
        private Subscription subscription;

        public abstract Subscription onCreate();

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final void setLoading(boolean z) {
            this.isLoading = z;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/live/LivePresenter$Request$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/live/LivePresenter$Request;", "create", "Lkotlin/Function1;", "Lrx/Subscription;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: LivePresenter.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Request newInstance(Function1<? super Request, ? extends Subscription> function1) {
                Intrinsics.checkNotNullParameter(function1, "create");
                return new LivePresenter$Request$Companion$newInstance$1(function1);
            }
        }

        public final void run() {
            cancel();
            this.isLoading = true;
            this.subscription = onCreate();
        }

        public final void cancel() {
            RxUtils.unsubscribe(this.subscription);
        }

        public final <T> Observable.Transformer<T, T> applyLoading() {
            return new LivePresenter$Request$applyLoading$1(this);
        }
    }
}
