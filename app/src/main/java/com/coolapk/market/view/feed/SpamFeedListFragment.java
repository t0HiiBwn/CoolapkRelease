package com.coolapk.market.view.feed;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feed/SpamFeedListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "channel", "", "getChannel", "()Ljava/lang/String;", "channel$delegate", "Lkotlin/Lazy;", "spamType", "getSpamType", "spamType$delegate", "subType", "getSubType", "subType$delegate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SpamFeedListFragment.kt */
public final class SpamFeedListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy channel$delegate = LazyKt.lazy(new SpamFeedListFragment$channel$2(this));
    private final Lazy spamType$delegate = LazyKt.lazy(new SpamFeedListFragment$spamType$2(this));
    private final Lazy subType$delegate = LazyKt.lazy(new SpamFeedListFragment$subType$2(this));

    private final String getChannel() {
        return (String) this.channel$delegate.getValue();
    }

    private final String getSpamType() {
        return (String) this.spamType$delegate.getValue();
    }

    private final String getSubType() {
        return (String) this.subType$delegate.getValue();
    }

    @JvmStatic
    public static final SpamFeedListFragment newInstance(String str, String str2, String str3) {
        return Companion.newInstance(str, str2, str3);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        String channel = getChannel();
        String spamType = getSpamType();
        String subType = getSubType();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> compose = instance.getSpamFeedList(channel, spamType, subType, i, entityId, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/SpamFeedListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/SpamFeedListFragment;", "channel", "", "spamType", "subType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SpamFeedListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SpamFeedListFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "channel");
            Intrinsics.checkNotNullParameter(str2, "spamType");
            Intrinsics.checkNotNullParameter(str3, "subType");
            Bundle bundle = new Bundle();
            bundle.putString("channel", str);
            bundle.putString("spamType", str2);
            bundle.putString("subType", str3);
            SpamFeedListFragment spamFeedListFragment = new SpamFeedListFragment();
            spamFeedListFragment.setArguments(bundle);
            return spamFeedListFragment;
        }
    }
}
