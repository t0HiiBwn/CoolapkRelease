package com.coolapk.market.view.node.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.PermissionItem;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.view.app.AppDetailContract;
import com.coolapk.market.view.app.AppDetailPresenter;
import com.coolapk.market.view.app.AppDetailViewModel;
import com.coolapk.market.view.app.DeveloperCard;
import com.coolapk.market.view.app.RelatedAlbumCard;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: AppDetailListFragment.kt */
public final class AppDetailListFragment extends EntityListFragment implements AppDetailContract.View {
    private static final String CARD_TYPE_DETAIL = "DETAIL";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_APP = "APP";
    private final Lazy presenter$delegate = LazyKt.lazy(new AppDetailListFragment$presenter$2(this));
    private final Lazy serviceApp$delegate = LazyKt.lazy(new AppDetailListFragment$serviceApp$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new AppDetailListFragment$viewModel$2(this));

    public final AppDetailPresenter getPresenter() {
        return (AppDetailPresenter) this.presenter$delegate.getValue();
    }

    public final ServiceApp getServiceApp() {
        return (ServiceApp) this.serviceApp$delegate.getValue();
    }

    public final AppDetailViewModel getViewModel() {
        return (AppDetailViewModel) this.viewModel$delegate.getValue();
    }

    /* compiled from: AppDetailListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppDetailListFragment newInstance(ServiceApp serviceApp) {
            Intrinsics.checkNotNullParameter(serviceApp, "serviceApp");
            AppDetailListFragment appDetailListFragment = new AppDetailListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("APP", serviceApp);
            Unit unit = Unit.INSTANCE;
            appDetailListFragment.setArguments(bundle);
            return appDetailListFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<List<Entity>> fromCallable = Observable.fromCallable(new AppDetailListFragment$onCreateRequest$1(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …   createData()\n        }");
        return fromCallable;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new AppDetailListFragment$onActivityCreated$1());
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558590).suitedEntityType("DETAIL").constructor(new AppDetailListFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558590).suitedEntityType("DETAIL").constructor(new AppDetailListFragment$onActivityCreated$3(this)).build(), 0, 2, null);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558956).suitedEntityType("apkScrollCard").constructor(new AppDetailListFragment$onActivityCreated$4(this)).doAfterBind(new AppDetailListFragment$onActivityCreated$5(this)).build(), 0);
        AppDetailPresenter presenter = getPresenter();
        ServiceApp serviceApp = getServiceApp();
        Intrinsics.checkNotNullExpressionValue(serviceApp, "serviceApp");
        List<String> permissions = serviceApp.getPermissions();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        presenter.loadPermission(permissions, requireActivity.getPackageManager());
    }

    @Override // com.coolapk.market.view.app.AppDetailContract.View
    public void onLoadPermissionComplete(List<PermissionItem> list, Throwable th) {
        getAdapter$presentation_coolapkAppRelease().notifyItemChanged(0);
    }

    public final ArrayList<Entity> createData() {
        ArrayList<Entity> arrayList = new ArrayList<>();
        arrayList.add(HolderItem.newBuilder().entityType("DETAIL").entityId("1").build());
        DeveloperCard developerCard = getViewModel().getDeveloperCard();
        Intrinsics.checkNotNullExpressionValue(developerCard, "viewModel.developerCard");
        if (!CollectionUtils.isEmpty(developerCard.getEntities())) {
            EntityCard.Builder url = EntityCard.builder().setEntityType("apkScrollCard").setEntityId("2").setTitle("该开发者的更多应用").setUrl("2");
            DeveloperCard developerCard2 = getViewModel().getDeveloperCard();
            Intrinsics.checkNotNullExpressionValue(developerCard2, "viewModel.developerCard");
            List<ServiceApp> entities = developerCard2.getEntities();
            Intrinsics.checkNotNull(entities);
            arrayList.add(url.setEntities(new ArrayList(entities)).build());
        }
        RelatedAlbumCard relatedAlbumCard = getViewModel().getRelatedAlbumCard();
        Intrinsics.checkNotNullExpressionValue(relatedAlbumCard, "viewModel.relatedAlbumCard");
        if (!CollectionUtils.isEmpty(relatedAlbumCard.getEntities())) {
            EntityCard.Builder url2 = EntityCard.builder().setEntityType("apkScrollCard").setEntityId("3").setTitle("相关应用集").setUrl("3");
            RelatedAlbumCard relatedAlbumCard2 = getViewModel().getRelatedAlbumCard();
            Intrinsics.checkNotNullExpressionValue(relatedAlbumCard2, "viewModel.relatedAlbumCard");
            List<Album> entities2 = relatedAlbumCard2.getEntities();
            Intrinsics.checkNotNull(entities2);
            arrayList.add(url2.setEntities(new ArrayList(entities2)).build());
        }
        return arrayList;
    }
}
