package com.coolapk.market.view.sharev8;

import android.content.Context;
import com.coolapk.market.view.sharev8.ShareImageListActivity;
import com.coolapk.market.widget.Toast;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/sharev8/ShareImageListActivity$DataAdapter$shareToQQ$1", "Lcom/tencent/tauth/IUiListener;", "onCancel", "", "onComplete", "p0", "", "onError", "Lcom/tencent/tauth/UiError;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShareImageListActivity.kt */
public final class ShareImageListActivity$DataAdapter$shareToQQ$1 implements IUiListener {
    final /* synthetic */ ShareImageListActivity.DataAdapter this$0;

    @Override // com.tencent.tauth.IUiListener
    public void onCancel() {
    }

    @Override // com.tencent.tauth.IUiListener
    public void onComplete(Object obj) {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ShareImageListActivity$DataAdapter$shareToQQ$1(ShareImageListActivity.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    @Override // com.tencent.tauth.IUiListener
    public void onError(UiError uiError) {
        Context context = this.this$0.getContext();
        String str = uiError != null ? uiError.errorMessage : null;
        if (str == null) {
            str = "";
        }
        Toast.show$default(context, str, 0, false, 12, null);
    }
}
