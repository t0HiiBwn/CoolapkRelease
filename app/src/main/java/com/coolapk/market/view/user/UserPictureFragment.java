package com.coolapk.market.view.user;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.wallpaper.coolpic.FallsListFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/user/UserPictureFragment;", "Lcom/coolapk/market/view/wallpaper/coolpic/FallsListFragment;", "()V", "uid", "", "getUid", "()Ljava/lang/String;", "uid$delegate", "Lkotlin/Lazy;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserPictureFragment.kt */
public final class UserPictureFragment extends FallsListFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy uid$delegate = LazyKt.lazy(new UserPictureFragment$uid$2(this));

    @JvmStatic
    public static final UserPictureFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    public final String getUid() {
        return (String) this.uid$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/user/UserPictureFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/user/UserPictureFragment;", "uid", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserPictureFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserPictureFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "uid");
            UserPictureFragment userPictureFragment = new UserPictureFragment();
            Bundle bundle = new Bundle();
            bundle.putString("uid", str);
            bundle.putString("URL", "/feed/userCoolPictureFeedList?fragmentTemplate=flex&uid=" + str);
            Unit unit = Unit.INSTANCE;
            userPictureFragment.setArguments(bundle);
            return userPictureFragment;
        }
    }

    @Override // com.coolapk.market.view.wallpaper.coolpic.FallsListFragment, com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        String uid = getUid();
        String str = null;
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default != null) {
            str = findLastEntity$default.getEntityId();
        }
        Observable<R> compose = instance.getUserPictureList(uid, i, entityId, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }
}
