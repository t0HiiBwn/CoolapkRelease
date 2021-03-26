package com.coolapk.market;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.EntityConvertUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\b\u0010\f\u001a\u00020\u0004H\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\b\u0010\u000e\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/AppSettingCompat;", "", "()V", "digitConfigCard", "Lcom/coolapk/market/model/EntityCard;", "discoveryConfigCard", "getDigitConfigCard", "getDigitSelectedHomeTab", "", "getDigitalConfigPages", "", "Lcom/coolapk/market/model/ConfigPage;", "getDiscoveryConfigCard", "getDiscoveryConfigPages", "getDiscoverySelectedHomeTab", "setNewDigitConfigCard", "", "entityCard", "setNewDiscoveryConfigCard", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppSettingCompat.kt */
public final class AppSettingCompat {
    public static final AppSettingCompat INSTANCE = new AppSettingCompat();
    private static EntityCard digitConfigCard;
    private static EntityCard discoveryConfigCard;

    private AppSettingCompat() {
    }

    public final void setNewDigitConfigCard(EntityCard entityCard) {
        Intrinsics.checkNotNullParameter(entityCard, "entityCard");
        digitConfigCard = entityCard;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        String json = instance.getGson().toJson(entityCard);
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        instance2.getPreferencesEditor().putString("DIGIT_CONFIG_CARD_JSON", json).apply();
        EventBus.getDefault().post(new DigitConfigPageEvent());
    }

