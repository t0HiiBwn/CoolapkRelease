package com.coolapk.market.view.user.block;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemLargeTextBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.base.refresh.LocalDataFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import java.util.ArrayList;

public class UserPrivacySettingFragment extends LocalDataFragment<HolderItem> {
    public static final String HOLDER_ITEM_TYPE_ITEM = "holder_item";

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public int getItemViewType(int i) {
        return 2131558804;
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().addItemDecoration(new PaddingDividerItemDecoration(new PaddingDividerItemDecoration.SimpleCallBack(getActivity()) {
            /* class com.coolapk.market.view.user.block.UserPrivacySettingFragment.AnonymousClass1 */

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getItemCount() {
                return UserPrivacySettingFragment.this.getDataList().size();
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getDividerHeight(int i) {
                if (i == 0) {
                    return this.m8dp;
                }
                return this.m1dp;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getFirstHeight() {
                return this.m8dp;
            }
        }));
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        initData();
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new LargeTextViewHolder(LayoutInflater.from(getActivity()).inflate(i, viewGroup, false), null);
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string(getString(2131887129)).build());
        getDataList().addAll(arrayList);
    }

    private class LargeTextViewHolder extends GenericBindHolder<ItemLargeTextBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558804;

        public LargeTextViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemLargeTextBinding) getBinding()).setHolder(holderItem);
            ((ItemLargeTextBinding) getBinding()).getRoot().setOnClickListener(new View.OnClickListener() {
                /* class com.coolapk.market.view.user.block.UserPrivacySettingFragment.LargeTextViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int adapterPosition = LargeTextViewHolder.this.getAdapterPosition();
                    if (adapterPosition == 0) {
                        ActionManager.startBlackUserListFragment(UserPrivacySettingFragment.this.getActivity());
                    } else if (adapterPosition == 1) {
                        ActionManager.startIgnoreUserListFragment(UserPrivacySettingFragment.this.getActivity());
                    } else if (adapterPosition == 2) {
                        ActionManager.startLimitedUserListFragment(UserPrivacySettingFragment.this.getActivity());
                    }
                }
            });
        }
    }
}
