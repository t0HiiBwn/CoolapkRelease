package com.coolapk.market.view.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.User;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment;
import com.coolapk.market.view.search.SearchUserContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.TitleViewHolder;
import com.coolapk.market.viewholder.UserViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;

public class SearchUserFragment extends SimpleAsyncListFragment<Result<List<Entity>>, Entity> implements SearchUserContract.View {
    public static SearchUserFragment newInstance() {
        Bundle bundle = new Bundle();
        SearchUserFragment searchUserFragment = new SearchUserFragment();
        searchUserFragment.setArguments(bundle);
        return searchUserFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558967, 2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        if (getUserVisibleHint()) {
            initData();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        boolean z2;
        boolean z3 = false;
        if (result.isSuccess()) {
            if (!CollectionUtils.isEmpty(result.getData())) {
                if (z) {
                    getDataList().addAll(0, result.getData());
                    if (!UiUtils.canScrollDown(getRecyclerView())) {
                        getRecyclerView().smoothScrollToPosition(0);
                    }
                } else {
                    getDataList().addAll(result.getData());
                }
                z2 = true;
            } else {
                z2 = false;
            }
            setEmptyData(getString(2131886765), 0);
            z3 = z2;
        } else {
            setEmptyData(result.getMessage(), 0);
        }
        updateContentUI();
        return z3;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public int getItemViewType(int i) {
        String entityType = ((Entity) getDataList().get(i)).getEntityType();
        entityType.hashCode();
        if (entityType.equals("holder_title")) {
            return 2131558954;
        }
        if (entityType.equals("user")) {
            return 2131558967;
        }
        throw new RuntimeException("unknown viewType");
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(getActivity()).inflate(i, viewGroup, false);
        if (i == 2131558954) {
            return new TitleViewHolder(inflate, null);
        }
        if (i != 2131558967) {
            return null;
        }
        return new UserViewHolder(inflate, getComponent(), new ItemActionHandler() {
            /* class com.coolapk.market.view.search.SearchUserFragment.AnonymousClass1 */

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                super.onItemClick(viewHolder, view);
                if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition()) && view.getId() == 2131362200) {
                    User user = (User) SearchUserFragment.this.getDataList().get(viewHolder.getAdapterPosition());
                    ActionManager.startUserSpaceActivity(viewHolder.itemView.findViewById(2131362672), user.getUid(), user.getUserAvatar());
                }
            }
        });
    }

    @Override // com.coolapk.market.view.search.SearchUserContract.View
    public String findFirstItem() {
        User findFirstUserType = EntityUtils.findFirstUserType(getDataList());
        if (findFirstUserType == null) {
            return null;
        }
        return findFirstUserType.getUid();
    }

    @Override // com.coolapk.market.view.search.SearchUserContract.View
    public String findLastItem() {
        User findLastUserType = EntityUtils.findLastUserType(getDataList());
        if (findLastUserType == null) {
            return null;
        }
        return findLastUserType.getUid();
    }
}
