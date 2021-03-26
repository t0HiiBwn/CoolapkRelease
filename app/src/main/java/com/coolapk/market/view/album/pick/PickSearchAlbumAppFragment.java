package com.coolapk.market.view.album.pick;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemPickServiceAppBinding;
import com.coolapk.market.databinding.ItemSearchViewBinding;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.search.SearchAppContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.ServicePickAppViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;
import java.util.Map;

public class PickSearchAlbumAppFragment extends StateEventListFragment<Result<List<Entity>>, Entity> implements SearchAppContract.View {
    private static final String HOLDER_TYPE_SEARCH = "holder type search";
    private Map<String, AlbumItem> commitApps;
    private SearchAppContract.Presenter presenter;

    public static PickSearchAlbumAppFragment newInstance() {
        Bundle bundle = new Bundle();
        PickSearchAlbumAppFragment pickSearchAlbumAppFragment = new PickSearchAlbumAppFragment();
        pickSearchAlbumAppFragment.setArguments(bundle);
        return pickSearchAlbumAppFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter2) {
        super.setPresenter(presenter2);
        this.presenter = (SearchAppContract.Presenter) presenter2;
    }

    public String getKeyword() {
        return this.presenter.getKeyword();
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        if (getDataList().isEmpty()) {
            getDataList().add(HolderItem.newBuilder().entityType("holder type search").build());
        }
        boolean z2 = true;
        if (result.getData() == null || result.getData().isEmpty()) {
            z2 = false;
        } else {
            if (z) {
                getDataList().addAll(1, result.getData());
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                getDataList().addAll(result.getData());
            }
            getRecyclerView().getAdapter().notifyItemChanged(0);
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886764), 0);
        this.commitApps = ((AlbumPickAppTabActivity) getActivity()).getCommitApps();
        setAdapter(new DataAdapter(this));
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558856, 2131231052).type(2131558917, 2131231056).last(2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.search.SearchAppContract.View
    public String findFirstItem() {
        ServiceApp findFirstApkType = EntityUtils.findFirstApkType(getDataList());
        if (findFirstApkType != null) {
            return findFirstApkType.getApkId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.search.SearchAppContract.View
    public String findLastItem() {
        ServiceApp findLastApkType = EntityUtils.findLastApkType(getDataList());
        if (findLastApkType != null) {
            return findLastApkType.getApkId();
        }
        return null;
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (i == 2131558856) {
                return new ServicePickAppViewHolder(inflate, this.component, PickSearchAlbumAppFragment.this.commitApps, new ItemActionHandler() {
                    /* class com.coolapk.market.view.album.pick.PickSearchAlbumAppFragment.DataAdapter.AnonymousClass1 */

                    @Override // com.coolapk.market.viewholder.ItemActionHandler
                    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                        if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                            Entity entity = (Entity) PickSearchAlbumAppFragment.this.getDataList().get(viewHolder.getAdapterPosition());
                            if (view.getId() == 2131362768 && EntityUtils.isApkType(entity.getEntityType())) {
                                ServiceApp serviceApp = (ServiceApp) entity;
                                AlbumItem createAlbumItemBySapp = AlbumItem.createAlbumItemBySapp(serviceApp);
                                PickSearchAlbumAppFragment.this.commitApps.put(serviceApp.getPackageName(), createAlbumItemBySapp);
                                ((AlbumPickAppTabActivity) PickSearchAlbumAppFragment.this.getActivity()).onDone();
                            }
                        }
                    }
                }) {
                    /* class com.coolapk.market.view.album.pick.PickSearchAlbumAppFragment.DataAdapter.AnonymousClass2 */

                    @Override // com.coolapk.market.viewholder.ServicePickAppViewHolder, com.coolapk.market.viewholder.BindingViewHolder
                    public void bindTo(Object obj) {
                        super.bindTo(obj);
                        ((ItemPickServiceAppBinding) getBinding()).appCheckView.setVisibility(8);
                    }
                };
            }
            if (i == 2131558917) {
                return new SearchViewHolder(inflate, null, null);
            }
            throw new RuntimeException("xxx");
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(PickSearchAlbumAppFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PickSearchAlbumAppFragment.this.getDataList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            String entityType = ((Entity) PickSearchAlbumAppFragment.this.getDataList().get(i)).getEntityType();
            entityType.hashCode();
            if (entityType.equals("holder type search")) {
                return 2131558917;
            }
            if (entityType.equals("apk")) {
                return 2131558856;
            }
            throw new RuntimeException("error");
        }
    }

    public class SearchViewHolder extends GenericBindHolder<ItemSearchViewBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558917;

        public SearchViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemSearchViewBinding) getBinding()).editText.setText(PickSearchAlbumAppFragment.this.getKeyword());
            ((ItemSearchViewBinding) getBinding()).editText.setSelection(PickSearchAlbumAppFragment.this.getKeyword().length());
            ViewUtil.clickListener(((ItemSearchViewBinding) getBinding()).imageView, new View.OnClickListener() {
                /* class com.coolapk.market.view.album.pick.PickSearchAlbumAppFragment.SearchViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SearchViewHolder.this.doSearchAction();
                }
            });
            ((ItemSearchViewBinding) getBinding()).editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                /* class com.coolapk.market.view.album.pick.PickSearchAlbumAppFragment.SearchViewHolder.AnonymousClass2 */

                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                        return false;
                    }
                    SearchViewHolder.this.doSearchAction();
                    return true;
                }
            });
        }

        /* access modifiers changed from: private */
        public void doSearchAction() {
            PickSearchAlbumAppFragment.this.presenter.setKeyword(((ItemSearchViewBinding) getBinding()).editText.getText().toString());
            if (PickSearchAlbumAppFragment.this.getDataList().size() > 1) {
                for (int size = PickSearchAlbumAppFragment.this.getDataList().size() - 1; size > 0; size--) {
                    PickSearchAlbumAppFragment.this.getDataList().remove(size);
                }
            }
            PickSearchAlbumAppFragment.this.setPage(1);
            PickSearchAlbumAppFragment.this.reloadData();
        }
    }
}
