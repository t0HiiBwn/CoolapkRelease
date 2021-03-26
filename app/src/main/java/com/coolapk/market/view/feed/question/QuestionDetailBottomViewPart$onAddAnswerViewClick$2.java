package com.coolapk.market.view.feed.question;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feed/question/QuestionDetailBottomViewPart$onAddAnswerViewClick$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onNext", "", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionDetailBottomViewPart.kt */
public final class QuestionDetailBottomViewPart$onAddAnswerViewClick$2 extends EmptySubscriber<Integer> {
    final /* synthetic */ QuestionDetailBottomViewPart this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    QuestionDetailBottomViewPart$onAddAnswerViewClick$2(QuestionDetailBottomViewPart questionDetailBottomViewPart) {
        this.this$0 = questionDetailBottomViewPart;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public /* bridge */ /* synthetic */ void onNext(Object obj) {
        onNext(((Number) obj).intValue());
    }

    public void onNext(int i) {
        super.onNext((QuestionDetailBottomViewPart$onAddAnswerViewClick$2) Integer.valueOf(i));
        if (i >= 1) {
            Activity activityNullable = UiUtils.getActivityNullable(this.this$0.getContext());
            if (activityNullable != null) {
                Activity activity = activityNullable;
                AlertDialog create = new AlertDialog.Builder(activity).setMessage("你已回答过此问题，重新回答会隐藏原有回答，是否继续？").setPositiveButton(2131886120, new QuestionDetailBottomViewPart$onAddAnswerViewClick$2$onNext$1(this)).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create();
                Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                WrapDialogFragmentKt.show(create, supportFragmentManager, null);
                return;
            }
            return;
        }
        this.this$0.enterAnswerActivity();
    }
}
