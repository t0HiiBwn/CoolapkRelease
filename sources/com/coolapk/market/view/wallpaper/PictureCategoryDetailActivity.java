package com.coolapk.market.view.wallpaper;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.wallpaper.coolpic.FallsListFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0014J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014¢\u0006\u0002\u0010\u0017R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/wallpaper/PictureCategoryDetailActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "mCategoryTags", "", "", "[Ljava/lang/String;", "picTag", "getPicTag", "()Ljava/lang/String;", "picTag$delegate", "Lkotlin/Lazy;", "getFragmentItem", "Lcom/coolapk/market/view/wallpaper/PictureCategoryDetailActivity$PictureTagListFragment;", "position", "", "getFragmentItemTag", "getTabStyle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateTabs", "()[Ljava/lang/String;", "PictureTagListFragment", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PictureCategoryDetailActivity.kt */
public final class PictureCategoryDetailActivity extends TabActivity {
    private final String[] mCategoryTags = {"recommend", "hot", "newest"};
    private final Lazy picTag$delegate = LazyKt.lazy(new PictureCategoryDetailActivity$picTag$2(this));

    private final String getPicTag() {
        return (String) this.picTag$delegate.getValue();
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{getString(2131887044), getString(2131887042), getString(2131887043)};
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Toolbar toolbar = getToolbar();
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setTitle(getPicTag());
        ViewPager viewPager = getViewPager();
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        viewPager.setCurrentItem(0);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.base.TabActivity
    public PictureTagListFragment getFragmentItem(int i) {
        return PictureTagListFragment.Companion.newInstance$default(PictureTagListFragment.Companion, getPicTag(), this.mCategoryTags[i], ",", "", null, 16, null);
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String getFragmentItemTag(int i) {
        return (String) ArraysKt.getOrNull(this.mCategoryTags, i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/wallpaper/PictureCategoryDetailActivity$PictureTagListFragment;", "Lcom/coolapk/market/view/wallpaper/coolpic/FallsListFragment;", "()V", "picTag", "", "getPicTag", "()Ljava/lang/String;", "picTag$delegate", "Lkotlin/Lazy;", "picType", "getPicType", "picType$delegate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PictureCategoryDetailActivity.kt */
    public static final class PictureTagListFragment extends FallsListFragment {
        public static final Companion Companion = new Companion(null);
        private final Lazy picTag$delegate = LazyKt.lazy(new PictureCategoryDetailActivity$PictureTagListFragment$picTag$2(this));
        private final Lazy picType$delegate = LazyKt.lazy(new PictureCategoryDetailActivity$PictureTagListFragment$picType$2(this));

        public final String getPicTag() {
            return (String) this.picTag$delegate.getValue();
        }

        public final String getPicType() {
            return (String) this.picType$delegate.getValue();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/wallpaper/PictureCategoryDetailActivity$PictureTagListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/wallpaper/PictureCategoryDetailActivity$PictureTagListFragment;", "tag", "", "type", "action", "title", "subTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: PictureCategoryDetailActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ PictureTagListFragment newInstance$default(Companion companion, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
                if ((i & 8) != 0) {
                    str4 = null;
                }
                if ((i & 16) != 0) {
                    str5 = null;
                }
                return companion.newInstance(str, str2, str3, str4, str5);
            }

            public final PictureTagListFragment newInstance(String str, String str2, String str3, String str4, String str5) {
                Intrinsics.checkNotNullParameter(str, "tag");
                Intrinsics.checkNotNullParameter(str2, "type");
                Intrinsics.checkNotNullParameter(str3, "action");
                PictureTagListFragment pictureTagListFragment = new PictureTagListFragment();
                Bundle bundle = new Bundle();
                bundle.putString("TAG", str);
                bundle.putString("TYPE", str2);
                bundle.putString("URL", str3);
                bundle.putString("TITLE", str4);
                bundle.putString("SUBTITLE", str5);
                Unit unit = Unit.INSTANCE;
                pictureTagListFragment.setArguments(bundle);
                return pictureTagListFragment;
            }
        }

        @Override // com.coolapk.market.view.wallpaper.coolpic.FallsListFragment, com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
        public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
            setUrlParams("tag=" + getPicTag() + "&type=" + getPicType());
            DataManager instance = DataManager.getInstance();
            String picTag = getPicTag();
            String picType = getPicType();
            Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
            String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
            Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
            Observable<R> compose = instance.getPictureTagList(picTag, picType, i, entityId, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null).compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose;
        }
    }
}
