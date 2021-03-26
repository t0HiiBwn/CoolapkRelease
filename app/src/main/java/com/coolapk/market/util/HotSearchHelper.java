package com.coolapk.market.util;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.PreferencesUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/util/HotSearchHelper;", "", "()V", "getSearchHotEntities", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "key", "", "save", "", "jsonString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HotSearchHelper.kt */
public final class HotSearchHelper {
    public static final HotSearchHelper INSTANCE = new HotSearchHelper();

    private HotSearchHelper() {
    }

    public final void save(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "jsonString");
        try {
            new JSONObject(str2);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            PreferencesUtils.EditorHelper preferencesEditor = instance.getPreferencesEditor();
            preferencesEditor.putString("SEARCH_HOT_" + str, str2).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Result<List<Entity>> getSearchHotEntities(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            DataManager instance = DataManager.getInstance();
            String preferencesString = instance.getPreferencesString("SEARCH_HOT_" + str, null);
            if (preferencesString != null) {
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                return EntityConvertUtils.convertEntityList(instance2.getGson(), preferencesString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
