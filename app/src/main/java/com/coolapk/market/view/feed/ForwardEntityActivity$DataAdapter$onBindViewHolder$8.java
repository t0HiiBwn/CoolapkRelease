package com.coolapk.market.view.feed;

import android.app.Activity;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemForwardEntityShareAppBinding;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feed.ForwardEntityActivity;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ForwardEntityActivity.kt */
final class ForwardEntityActivity$DataAdapter$onBindViewHolder$8 implements View.OnClickListener {
    final /* synthetic */ ItemForwardEntityShareAppBinding $binding;
    final /* synthetic */ ForwardEntityActivity.DataAdapter this$0;

    ForwardEntityActivity$DataAdapter$onBindViewHolder$8(ForwardEntityActivity.DataAdapter dataAdapter, ItemForwardEntityShareAppBinding itemForwardEntityShareAppBinding) {
        this.this$0 = dataAdapter;
        this.$binding = itemForwardEntityShareAppBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj;
        ForwardEntityActivity.DataAdapter dataAdapter = this.this$0;
        TextView textView = this.$binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        dataAdapter.doUserClickStatistic(textView);
        Iterator it2 = this.this$0.shareApps.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual(((ResolveInfo) obj).activityInfo.packageName, "com.zhihu.android")) {
                break;
            }
        }
        ResolveInfo resolveInfo = (ResolveInfo) obj;
        if (resolveInfo != null) {
            this.this$0.shareTextTo(resolveInfo);
            Activity activityNullable = UiUtils.getActivityNullable(this.this$0.getContext());
            if (activityNullable != null) {
                activityNullable.finish();
            }
        }
    }
}
