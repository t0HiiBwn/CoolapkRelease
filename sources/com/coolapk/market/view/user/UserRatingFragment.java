package com.coolapk.market.view.user;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemUserRatingBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.user.UserRatingContract;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;

public class UserRatingFragment extends StateEventListFragment<Result<List<Entity>>, Entity> implements UserRatingContract.View {
    private DataBindingComponent mComponent;
    private UserRatingContract.Presenter mPresenter;

    public static UserRatingFragment newInstance() {
        Bundle bundle = new Bundle();
        UserRatingFragment userRatingFragment = new UserRatingFragment();
        userRatingFragment.setArguments(bundle);
        return userRatingFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAutoUpdateContentUiOnDataChanged(true);
        this.mComponent = new FragmentBindingComponent(this);
        setAdapter(new DataAdapter());
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558988, 2131231062).last(2131231062).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        if (getUserVisibleHint()) {
            initData();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        boolean z2 = false;
        if (result.getData() != null && !result.getData().isEmpty()) {
            if (z) {
                getDataList().addAll(0, result.getData());
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                getDataList().addAll(result.getData());
            }
            z2 = true;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.user.UserRatingContract.View
    public String findFirstItem() {
        ServiceApp findFirstApkType = EntityUtils.findFirstApkType(getDataList());
        if (findFirstApkType != null) {
            return findFirstApkType.getApkId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.user.UserRatingContract.View
    public String findLastItem() {
        ServiceApp findLastApkType = EntityUtils.findLastApkType(getDataList());
        if (findLastApkType != null) {
            return findLastApkType.getApkId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter) {
        super.setPresenter(presenter);
        this.mPresenter = (UserRatingContract.Presenter) presenter;
    }

    @Override // com.coolapk.market.view.user.UserRatingContract.View
    public void onEntityUnrated(ServiceApp serviceApp) {
        getDataList().remove(serviceApp);
    }

    public class DataAdapter extends RecyclerView.Adapter<RatingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558988;
        }

        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RatingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            UserRatingFragment userRatingFragment = UserRatingFragment.this;
            return new RatingViewHolder(inflate, userRatingFragment.mComponent, new ItemActionHandler() {
                /* class com.coolapk.market.view.user.UserRatingFragment.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    super.onItemClick(viewHolder, view);
                    int adapterPosition = viewHolder.getAdapterPosition();
                    if (!UiUtils.isInvalidPosition(adapterPosition) && view.getId() == 2131361887) {
                        UserRatingFragment.this.mPresenter.unrateApp((ServiceApp) UserRatingFragment.this.getDataList().get(adapterPosition));
                    }
                }
            });
        }

        public void onBindViewHolder(RatingViewHolder ratingViewHolder, int i) {
            ratingViewHolder.bindToContent((ServiceApp) UserRatingFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UserRatingFragment.this.getDataList().size();
        }
    }

    private class RatingViewHolder extends GenericBindHolder<ItemUserRatingBinding, ServiceApp> {
        public static final int LAYOUT_ID = 2131558988;

        public RatingViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(ServiceApp serviceApp) {
            ((ItemUserRatingBinding) getBinding()).setApp(serviceApp);
            ((ItemUserRatingBinding) getBinding()).setViewHolder(this);
            ThemeUtils.setRatingBarColor(((ItemUserRatingBinding) getBinding()).ratingBar, Color.parseColor("#ffb712"));
            ((ItemUserRatingBinding) getBinding()).executePendingBindings();
            LoginSession loginSession = DataManager.getInstance().getLoginSession();
            if (!loginSession.isLogin() || !loginSession.getUid().equals(UserRatingFragment.this.mPresenter.getUid())) {
                ((ItemUserRatingBinding) getBinding()).actionContainer.setVisibility(8);
            } else {
                ((ItemUserRatingBinding) getBinding()).actionContainer.setVisibility(0);
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            if (view.getId() == 2131362205) {
                ServiceApp app = ((ItemUserRatingBinding) getBinding()).getApp();
                ActionManager.startAppViewActivity(UserRatingFragment.this.getActivity(), ((ItemUserRatingBinding) getBinding()).iconView, app.getPackageName(), app.getLogo(), app.getAppName(), app.getExtraAnalysisData(), app.getRequestContext(), app.getExtraFromApi());
            }
        }
    }
}
