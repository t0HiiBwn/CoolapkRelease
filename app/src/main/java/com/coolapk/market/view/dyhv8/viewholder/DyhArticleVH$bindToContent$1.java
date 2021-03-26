package com.coolapk.market.view.dyhv8.viewholder;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.dyhv8.DyhArticleAction;
import com.coolapk.market.view.dyhv8.DyhDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhArticleVH.kt */
final class DyhArticleVH$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ DyhArticleVH this$0;

    DyhArticleVH$bindToContent$1(DyhArticleVH dyhArticleVH) {
        this.this$0 = dyhArticleVH;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        DyhArticle dyhArticle;
        Intrinsics.checkNotNullExpressionValue(view, "v");
        if (view.getId() != 2131363260) {
            return false;
        }
        Activity activity = UiUtils.getActivity(this.this$0.getContext());
        if (activity instanceof DyhDetailActivity) {
            dyhArticle = DyhArticle.newBuilder(DyhArticleVH.access$getMDyhArticle$p(this.this$0)).dyhModel(((DyhDetailActivity) activity).getDyhModel()).build();
        } else {
            dyhArticle = DyhArticleVH.access$getMDyhArticle$p(this.this$0);
        }
        DyhArticleAction newInstance = DyhArticleAction.Companion.newInstance(dyhArticle);
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        return true;
    }
}
