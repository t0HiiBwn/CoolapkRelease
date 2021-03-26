package com.alibaba.baichuan.trade.common.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SortUtils {

    public static class SortInfo implements Serializable {
        private static final long serialVersionUID = 3959903664223165585L;
        public String[] after;
        public Boolean afterAll;
        public String[] before;
        public Boolean beforeAll;
        public String name;
    }

    private static void a(String str, String str2, Set<String> set, Map<String, Set<String>> map) {
        Set<String> set2 = map.get(str2);
        if (!(set2 == null || set2.contains(str))) {
            for (String str3 : set2) {
                if (set.add(str3)) {
                    a(str, str3, set, map);
                }
            }
        }
    }

    public static void sorts(SortInfo[] sortInfoArr) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i = 0;
        for (SortInfo sortInfo : sortInfoArr) {
            if (sortInfo.before != null) {
                String[] strArr = sortInfo.before;
                for (String str : strArr) {
                    Set set = (Set) hashMap.get(str);
                    if (set == null) {
                        set = new HashSet();
                        hashMap.put(str, set);
                    }
                    set.add(sortInfo.name);
                }
            }
            Collection collection = (Set) hashMap.get(sortInfo.name);
            if (collection == null) {
                collection = new HashSet();
                hashMap.put(sortInfo.name, collection);
            }
            if (sortInfo.after != null) {
                Collections.addAll(collection, sortInfo.after);
            }
            hashMap2.put(sortInfo.name, sortInfo);
        }
        HashSet hashSet = new HashSet();
        for (SortInfo sortInfo2 : sortInfoArr) {
            a(sortInfo2.name, sortInfo2.name, hashSet, hashMap);
            ((Set) hashMap.get(sortInfo2.name)).addAll(hashSet);
            hashSet.clear();
        }
        HashSet hashSet2 = new HashSet();
        HashSet<String> hashSet3 = new HashSet();
        for (SortInfo sortInfo3 : sortInfoArr) {
            String str2 = sortInfo3.name;
            if (sortInfo3.beforeAll != null && sortInfo3.beforeAll.booleanValue()) {
                hashSet2.add(str2);
                hashSet2.addAll((Set) hashMap.get(str2));
            } else if (sortInfo3.afterAll != null && sortInfo3.afterAll.booleanValue()) {
                hashSet3.add(str2);
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (((Set) entry.getValue()).contains(str2)) {
                        hashSet3.add(entry.getKey());
                    }
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (!hashSet2.contains(entry2.getKey())) {
                ((Set) entry2.getValue()).addAll(hashSet2);
            }
        }
        HashSet hashSet4 = new HashSet(hashMap.keySet());
        hashSet4.removeAll(hashSet3);
        for (String str3 : hashSet3) {
            ((Set) hashMap.get(str3)).addAll(hashSet4);
        }
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        ArrayList<String> arrayList = new ArrayList(sortInfoArr.length);
        while (hashMap.size() > 0) {
            Iterator it2 = hashMap.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry3 = (Map.Entry) it2.next();
                ((Set) entry3.getValue()).removeAll(hashSet6);
                ((Set) entry3.getValue()).retainAll(hashMap.keySet());
                if (((Set) entry3.getValue()).size() == 0) {
                    hashSet5.add(entry3.getKey());
                    arrayList.add(entry3.getKey());
                    it2.remove();
                }
            }
            if (hashSet5.size() != 0) {
                hashSet6.clear();
                hashSet6.addAll(hashSet5);
                hashSet5.clear();
            } else {
                throw new IllegalStateException("Circular found for " + hashMap);
            }
        }
        for (String str4 : arrayList) {
            SortInfo sortInfo4 = (SortInfo) hashMap2.get(str4);
            if (sortInfo4 != null) {
                sortInfoArr[i] = sortInfo4;
                i++;
            }
        }
    }
}
