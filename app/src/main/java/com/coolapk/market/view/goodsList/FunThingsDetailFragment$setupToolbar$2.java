package com.coolapk.market.view.goodsList;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.view.base.AlphableToolbar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FunThingsDetailFragment.kt */
final class FunThingsDetailFragment$setupToolbar$2 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ FunThingsDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunThingsDetailFragment$setupToolbar$2(FunThingsDetailFragment funThingsDetailFragment, FragmentActivity fragmentActivity) {
        super(1);
        this.this$0 = funThingsDetailFragment;
        this.$activity = fragmentActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
        invoke(f.floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        AlphableToolbar alphableToolbar = (AlphableToolbar) this.$activity;
        if (TextUtils.isEmpty(FunThingsDetailFragment.access$getCollection$p(this.this$0).getCoverPic())) {
            f = 1.0f;
        }
        alphableToolbar.setToolbarAlpha(f);
    }
}
