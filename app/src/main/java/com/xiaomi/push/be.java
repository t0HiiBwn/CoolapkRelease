package com.xiaomi.push;

import java.util.LinkedList;

public class be {
    private LinkedList<a> a = new LinkedList<>();

    public static class a {
        private static final be a = new be();

        /* renamed from: a  reason: collision with other field name */
        public int f225a;

        /* renamed from: a  reason: collision with other field name */
        public Object f226a;

        /* renamed from: a  reason: collision with other field name */
        public String f227a;

        a(int i, Object obj) {
            this.f225a = i;
            this.f226a = obj;
        }
    }

    public static be a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m134a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m135a() {
        return this.a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m136a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m134a();
    }
}
