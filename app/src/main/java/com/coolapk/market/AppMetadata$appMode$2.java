package com.coolapk.market;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppMetadata.kt */
final class AppMetadata$appMode$2 extends Lambda implements Function0<String> {
    final /* synthetic */ AppMetadata this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppMetadata$appMode$2(AppMetadata appMetadata) {
        super(0);
        this.this$0 = appMetadata;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        if (!Intrinsics.areEqual(this.this$0.getAppModeFromMeta(), "universal")) {
            return this.this$0.getAppModeFromMeta();
        }
        String string = this.this$0.appContext.getSharedPreferences("coolapk_preferences_v7", 0).getString("app_mode", null);
        if (string != null) {
            return string;
        }
        return this.this$0.getAppModeFromMeta();
    }
}
