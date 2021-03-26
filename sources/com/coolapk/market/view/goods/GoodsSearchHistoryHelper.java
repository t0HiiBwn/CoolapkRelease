package com.coolapk.market.view.goods;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.PreferencesUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\b\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsSearchHistoryHelper;", "", "()V", "KEY_GOODS_SEARCH_WORDS", "", "storeList", "", "addWords", "", "word", "clear", "getHistory", "", "initIfNecessary", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsSearchHistoryHelper.kt */
public final class GoodsSearchHistoryHelper {
    public static final GoodsSearchHistoryHelper INSTANCE = new GoodsSearchHistoryHelper();
    private static final String KEY_GOODS_SEARCH_WORDS = "goods_search_words";
    private static List<String> storeList;

    private GoodsSearchHistoryHelper() {
    }

    public static final /* synthetic */ List access$getStoreList$p(GoodsSearchHistoryHelper goodsSearchHistoryHelper) {
        List<String> list = storeList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeList");
        }
        return list;
    }

    public final List<String> getHistory() {
        initIfNecessary();
        List<String> list = storeList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeList");
        }
        return list;
    }

    public final void addWords(String str) {
        Intrinsics.checkNotNullParameter(str, "word");
        initIfNecessary();
        if (!StringsKt.isBlank(str)) {
            String trimIndent = StringsKt.trimIndent(str);
            List<String> list = storeList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storeList");
            }
            CollectionsKt.removeAll((List) list, (Function1) new GoodsSearchHistoryHelper$addWords$1$1(trimIndent));
            List<String> list2 = storeList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storeList");
            }
            list2.add(0, trimIndent);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            PreferencesUtils.EditorHelper preferencesEditor = instance.getPreferencesEditor();
            List<String> list3 = storeList;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storeList");
            }
            preferencesEditor.putString("goods_search_words", CollectionsKt.joinToString$default(list3, null, null, null, 0, null, null, 63, null)).apply();
        }
    }

    public final void clear() {
        initIfNecessary();
        List<String> list = storeList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeList");
        }
        list.clear();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("goods_search_words", "").apply();
    }

    private final void initIfNecessary() {
        if (storeList == null) {
            storeList = new ArrayList();
            String preferencesString = DataManager.getInstance().getPreferencesString("goods_search_words", "");
            Intrinsics.checkNotNullExpressionValue(preferencesString, "DataManager.getInstance(…Y_GOODS_SEARCH_WORDS, \"\")");
            List<String> split$default = StringsKt.split$default((CharSequence) StringsKt.trimIndent(preferencesString), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String str : split$default) {
                arrayList.add(StringsKt.trimIndent(str));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            List<String> list = storeList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storeList");
            }
            list.addAll(arrayList3);
        }
    }
}
