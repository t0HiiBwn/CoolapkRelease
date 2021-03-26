package com.coolapk.market.view.user.profile;

import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.KotlinExtendKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/HolderItem;", "kotlin.jvm.PlatformType", "array", "Lorg/json/JSONArray;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserCoverFragment.kt */
final class UserCoverFragment$onCreateRequest$1<T, R> implements Func1<JSONArray, List<? extends HolderItem>> {
    public static final UserCoverFragment$onCreateRequest$1 INSTANCE = new UserCoverFragment$onCreateRequest$1();

    UserCoverFragment$onCreateRequest$1() {
    }

    public final List<HolderItem> call(JSONArray jSONArray) {
        Intrinsics.checkNotNullExpressionValue(jSONArray, "array");
        List<JSONObject> jSONObjectList = KotlinExtendKt.toJSONObjectList(jSONArray);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jSONObjectList, 10));
        for (T t : jSONObjectList) {
            arrayList.add(HolderItem.newBuilder().entityType("holder_type_image").intValue(Integer.valueOf(t.optInt("isCustom"))).url(t.optString("url")).build());
        }
        return arrayList;
    }
}
