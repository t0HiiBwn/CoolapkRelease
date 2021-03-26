package com.bytedance.embedapplog;

import java.util.LinkedList;

public class t {
    private static final LinkedList<aq> a = new LinkedList<>();
    private static final LinkedList<aq> b = new LinkedList<>();

    public static void a(aq aqVar) {
        LinkedList<aq> linkedList = a;
        synchronized (linkedList) {
            if (linkedList.size() > 200) {
                bo.b("drop event in cache", null);
                b.add(linkedList.poll());
            }
            linkedList.add(aqVar);
        }
    }

    public static void a() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<aq> linkedList3 = a;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<aq> linkedList4 = b;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            k.a((aq) linkedList.poll());
        }
        while (!linkedList2.isEmpty()) {
            aq aqVar = (aq) linkedList2.poll();
            az azVar = null;
            if (aqVar instanceof az) {
                azVar = (az) aqVar;
            } else if (aqVar instanceof at) {
                at atVar = (at) aqVar;
                azVar = new az("" + atVar.i() + atVar.j(), "16", 1);
            } else if (aqVar instanceof av) {
                azVar = new az(((av) aqVar).j(), "16", 1);
            }
            k.a(azVar);
        }
    }
}
