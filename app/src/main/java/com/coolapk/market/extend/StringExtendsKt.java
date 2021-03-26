package com.coolapk.market.extend;

import android.graphics.Color;
import com.coolapk.market.model.ProductParams;
import com.coolapk.market.util.GsonUtils;
import com.github.salomonbrys.kotson.ElementKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0002¨\u0006\u0007"}, d2 = {"colorInt", "", "", "parseSecondHandParams", "", "Lcom/coolapk/market/model/ProductParams;", "parseSecondHandShowParams", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: StringExtends.kt */
public final class StringExtendsKt {
    public static final int colorInt(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$colorInt");
        return Color.parseColor(str);
    }

    public static final List<ProductParams> parseSecondHandParams(String str) {
        JsonObject jsonObject;
        JsonObject jsonObject2;
        JsonObject jsonObject3;
        JsonObject jsonObject4;
        JsonObject jsonObject5;
        Intrinsics.checkNotNullParameter(str, "$this$parseSecondHandParams");
        ArrayList arrayList = new ArrayList();
        StringExtendsKt$parseSecondHandParams$1 stringExtendsKt$parseSecondHandParams$1 = StringExtendsKt$parseSecondHandParams$1.INSTANCE;
        StringExtendsKt$parseSecondHandParams$2 stringExtendsKt$parseSecondHandParams$2 = StringExtendsKt$parseSecondHandParams$2.INSTANCE;
        StringExtendsKt$parseSecondHandParams$3 stringExtendsKt$parseSecondHandParams$3 = StringExtendsKt$parseSecondHandParams$3.INSTANCE;
        if (str.length() == 0) {
            return arrayList;
        }
        JsonElement parseString = JsonParser.parseString(str);
        try {
            Intrinsics.checkNotNullExpressionValue(parseString, "jsonObject");
            jsonObject = ElementKt.get(parseString, "color").getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject[\"color\"].asJsonObject");
        } catch (Exception unused) {
            jsonObject = new JsonObject();
        }
        try {
            Intrinsics.checkNotNullExpressionValue(parseString, "jsonObject");
            jsonObject2 = ElementKt.get(parseString, "ram").getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(jsonObject2, "jsonObject[\"ram\"].asJsonObject");
        } catch (Exception unused2) {
            jsonObject2 = new JsonObject();
        }
        try {
            Intrinsics.checkNotNullExpressionValue(parseString, "jsonObject");
            jsonObject3 = ElementKt.get(parseString, "rom").getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(jsonObject3, "jsonObject[\"rom\"].asJsonObject");
        } catch (Exception unused3) {
            jsonObject3 = new JsonObject();
        }
        try {
            Intrinsics.checkNotNullExpressionValue(parseString, "jsonObject");
            jsonObject4 = ElementKt.get(parseString, "purity").getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(jsonObject4, "jsonObject[\"purity\"].asJsonObject");
        } catch (Exception unused4) {
            jsonObject4 = new JsonObject();
        }
        try {
            Intrinsics.checkNotNullExpressionValue(parseString, "jsonObject");
            jsonObject5 = ElementKt.get(parseString, "extra").getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(jsonObject5, "jsonObject[\"extra\"].asJsonObject");
        } catch (Exception unused5) {
            jsonObject5 = new JsonObject();
        }
        String invoke = stringExtendsKt$parseSecondHandParams$1.invoke(jsonObject, "value");
        String str2 = "extra";
        String invoke2 = stringExtendsKt$parseSecondHandParams$1.invoke(jsonObject2, "value");
        String invoke3 = stringExtendsKt$parseSecondHandParams$1.invoke(jsonObject3, "value");
        String invoke4 = stringExtendsKt$parseSecondHandParams$1.invoke(jsonObject4, "value");
        List<String> invoke5 = stringExtendsKt$parseSecondHandParams$3.invoke(jsonObject5, "value");
        int invoke6 = stringExtendsKt$parseSecondHandParams$2.invoke(jsonObject, "other");
        int invoke7 = stringExtendsKt$parseSecondHandParams$2.invoke(jsonObject2, "other");
        int invoke8 = stringExtendsKt$parseSecondHandParams$2.invoke(jsonObject3, "other");
        int invoke9 = stringExtendsKt$parseSecondHandParams$2.invoke(jsonObject4, "other");
        ProductParams build = ProductParams.builder().setTitle(invoke).setKey("color").setItemState(1).setItemType(invoke6).setCheckBoxState(invoke.length() > 0 ? 1 : 0).setKeyIndex(0).build();
        Intrinsics.checkNotNullExpressionValue(build, "ProductParams.builder()\n…x(0)\n            .build()");
        arrayList.add(build);
        ProductParams build2 = ProductParams.builder().setTitle(invoke2).setKey("ram").setItemState(1).setItemType(invoke7).setCheckBoxState(invoke2.length() > 0 ? 1 : 0).setKeyIndex(1).build();
        Intrinsics.checkNotNullExpressionValue(build2, "ProductParams.builder()\n…x(1)\n            .build()");
        arrayList.add(build2);
        ProductParams build3 = ProductParams.builder().setTitle(invoke3).setKey("rom").setItemState(1).setItemType(invoke8).setCheckBoxState(invoke3.length() > 0 ? 1 : 0).setKeyIndex(2).build();
        Intrinsics.checkNotNullExpressionValue(build3, "ProductParams.builder()\n…x(2)\n            .build()");
        arrayList.add(build3);
        ProductParams build4 = ProductParams.builder().setTitle(invoke4).setKey("purity").setItemState(1).setItemType(invoke9).setCheckBoxState(invoke4.length() > 0 ? 1 : 0).setKeyIndex(3).build();
        Intrinsics.checkNotNullExpressionValue(build4, "ProductParams.builder()\n…x(3)\n            .build()");
        arrayList.add(build4);
        for (T t : invoke5) {
            ProductParams build5 = ProductParams.builder().setTitle(t).setKey(str2).setItemState(1).setItemType(0).setCheckBoxState(t.length() > 0 ? 1 : 0).setKeyIndex(4).build();
            Intrinsics.checkNotNullExpressionValue(build5, "ProductParams.builder()\n…\n                .build()");
            arrayList.add(build5);
            str2 = str2;
        }
        return arrayList;
    }

