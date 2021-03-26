package com.coolapk.market.view.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemGiftItemBinding;
import com.coolapk.market.event.GiftDelEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Gift;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.UserGiftViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscriber;

public class GiftListFragment extends NewAsyncListFragment<List<Gift>> {
    public static final String KEY_APK_ID = "APK_ID";
    private static final String KEY_DATA = "DATA";
    public static final String KEY_UID = "UID";
    public static final String KEY_USER_SIGN = "USER_SIGN";
    private String apkId;
    private final ObservableArrayList<Gift> dataList = new ObservableArrayList<>();
    private AdapterListChangedCallback onListChangeCallback;
    private String sign;
    private String uid;

    public static GiftListFragment newInstance() {
        return new GiftListFragment();
    }

    public static GiftListFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("APK_ID", str);
        GiftListFragment giftListFragment = new GiftListFragment();
        giftListFragment.setArguments(bundle);
        return giftListFragment;
    }

    public static GiftListFragment newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("UID", str);
        bundle.putString("USER_SIGN", str2);
        GiftListFragment giftListFragment = new GiftListFragment();
        giftListFragment.setArguments(bundle);
        return giftListFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.apkId = getArguments().getString("APK_ID");
            this.uid = getArguments().getString("UID");
            this.sign = getArguments().getString("USER_SIGN");
        }
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

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886764), 0);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558751, 2131231051).type(2131558972, 2131231051).last(2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setAdapter(new DataAdapter());
        if (getUserVisibleHint()) {
            initData();
        }
        EventBus.getDefault().register(this);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<Gift> list) {
        boolean z2 = false;
        if (!CollectionUtils.isEmpty(list)) {
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGiftDelEventChanged(GiftDelEvent giftDelEvent) {
        int indexOf = this.dataList.indexOf(giftDelEvent.getGift());
        this.dataList.remove(indexOf);
        getRecyclerView().getAdapter().notifyItemRemoved(indexOf);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Gift>> onCreateRequest(boolean z, int i) {
        String str;
        String str2 = null;
        if (!CollectionUtils.isEmpty(this.dataList)) {
            str2 = ((Gift) this.dataList.get(0)).getId();
            ObservableArrayList<Gift> observableArrayList = this.dataList;
            str = ((Gift) observableArrayList.get(observableArrayList.size() - 1)).getId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(this.apkId)) {
            return DataManager.getInstance().getGiftListByApkId(this.apkId, i, str2, str).map(RxUtils.checkResultToData());
        }
        if (TextUtils.isEmpty(this.uid) || TextUtils.isEmpty(this.sign)) {
            return DataManager.getInstance().getAllGiftList(i, str2, str).map(RxUtils.checkResultToData());
        }
        return DataManager.getInstance().getUserGiftList(this.uid, i, str2, str).map(RxUtils.checkResultToData());
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
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

    private static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558751;
        private final FragmentBindingComponent component;
        private final boolean isShowLogo;

        public DataViewHolder(View view, FragmentBindingComponent fragmentBindingComponent, boolean z, ItemActionHandler itemActionHandler) {
            super(view, fragmentBindingComponent, itemActionHandler);
            this.component = fragmentBindingComponent;
            this.isShowLogo = z;
            ItemGiftItemBinding itemGiftItemBinding = (ItemGiftItemBinding) getBinding();
            ViewUtil.clickListener(itemGiftItemBinding.giftGetText, this);
            ViewUtil.clickListener(itemGiftItemBinding.getRoot(), this);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemGiftItemBinding itemGiftItemBinding = (ItemGiftItemBinding) getBinding();
            Gift gift = (Gift) obj;
            if (this.isShowLogo) {
                AppHolder.getFragmentImageLoader().displayImage((Fragment) this.component.getContainer(), gift.getApkLogo(), itemGiftItemBinding.giftLogoView, 2131231363);
            } else {
                itemGiftItemBinding.giftLogoView.setVisibility(8);
                itemGiftItemBinding.getRoot().setPadding(0, DisplayUtils.dp2px(getContext(), 16.0f), DisplayUtils.dp2px(getContext(), 16.0f), DisplayUtils.dp2px(getContext(), 16.0f));
            }
            itemGiftItemBinding.titleGameView.setText(gift.getTitle());
            int parseInt = Integer.parseInt(gift.getUseCount());
            int parseInt2 = Integer.parseInt(gift.getTotalCount());
            float f = 100.0f - ((((((float) parseInt) * 1.0f) / ((float) parseInt2)) * 1.0f) * 100.0f);
            itemGiftItemBinding.giftProgressView.setProgress((int) f);
            int i = parseInt2 - parseInt;
            if (i > 10) {
                itemGiftItemBinding.progressBarText.setText(getContext().getString(2131886825, Integer.valueOf(Math.round(f))));
                itemGiftItemBinding.progressBarText.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            } else {
                itemGiftItemBinding.progressBarText.setText(getContext().getString(2131886826, Integer.valueOf(i)));
                itemGiftItemBinding.progressBarText.setTextColor(ResourceUtils.getColorInt(getContext(), 2131099820));
            }
            if (gift.isGet()) {
                itemGiftItemBinding.giftGetText.setText(getContext().getString(2131886823));
            } else {
                itemGiftItemBinding.giftGetText.setText(getContext().getString(2131886821));
            }
            itemGiftItemBinding.giftDateLine.setText(gift.getDateline() != null ? DateUtils.getTimeDescription(getContext(), gift.getDateline()) : "");
            if (!TextUtils.isEmpty(gift.getDescription())) {
                itemGiftItemBinding.giftContent.setText(gift.getDescription());
                itemGiftItemBinding.giftContent.setVisibility(0);
                return;
            }
            itemGiftItemBinding.giftContent.setVisibility(8);
        }
    }

    public static class DelGiftDialogFragment extends BaseDialogFragment {
        public static final String GIFT_DATA = "GIFT";
        private Gift gift;

        public static DelGiftDialogFragment newInstance(Gift gift2) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("GIFT", gift2);
            DelGiftDialogFragment delGiftDialogFragment = new DelGiftDialogFragment();
            delGiftDialogFragment.setArguments(bundle);
            return delGiftDialogFragment;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            this.gift = (Gift) getArguments().getParcelable("GIFT");
            return new AlertDialog.Builder(getActivity()).setMessage(getActivity().getString(2131886721)).setPositiveButton(getActivity().getString(2131886708), new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.app.GiftListFragment.DelGiftDialogFragment.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DataManager.getInstance().delUserGift(DelGiftDialogFragment.this.gift.getId(), DelGiftDialogFragment.this.gift.getGiftData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
                        /* class com.coolapk.market.view.app.GiftListFragment.DelGiftDialogFragment.AnonymousClass1.AnonymousClass1 */

                        @Override // rx.Observer
                        public void onCompleted() {
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th) {
                            Toast.error(DelGiftDialogFragment.this.getActivity(), th);
                        }

                        public void onNext(Result<String> result) {
                            EventBus.getDefault().post(new GiftDelEvent(DelGiftDialogFragment.this.gift));
                        }
                    });
                }
            }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create();
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;

        public DataAdapter() {
            this.component = new FragmentBindingComponent(GiftListFragment.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (i == 2131558751) {
                return new DataViewHolder(inflate, this.component, TextUtils.isEmpty(GiftListFragment.this.apkId), new ItemActionHandler() {
                    /* class com.coolapk.market.view.app.GiftListFragment.DataAdapter.AnonymousClass2 */

                    @Override // com.coolapk.market.viewholder.ItemActionHandler
                    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                        super.onItemClick(viewHolder, view);
                        if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                            final Gift gift = (Gift) GiftListFragment.this.dataList.get(viewHolder.getAdapterPosition());
                            int id = view.getId();
                            if (id != 2131362613) {
                                if (id == 2131362768) {
                                    ActionManager.startAppViewActivity(GiftListFragment.this.getActivity(), view.findViewById(2131362616), gift.getApkName(), gift.getApkLogo(), gift.getTitle(), gift.getExtraAnalysisData(), null, null);
                                }
                            } else if (!gift.isRequireInstalled() || PackageUtils.isInstalled(GiftListFragment.this.getActivity(), gift.getApkName())) {
                                FetchGiftDialog.newInstance(gift).show(GiftListFragment.this.getChildFragmentManager(), (String) null);
                            } else {
                                SimpleDialog newInstance = SimpleDialog.newInstance();
                                newInstance.setMessage(GiftListFragment.this.getString(2131886822));
                                newInstance.setPositiveButton(2131886128, new DialogInterface.OnClickListener() {
                                    /* class com.coolapk.market.view.app.GiftListFragment.DataAdapter.AnonymousClass2.AnonymousClass1 */

                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        ActionManager.startAppViewActivity(GiftListFragment.this.getActivity(), gift.getApkName(), true);
                                    }
                                });
                                newInstance.setNegativeButton(2131886115);
                                newInstance.show(GiftListFragment.this.getChildFragmentManager(), (String) null);
                            }
                        }
                    }
                });
            }
            if (i == 2131558972) {
                return new UserGiftViewHolder(inflate, this.component, new ItemActionHandler() {
                    /* class com.coolapk.market.view.app.GiftListFragment.DataAdapter.AnonymousClass1 */

                    @Override // com.coolapk.market.viewholder.ItemActionHandler
                    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                        if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                            Gift gift = (Gift) GiftListFragment.this.dataList.get(viewHolder.getAdapterPosition());
                            int id = view.getId();
                            if (id == 2131362613) {
                                StringUtils.copyText(GiftListFragment.this.getActivity(), gift.getGiftData());
                                Toast.show(GiftListFragment.this.getActivity(), GiftListFragment.this.getString(2131886824));
                            } else if (id == 2131362768) {
                                ActionManager.startAppViewActivity(GiftListFragment.this.getActivity(), view.findViewById(2131362616), gift.getApkName(), gift.getApkLogo(), gift.getApkTitle(), gift.getExtraAnalysisData(), null, null);
                            }
                        }
                    }

                    @Override // com.coolapk.market.viewholder.ItemActionHandler
                    public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
                        DelGiftDialogFragment.newInstance((Gift) GiftListFragment.this.dataList.get(viewHolder.getAdapterPosition())).show(GiftListFragment.this.getChildFragmentManager(), (String) null);
                        return true;
                    }
                });
            }
            throw new IllegalStateException("Unknown view type " + i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (TextUtils.isEmpty(GiftListFragment.this.sign) || TextUtils.isEmpty(GiftListFragment.this.uid)) ? 2131558751 : 2131558972;
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(GiftListFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return GiftListFragment.this.dataList.size();
        }
    }
}
