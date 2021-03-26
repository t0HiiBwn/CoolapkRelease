package com.coolapk.market.view.center;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "Lcom/coolapk/market/view/center/UserMenu;", "it", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterUserMenuPresenter.kt */
final class CenterUserMenuPresenter$Companion$baseMenuMap$2 extends Lambda implements Function1<Map<String, ? extends UserMenu>, Map<String, ? extends UserMenu>> {
    public static final CenterUserMenuPresenter$Companion$baseMenuMap$2 INSTANCE = new CenterUserMenuPresenter$Companion$baseMenuMap$2();

    CenterUserMenuPresenter$Companion$baseMenuMap$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Map<String, ? extends UserMenu> invoke(Map<String, ? extends UserMenu> map) {
        return invoke((Map<String, UserMenu>) map);
    }

    public final Map<String, UserMenu> invoke(Map<String, UserMenu> map) {
        Intrinsics.checkNotNullParameter(map, "it");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, UserMenu> entry : map.entrySet()) {
            if (!CenterUserMenuPresenterKt.access$isAppType(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
