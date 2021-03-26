package com.coolapk.market.view.message;

import androidx.fragment.app.Fragment;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.GsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aZ\u0012&\b\u0001\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003 \u0005*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00020\u0002 \u0005*,\u0012&\b\u0001\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003 \u0005*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "res", "Lokhttp3/ResponseBody;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChattingActivity.kt */
final class ChattingActivity$setPhoto$3<T, R> implements Func1<ResponseBody, Observable<? extends Result<List<? extends Entity>>>> {
    final /* synthetic */ ChattingActivity this$0;

    ChattingActivity$setPhoto$3(ChattingActivity chattingActivity) {
        this.this$0 = chattingActivity;
    }

    public final Observable<? extends Result<List<Entity>>> call(ResponseBody responseBody) {
        int i;
        String str;
        JsonElement parse = new JsonParser().parse(responseBody.string());
        Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(res.string())");
        JsonObject asJsonObject = parse.getAsJsonObject();
        JsonElement jsonElement = asJsonObject.get("data");
        if (asJsonObject.has("status")) {
            JsonElement jsonElement2 = asJsonObject.get("status");
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject.get(\"status\")");
            i = jsonElement2.getAsInt();
        } else {
            i = 1;
        }
        if (asJsonObject.has("message")) {
            JsonElement jsonElement3 = asJsonObject.get("message");
            Intrinsics.checkNotNullExpressionValue(jsonElement3, "jsonObject.get(\"message\")");
            str = jsonElement3.getAsString();
        } else {
            str = null;
        }
        if (i < 0 && str != null) {
            return Observable.error(new ClientException(i, str));
        }
        Intrinsics.checkNotNullExpressionValue(jsonElement, "dataElement");
        if (jsonElement.isJsonArray()) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = (T) DataManager.getInstance().parseJsonToEntities(asJsonObject);
            this.this$0.getActivity().runOnUiThread(new Runnable(this) {
                /* class com.coolapk.market.view.message.ChattingActivity$setPhoto$3.AnonymousClass1 */
                final /* synthetic */ ChattingActivity$setPhoto$3 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Fragment findFragmentById = this.this$0.this$0.getSupportFragmentManager().findFragmentById(2131363592);
                    Objects.requireNonNull(findFragmentById, "null cannot be cast to non-null type com.coolapk.market.view.message.ChatListFragment");
                    ((ChatListFragment) findFragmentById).insertMessageList(objectRef.element);
                }
            });
            return Observable.empty();
        }
        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("data");
        return DataManager.getInstance().sendMessage(this.this$0.userId, "", GsonUtils.optString(asJsonObject2, "message_pic"), GsonUtils.optString(asJsonObject2, "message_extra"));
    }
}
