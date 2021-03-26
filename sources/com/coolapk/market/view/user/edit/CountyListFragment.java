package com.coolapk.market.view.user.edit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemTextBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.view.WeUIItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class CountyListFragment extends NewAsyncListFragment<List<HolderItem>> {
    public static final String HOLDER_ITEM_TYPE_ITEM = "holder_item";
    private static final String KEY_DATA = "DATA";
    private final ObservableArrayList<HolderItem> dataList = new ObservableArrayList<>();
    private boolean isLoaded = false;
    private AdapterListChangedCallback onListChangeCallback;

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().setTitle(getString(2131886688));
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558946, 2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setClipToPadding(false);
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), 48.0f));
        setAdapter(new DataAdapter());
        setLoadMoreEnable(false);
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<HolderItem> list) {
        boolean z2 = false;
        if (!CollectionUtils.isEmpty(list)) {
            EntityUtils.removeReduplicatedEntity(list, this.dataList, null);
            if (z) {
                this.dataList.addAll(0, list);
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                this.dataList.addAll(list);
            }
            z2 = true;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<HolderItem>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getCountryList().doOnNext(new Action1<Result<String>>() {
            /* class com.coolapk.market.view.user.edit.CountyListFragment.AnonymousClass2 */

            public void call(Result<String> result) {
                if (result.getData() == null) {
                    Toast.show(CountyListFragment.this.getActivity(), result.getMessage());
                }
            }
        }).flatMap(new Func1<Result<String>, Observable<List<HolderItem>>>() {
            /* class com.coolapk.market.view.user.edit.CountyListFragment.AnonymousClass1 */

            public Observable<List<HolderItem>> call(Result<String> result) {
                if (TextUtils.isEmpty(result.getData())) {
                    return null;
                }
                List asList = Arrays.asList(result.getData().split(";"));
                ArrayList arrayList = new ArrayList(asList.size());
                for (int i = 0; i < asList.size(); i++) {
                    HolderItem build = HolderItem.newBuilder().entityType("holder_item").value(((String) asList.get(i)).split(":")[0]).string(((String) asList.get(i)).split(":")[1]).build();
                    if (!CountyListFragment.this.isLoaded) {
                        arrayList.add(build);
                    }
                }
                CountyListFragment.this.isLoaded = true;
                return Observable.just(arrayList);
            }
        });
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        if (this.onListChangeCallback == null) {
            AdapterListChangedCallback adapterListChangedCallback = new AdapterListChangedCallback(adapter);
            this.onListChangeCallback = adapterListChangedCallback;
            this.dataList.addOnListChangedCallback(adapterListChangedCallback);
        }
    }

    public static class CountryViewHolder extends GenericBindHolder<ItemTextBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558946;

        public CountryViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemTextBinding) getBinding()).itemText.setVisibility(4);
            ((ItemTextBinding) getBinding()).itemText.setContent(holderItem.getString());
            WeUIItem weUIItem = ((ItemTextBinding) getBinding()).itemText;
            weUIItem.setTitle("+" + holderItem.getValue());
            final TextView textView = (TextView) ((ItemTextBinding) getBinding()).itemText.getViewById(2131363581);
            textView.post(new Runnable() {
                /* class com.coolapk.market.view.user.edit.CountyListFragment.CountryViewHolder.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    textView.getLayoutParams().width = DisplayUtils.dp2px(CountryViewHolder.this.getContext(), 48.0f);
                    textView.requestLayout();
                    ((ItemTextBinding) CountryViewHolder.this.getBinding()).itemText.setVisibility(0);
                }
            });
            ViewUtil.clickListener(((ItemTextBinding) getBinding()).getRoot(), this);
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558946;
        }

        public DataAdapter() {
            this.component = new FragmentBindingComponent(CountyListFragment.this.getFragment());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new CountryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.component, new ItemActionHandler() {
                /* class com.coolapk.market.view.user.edit.CountyListFragment.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    super.onItemClick(viewHolder, view);
                    CountyListFragment.this.getActivity().setResult(-1, new Intent().putExtra("COUNTRY", (HolderItem) CountyListFragment.this.dataList.get(viewHolder.getAdapterPosition())));
                    CountyListFragment.this.getActivity().finish();
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(CountyListFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CountyListFragment.this.dataList.size();
        }
    }
}
