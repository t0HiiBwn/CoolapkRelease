package com.coolapk.market.view.cardlist;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.LogUtils;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainV8ListFragment.kt */
public final class MainListOrderUtils {
    private final String GROUP_TYPE_ARTICLE = "图文";
    private final HashMap<String, List<Feed>> cacheFeedMap = new HashMap<>();
    private final HashMap<String, Integer> groupCountTemp = new HashMap<>();
    private final HashMap<String, Entity> needInsertToFeeds = new HashMap<>();

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.List<com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    private final List<Entity> modifyFeedList(List<Entity> list) {
        boolean z;
        List<Feed> list2;
        List<Entity> list3 = list;
        int i = 0;
        for (Object obj : list3) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Entity entity = (Entity) obj;
            if (entity instanceof Feed) {
                LogUtils.d("类型: " + getGroupType((Feed) entity) + ", " + i, new Object[0]);
            } else {
                LogUtils.d("类型: " + EntityExtendsKt.uniqueType(entity) + ", " + i, new Object[0]);
            }
            i = i2;
        }
        this.groupCountTemp.clear();
        int i3 = 0;
        while (i3 < list.size()) {
            Entity entity2 = (Entity) list.get(i3);
            if (!(entity2 instanceof Feed)) {
                i3++;
            } else {
                Feed feed = (Feed) entity2;
                Integer num = this.groupCountTemp.get(getGroupType(feed));
                if (num == null) {
                    num = 0;
                }
                Intrinsics.checkNotNullExpressionValue(num, "groupCountTemp[feed.groupType] ?: 0");
                int intValue = num.intValue();
                if (intValue >= getGroupTypeAllowMaxCount(getGroupType(feed))) {
                    LogUtils.d("数目超限，移除 " + getGroupType(feed), new Object[0]);
                    AbstractMap abstractMap = this.cacheFeedMap;
                    String groupType = getGroupType(feed);
                    Object obj2 = abstractMap.get(groupType);
                    if (obj2 == null) {
                        obj2 = (List) new ArrayList();
                        abstractMap.put(groupType, obj2);
                    }
                    ((List) obj2).add(entity2);
                    list.remove(i3);
                    i3--;
                } else {
                    this.groupCountTemp.put(getGroupType(feed), Integer.valueOf(intValue + 1));
                }
            }
            i3++;
        }
        Set<String> keySet = this.cacheFeedMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "cacheFeedMap.keys");
        for (T t : keySet) {
            Integer num2 = this.groupCountTemp.get(t);
            if (num2 == null) {
                num2 = 0;
            }
            Intrinsics.checkNotNullExpressionValue(num2, "groupCountTemp[it] ?: 0");
            int intValue2 = num2.intValue();
            Intrinsics.checkNotNullExpressionValue(t, "it");
            if (intValue2 < getGroupTypeAllowMaxCount(t) && (list2 = this.cacheFeedMap.get(t)) != null) {
                Intrinsics.checkNotNullExpressionValue(list2, "cacheFeedMap[it] ?: return@forEach");
                if (!list2.isEmpty()) {
                    LogUtils.d("数量缺失，补充 " + ((String) t), new Object[0]);
                    list.add(1, list2.get(0));
                    list2.remove(0);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : list3) {
            Entity entity3 = (Entity) obj3;
            if ((entity3 instanceof Feed) && Intrinsics.areEqual(getGroupType((Feed) entity3), this.GROUP_TYPE_ARTICLE)) {
                arrayList.add(obj3);
            }
        }
        List<Feed> mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.filterIsInstance(arrayList, Feed.class));
        if (!(mutableList.size() == list.size())) {
            z = false;
            for (Feed feed2 : mutableList) {
                int indexOf = list.indexOf(feed2);
                Entity entity4 = (Entity) CollectionsKt.getOrNull(list, indexOf - 1);
                if (!(entity4 instanceof Feed) || !Intrinsics.areEqual(getGroupType((Feed) entity4), this.GROUP_TYPE_ARTICLE)) {
                    Entity entity5 = (Entity) CollectionsKt.getOrNull(list, indexOf + 1);
                    if (entity5 instanceof Feed) {
                        if (!Intrinsics.areEqual(getGroupType((Feed) entity5), this.GROUP_TYPE_ARTICLE)) {
                        }
                    }
                }
                z = true;
            }
        } else {
            z = false;
        }
        if (z) {
            LogUtils.d("图文重新排序", new Object[0]);
            Entity entity6 = (Entity) CollectionsKt.first((List<? extends Object>) list);
            boolean z2 = (entity6 instanceof Feed) && Intrinsics.areEqual(getGroupType((Feed) entity6), this.GROUP_TYPE_ARTICLE);
            CollectionsKt.removeAll((List) list, (Function1) new MainListOrderUtils$modifyFeedList$5(this));
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!(!mutableList.isEmpty())) {
                    if (z2) {
                        list.add(i4, CollectionsKt.first((List<? extends Object>) mutableList));
                    } else {
                        list.add(i4 + 1, CollectionsKt.first((List<? extends Object>) mutableList));
                    }
                    mutableList.remove(0);
                }
            }
            List list4 = mutableList;
            if (!list4.isEmpty()) {
                HashMap<String, List<Feed>> hashMap = this.cacheFeedMap;
                String str = this.GROUP_TYPE_ARTICLE;
                ArrayList arrayList2 = hashMap.get(str);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(str, arrayList2);
                }
                arrayList2.addAll(list4);
            }
        }
        return list;
    }

    private final int getGroupTypeAllowMaxCount(String str) {
        if (Intrinsics.areEqual(str, "动态")) {
            return Integer.MAX_VALUE;
        }
        return Intrinsics.areEqual(str, this.GROUP_TYPE_ARTICLE) ? 3 : 1;
    }

    public final String getGroupType(Feed feed) {
        if (Intrinsics.areEqual(feed.getExtraType(), "apk")) {
            return "动态推应用";
        }
        String feedTypeName = feed.getFeedTypeName();
        return feedTypeName != null ? feedTypeName : "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        int i;
        if (list == 0) {
            return null;
        }
        if (!z) {
            return list;
        }
        Iterator it2 = list.iterator();
        int i2 = 0;
        while (true) {
            i = -1;
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (((Entity) it2.next()) instanceof Feed) {
                break;
            } else {
                i2++;
            }
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (((Entity) listIterator.previous()) instanceof Feed) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                break;
            }
        }
        if (i2 < 0 || i2 == i) {
            return list;
        }
        boolean z2 = true;
        int i3 = i + 1;
        List subList = list.subList(i2, i3);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list.subList(0, i2)) {
            if (EntityExtendsKt.getIntExtraData((Entity) obj, "isad", 0) == 1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list.subList(i3, list.size())) {
            if (EntityExtendsKt.getIntExtraData((Entity) obj2, "isad", 0) == 1) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = arrayList2;
        arrayList4.addAll(arrayList5);
        ArrayList arrayList6 = arrayList3;
        arrayList4.addAll(arrayList6);
        ArrayList<Entity> arrayList7 = arrayList4;
        for (Entity entity : arrayList7) {
            this.needInsertToFeeds.put(EntityExtendsKt.entityUniqueId(entity), entity);
        }
        arrayList4.clear();
        Collection<Entity> values = this.needInsertToFeeds.values();
        Intrinsics.checkNotNullExpressionValue(values, "needInsertToFeeds.values");
        arrayList4.addAll(values);
        ArrayList arrayList8 = new ArrayList();
        List list2 = subList;
        arrayList8.addAll(modifyFeedList(CollectionsKt.toMutableList((Collection) list2)));
        int size = (arrayList8.size() / 3) - 1;
        int i4 = 0;
        while (i4 < size) {
            if (arrayList4.isEmpty() ^ z2) {
                Entity entity2 = (Entity) CollectionsKt.first((List<? extends Object>) arrayList4);
                LogUtils.d("重新插入其他 Card " + entity2.getTitle() + ", " + entity2, new Object[0]);
                arrayList8.add(((i4 + 1) * 3) + i4, entity2);
                arrayList4.remove(0);
            }
            i4++;
            z2 = true;
        }
        this.needInsertToFeeds.clear();
        for (Entity entity3 : arrayList7) {
            this.needInsertToFeeds.put(EntityExtendsKt.entityUniqueId(entity3), entity3);
        }
        List<Entity> mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.removeAll(arrayList5);
        mutableList.removeAll(arrayList6);
        mutableList.removeAll(list2);
        mutableList.addAll(i2 - arrayList2.size(), arrayList8);
        return mutableList;
    }
}
