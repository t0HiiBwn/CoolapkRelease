package com.coolapk.market.view.block;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.center.CenterUserMenuPresenter;
import com.github.salomonbrys.kotson.BuilderKt;
import com.github.salomonbrys.kotson.ElementKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u0017J\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 0\u001fJ\b\u0010!\u001a\u00020\u0017H\u0002J \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 0\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/block/BlockContentManager;", "", "()V", "KEY", "", "<set-?>", "", "lastModifyBlockItemTimeMill", "getLastModifyBlockItemTimeMill", "()J", "loadedBlockItems", "", "Lcom/coolapk/market/view/block/BlockItem;", "getBlockItems", "", "type", "getBlockMaxCount", "", "getBlockNums", "isBlockNodeAlreadyActive", "", "item", "onLoginEvent", "", "session", "Lcom/coolapk/market/local/LoginSession;", "parseLoadedJsonString", "jsonObject", "Lcom/google/gson/JsonObject;", "reloadBlockData", "reloadBlockDataObservable", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "updateLastModifyBlockItemsTimeMill", "updateSpamConfig", "items", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlockContentManager.kt */
public final class BlockContentManager {
    public static final BlockContentManager INSTANCE;
    private static final String KEY = "spam_word_config";
    private static long lastModifyBlockItemTimeMill;
    private static final List<BlockItem> loadedBlockItems = new ArrayList();

