package com.coolapk.market.view.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.FeedDeleteEvent;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment;
import com.coolapk.market.view.cardlist.divider.EntityListCardStyleRule;
import com.coolapk.market.view.cardlist.divider.EntityListDividerRule;
import com.coolapk.market.view.cardlist.divider.SimpleVXDividerDecoration;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.view.main.AlbumListContract;
import com.coolapk.market.view.userv9.UserSpaceV9Activity;
import com.coolapk.market.viewholder.AlbumViewHolder;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.ItemViewBindingInterceptor;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class AlbumListFragment extends SimpleAsyncListFragment<Result<List<Entity>>, Entity> implements AlbumListContract.View {
    private ItemViewBindingInterceptor bindingInterceptor;
    private boolean shouldDeleteAllOnNextDataLoaded;

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public int getItemViewType(int i) {
        return 2131558582;
    }

    public static AlbumListFragment newInstance() {
        Bundle bundle = new Bundle();
        AlbumListFragment albumListFragment = new AlbumListFragment();
        albumListFragment.setArguments(bundle);
        return albumListFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        boolean z2 = false;
        if (result.isSuccess()) {
            boolean z3 = true;
            if (!CollectionUtils.isEmpty(result.getData())) {
                if (this.shouldDeleteAllOnNextDataLoaded) {
                    getDataList().clear();
                }
                if (z) {
                    getDataList().addAll(0, result.getData());
                    if (!UiUtils.canScrollDown(getRecyclerView())) {
                        getRecyclerView().smoothScrollToPosition(0);
                    }
                } else {
                    int size = getDataList().size();
                    getDataList().addAll(result.getData());
                    getAdapter().notifyItemChanged(size - 1);
                }
            } else {
                z3 = false;
            }
            this.shouldDeleteAllOnNextDataLoaded = false;
            if (!(getActivity() instanceof UserSpaceV9Activity) || !((UserSpaceV9Activity) getActivity()).isInBlackList()) {
                setEmptyData(getString(2131886827), 0);
            } else {
                setEmptyData("由于你的黑名单设置，该用户动态对你不可见", 0);
            }
            z2 = z3;
        } else {
            setEmptyData(result.getMessage(), 0);
        }
        updateContentUI();
        return z2;
    }

    @Subscribe
    public void onFeedDeleted(FeedDeleteEvent feedDeleteEvent) {
        int findAlbumIndexById = FeedUtils.findAlbumIndexById(getDataList(), feedDeleteEvent.id);
        if (findAlbumIndexById >= 0) {
            getDataList().remove(findAlbumIndexById);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAutoUpdateContentUiOnDataChanged(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        SimpleVXDividerDecoration simpleVXDividerDecoration = new SimpleVXDividerDecoration(getRecyclerView().getAdapter(), this.dataList);
        simpleVXDividerDecoration.addDividerRule(new EntityListDividerRule());
        simpleVXDividerDecoration.addDividerRule(TopBottomDividerRule.TB12DP);
        getRecyclerView().addItemDecoration(simpleVXDividerDecoration);
        getRecyclerView().setClipToPadding(false);
        getRecyclerView().setClipChildren(false);
        if (getActivity() instanceof AlphaToolbarActivity) {
            getRecyclerView().setPadding(0, 0, 0, ((AlphaToolbarActivity) getActivity()).getNavigationBarHeight() + DisplayUtils.dp2px(getActivity(), 16.0f));
        }
        ItemViewBindingInterceptor itemViewBindingInterceptor = new ItemViewBindingInterceptor(getDataList(), getRecyclerView().getAdapter(), getFixedRecordId());
        this.bindingInterceptor = itemViewBindingInterceptor;
        itemViewBindingInterceptor.addCardStyleRule(new EntityListCardStyleRule());
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AlbumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), getComponent(), new ItemActionHandler());
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    protected void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
        super.onBindViewHolder(bindingViewHolder, i);
        ItemViewBindingInterceptor itemViewBindingInterceptor = this.bindingInterceptor;
        if (itemViewBindingInterceptor != null) {
            itemViewBindingInterceptor.onBindData(bindingViewHolder, getDataList().get(i));
        }
    }

    @Override // com.coolapk.market.view.main.AlbumListContract.View
    public String findLastItem() {
        Album findLastAlbumType = EntityUtils.findLastAlbumType(getDataList());
        if (findLastAlbumType != null) {
            return findLastAlbumType.getAlbumId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.main.AlbumListContract.View
    public String findFirstItem() {
        Album findFirstAlbumType = EntityUtils.findFirstAlbumType(getDataList());
        if (findFirstAlbumType != null) {
            return findFirstAlbumType.getAlbumId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.main.AlbumListContract.View
    public void clearAllData() {
        this.shouldDeleteAllOnNextDataLoaded = true;
    }
}
