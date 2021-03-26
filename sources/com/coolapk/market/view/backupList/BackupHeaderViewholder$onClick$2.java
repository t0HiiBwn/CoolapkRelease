package com.coolapk.market.view.backupList;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemBackupHeaderBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.view.feed.ConfirmDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupHeaderViewholder.kt */
final class BackupHeaderViewholder$onClick$2<T> implements Action1<Throwable> {
    final /* synthetic */ BackupHeaderViewholder this$0;

    BackupHeaderViewholder$onClick$2(BackupHeaderViewholder backupHeaderViewholder) {
        this.this$0 = backupHeaderViewholder;
    }

    public final void call(Throwable th) {
        TextView textView = ((ItemBackupHeaderBinding) this.this$0.getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setText("创建备份单");
        ProgressBar progressBar = ((ItemBackupHeaderBinding) this.this$0.getBinding()).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AppCompatActivity requireAppCompatActivity = ContextExtendsKt.requireAppCompatActivity(context);
        Throwable cause = th.getCause();
        final ConfirmDialog newInstance = ConfirmDialog.newInstance("备份数量已达上限", cause != null ? cause.getMessage() : null, "删除并创建新备份单", "取消");
        FragmentManager supportFragmentManager = requireAppCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        newInstance.setOnOkRunnable(new Runnable(this) {
            /* class com.coolapk.market.view.backupList.BackupHeaderViewholder$onClick$2.AnonymousClass1 */
            final /* synthetic */ BackupHeaderViewholder$onClick$2 this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.this$0.createList();
                newInstance.dismiss();
            }
        });
    }
}
