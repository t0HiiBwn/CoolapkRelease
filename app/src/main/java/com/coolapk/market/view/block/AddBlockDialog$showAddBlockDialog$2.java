package com.coolapk.market.view.block;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.DialogAddBlockWordBinding;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import rx.Subscriber;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AddBlockDialog.kt */
final class AddBlockDialog$showAddBlockDialog$2 implements View.OnClickListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ DialogAddBlockWordBinding $binding;
    final /* synthetic */ Function0 $callback;
    final /* synthetic */ DialogFragment $dialog;

    AddBlockDialog$showAddBlockDialog$2(DialogAddBlockWordBinding dialogAddBlockWordBinding, Activity activity, DialogFragment dialogFragment, Function0 function0) {
        this.$binding = dialogAddBlockWordBinding;
        this.$activity = activity;
        this.$dialog = dialogFragment;
        this.$callback = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText = this.$binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String obj = editText.getText().toString();
        if (obj.length() < 2 || obj.length() > 15) {
            Toast.show$default(this.$activity, "屏蔽失败，请输入2-15字以内的词语", 0, false, 12, null);
        } else if (!Intrinsics.areEqual(new Regex("\\p{P}|\\p{S}").replace(obj, ""), obj)) {
            Toast.show$default(this.$activity, "屏蔽失败，关键词内不允许存在标点符号", 0, false, 12, null);
        } else {
            List<BlockItem> blockItems = BlockContentManager.INSTANCE.getBlockItems("word");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(blockItems, 10));
            Iterator<T> it2 = blockItems.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getName());
            }
            if (arrayList.contains(obj)) {
                Toast.show$default(this.$activity, "屏蔽失败，已存在相同的屏蔽词", 0, false, 12, null);
                return;
            }
            final Dialog showProgressDialog$default = DialogUtil.showProgressDialog$default(DialogUtil.INSTANCE, this.$activity, "正在添加...", false, 4, null);
            BlockContentManager.INSTANCE.updateSpamConfig(CollectionsKt.mutableListOf(new BlockItem(null, obj, null, null, true, null, "word", 45, null))).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new Action0() {
                /* class com.coolapk.market.view.block.AddBlockDialog$showAddBlockDialog$2.AnonymousClass2 */

                @Override // rx.functions.Action0
                public final void call() {
                    showProgressDialog$default.dismiss();
                }
            }).subscribe((Subscriber<? super R>) new EmptySubscriber<String>(this) {
                /* class com.coolapk.market.view.block.AddBlockDialog$showAddBlockDialog$2.AnonymousClass3 */
                final /* synthetic */ AddBlockDialog$showAddBlockDialog$2 this$0;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.this$0 = r1;
                }

                public void onNext(String str) {
                    super.onNext((AnonymousClass3) str);
                    this.this$0.$dialog.dismiss();
                    Function0 function0 = this.this$0.$callback;
                    if (function0 != null) {
                        Unit unit = (Unit) function0.invoke();
                    }
                }

                @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                public void onError(Throwable th) {
                    Toast.error(this.this$0.$activity, th);
                }
            });
        }
    }
}
