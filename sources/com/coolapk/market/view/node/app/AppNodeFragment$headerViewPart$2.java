package com.coolapk.market.view.node.app;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppMetadataKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/node/app/BaseAppNodeViewPart;", "Landroidx/databinding/ViewDataBinding;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$headerViewPart$2 extends Lambda implements Function0<BaseAppNodeViewPart<? extends ViewDataBinding>> {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$headerViewPart$2(AppNodeFragment appNodeFragment) {
        super(0);
        this.this$0 = appNodeFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final BaseAppNodeViewPart<? extends ViewDataBinding> invoke() {
        return (BaseAppNodeViewPart) AppMetadataKt.runOnAppMode$default(this.this$0, null, new Function1<AppNodeFragment, BaseAppNodeViewPart<? extends ViewDataBinding>>(this) {
            /* class com.coolapk.market.view.node.app.AppNodeFragment$headerViewPart$2.AnonymousClass1 */
            final /* synthetic */ AppNodeFragment$headerViewPart$2 this$0;

            {
                this.this$0 = r1;
            }

            public final BaseAppNodeViewPart<? extends ViewDataBinding> invoke(AppNodeFragment appNodeFragment) {
                Intrinsics.checkNotNullParameter(appNodeFragment, "it");
                FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return new AppNodeCommunityViewPart(requireActivity, this.this$0.this$0.getViewModel(), this.this$0.this$0.getPresenter());
            }
        }, null, new Function1<AppNodeFragment, BaseAppNodeViewPart<? extends ViewDataBinding>>(this) {
            /* class com.coolapk.market.view.node.app.AppNodeFragment$headerViewPart$2.AnonymousClass2 */
            final /* synthetic */ AppNodeFragment$headerViewPart$2 this$0;

            {
                this.this$0 = r1;
            }

            public final BaseAppNodeViewPart<? extends ViewDataBinding> invoke(AppNodeFragment appNodeFragment) {
                Intrinsics.checkNotNullParameter(appNodeFragment, "it");
                FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return new AppNodeViewPart(requireActivity, this.this$0.this$0.getViewModel(), this.this$0.this$0.getPresenter());
            }
        }, 5, null);
    }
}
