package com.coolapk.market.view.block;

import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityConvertUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "it", "Lokhttp3/ResponseBody;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlockContentManager.kt */
final class BlockContentManager$reloadBlockDataObservable$1<T, R> implements Func1<ResponseBody, Result<String>> {
    public static final BlockContentManager$reloadBlockDataObservable$1 INSTANCE = new BlockContentManager$reloadBlockDataObservable$1();

    BlockContentManager$reloadBlockDataObservable$1() {
    }

    public final Result<String> call(ResponseBody responseBody) {
        JsonElement parseString = JsonParser.parseString(responseBody.string());
        Intrinsics.checkNotNullExpressionValue(parseString, "JsonParser.parseString(it.string())");
        JsonObject asJsonObject = parseString.getAsJsonObject();
        Result<String> wrapAsResult = EntityConvertUtils.wrapAsResult(asJsonObject, "");
        Intrinsics.checkNotNullExpressionValue(wrapAsResult, "result");
        if (wrapAsResult.isSuccess()) {
            BlockContentManager blockContentManager = BlockContentManager.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
            blockContentManager.parseLoadedJsonString(asJsonObject);
            EventBus.getDefault().post(new BlockItemChangeEvent());
            return wrapAsResult;
        }
        ClientException checkResult = wrapAsResult.checkResult();
        Intrinsics.checkNotNullExpressionValue(checkResult, "result.checkResult()");
        throw checkResult;
    }
}
