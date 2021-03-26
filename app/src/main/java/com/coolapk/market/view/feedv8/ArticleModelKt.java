package com.coolapk.market.view.feedv8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"toJson", "", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "includeExtra", "", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ArticleModel.kt */
public final class ArticleModelKt {
    public static /* synthetic */ String toJson$default(List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toJson(list, z);
    }

    public static final String toJson(List<? extends ArticleModel> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "$this$toJson");
        try {
            JSONArray jSONArray = new JSONArray();
            if (!z) {
                ArrayList arrayList = new ArrayList();
                for (T t : list) {
                    if (!(t instanceof ArticleNative)) {
                        arrayList.add(t);
                    }
                }
                list = arrayList;
            }
            List<? extends ArticleModel> list2 = list;
            ArrayList<JSONObject> arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().toJSONObject());
            }
            for (JSONObject jSONObject : arrayList2) {
                jSONArray.put(jSONObject);
            }
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
            return jSONArray2;
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
