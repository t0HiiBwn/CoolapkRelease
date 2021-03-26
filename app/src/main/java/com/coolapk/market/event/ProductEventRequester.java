package com.coolapk.market.event;

import com.coolapk.market.AppHolder;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005JT\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\u0004\u0018\u0001`\u00152\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017JT\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000e2\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\u0004\u0018\u0001`\u00152\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005JT\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000e2\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\u0004\u0018\u0001`\u00152\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/event/ProductEventRequester;", "", "()V", "eventRecordMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "obtainEventIdList", "type", "requestAddToMediaList", "", "mediaID", "requestChangeLikeState", "", "id", "likeState", "", "errorHandler", "Lkotlin/Function1;", "", "Lcom/coolapk/market/event/ErrorHandle;", "successHandler", "Lcom/coolapk/market/event/SuccessHandler;", "requestFollow", "follow", "requestRemoveFormToMediaList", "requestWish", "wish", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductEvent.kt */
public final class ProductEventRequester {
    public static final ProductEventRequester INSTANCE = new ProductEventRequester();
    private static final HashMap<String, List<String>> eventRecordMap = new HashMap<>();

    private ProductEventRequester() {
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.coolapk.market.event.ProductEventRequester */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean requestFollow$default(ProductEventRequester productEventRequester, String str, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        return productEventRequester.requestFollow(str, z, function1, function12);
    }

    public final boolean requestFollow(String str, boolean z, Function1<? super Throwable, Boolean> function1, Function1<Object, Boolean> function12) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!ActionManager.checkLogin(AppHolder.getCurrentActivity()).booleanValue()) {
            return false;
        }
        List<String> obtainEventIdList = obtainEventIdList("follow_event");
        if (obtainEventIdList.contains(str)) {
            return false;
        }
        obtainEventIdList.add(str);
        DataManager.getInstance().changeProductFollowState(str, z).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new ProductEventRequester$requestFollow$1(obtainEventIdList, str)).subscribe((Subscriber<? super R>) new ProductEventRequester$requestFollow$2(function1, str, z, function12));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.coolapk.market.event.ProductEventRequester */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean requestChangeLikeState$default(ProductEventRequester productEventRequester, String str, int i, Function1 function1, Function1 function12, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        if ((i2 & 8) != 0) {
            function12 = null;
        }
        return productEventRequester.requestChangeLikeState(str, i, function1, function12);
    }

    public final boolean requestChangeLikeState(String str, int i, Function1<? super Throwable, Boolean> function1, Function1<Object, Boolean> function12) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!ActionManager.checkLogin(AppHolder.getCurrentActivity()).booleanValue()) {
            return false;
        }
        List<String> obtainEventIdList = obtainEventIdList("like_event");
        if (obtainEventIdList.contains(str)) {
            return false;
        }
        obtainEventIdList.add(str);
        DataManager.getInstance().changeProductLikeState(str, i).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new ProductEventRequester$requestChangeLikeState$1(obtainEventIdList, str)).subscribe((Subscriber<? super R>) new ProductEventRequester$requestChangeLikeState$2(function1, str, function12));
        return true;
    }

    public final void requestAddToMediaList(String str) {
        Intrinsics.checkNotNullParameter(str, "mediaID");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isAdmin()) {
            List<String> obtainEventIdList = obtainEventIdList("add_media");
            if (!obtainEventIdList.contains(str)) {
                obtainEventIdList.add(str);
                DataManager.getInstance().addToMediaList(str).compose(RxUtils.apiCommonToData()).doOnSubscribe(new ProductEventRequester$requestAddToMediaList$1(obtainEventIdList, str)).subscribe((Subscriber<? super R>) new ProductEventRequester$requestAddToMediaList$2(str));
            }
        }
    }

    public final void requestRemoveFormToMediaList(String str) {
        Intrinsics.checkNotNullParameter(str, "mediaID");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isAdmin()) {
            List<String> obtainEventIdList = obtainEventIdList("remove_media");
            if (!obtainEventIdList.contains(str)) {
                obtainEventIdList.add(str);
                DataManager.getInstance().deleteFromMediaList(str).compose(RxUtils.apiCommonToData()).doOnSubscribe(new ProductEventRequester$requestRemoveFormToMediaList$1(obtainEventIdList, str)).subscribe((Subscriber<? super R>) new ProductEventRequester$requestRemoveFormToMediaList$2(str));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.coolapk.market.event.ProductEventRequester */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean requestWish$default(ProductEventRequester productEventRequester, String str, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        return productEventRequester.requestWish(str, z, function1, function12);
    }

    public final boolean requestWish(String str, boolean z, Function1<? super Throwable, Boolean> function1, Function1<Object, Boolean> function12) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!ActionManager.checkLogin(AppHolder.getCurrentActivity()).booleanValue()) {
            return false;
        }
        List<String> obtainEventIdList = obtainEventIdList("wish_event");
        if (obtainEventIdList.contains(str)) {
            return false;
        }
        obtainEventIdList.add(str);
        DataManager.getInstance().changeProductWishStatus(str, z).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new ProductEventRequester$requestWish$1(obtainEventIdList, str)).subscribe((Subscriber<? super R>) new ProductEventRequester$requestWish$2(function1, str, z, function12));
        return true;
    }
}
