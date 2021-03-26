package com.coolapk.market.view.feed.pick;

import android.content.Intent;
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
import com.coolapk.market.databinding.ItemSearchViewBinding;
import com.coolapk.market.databinding.ServiceAppBinding;
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
import com.coolapk.market.viewholder.ServiceAppViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;

public class PickSearchAppFragment extends StateEventListFragment<Result<List<Entity>>, Entity> implements SearchAppContract.View {
    private static final String HOLDER_TYPE_SEARCH = "holder type search";
    private SearchAppContract.Presenter presenter;

    public static PickSearchAppFragment newInstance() {
        Bundle bundle = new Bundle();
        PickSearchAppFragment pickSearchAppFragment = new PickSearchAppFragment();
        pickSearchAppFragment.setArguments(bundle);
        return pickSearchAppFragment;
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
        setEmptyData(getString(2131886826), 0);
        setAdapter(new DataAdapter(this));
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558931, 2131231062).type(2131558924, 2131231066).last(2131231062).create());
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
        private FragmentBindingComponent component;

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (i == 2131558924) {
                return new SearchViewHolder(inflate, null, null);
            }
            if (i == 2131558931) {
                return new ServiceAppViewHolder(inflate, this.component, new ItemActionHandler() {
                    /* class com.coolapk.market.view.feed.pick.PickSearchAppFragment.DataAdapter.AnonymousClass1 */

                    @Override // com.coolapk.market.viewholder.ItemActionHandler
                    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                        if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                            Entity entity = (Entity) PickSearchAppFragment.this.getDataList().get(viewHolder.getAdapterPosition());
                            if (view.getId() == 2131362779 && EntityUtils.isApkType(entity.getEntityType())) {
                                PickSearchAppFragment.this.getActivity().setResult(-1, new Intent().putExtra("pick_app_result", ((ServiceApp) entity).getPackageName()));
                                PickSearchAppFragment.this.getActivity().finish();
                            }
                        }
                    }
                }) {
                    /* class com.coolapk.market.view.feed.pick.PickSearchAppFragment.DataAdapter.AnonymousClass2 */

                    @Override // com.coolapk.market.viewholder.ServiceAppViewHolder, com.coolapk.market.viewholder.BindingViewHolder
                    public void bindTo(Object obj) {
                        super.bindTo(obj);
                        ((ServiceAppBinding) getBinding()).actionContainer.setVisibility(8);
                    }
                };
            }
            throw new RuntimeException("xxx");
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(PickSearchAppFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PickSearchAppFragment.this.getDataList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            String entityType = ((Entity) PickSearchAppFragment.this.getDataList().get(i)).getEntityType();
            entityType.hashCode();
            if (entityType.equals("holder type search")) {
                return 2131558924;
            }
            if (entityType.equals("apk")) {
                return 2131558931;
            }
            throw new RuntimeException("error");
        }
    }

    public class SearchViewHolder extends GenericBindHolder<ItemSearchViewBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558924;

        public SearchViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemSearchViewBinding) getBinding()).editText.setText(PickSearchAppFragment.this.getKeyword());
            ((ItemSearchViewBinding) getBinding()).editText.setSelection(PickSearchAppFragment.this.getKeyword().length());
            ViewUtil.clickListener(((ItemSearchViewBinding) getBinding()).imageView, new View.OnClickListener() {
                /* class com.coolapk.market.view.feed.pick.PickSearchAppFragment.SearchViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SearchViewHolder.this.doSearchAction();
                }
            });
            ((ItemSearchViewBinding) getBinding()).editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                /* class com.coolapk.market.view.feed.pick.PickSearchAppFragment.SearchViewHolder.AnonymousClass2 */

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
            PickSearchAppFragment.this.presenter.setKeyword(((ItemSearchViewBinding) getBinding()).editText.getText().toString());
            if (PickSearchAppFragment.this.getDataList().size() > 1) {
                for (int size = PickSearchAppFragment.this.getDataList().size() - 1; size > 0; size--) {
                    PickSearchAppFragment.this.getDataList().remove(size);
                }
            }
            PickSearchAppFragment.this.setPage(1);
            PickSearchAppFragment.this.reloadData();
        }
    }
}
