package com.coolapk.market.util;

import android.content.Context;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.ServiceApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007J\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0002R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/util/ExposureHelper;", "", "()V", "alreadyReportDataSet", "", "", "kotlin.jvm.PlatformType", "", "clearReportData", "", "report", "context", "Landroid/content/Context;", "entitySet", "Lcom/coolapk/market/model/Entity;", "shouldReport", "Ljava/util/HashMap;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ExposureHelper.kt */
public final class ExposureHelper {
    private final List<String> alreadyReportDataSet = Collections.synchronizedList(new ArrayList());

    private final HashMap<String, String> shouldReport(List<? extends Entity> list) {
        boolean z;
        List<Entity> entities;
        Sequence asSequence;
        Sequence<Entity> filter;
        List<String> list2 = this.alreadyReportDataSet;
        Intrinsics.checkNotNullExpressionValue(list2, "alreadyReportDataSet");
        List distinct = CollectionsKt.distinct(list2);
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<? extends Entity> it2 = list.iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            Entity entity = (Entity) it2.next();
            if (entity instanceof ServiceApp) {
                ServiceApp serviceApp = (ServiceApp) entity;
                String extraAnalysisData = serviceApp.getExtraAnalysisData();
                if (!(extraAnalysisData == null || extraAnalysisData.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    String entityUniqueId = EntityExtendsKt.entityUniqueId(entity);
                    if (!distinct.contains(entityUniqueId)) {
                        sb.append(serviceApp.getAppName());
                        sb.append(", ");
                        String extraAnalysisData2 = serviceApp.getExtraAnalysisData();
                        Intrinsics.checkNotNull(extraAnalysisData2);
                        hashMap.put(entityUniqueId, extraAnalysisData2);
                    }
                }
            }
            if (!(!(entity instanceof EntityCard) || (entities = ((EntityCard) entity).getEntities()) == null || (asSequence = CollectionsKt.asSequence(entities)) == null || (filter = SequencesKt.filter(asSequence, new ExposureHelper$shouldReport$1(distinct))) == null)) {
                for (Entity entity2 : filter) {
                    Objects.requireNonNull(entity2, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                    ServiceApp serviceApp2 = (ServiceApp) entity2;
                    sb.append(serviceApp2.getAppName());
                    sb.append(", ");
                    String entityUniqueId2 = EntityExtendsKt.entityUniqueId(serviceApp2);
                    String extraAnalysisData3 = serviceApp2.getExtraAnalysisData();
                    Intrinsics.checkNotNull(extraAnalysisData3);
                    hashMap.put(entityUniqueId2, extraAnalysisData3);
                }
            }
        }
        if (sb.length() <= 0) {
            z = false;
        }
        if (z) {
            LogUtils.v("需要上报曝光的有: {" + sb.substring(0, sb.length() - 2) + '}', new Object[0]);
        } else {
            LogUtils.v("没有需要上报曝光的", new Object[0]);
        }
        return hashMap;
    }

    public final void report(Context context, List<? extends Entity> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "entitySet");
        LogUtils.v("上报前，已经上报的数据有" + this.alreadyReportDataSet.size() + (char) 26465, new Object[0]);
        HashMap<String, String> shouldReport = shouldReport(list);
        if (!shouldReport.isEmpty()) {
            ActionManager.reportExposure(context, new ArrayList(shouldReport.values()));
            List<String> list2 = this.alreadyReportDataSet;
            Set<String> keySet = shouldReport.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "dataSet.keys");
            list2.addAll(keySet);
            LogUtils.v("上报后，已经上报的数据有" + this.alreadyReportDataSet.size() + (char) 26465, new Object[0]);
        }
    }

    public final void clearReportData() {
        LogUtils.v("清空已上报数据", new Object[0]);
        this.alreadyReportDataSet.clear();
    }
}