    private final EntityCard getDigitConfigCard() {
        JsonObject jsonObject;
        EntityCard entityCard = digitConfigCard;
        if (entityCard != null) {
            return entityCard;
        }
        try {
            JsonElement parse = new JsonParser().parse(DataManager.getInstance().getPreferencesString("DIGIT_CONFIG_CARD_JSON", "{\"entityTemplate\":\"configCard\",\"entityId\":\"14468\",\"entityFixed\":0,\"extraData\":\"{\\\"selectedHomeTab\\\":\\\"V8_CHANNEL_SJB\\\"}\",\"title\":\"APP配置/数码\",\"url\":\"#PageManageModel::getPageRows?pageType\\u003d10\\u0026t\\u003d1\\u0026title\\u003dAPP配置/数码\",\"entities\":[{\"entityType\":\"page\",\"entityId\":\"790\",\"title\":\"数码\",\"url\":\"/page?url\\u003dV10_DIGITAL_HOME\",\"description\":\"\",\"logo\":\"\",\"id\":\"790\",\"extraData\":\"\",\"dateline\":1575366658,\"lastupdate\":1576476480,\"page_name\":\"V10_DIGITAL_HOME\",\"page_visibility\":1,\"order\":0,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"17\",\"title\":\"手机\",\"url\":\"/page?url\\u003dV8_CHANNEL_SJB\",\"description\":\"\",\"logo\":\"\",\"id\":\"17\",\"extraData\":\"\",\"dateline\":1512460415,\"lastupdate\":1576476567,\"page_name\":\"V8_CHANNEL_SJB\",\"page_visibility\":1,\"order\":10,\"page_fixed\":0,\"entities\":[]}],\"entityTypeName\":\"APP配置/数码\",\"lastupdate\":1576476027,\"entityType\":\"card\",\"pic\":\"\"}"));
            Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(it)");
            jsonObject = parse.getAsJsonObject();
        } catch (Exception unused) {
            JsonElement parse2 = new JsonParser().parse("{\"entityTemplate\":\"configCard\",\"entityId\":\"14468\",\"entityFixed\":0,\"extraData\":\"{\\\"selectedHomeTab\\\":\\\"V8_CHANNEL_SJB\\\"}\",\"title\":\"APP配置/数码\",\"url\":\"#PageManageModel::getPageRows?pageType\\u003d10\\u0026t\\u003d1\\u0026title\\u003dAPP配置/数码\",\"entities\":[{\"entityType\":\"page\",\"entityId\":\"790\",\"title\":\"数码\",\"url\":\"/page?url\\u003dV10_DIGITAL_HOME\",\"description\":\"\",\"logo\":\"\",\"id\":\"790\",\"extraData\":\"\",\"dateline\":1575366658,\"lastupdate\":1576476480,\"page_name\":\"V10_DIGITAL_HOME\",\"page_visibility\":1,\"order\":0,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"17\",\"title\":\"手机\",\"url\":\"/page?url\\u003dV8_CHANNEL_SJB\",\"description\":\"\",\"logo\":\"\",\"id\":\"17\",\"extraData\":\"\",\"dateline\":1512460415,\"lastupdate\":1576476567,\"page_name\":\"V8_CHANNEL_SJB\",\"page_visibility\":1,\"order\":10,\"page_fixed\":0,\"entities\":[]}],\"entityTypeName\":\"APP配置/数码\",\"lastupdate\":1576476027,\"entityType\":\"card\",\"pic\":\"\"}");
            Intrinsics.checkNotNullExpressionValue(parse2, "JsonParser().parse(MainI…r.DIGIT_CONFIG_CARD_JSON)");
            jsonObject = parse2.getAsJsonObject();
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        Entity handleType = EntityConvertUtils.handleType(instance.getGson(), jsonObject, "card");
        Objects.requireNonNull(handleType, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        EntityCard entityCard2 = (EntityCard) handleType;
        digitConfigCard = entityCard2;
        return entityCard2;
    }

    public final List<ConfigPage> getDigitalConfigPages() {
        List filterIsInstance;
        List<Entity> entities = getDigitConfigCard().getEntities();
        if (entities == null || (filterIsInstance = CollectionsKt.filterIsInstance(entities, ConfigPage.class)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : filterIsInstance) {
            if (((ConfigPage) obj).isVisibility()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final String getDigitSelectedHomeTab() {
        JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(getDigitConfigCard());
        if (jsonExtraData != null) {
            return jsonExtraData.optString("selectedHomeTab");
        }
        return null;
    }

    public final void setNewDiscoveryConfigCard(EntityCard entityCard) {
        Intrinsics.checkNotNullParameter(entityCard, "entityCard");
        discoveryConfigCard = entityCard;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        String json = instance.getGson().toJson(entityCard);
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        instance2.getPreferencesEditor().putString("DISCOVERY_CONFIG_CARD_JSON", json).apply();
        EventBus.getDefault().post(new DiscoveryConfigPageEvent());
    }

    private final EntityCard getDiscoveryConfigCard() {
        JsonObject jsonObject;
        EntityCard entityCard = discoveryConfigCard;
        if (entityCard != null) {
            return entityCard;
        }
        try {
            JsonElement parse = new JsonParser().parse(DataManager.getInstance().getPreferencesString("DISCOVERY_CONFIG_CARD_JSON", "{\"entityTemplate\":\"configCard\",\"entityId\":\"20131\",\"entityFixed\":0,\"extraData\":\"{\\\"selectedHomeTab\\\":\\\"V11_FIND_GOOD_GOODS_HOME\\\"}\",\"title\":\"发现TAB配置\",\"url\":\"#PageManageModel::getPageRows?pageType\\u003d13\\u0026t\\u003d1\\u0026title\\u003d发现TAB配置\",\"entities\":[{\"entityType\":\"page\",\"entityId\":\"1175\",\"title\":\"酷图\",\"url\":\"/page?url\\u003dV11_FIND_COOLPIC\",\"description\":\"\",\"logo\":\"\",\"id\":\"1175\",\"extraData\":\"\",\"dateline\":1603784764,\"lastupdate\":1603784787,\"page_name\":\"V11_FIND_COOLPIC\",\"page_visibility\":1,\"order\":1,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1174\",\"title\":\"好物\",\"url\":\"/page?url\\u003dV11_FIND_GOOD_GOODS_HOME\",\"description\":\"\",\"logo\":\"\",\"id\":\"1174\",\"extraData\":\"\",\"dateline\":1603781719,\"lastupdate\":1603855291,\"page_name\":\"V11_FIND_GOOD_GOODS_HOME\",\"page_visibility\":1,\"order\":2,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1178\",\"title\":\"二手\",\"url\":\"/page?url\\u003dV11_DISCOVERY_SECOND_HAND\",\"description\":\"\",\"logo\":\"\",\"id\":\"1178\",\"extraData\":\"\",\"dateline\":1603853941,\"lastupdate\":1603856229,\"page_name\":\"V11_DISCOVERY_SECOND_HAND\",\"page_visibility\":1,\"order\":3,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1170\",\"title\":\"酷品\",\"url\":\"/page?url\\u003dV11_FIND_GOODS\",\"description\":\"\",\"logo\":\"http://image.coolapk.com/image/2019/0326/14/1553580047_072-0-o_1d6s9cea2d4b6gq1u0v1ssc1jf4i-uid-611629@96x96.png\",\"id\":\"1170\",\"extraData\":\"\",\"dateline\":1603780598,\"lastupdate\":1603784779,\"page_name\":\"V11_FIND_GOODS\",\"page_visibility\":1,\"order\":4,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1176\",\"title\":\"看看号\",\"url\":\"/page?url\\u003dV11_FIND_DYH\",\"description\":\"\",\"logo\":\"\",\"id\":\"1176\",\"extraData\":\"\",\"dateline\":1603784838,\"lastupdate\":1603784838,\"page_name\":\"V11_FIND_DYH\",\"page_visibility\":1,\"order\":5,\"page_fixed\":0,\"entities\":[]}],\"entityTypeName\":\"发现TAB配置\",\"lastupdate\":1603856451,\"entityType\":\"card\",\"pic\":\"\"}"));
            Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(it)");
            jsonObject = parse.getAsJsonObject();
        } catch (Exception unused) {
            JsonElement parse2 = new JsonParser().parse("{\"entityTemplate\":\"configCard\",\"entityId\":\"20131\",\"entityFixed\":0,\"extraData\":\"{\\\"selectedHomeTab\\\":\\\"V11_FIND_GOOD_GOODS_HOME\\\"}\",\"title\":\"发现TAB配置\",\"url\":\"#PageManageModel::getPageRows?pageType\\u003d13\\u0026t\\u003d1\\u0026title\\u003d发现TAB配置\",\"entities\":[{\"entityType\":\"page\",\"entityId\":\"1175\",\"title\":\"酷图\",\"url\":\"/page?url\\u003dV11_FIND_COOLPIC\",\"description\":\"\",\"logo\":\"\",\"id\":\"1175\",\"extraData\":\"\",\"dateline\":1603784764,\"lastupdate\":1603784787,\"page_name\":\"V11_FIND_COOLPIC\",\"page_visibility\":1,\"order\":1,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1174\",\"title\":\"好物\",\"url\":\"/page?url\\u003dV11_FIND_GOOD_GOODS_HOME\",\"description\":\"\",\"logo\":\"\",\"id\":\"1174\",\"extraData\":\"\",\"dateline\":1603781719,\"lastupdate\":1603855291,\"page_name\":\"V11_FIND_GOOD_GOODS_HOME\",\"page_visibility\":1,\"order\":2,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1178\",\"title\":\"二手\",\"url\":\"/page?url\\u003dV11_DISCOVERY_SECOND_HAND\",\"description\":\"\",\"logo\":\"\",\"id\":\"1178\",\"extraData\":\"\",\"dateline\":1603853941,\"lastupdate\":1603856229,\"page_name\":\"V11_DISCOVERY_SECOND_HAND\",\"page_visibility\":1,\"order\":3,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1170\",\"title\":\"酷品\",\"url\":\"/page?url\\u003dV11_FIND_GOODS\",\"description\":\"\",\"logo\":\"http://image.coolapk.com/image/2019/0326/14/1553580047_072-0-o_1d6s9cea2d4b6gq1u0v1ssc1jf4i-uid-611629@96x96.png\",\"id\":\"1170\",\"extraData\":\"\",\"dateline\":1603780598,\"lastupdate\":1603784779,\"page_name\":\"V11_FIND_GOODS\",\"page_visibility\":1,\"order\":4,\"page_fixed\":0,\"entities\":[]},{\"entityType\":\"page\",\"entityId\":\"1176\",\"title\":\"看看号\",\"url\":\"/page?url\\u003dV11_FIND_DYH\",\"description\":\"\",\"logo\":\"\",\"id\":\"1176\",\"extraData\":\"\",\"dateline\":1603784838,\"lastupdate\":1603784838,\"page_name\":\"V11_FIND_DYH\",\"page_visibility\":1,\"order\":5,\"page_fixed\":0,\"entities\":[]}],\"entityTypeName\":\"发现TAB配置\",\"lastupdate\":1603856451,\"entityType\":\"card\",\"pic\":\"\"}");
            Intrinsics.checkNotNullExpressionValue(parse2, "JsonParser().parse(MainI…SCOVERY_CONFIG_CARD_JSON)");
            jsonObject = parse2.getAsJsonObject();
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        Entity handleType = EntityConvertUtils.handleType(instance.getGson(), jsonObject, "card");
        Objects.requireNonNull(handleType, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        EntityCard entityCard2 = (EntityCard) handleType;
        discoveryConfigCard = entityCard2;
        return entityCard2;
    }

    public final List<ConfigPage> getDiscoveryConfigPages() {
        List filterIsInstance;
        List<Entity> entities = getDiscoveryConfigCard().getEntities();
        if (entities == null || (filterIsInstance = CollectionsKt.filterIsInstance(entities, ConfigPage.class)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : filterIsInstance) {
            if (((ConfigPage) obj).isVisibility()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final String getDiscoverySelectedHomeTab() {
        JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(getDiscoveryConfigCard());
        if (jsonExtraData != null) {
            return jsonExtraData.optString("selectedHomeTab");
        }
        return null;
    }
}
