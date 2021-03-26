package com.alibaba.baichuan.android.trade.miniapp.handler;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.ListIterator;

public class e<T> extends AbstractList {
    private final LinkedList<a<T>> a;
    private final int b;

    public static class a<T> {
        private T a;
        private int b;

        public a(T t, int i) {
            this.a = t;
            this.b = i;
        }
    }

    public e() {
        this(0);
    }

    public e(int i) {
        this.a = new LinkedList<>();
        this.b = i;
    }

    public boolean a(T t, int i) {
        a<T> aVar = new a<>(t, i);
        if (this.a.isEmpty()) {
            this.a.add(aVar);
            return true;
        }
        ListIterator<a<T>> listIterator = this.a.listIterator();
        while (listIterator.hasNext()) {
            if (((a) listIterator.next()).b < i) {
                listIterator.previous();
                listIterator.add(aVar);
                return true;
            }
        }
        this.a.addLast(aVar);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return (T) ((a) this.a.get(i)).a;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.a.size();
    }
}
