package com.coolapk.market.view.center;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.view.main.MainActivity;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterV9Fragment.kt */
final class CenterV9Fragment$onActivityCreated$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ CenterV9Fragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CenterV9Fragment$onActivityCreated$1(CenterV9Fragment centerV9Fragment) {
        super(1);
        this.this$0 = centerV9Fragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
        invoke(f.floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        if ((this.this$0.getActivity() instanceof MainActivity) && this.this$0.isVisible()) {
            FragmentActivity activity = this.this$0.getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.main.MainActivity");
            ((MainActivity) activity).setAppHeaderAlpha(f);
        }
    }
}
