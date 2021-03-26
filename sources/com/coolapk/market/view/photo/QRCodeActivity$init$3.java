package com.coolapk.market.view.photo;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
final class QRCodeActivity$init$3 implements View.OnClickListener {
    final /* synthetic */ QRCodeActivity this$0;

    QRCodeActivity$init$3(QRCodeActivity qRCodeActivity) {
        this.this$0 = qRCodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManager.startPhotoPickerActivity(this.this$0.getActivity(), 1, (List<String>) null);
    }
}
