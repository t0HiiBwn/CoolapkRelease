package com.coolapk.market.view.search;

import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/String;"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchResultActivity.kt */
final class SuperSearchResultActivity$titles$2 extends Lambda implements Function0<String[]> {
    final /* synthetic */ SuperSearchResultActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuperSearchResultActivity$titles$2(SuperSearchResultActivity superSearchResultActivity) {
        super(0);
        this.this$0 = superSearchResultActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String[] invoke() {
        String appMode = AppHolder.getAppMetadata().getAppMode();
        if (appMode != null && appMode.hashCode() == -1480249367 && appMode.equals("community")) {
            String string = this.this$0.getString(2131887039);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_search_page_title_user)");
            String string2 = this.this$0.getString(2131887036);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_search_page_title_feed)");
            return new String[]{"综合", "数码", string, string2, "话题", "好物", "二手", "问答", "好物单", "看看号"};
        }
        String string3 = this.this$0.getString(2131887033);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.str_search_page_title_app)");
        String string4 = this.this$0.getString(2131887037);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.str_search_page_title_game)");
        String string5 = this.this$0.getString(2131887039);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.str_search_page_title_user)");
        String string6 = this.this$0.getString(2131887036);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.str_search_page_title_feed)");
        String string7 = this.this$0.getString(2131887032);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(R.string.str_search_page_title_album)");
        return new String[]{"综合", "数码", string3, string4, string5, string6, "话题", "好物", "二手", "问答", "好物单", "看看号", string7};
    }
}
