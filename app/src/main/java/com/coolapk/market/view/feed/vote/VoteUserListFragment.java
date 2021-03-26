package com.coolapk.market.view.feed.vote;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.User;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.SingleDividerRule;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0014¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteUserListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "onRequestResponse", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteUserListFragment.kt */
public final class VoteUserListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ID = "id";
    public static final String EXTRA_OPTION_ID = "option_id";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteUserListFragment$Companion;", "", "()V", "EXTRA_ID", "", "EXTRA_OPTION_ID", "newInstance", "Lcom/coolapk/market/view/feed/vote/VoteUserListFragment;", "id", "optionId", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteUserListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VoteUserListFragment newInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "optionId");
            VoteUserListFragment voteUserListFragment = new VoteUserListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString("option_id", str2);
            Unit unit = Unit.INSTANCE;
            voteUserListFragment.setArguments(bundle);
            return voteUserListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558989).constructor(new VoteUserListFragment$onActivityCreated$1(this)).suitedMethod(VoteUserListFragment$onActivityCreated$2.INSTANCE).build(), 0);
        getVxDividerDecoration$presentation_coolapkAppRelease().setDefaultNoMargin();
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SingleDividerRule(DividerData.Companion.createImmutable$default(DividerData.Companion, NumberExtendsKt.getDp((Number) 56), 0, NumberExtendsKt.getDp(Double.valueOf(0.5d)), null, 8, null)));
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(TopBottomDividerRule.Companion.getEMPTY());
        getVxDividerDecoration$presentation_coolapkAppRelease().setDividerColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String str;
        String str2;
        Parcelable parcelable;
        boolean z2;
        T t;
        boolean z3;
        String string = requireArguments().getString("id");
        String string2 = requireArguments().getString("option_id");
        if (z) {
            str = "";
        } else {
            Iterator<T> it2 = getDataList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                T t2 = t;
                if (!(t2 instanceof User) || t2.getIsAnonymous() != 0) {
                    z3 = false;
                    continue;
                } else {
                    z3 = true;
                    continue;
                }
                if (z3) {
                    break;
                }
            }
            if (!(t instanceof User)) {
                t = null;
            }
            T t3 = t;
            str = t3 != null ? t3.getUid() : null;
        }
        if (z) {
            str2 = "";
        } else {
            List<Parcelable> dataList = getDataList();
            ListIterator<Parcelable> listIterator = dataList.listIterator(dataList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    parcelable = null;
                    break;
                }
                parcelable = listIterator.previous();
                Parcelable parcelable2 = parcelable;
                if (!(parcelable2 instanceof User) || ((User) parcelable2).getIsAnonymous() != 0) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            if (!(parcelable instanceof User)) {
                parcelable = null;
            }
            User user = (User) parcelable;
            str2 = user != null ? user.getUid() : null;
        }
        Observable<R> compose = DataManager.getInstance().getVoteUserList(string, string2, i, str, str2).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        if (z) {
            getDataList().clear();
        }
        return super.onRequestResponse(z, list);
    }
}
