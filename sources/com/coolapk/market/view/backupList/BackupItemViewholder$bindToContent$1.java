package com.coolapk.market.view.backupList;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.event.BackupDelEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupItemViewholder.kt */
final class BackupItemViewholder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ BackupInfo $entity;
    final /* synthetic */ BackupItemViewholder this$0;

    BackupItemViewholder$bindToContent$1(BackupItemViewholder backupItemViewholder, BackupInfo backupInfo) {
        this.this$0 = backupItemViewholder;
        this.$entity = backupInfo;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确定要删除此备份单吗？", "确定", "取消");
        newInstance.setOnOkRunnable(new Runnable(this) {
            /* class com.coolapk.market.view.backupList.BackupItemViewholder$bindToContent$1.AnonymousClass1 */
            final /* synthetic */ BackupItemViewholder$bindToContent$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DataManager.getInstance().deleteBackup(this.this$0.$entity.getId()).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                    /* class com.coolapk.market.view.backupList.BackupItemViewholder$bindToContent$1.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            Toast.show$default(this.this$0.this$0.this$0.getContext(), str, 0, false, 12, null);
                            EventBus.getDefault().post(new BackupDelEvent(this.this$0.this$0.$entity.getId()));
                        }
                    }
                }, new Action1<Throwable>(this) {
                    /* class com.coolapk.market.view.backupList.BackupItemViewholder$bindToContent$1.AnonymousClass1.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(Throwable th) {
                        Toast.error(this.this$0.this$0.this$0.getContext(), th);
                    }
                });
            }
        });
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        return true;
    }
}
