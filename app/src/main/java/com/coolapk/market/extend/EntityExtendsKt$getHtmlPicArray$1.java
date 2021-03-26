package com.coolapk.market.extend;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "it", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityExtends.kt */
final class EntityExtendsKt$getHtmlPicArray$1 extends Lambda implements Function1<String, List<? extends String>> {
    public static final EntityExtendsKt$getHtmlPicArray$1 INSTANCE = new EntityExtendsKt$getHtmlPicArray$1();

    EntityExtendsKt$getHtmlPicArray$1() {
        super(1);
    }

    public final List<String> invoke(String str) {
        if (str == null) {
            str = "";
        }
        return StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
    }
}
