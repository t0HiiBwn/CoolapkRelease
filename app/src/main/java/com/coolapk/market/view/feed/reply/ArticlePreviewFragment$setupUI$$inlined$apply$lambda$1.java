package com.coolapk.market.view.feed.reply;

import android.app.ProgressDialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.view.feedv8.BaseFeedContentHolder;
import com.coolapk.market.widget.PrivacyAlertDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/view/feed/reply/ArticlePreviewFragment$setupUI$textView$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticlePreviewFragment.kt */
final class ArticlePreviewFragment$setupUI$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ FragmentActivity $activity$inlined;
    final /* synthetic */ ArticlePreviewFragment this$0;

    ArticlePreviewFragment$setupUI$$inlined$apply$lambda$1(ArticlePreviewFragment articlePreviewFragment, FragmentActivity fragmentActivity) {
        this.this$0 = articlePreviewFragment;
        this.$activity$inlined = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (PrivacyAlertDialog.Companion.shouldShowByIntent()) {
            PrivacyAlertDialog newInstance = PrivacyAlertDialog.Companion.newInstance();
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            return;
        }
        if (this.this$0.contentHolder == null) {
            Toast.show$default(this.this$0.getActivity(), "当前无法发布，请重新打开预览界面，或者回到上一页提交", 0, false, 12, null);
        }
        BaseFeedContentHolder baseFeedContentHolder = this.this$0.contentHolder;
        if (baseFeedContentHolder != null) {
            baseFeedContentHolder.setPostListener(new BaseFeedContentHolder.PostListener(this) {
                /* class com.coolapk.market.view.feed.reply.ArticlePreviewFragment$setupUI$$inlined$apply$lambda$1.AnonymousClass1 */
                private ProgressDialog dialog;
                final /* synthetic */ ArticlePreviewFragment$setupUI$$inlined$apply$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final ProgressDialog getDialog() {
                    return this.dialog;
                }

                public final void setDialog(ProgressDialog progressDialog) {
                    this.dialog = progressDialog;
                }

                @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder.PostListener
                public void onPostStart() {
                    if (this.this$0.$activity$inlined != null && !this.this$0.$activity$inlined.isFinishing()) {
                        this.dialog = new ProgressDialog(this.this$0.$activity$inlined);
                    }
                    ProgressDialog progressDialog = this.dialog;
                    if (progressDialog != null) {
                        progressDialog.setProgressStyle(0);
                    }
                    ProgressDialog progressDialog2 = this.dialog;
                    if (progressDialog2 != null) {
                        progressDialog2.setCancelable(false);
                    }
                    ProgressDialog progressDialog3 = this.dialog;
                    if (progressDialog3 != null) {
                        progressDialog3.setCanceledOnTouchOutside(false);
                    }
                    try {
                        ProgressDialog progressDialog4 = this.dialog;
                        if (progressDialog4 != null) {
                            progressDialog4.show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder.PostListener
                public void onNewMessage(String str) {
                    Intrinsics.checkNotNullParameter(str, "message");
                    ProgressDialog progressDialog = this.dialog;
                    if (progressDialog != null) {
                        progressDialog.setMessage(str);
                    }
                }

                @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder.PostListener
                public void onPostResult(Throwable th) {
                    ProgressDialog progressDialog = this.dialog;
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    FragmentActivity fragmentActivity = this.this$0.$activity$inlined;
                    if (fragmentActivity != null) {
                        fragmentActivity.finish();
                    }
                }
            });
        }
        BaseFeedContentHolder baseFeedContentHolder2 = this.this$0.contentHolder;
        if (baseFeedContentHolder2 != null) {
            baseFeedContentHolder2.onSubmitButtonClick();
        }
    }
}
