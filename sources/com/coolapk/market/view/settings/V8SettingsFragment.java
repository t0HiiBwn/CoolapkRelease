package com.coolapk.market.view.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSettingBinding;
import com.coolapk.market.databinding.ItemSimpleDividerBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.LocalDataFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

public class V8SettingsFragment extends LocalDataFragment<HolderItem> {
    public static final int HOLDER_ITEM_TYPE_ABOUT = 12;
    public static final int HOLDER_ITEM_TYPE_ACCOUNT = 0;
    public static final int HOLDER_ITEM_TYPE_BETA = 6;
    public static final int HOLDER_ITEM_TYPE_CACHECLEAR = 7;
    public static final int HOLDER_ITEM_TYPE_DIVIDER = 14;
    public static final int HOLDER_ITEM_TYPE_DOWNLOAD = 4;
    public static final int HOLDER_ITEM_TYPE_HELP = 8;
    public static final String HOLDER_ITEM_TYPE_ITEM = "holder_item";
    public static final int HOLDER_ITEM_TYPE_MEINFO = 1;
    public static final int HOLDER_ITEM_TYPE_MESSAGE = 3;
    public static final int HOLDER_ITEM_TYPE_PICTUREMODE = 5;
    public static final int HOLDER_ITEM_TYPE_PRIVACY = 10;
    public static final int HOLDER_ITEM_TYPE_SECURITY = 11;
    public static final int HOLDER_ITEM_TYPE_SIGNOUT = 13;
    public static final int HOLDER_ITEM_TYPE_UISETTINGS = 2;
    public static final int HOLDER_ITEM_TYPE_USERAGREEMENT = 9;

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public int getItemViewType(int i) {
        return 2131558933;
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().setTitle("设置");
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        initData();
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SettingViewHolder(LayoutInflater.from(getActivity()).inflate(i, viewGroup, false), null, new ItemActionHandler() {
            /* class com.coolapk.market.view.settings.V8SettingsFragment.AnonymousClass1 */

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                super.onItemClick(viewHolder, view);
                switch (((HolderItem) V8SettingsFragment.this.getDataList().get(viewHolder.getAdapterPosition())).getIntValue().intValue()) {
                    case 0:
                        ActionManager.startWebViewTitleActivity(V8SettingsFragment.this.getActivity(), "https://account.coolapk.com/account/settings", "", true);
                        return;
                    case 1:
                        ActionManager.startUserProfileActivity(V8SettingsFragment.this.getActivity(), "头像与个人信息");
                        return;
                    case 2:
                        ActionManager.startUISettingsActivity(V8SettingsFragment.this.getActivity());
                        return;
                    case 3:
                        ActionManager.startNotificationSettingsActivity(V8SettingsFragment.this.getActivity());
                        return;
                    case 4:
                        ActionManager.startDownloadInstallSettingsActivity(V8SettingsFragment.this.getActivity());
                        return;
                    case 5:
                        ActionManager.startFlowSettingsActivity(V8SettingsFragment.this.getActivity());
                        return;
                    case 6:
                        ActionManager.startBetaSettingsActivity(V8SettingsFragment.this.getActivity());
                        return;
                    case 7:
                        ActionManager.startCacheCleanSettingsActivity(V8SettingsFragment.this.getActivity());
                        return;
                    case 8:
                        ActionManager.startWebViewTitleActivity(V8SettingsFragment.this.getActivity(), UriUtils.getCoolApkHelpUrl(), "帮助与反馈");
                        return;
                    case 9:
                        ActionManager.startWebViewTitleActivity(V8SettingsFragment.this.getActivity(), UriUtils.getCoolApkUserAgreementUrl(), "用户协议");
                        return;
                    case 10:
                        ActionManager.startWebViewTitleActivity(V8SettingsFragment.this.getActivity(), UriUtils.getCoolApkUserPrivacyUrl(), "隐私政策");
                        return;
                    case 11:
                        ActionManager.startWebViewTitleActivity(V8SettingsFragment.this.getActivity(), UriUtils.getCoolApkErshouAgreementUrl(), "安全条款");
                        return;
                    case 12:
                        ActionManager.startAboutActivity(V8SettingsFragment.this.getActivity());
                        return;
                    case 13:
                        ConfirmDialog newInstance = ConfirmDialog.newInstance("", "你确定要退出登录吗?");
                        newInstance.setOnOkRunnable(new Runnable() {
                            /* class com.coolapk.market.view.settings.V8SettingsFragment.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                LoginSession loginSession = DataManager.getInstance().getLoginSession();
                                loginSession.reset();
                                EventBus.getDefault().post(loginSession);
                                V8SettingsFragment.this.getActivity().finish();
                            }
                        });
                        newInstance.show(V8SettingsFragment.this.getChildFragmentManager(), (String) null);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        ArrayList arrayList = new ArrayList();
        if (DataManager.getInstance().getLoginSession().isLogin()) {
            arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("头像与个人信息").intValue(1).build());
        }
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("账号与绑定").intValue(0).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(14).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("界面显示").intValue(2).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("消息提醒").intValue(3).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("下载安装").intValue(4).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string(getString(2131886574)).intValue(5).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(14).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("实验室").intValue(6).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(14).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("缓存清理").intValue(7).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("帮助与反馈").intValue(8).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("用户协议").intValue(9).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("隐私政策").intValue(10).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("安全条款").intValue(11).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("关于").intValue(12).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(14).build());
        if (DataManager.getInstance().getLoginSession().isLogin()) {
            arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("退出登录").intValue(13).build());
        }
        getDataList().addAll(arrayList);
    }

    public static class SettingViewHolder extends GenericBindHolder<ItemSettingBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558933;

        public SettingViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemSettingBinding) getBinding()).setHolderItem(holderItem);
            int i = 1;
            int i2 = 0;
            boolean z = holderItem.getIntValue().intValue() == 13;
            ViewUtil.clickListener(((ItemSettingBinding) getBinding()).getRoot(), this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((ItemSettingBinding) getBinding()).titleView.getLayoutParams();
            if (!z) {
                i = 3;
            }
            layoutParams.gravity = i;
            ((ItemSettingBinding) getBinding()).titleView.setLayoutParams(layoutParams);
            ((ItemSettingBinding) getBinding()).titleView.setTextColor(z ? -65536 : AppHolder.getAppTheme().getTextColorPrimary());
            ImageView imageView = ((ItemSettingBinding) getBinding()).imageView;
            if (z) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            ((ItemSettingBinding) getBinding()).executePendingBindings();
        }
    }

    public static class SettingDividerViewHolder extends GenericBindHolder<ItemSimpleDividerBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558935;

        public SettingDividerViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ((ItemSimpleDividerBinding) getBinding()).executePendingBindings();
        }
    }
}
