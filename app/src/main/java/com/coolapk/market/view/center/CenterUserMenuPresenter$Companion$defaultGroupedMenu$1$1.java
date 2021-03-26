package com.coolapk.market.view.center;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterUserMenuPresenter.kt */
final class CenterUserMenuPresenter$Companion$defaultGroupedMenu$1$1 extends Lambda implements Function1<List<String>, List<? extends String>> {
    public static final CenterUserMenuPresenter$Companion$defaultGroupedMenu$1$1 INSTANCE = new CenterUserMenuPresenter$Companion$defaultGroupedMenu$1$1();

    CenterUserMenuPresenter$Companion$defaultGroupedMenu$1$1() {
        super(1);
    }

    public final List<String> invoke(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (!CenterUserMenuPresenterKt.isAppType(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
