package com.coolapk.market.view.photo;

import android.view.View;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
final class QRCodeActivity$processOtherText$2 implements View.OnClickListener {
    final /* synthetic */ String $text;
    final /* synthetic */ QRCodeActivity this$0;

    QRCodeActivity$processOtherText$2(QRCodeActivity qRCodeActivity, String str) {
        this.this$0 = qRCodeActivity;
        this.$text = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StringUtils.copyText(this.this$0.getActivity(), this.$text);
        BaseActivity activity = this.this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Toast.show(activity, 2131887252);
        this.this$0.hideResultView();
    }
}
