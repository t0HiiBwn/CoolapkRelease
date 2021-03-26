package com.coolapk.market.view.ad;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.base.BaseFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u000e\u001a\u00020\u000fRb\u0010\u0003\u001aV\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00070\u0004j*\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/ad/ActivityADScope;", "", "()V", "fragmentFeedAdSourceMap", "Ljava/util/HashMap;", "", "Lcom/coolapk/market/view/ad/FeedAdSource;", "Lkotlin/collections/HashMap;", "addOnItsActivityDestroyCallback", "", "fragmentStateID", "activity", "Landroidx/fragment/app/FragmentActivity;", "getFeedSourceMap", "fragment", "Lcom/coolapk/market/view/base/BaseFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActivityADScope.kt */
public final class ActivityADScope {
    public static final ActivityADScope INSTANCE = new ActivityADScope();
    private static final HashMap<String, HashMap<String, FeedAdSource>> fragmentFeedAdSourceMap = new HashMap<>();

    private ActivityADScope() {
    }

    public final HashMap<String, FeedAdSource> getFeedSourceMap(BaseFragment baseFragment) {
        Intrinsics.checkNotNullParameter(baseFragment, "fragment");
        HashMap<String, HashMap<String, FeedAdSource>> hashMap = fragmentFeedAdSourceMap;
        String fragmentStateID = baseFragment.getFragmentStateID();
        Intrinsics.checkNotNullExpressionValue(fragmentStateID, "fragment.fragmentStateID");
        HashMap<String, FeedAdSource> hashMap2 = hashMap.get(fragmentStateID);
        if (hashMap2 == null) {
            ActivityADScope activityADScope = INSTANCE;
            String fragmentStateID2 = baseFragment.getFragmentStateID();
            Intrinsics.checkNotNullExpressionValue(fragmentStateID2, "fragment.fragmentStateID");
            FragmentActivity requireActivity = baseFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
            activityADScope.addOnItsActivityDestroyCallback(fragmentStateID2, requireActivity);
            hashMap2 = new HashMap<>();
            hashMap.put(fragmentStateID, hashMap2);
        }
        return hashMap2;
    }

    private final void addOnItsActivityDestroyCallback(String str, FragmentActivity fragmentActivity) {
        LogUtils.d("构建广告组 " + str, new Object[0]);
        Lifecycle lifecycle = fragmentActivity.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "activity.lifecycle");
        LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new ActivityADScope$addOnItsActivityDestroyCallback$1(str));
    }
}
