package com.coolapk.market.view.main;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/main/RecommendAppListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "action", "", "apkType", "subTitle", "title", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecommendAppListFragment.kt */
public final class RecommendAppListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ACTION = "action";
    public static final String KEY_APK_TYPE = "apk_type";
    public static final String KEY_SUBTITLE = "SUBTITLE";
    public static final String KEY_TITLE = "title";
    private String action;
    private String apkType;
    private String subTitle;
    private String title;

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apkType = requireArguments().getString("apk_type");
        this.title = requireArguments().getString("title");
        this.action = requireArguments().getString("action");
        this.subTitle = requireArguments().getString("SUBTITLE");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/main/RecommendAppListFragment$Companion;", "", "()V", "KEY_ACTION", "", "KEY_APK_TYPE", "KEY_SUBTITLE", "KEY_TITLE", "newInstance", "Lcom/coolapk/market/view/main/RecommendAppListFragment;", "apkType", "title", "subTitle", "action", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RecommendAppListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecommendAppListFragment newInstance(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "apkType");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "subTitle");
            Intrinsics.checkNotNullParameter(str4, "action");
            RecommendAppListFragment recommendAppListFragment = new RecommendAppListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("apk_type", str);
            bundle.putString("title", str2);
            bundle.putString("SUBTITLE", str3);
            bundle.putString("action", str4);
            recommendAppListFragment.setArguments(bundle);
            return recommendAppListFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        Observable<R> map = DataManager.getInstance().getRecommendAppList(this.apkType, this.title, this.subTitle, this.action, i, (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, "apk", null, false, false, 14, null)) == null) ? null : findFirstEntity$default.getEntityId(), (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this, "apk", false, 2, null)) == null) ? null : findLastEntity$default.getEntityId()).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }
}
