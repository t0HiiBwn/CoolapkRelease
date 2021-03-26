package com.coolapk.market.view.block;

import com.google.gson.JsonElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "key", "", "element", "Lcom/google/gson/JsonElement;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlockContentManager.kt */
final class BlockContentManager$parseLoadedJsonString$2 extends Lambda implements Function2<String, JsonElement, Unit> {
    public static final BlockContentManager$parseLoadedJsonString$2 INSTANCE = new BlockContentManager$parseLoadedJsonString$2();

    BlockContentManager$parseLoadedJsonString$2() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, JsonElement jsonElement) {
        invoke(str, jsonElement);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        String asString = jsonElement.getAsString();
        BlockContentManager blockContentManager = BlockContentManager.INSTANCE;
        List list = BlockContentManager.loadedBlockItems;
        Intrinsics.checkNotNullExpressionValue(asString, "title");
        list.add(new BlockItem(null, asString, asString, null, false, null, "word", 57, null));
    }
}
