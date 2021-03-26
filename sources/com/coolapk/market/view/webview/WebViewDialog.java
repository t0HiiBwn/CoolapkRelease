package com.coolapk.market.view.webview;

import android.app.Dialog;
import android.os.Bundle;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/webview/WebViewDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "mAddToFeed", "", "mCallback", "Ljava/lang/Runnable;", "mCopyLink", "mSaveImage", "mUrl", "", "hideTitle", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "setAddToFeed", "callback", "setSaveImage", "setShowCopyLink", "copyLink", "setUrl", "url", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WebViewDialog.kt */
public final class WebViewDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private boolean mAddToFeed;
    private Runnable mCallback;
    private boolean mCopyLink = true;
    private boolean mSaveImage;
    private String mUrl = "";

    @JvmStatic
    public static final WebViewDialog newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/webview/WebViewDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/webview/WebViewDialog;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: WebViewDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final WebViewDialog newInstance() {
            Bundle bundle = new Bundle();
            WebViewDialog webViewDialog = new WebViewDialog();
            webViewDialog.setArguments(bundle);
            return webViewDialog;
        }
    }

    public final void setUrl(String str) {
        if (str == null) {
            str = "";
        }
        this.mUrl = str;
    }

    public final void setSaveImage(boolean z) {
        this.mSaveImage = z;
    }

    public final void setShowCopyLink(boolean z) {
        this.mCopyLink = z;
    }

    public final void setAddToFeed(boolean z, Runnable runnable) {
        this.mAddToFeed = z;
        this.mCallback = runnable;
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment
    protected void hideTitle() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setTitle(this.mUrl);
        }
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        updateDataList(new WebViewDialog$onActivityCreated$1(this));
    }
}
