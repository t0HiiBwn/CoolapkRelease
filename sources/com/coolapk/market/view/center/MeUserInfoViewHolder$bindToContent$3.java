package com.coolapk.market.view.center;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.coolapk.market.databinding.ItemCenterUserInfoBinding;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.widget.ViewTouchAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/center/MeUserInfoViewHolder$bindToContent$3", "Lcom/coolapk/market/widget/ViewTouchAnimator;", "onPressDown", "", "v", "Landroid/view/View;", "onRaiseUp", "onTouch", "", "event", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MeUserInfoViewHolder.kt */
public final class MeUserInfoViewHolder$bindToContent$3 extends ViewTouchAnimator {
    final /* synthetic */ MeUserInfoViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MeUserInfoViewHolder$bindToContent$3(MeUserInfoViewHolder meUserInfoViewHolder) {
        this.this$0 = meUserInfoViewHolder;
    }

    @Override // com.coolapk.market.widget.ViewTouchAnimator, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            onPressDown(view);
        } else if (action == 1) {
            onRaiseUp(view);
        } else if (action == 2) {
            view.animate().scaleX(1.0f).setDuration(100).scaleY(1.0f).start();
        }
        return true;
    }

    @Override // com.coolapk.market.widget.ViewTouchAnimator
    public void onRaiseUp(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        view.animate().scaleX(1.0f).setDuration(100).scaleY(1.0f).start();
        ItemCenterUserInfoBinding itemCenterUserInfoBinding = (ItemCenterUserInfoBinding) this.this$0.getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCenterUserInfoBinding, "binding");
        UserProfile model = itemCenterUserInfoBinding.getModel();
        Intrinsics.checkNotNull(model);
        Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
        String levelDetailUrl = model.getLevelDetailUrl();
        if (!TextUtils.isEmpty(levelDetailUrl)) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            ActionManagerCompat.startActivityByUrl$default(context, levelDetailUrl, null, null, 12, null);
        }
    }

    @Override // com.coolapk.market.widget.ViewTouchAnimator
    public void onPressDown(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        view.animate().scaleX(1.1f).setDuration(100).scaleY(1.1f).start();
    }
}
