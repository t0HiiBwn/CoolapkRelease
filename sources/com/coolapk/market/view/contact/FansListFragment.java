package com.coolapk.market.view.contact;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemContactBinding;
import com.coolapk.market.event.ContactsEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment;
import com.coolapk.market.view.contact.ContactContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ContactViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.TitleViewHolder;
import com.coolapk.market.widget.Toast;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FansListFragment extends SimpleAsyncListFragment<Result<List<Entity>>, Entity> implements ContactContract.View {
    private String loginUserUid;
    private ContactContract.FansPresenter mPresenter;

    public static FansListFragment newInstance() {
        Bundle bundle = new Bundle();
        FansListFragment fansListFragment = new FansListFragment();
        fansListFragment.setArguments(bundle);
        return fansListFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.loginUserUid = DataManager.getInstance().getLoginSession().getUid();
        super.onActivityCreated(bundle);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setRefreshEnable(false);
        if (getUserVisibleHint()) {
            initData();
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public int getItemViewType(int i) {
        String entityType = ((Entity) getDataList().get(i)).getEntityType();
        entityType.hashCode();
        if (!entityType.equals("holder_title")) {
            return !entityType.equals("contacts") ? 0 : 2131558666;
        }
        return 2131558961;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter) {
        super.setPresenter(presenter);
        this.mPresenter = (ContactContract.FansPresenter) presenter;
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

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe
    public void onContactFollowEvent(ContactsEvent contactsEvent) {
        List dataList = getDataList();
        for (int i = 0; i < dataList.size(); i++) {
            Entity entity = (Entity) dataList.get(i);
            if (entity instanceof Contacts) {
                Contacts contacts = (Contacts) entity;
                if (contacts.getUid().equals(contactsEvent.uid)) {
                    setNotifyAdapter(false);
                    getDataList().set(i, Contacts.builder(contacts).setIsFriend(contactsEvent.isFollow ? 1 : 0).build());
                    getAdapter().notifyItemChanged(i);
                    setNotifyAdapter(true);
                    return;
                }
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        if (i == 2131558666) {
            return new FansViewHolder(inflate, getComponent(), new ItemActionHandler() {
                /* class com.coolapk.market.view.contact.FansListFragment.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    super.onItemClick(viewHolder, view);
                    if (view.getId() == 2131361887) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        if (!UiUtils.isInvalidPosition(adapterPosition)) {
                            Contacts contacts = (Contacts) FansListFragment.this.getDataList().get(adapterPosition);
                            if (contacts.getIsFriend() > 0) {
                                FansListFragment.this.mPresenter.unfollowUser(contacts.getUid());
                            } else {
                                FansListFragment.this.mPresenter.followUser(contacts.getUid());
                            }
                        }
                    }
                }
            });
        }
        if (i != 2131558961) {
            return null;
        }
        return new TitleViewHolder(inflate, null);
    }

    @Override // com.coolapk.market.view.contact.ContactContract.View
    public String findFirstItem() {
        Contacts findFirstContactsType = EntityUtils.findFirstContactsType(getDataList());
        if (findFirstContactsType == null) {
            return null;
        }
        return findFirstContactsType.getFollowUid();
    }

    @Override // com.coolapk.market.view.contact.ContactContract.View
    public String findLastItem() {
        Contacts findLastContactsType = EntityUtils.findLastContactsType(getDataList());
        if (findLastContactsType == null) {
            return null;
        }
        return findLastContactsType.getFollowUid();
    }

    public class FansViewHolder extends ContactViewHolder {
        public FansViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler, -1);
        }

        @Override // com.coolapk.market.viewholder.ContactViewHolder
        public void bindToContent(Contacts contacts) {
            super.bindToContent(contacts);
            ((ItemContactBinding) getBinding()).detailContainerView.setVisibility(0);
            ((ItemContactBinding) getBinding()).introduceView.setVisibility(TextUtils.isEmpty(contacts.getUserInfo().getBio()) ? 8 : 0);
            if (FansListFragment.this.mPresenter.getUid().equals(FansListFragment.this.loginUserUid)) {
                ((ItemContactBinding) getBinding()).actionContainer.setVisibility(0);
            }
        }
    }
}
