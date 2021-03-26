package com.coolapk.market.view.message;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aZ\u0012&\b\u0001\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003 \u0005*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00020\u0002 \u0005*,\u0012&\b\u0001\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003 \u0005*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "it", "Lokhttp3/ResponseBody;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChattingActivity.kt */
final class ChattingActivity$setPhoto$4<T, R> implements Func1<ResponseBody, Observable<? extends Result<List<? extends Entity>>>> {
    public static final ChattingActivity$setPhoto$4 INSTANCE = new ChattingActivity$setPhoto$4();

    ChattingActivity$setPhoto$4() {
    }

    public final Observable<? extends Result<List<Entity>>> call(ResponseBody responseBody) {
        int i;
        String str;
        JsonElement parseString = JsonParser.parseString(responseBody.string());
        Intrinsics.checkNotNullExpressionValue(parseString, "JsonParser.parseString(it.string())");
        JsonObject asJsonObject = parseString.getAsJsonObject();
        if (asJsonObject.has("status")) {
            JsonElement jsonElement = asJsonObject.get("status");
            Intrinsics.checkNotNullExpressionValue(jsonElement, "jsonObject.get(\"status\")");
            i = jsonElement.getAsInt();
        } else {
            i = 1;
        }
        if (asJsonObject.has("message")) {
            JsonElement jsonElement2 = asJsonObject.get("message");
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject.get(\"message\")");
            str = jsonElement2.getAsString();
        } else {
            str = null;
        }
        if (i < 0) {
            return Observable.error(new ClientException(i, str));
        }
        return Observable.empty();
    }
}