    static {
        BlockContentManager blockContentManager = new BlockContentManager();
        INSTANCE = blockContentManager;
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, blockContentManager);
    }

    private BlockContentManager() {
    }

    public final long getLastModifyBlockItemTimeMill() {
        return lastModifyBlockItemTimeMill;
    }

    @Subscribe
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        if (loginSession.isLogin()) {
            reloadBlockData();
            return;
        }
        loadedBlockItems.clear();
        updateLastModifyBlockItemsTimeMill();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b6, code lost:
        if ((r3.length() > 0) != false) goto L_0x02b8;
     */
    public final Observable<Result<String>> updateSpamConfig(List<BlockItem> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(list, "items");
        List<BlockItem> list2 = list;
        ArrayList arrayList = new ArrayList();
        for (T t : list2) {
            if (Intrinsics.areEqual(t.getType(), "node")) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (T t2 : list2) {
            if (Intrinsics.areEqual(t2.getType(), "word")) {
                arrayList3.add(t2);
            }
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList();
        for (T t3 : list2) {
            if (Intrinsics.areEqual(t3.getType(), "user")) {
                arrayList5.add(t3);
            }
        }
        ArrayList arrayList6 = arrayList5;
        ArrayList arrayList7 = arrayList2;
        ArrayList arrayList8 = new ArrayList();
        for (Object obj : arrayList7) {
            if (((BlockItem) obj).getActive()) {
                arrayList8.add(obj);
            }
        }
        ArrayList<BlockItem> arrayList9 = arrayList8;
        ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
        for (BlockItem blockItem : arrayList9) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("tid", blockItem.getTid());
            jsonObject.addProperty("name", blockItem.getName());
            Unit unit = Unit.INSTANCE;
            arrayList10.add(jsonObject);
        }
        JsonArray jsonArray = BuilderKt.toJsonArray(arrayList10);
        ArrayList arrayList11 = new ArrayList();
        Iterator it2 = arrayList7.iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (true ^ ((BlockItem) next).getActive()) {
                arrayList11.add(next);
            }
        }
        ArrayList<BlockItem> arrayList12 = arrayList11;
        ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList12, 10));
        for (BlockItem blockItem2 : arrayList12) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("tid", blockItem2.getTid());
            jsonObject2.addProperty("name", blockItem2.getName());
            Unit unit2 = Unit.INSTANCE;
            arrayList13.add(jsonObject2);
        }
        JsonArray jsonArray2 = BuilderKt.toJsonArray(arrayList13);
        ArrayList arrayList14 = arrayList4;
        ArrayList arrayList15 = new ArrayList();
        for (Object obj2 : arrayList14) {
            if (((BlockItem) obj2).getActive()) {
                arrayList15.add(obj2);
            }
        }
        ArrayList arrayList16 = arrayList15;
        ArrayList arrayList17 = new ArrayList();
        for (Object obj3 : arrayList14) {
            if (!((BlockItem) obj3).getActive()) {
                arrayList17.add(obj3);
            }
        }
        ArrayList arrayList18 = arrayList17;
        ArrayList arrayList19 = arrayList6;
        ArrayList arrayList20 = new ArrayList();
        for (Object obj4 : arrayList19) {
            if (((BlockItem) obj4).getActive()) {
                arrayList20.add(obj4);
            }
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList20, ",", null, null, 0, null, BlockContentManager$updateSpamConfig$userAddData$2.INSTANCE, 30, null);
        ArrayList arrayList21 = new ArrayList();
        for (Object obj5 : arrayList19) {
            if (!((BlockItem) obj5).getActive()) {
                arrayList21.add(obj5);
            }
        }
        String joinToString$default2 = CollectionsKt.joinToString$default(arrayList21, ",", null, null, 0, null, BlockContentManager$updateSpamConfig$userCancelData$2.INSTANCE, 30, null);
        JsonObject jsonObject3 = new JsonObject();
        if (jsonArray.size() > 0 || jsonArray2.size() > 0) {
            JsonObject jsonObject4 = new JsonObject();
            if (jsonArray.size() > 0) {
                jsonObject4.add("add", jsonArray);
            }
            if (jsonArray2.size() > 0) {
                jsonObject4.add("cancel", jsonArray2);
            }
            Unit unit3 = Unit.INSTANCE;
            jsonObject3.add("node", jsonObject4);
        }
        if (arrayList16.size() == 1 || arrayList18.size() == 1) {
            JsonObject jsonObject5 = new JsonObject();
            if (arrayList16.size() == 1) {
                jsonObject5.addProperty("add", ((BlockItem) CollectionsKt.first((List<? extends Object>) arrayList16)).getName());
            }
            if (arrayList18.size() == 1) {
                jsonObject5.addProperty("cancel", ((BlockItem) CollectionsKt.first((List<? extends Object>) arrayList18)).getName());
            }
            Unit unit4 = Unit.INSTANCE;
            jsonObject3.add("word", jsonObject5);
        }
        String str = joinToString$default;
        if (!(str.length() > 0)) {
        }
        JsonObject jsonObject6 = new JsonObject();
        if (str.length() > 0) {
            jsonObject6.addProperty("add", joinToString$default);
        }
        if (joinToString$default2.length() <= 0) {
            z = false;
        }
        if (z) {
            jsonObject6.addProperty("cancel", joinToString$default2);
        }
        Unit unit5 = Unit.INSTANCE;
        jsonObject3.add("user", jsonObject6);
        Unit unit6 = Unit.INSTANCE;
        Observable<Result<String>> doOnNext = DataManager.getInstance().updateTitleConfig(KEY, jsonObject3.toString()).doOnNext(new BlockContentManager$updateSpamConfig$1(list));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "DataManager.getInstance(…      }\n                }");
        return doOnNext;
    }

    public final boolean isBlockNodeAlreadyActive(BlockItem blockItem) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(blockItem, "item");
        Iterator<T> it2 = loadedBlockItems.iterator();
        while (true) {
            t = null;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            T t2 = next;
            if ((Intrinsics.areEqual(t2.getTid(), blockItem.getTid()) || (Intrinsics.areEqual(blockItem.getTid(), "0") && StringsKt.startsWith$default(t2.getTid(), "300", false, 2, (Object) null))) && Intrinsics.areEqual(t2.getName(), blockItem.getName()) && Intrinsics.areEqual(t2.getType(), blockItem.getType())) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        if (t != null) {
            return true;
        }
        return false;
    }

    public final Observable<Result<String>> reloadBlockDataObservable() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        Observable<R> map = instance.getUserSpamWordList().map(BlockContentManager$reloadBlockDataObservable$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…      }\n                }");
        return map;
    }

    public final void reloadBlockData() {
        reloadBlockDataObservable().compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new EmptySubscriber());
    }

    /* access modifiers changed from: private */
    public final void parseLoadedJsonString(JsonObject jsonObject) {
        JsonElement jsonElement;
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        JsonObject asJsonObject2;
        JsonElement jsonElement3;
        JsonObject asJsonObject3;
        JsonObject asJsonObject4;
        JsonElement jsonElement4;
        if (jsonObject.has("data")) {
            JsonElement jsonElement5 = jsonObject.get("data");
            Intrinsics.checkNotNullExpressionValue(jsonElement5, "jsonObject.get(\"data\")");
            if (jsonElement5.isJsonObject()) {
                JsonElement jsonElement6 = jsonObject.get("data");
                JsonElement parseString = JsonParser.parseString((jsonElement6 == null || (asJsonObject4 = jsonElement6.getAsJsonObject()) == null || (jsonElement4 = asJsonObject4.get(KEY)) == null) ? null : jsonElement4.getAsString());
                loadedBlockItems.clear();
                if (!(parseString == null || (jsonElement3 = ElementKt.get(parseString, "node")) == null || (asJsonObject3 = jsonElement3.getAsJsonObject()) == null)) {
                    ElementKt.forEach(asJsonObject3, BlockContentManager$parseLoadedJsonString$1.INSTANCE);
                }
                if (!(parseString == null || (jsonElement2 = ElementKt.get(parseString, "custom")) == null || (asJsonObject2 = jsonElement2.getAsJsonObject()) == null)) {
                    ElementKt.forEach(asJsonObject2, BlockContentManager$parseLoadedJsonString$2.INSTANCE);
                }
                if (!(parseString == null || (jsonElement = ElementKt.get(parseString, "user")) == null || (asJsonObject = jsonElement.getAsJsonObject()) == null)) {
                    ElementKt.forEach(asJsonObject, BlockContentManager$parseLoadedJsonString$3.INSTANCE);
                }
                updateLastModifyBlockItemsTimeMill();
            }
        }
    }

    public final List<BlockItem> getBlockItems(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        ArrayList arrayList = new ArrayList();
        for (T t : loadedBlockItems) {
            if (Intrinsics.areEqual(t.getType(), str)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public final int getBlockMaxCount() {
        UserProfile userProfile = CenterUserMenuPresenter.Companion.getInstance().getUserProfile();
        Integer valueOf = userProfile != null ? Integer.valueOf(userProfile.getLevel()) : null;
        if (valueOf == null || valueOf.intValue() < 0) {
            return 0;
        }
        return Math.min(30, valueOf.intValue() * 3);
    }

    public final int getBlockNums() {
        return loadedBlockItems.size();
    }

    /* access modifiers changed from: private */
    public final void updateLastModifyBlockItemsTimeMill() {
        lastModifyBlockItemTimeMill = System.currentTimeMillis();
    }
}
