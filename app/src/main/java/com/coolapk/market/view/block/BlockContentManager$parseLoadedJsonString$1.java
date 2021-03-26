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
final class BlockContentManager$parseLoadedJsonString$1 extends Lambda implements Function2<String, JsonElement, Unit> {
    public static final BlockContentManager$parseLoadedJsonString$1 INSTANCE = new BlockContentManager$parseLoadedJsonString$1();

    BlockContentManager$parseLoadedJsonString$1() {
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
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        BlockContentManager blockContentManager = BlockContentManager.INSTANCE;
        List list = BlockContentManager.loadedBlockItems;
        JsonElement jsonElement2 = asJsonObject.get("targetFullId");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "nodeObj.get(\"targetFullId\")");
        String asString = jsonElement2.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "nodeObj.get(\"targetFullId\").asString");
        JsonElement jsonElement3 = asJsonObject.get("title");
        String str5 = null;
        String asString2 = jsonElement3 != null ? jsonElement3.getAsString() : null;
        if (asString2 == null) {
            asString2 = "";
        }
        JsonElement jsonElement4 = asJsonObject.get("title");
        String asString3 = jsonElement4 != null ? jsonElement4.getAsString() : null;
        if (asString3 != null) {
            str2 = asString3;
        } else {
            str2 = "";
        }
        JsonElement jsonElement5 = asJsonObject.get("logo");
        String asString4 = jsonElement5 != null ? jsonElement5.getAsString() : null;
        if (asString4 != null) {
            str3 = asString4;
        } else {
            str3 = "";
        }
        JsonElement jsonElement6 = asJsonObject.get("url");
        if (jsonElement6 != null) {
            str5 = jsonElement6.getAsString();
        }
        if (str5 != null) {
            str4 = str5;
        } else {
            str4 = "";
        }
        list.add(new BlockItem(asString, asString2, str2, str3, true, str4, "node"));
    }
}
