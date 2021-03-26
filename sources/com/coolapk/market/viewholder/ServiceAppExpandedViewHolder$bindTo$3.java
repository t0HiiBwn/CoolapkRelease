package com.coolapk.market.viewholder;

import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/viewholder/v8/image/ImageArgs;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ServiceAppExpandedViewHolder.kt */
final class ServiceAppExpandedViewHolder$bindTo$3 extends Lambda implements Function1<ImageArgs, String> {
    final /* synthetic */ ServiceApp $serviceApp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceAppExpandedViewHolder$bindTo$3(ServiceApp serviceApp) {
        super(1);
        this.$serviceApp = serviceApp;
    }

    public final String invoke(ImageArgs imageArgs) {
        Intrinsics.checkNotNullParameter(imageArgs, "it");
        String inSource = imageArgs.getInSource();
        ServiceApp serviceApp = this.$serviceApp;
        List<String> screenList = serviceApp.getScreenList();
        String str = null;
        Integer valueOf = screenList != null ? Integer.valueOf(screenList.indexOf(inSource)) : null;
        if (valueOf == null) {
            return inSource;
        }
        int intValue = valueOf.intValue();
        List<String> thumbList = serviceApp.getThumbList();
        if (thumbList != null) {
            str = thumbList.get(intValue);
        }
        return str != null ? str : inSource;
    }
}
