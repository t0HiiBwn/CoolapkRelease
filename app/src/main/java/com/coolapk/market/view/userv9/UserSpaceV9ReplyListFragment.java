package com.coolapk.market.view.userv9;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tH\u0014J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J \u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9ReplyListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onRequestResponse", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFeedListFragment.kt */
public final class UserSpaceV9ReplyListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9ReplyListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/userv9/UserSpaceV9ReplyListFragment;", "uid", "", "num", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserFeedListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserSpaceV9ReplyListFragment newInstance(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "uid");
            UserSpaceV9ReplyListFragment userSpaceV9ReplyListFragment = new UserSpaceV9ReplyListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("UID", str);
            bundle.putInt("NUM", i);
            Unit unit = Unit.INSTANCE;
            userSpaceV9ReplyListFragment.setArguments(bundle);
            return userSpaceV9ReplyListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(TopBottomDividerRule.Companion.getEMPTY());
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558982).constructor(new UserSpaceV9ReplyListFragment$onActivityCreated$1(this)).suitedEntityType("USER_SPACE_COUNT").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558898).constructor(new UserSpaceV9ReplyListFragment$onActivityCreated$2(this)).suitedMethod(UserSpaceV9ReplyListFragment$onActivityCreated$3.INSTANCE).build(), 0, 2, null);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipToPadding(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        RecyclerView recyclerView3 = recyclerView2;
        recyclerView3.setPadding(recyclerView3.getPaddingLeft(), recyclerView3.getPaddingTop(), recyclerView3.getPaddingRight(), NumberExtendsKt.getDp((Number) 12));
        if (getActivity() instanceof UserSpaceV9Activity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.userv9.UserSpaceV9Activity");
            if (((UserSpaceV9Activity) activity).isInBlackList()) {
                setEmptyData("由于你的黑名单设置，该用户动态对你不可见", 0);
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String string = requireArguments().getString("UID");
        DataManager instance = DataManager.getInstance();
        String str = null;
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, true, 7, null);
        String id = findFirstEntity$default != null ? findFirstEntity$default.getId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, true, 1, null);
        if (findLastEntity$default != null) {
            str = findLastEntity$default.getId();
        }
        Observable<R> compose = instance.getUserReplyList(string, i, id, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        boolean z2 = true;
        if (!getDataList().isEmpty()) {
            Parcelable parcelable = (Parcelable) CollectionsKt.first((List<? extends Object>) getDataList());
            if (!(parcelable instanceof HolderItem) || !Intrinsics.areEqual(((HolderItem) parcelable).getEntityType(), "USER_SPACE_COUNT")) {
                z2 = false;
            }
            if (!z2) {
                int i = requireArguments().getInt("NUM", 0);
                List<Parcelable> dataList = getDataList();
                HolderItem.Builder entityType = HolderItem.newBuilder().entityType("USER_SPACE_COUNT");
                HolderItem build = entityType.string("全部回复（" + i + (char) 65289).build();
                Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…                 .build()");
                dataList.add(0, build);
            }
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (obj instanceof HolderItem) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }
}
