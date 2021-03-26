package com.coolapk.market.view.feedv8.util;

import android.util.SparseArray;
import androidx.core.util.SparseArrayKt;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedUIConfig;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0016\u0010 \u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078B@BX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8B@BX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/coolapk/market/view/feedv8/util/FeedGoodsUrlUtils;", "", "()V", "KEY_GOODS_IGNORE_HASH_CODE", "", "KEY_USER_POST_HASH_CODE", "_userGoodsHashCodes", "", "goodsArray", "Landroid/util/SparseArray;", "Lcom/coolapk/market/model/FeedGoods;", "ignoreTempUrl", "", "", "value", "userGoodsHashCodes", "getUserGoodsHashCodes", "()Ljava/util/List;", "setUserGoodsHashCodes", "(Ljava/util/List;)V", "userRecentIgnoreHashCode", "getUserRecentIgnoreHashCode", "()I", "setUserRecentIgnoreHashCode", "(I)V", "isUrlPostBefore", "", "url", "isUrlShouldIgnore", "markFeedGoodsPost", "", "goods", "markGoodsResult", "markTempIgnoreGoods", "onFeedPostEvent", "event", "Lcom/coolapk/market/event/FeedPostEvent;", "onLoginEvent", "session", "Lcom/coolapk/market/local/LoginSession;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsUrlUtils.kt */
public final class FeedGoodsUrlUtils {
    public static final FeedGoodsUrlUtils INSTANCE;
    private static final String KEY_GOODS_IGNORE_HASH_CODE = "goods_ignore_hashcode";
    private static final String KEY_USER_POST_HASH_CODE = "user_post_goods_hashcode";
    private static List<String> _userGoodsHashCodes;
    private static final SparseArray<FeedGoods> goodsArray = new SparseArray<>();
    private static final Set<Integer> ignoreTempUrl;

    static {
        FeedGoodsUrlUtils feedGoodsUrlUtils = new FeedGoodsUrlUtils();
        INSTANCE = feedGoodsUrlUtils;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int userRecentIgnoreHashCode = feedGoodsUrlUtils.getUserRecentIgnoreHashCode();
        if (userRecentIgnoreHashCode != 0) {
            linkedHashSet.add(Integer.valueOf(userRecentIgnoreHashCode));
        }
        ignoreTempUrl = linkedHashSet;
        EventBus.getDefault().register(feedGoodsUrlUtils);
    }

    private FeedGoodsUrlUtils() {
    }

    private final List<String> getUserGoodsHashCodes() {
        if (_userGoodsHashCodes == null) {
            String preferencesString = DataManager.getInstance().getPreferencesString("user_post_goods_hashcode", "");
            Intrinsics.checkNotNullExpressionValue(preferencesString, "DataManager.getInstance(…_USER_POST_HASH_CODE, \"\")");
            _userGoodsHashCodes = StringsKt.split$default((CharSequence) preferencesString, new String[]{","}, false, 0, 6, (Object) null);
        }
        List<String> list = _userGoodsHashCodes;
        Intrinsics.checkNotNull(list);
        return list;
    }

    private final void setUserGoodsHashCodes(List<String> list) {
        if (!Intrinsics.areEqual(list, _userGoodsHashCodes)) {
            _userGoodsHashCodes = list;
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putString("user_post_goods_hashcode", CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null)).apply();
        }
    }

    private final int getUserRecentIgnoreHashCode() {
        return DataManager.getInstance().getPreferencesInt("goods_ignore_hashcode", 0);
    }

    private final void setUserRecentIgnoreHashCode(int i) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putInt("goods_ignore_hashcode", i).apply();
    }

    public final void markGoodsResult(String str, FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(feedGoods, "goods");
        goodsArray.put(str.hashCode(), feedGoods);
    }

    public final void markTempIgnoreGoods(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "goods");
        FeedGoods feedGoods2 = null;
        Iterator valueIterator = SparseArrayKt.valueIterator(goodsArray);
        while (valueIterator.hasNext()) {
            FeedGoods feedGoods3 = (FeedGoods) valueIterator.next();
            if (Intrinsics.areEqual(feedGoods.getId(), feedGoods3.getId())) {
                feedGoods2 = feedGoods3;
            }
        }
        SparseArray<FeedGoods> sparseArray = goodsArray;
        int indexOfValue = sparseArray.indexOfValue(feedGoods2);
        if (indexOfValue >= 0) {
            int keyAt = sparseArray.keyAt(indexOfValue);
            sparseArray.remove(keyAt);
            ignoreTempUrl.add(Integer.valueOf(keyAt));
            setUserRecentIgnoreHashCode(keyAt);
        }
    }

    private final void markFeedGoodsPost(FeedGoods feedGoods) {
        FeedGoods feedGoods2 = null;
        Iterator valueIterator = SparseArrayKt.valueIterator(goodsArray);
        while (valueIterator.hasNext()) {
            FeedGoods feedGoods3 = (FeedGoods) valueIterator.next();
            if (Intrinsics.areEqual(feedGoods.getId(), feedGoods3.getId())) {
                feedGoods2 = feedGoods3;
            }
        }
        SparseArray<FeedGoods> sparseArray = goodsArray;
        int indexOfValue = sparseArray.indexOfValue(feedGoods2);
        if (indexOfValue >= 0) {
            setUserGoodsHashCodes(CollectionsKt.plus((Collection<? extends String>) getUserGoodsHashCodes(), String.valueOf(sparseArray.keyAt(indexOfValue))));
        }
    }

    public final boolean isUrlPostBefore(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return getUserGoodsHashCodes().contains(String.valueOf(str.hashCode()));
    }

    public final boolean isUrlShouldIgnore(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return ignoreTempUrl.contains(Integer.valueOf(str.hashCode()));
    }

    @Subscribe
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        List<String> emptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(emptyList, "Collections.emptyList()");
        setUserGoodsHashCodes(emptyList);
    }

    @Subscribe
    public final void onFeedPostEvent(FeedPostEvent feedPostEvent) {
        FeedGoods feedGoods;
        Intrinsics.checkNotNullParameter(feedPostEvent, "event");
        FeedUIConfig uiConfig = feedPostEvent.getUiConfig();
        if (uiConfig != null && (feedGoods = uiConfig.feedGoods()) != null) {
            Intrinsics.checkNotNullExpressionValue(feedGoods, "event.uiConfig?.feedGoods() ?: return");
            markFeedGoodsPost(feedGoods);
        }
    }
}
