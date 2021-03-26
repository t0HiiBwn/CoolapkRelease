package com.coolapk.market.view.settings;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppMetadataKt;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemSettingBinding;
import com.coolapk.market.databinding.ItemSimpleDividerBinding;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.LocalDataFragment;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/settings/VXSettingsFragment;", "Lcom/coolapk/market/view/base/refresh/LocalDataFragment;", "Lcom/coolapk/market/model/HolderItem;", "()V", "getItemViewType", "", "position", "initData", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateViewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "SettingDividerViewHolder", "SettingViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VXSettingsFragment.kt */
public final class VXSettingsFragment extends LocalDataFragment<HolderItem> {
    public static final Companion Companion = new Companion(null);
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
    public static final int HOLDER_ITEM_TYPE_PICTU_SETTING = 15;
    public static final int HOLDER_ITEM_TYPE_PRIVACY = 10;
    public static final int HOLDER_ITEM_TYPE_PRIVACY_SETTING = 16;
    public static final int HOLDER_ITEM_TYPE_SECURITY = 11;
    public static final int HOLDER_ITEM_TYPE_SIGNOUT = 13;
    public static final int HOLDER_ITEM_TYPE_UISETTINGS = 2;
    public static final int HOLDER_ITEM_TYPE_USERAGREEMENT = 9;

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.setTitle("设置");
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtents2Kt.tryListenWindowsInset(recyclerView, new VXSettingsFragment$onActivityCreated$1(this));
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        initData();
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public int getItemViewType(int i) {
        HolderItem holderItem = (HolderItem) getDataList().get(i);
        Intrinsics.checkNotNullExpressionValue(holderItem, "data");
        Integer intValue = holderItem.getIntValue();
        if (intValue != null && intValue.intValue() == 14) {
            return SettingDividerViewHolder.Companion.getLAYOUT_ID();
        }
        return SettingViewHolder.Companion.getLAYOUT_ID();
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(getActivity()).inflate(i, viewGroup, false);
        if (i == SettingViewHolder.Companion.getLAYOUT_ID()) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new SettingViewHolder(inflate, new FragmentBindingComponent(this), new VXSettingsFragment$onCreateViewHolder$1(this));
        } else if (i == SettingDividerViewHolder.Companion.getLAYOUT_ID()) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new SettingDividerViewHolder(inflate, new FragmentBindingComponent(this), null);
        } else {
            throw new RuntimeException("unknown view type...");
        }
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        ArrayList arrayList = new ArrayList();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isLogin()) {
            arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("头像与个人信息").intValue(1).build());
        }
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("账号与绑定").intValue(0).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(14).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("界面显示").intValue(2).build());
        AppMetadataKt.runOnAppMode$default(this, null, VXSettingsFragment$initData$1.INSTANCE, null, new VXSettingsFragment$initData$2(arrayList), 5, null);
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("图片设置").intValue(15).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").intValue(14).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("消息提醒").intValue(3).build());
        arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("隐私设置").intValue(16).build());
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
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        LoginSession loginSession2 = instance2.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
        if (loginSession2.isLogin()) {
            arrayList.add(HolderItem.newBuilder().entityType("holder_item").string("退出登录").intValue(13).build());
        }
        getDataList().addAll(arrayList);
        SettingSynchronized.INSTANCE.reloadSettingConfig();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/settings/VXSettingsFragment$SettingViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemSettingBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VXSettingsFragment.kt */
    public static final class SettingViewHolder extends GenericBindHolder<ItemSettingBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        private static final int LAYOUT_ID = 2131558933;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettingViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(itemActionHandler, "onItemClick");
        }

        public void bindToContent(HolderItem holderItem) {
            Typeface typeface;
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
            ItemSettingBinding itemSettingBinding = (ItemSettingBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemSettingBinding, "binding");
            itemSettingBinding.setHolderItem(holderItem);
            Integer intValue = holderItem.getIntValue();
            boolean z = intValue != null && intValue.intValue() == 13;
            ItemSettingBinding itemSettingBinding2 = (ItemSettingBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemSettingBinding2, "binding");
            ViewUtil.clickListener(itemSettingBinding2.getRoot(), this);
            TextView textView = ((ItemSettingBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = z ? 1 : 8388611;
            TextView textView2 = ((ItemSettingBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            textView2.setLayoutParams(layoutParams2);
            ((ItemSettingBinding) getBinding()).titleView.setTextColor(z ? -65536 : AppHolder.getAppTheme().getTextColorPrimary());
            ImageView imageView = ((ItemSettingBinding) getBinding()).imageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
            imageView.setVisibility(z ? 8 : 0);
            TextView textView3 = ((ItemSettingBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
            if (z) {
                typeface = Typeface.defaultFromStyle(1);
            } else {
                typeface = Typeface.defaultFromStyle(0);
            }
            textView3.setTypeface(typeface);
            ((ItemSettingBinding) getBinding()).executePendingBindings();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/settings/VXSettingsFragment$SettingViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "getLAYOUT_ID", "()I", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: VXSettingsFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int getLAYOUT_ID() {
                return SettingViewHolder.LAYOUT_ID;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/settings/VXSettingsFragment$SettingDividerViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemSimpleDividerBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VXSettingsFragment.kt */
    public static final class SettingDividerViewHolder extends GenericBindHolder<ItemSimpleDividerBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        private static final int LAYOUT_ID = 2131558935;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettingDividerViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
            ((ItemSimpleDividerBinding) getBinding()).executePendingBindings();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/settings/VXSettingsFragment$SettingDividerViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "getLAYOUT_ID", "()I", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: VXSettingsFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int getLAYOUT_ID() {
                return SettingDividerViewHolder.LAYOUT_ID;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/settings/VXSettingsFragment$Companion;", "", "()V", "HOLDER_ITEM_TYPE_ABOUT", "", "HOLDER_ITEM_TYPE_ACCOUNT", "HOLDER_ITEM_TYPE_BETA", "HOLDER_ITEM_TYPE_CACHECLEAR", "HOLDER_ITEM_TYPE_DIVIDER", "HOLDER_ITEM_TYPE_DOWNLOAD", "HOLDER_ITEM_TYPE_HELP", "HOLDER_ITEM_TYPE_ITEM", "", "HOLDER_ITEM_TYPE_MEINFO", "HOLDER_ITEM_TYPE_MESSAGE", "HOLDER_ITEM_TYPE_PICTUREMODE", "HOLDER_ITEM_TYPE_PICTU_SETTING", "HOLDER_ITEM_TYPE_PRIVACY", "HOLDER_ITEM_TYPE_PRIVACY_SETTING", "HOLDER_ITEM_TYPE_SECURITY", "HOLDER_ITEM_TYPE_SIGNOUT", "HOLDER_ITEM_TYPE_UISETTINGS", "HOLDER_ITEM_TYPE_USERAGREEMENT", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VXSettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
