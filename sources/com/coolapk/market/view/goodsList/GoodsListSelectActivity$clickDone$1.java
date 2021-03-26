package com.coolapk.market.view.goodsList;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsListSelectActivity.kt */
final class GoodsListSelectActivity$clickDone$1 implements View.OnClickListener {
    final /* synthetic */ GoodsListSelectActivity this$0;

    GoodsListSelectActivity$clickDone$1(GoodsListSelectActivity goodsListSelectActivity) {
        this.this$0 = goodsListSelectActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x004f, code lost:
        if ((!r2.isEmpty()) != false) goto L_0x0051;
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ProgressBar progressBar = GoodsListSelectActivity.access$getBinding$p(this.this$0).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        boolean z = false;
        progressBar.setVisibility(0);
        TextView textView = GoodsListSelectActivity.access$getBinding$p(this.this$0).actionDone;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
        textView.setVisibility(4);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        LinkedHashMap linkedHashMap = this.this$0.goodsListMap;
        Intrinsics.checkNotNull(linkedHashMap);
        if (!(!linkedHashMap.isEmpty())) {
            LinkedHashMap linkedHashMap2 = this.this$0.cancelMap;
            Intrinsics.checkNotNull(linkedHashMap2);
        }
        LinkedHashMap linkedHashMap3 = this.this$0.goodsListMap;
        Intrinsics.checkNotNull(linkedHashMap3);
        Collection<FunThings> values = linkedHashMap3.values();
        Intrinsics.checkNotNullExpressionValue(values, "goodsListMap!!.values");
        int i = 0;
        for (FunThings funThings : values) {
            Intrinsics.checkNotNullExpressionValue(funThings, "any");
            sb.append(funThings.getId());
            LinkedHashMap linkedHashMap4 = this.this$0.goodsListMap;
            Intrinsics.checkNotNull(linkedHashMap4);
            if (i >= linkedHashMap4.values().size() - 1) {
                break;
            }
            sb.append(",");
            i++;
        }
        LinkedHashMap linkedHashMap5 = this.this$0.cancelMap;
        Intrinsics.checkNotNull(linkedHashMap5);
        Collection<FunThings> values2 = linkedHashMap5.values();
        Intrinsics.checkNotNullExpressionValue(values2, "cancelMap!!.values");
        int i2 = 0;
        for (FunThings funThings2 : values2) {
            Intrinsics.checkNotNullExpressionValue(funThings2, "any");
            sb2.append(funThings2.getId());
            LinkedHashMap linkedHashMap6 = this.this$0.cancelMap;
            Intrinsics.checkNotNull(linkedHashMap6);
            if (i2 >= linkedHashMap6.values().size() - 1) {
                break;
            }
            sb2.append(",");
            i2++;
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "addBuilder.toString()");
        if (sb3.length() > 0) {
            DataManager.getInstance().addGoodsOrNote(sb.toString(), this.this$0.feedId, "", false).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                /* class com.coolapk.market.view.goodsList.GoodsListSelectActivity$clickDone$1.AnonymousClass1 */
                final /* synthetic */ GoodsListSelectActivity$clickDone$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(String str) {
                    Toast.show$default(this.this$0.this$0.getActivity(), "添加成功", 0, false, 12, null);
                    GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).bottomSheet.dismissView();
                    ProgressBar progressBar = GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).loadingView;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
                    progressBar.setVisibility(8);
                    TextView textView = GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).actionDone;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
                    textView.setVisibility(0);
                }
            }, new Action1<Throwable>(this) {
                /* class com.coolapk.market.view.goodsList.GoodsListSelectActivity$clickDone$1.AnonymousClass2 */
                final /* synthetic */ GoodsListSelectActivity$clickDone$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(Throwable th) {
                    ProgressBar progressBar = GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).loadingView;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
                    progressBar.setVisibility(8);
                    TextView textView = GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).actionDone;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
                    textView.setVisibility(0);
                    Toast.error(this.this$0.this$0.getActivity(), th);
                }
            });
        }
        String sb4 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "cancelBuilder.toString()");
        if (sb4.length() > 0) {
            z = true;
        }
        if (z) {
            DataManager.getInstance().deleteGoods(sb2.toString(), this.this$0.feedId).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                /* class com.coolapk.market.view.goodsList.GoodsListSelectActivity$clickDone$1.AnonymousClass3 */
                final /* synthetic */ GoodsListSelectActivity$clickDone$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(String str) {
                    GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).bottomSheet.dismissView();
                    ProgressBar progressBar = GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).loadingView;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
                    progressBar.setVisibility(8);
                    TextView textView = GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).actionDone;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
                    textView.setVisibility(0);
                }
            }, new Action1<Throwable>(this) {
                /* class com.coolapk.market.view.goodsList.GoodsListSelectActivity$clickDone$1.AnonymousClass4 */
                final /* synthetic */ GoodsListSelectActivity$clickDone$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(Throwable th) {
                    ProgressBar progressBar = GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).loadingView;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
                    progressBar.setVisibility(8);
                    TextView textView = GoodsListSelectActivity.access$getBinding$p(this.this$0.this$0).actionDone;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
                    textView.setVisibility(0);
                    Toast.error(this.this$0.this$0.getActivity(), th);
                }
            });
        }
    }
}
