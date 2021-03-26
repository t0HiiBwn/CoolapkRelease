package com.coolapk.market.viewholder;

import com.coolapk.market.model.ServiceApp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ServiceAppExpandedViewHolder.kt */
final class ServiceAppExpandedViewHolder$bindTo$2 extends Lambda implements Function1<String, String> {
    final /* synthetic */ ServiceApp $serviceApp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceAppExpandedViewHolder$bindTo$2(ServiceApp serviceApp) {
        super(1);
        this.$serviceApp = serviceApp;
    }

    public final String invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        ServiceApp serviceApp = this.$serviceApp;
        List<String> screenList = serviceApp.getScreenList();
        String str2 = null;
        Integer valueOf = screenList != null ? Integer.valueOf(screenList.indexOf(str)) : null;
        if (valueOf == null) {
            return str;
        }
        int intValue = valueOf.intValue();
        List<String> thumbList = serviceApp.getThumbList();
        if (thumbList != null) {
            str2 = thumbList.get(intValue);
        }
        return str2 != null ? str2 : str;
    }
}
