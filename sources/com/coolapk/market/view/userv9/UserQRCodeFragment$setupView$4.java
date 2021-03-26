package com.coolapk.market.view.userv9;

import android.view.View;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.widget.Toast;
import java.io.File;
import kotlin.Metadata;
import org.apache.commons.io.FileUtils;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserQRCodeFragment.kt */
final class UserQRCodeFragment$setupView$4 implements View.OnClickListener {
    final /* synthetic */ UserQRCodeFragment this$0;

    UserQRCodeFragment$setupView$4(UserQRCodeFragment userQRCodeFragment) {
        this.this$0 = userQRCodeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            File file = this.this$0.saveToTempPath();
            File createBitmapSavePath = BitmapUtil.createBitmapSavePath();
            FileUtils.copyFile(file, createBitmapSavePath);
            CoolFileUtils.notifyNewMediaFile(this.this$0.getActivity(), createBitmapSavePath);
            file.delete();
            Toast.show$default(this.this$0.getActivity(), "保存成功", 0, false, 12, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
