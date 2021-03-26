package com.coolapk.market.view.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.User;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment;
import com.coolapk.market.view.contact.ContactPickActivityV9;
import com.coolapk.market.view.contact.UserContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.TitleViewHolder;
import com.coolapk.market.viewholder.UserViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006:\u0002./B\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\u001a\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bH\u0016J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0014J$\u0010*\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0014J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020-H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/coolapk/market/view/contact/UserPickFragment;", "Lcom/coolapk/market/view/base/asynclist/SimpleAsyncListFragment;", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "Lcom/coolapk/market/view/contact/UserContract$View;", "Lcom/coolapk/market/view/contact/ContactPickActivityV9$PopLayoutBehavior;", "()V", "filterLock", "Ljava/lang/Object;", "filterSub", "Lrx/Subscription;", "isTaskLoading", "", "keyword", "", "presenter", "Lcom/coolapk/market/view/contact/UserContract$Presenter;", "clearData", "clearDataAndReload", "", "findFirstItem", "findLastItem", "getAdapterFilter", "Landroid/widget/Filter;", "getFilter", "getItemViewType", "", "position", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "onCreateViewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onRequestFailure", "isRefresh", "error", "", "onRequestResponse", "result", "setPresenter", "Lcom/coolapk/market/view/base/asynclist/AsyncListContract$Presenter;", "AutoCompleteOnSubscribe", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserPickFragment.kt */
public final class UserPickFragment extends SimpleAsyncListFragment<Result<List<? extends Entity>>, Entity> implements UserContract.View, ContactPickActivityV9.PopLayoutBehavior {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_KEYWORD = "extra_keyword";
    private final Object filterLock = new Object();
    private Subscription filterSub;
    private boolean isTaskLoading;
    private String keyword;
    private UserContract.Presenter presenter;

    @JvmStatic
    public static final UserPickFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/contact/UserPickFragment$Companion;", "", "()V", "EXTRA_KEYWORD", "", "newInstance", "Lcom/coolapk/market/view/contact/UserPickFragment;", "keyWord", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserPickFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserPickFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "keyWord");
            Bundle bundle = new Bundle();
            bundle.putString("extra_keyword", str);
            UserPickFragment userPickFragment = new UserPickFragment();
            userPickFragment.setArguments(bundle);
            return userPickFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.keyword = requireArguments().getString("extra_keyword");
        UserContract.Presenter presenter2 = this.presenter;
        Intrinsics.checkNotNull(presenter2);
        presenter2.setKeyWord(this.keyword);
        super.onActivityCreated(bundle);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558974, 2131231062).create());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator);
        Intrinsics.checkNotNullExpressionValue(itemAnimator, "recyclerView.itemAnimator!!");
        itemAnimator.setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter2) {
        Intrinsics.checkNotNullParameter(presenter2, "presenter");
        super.setPresenter(presenter2);
        this.presenter = (UserContract.Presenter) presenter2;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        boolean z2;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getData() == null || result.getData().isEmpty()) {
            z2 = false;
        } else {
            if (z) {
                List dataList = getDataList();
                List<Entity> data = result.getData();
                Intrinsics.checkNotNullExpressionValue(data, "result.data");
                dataList.addAll(0, data);
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                List dataList2 = getDataList();
                List<Entity> data2 = result.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "result.data");
                dataList2.addAll(data2);
            }
            z2 = true;
        }
        updateContentUI();
        synchronized (this.filterLock) {
            this.isTaskLoading = false;
            this.filterLock.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Toast.error(getActivity(), th);
        synchronized (this.filterLock) {
            this.isTaskLoading = false;
            this.filterLock.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public int getItemViewType(int i) {
        Entity entity = (Entity) getDataList().get(i);
        Intrinsics.checkNotNullExpressionValue(entity, "entity");
        String entityType = entity.getEntityType();
        if (entityType != null) {
            int hashCode = entityType.hashCode();
            if (hashCode != -602316283) {
                if (hashCode == 3599307 && entityType.equals("user")) {
                    return 2131558974;
                }
            } else if (entityType.equals("holder_title")) {
                return 2131558961;
            }
        }
        throw new RuntimeException("unknown viewType");
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        if (i == 2131558961) {
            return new TitleViewHolder(inflate, null);
        }
        if (i != 2131558974) {
            return null;
        }
        return new UserViewHolder(inflate, getComponent(), new UserPickFragment$onCreateViewHolder$1(this));
    }

    @Override // com.coolapk.market.view.contact.UserContract.View
    public String findFirstItem() {
        User findFirstUserType = EntityUtils.findFirstUserType(getDataList());
        if (findFirstUserType != null) {
            return findFirstUserType.getUid();
        }
        return null;
    }

    @Override // com.coolapk.market.view.contact.UserContract.View
    public String findLastItem() {
        User findLastUserType = EntityUtils.findLastUserType(getDataList());
        if (findLastUserType != null) {
            return findLastUserType.getUid();
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return getAdapterFilter();
    }

    @Override // com.coolapk.market.view.contact.ContactPickActivityV9.OnBackPressedBehavior
    public boolean onBackPressed() {
        return clearData();
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public Filter getAdapterFilter() {
        AutoCompleteOnSubscribe autoCompleteOnSubscribe = new AutoCompleteOnSubscribe();
        this.filterSub = Observable.create(autoCompleteOnSubscribe).debounce(500, TimeUnit.MILLISECONDS).subscribe(new UserPickFragment$getAdapterFilter$1(this));
        return autoCompleteOnSubscribe.getFilter();
    }

    public final boolean clearData() {
        List dataList = getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "getDataList()");
        if (!(!dataList.isEmpty())) {
            return false;
        }
        getDataList().clear();
        setPage(1);
        return true;
    }

    /* access modifiers changed from: private */
    public final void clearDataAndReload() {
        this.isTaskLoading = true;
        getRecyclerView().post(new UserPickFragment$clearDataAndReload$1(this));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0016R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/contact/UserPickFragment$AutoCompleteOnSubscribe;", "Lrx/Observable$OnSubscribe;", "", "(Lcom/coolapk/market/view/contact/UserPickFragment;)V", "<set-?>", "Landroid/widget/Filter;", "filter", "getFilter", "()Landroid/widget/Filter;", "call", "", "subscriber", "Lrx/Subscriber;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserPickFragment.kt */
    private final class AutoCompleteOnSubscribe implements Observable.OnSubscribe<String> {
        private Filter filter;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AutoCompleteOnSubscribe() {
        }

        public final Filter getFilter() {
            Filter filter2 = this.filter;
            if (filter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filter");
            }
            return filter2;
        }

        public void call(Subscriber<? super String> subscriber) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            this.filter = new UserPickFragment$AutoCompleteOnSubscribe$call$1(this, subscriber);
        }
    }
}
