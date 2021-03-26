package com.coolapk.market.view.sencondhand;

import com.coolapk.market.view.base.AlphaToolbarActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SelectParamsActivity;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "()V", "onCreateFragment", "Lcom/coolapk/market/view/sencondhand/SelectParamsFragment;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SelectParamsActivity.kt */
public final class SelectParamsActivity extends AlphaToolbarActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ERSHOU_DEAL_TYPE = "KEY_ERSHOU_DEAL_TYPE";
    public static final String KEY_ERSHOU_PARAMS = "KEY_ERSHOU_PARAMS";
    public static final String KEY_ERSHOU_TYPE_ID = "KEY_ERSHOU_TYPE_ID";
    public static final String KEY_PRODUCT_ID = "KEY_PRODUCT_ID";
    public static final int REQUESTCODE = 5555;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SelectParamsActivity$Companion;", "", "()V", "KEY_ERSHOU_DEAL_TYPE", "", "KEY_ERSHOU_PARAMS", "KEY_ERSHOU_TYPE_ID", "KEY_PRODUCT_ID", "REQUESTCODE", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SelectParamsActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public SelectParamsFragment onCreateFragment() {
        setTitle("参数选择");
        String stringExtra = getIntent().getStringExtra("KEY_PRODUCT_ID");
        Intrinsics.checkNotNull(stringExtra);
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_PRODUCT_ID)!!");
        String stringExtra2 = getIntent().getStringExtra("KEY_ERSHOU_TYPE_ID");
        Intrinsics.checkNotNull(stringExtra2);
        Intrinsics.checkNotNullExpressionValue(stringExtra2, "intent.getStringExtra(KEY_ERSHOU_TYPE_ID)!!");
        String stringExtra3 = getIntent().getStringExtra("KEY_ERSHOU_DEAL_TYPE");
        Intrinsics.checkNotNull(stringExtra3);
        Intrinsics.checkNotNullExpressionValue(stringExtra3, "intent.getStringExtra(KEY_ERSHOU_DEAL_TYPE)!!");
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("KEY_ERSHOU_PARAMS");
        if (stringArrayListExtra == null) {
            return SelectParamsFragment.Companion.newInstance(stringExtra, stringExtra2, stringExtra3);
        }
        Intrinsics.checkNotNullExpressionValue(stringArrayListExtra, "intent.getStringArrayLis…ouTypeId, ershouDealType)");
        return SelectParamsFragment.Companion.newInstance(stringExtra, stringExtra2, stringArrayListExtra, stringExtra3);
    }
}
