package com.coolapk.market.view.contact;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemContactBinding;
import com.coolapk.market.event.ContactsEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment;
import com.coolapk.market.view.contact.ContactContract;
import com.coolapk.market.view.feed.CancelFollowItemDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ContactViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.TitleViewHolder;
import com.coolapk.market.widget.Toast;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FriendListFragment extends SimpleAsyncListFragment<Result<List<Entity>>, Entity> implements ContactContract.View {
    private String loginUserUid;
    private ContactContract.FriendPresenter mPresenter;

    public static FriendListFragment newInstance() {
        Bundle bundle = new Bundle();
        FriendListFragment friendListFragment = new FriendListFragment();
        friendListFragment.setArguments(bundle);
        return friendListFragment;
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
        EventBus.getDefault().register(this);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onContactFollowEvent(ContactsEvent contactsEvent) {
        List dataList = getDataList();
        for (int i = 0; i < dataList.size(); i++) {
            Entity entity = (Entity) dataList.get(i);
            if ((entity instanceof Contacts) && ((Contacts) entity).getFollowUid().equals(contactsEvent.uid)) {
                getDataList().remove(i);
                return;
            }
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

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter) {
        super.setPresenter(presenter);
        this.mPresenter = (ContactContract.FriendPresenter) presenter;
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public int getItemViewType(int i) {
        String entityType = ((Entity) getDataList().get(i)).getEntityType();
        entityType.hashCode();
        if (entityType.equals("holder_title")) {
            return 2131558954;
        }
        if (entityType.equals("contacts")) {
            return 2131558660;
        }
        throw new RuntimeException("unknown viewType");
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        if (i == 2131558660) {
            return new FriendViewHolder(inflate, getComponent(), null);
        }
        if (i != 2131558954) {
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

    public class FriendViewHolder extends ContactViewHolder {
        public FriendViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler, 1);
        }

        @Override // com.coolapk.market.viewholder.ContactViewHolder
        public void bindToContent(Contacts contacts) {
            super.bindToContent(contacts);
            boolean z = false;
            ((ItemContactBinding) getBinding()).detailContainerView.setVisibility(0);
            ((ItemContactBinding) getBinding()).introduceView.setVisibility(TextUtils.isEmpty(contacts.getFollowerUserInfo().getBio()) ? 8 : 0);
            if (FriendListFragment.this.mPresenter.getUid().equals(FriendListFragment.this.loginUserUid)) {
                ((ItemContactBinding) getBinding()).messageView.setVisibility(0);
            }
            if (EntityExtendsKt.getIntExtraData(contacts, "showCancelFollowMenu", 0) == 1) {
                z = true;
            }
            if (z && DataManager.getInstance().getLoginSession().getUid().equals(contacts.getUid())) {
                ((ItemContactBinding) getBinding()).getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.coolapk.market.view.contact.FriendListFragment.FriendViewHolder.AnonymousClass1 */

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        if (FriendViewHolder.this.getAdapterPosition() < 0) {
                            return false;
                        }
                        CancelFollowItemDialog.newInstance((Contacts) FriendListFragment.this.getDataList().get(FriendViewHolder.this.getAdapterPosition())).show(FriendListFragment.this.requireActivity().getSupportFragmentManager(), (String) null);
                        return true;
                    }
                });
            }
        }

        @Override // com.coolapk.market.viewholder.ContactViewHolder, com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            if (getAdapterPosition() >= 0) {
                Contacts contacts = (Contacts) FriendListFragment.this.getDataList().get(getAdapterPosition());
                if (view.getId() == 2131362933) {
                    ActionManager.startChattingActivity(FriendListFragment.this.getActivity(), contacts.getFollowUid(), contacts.getFollowUserName());
                }
            }
        }
    }
}
