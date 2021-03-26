package com.coolapk.market.view.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.view.app.RelatedAlbumsContract;
import com.coolapk.market.view.base.asynclist.AsyncListFragment;
import com.coolapk.market.viewholder.AlbumViewHolder;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;

public class RelatedAlbumsFragment extends AsyncListFragment<Result<List<Entity>>, Entity> implements RelatedAlbumsContract.View {
    public static final String KEY_KEYWORD = "KEYWORD";
    private FragmentBindingComponent component;
    private String keyword;

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("KEYWORD");
        this.keyword = string;
        setPresenter(new RelatedAlbumsPresenter(this, string));
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.component = new FragmentBindingComponent(this);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        setEmptyData(getString(2131886766), 0);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        setAdapter(new DataAdapter());
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558578, 2131231052).last(2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        initData();
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        boolean z2;
        if (!CollectionUtils.isEmpty(result.getData())) {
            if (z) {
                getDataList().clear();
            }
            getDataList().addAll(result.getData());
            z2 = true;
        } else {
            z2 = false;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.app.RelatedAlbumsContract.View
    public String findFirstItem() {
        if (CollectionUtils.isEmpty(getDataList())) {
            return null;
        }
        return ((Album) getDataList().get(0)).getAlbumId();
    }

    @Override // com.coolapk.market.view.app.RelatedAlbumsContract.View
    public String findLastItem() {
        if (CollectionUtils.isEmpty(getDataList())) {
            return null;
        }
        return ((Album) getDataList().get(getDataList().size() - 1)).getAlbumId();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558578;
        }

        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new AlbumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), RelatedAlbumsFragment.this.component, null);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(RelatedAlbumsFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RelatedAlbumsFragment.this.getDataList().size();
        }
    }
}
