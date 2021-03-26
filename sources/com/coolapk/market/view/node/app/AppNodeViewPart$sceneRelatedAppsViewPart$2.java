package com.coolapk.market.view.node.app;

import com.coolapk.market.view.main.SceneRelatedAppsViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeViewPart.kt */
final class AppNodeViewPart$sceneRelatedAppsViewPart$2 extends Lambda implements Function0<SceneRelatedAppsViewPart> {
    final /* synthetic */ AppNodeViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeViewPart$sceneRelatedAppsViewPart$2(AppNodeViewPart appNodeViewPart) {
        super(0);
        this.this$0 = appNodeViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SceneRelatedAppsViewPart invoke() {
        return new SceneRelatedAppsViewPart(this.this$0.component, true);
    }
}
