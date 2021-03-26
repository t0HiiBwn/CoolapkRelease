package com.coolapk.market.view.node.prodcut;

import android.graphics.drawable.ColorDrawable;
import com.coolapk.market.view.node.util.NodeExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "endColor", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductNodeFragment.kt */
final class ProductNodeFragment$installTopicContent$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ ProductNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductNodeFragment$installTopicContent$1(ProductNodeFragment productNodeFragment) {
        super(2);
        this.this$0 = productNodeFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        this.this$0.getBehavior().setAppBarBackground(NodeExtendsKt.nodeDarkForegroundIfNeed(new ColorDrawable(i2)));
    }
}
