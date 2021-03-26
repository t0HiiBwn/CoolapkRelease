package com.coolapk.market.view.wallpaper;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: PictureCategoryDetailActivity.kt */
final class PictureCategoryDetailActivity$picTag$2 extends Lambda implements Function0<String> {
    final /* synthetic */ PictureCategoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PictureCategoryDetailActivity$picTag$2(PictureCategoryDetailActivity pictureCategoryDetailActivity) {
        super(0);
        this.this$0 = pictureCategoryDetailActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String stringExtra = this.this$0.getIntent().getStringExtra("tag");
        return stringExtra != null ? stringExtra : "";
    }
}
