package com.coolapk.market.view.center;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "it", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterUserMenuPresenter.kt */
final class CenterUserMenuPresenter$getActiveUserMenu$2 extends Lambda implements Function1<List<? extends String>, List<? extends String>> {
    public static final CenterUserMenuPresenter$getActiveUserMenu$2 INSTANCE = new CenterUserMenuPresenter$getActiveUserMenu$2();

    CenterUserMenuPresenter$getActiveUserMenu$2() {
        super(1);
    }

    public final List<String> invoke(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends String> invoke(List<? extends String> list) {
        return invoke((List<String>) list);
    }
}
