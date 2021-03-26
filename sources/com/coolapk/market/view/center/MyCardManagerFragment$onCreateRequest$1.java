package com.coolapk.market.view.center;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.CardTitleItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "it", "Lokhttp3/ResponseBody;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: MyCardManagerFragment.kt */
final class MyCardManagerFragment$onCreateRequest$1<T, R> implements Func1<ResponseBody, Observable<? extends List<? extends Entity>>> {
    final /* synthetic */ MyCardManagerFragment this$0;

    MyCardManagerFragment$onCreateRequest$1(MyCardManagerFragment myCardManagerFragment) {
        this.this$0 = myCardManagerFragment;
    }

    public final Observable<? extends List<Entity>> call(ResponseBody responseBody) {
        JsonElement parse = new JsonParser().parse(responseBody.string());
        Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(it.string())");
        JsonObject asJsonObject = parse.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "JsonParser().parse(it.string()).asJsonObject");
        JsonElement jsonElement = asJsonObject.get("data");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (jsonElement != null) {
            Iterator<JsonElement> it2 = jsonElement.getAsJsonArray().iterator();
            while (it2.hasNext()) {
                JsonElement next = it2.next();
                Intrinsics.checkNotNullExpressionValue(next, "ele");
                JsonObject asJsonObject2 = next.getAsJsonObject();
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                CardTitleItem cardTitleItem = (CardTitleItem) instance.getGson().fromJson((JsonElement) asJsonObject2, (Class<Object>) CardTitleItem.class);
                if (cardTitleItem != null) {
                    if (cardTitleItem.isAdded()) {
                        arrayList.add(cardTitleItem);
                        ArrayList arrayList3 = this.this$0.visibleIdList;
                        String id = cardTitleItem.getId();
                        Intrinsics.checkNotNull(id);
                        arrayList3.add(id);
                    } else {
                        arrayList2.add(cardTitleItem);
                        ArrayList arrayList4 = this.this$0.invisibleIdList;
                        String id2 = cardTitleItem.getId();
                        Intrinsics.checkNotNull(id2);
                        arrayList4.add(id2);
                    }
                }
            }
        }
        this.this$0.list.clear();
        this.this$0.list.add(HolderItem.newBuilder().title("已添加").entityType("TYPE_TITLE_ADDED").build());
        this.this$0.list.addAll(arrayList);
        this.this$0.list.add(HolderItem.newBuilder().title("未添加").entityType("TYPE_TITLE_NOT_ADDED").build());
        this.this$0.list.addAll(arrayList2);
        return Observable.just(this.this$0.list);
    }
}
