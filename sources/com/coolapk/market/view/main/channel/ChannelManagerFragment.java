package com.coolapk.market.view.main.channel;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.event.ConfigPageEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J$\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020#2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J \u0010.\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\tH\u0014J\u000e\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020&J\b\u00106\u001a\u00020\u001aH\u0002J\u0006\u00107\u001a\u00020\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00068"}, d2 = {"Lcom/coolapk/market/view/main/channel/ChannelManagerFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lcom/coolapk/market/model/ConfigPage;", "Lcom/coolapk/market/view/main/channel/OnStartDragListener;", "()V", "adapter", "Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "value", "", "isEditMode", "()Z", "setEditMode", "(Z)V", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "reset", "getReset", "setReset", "updateUserConfigSub", "Lrx/Subscription;", "viewModel", "Lcom/coolapk/market/view/main/channel/ChannelViewModel;", "getViewModel", "()Lcom/coolapk/market/view/main/channel/ChannelViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "page", "", "onDestroyView", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestFailure", "error", "", "onRequestResponse", "result", "onStartDrag", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "shouldShowList", "startDrag", "position", "updateConfigPage", "updateUserConfig", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChannelManagerFragment.kt */
public final class ChannelManagerFragment extends NewAsyncListFragment<List<? extends ConfigPage>> implements OnStartDragListener {
    private MultiTypeAdapter adapter;
    private boolean isEditMode;
    private ItemTouchHelper itemTouchHelper;
    private boolean reset;
    private Subscription updateUserConfigSub;
    private final ChannelViewModel viewModel = new ChannelViewModel();

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
    }

    public final ChannelViewModel getViewModel() {
        return this.viewModel;
    }

    public final boolean isEditMode() {
        return this.isEditMode;
    }

    public final void setEditMode(boolean z) {
        this.isEditMode = z;
        MultiTypeAdapter multiTypeAdapter = this.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter.notifyDataSetChanged();
    }

    public final boolean getReset() {
        return this.reset;
    }

    public final void setReset(boolean z) {
        this.reset = z;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipChildren(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView3.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(250);
        }
        RecyclerView recyclerView4 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView4.getItemAnimator();
        if (itemAnimator2 != null) {
            itemAnimator2.setMoveDuration(250);
        }
        RecyclerView recyclerView5 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator3 = recyclerView5.getItemAnimator();
        if (itemAnimator3 != null) {
            itemAnimator3.setAddDuration(120);
        }
        RecyclerView recyclerView6 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView6, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator4 = recyclerView6.getItemAnimator();
        if (itemAnimator4 != null) {
            itemAnimator4.setRemoveDuration(120);
        }
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter(this.viewModel.getDataList());
        this.adapter = multiTypeAdapter;
        ChannelViewModel channelViewModel = this.viewModel;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        channelViewModel.setAdapter(multiTypeAdapter);
        MultiTypeAdapter multiTypeAdapter2 = this.adapter;
        if (multiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(multiTypeAdapter2, SimpleViewHolderFactor.Companion.withLayoutId(2131558653).suitedClass(ChannelTitle.class).constructor(new ChannelManagerFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        MultiTypeAdapter multiTypeAdapter3 = this.adapter;
        if (multiTypeAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(multiTypeAdapter3, SimpleViewHolderFactor.Companion.withLayoutId(2131558652).suitedClass(Channel.class).constructor(new ChannelManagerFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        MultiTypeAdapter multiTypeAdapter4 = this.adapter;
        if (multiTypeAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        setAdapter(multiTypeAdapter4);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setSpanSizeLookup(new ChannelManagerFragment$onActivityCreated$3(this));
        setLayoutManager(gridLayoutManager);
        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(new SimpleItemTouchHelperCallback(new ChannelManagerFragment$onActivityCreated$callback$1(this)));
        this.itemTouchHelper = itemTouchHelper2;
        if (itemTouchHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        itemTouchHelper2.attachToRecyclerView(getRecyclerView());
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(2131623944, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == 2131361959) {
            this.reset = true;
            reloadData();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        RxUtils.unsubscribe(this.updateUserConfigSub);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<? extends ConfigPage> list) {
        if (list == null) {
            return true;
        }
        this.viewModel.convertToChannelData(list);
        updateContentUI();
        if (!this.reset) {
            return true;
        }
        updateConfigPage();
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<ConfigPage>> onCreateRequest(boolean z, int i) {
        Observable<R> map = DataManager.getInstance().loadHomeTabConfig(this.reset).doOnUnsubscribe(new ChannelManagerFragment$onCreateRequest$1(this)).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return !this.viewModel.getDataList().isEmpty();
    }

    @Override // com.coolapk.market.view.main.channel.OnStartDragListener
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        ItemTouchHelper itemTouchHelper2 = this.itemTouchHelper;
        if (itemTouchHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        itemTouchHelper2.startDrag(viewHolder);
    }

    public final void startDrag(int i) {
        ChannelManagerFragment$startDrag$1 channelManagerFragment$startDrag$1 = new ChannelManagerFragment$startDrag$1(this, i);
        if (!this.isEditMode) {
            setEditMode(true);
            getRecyclerView().post(new ChannelManagerFragment$startDrag$2(channelManagerFragment$startDrag$1));
            return;
        }
        channelManagerFragment$startDrag$1.invoke();
    }

    public final void updateUserConfig() {
        Subscription subscription = this.updateUserConfigSub;
        if (subscription != null) {
            RxUtils.unsubscribe(subscription);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : this.viewModel.getChannelList()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", t.getId());
            jSONObject.put("title", t.getTitle());
            arrayList.add(jSONObject.put("page_visibility", t.getVisible() ? "1" : "0"));
        }
        String jSONArray = new JSONArray((Collection) arrayList).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(items).toString()");
        this.updateUserConfigSub = DataManager.getInstance().updateHomeTabConfig(jSONArray).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new ChannelManagerFragment$updateUserConfig$1(this));
    }

    /* access modifiers changed from: private */
    public final void updateConfigPage() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        EntityCard configCard = appSetting.getConfigCard();
        Class<? super Object> superclass = configCard.getClass().getSuperclass();
        Intrinsics.checkNotNull(superclass);
        Class<? super Object> superclass2 = superclass.getSuperclass();
        Intrinsics.checkNotNull(superclass2);
        Field declaredField = superclass2.getDeclaredField("entities");
        Intrinsics.checkNotNullExpressionValue(declaredField, "it");
        declaredField.setAccessible(true);
        declaredField.set(configCard, this.viewModel.getConfigPageList());
        AppSetting appSetting2 = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting2, "AppHolder.getAppSetting()");
        appSetting2.setConfigCard(configCard);
        EventBus.getDefault().post(new ConfigPageEvent(false, 1, null));
    }
}