    public static final String parseSecondHandShowParams(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$parseSecondHandShowParams");
        if (str.length() == 0) {
            return "";
        }
        JsonElement parseString = JsonParser.parseString(str);
        Intrinsics.checkNotNullExpressionValue(parseString, "JsonParser.parseString(this)");
        JsonObject asJsonObject = parseString.getAsJsonObject();
        String optString = GsonUtils.optString(asJsonObject, "color");
        String optString2 = GsonUtils.optString(asJsonObject, "ram");
        String optString3 = GsonUtils.optString(asJsonObject, "rom");
        String optString4 = GsonUtils.optString(asJsonObject, "area");
        String optString5 = GsonUtils.optString(asJsonObject, "purity");
        StringBuilder sb = new StringBuilder();
        if (optString != null) {
            sb.append((String) StringsKt.split$default((CharSequence) optString, new String[]{"："}, false, 0, 6, (Object) null).get(1));
            sb.append("·");
        }
        if (optString2 != null) {
            sb.append((String) StringsKt.split$default((CharSequence) optString2, new String[]{"："}, false, 0, 6, (Object) null).get(1));
            sb.append("·");
        }
        if (optString3 != null) {
            sb.append((String) StringsKt.split$default((CharSequence) optString3, new String[]{"："}, false, 0, 6, (Object) null).get(1));
            sb.append("·");
        }
        if (optString4 != null) {
            sb.append((String) StringsKt.split$default((CharSequence) optString4, new String[]{"："}, false, 0, 6, (Object) null).get(1));
            sb.append("·");
        }
        if (optString5 != null) {
            sb.append((String) StringsKt.split$default((CharSequence) optString5, new String[]{"："}, false, 0, 6, (Object) null).get(1));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
