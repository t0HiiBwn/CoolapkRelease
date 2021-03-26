package com.coolapk.market.view.message;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Message;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewMessageListFragment.kt */
final class NewMessageListFragment$onShowDelView$2 implements View.OnClickListener {
    final /* synthetic */ NewMessageListFragment this$0;

    NewMessageListFragment$onShowDelView$2(NewMessageListFragment newMessageListFragment) {
        this.this$0 = newMessageListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinkedHashMap linkedHashMap = this.this$0.delList;
        Intrinsics.checkNotNull(linkedHashMap);
        if (!linkedHashMap.isEmpty()) {
            boolean z = this.this$0.isSelectAll;
            StringBuilder sb = new StringBuilder();
            sb.append("确定要删除");
            LinkedHashMap linkedHashMap2 = this.this$0.delList;
            Intrinsics.checkNotNull(linkedHashMap2);
            sb.append(linkedHashMap2.size());
            sb.append("条会话？");
            String sb2 = sb.toString();
            if (z) {
                sb2 = "确定要删除全部会话？";
            }
            ConfirmDialog newInstance = ConfirmDialog.newInstance(sb2, "删除会话会删除与对方所有的聊天记录，且无法恢复！", "确认删除", "取消");
            newInstance.setOnOkRunnable(new Runnable(this) {
                /* class com.coolapk.market.view.message.NewMessageListFragment$onShowDelView$2.AnonymousClass1 */
                final /* synthetic */ NewMessageListFragment$onShowDelView$2 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    TextView textView = NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0.this$0).deleteView;
                    Intrinsics.checkNotNullExpressionValue(textView, "messageSelectViewBinding.deleteView");
                    textView.setVisibility(4);
                    ProgressBar progressBar = NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0.this$0).loadingView;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "messageSelectViewBinding.loadingView");
                    progressBar.setVisibility(0);
                    final StringBuilder sb = new StringBuilder();
                    LinkedHashMap linkedHashMap = this.this$0.this$0.delList;
                    Intrinsics.checkNotNull(linkedHashMap);
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    LinkedHashMap linkedHashMap2 = this.this$0.this$0.delList;
                    Intrinsics.checkNotNull(linkedHashMap2);
                    if (!linkedHashMap2.isEmpty()) {
                        LinkedHashMap linkedHashMap3 = this.this$0.this$0.delList;
                        Intrinsics.checkNotNull(linkedHashMap3);
                        arrayList.addAll(linkedHashMap3.values());
                        int size = arrayList.size();
                        for (int i = 0; i < size; i++) {
                            Object obj = arrayList.get(i);
                            Intrinsics.checkNotNullExpressionValue(obj, "mesgList[i]");
                            sb.append(((Message) obj).getEntityId());
                            if (i >= arrayList.size() - 1) {
                                break;
                            }
                            sb.append(",");
                        }
                        Observable.just(Boolean.valueOf(this.this$0.this$0.isSelectAll())).flatMap(new Func1<Boolean, Observable<? extends Result<List<String>>>>() {
                            /* class com.coolapk.market.view.message.NewMessageListFragment$onShowDelView$2.AnonymousClass1.AnonymousClass1 */

                            public final Observable<? extends Result<List<String>>> call(Boolean bool) {
                                Intrinsics.checkNotNull(bool);
                                if (bool.booleanValue()) {
                                    return DataManager.getInstance().deleteChatAll();
                                }
                                return DataManager.getInstance().deleteChatMulti(sb.toString());
                            }
                        }).compose(RxUtils.apiCommonToData()).subscribe(new Action1<List<String>>(this) {
                            /* class com.coolapk.market.view.message.NewMessageListFragment$onShowDelView$2.AnonymousClass1.AnonymousClass2 */
                            final /* synthetic */ AnonymousClass1 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void call(List<String> list) {
                                Intrinsics.checkNotNullExpressionValue(list, "s");
                                if (!list.isEmpty()) {
                                    this.this$0.this$0.this$0.deleteChat(this.this$0.this$0.this$0.getDataList(), list);
                                    LinkedHashMap linkedHashMap = this.this$0.this$0.this$0.delList;
                                    Intrinsics.checkNotNull(linkedHashMap);
                                    linkedHashMap.clear();
                                }
                                this.this$0.this$0.this$0.updateDelView();
                                TextView textView = NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0.this$0.this$0).deleteView;
                                Intrinsics.checkNotNullExpressionValue(textView, "messageSelectViewBinding.deleteView");
                                textView.setVisibility(0);
                                ProgressBar progressBar = NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0.this$0.this$0).loadingView;
                                Intrinsics.checkNotNullExpressionValue(progressBar, "messageSelectViewBinding.loadingView");
                                progressBar.setVisibility(8);
                            }
                        }, new Action1<Throwable>(this) {
                            /* class com.coolapk.market.view.message.NewMessageListFragment$onShowDelView$2.AnonymousClass1.AnonymousClass3 */
                            final /* synthetic */ AnonymousClass1 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void call(Throwable th) {
                                Toast.error(AppHolder.getApplication(), th);
                                TextView textView = NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0.this$0.this$0).deleteView;
                                Intrinsics.checkNotNullExpressionValue(textView, "messageSelectViewBinding.deleteView");
                                textView.setVisibility(0);
                                ProgressBar progressBar = NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0.this$0.this$0).loadingView;
                                Intrinsics.checkNotNullExpressionValue(progressBar, "messageSelectViewBinding.loadingView");
                                progressBar.setVisibility(8);
                            }
                        });
                    }
                }
            });
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
    }
}
