package com.coolapk.market.view.webview;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.util.PhotoUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.CopyActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: WebViewDialog.kt */
final class WebViewDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ WebViewDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewDialog$onActivityCreated$1(WebViewDialog webViewDialog) {
        super(1);
        this.this$0 = webViewDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        if (this.this$0.mCopyLink) {
            String string = this.this$0.getString(2131886423);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.menu_action_copy_link)");
            list.add(new CopyActionItem(string, this.this$0.mUrl));
        }
        if (this.this$0.mSaveImage) {
            String string2 = this.this$0.getString(2131886992);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_photo_view_save_photo)");
            MultiItemDialogFragmentKt.addItem(list, string2, new Function0<Unit>(this) {
                /* class com.coolapk.market.view.webview.WebViewDialog$onActivityCreated$1.AnonymousClass1 */
                final /* synthetic */ WebViewDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    String str = this.this$0.this$0.mUrl;
                    File webViewSaveCacheFile = PhotoUtils.getWebViewSaveCacheFile(str);
                    Intrinsics.checkNotNullExpressionValue(webViewSaveCacheFile, "PhotoUtils.getWebViewSaveCacheFile(url)");
                    if (webViewSaveCacheFile.exists()) {
                        str = webViewSaveCacheFile.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(str, "path.absolutePath");
                    }
                    PhotoUtils.saveImageObservable(str, false).subscribe((Subscriber<? super File>) new EmptySubscriber());
                }
            });
        }
        if (this.this$0.mAddToFeed) {
            String string3 = this.this$0.getString(2131886333);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.dialog_add_to_feed_photo)");
            MultiItemDialogFragmentKt.addItem(list, string3, new Function0<Unit>(this) {
                /* class com.coolapk.market.view.webview.WebViewDialog$onActivityCreated$1.AnonymousClass2 */
                final /* synthetic */ WebViewDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    Runnable runnable = this.this$0.this$0.mCallback;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }
}
