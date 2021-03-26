package com.coolapk.market.view.appmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.content.AsyncTaskLoader;
import com.coolapk.market.model.LocalApk;
import com.coolapk.market.util.LocalApkUtils;
import com.coolapk.market.view.appmanager.OptionPopupMenu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/appmanager/OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$1", "Landroidx/loader/content/AsyncTaskLoader;", "", "loadInBackground", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OptionPopupMenu.kt */
public final class OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$1 extends AsyncTaskLoader<String> {
    final /* synthetic */ OptionPopupMenu.PackageMD5DialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$1(OptionPopupMenu.PackageMD5DialogFragment packageMD5DialogFragment, Context context) {
        super(context);
        this.this$0 = packageMD5DialogFragment;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public String loadInBackground() {
        String string = this.this$0.getString(2131886633);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_can_not_find_file)");
        String str = this.this$0.filePath;
        if (str == null) {
            return string;
        }
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        PackageManager packageManager = requireActivity.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo == null) {
            return string;
        }
        packageArchiveInfo.applicationInfo.sourceDir = str;
        packageArchiveInfo.applicationInfo.publicSourceDir = str;
        LocalApk app = LocalApkUtils.getApp(packageManager, packageArchiveInfo);
        Intrinsics.checkNotNullExpressionValue(app, "localApk");
        return String.valueOf(app.getTargetSdkVersion());
    }
}
