package com.coolapk.market.view.appmanager;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.view.appmanager.OptionPopupMenu;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/appmanager/OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$2", "Landroidx/loader/content/AsyncTaskLoader;", "", "loadInBackground", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OptionPopupMenu.kt */
public final class OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$2 extends AsyncTaskLoader<String> {
    final /* synthetic */ OptionPopupMenu.PackageMD5DialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$2(OptionPopupMenu.PackageMD5DialogFragment packageMD5DialogFragment, Context context) {
        super(context);
        this.this$0 = packageMD5DialogFragment;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public String loadInBackground() {
        String string = this.this$0.getString(2131886633);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_can_not_find_file)");
        String str = this.this$0.filePath;
        if (str == null || !new File(this.this$0.filePath).exists()) {
            return string;
        }
        String fileMd5 = CoolFileUtils.getFileMd5(str);
        return fileMd5 != null ? fileMd5 : "未知";
    }
}
