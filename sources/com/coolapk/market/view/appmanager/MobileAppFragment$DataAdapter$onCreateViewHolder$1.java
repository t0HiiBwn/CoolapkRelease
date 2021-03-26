package com.coolapk.market.view.appmanager;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.appmanager.MobileAppFragment;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/appmanager/MobileAppFragment$DataAdapter$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MobileAppFragment.kt */
public final class MobileAppFragment$DataAdapter$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ MobileAppFragment.DataAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MobileAppFragment$DataAdapter$onCreateViewHolder$1(MobileAppFragment.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        if (viewHolder.getAdapterPosition() != -1) {
            SelectionTracker selectionTracker = this.this$0.this$0.tracker;
            if (selectionTracker == null || !selectionTracker.hasSelection()) {
                MobileApp mobileApp = (MobileApp) this.this$0.this$0.getDataList().get(MobileAppFragment.access$getAdapter$p(this.this$0.this$0).sectionedPositionToPosition(viewHolder.getAdapterPosition()));
                int id = view.getId();
                if (id == 2131361887) {
                    Intrinsics.checkNotNullExpressionValue(mobileApp, "mobileApp");
                    FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    if (TextUtils.equals(mobileApp.getPackageName(), requireActivity.getPackageName())) {
                        FragmentActivity requireActivity2 = this.this$0.this$0.requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                        Toast.show(requireActivity2, 2131887278);
                        return;
                    }
                    AppSetting appSetting = AppHolder.getAppSetting();
                    Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
                    if (appSetting.isInstallSilent()) {
                        SimpleDialog newInstance = SimpleDialog.newInstance();
                        newInstance.setMessage(this.this$0.this$0.getString(2131887110, mobileApp.getAppName()));
                        newInstance.setNegativeButton(2131886140);
                        newInstance.setPositiveButton(2131886162, new MobileAppFragment$DataAdapter$onCreateViewHolder$1$onItemClick$1(this, mobileApp));
                        FragmentManager childFragmentManager = this.this$0.this$0.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                        newInstance.show(childFragmentManager, (String) null);
                        return;
                    }
                    ActionManager.uninstall(this.this$0.this$0.getActivity(), mobileApp.getPackageName(), mobileApp.getAppName());
                } else if (id == 2131362779) {
                    Intrinsics.checkNotNullExpressionValue(mobileApp, "mobileApp");
                    ActionManager.startAppViewActivity(this.this$0.this$0.getActivity(), mobileApp.getPackageName());
                } else if (id == 2131362982) {
                    Intrinsics.checkNotNullExpressionValue(mobileApp, "mobileApp");
                    String appName = mobileApp.getAppName();
                    String packageName = mobileApp.getPackageName();
                    String versionName = mobileApp.getVersionName();
                    int versionCode = mobileApp.getVersionCode();
                    String apkPath = mobileApp.getApkPath();
                    FragmentActivity requireActivity3 = this.this$0.this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity3, "requireActivity()");
                    new OptionPopupMenu(requireActivity3, this.this$0.this$0.getChildFragmentManager(), view, 2131623962, appName, packageName, versionName, versionCode, apkPath, null).show();
                }
            }
        }
    }
}
