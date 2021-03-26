package com.coolapk.market.view.feed.pick;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.ItemPickAppBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.LocalDataFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class PickLocalAppFragment extends LocalDataFragment<MobileApp> {
    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public int getItemViewType(int i) {
        return 2131558855;
    }

    public static PickLocalAppFragment newInstance() {
        Bundle bundle = new Bundle();
        PickLocalAppFragment pickLocalAppFragment = new PickLocalAppFragment();
        pickLocalAppFragment.setArguments(bundle);
        return pickLocalAppFragment;
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().setTitle(getString(2131887286));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558855, 2131231052).create());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        initData();
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PickAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), getComponent(), new ItemActionHandler() {
            /* class com.coolapk.market.view.feed.pick.PickLocalAppFragment.AnonymousClass1 */

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                super.onItemClick(viewHolder, view);
                PickLocalAppFragment.this.getActivity().setResult(-1, new Intent().putExtra("pick_app_result", ((MobileApp) PickLocalAppFragment.this.getDataList().get(viewHolder.getAdapterPosition())).getPackageName()));
                PickLocalAppFragment.this.getActivity().finish();
            }
        });
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        Observable.create(new Observable.OnSubscribe<List<MobileApp>>() {
            /* class com.coolapk.market.view.feed.pick.PickLocalAppFragment.AnonymousClass3 */

            public void call(Subscriber<? super List<MobileApp>> subscriber) {
                try {
                    List<MobileApp> mobileAppExistList = DataManager.getInstance().getMobileAppExistList();
                    Collections.sort(mobileAppExistList, $$Lambda$PickLocalAppFragment$3$aQMgjGpsKm7J4CGfvSh8D1KB5KQ.INSTANCE);
                    subscriber.onNext(mobileAppExistList);
                } catch (Exception e) {
                    subscriber.onError(e);
                }
                subscriber.onCompleted();
            }
        }).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<List<MobileApp>>() {
            /* class com.coolapk.market.view.feed.pick.PickLocalAppFragment.AnonymousClass2 */

            public void onNext(List<MobileApp> list) {
                PickLocalAppFragment.this.getDataList().addAll(list);
            }
        });
    }

    public static class PickAppViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558855;

        public PickAppViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemPickAppBinding itemPickAppBinding = (ItemPickAppBinding) getBinding();
            itemPickAppBinding.setApp((MobileApp) obj);
            ViewUtil.clickListener(itemPickAppBinding.getRoot(), this);
            itemPickAppBinding.executePendingBindings();
        }
    }
}
