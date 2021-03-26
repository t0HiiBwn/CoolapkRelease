package com.coolapk.market.view.feedv8.draft;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/coolapk/market/view/feedv8/draft/RoughDraft;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RoughDraftHelper.kt */
final class RoughDraftHelper$roughDraftList$2 extends Lambda implements Function0<ArrayList<RoughDraft>> {
    final /* synthetic */ RoughDraftHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoughDraftHelper$roughDraftList$2(RoughDraftHelper roughDraftHelper) {
        super(0);
        this.this$0 = roughDraftHelper;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ArrayList<RoughDraft> invoke() {
        try {
            return this.this$0.jsonToList(this.this$0.loadJsonFromDisk());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
