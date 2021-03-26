package com.amap.api.mapcore2d;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: SyncList */
class bn<T> implements List<T> {
    private LinkedList<T> a = new LinkedList<>();

    bn() {
    }

    public synchronized void a(T t) {
        add(t);
    }

    @Override // java.util.List
    public synchronized void add(int i, T t) {
        this.a.add(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean addAll(Collection<? extends T> collection) {
        return this.a.addAll(collection);
    }

    @Override // java.util.List
    public synchronized boolean addAll(int i, Collection<? extends T> collection) {
        return this.a.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized void clear() {
        this.a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean containsAll(Collection<?> collection) {
        return this.a.containsAll(collection);
    }

    @Override // java.util.List
    public synchronized T get(int i) {
        T t;
        t = null;
        try {
            t = this.a.get(i);
        } catch (Exception e) {
            cm.a(e, "SyncList", "get");
        }
        return t;
    }

    @Override // java.util.List
    public synchronized int indexOf(Object obj) {
        return this.a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public synchronized Iterator<T> iterator() {
        return this.a.listIterator();
    }

    @Override // java.util.List
    public synchronized int lastIndexOf(Object obj) {
        return this.a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public synchronized ListIterator<T> listIterator() {
        return this.a.listIterator();
    }

    @Override // java.util.List
    public synchronized ListIterator<T> listIterator(int i) {
        return this.a.listIterator(i);
    }

    @Override // java.util.List
    public synchronized T remove(int i) {
        return this.a.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean remove(Object obj) {
        return this.a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean removeAll(Collection<?> collection) {
        return this.a.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean retainAll(Collection<?> collection) {
        return this.a.retainAll(collection);
    }

    @Override // java.util.List
    public synchronized T set(int i, T t) {
        return this.a.set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized int size() {
        return this.a.size();
    }

    @Override // java.util.List
    public synchronized List<T> subList(int i, int i2) {
        return this.a.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized Object[] toArray() {
        return this.a.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public synchronized <V> V[] toArray(V[] vArr) {
        return (V[]) this.a.toArray(vArr);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean add(T t) {
        try {
        } catch (Throwable unused) {
            return true;
        }
        return this.a.add(t);
    }
}
