package com.coolapk.market.view.appmanager;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.appmanager.OptionPopupMenu;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: OptionPopupMenu.kt */
final class OptionPopupMenu$PackageMD5DialogFragment$onCreateDialog$2 implements DialogInterface.OnClickListener {
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $title;
    final /* synthetic */ int $versionCode;
    final /* synthetic */ String $versionName;
    final /* synthetic */ OptionPopupMenu.PackageMD5DialogFragment this$0;

    OptionPopupMenu$PackageMD5DialogFragment$onCreateDialog$2(OptionPopupMenu.PackageMD5DialogFragment packageMD5DialogFragment, String str, String str2, int i, String str3) {
        this.this$0 = packageMD5DialogFragment;
        this.$title = str;
        this.$versionName = str2;
        this.$versionCode = i;
        this.$packageName = str3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        StringUtils.copyText(this.this$0.getActivity(), this.$title + " " + this.$versionName + " (" + this.$versionCode + ") " + this.$packageName);
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Toast.show(requireActivity, 2131887190);
    }
}
