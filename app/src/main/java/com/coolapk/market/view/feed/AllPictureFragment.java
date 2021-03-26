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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\u0005R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/feed/AllPictureFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "isFolded", "", "()Z", "isFolded$delegate", "Lkotlin/Lazy;", "listType", "", "getListType", "()Ljava/lang/String;", "listType$delegate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AllPictureFragment.kt */
public final class AllPictureFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy isFolded$delegate = LazyKt.lazy(new AllPictureFragment$isFolded$2(this));
    private final Lazy listType$delegate = LazyKt.lazy(new AllPictureFragment$listType$2(this));

    @JvmStatic
    public static final AllPictureFragment newInstance(String str, boolean z) {
        return Companion.newInstance(str, z);
    }

    public final String getListType() {
        return (String) this.listType$delegate.getValue();
    }

    public final boolean isFolded() {
        return ((Boolean) this.isFolded$delegate.getValue()).booleanValue();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        String listType = getListType();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> compose = instance.getAdminNewestList(listType, i, entityId, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null, isFolded() ? 1 : 0).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/AllPictureFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/AllPictureFragment;", "type", "", "isFolded", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AllPictureFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AllPictureFragment newInstance(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "type");
            Bundle bundle = new Bundle();
            bundle.putString("type", str);
            bundle.putBoolean("isFolded", z);
            AllPictureFragment allPictureFragment = new AllPictureFragment();
            allPictureFragment.setArguments(bundle);
            return allPictureFragment;
        }
    }
}
