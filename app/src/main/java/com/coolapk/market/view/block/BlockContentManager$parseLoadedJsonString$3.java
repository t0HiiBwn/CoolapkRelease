package com.coolapk.market.view.block;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "key", "", "element", "Lcom/google/gson/JsonElement;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlockContentManager.kt */
final class BlockContentManager$parseLoadedJsonString$3 extends Lambda implements Function2<String, JsonElement, Unit> {
    public static final BlockContentManager$parseLoadedJsonString$3 INSTANCE = new BlockContentManager$parseLoadedJsonString$3();

    BlockContentManager$parseLoadedJsonString$3() {
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
        String str2;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        BlockContentManager blockContentManager = BlockContentManager.INSTANCE;
        List list = BlockContentManager.loadedBlockItems;
        JsonElement jsonElement2 = asJsonObject.get("uid");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "nodeObj.get(\"uid\")");
        String asString = jsonElement2.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "nodeObj.get(\"uid\").asString");
        JsonElement jsonElement3 = asJsonObject.get("name");
        String str3 = null;
        String asString2 = jsonElement3 != null ? jsonElement3.getAsString() : null;
        String str4 = asString2 != null ? asString2 : "";
        JsonElement jsonElement4 = asJsonObject.get("logo");
        if (jsonElement4 != null) {
            str3 = jsonElement4.getAsString();
        }
        if (str3 != null) {
            str2 = str3;
        } else {
            str2 = "";
        }
        list.add(new BlockItem(null, asString, str4, str2, true, null, "user", 33, null));
    }
}
