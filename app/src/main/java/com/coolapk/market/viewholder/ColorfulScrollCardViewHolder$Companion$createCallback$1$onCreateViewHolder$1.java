package com.coolapk.market.viewholder;

import com.coolapk.market.model.EntityCard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/EntityCard;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ColorfulScrollCardViewHolder.kt */
final class ColorfulScrollCardViewHolder$Companion$createCallback$1$onCreateViewHolder$1 extends Lambda implements Function0<EntityCard> {
    final /* synthetic */ ColorfulScrollCardViewHolder$Companion$createCallback$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ColorfulScrollCardViewHolder$Companion$createCallback$1$onCreateViewHolder$1(ColorfulScrollCardViewHolder$Companion$createCallback$1 colorfulScrollCardViewHolder$Companion$createCallback$1) {
        super(0);
        this.this$0 = colorfulScrollCardViewHolder$Companion$createCallback$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EntityCard invoke() {
        return this.this$0.getCard();
    }
}
