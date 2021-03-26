package com.coolapk.market.view.center;

import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityConvertUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "it", "Lokhttp3/ResponseBody;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterUserMenuPresenter.kt */
final class CenterUserMenuPresenter$loadMenuDataInServe$1<T, R> implements Func1<ResponseBody, Result<String>> {
    public static final CenterUserMenuPresenter$loadMenuDataInServe$1 INSTANCE = new CenterUserMenuPresenter$loadMenuDataInServe$1();

    CenterUserMenuPresenter$loadMenuDataInServe$1() {
    }

    public final Result<String> call(ResponseBody responseBody) {
        JsonObject asJsonObject;
        JsonElement jsonElement;
        JsonElement parse = new JsonParser().parse(responseBody.string());
        Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(jsonString)");
        JsonObject asJsonObject2 = parse.getAsJsonObject();
        StringBuilder sb = new StringBuilder();
        if (asJsonObject2.has("data")) {
            JsonElement jsonElement2 = asJsonObject2.get("data");
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject.get(\"data\")");
            if (jsonElement2.isJsonObject()) {
                JsonElement jsonElement3 = asJsonObject2.get("data");
                String asString = (jsonElement3 == null || (asJsonObject = jsonElement3.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("my_setting_tab_config")) == null) ? null : jsonElement.getAsString();
                if (asString != null) {
                    if (asString.length() > 0) {
                        try {
                            JSONArray jSONArray = new JSONArray(asString);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                sb.append(jSONArray.optString(i));
                                sb.append(",");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        Result<String> wrapAsResult = EntityConvertUtils.wrapAsResult(asJsonObject2, sb.toString());
        Intrinsics.checkNotNullExpressionValue(wrapAsResult, "result");
        if (wrapAsResult.isSuccess()) {
            return wrapAsResult;
        }
        ClientException checkResult = wrapAsResult.checkResult();
        Intrinsics.checkNotNullExpressionValue(checkResult, "result.checkResult()");
        throw checkResult;
    }
}
