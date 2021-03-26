package com.coolapk.market.util;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ExposureHelper.kt */
final class ExposureHelper$shouldReport$1 extends Lambda implements Function1<Entity, Boolean> {
    final /* synthetic */ List $alreadyReportDataSet;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposureHelper$shouldReport$1(List list) {
        super(1);
        this.$alreadyReportDataSet = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Entity entity) {
        return Boolean.valueOf(invoke(entity));
    }

    public final boolean invoke(Entity entity) {
        if (entity instanceof ServiceApp) {
            String extraAnalysisData = ((ServiceApp) entity).getExtraAnalysisData();
            if (!(extraAnalysisData == null || extraAnalysisData.length() == 0) && !this.$alreadyReportDataSet.contains(EntityExtendsKt.entityUniqueId(entity))) {
                return true;
            }
        }
        return false;
    }
}
