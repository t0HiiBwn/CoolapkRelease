package com.coolapk.market.view.settings;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/settings/VXSettingsFragment$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VXSettingsFragment.kt */
public final class VXSettingsFragment$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ VXSettingsFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    VXSettingsFragment$onCreateViewHolder$1(VXSettingsFragment vXSettingsFragment) {
        this.this$0 = vXSettingsFragment;
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        super.onItemClick(viewHolder, view);
        Object obj = this.this$0.getDataList().get(viewHolder.getAdapterPosition());
        Intrinsics.checkNotNullExpressionValue(obj, "dataList[holder.adapterPosition]");
        Integer intValue = ((HolderItem) obj).getIntValue();
        if (intValue != null && intValue.intValue() == 0) {
            ActionManager.startWebViewTitleActivity(this.this$0.getActivity(), "https://account.coolapk.com/account/settings", "", true);
        } else if (intValue != null && intValue.intValue() == 2) {
            ActionManager.startUISettingsActivity(this.this$0.getActivity());
        } else if (intValue != null && intValue.intValue() == 3) {
            ActionManager.startNotificationSettingsActivity(this.this$0.getActivity());
        } else if (intValue != null && intValue.intValue() == 4) {
            ActionManager.startDownloadInstallSettingsActivity(this.this$0.getActivity());
        } else if (intValue != null && intValue.intValue() == 5) {
            ActionManager.startFlowSettingsActivity(this.this$0.getActivity());
        } else if (intValue != null && intValue.intValue() == 6) {
            ActionManager.startBetaSettingsActivity(this.this$0.getActivity());
        } else if (intValue != null && intValue.intValue() == 7) {
            ActionManager.startCacheCleanSettingsActivity(this.this$0.getActivity());
        } else if (intValue != null && intValue.intValue() == 12) {
            ActionManager.startAboutActivity(this.this$0.getActivity());
        } else if (intValue != null && intValue.intValue() == 13) {
            ConfirmDialog newInstance = ConfirmDialog.newInstance("", "你确定要退出登录吗?");
            newInstance.setOnOkRunnable(new VXSettingsFragment$onCreateViewHolder$1$onItemClick$1(this));
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        } else if (intValue != null && intValue.intValue() == 1) {
            ActionManager.startUserProfileActivity(this.this$0.getActivity(), "头像与个人信息");
        } else if (intValue != null && intValue.intValue() == 8) {
            ActionManager.startWebViewTitleActivity(this.this$0.getActivity(), UriUtils.getCoolApkHelpUrl(), "帮助与反馈");
        } else if (intValue != null && intValue.intValue() == 9) {
            ActionManager.startWebViewTitleActivity(this.this$0.getActivity(), UriUtils.getCoolApkUserAgreementUrl(), "用户协议");
        } else if (intValue != null && intValue.intValue() == 10) {
            ActionManager.startWebViewTitleActivity(this.this$0.getActivity(), UriUtils.getCoolApkUserPrivacyUrl(), "隐私政策");
        } else if (intValue != null && intValue.intValue() == 11) {
            ActionManager.startWebViewTitleActivity(this.this$0.getActivity(), UriUtils.getCoolApkErshouAgreementUrl(), "安全条款");
        } else if (intValue != null && intValue.intValue() == 16) {
            ActionManager.startPrivacySettingsActivity(this.this$0.getActivity());
        } else if (intValue != null && intValue.intValue() == 15) {
            ActionManager.startWaterMarkSettingsActivity(this.this$0.getActivity());
        }
    }
}
