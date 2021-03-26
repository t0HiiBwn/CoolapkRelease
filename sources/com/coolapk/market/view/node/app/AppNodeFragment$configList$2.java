package com.coolapk.market.view.node.app;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.extend.EntityExtendsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$configList$2 extends Lambda implements Function0<List<? extends Pair<? extends String, ? extends String>>> {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$configList$2(AppNodeFragment appNodeFragment) {
        super(0);
        this.this$0 = appNodeFragment;
    }

    /* Return type fixed from 'java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends Pair<? extends String, ? extends String>> invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        String stringExtra = requireActivity.getIntent().getStringExtra("CLIENT_CONFIG");
        if (stringExtra == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "it");
        return EntityExtendsKt.parseUrlClientConfigToList(stringExtra);
    }
}
