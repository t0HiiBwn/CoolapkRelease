package com.coolapk.market.view.ad;

import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.SimpleLifeCycleObserver;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.cardlist.EntityDataFilter;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020\u0007J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010$\u001a\u00020\u000fH\u0016J\u0016\u0010%\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'J\u0018\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010+J0\u0010(\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+J \u0010/\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\"2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000101R0\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u00064"}, d2 = {"Lcom/coolapk/market/view/ad/EntityAdHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "cardToAdMap", "Ljava/util/HashMap;", "", "Lcom/coolapk/market/view/ad/FeedAdSource;", "Lkotlin/collections/HashMap;", "getCardToAdMap", "()Ljava/util/HashMap;", "cardToListenerMap", "Lcom/coolapk/market/view/ad/ViewHolderAdLoadListener;", "shouldDestroyADAfterRefresh", "", "getShouldDestroyADAfterRefresh", "()Z", "setShouldDestroyADAfterRefresh", "(Z)V", "smoothScrollWithADBindHelper", "Lcom/coolapk/market/view/ad/SmoothScrollWithADBindHelper;", "sponsorCardTemplates", "", "[Ljava/lang/String;", "addNotBlockSmoothScrollTask", "", "task", "Lkotlin/Function0;", "destroyAllLoadedAds", "findFeedAdSource", "key", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "requestCloseAd", "position", "", "requestLoadAd", "card", "callback", "Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;", "name", "appId", "posId", "requestLoadAdIntoDataList", "anchor", "Landroid/os/Parcelable;", "nextAnchor", "AdViewHolderCallback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class EntityAdHelper extends EntityDataFilter {
    private final HashMap<String, ViewHolderAdLoadListener> cardToListenerMap = new HashMap<>();
    private final EntityListFragment fragment;
    private boolean shouldDestroyADAfterRefresh = true;
    private SmoothScrollWithADBindHelper smoothScrollWithADBindHelper;
    private final String[] sponsorCardTemplates = {"sponsorCard", "sponsorFeed", "sponsorArticleNews"};

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;", "", "getPositionInDataList", "", "onAdBan", "", "adInfo", "Lcom/coolapk/market/view/ad/AdInfo;", "onAdClose", "onAdLoadFail", "onAdLoadSuccess", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EntityAdHelper.kt */
    public interface AdViewHolderCallback {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* compiled from: EntityAdHelper.kt */
        public static final class DefaultImpls {
            public static int getPositionInDataList(AdViewHolderCallback adViewHolderCallback) {
                return -1;
            }

            public static void onAdBan(AdViewHolderCallback adViewHolderCallback, AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            }

            public static void onAdClose(AdViewHolderCallback adViewHolderCallback) {
            }

            public static void onAdLoadFail(AdViewHolderCallback adViewHolderCallback) {
            }
        }

        int getPositionInDataList();

        void onAdBan(AdInfo adInfo);

        void onAdClose();

        void onAdLoadFail();

        void onAdLoadSuccess();
    }

    public EntityAdHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
        entityListFragment.getLifecycle().addObserver(new SimpleLifeCycleObserver(this) {
            /* class com.coolapk.market.view.ad.EntityAdHelper.AnonymousClass1 */
            final /* synthetic */ EntityAdHelper this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.extend.SimpleLifeCycleObserver
            public void onResume() {
                super.onResume();
                Collection<FeedAdSource> values = this.this$0.getCardToAdMap().values();
                Intrinsics.checkNotNullExpressionValue(values, "cardToAdMap.values");
                for (FeedAdSource feedAdSource : values) {
                    feedAdSource.onResume();
                }
            }

            @Override // com.coolapk.market.extend.SimpleLifeCycleObserver
            public void onDestroy() {
                super.onDestroy();
                Collection<FeedAdSource> values = this.this$0.getCardToAdMap().values();
                Intrinsics.checkNotNullExpressionValue(values, "cardToAdMap.values");
                for (FeedAdSource feedAdSource : values) {
                    feedAdSource.detachListeners();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public final HashMap<String, FeedAdSource> getCardToAdMap() {
        return ActivityADScope.INSTANCE.getFeedSourceMap(this.fragment);
    }

    public final boolean getShouldDestroyADAfterRefresh() {
        return this.shouldDestroyADAfterRefresh;
    }

    public final void setShouldDestroyADAfterRefresh(boolean z) {
        this.shouldDestroyADAfterRefresh = z;
    }

    public final void addNotBlockSmoothScrollTask(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "task");
        if (this.smoothScrollWithADBindHelper == null) {
            RecyclerView recyclerView = this.fragment.getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "fragment.recyclerView");
            this.smoothScrollWithADBindHelper = new SmoothScrollWithADBindHelper(recyclerView);
        }
        SmoothScrollWithADBindHelper smoothScrollWithADBindHelper2 = this.smoothScrollWithADBindHelper;
        if (smoothScrollWithADBindHelper2 != null) {
            smoothScrollWithADBindHelper2.addTask(function0);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Object obj;
        int indexOf;
        Intrinsics.checkNotNullParameter(list, "list");
        if (z && this.shouldDestroyADAfterRefresh) {
            destroyAllLoadedAds();
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (ArraysKt.contains(this.sponsorCardTemplates, ((Entity) obj).getEntityTemplate())) {
                break;
            }
        }
        Entity entity = (Entity) obj;
        if (entity != null) {
            JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(entity);
            String optString = jsonExtraData != null ? jsonExtraData.optString("sponsorType") : null;
            boolean z2 = false;
            if (optString != null && (StringsKt.startsWith$default(optString, "QQ_SELF_DRAW", false, 2, (Object) null) || StringsKt.startsWith$default(optString, "TT_SELF_DRAW", false, 2, (Object) null))) {
                z2 = true;
            }
            if (!z2 || (indexOf = list.indexOf(entity)) <= 0) {
                requestLoadAd(entity, new EntityAdHelper$modifyData$1(this, entity));
            } else {
                removeData$presentation_coolapkAppRelease(list, entity);
                requestLoadAdIntoDataList(entity, (Entity) list.get(indexOf - 1), (Entity) CollectionsKt.getOrNull(list, indexOf + 1));
                return list;
            }
        }
        return list;
    }

    public final void requestLoadAdIntoDataList(Entity entity, Parcelable parcelable, Parcelable parcelable2) {
        Intrinsics.checkNotNullParameter(entity, "card");
        Intrinsics.checkNotNullParameter(parcelable, "anchor");
        requestLoadAd(entity, new EntityAdHelper$requestLoadAdIntoDataList$1(this, parcelable, entity, parcelable2));
    }

    public final void requestLoadAd(Entity entity, AdViewHolderCallback adViewHolderCallback) {
        Intrinsics.checkNotNullParameter(entity, "card");
        String entityUniqueId = EntityExtendsKt.entityUniqueId(entity);
        JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(entity);
        String optString = jsonExtraData != null ? jsonExtraData.optString("sponsorType") : null;
        if (optString != null) {
            String str = optString;
            if (str.length() > 0) {
                List split$default = StringsKt.split$default((CharSequence) str, new String[]{"|"}, false, 0, 6, (Object) null);
                String str2 = (String) split$default.get(0);
                Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj = StringsKt.trim((CharSequence) str2).toString();
                String str3 = (String) split$default.get(1);
                Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj2 = StringsKt.trim((CharSequence) str3).toString();
                String str4 = (String) split$default.get(2);
                Objects.requireNonNull(str4, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj3 = StringsKt.trim((CharSequence) str4).toString();
                LogUtils.d("信息流广告: " + obj + '|' + obj2 + '|' + obj3, new Object[0]);
                if (FeedAdUtils.INSTANCE.checkName(obj)) {
                    requestLoadAd(entityUniqueId, obj, obj2, obj3, adViewHolderCallback);
                }
            }
        }
    }

    public final void requestLoadAd(String str, String str2, String str3, String str4, AdViewHolderCallback adViewHolderCallback) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "appId");
        Intrinsics.checkNotNullParameter(str4, "posId");
        FeedAdSource feedAdSource = getCardToAdMap().get(str);
        if (feedAdSource != null) {
            ViewHolderAdLoadListener viewHolderAdLoadListener = this.cardToListenerMap.get(str);
            if (viewHolderAdLoadListener == null) {
                ViewHolderAdLoadListener viewHolderAdLoadListener2 = new ViewHolderAdLoadListener(str2, str3, str4, adViewHolderCallback);
                feedAdSource.setOnAdEventListener(viewHolderAdLoadListener2);
                feedAdSource.load(viewHolderAdLoadListener2);
            } else {
                viewHolderAdLoadListener.setAdViewHolderCallback(adViewHolderCallback);
            }
            if (feedAdSource.isSucceedLoaded() && adViewHolderCallback != null) {
                adViewHolderCallback.onAdLoadSuccess();
                return;
            }
            return;
        }
        FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        FeedAdSource feedAd = FeedAdFactory.INSTANCE.getFeedAd(requireActivity, str2, str3, str4, 1);
        ViewHolderAdLoadListener viewHolderAdLoadListener3 = new ViewHolderAdLoadListener(str2, str3, str4, adViewHolderCallback);
        feedAd.load(viewHolderAdLoadListener3);
        feedAd.setOnAdEventListener(viewHolderAdLoadListener3);
        getCardToAdMap().put(str, feedAd);
        this.cardToListenerMap.put(str, viewHolderAdLoadListener3);
    }

    public final void requestCloseAd(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (i >= 0) {
            FeedAdSource remove = getCardToAdMap().remove(str);
            if (remove != null) {
                remove.release();
            }
            this.cardToListenerMap.remove(str);
            this.fragment.getDataList().remove(i);
        }
    }

    public final FeedAdSource findFeedAdSource(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getCardToAdMap().get(str);
    }

    public final void destroyAllLoadedAds() {
        AdViewHolderCallback adViewHolderCallback;
        Collection<FeedAdSource> values = getCardToAdMap().values();
        Intrinsics.checkNotNullExpressionValue(values, "cardToAdMap.values");
        Iterator<T> it2 = values.iterator();
        while (it2.hasNext()) {
            it2.next().release();
        }
        Set<String> keySet = getCardToAdMap().keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "cardToAdMap.keys");
        Iterator<T> it3 = keySet.iterator();
        while (it3.hasNext()) {
            ViewHolderAdLoadListener viewHolderAdLoadListener = this.cardToListenerMap.get(it3.next());
            if (!(viewHolderAdLoadListener == null || (adViewHolderCallback = viewHolderAdLoadListener.getAdViewHolderCallback()) == null)) {
                Integer valueOf = Integer.valueOf(adViewHolderCallback.getPositionInDataList());
                if (!(valueOf.intValue() != -1)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    int intValue = valueOf.intValue();
                    RecyclerView recyclerView = this.fragment.getRecyclerView();
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "fragment.recyclerView");
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(intValue);
                    }
                }
            }
        }
        getCardToAdMap().clear();
        this.cardToListenerMap.clear();
    }
}
