package com.coolapk.market.view.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemPermissionBinding;
import com.coolapk.market.databinding.PermissionBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.PermissionItem;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;
import rx.Subscription;

public class PermissionFragment extends BaseFragment {
    public static final String KEY_PERMISSION_LIST = "PERMISSION_LIST";
    private PermissionBinding binding;
    private List<PermissionItem> permissionItems;
    private Subscription subscription;

    public static PermissionFragment newInstance(ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("PERMISSION_LIST", arrayList);
        PermissionFragment permissionFragment = new PermissionFragment();
        permissionFragment.setArguments(bundle);
        return permissionFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        PermissionBinding permissionBinding = (PermissionBinding) DataBindingUtil.inflate(layoutInflater, 2131559085, viewGroup, false);
        this.binding = permissionBinding;
        return permissionBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.binding.recyclerView.setAdapter(new DataAdapter());
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.binding.recyclerView.addItemDecoration(ItemDecorations.vertical(getActivity()).type(0, 2131231062).last(2131231062).create());
        this.binding.recyclerView.getItemAnimator().setChangeDuration(0);
        this.binding.recyclerView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        this.subscription = DataManager.getInstance().getPermissionList(getArguments().getStringArrayList("PERMISSION_LIST"), getActivity().getPackageManager()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<List<PermissionItem>>() {
            /* class com.coolapk.market.view.app.PermissionFragment.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Toast.error(PermissionFragment.this.getActivity(), th);
            }

            public void onNext(List<PermissionItem> list) {
                PermissionFragment.this.permissionItems = list;
                PermissionFragment.this.binding.recyclerView.getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null && !subscription2.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
        super.onDestroyView();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558855, viewGroup, false));
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(PermissionFragment.this.permissionItems.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(PermissionFragment.this.permissionItems);
        }
    }

    private static class DataViewHolder extends BindingViewHolder {
        public DataViewHolder(View view) {
            super(view);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            PermissionItem permissionItem = (PermissionItem) obj;
            ItemPermissionBinding itemPermissionBinding = (ItemPermissionBinding) getBinding();
            itemPermissionBinding.setPermission(permissionItem);
            itemPermissionBinding.executePendingBindings();
            if (permissionItem.level() == 1) {
                itemPermissionBinding.nameView.setTextColor(AppHolder.getAppTheme().getColorAccent());
            } else {
                itemPermissionBinding.nameView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            }
        }
    }
}
