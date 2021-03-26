package com.coolapk.market.event;

import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\\\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013j\u0004\u0018\u0001`\u00152\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017Jb\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013j\u0004\u0018\u0001`\u00152\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0007j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/event/FeedEventRequester;", "", "()V", "EVENT_TYPE_LIKE", "", "EVENT_TYP_VOTE_OPTIONS", "eventRecordMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "obtainEventIdList", "type", "requestLike", "", "id", "like", "detail", "", "errorHandler", "Lkotlin/Function1;", "", "Lcom/coolapk/market/event/ErrorHandle;", "successHandler", "Lcom/coolapk/market/event/SuccessHandler;", "requestVote", "options", "", "anonymous", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEventProcessor.kt */
public final class FeedEventRequester {
    private static final String EVENT_TYPE_LIKE = "event_type_like";
    private static final String EVENT_TYP_VOTE_OPTIONS = "event_type_vote_options";
    public static final FeedEventRequester INSTANCE = new FeedEventRequester();
    private static final HashMap<String, List<String>> eventRecordMap = new HashMap<>();

    private FeedEventRequester() {
    }

    private final List<String> obtainEventIdList(String str) {
        HashMap<String, List<String>> hashMap = eventRecordMap;
        ArrayList arrayList = hashMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            hashMap.put(str, arrayList);
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.coolapk.market.event.FeedEventRequester */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean requestLike$default(FeedEventRequester feedEventRequester, String str, boolean z, int i, Function1 function1, Function1 function12, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        if ((i2 & 16) != 0) {
            function12 = null;
        }
        return feedEventRequester.requestLike(str, z, i, function1, function12);
    }

    public final boolean requestLike(String str, boolean z, int i, Function1<? super Throwable, Boolean> function1, Function1<Object, Boolean> function12) {
        Observable<Result<LikeResult>> observable;
        Intrinsics.checkNotNullParameter(str, "id");
        if (!ActionManager.checkLogin(AppHolder.getCurrentActivity()).booleanValue()) {
            return false;
        }
        List<String> obtainEventIdList = obtainEventIdList("event_type_like");
        if (obtainEventIdList.contains(str)) {
            return false;
        }
        obtainEventIdList.add(str);
        if (z) {
            observable = DataManager.getInstance().likeFeed(str, i);
        } else {
            observable = DataManager.getInstance().unlikeFeed(str, i);
        }
        observable.compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new FeedEventRequester$requestLike$1(obtainEventIdList, str)).subscribe((Subscriber) new FeedEventRequester$requestLike$2(function1, str, z, function12));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.coolapk.market.event.FeedEventRequester */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean requestVote$default(FeedEventRequester feedEventRequester, String str, List list, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        if ((i & 16) != 0) {
            function12 = null;
        }
        return feedEventRequester.requestVote(str, list, z, function1, function12);
    }

    public final boolean requestVote(String str, List<String> list, boolean z, Function1<? super Throwable, Boolean> function1, Function1<Object, Boolean> function12) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "options");
        int i = 0;
        if (!ActionManager.checkLogin(AppHolder.getCurrentActivity()).booleanValue()) {
            return false;
        }
        List<String> obtainEventIdList = obtainEventIdList("event_type_like");
        if (obtainEventIdList.contains(str)) {
            return false;
        }
        obtainEventIdList.add(str);
        HashMap hashMap = new HashMap();
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            hashMap.put("select_option[" + i + ']', t);
            i = i2;
        }
        DataManager.getInstance().createUserVote(str, hashMap, z ? 1 : 0).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new FeedEventRequester$requestVote$2(obtainEventIdList, str)).subscribe((Subscriber<? super R>) new FeedEventRequester$requestVote$3(function1, function12));
        return true;
    }
}
