package com.coolapk.market.view.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemUserNavigationBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.LocalDataFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import java.util.ArrayList;

public class UserNavigationFragment extends LocalDataFragment<HolderItem> {
    public static final String HOLDER_ITEM_TYPE_ITEM = "holder_item";

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public int getItemViewType(int i) {
        return 2131558984;
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().setTitle(getString(2131886937));
        getRecyclerView().addItemDecoration(new PaddingDividerItemDecoration(new PaddingDividerItemDecoration.SimpleCallBack(getActivity()) {
            /* class com.coolapk.market.view.user.UserNavigationFragment.AnonymousClass1 */

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getItemCount() {
                return UserNavigationFragment.this.getDataList().size();
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getDividerHeight(int i) {
                if (i == 0 || i == 4) {
                    return this.m8dp;
                }
                return this.m1dp;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getFirstHeight() {
                return this.m8dp;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getLastHeight() {
                return this.m8dp;
            }
        }));
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        initData();
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new UserNavigationViewHolder(LayoutInflater.from(getActivity()).inflate(i, viewGroup, false), null, new ItemActionHandler() {
            /* class com.coolapk.market.view.user.UserNavigationFragment.AnonymousClass2 */

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                super.onItemClick(viewHolder, view);
                LoginSession loginSession = DataManager.getInstance().getLoginSession();
                int adapterPosition = viewHolder.getAdapterPosition();
                if (adapterPosition == 0) {
                    ActionManager.startWebViewTitleActivity(UserNavigationFragment.this.getActivity(), "https://m.coolapk.com/mp/do?c=userDevice&m=myDevice", UserNavigationFragment.this.getString(2131886939));
                } else if (adapterPosition == 1) {
                    ActionManager.startUserApkCommentActivity(UserNavigationFragment.this.getActivity(), loginSession.getUid());
                } else if (adapterPosition == 2) {
                    ActionManager.startUserRatingActivity(UserNavigationFragment.this.getActivity(), loginSession.getUid());
                } else if (adapterPosition == 3) {
                    ActionManager.startUserLikeListActivity(UserNavigationFragment.this.getActivity(), loginSession.getUid());
                } else if (adapterPosition == 4) {
                    ActionManager.startFeedRoughDraftListFragment(UserNavigationFragment.this.getActivity());
                } else if (adapterPosition == 5) {
                    ActionManager.startUserGiftCenterActivity(UserNavigationFragment.this.getActivity(), loginSession.getUid());
                }
            }
        });
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(2131231672).string(getString(2131886939)).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(2131231492).string(getString(2131887126)).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(2131231490).string(getString(2131887127)).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(2131231677).string(getString(2131887160)).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(2131231666).string(getString(2131887189)).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(2131231673).string(getString(2131886940)).build());
        getDataList().addAll(arrayList);
    }

    public static class UserNavigationViewHolder extends GenericBindHolder<ItemUserNavigationBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558984;

        public UserNavigationViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemUserNavigationBinding) getBinding()).setHolderItem(holderItem);
            ((ItemUserNavigationBinding) getBinding()).iconView.setImageResource(holderItem.getIntValue().intValue());
            ViewUtil.clickListener(((ItemUserNavigationBinding) getBinding()).getRoot(), this);
        }
    }
}
