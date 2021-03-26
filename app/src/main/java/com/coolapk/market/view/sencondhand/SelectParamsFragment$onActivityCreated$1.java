package com.coolapk.market.view.sencondhand;

import com.coolapk.market.model.DeviceParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "item", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SelectParamsFragment.kt */
final class SelectParamsFragment$onActivityCreated$1 extends Lambda implements Function1<Object, Boolean> {
    public static final SelectParamsFragment$onActivityCreated$1 INSTANCE = new SelectParamsFragment$onActivityCreated$1();

    SelectParamsFragment$onActivityCreated$1() {
        super(1);
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, java.lang.Boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        return obj instanceof DeviceParams;
    }
}
