package com.coolapk.market.view.user.block;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemUserBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.User;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.view.user.block.BlockedUserListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.UserViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public abstract class BlockedUserListFragment extends NewAsyncListFragment<Result<List<User>>> {
    private static final String KEY_DATA = "DATA";
    private final ObservableArrayList<User> dataList = new ObservableArrayList<>();

    public abstract Observable<Result<String>> onCancelClick(User user);

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

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getRecyclerView().setClipToPadding(false);
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), 48.0f));
        DataAdapter dataAdapter = new DataAdapter();
        setAdapter(dataAdapter);
        this.dataList.addOnListChangedCallback(new AdapterListChangedCallback(dataAdapter));
        if (getUserVisibleHint()) {
            initData();
        }
    }

    public ObservableArrayList<User> getDataList() {
        return this.dataList;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<User>> result) {
        boolean z2 = false;
        if (!CollectionUtils.isEmpty(result.getData())) {
            if (z) {
                this.dataList.addAll(0, result.getData());
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                this.dataList.addAll(result.getData());
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

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    public String findFirstItem() {
        if (this.dataList.size() > 0) {
            return ((User) this.dataList.get(0)).getUid();
        }
        return null;
    }

    public String findLastItem() {
        if (this.dataList.size() <= 0) {
            return null;
        }
        ObservableArrayList<User> observableArrayList = this.dataList;
        return ((User) observableArrayList.get(observableArrayList.size() - 1)).getUid();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558967;
        }

        public DataAdapter() {
            this.component = new FragmentBindingComponent(BlockedUserListFragment.this.getFragment());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (i == 2131558967) {
                return new UserViewHolder(inflate, this.component, null) {
                    /* class com.coolapk.market.view.user.block.BlockedUserListFragment.DataAdapter.AnonymousClass1 */
                    private boolean isRequesting;

                    @Override // com.coolapk.market.viewholder.UserViewHolder
                    public void bindToContent(final User user) {
                        super.bindToContent(user);
                        this.isRequesting = false;
                        ((ItemUserBinding) getBinding()).actionContainer.setVisibility(0);
                        ((ItemUserBinding) getBinding()).actionButton.setText(2131886115);
                        ((ItemUserBinding) getBinding()).actionContainer.setOnClickListener(new View.OnClickListener() {
                            /* class com.coolapk.market.view.user.block.BlockedUserListFragment.DataAdapter.AnonymousClass1.AnonymousClass1 */

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!AnonymousClass1.this.isRequesting) {
                                    AnonymousClass1.this.isRequesting = true;
                                    BlockedUserListFragment.this.onCancelClick(user).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                                        /* class com.coolapk.market.view.user.block.BlockedUserListFragment.DataAdapter.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                        public void onError(Throwable th) {
                                            super.onError(th);
                                            Toast.error(BlockedUserListFragment.this.getActivity(), th);
                                            AnonymousClass1.this.isRequesting = false;
                                        }

                                        public void onNext(String str) {
                                            super.onNext((AnonymousClass1) str);
                                            BlockedUserListFragment.this.getDataList().remove(user);
                                        }
                                    });
                                }
                            }
                        });
                        ((ItemUserBinding) getBinding()).cardView.setOnClickListener(new View.OnClickListener(user) {
                            /* class com.coolapk.market.view.user.block.$$Lambda$BlockedUserListFragment$DataAdapter$1$VBmBbpkAn2JNnFlaMSBMJYsrYqA */
                            public final /* synthetic */ User f$1;

                            {
                                this.f$1 = r2;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                BlockedUserListFragment.DataAdapter.AnonymousClass1.this.lambda$bindToContent$0$BlockedUserListFragment$DataAdapter$1(this.f$1, view);
                            }
                        });
                    }

                    public /* synthetic */ void lambda$bindToContent$0$BlockedUserListFragment$DataAdapter$1(User user, View view) {
                        ActionManager.startUserSpaceActivity(((ItemUserBinding) getBinding()).iconView, user.getUid(), user.getUserAvatar());
                    }
                };
            }
            throw new IllegalStateException("Unknown view type " + i);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(BlockedUserListFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return BlockedUserListFragment.this.dataList.size();
        }
    }
}
