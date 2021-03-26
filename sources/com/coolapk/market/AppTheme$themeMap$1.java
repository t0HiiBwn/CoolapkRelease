package com.coolapk.market;

import com.coolapk.market.AppTheme;
import com.coolapk.market.util.ResourceUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J8\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"com/coolapk/market/AppTheme$themeMap$1", "Ljava/util/HashMap;", "", "Lcom/coolapk/market/AppTheme$ThemeItem;", "put", "", "themeName", "mainStylesRes", "", "colorRes", "label", "isTimeLimit", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppTheme.kt */
public final class AppTheme$themeMap$1 extends HashMap<String, AppTheme.ThemeItem> {
    AppTheme$themeMap$1() {
        put$default(this, "black", 2131951630, 2131099753, "黑色", false, 16, null);
        put$default(this, "blue", 2131951631, 2131099755, "蓝色", false, 16, null);
        put$default(this, "blue_grey", 2131951632, 2131099756, "灰色", false, 16, null);
        put$default(this, "brown", 2131951633, 2131099763, "棕色", false, 16, null);
        put$default(this, "night", 2131951643, 2131099808, "黑色", false, 16, null);
        put$default(this, "deep_purple", 2131951636, 2131099826, "紫色", false, 16, null);
        put$default(this, "green", 2131951638, 2131099894, "绿色", false, 16, null);
        put$default(this, "grey", 2131951639, 2131099895, "灰色", false, 16, null);
        put$default(this, "indigo", 2131951640, 2131099903, "蓝色", false, 16, null);
        put$default(this, "orange", 2131951645, 2131100020, "橙色", false, 16, null);
        put$default(this, "pink", 2131951646, 2131100021, "粉色", false, 16, null);
        put$default(this, "red", 2131951648, 2131100040, "红色", false, 16, null);
        put$default(this, "teal", 2131951650, 2131100064, "青色", false, 16, null);
        put$default(this, "custom_dark", 2131951635, 2131099808, "自定义", false, 16, null);
        put$default(this, "custom", 2131951634, 2131099808, "自定义", false, 16, null);
        put("amoled", new AppTheme.ThemeItem("amoled", 2131951628, -16777216, "纯黑"));
        put$default(this, "white", 2131951652, 2131100159, "白色", false, 16, null);
        put("TIME_LIMIT_THEME", 2131951651, 2131100067, "蓝调", true);
        put$default(this, "SMARTISAN_PRO", 2131951649, 2131100055, "深红", false, 16, null);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    public /* bridge */ boolean containsValue(AppTheme.ThemeItem themeItem) {
        return super.containsValue((Object) themeItem);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof AppTheme.ThemeItem) {
            return containsValue((AppTheme.ThemeItem) obj);
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, AppTheme.ThemeItem>> entrySet() {
        return getEntries();
    }

    public /* bridge */ AppTheme.ThemeItem get(String str) {
        return (AppTheme.ThemeItem) super.get((Object) str);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ AppTheme.ThemeItem getOrDefault(String str, AppTheme.ThemeItem themeItem) {
        return (AppTheme.ThemeItem) super.getOrDefault((Object) str, (String) themeItem);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return obj instanceof String ? getOrDefault((String) obj, (AppTheme.ThemeItem) obj2) : obj2;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public /* bridge */ AppTheme.ThemeItem remove(String str) {
        return (AppTheme.ThemeItem) super.remove((Object) str);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (!(obj instanceof String) || !(obj2 instanceof AppTheme.ThemeItem)) {
            return false;
        }
        return remove((String) obj, (AppTheme.ThemeItem) obj2);
    }

    public /* bridge */ boolean remove(String str, AppTheme.ThemeItem themeItem) {
        return super.remove((Object) str, (Object) themeItem);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<AppTheme.ThemeItem> values() {
        return getValues();
    }

    static /* synthetic */ void put$default(AppTheme$themeMap$1 appTheme$themeMap$1, String str, int i, int i2, String str2, boolean z, int i3, Object obj) {
        appTheme$themeMap$1.put(str, i, i2, str2, (i3 & 16) != 0 ? false : z);
    }

    private final void put(@AppTheme.ThemeIds String str, int i, int i2, String str2, boolean z) {
        put(str, new AppTheme.ThemeItem(str, i, ResourceUtils.getColorInt(AppHolder.getApplication(), i2), str2, z));
    }
}
